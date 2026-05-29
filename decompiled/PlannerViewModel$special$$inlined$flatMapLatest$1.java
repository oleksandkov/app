package com.example;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DebugMetadata(
   f = "PlannerViewModel.kt",
   l = {189},
   i = {0, 0},
   s = {"L$0", "L$1"},
   n = {"$this$transformLatest", "it"},
   m = "invokeSuspend",
   c = "com.example.PlannerViewModel$special$$inlined$flatMapLatest$1"
)
@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48,
   d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n¨\u0006\u0006"},
   d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}
)
@SourceDebugExtension({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n+ 2 PlannerViewModel.kt\ncom/example/PlannerViewModel\n*L\n1#1,189:1\n42#2:190\n*E\n"})
public final class PlannerViewModel$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3 {
   int label;
   // $FF: synthetic field
   private Object L$0;
   // $FF: synthetic field
   Object L$1;
   // $FF: synthetic field
   final PlannerViewModel this$0;

   public PlannerViewModel$special$$inlined$flatMapLatest$1(Continuation $completion, PlannerViewModel var2) {
      super(3, $completion);
      this.this$0 = var2;
   }

   public final Object invokeSuspend(Object $result) {
      Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      switch (this.label) {
         case 0:
            ResultKt.throwOnFailure($result);
            FlowCollector $this$transformLatest = (FlowCollector)this.L$0;
            Object it = this.L$1;
            Continuation var6 = (Continuation)this;
            long var7 = ((Number)it).longValue();
            int var9 = 0;
            Flow var10001 = PlannerViewModel.access$getTaskDao$p(this.this$0).getTasksForDate(this.this$0.getCurrentUserId(), PlannerViewModel.access$getStartOfDay(this.this$0, var7), PlannerViewModel.access$getEndOfDay(this.this$0, var7));
            Continuation var10002 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable($this$transformLatest);
            this.L$1 = SpillingKt.nullOutSpilledVariable(it);
            this.label = 1;
            if (FlowKt.emitAll($this$transformLatest, var10001, var10002) == var2) {
               return var2;
            }
            break;
         case 1:
            Object it = this.L$1;
            FlowCollector $this$transformLatest = (FlowCollector)this.L$0;
            ResultKt.throwOnFailure($result);
            break;
         default:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }

      return Unit.INSTANCE;
   }

   public final Object invoke(FlowCollector p1, Object p2, Continuation p3) {
      PlannerViewModel$special$$inlined$flatMapLatest$1 var4 = new PlannerViewModel$special$$inlined$flatMapLatest$1(p3, this.this$0);
      var4.L$0 = p1;
      var4.L$1 = p2;
      return var4.invokeSuspend(Unit.INSTANCE);
   }
}
