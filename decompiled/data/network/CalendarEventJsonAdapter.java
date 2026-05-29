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
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"},
   d2 = {"Lcom/example/data/network/CalendarEventJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/example/data/network/CalendarEvent;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "nullableStringAdapter", "nullableEventDateTimeAdapter", "Lcom/example/data/network/EventDateTime;", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class CalendarEventJsonAdapter extends JsonAdapter {
   @NotNull
   private final JsonReader.Options options;
   @NotNull
   private final JsonAdapter stringAdapter;
   @NotNull
   private final JsonAdapter nullableStringAdapter;
   @NotNull
   private final JsonAdapter nullableEventDateTimeAdapter;
   @Nullable
   private volatile Constructor constructorRef;
   public static final int $stable = 8;

   public CalendarEventJsonAdapter(@NotNull Moshi moshi) {
      Intrinsics.checkNotNullParameter(moshi, "moshi");
      super();
      String[] var2 = new String[]{"id", "summary", "description", "start", "end", "htmlLink"};
      JsonReader.Options var10001 = Options.of(var2);
      Intrinsics.checkNotNullExpressionValue(var10001, "of(...)");
      this.options = var10001;
      JsonAdapter var3 = moshi.adapter((Type)String.class, SetsKt.emptySet(), "id");
      Intrinsics.checkNotNullExpressionValue(var3, "adapter(...)");
      this.stringAdapter = var3;
      var3 = moshi.adapter((Type)String.class, SetsKt.emptySet(), "summary");
      Intrinsics.checkNotNullExpressionValue(var3, "adapter(...)");
      this.nullableStringAdapter = var3;
      var3 = moshi.adapter((Type)EventDateTime.class, SetsKt.emptySet(), "start");
      Intrinsics.checkNotNullExpressionValue(var3, "adapter(...)");
      this.nullableEventDateTimeAdapter = var3;
   }

   @NotNull
   public String toString() {
      byte var1 = 35;
      StringBuilder var3_1 = new StringBuilder(var1);
      int var4 = 0;
      var3_1.append("GeneratedJsonAdapter(").append("CalendarEvent").append(')');
      return var3_1.toString();
   }

   @NotNull
   public CalendarEvent fromJson(@NotNull JsonReader reader) {
      Intrinsics.checkNotNullParameter(reader, "reader");
      String id = null;
      String summary = null;
      String description = null;
      EventDateTime start = null;
      EventDateTime end = null;
      String htmlLink = null;
      int mask0 = -1;
      reader.beginObject();

      while(reader.hasNext()) {
         switch (reader.selectName(this.options)) {
            case -1:
               reader.skipName();
               reader.skipValue();
               break;
            case 0:
               String var10000 = (String)this.stringAdapter.fromJson(reader);
               if (var10000 == null) {
                  throw Util.unexpectedNull("id", "id", reader);
               }

               id = var10000;
               break;
            case 1:
               summary = (String)this.nullableStringAdapter.fromJson(reader);
               break;
            case 2:
               description = (String)this.nullableStringAdapter.fromJson(reader);
               break;
            case 3:
               start = (EventDateTime)this.nullableEventDateTimeAdapter.fromJson(reader);
               break;
            case 4:
               end = (EventDateTime)this.nullableEventDateTimeAdapter.fromJson(reader);
               break;
            case 5:
               htmlLink = (String)this.nullableStringAdapter.fromJson(reader);
               mask0 &= -33;
         }
      }

      reader.endObject();
      if (mask0 == -33) {
         CalendarEvent var17 = new CalendarEvent;
         if (id == null) {
            throw Util.missingProperty("id", "id", reader);
         } else {
            var17.<init>(id, summary, description, start, end, htmlLink);
            return var17;
         }
      } else {
         Constructor var16 = this.constructorRef;
         if (var16 == null) {
            Class[] var13_1 = new Class[]{String.class, String.class, String.class, EventDateTime.class, EventDateTime.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER};
            Constructor var13_1 = CalendarEvent.class.getDeclaredConstructor(var13_1);
            int var14 = 0;
            this.constructorRef = var13_1;
            var16 = var13_1;
            Intrinsics.checkNotNullExpressionValue(var13_1, "also(...)");
         }

         Constructor localConstructor = var16;
         Object[] var11 = new Object[8];
         if (id == null) {
            throw Util.missingProperty("id", "id", reader);
         } else {
            var11[0] = id;
            var11[1] = summary;
            var11[2] = description;
            var11[3] = start;
            var11[4] = end;
            var11[5] = htmlLink;
            var11[6] = mask0;
            var11[7] = null;
            Object var10 = localConstructor.newInstance(var11);
            Intrinsics.checkNotNullExpressionValue(var10, "newInstance(...)");
            return (CalendarEvent)var10;
         }
      }
   }

   public void toJson(@NotNull JsonWriter writer, @Nullable CalendarEvent value_) {
      Intrinsics.checkNotNullParameter(writer, "writer");
      if (value_ == null) {
         throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
      } else {
         writer.beginObject();
         writer.name("id");
         this.stringAdapter.toJson(writer, value_.getId());
         writer.name("summary");
         this.nullableStringAdapter.toJson(writer, value_.getSummary());
         writer.name("description");
         this.nullableStringAdapter.toJson(writer, value_.getDescription());
         writer.name("start");
         this.nullableEventDateTimeAdapter.toJson(writer, value_.getStart());
         writer.name("end");
         this.nullableEventDateTimeAdapter.toJson(writer, value_.getEnd());
         writer.name("htmlLink");
         this.nullableStringAdapter.toJson(writer, value_.getHtmlLink());
         writer.endObject();
      }
   }
}
