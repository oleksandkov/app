package com.example.data.network;

import androidx.compose.runtime.internal.StabilityInferred;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.internal.Util;
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
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"},
   d2 = {"Lcom/example/data/network/EventReminderOverrideJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/example/data/network/EventReminderOverride;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "intAdapter", "", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class EventReminderOverrideJsonAdapter extends JsonAdapter {
   @NotNull
   private final JsonReader.Options options;
   @NotNull
   private final JsonAdapter stringAdapter;
   @NotNull
   private final JsonAdapter intAdapter;
   public static final int $stable = 8;

   public EventReminderOverrideJsonAdapter(@NotNull Moshi moshi) {
      Intrinsics.checkNotNullParameter(moshi, "moshi");
      super();
      String[] var2 = new String[]{"method", "minutes"};
      JsonReader.Options var10001 = Options.of(var2);
      Intrinsics.checkNotNullExpressionValue(var10001, "of(...)");
      this.options = var10001;
      JsonAdapter var3 = moshi.adapter((Type)String.class, SetsKt.emptySet(), "method");
      Intrinsics.checkNotNullExpressionValue(var3, "adapter(...)");
      this.stringAdapter = var3;
      var3 = moshi.adapter((Type)Integer.TYPE, SetsKt.emptySet(), "minutes");
      Intrinsics.checkNotNullExpressionValue(var3, "adapter(...)");
      this.intAdapter = var3;
   }

   @NotNull
   public String toString() {
      byte var1 = 43;
      StringBuilder var3_1 = new StringBuilder(var1);
      int var4 = 0;
      var3_1.append("GeneratedJsonAdapter(").append("EventReminderOverride").append(')');
      return var3_1.toString();
   }

   @NotNull
   public EventReminderOverride fromJson(@NotNull JsonReader reader) {
      Intrinsics.checkNotNullParameter(reader, "reader");
      String method = null;
      Integer minutes = null;
      reader.beginObject();

      while(reader.hasNext()) {
         switch (reader.selectName(this.options)) {
            case -1:
               reader.skipName();
               reader.skipValue();
               break;
            case 0:
               String var4 = (String)this.stringAdapter.fromJson(reader);
               if (var4 == null) {
                  throw Util.unexpectedNull("method", "method", reader);
               }

               method = var4;
               break;
            case 1:
               Integer var10000 = (Integer)this.intAdapter.fromJson(reader);
               if (var10000 == null) {
                  throw Util.unexpectedNull("minutes", "minutes", reader);
               }

               minutes = var10000;
         }
      }

      reader.endObject();
      EventReminderOverride var5 = new EventReminderOverride;
      if (method == null) {
         throw Util.missingProperty("method", "method", reader);
      } else if (minutes != null) {
         var5.<init>(method, minutes);
         return var5;
      } else {
         throw Util.missingProperty("minutes", "minutes", reader);
      }
   }

   public void toJson(@NotNull JsonWriter writer, @Nullable EventReminderOverride value_) {
      Intrinsics.checkNotNullParameter(writer, "writer");
      if (value_ == null) {
         throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
      } else {
         writer.beginObject();
         writer.name("method");
         this.stringAdapter.toJson(writer, value_.getMethod());
         writer.name("minutes");
         this.intAdapter.toJson(writer, value_.getMinutes());
         writer.endObject();
      }
   }
}
