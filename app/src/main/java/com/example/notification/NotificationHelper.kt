package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.MainActivity
import com.example.R
import com.example.data.local.entity.TaskEntity

class NotificationHelper(private val context: Context) {

    companion object {
        const val CHANNEL_REMINDERS_ID = "planit_reminders"
        const val CHANNEL_PERSISTENT_ID = "planit_persistent"
        const val NOTIFICATION_PERSISTENT_ID = 2001
        const val NOTIFICATION_REMINDER_ID = 2002
    }

    init {
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nameReminders = "PlanIt Reminders"
            val descReminders = "Notifications for plans and task reminders"
            val importanceReminders = NotificationManager.IMPORTANCE_HIGH
            val channelReminders = NotificationChannel(CHANNEL_REMINDERS_ID, nameReminders, importanceReminders).apply {
                description = descReminders
            }

            val namePersistent = "PlanIt Active Schedule"
            val descPersistent = "Persistent notification displaying the current active plan"
            val importancePersistent = NotificationManager.IMPORTANCE_LOW
            val channelPersistent = NotificationChannel(CHANNEL_PERSISTENT_ID, namePersistent, importancePersistent).apply {
                description = descPersistent
            }

            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channelReminders)
            manager.createNotificationChannel(channelPersistent)
        }
    }

    // Displays the persistent timeline ticker in the system tray
    fun showPersistentNotification(currentPlan: TaskEntity?, nextPlan: TaskEntity?) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val title = currentPlan?.let { "Active: ${it.title}" } ?: "No Active Plans"
        val nextText = nextPlan?.let { "Next Up: ${it.title}" } ?: "No Upcoming Plans"

        val builder = NotificationCompat.Builder(context, CHANNEL_PERSISTENT_ID)
            .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
            .setContentTitle(title)
            .setContentText(nextText)
            .setOngoing(true)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setContentIntent(pendingIntent)

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(NOTIFICATION_PERSISTENT_ID, builder.build())
    }

    // Displays high-priority watch-formatted alerts for plans starting now
    fun showReminderNotification(task: TaskEntity) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Action Broadcast: Mark Done from watch or notification bar
        val doneIntent = Intent(context, NotificationActionReceiver::class.java).apply {
            action = "ACTION_MARK_DONE"
            putExtra("task_id", task.id)
        }
        val donePendingIntent = PendingIntent.getBroadcast(
            context,
            task.id,
            doneIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, CHANNEL_REMINDERS_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Plan Alert: ${task.title}")
            .setContentText(task.description ?: "Plan starting now.")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_REMINDER)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .addAction(android.R.drawable.checkbox_on_background, "Done", donePendingIntent)

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(NOTIFICATION_REMINDER_ID + task.id, builder.build())
    }

    fun cancelPersistentNotification() {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(NOTIFICATION_PERSISTENT_ID)
    }
}
