package com.example.settings;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.datastore.preferences.core.PreferencesKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0086@¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010$J\u0016\u0010*\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010$J\u0016\u0010+\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010$J\u0016\u0010,\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010$J\u0016\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010!J\u0016\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u00101R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\n¨\u00063"},
   d2 = {"Lcom/example/settings/UserPreferencesRepository;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "themeModeFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getThemeModeFlow", "()Lkotlinx/coroutines/flow/Flow;", "notificationsMutedFlow", "", "getNotificationsMutedFlow", "lastSyncTimestampFlow", "", "getLastSyncTimestampFlow", "calendarSyncEnabledFlow", "getCalendarSyncEnabledFlow", "planNotificationEnabledFlow", "getPlanNotificationEnabledFlow", "googleCalendarRemindersEnabledFlow", "getGoogleCalendarRemindersEnabledFlow", "notificationSoundEnabledFlow", "getNotificationSoundEnabledFlow", "notificationMelodyFlow", "getNotificationMelodyFlow", "notificationVolumeFlow", "", "getNotificationVolumeFlow", "updateThemeMode", "", "themeMode", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotificationsMuted", "muted", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastSyncTimestamp", "timestamp", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCalendarSyncEnabled", "enabled", "updatePlanNotificationEnabled", "updateGoogleCalendarRemindersEnabled", "updateNotificationSoundEnabled", "updateNotificationMelody", "melody", "updateNotificationVolume", "volume", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PreferencesKeys", "app"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nUserPreferencesRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserPreferencesRepository.kt\ncom/example/settings/UserPreferencesRepository\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,189:1\n49#2:190\n51#2:194\n49#2:195\n51#2:199\n49#2:200\n51#2:204\n49#2:205\n51#2:209\n49#2:210\n51#2:214\n49#2:215\n51#2:219\n49#2:220\n51#2:224\n49#2:225\n51#2:229\n49#2:230\n51#2:234\n46#3:191\n51#3:193\n46#3:196\n51#3:198\n46#3:201\n51#3:203\n46#3:206\n51#3:208\n46#3:211\n51#3:213\n46#3:216\n51#3:218\n46#3:221\n51#3:223\n46#3:226\n51#3:228\n46#3:231\n51#3:233\n105#4:192\n105#4:197\n105#4:202\n105#4:207\n105#4:212\n105#4:217\n105#4:222\n105#4:227\n105#4:232\n*S KotlinDebug\n*F\n+ 1 UserPreferencesRepository.kt\ncom/example/settings/UserPreferencesRepository\n*L\n35#1:190\n35#1:194\n47#1:195\n47#1:199\n59#1:200\n59#1:204\n71#1:205\n71#1:209\n83#1:210\n83#1:214\n95#1:215\n95#1:219\n107#1:220\n107#1:224\n119#1:225\n119#1:229\n131#1:230\n131#1:234\n35#1:191\n35#1:193\n47#1:196\n47#1:198\n59#1:201\n59#1:203\n71#1:206\n71#1:208\n83#1:211\n83#1:213\n95#1:216\n95#1:218\n107#1:221\n107#1:223\n119#1:226\n119#1:228\n131#1:231\n131#1:233\n35#1:192\n47#1:197\n59#1:202\n71#1:207\n83#1:212\n95#1:217\n107#1:222\n119#1:227\n131#1:232\n*E\n"})
public final class UserPreferencesRepository {
   @NotNull
   private final Context context;
   @NotNull
   private final Flow themeModeFlow;
   @NotNull
   private final Flow notificationsMutedFlow;
   @NotNull
   private final Flow lastSyncTimestampFlow;
   @NotNull
   private final Flow calendarSyncEnabledFlow;
   @NotNull
   private final Flow planNotificationEnabledFlow;
   @NotNull
   private final Flow googleCalendarRemindersEnabledFlow;
   @NotNull
   private final Flow notificationSoundEnabledFlow;
   @NotNull
   private final Flow notificationMelodyFlow;
   @NotNull
   private final Flow notificationVolumeFlow;
   public static final int $stable = 8;

