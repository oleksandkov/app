package com.example.data.network;

import androidx.compose.runtime.internal.StabilityInferred;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"},
   d2 = {"Lcom/example/data/network/CalendarEventsResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/example/data/network/CalendarEventsResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "listOfCalendarEventAdapter", "", "Lcom/example/data/network/CalendarEvent;", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class CalendarEventsResponseJsonAdapter extends JsonAdapter {
   @NotNull
   private final JsonReader.Options options;
   @NotNull
   private final JsonAdapter listOfCalendarEventAdapter;
   @Nullable
   private volatile Constructor constructorRef;
   public static final int $stable = 8;

   public CalendarEventsResponseJsonAdapter(@NotNull Moshi moshi) {
      Intrinsics.checkNotNullParameter(moshi, "moshi");
      super();
      String[] var2 = new String[]{"items"};
      JsonReader.Options var10001 = Options.of(var2);
      Intrinsics.checkNotNullExpressionValue(var10001, "of(...)");
      this.options = var10001;
      Type var10002 = (Type)List.class;
      Type[] var3 = new Type[]{CalendarEvent.class};
      JsonAdapter var4 = moshi.adapter((Type)Types.newParameterizedType(var10002, var3), SetsKt.emptySet(), "items");
      Intrinsics.checkNotNullExpressionValue(var4, "adapter(...)");
      this.listOfCalendarEventAdapter = var4;
   }

   @NotNull
   public String toString() {
      byte var1 = 44;
      StringBuilder var3_1 = new StringBuilder(var1);
      int var4 = 0;
      var3_1.append("GeneratedJsonAdapter(").append("CalendarEventsResponse").append(')');
      return var3_1.toString();
   }

   @NotNull
   public CalendarEventsResponse fromJson(@NotNull JsonReader reader) {
      Intrinsics.checkNotNullParameter(reader, "reader");
      List items = null;
      int mask0 = -1;
      reader.beginObject();

      while(reader.hasNext()) {
         switch (reader.selectName(this.options)) {
            case -1:
               reader.skipName();
               reader.skipValue();
               break;
            case 0:
               List var10000 = (List)this.listOfCalendarEventAdapter.fromJson(reader);
               if (var10000 == null) {
                  throw Util.unexpectedNull("items", "items", reader);
               }

               items = var10000;
               mask0 &= -2;
         }
      }

      reader.endObject();
      if (mask0 == -2) {
         Intrinsics.checkNotNull(items, "null cannot be cast to non-null type kotlin.collections.List<com.example.data.network.CalendarEvent>");
         return new CalendarEventsResponse(items);
      } else {
         Constructor var10 = this.constructorRef;
         if (var10 == null) {
            Class[] var7_1 = new Class[]{List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER};
            Constructor var7_1 = CalendarEventsResponse.class.getDeclaredConstructor(var7_1);
            int var8 = 0;
            this.constructorRef = var7_1;
            var10 = var7_1;
            Intrinsics.checkNotNullExpressionValue(var7_1, "also(...)");
         }

         Constructor localConstructor = var10;
         Object[] var5 = new Object[]{items, mask0, null};
         Object var11 = localConstructor.newInstance(var5);
         Intrinsics.checkNotNullExpressionValue(var11, "newInstance(...)");
         return (CalendarEventsResponse)var11;
      }
   }

   public void toJson(@NotNull JsonWriter writer, @Nullable CalendarEventsResponse value_) {
      Intrinsics.checkNotNullParameter(writer, "writer");
      if (value_ == null) {
         throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
      } else {
         writer.beginObject();
         writer.name("items");
         this.listOfCalendarEventAdapter.toJson(writer, value_.getItems());
         writer.endObject();
      }
   }
}
