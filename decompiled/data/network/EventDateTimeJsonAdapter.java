package com.example.data.network;

import androidx.compose.runtime.internal.StabilityInferred;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"},
   d2 = {"Lcom/example/data/network/EventDateTimeJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/example/data/network/EventDateTime;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "nullableStringAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class EventDateTimeJsonAdapter extends JsonAdapter {
   @NotNull
   private final JsonReader.Options options;
   @NotNull
   private final JsonAdapter nullableStringAdapter;
   @Nullable
   private volatile Constructor constructorRef;
   public static final int $stable = 8;

   public EventDateTimeJsonAdapter(@NotNull Moshi moshi) {
      Intrinsics.checkNotNullParameter(moshi, "moshi");
      super();
      String[] var2 = new String[]{"dateTime", "date", "timeZone"};
      JsonReader.Options var10001 = Options.of(var2);
      Intrinsics.checkNotNullExpressionValue(var10001, "of(...)");
      this.options = var10001;
      JsonAdapter var3 = moshi.adapter((Type)String.class, SetsKt.emptySet(), "dateTime");
      Intrinsics.checkNotNullExpressionValue(var3, "adapter(...)");
      this.nullableStringAdapter = var3;
   }

   @NotNull
   public String toString() {
      byte var1 = 35;
      StringBuilder var3_1 = new StringBuilder(var1);
      int var4 = 0;
      var3_1.append("GeneratedJsonAdapter(").append("EventDateTime").append(')');
      return var3_1.toString();
   }

   @NotNull
   public EventDateTime fromJson(@NotNull JsonReader reader) {
      Intrinsics.checkNotNullParameter(reader, "reader");
      String dateTime = null;
      String date = null;
      String timeZone = null;
      int mask0 = -1;
      reader.beginObject();

      while(reader.hasNext()) {
         switch (reader.selectName(this.options)) {
            case -1:
               reader.skipName();
               reader.skipValue();
               break;
            case 0:
               dateTime = (String)this.nullableStringAdapter.fromJson(reader);
               mask0 &= -2;
               break;
            case 1:
               date = (String)this.nullableStringAdapter.fromJson(reader);
               mask0 &= -3;
               break;
            case 2:
               timeZone = (String)this.nullableStringAdapter.fromJson(reader);
               mask0 &= -5;
         }
      }

      reader.endObject();
      if (mask0 == -8) {
         return new EventDateTime(dateTime, date, timeZone);
      } else {
         Constructor var10000 = this.constructorRef;
         if (var10000 == null) {
            Class[] var9_1 = new Class[]{String.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER};
            Constructor var9_1 = EventDateTime.class.getDeclaredConstructor(var9_1);
            int var10 = 0;
            this.constructorRef = var9_1;
            var10000 = var9_1;
            Intrinsics.checkNotNullExpressionValue(var9_1, "also(...)");
         }

         Constructor localConstructor = var10000;
         Object[] var7 = new Object[]{dateTime, date, timeZone, mask0, null};
         Object var12 = localConstructor.newInstance(var7);
         Intrinsics.checkNotNullExpressionValue(var12, "newInstance(...)");
         return (EventDateTime)var12;
      }
   }

   public void toJson(@NotNull JsonWriter writer, @Nullable EventDateTime value_) {
      Intrinsics.checkNotNullParameter(writer, "writer");
      if (value_ == null) {
         throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
      } else {
         writer.beginObject();
         writer.name("dateTime");
         this.nullableStringAdapter.toJson(writer, value_.getDateTime());
         writer.name("date");
         this.nullableStringAdapter.toJson(writer, value_.getDate());
         writer.name("timeZone");
         this.nullableStringAdapter.toJson(writer, value_.getTimeZone());
         writer.endObject();
      }
   }
}