   public UserPreferencesRepository(@NotNull Context context) {
      Intrinsics.checkNotNullParameter(context, "context");
      super();
      this.context = context;
      Flow var4_1 = FlowKt.catch(UserPreferencesRepositoryKt.getDataStore(this.context).getData(), new Function3((Continuation)null) {
         int label;
         // $FF: synthetic field
         private Object L$0;
         // $FF: synthetic field
         Object L$1;

         public final Object invokeSuspend(Object $result) {
            FlowCollector $this$catch = (FlowCollector)this.L$0;
            Throwable exception = (Throwable)this.L$1;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  if (!(exception instanceof IOException)) {
                     throw exception;
                  }

                  Preferences var10001 = PreferencesFactory.createEmpty();
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable($this$catch);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(exception);
                  this.label = 1;
                  if ($this$catch.emit(var10001, var10002) == var4) {
                     return var4;
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

         public final Object invoke(FlowCollector p1, Throwable p2, Continuation p3) {
            Function3 var4 = new <anonymous constructor>(p3);
            var4.L$0 = p1;
            var4.L$1 = p2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }
      });
      int var3 = 0;
      int var5 = 0;
      int var6 = 0;
      this.themeModeFlow = new UserPreferencesRepository$special$$inlined$map$1(var4_1);
      var4_1 = FlowKt.catch(UserPreferencesRepositoryKt.getDataStore(this.context).getData(), new Function3((Continuation)null) {
         int label;
         // $FF: synthetic field
         private Object L$0;
         // $FF: synthetic field
         Object L$1;

         public final Object invokeSuspend(Object $result) {
            FlowCollector $this$catch = (FlowCollector)this.L$0;
            Throwable exception = (Throwable)this.L$1;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  if (!(exception instanceof IOException)) {
                     throw exception;
                  }

                  Preferences var10001 = PreferencesFactory.createEmpty();
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable($this$catch);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(exception);
                  this.label = 1;
                  if ($this$catch.emit(var10001, var10002) == var4) {
                     return var4;
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

         public final Object invoke(FlowCollector p1, Throwable p2, Continuation p3) {
            Function3 var4 = new <anonymous constructor>(p3);
            var4.L$0 = p1;
            var4.L$1 = p2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }
      });
      var3 = 0;
      var5 = 0;
      var6 = 0;
      this.notificationsMutedFlow = new UserPreferencesRepository$special$$inlined$map$2(var4_1);
      var4_1 = FlowKt.catch(UserPreferencesRepositoryKt.getDataStore(this.context).getData(), new Function3((Continuation)null) {
         int label;
         // $FF: synthetic field
         private Object L$0;
         // $FF: synthetic field
         Object L$1;

         public final Object invokeSuspend(Object $result) {
            FlowCollector $this$catch = (FlowCollector)this.L$0;
            Throwable exception = (Throwable)this.L$1;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  if (!(exception instanceof IOException)) {
                     throw exception;
                  }

                  Preferences var10001 = PreferencesFactory.createEmpty();
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable($this$catch);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(exception);
                  this.label = 1;
                  if ($this$catch.emit(var10001, var10002) == var4) {
                     return var4;
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

         public final Object invoke(FlowCollector p1, Throwable p2, Continuation p3) {
            Function3 var4 = new <anonymous constructor>(p3);
            var4.L$0 = p1;
            var4.L$1 = p2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }
      });
      var3 = 0;
      var5 = 0;
      var6 = 0;
      this.lastSyncTimestampFlow = new UserPreferencesRepository$special$$inlined$map$3(var4_1);
      var4_1 = FlowKt.catch(UserPreferencesRepositoryKt.getDataStore(this.context).getData(), new Function3((Continuation)null) {
         int label;
         // $FF: synthetic field
         private Object L$0;
         // $FF: synthetic field
         Object L$1;

         public final Object invokeSuspend(Object $result) {
            FlowCollector $this$catch = (FlowCollector)this.L$0;
            Throwable exception = (Throwable)this.L$1;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  if (!(exception instanceof IOException)) {
                     throw exception;
                  }

                  Preferences var10001 = PreferencesFactory.createEmpty();
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable($this$catch);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(exception);
                  this.label = 1;
                  if ($this$catch.emit(var10001, var10002) == var4) {
                     return var4;
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

         public final Object invoke(FlowCollector p1, Throwable p2, Continuation p3) {
            Function3 var4 = new <anonymous constructor>(p3);
            var4.L$0 = p1;
            var4.L$1 = p2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }
      });
      var3 = 0;
      var5 = 0;
      var6 = 0;
      this.calendarSyncEnabledFlow = new UserPreferencesRepository$special$$inlined$map$4(var4_1);
      var4_1 = FlowKt.catch(UserPreferencesRepositoryKt.getDataStore(this.context).getData(), new Function3((Continuation)null) {
         int label;
         // $FF: synthetic field
         private Object L$0;
         // $FF: synthetic field
         Object L$1;

         public final Object invokeSuspend(Object $result) {
            FlowCollector $this$catch = (FlowCollector)this.L$0;
            Throwable exception = (Throwable)this.L$1;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  if (!(exception instanceof IOException)) {
                     throw exception;
                  }

                  Preferences var10001 = PreferencesFactory.createEmpty();
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable($this$catch);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(exception);
                  this.label = 1;
                  if ($this$catch.emit(var10001, var10002) == var4) {
                     return var4;
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

         public final Object invoke(FlowCollector p1, Throwable p2, Continuation p3) {
            Function3 var4 = new <anonymous constructor>(p3);
            var4.L$0 = p1;
            var4.L$1 = p2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }
      });
      var3 = 0;
      var5 = 0;
      var6 = 0;
      this.planNotificationEnabledFlow = new UserPreferencesRepository$special$$inlined$map$5(var4_1);
      var4_1 = FlowKt.catch(UserPreferencesRepositoryKt.getDataStore(this.context).getData(), new Function3((Continuation)null) {
         int label;
         // $FF: synthetic field
         private Object L$0;
         // $FF: synthetic field
         Object L$1;

         public final Object invokeSuspend(Object $result) {
            FlowCollector $this$catch = (FlowCollector)this.L$0;
            Throwable exception = (Throwable)this.L$1;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  if (!(exception instanceof IOException)) {
                     throw exception;
                  }

                  Preferences var10001 = PreferencesFactory.createEmpty();
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable($this$catch);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(exception);
                  this.label = 1;
                  if ($this$catch.emit(var10001, var10002) == var4) {
                     return var4;
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

         public final Object invoke(FlowCollector p1, Throwable p2, Continuation p3) {
            Function3 var4 = new <anonymous constructor>(p3);
            var4.L$0 = p1;
            var4.L$1 = p2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }
      });
      var3 = 0;
      var5 = 0;
      var6 = 0;
      this.googleCalendarRemindersEnabledFlow = new UserPreferencesRepository$special$$inlined$map$6(var4_1);
      var4_1 = FlowKt.catch(UserPreferencesRepositoryKt.getDataStore(this.context).getData(), new Function3((Continuation)null) {
         int label;
         // $FF: synthetic field
         private Object L$0;
         // $FF: synthetic field
         Object L$1;

         public final Object invokeSuspend(Object $result) {
            FlowCollector $this$catch = (FlowCollector)this.L$0;
            Throwable exception = (Throwable)this.L$1;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  if (!(exception instanceof IOException)) {
                     throw exception;
                  }

                  Preferences var10001 = PreferencesFactory.createEmpty();
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable($this$catch);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(exception);
                  this.label = 1;
                  if ($this$catch.emit(var10001, var10002) == var4) {
                     return var4;
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

         public final Object invoke(FlowCollector p1, Throwable p2, Continuation p3) {
            Function3 var4 = new <anonymous constructor>(p3);
            var4.L$0 = p1;
            var4.L$1 = p2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }
      });
      var3 = 0;
      var5 = 0;
      var6 = 0;
      this.notificationSoundEnabledFlow = new UserPreferencesRepository$special$$inlined$map$7(var4_1);
      var4_1 = FlowKt.catch(UserPreferencesRepositoryKt.getDataStore(this.context).getData(), new Function3((Continuation)null) {
         int label;
         // $FF: synthetic field
         private Object L$0;
         // $FF: synthetic field
         Object L$1;

         public final Object invokeSuspend(Object $result) {
            FlowCollector $this$catch = (FlowCollector)this.L$0;
            Throwable exception = (Throwable)this.L$1;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  if (!(exception instanceof IOException)) {
                     throw exception;
                  }

                  Preferences var10001 = PreferencesFactory.createEmpty();
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable($this$catch);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(exception);
                  this.label = 1;
                  if ($this$catch.emit(var10001, var10002) == var4) {
                     return var4;
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

         public final Object invoke(FlowCollector p1, Throwable p2, Continuation p3) {
            Function3 var4 = new <anonymous constructor>(p3);
            var4.L$0 = p1;
            var4.L$1 = p2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }
      });
      var3 = 0;
      var5 = 0;
      var6 = 0;
      this.notificationMelodyFlow = new UserPreferencesRepository$special$$inlined$map$8(var4_1);
      var4_1 = FlowKt.catch(UserPreferencesRepositoryKt.getDataStore(this.context).getData(), new Function3((Continuation)null) {
         int label;
         // $FF: synthetic field
         private Object L$0;
         // $FF: synthetic field
         Object L$1;

         public final Object invokeSuspend(Object $result) {
            FlowCollector $this$catch = (FlowCollector)this.L$0;
            Throwable exception = (Throwable)this.L$1;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  if (!(exception instanceof IOException)) {
                     throw exception;
                  }

                  Preferences var10001 = PreferencesFactory.createEmpty();
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable($this$catch);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(exception);
                  this.label = 1;
                  if ($this$catch.emit(var10001, var10002) == var4) {
                     return var4;
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

         public final Object invoke(FlowCollector p1, Throwable p2, Continuation p3) {
            Function3 var4 = new <anonymous constructor>(p3);
            var4.L$0 = p1;
            var4.L$1 = p2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }
      });
      var3 = 0;
      var5 = 0;
      var6 = 0;
      this.notificationVolumeFlow = new UserPreferencesRepository$special$$inlined$map$9(var4_1);
   }

   @NotNull
   public final Flow getThemeModeFlow() {
      return this.themeModeFlow;
   }

   @NotNull
   public final Flow getNotificationsMutedFlow() {
      return this.notificationsMutedFlow;
   }

   @NotNull
   public final Flow getLastSyncTimestampFlow() {
      return this.lastSyncTimestampFlow;
   }

   @NotNull
   public final Flow getCalendarSyncEnabledFlow() {
      return this.calendarSyncEnabledFlow;
   }

   @NotNull
   public final Flow getPlanNotificationEnabledFlow() {
      return this.planNotificationEnabledFlow;
   }

   @NotNull
   public final Flow getGoogleCalendarRemindersEnabledFlow() {
      return this.googleCalendarRemindersEnabledFlow;
   }

   @NotNull
   public final Flow getNotificationSoundEnabledFlow() {
      return this.notificationSoundEnabledFlow;
   }

   @NotNull
   public final Flow getNotificationMelodyFlow() {
      return this.notificationMelodyFlow;
   }

   @NotNull
   public final Flow getNotificationVolumeFlow() {
      return this.notificationVolumeFlow;
   }

   @Nullable
   public final Object updateThemeMode(@NotNull final String themeMode, @NotNull Continuation $completion) {
      Object var10000 = PreferencesKt.edit(UserPreferencesRepositoryKt.getDataStore(this.context), new Function2((Continuation)null) {
         int label;
         // $FF: synthetic field
         Object L$0;

         public final Object invokeSuspend(Object $result) {
            MutablePreferences preferences = (MutablePreferences)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  preferences.set(UserPreferencesRepository.PreferencesKeys.INSTANCE.getTHEME_MODE(), themeMode);
                  return Unit.INSTANCE;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         public final Object invoke(MutablePreferences p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public final Object updateNotificationsMuted(final boolean muted, @NotNull Continuation $completion) {
      Object var10000 = PreferencesKt.edit(UserPreferencesRepositoryKt.getDataStore(this.context), new Function2((Continuation)null) {
         int label;
         // $FF: synthetic field
         Object L$0;

         public final Object invokeSuspend(Object $result) {
            MutablePreferences preferences = (MutablePreferences)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  preferences.set(UserPreferencesRepository.PreferencesKeys.INSTANCE.getNOTIFICATIONS_MUTED(), Boxing.boxBoolean(muted));
                  return Unit.INSTANCE;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         public final Object invoke(MutablePreferences p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public final Object updateLastSyncTimestamp(final long timestamp, @NotNull Continuation $completion) {
      Object var10000 = PreferencesKt.edit(UserPreferencesRepositoryKt.getDataStore(this.context), new Function2((Continuation)null) {
         int label;
         // $FF: synthetic field
         Object L$0;

         public final Object invokeSuspend(Object $result) {
            MutablePreferences preferences = (MutablePreferences)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  preferences.set(UserPreferencesRepository.PreferencesKeys.INSTANCE.getLAST_SYNC_TIMESTAMP(), Boxing.boxLong(timestamp));
                  return Unit.INSTANCE;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         public final Object invoke(MutablePreferences p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public final Object updateCalendarSyncEnabled(final boolean enabled, @NotNull Continuation $completion) {
      Object var10000 = PreferencesKt.edit(UserPreferencesRepositoryKt.getDataStore(this.context), new Function2((Continuation)null) {
         int label;
         // $FF: synthetic field
         Object L$0;

         public final Object invokeSuspend(Object $result) {
            MutablePreferences preferences = (MutablePreferences)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  preferences.set(UserPreferencesRepository.PreferencesKeys.INSTANCE.getCALENDAR_SYNC_ENABLED(), Boxing.boxBoolean(enabled));
                  return Unit.INSTANCE;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         public final Object invoke(MutablePreferences p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public final Object updatePlanNotificationEnabled(final boolean enabled, @NotNull Continuation $completion) {
      Object var10000 = PreferencesKt.edit(UserPreferencesRepositoryKt.getDataStore(this.context), new Function2((Continuation)null) {
         int label;
         // $FF: synthetic field
         Object L$0;

         public final Object invokeSuspend(Object $result) {
            MutablePreferences preferences = (MutablePreferences)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  preferences.set(UserPreferencesRepository.PreferencesKeys.INSTANCE.getPLAN_NOTIFICATION_ENABLED(), Boxing.boxBoolean(enabled));
                  return Unit.INSTANCE;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         public final Object invoke(MutablePreferences p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public final Object updateGoogleCalendarRemindersEnabled(final boolean enabled, @NotNull Continuation $completion) {
      Object var10000 = PreferencesKt.edit(UserPreferencesRepositoryKt.getDataStore(this.context), new Function2((Continuation)null) {
         int label;
         // $FF: synthetic field
         Object L$0;

         public final Object invokeSuspend(Object $result) {
            MutablePreferences preferences = (MutablePreferences)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  preferences.set(UserPreferencesRepository.PreferencesKeys.INSTANCE.getGOOGLE_CALENDAR_REMINDERS_ENABLED(), Boxing.boxBoolean(enabled));
                  return Unit.INSTANCE;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         public final Object invoke(MutablePreferences p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public final Object updateNotificationSoundEnabled(final boolean enabled, @NotNull Continuation $completion) {
      Object var10000 = PreferencesKt.edit(UserPreferencesRepositoryKt.getDataStore(this.context), new Function2((Continuation)null) {
         int label;
         // $FF: synthetic field
         Object L$0;

         public final Object invokeSuspend(Object $result) {
            MutablePreferences preferences = (MutablePreferences)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  preferences.set(UserPreferencesRepository.PreferencesKeys.INSTANCE.getNOTIFICATION_SOUND_ENABLED(), Boxing.boxBoolean(enabled));
                  return Unit.INSTANCE;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         public final Object invoke(MutablePreferences p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public final Object updateNotificationMelody(@NotNull final String melody, @NotNull Continuation $completion) {
      Object var10000 = PreferencesKt.edit(UserPreferencesRepositoryKt.getDataStore(this.context), new Function2((Continuation)null) {
         int label;
         // $FF: synthetic field
         Object L$0;

         public final Object invokeSuspend(Object $result) {
            MutablePreferences preferences = (MutablePreferences)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  preferences.set(UserPreferencesRepository.PreferencesKeys.INSTANCE.getNOTIFICATION_MELODY(), melody);
                  return Unit.INSTANCE;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         public final Object invoke(MutablePreferences p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Nullable
   public final Object updateNotificationVolume(final int volume, @NotNull Continuation $completion) {
      Object var10000 = PreferencesKt.edit(UserPreferencesRepositoryKt.getDataStore(this.context), new Function2((Continuation)null) {
         int label;
         // $FF: synthetic field
         Object L$0;

         public final Object invokeSuspend(Object $result) {
            MutablePreferences preferences = (MutablePreferences)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  preferences.set(UserPreferencesRepository.PreferencesKeys.INSTANCE.getNOTIFICATION_VOLUME(), Boxing.boxInt(volume));
                  return Unit.INSTANCE;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         public final Object invoke(MutablePreferences p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, $completion);
      return var10000 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var10000 : Unit.INSTANCE;
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\b¨\u0006\u001c"},
      d2 = {"Lcom/example/settings/UserPreferencesRepository$PreferencesKeys;", "", "<init>", "()V", "THEME_MODE", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getTHEME_MODE", "()Landroidx/datastore/preferences/core/Preferences$Key;", "NOTIFICATIONS_MUTED", "", "getNOTIFICATIONS_MUTED", "LAST_SYNC_TIMESTAMP", "", "getLAST_SYNC_TIMESTAMP", "CALENDAR_SYNC_ENABLED", "getCALENDAR_SYNC_ENABLED", "PLAN_NOTIFICATION_ENABLED", "getPLAN_NOTIFICATION_ENABLED", "GOOGLE_CALENDAR_REMINDERS_ENABLED", "getGOOGLE_CALENDAR_REMINDERS_ENABLED", "NOTIFICATION_SOUND_ENABLED", "getNOTIFICATION_SOUND_ENABLED", "NOTIFICATION_MELODY", "getNOTIFICATION_MELODY", "NOTIFICATION_VOLUME", "", "getNOTIFICATION_VOLUME", "app"}
   )
   private static final class PreferencesKeys {
      @NotNull
      public static final PreferencesKeys INSTANCE = new PreferencesKeys();
      @NotNull
      private static final Preferences.Key THEME_MODE = androidx.datastore.preferences.core.PreferencesKeys.stringKey("theme_mode");
      @NotNull
      private static final Preferences.Key NOTIFICATIONS_MUTED = androidx.datastore.preferences.core.PreferencesKeys.booleanKey("notifications_muted");
      @NotNull
      private static final Preferences.Key LAST_SYNC_TIMESTAMP = androidx.datastore.preferences.core.PreferencesKeys.longKey("last_sync_timestamp");
      @NotNull
      private static final Preferences.Key CALENDAR_SYNC_ENABLED = androidx.datastore.preferences.core.PreferencesKeys.booleanKey("calendar_sync_enabled");
      @NotNull
      private static final Preferences.Key PLAN_NOTIFICATION_ENABLED = androidx.datastore.preferences.core.PreferencesKeys.booleanKey("plan_notification_enabled");
      @NotNull
      private static final Preferences.Key GOOGLE_CALENDAR_REMINDERS_ENABLED = androidx.datastore.preferences.core.PreferencesKeys.booleanKey("google_calendar_reminders_enabled");
      @NotNull
      private static final Preferences.Key NOTIFICATION_SOUND_ENABLED = androidx.datastore.preferences.core.PreferencesKeys.booleanKey("notification_sound_enabled");
      @NotNull
      private static final Preferences.Key NOTIFICATION_MELODY = androidx.datastore.preferences.core.PreferencesKeys.stringKey("notification_melody");
      @NotNull
      private static final Preferences.Key NOTIFICATION_VOLUME = androidx.datastore.preferences.core.PreferencesKeys.intKey("notification_volume");

      @NotNull
      public final Preferences.Key getTHEME_MODE() {
         return THEME_MODE;
      }

      @NotNull
      public final Preferences.Key getNOTIFICATIONS_MUTED() {
         return NOTIFICATIONS_MUTED;
      }

      @NotNull
      public final Preferences.Key getLAST_SYNC_TIMESTAMP() {
         return LAST_SYNC_TIMESTAMP;
      }

      @NotNull
      public final Preferences.Key getCALENDAR_SYNC_ENABLED() {
         return CALENDAR_SYNC_ENABLED;
      }

      @NotNull
      public final Preferences.Key getPLAN_NOTIFICATION_ENABLED() {
         return PLAN_NOTIFICATION_ENABLED;
      }

      @NotNull
      public final Preferences.Key getGOOGLE_CALENDAR_REMINDERS_ENABLED() {
         return GOOGLE_CALENDAR_REMINDERS_ENABLED;
      }

      @NotNull
      public final Preferences.Key getNOTIFICATION_SOUND_ENABLED() {
         return NOTIFICATION_SOUND_ENABLED;
      }

      @NotNull
      public final Preferences.Key getNOTIFICATION_MELODY() {
         return NOTIFICATION_MELODY;
      }

      @NotNull
      public final Preferences.Key getNOTIFICATION_VOLUME() {
         return NOTIFICATION_VOLUME;
      }
   }
}
