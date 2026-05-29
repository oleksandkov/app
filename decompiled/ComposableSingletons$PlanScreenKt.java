package com.example;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.EditKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nPlanScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlanScreen.kt\ncom/example/ComposableSingletons$PlanScreenKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,679:1\n149#2:680\n149#2:681\n149#2:682\n71#3:683\n69#3,5:684\n74#3:717\n78#3:721\n79#4,6:689\n86#4,4:704\n90#4,2:714\n94#4:720\n368#5,9:695\n377#5:716\n378#5,2:718\n4034#6,6:708\n*S KotlinDebug\n*F\n+ 1 PlanScreen.kt\ncom/example/ComposableSingletons$PlanScreenKt\n*L\n229#1:680\n527#1:681\n529#1:682\n524#1:683\n524#1:684,5\n524#1:717\n524#1:721\n524#1:689,6\n524#1:704,4\n524#1:714,2\n524#1:720\n524#1:695,9\n524#1:716\n524#1:718,2\n524#1:708,6\n*E\n"})
public final class ComposableSingletons$PlanScreenKt {
   @NotNull
   public static final ComposableSingletons$PlanScreenKt INSTANCE = new ComposableSingletons$PlanScreenKt();
   @NotNull
   private static Function3 lambda$113925377 = (Function3)ComposableLambdaKt.composableLambdaInstance(113925377, false, ComposableSingletons$PlanScreenKt::lambda_113925377$lambda$0);
   @NotNull
   private static Function3 lambda$404551352 = (Function3)ComposableLambdaKt.composableLambdaInstance(404551352, false, ComposableSingletons$PlanScreenKt::lambda_404551352$lambda$1);
   @NotNull
   private static Function2 lambda$-1136223843 = (Function2)ComposableLambdaKt.composableLambdaInstance(-1136223843, false, ComposableSingletons$PlanScreenKt::lambda__1136223843$lambda$2);
   @NotNull
   private static Function2 lambda$-477593260 = (Function2)ComposableLambdaKt.composableLambdaInstance(-477593260, false, ComposableSingletons$PlanScreenKt::lambda__477593260$lambda$3);
   @NotNull
   private static Function3 lambda$-554183108 = (Function3)ComposableLambdaKt.composableLambdaInstance(-554183108, false, ComposableSingletons$PlanScreenKt::lambda__554183108$lambda$5);

   @NotNull
   public final Function3 getLambda$113925377$app() {
      return lambda$113925377;
   }

   @NotNull
   public final Function3 getLambda$404551352$app() {
      return lambda$404551352;
   }

   @NotNull
   public final Function2 getLambda$_1136223843$app/* $FF was: getLambda$-1136223843$app*/() {
      return lambda$-1136223843;
   }

   @NotNull
   public final Function2 getLambda$_477593260$app/* $FF was: getLambda$-477593260$app*/() {
      return lambda$-477593260;
   }

   @NotNull
   public final Function3 getLambda$_554183108$app/* $FF was: getLambda$-554183108$app*/() {
      return lambda$-554183108;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda_113925377$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$item, "$this$item");
      ComposerKt.sourceInformation($composer, "C201@8335L11,197@8115L341:PlanScreen.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(113925377, $changed, -1, "com.example.ComposableSingletons$PlanScreenKt.lambda$113925377.<anonymous> (PlanScreen.kt:197)");
         }

