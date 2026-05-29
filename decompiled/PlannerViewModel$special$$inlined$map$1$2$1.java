package com.example;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
@DebugMetadata(
   f = "PlannerViewModel.kt",
   l = {50},
   i = {0, 0, 0, 0, 0},
   s = {"L$0", "L$1", "L$2", "L$3", "I$0"},
   n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1\\1\\49\\0"},
   m = "emit",
   c = "com.example.PlannerViewModel$special$$inlined$map$1$2"
)
public final class PlannerViewModel$special$$inlined$map$1$2$1 extends ContinuationImpl {
   // $FF: synthetic field
   Object result;
   int label;
   Object L$0;
   // $FF: synthetic field
   final PlannerViewModel$special$$inlined$map$1$2 this$0;
   Object L$1;
   Object L$2;
   Object L$3;
   int I$0;

   public PlannerViewModel$special$$inlined$map$1$2$1(PlannerViewModel$special$$inlined$map$1$2 this$0, Continuation $completion) {
      super($completion);
      this.this$0 = this$0;
   }

   public final Object invokeSuspend(Object $result) {
      this.result = $result;
      this.label |= Integer.MIN_VALUE;
      return this.this$0.emit((Object)null, (Continuation)this);
   }
}
