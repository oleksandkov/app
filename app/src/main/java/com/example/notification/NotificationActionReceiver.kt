package com.example.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.data.local.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotificationActionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "ACTION_MARK_DONE") {
            val taskId = intent.getIntExtra("task_id", -1)
            if (taskId != -1) {
                val pendingResult = goAsync()
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val db = AppDatabase.getDatabase(context.applicationContext)
                        val taskDao = db.taskDao()
                        val task = taskDao.getTaskById(taskId)
                        if (task != null) {
                            taskDao.updateTask(task.copy(isCompleted = true))
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    } finally {
                        pendingResult.finish()
                    }
                }
            }
        }
    }
}
