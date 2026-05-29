package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subtasks")
data class SubTaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: String = "",
    val parentIdStr: String, // "local_{id}" or "google_{id}"
    val title: String,
    val isCompleted: Boolean = false
)
