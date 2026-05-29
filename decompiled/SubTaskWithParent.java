package com.example;

import androidx.compose.runtime.internal.StabilityInferred;
import com.example.data.local.entity.SubTaskEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JD\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015¨\u0006\""},
   d2 = {"Lcom/example/SubTaskWithParent;", "", "subTask", "Lcom/example/data/local/entity/SubTaskEntity;", "parentTitle", "", "parentStartTime", "", "parentEndTime", "isSynced", "", "<init>", "(Lcom/example/data/local/entity/SubTaskEntity;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Z)V", "getSubTask", "()Lcom/example/data/local/entity/SubTaskEntity;", "getParentTitle", "()Ljava/lang/String;", "getParentStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getParentEndTime", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/example/data/local/entity/SubTaskEntity;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Z)Lcom/example/SubTaskWithParent;", "equals", "other", "hashCode", "", "toString", "app"}
)
@StabilityInferred(
   parameters = 1
)
public final class SubTaskWithParent {
   @NotNull
   private final SubTaskEntity subTask;
   @NotNull
   private final String parentTitle;
   @Nullable
   private final Long parentStartTime;
   @Nullable
   private final Long parentEndTime;
   private final boolean isSynced;
   public static final int $stable;

   public SubTaskWithParent(@NotNull SubTaskEntity subTask, @NotNull String parentTitle, @Nullable Long parentStartTime, @Nullable Long parentEndTime, boolean isSynced) {
      Intrinsics.checkNotNullParameter(subTask, "subTask");
      Intrinsics.checkNotNullParameter(parentTitle, "parentTitle");
      super();
      this.subTask = subTask;
      this.parentTitle = parentTitle;
      this.parentStartTime = parentStartTime;
      this.parentEndTime = parentEndTime;
      this.isSynced = isSynced;
   }

   // $FF: synthetic method
   public SubTaskWithParent(SubTaskEntity var1, String var2, Long var3, Long var4, boolean var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 4) != 0) {
         var3 = null;
      }

      if ((var6 & 8) != 0) {
         var4 = null;
      }

      if ((var6 & 16) != 0) {
         var5 = false;
      }

      this(var1, var2, var3, var4, var5);
   }

   @NotNull
   public final SubTaskEntity getSubTask() {
      return this.subTask;
   }

   @NotNull
   public final String getParentTitle() {
      return this.parentTitle;
   }

   @Nullable
   public final Long getParentStartTime() {
      return this.parentStartTime;
   }

   @Nullable
   public final Long getParentEndTime() {
      return this.parentEndTime;
   }

   public final boolean isSynced() {
      return this.isSynced;
   }

   @NotNull
   public final SubTaskEntity component1() {
      return this.subTask;
   }

   @NotNull
   public final String component2() {
      return this.parentTitle;
   }

   @Nullable
   public final Long component3() {
      return this.parentStartTime;
   }

   @Nullable
   public final Long component4() {
      return this.parentEndTime;
   }

   public final boolean component5() {
      return this.isSynced;
   }

   @NotNull
   public final SubTaskWithParent copy(@NotNull SubTaskEntity subTask, @NotNull String parentTitle, @Nullable Long parentStartTime, @Nullable Long parentEndTime, boolean isSynced) {
      Intrinsics.checkNotNullParameter(subTask, "subTask");
      Intrinsics.checkNotNullParameter(parentTitle, "parentTitle");
      return new SubTaskWithParent(subTask, parentTitle, parentStartTime, parentEndTime, isSynced);
   }

   // $FF: synthetic method
   public static SubTaskWithParent copy$default(SubTaskWithParent var0, SubTaskEntity var1, String var2, Long var3, Long var4, boolean var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.subTask;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.parentTitle;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.parentStartTime;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.parentEndTime;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.isSynced;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   @NotNull
   public String toString() {
      return "SubTaskWithParent(subTask=" + this.subTask + ", parentTitle=" + this.parentTitle + ", parentStartTime=" + this.parentStartTime + ", parentEndTime=" + this.parentEndTime + ", isSynced=" + this.isSynced + ")";
   }

   public int hashCode() {
      int result = this.subTask.hashCode();
      result = result * 31 + this.parentTitle.hashCode();
      result = result * 31 + (this.parentStartTime == null ? 0 : this.parentStartTime.hashCode());
      result = result * 31 + (this.parentEndTime == null ? 0 : this.parentEndTime.hashCode());
      result = result * 31 + Boolean.hashCode(this.isSynced);
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof SubTaskWithParent)) {
         return false;
      } else {
         SubTaskWithParent var2 = (SubTaskWithParent)other;
         if (!Intrinsics.areEqual(this.subTask, var2.subTask)) {
            return false;
         } else if (!Intrinsics.areEqual(this.parentTitle, var2.parentTitle)) {
            return false;
         } else if (!Intrinsics.areEqual(this.parentStartTime, var2.parentStartTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.parentEndTime, var2.parentEndTime)) {
            return false;
         } else {
            return this.isSynced == var2.isSynced;
         }
      }
   }
}
