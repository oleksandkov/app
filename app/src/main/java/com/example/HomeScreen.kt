package com.example

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.local.entity.TaskEntity
import com.example.data.local.entity.NoteEntity
import com.example.data.local.entity.SubTaskEntity
import com.example.ui.theme.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: PlannerViewModel) {
    val coroutineScope = rememberCoroutineScope()
    val selectedDate by viewModel.selectedDate.collectAsStateWithLifecycle()
    val scheduleTasks by viewModel.scheduleTasks.collectAsStateWithLifecycle()
    val allNotes by viewModel.allNotes.collectAsStateWithLifecycle()

    var showAddPlanDialog by remember { mutableStateOf(false) }
    var selectedPlanForEdit by remember { mutableStateOf<TaskEntity?>(null) }
    var showPresetDialog by remember { mutableStateOf(false) }
    var showTrainerDrawer by remember { mutableStateOf(false) }
    var initialHourForNewPlan by remember { mutableStateOf(9) }

    val listState = rememberLazyListState()

    // Notes attached to the selected day
    val dailyNotes = remember(allNotes, selectedDate) {
        allNotes.filter { it.linkedDate != null && isSameDay(it.linkedDate, selectedDate) }
    }

    // Filter upcoming plans (plans today starting after current time)
    val upcomingPlans = remember(scheduleTasks) {
        val now = System.currentTimeMillis()
        scheduleTasks.filter { it.startTime != null && it.startTime > now }.sortedBy { it.startTime }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // 1. Header Navigation & Date Selector
            HomeHeader(selectedDate = selectedDate, onDateSelected = { viewModel.selectDate(it) })

            // 2. Upcoming plans ticker
            if (upcomingPlans.isNotEmpty()) {
                UpcomingPlansTicker(upcomingPlans = upcomingPlans, onPlanClick = { plan ->
                    coroutineScope.launch {
                        val planHour = getHourFromTimestamp(plan.startTime ?: 0)
                        listState.animateScrollToItem(planHour)
                    }
                })
            }

            // 3. Compact Note Shortcuts Integration Block
            if (dailyNotes.isNotEmpty()) {
                DailyNoteShortcuts(notes = dailyNotes)
            }

            // 4. Action Row (Presets, Workout Drawer, Add Plan)
            ActionHeaderRow(
                onPresetsClick = { showPresetDialog = true },
                onTrainerDrawerClick = { showTrainerDrawer = true },
                onAddPlanClick = {
                    initialHourForNewPlan = 9
                    showAddPlanDialog = true
                }
            )

            // 5. Hour-by-hour visual timeline
            HourByHourTimeline(
                listState = listState,
                scheduleTasks = scheduleTasks,
                onPlanDoubleTap = { selectedPlanForEdit = it },
                onEmptySlotClick = { hour ->
                    initialHourForNewPlan = hour
                    showAddPlanDialog = true
                },
                onSwipeLeft = { plan ->
                    // Manual delete from calendar
                    val updated = plan.copy(externalCalendarEventId = null)
                    viewModel.updateTask(updated)
                },
                onSwipeRight = { plan ->
                    // Manual sync to calendar (simulate assigning event ID)
                    val updated = plan.copy(externalCalendarEventId = "google_event_${plan.id}")
                    viewModel.updateTask(updated)
                }
            )
        }

        // Trainer Workout Collapsible Bottom Sheet / Drawer
        if (showTrainerDrawer) {
            ModalBottomSheet(
                onDismissRequest = { showTrainerDrawer = false },
                containerColor = AppBackground
            ) {
                TrainerDrawerContent(onAddWorkout = { workoutName, hour ->
                    viewModel.addTask(
                        title = workoutName,
                        description = "Sync workout from Trainer module",
                        isTimeBoxed = true,
                        hour = hour,
                        minute = 0
                    )
                    showTrainerDrawer = false
                })
            }
        }

        // Add Plan Dialog
        if (showAddPlanDialog) {
            AddPlanDialog(
                initialHour = initialHourForNewPlan,
                onDismiss = { showAddPlanDialog = false },
                onAdd = { title, desc, hour, minute, subtasks ->
                    viewModel.addTask(title, desc, true, hour, minute, subtasks)
                    showAddPlanDialog = false
                }
            )
        }

        // Edit Plan Dialog (safeguard double tap edit)
        selectedPlanForEdit?.let { plan ->
            EditPlanDialog(
                plan = plan,
                viewModel = viewModel,
                onDismiss = { selectedPlanForEdit = null },
                onSave = { updatedPlan ->
                    viewModel.updateTask(updatedPlan)
                    selectedPlanForEdit = null
                },
                onDelete = {
                    viewModel.deleteTask(plan)
                    selectedPlanForEdit = null
                }
            )
        }

        // Presets Creation and Application Dialog
        if (showPresetDialog) {
            PresetManagementDialog(
                onDismiss = { showPresetDialog = false },
                onSavePreset = { presetName ->
                    // In a production app, serialize the list of plans into JSON.
                    // For mockup, we can insert a dummy preset.
                    showPresetDialog = false
                },
                onApplyPreset = {
                    // Populate current schedule with preset templates
                    viewModel.addTask("Morning Exercise", "From Preset", true, 8, 0)
                    viewModel.addTask("Focus Work Session", "From Preset", true, 10, 0)
                    viewModel.addTask("Team Sync Meeting", "From Preset", true, 14, 0)
                    showPresetDialog = false
                }
            )
        }
    }
}

