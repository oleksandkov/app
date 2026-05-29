package com.example.settings;

import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 UserPreferencesRepository.kt\ncom/example/settings/UserPreferencesRepository\n*L\n1#1,49:1\n50#2:50\n96#3:51\n*E\n"})
public final class UserPreferencesRepository$special$$inlined$map$6$2 implements FlowCollector {
   // $FF: synthetic field
   final FlowCollector $this_unsafeFlow;

   public UserPreferencesRepository$special$$inlined$map$6$2(FlowCollector $receiver) {
      this.$this_unsafeFlow = $receiver;
   }

   public final Object emit(Object value, Continuation $completion) {
      Continuation $continuation;
      label25: {
         if ($completion instanceof UserPreferencesRepository$special$$inlined$map$6$2$1) {
            $continuation = (UserPreferencesRepository$special$$inlined$map$6$2$1)$completion;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
               $continuation.label -= Integer.MIN_VALUE;
               break label25;
            }
         }

         $continuation = new UserPreferencesRepository$special$$inlined$map$6$2$1(this, $completion);
      }

      Object $result = $continuation.result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      switch ($continuation.label) {
         case 0:
            ResultKt.throwOnFailure($result);
            FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
            int var16 = 0;
            Continuation var11 = $continuation;
            Preferences var12 = (Preferences)value;
            int var13 = 0;
            Boolean var10000 = (Boolean)var12.get(UserPreferencesRepository.PreferencesKeys.INSTANCE.getGOOGLE_CALENDAR_REMINDERS_ENABLED());
            Boolean var10001 = Boxing.boxBoolean(var10000 != null ? var10000 : true);
            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
            $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
            $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
            $continuation.I$0 = var16;
            $continuation.label = 1;
            if ($this$map_u24lambda_u245.emit(var10001, $continuation) == var5) {
               return var5;
            }
            break;
         case 1:
            int var9 = $continuation.I$0;
            FlowCollector $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
            Object value = $continuation.L$2;
            Continuation $completion = (UserPreferencesRepository$special$$inlined$map$6$2$1)$continuation.L$1;
            value = $continuation.L$0;
            ResultKt.throwOnFailure($result);
            break;
         default:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }

      return Unit.INSTANCE;
   }
}