         long var3 = TextUnitKt.getSp(11);
         FontWeight var5 = FontWeight.Companion.getBold();
         long var6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.4F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         long var8 = TextUnitKt.getSp((double)1.5F);
         TextKt.Text--4IGK_g("TODAY'S TASKS & PLANS", (Modifier)null, var6, var3, (FontStyle)null, var5, (FontFamily)null, var8, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 12782598, 0, 130898);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda_404551352$lambda$1(LazyItemScope $this$item, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$item, "$this$item");
      ComposerKt.sourceInformation($composer, "C228@9626L41,233@9907L11,229@9692L336:PlanScreen.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(404551352, $changed, -1, "com.example.ComposableSingletons$PlanScreenKt.lambda$404551352.<anonymous> (PlanScreen.kt:228)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var3 = 16;
         int var4 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var10000, Dp.constructor-impl((float)var3)), $composer, 6);
         long var10 = TextUnitKt.getSp(11);
         FontWeight var5 = FontWeight.Companion.getBold();
         long var6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.4F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         long var8 = TextUnitKt.getSp((double)1.5F);
         TextKt.Text--4IGK_g("SUBTASKS BY PLAN", (Modifier)null, var6, var10, (FontStyle)null, var5, (FontFamily)null, var8, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 12782598, 0, 130898);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda__1136223843$lambda$2(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C490@21970L11,487@21779L264:PlanScreen.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1136223843, $changed, -1, "com.example.ComposableSingletons$PlanScreenKt.lambda$-1136223843.<anonymous> (PlanScreen.kt:487)");
         }

         IconKt.Icon-ww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), "Edit task", (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null), $composer, 48, 4);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda__477593260$lambda$3(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C498@22355L11,495@22160L261:PlanScreen.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-477593260, $changed, -1, "com.example.ComposableSingletons$PlanScreenKt.lambda$-477593260.<anonymous> (PlanScreen.kt:495)");
         }

         IconKt.Icon-ww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Delete task", (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError-0d7_KjU(), 0.7F, 0.0F, 0.0F, 0.0F, 14, (Object)null), $composer, 48, 4);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda__554183108$lambda$5(RowScope $this$SwipeToDismissBox, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$SwipeToDismissBox, "$this$SwipeToDismissBox");
      ComposerKt.sourceInformation($composer, "C523@23070L556:PlanScreen.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-554183108, $changed, -1, "com.example.ComposableSingletons$PlanScreenKt.lambda$-554183108.<anonymous> (PlanScreen.kt:523)");
         }

         Modifier var10000 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var3 = 24;
         int var4 = 0;
         var10000 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(var10000, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var3))), Color.copy-wmQWz5c$default(Color.Companion.getRed-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null), (Shape)null, 2, (Object)null);
         var3 = 24;
         var4 = 0;
         Modifier var32 = PaddingKt.padding-qDBjuR0$default(var10000, 0.0F, 0.0F, Dp.constructor-impl((float)var3), 0.0F, 11, (Object)null);
         Alignment var34 = Alignment.Companion.getCenterEnd();
         byte var7 = 48;
         int var8 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         boolean var5 = false;
         MeasurePolicy var9 = BoxKt.maybeCachedBoxMeasurePolicy(var34, var5);
         int var10 = 112 & var7 << 3;
         int var11 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var12 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var13 = $composer.getCurrentCompositionLocalMap();
         Modifier var14 = ComposedModifierKt.materializeModifier($composer, var32);
         Function0 var15 = ComposeUiNode.Companion.getConstructor();
         int var16 = 6 | 896 & var10 << 6;
         int var17 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var15);
         } else {
            $composer.useNode();
         }

         Composer var18 = Updater.constructor-impl($composer);
         int var19 = 0;
         Updater.set-impl(var18, var9, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var18, var13, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var20 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var21 = 0;
         int var23 = 0;
         if (var18.getInserting() || !Intrinsics.areEqual(var18.rememberedValue(), var12)) {
            var18.updateRememberedValue(var12);
            var18.apply(var12, var20);
         }

         Updater.set-impl(var18, var14, ComposeUiNode.Companion.getSetModifier());
         int var24 = 14 & var16 >> 6;
         int var26 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         int var27 = 6 | 112 & var7 >> 6;
         BoxScope var36 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var30 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -255651340, "C531@23423L185:PlanScreen.kt#to5c3");
         IconKt.Icon-ww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Delete", (Modifier)null, Color.Companion.getWhite-0d7_KjU(), $composer, 3120, 4);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }
}
