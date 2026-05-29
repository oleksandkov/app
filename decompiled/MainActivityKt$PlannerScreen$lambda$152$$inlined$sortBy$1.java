package com.example;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 MainActivity.kt\ncom/example/MainActivityKt\n*L\n1#1,328:1\n597#2:329\n*E\n"})
public final class MainActivityKt$PlannerScreen$lambda$152$$inlined$sortBy$1 implements Comparator {
   public final int compare(Object a, Object b) {
      TimelineItem var3 = (TimelineItem)a;
      int var4 = 0;
      Comparable var10000 = (Comparable)var3.getTimeInMillis();
      var3 = (TimelineItem)b;
      Comparable var5 = var10000;
      var4 = 0;
      return ComparisonsKt.compareValues(var5, (Comparable)var3.getTimeInMillis());
   }
}
