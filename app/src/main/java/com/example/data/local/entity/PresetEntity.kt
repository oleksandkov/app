package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "presets")
data class PresetEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: String,
    val name: String,
    val plansJson: String, // JSON serialization of schedule plans/timeline items
    val tasksJson: String  // JSON serialization of daily tasks
)
