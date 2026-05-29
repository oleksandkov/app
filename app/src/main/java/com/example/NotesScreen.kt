package com.example

import android.content.Intent
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.local.entity.NoteEntity
import com.example.ui.theme.*
import java.io.File
import java.io.FileOutputStream

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(viewModel: PlannerViewModel) {
    val context = LocalContext.current
    val allNotes by viewModel.allNotes.collectAsStateWithLifecycle()
    val selectedDate by viewModel.selectedDate.collectAsStateWithLifecycle()

    var activeNoteForEdit by remember { mutableStateOf<NoteEntity?>(null) }
    var showAddDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
    ) {
        if (activeNoteForEdit == null) {
            // Note list grid view
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Your Notes", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Slate900)
                    IconButton(onClick = { showAddDialog = true }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "New Note", tint = Indigo600)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                if (allNotes.isEmpty()) {
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(imageVector = Icons.Default.Create, contentDescription = null, modifier = Modifier.size(64.dp), tint = Slate300)
                            Spacer(modifier = Modifier.height(16.dp))
                            Text("No Notes Yet", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Slate500)
                            Text("Tap '+' above to create your first markdown note.", fontSize = 12.sp, color = Slate400)
                        }
                    }
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(bottom = 80.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        items(allNotes) { note ->
                            NoteGridCard(note = note, onClick = { activeNoteForEdit = note })
                        }
                    }
                }
            }
        } else {
            // Full screen Markdown Editor and Preview
            val currentNote = activeNoteForEdit!!
            MarkdownEditorView(
                note = currentNote,
                selectedDate = selectedDate,
                onDismiss = { activeNoteForEdit = null },
                onSave = { updated ->
                    viewModel.updateNote(updated)
                    activeNoteForEdit = null
                    Toast.makeText(context, "Note saved", Toast.LENGTH_SHORT).show()
                },
                onDelete = {
                    viewModel.deleteNote(currentNote)
                    activeNoteForEdit = null
                    Toast.makeText(context, "Note deleted", Toast.LENGTH_SHORT).show()
                }
            )
        }

        // Add Note Dialog
        if (showAddDialog) {
            AddNoteDialog(
                onDismiss = { showAddDialog = false },
                onAdd = { title, content ->
                    viewModel.addNote(title, content)
                    showAddDialog = false
                    Toast.makeText(context, "Note created", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@Composable
fun NoteGridCard(note: NoteEntity, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Slate200),
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(text = note.title, fontWeight = FontWeight.Bold, color = Slate900, maxLines = 1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = note.content, fontSize = 12.sp, color = Slate500, maxLines = 4)
        }
    }
}

@Composable
fun MarkdownEditorView(
    note: NoteEntity,
    selectedDate: Long,
    onDismiss: () -> Unit,
    onSave: (NoteEntity) -> Unit,
    onDelete: () -> Unit
) {
    val context = LocalContext.current
    var title by remember { mutableStateOf(note.title) }
    var contentValue by remember { mutableStateOf(TextFieldValue(note.content)) }
    var isPreviewMode by remember { mutableStateOf(false) }
    var attachToToday by remember { mutableStateOf(note.linkedDate != null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackground)
    ) {
        // Toolbar Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onDismiss) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Slate900)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text("Edit Note", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Slate900)
            }
            Row {
                // Delete Note
                IconButton(onClick = onDelete) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red)
                }
                // Share Note
                IconButton(onClick = {
                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_SUBJECT, title)
                        putExtra(Intent.EXTRA_TEXT, contentValue.text)
                    }
                    context.startActivity(Intent.createChooser(shareIntent, "Share Note"))
                }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "Share", tint = Indigo600)
                }
                // Save Note
                IconButton(onClick = {
                    val updatedNote = note.copy(
                        title = title,
                        content = contentValue.text,
                        linkedDate = if (attachToToday) selectedDate else null
                    )
                    onSave(updatedNote)
                }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Save", tint = Color(0xFF2ECC71))
                }
            }
        }

        // Toggle Preview / Edit tab
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { isPreviewMode = false },
                colors = ButtonDefaults.buttonColors(containerColor = if (!isPreviewMode) Indigo600 else Slate200, contentColor = if (!isPreviewMode) Color.White else Slate900),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Editor", fontSize = 12.sp)
            }
            Button(
                onClick = { isPreviewMode = true },
                colors = ButtonDefaults.buttonColors(containerColor = if (isPreviewMode) Indigo600 else Slate200, contentColor = if (isPreviewMode) Color.White else Slate900),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Preview Markdown", fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title Input
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            placeholder = { Text("Note Title") },
            textStyle = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Attach Day Option
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Checkbox(checked = attachToToday, onCheckedChange = { attachToToday = it })
            Spacer(modifier = Modifier.width(8.dp))
            Text("Attach note to selected day timeline", fontSize = 12.sp, color = Slate500)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Editor Toolbar
        if (!isPreviewMode) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Slate100)
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextButton(onClick = {
                    val text = contentValue.text
                    val selection = contentValue.selection
                    val newText = text.substring(0, selection.start) + "[ ] " + text.substring(selection.end)
                    contentValue = TextFieldValue(newText, androidx.compose.ui.text.TextRange(selection.start + 4))
                }) {
                    Text("[ ] Checklist Item", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Indigo600)
                }

                // Export MD file option
                TextButton(onClick = {
                    try {
                        val file = File(context.getExternalFilesDir(null), "${title.replace(" ", "_")}.md")
                        val stream = FileOutputStream(file)
                        stream.use { it.write(contentValue.text.toByteArray()) }
                        Toast.makeText(context, "Downloaded to ${file.absolutePath}", Toast.LENGTH_LONG).show()
                    } catch (e: Exception) {
                        Toast.makeText(context, "Download Failed: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Indigo600, modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Export MD File", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Indigo600)
                }
            }
        }

        // Main Editor/Preview space
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(24.dp)
        ) {
            if (!isPreviewMode) {
                OutlinedTextField(
                    value = contentValue,
                    onValueChange = { contentValue = it },
                    placeholder = { Text("Write your notes using Markdown syntax...") },
                    modifier = Modifier.fillMaxSize(),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Indigo600)
                )
            } else {
                SelectionContainer {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White, RoundedCornerShape(16.dp))
                            .border(1.dp, Slate200, RoundedCornerShape(16.dp))
                            .padding(16.dp)
                    ) {
                        item {
                            val styledText = renderMarkdown(contentValue.text)
                            Text(text = styledText, fontSize = 14.sp, color = Slate900, lineHeight = 20.sp)
                        }
                    }
                }
            }
        }
    }
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
        title = { Text("Create Note") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Note Title") }
                )
                OutlinedTextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("Content") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { onAdd(title, content) },
                colors = ButtonDefaults.buttonColors(containerColor = Indigo600)
            ) {
                Text("Create")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Cancel") }
        }
    )
}

