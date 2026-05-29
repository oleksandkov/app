package com.example.data.network;

import androidx.compose.runtime.internal.StabilityInferred;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"},
   d2 = {"Lcom/example/data/network/CalendarEventsResponse;", "", "items", "", "Lcom/example/data/network/CalendarEvent;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class CalendarEventsResponse {
   @NotNull
   private final List items;
   public static final int $stable = 8;

   public CalendarEventsResponse(@Json(name = "items") @NotNull List items) {
      Intrinsics.checkNotNullParameter(items, "items");
      super();
      this.items = items;
   }

   // $FF: synthetic method
   public CalendarEventsResponse(List var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         var1 = CollectionsKt.emptyList();
      }

      this(var1);
   }

   @NotNull
   public final List getItems() {
      return this.items;
   }

   @NotNull
   public final List component1() {
      return this.items;
   }

   @NotNull
   public final CalendarEventsResponse copy(@Json(name = "items") @NotNull List items) {
      Intrinsics.checkNotNullParameter(items, "items");
      return new CalendarEventsResponse(items);
   }

   // $FF: synthetic method
   public static CalendarEventsResponse copy$default(CalendarEventsResponse var0, List var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.items;
      }

      return var0.copy(var1);
   }

   @NotNull
   public String toString() {
      return "CalendarEventsResponse(items=" + this.items + ")";
   }

   public int hashCode() {
      return this.items.hashCode();
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof CalendarEventsResponse)) {
         return false;
      } else {
         CalendarEventsResponse var2 = (CalendarEventsResponse)other;
         return Intrinsics.areEqual(this.items, var2.items);
      }
   }

   public CalendarEventsResponse() {
      this((List)null, 1, (DefaultConstructorMarker)null);
   }
}
