package com.example;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.example.notification.PlanNotificationWorker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"},
   d2 = {"Lcom/example/PlannerProApplication;", "Landroid/app/Application;", "<init>", "()V", "onCreate", "", "createNotificationChannels", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class PlannerProApplication extends Application {
   public static final int $stable = 8;

   public void onCreate() {
      super.onCreate();
      this.createNotificationChannels();

      try {
         WorkManager.Companion.getInstance((Context)this).enqueue((WorkRequest)OneTimeWorkRequest.Companion.from(PlanNotificationWorker.class));
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   private final void createNotificationChannels() {
      if (VERSION.SDK_INT >= 26) {
         String name = "Task Reminders";
         String descriptionText = "Notifications for planner task and note reminders";
         int importance = 4;
         NotificationChannel var6_1 = new NotificationChannel("planner_reminders_v2", (CharSequence)name, importance);
         int var7 = 0;
         var6_1.setDescription(descriptionText);
         var6_1.setSound((Uri)null, (AudioAttributes)null);
         NotificationChannel channel = var6_1;
         Object var10000 = this.getSystemService("notification");
         Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type android.app.NotificationManager");
         NotificationManager notificationManager = (NotificationManager)var10000;
         notificationManager.createNotificationChannel(channel);
      }

   }
}
