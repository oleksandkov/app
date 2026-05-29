package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: String = "",
    val title: String,
    val description: String?,
    val date: Long, // Epoch milliseconds representing the date
    val startTime: Long?, // Epoch milliseconds for start time (null if floating)
    val endTime: Long?, // Epoch milliseconds for end time
    val isTimeBoxed: Boolean, 
    val isCompleted: Boolean = false,
    val reminderTime: Long? = null,
    val externalCalendarEventId: String? = null
)
