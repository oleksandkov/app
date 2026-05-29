package com.example

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.entity.NoteEntity
import com.example.data.local.entity.TaskEntity
import com.example.data.local.entity.SubTaskEntity
import com.example.data.local.entity.UserStatsEntity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.Calendar

@OptIn(ExperimentalCoroutinesApi::class)
class PlannerViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)
    private val taskDao = db.taskDao()
    private val noteDao = db.noteDao()
    private val subTaskDao = db.subTaskDao()
    private val userStatsDao = db.userStatsDao()
    private val presetDao = db.presetDao()

    val currentUserId: String
        get() = FirebaseAuth.getInstance().currentUser?.uid ?: "demo_user"

    val userStats: StateFlow<UserStatsEntity?> = userStatsDao.getUserStatsFlow(currentUserId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun addXp(amount: Int) {
        viewModelScope.launch {
            val stats = userStatsDao.getUserStats(currentUserId) ?: UserStatsEntity(userId = currentUserId)
            var newXp = stats.xp + amount
            var newLevel = stats.level
            var xpNeeded = newLevel * 150
            while (newXp >= xpNeeded) {
                newXp -= xpNeeded
                newLevel += 1
                xpNeeded = newLevel * 150
            }
            userStatsDao.insertOrUpdateUserStats(stats.copy(xp = newXp, level = newLevel))
        }
    }

    fun updateStreakOnStart() {
        viewModelScope.launch {
            val stats = userStatsDao.getUserStats(currentUserId) ?: UserStatsEntity(userId = currentUserId)
            val now = System.currentTimeMillis()
            val lastActive = stats.lastActiveTimestamp
            if (lastActive == 0L) {
                userStatsDao.insertOrUpdateUserStats(stats.copy(currentStreak = 1, lastActiveTimestamp = now))
                return@launch
            }
            val daysDiff = ((now - lastActive) / (1000 * 60 * 60 * 24)).toInt()
            if (daysDiff == 1) {
                userStatsDao.insertOrUpdateUserStats(stats.copy(currentStreak = stats.currentStreak + 1, lastActiveTimestamp = now))
            } else if (daysDiff > 1) {
                userStatsDao.insertOrUpdateUserStats(stats.copy(currentStreak = 1, lastActiveTimestamp = now))
            } else {
                userStatsDao.insertOrUpdateUserStats(stats.copy(lastActiveTimestamp = now))
            }
        }
    }

    private val _selectedDate = MutableStateFlow(getStartOfDay(System.currentTimeMillis()))
    val selectedDate: StateFlow<Long> = _selectedDate

    val todaysTasks: StateFlow<List<TaskEntity>> = _selectedDate
        .flatMapLatest { timestamp ->
            taskDao.getTasksForDate(currentUserId, getStartOfDay(timestamp), getEndOfDay(timestamp))
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val floatingTasks: StateFlow<List<TaskEntity>> = todaysTasks
        .map { tasks -> tasks.filter { !it.isTimeBoxed } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val scheduleTasks: StateFlow<List<TaskEntity>> = todaysTasks
        .map { tasks -> tasks.filter { it.isTimeBoxed } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allNotes: StateFlow<List<NoteEntity>> = noteDao.getAllNotes(currentUserId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allSubTasksFlow = subTaskDao.getAllSubTasks(currentUserId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val notificationHelper = com.example.notification.NotificationHelper(application)
    private val preferencesRepository = com.example.settings.PreferencesRepository(application)
    private val notifiedTaskIds = mutableSetOf<Int>()

    private val tickerFlow = flow {
        while (true) {
            emit(System.currentTimeMillis())
            kotlinx.coroutines.delay(30000)
        }
    }

    private val todayStartOfDayFlow: Flow<Long> = flow {
        while (true) {
            emit(getStartOfDay(System.currentTimeMillis()))
            kotlinx.coroutines.delay(30000)
        }
    }.distinctUntilChanged()

    val actualTodaysTasks: Flow<List<TaskEntity>> = todayStartOfDayFlow
        .flatMapLatest { startOfDay ->
            taskDao.getTasksForDate(currentUserId, startOfDay, getEndOfDay(startOfDay))
        }

    init {
        updateStreakOnStart()
        startNotificationLoop()
    }

    private fun startNotificationLoop() {
        viewModelScope.launch {
            combine(
                actualTodaysTasks,
                preferencesRepository.masterNotificationsFlow,
                preferencesRepository.notifyPlansFlow,
                tickerFlow
            ) { tasks, masterEnabled, plansEnabled, now ->
                NotificationParams(tasks, masterEnabled, plansEnabled, now)
            }.collect { params ->
                updateNotifications(params)
            }
        }
    }

    private fun updateNotifications(params: NotificationParams) {
        if (!params.masterEnabled) {
            notificationHelper.cancelPersistentNotification()
            return
        }

        if (params.plansEnabled) {
            val timeBoxed = params.tasks.filter { it.isTimeBoxed && !it.isCompleted }
            val currentPlan = timeBoxed.firstOrNull { task ->
                val start = task.startTime
                val end = task.endTime
                start != null && end != null && params.now >= start && params.now < end
            }
            val nextPlan = timeBoxed
                .filter { task ->
                    val start = task.startTime
                    start != null && start > params.now
                }
                .minByOrNull { it.startTime!! }

            notificationHelper.showPersistentNotification(currentPlan, nextPlan)
        } else {
            notificationHelper.cancelPersistentNotification()
        }

        if (params.plansEnabled) {
            val upcomingTimeBoxed = params.tasks.filter { it.isTimeBoxed && !it.isCompleted }
            for (task in upcomingTimeBoxed) {
                val start = task.startTime
                if (start != null) {
                    val diff = Math.abs(start - params.now)
                    if (diff <= 60000L && !notifiedTaskIds.contains(task.id)) {
                        notificationHelper.showReminderNotification(task)
                        notifiedTaskIds.add(task.id)
                    }
                }
            }
        }
    }

    private data class NotificationParams(
        val tasks: List<TaskEntity>,
        val masterEnabled: Boolean,
        val plansEnabled: Boolean,
        val now: Long
    )

    fun selectDate(timestamp: Long) {
        _selectedDate.value = getStartOfDay(timestamp)
    }


    private fun getStartOfDay(timestamp: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.timeInMillis
    }

    private fun getEndOfDay(timestamp: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        calendar.set(Calendar.MILLISECOND, 999)
        return calendar.timeInMillis
    }

    fun addTask(title: String, description: String?, isTimeBoxed: Boolean, hour: Int = 9, minute: Int = 0, subtasks: List<String> = emptyList()) {
        viewModelScope.launch {
            val taskTime = if (isTimeBoxed) {
                val cal = Calendar.getInstance()
                cal.timeInMillis = _selectedDate.value
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                cal.timeInMillis
            } else null

            val insertedId = taskDao.insertTask(
                TaskEntity(
                    userId = currentUserId,
                    title = title,
                    description = description,
                    date = _selectedDate.value,
                    startTime = taskTime,
                    endTime = taskTime?.let { it + 60 * 60000L }, // default 1 hour
                    isTimeBoxed = isTimeBoxed
                )
            )

            if (subtasks.isNotEmpty()) {
                val parentIdStr = "local_$insertedId"
                val entities = subtasks.map { subtaskTitle ->
                    SubTaskEntity(
                        userId = currentUserId,
                        parentIdStr = parentIdStr,
                        title = subtaskTitle,
                        isCompleted = false
                    )
                }
                subTaskDao.insertSubTasks(entities)
            }
        }
    }

    fun updateTask(task: TaskEntity) {
        viewModelScope.launch {
            val previous = taskDao.getTaskById(task.id)
            if (previous != null && !previous.isCompleted && task.isCompleted) {
                addXp(15)
            }
            taskDao.updateTask(task)
        }
    }

    fun deleteTask(task: TaskEntity) {
        viewModelScope.launch {
            taskDao.deleteTaskById(task.id)
            subTaskDao.deleteSubTasksByParent(currentUserId, "local_${task.id}")
        }
    }

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            noteDao.insertNote(
                NoteEntity(
                    userId = currentUserId,
                    title = title,
                    content = content,
                    categoryId = null,
                    linkedDate = _selectedDate.value
                )
            )
            addXp(5)
        }
    }

    fun deleteNote(note: NoteEntity) {
        viewModelScope.launch {
            noteDao.deleteNoteById(note.id)
        }
    }

    fun updateNote(note: NoteEntity) {
        viewModelScope.launch {
            noteDao.updateNote(note)
        }
    }

    suspend fun getSubTasksForParent(parentIdStr: String): List<SubTaskEntity> {
        return subTaskDao.getSubTasksForParent(currentUserId, parentIdStr)
    }

    fun saveSubTasksForParentDirectly(parentIdStr: String, subTasks: List<SubTaskEntity>) {
        viewModelScope.launch {
            subTaskDao.deleteSubTasksByParent(currentUserId, parentIdStr)
            val updated = subTasks.map { it.copy(userId = currentUserId, parentIdStr = parentIdStr) }
            subTaskDao.insertSubTasks(updated)
        }
    }

    fun toggleSubTaskCompletion(subTask: SubTaskEntity, isCompleted: Boolean) {
        viewModelScope.launch {
            if (!subTask.isCompleted && isCompleted) {
                addXp(10)
            }
            subTaskDao.updateSubTask(subTask.copy(isCompleted = isCompleted))
        }
    }
}
