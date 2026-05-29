package com.example.notification;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.ListenableWorker.Result;
import com.example.data.local.AppDatabase;
import com.example.data.local.dao.NoteDao;
import com.example.data.local.dao.TaskDao;
import com.example.data.local.entity.NoteEntity;
import com.example.data.local.entity.TaskEntity;
import com.example.settings.UserPreferencesRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"},
   d2 = {"Lcom/example/notification/ReminderWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nReminderWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReminderWorker.kt\ncom/example/notification/ReminderWorker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n1#2:70\n*E\n"})
public final class ReminderWorker extends CoroutineWorker {
   public static final int $stable = 8;

   public ReminderWorker(@NotNull Context context, @NotNull WorkerParameters workerParams) {
      Intrinsics.checkNotNullParameter(context, "context");
      Intrinsics.checkNotNullParameter(workerParams, "workerParams");
      super(context, workerParams);
   }

   @Nullable
   public Object doWork(@NotNull Continuation $completion) {
      Continuation $continuation;
      label120: {
         if ($completion instanceof <undefinedtype>) {
            $continuation = (<undefinedtype>)$completion;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
               $continuation.label -= Integer.MIN_VALUE;
               break label120;
            }
         }

         $continuation = new ContinuationImpl($completion) {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            boolean Z$0;
            // $FF: synthetic field
            Object result;
            int label;

            @Nullable
            public final Object invokeSuspend(@NotNull Object $result) {
               this.result = $result;
               this.label |= Integer.MIN_VALUE;
               return ReminderWorker.this.doWork((Continuation)this);
            }
         };
      }

