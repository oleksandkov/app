package com.example.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.data.local.entity.NoteEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J$\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH'J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\nH§@¢\u0006\u0002\u0010\u0013J,\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH'J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H'J*\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH§@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH§@¢\u0006\u0002\u0010\u0013¨\u0006\u001eÀ\u0006\u0003"},
   d2 = {"Lcom/example/data/local/dao/NoteDao;", "", "getAllNotes", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/local/entity/NoteEntity;", "userId", "", "getNotesByCategory", "categoryId", "", "insertNote", "", "note", "(Lcom/example/data/local/entity/NoteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNote", "", "getNoteById", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotesForDate", "startOfDay", "endOfDay", "getNotesForMeeting", "meetingId", "softDeleteNoteById", "deletedAt", "updatedAt", "(IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNoteById", "app"}
)
@Dao
public interface NoteDao {
   @Query("SELECT * FROM notes WHERE userId = :userId AND deletedAt IS NULL ORDER BY updatedAt DESC")
   @NotNull
   Flow getAllNotes(@NotNull String var1);

   @Query("SELECT * FROM notes WHERE userId = :userId AND categoryId = :categoryId AND deletedAt IS NULL ORDER BY updatedAt DESC")
   @NotNull
   Flow getNotesByCategory(@NotNull String var1, int var2);

   @Insert(
      onConflict = 1
   )
   @Nullable
   Object insertNote(@NotNull NoteEntity var1, @NotNull Continuation var2);

   @Update
   @Nullable
   Object updateNote(@NotNull NoteEntity var1, @NotNull Continuation var2);

   @Query("SELECT * FROM notes WHERE id = :id AND deletedAt IS NULL")
   @Nullable
   Object getNoteById(int var1, @NotNull Continuation var2);

   @Query("SELECT * FROM notes WHERE userId = :userId AND linkedDate >= :startOfDay AND linkedDate <= :endOfDay AND deletedAt IS NULL ORDER BY updatedAt DESC")
   @NotNull
   Flow getNotesForDate(@NotNull String var1, long var2, long var4);

   @Query("SELECT * FROM notes WHERE userId = :userId AND linkedMeetingId = :meetingId AND deletedAt IS NULL ORDER BY updatedAt DESC")
   @NotNull
   Flow getNotesForMeeting(@NotNull String var1, @NotNull String var2);

   @Query("UPDATE notes SET deletedAt = :deletedAt, updatedAt = :updatedAt WHERE id = :id")
   @Nullable
   Object softDeleteNoteById(int var1, long var2, long var4, @NotNull Continuation var6);

   // $FF: synthetic method
   static Object softDeleteNoteById$default(NoteDao var0, int var1, long var2, long var4, Continuation var6, int var7, Object var8) {
      if (var8 != null) {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: softDeleteNoteById");
      } else {
         if ((var7 & 2) != 0) {
            var2 = System.currentTimeMillis();
         }

         if ((var7 & 4) != 0) {
            var4 = System.currentTimeMillis();
         }

         return var0.softDeleteNoteById(var1, var2, var4, var6);
      }
   }

   @Query("DELETE FROM notes WHERE id = :id")
   @Nullable
   Object deleteNoteById(int var1, @NotNull Continuation var2);

   @Metadata(
      mv = {2, 2, 0},
      k = 3,
      xi = 48
   )
   public static final class DefaultImpls {
      // $FF: synthetic method
      public static Object softDeleteNoteById$default(NoteDao var0, int var1, long var2, long var4, Continuation var6, int var7, Object var8) {
         return NoteDao.softDeleteNoteById$default(var0, var1, var2, var4, var6, var7, var8);
      }
   }
}
