package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_stats")
data class UserStatsEntity(
    @PrimaryKey val userId: String,
    val xp: Int = 0,
    val level: Int = 1,
    val currentStreak: Int = 0,
    val lastActiveTimestamp: Long = 0L,
    val unlockedAchievementsJson: String = "[]" // JSON representation of unlocked achievement badges
)
