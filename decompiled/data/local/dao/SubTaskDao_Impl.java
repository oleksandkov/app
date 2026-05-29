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
import com.example.data.local.entity.SubTaskEntity;
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
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J$\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u001bJ&\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"},
   d2 = {"Lcom/example/data/local/dao/SubTaskDao_Impl;", "Lcom/example/data/local/dao/SubTaskDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfSubTaskEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/local/entity/SubTaskEntity;", "__deleteAdapterOfSubTaskEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfSubTaskEntity", "insertSubTask", "", "subTask", "(Lcom/example/data/local/entity/SubTaskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSubTask", "", "updateSubTask", "getAllSubTasksFlow", "Lkotlinx/coroutines/flow/Flow;", "", "userId", "", "getSubTasksForParentFlow", "parentIdStr", "getSubTasksForParent", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSubTasksForParent", "softDeleteSubTask", "id", "", "deletedAt", "updatedAt", "(IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class SubTaskDao_Impl implements SubTaskDao {
   @NotNull
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   @NotNull
   private final RoomDatabase __db;
   @NotNull
   private final EntityInsertAdapter __insertAdapterOfSubTaskEntity;
   @NotNull
   private final EntityDeleteOrUpdateAdapter __deleteAdapterOfSubTaskEntity;
   @NotNull
   private final EntityDeleteOrUpdateAdapter __updateAdapterOfSubTaskEntity;
   public static final int $stable = 8;

   public SubTaskDao_Impl(@NotNull RoomDatabase __db) {
      Intrinsics.checkNotNullParameter(__db, "__db");
      super();
      this.__db = __db;
      this.__insertAdapterOfSubTaskEntity = new EntityInsertAdapter() {
         protected String createQuery() {
            return "INSERT OR REPLACE INTO `subtasks` (`id`,`userId`,`parentIdStr`,`title`,`startTime`,`endTime`,`isCompleted`,`updatedAt`,`deletedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
         }

         protected void bind(SQLiteStatement statement, SubTaskEntity entity) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            Intrinsics.checkNotNullParameter(entity, "entity");
            statement.bindLong(1, (long)entity.getId());
            statement.bindText(2, entity.getUserId());
            statement.bindText(3, entity.getParentIdStr());
            statement.bindText(4, entity.getTitle());
            Long _tmpStartTime = entity.getStartTime();
            if (_tmpStartTime == null) {
               statement.bindNull(5);
            } else {
               statement.bindLong(5, _tmpStartTime);
            }

            Long _tmpEndTime = entity.getEndTime();
            if (_tmpEndTime == null) {
               statement.bindNull(6);
            } else {
               statement.bindLong(6, _tmpEndTime);
            }

            int _tmp = entity.isCompleted() ? 1 : 0;
            statement.bindLong(7, (long)_tmp);
            statement.bindLong(8, entity.getUpdatedAt());
            Long _tmpDeletedAt = entity.getDeletedAt();
            if (_tmpDeletedAt == null) {
               statement.bindNull(9);
            } else {
               statement.bindLong(9, _tmpDeletedAt);
            }

         }
      };
      this.__deleteAdapterOfSubTaskEntity = new EntityDeleteOrUpdateAdapter() {
         protected String createQuery() {
            return "DELETE FROM `subtasks` WHERE `id` = ?";
         }

         protected void bind(SQLiteStatement statement, SubTaskEntity entity) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            Intrinsics.checkNotNullParameter(entity, "entity");
            statement.bindLong(1, (long)entity.getId());
         }
      };
      this.__updateAdapterOfSubTaskEntity = new EntityDeleteOrUpdateAdapter() {
         protected String createQuery() {
            return "UPDATE OR ABORT `subtasks` SET `id` = ?,`userId` = ?,`parentIdStr` = ?,`title` = ?,`startTime` = ?,`endTime` = ?,`isCompleted` = ?,`updatedAt` = ?,`deletedAt` = ? WHERE `id` = ?";
         }

         protected void bind(SQLiteStatement statement, SubTaskEntity entity) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            Intrinsics.checkNotNullParameter(entity, "entity");
            statement.bindLong(1, (long)entity.getId());
            statement.bindText(2, entity.getUserId());
            statement.bindText(3, entity.getParentIdStr());
            statement.bindText(4, entity.getTitle());
            Long _tmpStartTime = entity.getStartTime();
            if (_tmpStartTime == null) {
               statement.bindNull(5);
            } else {
               statement.bindLong(5, _tmpStartTime);
            }

            Long _tmpEndTime = entity.getEndTime();
            if (_tmpEndTime == null) {
               statement.bindNull(6);
            } else {
               statement.bindLong(6, _tmpEndTime);
            }

            int _tmp = entity.isCompleted() ? 1 : 0;
            statement.bindLong(7, (long)_tmp);
            statement.bindLong(8, entity.getUpdatedAt());
            Long _tmpDeletedAt = entity.getDeletedAt();
            if (_tmpDeletedAt == null) {
               statement.bindNull(9);
            } else {
               statement.bindLong(9, _tmpDeletedAt);
            }

            statement.bindLong(10, (long)entity.getId());
         }
      };
   }

   @Nullable
   public Object insertSubTask(@NotNull SubTaskEntity subTask, @NotNull Continuation $completion) {
      return DBUtil.performSuspending(this.__db, false, true, SubTaskDao_Impl::insertSubTask$lambda$0, $completion);
   }

   @Nullable
   public Object deleteSubTask(@NotNull SubTaskEntity subTask, @NotNull Continuation $completion) {
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, SubTaskDao_Impl::deleteSubTask$lambda$1, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public Object updateSubTask(@NotNull SubTaskEntity subTask, @NotNull Continuation $completion) {
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, SubTaskDao_Impl::updateSubTask$lambda$2, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @NotNull
   public Flow getAllSubTasksFlow(@NotNull String userId) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      String _sql = "SELECT * FROM subtasks WHERE userId = ? AND deletedAt IS NULL";
      RoomDatabase var10000 = this.__db;
      String[] var3 = new String[]{"subtasks"};
      return FlowUtil.createFlow(var10000, false, var3, SubTaskDao_Impl::getAllSubTasksFlow$lambda$3);
   }

   @NotNull
   public Flow getSubTasksForParentFlow(@NotNull String userId, @NotNull String parentIdStr) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      Intrinsics.checkNotNullParameter(parentIdStr, "parentIdStr");
      String _sql = "SELECT * FROM subtasks WHERE userId = ? AND parentIdStr = ? AND deletedAt IS NULL";
      RoomDatabase var10000 = this.__db;
      String[] var4 = new String[]{"subtasks"};
      return FlowUtil.createFlow(var10000, false, var4, SubTaskDao_Impl::getSubTasksForParentFlow$lambda$4);
   }

   @Nullable
   public Object getSubTasksForParent(@NotNull String parentIdStr, @NotNull Continuation $completion) {
      String _sql = "SELECT * FROM subtasks WHERE parentIdStr = ? AND deletedAt IS NULL";
      return DBUtil.performSuspending(this.__db, true, false, SubTaskDao_Impl::getSubTasksForParent$lambda$5, $completion);
   }

   @Nullable
   public Object deleteSubTasksForParent(@NotNull String parentIdStr, @NotNull Continuation $completion) {
      String _sql = "DELETE FROM subtasks WHERE parentIdStr = ?";
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, SubTaskDao_Impl::deleteSubTasksForParent$lambda$6, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public Object softDeleteSubTask(int id, long deletedAt, long updatedAt, @NotNull Continuation $completion) {
      String _sql = "UPDATE subtasks SET deletedAt = ?, updatedAt = ? WHERE id = ?";
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, SubTaskDao_Impl::softDeleteSubTask$lambda$7, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   private static final long insertSubTask$lambda$0(SubTaskDao_Impl this$0, SubTaskEntity $subTask, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      long _result = this$0.__insertAdapterOfSubTaskEntity.insertAndReturnId(_connection, $subTask);
      return _result;
   }

   private static final Unit deleteSubTask$lambda$1(SubTaskDao_Impl this$0, SubTaskEntity $subTask, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      this$0.__deleteAdapterOfSubTaskEntity.handle(_connection, $subTask);
      return Unit.INSTANCE;
   }

   private static final Unit updateSubTask$lambda$2(SubTaskDao_Impl this$0, SubTaskEntity $subTask, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      this$0.__updateAdapterOfSubTaskEntity.handle(_connection, $subTask);
      return Unit.INSTANCE;
   }

   private static final List getAllSubTasksFlow$lambda$3(String $_sql, String $userId, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      List var29;
      try {
         int _argIndex = 1;
         _stmt.bindText(_argIndex, $userId);
         int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
         int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
         int _columnIndexOfParentIdStr = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "parentIdStr");
         int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
         int _columnIndexOfStartTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "startTime");
         int _columnIndexOfEndTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "endTime");
         int _columnIndexOfIsCompleted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isCompleted");
         int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
         int _columnIndexOfDeletedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "deletedAt");
         List _result = (List)(new ArrayList());

         while(_stmt.step()) {
            SubTaskEntity _item = null;
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpUserId = null;
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
            String _tmpParentIdStr = null;
            _tmpParentIdStr = _stmt.getText(_columnIndexOfParentIdStr);
            String _tmpTitle = null;
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
            Long _tmpStartTime = null;
            if (_stmt.isNull(_columnIndexOfStartTime)) {
               _tmpStartTime = null;
            } else {
               _tmpStartTime = _stmt.getLong(_columnIndexOfStartTime);
            }

            Long _tmpEndTime = null;
            if (_stmt.isNull(_columnIndexOfEndTime)) {
               _tmpEndTime = null;
            } else {
               _tmpEndTime = _stmt.getLong(_columnIndexOfEndTime);
            }

            boolean _tmpIsCompleted = false;
            int _tmp = 0;
            _tmp = (int)_stmt.getLong(_columnIndexOfIsCompleted);
            _tmpIsCompleted = _tmp != 0;
            long _tmpUpdatedAt = 0L;
            _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
            Long _tmpDeletedAt = null;
            if (_stmt.isNull(_columnIndexOfDeletedAt)) {
               _tmpDeletedAt = null;
            } else {
               _tmpDeletedAt = _stmt.getLong(_columnIndexOfDeletedAt);
            }

            _item = new SubTaskEntity(_tmpId, _tmpUserId, _tmpParentIdStr, _tmpTitle, _tmpStartTime, _tmpEndTime, _tmpIsCompleted, _tmpUpdatedAt, _tmpDeletedAt);
            _result.add(_item);
         }

         var29 = _result;
      } finally {
         _stmt.close();
      }

      return var29;
   }

   private static final List getSubTasksForParentFlow$lambda$4(String $_sql, String $userId, String $parentIdStr, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      List var31;
      try {
         int _argIndex = 1;
         _stmt.bindText(_argIndex, $userId);
         _argIndex = 2;
         _stmt.bindText(_argIndex, $parentIdStr);
         int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
         int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
         int _columnIndexOfParentIdStr = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "parentIdStr");
         int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
         int _columnIndexOfStartTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "startTime");
         int _columnIndexOfEndTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "endTime");
         int _columnIndexOfIsCompleted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isCompleted");
         int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
         int _columnIndexOfDeletedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "deletedAt");
         List _result = (List)(new ArrayList());

         while(_stmt.step()) {
            SubTaskEntity _item = null;
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpUserId = null;
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
            String _tmpParentIdStr = null;
            _tmpParentIdStr = _stmt.getText(_columnIndexOfParentIdStr);
            String _tmpTitle = null;
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
            Long _tmpStartTime = null;
            if (_stmt.isNull(_columnIndexOfStartTime)) {
               _tmpStartTime = null;
            } else {
               _tmpStartTime = _stmt.getLong(_columnIndexOfStartTime);
            }

            Long _tmpEndTime = null;
            if (_stmt.isNull(_columnIndexOfEndTime)) {
               _tmpEndTime = null;
            } else {
               _tmpEndTime = _stmt.getLong(_columnIndexOfEndTime);
            }

            boolean _tmpIsCompleted = false;
            int _tmp = 0;
            _tmp = (int)_stmt.getLong(_columnIndexOfIsCompleted);
            _tmpIsCompleted = _tmp != 0;
            long _tmpUpdatedAt = 0L;
            _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
            Long _tmpDeletedAt = null;
            if (_stmt.isNull(_columnIndexOfDeletedAt)) {
               _tmpDeletedAt = null;
            } else {
               _tmpDeletedAt = _stmt.getLong(_columnIndexOfDeletedAt);
            }

            _item = new SubTaskEntity(_tmpId, _tmpUserId, _tmpParentIdStr, _tmpTitle, _tmpStartTime, _tmpEndTime, _tmpIsCompleted, _tmpUpdatedAt, _tmpDeletedAt);
            _result.add(_item);
         }

         var31 = _result;
      } finally {
         _stmt.close();
      }

      return var31;
   }

   private static final List getSubTasksForParent$lambda$5(String $_sql, String $parentIdStr, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      List var29;
      try {
         int _argIndex = 1;
         _stmt.bindText(_argIndex, $parentIdStr);
         int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
         int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
         int _columnIndexOfParentIdStr = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "parentIdStr");
         int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
         int _columnIndexOfStartTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "startTime");
         int _columnIndexOfEndTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "endTime");
         int _columnIndexOfIsCompleted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isCompleted");
         int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
         int _columnIndexOfDeletedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "deletedAt");
         List _result = (List)(new ArrayList());

         while(_stmt.step()) {
            SubTaskEntity _item = null;
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpUserId = null;
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
            String _tmpParentIdStr = null;
            _tmpParentIdStr = _stmt.getText(_columnIndexOfParentIdStr);
            String _tmpTitle = null;
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
            Long _tmpStartTime = null;
            if (_stmt.isNull(_columnIndexOfStartTime)) {
               _tmpStartTime = null;
            } else {
               _tmpStartTime = _stmt.getLong(_columnIndexOfStartTime);
            }

            Long _tmpEndTime = null;
            if (_stmt.isNull(_columnIndexOfEndTime)) {
               _tmpEndTime = null;
            } else {
               _tmpEndTime = _stmt.getLong(_columnIndexOfEndTime);
            }

            boolean _tmpIsCompleted = false;
            int _tmp = 0;
            _tmp = (int)_stmt.getLong(_columnIndexOfIsCompleted);
            _tmpIsCompleted = _tmp != 0;
            long _tmpUpdatedAt = 0L;
            _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
            Long _tmpDeletedAt = null;
            if (_stmt.isNull(_columnIndexOfDeletedAt)) {
               _tmpDeletedAt = null;
            } else {
               _tmpDeletedAt = _stmt.getLong(_columnIndexOfDeletedAt);
            }

            _item = new SubTaskEntity(_tmpId, _tmpUserId, _tmpParentIdStr, _tmpTitle, _tmpStartTime, _tmpEndTime, _tmpIsCompleted, _tmpUpdatedAt, _tmpDeletedAt);
            _result.add(_item);
         }

         var29 = _result;
      } finally {
         _stmt.close();
      }

      return var29;
   }

   private static final Unit deleteSubTasksForParent$lambda$6(String $_sql, String $parentIdStr, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      try {
         int _argIndex = 1;
         _stmt.bindText(_argIndex, $parentIdStr);
         _stmt.step();
      } finally {
         _stmt.close();
      }

      return Unit.INSTANCE;
   }

   private static final Unit softDeleteSubTask$lambda$7(String $_sql, long $deletedAt, long $updatedAt, int $id, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      try {
         int _argIndex = 1;
         _stmt.bindLong(_argIndex, $deletedAt);
         _argIndex = 2;
         _stmt.bindLong(_argIndex, $updatedAt);
         _argIndex = 3;
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
      d2 = {"Lcom/example/data/local/dao/SubTaskDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}
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
