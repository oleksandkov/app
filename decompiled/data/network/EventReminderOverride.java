package com.example.data.network;

import androidx.compose.runtime.internal.StabilityInferred;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(
   generateAdapter = true
)
@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"},
   d2 = {"Lcom/example/data/network/EventReminderOverride;", "", "method", "", "minutes", "", "<init>", "(Ljava/lang/String;I)V", "getMethod", "()Ljava/lang/String;", "getMinutes", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app"}
)
@StabilityInferred(
   parameters = 1
)
public final class EventReminderOverride {
   @NotNull
   private final String method;
   private final int minutes;
   public static final int $stable;

   public EventReminderOverride(@Json(name = "method") @NotNull String method, @Json(name = "minutes") int minutes) {
      Intrinsics.checkNotNullParameter(method, "method");
      super();
      this.method = method;
      this.minutes = minutes;
   }

   @NotNull
   public final String getMethod() {
      return this.method;
   }

   public final int getMinutes() {
      return this.minutes;
   }

   @NotNull
   public final String component1() {
      return this.method;
   }

   public final int component2() {
      return this.minutes;
   }

   @NotNull
   public final EventReminderOverride copy(@Json(name = "method") @NotNull String method, @Json(name = "minutes") int minutes) {
      Intrinsics.checkNotNullParameter(method, "method");
      return new EventReminderOverride(method, minutes);
   }

   // $FF: synthetic method
   public static EventReminderOverride copy$default(EventReminderOverride var0, String var1, int var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.method;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.minutes;
      }

      return var0.copy(var1, var2);
   }

   @NotNull
   public String toString() {
      return "EventReminderOverride(method=" + this.method + ", minutes=" + this.minutes + ")";
   }

   public int hashCode() {
      int result = this.method.hashCode();
      result = result * 31 + Integer.hashCode(this.minutes);
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof EventReminderOverride)) {
         return false;
      } else {
         EventReminderOverride var2 = (EventReminderOverride)other;
         if (!Intrinsics.areEqual(this.method, var2.method)) {
            return false;
         } else {
            return this.minutes == var2.minutes;
         }
      }
   }
}
