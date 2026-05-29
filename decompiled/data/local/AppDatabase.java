package com.example.data.local;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.data.local.dao.CategoryDao;
import com.example.data.local.dao.NoteDao;
import com.example.data.local.dao.SubTaskDao;
import com.example.data.local.dao.TaskDao;
import com.example.data.local.entity.CategoryEntity;
import com.example.data.local.entity.NoteEntity;
import com.example.data.local.entity.SubTaskEntity;
import com.example.data.local.entity.TaskEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\r"},
   d2 = {"Lcom/example/data/local/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "taskDao", "Lcom/example/data/local/dao/TaskDao;", "noteDao", "Lcom/example/data/local/dao/NoteDao;", "categoryDao", "Lcom/example/data/local/dao/CategoryDao;", "subTaskDao", "Lcom/example/data/local/dao/SubTaskDao;", "Companion", "app"}
)
@Database(
   entities = {TaskEntity.class, NoteEntity.class, CategoryEntity.class, SubTaskEntity.class},
   version = 6,
   exportSchema = false
)
@StabilityInferred(
   parameters = 0
)
public abstract class AppDatabase extends RoomDatabase {
   @NotNull
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int $stable = 8;
   @Nullable
   private static volatile AppDatabase INSTANCE;

   @NotNull
   public abstract TaskDao taskDao();

   @NotNull
   public abstract NoteDao noteDao();

   @NotNull
   public abstract CategoryDao categoryDao();

   @NotNull
   public abstract SubTaskDao subTaskDao();

   // $FF: synthetic method
   public static final AppDatabase access$getINSTANCE$cp() {
      return INSTANCE;
   }

   // $FF: synthetic method
   public static final void access$setINSTANCE$cp(AppDatabase var0) {
      INSTANCE = var0;
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"},
      d2 = {"Lcom/example/data/local/AppDatabase$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/example/data/local/AppDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app"}
   )
   public static final class Companion {
      private Companion() {
      }

      @NotNull
      public final AppDatabase getDatabase(@NotNull Context param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