      label114: {
         AppDatabase.Companion var10000;
         label139: {
            TaskEntity task;
            label140: {
               label134: {
                  Object var18;
                  int id;
                  String type;
                  UserPreferencesRepository prefsRepository;
                  boolean muted;
                  AppDatabase db;
                  TaskDao taskDao;
                  label125: {
                     Object $result = $continuation.result;
                     var18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     switch ($continuation.label) {
                        case 0:
                           ResultKt.throwOnFailure($result);
                           id = this.getInputData().getInt("id", -1);
                           String var39 = this.getInputData().getString("type");
                           if (var39 == null) {
                              var39 = "task";
                           }

                           type = var39;
                           if (id == -1) {
                              ListenableWorker.Result var52 = Result.failure();
                              Intrinsics.checkNotNullExpressionValue(var52, "failure(...)");
                              return var52;
                           }

                           Context var10002 = this.getApplicationContext();
                           Intrinsics.checkNotNullExpressionValue(var10002, "getApplicationContext(...)");
                           prefsRepository = new UserPreferencesRepository(var10002);
                           Flow var40 = prefsRepository.getNotificationsMutedFlow();
                           $continuation.L$0 = type;
                           $continuation.L$1 = prefsRepository;
                           $continuation.I$0 = id;
                           $continuation.label = 1;
                           var10000 = FlowKt.first(var40, $continuation);
                           if (var10000 == var18) {
                              return var18;
                           }
                           break;
                        case 1:
                           id = $continuation.I$0;
                           prefsRepository = (UserPreferencesRepository)$continuation.L$1;
                           type = (String)$continuation.L$0;
                           ResultKt.throwOnFailure($result);
                           var10000 = $result;
                           break;
                        case 2:
                           muted = $continuation.Z$0;
                           id = $continuation.I$0;
                           taskDao = (TaskDao)$continuation.L$3;
                           db = (AppDatabase)$continuation.L$2;
                           prefsRepository = (UserPreferencesRepository)$continuation.L$1;
                           type = (String)$continuation.L$0;
                           ResultKt.throwOnFailure($result);
                           var10000 = $result;
                           break label125;
                        case 3:
                           boolean isGoogleEvent = (boolean)$continuation.I$1;
                           muted = $continuation.Z$0;
                           id = $continuation.I$0;
                           task = (TaskEntity)$continuation.L$4;
                           taskDao = (TaskDao)$continuation.L$3;
                           db = (AppDatabase)$continuation.L$2;
                           prefsRepository = (UserPreferencesRepository)$continuation.L$1;
                           type = (String)$continuation.L$0;
                           ResultKt.throwOnFailure($result);
                           var10000 = $result;
                           break label134;
                        case 4:
                           muted = $continuation.Z$0;
                           id = $continuation.I$0;
                           NoteDao noteDao = (NoteDao)$continuation.L$3;
                           db = (AppDatabase)$continuation.L$2;
                           prefsRepository = (UserPreferencesRepository)$continuation.L$1;
                           type = (String)$continuation.L$0;
                           ResultKt.throwOnFailure($result);
                           var10000 = (AppDatabase.Companion)$result;
                           break label139;
                        default:
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     muted = (Boolean)var10000;
                     var10000 = AppDatabase.Companion;
                     Context var10001 = this.getApplicationContext();
                     Intrinsics.checkNotNullExpressionValue(var10001, "getApplicationContext(...)");
                     db = var10000.getDatabase(var10001);
                     if (!Intrinsics.areEqual(type, "task")) {
                        if (muted) {
                           ListenableWorker.Result var51 = Result.success();
                           Intrinsics.checkNotNullExpressionValue(var51, "success(...)");
                           return var51;
                        }

                        NoteDao noteDao = db.noteDao();
                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(type);
                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(prefsRepository);
                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(db);
                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable(noteDao);
                        $continuation.I$0 = id;
                        $continuation.Z$0 = muted;
                        $continuation.label = 4;
                        var10000 = (AppDatabase.Companion)noteDao.getNoteById(id, $continuation);
                        if (var10000 == var18) {
                           return var18;
                        }
                        break label139;
                     }

                     taskDao = db.taskDao();
                     $continuation.L$0 = SpillingKt.nullOutSpilledVariable(type);
                     $continuation.L$1 = prefsRepository;
                     $continuation.L$2 = SpillingKt.nullOutSpilledVariable(db);
                     $continuation.L$3 = SpillingKt.nullOutSpilledVariable(taskDao);
                     $continuation.I$0 = id;
                     $continuation.Z$0 = muted;
                     $continuation.label = 2;
                     var10000 = taskDao.getTaskById(id, $continuation);
                     if (var10000 == var18) {
                        return var18;
                     }
                  }

                  task = (TaskEntity)var10000;
                  if (task == null || task.isCompleted()) {
                     break label114;
                  }

                  CharSequence var10 = (CharSequence)task.getExternalCalendarEventId();
                  boolean isGoogleEvent = var10 != null && var10.length() != 0;
                  if (isGoogleEvent == 0) {
                     if (muted) {
                        ListenableWorker.Result var48 = Result.success();
                        Intrinsics.checkNotNullExpressionValue(var48, "success(...)");
                        return var48;
                     }
                     break label140;
                  }

                  Flow var42 = prefsRepository.getGoogleCalendarRemindersEnabledFlow();
                  $continuation.L$0 = SpillingKt.nullOutSpilledVariable(type);
                  $continuation.L$1 = SpillingKt.nullOutSpilledVariable(prefsRepository);
                  $continuation.L$2 = SpillingKt.nullOutSpilledVariable(db);
                  $continuation.L$3 = SpillingKt.nullOutSpilledVariable(taskDao);
                  $continuation.L$4 = task;
                  $continuation.I$0 = id;
                  $continuation.Z$0 = muted;
                  $continuation.I$1 = isGoogleEvent;
                  $continuation.label = 3;
                  var10000 = FlowKt.first(var42, $continuation);
                  if (var10000 == var18) {
                     return var18;
                  }
               }

               boolean calendarRemindersEnabled = (Boolean)var10000;
               if (!calendarRemindersEnabled) {
                  ListenableWorker.Result var43 = Result.success();
                  Intrinsics.checkNotNullExpressionValue(var43, "success(...)");
                  return var43;
               }
            }

            String var46;
            if (!task.isTimeBoxed()) {
               var46 = task.getDescription();
               if (var46 == null) {
                  var46 = "Task Reminder";
               }
            } else {
               label74: {
                  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
                  Long var44 = task.getStartTime();
                  if (var44 != null) {
                     long var13 = ((Number)var44).longValue();
                     int var15 = 0;
                     var46 = sdf.format(new Date(var13));
                     if (var46 != null) {
                        break label74;
                     }
                  }

                  var46 = "00:00";
               }

               String timeString = var46;
               var46 = "Scheduled for " + timeString;
            }

            String timeText = var46;
            NotificationHelper var47 = NotificationHelper.INSTANCE;
            Context var53 = this.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(var53, "getApplicationContext(...)");
            var47.showNotification(var53, task.getId(), task.getTitle(), timeText);
            break label114;
         }

         NoteEntity note = (NoteEntity)var10000;
         if (note != null) {
            NotificationHelper var49 = NotificationHelper.INSTANCE;
            Context var54 = this.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(var54, "getApplicationContext(...)");
            var49.showNotification(var54, note.getId() + 100000, "Note Review: " + note.getTitle(), StringsKt.take(note.getContent(), 80));
         }
      }

      ListenableWorker.Result var50 = Result.success();
      Intrinsics.checkNotNullExpressionValue(var50, "success(...)");
      return var50;
   }
}
