package com.example.data.repository;

import androidx.compose.runtime.internal.StabilityInferred;
import com.example.data.local.entity.TaskEntity;
import com.example.data.network.CalendarApiService;
import com.example.data.network.CalendarEventsResponse;
import com.example.data.network.CreateEventRequest;
import com.example.data.network.EventDateTime;
import com.example.data.network.EventReminderOverride;
import com.example.data.network.EventReminders;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"},
   d2 = {"Lcom/example/data/repository/CalendarRepository;", "", "apiService", "Lcom/example/data/network/CalendarApiService;", "<init>", "(Lcom/example/data/network/CalendarApiService;)V", "getTodayEvents", "", "Lcom/example/data/network/CalendarEvent;", "accessToken", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pushTaskToCalendar", "task", "Lcom/example/data/local/entity/TaskEntity;", "(Ljava/lang/String;Lcom/example/data/local/entity/TaskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEvent", "", "eventId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEvent", "(Ljava/lang/String;Ljava/lang/String;Lcom/example/data/local/entity/TaskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class CalendarRepository {
   @NotNull
   private final CalendarApiService apiService;
   public static final int $stable = 8;

   public CalendarRepository(@NotNull CalendarApiService apiService) {
      Intrinsics.checkNotNullParameter(apiService, "apiService");
      super();
      this.apiService = apiService;
   }

   // $FF: synthetic method
   public CalendarRepository(CalendarApiService var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         var1 = CalendarApiService.Companion.create();
      }

      this(var1);
   }

   @Nullable
   public final Object getTodayEvents(@NotNull String accessToken, @NotNull Continuation $completion) {
      Continuation $continuation;
      label20: {
         if ($completion instanceof <undefinedtype>) {
            $continuation = (<undefinedtype>)$completion;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
               $continuation.label -= Integer.MIN_VALUE;
               break label20;
            }
         }

         $continuation = new ContinuationImpl($completion) {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            // $FF: synthetic field
            Object result;
            int label;

            @Nullable
            public final Object invokeSuspend(@NotNull Object $result) {
               this.result = $result;
               this.label |= Integer.MIN_VALUE;
               return CalendarRepository.this.getTodayEvents((String)null, (Continuation)this);
            }
         };
      }

      Object $result = $continuation.result;
      Object var10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      Object var10000;
      switch ($continuation.label) {
         case 0:
            ResultKt.throwOnFailure($result);
            SimpleDateFormat var5_2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
            int timeMax = 0;
            var5_2.setTimeZone(TimeZone.getTimeZone("UTC"));
            SimpleDateFormat sdf = var5_2;
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            String timeMin = sdf.format(calendar.getTime());
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            String timeMax = sdf.format(calendar.getTime());
            CalendarApiService var18 = this.apiService;
            String var10001 = "Bearer " + accessToken;
            Intrinsics.checkNotNull(timeMin);
            Intrinsics.checkNotNull(timeMax);
            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(accessToken);
            $continuation.L$1 = SpillingKt.nullOutSpilledVariable(sdf);
            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(calendar);
            $continuation.L$3 = SpillingKt.nullOutSpilledVariable(timeMin);
            $continuation.L$4 = SpillingKt.nullOutSpilledVariable(timeMax);
            $continuation.label = 1;
            var10000 = CalendarApiService.getPrimaryCalendarEvents$default(var18, var10001, timeMin, timeMax, false, (String)null, $continuation, 24, (Object)null);
            if (var10000 == var10) {
               return var10;
            }
            break;
         case 1:
            String timeMax = (String)$continuation.L$4;
            String timeMin = (String)$continuation.L$3;
            Calendar calendar = (Calendar)$continuation.L$2;
            SimpleDateFormat sdf = (SimpleDateFormat)$continuation.L$1;
            accessToken = (String)$continuation.L$0;
            ResultKt.throwOnFailure($result);
            var10000 = $result;
            break;
         default:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }

      CalendarEventsResponse response = (CalendarEventsResponse)var10000;
      return response.getItems();
   }

   @Nullable
   public final Object pushTaskToCalendar(@NotNull String accessToken, @NotNull TaskEntity task, @NotNull Continuation $completion) {
      Calendar startCal = Calendar.getInstance();
      if (task.getStartTime() != null) {
         startCal.setTimeInMillis(task.getStartTime());
      } else {
         startCal.setTimeInMillis(task.getDate());
         startCal.set(11, 9);
         startCal.set(12, 0);
      }

      Calendar endCal = Calendar.getInstance();
      if (task.getEndTime() != null) {
         endCal.setTimeInMillis(task.getEndTime());
      } else {
         endCal.setTimeInMillis(startCal.getTimeInMillis());
         endCal.add(11, 1);
      }

      SimpleDateFormat var8_1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
      int var9 = 0;
      var8_1.setTimeZone(TimeZone.getTimeZone("UTC"));
      SimpleDateFormat sdf = var8_1;
      String startTimeStr = var8_1.format(startCal.getTime());
      String endTimeStr = sdf.format(endCal.getTime());
      EventReminders var10000;
      if (task.getHasReminder()) {
         int minutesBefore = task.getReminderMinutesBefore() != null ? task.getReminderMinutesBefore() : (task.getReminderTime() != null && task.getStartTime() != null && task.getStartTime() > task.getReminderTime() ? (int)((task.getStartTime() - task.getReminderTime()) / (long)'\uea60') : 15);
         var10000 = new EventReminders(false, CollectionsKt.listOf(new EventReminderOverride("popup", minutesBefore)));
      } else {
         var10000 = new EventReminders(true, CollectionsKt.emptyList());
      }

      EventReminders reminders = var10000;
      CreateEventRequest var14 = new CreateEventRequest;
      String var10002 = task.getTitle();
      String var10003 = task.getDescription();
      if (var10003 == null) {
         var10003 = "Created via Planner Pro";
      }

      var14.<init>(var10002, var10003, new EventDateTime(startTimeStr, (String)null, "UTC", 2, (DefaultConstructorMarker)null), new EventDateTime(endTimeStr, (String)null, "UTC", 2, (DefaultConstructorMarker)null), reminders);
      CreateEventRequest request = var14;
      return this.apiService.createEvent("Bearer " + accessToken, request, $completion);
   }

   @Nullable
   public final Object deleteEvent(@NotNull String accessToken, @NotNull String eventId, @NotNull Continuation $completion) {
      Continuation $continuation;
      label48: {
         if ($completion instanceof <undefinedtype>) {
            $continuation = (<undefinedtype>)$completion;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
               $continuation.label -= Integer.MIN_VALUE;
               break label48;
            }
         }

         $continuation = new ContinuationImpl($completion) {
            Object L$0;
            Object L$1;
            // $FF: synthetic field
            Object result;
            int label;

            @Nullable
            public final Object invokeSuspend(@NotNull Object $result) {
               this.result = $result;
               this.label |= Integer.MIN_VALUE;
               return CalendarRepository.this.deleteEvent((String)null, (String)null, (Continuation)this);
            }
         };
      }

      Object $result = $continuation.result;
      Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      switch ($continuation.label) {
         case 0:
            ResultKt.throwOnFailure($result);

            CalendarApiService var13;
            try {
               var13 = this.apiService;
               String var15 = "Bearer " + accessToken;
               $continuation.L$0 = SpillingKt.nullOutSpilledVariable(accessToken);
               $continuation.L$1 = SpillingKt.nullOutSpilledVariable(eventId);
               $continuation.label = 1;
               var13 = (CalendarApiService)var13.deleteEvent(var15, eventId, $continuation);
            } catch (Exception var9) {
               boolean var14 = false;
               return Unit.INSTANCE;
            }

            if (var13 == var7) {
               return var7;
            }
            break;
         case 1:
            eventId = (String)$continuation.L$1;
            accessToken = (String)$continuation.L$0;

            try {
               ResultKt.throwOnFailure($result);
               break;
            } catch (Exception var10) {
               boolean var10001 = false;
               return Unit.INSTANCE;
            }
         default:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }

      try {
         ;
      } catch (Exception var8) {
         boolean var16 = false;
      }

      return Unit.INSTANCE;
   }

   @Nullable
   public final Object updateEvent(@NotNull String accessToken, @NotNull String eventId, @NotNull TaskEntity task, @NotNull Continuation $completion) {
      Calendar startCal = Calendar.getInstance();
      if (task.getStartTime() != null) {
         startCal.setTimeInMillis(task.getStartTime());
      } else {
         startCal.setTimeInMillis(task.getDate());
         startCal.set(11, 9);
         startCal.set(12, 0);
      }

      Calendar endCal = Calendar.getInstance();
      if (task.getEndTime() != null) {
         endCal.setTimeInMillis(task.getEndTime());
      } else {
         endCal.setTimeInMillis(startCal.getTimeInMillis());
         endCal.add(11, 1);
      }

      SimpleDateFormat var9_1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
      int var10 = 0;
      var9_1.setTimeZone(TimeZone.getTimeZone("UTC"));
      SimpleDateFormat sdf = var9_1;
      String startTimeStr = var9_1.format(startCal.getTime());
      String endTimeStr = sdf.format(endCal.getTime());
      EventReminders var10000;
      if (task.getHasReminder()) {
         int minutesBefore = task.getReminderMinutesBefore() != null ? task.getReminderMinutesBefore() : (task.getReminderTime() != null && task.getStartTime() != null && task.getStartTime() > task.getReminderTime() ? (int)((task.getStartTime() - task.getReminderTime()) / (long)'\uea60') : 15);
         var10000 = new EventReminders(false, CollectionsKt.listOf(new EventReminderOverride("popup", minutesBefore)));
      } else {
         var10000 = new EventReminders(true, CollectionsKt.emptyList());
      }

      EventReminders reminders = var10000;
      CreateEventRequest var15 = new CreateEventRequest;
      String var10002 = task.getTitle();
      String var10003 = task.getDescription();
      if (var10003 == null) {
         var10003 = "Created/Modified via Planner Pro";
      }

      var15.<init>(var10002, var10003, new EventDateTime(startTimeStr, (String)null, "UTC", 2, (DefaultConstructorMarker)null), new EventDateTime(endTimeStr, (String)null, "UTC", 2, (DefaultConstructorMarker)null), reminders);
      CreateEventRequest request = var15;
      return this.apiService.updateEvent("Bearer " + accessToken, eventId, request, $completion);
   }

   public CalendarRepository() {
      this((CalendarApiService)null, 1, (DefaultConstructorMarker)null);
   }
}
