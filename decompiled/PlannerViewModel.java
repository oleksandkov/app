package com.example;

import android.app.Application;
import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.auth.AuthManager;
import com.example.calendar.CalendarSyncViewModel;
import com.example.data.local.AppDatabase;
import com.example.data.local.dao.NoteDao;
import com.example.data.local.dao.SubTaskDao;
import com.example.data.local.dao.TaskDao;
import com.example.data.local.entity.NoteEntity;
import com.example.data.local.entity.SubTaskEntity;
import com.example.data.local.entity.TaskEntity;
import com.example.data.network.CalendarEvent;
import com.example.notification.PlanNotificationManager;
import com.example.notification.ReminderScheduler;
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
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.SharingStarted.Companion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0014J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0014H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0014H\u0002J\u008f\u0001\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u000f2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020-2\b\b\u0002\u00103\u001a\u00020-2\n\b\u0002\u00104\u001a\u0004\u0018\u00010/2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u00106\u001a\u00020-2\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020%08¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010<J\u000e\u0010=\u001a\u00020%2\u0006\u0010;\u001a\u00020\u001bJ\u0016\u0010@\u001a\u00020%2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000fJ\u000e\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020\"J\u000e\u0010D\u001a\u00020%2\u0006\u0010;\u001a\u00020\u001bJ\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020H0\u001a2\u0006\u0010K\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010LJ\u001c\u0010M\u001a\u00020%2\u0006\u0010K\u001a\u00020\u000f2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020H0\u001aJ\u001e\u0010O\u001a\u00020\u000f2\b\u0010P\u001a\u0004\u0018\u00010\u000f2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020H0\u001aJ(\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020H2\u0006\u0010T\u001a\u00020-2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020XR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u001d\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0018R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0018¨\u0006Y"},
   d2 = {"Lcom/example/PlannerViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "db", "Lcom/example/data/local/AppDatabase;", "taskDao", "Lcom/example/data/local/dao/TaskDao;", "noteDao", "Lcom/example/data/local/dao/NoteDao;", "scheduler", "Lcom/example/notification/ReminderScheduler;", "currentUserId", "", "getCurrentUserId", "()Ljava/lang/String;", "_selectedDate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "selectedDate", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedDate", "()Lkotlinx/coroutines/flow/StateFlow;", "todaysTasks", "", "Lcom/example/data/local/entity/TaskEntity;", "getTodaysTasks", "floatingTasks", "getFloatingTasks", "scheduleTasks", "getScheduleTasks", "notesForToday", "Lcom/example/data/local/entity/NoteEntity;", "getNotesForToday", "selectDate", "", "timestamp", "getStartOfDay", "getEndOfDay", "addTask", "title", "description", "isTimeBoxed", "", "hour", "", "minute", "durationMinutes", "isAllTime", "hasReminder", "reminderMinutesBefore", "customReminderTime", "isMeeting", "onTaskAdded", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/lang/String;ZIIIZZLjava/lang/Integer;Ljava/lang/Long;ZLkotlin/jvm/functions/Function1;)V", "updateTaskSuspend", "task", "(Lcom/example/data/local/entity/TaskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "allNotes", "getAllNotes", "addNote", "content", "deleteNote", "note", "deleteTask", "prefsRepository", "Lcom/example/settings/UserPreferencesRepository;", "allSubTasksFlow", "Lcom/example/data/local/entity/SubTaskEntity;", "getAllSubTasksFlow", "getSubTasksForParent", "parentIdStr", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSubTasksForParentDirectly", "subtasksList", "formatDescriptionWithSubTasks", "baseDescription", "subTasks", "toggleSubTaskCompletion", "subTask", "isCompleted", "authManager", "Lcom/example/auth/AuthManager;", "syncViewModel", "Lcom/example/calendar/CalendarSyncViewModel;", "app"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nPlannerViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlannerViewModel.kt\ncom/example/PlannerViewModel\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,318:1\n189#2:319\n189#2:330\n49#3:320\n51#3:324\n49#3:325\n51#3:329\n46#4:321\n51#4:323\n46#4:326\n51#4:328\n105#5:322\n105#5:327\n*S KotlinDebug\n*F\n+ 1 PlannerViewModel.kt\ncom/example/PlannerViewModel\n*L\n41#1:319\n55#1:330\n47#1:320\n47#1:324\n51#1:325\n51#1:329\n47#1:321\n47#1:323\n51#1:326\n51#1:328\n47#1:322\n51#1:327\n*E\n"})
public final class PlannerViewModel extends AndroidViewModel {
   @NotNull
   private final AppDatabase db;
   @NotNull
   private final TaskDao taskDao;
   @NotNull
   private final NoteDao noteDao;
   @NotNull
   private final ReminderScheduler scheduler;
   @NotNull
   private final MutableStateFlow _selectedDate;
   @NotNull
   private final StateFlow selectedDate;
   @NotNull
   private final StateFlow todaysTasks;
   @NotNull
   private final StateFlow floatingTasks;
   @NotNull
   private final StateFlow scheduleTasks;
   @NotNull
   private final StateFlow notesForToday;
   @NotNull
   private final StateFlow allNotes;
   @NotNull
   private final UserPreferencesRepository prefsRepository;
   @NotNull
   private final StateFlow allSubTasksFlow;
   public static final int $stable = 8;

   public PlannerViewModel(@NotNull Application application) {
      Intrinsics.checkNotNullParameter(application, "application");
      super(application);
      this.db = AppDatabase.Companion.getDatabase((Context)application);
      this.taskDao = this.db.taskDao();
      this.noteDao = this.db.noteDao();
      this.scheduler = new ReminderScheduler((Context)application);
      this._selectedDate = StateFlowKt.MutableStateFlow(this.getStartOfDay(System.currentTimeMillis()));
      this.selectedDate = (StateFlow)this._selectedDate;
      Flow var4_1 = (Flow)this._selectedDate;
      int var3 = 0;
      this.todaysTasks = FlowKt.stateIn(FlowKt.transformLatest(var4_1, new PlannerViewModel$special$$inlined$flatMapLatest$1((Continuation)null, this)), ViewModelKt.getViewModelScope((ViewModel)this), Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object)null), CollectionsKt.emptyList());
      var4_1 = (Flow)this.todaysTasks;
      var3 = 0;
      int var5 = 0;
      int var6 = 0;
      this.floatingTasks = FlowKt.stateIn(new PlannerViewModel$special$$inlined$map$1(var4_1), ViewModelKt.getViewModelScope((ViewModel)this), Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object)null), CollectionsKt.emptyList());
      var4_1 = (Flow)this.todaysTasks;
      var3 = 0;
      var5 = 0;
      var6 = 0;
      this.scheduleTasks = FlowKt.stateIn(new PlannerViewModel$special$$inlined$map$2(var4_1), ViewModelKt.getViewModelScope((ViewModel)this), Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object)null), CollectionsKt.emptyList());
      var4_1 = (Flow)this._selectedDate;
      var3 = 0;
      this.notesForToday = FlowKt.stateIn(FlowKt.transformLatest(var4_1, new PlannerViewModel$special$$inlined$flatMapLatest$2((Continuation)null, this)), ViewModelKt.getViewModelScope((ViewModel)this), Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object)null), CollectionsKt.emptyList());
      this.allNotes = FlowKt.stateIn(this.noteDao.getAllNotes(this.getCurrentUserId()), ViewModelKt.getViewModelScope((ViewModel)this), Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object)null), CollectionsKt.emptyList());
      this.prefsRepository = new UserPreferencesRepository((Context)this.getApplication());
      this.allSubTasksFlow = FlowKt.stateIn(this.db.subTaskDao().getAllSubTasksFlow(this.getCurrentUserId()), ViewModelKt.getViewModelScope((ViewModel)this), Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object)null), CollectionsKt.emptyList());
   }

   @NotNull
   public final String getCurrentUserId() {
      FirebaseUser var10000 = FirebaseAuth.getInstance().getCurrentUser();
      String var1;
      if (var10000 != null) {
         var1 = var10000.getUid();
         if (var1 != null) {
            return var1;
         }
      }

      var1 = "";
      return var1;
   }

   @NotNull
   public final StateFlow getSelectedDate() {
      return this.selectedDate;
   }

   @NotNull
   public final StateFlow getTodaysTasks() {
      return this.todaysTasks;
   }

   @NotNull
   public final StateFlow getFloatingTasks() {
      return this.floatingTasks;
   }

   @NotNull
   public final StateFlow getScheduleTasks() {
      return this.scheduleTasks;
   }

   @NotNull
   public final StateFlow getNotesForToday() {
      return this.notesForToday;
   }

   public final void selectDate(long timestamp) {
      this._selectedDate.setValue(this.getStartOfDay(timestamp));
   }

   private final long getStartOfDay(long timestamp) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTimeInMillis(timestamp);
      calendar.set(11, 0);
      calendar.set(12, 0);
      calendar.set(13, 0);
      calendar.set(14, 0);
      return calendar.getTimeInMillis();
   }

   private final long getEndOfDay(long timestamp) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTimeInMillis(timestamp);
      calendar.set(11, 23);
      calendar.set(12, 59);
      calendar.set(13, 59);
      calendar.set(14, 999);
      return calendar.getTimeInMillis();
   }

   public final void addTask(@NotNull final String title, @Nullable final String description, final boolean isTimeBoxed, final int hour, final int minute, final int durationMinutes, final boolean isAllTime, final boolean hasReminder, @Nullable final Integer reminderMinutesBefore, @Nullable final Long customReminderTime, final boolean isMeeting, @NotNull final Function1 onTaskAdded) {
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(onTaskAdded, "onTaskAdded");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         long J$0;
         Object L$0;
         Object L$1;
         Object L$2;
         Object L$3;
         Object L$4;
         int I$0;
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            long dateVal;
            Long startTimeVal;
            Long endTimeVal;
            Long finalReminderTime;
            TaskEntity task;
            Object var10000;
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  dateVal = isTimeBoxed ? ((Number)PlannerViewModel.this._selectedDate.getValue()).longValue() : (isAllTime ? 0L : ((Number)PlannerViewModel.this._selectedDate.getValue()).longValue());
                  Long var22;
                  if (isTimeBoxed) {
                     Calendar var9_2 = Calendar.getInstance();
                     int var18 = hour;
                     int var19 = minute;
                     int var10 = 0;
                     var9_2.setTimeInMillis(dateVal);
                     var9_2.set(11, var18);
                     var9_2.set(12, var19);
                     var9_2.set(13, 0);
                     var9_2.set(14, 0);
                     var22 = Boxing.boxLong(var9_2.getTimeInMillis());
                  } else {
                     var22 = null;
                  }

                  startTimeVal = var22;
                  endTimeVal = isTimeBoxed && startTimeVal != null ? Boxing.boxLong(startTimeVal + (long)durationMinutes * 60000L) : null;
                  finalReminderTime = hasReminder ? (isTimeBoxed && reminderMinutesBefore != null && startTimeVal != null ? Boxing.boxLong(startTimeVal - (long)reminderMinutesBefore * 60000L) : customReminderTime) : null;
                  task = new TaskEntity(0, PlannerViewModel.this.getCurrentUserId(), title, description, dateVal, startTimeVal, endTimeVal, isTimeBoxed, false, hasReminder, finalReminderTime, isTimeBoxed ? reminderMinutesBefore : null, (String)null, isMeeting, 0L, (Long)null, 53505, (DefaultConstructorMarker)null);
                  TaskDao var23 = PlannerViewModel.this.taskDao;
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(startTimeVal);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(endTimeVal);
                  this.L$2 = finalReminderTime;
                  this.L$3 = task;
                  this.J$0 = dateVal;
                  this.label = 1;
                  var10000 = var23.insertTask(task, var10002);
                  if (var10000 == var11) {
                     return var11;
                  }
                  break;
               case 1:
                  dateVal = this.J$0;
                  task = (TaskEntity)this.L$3;
                  finalReminderTime = (Long)this.L$2;
                  endTimeVal = (Long)this.L$1;
                  startTimeVal = (Long)this.L$0;
                  ResultKt.throwOnFailure($result);
                  var10000 = $result;
                  break;
               case 2:
                  int taskId = this.I$0;
                  dateVal = this.J$0;
                  TaskEntity insertedTask = (TaskEntity)this.L$4;
                  task = (TaskEntity)this.L$3;
                  finalReminderTime = (Long)this.L$2;
                  endTimeVal = (Long)this.L$1;
                  startTimeVal = (Long)this.L$0;
                  ResultKt.throwOnFailure($result);
                  return Unit.INSTANCE;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            int taskId = (int)((Number)var10000).longValue();
            TaskEntity insertedTask = TaskEntity.copy$default(task, taskId, (String)null, (String)null, (String)null, 0L, (Long)null, (Long)null, false, false, false, (Long)null, (Integer)null, (String)null, false, 0L, (Long)null, 65534, (Object)null);
            if (hasReminder && finalReminderTime != null) {
               PlannerViewModel.this.scheduler.scheduleReminder(taskId, "task", finalReminderTime);
            }

            onTaskAdded.invoke(insertedTask);
            PlanNotificationManager var24 = PlanNotificationManager.INSTANCE;
            Context var10001 = (Context)PlannerViewModel.this.getApplication();
            Continuation var25 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(startTimeVal);
            this.L$1 = SpillingKt.nullOutSpilledVariable(endTimeVal);
            this.L$2 = SpillingKt.nullOutSpilledVariable(finalReminderTime);
            this.L$3 = SpillingKt.nullOutSpilledVariable(task);
            this.L$4 = SpillingKt.nullOutSpilledVariable(insertedTask);
            this.J$0 = dateVal;
            this.I$0 = taskId;
            this.label = 2;
            if (var24.updateCurrentPlanNotification(var10001, var25) == var11) {
               return var11;
            } else {
               return Unit.INSTANCE;
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   // $FF: synthetic method
   public static void addTask$default(PlannerViewModel var0, String var1, String var2, boolean var3, int var4, int var5, int var6, boolean var7, boolean var8, Integer var9, Long var10, boolean var11, Function1 var12, int var13, Object var14) {
      if ((var13 & 8) != 0) {
         var4 = 9;
      }

      if ((var13 & 16) != 0) {
         var5 = 0;
      }

      if ((var13 & 32) != 0) {
         var6 = 60;
      }

      if ((var13 & 64) != 0) {
         var7 = false;
      }

      if ((var13 & 128) != 0) {
         var8 = false;
      }

      if ((var13 & 256) != 0) {
         var9 = null;
      }

      if ((var13 & 512) != 0) {
         var10 = null;
      }

      if ((var13 & 1024) != 0) {
         var11 = false;
      }

      if ((var13 & 2048) != 0) {
         var12 = PlannerViewModel::addTask$lambda$6;
      }

      var0.addTask(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   @Nullable
   public final Object updateTaskSuspend(@NotNull TaskEntity task, @NotNull Continuation $completion) {
      Continuation $continuation;
      label51: {
         if ($completion instanceof <undefinedtype>) {
            $continuation = (<undefinedtype>)$completion;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
               $continuation.label -= Integer.MIN_VALUE;
               break label51;
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
               return PlannerViewModel.this.updateTaskSuspend((TaskEntity)null, (Continuation)this);
            }
         };
      }

      Object $result = $continuation.result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      TaskEntity updatedTask;
      switch ($continuation.label) {
         case 0:
            ResultKt.throwOnFailure($result);
            updatedTask = task.getHasReminder() && task.getReminderMinutesBefore() != null && task.getStartTime() != null ? TaskEntity.copy$default(task, 0, (String)null, (String)null, (String)null, 0L, (Long)null, (Long)null, false, false, false, Boxing.boxLong(task.getStartTime() - (long)task.getReminderMinutesBefore() * 60000L), (Integer)null, (String)null, false, 0L, (Long)null, 64511, (Object)null) : task;
            TaskDao var10000 = this.taskDao;
            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(task);
            $continuation.L$1 = updatedTask;
            $continuation.label = 1;
            if (var10000.updateTask(updatedTask, $continuation) == var6) {
               return var6;
            }
            break;
         case 1:
            updatedTask = (TaskEntity)$continuation.L$1;
            task = (TaskEntity)$continuation.L$0;
            ResultKt.throwOnFailure($result);
            break;
         case 2:
            updatedTask = (TaskEntity)$continuation.L$1;
            task = (TaskEntity)$continuation.L$0;
            ResultKt.throwOnFailure($result);
            return Unit.INSTANCE;
         default:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }

      if (updatedTask.getHasReminder() && updatedTask.getReminderTime() != null) {
         this.scheduler.scheduleReminder(updatedTask.getId(), "task", updatedTask.getReminderTime());
      } else {
         this.scheduler.cancelReminder(updatedTask.getId(), "task");
      }

      PlanNotificationManager var9 = PlanNotificationManager.INSTANCE;
      Context var10001 = (Context)this.getApplication();
      $continuation.L$0 = SpillingKt.nullOutSpilledVariable(task);
      $continuation.L$1 = SpillingKt.nullOutSpilledVariable(updatedTask);
      $continuation.label = 2;
      if (var9.updateCurrentPlanNotification(var10001, $continuation) == var6) {
         return var6;
      } else {
         return Unit.INSTANCE;
      }
   }

   public final void updateTask(@NotNull final TaskEntity task) {
      Intrinsics.checkNotNullParameter(task, "task");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  PlannerViewModel var10000 = PlannerViewModel.this;
                  TaskEntity var10001 = task;
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.updateTaskSuspend(var10001, var10002) == var2) {
                     return var2;
                  }
                  break;
               case 1:
                  ResultKt.throwOnFailure($result);
                  break;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   @NotNull
   public final StateFlow getAllNotes() {
      return this.allNotes;
   }

   public final void addNote(@NotNull final String title, @NotNull final String content) {
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(content, "content");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  NoteDao var10000 = PlannerViewModel.this.noteDao;
                  NoteEntity var10001 = new NoteEntity(0, PlannerViewModel.this.getCurrentUserId(), title, content, (Integer)null, (Long)null, (Long)null, (String)null, 0L, (Long)null, 993, (DefaultConstructorMarker)null);
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.insertNote(var10001, var10002) == var2) {
                     return var2;
                  }
                  break;
               case 1:
                  ResultKt.throwOnFailure($result);
                  break;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   public final void deleteNote(@NotNull final NoteEntity note) {
      Intrinsics.checkNotNullParameter(note, "note");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  NoteDao var10000 = PlannerViewModel.this.noteDao;
                  int var10001 = note.getId();
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.deleteNoteById(var10001, var10002) == var2) {
                     return var2;
                  }
                  break;
               case 1:
                  ResultKt.throwOnFailure($result);
                  break;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            PlannerViewModel.this.scheduler.cancelReminder(note.getId(), "note");
            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   public final void deleteTask(@NotNull final TaskEntity task) {
      Intrinsics.checkNotNullParameter(task, "task");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2;
            label28: {
               var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               switch (this.label) {
                  case 0:
                     ResultKt.throwOnFailure($result);
                     TaskDao var10000 = PlannerViewModel.this.taskDao;
                     int var10001 = task.getId();
                     Continuation var10002 = (Continuation)this;
                     this.label = 1;
                     if (var10000.deleteTaskById(var10001, var10002) == var2) {
                        return var2;
                     }
                     break;
                  case 1:
                     ResultKt.throwOnFailure($result);
                     break;
                  case 2:
                     ResultKt.throwOnFailure($result);
                     break label28;
                  case 3:
                     ResultKt.throwOnFailure($result);
                     return Unit.INSTANCE;
                  default:
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               PlannerViewModel.this.scheduler.cancelReminder(task.getId(), "task");
               SubTaskDao var3 = PlannerViewModel.this.db.subTaskDao();
               String var5 = "local_" + task.getId();
               Continuation var7 = (Continuation)this;
               this.label = 2;
               if (var3.deleteSubTasksForParent(var5, var7) == var2) {
                  return var2;
               }
            }

            PlanNotificationManager var4 = PlanNotificationManager.INSTANCE;
            Context var6 = (Context)PlannerViewModel.this.getApplication();
            Continuation var8 = (Continuation)this;
            this.label = 3;
            if (var4.updateCurrentPlanNotification(var6, var8) == var2) {
               return var2;
            } else {
               return Unit.INSTANCE;
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   @NotNull
   public final StateFlow getAllSubTasksFlow() {
      return this.allSubTasksFlow;
   }

   @Nullable
   public final Object getSubTasksForParent(@NotNull String parentIdStr, @NotNull Continuation $completion) {
      return this.db.subTaskDao().getSubTasksForParent(parentIdStr, $completion);
   }

   public final void saveSubTasksForParentDirectly(@NotNull final String parentIdStr, @NotNull final List subtasksList) {
      Intrinsics.checkNotNullParameter(parentIdStr, "parentIdStr");
      Intrinsics.checkNotNullParameter(subtasksList, "subtasksList");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         Object L$0;
         Object L$1;
         Object L$2;
         Object L$3;
         Object L$4;
         Object L$5;
         int I$0;
         int I$1;
         int label;

         public final Object invokeSuspend(Object $result) {
            Iterable var2;
            PlannerViewModel var3;
            String var4;
            int var5;
            Iterator var6;
            Object var10;
            label30: {
               var10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               switch (this.label) {
                  case 0:
                     ResultKt.throwOnFailure($result);
                     SubTaskDao var10000 = PlannerViewModel.this.db.subTaskDao();
                     String var10001 = parentIdStr;
                     Continuation var10002 = (Continuation)this;
                     this.label = 1;
                     if (var10000.deleteSubTasksForParent(var10001, var10002) == var10) {
                        return var10;
                     }
                     break;
                  case 1:
                     ResultKt.throwOnFailure($result);
                     break;
                  case 2:
                     int var9 = this.I$1;
                     var5 = this.I$0;
                     SubTaskEntity var8 = (SubTaskEntity)this.L$5;
                     Object var7 = this.L$4;
                     var6 = (Iterator)this.L$3;
                     var4 = (String)this.L$2;
                     var3 = (PlannerViewModel)this.L$1;
                     var2 = (Iterable)this.L$0;
                     ResultKt.throwOnFailure($result);
                     break label30;
                  default:
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               var2 = (Iterable)subtasksList;
               var3 = PlannerViewModel.this;
               var4 = parentIdStr;
               var5 = 0;
               var6 = var2.iterator();
            }

            while(var6.hasNext()) {
               Object var11 = var6.next();
               SubTaskEntity var12 = (SubTaskEntity)var11;
               int var13 = 0;
               SubTaskDao var14 = var3.db.subTaskDao();
               SubTaskEntity var15 = SubTaskEntity.copy$default(var12, 0, var3.getCurrentUserId(), var4, (String)null, (Long)null, (Long)null, false, 0L, (Long)null, 504, (Object)null);
               this.L$0 = SpillingKt.nullOutSpilledVariable(var2);
               this.L$1 = var3;
               this.L$2 = var4;
               this.L$3 = var6;
               this.L$4 = SpillingKt.nullOutSpilledVariable(var11);
               this.L$5 = SpillingKt.nullOutSpilledVariable(var12);
               this.I$0 = var5;
               this.I$1 = var13;
               this.label = 2;
               if (var14.insertSubTask(var15, this) == var10) {
                  return var10;
               }
            }

            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   @NotNull
   public final String formatDescriptionWithSubTasks(@Nullable String baseDescription, @NotNull List subTasks) {
      Intrinsics.checkNotNullParameter(subTasks, "subTasks");
      String var10000;
      if (baseDescription != null) {
         int index = StringsKt.indexOf$default((CharSequence)baseDescription, "\n\nTasks:\n", 0, false, 6, (Object)null);
         if (index != -1) {
            var10000 = baseDescription.substring(0, index);
            Intrinsics.checkNotNullExpressionValue(var10000, "substring(...)");
         } else {
            var10000 = StringsKt.startsWith$default(baseDescription, "Tasks:\n", false, 2, (Object)null) ? "" : baseDescription;
         }
      } else {
         var10000 = "";
      }

      String cleanDesc = var10000;
      if (subTasks.isEmpty()) {
         return cleanDesc;
      } else {
         SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm", Locale.getDefault());
         String subTasksStr = CollectionsKt.joinToString$default((Iterable)subTasks, (CharSequence)"\n", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, PlannerViewModel::formatDescriptionWithSubTasks$lambda$7, 30, (Object)null);
         return StringsKt.isBlank((CharSequence)cleanDesc) ? "Tasks:\n" + subTasksStr : cleanDesc + "\n\nTasks:\n" + subTasksStr;
      }
   }

   public final void toggleSubTaskCompletion(@NotNull final SubTaskEntity subTask, final boolean isCompleted, @Nullable final AuthManager authManager, @NotNull final CalendarSyncViewModel syncViewModel) {
      Intrinsics.checkNotNullParameter(subTask, "subTask");
      Intrinsics.checkNotNullParameter(syncViewModel, "syncViewModel");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         Object L$0;
         Object L$1;
         Object L$2;
         Object L$3;
         Object L$4;
         Object L$5;
         Object L$6;
         Object L$7;
         int label;

         public final Object invokeSuspend(Object $result) {
            TaskEntity updatedParent;
            SubTaskDao var10000;
            label151: {
               Object var16;
               SubTaskEntity updatedSubTask;
               String parentIdStr;
               List siblings;
               Integer localId;
               TaskEntity parentTask;
               String baseDescWithoutTasks;
               String finalDesc;
               label152: {
                  label139: {
                     label126: {
                        var16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                           case 0:
                              ResultKt.throwOnFailure($result);
                              updatedSubTask = SubTaskEntity.copy$default(subTask, 0, (String)null, (String)null, (String)null, (Long)null, (Long)null, isCompleted, 0L, (Long)null, 447, (Object)null);
                              SubTaskDao var45 = PlannerViewModel.this.db.subTaskDao();
                              Continuation var10002 = (Continuation)this;
                              this.L$0 = updatedSubTask;
                              this.label = 1;
                              if (var45.updateSubTask(updatedSubTask, var10002) == var16) {
                                 return var16;
                              }
                              break;
                           case 1:
                              updatedSubTask = (SubTaskEntity)this.L$0;
                              ResultKt.throwOnFailure($result);
                              break;
                           case 2:
                              parentIdStr = (String)this.L$1;
                              updatedSubTask = (SubTaskEntity)this.L$0;
                              ResultKt.throwOnFailure($result);
                              var10000 = $result;
                              break label126;
                           case 3:
                              localId = (Integer)this.L$3;
                              siblings = (List)this.L$2;
                              parentIdStr = (String)this.L$1;
                              updatedSubTask = (SubTaskEntity)this.L$0;
                              ResultKt.throwOnFailure($result);
                              var10000 = $result;
                              break label139;
                           case 4:
                              updatedParent = (TaskEntity)this.L$7;
                              finalDesc = (String)this.L$6;
                              baseDescWithoutTasks = (String)this.L$5;
                              parentTask = (TaskEntity)this.L$4;
                              localId = (Integer)this.L$3;
                              siblings = (List)this.L$2;
                              parentIdStr = (String)this.L$1;
                              updatedSubTask = (SubTaskEntity)this.L$0;
                              ResultKt.throwOnFailure($result);
                              break label152;
                           case 5:
                              updatedParent = (TaskEntity)this.L$7;
                              finalDesc = (String)this.L$6;
                              baseDescWithoutTasks = (String)this.L$5;
                              parentTask = (TaskEntity)this.L$4;
                              localId = (Integer)this.L$3;
                              siblings = (List)this.L$2;
                              parentIdStr = (String)this.L$1;
                              updatedSubTask = (SubTaskEntity)this.L$0;
                              ResultKt.throwOnFailure($result);
                              var10000 = (SubTaskDao)$result;
                              break label151;
                           default:
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        parentIdStr = subTask.getParentIdStr();
                        var10000 = PlannerViewModel.this.db.subTaskDao();
                        Continuation var55 = (Continuation)this;
                        this.L$0 = updatedSubTask;
                        this.L$1 = parentIdStr;
                        this.label = 2;
                        var10000 = var10000.getSubTasksForParent(parentIdStr, var55);
                        if (var10000 == var16) {
                           return var16;
                        }
                     }

                     Iterable localIdx = (Iterable)var10000;
                     SubTaskEntity var25 = subTask;
                     int baseDescWithoutTasksx = 0;
                     Collection updatedParent = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(localIdx, 10)));
                     int var10 = 0;

                     for(Object firebaseUser : localIdx) {
                        SubTaskEntity var13 = (SubTaskEntity)firebaseUser;
                        int var14 = 0;
                        updatedParent.add(var13.getId() == var25.getId() ? updatedSubTask : var13);
                     }

                     siblings = (List)updatedParent;
                     if (!StringsKt.startsWith$default(parentIdStr, "local_", false, 2, (Object)null)) {
                        if (StringsKt.startsWith$default(parentIdStr, "google_", false, 2, (Object)null)) {
                           String googleEventId = StringsKt.substringAfter$default(parentIdStr, "google_", (String)null, 2, (Object)null);
                           if (authManager != null) {
                              Iterable indexx = (Iterable)PlanNotificationManager.INSTANCE.getCachedGoogleEvents();
                              Iterator var36 = indexx.iterator();

                              while(true) {
                                 if (!var36.hasNext()) {
                                    var10000 = null;
                                    break;
                                 }

                                 Object var39 = var36.next();
                                 CalendarEvent var40 = (CalendarEvent)var39;
                                 int var42 = 0;
                                 if (Intrinsics.areEqual(var40.getId(), googleEventId)) {
                                    var10000 = (SubTaskDao)var39;
                                    break;
                                 }
                              }

                              CalendarEvent cachedEvent = (CalendarEvent)var10000;
                              if (cachedEvent != null) {
                                 String var52;
                                 if (cachedEvent.getDescription() != null) {
                                    int index = StringsKt.indexOf$default((CharSequence)cachedEvent.getDescription(), "\n\nTasks:\n", 0, false, 6, (Object)null);
                                    if (index != -1) {
                                       var52 = cachedEvent.getDescription().substring(0, index);
                                       Intrinsics.checkNotNullExpressionValue(var52, "substring(...)");
                                    } else {
                                       var52 = cachedEvent.getDescription();
                                    }
                                 } else {
                                    var52 = "";
                                 }

                                 String baseDescWithoutTasks = var52;
                                 String finalDesc = PlannerViewModel.this.formatDescriptionWithSubTasks(baseDescWithoutTasks, siblings);
                                 TaskEntity var53 = new TaskEntity;
                                 String var10004 = cachedEvent.getSummary();
                                 if (var10004 == null) {
                                    var10004 = "";
                                 }

                                 var53.<init>(-1, (String)null, var10004, finalDesc, cachedEvent.getStartTimeInMillis(), Boxing.boxLong(cachedEvent.getStartTimeInMillis()), Boxing.boxLong(cachedEvent.getEndTimeInMillis()), true, false, false, (Long)null, (Integer)null, cachedEvent.getId(), false, 0L, (Long)null, 61186, (DefaultConstructorMarker)null);
                                 TaskEntity placeholder = var53;
                                 syncViewModel.updateGoogleEvent(placeholder, authManager);
                              }

                              return Unit.INSTANCE;
                           }
                        }

                        return Unit.INSTANCE;
                     }

                     localId = StringsKt.toIntOrNull(StringsKt.substringAfter$default(parentIdStr, "local_", (String)null, 2, (Object)null));
                     if (localId == null) {
                        return Unit.INSTANCE;
                     }

                     TaskDao var47 = PlannerViewModel.this.taskDao;
                     int var10001 = localId;
                     Continuation var56 = (Continuation)this;
                     this.L$0 = SpillingKt.nullOutSpilledVariable(updatedSubTask);
                     this.L$1 = SpillingKt.nullOutSpilledVariable(parentIdStr);
                     this.L$2 = siblings;
                     this.L$3 = SpillingKt.nullOutSpilledVariable(localId);
                     this.label = 3;
                     var10000 = var47.getTaskById(var10001, var56);
                     if (var10000 == var16) {
                        return var16;
                     }
                  }

                  parentTask = (TaskEntity)var10000;
                  if (parentTask == null) {
                     return Unit.INSTANCE;
                  }

                  String var48;
                  if (parentTask.getDescription() != null) {
                     int index = StringsKt.indexOf$default((CharSequence)parentTask.getDescription(), "\n\nTasks:\n", 0, false, 6, (Object)null);
                     if (index != -1) {
                        var48 = parentTask.getDescription().substring(0, index);
                        Intrinsics.checkNotNullExpressionValue(var48, "substring(...)");
                     } else {
                        var48 = parentTask.getDescription();
                     }
                  } else {
                     var48 = "";
                  }

                  baseDescWithoutTasks = var48;
                  finalDesc = PlannerViewModel.this.formatDescriptionWithSubTasks(baseDescWithoutTasks, siblings);
                  updatedParent = TaskEntity.copy$default(parentTask, 0, (String)null, (String)null, finalDesc, 0L, (Long)null, (Long)null, false, false, false, (Long)null, (Integer)null, (String)null, false, 0L, (Long)null, 65527, (Object)null);
                  TaskDao var49 = PlannerViewModel.this.taskDao;
                  Continuation var57 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(updatedSubTask);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(parentIdStr);
                  this.L$2 = SpillingKt.nullOutSpilledVariable(siblings);
                  this.L$3 = SpillingKt.nullOutSpilledVariable(localId);
                  this.L$4 = SpillingKt.nullOutSpilledVariable(parentTask);
                  this.L$5 = SpillingKt.nullOutSpilledVariable(baseDescWithoutTasks);
                  this.L$6 = SpillingKt.nullOutSpilledVariable(finalDesc);
                  this.L$7 = updatedParent;
                  this.label = 4;
                  if (var49.updateTask(updatedParent, var57) == var16) {
                     return var16;
                  }
               }

               if (authManager == null) {
                  return Unit.INSTANCE;
               }

               Flow var50 = PlannerViewModel.this.prefsRepository.getCalendarSyncEnabledFlow();
               Continuation var54 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(updatedSubTask);
               this.L$1 = SpillingKt.nullOutSpilledVariable(parentIdStr);
               this.L$2 = SpillingKt.nullOutSpilledVariable(siblings);
               this.L$3 = SpillingKt.nullOutSpilledVariable(localId);
               this.L$4 = SpillingKt.nullOutSpilledVariable(parentTask);
               this.L$5 = SpillingKt.nullOutSpilledVariable(baseDescWithoutTasks);
               this.L$6 = SpillingKt.nullOutSpilledVariable(finalDesc);
               this.L$7 = updatedParent;
               this.label = 5;
               var10000 = (SubTaskDao)FlowKt.first(var50, var54);
               if (var10000 == var16) {
                  return var16;
               }
            }

            boolean calendarSyncEnabled = (Boolean)var10000;

            FirebaseUser firebaseUser;
            try {
               firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            } catch (Exception var17) {
               firebaseUser = null;
            }

            if (updatedParent.isTimeBoxed() && calendarSyncEnabled && firebaseUser != null) {
               syncViewModel.pushTaskToCalendar(updatedParent, authManager, PlannerViewModel.this);
            }

            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   private static final Unit addTask$lambda$6(TaskEntity it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Unit.INSTANCE;
   }

   private static final CharSequence formatDescriptionWithSubTasks$lambda$7(SimpleDateFormat $timeFormatter, SubTaskEntity subTask) {
      Intrinsics.checkNotNullParameter(subTask, "subTask");
      String timeStr = subTask.getStartTime() != null && subTask.getEndTime() != null ? " (" + $timeFormatter.format(new Date(subTask.getStartTime())) + " - " + $timeFormatter.format(new Date(subTask.getEndTime())) + ")" : (subTask.getStartTime() != null ? " (" + $timeFormatter.format(new Date(subTask.getStartTime())) + ")" : "");
      String statusChar = subTask.isCompleted() ? "x" : " ";
      return (CharSequence)("[" + statusChar + "] " + subTask.getTitle() + timeStr);
   }

   // $FF: synthetic method
   public static final long access$getStartOfDay(PlannerViewModel $this, long timestamp) {
      return $this.getStartOfDay(timestamp);
   }

   // $FF: synthetic method
   public static final long access$getEndOfDay(PlannerViewModel $this, long timestamp) {
      return $this.getEndOfDay(timestamp);
   }
}
