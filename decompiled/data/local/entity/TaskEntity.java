package com.example.data.local.entity;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001B©\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010!J\t\u00104\u001a\u00020\rHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010:\u001a\u00020\rHÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010!J¼\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\r2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010$R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010$R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010!R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010$R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b,\u0010!¨\u0006C"},
   d2 = {"Lcom/example/data/local/entity/TaskEntity;", "", "id", "", "userId", "", "title", "description", "date", "", "startTime", "endTime", "isTimeBoxed", "", "isCompleted", "hasReminder", "reminderTime", "reminderMinutesBefore", "externalCalendarEventId", "isMeeting", "updatedAt", "deletedAt", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;ZZZLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;ZJLjava/lang/Long;)V", "getId", "()I", "getUserId", "()Ljava/lang/String;", "getTitle", "getDescription", "getDate", "()J", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "()Z", "getHasReminder", "getReminderTime", "getReminderMinutesBefore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExternalCalendarEventId", "getUpdatedAt", "getDeletedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;ZZZLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;ZJLjava/lang/Long;)Lcom/example/data/local/entity/TaskEntity;", "equals", "other", "hashCode", "toString", "app"}
)
@Entity(
   tableName = "tasks"
)
@StabilityInferred(
   parameters = 1
)
public final class TaskEntity {
   @PrimaryKey(
      autoGenerate = true
   )
   private final int id;
   @NotNull
   private final String userId;
   @NotNull
   private final String title;
   @Nullable
   private final String description;
   private final long date;
   @Nullable
   private final Long startTime;
   @Nullable
   private final Long endTime;
   private final boolean isTimeBoxed;
   private final boolean isCompleted;
   private final boolean hasReminder;
   @Nullable
   private final Long reminderTime;
   @Nullable
   private final Integer reminderMinutesBefore;
   @Nullable
   private final String externalCalendarEventId;
   private final boolean isMeeting;
   private final long updatedAt;
   @Nullable
   private final Long deletedAt;
   public static final int $stable;

