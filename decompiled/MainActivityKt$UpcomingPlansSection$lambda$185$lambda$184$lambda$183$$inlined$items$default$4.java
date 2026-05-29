package com.example;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.example.ui.theme.ColorKt;
import com.example.ui.theme.ThemeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
@SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$4\n+ 2 MainActivity.kt\ncom/example/MainActivityKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 5 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/Updater\n+ 9 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n*L\n1#1,433:1\n745#2,7:434\n752#2:442\n753#2:444\n754#2:446\n760#2:453\n762#2:491\n763#2,8:529\n771#2:538\n773#2,4:545\n772#2,7:549\n779#2:560\n780#2:565\n149#3:441\n149#3:443\n149#3:445\n149#3:454\n149#3:537\n1225#4,6:447\n1225#4,6:539\n71#5:455\n68#5,6:456\n74#5:490\n78#5:564\n79#6,6:462\n86#6,4:477\n90#6,2:487\n79#6,6:500\n86#6,4:515\n90#6,2:525\n94#6:558\n94#6:563\n368#7,9:468\n377#7:489\n368#7,9:506\n377#7:527\n378#7,2:556\n378#7,2:561\n4034#8,6:481\n4034#8,6:519\n86#9:492\n82#9,7:493\n89#9:528\n93#9:559\n*S KotlinDebug\n*F\n+ 1 MainActivity.kt\ncom/example/MainActivityKt\n*L\n751#1:441\n752#1:443\n753#1:445\n760#1:454\n770#1:537\n754#1:447,6\n771#1:539,6\n749#1:455\n749#1:456,6\n749#1:490\n749#1:564\n749#1:462,6\n749#1:477,4\n749#1:487,2\n762#1:500,6\n762#1:515,4\n762#1:525,2\n762#1:558\n749#1:563\n749#1:468,9\n749#1:489\n762#1:506,9\n762#1:527\n762#1:556,2\n749#1:561,2\n749#1:481,6\n762#1:519,6\n762#1:492\n762#1:493,7\n762#1:528\n762#1:559\n*E\n"})
public final class MainActivityKt$UpcomingPlansSection$lambda$185$lambda$184$lambda$183$$inlined$items$default$4 extends Lambda implements Function4 {
   // $FF: synthetic field
   final List $items;
   // $FF: synthetic field
   final Function1 $onTaskClick$inlined;
   // $FF: synthetic field
   final Function1 $onGoogleEventClick$inlined;

   public MainActivityKt$UpcomingPlansSection$lambda$185$lambda$184$lambda$183$$inlined$items$default$4(List $items, Function1 var2, Function1 var3) {
      super(4);
      this.$items = $items;
      this.$onTaskClick$inlined = var2;
      this.$onGoogleEventClick$inlined = var3;
   }

   @Composable
   public final void invoke(@NotNull LazyItemScope $this$items, int it, @Nullable Composer $composer, int $changed) {
      // $FF: Couldn't be decompiled
   }
}
