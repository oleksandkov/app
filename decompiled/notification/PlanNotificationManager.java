package com.example.notification;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import com.example.data.local.AppDatabase;
import com.example.data.local.entity.TaskEntity;
import com.example.data.network.CalendarEvent;
import com.example.settings.UserPreferencesRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"},
   d2 = {"Lcom/example/notification/PlanNotificationManager;", "", "<init>", "()V", "UNIQUE_WORK_NAME", "", "cachedGoogleEvents", "", "Lcom/example/data/network/CalendarEvent;", "getCachedGoogleEvents", "()Ljava/util/List;", "setCachedGoogleEvents", "(Ljava/util/List;)V", "lastActivePlanId", "updateCurrentPlanNotification", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nPlanNotificationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlanNotificationManager.kt\ncom/example/notification/PlanNotificationManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 OneTimeWorkRequest.kt\nandroidx/work/OneTimeWorkRequestKt\n*L\n1#1,149:1\n1617#2,9:150\n1869#2:159\n1870#2:161\n1626#2:162\n774#2:163\n865#2,2:164\n295#2,2:166\n295#2:168\n296#2:170\n774#2:171\n865#2,2:172\n774#2:174\n865#2,2:175\n1617#2,9:177\n1869#2:186\n1870#2:188\n1626#2:189\n1563#2:190\n1634#2,3:191\n1#3:160\n1#3:169\n1#3:187\n105#4:194\n*S KotlinDebug\n*F\n+ 1 PlanNotificationManager.kt\ncom/example/notification/PlanNotificationManager\n*L\n53#1:150,9\n53#1:159\n53#1:161\n53#1:162\n54#1:163\n54#1:164,2\n62#1:166,2\n76#1:168\n76#1:170\n112#1:171\n112#1:172,2\n115#1:174\n115#1:175,2\n119#1:177,9\n119#1:186\n119#1:188\n119#1:189\n120#1:190\n120#1:191,3\n53#1:160\n119#1:187\n133#1:194\n*E\n"})
public final class PlanNotificationManager {
   @NotNull
   public static final PlanNotificationManager INSTANCE = new PlanNotificationManager();
   @NotNull
   private static final String UNIQUE_WORK_NAME = "current_plan_notification_update";
   @NotNull
   private static volatile List cachedGoogleEvents = CollectionsKt.emptyList();
   @Nullable
   private static String lastActivePlanId;
   public static final int $stable = 8;

   private PlanNotificationManager() {
   }

   @NotNull
   public final List getCachedGoogleEvents() {
      return cachedGoogleEvents;
   }

   public final void setCachedGoogleEvents(@NotNull List var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      cachedGoogleEvents = var1;
   }

   @Nullable
   public final Object updateCurrentPlanNotification(@NotNull Context context, @NotNull Continuation $completion) {
      Continuation $continuation;
      label319: {
         if ($completion instanceof <undefinedtype>) {
            $continuation = (<undefinedtype>)$completion;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
               $continuation.label -= Integer.MIN_VALUE;
               break label319;
            }
         }

         $continuation = new ContinuationImpl($completion) {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            Object L$10;
            Object L$11;
            Object L$12;
            boolean Z$0;
            boolean Z$1;
            long J$0;
            long J$1;
            long J$2;
            // $FF: synthetic field
            Object result;
            int label;

            @Nullable
            public final Object invokeSuspend(@NotNull Object $result) {
               this.result = $result;
               this.label |= Integer.MIN_VALUE;
               return PlanNotificationManager.this.updateCurrentPlanNotification((Context)null, (Continuation)this);
            }
         };
      }

      long now;
      Long nextBoundaryTime;
      label371: {
         String melody;
         Object var10000;
         label372: {
            Object var42;
            UserPreferencesRepository prefsRepository;
            boolean enabled;
            AppDatabase db;
            Calendar cal;
            long startOfDay;
            long endOfDay;
            String userId;
            List tasks;
            Set syncedEventIds;
            List uniqueGoogleEvents;
            String activePlanTitle;
            String currentPlanId;
            TaskEntity activeTask;
            boolean soundEnabled;
            label373: {
               label350: {
                  label326: {
                     Object $result = $continuation.result;
                     var42 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     switch ($continuation.label) {
                        case 0:
                           ResultKt.throwOnFailure($result);
                           prefsRepository = new UserPreferencesRepository(context);
                           Flow var144 = prefsRepository.getPlanNotificationEnabledFlow();
                           $continuation.L$0 = context;
                           $continuation.L$1 = prefsRepository;
                           $continuation.label = 1;
                           var10000 = FlowKt.first(var144, $continuation);
                           if (var10000 == var42) {
                              return var42;
                           }
                           break;
                        case 1:
                           prefsRepository = (UserPreferencesRepository)$continuation.L$1;
                           context = (Context)$continuation.L$0;
                           ResultKt.throwOnFailure($result);
                           var10000 = $result;
                           break;
                        case 2:
                           endOfDay = $continuation.J$2;
                           startOfDay = $continuation.J$1;
                           now = $continuation.J$0;
                           enabled = $continuation.Z$0;
                           userId = (String)$continuation.L$4;
                           cal = (Calendar)$continuation.L$3;
                           db = (AppDatabase)$continuation.L$2;
                           prefsRepository = (UserPreferencesRepository)$continuation.L$1;
                           context = (Context)$continuation.L$0;
                           ResultKt.throwOnFailure($result);
                           var10000 = $result;
                           break label326;
                        case 3:
                           endOfDay = $continuation.J$2;
                           startOfDay = $continuation.J$1;
                           now = $continuation.J$0;
                           enabled = $continuation.Z$0;
                           activeTask = (TaskEntity)$continuation.L$11;
                           currentPlanId = (String)$continuation.L$10;
                           nextBoundaryTime = (Long)$continuation.L$9;
                           activePlanTitle = (String)$continuation.L$8;
                           uniqueGoogleEvents = (List)$continuation.L$7;
                           syncedEventIds = (Set)$continuation.L$6;
                           tasks = (List)$continuation.L$5;
                           userId = (String)$continuation.L$4;
                           cal = (Calendar)$continuation.L$3;
                           db = (AppDatabase)$continuation.L$2;
                           prefsRepository = (UserPreferencesRepository)$continuation.L$1;
                           context = (Context)$continuation.L$0;
                           ResultKt.throwOnFailure($result);
                           var10000 = $result;
                           break label350;
                        case 4:
                           soundEnabled = $continuation.Z$1;
                           endOfDay = $continuation.J$2;
                           startOfDay = $continuation.J$1;
                           now = $continuation.J$0;
                           enabled = $continuation.Z$0;
                           activeTask = (TaskEntity)$continuation.L$11;
                           currentPlanId = (String)$continuation.L$10;
                           nextBoundaryTime = (Long)$continuation.L$9;
                           activePlanTitle = (String)$continuation.L$8;
                           uniqueGoogleEvents = (List)$continuation.L$7;
                           syncedEventIds = (Set)$continuation.L$6;
                           tasks = (List)$continuation.L$5;
                           userId = (String)$continuation.L$4;
                           cal = (Calendar)$continuation.L$3;
                           db = (AppDatabase)$continuation.L$2;
                           prefsRepository = (UserPreferencesRepository)$continuation.L$1;
                           context = (Context)$continuation.L$0;
                           ResultKt.throwOnFailure($result);
                           var10000 = $result;
                           break label373;
                        case 5:
                           soundEnabled = $continuation.Z$1;
                           endOfDay = $continuation.J$2;
                           startOfDay = $continuation.J$1;
                           now = $continuation.J$0;
                           enabled = $continuation.Z$0;
                           melody = (String)$continuation.L$12;
                           activeTask = (TaskEntity)$continuation.L$11;
                           currentPlanId = (String)$continuation.L$10;
                           nextBoundaryTime = (Long)$continuation.L$9;
                           activePlanTitle = (String)$continuation.L$8;
                           uniqueGoogleEvents = (List)$continuation.L$7;
                           syncedEventIds = (Set)$continuation.L$6;
                           tasks = (List)$continuation.L$5;
                           userId = (String)$continuation.L$4;
                           cal = (Calendar)$continuation.L$3;
                           db = (AppDatabase)$continuation.L$2;
                           prefsRepository = (UserPreferencesRepository)$continuation.L$1;
                           context = (Context)$continuation.L$0;
                           ResultKt.throwOnFailure($result);
                           var10000 = $result;
                           break label372;
                        default:
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     enabled = (Boolean)var10000;
                     if (!enabled) {
                        NotificationHelper.INSTANCE.updateStickyNotification(context, (String)null);

                        try {
                           WorkManager.Companion.getInstance(context).cancelUniqueWork("current_plan_notification_update");
                        } catch (Exception e) {
                           e.printStackTrace();
                        }

                        return Unit.INSTANCE;
                     }

                     db = AppDatabase.Companion.getDatabase(context);
                     now = System.currentTimeMillis();
                     cal = Calendar.getInstance();
                     cal.setTimeInMillis(now);
                     cal.set(11, 0);
                     cal.set(12, 0);
                     cal.set(13, 0);
                     cal.set(14, 0);
                     startOfDay = cal.getTimeInMillis();
                     cal.set(11, 23);
                     cal.set(12, 59);
                     cal.set(13, 59);
                     endOfDay = cal.getTimeInMillis();

                     try {
                        label289: {
                           FirebaseUser var145 = FirebaseAuth.getInstance().getCurrentUser();
                           if (var145 != null) {
                              var146 = var145.getUid();
                              if (var146 != null) {
                                 break label289;
                              }
                           }

                           var146 = "";
                        }

                        tasks = var146;
                     } catch (Exception var45) {
                        tasks = "";
                     }

                     userId = tasks;
                     Flow var147 = db.taskDao().getTasksForDate(tasks, startOfDay, endOfDay);
                     $continuation.L$0 = context;
                     $continuation.L$1 = prefsRepository;
                     $continuation.L$2 = SpillingKt.nullOutSpilledVariable(db);
                     $continuation.L$3 = SpillingKt.nullOutSpilledVariable(cal);
                     $continuation.L$4 = SpillingKt.nullOutSpilledVariable(tasks);
                     $continuation.Z$0 = enabled;
                     $continuation.J$0 = now;
                     $continuation.J$1 = startOfDay;
                     $continuation.J$2 = endOfDay;
                     $continuation.label = 2;
                     var10000 = FlowKt.first(var147, $continuation);
                     if (var10000 == var42) {
                        return var42;
                     }
                  }

                  tasks = (List)var10000;
                  Iterable uniqueGoogleEvents = (Iterable)tasks;
                  int activePlanTitle = 0;
                  Collection currentPlanId = (Collection)(new ArrayList());
                  int activeTask = 0;
                  int var74 = 0;

                  for(Object var25_1 : uniqueGoogleEvents) {
                     int var26 = 0;
                     TaskEntity var27 = (TaskEntity)var25_1;
                     int var28 = 0;
                     String var148 = var27.getExternalCalendarEventId();
                     if (var148 != null) {
                        Object var29 = var148;
                        int var30 = 0;
                        currentPlanId.add(var29);
                     }
                  }

                  syncedEventIds = CollectionsKt.toSet((Iterable)((List)currentPlanId));
                  Iterable activePlanTitle = (Iterable)cachedGoogleEvents;
                  int nextBoundaryTime = 0;
                  Collection activeTask = (Collection)(new ArrayList());
                  soundEnabled = (boolean)0;

                  for(Object endStr : activePlanTitle) {
                     CalendarEvent var25_1 = (CalendarEvent)endStr;
                     int var25 = 0;
                     if (!syncedEventIds.contains(var25_1.getId())) {
                        activeTask.add(endStr);
                     }
                  }

                  uniqueGoogleEvents = (List)activeTask;
                  activePlanTitle = null;
                  nextBoundaryTime = null;
                  currentPlanId = null;
                  Iterable sdf = (Iterable)tasks;
                  var74 = 0;
                  Iterator var83 = sdf.iterator();

                  while(true) {
                     if (!var83.hasNext()) {
                        var10000 = null;
                        break;
                     }

                     Object var25_1 = var83.next();
                     TaskEntity var101 = (TaskEntity)var25_1;
                     int var107 = 0;
                     if (var101.isTimeBoxed() && var101.getStartTime() != null && var101.getEndTime() != null && now >= var101.getStartTime() && now < var101.getEndTime()) {
                        var10000 = var25_1;
                        break;
                     }
                  }

                  activeTask = (TaskEntity)var10000;
                  if (activeTask != null) {
                     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
                     Long var10003 = activeTask.getStartTime();
                     Intrinsics.checkNotNull(var10003);
                     String startStr = sdf.format(new Date(var10003));
                     var10003 = activeTask.getEndTime();
                     Intrinsics.checkNotNull(var10003);
                     String endStr = sdf.format(new Date(var10003));
                     activePlanTitle = activeTask.getTitle() + " (" + startStr + " - " + endStr + ")";
                     nextBoundaryTime = activeTask.getEndTime();
                     currentPlanId = "local_" + activeTask.getId();
                  } else {
                     Iterable sdf = (Iterable)uniqueGoogleEvents;
                     int start = 0;
                     Iterator var25_1 = sdf.iterator();

                     while(true) {
                        if (var25_1.hasNext()) {
                           Object var102 = var25_1.next();
                           CalendarEvent var108 = (CalendarEvent)var102;
                           int var112 = 0;
                           long var117 = var108.getStartTimeInMillis();
                           Long var128 = Boxing.boxLong(var108.getEndTimeInMillis());
                           long var31 = ((Number)var128).longValue();
                           int var33 = 0;
                           long var34 = (var31 > 0L ? var128 : null) != null ? var31 > 0L ? var128 : null : var117 + 3600000L;
                           if (now < var117 || now >= var34) {
                              continue;
                           }

                           var10000 = var102;
                           break;
                        }

                        var10000 = null;
                        break;
                     }

                     CalendarEvent activeGoogleEvent = (CalendarEvent)var10000;
                     if (activeGoogleEvent != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
                        long start = activeGoogleEvent.getStartTimeInMillis();
                        Long endStr = Boxing.boxLong(activeGoogleEvent.getEndTimeInMillis());
                        long var124 = ((Number)endStr).longValue();
                        int var133 = 0;
                        long end = (var124 > 0L ? endStr : null) != null ? var124 > 0L ? endStr : null : start + 3600000L;
                        String startStr = sdf.format(new Date(start));
                        String endStr = sdf.format(new Date(end));
                        String var151 = activeGoogleEvent.getSummary();
                        if (var151 == null) {
                           var151 = "Meeting";
                        }

                        activePlanTitle = var151 + " (" + startStr + " - " + endStr + ")";
                        nextBoundaryTime = Boxing.boxLong(end);
                        currentPlanId = "google_" + activeGoogleEvent.getId();
                     }
                  }

                  if (activePlanTitle == null) {
                     lastActivePlanId = null;
                     NotificationHelper.INSTANCE.updateStickyNotification(context, (String)null);
                     Iterable var80 = (Iterable)tasks;
                     int nextTaskTime = 0;
                     Collection end = (Collection)(new ArrayList());
                     int var109 = 0;

                     for(Object var120 : var80) {
                        TaskEntity var125 = (TaskEntity)var120;
                        int var129 = 0;
                        if (var125.isTimeBoxed() && var125.getStartTime() != null && var125.getStartTime() > now) {
                           end.add(var120);
                        }
                     }

                     List upcomingTasks = (List)end;
                     Iterable workRequest = (Iterable)uniqueGoogleEvents;
                     int var95 = 0;
                     Collection var110 = (Collection)(new ArrayList());
                     int var115 = 0;

                     for(Object var126 : workRequest) {
                        CalendarEvent var130 = (CalendarEvent)var126;
                        int var134 = 0;
                        if (var130.getStartTimeInMillis() > now) {
                           var110.add(var126);
                        }
                     }

                     List upcomingGoogleEvents = (List)var110;
                     Iterable var25_1 = (Iterable)upcomingTasks;
                     int var105 = 0;
                     Collection var116 = (Collection)(new ArrayList());
                     int var122 = 0;
                     int var131 = 0;

                     for(Object var33_2 : var25_1) {
                        int var139 = 0;
                        TaskEntity var35 = (TaskEntity)var33_2;
                        int var36 = 0;
                        Long var155 = var35.getStartTime();
                        if (var155 != null) {
                           Object var37 = var155;
                           int var38 = 0;
                           var116.add(var37);
                        }
                     }

                     Long nextTaskTime = (Long)CollectionsKt.minOrNull((Iterable)((List)var116));
                     Iterable var106 = (Iterable)upcomingGoogleEvents;
                     int var111 = 0;
                     Collection var123 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var106, 10)));
                     int var127 = 0;

                     for(Object var136 : var106) {
                        CalendarEvent var33_2 = (CalendarEvent)var136;
                        int var138 = 0;
                        var123.add(Boxing.boxLong(var33_2.getStartTimeInMillis()));
                     }

                     Long nextEventTime = (Long)CollectionsKt.minOrNull((Iterable)((List)var123));
                     if (nextTaskTime == null || nextEventTime != null && nextTaskTime >= nextEventTime) {
                        if (nextEventTime != null) {
                           nextBoundaryTime = nextEventTime;
                        }
                     } else {
                        nextBoundaryTime = nextTaskTime;
                     }
                     break label371;
                  }

                  NotificationHelper.INSTANCE.updateStickyNotification(context, activePlanTitle);
                  if (currentPlanId == null || Intrinsics.areEqual(currentPlanId, lastActivePlanId)) {
                     break label371;
                  }

                  lastActivePlanId = currentPlanId;
                  Flow var152 = prefsRepository.getNotificationSoundEnabledFlow();
                  $continuation.L$0 = context;
                  $continuation.L$1 = prefsRepository;
                  $continuation.L$2 = SpillingKt.nullOutSpilledVariable(db);
                  $continuation.L$3 = SpillingKt.nullOutSpilledVariable(cal);
                  $continuation.L$4 = SpillingKt.nullOutSpilledVariable(userId);
                  $continuation.L$5 = SpillingKt.nullOutSpilledVariable(tasks);
                  $continuation.L$6 = SpillingKt.nullOutSpilledVariable(syncedEventIds);
                  $continuation.L$7 = SpillingKt.nullOutSpilledVariable(uniqueGoogleEvents);
                  $continuation.L$8 = SpillingKt.nullOutSpilledVariable(activePlanTitle);
                  $continuation.L$9 = nextBoundaryTime;
                  $continuation.L$10 = SpillingKt.nullOutSpilledVariable(currentPlanId);
                  $continuation.L$11 = SpillingKt.nullOutSpilledVariable(activeTask);
                  $continuation.Z$0 = enabled;
                  $continuation.J$0 = now;
                  $continuation.J$1 = startOfDay;
                  $continuation.J$2 = endOfDay;
                  $continuation.label = 3;
                  var10000 = FlowKt.first(var152, $continuation);
                  if (var10000 == var42) {
                     return var42;
                  }
               }

               soundEnabled = (Boolean)var10000;
               if (!soundEnabled) {
                  break label371;
               }

               Flow var153 = prefsRepository.getNotificationMelodyFlow();
               $continuation.L$0 = context;
               $continuation.L$1 = prefsRepository;
               $continuation.L$2 = SpillingKt.nullOutSpilledVariable(db);
               $continuation.L$3 = SpillingKt.nullOutSpilledVariable(cal);
               $continuation.L$4 = SpillingKt.nullOutSpilledVariable(userId);
               $continuation.L$5 = SpillingKt.nullOutSpilledVariable(tasks);
               $continuation.L$6 = SpillingKt.nullOutSpilledVariable(syncedEventIds);
               $continuation.L$7 = SpillingKt.nullOutSpilledVariable(uniqueGoogleEvents);
               $continuation.L$8 = SpillingKt.nullOutSpilledVariable(activePlanTitle);
               $continuation.L$9 = nextBoundaryTime;
               $continuation.L$10 = SpillingKt.nullOutSpilledVariable(currentPlanId);
               $continuation.L$11 = SpillingKt.nullOutSpilledVariable(activeTask);
               $continuation.Z$0 = enabled;
               $continuation.J$0 = now;
               $continuation.J$1 = startOfDay;
               $continuation.J$2 = endOfDay;
               $continuation.Z$1 = soundEnabled;
               $continuation.label = 4;
               var10000 = FlowKt.first(var153, $continuation);
               if (var10000 == var42) {
                  return var42;
               }
            }

            melody = (String)var10000;
            Flow var154 = prefsRepository.getNotificationVolumeFlow();
            $continuation.L$0 = context;
            $continuation.L$1 = SpillingKt.nullOutSpilledVariable(prefsRepository);
            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(db);
            $continuation.L$3 = SpillingKt.nullOutSpilledVariable(cal);
            $continuation.L$4 = SpillingKt.nullOutSpilledVariable(userId);
            $continuation.L$5 = SpillingKt.nullOutSpilledVariable(tasks);
            $continuation.L$6 = SpillingKt.nullOutSpilledVariable(syncedEventIds);
            $continuation.L$7 = SpillingKt.nullOutSpilledVariable(uniqueGoogleEvents);
            $continuation.L$8 = SpillingKt.nullOutSpilledVariable(activePlanTitle);
            $continuation.L$9 = nextBoundaryTime;
            $continuation.L$10 = SpillingKt.nullOutSpilledVariable(currentPlanId);
            $continuation.L$11 = SpillingKt.nullOutSpilledVariable(activeTask);
            $continuation.L$12 = melody;
            $continuation.Z$0 = enabled;
            $continuation.J$0 = now;
            $continuation.J$1 = startOfDay;
            $continuation.J$2 = endOfDay;
            $continuation.Z$1 = soundEnabled;
            $continuation.label = 5;
            var10000 = FlowKt.first(var154, $continuation);
            if (var10000 == var42) {
               return var42;
            }
         }

         int volume = ((Number)var10000).intValue();
         NotificationHelper.INSTANCE.playMelody(context, melody, volume);
      }

      if (nextBoundaryTime != null) {
         long delay = nextBoundaryTime - now;
         if (delay > 0L) {
            int var98 = 0;
            OneTimeWorkRequest workRequest = (OneTimeWorkRequest)((OneTimeWorkRequest.Builder)(new OneTimeWorkRequest.Builder(PlanNotificationWorker.class)).setInitialDelay(delay, TimeUnit.MILLISECONDS)).build();

            try {
               Operation var25_1 = WorkManager.Companion.getInstance(context).enqueueUniqueWork("current_plan_notification_update", ExistingWorkPolicy.REPLACE, workRequest);
            } catch (Exception e) {
               e.printStackTrace();
               Unit var25_1 = Unit.INSTANCE;
            }
         }
      }

      return Unit.INSTANCE;
   }
}
