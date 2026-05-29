package com.example

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.settings.SettingsViewModel
import com.example.ui.theme.*
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SettingsScreen(
    onSignOut: () -> Unit
) {
    val settingsViewModel: SettingsViewModel = viewModel()
    val scrollState = rememberScrollState()

    // Collect settings flows
    val themeMode by settingsViewModel.themeMode.collectAsStateWithLifecycle()
    val masterNotifications by settingsViewModel.masterNotifications.collectAsStateWithLifecycle()
    val notifyPlans by settingsViewModel.notifyPlans.collectAsStateWithLifecycle()
    val notifyTasks by settingsViewModel.notifyTasks.collectAsStateWithLifecycle()
    val notifyStreaks by settingsViewModel.notifyStreaks.collectAsStateWithLifecycle()
    val notifyGamification by settingsViewModel.notifyGamification.collectAsStateWithLifecycle()
    val notificationVolume by settingsViewModel.notificationVolume.collectAsStateWithLifecycle()
    val notificationSoundProfile by settingsViewModel.notificationSoundProfile.collectAsStateWithLifecycle()
    val googleCalendarSync by settingsViewModel.googleCalendarSync.collectAsStateWithLifecycle()
    val googleCalendarAutoPush by settingsViewModel.googleCalendarAutoPush.collectAsStateWithLifecycle()

    val firebaseUser = remember { FirebaseAuth.getInstance().currentUser }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
            .padding(horizontal = 24.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text("Settings", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Slate900)
        Spacer(modifier = Modifier.height(20.dp))

        // 1. User Profile section
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, Slate200),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .background(Indigo100),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null, tint = Indigo600)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = firebaseUser?.displayName ?: "User Account",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Slate900
                    )
                    Text(
                        text = firebaseUser?.email ?: "offline@planit.com",
                        fontSize = 12.sp,
                        color = Slate500
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 2. Theme Preferences
        Text("Theme Mode", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Slate500)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("light" to "Light", "dark" to "Dark", "system" to "System").forEach { item ->
                val isSelected = themeMode == item.first
                Button(
                    onClick = { settingsViewModel.setThemeMode(item.first) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) Indigo600 else Color.White,
                        contentColor = if (isSelected) Color.White else Slate500
                    ),
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, if (isSelected) Color.Transparent else Slate200),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(item.second, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 3. Notification Panels
        Text("Notification Channels", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Slate500)
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Slate200),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Master Notifications Toggle", fontWeight = FontWeight.Bold)
                    Switch(checked = masterNotifications, onCheckedChange = { settingsViewModel.setMasterNotifications(it) })
                }
                if (masterNotifications) {
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Daily Plans starting soon", fontSize = 14.sp)
                        Switch(checked = notifyPlans, onCheckedChange = { settingsViewModel.setNotifyPlans(it) })
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Task reminders", fontSize = 14.sp)
                        Switch(checked = notifyTasks, onCheckedChange = { settingsViewModel.setNotifyTasks(it) })
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Daily streaks alert", fontSize = 14.sp)
                        Switch(checked = notifyStreaks, onCheckedChange = { settingsViewModel.setNotifyStreaks(it) })
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 4. Sound Control
        Text("Notification Audio Profile", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Slate500)
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Slate200),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Alert Volume", fontSize = 12.sp, color = Slate500)
                Slider(
                    value = notificationVolume,
                    onValueChange = { settingsViewModel.setNotificationVolume(it) },
                    valueRange = 0.0f..1.0f
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Sound profile:")
                    Text(notificationSoundProfile.uppercase(), fontWeight = FontWeight.Bold, color = Indigo600)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 5. Google Calendar Sync
        Text("Calendar Synchronization", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Slate500)
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Slate200),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Sync Google Calendar", fontWeight = FontWeight.Bold)
                    Switch(checked = googleCalendarSync, onCheckedChange = { settingsViewModel.setGoogleCalendarSync(it) })
                }
                if (googleCalendarSync) {
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Auto push plans to Google", fontSize = 14.sp)
                        Switch(checked = googleCalendarAutoPush, onCheckedChange = { settingsViewModel.setGoogleCalendarAutoPush(it) })
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Logout
        Button(
            onClick = onSignOut,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Sign Out", color = Color.White, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(48.dp))
    }
}
