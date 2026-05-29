package com.example.data.network;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J@\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0015J,\u0010\u0016\u001a\u00020\r2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0017¨\u0006\u0019À\u0006\u0003"},
   d2 = {"Lcom/example/data/network/CalendarApiService;", "", "getPrimaryCalendarEvents", "Lcom/example/data/network/CalendarEventsResponse;", "authHeader", "", "timeMin", "timeMax", "singleEvents", "", "orderBy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createEvent", "Lcom/example/data/network/CalendarEvent;", "event", "Lcom/example/data/network/CreateEventRequest;", "(Ljava/lang/String;Lcom/example/data/network/CreateEventRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEvent", "Lretrofit2/Response;", "", "eventId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEvent", "(Ljava/lang/String;Ljava/lang/String;Lcom/example/data/network/CreateEventRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app"}
)
public interface CalendarApiService {
   @NotNull
   Companion Companion = CalendarApiService.Companion.$$INSTANCE;

   @GET("calendars/primary/events")
   @Nullable
   Object getPrimaryCalendarEvents(@Header("Authorization") @NotNull String var1, @Query("timeMin") @NotNull String var2, @Query("timeMax") @NotNull String var3, @Query("singleEvents") boolean var4, @Query("orderBy") @NotNull String var5, @NotNull Continuation var6);

   // $FF: synthetic method
   static Object getPrimaryCalendarEvents$default(CalendarApiService var0, String var1, String var2, String var3, boolean var4, String var5, Continuation var6, int var7, Object var8) {
      if (var8 != null) {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrimaryCalendarEvents");
      } else {
         if ((var7 & 8) != 0) {
            var4 = true;
         }

         if ((var7 & 16) != 0) {
            var5 = "startTime";
         }

         return var0.getPrimaryCalendarEvents(var1, var2, var3, var4, var5, var6);
      }
   }

   @POST("calendars/primary/events")
   @Nullable
   Object createEvent(@Header("Authorization") @NotNull String var1, @Body @NotNull CreateEventRequest var2, @NotNull Continuation var3);

   @DELETE("calendars/primary/events/{eventId}")
   @Nullable
   Object deleteEvent(@Header("Authorization") @NotNull String var1, @Path("eventId") @NotNull String var2, @NotNull Continuation var3);

   @PUT("calendars/primary/events/{eventId}")
   @Nullable
   Object updateEvent(@Header("Authorization") @NotNull String var1, @Path("eventId") @NotNull String var2, @Body @NotNull CreateEventRequest var3, @NotNull Continuation var4);

   @Metadata(
      mv = {2, 2, 0},
      k = 3,
      xi = 48
   )
   public static final class DefaultImpls {
      // $FF: synthetic method
      public static Object getPrimaryCalendarEvents$default(CalendarApiService var0, String var1, String var2, String var3, boolean var4, String var5, Continuation var6, int var7, Object var8) {
         return CalendarApiService.getPrimaryCalendarEvents$default(var0, var1, var2, var3, var4, var5, var6, var7, var8);
      }
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/example/data/network/CalendarApiService$Companion;", "", "<init>", "()V", "create", "Lcom/example/data/network/CalendarApiService;", "app"}
   )
   public static final class Companion {
      // $FF: synthetic field
      static final Companion $$INSTANCE = new Companion();

      private Companion() {
      }

      @NotNull
      public final CalendarApiService create() {
         Moshi moshi = (new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build();
         Object var10000 = (new Retrofit.Builder()).baseUrl("https://www.googleapis.com/calendar/v3/").addConverterFactory((Converter.Factory)MoshiConverterFactory.create(moshi)).build().create(CalendarApiService.class);
         Intrinsics.checkNotNullExpressionValue(var10000, "create(...)");
         return (CalendarApiService)var10000;
      }
   }
}
