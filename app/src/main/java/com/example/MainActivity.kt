package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
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
import com.example.ui.theme.*
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import android.widget.Toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        try {
            if (com.google.firebase.FirebaseApp.getApps(this).isEmpty()) {
                val options = com.google.firebase.FirebaseOptions.Builder()
                    .setApiKey("AIzaSyFakeKeyForInitialInitializationNeeds")
                    .setApplicationId("1:948511050671:android:e3a89be432f9cb")
                    .setProjectId("planit-app-94851")
                    .build()
                com.google.firebase.FirebaseApp.initializeApp(this, options)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (android.os.Build.VERSION.SDK_INT >= 33) {
            val requestPermissionLauncher = registerForActivityResult(
                androidx.activity.result.contract.ActivityResultContracts.RequestPermission()
            ) { _ -> }
            if (androidx.core.content.ContextCompat.checkSelfPermission(
                    this,
                    "android.permission.POST_NOTIFICATIONS"
                ) != android.content.pm.PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS")
            }
        }

        setContent {
            val settingsViewModel: com.example.settings.SettingsViewModel = viewModel()
            val themeMode by settingsViewModel.themeMode.collectAsStateWithLifecycle()
            val darkTheme = when (themeMode) {
                "light" -> false
                "dark" -> true
                else -> androidx.compose.foundation.isSystemInDarkTheme()
            }
            MyApplicationTheme(darkTheme = darkTheme) {
                MainAppNavigation()
            }
        }
    }
}

@Composable
fun MainAppNavigation() {
    val navController = rememberNavController()
    val currentUser = remember { FirebaseAuth.getInstance().currentUser }
    val startDestination = if (currentUser != null) "main" else "login"

    NavHost(navController = navController, startDestination = startDestination) {
        composable("login") { LoginScreen(navController) }
        composable("main") { 
            MainDashboardScreen(onSignOut = {
                FirebaseAuth.getInstance().signOut()
                navController.navigate("login") {
                    popUpTo(0) { inclusive = true }
                }
            }) 
        }
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val auth: FirebaseAuth = remember { FirebaseAuth.getInstance() }
    val authManager: com.example.auth.AuthManager = remember { com.example.auth.AuthManager(context, auth) }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isRegistering by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
            .padding(24.dp),
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
        Text(
            text = if (isRegistering) "Create Account" else "Welcome to PlanIt",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Slate900
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Keep your schedule, notes, and task lists synchronized.",
            fontSize = 14.sp,
            color = Slate500,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Email field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Password field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        if (isLoading) {
            CircularProgressIndicator(color = Indigo600)
            Spacer(modifier = Modifier.height(16.dp))
        } else {
            // Main Action Button (Login / Register)
            Button(
                onClick = {
                    if (email.isBlank() || password.isBlank()) {
                        Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    isLoading = true
                    coroutineScope.launch {
                        try {
                            if (isRegistering) {
                                auth.createUserWithEmailAndPassword(email, password)
                            } else {
                                auth.signInWithEmailAndPassword(email, password)
                            }
                            isLoading = false
                            navController.navigate("main") {
                                popUpTo("login") { inclusive = true }
                            }
                        } catch (e: Exception) {
                            isLoading = false
                            Toast.makeText(context, "Auth Failed: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Indigo600),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(
                    text = if (isRegistering) "Register & Enter" else "Sign In",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Google Sign-In Button
            Button(
                onClick = {
                    isLoading = true
                    coroutineScope.launch {
                        val success = authManager.signInWithGoogle()
                        isLoading = false
                        if (success) {
                            navController.navigate("main") {
                                popUpTo("login") { inclusive = true }
                            }
                        } else {
                            Toast.makeText(context, "Google Sign-In failed or cancelled", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Slate200),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(
                    text = "Sign In with Google",
                    color = Slate900,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            // Toggle Register/Login Mode
            Text(
                text = if (isRegistering) "Already have an account? Sign In" else "New to PlanIt? Create an Account",
                color = Indigo500,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .clickable { isRegistering = !isRegistering }
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun MainDashboardScreen(onSignOut: () -> Unit = {}) {
    val bottomNavController = rememberNavController()
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "home"
    val plannerViewModel: PlannerViewModel = viewModel()

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
        }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = "home",
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            composable("home") { HomeScreen(plannerViewModel) }
            composable("tasks") {
                TasksScreen(
                    viewModel = plannerViewModel,
                    onNavigateToHome = { hour ->
                        bottomNavController.navigate("home")
                    }
                )
            }
            composable("notes") { NotesScreen(plannerViewModel) }
            composable("insights") { InsightsScreen(plannerViewModel) }
            composable("settings") { SettingsScreen(onSignOut) }
        }
    }
}





@Composable
fun PlaceholderScreen(title: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.Info, contentDescription = null, modifier = Modifier.size(64.dp), tint = Slate300)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Slate900)
            Text(text = "Ready to start implementation", fontSize = 14.sp, color = Slate500)
        }
    }
}

@Composable
fun BottomNavBar(currentRoute: String, onNavigate: (String) -> Unit) {
    Row(
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxWidth()
            .height(80.dp)
            .background(White90)
            .padding(horizontal = 8.dp)
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavBarItem("Planner", Icons.Default.Home, isActive = currentRoute == "home") { onNavigate("home") }
        NavBarItem("Tasks", Icons.Default.CheckCircle, isActive = currentRoute == "tasks") { onNavigate("tasks") }
        NavBarItem("Notes", Icons.Default.Create, isActive = currentRoute == "notes") { onNavigate("notes") }
        NavBarItem("Insights", Icons.Default.Info, isActive = currentRoute == "insights") { onNavigate("insights") }
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