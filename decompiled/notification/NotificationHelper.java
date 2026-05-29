package com.example.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import com.example.MainActivity;
import com.example.settings.UserPreferencesRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lcom/example/notification/NotificationHelper;", "", "<init>", "()V", "CHANNEL_ID", "", "playMelody", "", "context", "Landroid/content/Context;", "melodyName", "volume", "", "showNotification", "id", "title", "text", "STICKY_NOTIFICATION_ID", "updateStickyNotification", "planTitle", "app"}
)
@StabilityInferred(
   parameters = 1
)
public final class NotificationHelper {
   @NotNull
   public static final NotificationHelper INSTANCE = new NotificationHelper();
   @NotNull
   private static final String CHANNEL_ID = "planner_reminders_v2";
   private static final int STICKY_NOTIFICATION_ID = 9999;
   public static final int $stable;

   private NotificationHelper() {
   }

   public final void playMelody(@NotNull Context context, @NotNull String melodyName, int volume) {
      byte var10000;
      label32: {
         Intrinsics.checkNotNullParameter(context, "context");
         Intrinsics.checkNotNullParameter(melodyName, "melodyName");
         switch (melodyName) {
            case "Classic Chime":
               var10000 = 44;
               break label32;
            case "Double Alert":
               var10000 = 93;
               break label32;
            case "Digital Ping":
               var10000 = 27;
               break label32;
         }

         var10000 = 24;
      }

      int toneType = var10000;

      try {
         ToneGenerator toneGenerator = new ToneGenerator(5, volume);
         toneGenerator.startTone(toneType, 300);
         (new Handler(Looper.getMainLooper())).postDelayed(NotificationHelper::playMelody$lambda$0, 500L);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public final void showNotification(@NotNull final Context context, int id, @NotNull String title, @NotNull String text) {
      Intrinsics.checkNotNullParameter(context, "context");
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(text, "text");
      Intent var7_1 = new Intent(context, MainActivity.class);
      int var8 = 0;
      var7_1.setFlags(268468224);
      PendingIntent pendingIntent = PendingIntent.getActivity(context, id, var7_1, 201326592);
      Notification var10000 = (new NotificationCompat.Builder(context, "planner_reminders_v2")).setSmallIcon(17301598).setContentTitle((CharSequence)title).setContentText((CharSequence)text).setPriority(1).setContentIntent(pendingIntent).setAutoCancel(true).setSound((Uri)null).build();
      Intrinsics.checkNotNullExpressionValue(var10000, "build(...)");
      Notification notification = var10000;
      Object var13 = context.getSystemService("notification");
      Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type android.app.NotificationManager");
      NotificationManager notificationManager = (NotificationManager)var13;

      try {
         notificationManager.notify(id, notification);
      } catch (Exception e) {
         e.printStackTrace();
      }

      final UserPreferencesRepository prefsRepository = new UserPreferencesRepository(context);
      BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getIO()), (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         boolean Z$0;
         Object L$0;
         int label;

         public final Object invokeSuspend(Object $result) {
            Exception var10000;
            label67: {
               String melody;
               label71: {
                  Object var5;
                  boolean soundEnabled;
                  label72: {
                     var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     Object var17;
                     switch (this.label) {
                        case 0:
                           ResultKt.throwOnFailure($result);

                           try {
                              Flow var18 = prefsRepository.getNotificationSoundEnabledFlow();
                              Continuation var24 = (Continuation)this;
                              this.label = 1;
                              var17 = FlowKt.first(var18, var24);
                           } catch (Exception var9) {
                              var10000 = var9;
                              boolean var23 = false;
                              break label67;
                           }

                           if (var17 == var5) {
                              return var5;
                           }
                           break;
                        case 1:
                           try {
                              ResultKt.throwOnFailure($result);
                              var17 = $result;
                              break;
                           } catch (Exception var10) {
                              var10000 = var10;
                              boolean var22 = false;
                              break label67;
                           }
                        case 2:
                           soundEnabled = this.Z$0;

                           try {
                              ResultKt.throwOnFailure($result);
                              var16 = $result;
                              break label72;
                           } catch (Exception var11) {
                              var10000 = var11;
                              boolean var21 = false;
                              break label67;
                           }
                        case 3:
                           soundEnabled = this.Z$0;
                           melody = (String)this.L$0;

                           try {
                              ResultKt.throwOnFailure($result);
                              var15 = $result;
                              break label71;
                           } catch (Exception var12) {
                              var10000 = var12;
                              boolean var10001 = false;
                              break label67;
                           }
                        default:
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     try {
                        soundEnabled = (Boolean)var17;
                        if (!soundEnabled) {
                           return Unit.INSTANCE;
                        }

                        Flow var19 = prefsRepository.getNotificationMelodyFlow();
                        Continuation var26 = (Continuation)this;
                        this.Z$0 = soundEnabled;
                        this.label = 2;
                        var16 = FlowKt.first(var19, var26);
                     } catch (Exception var8) {
                        var10000 = var8;
                        boolean var25 = false;
                        break label67;
                     }

                     if (var16 == var5) {
                        return var5;
                     }
                  }

                  try {
                     melody = (String)var16;
                     Flow var20 = prefsRepository.getNotificationVolumeFlow();
                     Continuation var28 = (Continuation)this;
                     this.L$0 = melody;
                     this.Z$0 = soundEnabled;
                     this.label = 3;
                     var15 = FlowKt.first(var20, var28);
                  } catch (Exception var7) {
                     var10000 = var7;
                     boolean var27 = false;
                     break label67;
                  }

                  if (var15 == var5) {
                     return var5;
                  }
               }

               try {
                  int volume = ((Number)var15).intValue();
                  NotificationHelper.INSTANCE.playMelody(context, melody, volume);
                  return Unit.INSTANCE;
               } catch (Exception var6) {
                  var10000 = var6;
                  boolean var29 = false;
               }
            }

            Exception e = var10000;
            e.printStackTrace();
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

   public final void updateStickyNotification(@NotNull Context context, @Nullable String planTitle) {
      Intrinsics.checkNotNullParameter(context, "context");
      Object var10000 = context.getSystemService("notification");
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type android.app.NotificationManager");
      NotificationManager notificationManager = (NotificationManager)var10000;
      if (planTitle == null) {
         try {
            notificationManager.cancel(9999);
         } catch (Exception e) {
            e.printStackTrace();
         }

      } else {
         Intent var6_1 = new Intent(context, MainActivity.class);
         int var7 = 0;
         var6_1.setFlags(268468224);
         PendingIntent pendingIntent = PendingIntent.getActivity(context, 9999, var6_1, 201326592);
         Notification var11 = (new NotificationCompat.Builder(context, "planner_reminders_v2")).setSmallIcon(17301598).setContentTitle((CharSequence)"Current Action").setContentText((CharSequence)planTitle).setPriority(-1).setContentIntent(pendingIntent).setOngoing(true).setSound((Uri)null).build();
         Intrinsics.checkNotNullExpressionValue(var11, "build(...)");
         Notification notification = var11;

         try {
            notificationManager.notify(9999, notification);
         } catch (Exception e) {
            e.printStackTrace();
         }

      }
   }

   private static final void playMelody$lambda$0(ToneGenerator $toneGenerator) {
      try {
         $toneGenerator.release();
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}
