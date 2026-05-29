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
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"},
   d2 = {"Lcom/example/PlanItem;", "", "<init>", "()V", "startTime", "", "getStartTime", "()J", "title", "", "getTitle", "()Ljava/lang/String;", "LocalTask", "GoogleEvent", "Lcom/example/PlanItem$GoogleEvent;", "Lcom/example/PlanItem$LocalTask;", "app"}
)
@StabilityInferred(
   parameters = 1
)
public abstract class PlanItem {
   public static final int $stable;

   private PlanItem() {
   }

   public abstract long getStartTime();

   @NotNull
   public abstract String getTitle();

   // $FF: synthetic method
   public PlanItem(DefaultConstructorMarker $constructor_marker) {
      this();
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"},
      d2 = {"Lcom/example/PlanItem$LocalTask;", "Lcom/example/PlanItem;", "task", "Lcom/example/data/local/entity/TaskEntity;", "<init>", "(Lcom/example/data/local/entity/TaskEntity;)V", "getTask", "()Lcom/example/data/local/entity/TaskEntity;", "startTime", "", "getStartTime", "()J", "title", "", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app"}
   )
   @StabilityInferred(
      parameters = 1
   )
   public static final class LocalTask extends PlanItem {
      @NotNull
      private final TaskEntity task;
      public static final int $stable;

      public LocalTask(@NotNull TaskEntity task) {
         Intrinsics.checkNotNullParameter(task, "task");
         super((DefaultConstructorMarker)null);
         this.task = task;
      }

      @NotNull
      public final TaskEntity getTask() {
         return this.task;
      }

      public long getStartTime() {
         Long var10000 = this.task.getStartTime();
         return var10000 != null ? var10000 : this.task.getDate();
      }

      @NotNull
      public String getTitle() {
         return this.task.getTitle();
      }

      @NotNull
      public final TaskEntity component1() {
         return this.task;
      }

      @NotNull
      public final LocalTask copy(@NotNull TaskEntity task) {
         Intrinsics.checkNotNullParameter(task, "task");
         return new LocalTask(task);
      }

      // $FF: synthetic method
      public static LocalTask copy$default(LocalTask var0, TaskEntity var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.task;
         }

         return var0.copy(var1);
      }

      @NotNull
      public String toString() {
         return "LocalTask(task=" + this.task + ")";
      }

      public int hashCode() {
         return this.task.hashCode();
      }

      public boolean equals(@Nullable Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof LocalTask)) {
            return false;
         } else {
            LocalTask var2 = (LocalTask)other;
            return Intrinsics.areEqual(this.task, var2.task);
         }
      }
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"},
      d2 = {"Lcom/example/PlanItem$GoogleEvent;", "Lcom/example/PlanItem;", "event", "Lcom/example/data/network/CalendarEvent;", "<init>", "(Lcom/example/data/network/CalendarEvent;)V", "getEvent", "()Lcom/example/data/network/CalendarEvent;", "startTime", "", "getStartTime", "()J", "title", "", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app"}
   )
   @StabilityInferred(
      parameters = 1
   )
   public static final class GoogleEvent extends PlanItem {
      @NotNull
      private final CalendarEvent event;
      public static final int $stable;

      public GoogleEvent(@NotNull CalendarEvent event) {
         Intrinsics.checkNotNullParameter(event, "event");
         super((DefaultConstructorMarker)null);
         this.event = event;
      }

      @NotNull
      public final CalendarEvent getEvent() {
         return this.event;
      }

      public long getStartTime() {
         return this.event.getStartTimeInMillis();
      }

      @NotNull
      public String getTitle() {
         String var10000 = this.event.getSummary();
         if (var10000 == null) {
            var10000 = "Meeting";
         }

         return var10000;
      }

      @NotNull
      public final CalendarEvent component1() {
         return this.event;
      }

      @NotNull
      public final GoogleEvent copy(@NotNull CalendarEvent event) {
         Intrinsics.checkNotNullParameter(event, "event");
         return new GoogleEvent(event);
      }

      // $FF: synthetic method
      public static GoogleEvent copy$default(GoogleEvent var0, CalendarEvent var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.event;
         }

         return var0.copy(var1);
      }

      @NotNull
      public String toString() {
         return "GoogleEvent(event=" + this.event + ")";
      }

      public int hashCode() {
         return this.event.hashCode();
      }

      public boolean equals(@Nullable Object other) {
         if (this == other) {
            return true;
         } else if (!(other instanceof GoogleEvent)) {
            return false;
         } else {
            GoogleEvent var2 = (GoogleEvent)other;
            return Intrinsics.areEqual(this.event, var2.event);
         }
      }
   }
}
