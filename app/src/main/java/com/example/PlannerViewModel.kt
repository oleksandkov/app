package com.example

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.entity.TaskEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar

class PlannerViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)
    private val taskDao = db.taskDao()

    private val startOfDay: Long
    private val endOfDay: Long

    init {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        startOfDay = calendar.timeInMillis
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        calendar.set(Calendar.MILLISECOND, 999)
        endOfDay = calendar.timeInMillis
    }

    val todaysTasks = taskDao.getTasksForDate(startOfDay, endOfDay)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val floatingTasks: StateFlow<List<TaskEntity>> = todaysTasks
        .map { tasks -> tasks.filter { !it.isTimeBoxed } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val scheduleTasks: StateFlow<List<TaskEntity>> = todaysTasks
        .map { tasks -> tasks.filter { it.isTimeBoxed } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addTask(title: String, description: String?, isTimeBoxed: Boolean, hour: Int = 9, minute: Int = 0) {
        viewModelScope.launch {
            val taskTime = if (isTimeBoxed) {
                val cal = Calendar.getInstance()
                cal.timeInMillis = startOfDay
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                cal.timeInMillis
            } else null

            taskDao.insertTask(
                TaskEntity(
                    title = title,
                    description = description,
                    date = startOfDay,
                    startTime = taskTime,
                    endTime = null,
                    isTimeBoxed = isTimeBoxed
                )
            )
        }
    }

    val allNotes = db.noteDao().getAllNotes().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            db.noteDao().insertNote(
                com.example.data.local.entity.NoteEntity(
                    title = title,
                    content = content,
                    categoryId = null
                )
            )
        }
    }

    fun deleteNote(note: com.example.data.local.entity.NoteEntity) {
        viewModelScope.launch {
            db.noteDao().deleteNoteById(note.id)
        }
    }

    fun deleteTask(task: TaskEntity) {
        viewModelScope.launch {
            taskDao.deleteTaskById(task.id)
        }
    }
}
