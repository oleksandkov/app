package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.local.entity.SubTaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SubTaskDao {
    @Query("SELECT * FROM subtasks WHERE userId = :userId AND parentIdStr = :parentIdStr ORDER BY id ASC")
    suspend fun getSubTasksForParent(userId: String, parentIdStr: String): List<SubTaskEntity>

    @Query("SELECT * FROM subtasks WHERE userId = :userId AND parentIdStr = :parentIdStr ORDER BY id ASC")
    fun getSubTasksForParentFlow(userId: String, parentIdStr: String): Flow<List<SubTaskEntity>>

    @Query("SELECT * FROM subtasks WHERE userId = :userId ORDER BY id ASC")
    fun getAllSubTasks(userId: String): Flow<List<SubTaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubTask(subTask: SubTaskEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubTasks(subTasks: List<SubTaskEntity>)

    @Update
    suspend fun updateSubTask(subTask: SubTaskEntity)

    @Delete
    suspend fun deleteSubTask(subTask: SubTaskEntity)

    @Query("DELETE FROM subtasks WHERE userId = :userId AND parentIdStr = :parentIdStr")
    suspend fun deleteSubTasksByParent(userId: String, parentIdStr: String)
}
