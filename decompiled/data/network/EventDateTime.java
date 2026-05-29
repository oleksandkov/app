package com.example.data.network;

import androidx.compose.runtime.internal.StabilityInferred;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"},
   d2 = {"Lcom/example/data/network/EventDateTime;", "", "dateTime", "", "date", "timeZone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDateTime", "()Ljava/lang/String;", "getDate", "getTimeZone", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}
)
@StabilityInferred(
   parameters = 1
)
public final class EventDateTime {
   @Nullable
   private final String dateTime;
   @Nullable
   private final String date;
   @Nullable
   private final String timeZone;
   public static final int $stable;

   public EventDateTime(@Json(name = "dateTime") @Nullable String dateTime, @Json(name = "date") @Nullable String date, @Json(name = "timeZone") @Nullable String timeZone) {
      this.dateTime = dateTime;
      this.date = date;
      this.timeZone = timeZone;
   }

   // $FF: synthetic method
   public EventDateTime(String var1, String var2, String var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 1) != 0) {
         var1 = null;
      }

      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   @Nullable
   public final String getDateTime() {
      return this.dateTime;
   }

   @Nullable
   public final String getDate() {
      return this.date;
   }

   @Nullable
   public final String getTimeZone() {
      return this.timeZone;
   }

   @Nullable
   public final String component1() {
      return this.dateTime;
   }

   @Nullable
   public final String component2() {
      return this.date;
   }

   @Nullable
   public final String component3() {
      return this.timeZone;
   }

   @NotNull
   public final EventDateTime copy(@Json(name = "dateTime") @Nullable String dateTime, @Json(name = "date") @Nullable String date, @Json(name = "timeZone") @Nullable String timeZone) {
      return new EventDateTime(dateTime, date, timeZone);
   }

   // $FF: synthetic method
   public static EventDateTime copy$default(EventDateTime var0, String var1, String var2, String var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.dateTime;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.date;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.timeZone;
      }

      return var0.copy(var1, var2, var3);
   }

   @NotNull
   public String toString() {
      return "EventDateTime(dateTime=" + this.dateTime + ", date=" + this.date + ", timeZone=" + this.timeZone + ")";
   }

   public int hashCode() {
      int result = this.dateTime == null ? 0 : this.dateTime.hashCode();
      result = result * 31 + (this.date == null ? 0 : this.date.hashCode());
      result = result * 31 + (this.timeZone == null ? 0 : this.timeZone.hashCode());
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof EventDateTime)) {
         return false;
      } else {
         EventDateTime var2 = (EventDateTime)other;
         if (!Intrinsics.areEqual(this.dateTime, var2.dateTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.date, var2.date)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.timeZone, var2.timeZone);
         }
      }
   }

   public EventDateTime() {
      this((String)null, (String)null, (String)null, 7, (DefaultConstructorMarker)null);
   }
}
