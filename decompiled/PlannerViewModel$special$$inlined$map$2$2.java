package com.example;

import com.example.data.local.entity.TaskEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PlannerViewModel.kt\ncom/example/PlannerViewModel\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,49:1\n50#2:50\n51#3:51\n774#4:52\n865#4,2:53\n*S KotlinDebug\n*F\n+ 1 PlannerViewModel.kt\ncom/example/PlannerViewModel\n*L\n51#1:52\n51#1:53,2\n*E\n"})
public final class PlannerViewModel$special$$inlined$map$2$2 implements FlowCollector {
   // $FF: synthetic field
   final FlowCollector $this_unsafeFlow;

   public PlannerViewModel$special$$inlined$map$2$2(FlowCollector $receiver) {
      this.$this_unsafeFlow = $receiver;
   }

   public final Object emit(Object value, Continuation $completion) {
      Continuation $continuation;
      label31: {
         if ($completion instanceof PlannerViewModel$special$$inlined$map$2$2$1) {
            $continuation = (PlannerViewModel$special$$inlined$map$2$2$1)$completion;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
               $continuation.label -= Integer.MIN_VALUE;
               break label31;
            }
         }

         $continuation = new PlannerViewModel$special$$inlined$map$2$2$1(this, $completion);
      }

      Object $result = $continuation.result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      switch ($continuation.label) {
         case 0:
            ResultKt.throwOnFailure($result);
            FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
            int var25 = 0;
            Continuation var11 = $continuation;
            List var12 = (List)value;
            int var13 = 0;
            Iterable var14 = (Iterable)var12;
            int var15 = 0;
            Collection var17 = (Collection)(new ArrayList());
            int var18 = 0;

            for(Object var20 : var14) {
               TaskEntity var21 = (TaskEntity)var20;
               int var22 = 0;
               if (var21.isTimeBoxed()) {
                  var17.add(var20);
               }
            }

            List var10001 = (List)var17;
            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
            $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
            $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
            $continuation.I$0 = var25;
            $continuation.label = 1;
            if ($this$map_u24lambda_u245.emit(var10001, $continuation) == var5) {
               return var5;
            }
            break;
         case 1:
            int var9 = $continuation.I$0;
            FlowCollector $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
            Object value = $continuation.L$2;
            Continuation $completion = (PlannerViewModel$special$$inlined$map$2$2$1)$continuation.L$1;
            value = $continuation.L$0;
            ResultKt.throwOnFailure($result);
            break;
         default:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }

      return Unit.INSTANCE;
   }
}
