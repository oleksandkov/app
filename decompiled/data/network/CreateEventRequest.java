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
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "},
   d2 = {"Lcom/example/data/network/CreateEventRequest;", "", "summary", "", "description", "start", "Lcom/example/data/network/EventDateTime;", "end", "reminders", "Lcom/example/data/network/EventReminders;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/example/data/network/EventDateTime;Lcom/example/data/network/EventDateTime;Lcom/example/data/network/EventReminders;)V", "getSummary", "()Ljava/lang/String;", "getDescription", "getStart", "()Lcom/example/data/network/EventDateTime;", "getEnd", "getReminders", "()Lcom/example/data/network/EventReminders;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class CreateEventRequest {
   @NotNull
   private final String summary;
   @Nullable
   private final String description;
   @NotNull
   private final EventDateTime start;
   @NotNull
   private final EventDateTime end;
   @Nullable
   private final EventReminders reminders;
   public static final int $stable = 8;

   public CreateEventRequest(@Json(name = "summary") @NotNull String summary, @Json(name = "description") @Nullable String description, @Json(name = "start") @NotNull EventDateTime start, @Json(name = "end") @NotNull EventDateTime end, @Json(name = "reminders") @Nullable EventReminders reminders) {
      Intrinsics.checkNotNullParameter(summary, "summary");
      Intrinsics.checkNotNullParameter(start, "start");
      Intrinsics.checkNotNullParameter(end, "end");
      super();
      this.summary = summary;
      this.description = description;
      this.start = start;
      this.end = end;
      this.reminders = reminders;
   }

   // $FF: synthetic method
   public CreateEventRequest(String var1, String var2, EventDateTime var3, EventDateTime var4, EventReminders var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 16) != 0) {
         var5 = null;
      }

      this(var1, var2, var3, var4, var5);
   }

   @NotNull
   public final String getSummary() {
      return this.summary;
   }

   @Nullable
   public final String getDescription() {
      return this.description;
   }

   @NotNull
   public final EventDateTime getStart() {
      return this.start;
   }

   @NotNull
   public final EventDateTime getEnd() {
      return this.end;
   }

   @Nullable
   public final EventReminders getReminders() {
      return this.reminders;
   }

   @NotNull
   public final String component1() {
      return this.summary;
   }

   @Nullable
   public final String component2() {
      return this.description;
   }

   @NotNull
   public final EventDateTime component3() {
      return this.start;
   }

   @NotNull
   public final EventDateTime component4() {
      return this.end;
   }

   @Nullable
   public final EventReminders component5() {
      return this.reminders;
   }

   @NotNull
   public final CreateEventRequest copy(@Json(name = "summary") @NotNull String summary, @Json(name = "description") @Nullable String description, @Json(name = "start") @NotNull EventDateTime start, @Json(name = "end") @NotNull EventDateTime end, @Json(name = "reminders") @Nullable EventReminders reminders) {
      Intrinsics.checkNotNullParameter(summary, "summary");
      Intrinsics.checkNotNullParameter(start, "start");
      Intrinsics.checkNotNullParameter(end, "end");
      return new CreateEventRequest(summary, description, start, end, reminders);
   }

   // $FF: synthetic method
   public static CreateEventRequest copy$default(CreateEventRequest var0, String var1, String var2, EventDateTime var3, EventDateTime var4, EventReminders var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.summary;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.description;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.start;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.end;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.reminders;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   @NotNull
   public String toString() {
      return "CreateEventRequest(summary=" + this.summary + ", description=" + this.description + ", start=" + this.start + ", end=" + this.end + ", reminders=" + this.reminders + ")";
   }

   public int hashCode() {
      int result = this.summary.hashCode();
      result = result * 31 + (this.description == null ? 0 : this.description.hashCode());
      result = result * 31 + this.start.hashCode();
      result = result * 31 + this.end.hashCode();
      result = result * 31 + (this.reminders == null ? 0 : this.reminders.hashCode());
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof CreateEventRequest)) {
         return false;
      } else {
         CreateEventRequest var2 = (CreateEventRequest)other;
         if (!Intrinsics.areEqual(this.summary, var2.summary)) {
            return false;
         } else if (!Intrinsics.areEqual(this.description, var2.description)) {
            return false;
         } else if (!Intrinsics.areEqual(this.start, var2.start)) {
            return false;
         } else if (!Intrinsics.areEqual(this.end, var2.end)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.reminders, var2.reminders);
         }
      }
   }
}
