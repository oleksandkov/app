package com.example.settings;

import android.app.Application;
import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.auth.AuthManager;
import com.example.notification.PlanNotificationManager;
import com.google.firebase.auth.FirebaseAuth;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0014J\u000e\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u0014J\u000e\u00101\u001a\u00020+2\u0006\u00100\u001a\u00020\u0014J\u000e\u00102\u001a\u00020+2\u0006\u00100\u001a\u00020\u0014J\u000e\u00103\u001a\u00020+2\u0006\u00100\u001a\u00020\u0014J\u000e\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u000eJ\u000e\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020'J\u0014\u00108\u001a\u00020+2\f\u00109\u001a\b\u0012\u0004\u0012\u00020+0:R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0012R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0012¨\u0006;"},
   d2 = {"Lcom/example/settings/SettingsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "prefsRepository", "Lcom/example/settings/UserPreferencesRepository;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "authManager", "Lcom/example/auth/AuthManager;", "_themeMode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "themeMode", "Lkotlinx/coroutines/flow/StateFlow;", "getThemeMode", "()Lkotlinx/coroutines/flow/StateFlow;", "_notificationsMuted", "", "notificationsMuted", "getNotificationsMuted", "_calendarSyncEnabled", "calendarSyncEnabled", "getCalendarSyncEnabled", "_planNotificationEnabled", "planNotificationEnabled", "getPlanNotificationEnabled", "_googleCalendarRemindersEnabled", "googleCalendarRemindersEnabled", "getGoogleCalendarRemindersEnabled", "_notificationSoundEnabled", "notificationSoundEnabled", "getNotificationSoundEnabled", "_notificationMelody", "notificationMelody", "getNotificationMelody", "_notificationVolume", "", "notificationVolume", "getNotificationVolume", "setThemeMode", "", "mode", "toggleNotifications", "muted", "setCalendarSyncEnabled", "enabled", "setPlanNotificationEnabled", "setGoogleCalendarRemindersEnabled", "setNotificationSoundEnabled", "setNotificationMelody", "melody", "setNotificationVolume", "volume", "signOut", "onSignOutComplete", "Lkotlin/Function0;", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class SettingsViewModel extends AndroidViewModel {
   @NotNull
   private final UserPreferencesRepository prefsRepository;
   @NotNull
   private final FirebaseAuth auth;
   @NotNull
   private final AuthManager authManager;
   @NotNull
   private final MutableStateFlow _themeMode;
   @NotNull
   private final StateFlow themeMode;
   @NotNull
   private final MutableStateFlow _notificationsMuted;
   @NotNull
   private final StateFlow notificationsMuted;
   @NotNull
   private final MutableStateFlow _calendarSyncEnabled;
   @NotNull
   private final StateFlow calendarSyncEnabled;
   @NotNull
   private final MutableStateFlow _planNotificationEnabled;
   @NotNull
   private final StateFlow planNotificationEnabled;
   @NotNull
   private final MutableStateFlow _googleCalendarRemindersEnabled;
   @NotNull
   private final StateFlow googleCalendarRemindersEnabled;
   @NotNull
   private final MutableStateFlow _notificationSoundEnabled;
   @NotNull
   private final StateFlow notificationSoundEnabled;
   @NotNull
   private final MutableStateFlow _notificationMelody;
   @NotNull
   private final StateFlow notificationMelody;
   @NotNull
   private final MutableStateFlow _notificationVolume;
   @NotNull
   private final StateFlow notificationVolume;
   public static final int $stable = 8;

   public SettingsViewModel(@NotNull final Application application) {
      Intrinsics.checkNotNullParameter(application, "application");
      super(application);
      this.prefsRepository = new UserPreferencesRepository((Context)application);
      FirebaseAuth var10001 = FirebaseAuth.getInstance();
      Intrinsics.checkNotNullExpressionValue(var10001, "getInstance(...)");
      this.auth = var10001;
      this.authManager = new AuthManager((Context)application, this.auth);
      this._themeMode = StateFlowKt.MutableStateFlow("SYSTEM");
      this.themeMode = (StateFlow)this._themeMode;
      this._notificationsMuted = StateFlowKt.MutableStateFlow(false);
      this.notificationsMuted = (StateFlow)this._notificationsMuted;
      this._calendarSyncEnabled = StateFlowKt.MutableStateFlow(true);
      this.calendarSyncEnabled = (StateFlow)this._calendarSyncEnabled;
      this._planNotificationEnabled = StateFlowKt.MutableStateFlow(false);
      this.planNotificationEnabled = (StateFlow)this._planNotificationEnabled;
      this._googleCalendarRemindersEnabled = StateFlowKt.MutableStateFlow(true);
      this.googleCalendarRemindersEnabled = (StateFlow)this._googleCalendarRemindersEnabled;
      this._notificationSoundEnabled = StateFlowKt.MutableStateFlow(true);
      this.notificationSoundEnabled = (StateFlow)this._notificationSoundEnabled;
      this._notificationMelody = StateFlowKt.MutableStateFlow("Default");
      this.notificationMelody = (StateFlow)this._notificationMelody;
      this._notificationVolume = StateFlowKt.MutableStateFlow(80);
      this.notificationVolume = (StateFlow)this._notificationVolume;
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         Object L$1;
         int label;
         // $FF: synthetic field
         private Object L$0;

         public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$launch;
            MutableStateFlow var3;
            Object var10000;
            label91: {
               Object var4;
               label92: {
                  label93: {
                     label94: {
                        label95: {
                           label69: {
                              label68: {
                                 $this$launch = (CoroutineScope)this.L$0;
                                 var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 switch (this.label) {
                                    case 0:
                                       ResultKt.throwOnFailure($result);
                                       var3 = SettingsViewModel.this._themeMode;
                                       Flow var19 = SettingsViewModel.this.prefsRepository.getThemeModeFlow();
                                       Continuation var10001 = (Continuation)this;
                                       this.L$0 = $this$launch;
                                       this.L$1 = var3;
                                       this.label = 1;
                                       var10000 = FlowKt.first(var19, var10001);
                                       if (var10000 == var4) {
                                          return var4;
                                       }
                                       break;
                                    case 1:
                                       var3 = (MutableStateFlow)this.L$1;
                                       ResultKt.throwOnFailure($result);
                                       var10000 = $result;
                                       break;
                                    case 2:
                                       var3 = (MutableStateFlow)this.L$1;
                                       ResultKt.throwOnFailure($result);
                                       var10000 = $result;
                                       break label68;
                                    case 3:
                                       var3 = (MutableStateFlow)this.L$1;
                                       ResultKt.throwOnFailure($result);
                                       var10000 = $result;
                                       break label69;
                                    case 4:
                                       var3 = (MutableStateFlow)this.L$1;
                                       ResultKt.throwOnFailure($result);
                                       var10000 = $result;
                                       break label95;
                                    case 5:
                                       var3 = (MutableStateFlow)this.L$1;
                                       ResultKt.throwOnFailure($result);
                                       var10000 = $result;
                                       break label94;
                                    case 6:
                                       var3 = (MutableStateFlow)this.L$1;
                                       ResultKt.throwOnFailure($result);
                                       var10000 = $result;
                                       break label93;
                                    case 7:
                                       var3 = (MutableStateFlow)this.L$1;
                                       ResultKt.throwOnFailure($result);
                                       var10000 = $result;
                                       break label92;
                                    case 8:
                                       var3 = (MutableStateFlow)this.L$1;
                                       ResultKt.throwOnFailure($result);
                                       var10000 = $result;
                                       break label91;
                                    default:
                                       throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }

                                 var3.setValue(var10000);
                                 var3 = SettingsViewModel.this._notificationsMuted;
                                 Flow var20 = SettingsViewModel.this.prefsRepository.getNotificationsMutedFlow();
                                 Continuation var27 = (Continuation)this;
                                 this.L$0 = $this$launch;
                                 this.L$1 = var3;
                                 this.label = 2;
                                 var10000 = FlowKt.first(var20, var27);
                                 if (var10000 == var4) {
                                    return var4;
                                 }
                              }

                              var3.setValue(var10000);
                              var3 = SettingsViewModel.this._calendarSyncEnabled;
                              Flow var21 = SettingsViewModel.this.prefsRepository.getCalendarSyncEnabledFlow();
                              Continuation var28 = (Continuation)this;
                              this.L$0 = $this$launch;
                              this.L$1 = var3;
                              this.label = 3;
                              var10000 = FlowKt.first(var21, var28);
                              if (var10000 == var4) {
                                 return var4;
                              }
                           }

                           var3.setValue(var10000);
                           var3 = SettingsViewModel.this._planNotificationEnabled;
                           Flow var22 = SettingsViewModel.this.prefsRepository.getPlanNotificationEnabledFlow();
                           Continuation var29 = (Continuation)this;
                           this.L$0 = $this$launch;
                           this.L$1 = var3;
                           this.label = 4;
                           var10000 = FlowKt.first(var22, var29);
                           if (var10000 == var4) {
                              return var4;
                           }
                        }

                        var3.setValue(var10000);
                        var3 = SettingsViewModel.this._googleCalendarRemindersEnabled;
                        Flow var23 = SettingsViewModel.this.prefsRepository.getGoogleCalendarRemindersEnabledFlow();
                        Continuation var30 = (Continuation)this;
                        this.L$0 = $this$launch;
                        this.L$1 = var3;
                        this.label = 5;
                        var10000 = FlowKt.first(var23, var30);
                        if (var10000 == var4) {
                           return var4;
                        }
                     }

                     var3.setValue(var10000);
                     var3 = SettingsViewModel.this._notificationSoundEnabled;
                     Flow var24 = SettingsViewModel.this.prefsRepository.getNotificationSoundEnabledFlow();
                     Continuation var31 = (Continuation)this;
                     this.L$0 = $this$launch;
                     this.L$1 = var3;
                     this.label = 6;
                     var10000 = FlowKt.first(var24, var31);
                     if (var10000 == var4) {
                        return var4;
                     }
                  }

                  var3.setValue(var10000);
                  var3 = SettingsViewModel.this._notificationMelody;
                  Flow var25 = SettingsViewModel.this.prefsRepository.getNotificationMelodyFlow();
                  Continuation var32 = (Continuation)this;
                  this.L$0 = $this$launch;
                  this.L$1 = var3;
                  this.label = 7;
                  var10000 = FlowKt.first(var25, var32);
                  if (var10000 == var4) {
                     return var4;
                  }
               }

               var3.setValue(var10000);
               var3 = SettingsViewModel.this._notificationVolume;
               Flow var26 = SettingsViewModel.this.prefsRepository.getNotificationVolumeFlow();
               Continuation var33 = (Continuation)this;
               this.L$0 = $this$launch;
               this.L$1 = var3;
               this.label = 8;
               var10000 = FlowKt.first(var26, var33);
               if (var10000 == var4) {
                  return var4;
               }
            }

            var3.setValue(var10000);
            BuildersKt.launch$default($this$launch, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        PlanNotificationManager var10000 = PlanNotificationManager.INSTANCE;
                        Context var10001 = (Context)application;
                        Continuation var10002 = (Continuation)this;
                        this.label = 1;
                        if (var10000.updateCurrentPlanNotification(var10001, var10002) == var2) {
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
            BuildersKt.launch$default($this$launch, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        Flow var10000 = SettingsViewModel.this.prefsRepository.getThemeModeFlow();
                        FlowCollector var10001 = new FlowCollector() {
                           public final Object emit(String it, Continuation $completion) {
                              SettingsViewModel.this._themeMode.setValue(it);
                              return Unit.INSTANCE;
                           }
                        };
                        Continuation var10002 = (Continuation)this;
                        this.label = 1;
                        if (var10000.collect(var10001, var10002) == var2) {
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
            BuildersKt.launch$default($this$launch, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        Flow var10000 = SettingsViewModel.this.prefsRepository.getNotificationsMutedFlow();
                        FlowCollector var10001 = new FlowCollector() {
                           public final Object emit(boolean it, Continuation $completion) {
                              SettingsViewModel.this._notificationsMuted.setValue(Boxing.boxBoolean(it));
                              return Unit.INSTANCE;
                           }
                        };
                        Continuation var10002 = (Continuation)this;
                        this.label = 1;
                        if (var10000.collect(var10001, var10002) == var2) {
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
            BuildersKt.launch$default($this$launch, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        Flow var10000 = SettingsViewModel.this.prefsRepository.getCalendarSyncEnabledFlow();
                        FlowCollector var10001 = new FlowCollector() {
                           public final Object emit(boolean it, Continuation $completion) {
                              SettingsViewModel.this._calendarSyncEnabled.setValue(Boxing.boxBoolean(it));
                              return Unit.INSTANCE;
                           }
                        };
                        Continuation var10002 = (Continuation)this;
                        this.label = 1;
                        if (var10000.collect(var10001, var10002) == var2) {
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
            BuildersKt.launch$default($this$launch, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        Flow var10000 = SettingsViewModel.this.prefsRepository.getPlanNotificationEnabledFlow();
                        FlowCollector var10001 = new FlowCollector() {
                           public final Object emit(boolean it, Continuation $completion) {
                              SettingsViewModel.this._planNotificationEnabled.setValue(Boxing.boxBoolean(it));
                              return Unit.INSTANCE;
                           }
                        };
                        Continuation var10002 = (Continuation)this;
                        this.label = 1;
                        if (var10000.collect(var10001, var10002) == var2) {
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
            BuildersKt.launch$default($this$launch, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        Flow var10000 = SettingsViewModel.this.prefsRepository.getGoogleCalendarRemindersEnabledFlow();
                        FlowCollector var10001 = new FlowCollector() {
                           public final Object emit(boolean it, Continuation $completion) {
                              SettingsViewModel.this._googleCalendarRemindersEnabled.setValue(Boxing.boxBoolean(it));
                              return Unit.INSTANCE;
                           }
                        };
                        Continuation var10002 = (Continuation)this;
                        this.label = 1;
                        if (var10000.collect(var10001, var10002) == var2) {
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
            BuildersKt.launch$default($this$launch, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        Flow var10000 = SettingsViewModel.this.prefsRepository.getNotificationSoundEnabledFlow();
                        FlowCollector var10001 = new FlowCollector() {
                           public final Object emit(boolean it, Continuation $completion) {
                              SettingsViewModel.this._notificationSoundEnabled.setValue(Boxing.boxBoolean(it));
                              return Unit.INSTANCE;
                           }
                        };
                        Continuation var10002 = (Continuation)this;
                        this.label = 1;
                        if (var10000.collect(var10001, var10002) == var2) {
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
            BuildersKt.launch$default($this$launch, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        Flow var10000 = SettingsViewModel.this.prefsRepository.getNotificationMelodyFlow();
                        FlowCollector var10001 = new FlowCollector() {
                           public final Object emit(String it, Continuation $completion) {
                              SettingsViewModel.this._notificationMelody.setValue(it);
                              return Unit.INSTANCE;
                           }
                        };
                        Continuation var10002 = (Continuation)this;
                        this.label = 1;
                        if (var10000.collect(var10001, var10002) == var2) {
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
            BuildersKt.launch$default($this$launch, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        Flow var10000 = SettingsViewModel.this.prefsRepository.getNotificationVolumeFlow();
                        FlowCollector var10001 = new FlowCollector() {
                           public final Object emit(int it, Continuation $completion) {
                              SettingsViewModel.this._notificationVolume.setValue(Boxing.boxInt(it));
                              return Unit.INSTANCE;
                           }
                        };
                        Continuation var10002 = (Continuation)this;
                        this.label = 1;
                        if (var10000.collect(var10001, var10002) == var2) {
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
            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
   }

   @NotNull
   public final StateFlow getThemeMode() {
      return this.themeMode;
   }

   @NotNull
   public final StateFlow getNotificationsMuted() {
      return this.notificationsMuted;
   }

   @NotNull
   public final StateFlow getCalendarSyncEnabled() {
      return this.calendarSyncEnabled;
   }

   @NotNull
   public final StateFlow getPlanNotificationEnabled() {
      return this.planNotificationEnabled;
   }

   @NotNull
   public final StateFlow getGoogleCalendarRemindersEnabled() {
      return this.googleCalendarRemindersEnabled;
   }

   @NotNull
   public final StateFlow getNotificationSoundEnabled() {
      return this.notificationSoundEnabled;
   }

   @NotNull
   public final StateFlow getNotificationMelody() {
      return this.notificationMelody;
   }

   @NotNull
   public final StateFlow getNotificationVolume() {
      return this.notificationVolume;
   }

   public final void setThemeMode(@NotNull final String mode) {
      Intrinsics.checkNotNullParameter(mode, "mode");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  UserPreferencesRepository var10000 = SettingsViewModel.this.prefsRepository;
                  String var10001 = mode;
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.updateThemeMode(var10001, var10002) == var2) {
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

   public final void toggleNotifications(final boolean muted) {
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  UserPreferencesRepository var10000 = SettingsViewModel.this.prefsRepository;
                  boolean var10001 = muted;
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.updateNotificationsMuted(var10001, var10002) == var2) {
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

   public final void setCalendarSyncEnabled(final boolean enabled) {
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  UserPreferencesRepository var10000 = SettingsViewModel.this.prefsRepository;
                  boolean var10001 = enabled;
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.updateCalendarSyncEnabled(var10001, var10002) == var2) {
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

   public final void setPlanNotificationEnabled(final boolean enabled) {
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  UserPreferencesRepository var10000 = SettingsViewModel.this.prefsRepository;
                  boolean var10001 = enabled;
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.updatePlanNotificationEnabled(var10001, var10002) == var2) {
                     return var2;
                  }
                  break;
               case 1:
                  ResultKt.throwOnFailure($result);
                  break;
               case 2:
                  ResultKt.throwOnFailure($result);
                  return Unit.INSTANCE;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            PlanNotificationManager var3 = PlanNotificationManager.INSTANCE;
            Context var4 = (Context)SettingsViewModel.this.getApplication();
            Continuation var5 = (Continuation)this;
            this.label = 2;
            if (var3.updateCurrentPlanNotification(var4, var5) == var2) {
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

   public final void setGoogleCalendarRemindersEnabled(final boolean enabled) {
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  UserPreferencesRepository var10000 = SettingsViewModel.this.prefsRepository;
                  boolean var10001 = enabled;
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.updateGoogleCalendarRemindersEnabled(var10001, var10002) == var2) {
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

   public final void setNotificationSoundEnabled(final boolean enabled) {
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  UserPreferencesRepository var10000 = SettingsViewModel.this.prefsRepository;
                  boolean var10001 = enabled;
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.updateNotificationSoundEnabled(var10001, var10002) == var2) {
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

   public final void setNotificationMelody(@NotNull final String melody) {
      Intrinsics.checkNotNullParameter(melody, "melody");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  UserPreferencesRepository var10000 = SettingsViewModel.this.prefsRepository;
                  String var10001 = melody;
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.updateNotificationMelody(var10001, var10002) == var2) {
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

   public final void setNotificationVolume(final int volume) {
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  UserPreferencesRepository var10000 = SettingsViewModel.this.prefsRepository;
                  int var10001 = volume;
                  Continuation var10002 = (Continuation)this;
                  this.label = 1;
                  if (var10000.updateNotificationVolume(var10001, var10002) == var2) {
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

   public final void signOut(@NotNull final Function0 onSignOutComplete) {
      Intrinsics.checkNotNullParameter(onSignOutComplete, "onSignOutComplete");
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  AuthManager var10000 = SettingsViewModel.this.authManager;
                  Continuation var10001 = (Continuation)this;
                  this.label = 1;
                  if (var10000.signOut(var10001) == var2) {
                     return var2;
                  }
                  break;
               case 1:
                  ResultKt.throwOnFailure($result);
                  break;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            onSignOutComplete.invoke();
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