   public TaskEntity(int id, @NotNull String userId, @NotNull String title, @Nullable String description, long date, @Nullable Long startTime, @Nullable Long endTime, boolean isTimeBoxed, boolean isCompleted, boolean hasReminder, @Nullable Long reminderTime, @Nullable Integer reminderMinutesBefore, @Nullable String externalCalendarEventId, boolean isMeeting, long updatedAt, @Nullable Long deletedAt) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      Intrinsics.checkNotNullParameter(title, "title");
      super();
      this.id = id;
      this.userId = userId;
      this.title = title;
      this.description = description;
      this.date = date;
      this.startTime = startTime;
      this.endTime = endTime;
      this.isTimeBoxed = isTimeBoxed;
      this.isCompleted = isCompleted;
      this.hasReminder = hasReminder;
      this.reminderTime = reminderTime;
      this.reminderMinutesBefore = reminderMinutesBefore;
      this.externalCalendarEventId = externalCalendarEventId;
      this.isMeeting = isMeeting;
      this.updatedAt = updatedAt;
      this.deletedAt = deletedAt;
   }

   // $FF: synthetic method
   public TaskEntity(int var1, String var2, String var3, String var4, long var5, Long var7, Long var8, boolean var9, boolean var10, boolean var11, Long var12, Integer var13, String var14, boolean var15, long var16, Long var18, int var19, DefaultConstructorMarker var20) {
      if ((var19 & 1) != 0) {
         var1 = 0;
      }

      if ((var19 & 2) != 0) {
         var2 = "";
      }

      if ((var19 & 256) != 0) {
         var10 = false;
      }

      if ((var19 & 512) != 0) {
         var11 = false;
      }

      if ((var19 & 1024) != 0) {
         var12 = null;
      }

      if ((var19 & 2048) != 0) {
         var13 = null;
      }

      if ((var19 & 4096) != 0) {
         var14 = null;
      }

      if ((var19 & 8192) != 0) {
         var15 = false;
      }

      if ((var19 & 16384) != 0) {
         var16 = System.currentTimeMillis();
      }

      if ((var19 & '耀') != 0) {
         var18 = null;
      }

      this(var1, var2, var3, var4, var5, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var18);
   }

   public final int getId() {
      return this.id;
   }

   @NotNull
   public final String getUserId() {
      return this.userId;
   }

   @NotNull
   public final String getTitle() {
      return this.title;
   }

   @Nullable
   public final String getDescription() {
      return this.description;
   }

   public final long getDate() {
      return this.date;
   }

   @Nullable
   public final Long getStartTime() {
      return this.startTime;
   }

   @Nullable
   public final Long getEndTime() {
      return this.endTime;
   }

   public final boolean isTimeBoxed() {
      return this.isTimeBoxed;
   }

   public final boolean isCompleted() {
      return this.isCompleted;
   }

   public final boolean getHasReminder() {
      return this.hasReminder;
   }

   @Nullable
   public final Long getReminderTime() {
      return this.reminderTime;
   }

   @Nullable
   public final Integer getReminderMinutesBefore() {
      return this.reminderMinutesBefore;
   }

   @Nullable
   public final String getExternalCalendarEventId() {
      return this.externalCalendarEventId;
   }

   public final boolean isMeeting() {
      return this.isMeeting;
   }

   public final long getUpdatedAt() {
      return this.updatedAt;
   }

   @Nullable
   public final Long getDeletedAt() {
      return this.deletedAt;
   }

   public final int component1() {
      return this.id;
   }

   @NotNull
   public final String component2() {
      return this.userId;
   }

   @NotNull
   public final String component3() {
      return this.title;
   }

   @Nullable
   public final String component4() {
      return this.description;
   }

   public final long component5() {
      return this.date;
   }

   @Nullable
   public final Long component6() {
      return this.startTime;
   }

   @Nullable
   public final Long component7() {
      return this.endTime;
   }

   public final boolean component8() {
      return this.isTimeBoxed;
   }

   public final boolean component9() {
      return this.isCompleted;
   }

   public final boolean component10() {
      return this.hasReminder;
   }

   @Nullable
   public final Long component11() {
      return this.reminderTime;
   }

   @Nullable
   public final Integer component12() {
      return this.reminderMinutesBefore;
   }

   @Nullable
   public final String component13() {
      return this.externalCalendarEventId;
   }

   public final boolean component14() {
      return this.isMeeting;
   }

   public final long component15() {
      return this.updatedAt;
   }

   @Nullable
   public final Long component16() {
      return this.deletedAt;
   }

   @NotNull
   public final TaskEntity copy(int id, @NotNull String userId, @NotNull String title, @Nullable String description, long date, @Nullable Long startTime, @Nullable Long endTime, boolean isTimeBoxed, boolean isCompleted, boolean hasReminder, @Nullable Long reminderTime, @Nullable Integer reminderMinutesBefore, @Nullable String externalCalendarEventId, boolean isMeeting, long updatedAt, @Nullable Long deletedAt) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      Intrinsics.checkNotNullParameter(title, "title");
      return new TaskEntity(id, userId, title, description, date, startTime, endTime, isTimeBoxed, isCompleted, hasReminder, reminderTime, reminderMinutesBefore, externalCalendarEventId, isMeeting, updatedAt, deletedAt);
   }

   // $FF: synthetic method
   public static TaskEntity copy$default(TaskEntity var0, int var1, String var2, String var3, String var4, long var5, Long var7, Long var8, boolean var9, boolean var10, boolean var11, Long var12, Integer var13, String var14, boolean var15, long var16, Long var18, int var19, Object var20) {
      if ((var19 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var19 & 2) != 0) {
         var2 = var0.userId;
      }

      if ((var19 & 4) != 0) {
         var3 = var0.title;
      }

      if ((var19 & 8) != 0) {
         var4 = var0.description;
      }

      if ((var19 & 16) != 0) {
         var5 = var0.date;
      }

      if ((var19 & 32) != 0) {
         var7 = var0.startTime;
      }

      if ((var19 & 64) != 0) {
         var8 = var0.endTime;
      }

      if ((var19 & 128) != 0) {
         var9 = var0.isTimeBoxed;
      }

      if ((var19 & 256) != 0) {
         var10 = var0.isCompleted;
      }

      if ((var19 & 512) != 0) {
         var11 = var0.hasReminder;
      }

      if ((var19 & 1024) != 0) {
         var12 = var0.reminderTime;
      }

      if ((var19 & 2048) != 0) {
         var13 = var0.reminderMinutesBefore;
      }

      if ((var19 & 4096) != 0) {
         var14 = var0.externalCalendarEventId;
      }

      if ((var19 & 8192) != 0) {
         var15 = var0.isMeeting;
      }

      if ((var19 & 16384) != 0) {
         var16 = var0.updatedAt;
      }

      if ((var19 & '耀') != 0) {
         var18 = var0.deletedAt;
      }

      return var0.copy(var1, var2, var3, var4, var5, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var18);
   }

   @NotNull
   public String toString() {
      return "TaskEntity(id=" + this.id + ", userId=" + this.userId + ", title=" + this.title + ", description=" + this.description + ", date=" + this.date + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", isTimeBoxed=" + this.isTimeBoxed + ", isCompleted=" + this.isCompleted + ", hasReminder=" + this.hasReminder + ", reminderTime=" + this.reminderTime + ", reminderMinutesBefore=" + this.reminderMinutesBefore + ", externalCalendarEventId=" + this.externalCalendarEventId + ", isMeeting=" + this.isMeeting + ", updatedAt=" + this.updatedAt + ", deletedAt=" + this.deletedAt + ")";
   }

   public int hashCode() {
      int result = Integer.hashCode(this.id);
      result = result * 31 + this.userId.hashCode();
      result = result * 31 + this.title.hashCode();
      result = result * 31 + (this.description == null ? 0 : this.description.hashCode());
      result = result * 31 + Long.hashCode(this.date);
      result = result * 31 + (this.startTime == null ? 0 : this.startTime.hashCode());
      result = result * 31 + (this.endTime == null ? 0 : this.endTime.hashCode());
      result = result * 31 + Boolean.hashCode(this.isTimeBoxed);
      result = result * 31 + Boolean.hashCode(this.isCompleted);
      result = result * 31 + Boolean.hashCode(this.hasReminder);
      result = result * 31 + (this.reminderTime == null ? 0 : this.reminderTime.hashCode());
      result = result * 31 + (this.reminderMinutesBefore == null ? 0 : this.reminderMinutesBefore.hashCode());
      result = result * 31 + (this.externalCalendarEventId == null ? 0 : this.externalCalendarEventId.hashCode());
      result = result * 31 + Boolean.hashCode(this.isMeeting);
      result = result * 31 + Long.hashCode(this.updatedAt);
      result = result * 31 + (this.deletedAt == null ? 0 : this.deletedAt.hashCode());
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof TaskEntity)) {
         return false;
      } else {
         TaskEntity var2 = (TaskEntity)other;
         if (this.id != var2.id) {
            return false;
         } else if (!Intrinsics.areEqual(this.userId, var2.userId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.title, var2.title)) {
            return false;
         } else if (!Intrinsics.areEqual(this.description, var2.description)) {
            return false;
         } else if (this.date != var2.date) {
            return false;
         } else if (!Intrinsics.areEqual(this.startTime, var2.startTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.endTime, var2.endTime)) {
            return false;
         } else if (this.isTimeBoxed != var2.isTimeBoxed) {
            return false;
         } else if (this.isCompleted != var2.isCompleted) {
            return false;
         } else if (this.hasReminder != var2.hasReminder) {
            return false;
         } else if (!Intrinsics.areEqual(this.reminderTime, var2.reminderTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.reminderMinutesBefore, var2.reminderMinutesBefore)) {
            return false;
         } else if (!Intrinsics.areEqual(this.externalCalendarEventId, var2.externalCalendarEventId)) {
            return false;
         } else if (this.isMeeting != var2.isMeeting) {
            return false;
         } else if (this.updatedAt != var2.updatedAt) {
            return false;
         } else {
            return Intrinsics.areEqual(this.deletedAt, var2.deletedAt);
         }
      }
   }
}
