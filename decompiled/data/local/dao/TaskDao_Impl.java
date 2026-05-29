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
import com.example.data.local.entity.TaskEntity;
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
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ,\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"},
   d2 = {"Lcom/example/data/local/dao/TaskDao_Impl;", "Lcom/example/data/local/dao/TaskDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfTaskEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/local/entity/TaskEntity;", "__updateAdapterOfTaskEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "insertTask", "", "task", "(Lcom/example/data/local/entity/TaskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "", "getTasksForDate", "Lkotlinx/coroutines/flow/Flow;", "", "userId", "", "startOfDay", "endOfDay", "getTaskById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTasks", "softDeleteTaskById", "deletedAt", "updatedAt", "(IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTaskById", "Companion", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class TaskDao_Impl implements TaskDao {
   @NotNull
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   @NotNull
   private final RoomDatabase __db;
   @NotNull
   private final EntityInsertAdapter __insertAdapterOfTaskEntity;
   @NotNull
   private final EntityDeleteOrUpdateAdapter __updateAdapterOfTaskEntity;
   public static final int $stable = 8;

   public TaskDao_Impl(@NotNull RoomDatabase __db) {
      Intrinsics.checkNotNullParameter(__db, "__db");
      super();
      this.__db = __db;
      this.__insertAdapterOfTaskEntity = new EntityInsertAdapter() {
         protected String createQuery() {
            return "INSERT OR REPLACE INTO `tasks` (`id`,`userId`,`title`,`description`,`date`,`startTime`,`endTime`,`isTimeBoxed`,`isCompleted`,`hasReminder`,`reminderTime`,`reminderMinutesBefore`,`externalCalendarEventId`,`isMeeting`,`updatedAt`,`deletedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         }

         protected void bind(SQLiteStatement statement, TaskEntity entity) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            Intrinsics.checkNotNullParameter(entity, "entity");
            statement.bindLong(1, (long)entity.getId());
            statement.bindText(2, entity.getUserId());
            statement.bindText(3, entity.getTitle());
            String _tmpDescription = entity.getDescription();
            if (_tmpDescription == null) {
               statement.bindNull(4);
            } else {
               statement.bindText(4, _tmpDescription);
            }

            statement.bindLong(5, entity.getDate());
            Long _tmpStartTime = entity.getStartTime();
            if (_tmpStartTime == null) {
               statement.bindNull(6);
            } else {
               statement.bindLong(6, _tmpStartTime);
            }

            Long _tmpEndTime = entity.getEndTime();
            if (_tmpEndTime == null) {
               statement.bindNull(7);
            } else {
               statement.bindLong(7, _tmpEndTime);
            }

            int _tmp = entity.isTimeBoxed() ? 1 : 0;
            statement.bindLong(8, (long)_tmp);
            int _tmp_1 = entity.isCompleted() ? 1 : 0;
            statement.bindLong(9, (long)_tmp_1);
            int _tmp_2 = entity.getHasReminder() ? 1 : 0;
            statement.bindLong(10, (long)_tmp_2);
            Long _tmpReminderTime = entity.getReminderTime();
            if (_tmpReminderTime == null) {
               statement.bindNull(11);
            } else {
               statement.bindLong(11, _tmpReminderTime);
            }

            Integer _tmpReminderMinutesBefore = entity.getReminderMinutesBefore();
            if (_tmpReminderMinutesBefore == null) {
               statement.bindNull(12);
            } else {
               statement.bindLong(12, (long)_tmpReminderMinutesBefore);
            }

            String _tmpExternalCalendarEventId = entity.getExternalCalendarEventId();
            if (_tmpExternalCalendarEventId == null) {
               statement.bindNull(13);
            } else {
               statement.bindText(13, _tmpExternalCalendarEventId);
            }

            int _tmp_3 = entity.isMeeting() ? 1 : 0;
            statement.bindLong(14, (long)_tmp_3);
            statement.bindLong(15, entity.getUpdatedAt());
            Long _tmpDeletedAt = entity.getDeletedAt();
            if (_tmpDeletedAt == null) {
               statement.bindNull(16);
            } else {
               statement.bindLong(16, _tmpDeletedAt);
            }

         }
      };
      this.__updateAdapterOfTaskEntity = new EntityDeleteOrUpdateAdapter() {
         protected String createQuery() {
            return "UPDATE OR ABORT `tasks` SET `id` = ?,`userId` = ?,`title` = ?,`description` = ?,`date` = ?,`startTime` = ?,`endTime` = ?,`isTimeBoxed` = ?,`isCompleted` = ?,`hasReminder` = ?,`reminderTime` = ?,`reminderMinutesBefore` = ?,`externalCalendarEventId` = ?,`isMeeting` = ?,`updatedAt` = ?,`deletedAt` = ? WHERE `id` = ?";
         }

         protected void bind(SQLiteStatement statement, TaskEntity entity) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            Intrinsics.checkNotNullParameter(entity, "entity");
            statement.bindLong(1, (long)entity.getId());
            statement.bindText(2, entity.getUserId());
            statement.bindText(3, entity.getTitle());
            String _tmpDescription = entity.getDescription();
            if (_tmpDescription == null) {
               statement.bindNull(4);
            } else {
               statement.bindText(4, _tmpDescription);
            }

            statement.bindLong(5, entity.getDate());
            Long _tmpStartTime = entity.getStartTime();
            if (_tmpStartTime == null) {
               statement.bindNull(6);
            } else {
               statement.bindLong(6, _tmpStartTime);
            }

            Long _tmpEndTime = entity.getEndTime();
            if (_tmpEndTime == null) {
               statement.bindNull(7);
            } else {
               statement.bindLong(7, _tmpEndTime);
            }

            int _tmp = entity.isTimeBoxed() ? 1 : 0;
            statement.bindLong(8, (long)_tmp);
            int _tmp_1 = entity.isCompleted() ? 1 : 0;
            statement.bindLong(9, (long)_tmp_1);
            int _tmp_2 = entity.getHasReminder() ? 1 : 0;
            statement.bindLong(10, (long)_tmp_2);
            Long _tmpReminderTime = entity.getReminderTime();
            if (_tmpReminderTime == null) {
               statement.bindNull(11);
            } else {
               statement.bindLong(11, _tmpReminderTime);
            }

            Integer _tmpReminderMinutesBefore = entity.getReminderMinutesBefore();
            if (_tmpReminderMinutesBefore == null) {
               statement.bindNull(12);
            } else {
               statement.bindLong(12, (long)_tmpReminderMinutesBefore);
            }

            String _tmpExternalCalendarEventId = entity.getExternalCalendarEventId();
            if (_tmpExternalCalendarEventId == null) {
               statement.bindNull(13);
            } else {
               statement.bindText(13, _tmpExternalCalendarEventId);
            }

            int _tmp_3 = entity.isMeeting() ? 1 : 0;
            statement.bindLong(14, (long)_tmp_3);
            statement.bindLong(15, entity.getUpdatedAt());
            Long _tmpDeletedAt = entity.getDeletedAt();
            if (_tmpDeletedAt == null) {
               statement.bindNull(16);
            } else {
               statement.bindLong(16, _tmpDeletedAt);
            }

            statement.bindLong(17, (long)entity.getId());
         }
      };
   }

   @Nullable
   public Object insertTask(@NotNull TaskEntity task, @NotNull Continuation $completion) {
      return DBUtil.performSuspending(this.__db, false, true, TaskDao_Impl::insertTask$lambda$0, $completion);
   }

   @Nullable
   public Object updateTask(@NotNull TaskEntity task, @NotNull Continuation $completion) {
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, TaskDao_Impl::updateTask$lambda$1, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @NotNull
   public Flow getTasksForDate(@NotNull String userId, long startOfDay, long endOfDay) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      String _sql = "SELECT * FROM tasks WHERE userId = ? AND deletedAt IS NULL AND ((date >= ? AND date <= ?) OR date = 0) ORDER BY date ASC, startTime ASC";
      RoomDatabase var10000 = this.__db;
      String[] var7 = new String[]{"tasks"};
      return FlowUtil.createFlow(var10000, false, var7, TaskDao_Impl::getTasksForDate$lambda$2);
   }

   @Nullable
   public Object getTaskById(int id, @NotNull Continuation $completion) {
      String _sql = "SELECT * FROM tasks WHERE id = ? AND deletedAt IS NULL";
      return DBUtil.performSuspending(this.__db, true, false, TaskDao_Impl::getTaskById$lambda$3, $completion);
   }

   @NotNull
   public Flow getAllTasks(@NotNull String userId) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      String _sql = "SELECT * FROM tasks WHERE userId = ? AND deletedAt IS NULL ORDER BY date ASC, startTime ASC";
      RoomDatabase var10000 = this.__db;
      String[] var3 = new String[]{"tasks"};
      return FlowUtil.createFlow(var10000, false, var3, TaskDao_Impl::getAllTasks$lambda$4);
   }

   @Nullable
   public Object softDeleteTaskById(int id, long deletedAt, long updatedAt, @NotNull Continuation $completion) {
      String _sql = "UPDATE tasks SET deletedAt = ?, updatedAt = ? WHERE id = ?";
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, TaskDao_Impl::softDeleteTaskById$lambda$5, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public Object deleteTaskById(int id, @NotNull Continuation $completion) {
      String _sql = "DELETE FROM tasks WHERE id = ?";
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, TaskDao_Impl::deleteTaskById$lambda$6, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   private static final long insertTask$lambda$0(TaskDao_Impl this$0, TaskEntity $task, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      long _result = this$0.__insertAdapterOfTaskEntity.insertAndReturnId(_connection, $task);
      return _result;
   }

   private static final Unit updateTask$lambda$1(TaskDao_Impl this$0, TaskEntity $task, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      this$0.__updateAdapterOfTaskEntity.handle(_connection, $task);
      return Unit.INSTANCE;
   }

   private static final List getTasksForDate$lambda$2(String $_sql, String $userId, long $startOfDay, long $endOfDay, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      List var53;
      try {
         int _argIndex = 1;
         _stmt.bindText(_argIndex, $userId);
         _argIndex = 2;
         _stmt.bindLong(_argIndex, $startOfDay);
         _argIndex = 3;
         _stmt.bindLong(_argIndex, $endOfDay);
         int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
         int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
         int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
         int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
         int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
         int _columnIndexOfStartTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "startTime");
         int _columnIndexOfEndTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "endTime");
         int _columnIndexOfIsTimeBoxed = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isTimeBoxed");
         int _columnIndexOfIsCompleted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isCompleted");
         int _columnIndexOfHasReminder = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hasReminder");
         int _columnIndexOfReminderTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderTime");
         int _columnIndexOfReminderMinutesBefore = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderMinutesBefore");
         int _columnIndexOfExternalCalendarEventId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "externalCalendarEventId");
         int _columnIndexOfIsMeeting = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isMeeting");
         int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
         int _columnIndexOfDeletedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "deletedAt");
         List _result = (List)(new ArrayList());

         while(_stmt.step()) {
            TaskEntity _item = null;
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpUserId = null;
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
            String _tmpTitle = null;
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
            String _tmpDescription = null;
            if (_stmt.isNull(_columnIndexOfDescription)) {
               _tmpDescription = null;
            } else {
               _tmpDescription = _stmt.getText(_columnIndexOfDescription);
            }

            long _tmpDate = 0L;
            _tmpDate = _stmt.getLong(_columnIndexOfDate);
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

            boolean _tmpIsTimeBoxed = false;
            int _tmp = 0;
            _tmp = (int)_stmt.getLong(_columnIndexOfIsTimeBoxed);
            _tmpIsTimeBoxed = _tmp != 0;
            boolean _tmpIsCompleted = false;
            int _tmp_1 = 0;
            _tmp_1 = (int)_stmt.getLong(_columnIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_1 != 0;
            boolean _tmpHasReminder = false;
            int _tmp_2 = 0;
            _tmp_2 = (int)_stmt.getLong(_columnIndexOfHasReminder);
            _tmpHasReminder = _tmp_2 != 0;
            Long _tmpReminderTime = null;
            if (_stmt.isNull(_columnIndexOfReminderTime)) {
               _tmpReminderTime = null;
            } else {
               _tmpReminderTime = _stmt.getLong(_columnIndexOfReminderTime);
            }

            Integer _tmpReminderMinutesBefore = null;
            if (_stmt.isNull(_columnIndexOfReminderMinutesBefore)) {
               _tmpReminderMinutesBefore = null;
            } else {
               _tmpReminderMinutesBefore = (int)_stmt.getLong(_columnIndexOfReminderMinutesBefore);
            }

            String _tmpExternalCalendarEventId = null;
            if (_stmt.isNull(_columnIndexOfExternalCalendarEventId)) {
               _tmpExternalCalendarEventId = null;
            } else {
               _tmpExternalCalendarEventId = _stmt.getText(_columnIndexOfExternalCalendarEventId);
            }

            boolean _tmpIsMeeting = false;
            int _tmp_3 = 0;
            _tmp_3 = (int)_stmt.getLong(_columnIndexOfIsMeeting);
            _tmpIsMeeting = _tmp_3 != 0;
            long _tmpUpdatedAt = 0L;
            _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
            Long _tmpDeletedAt = null;
            if (_stmt.isNull(_columnIndexOfDeletedAt)) {
               _tmpDeletedAt = null;
            } else {
               _tmpDeletedAt = _stmt.getLong(_columnIndexOfDeletedAt);
            }

            _item = new TaskEntity(_tmpId, _tmpUserId, _tmpTitle, _tmpDescription, _tmpDate, _tmpStartTime, _tmpEndTime, _tmpIsTimeBoxed, _tmpIsCompleted, _tmpHasReminder, _tmpReminderTime, _tmpReminderMinutesBefore, _tmpExternalCalendarEventId, _tmpIsMeeting, _tmpUpdatedAt, _tmpDeletedAt);
            _result.add(_item);
         }

         var53 = _result;
      } finally {
         _stmt.close();
      }

      return var53;
   }

   private static final TaskEntity getTaskById$lambda$3(String $_sql, int $id, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      TaskEntity var46;
      try {
         int _argIndex = 1;
         _stmt.bindLong(_argIndex, (long)$id);
         int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
         int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
         int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
         int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
         int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
         int _columnIndexOfStartTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "startTime");
         int _columnIndexOfEndTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "endTime");
         int _columnIndexOfIsTimeBoxed = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isTimeBoxed");
         int _columnIndexOfIsCompleted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isCompleted");
         int _columnIndexOfHasReminder = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hasReminder");
         int _columnIndexOfReminderTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderTime");
         int _columnIndexOfReminderMinutesBefore = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderMinutesBefore");
         int _columnIndexOfExternalCalendarEventId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "externalCalendarEventId");
         int _columnIndexOfIsMeeting = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isMeeting");
         int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
         int _columnIndexOfDeletedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "deletedAt");
         TaskEntity _result = null;
         if (_stmt.step()) {
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpUserId = null;
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
            String _tmpTitle = null;
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
            String _tmpDescription = null;
            if (_stmt.isNull(_columnIndexOfDescription)) {
               _tmpDescription = null;
            } else {
               _tmpDescription = _stmt.getText(_columnIndexOfDescription);
            }

            long _tmpDate = 0L;
            _tmpDate = _stmt.getLong(_columnIndexOfDate);
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

            boolean _tmpIsTimeBoxed = false;
            int _tmp = 0;
            _tmp = (int)_stmt.getLong(_columnIndexOfIsTimeBoxed);
            _tmpIsTimeBoxed = _tmp != 0;
            boolean _tmpIsCompleted = false;
            int _tmp_1 = 0;
            _tmp_1 = (int)_stmt.getLong(_columnIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_1 != 0;
            boolean _tmpHasReminder = false;
            int _tmp_2 = 0;
            _tmp_2 = (int)_stmt.getLong(_columnIndexOfHasReminder);
            _tmpHasReminder = _tmp_2 != 0;
            Long _tmpReminderTime = null;
            if (_stmt.isNull(_columnIndexOfReminderTime)) {
               _tmpReminderTime = null;
            } else {
               _tmpReminderTime = _stmt.getLong(_columnIndexOfReminderTime);
            }

            Integer _tmpReminderMinutesBefore = null;
            if (_stmt.isNull(_columnIndexOfReminderMinutesBefore)) {
               _tmpReminderMinutesBefore = null;
            } else {
               _tmpReminderMinutesBefore = (int)_stmt.getLong(_columnIndexOfReminderMinutesBefore);
            }

            String _tmpExternalCalendarEventId = null;
            if (_stmt.isNull(_columnIndexOfExternalCalendarEventId)) {
               _tmpExternalCalendarEventId = null;
            } else {
               _tmpExternalCalendarEventId = _stmt.getText(_columnIndexOfExternalCalendarEventId);
            }

            boolean _tmpIsMeeting = false;
            int _tmp_3 = 0;
            _tmp_3 = (int)_stmt.getLong(_columnIndexOfIsMeeting);
            _tmpIsMeeting = _tmp_3 != 0;
            long _tmpUpdatedAt = 0L;
            _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
            Long _tmpDeletedAt = null;
            if (_stmt.isNull(_columnIndexOfDeletedAt)) {
               _tmpDeletedAt = null;
            } else {
               _tmpDeletedAt = _stmt.getLong(_columnIndexOfDeletedAt);
            }

            _result = new TaskEntity(_tmpId, _tmpUserId, _tmpTitle, _tmpDescription, _tmpDate, _tmpStartTime, _tmpEndTime, _tmpIsTimeBoxed, _tmpIsCompleted, _tmpHasReminder, _tmpReminderTime, _tmpReminderMinutesBefore, _tmpExternalCalendarEventId, _tmpIsMeeting, _tmpUpdatedAt, _tmpDeletedAt);
         } else {
            _result = null;
         }

         var46 = _result;
      } finally {
         _stmt.close();
      }

      return var46;
   }

   private static final List getAllTasks$lambda$4(String $_sql, String $userId, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      List var47;
      try {
         int _argIndex = 1;
         _stmt.bindText(_argIndex, $userId);
         int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
         int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
         int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
         int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
         int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
         int _columnIndexOfStartTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "startTime");
         int _columnIndexOfEndTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "endTime");
         int _columnIndexOfIsTimeBoxed = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isTimeBoxed");
         int _columnIndexOfIsCompleted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isCompleted");
         int _columnIndexOfHasReminder = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hasReminder");
         int _columnIndexOfReminderTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderTime");
         int _columnIndexOfReminderMinutesBefore = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderMinutesBefore");
         int _columnIndexOfExternalCalendarEventId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "externalCalendarEventId");
         int _columnIndexOfIsMeeting = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isMeeting");
         int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
         int _columnIndexOfDeletedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "deletedAt");
         List _result = (List)(new ArrayList());

         while(_stmt.step()) {
            TaskEntity _item = null;
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpUserId = null;
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
            String _tmpTitle = null;
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
            String _tmpDescription = null;
            if (_stmt.isNull(_columnIndexOfDescription)) {
               _tmpDescription = null;
            } else {
               _tmpDescription = _stmt.getText(_columnIndexOfDescription);
            }

            long _tmpDate = 0L;
            _tmpDate = _stmt.getLong(_columnIndexOfDate);
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

            boolean _tmpIsTimeBoxed = false;
            int _tmp = 0;
            _tmp = (int)_stmt.getLong(_columnIndexOfIsTimeBoxed);
            _tmpIsTimeBoxed = _tmp != 0;
            boolean _tmpIsCompleted = false;
            int _tmp_1 = 0;
            _tmp_1 = (int)_stmt.getLong(_columnIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_1 != 0;
            boolean _tmpHasReminder = false;
            int _tmp_2 = 0;
            _tmp_2 = (int)_stmt.getLong(_columnIndexOfHasReminder);
            _tmpHasReminder = _tmp_2 != 0;
            Long _tmpReminderTime = null;
            if (_stmt.isNull(_columnIndexOfReminderTime)) {
               _tmpReminderTime = null;
            } else {
               _tmpReminderTime = _stmt.getLong(_columnIndexOfReminderTime);
            }

            Integer _tmpReminderMinutesBefore = null;
            if (_stmt.isNull(_columnIndexOfReminderMinutesBefore)) {
               _tmpReminderMinutesBefore = null;
            } else {
               _tmpReminderMinutesBefore = (int)_stmt.getLong(_columnIndexOfReminderMinutesBefore);
            }

            String _tmpExternalCalendarEventId = null;
            if (_stmt.isNull(_columnIndexOfExternalCalendarEventId)) {
               _tmpExternalCalendarEventId = null;
            } else {
               _tmpExternalCalendarEventId = _stmt.getText(_columnIndexOfExternalCalendarEventId);
            }

            boolean _tmpIsMeeting = false;
            int _tmp_3 = 0;
            _tmp_3 = (int)_stmt.getLong(_columnIndexOfIsMeeting);
            _tmpIsMeeting = _tmp_3 != 0;
            long _tmpUpdatedAt = 0L;
            _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
            Long _tmpDeletedAt = null;
            if (_stmt.isNull(_columnIndexOfDeletedAt)) {
               _tmpDeletedAt = null;
            } else {
               _tmpDeletedAt = _stmt.getLong(_columnIndexOfDeletedAt);
            }

            _item = new TaskEntity(_tmpId, _tmpUserId, _tmpTitle, _tmpDescription, _tmpDate, _tmpStartTime, _tmpEndTime, _tmpIsTimeBoxed, _tmpIsCompleted, _tmpHasReminder, _tmpReminderTime, _tmpReminderMinutesBefore, _tmpExternalCalendarEventId, _tmpIsMeeting, _tmpUpdatedAt, _tmpDeletedAt);
            _result.add(_item);
         }

         var47 = _result;
      } finally {
         _stmt.close();
      }

      return var47;
   }

   private static final Unit softDeleteTaskById$lambda$5(String $_sql, long $deletedAt, long $updatedAt, int $id, SQLiteConnection _connection) {
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

   private static final Unit deleteTaskById$lambda$6(String $_sql, int $id, SQLiteConnection _connection) {
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
      d2 = {"Lcom/example/data/local/dao/TaskDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}
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
