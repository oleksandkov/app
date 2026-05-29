package com.example.data.local;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.example.data.local.dao.CategoryDao;
import com.example.data.local.dao.CategoryDao_Impl;
import com.example.data.local.dao.NoteDao;
import com.example.data.local.dao.NoteDao_Impl;
import com.example.data.local.dao.SubTaskDao;
import com.example.data.local.dao.SubTaskDao_Impl;
import com.example.data.local.dao.TaskDao;
import com.example.data.local.dao.TaskDao_Impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u00160\u0014H\u0014J\u0016\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u00150\u0018H\u0016J*\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\u001a\u0010\u001c\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0015\u0012\u0004\u0012\u00020\u00190\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"},
   d2 = {"Lcom/example/data/local/AppDatabase_Impl;", "Lcom/example/data/local/AppDatabase;", "<init>", "()V", "_taskDao", "Lkotlin/Lazy;", "Lcom/example/data/local/dao/TaskDao;", "_noteDao", "Lcom/example/data/local/dao/NoteDao;", "_categoryDao", "Lcom/example/data/local/dao/CategoryDao;", "_subTaskDao", "Lcom/example/data/local/dao/SubTaskDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "taskDao", "noteDao", "categoryDao", "subTaskDao", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class AppDatabase_Impl extends AppDatabase {
   @NotNull
   private final Lazy _taskDao = LazyKt.lazy(AppDatabase_Impl::_taskDao$lambda$0);
   @NotNull
   private final Lazy _noteDao = LazyKt.lazy(AppDatabase_Impl::_noteDao$lambda$1);
   @NotNull
   private final Lazy _categoryDao = LazyKt.lazy(AppDatabase_Impl::_categoryDao$lambda$2);
   @NotNull
   private final Lazy _subTaskDao = LazyKt.lazy(AppDatabase_Impl::_subTaskDao$lambda$3);
   public static final int $stable = 8;

   @NotNull
   protected RoomOpenDelegate createOpenDelegate() {
      RoomOpenDelegate _openDelegate = new RoomOpenDelegate() {
         public void createAllTables(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `tasks` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT, `date` INTEGER NOT NULL, `startTime` INTEGER, `endTime` INTEGER, `isTimeBoxed` INTEGER NOT NULL, `isCompleted` INTEGER NOT NULL, `hasReminder` INTEGER NOT NULL, `reminderTime` INTEGER, `reminderMinutesBefore` INTEGER, `externalCalendarEventId` TEXT, `isMeeting` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `deletedAt` INTEGER)");
            SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `notes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `categoryId` INTEGER, `reminderTime` INTEGER, `linkedDate` INTEGER, `linkedMeetingId` TEXT, `updatedAt` INTEGER NOT NULL, `deletedAt` INTEGER, FOREIGN KEY(`categoryId`) REFERENCES `categories`(`id`) ON UPDATE NO ACTION ON DELETE SET NULL )");
            SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_notes_categoryId` ON `notes` (`categoryId`)");
            SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `categories` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `colorHex` TEXT NOT NULL)");
            SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `subtasks` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `parentIdStr` TEXT NOT NULL, `title` TEXT NOT NULL, `startTime` INTEGER, `endTime` INTEGER, `isCompleted` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, `deletedAt` INTEGER)");
            SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '19b421b37a061b9be1792101ef1d17fd')");
         }

         public void dropAllTables(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            SQLite.execSQL(connection, "DROP TABLE IF EXISTS `tasks`");
            SQLite.execSQL(connection, "DROP TABLE IF EXISTS `notes`");
            SQLite.execSQL(connection, "DROP TABLE IF EXISTS `categories`");
            SQLite.execSQL(connection, "DROP TABLE IF EXISTS `subtasks`");
         }

         public void onCreate(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
         }

         public void onOpen(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            SQLite.execSQL(connection, "PRAGMA foreign_keys = ON");
            AppDatabase_Impl.this.internalInitInvalidationTracker(connection);
         }

         public void onPreMigrate(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            DBUtil.dropFtsSyncTriggers(connection);
         }

         public void onPostMigrate(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
         }

         public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Map _columnsTasks = (Map)(new LinkedHashMap());
            _columnsTasks.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String)null, 1));
            _columnsTasks.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, (String)null, 1));
            _columnsTasks.put("title", new TableInfo.Column("title", "TEXT", true, 0, (String)null, 1));
            _columnsTasks.put("description", new TableInfo.Column("description", "TEXT", false, 0, (String)null, 1));
            _columnsTasks.put("date", new TableInfo.Column("date", "INTEGER", true, 0, (String)null, 1));
            _columnsTasks.put("startTime", new TableInfo.Column("startTime", "INTEGER", false, 0, (String)null, 1));
            _columnsTasks.put("endTime", new TableInfo.Column("endTime", "INTEGER", false, 0, (String)null, 1));
            _columnsTasks.put("isTimeBoxed", new TableInfo.Column("isTimeBoxed", "INTEGER", true, 0, (String)null, 1));
            _columnsTasks.put("isCompleted", new TableInfo.Column("isCompleted", "INTEGER", true, 0, (String)null, 1));
            _columnsTasks.put("hasReminder", new TableInfo.Column("hasReminder", "INTEGER", true, 0, (String)null, 1));
            _columnsTasks.put("reminderTime", new TableInfo.Column("reminderTime", "INTEGER", false, 0, (String)null, 1));
            _columnsTasks.put("reminderMinutesBefore", new TableInfo.Column("reminderMinutesBefore", "INTEGER", false, 0, (String)null, 1));
            _columnsTasks.put("externalCalendarEventId", new TableInfo.Column("externalCalendarEventId", "TEXT", false, 0, (String)null, 1));
            _columnsTasks.put("isMeeting", new TableInfo.Column("isMeeting", "INTEGER", true, 0, (String)null, 1));
            _columnsTasks.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, (String)null, 1));
            _columnsTasks.put("deletedAt", new TableInfo.Column("deletedAt", "INTEGER", false, 0, (String)null, 1));
            Set _foreignKeysTasks = (Set)(new LinkedHashSet());
            Set _indicesTasks = (Set)(new LinkedHashSet());
            TableInfo _infoTasks = new TableInfo("tasks", _columnsTasks, _foreignKeysTasks, _indicesTasks);
            TableInfo _existingTasks = TableInfo.Companion.read(connection, "tasks");
            if (!_infoTasks.equals(_existingTasks)) {
               return new RoomOpenDelegate.ValidationResult(false, "tasks(com.example.data.local.entity.TaskEntity).\n Expected:\n" + _infoTasks + "\n Found:\n" + _existingTasks);
            } else {
               Map _columnsNotes = (Map)(new LinkedHashMap());
               _columnsNotes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String)null, 1));
               _columnsNotes.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, (String)null, 1));
               _columnsNotes.put("title", new TableInfo.Column("title", "TEXT", true, 0, (String)null, 1));
               _columnsNotes.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String)null, 1));
               _columnsNotes.put("categoryId", new TableInfo.Column("categoryId", "INTEGER", false, 0, (String)null, 1));
               _columnsNotes.put("reminderTime", new TableInfo.Column("reminderTime", "INTEGER", false, 0, (String)null, 1));
               _columnsNotes.put("linkedDate", new TableInfo.Column("linkedDate", "INTEGER", false, 0, (String)null, 1));
               _columnsNotes.put("linkedMeetingId", new TableInfo.Column("linkedMeetingId", "TEXT", false, 0, (String)null, 1));
               _columnsNotes.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, (String)null, 1));
               _columnsNotes.put("deletedAt", new TableInfo.Column("deletedAt", "INTEGER", false, 0, (String)null, 1));
               Set _foreignKeysNotes = (Set)(new LinkedHashSet());
               _foreignKeysNotes.add(new TableInfo.ForeignKey("categories", "SET NULL", "NO ACTION", CollectionsKt.listOf("categoryId"), CollectionsKt.listOf("id")));
               Set _indicesNotes = (Set)(new LinkedHashSet());
               _indicesNotes.add(new TableInfo.Index("index_notes_categoryId", false, CollectionsKt.listOf("categoryId"), CollectionsKt.listOf("ASC")));
               TableInfo _infoNotes = new TableInfo("notes", _columnsNotes, _foreignKeysNotes, _indicesNotes);
               TableInfo _existingNotes = TableInfo.Companion.read(connection, "notes");
               if (!_infoNotes.equals(_existingNotes)) {
                  return new RoomOpenDelegate.ValidationResult(false, "notes(com.example.data.local.entity.NoteEntity).\n Expected:\n" + _infoNotes + "\n Found:\n" + _existingNotes);
               } else {
                  Map _columnsCategories = (Map)(new LinkedHashMap());
                  _columnsCategories.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String)null, 1));
                  _columnsCategories.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String)null, 1));
                  _columnsCategories.put("colorHex", new TableInfo.Column("colorHex", "TEXT", true, 0, (String)null, 1));
                  Set _foreignKeysCategories = (Set)(new LinkedHashSet());
                  Set _indicesCategories = (Set)(new LinkedHashSet());
                  TableInfo _infoCategories = new TableInfo("categories", _columnsCategories, _foreignKeysCategories, _indicesCategories);
                  TableInfo _existingCategories = TableInfo.Companion.read(connection, "categories");
                  if (!_infoCategories.equals(_existingCategories)) {
                     return new RoomOpenDelegate.ValidationResult(false, "categories(com.example.data.local.entity.CategoryEntity).\n Expected:\n" + _infoCategories + "\n Found:\n" + _existingCategories);
                  } else {
                     Map _columnsSubtasks = (Map)(new LinkedHashMap());
                     _columnsSubtasks.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String)null, 1));
                     _columnsSubtasks.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, (String)null, 1));
                     _columnsSubtasks.put("parentIdStr", new TableInfo.Column("parentIdStr", "TEXT", true, 0, (String)null, 1));
                     _columnsSubtasks.put("title", new TableInfo.Column("title", "TEXT", true, 0, (String)null, 1));
                     _columnsSubtasks.put("startTime", new TableInfo.Column("startTime", "INTEGER", false, 0, (String)null, 1));
                     _columnsSubtasks.put("endTime", new TableInfo.Column("endTime", "INTEGER", false, 0, (String)null, 1));
                     _columnsSubtasks.put("isCompleted", new TableInfo.Column("isCompleted", "INTEGER", true, 0, (String)null, 1));
                     _columnsSubtasks.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, (String)null, 1));
                     _columnsSubtasks.put("deletedAt", new TableInfo.Column("deletedAt", "INTEGER", false, 0, (String)null, 1));
                     Set _foreignKeysSubtasks = (Set)(new LinkedHashSet());
                     Set _indicesSubtasks = (Set)(new LinkedHashSet());
                     TableInfo _infoSubtasks = new TableInfo("subtasks", _columnsSubtasks, _foreignKeysSubtasks, _indicesSubtasks);
                     TableInfo _existingSubtasks = TableInfo.Companion.read(connection, "subtasks");
                     return !_infoSubtasks.equals(_existingSubtasks) ? new RoomOpenDelegate.ValidationResult(false, "subtasks(com.example.data.local.entity.SubTaskEntity).\n Expected:\n" + _infoSubtasks + "\n Found:\n" + _existingSubtasks) : new RoomOpenDelegate.ValidationResult(true, (String)null);
                  }
               }
            }
         }
      };
      return _openDelegate;
   }

   @NotNull
   protected InvalidationTracker createInvalidationTracker() {
      Map _shadowTablesMap = (Map)(new LinkedHashMap());
      Map _viewTables = (Map)(new LinkedHashMap());
      RoomDatabase var10002 = this;
      String[] var3 = new String[]{"tasks", "notes", "categories", "subtasks"};
      return new InvalidationTracker(var10002, _shadowTablesMap, _viewTables, var3);
   }

   public void clearAllTables() {
      String[] var1 = new String[]{"tasks", "notes", "categories", "subtasks"};
      super.performClear(true, var1);
   }

   @NotNull
   protected Map getRequiredTypeConverterClasses() {
      Map _typeConvertersMap = (Map)(new LinkedHashMap());
      _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(TaskDao.class), TaskDao_Impl.Companion.getRequiredConverters());
      _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(NoteDao.class), NoteDao_Impl.Companion.getRequiredConverters());
      _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(CategoryDao.class), CategoryDao_Impl.Companion.getRequiredConverters());
      _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(SubTaskDao.class), SubTaskDao_Impl.Companion.getRequiredConverters());
      return _typeConvertersMap;
   }

   @NotNull
   public Set getRequiredAutoMigrationSpecClasses() {
      Set _autoMigrationSpecsSet = (Set)(new LinkedHashSet());
      return _autoMigrationSpecsSet;
   }

   @NotNull
   public List createAutoMigrations(@NotNull Map autoMigrationSpecs) {
      Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
      List _autoMigrations = (List)(new ArrayList());
      return _autoMigrations;
   }

   @NotNull
   public TaskDao taskDao() {
      return (TaskDao)this._taskDao.getValue();
   }

   @NotNull
   public NoteDao noteDao() {
      return (NoteDao)this._noteDao.getValue();
   }

   @NotNull
   public CategoryDao categoryDao() {
      return (CategoryDao)this._categoryDao.getValue();
   }

   @NotNull
   public SubTaskDao subTaskDao() {
      return (SubTaskDao)this._subTaskDao.getValue();
   }

   private static final TaskDao_Impl _taskDao$lambda$0(AppDatabase_Impl this$0) {
      return new TaskDao_Impl(this$0);
   }

   private static final NoteDao_Impl _noteDao$lambda$1(AppDatabase_Impl this$0) {
      return new NoteDao_Impl(this$0);
   }

   private static final CategoryDao_Impl _categoryDao$lambda$2(AppDatabase_Impl this$0) {
      return new CategoryDao_Impl(this$0);
   }

   private static final SubTaskDao_Impl _subTaskDao$lambda$3(AppDatabase_Impl this$0) {
      return new SubTaskDao_Impl(this$0);
   }
}
