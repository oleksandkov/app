package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.dao.CategoryDao
import com.example.data.local.dao.NoteDao
import com.example.data.local.dao.TaskDao
import com.example.data.local.entity.CategoryEntity
import com.example.data.local.entity.NoteEntity
import com.example.data.local.entity.TaskEntity

import com.example.data.local.dao.SubTaskDao
import com.example.data.local.entity.SubTaskEntity
import com.example.data.local.dao.UserStatsDao
import com.example.data.local.entity.UserStatsEntity
import com.example.data.local.dao.PresetDao
import com.example.data.local.entity.PresetEntity

@Database(
    entities = [
        TaskEntity::class, 
        NoteEntity::class, 
        CategoryEntity::class, 
        SubTaskEntity::class,
        UserStatsEntity::class,
        PresetEntity::class
    ],
    version = 7,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun noteDao(): NoteDao
    abstract fun categoryDao(): CategoryDao
    abstract fun subTaskDao(): SubTaskDao
    abstract fun userStatsDao(): UserStatsDao
    abstract fun presetDao(): PresetDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "planner_db"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