// Native lightweight Markdown Stylist
fun renderMarkdown(text: String): AnnotatedString {
    return buildAnnotatedString {
        val lines = text.split("\n")
        lines.forEachIndexed { index, line ->
            when {
                line.startsWith("# ") -> {
                    this@buildAnnotatedString.withStyle(SpanStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Slate900)) {
                        append(line.substring(2))
                    }
                }
                line.startsWith("## ") -> {
                    this@buildAnnotatedString.withStyle(SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Slate900)) {
                        append(line.substring(3))
                    }
                }
                line.startsWith("### ") -> {
                    this@buildAnnotatedString.withStyle(SpanStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Slate900)) {
                        append(line.substring(4))
                    }
                }
                line.startsWith("- [ ] ") -> {
                    append("☐  ")
                    append(line.substring(6))
                }
                line.startsWith("- [x] ") -> {
                    this@buildAnnotatedString.withStyle(SpanStyle(color = Slate400, textDecoration = androidx.compose.ui.text.style.TextDecoration.LineThrough)) {
                        append("☑  ")
                        append(line.substring(6))
                    }
                }
                else -> {
                    // Basic bold/italic inline parsing
                    var remaining = line
                    while (remaining.isNotEmpty()) {
                        val boldIndex = remaining.indexOf("**")
                        val italicIndex = remaining.indexOf("*")
                        if (boldIndex != -1 && (italicIndex == -1 || boldIndex < italicIndex)) {
                            append(remaining.substring(0, boldIndex))
                            val closeIndex = remaining.indexOf("**", boldIndex + 2)
                            if (closeIndex != -1) {
                                this@buildAnnotatedString.withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append(remaining.substring(boldIndex + 2, closeIndex))
                                }
                                remaining = remaining.substring(closeIndex + 2)
                            } else {
                                append("**")
                                remaining = remaining.substring(boldIndex + 2)
                            }
                        } else if (italicIndex != -1) {
                            append(remaining.substring(0, italicIndex))
                            val closeIndex = remaining.indexOf("*", italicIndex + 1)
                            if (closeIndex != -1) {
                                this@buildAnnotatedString.withStyle(SpanStyle(fontStyle = FontStyle.Italic)) {
                                    append(remaining.substring(italicIndex + 1, closeIndex))
                                }
                                remaining = remaining.substring(closeIndex + 1)
                            } else {
                                append("*")
                                remaining = remaining.substring(italicIndex + 1)
                            }
                        } else {
                            append(remaining)
                            break
                        }
                    }
                }
            }
            if (index < lines.size - 1) {
                append("\n")
            }
        }
    }
}
