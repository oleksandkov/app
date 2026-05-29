package com.example.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.data.local.entity.CategoryEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\tJ\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"},
   d2 = {"Lcom/example/data/local/dao/CategoryDao;", "", "getAllCategories", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/local/entity/CategoryEntity;", "insertCategory", "", "category", "(Lcom/example/data/local/entity/CategoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCategory", "", "deleteCategoryById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}
)
@Dao
public interface CategoryDao {
   @Query("SELECT * FROM categories ORDER BY name ASC")
   @NotNull
   Flow getAllCategories();

   @Insert(
      onConflict = 1
   )
   @Nullable
   Object insertCategory(@NotNull CategoryEntity var1, @NotNull Continuation var2);

   @Update
   @Nullable
   Object updateCategory(@NotNull CategoryEntity var1, @NotNull Continuation var2);

   @Query("DELETE FROM categories WHERE id = :id")
   @Nullable
   Object deleteCategoryById(int var1, @NotNull Continuation var2);
}
