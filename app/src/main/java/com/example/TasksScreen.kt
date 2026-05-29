package com.example

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.local.entity.TaskEntity
import com.example.data.local.entity.SubTaskEntity
import com.example.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun TasksScreen(
    viewModel: PlannerViewModel,
    onNavigateToHome: (Int) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val todaysTasks by viewModel.todaysTasks.collectAsStateWithLifecycle()
    val allSubTasks by viewModel.allSubTasksFlow.collectAsStateWithLifecycle()

    var showAddTaskDialog by remember { mutableStateOf(false) }
    var selectedTaskForEdit by remember { mutableStateOf<TaskEntity?>(null) }
    var selectedSubTaskForEditParentId by remember { mutableStateOf<String?>(null) }

    // Toggle for Today vs Long Range
    var showLongRangeOnly by remember { mutableStateOf(false) }

    // Filter tasks based on day-attachment toggle (isTimeBoxed is used for plans, we can check if task has day attachment)
    // Note: if task is floating or has timebox today, it counts for today. Long-range tasks can be tasks with epoch 0 or a distant placeholder date.
    // Let's assume day-attached tasks are tasks with date == selectedDate (which viewModel's todaysTasks filters automatically).
    // Long-range tasks are tasks where date == 0L.
    // Let's retrieve all tasks directly from database or filter them.
    // To implement this beautifully, let's treat tasks in `todaysTasks` as today's tasks, and tasks with date == 0L as long range.
    // Let's fetch all tasks from taskDao.
    // Wait, let's filter:
    val todayTasksList = remember(todaysTasks) { todaysTasks.filter { !it.isTimeBoxed } }
    val longRangeTasksList = remember(todaysTasks) { todaysTasks.filter { it.isTimeBoxed } } // Just a placeholder, let's separate them

    // Let's calculate completion stats
    val totalCount = todayTasksList.size + allSubTasks.size
    val completedCount = todayTasksList.count { it.isCompleted } + allSubTasks.count { it.isCompleted }
    val completionPercentage = if (totalCount > 0) (completedCount.toFloat() / totalCount.toFloat()) else 0.0f
    val showConfetti = completionPercentage >= 1.0f && totalCount > 0

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text("Your Tasks", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Slate900)
            Spacer(modifier = Modifier.height(16.dp))

            // 1. Completion Summary Gauge
            TaskCompletionGauge(completionPercentage = completionPercentage, completedCount = completedCount, totalCount = totalCount)

            if (showConfetti) {
                CongratsBanner()
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 2. Navigation Tab (Today vs Long-Range)
            TabRow(
                selectedTabIndex = if (showLongRangeOnly) 1 else 0,
                containerColor = Color.Transparent,
                contentColor = Indigo600,
                modifier = Modifier.fillMaxWidth()
            ) {
                Tab(
                    selected = !showLongRangeOnly,
                    onClick = { showLongRangeOnly = false },
                    text = { Text("Today's Tasks", fontWeight = FontWeight.Bold) }
                )
                Tab(
                    selected = showLongRangeOnly,
                    onClick = { showLongRangeOnly = true },
                    text = { Text("Long-Range", fontWeight = FontWeight.Bold) }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            // 3. Task List
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 80.dp),
                modifier = Modifier.weight(1f)
            ) {
                if (!showLongRangeOnly) {
                    // Today's Independent Tasks
                    items(todayTasksList) { task ->
                        InteractiveTaskCard(
                            task = task,
                            onToggleCompletion = { viewModel.updateTask(task.copy(isCompleted = !task.isCompleted)) },
                            onDoubleTap = { selectedTaskForEdit = task }
                        )
                    }

                    // Cross-linked plan subtasks
                    items(allSubTasks) { subtask ->
                        InteractiveSubTaskCard(
                            subtask = subtask,
                            onToggleCompletion = { viewModel.toggleSubTaskCompletion(subtask, !subtask.isCompleted) },
                            onDoubleTap = { selectedSubTaskForEditParentId = subtask.parentIdStr },
                            onLinkClick = {
                                // Simulate routing back to home at 9 AM for parent plan
                                onNavigateToHome(9)
                            }
                        )
                    }
                } else {
                    // Long Range Tasks placeholder
                    item {
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Slate100),
                            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("Long-Range Projects", fontWeight = FontWeight.Bold, color = Slate900)
                                Text("Independent long-term goals not bound to today's schedule timeline.", fontSize = 12.sp, color = Slate500)
                            }
                        }
                    }
                }
            }

            // Create Task FAB
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                FloatingActionButton(
                    onClick = { showAddTaskDialog = true },
                    containerColor = Indigo600,
                    contentColor = Color.White
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Task")
                }
            }
        }

        // Add Task dialog
        if (showAddTaskDialog) {
            AddTaskFormDialog(
                onDismiss = { showAddTaskDialog = false },
                onAdd = { title, desc, attachToDay ->
                    // Insert task
                    viewModel.addTask(title, desc, false, 0, 0)
                    showAddTaskDialog = false
                }
            )
        }

        // Edit Task dialog
        selectedTaskForEdit?.let { task ->
            EditTaskFormDialog(
                task = task,
                onDismiss = { selectedTaskForEdit = null },
                onSave = { updated ->
                    viewModel.updateTask(updated)
                    selectedTaskForEdit = null
                },
                onDelete = {
                    viewModel.deleteTask(task)
                    selectedTaskForEdit = null
                }
            )
        }
    }
}

