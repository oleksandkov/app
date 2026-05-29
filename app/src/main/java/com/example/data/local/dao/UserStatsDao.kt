package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.UserStatsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserStatsDao {
    @Query("SELECT * FROM user_stats WHERE userId = :userId LIMIT 1")
    fun getUserStatsFlow(userId: String): Flow<UserStatsEntity?>

    @Query("SELECT * FROM user_stats WHERE userId = :userId LIMIT 1")
    suspend fun getUserStats(userId: String): UserStatsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUserStats(stats: UserStatsEntity)

    @Query("DELETE FROM user_stats WHERE userId = :userId")
    suspend fun deleteUserStats(userId: String)
}
