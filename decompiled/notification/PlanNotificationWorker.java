package com.example.notification;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.ListenableWorker.Result;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"},
   d2 = {"Lcom/example/notification/PlanNotificationWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}
)
@StabilityInferred(
   parameters = 0
)
public final class PlanNotificationWorker extends CoroutineWorker {
   public static final int $stable = 8;

   public PlanNotificationWorker(@NotNull Context context, @NotNull WorkerParameters workerParams) {
      Intrinsics.checkNotNullParameter(context, "context");
      Intrinsics.checkNotNullParameter(workerParams, "workerParams");
      super(context, workerParams);
   }

   @Nullable
   public Object doWork(@NotNull Continuation $completion) {
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
            // $FF: synthetic field
            Object result;
            int label;

            @Nullable
            public final Object invokeSuspend(@NotNull Object $result) {
               this.result = $result;
               this.label |= Integer.MIN_VALUE;
               return PlanNotificationWorker.this.doWork((Continuation)this);
            }
         };
      }

      Object $result = $continuation.result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      switch ($continuation.label) {
         case 0:
            ResultKt.throwOnFailure($result);
            PlanNotificationManager var10000 = PlanNotificationManager.INSTANCE;
            Context var10001 = this.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(var10001, "getApplicationContext(...)");
            $continuation.label = 1;
            if (var10000.updateCurrentPlanNotification(var10001, $continuation) == var4) {
               return var4;
            }
            break;
         case 1:
            ResultKt.throwOnFailure($result);
            break;
         default:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }

      ListenableWorker.Result var5 = Result.success();
      Intrinsics.checkNotNullExpressionValue(var5, "success(...)");
      return var5;
   }
}
