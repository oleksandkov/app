package com.example.settings;

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
   f = "UserPreferencesRepository.kt",
   l = {50},
   i = {0, 0, 0, 0, 0},
   s = {"L$0", "L$1", "L$2", "L$3", "I$0"},
   n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1\\1\\49\\0"},
   m = "emit",
   c = "com.example.settings.UserPreferencesRepository$special$$inlined$map$4$2"
)
public final class UserPreferencesRepository$special$$inlined$map$4$2$1 extends ContinuationImpl {
   // $FF: synthetic field
   Object result;
   int label;
   Object L$0;
   // $FF: synthetic field
   final UserPreferencesRepository$special$$inlined$map$4$2 this$0;
   Object L$1;
   Object L$2;
   Object L$3;
   int I$0;

   public UserPreferencesRepository$special$$inlined$map$4$2$1(UserPreferencesRepository$special$$inlined$map$4$2 this$0, Continuation $completion) {
      super($completion);
      this.this$0 = this$0;
   }

   public final Object invokeSuspend(Object $result) {
      this.result = $result;
      this.label |= Integer.MIN_VALUE;
      return this.this$0.emit((Object)null, (Continuation)this);
   }
}
