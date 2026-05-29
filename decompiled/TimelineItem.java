package com.example;

import androidx.compose.runtime.internal.StabilityInferred;
import com.example.data.local.entity.TaskEntity;
import com.example.data.network.CalendarEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"},
   d2 = {"Lcom/example/TimelineItem;", "", "<init>", "()V", "timeInMillis", "", "getTimeInMillis", "()J", "AppTaskItem", "GoogleEventItem", "Lcom/example/TimelineItem$AppTaskItem;", "Lcom/example/TimelineItem$GoogleEventItem;", "app"}
)
@StabilityInferred(
   parameters = 1
)
public abstract class TimelineItem {
   public static final int $stable;

   private TimelineItem() {
   }

   public abstract long getTimeInMillis();

   // $FF: synthetic method
   public TimelineItem(DefaultConstructorMarker $constructor_marker) {
      this();
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"},
      d2 = {"Lcom/example/TimelineItem$AppTaskItem;", "Lcom/example/TimelineItem;", "task", "Lcom/example/data/local/entity/TaskEntity;", "<init>", "(Lcom/example/data/local/entity/TaskEntity;)V", "getTask", "()Lcom/example/data/local/entity/TaskEntity;", "timeInMillis", "", "getTimeInMillis", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}
   )
   @StabilityInferred(
      parameters = 1
   )
   public static final class AppTaskItem extends TimelineItem {
      @NotNull
      private final TaskEntity task;
      public static final int $stable;

      public AppTaskItem(@NotNull TaskEntity task) {
         Intrinsics.checkNotNullParameter(task, "task");
         super((DefaultConstructorMarker)null);
         this.task = task;
      }

      @NotNull
      public final TaskEntity getTask() {
         return this.task;
      }

      public long getTimeInMillis() {
         Long var10000 = this.task.getStartTime();
         return var10000 != null ? var10000 : this.task.getDate();
      }

      @NotNull
      public final TaskEntity component1() {
         return this.task;
      }

      @NotNull
      public final AppTaskItem copy(@NotNull TaskEntity task) {
         Intrinsics.checkNotNullParameter(task, "task");
         return new AppTaskItem(task);
      }

      // $FF: synthetic method
      public static AppTaskItem copy$default(AppTaskItem var0, TaskEntity var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.task;
         }

         return var0.copy(var1);
      }

      @NotNull
      public String toString() {
         return "AppTaskItem(task=" + this.task + ")";
      }

      public int hashCode() {
         return this.task.hashCode();
      }

      public boolean equals(@Nullable Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof AppTaskItem)) {
            return false;
         } else {
            AppTaskItem var2 = (AppTaskItem)other;
            return Intrinsics.areEqual(this.task, var2.task);
         }
      }
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"},
      d2 = {"Lcom/example/TimelineItem$GoogleEventItem;", "Lcom/example/TimelineItem;", "event", "Lcom/example/data/network/CalendarEvent;", "<init>", "(Lcom/example/data/network/CalendarEvent;)V", "getEvent", "()Lcom/example/data/network/CalendarEvent;", "timeInMillis", "", "getTimeInMillis", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}
   )
   @StabilityInferred(
      parameters = 1
   )
   public static final class GoogleEventItem extends TimelineItem {
      @NotNull
      private final CalendarEvent event;
      public static final int $stable;

      public GoogleEventItem(@NotNull CalendarEvent event) {
         Intrinsics.checkNotNullParameter(event, "event");
         super((DefaultConstructorMarker)null);
         this.event = event;
      }

      @NotNull
      public final CalendarEvent getEvent() {
         return this.event;
      }

      public long getTimeInMillis() {
         return this.event.getStartTimeInMillis();
      }

      @NotNull
      public final CalendarEvent component1() {
         return this.event;
      }

      @NotNull
      public final GoogleEventItem copy(@NotNull CalendarEvent event) {
         Intrinsics.checkNotNullParameter(event, "event");
         return new GoogleEventItem(event);
      }

      // $FF: synthetic method
      public static GoogleEventItem copy$default(GoogleEventItem var0, CalendarEvent var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.event;
         }

         return var0.copy(var1);
      }

      @NotNull
      public String toString() {
         return "GoogleEventItem(event=" + this.event + ")";
      }

      public int hashCode() {
         return this.event.hashCode();
      }

      public boolean equals(@Nullable Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof GoogleEventItem)) {
            return false;
         } else {
            GoogleEventItem var2 = (GoogleEventItem)other;
            return Intrinsics.areEqual(this.event, var2.event);
         }
      }
   }
}
