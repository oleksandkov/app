package com.example.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.data.local.entity.TaskEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH'J\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\rJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J*\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013¨\u0006\u001aÀ\u0006\u0003"},
   d2 = {"Lcom/example/data/local/dao/TaskDao;", "", "getTasksForDate", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/local/entity/TaskEntity;", "userId", "", "startOfDay", "", "endOfDay", "insertTask", "task", "(Lcom/example/data/local/entity/TaskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "", "getTaskById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTasks", "softDeleteTaskById", "deletedAt", "updatedAt", "(IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTaskById", "app"}
)
@Dao
public interface TaskDao {
   @Query("SELECT * FROM tasks WHERE userId = :userId AND deletedAt IS NULL AND ((date >= :startOfDay AND date <= :endOfDay) OR date = 0) ORDER BY date ASC, startTime ASC")
   @NotNull
   Flow getTasksForDate(@NotNull String var1, long var2, long var4);

   @Insert(
      onConflict = 1
   )
   @Nullable
   Object insertTask(@NotNull TaskEntity var1, @NotNull Continuation var2);

   @Update
   @Nullable
   Object updateTask(@NotNull TaskEntity var1, @NotNull Continuation var2);

   @Query("SELECT * FROM tasks WHERE id = :id AND deletedAt IS NULL")
   @Nullable
   Object getTaskById(int var1, @NotNull Continuation var2);

   @Query("SELECT * FROM tasks WHERE userId = :userId AND deletedAt IS NULL ORDER BY date ASC, startTime ASC")
   @NotNull
   Flow getAllTasks(@NotNull String var1);

   @Query("UPDATE tasks SET deletedAt = :deletedAt, updatedAt = :updatedAt WHERE id = :id")
   @Nullable
   Object softDeleteTaskById(int var1, long var2, long var4, @NotNull Continuation var6);

   // $FF: synthetic method
   static Object softDeleteTaskById$default(TaskDao var0, int var1, long var2, long var4, Continuation var6, int var7, Object var8) {
      if (var8 != null) {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: softDeleteTaskById");
      } else {
         if ((var7 & 2) != 0) {
            var2 = System.currentTimeMillis();
         }

         if ((var7 & 4) != 0) {
            var4 = System.currentTimeMillis();
         }

         return var0.softDeleteTaskById(var1, var2, var4, var6);
      }
   }

   @Query("DELETE FROM tasks WHERE id = :id")
   @Nullable
   Object deleteTaskById(int var1, @NotNull Continuation var2);

   @Metadata(
      mv = {2, 2, 0},
      k = 3,
      xi = 48
   )
   public static final class DefaultImpls {
      // $FF: synthetic method
      public static Object softDeleteTaskById$default(TaskDao var0, int var1, long var2, long var4, Continuation var6, int var7, Object var8) {
         return TaskDao.softDeleteTaskById$default(var0, var1, var2, var4, var6, var7, var8);
      }
   }
}
