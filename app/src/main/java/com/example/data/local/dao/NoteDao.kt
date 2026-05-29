package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes WHERE userId = :userId ORDER BY updatedAt DESC")
    fun getAllNotes(userId: String): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE userId = :userId AND categoryId = :categoryId ORDER BY updatedAt DESC")
    fun getNotesByCategory(userId: String, categoryId: Int): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE userId = :userId AND linkedDate >= :startOfDay AND linkedDate <= :endOfDay ORDER BY updatedAt DESC")
    fun getNotesForDate(userId: String, startOfDay: Long, endOfDay: Long): Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity): Long

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun deleteNoteById(id: Int)
}
