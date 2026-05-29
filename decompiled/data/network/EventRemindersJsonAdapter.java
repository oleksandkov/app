package com.example.data.network;

import androidx.compose.runtime.internal.StabilityInferred;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.internal.Util;
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
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"},
   d2 = {"Lcom/example/data/network/EventRemindersJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/example/data/network/EventReminders;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "booleanAdapter", "", "listOfEventReminderOverrideAdapter", "", "Lcom/example/data/network/EventReminderOverride;", "toString", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class EventRemindersJsonAdapter extends JsonAdapter {
   @NotNull
   private final JsonReader.Options options;
   @NotNull
   private final JsonAdapter booleanAdapter;
   @NotNull
   private final JsonAdapter listOfEventReminderOverrideAdapter;
   public static final int $stable = 8;

   public EventRemindersJsonAdapter(@NotNull Moshi moshi) {
      Intrinsics.checkNotNullParameter(moshi, "moshi");
      super();
      String[] var2 = new String[]{"useDefault", "overrides"};
      JsonReader.Options var10001 = Options.of(var2);
      Intrinsics.checkNotNullExpressionValue(var10001, "of(...)");
      this.options = var10001;
      JsonAdapter var4 = moshi.adapter((Type)Boolean.TYPE, SetsKt.emptySet(), "useDefault");
      Intrinsics.checkNotNullExpressionValue(var4, "adapter(...)");
      this.booleanAdapter = var4;
      Type var10002 = (Type)List.class;
      Type[] var3 = new Type[]{EventReminderOverride.class};
      var4 = moshi.adapter((Type)Types.newParameterizedType(var10002, var3), SetsKt.emptySet(), "overrides");
      Intrinsics.checkNotNullExpressionValue(var4, "adapter(...)");
      this.listOfEventReminderOverrideAdapter = var4;
   }

   @NotNull
   public String toString() {
      byte var1 = 36;
      StringBuilder var3_1 = new StringBuilder(var1);
      int var4 = 0;
      var3_1.append("GeneratedJsonAdapter(").append("EventReminders").append(')');
      return var3_1.toString();
   }

   @NotNull
   public EventReminders fromJson(@NotNull JsonReader reader) {
      Intrinsics.checkNotNullParameter(reader, "reader");
      Boolean useDefault = null;
      List overrides = null;
      reader.beginObject();

      while(reader.hasNext()) {
         switch (reader.selectName(this.options)) {
            case -1:
               reader.skipName();
               reader.skipValue();
               break;
            case 0:
               Boolean var4 = (Boolean)this.booleanAdapter.fromJson(reader);
               if (var4 == null) {
                  throw Util.unexpectedNull("useDefault", "useDefault", reader);
               }

               useDefault = var4;
               break;
            case 1:
               List var10000 = (List)this.listOfEventReminderOverrideAdapter.fromJson(reader);
               if (var10000 == null) {
                  throw Util.unexpectedNull("overrides", "overrides", reader);
               }

               overrides = var10000;
         }
      }

      reader.endObject();
      EventReminders var5 = new EventReminders;
      if (useDefault != null) {
         boolean var10002 = useDefault;
         if (overrides == null) {
            throw Util.missingProperty("overrides", "overrides", reader);
         } else {
            var5.<init>(var10002, overrides);
            return var5;
         }
      } else {
         throw Util.missingProperty("useDefault", "useDefault", reader);
      }
   }

   public void toJson(@NotNull JsonWriter writer, @Nullable EventReminders value_) {
      Intrinsics.checkNotNullParameter(writer, "writer");
      if (value_ == null) {
         throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
      } else {
         writer.beginObject();
         writer.name("useDefault");
         this.booleanAdapter.toJson(writer, value_.getUseDefault());
         writer.name("overrides");
         this.listOfEventReminderOverrideAdapter.toJson(writer, value_.getOverrides());
         writer.endObject();
      }
   }
}
