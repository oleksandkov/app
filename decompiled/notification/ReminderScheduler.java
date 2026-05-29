package com.example.notification;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0013"},
   d2 = {"Lcom/example/notification/ReminderScheduler;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "workManager", "Landroidx/work/WorkManager;", "getWorkManager", "()Landroidx/work/WorkManager;", "scheduleReminder", "", "id", "", "type", "", "triggerAtMillis", "", "cancelReminder", "app"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nReminderScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReminderScheduler.kt\ncom/example/notification/ReminderScheduler\n+ 2 OneTimeWorkRequest.kt\nandroidx/work/OneTimeWorkRequestKt\n*L\n1#1,41:1\n105#2:42\n*S KotlinDebug\n*F\n+ 1 ReminderScheduler.kt\ncom/example/notification/ReminderScheduler\n*L\n24#1:42\n*E\n"})
public final class ReminderScheduler {
   @NotNull
   private final Context context;
   public static final int $stable = 8;

   public ReminderScheduler(@NotNull Context context) {
      Intrinsics.checkNotNullParameter(context, "context");
      super();
      this.context = context;
   }

   private final WorkManager getWorkManager() {
      WorkManager var1;
      try {
         var1 = WorkManager.Companion.getInstance(this.context);
      } catch (Exception var3) {
         var1 = null;
      }

      return var1;
   }

   public final void scheduleReminder(int id, @NotNull String type, long triggerAtMillis) {
      Intrinsics.checkNotNullParameter(type, "type");
      WorkManager var10000 = this.getWorkManager();
      if (var10000 != null) {
         WorkManager wm = var10000;
         long delay = triggerAtMillis - System.currentTimeMillis();
         if (delay > 0L) {
            Data data = (new Data.Builder()).putInt("id", id).putString("type", type).build();
            int var10 = 0;
            OneTimeWorkRequest workRequest = (OneTimeWorkRequest)((OneTimeWorkRequest.Builder)((OneTimeWorkRequest.Builder)((OneTimeWorkRequest.Builder)(new OneTimeWorkRequest.Builder(ReminderWorker.class)).setInputData(data)).setInitialDelay(delay, TimeUnit.MILLISECONDS)).addTag(type + "_" + id)).build();
            wm.enqueueUniqueWork(type + "_" + id, ExistingWorkPolicy.REPLACE, workRequest);
         }
      }
   }

   public final void cancelReminder(int id, @NotNull String type) {
      Intrinsics.checkNotNullParameter(type, "type");
      WorkManager var10000 = this.getWorkManager();
      if (var10000 != null) {
         var10000.cancelUniqueWork(type + "_" + id);
      }

   }
}
