package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.PresetEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PresetDao {
    @Query("SELECT * FROM presets WHERE userId = :userId")
    fun getAllPresetsFlow(userId: String): Flow<List<PresetEntity>>

    @Query("SELECT * FROM presets WHERE userId = :userId")
    suspend fun getAllPresets(userId: String): List<PresetEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPreset(preset: PresetEntity)

    @Query("DELETE FROM presets WHERE id = :id AND userId = :userId")
    suspend fun deletePreset(id: Int, userId: String)
}
