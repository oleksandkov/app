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
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"},
   d2 = {"Lcom/example/data/network/CreateEventRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/example/data/network/CreateEventRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "nullableStringAdapter", "eventDateTimeAdapter", "Lcom/example/data/network/EventDateTime;", "nullableEventRemindersAdapter", "Lcom/example/data/network/EventReminders;", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "app"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nCreateEventRequestJsonAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateEventRequestJsonAdapter.kt\ncom/example/data/network/CreateEventRequestJsonAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,123:1\n1#2:124\n*E\n"})
public final class CreateEventRequestJsonAdapter extends JsonAdapter {
   @NotNull
   private final JsonReader.Options options;
   @NotNull
   private final JsonAdapter stringAdapter;
   @NotNull
   private final JsonAdapter nullableStringAdapter;
   @NotNull
   private final JsonAdapter eventDateTimeAdapter;
   @NotNull
   private final JsonAdapter nullableEventRemindersAdapter;
   @Nullable
   private volatile Constructor constructorRef;
   public static final int $stable = 8;

   public CreateEventRequestJsonAdapter(@NotNull Moshi moshi) {
      Intrinsics.checkNotNullParameter(moshi, "moshi");
      super();
      String[] var2 = new String[]{"summary", "description", "start", "end", "reminders"};
      JsonReader.Options var10001 = Options.of(var2);
      Intrinsics.checkNotNullExpressionValue(var10001, "of(...)");
      this.options = var10001;
      JsonAdapter var3 = moshi.adapter((Type)String.class, SetsKt.emptySet(), "summary");
      Intrinsics.checkNotNullExpressionValue(var3, "adapter(...)");
      this.stringAdapter = var3;
      var3 = moshi.adapter((Type)String.class, SetsKt.emptySet(), "description");
      Intrinsics.checkNotNullExpressionValue(var3, "adapter(...)");
      this.nullableStringAdapter = var3;
      var3 = moshi.adapter((Type)EventDateTime.class, SetsKt.emptySet(), "start");
      Intrinsics.checkNotNullExpressionValue(var3, "adapter(...)");
      this.eventDateTimeAdapter = var3;
      var3 = moshi.adapter((Type)EventReminders.class, SetsKt.emptySet(), "reminders");
      Intrinsics.checkNotNullExpressionValue(var3, "adapter(...)");
      this.nullableEventRemindersAdapter = var3;
   }

   @NotNull
   public String toString() {
      byte var1 = 40;
      StringBuilder var3_1 = new StringBuilder(var1);
      int var4 = 0;
      var3_1.append("GeneratedJsonAdapter(").append("CreateEventRequest").append(')');
      return var3_1.toString();
   }

   @NotNull
   public CreateEventRequest fromJson(@NotNull JsonReader reader) {
      Intrinsics.checkNotNullParameter(reader, "reader");
      String summary = null;
      String description = null;
      EventDateTime start = null;
      EventDateTime end = null;
      EventReminders reminders = null;
      int mask0 = -1;
      reader.beginObject();

      while(reader.hasNext()) {
         switch (reader.selectName(this.options)) {
            case -1:
               reader.skipName();
               reader.skipValue();
               break;
            case 0:
               String var16 = (String)this.stringAdapter.fromJson(reader);
               if (var16 == null) {
                  throw Util.unexpectedNull("summary", "summary", reader);
               }

               summary = var16;
               break;
            case 1:
               description = (String)this.nullableStringAdapter.fromJson(reader);
               break;
            case 2:
               EventDateTime var15 = (EventDateTime)this.eventDateTimeAdapter.fromJson(reader);
               if (var15 == null) {
                  throw Util.unexpectedNull("start", "start", reader);
               }

               start = var15;
               break;
            case 3:
               EventDateTime var10000 = (EventDateTime)this.eventDateTimeAdapter.fromJson(reader);
               if (var10000 == null) {
                  throw Util.unexpectedNull("end", "end", reader);
               }

               end = var10000;
               break;
            case 4:
               reminders = (EventReminders)this.nullableEventRemindersAdapter.fromJson(reader);
               mask0 &= -17;
         }
      }

      reader.endObject();
      if (mask0 == -17) {
         CreateEventRequest var18 = new CreateEventRequest;
         if (summary == null) {
            throw Util.missingProperty("summary", "summary", reader);
         } else if (start == null) {
            throw Util.missingProperty("start", "start", reader);
         } else if (end == null) {
            throw Util.missingProperty("end", "end", reader);
         } else {
            var18.<init>(summary, description, start, end, reminders);
            return var18;
         }
      } else {
         Constructor var17 = this.constructorRef;
         if (var17 == null) {
            Class[] var12_1 = new Class[]{String.class, String.class, EventDateTime.class, EventDateTime.class, EventReminders.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER};
            Constructor var12_1 = CreateEventRequest.class.getDeclaredConstructor(var12_1);
            int var13 = 0;
            this.constructorRef = var12_1;
            var17 = var12_1;
            Intrinsics.checkNotNullExpressionValue(var12_1, "also(...)");
         }

         Constructor localConstructor = var17;
         Object[] var10 = new Object[7];
         if (summary == null) {
            throw Util.missingProperty("summary", "summary", reader);
         } else {
            var10[0] = summary;
            var10[1] = description;
            if (start == null) {
               throw Util.missingProperty("start", "start", reader);
            } else {
               var10[2] = start;
               if (end == null) {
                  throw Util.missingProperty("end", "end", reader);
               } else {
                  var10[3] = end;
                  var10[4] = reminders;
                  var10[5] = mask0;
                  var10[6] = null;
                  Object var9 = localConstructor.newInstance(var10);
                  Intrinsics.checkNotNullExpressionValue(var9, "newInstance(...)");
                  return (CreateEventRequest)var9;
               }
            }
         }
      }
   }

   public void toJson(@NotNull JsonWriter writer, @Nullable CreateEventRequest value_) {
      Intrinsics.checkNotNullParameter(writer, "writer");
      if (value_ == null) {
         throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
      } else {
         writer.beginObject();
         writer.name("summary");
         this.stringAdapter.toJson(writer, value_.getSummary());
         writer.name("description");
         this.nullableStringAdapter.toJson(writer, value_.getDescription());
         writer.name("start");
         this.eventDateTimeAdapter.toJson(writer, value_.getStart());
         writer.name("end");
         this.eventDateTimeAdapter.toJson(writer, value_.getEnd());
         writer.name("reminders");
         this.nullableEventRemindersAdapter.toJson(writer, value_.getReminders());
         writer.endObject();
      }
   }
}