@Composable
fun HomeHeader(selectedDate: Long, onDateSelected: (Long) -> Unit) {
    val sdfDay = SimpleDateFormat("EEEE", Locale.getDefault())
    val sdfDate = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
    val formattedDay = sdfDay.format(Date(selectedDate))
    val formattedDate = sdfDate.format(Date(selectedDate))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .padding(top = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = formattedDay, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Slate900)
                Text(text = formattedDate, fontSize = 14.sp, color = Slate500)
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Brush.linearGradient(listOf(Indigo600, Purple500))),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "JD", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Week Calendar Strip
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = selectedDate
        calendar.set(Calendar.DAY_OF_WEEK, calendar.firstDayOfWeek)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (i in 0..6) {
                val dayTime = calendar.timeInMillis
                val isSelected = isSameDay(dayTime, selectedDate)
                val dayName = SimpleDateFormat("EE", Locale.getDefault()).format(Date(dayTime)).first().toString()
                val dayNumber = SimpleDateFormat("dd", Locale.getDefault()).format(Date(dayTime))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .clickable { onDateSelected(dayTime) }
                        .background(if (isSelected) Indigo600 else Color.Transparent)
                        .padding(vertical = 8.dp, horizontal = 12.dp)
                ) {
                    Text(text = dayName, fontSize = 11.sp, color = if (isSelected) Color.White else Slate400, fontWeight = FontWeight.SemiBold)
                    Text(text = dayNumber, fontSize = 14.sp, color = if (isSelected) Color.White else Slate900, fontWeight = FontWeight.Bold)
                }
                calendar.add(Calendar.DAY_OF_WEEK, 1)
            }
        }
    }
}

