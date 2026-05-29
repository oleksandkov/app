package com.example;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48,
   d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"},
   d2 = {"<anonymous>", "", "T", "index", "", "invoke", "androidx/compose/foundation/lazy/LazyDslKt$items$2"}
)
@SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$2\n*L\n1#1,433:1\n*E\n"})
public final class PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$6 extends Lambda implements Function1 {
   // $FF: synthetic field
   final Function1 $key;
   // $FF: synthetic field
   final List $items;

   public PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$6(Function1 $key, List $items) {
      super(1);
      this.$key = $key;
      this.$items = $items;
   }

   @NotNull
   public final Object invoke(int index) {
      return this.$key.invoke(this.$items.get(index));
   }
}
