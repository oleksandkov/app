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
import com.example.data.local.entity.NoteEntity;
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
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001bJ,\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016J$\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0016J&\u0010!\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"},
   d2 = {"Lcom/example/data/local/dao/NoteDao_Impl;", "Lcom/example/data/local/dao/NoteDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfNoteEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/local/entity/NoteEntity;", "__updateAdapterOfNoteEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "insertNote", "", "note", "(Lcom/example/data/local/entity/NoteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNote", "", "getAllNotes", "Lkotlinx/coroutines/flow/Flow;", "", "userId", "", "getNotesByCategory", "categoryId", "", "getNoteById", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotesForDate", "startOfDay", "endOfDay", "getNotesForMeeting", "meetingId", "softDeleteNoteById", "deletedAt", "updatedAt", "(IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNoteById", "Companion", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class NoteDao_Impl implements NoteDao {
   @NotNull
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   @NotNull
   private final RoomDatabase __db;
   @NotNull
   private final EntityInsertAdapter __insertAdapterOfNoteEntity;
   @NotNull
   private final EntityDeleteOrUpdateAdapter __updateAdapterOfNoteEntity;
   public static final int $stable = 8;

   public NoteDao_Impl(@NotNull RoomDatabase __db) {
      Intrinsics.checkNotNullParameter(__db, "__db");
      super();
      this.__db = __db;
      this.__insertAdapterOfNoteEntity = new EntityInsertAdapter() {
         protected String createQuery() {
            return "INSERT OR REPLACE INTO `notes` (`id`,`userId`,`title`,`content`,`categoryId`,`reminderTime`,`linkedDate`,`linkedMeetingId`,`updatedAt`,`deletedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
         }

         protected void bind(SQLiteStatement statement, NoteEntity entity) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            Intrinsics.checkNotNullParameter(entity, "entity");
            statement.bindLong(1, (long)entity.getId());
            statement.bindText(2, entity.getUserId());
            statement.bindText(3, entity.getTitle());
            statement.bindText(4, entity.getContent());
            Integer _tmpCategoryId = entity.getCategoryId();
            if (_tmpCategoryId == null) {
               statement.bindNull(5);
            } else {
               statement.bindLong(5, (long)_tmpCategoryId);
            }

            Long _tmpReminderTime = entity.getReminderTime();
            if (_tmpReminderTime == null) {
               statement.bindNull(6);
            } else {
               statement.bindLong(6, _tmpReminderTime);
            }

            Long _tmpLinkedDate = entity.getLinkedDate();
            if (_tmpLinkedDate == null) {
               statement.bindNull(7);
            } else {
               statement.bindLong(7, _tmpLinkedDate);
            }

            String _tmpLinkedMeetingId = entity.getLinkedMeetingId();
            if (_tmpLinkedMeetingId == null) {
               statement.bindNull(8);
            } else {
               statement.bindText(8, _tmpLinkedMeetingId);
            }

            statement.bindLong(9, entity.getUpdatedAt());
            Long _tmpDeletedAt = entity.getDeletedAt();
            if (_tmpDeletedAt == null) {
               statement.bindNull(10);
            } else {
               statement.bindLong(10, _tmpDeletedAt);
            }

         }
      };
      this.__updateAdapterOfNoteEntity = new EntityDeleteOrUpdateAdapter() {
         protected String createQuery() {
            return "UPDATE OR ABORT `notes` SET `id` = ?,`userId` = ?,`title` = ?,`content` = ?,`categoryId` = ?,`reminderTime` = ?,`linkedDate` = ?,`linkedMeetingId` = ?,`updatedAt` = ?,`deletedAt` = ? WHERE `id` = ?";
         }

         protected void bind(SQLiteStatement statement, NoteEntity entity) {
            Intrinsics.checkNotNullParameter(statement, "statement");
            Intrinsics.checkNotNullParameter(entity, "entity");
            statement.bindLong(1, (long)entity.getId());
            statement.bindText(2, entity.getUserId());
            statement.bindText(3, entity.getTitle());
            statement.bindText(4, entity.getContent());
            Integer _tmpCategoryId = entity.getCategoryId();
            if (_tmpCategoryId == null) {
               statement.bindNull(5);
            } else {
               statement.bindLong(5, (long)_tmpCategoryId);
            }

            Long _tmpReminderTime = entity.getReminderTime();
            if (_tmpReminderTime == null) {
               statement.bindNull(6);
            } else {
               statement.bindLong(6, _tmpReminderTime);
            }

            Long _tmpLinkedDate = entity.getLinkedDate();
            if (_tmpLinkedDate == null) {
               statement.bindNull(7);
            } else {
               statement.bindLong(7, _tmpLinkedDate);
            }

            String _tmpLinkedMeetingId = entity.getLinkedMeetingId();
            if (_tmpLinkedMeetingId == null) {
               statement.bindNull(8);
            } else {
               statement.bindText(8, _tmpLinkedMeetingId);
            }

            statement.bindLong(9, entity.getUpdatedAt());
            Long _tmpDeletedAt = entity.getDeletedAt();
            if (_tmpDeletedAt == null) {
               statement.bindNull(10);
            } else {
               statement.bindLong(10, _tmpDeletedAt);
            }

            statement.bindLong(11, (long)entity.getId());
         }
      };
   }

   @Nullable
   public Object insertNote(@NotNull NoteEntity note, @NotNull Continuation $completion) {
      return DBUtil.performSuspending(this.__db, false, true, NoteDao_Impl::insertNote$lambda$0, $completion);
   }

   @Nullable
   public Object updateNote(@NotNull NoteEntity note, @NotNull Continuation $completion) {
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, NoteDao_Impl::updateNote$lambda$1, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @NotNull
   public Flow getAllNotes(@NotNull String userId) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      String _sql = "SELECT * FROM notes WHERE userId = ? AND deletedAt IS NULL ORDER BY updatedAt DESC";
      RoomDatabase var10000 = this.__db;
      String[] var3 = new String[]{"notes"};
      return FlowUtil.createFlow(var10000, false, var3, NoteDao_Impl::getAllNotes$lambda$2);
   }

   @NotNull
   public Flow getNotesByCategory(@NotNull String userId, int categoryId) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      String _sql = "SELECT * FROM notes WHERE userId = ? AND categoryId = ? AND deletedAt IS NULL ORDER BY updatedAt DESC";
      RoomDatabase var10000 = this.__db;
      String[] var4 = new String[]{"notes"};
      return FlowUtil.createFlow(var10000, false, var4, NoteDao_Impl::getNotesByCategory$lambda$3);
   }

   @Nullable
   public Object getNoteById(int id, @NotNull Continuation $completion) {
      String _sql = "SELECT * FROM notes WHERE id = ? AND deletedAt IS NULL";
      return DBUtil.performSuspending(this.__db, true, false, NoteDao_Impl::getNoteById$lambda$4, $completion);
   }

   @NotNull
   public Flow getNotesForDate(@NotNull String userId, long startOfDay, long endOfDay) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      String _sql = "SELECT * FROM notes WHERE userId = ? AND linkedDate >= ? AND linkedDate <= ? AND deletedAt IS NULL ORDER BY updatedAt DESC";
      RoomDatabase var10000 = this.__db;
      String[] var7 = new String[]{"notes"};
      return FlowUtil.createFlow(var10000, false, var7, NoteDao_Impl::getNotesForDate$lambda$5);
   }

   @NotNull
   public Flow getNotesForMeeting(@NotNull String userId, @NotNull String meetingId) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      Intrinsics.checkNotNullParameter(meetingId, "meetingId");
      String _sql = "SELECT * FROM notes WHERE userId = ? AND linkedMeetingId = ? AND deletedAt IS NULL ORDER BY updatedAt DESC";
      RoomDatabase var10000 = this.__db;
      String[] var4 = new String[]{"notes"};
      return FlowUtil.createFlow(var10000, false, var4, NoteDao_Impl::getNotesForMeeting$lambda$6);
   }

   @Nullable
   public Object softDeleteNoteById(int id, long deletedAt, long updatedAt, @NotNull Continuation $completion) {
      String _sql = "UPDATE notes SET deletedAt = ?, updatedAt = ? WHERE id = ?";
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, NoteDao_Impl::softDeleteNoteById$lambda$7, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public Object deleteNoteById(int id, @NotNull Continuation $completion) {
      String _sql = "DELETE FROM notes WHERE id = ?";
      Object var10000 = DBUtil.performSuspending(this.__db, false, true, NoteDao_Impl::deleteNoteById$lambda$8, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   private static final long insertNote$lambda$0(NoteDao_Impl this$0, NoteEntity $note, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      long _result = this$0.__insertAdapterOfNoteEntity.insertAndReturnId(_connection, $note);
      return _result;
   }

   private static final Unit updateNote$lambda$1(NoteDao_Impl this$0, NoteEntity $note, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      this$0.__updateAdapterOfNoteEntity.handle(_connection, $note);
      return Unit.INSTANCE;
   }

   private static final List getAllNotes$lambda$2(String $_sql, String $userId, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      List var30;
      try {
         int _argIndex = 1;
         _stmt.bindText(_argIndex, $userId);
         int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
         int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
         int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
         int _columnIndexOfContent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "content");
         int _columnIndexOfCategoryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "categoryId");
         int _columnIndexOfReminderTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderTime");
         int _columnIndexOfLinkedDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "linkedDate");
         int _columnIndexOfLinkedMeetingId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "linkedMeetingId");
         int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
         int _columnIndexOfDeletedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "deletedAt");
         List _result = (List)(new ArrayList());

         while(_stmt.step()) {
            NoteEntity _item = null;
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpUserId = null;
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
            String _tmpTitle = null;
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
            String _tmpContent = null;
            _tmpContent = _stmt.getText(_columnIndexOfContent);
            Integer _tmpCategoryId = null;
            if (_stmt.isNull(_columnIndexOfCategoryId)) {
               _tmpCategoryId = null;
            } else {
               _tmpCategoryId = (int)_stmt.getLong(_columnIndexOfCategoryId);
            }

            Long _tmpReminderTime = null;
            if (_stmt.isNull(_columnIndexOfReminderTime)) {
               _tmpReminderTime = null;
            } else {
               _tmpReminderTime = _stmt.getLong(_columnIndexOfReminderTime);
            }

            Long _tmpLinkedDate = null;
            if (_stmt.isNull(_columnIndexOfLinkedDate)) {
               _tmpLinkedDate = null;
            } else {
               _tmpLinkedDate = _stmt.getLong(_columnIndexOfLinkedDate);
            }

            String _tmpLinkedMeetingId = null;
            if (_stmt.isNull(_columnIndexOfLinkedMeetingId)) {
               _tmpLinkedMeetingId = null;
            } else {
               _tmpLinkedMeetingId = _stmt.getText(_columnIndexOfLinkedMeetingId);
            }

            long _tmpUpdatedAt = 0L;
            _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
            Long _tmpDeletedAt = null;
            if (_stmt.isNull(_columnIndexOfDeletedAt)) {
               _tmpDeletedAt = null;
            } else {
               _tmpDeletedAt = _stmt.getLong(_columnIndexOfDeletedAt);
            }

            _item = new NoteEntity(_tmpId, _tmpUserId, _tmpTitle, _tmpContent, _tmpCategoryId, _tmpReminderTime, _tmpLinkedDate, _tmpLinkedMeetingId, _tmpUpdatedAt, _tmpDeletedAt);
            _result.add(_item);
         }

         var30 = _result;
      } finally {
         _stmt.close();
      }

      return var30;
   }

   private static final List getNotesByCategory$lambda$3(String $_sql, String $userId, int $categoryId, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      List var32;
      try {
         int _argIndex = 1;
         _stmt.bindText(_argIndex, $userId);
         _argIndex = 2;
         _stmt.bindLong(_argIndex, (long)$categoryId);
         int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
         int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
         int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
         int _columnIndexOfContent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "content");
         int _columnIndexOfCategoryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "categoryId");
         int _columnIndexOfReminderTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderTime");
         int _columnIndexOfLinkedDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "linkedDate");
         int _columnIndexOfLinkedMeetingId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "linkedMeetingId");
         int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
         int _columnIndexOfDeletedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "deletedAt");
         List _result = (List)(new ArrayList());

         while(_stmt.step()) {
            NoteEntity _item = null;
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpUserId = null;
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
            String _tmpTitle = null;
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
            String _tmpContent = null;
            _tmpContent = _stmt.getText(_columnIndexOfContent);
            Integer _tmpCategoryId = null;
            if (_stmt.isNull(_columnIndexOfCategoryId)) {
               _tmpCategoryId = null;
            } else {
               _tmpCategoryId = (int)_stmt.getLong(_columnIndexOfCategoryId);
            }

            Long _tmpReminderTime = null;
            if (_stmt.isNull(_columnIndexOfReminderTime)) {
               _tmpReminderTime = null;
            } else {
               _tmpReminderTime = _stmt.getLong(_columnIndexOfReminderTime);
            }

            Long _tmpLinkedDate = null;
            if (_stmt.isNull(_columnIndexOfLinkedDate)) {
               _tmpLinkedDate = null;
            } else {
               _tmpLinkedDate = _stmt.getLong(_columnIndexOfLinkedDate);
            }

            String _tmpLinkedMeetingId = null;
            if (_stmt.isNull(_columnIndexOfLinkedMeetingId)) {
               _tmpLinkedMeetingId = null;
            } else {
               _tmpLinkedMeetingId = _stmt.getText(_columnIndexOfLinkedMeetingId);
            }

            long _tmpUpdatedAt = 0L;
            _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
            Long _tmpDeletedAt = null;
            if (_stmt.isNull(_columnIndexOfDeletedAt)) {
               _tmpDeletedAt = null;
            } else {
               _tmpDeletedAt = _stmt.getLong(_columnIndexOfDeletedAt);
            }

            _item = new NoteEntity(_tmpId, _tmpUserId, _tmpTitle, _tmpContent, _tmpCategoryId, _tmpReminderTime, _tmpLinkedDate, _tmpLinkedMeetingId, _tmpUpdatedAt, _tmpDeletedAt);
            _result.add(_item);
         }

         var32 = _result;
      } finally {
         _stmt.close();
      }

      return var32;
   }

   private static final NoteEntity getNoteById$lambda$4(String $_sql, int $id, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      NoteEntity var29;
      try {
         int _argIndex = 1;
         _stmt.bindLong(_argIndex, (long)$id);
         int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
         int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
         int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
         int _columnIndexOfContent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "content");
         int _columnIndexOfCategoryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "categoryId");
         int _columnIndexOfReminderTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderTime");
         int _columnIndexOfLinkedDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "linkedDate");
         int _columnIndexOfLinkedMeetingId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "linkedMeetingId");
         int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
         int _columnIndexOfDeletedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "deletedAt");
         NoteEntity _result = null;
         if (_stmt.step()) {
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpUserId = null;
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
            String _tmpTitle = null;
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
            String _tmpContent = null;
            _tmpContent = _stmt.getText(_columnIndexOfContent);
            Integer _tmpCategoryId = null;
            if (_stmt.isNull(_columnIndexOfCategoryId)) {
               _tmpCategoryId = null;
            } else {
               _tmpCategoryId = (int)_stmt.getLong(_columnIndexOfCategoryId);
            }

            Long _tmpReminderTime = null;
            if (_stmt.isNull(_columnIndexOfReminderTime)) {
               _tmpReminderTime = null;
            } else {
               _tmpReminderTime = _stmt.getLong(_columnIndexOfReminderTime);
            }

            Long _tmpLinkedDate = null;
            if (_stmt.isNull(_columnIndexOfLinkedDate)) {
               _tmpLinkedDate = null;
            } else {
               _tmpLinkedDate = _stmt.getLong(_columnIndexOfLinkedDate);
            }

            String _tmpLinkedMeetingId = null;
            if (_stmt.isNull(_columnIndexOfLinkedMeetingId)) {
               _tmpLinkedMeetingId = null;
            } else {
               _tmpLinkedMeetingId = _stmt.getText(_columnIndexOfLinkedMeetingId);
            }

            long _tmpUpdatedAt = 0L;
            _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
            Long _tmpDeletedAt = null;
            if (_stmt.isNull(_columnIndexOfDeletedAt)) {
               _tmpDeletedAt = null;
            } else {
               _tmpDeletedAt = _stmt.getLong(_columnIndexOfDeletedAt);
            }

            _result = new NoteEntity(_tmpId, _tmpUserId, _tmpTitle, _tmpContent, _tmpCategoryId, _tmpReminderTime, _tmpLinkedDate, _tmpLinkedMeetingId, _tmpUpdatedAt, _tmpDeletedAt);
         } else {
            _result = null;
         }

         var29 = _result;
      } finally {
         _stmt.close();
      }

      return var29;
   }

   private static final List getNotesForDate$lambda$5(String $_sql, String $userId, long $startOfDay, long $endOfDay, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      List var36;
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
         int _columnIndexOfContent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "content");
         int _columnIndexOfCategoryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "categoryId");
         int _columnIndexOfReminderTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderTime");
         int _columnIndexOfLinkedDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "linkedDate");
         int _columnIndexOfLinkedMeetingId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "linkedMeetingId");
         int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
         int _columnIndexOfDeletedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "deletedAt");
         List _result = (List)(new ArrayList());

         while(_stmt.step()) {
            NoteEntity _item = null;
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpUserId = null;
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
            String _tmpTitle = null;
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
            String _tmpContent = null;
            _tmpContent = _stmt.getText(_columnIndexOfContent);
            Integer _tmpCategoryId = null;
            if (_stmt.isNull(_columnIndexOfCategoryId)) {
               _tmpCategoryId = null;
            } else {
               _tmpCategoryId = (int)_stmt.getLong(_columnIndexOfCategoryId);
            }

            Long _tmpReminderTime = null;
            if (_stmt.isNull(_columnIndexOfReminderTime)) {
               _tmpReminderTime = null;
            } else {
               _tmpReminderTime = _stmt.getLong(_columnIndexOfReminderTime);
            }

            Long _tmpLinkedDate = null;
            if (_stmt.isNull(_columnIndexOfLinkedDate)) {
               _tmpLinkedDate = null;
            } else {
               _tmpLinkedDate = _stmt.getLong(_columnIndexOfLinkedDate);
            }

            String _tmpLinkedMeetingId = null;
            if (_stmt.isNull(_columnIndexOfLinkedMeetingId)) {
               _tmpLinkedMeetingId = null;
            } else {
               _tmpLinkedMeetingId = _stmt.getText(_columnIndexOfLinkedMeetingId);
            }

            long _tmpUpdatedAt = 0L;
            _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
            Long _tmpDeletedAt = null;
            if (_stmt.isNull(_columnIndexOfDeletedAt)) {
               _tmpDeletedAt = null;
            } else {
               _tmpDeletedAt = _stmt.getLong(_columnIndexOfDeletedAt);
            }

            _item = new NoteEntity(_tmpId, _tmpUserId, _tmpTitle, _tmpContent, _tmpCategoryId, _tmpReminderTime, _tmpLinkedDate, _tmpLinkedMeetingId, _tmpUpdatedAt, _tmpDeletedAt);
            _result.add(_item);
         }

         var36 = _result;
      } finally {
         _stmt.close();
      }

      return var36;
   }

   private static final List getNotesForMeeting$lambda$6(String $_sql, String $userId, String $meetingId, SQLiteConnection _connection) {
      Intrinsics.checkNotNullParameter(_connection, "_connection");
      SQLiteStatement _stmt = _connection.prepare($_sql);

      List var32;
      try {
         int _argIndex = 1;
         _stmt.bindText(_argIndex, $userId);
         _argIndex = 2;
         _stmt.bindText(_argIndex, $meetingId);
         int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
         int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
         int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
         int _columnIndexOfContent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "content");
         int _columnIndexOfCategoryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "categoryId");
         int _columnIndexOfReminderTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reminderTime");
         int _columnIndexOfLinkedDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "linkedDate");
         int _columnIndexOfLinkedMeetingId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "linkedMeetingId");
         int _columnIndexOfUpdatedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "updatedAt");
         int _columnIndexOfDeletedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "deletedAt");
         List _result = (List)(new ArrayList());

         while(_stmt.step()) {
            NoteEntity _item = null;
            int _tmpId = 0;
            _tmpId = (int)_stmt.getLong(_columnIndexOfId);
            String _tmpUserId = null;
            _tmpUserId = _stmt.getText(_columnIndexOfUserId);
            String _tmpTitle = null;
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
            String _tmpContent = null;
            _tmpContent = _stmt.getText(_columnIndexOfContent);
            Integer _tmpCategoryId = null;
            if (_stmt.isNull(_columnIndexOfCategoryId)) {
               _tmpCategoryId = null;
            } else {
               _tmpCategoryId = (int)_stmt.getLong(_columnIndexOfCategoryId);
            }

            Long _tmpReminderTime = null;
            if (_stmt.isNull(_columnIndexOfReminderTime)) {
               _tmpReminderTime = null;
            } else {
               _tmpReminderTime = _stmt.getLong(_columnIndexOfReminderTime);
            }

            Long _tmpLinkedDate = null;
            if (_stmt.isNull(_columnIndexOfLinkedDate)) {
               _tmpLinkedDate = null;
            } else {
               _tmpLinkedDate = _stmt.getLong(_columnIndexOfLinkedDate);
            }

            String _tmpLinkedMeetingId = null;
            if (_stmt.isNull(_columnIndexOfLinkedMeetingId)) {
               _tmpLinkedMeetingId = null;
            } else {
               _tmpLinkedMeetingId = _stmt.getText(_columnIndexOfLinkedMeetingId);
            }

            long _tmpUpdatedAt = 0L;
            _tmpUpdatedAt = _stmt.getLong(_columnIndexOfUpdatedAt);
            Long _tmpDeletedAt = null;
            if (_stmt.isNull(_columnIndexOfDeletedAt)) {
               _tmpDeletedAt = null;
            } else {
               _tmpDeletedAt = _stmt.getLong(_columnIndexOfDeletedAt);
            }

            _item = new NoteEntity(_tmpId, _tmpUserId, _tmpTitle, _tmpContent, _tmpCategoryId, _tmpReminderTime, _tmpLinkedDate, _tmpLinkedMeetingId, _tmpUpdatedAt, _tmpDeletedAt);
            _result.add(_item);
         }

         var32 = _result;
      } finally {
         _stmt.close();
      }

      return var32;
   }

   private static final Unit softDeleteNoteById$lambda$7(String $_sql, long $deletedAt, long $updatedAt, int $id, SQLiteConnection _connection) {
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

   private static final Unit deleteNoteById$lambda$8(String $_sql, int $id, SQLiteConnection _connection) {
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
      d2 = {"Lcom/example/data/local/dao/NoteDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}
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