@Composable
fun UpcomingPlansTicker(upcomingPlans: List<TaskEntity>, onPlanClick: (TaskEntity) -> Unit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Indigo100),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Info, contentDescription = "Upcoming", tint = Indigo700)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "UPCOMING:",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Indigo700,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(upcomingPlans) { plan ->
                    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                    val timeStr = plan.startTime?.let { timeFormat.format(Date(it)) } ?: ""
                    Box(
                        modifier = Modifier
                            .background(Color.White, RoundedCornerShape(16.dp))
                            .clickable { onPlanClick(plan) }
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "$timeStr ${plan.title}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Slate900
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DailyNoteShortcuts(notes: List<NoteEntity>) {
    Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)) {
        Text("ATTACHED NOTES", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Slate400, letterSpacing = 1.sp)
        Spacer(modifier = Modifier.height(4.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(notes) { note ->
                Box(
                    modifier = Modifier
                        .background(Slate100, RoundedCornerShape(8.dp))
                        .border(1.dp, Slate200, RoundedCornerShape(8.dp))
                        .clickable { /* Route to note details */ }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Create, contentDescription = null, tint = Slate500, modifier = Modifier.size(12.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(text = note.title, fontSize = 11.sp, color = Slate800, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }
    }
}

@Composable
fun ActionHeaderRow(
    onPresetsClick: () -> Unit,
    onTrainerDrawerClick: () -> Unit,
    onAddPlanClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = onPresetsClick,
                colors = ButtonDefaults.buttonColors(containerColor = Slate100, contentColor = Slate900),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.height(36.dp)
            ) {
                Icon(imageVector = Icons.Default.List, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("Presets", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }

            Button(
                onClick = onTrainerDrawerClick,
                colors = ButtonDefaults.buttonColors(containerColor = Slate100, contentColor = Slate900),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.height(36.dp)
            ) {
                Icon(imageVector = Icons.Default.Star, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("Workouts", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }
        }

        Button(
            onClick = onAddPlanClick,
            colors = ButtonDefaults.buttonColors(containerColor = Indigo600),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
            modifier = Modifier.height(36.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("Add Plan", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun HourByHourTimeline(
    listState: androidx.compose.foundation.lazy.LazyListState,
    scheduleTasks: List<TaskEntity>,
    onPlanDoubleTap: (TaskEntity) -> Unit,
    onEmptySlotClick: (Int) -> Unit,
    onSwipeLeft: (TaskEntity) -> Unit,
    onSwipeRight: (TaskEntity) -> Unit
) {
    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(bottom = 80.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        items(24) { hour ->
            val hourTasks = scheduleTasks.filter { plan ->
                plan.startTime?.let { getHourFromTimestamp(it) == hour } ?: false
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.Top
            ) {
                // Time tag
                Text(
                    text = String.format("%02d:00", hour),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate400,
                    modifier = Modifier.width(44.dp),
                    textAlign = TextAlign.End
                )
                Spacer(modifier = Modifier.width(16.dp))

                // Event cards block
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (hourTasks.isEmpty()) {
                        // Empty slot representation
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(44.dp)
                                .border(
                                    BorderStroke(
                                        1.dp,
                                        Brush.sweepGradient(listOf(Slate200, Color.Transparent))
                                    ),
                                    RoundedCornerShape(8.dp)
                                )
                                .clickable { onEmptySlotClick(hour) }
                        )
                    } else {
                        hourTasks.forEach { plan ->
                            SwipeablePlanCard(
                                plan = plan,
                                onDoubleTap = { onPlanDoubleTap(plan) },
                                onSwipeLeft = { onSwipeLeft(plan) },
                                onSwipeRight = { onSwipeRight(plan) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SwipeablePlanCard(
    plan: TaskEntity,
    onDoubleTap: () -> Unit,
    onSwipeLeft: () -> Unit,
    onSwipeRight: () -> Unit
) {
    // Basic color logic based on requirements
    val isMeeting = plan.title.contains("meeting", ignoreCase = true) || plan.title.contains("event", ignoreCase = true)
    val isSynced = plan.externalCalendarEventId != null

    val gradientColors = when {
        isMeeting -> listOf(Color(0xFFFF7043), Color(0xFFFF8A65)) // Sunset Coral
        isSynced -> listOf(Color(0xFFFFB300), Color(0xFFFFC107)) // Synced Gold
        else -> listOf(Color(0xFF5C6BC0), Color(0xFF7986CB)) // Offline Indigo
    }

    var offsetX by remember { mutableStateOf(0f) }
    val animatedOffset by animateFloatAsState(targetValue = offsetX)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .offset(x = animatedOffset.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = { onDoubleTap() }
                )
            }
            .background(Brush.linearGradient(gradientColors), RoundedCornerShape(16.dp))
            .border(1.dp, Color.White.copy(alpha = 0.3f), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isSynced) "SYNCED PLAN" else "OFFLINE PLAN",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White.copy(alpha = 0.8f),
                    letterSpacing = 0.5.sp
                )
                if (isSynced) {
                    Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = plan.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            if (!plan.description.isNullOrBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = plan.description,
                    fontSize = 12.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
            
            // Swipe Controls Indicator for Demo
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(
                    text = "← Swipe Left to Unsync",
                    fontSize = 9.sp,
                    color = Color.White.copy(alpha = 0.7f),
                    modifier = Modifier.clickable { onSwipeLeft() }
                )
                Text(
                    text = "Swipe Right to Sync →",
                    fontSize = 9.sp,
                    color = Color.White.copy(alpha = 0.7f),
                    modifier = Modifier.clickable { onSwipeRight() }
                )
            }
        }
    }
}

@Composable
fun TrainerDrawerContent(onAddWorkout: (String, Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Text("Trainer Sync Schedule", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Slate900)
        Text("Recommended workouts compiled by your trainer today.", fontSize = 12.sp, color = Slate500)
        Spacer(modifier = Modifier.height(16.dp))

        val mockWorkouts = listOf(
            Pair("Cardio & Warmup", 9),
            Pair("Strength Training A", 12),
            Pair("Core Exercises & Stretch", 18)
        )

        mockWorkouts.forEach { workout ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Slate100),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(text = workout.first, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Slate900)
                        Text(text = "Scheduled Hour: ${workout.second}:00", fontSize = 11.sp, color = Slate500)
                    }
                    Button(
                        onClick = { onAddWorkout(workout.first, workout.second) },
                        colors = ButtonDefaults.buttonColors(containerColor = Indigo600)
                    ) {
                        Text("Add", fontSize = 11.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun AddPlanDialog(
    initialHour: Int = 9,
    onDismiss: () -> Unit,
    onAdd: (String, String, Int, Int, List<String>) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var hourStr by remember { mutableStateOf(String.format("%02d", initialHour)) }
    var minuteStr by remember { mutableStateOf("00") }

    val subtasks = remember { mutableStateListOf<String>() }
    var newSubtaskTitle by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Create Daily Plan", fontWeight = FontWeight.Bold) },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Plan Title") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = hourStr,
                        onValueChange = { hourStr = it },
                        label = { Text("Hour (0-23)") },
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = minuteStr,
                        onValueChange = { minuteStr = it },
                        label = { Text("Minute (0-59)") },
                        modifier = Modifier.weight(1f)
                    )
                }

                Divider()

                Text("Subtasks Checklist", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = Slate500)

                subtasks.forEachIndexed { index, subtask ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = Slate400,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = subtask,
                            fontSize = 14.sp,
                            color = Slate800,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(onClick = { subtasks.removeAt(index) }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete Subtask",
                                tint = Color.Red.copy(alpha = 0.7f),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = newSubtaskTitle,
                        onValueChange = { newSubtaskTitle = it },
                        label = { Text("New Subtask") },
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )
                    Button(
                        onClick = {
                            if (newSubtaskTitle.isNotBlank()) {
                                subtasks.add(newSubtaskTitle.trim())
                                newSubtaskTitle = ""
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Indigo600),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Text("Add")
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val hour = hourStr.toIntOrNull() ?: 9
                    val minute = minuteStr.toIntOrNull() ?: 0
                    onAdd(title, description, hour, minute, subtasks.toList())
                },
                colors = ButtonDefaults.buttonColors(containerColor = Indigo600)
            ) {
                Text("Add to Schedule")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Cancel") }
        }
    )
}

@Composable
fun EditPlanDialog(
    plan: TaskEntity,
    viewModel: PlannerViewModel,
    onDismiss: () -> Unit,
    onSave: (TaskEntity) -> Unit,
    onDelete: () -> Unit
) {
    var title by remember { mutableStateOf(plan.title) }
    var description by remember { mutableStateOf(plan.description ?: "") }

    val coroutineScope = rememberCoroutineScope()
    val subtasks = remember { mutableStateListOf<SubTaskEntity>() }
    var newSubtaskTitle by remember { mutableStateOf("") }

    val parentIdStr = "local_${plan.id}"

    LaunchedEffect(plan.id) {
        val dbSubtasks = viewModel.getSubTasksForParent(parentIdStr)
        subtasks.clear()
        subtasks.addAll(dbSubtasks)
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Edit Plan Details", fontWeight = FontWeight.Bold) },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Plan Title") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )

                Divider()

                Text("Subtasks Checklist", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = Slate500)

                subtasks.forEachIndexed { index, subtask ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = subtask.isCompleted,
                            onCheckedChange = { isChecked ->
                                subtasks[index] = subtask.copy(isCompleted = isChecked)
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = subtask.title,
                            fontSize = 14.sp,
                            color = Slate800,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(onClick = { subtasks.removeAt(index) }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete Subtask",
                                tint = Color.Red.copy(alpha = 0.7f),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = newSubtaskTitle,
                        onValueChange = { newSubtaskTitle = it },
                        label = { Text("New Subtask") },
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )
                    Button(
                        onClick = {
                            if (newSubtaskTitle.isNotBlank()) {
                                subtasks.add(
                                    SubTaskEntity(
                                        userId = viewModel.currentUserId,
                                        parentIdStr = parentIdStr,
                                        title = newSubtaskTitle.trim(),
                                        isCompleted = false
                                    )
                                )
                                newSubtaskTitle = ""
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Indigo600),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Text("Add")
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    coroutineScope.launch {
                        val originalSubtasks = viewModel.getSubTasksForParent(parentIdStr)
                        subtasks.forEach { subtask ->
                            if (subtask.isCompleted) {
                                val wasCompleted = originalSubtasks.find { it.title == subtask.title }?.isCompleted == true
                                if (!wasCompleted) {
                                    viewModel.addXp(10)
                                }
                            }
                        }
                        viewModel.saveSubTasksForParentDirectly(parentIdStr, subtasks.toList())
                    }
                    onSave(plan.copy(title = title, description = description))
                },
                colors = ButtonDefaults.buttonColors(containerColor = Indigo600)
            ) {
                Text("Save Changes")
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDelete,
                colors = ButtonDefaults.textButtonColors(contentColor = Color.Red)
            ) {
                Text("Delete Plan")
            }
        }
    )
}

@Composable
fun PresetManagementDialog(
    onDismiss: () -> Unit,
    onSavePreset: (String) -> Unit,
    onApplyPreset: () -> Unit
) {
    var presetName by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Manage Schedule Presets") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Apply saved day template:", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Button(
                    onClick = onApplyPreset,
                    colors = ButtonDefaults.buttonColors(containerColor = Indigo500),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Apply 'Standard Workday' Preset")
                }
                Divider()
                Text("Or save current day snapshot:", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                OutlinedTextField(
                    value = presetName,
                    onValueChange = { presetName = it },
                    label = { Text("Preset Template Name") }
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (presetName.isNotBlank()) {
                        onSavePreset(presetName)
                    }
                }
            ) {
                Text("Save Preset")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Close") }
        }
    )
}

// Helpers
fun isSameDay(timestamp1: Long, timestamp2: Long): Boolean {
    val cal1 = Calendar.getInstance().apply { timeInMillis = timestamp1 }
    val cal2 = Calendar.getInstance().apply { timeInMillis = timestamp2 }
    return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
            cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
}

fun getHourFromTimestamp(timestamp: Long): Int {
    val cal = Calendar.getInstance().apply { timeInMillis = timestamp }
    return cal.get(Calendar.HOUR_OF_DAY)
}


