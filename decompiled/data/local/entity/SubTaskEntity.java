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
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018Jn\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001bR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018¨\u0006."},
   d2 = {"Lcom/example/data/local/entity/SubTaskEntity;", "", "id", "", "userId", "", "parentIdStr", "title", "startTime", "", "endTime", "isCompleted", "", "updatedAt", "deletedAt", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ZJLjava/lang/Long;)V", "getId", "()I", "getUserId", "()Ljava/lang/String;", "getParentIdStr", "getTitle", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "()Z", "getUpdatedAt", "()J", "getDeletedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ZJLjava/lang/Long;)Lcom/example/data/local/entity/SubTaskEntity;", "equals", "other", "hashCode", "toString", "app"}
)
@Entity(
   tableName = "subtasks"
)
@StabilityInferred(
   parameters = 1
)
public final class SubTaskEntity {
   @PrimaryKey(
      autoGenerate = true
   )
   private final int id;
   @NotNull
   private final String userId;
   @NotNull
   private final String parentIdStr;
   @NotNull
   private final String title;
   @Nullable
   private final Long startTime;
   @Nullable
   private final Long endTime;
   private final boolean isCompleted;
   private final long updatedAt;
   @Nullable
   private final Long deletedAt;
   public static final int $stable;

   public SubTaskEntity(int id, @NotNull String userId, @NotNull String parentIdStr, @NotNull String title, @Nullable Long startTime, @Nullable Long endTime, boolean isCompleted, long updatedAt, @Nullable Long deletedAt) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      Intrinsics.checkNotNullParameter(parentIdStr, "parentIdStr");
      Intrinsics.checkNotNullParameter(title, "title");
      super();
      this.id = id;
      this.userId = userId;
      this.parentIdStr = parentIdStr;
      this.title = title;
      this.startTime = startTime;
      this.endTime = endTime;
      this.isCompleted = isCompleted;
      this.updatedAt = updatedAt;
      this.deletedAt = deletedAt;
   }

   // $FF: synthetic method
   public SubTaskEntity(int var1, String var2, String var3, String var4, Long var5, Long var6, boolean var7, long var8, Long var10, int var11, DefaultConstructorMarker var12) {
      if ((var11 & 1) != 0) {
         var1 = 0;
      }

      if ((var11 & 2) != 0) {
         var2 = "";
      }

      if ((var11 & 64) != 0) {
         var7 = false;
      }

      if ((var11 & 128) != 0) {
         var8 = System.currentTimeMillis();
      }

      if ((var11 & 256) != 0) {
         var10 = null;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var10);
   }

   public final int getId() {
      return this.id;
   }

   @NotNull
   public final String getUserId() {
      return this.userId;
   }

   @NotNull
   public final String getParentIdStr() {
      return this.parentIdStr;
   }

   @NotNull
   public final String getTitle() {
      return this.title;
   }

   @Nullable
   public final Long getStartTime() {
      return this.startTime;
   }

   @Nullable
   public final Long getEndTime() {
      return this.endTime;
   }

   public final boolean isCompleted() {
      return this.isCompleted;
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
      return this.parentIdStr;
   }

   @NotNull
   public final String component4() {
      return this.title;
   }

   @Nullable
   public final Long component5() {
      return this.startTime;
   }

   @Nullable
   public final Long component6() {
      return this.endTime;
   }

   public final boolean component7() {
      return this.isCompleted;
   }

   public final long component8() {
      return this.updatedAt;
   }

   @Nullable
   public final Long component9() {
      return this.deletedAt;
   }

   @NotNull
   public final SubTaskEntity copy(int id, @NotNull String userId, @NotNull String parentIdStr, @NotNull String title, @Nullable Long startTime, @Nullable Long endTime, boolean isCompleted, long updatedAt, @Nullable Long deletedAt) {
      Intrinsics.checkNotNullParameter(userId, "userId");
      Intrinsics.checkNotNullParameter(parentIdStr, "parentIdStr");
      Intrinsics.checkNotNullParameter(title, "title");
      return new SubTaskEntity(id, userId, parentIdStr, title, startTime, endTime, isCompleted, updatedAt, deletedAt);
   }

   // $FF: synthetic method
   public static SubTaskEntity copy$default(SubTaskEntity var0, int var1, String var2, String var3, String var4, Long var5, Long var6, boolean var7, long var8, Long var10, int var11, Object var12) {
      if ((var11 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var11 & 2) != 0) {
         var2 = var0.userId;
      }

      if ((var11 & 4) != 0) {
         var3 = var0.parentIdStr;
      }

      if ((var11 & 8) != 0) {
         var4 = var0.title;
      }

      if ((var11 & 16) != 0) {
         var5 = var0.startTime;
      }

      if ((var11 & 32) != 0) {
         var6 = var0.endTime;
      }

      if ((var11 & 64) != 0) {
         var7 = var0.isCompleted;
      }

      if ((var11 & 128) != 0) {
         var8 = var0.updatedAt;
      }

      if ((var11 & 256) != 0) {
         var10 = var0.deletedAt;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var10);
   }

   @NotNull
   public String toString() {
      return "SubTaskEntity(id=" + this.id + ", userId=" + this.userId + ", parentIdStr=" + this.parentIdStr + ", title=" + this.title + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", isCompleted=" + this.isCompleted + ", updatedAt=" + this.updatedAt + ", deletedAt=" + this.deletedAt + ")";
   }

   public int hashCode() {
      int result = Integer.hashCode(this.id);
      result = result * 31 + this.userId.hashCode();
      result = result * 31 + this.parentIdStr.hashCode();
      result = result * 31 + this.title.hashCode();
      result = result * 31 + (this.startTime == null ? 0 : this.startTime.hashCode());
      result = result * 31 + (this.endTime == null ? 0 : this.endTime.hashCode());
      result = result * 31 + Boolean.hashCode(this.isCompleted);
      result = result * 31 + Long.hashCode(this.updatedAt);
      result = result * 31 + (this.deletedAt == null ? 0 : this.deletedAt.hashCode());
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof SubTaskEntity)) {
         return false;
      } else {
         SubTaskEntity var2 = (SubTaskEntity)other;
         if (this.id != var2.id) {
            return false;
         } else if (!Intrinsics.areEqual(this.userId, var2.userId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.parentIdStr, var2.parentIdStr)) {
            return false;
         } else if (!Intrinsics.areEqual(this.title, var2.title)) {
            return false;
         } else if (!Intrinsics.areEqual(this.startTime, var2.startTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.endTime, var2.endTime)) {
            return false;
         } else if (this.isCompleted != var2.isCompleted) {
            return false;
         } else if (this.updatedAt != var2.updatedAt) {
            return false;
         } else {
            return Intrinsics.areEqual(this.deletedAt, var2.deletedAt);
         }
      }
   }
}
