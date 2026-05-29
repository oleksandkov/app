package com.example;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001e"},
   d2 = {"Lcom/example/MeetingItem;", "", "id", "", "title", "startTime", "", "endTime", "isGoogle", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJZ)V", "getId", "()Ljava/lang/String;", "getTitle", "getStartTime", "()J", "getEndTime", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app"}
)
@StabilityInferred(
   parameters = 1
)
public final class MeetingItem {
   @NotNull
   private final String id;
   @NotNull
   private final String title;
   private final long startTime;
   private final long endTime;
   private final boolean isGoogle;
   public static final int $stable;

   public MeetingItem(@NotNull String id, @NotNull String title, long startTime, long endTime, boolean isGoogle) {
      Intrinsics.checkNotNullParameter(id, "id");
      Intrinsics.checkNotNullParameter(title, "title");
      super();
      this.id = id;
      this.title = title;
      this.startTime = startTime;
      this.endTime = endTime;
      this.isGoogle = isGoogle;
   }

   @NotNull
   public final String getId() {
      return this.id;
   }

   @NotNull
   public final String getTitle() {
      return this.title;
   }

   public final long getStartTime() {
      return this.startTime;
   }

   public final long getEndTime() {
      return this.endTime;
   }

   public final boolean isGoogle() {
      return this.isGoogle;
   }

   @NotNull
   public final String component1() {
      return this.id;
   }

   @NotNull
   public final String component2() {
      return this.title;
   }

   public final long component3() {
      return this.startTime;
   }

   public final long component4() {
      return this.endTime;
   }

   public final boolean component5() {
      return this.isGoogle;
   }

   @NotNull
   public final MeetingItem copy(@NotNull String id, @NotNull String title, long startTime, long endTime, boolean isGoogle) {
      Intrinsics.checkNotNullParameter(id, "id");
      Intrinsics.checkNotNullParameter(title, "title");
      return new MeetingItem(id, title, startTime, endTime, isGoogle);
   }

   // $FF: synthetic method
   public static MeetingItem copy$default(MeetingItem var0, String var1, String var2, long var3, long var5, boolean var7, int var8, Object var9) {
      if ((var8 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var8 & 2) != 0) {
         var2 = var0.title;
      }

      if ((var8 & 4) != 0) {
         var3 = var0.startTime;
      }

      if ((var8 & 8) != 0) {
         var5 = var0.endTime;
      }

      if ((var8 & 16) != 0) {
         var7 = var0.isGoogle;
      }

      return var0.copy(var1, var2, var3, var5, var7);
   }

   @NotNull
   public String toString() {
      return "MeetingItem(id=" + this.id + ", title=" + this.title + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", isGoogle=" + this.isGoogle + ")";
   }

   public int hashCode() {
      int result = this.id.hashCode();
      result = result * 31 + this.title.hashCode();
      result = result * 31 + Long.hashCode(this.startTime);
      result = result * 31 + Long.hashCode(this.endTime);
      result = result * 31 + Boolean.hashCode(this.isGoogle);
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof MeetingItem)) {
         return false;
      } else {
         MeetingItem var2 = (MeetingItem)other;
         if (!Intrinsics.areEqual(this.id, var2.id)) {
            return false;
         } else if (!Intrinsics.areEqual(this.title, var2.title)) {
            return false;
         } else if (this.startTime != var2.startTime) {
            return false;
         } else if (this.endTime != var2.endTime) {
            return false;
         } else {
            return this.isGoogle == var2.isGoogle;
         }
      }
   }
}
