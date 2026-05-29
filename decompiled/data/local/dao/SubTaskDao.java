package com.example.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.data.local.entity.SubTaskEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J$\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H'J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u000bJ*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\rH§@¢\u0006\u0002\u0010\u0019¨\u0006\u001aÀ\u0006\u0003"},
   d2 = {"Lcom/example/data/local/dao/SubTaskDao;", "", "getAllSubTasksFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/local/entity/SubTaskEntity;", "userId", "", "getSubTasksForParentFlow", "parentIdStr", "getSubTasksForParent", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSubTask", "", "subTask", "(Lcom/example/data/local/entity/SubTaskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubTask", "", "deleteSubTask", "deleteSubTasksForParent", "softDeleteSubTask", "id", "", "deletedAt", "updatedAt", "(IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}
)
@Dao
public interface SubTaskDao {
   @Query("SELECT * FROM subtasks WHERE userId = :userId AND deletedAt IS NULL")
   @NotNull
   Flow getAllSubTasksFlow(@NotNull String var1);

   @Query("SELECT * FROM subtasks WHERE userId = :userId AND parentIdStr = :parentIdStr AND deletedAt IS NULL")
   @NotNull
   Flow getSubTasksForParentFlow(@NotNull String var1, @NotNull String var2);

   @Query("SELECT * FROM subtasks WHERE parentIdStr = :parentIdStr AND deletedAt IS NULL")
   @Nullable
   Object getSubTasksForParent(@NotNull String var1, @NotNull Continuation var2);

   @Insert(
      onConflict = 1
   )
   @Nullable
   Object insertSubTask(@NotNull SubTaskEntity var1, @NotNull Continuation var2);

   @Update
   @Nullable
   Object updateSubTask(@NotNull SubTaskEntity var1, @NotNull Continuation var2);

   @Delete
   @Nullable
   Object deleteSubTask(@NotNull SubTaskEntity var1, @NotNull Continuation var2);

   @Query("DELETE FROM subtasks WHERE parentIdStr = :parentIdStr")
   @Nullable
   Object deleteSubTasksForParent(@NotNull String var1, @NotNull Continuation var2);

   @Query("UPDATE subtasks SET deletedAt = :deletedAt, updatedAt = :updatedAt WHERE id = :id")
   @Nullable
   Object softDeleteSubTask(int var1, long var2, long var4, @NotNull Continuation var6);

   // $FF: synthetic method
   static Object softDeleteSubTask$default(SubTaskDao var0, int var1, long var2, long var4, Continuation var6, int var7, Object var8) {
      if (var8 != null) {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: softDeleteSubTask");
      } else {
         if ((var7 & 2) != 0) {
            var2 = System.currentTimeMillis();
         }

         if ((var7 & 4) != 0) {
            var4 = System.currentTimeMillis();
         }

         return var0.softDeleteSubTask(var1, var2, var4, var6);
      }
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 3,
      xi = 48
   )
   public static final class DefaultImpls {
      // $FF: synthetic method
      public static Object softDeleteSubTask$default(SubTaskDao var0, int var1, long var2, long var4, Continuation var6, int var7, Object var8) {
         return SubTaskDao.softDeleteSubTask$default(var0, var1, var2, var4, var6, var7, var8);
      }
   }
}
