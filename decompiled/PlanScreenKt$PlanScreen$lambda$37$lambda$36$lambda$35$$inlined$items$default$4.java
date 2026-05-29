package com.example;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.example.data.local.entity.TaskEntity;
import java.text.SimpleDateFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48,
   d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"},
   d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V", "androidx/compose/foundation/lazy/LazyDslKt$items$4"}
)
@SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$4\n+ 2 PlanScreen.kt\ncom/example/PlanScreenKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,433:1\n207#2,4:434\n213#2:444\n217#2:451\n218#2:458\n219#2:465\n224#2:472\n1225#3,6:438\n1225#3,6:445\n1225#3,6:452\n1225#3,6:459\n1225#3,6:466\n*S KotlinDebug\n*F\n+ 1 PlanScreen.kt\ncom/example/PlanScreenKt\n*L\n210#1:438,6\n213#1:445,6\n217#1:452,6\n218#1:459,6\n219#1:466,6\n*E\n"})
public final class PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$4 extends Lambda implements Function4 {
   // $FF: synthetic field
   final List $items;
   // $FF: synthetic field
   final SimpleDateFormat $timeFormatter$inlined;
   // $FF: synthetic field
   final PlannerViewModel $viewModel$inlined;
   // $FF: synthetic field
   final Function1 $onHighlightPlan$inlined;
   // $FF: synthetic field
   final Function1 $onTaskEdit$inlined;
   // $FF: synthetic field
   final Function1 $onTaskDelete$inlined;

   public PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$4(List $items, SimpleDateFormat var2, PlannerViewModel var3, Function1 var4, Function1 var5, Function1 var6) {
      super(4);
      this.$items = $items;
      this.$timeFormatter$inlined = var2;
      this.$viewModel$inlined = var3;
      this.$onHighlightPlan$inlined = var4;
      this.$onTaskEdit$inlined = var5;
      this.$onTaskDelete$inlined = var6;
   }

   @Composable
   public final void invoke(@NotNull LazyItemScope $this$items, int it, @Nullable Composer $composer, int $changed) {
      // $FF: Couldn't be decompiled
   }
}
