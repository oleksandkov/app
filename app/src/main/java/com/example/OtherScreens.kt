package com.example

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import com.example.data.local.entity.NoteEntity
import com.example.ui.theme.*

@Composable
fun NotesScreen(viewModel: PlannerViewModel) {
    val notes by viewModel.allNotes.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("Your Notes", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Slate900)
        Spacer(modifier = Modifier.height(16.dp))
        
        if (notes.isEmpty()) {
            Box(modifier = Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text("No notes yet. Tap + to add one.", color = Slate500)
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 100.dp)
            ) {
                items(notes) { note ->
                    NoteCard(note = note, onDelete = { viewModel.deleteNote(note) })
                }
            }
        }
    }
}

@Composable
fun NoteCard(note: NoteEntity, onDelete: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth().clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(containerColor = White90),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(note.title, fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = Slate900)
                IconButton(onClick = onDelete, modifier = Modifier.size(24.dp)) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red.copy(alpha = 0.7f))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = note.content,
                color = Slate800,
                maxLines = if (expanded) Int.MAX_VALUE else 2,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun SyncScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(Icons.Default.Refresh, contentDescription = "Sync", modifier = Modifier.size(80.dp), tint = Indigo500)
        Spacer(modifier = Modifier.height(24.dp))
        Text("Google Calendar Sync", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Slate900)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            "Your schedule automatically syncs with Google Calendar. Tap below to force a manual sync.",
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            color = Slate500
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { /* mocked sync action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Indigo600),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("Sync Now", fontSize = 16.sp)
        }
    }
}

@Composable
fun SettingsScreen(onSignOut: () -> Unit) {
    val auth = try { com.google.firebase.auth.FirebaseAuth.getInstance() } catch(e: Exception) { null }
    val user = auth?.currentUser
    val name = user?.displayName ?: "Google User"
    val email = user?.email ?: "muaronok@gmail.com"
    val initial = name.firstOrNull()?.toString()?.uppercase() ?: "U"

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("Profile & Settings", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Slate900)
        Spacer(modifier = Modifier.height(32.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White90)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.size(64.dp).clip(CircleShape).background(Indigo500),
                    contentAlignment = Alignment.Center
                ) {
                    Text(initial, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(name, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Slate900)
                    Text(email, color = Slate500, fontSize = 14.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        
        Text("Preferences", fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Slate500)
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text("Push Notifications", fontSize = 16.sp, color = Slate900)
            Switch(checked = true, onCheckedChange = {})
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text("Dark Mode", fontSize = 16.sp, color = Slate900)
            Switch(checked = false, onCheckedChange = {})
        }

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = onSignOut,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
        ) {
            Text("Sign Out", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}
