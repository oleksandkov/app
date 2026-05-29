package com.example.data.network;

import androidx.compose.runtime.internal.StabilityInferred;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
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
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"},
   d2 = {"Lcom/example/data/network/EventReminders;", "", "useDefault", "", "overrides", "", "Lcom/example/data/network/EventReminderOverride;", "<init>", "(ZLjava/util/List;)V", "getUseDefault", "()Z", "getOverrides", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class EventReminders {
   private final boolean useDefault;
   @NotNull
   private final List overrides;
   public static final int $stable = 8;

   public EventReminders(@Json(name = "useDefault") boolean useDefault, @Json(name = "overrides") @NotNull List overrides) {
      Intrinsics.checkNotNullParameter(overrides, "overrides");
      super();
      this.useDefault = useDefault;
      this.overrides = overrides;
   }

   public final boolean getUseDefault() {
      return this.useDefault;
   }

   @NotNull
   public final List getOverrides() {
      return this.overrides;
   }

   public final boolean component1() {
      return this.useDefault;
   }

   @NotNull
   public final List component2() {
      return this.overrides;
   }

   @NotNull
   public final EventReminders copy(@Json(name = "useDefault") boolean useDefault, @Json(name = "overrides") @NotNull List overrides) {
      Intrinsics.checkNotNullParameter(overrides, "overrides");
      return new EventReminders(useDefault, overrides);
   }

   // $FF: synthetic method
   public static EventReminders copy$default(EventReminders var0, boolean var1, List var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.useDefault;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.overrides;
      }

      return var0.copy(var1, var2);
   }

   @NotNull
   public String toString() {
      return "EventReminders(useDefault=" + this.useDefault + ", overrides=" + this.overrides + ")";
   }

   public int hashCode() {
      int result = Boolean.hashCode(this.useDefault);
      result = result * 31 + this.overrides.hashCode();
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof EventReminders)) {
         return false;
      } else {
         EventReminders var2 = (EventReminders)other;
         if (this.useDefault != var2.useDefault) {
            return false;
         } else {
            return Intrinsics.areEqual(this.overrides, var2.overrides);
         }
      }
   }
}
