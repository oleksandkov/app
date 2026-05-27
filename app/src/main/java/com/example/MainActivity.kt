package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.data.local.entity.TaskEntity
import com.example.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainAppNavigation()
            }
        }
    }
}

@Composable
fun MainAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("main") { 
            MainDashboardScreen(onSignOut = {
                navController.navigate("login") {
                    popUpTo(0) { inclusive = true }
                }
            }) 
        }
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().background(AppBackground).padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = "Logo",
            tint = Indigo600,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Welcome to Planner Pro", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Slate900)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Sign in to sync your Google Calendar and keep your tasks updated across devices.",
            fontSize = 14.sp,
            color = Slate500,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = {
                navController.navigate("main") {
                    popUpTo("login") { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Indigo600),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("Sign in with Google", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun MainDashboardScreen(onSignOut: () -> Unit = {}) {
    val bottomNavController = rememberNavController()
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "home"

    var showAddTaskDialog by remember { mutableStateOf(false) }
    var showAddNoteDialog by remember { mutableStateOf(false) }
    val viewModel: PlannerViewModel = viewModel()
    
    var selectedTask by remember { mutableStateOf<TaskEntity?>(null) }

    Scaffold(
        containerColor = AppBackground,
        bottomBar = {
            BottomNavBar(currentRoute) { route ->
                bottomNavController.navigate(route) {
                    popUpTo(bottomNavController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        },
        floatingActionButton = {
            if (currentRoute == "home") {
                FloatingActionButton(
                    onClick = { showAddTaskDialog = true },
                    containerColor = Indigo600,
                    contentColor = Color.White,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.size(56.dp)
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add", modifier = Modifier.size(32.dp))
                }
            } else if (currentRoute == "notes") {
                FloatingActionButton(
                    onClick = { showAddNoteDialog = true },
                    containerColor = Indigo600,
                    contentColor = Color.White,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.size(56.dp)
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note", modifier = Modifier.size(32.dp))
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            composable("home") { 
                PlannerScreen(
                    viewModel = viewModel,
                    onTaskClick = { task -> selectedTask = task }
                ) 
            }
            composable("notes") { NotesScreen(viewModel = viewModel) }
            composable("sync") { SyncScreen() }
            composable("settings") { SettingsScreen(onSignOut = onSignOut) }
        }
    }

    if (showAddTaskDialog) {
        AddTaskDialog(
            onDismiss = { showAddTaskDialog = false },
            onAdd = { title, desc, isTimeBoxed, hour, minute ->
                viewModel.addTask(title, desc, isTimeBoxed, hour, minute)
                showAddTaskDialog = false
            }
        )
    }

    if (showAddNoteDialog) {
        AddNoteDialog(
            onDismiss = { showAddNoteDialog = false },
            onAdd = { title, content ->
                viewModel.addNote(title, content)
                showAddNoteDialog = false
            }
        )
    }

    selectedTask?.let { task ->
        TaskDetailDialog(
            task = task, 
            onDismiss = { selectedTask = null },
            onDelete = {
                viewModel.deleteTask(it)
                selectedTask = null
            }
        )
    }
}

@Composable
fun PlannerScreen(viewModel: PlannerViewModel, onTaskClick: (TaskEntity) -> Unit) {
    val floatingTasks by viewModel.floatingTasks.collectAsStateWithLifecycle()
    val scheduleTasks by viewModel.scheduleTasks.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar()
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            FloatingTasksSection(floatingTasks, onTaskClick)
            Spacer(modifier = Modifier.height(32.dp))
            ScheduleSection(scheduleTasks, onTaskClick)
        }
    }
}

@Composable
fun PlaceholderScreen(title: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.Settings, contentDescription = null, modifier = Modifier.size(64.dp), tint = Slate300)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Slate900)
            Text(text = "Coming Soon", fontSize = 14.sp, color = Slate500)
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Thursday", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Slate900, letterSpacing = (-0.5).sp)
            Text(text = "Oct 24, 2024", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Slate500)
        }
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(2.dp, Color.White, CircleShape)
                .background(Brush.linearGradient(listOf(Indigo400, Purple500))),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "JD", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun FloatingTasksSection(tasks: List<TaskEntity>, onTaskClick: (TaskEntity) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "FLOATING TASKS", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Slate400, letterSpacing = 1.5.sp)
            Box(
                modifier = Modifier
                    .background(Indigo100, RoundedCornerShape(percent = 50))
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(text = "${tasks.size} PENDING", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Indigo700)
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(tasks) { task ->
                Box(
                    modifier = Modifier
                        .width(140.dp)
                        .background(White70, RoundedCornerShape(16.dp))
                        .border(1.dp, White40, RoundedCornerShape(16.dp))
                        .clickable { onTaskClick(task) }
                        .padding(12.dp)
                ) {
                    Column {
                        Text(text = task.title, fontSize = 12.sp, fontWeight = FontWeight.Medium, color = Slate900, lineHeight = 16.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(modifier = Modifier.fillMaxWidth().height(4.dp).background(Indigo100, CircleShape)) {
                            Box(modifier = Modifier.fillMaxWidth(0.5f).height(4.dp).background(Indigo500, CircleShape))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ScheduleSection(tasks: List<TaskEntity>, onTaskClick: (TaskEntity) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "SCHEDULE", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Slate400, letterSpacing = 1.5.sp)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 100.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(tasks) { task ->
                val timeFormat = java.text.SimpleDateFormat("HH:mm", java.util.Locale.getDefault())
                val timeString = task.startTime?.let { timeFormat.format(java.util.Date(it)) } ?: "00:00"

                ScheduleRow(time = timeString, isActive = true) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Indigo600, RoundedCornerShape(24.dp))
                            .clickable { onTaskClick(task) }
                            .padding(16.dp)
                    ) {
                        Column {
                            Text(text = "APP TASK", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = White80, letterSpacing = (-0.5).sp)
                            Text(text = task.title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }
            }
            item {
                // Current time indicator
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                ) {
                    Text(text = "12:45", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Indigo600, modifier = Modifier.width(40.dp), textAlign = TextAlign.End)
                    Spacer(modifier = Modifier.width(16.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Indigo400)) {
                        Box(modifier = Modifier.offset(y = (-4).dp).size(10.dp).background(Indigo600, CircleShape).border(2.dp, Color.White, CircleShape))
                    }
                }
            }
        }
    }
}

@Composable
fun ScheduleRow(time: String, isActive: Boolean = false, opacity: Float = 1f, content: @Composable () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().alpha(opacity),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = time,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Slate400,
            modifier = Modifier.width(40.dp).padding(top = 4.dp),
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.width(16.dp))
        Box(modifier = Modifier.weight(1f)) {
            content()
        }
    }
}

@Composable
fun BottomNavBar(currentRoute: String, onNavigate: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(White90)
            .border(1.dp, Slate100)
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavBarItem("Planner", Icons.Default.Home, isActive = currentRoute == "home") { onNavigate("home") }
        NavBarItem("Notes", Icons.Default.Create, isActive = currentRoute == "notes") { onNavigate("notes") }
        NavBarItem("Sync", Icons.Default.DateRange, isActive = currentRoute == "sync") { onNavigate("sync") }
        NavBarItem("Settings", Icons.Default.Settings, isActive = currentRoute == "settings") { onNavigate("settings") }
    }
}

@Composable
fun NavBarItem(label: String, icon: ImageVector, isActive: Boolean = false, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .alpha(if (isActive) 1f else 0.5f)
            .clickable { onClick() }
            .padding(4.dp)
    ) {
        if (isActive) {
            Box(
                modifier = Modifier
                    .background(Indigo100, RoundedCornerShape(16.dp))
                    .padding(horizontal = 20.dp, vertical = 4.dp)
            ) {
                Icon(imageVector = icon, contentDescription = label, tint = Indigo700, modifier = Modifier.size(24.dp))
            }
        } else {
            Icon(imageVector = icon, contentDescription = label, tint = Slate900, modifier = Modifier.size(24.dp))
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = label, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = if (isActive) Indigo700 else Slate900)
    }
}

@Composable
fun AddTaskDialog(
    onDismiss: () -> Unit,
    onAdd: (String, String, Boolean, Int, Int) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var isTimeBoxed by remember { mutableStateOf(false) }
    var hour by remember { mutableStateOf("09") }
    var minute by remember { mutableStateOf("00") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Task") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Task Title") },
                    singleLine = true
                )
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    minLines = 2,
                    maxLines = 4
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Switch(checked = isTimeBoxed, onCheckedChange = { isTimeBoxed = it })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Time-Boxed")
                }
                if (isTimeBoxed) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = hour,
                            onValueChange = { hour = it },
                            label = { Text("HH") },
                            modifier = Modifier.weight(1f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                        OutlinedTextField(
                            value = minute,
                            onValueChange = { minute = it },
                            label = { Text("MM") },
                            modifier = Modifier.weight(1f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onAdd(title, description, isTimeBoxed, hour.toIntOrNull() ?: 9, minute.toIntOrNull() ?: 0)
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun TaskDetailDialog(task: TaskEntity, onDismiss: () -> Unit, onDelete: (TaskEntity) -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(task.title, fontWeight = FontWeight.Bold) },
        text = {
            Column {
                if (task.isTimeBoxed) {
                    val timeFormat = java.text.SimpleDateFormat("HH:mm", java.util.Locale.getDefault())
                    val timeString = task.startTime?.let { timeFormat.format(java.util.Date(it)) } ?: ""
                    Text("Time: $timeString", fontWeight = FontWeight.SemiBold, color = Indigo600)
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Text(
                    text = task.description?.takeIf { it.isNotBlank() } ?: "No description provided.",
                    color = Slate800
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDelete(task) }) {
                Text("Delete", color = Color.Red)
            }
        }
    )
}

@Composable
fun AddNoteDialog(
    onDismiss: () -> Unit,
    onAdd: (String, String) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Note") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Note Title") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("Content") },
                    minLines = 3,
                    maxLines = 5,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(onClick = { onAdd(title, content) }) {
                Text("Add")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}