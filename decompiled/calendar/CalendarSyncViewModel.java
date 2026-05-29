package com.example.calendar;

import android.app.Application;
import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.PlannerViewModel;
import com.example.auth.AuthManager;
import com.example.data.local.entity.TaskEntity;
import com.example.data.network.CalendarApiService;
import com.example.data.network.CalendarEvent;
import com.example.data.repository.CalendarRepository;
import com.example.settings.UserPreferencesRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%J\u001e\u0010&\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%J\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010)\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006*"},
   d2 = {"Lcom/example/calendar/CalendarSyncViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "calendarRepository", "Lcom/example/data/repository/CalendarRepository;", "prefsRepository", "Lcom/example/settings/UserPreferencesRepository;", "_events", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/data/network/CalendarEvent;", "events", "Lkotlinx/coroutines/flow/StateFlow;", "getEvents", "()Lkotlinx/coroutines/flow/StateFlow;", "_isSyncing", "", "isSyncing", "_lastSyncTime", "", "lastSyncTime", "getLastSyncTime", "_error", "", "error", "getError", "syncCalendar", "", "authManager", "Lcom/example/auth/AuthManager;", "pushTaskToCalendar", "task", "Lcom/example/data/local/entity/TaskEntity;", "plannerViewModel", "Lcom/example/PlannerViewModel;", "deleteTask", "deleteGoogleEvent", "event", "updateGoogleEvent", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class CalendarSyncViewModel extends AndroidViewModel {
   @NotNull
   private final CalendarRepository calendarRepository;
   @NotNull
   private final UserPreferencesRepository prefsRepository;
   @NotNull
   private final MutableStateFlow _events;
   @NotNull
   private final StateFlow events;
   @NotNull
   private final MutableStateFlow _isSyncing;
   @NotNull
   private final StateFlow isSyncing;
   @NotNull
   private final MutableStateFlow _lastSyncTime;
   @NotNull
   private final StateFlow lastSyncTime;
   @NotNull
   private final MutableStateFlow _error;
   @NotNull
   private final StateFlow error;
   public static final int $stable = 8;

   public CalendarSyncViewModel(@NotNull Application application) {
      Intrinsics.checkNotNullParameter(application, "application");
      super(application);
      this.calendarRepository = new CalendarRepository((CalendarApiService)null, 1, (DefaultConstructorMarker)null);
      this.prefsRepository = new UserPreferencesRepository((Context)application);
      this._events = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
      this.events = (StateFlow)this._events;
      this._isSyncing = StateFlowKt.MutableStateFlow(false);
      this.isSyncing = (StateFlow)this._isSyncing;
      this._lastSyncTime = StateFlowKt.MutableStateFlow((Object)null);
      this.lastSyncTime = (StateFlow)this._lastSyncTime;
      this._error = StateFlowKt.MutableStateFlow((Object)null);
      this.error = (StateFlow)this._error;
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         Object L$0;
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            MutableStateFlow var2;
            Object var10000;
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  var2 = CalendarSyncViewModel.this._lastSyncTime;
                  Flow var4 = CalendarSyncViewModel.this.prefsRepository.getLastSyncTimestampFlow();
                  Continuation var10001 = (Continuation)this;
                  this.L$0 = var2;
                  this.label = 1;
                  var10000 = FlowKt.first(var4, var10001);
                  if (var10000 == var3) {
                     return var3;
                  }
                  break;
               case 1:
                  var2 = (MutableStateFlow)this.L$0;
                  ResultKt.throwOnFailure($result);
                  var10000 = $result;
                  break;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var2.setValue(var10000);
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
   public final StateFlow getEvents() {
      return this.events;
   }

   @NotNull
   public final StateFlow isSyncing() {
      return this.isSyncing;
   }

   @NotNull
   public final StateFlow getLastSyncTime() {
      return this.lastSyncTime;
   }

   @NotNull
   public final StateFlow getError() {
      return this.error;
   }

   public final void syncCalendar(@NotNull final AuthManager authManager) {
      Intrinsics.checkNotNullParameter(authManager, "authManager");
      this._isSyncing.setValue(true);
      this._error.setValue((Object)null);
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         Object L$0;
         Object L$1;
         long J$0;
         int label;

         public final Object invokeSuspend(Object param1) {
            // $FF: Couldn't be decompiled
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   public final void pushTaskToCalendar(@NotNull final TaskEntity task, @NotNull final AuthManager authManager, @NotNull final PlannerViewModel plannerViewModel) {
      Intrinsics.checkNotNullParameter(task, "task");
      Intrinsics.checkNotNullParameter(authManager, "authManager");
      Intrinsics.checkNotNullParameter(plannerViewModel, "plannerViewModel");
      this._isSyncing.setValue(true);
      this._error.setValue((Object)null);
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         Object L$0;
         Object L$1;
         Object L$2;
         Object L$3;
         int label;

         public final Object invokeSuspend(Object param1) {
            // $FF: Couldn't be decompiled
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   public final void deleteTask(@NotNull TaskEntity task, @NotNull final AuthManager authManager, @NotNull PlannerViewModel plannerViewModel) {
      Intrinsics.checkNotNullParameter(task, "task");
      Intrinsics.checkNotNullParameter(authManager, "authManager");
      Intrinsics.checkNotNullParameter(plannerViewModel, "plannerViewModel");
      plannerViewModel.deleteTask(task);
      final String eventId = task.getExternalCalendarEventId();
      CharSequence var5 = (CharSequence)eventId;
      if (var5 != null && var5.length() != 0) {
         BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
            Object L$0;
            int label;

            public final Object invokeSuspend(Object $result) {
               label56: {
                  Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  Object var10000;
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);

                        try {
                           var10000 = authManager;
                           Continuation var15 = (Continuation)this;
                           this.label = 1;
                           var10000 = (AuthManager)var10000.getCalendarAccessToken(var15);
                        } catch (Exception var6) {
                           boolean var14 = false;
                           return Unit.INSTANCE;
                        }

                        if (var10000 == var3) {
                           return var3;
                        }
                        break;
                     case 1:
                        try {
                           ResultKt.throwOnFailure($result);
                           var10000 = (AuthManager)$result;
                           break;
                        } catch (Exception var7) {
                           boolean var13 = false;
                           return Unit.INSTANCE;
                        }
                     case 2:
                        String token = (String)this.L$0;

                        try {
                           ResultKt.throwOnFailure($result);
                           break label56;
                        } catch (Exception var8) {
                           boolean var10001 = false;
                           return Unit.INSTANCE;
                        }
                     default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  try {
                     String token = (String)var10000;
                     if (token == null) {
                        return Unit.INSTANCE;
                     }

                     CalendarRepository var11 = CalendarSyncViewModel.this.calendarRepository;
                     String var10002 = eventId;
                     Continuation var10003 = (Continuation)this;
                     this.L$0 = SpillingKt.nullOutSpilledVariable(token);
                     this.label = 2;
                     var10000 = (AuthManager)var11.deleteEvent(token, var10002, var10003);
                  } catch (Exception var5) {
                     boolean var16 = false;
                     return Unit.INSTANCE;
                  }

                  if (var10000 == var3) {
                     return var3;
                  }
               }

               try {
                  CalendarSyncViewModel.this.syncCalendar(authManager);
               } catch (Exception var4) {
                  boolean var17 = false;
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

   }

   public final void deleteGoogleEvent(@NotNull final CalendarEvent event, @NotNull final AuthManager authManager) {
      Intrinsics.checkNotNullParameter(event, "event");
      Intrinsics.checkNotNullParameter(authManager, "authManager");
      this._isSyncing.setValue(true);
      this._error.setValue((Object)null);
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         Object L$0;
         int label;

         public final Object invokeSuspend(Object param1) {
            // $FF: Couldn't be decompiled
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   public final void updateGoogleEvent(@NotNull final TaskEntity task, @NotNull final AuthManager authManager) {
      Intrinsics.checkNotNullParameter(task, "task");
      Intrinsics.checkNotNullParameter(authManager, "authManager");
      this._isSyncing.setValue(true);
      this._error.setValue((Object)null);
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         Object L$0;
         Object L$1;
         int label;

         public final Object invokeSuspend(Object param1) {
            // $FF: Couldn't be decompiled
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
   public static final MutableStateFlow access$get_events$p(CalendarSyncViewModel $this) {
      return $this._events;
   }

   // $FF: synthetic method
   public static final MutableStateFlow access$get_error$p(CalendarSyncViewModel $this) {
      return $this._error;
   }

   // $FF: synthetic method
   public static final MutableStateFlow access$get_isSyncing$p(CalendarSyncViewModel $this) {
      return $this._isSyncing;
   }
}