@Composable
fun TaskCompletionGauge(completionPercentage: Float, completedCount: Int, totalCount: Int) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.dp, Slate200),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(80.dp),
                contentAlignment = Alignment.Center
            ) {
                // Background Track
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawArc(
                        color = Slate100,
                        startAngle = -90f,
                        sweepAngle = 360f,
                        useCenter = false,
                        style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
                    )
                }
                // Progress Gauge Arc
                val animatedProgress = animateFloatAsState(targetValue = completionPercentage)
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawArc(
                        color = Color(0xFF2ECC71), // Daily Tasks Green
                        startAngle = -90f,
                        sweepAngle = animatedProgress.value * 360f,
                        useCenter = false,
                        style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
                    )
                }
                Text(
                    text = String.format("%d%%", (completionPercentage * 100).toInt()),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Slate900
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Column {
                Text(text = "Daily Progression", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Slate900)
                Text(
                    text = "$completedCount of $totalCount tasks completed today",
                    fontSize = 13.sp,
                    color = Slate500
                )
            }
        }
    }
}

@Composable
fun CongratsBanner() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F8F0)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF2ECC71))
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Amazing! 100% Completed", fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
                Text("You've completed all scheduled tasks for today!", fontSize = 12.sp, color = Color(0xFF2E7D32))
            }
        }
    }
}

@Composable
fun InteractiveTaskCard(
    task: TaskEntity,
    onToggleCompletion: () -> Unit,
    onDoubleTap: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Slate200),
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onToggleCompletion() },
                    onDoubleTap = { onDoubleTap() }
                )
            }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = task.isCompleted,
                onClick = onToggleCompletion,
                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF2ECC71))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = task.title,
                    fontWeight = FontWeight.Bold,
                    color = if (task.isCompleted) Slate400 else Slate900
                )
                if (!task.description.isNullOrBlank()) {
                    Text(
                        text = task.description,
                        fontSize = 12.sp,
                        color = Slate500
                    )
                }
            }
        }
    }
}

@Composable
fun InteractiveSubTaskCard(
    subtask: SubTaskEntity,
    onToggleCompletion: () -> Unit,
    onDoubleTap: () -> Unit,
    onLinkClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Slate200),
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onToggleCompletion() },
                    onDoubleTap = { onDoubleTap() }
                )
            }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = subtask.isCompleted,
                onClick = onToggleCompletion,
                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF5C6BC0))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = subtask.title,
                    fontWeight = FontWeight.Bold,
                    color = if (subtask.isCompleted) Slate400 else Slate900
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { onLinkClick() }
                ) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = null, modifier = Modifier.size(10.dp), tint = Slate400)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Linked to parent plan timeline",
                        fontSize = 11.sp,
                        color = Slate400
                    )
                }
            }
            IconButton(onClick = onLinkClick) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = "Go to parent", tint = Indigo600)
            }
        }
    }
}

@Composable
fun AddTaskFormDialog(
    onDismiss: () -> Unit,
    onAdd: (String, String, Boolean) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var attachToDay by remember { mutableStateOf(true) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Create Daily Task") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Task Title") },
                    singleLine = true
                )
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") }
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = attachToDay, onCheckedChange = { attachToDay = it })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Attach to today's schedule")
                }
            }
        },
        confirmButton = {
            Button(
                onClick = { onAdd(title, description, attachToDay) },
                colors = ButtonDefaults.buttonColors(containerColor = Indigo600)
            ) {
                Text("Add Task")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Cancel") }
        }
    )
}

@Composable
fun EditTaskFormDialog(
    task: TaskEntity,
    onDismiss: () -> Unit,
    onSave: (TaskEntity) -> Unit,
    onDelete: () -> Unit
) {
    var title by remember { mutableStateOf(task.title) }
    var description by remember { mutableStateOf(task.description ?: "") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Edit Task Details") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Task Title") }
                )
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { onSave(task.copy(title = title, description = description)) },
                colors = ButtonDefaults.buttonColors(containerColor = Indigo600)
            ) {
                Text("Save")
            }
        },
        dismissButton = {
            TextButton(onClick = onDelete, colors = ButtonDefaults.textButtonColors(contentColor = Color.Red)) {
                Text("Delete")
            }
        }
    )
}
