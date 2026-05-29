package com.example.data.local.dao;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.example.data.local.entity.CategoryEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u0012H\u0016J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"},
   d2 = {"Lcom/example/data/local/dao/CategoryDao_Impl;", "Lcom/example/data/local/dao/CategoryDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfCategoryEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/local/entity/CategoryEntity;", "__updateAdapterOfCategoryEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "insertCategory", "", "category", "(Lcom/example/data/local/entity/CategoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCategory", "", "getAllCategories", "Lkotlinx/coroutines/flow/Flow;", "", "deleteCategoryById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class CategoryDao_Impl implements CategoryDao {
   @NotNull
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   @NotNull
   private final RoomDatabase __db;
   @NotNull
   private final EntityInsertAdapter __insertAdapterOfCategoryEntity;
   @NotNull
   private final EntityDeleteOrUpdateAdapter __updateAdapterOfCategoryEntity;
   public static final int $stable = 8;

   public CategoryDao_Impl(@NotNull RoomDatabase __db) {
      Intrinsics.checkNotNullParameter(__db, "__db");
      super();
      this.__db = __db;
      this.__insertAdapterOfCategoryEntity = new EntityInsertAdapter() {
         protected String createQuery() {
            return "INSERT OR REPLACE INTO `categories` (`id`,`name`,`colorHex`) VALUES (nullif(?, 0),?,?)";
         }

         protected void bind(SQLiteStatement statement, CategoryEntity entity) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            Intrinsics.checkNotNullParameter(entity, "entity");
            statement.bindLong(1, (long)entity.getId());
            statement.bindText(2, entity.getName());
            statement.bindText(3, entity.getColorHex());
         }
      };
      this.__updateAdapterOfCategoryEntity = new EntityDeleteOrUpdateAdapter() {
         protected String createQuery() {
            return "UPDATE OR ABORT `categories` SET `id` = ?,`name` = ?,`colorHex` = ? WHERE `id` = ?";
         }

         protected void bind(SQLiteStatement statement, CategoryEntity entity) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            Intrinsics.checkNotNullParameter(entity, "entity");
            statement.bindLong(1, (long)entity.getId());
            statement.bindText(2, entity.getName());
            statement.bindText(3, entity.getColorHex());
            statement.bindLong(4, (long)entity.getId());
         }
      };
   }

   @Nullable
   public Object insertCategory(@NotNull CategoryEntity category, @NotNull Continuation $completion) {
      return DBUtil.performSuspending(this.__db, false, true, CategoryDao_Impl::insertCategory$lambda$0, $completion);
   }

   @Nullable
   public Object updateCategory(@NotNull CategoryEntity category, @NotNull Continuation $completion) {
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, CategoryDao_Impl::updateCategory$lambda$1, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @NotNull
   public Flow getAllCategories() {
      String _sql = "SELECT * FROM categories ORDER BY name ASC";
      RoomDatabase var10000 = this.__db;
      String[] var2 = new String[]{"categories"};
      return FlowUtil.createFlow(var10000, false, var2, CategoryDao_Impl::getAllCategories$lambda$2);
   }

   @Nullable
   public Object deleteCategoryById(int id, @NotNull Continuation $completion) {
      String _sql = "DELETE FROM categories WHERE id = ?";
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, CategoryDao_Impl::deleteCategoryById$lambda$3, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   private static final long insertCategory$lambda$0(CategoryDao_Impl this$0, CategoryEntity $category, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      long _result = this$0.__insertAdapterOfCategoryEntity.insertAndReturnId(_connection, $category);
      return _result;
   }

   private static final Unit updateCategory$lambda$1(CategoryDao_Impl this$0, CategoryEntity $category, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      this$0.__updateAdapterOfCategoryEntity.handle(_connection, $category);
      return Unit.INSTANCE;
   }

   private static final List getAllCategories$lambda$2(String $_sql, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      List var13;
      try {
         int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
         int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
         int _columnIndexOfColorHex = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "colorHex");
         List _result = (List)(new ArrayList());

         while(_stmt.step()) {
            CategoryEntity _item = null;
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpName = null;
            _tmpName = _stmt.getText(_columnIndexOfName);
            String _tmpColorHex = null;
            _tmpColorHex = _stmt.getText(_columnIndexOfColorHex);
            _item = new CategoryEntity(_tmpId, _tmpName, _tmpColorHex);
            _result.add(_item);
         }

         var13 = _result;
      } finally {
         _stmt.close();
      }

      return var13;
   }

   private static final Unit deleteCategoryById$lambda$3(String $_sql, int $id, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      try {
         int _argIndex = 1;
         _stmt.bindLong(_argIndex, (long)$id);
         _stmt.step();
      } finally {
         _stmt.close();
      }

      return Unit.INSTANCE;
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"},
      d2 = {"Lcom/example/data/local/dao/CategoryDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final List getRequiredConverters() {
         return CollectionsKt.emptyList();
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
