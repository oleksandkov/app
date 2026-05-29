package com.example.data.network;

import androidx.compose.runtime.internal.StabilityInferred;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006'"},
   d2 = {"Lcom/example/data/network/CalendarEvent;", "", "id", "", "summary", "description", "start", "Lcom/example/data/network/EventDateTime;", "end", "htmlLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/example/data/network/EventDateTime;Lcom/example/data/network/EventDateTime;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSummary", "getDescription", "getStart", "()Lcom/example/data/network/EventDateTime;", "getEnd", "getHtmlLink", "startTimeInMillis", "", "getStartTimeInMillis", "()J", "endTimeInMillis", "getEndTimeInMillis", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}
)
@StabilityInferred(
   parameters = 1
)
public final class CalendarEvent {
   @NotNull
   private final String id;
   @Nullable
   private final String summary;
   @Nullable
   private final String description;
   @Nullable
   private final EventDateTime start;
   @Nullable
   private final EventDateTime end;
   @Nullable
   private final String htmlLink;
   public static final int $stable;

   public CalendarEvent(@Json(name = "id") @NotNull String id, @Json(name = "summary") @Nullable String summary, @Json(name = "description") @Nullable String description, @Json(name = "start") @Nullable EventDateTime start, @Json(name = "end") @Nullable EventDateTime end, @Json(name = "htmlLink") @Nullable String htmlLink) {
      Intrinsics.checkNotNullParameter(id, "id");
      super();
      this.id = id;
      this.summary = summary;
      this.description = description;
      this.start = start;
      this.end = end;
      this.htmlLink = htmlLink;
   }

   // $FF: synthetic method
   public CalendarEvent(String var1, String var2, String var3, EventDateTime var4, EventDateTime var5, String var6, int var7, DefaultConstructorMarker var8) {
      if ((var7 & 32) != 0) {
         var6 = null;
      }

      this(var1, var2, var3, var4, var5, var6);
   }

   @NotNull
   public final String getId() {
      return this.id;
   }

   @Nullable
   public final String getSummary() {
      return this.summary;
   }

   @Nullable
   public final String getDescription() {
      return this.description;
   }

   @Nullable
   public final EventDateTime getStart() {
      return this.start;
   }

   @Nullable
   public final EventDateTime getEnd() {
      return this.end;
   }

   @Nullable
   public final String getHtmlLink() {
      return this.htmlLink;
   }

   public final long getStartTimeInMillis() {
      long sdf;
      try {
         EventDateTime var10000 = this.start;
         long var9;
         if ((var10000 != null ? var10000.getDateTime() : null) != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
            String var7 = this.start.getDateTime().substring(0, 19);
            Intrinsics.checkNotNullExpressionValue(var7, "substring(...)");
            String formatted = var7;
            Date var8 = sdf.parse(formatted);
            var9 = var8 != null ? var8.getTime() : 0L;
         } else {
            EventDateTime var10 = this.start;
            if ((var10 != null ? var10.getDate() : null) != null) {
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
               Date var11 = sdf.parse(this.start.getDate());
               var9 = var11 != null ? var11.getTime() : 0L;
            } else {
               var9 = 0L;
            }
         }

         sdf = var9;
      } catch (Exception var4) {
         sdf = 0L;
      }

      return sdf;
   }

   public final long getEndTimeInMillis() {
      long sdf;
      try {
         EventDateTime var10000 = this.end;
         long var9;
         if ((var10000 != null ? var10000.getDateTime() : null) != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
            String var7 = this.end.getDateTime().substring(0, 19);
            Intrinsics.checkNotNullExpressionValue(var7, "substring(...)");
            String formatted = var7;
            Date var8 = sdf.parse(formatted);
            var9 = var8 != null ? var8.getTime() : 0L;
         } else {
            EventDateTime var10 = this.end;
            if ((var10 != null ? var10.getDate() : null) != null) {
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
               Date var11 = sdf.parse(this.end.getDate());
               var9 = var11 != null ? var11.getTime() : 0L;
            } else {
               var9 = 0L;
            }
         }

         sdf = var9;
      } catch (Exception var4) {
         sdf = 0L;
      }

      return sdf;
   }

   @NotNull
   public final String component1() {
      return this.id;
   }

   @Nullable
   public final String component2() {
      return this.summary;
   }

   @Nullable
   public final String component3() {
      return this.description;
   }

   @Nullable
   public final EventDateTime component4() {
      return this.start;
   }

   @Nullable
   public final EventDateTime component5() {
      return this.end;
   }

   @Nullable
   public final String component6() {
      return this.htmlLink;
   }

   @NotNull
   public final CalendarEvent copy(@Json(name = "id") @NotNull String id, @Json(name = "summary") @Nullable String summary, @Json(name = "description") @Nullable String description, @Json(name = "start") @Nullable EventDateTime start, @Json(name = "end") @Nullable EventDateTime end, @Json(name = "htmlLink") @Nullable String htmlLink) {
      Intrinsics.checkNotNullParameter(id, "id");
      return new CalendarEvent(id, summary, description, start, end, htmlLink);
   }

   // $FF: synthetic method
   public static CalendarEvent copy$default(CalendarEvent var0, String var1, String var2, String var3, EventDateTime var4, EventDateTime var5, String var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var7 & 2) != 0) {
         var2 = var0.summary;
      }

      if ((var7 & 4) != 0) {
         var3 = var0.description;
      }

      if ((var7 & 8) != 0) {
         var4 = var0.start;
      }

      if ((var7 & 16) != 0) {
         var5 = var0.end;
      }

      if ((var7 & 32) != 0) {
         var6 = var0.htmlLink;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6);
   }

   @NotNull
   public String toString() {
      return "CalendarEvent(id=" + this.id + ", summary=" + this.summary + ", description=" + this.description + ", start=" + this.start + ", end=" + this.end + ", htmlLink=" + this.htmlLink + ")";
   }

   public int hashCode() {
      int result = this.id.hashCode();
      result = result * 31 + (this.summary == null ? 0 : this.summary.hashCode());
      result = result * 31 + (this.description == null ? 0 : this.description.hashCode());
      result = result * 31 + (this.start == null ? 0 : this.start.hashCode());
      result = result * 31 + (this.end == null ? 0 : this.end.hashCode());
      result = result * 31 + (this.htmlLink == null ? 0 : this.htmlLink.hashCode());
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof CalendarEvent)) {
         return false;
      } else {
         CalendarEvent var2 = (CalendarEvent)other;
         if (!Intrinsics.areEqual(this.id, var2.id)) {
            return false;
         } else if (!Intrinsics.areEqual(this.summary, var2.summary)) {
            return false;
         } else if (!Intrinsics.areEqual(this.description, var2.description)) {
            return false;
         } else if (!Intrinsics.areEqual(this.start, var2.start)) {
            return false;
         } else if (!Intrinsics.areEqual(this.end, var2.end)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.htmlLink, var2.htmlLink);
         }
      }
   }
}
