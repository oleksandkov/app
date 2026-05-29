package com.example;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AccountCircleKt;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
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
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras.Empty;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.example.settings.SettingsViewModel;
import com.example.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\ncom/example/ComposableSingletons$MainActivityKt\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 ViewModel.kt\nandroidx/lifecycle/viewmodel/compose/ViewModelKt__ViewModelKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 5 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,1753:1\n81#2:1754\n55#3,11:1755\n149#4:1766\n149#4:1767\n149#4:1768\n149#4:1769\n149#4:1770\n71#5:1771\n69#5,5:1772\n74#5:1805\n78#5:1809\n79#6,6:1777\n86#6,4:1792\n90#6,2:1802\n94#6:1808\n368#7,9:1783\n377#7:1804\n378#7,2:1806\n4034#8,6:1796\n*S KotlinDebug\n*F\n+ 1 MainActivity.kt\ncom/example/ComposableSingletons$MainActivityKt\n*L\n72#1:1754\n71#1:1755,11\n270#1:1766\n272#1:1767\n359#1:1768\n1058#1:1769\n1059#1:1770\n1055#1:1771\n1055#1:1772,5\n1055#1:1805\n1055#1:1809\n1055#1:1777,6\n1055#1:1792,4\n1055#1:1802,2\n1055#1:1808\n1055#1:1783,9\n1055#1:1804\n1055#1:1806,2\n1055#1:1796,6\n*E\n"})
public final class ComposableSingletons$MainActivityKt {
   @NotNull
   public static final ComposableSingletons$MainActivityKt INSTANCE = new ComposableSingletons$MainActivityKt();
   @NotNull
   private static Function2 lambda$-601144069 = (Function2)ComposableLambdaKt.composableLambdaInstance(-601144069, false, ComposableSingletons$MainActivityKt::lambda__601144069$lambda$2);
   @NotNull
   private static Function2 lambda$1744754540 = (Function2)ComposableLambdaKt.composableLambdaInstance(1744754540, false, ComposableSingletons$MainActivityKt::lambda_1744754540$lambda$3);
   @NotNull
   private static Function2 lambda$2078831761 = (Function2)ComposableLambdaKt.composableLambdaInstance(2078831761, false, ComposableSingletons$MainActivityKt::lambda_2078831761$lambda$4);
   @NotNull
   private static Function2 lambda$1702114632 = (Function2)ComposableLambdaKt.composableLambdaInstance(1702114632, false, ComposableSingletons$MainActivityKt::lambda_1702114632$lambda$5);
   @NotNull
   private static Function3 lambda$1549237918 = (Function3)ComposableLambdaKt.composableLambdaInstance(1549237918, false, ComposableSingletons$MainActivityKt::lambda_1549237918$lambda$6);
   @NotNull
   private static Function2 lambda$177959605 = (Function2)ComposableLambdaKt.composableLambdaInstance(177959605, false, ComposableSingletons$MainActivityKt::lambda_177959605$lambda$7);
   @NotNull
   private static Function3 lambda$-1829659831 = (Function3)ComposableLambdaKt.composableLambdaInstance(-1829659831, false, ComposableSingletons$MainActivityKt::lambda__1829659831$lambda$9);
   @NotNull
   private static Function3 lambda$-797412777 = (Function3)ComposableLambdaKt.composableLambdaInstance(-797412777, false, ComposableSingletons$MainActivityKt::lambda__797412777$lambda$10);
   @NotNull
   private static Function3 lambda$-1605815414 = (Function3)ComposableLambdaKt.composableLambdaInstance(-1605815414, false, ComposableSingletons$MainActivityKt::lambda__1605815414$lambda$11);
   @NotNull
   private static Function3 lambda$923266341 = (Function3)ComposableLambdaKt.composableLambdaInstance(923266341, false, ComposableSingletons$MainActivityKt::lambda_923266341$lambda$12);
   @NotNull
   private static Function2 lambda$-1416378372 = (Function2)ComposableLambdaKt.composableLambdaInstance(-1416378372, false, ComposableSingletons$MainActivityKt::lambda__1416378372$lambda$13);
   @NotNull
   private static Function2 lambda$-1559172109 = (Function2)ComposableLambdaKt.composableLambdaInstance(-1559172109, false, ComposableSingletons$MainActivityKt::lambda__1559172109$lambda$14);
   @NotNull
   private static Function2 lambda$-955061994 = (Function2)ComposableLambdaKt.composableLambdaInstance(-955061994, false, ComposableSingletons$MainActivityKt::lambda__955061994$lambda$15);
   @NotNull
   private static Function2 lambda$-320843275 = (Function2)ComposableLambdaKt.composableLambdaInstance(-320843275, false, ComposableSingletons$MainActivityKt::lambda__320843275$lambda$16);
   @NotNull
   private static Function2 lambda$1191297817 = (Function2)ComposableLambdaKt.composableLambdaInstance(1191297817, false, ComposableSingletons$MainActivityKt::lambda_1191297817$lambda$17);
   @NotNull
   private static Function3 lambda$562488902 = (Function3)ComposableLambdaKt.composableLambdaInstance(562488902, false, ComposableSingletons$MainActivityKt::lambda_562488902$lambda$18);
   @NotNull
   private static Function3 lambda$1684216341 = (Function3)ComposableLambdaKt.composableLambdaInstance(1684216341, false, ComposableSingletons$MainActivityKt::lambda_1684216341$lambda$19);

   @NotNull
   public final Function2 getLambda$_601144069$app/* $FF was: getLambda$-601144069$app*/() {
      return lambda$-601144069;
   }

   @NotNull
   public final Function2 getLambda$1744754540$app() {
      return lambda$1744754540;
   }

   @NotNull
   public final Function2 getLambda$2078831761$app() {
      return lambda$2078831761;
   }

   @NotNull
   public final Function2 getLambda$1702114632$app() {
      return lambda$1702114632;
   }

   @NotNull
   public final Function3 getLambda$1549237918$app() {
      return lambda$1549237918;
   }

   @NotNull
   public final Function2 getLambda$177959605$app() {
      return lambda$177959605;
   }

   @NotNull
   public final Function3 getLambda$_1829659831$app/* $FF was: getLambda$-1829659831$app*/() {
      return lambda$-1829659831;
   }

   @NotNull
   public final Function3 getLambda$_797412777$app/* $FF was: getLambda$-797412777$app*/() {
      return lambda$-797412777;
   }

   @NotNull
   public final Function3 getLambda$_1605815414$app/* $FF was: getLambda$-1605815414$app*/() {
      return lambda$-1605815414;
   }

   @NotNull
   public final Function3 getLambda$923266341$app() {
      return lambda$923266341;
   }

   @NotNull
   public final Function2 getLambda$_1416378372$app/* $FF was: getLambda$-1416378372$app*/() {
      return lambda$-1416378372;
   }

   @NotNull
   public final Function2 getLambda$_1559172109$app/* $FF was: getLambda$-1559172109$app*/() {
      return lambda$-1559172109;
   }

   @NotNull
   public final Function2 getLambda$_955061994$app/* $FF was: getLambda$-955061994$app*/() {
      return lambda$-955061994;
   }

   @NotNull
   public final Function2 getLambda$_320843275$app/* $FF was: getLambda$-320843275$app*/() {
      return lambda$-320843275;
   }

   @NotNull
   public final Function2 getLambda$1191297817$app() {
      return lambda$1191297817;
   }

   @NotNull
   public final Function3 getLambda$562488902$app() {
      return lambda$562488902;
   }

   @NotNull
   public final Function3 getLambda$1684216341$app() {
      return lambda$1684216341;
   }

   private static final String lambda__601144069$lambda$2$lambda$0(State $themeMode$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)$themeMode$delegate.getValue();
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda__601144069$lambda$2$lambda$1(SettingsViewModel $settingsViewModel, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C73@3194L36:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1251129304, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-601144069.<anonymous>.<anonymous> (MainActivity.kt:73)");
         }

         MainActivityKt.MainAppNavigation($settingsViewModel, $composer, 0);
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
   private static final Unit lambda__601144069$lambda$2(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C70@3023L11,71@3092L29,72@3176L68,72@3134L110:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-601144069, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-601144069.<anonymous> (MainActivity.kt:70)");
         }

         byte var8 = 0;
         int var9 = 0;
         $composer.startReplaceableGroup(1729797275);
         ComposerKt.sourceInformation($composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
         ViewModelStoreOwner var10000 = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer, 6);
         if (var10000 == null) {
            int var10 = 0;
            String var13 = "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner";
            throw new IllegalStateException(var13.toString());
         }

         ViewModelStoreOwner var3 = var10000;
         String var4 = null;
         ViewModelProvider.Factory var5 = null;
         CreationExtras var6 = var3 instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory)var3).getDefaultViewModelCreationExtras() : (CreationExtras)Empty.INSTANCE;
         ViewModel var11 = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(SettingsViewModel.class), var3, var4, var5, var6, $composer, 112 & var8 << 3 | 896 & var8 << 3 | 7168 & var8 << 3 | '\ue000' & var8 << 3, 0);
         $composer.endReplaceableGroup();
         SettingsViewModel settingsViewModel = (SettingsViewModel)var11;
         State themeMode$delegate = FlowExtKt.collectAsStateWithLifecycle(settingsViewModel.getThemeMode(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         ThemeKt.MyApplicationTheme(lambda__601144069$lambda$2$lambda$0(themeMode$delegate), (Function2)ComposableLambdaKt.rememberComposableLambda(-1251129304, true, ComposableSingletons$MainActivityKt::lambda__601144069$lambda$2$lambda$1, $composer, 54), $composer, 48, 0);
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
   private static final Unit lambda_1744754540$lambda$3(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C203@7988L12:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1744754540, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$1744754540.<anonymous> (MainActivity.kt:203)");
         }

         TextKt.Text--4IGK_g("Name", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
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
   private static final Unit lambda_2078831761$lambda$4(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C214@8420L13:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2078831761, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$2078831761.<anonymous> (MainActivity.kt:214)");
         }

         TextKt.Text--4IGK_g("Email", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
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
   private static final Unit lambda_1702114632$lambda$5(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C224@8821L16:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1702114632, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$1702114632.<anonymous> (MainActivity.kt:224)");
         }

         TextKt.Text--4IGK_g("Password", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
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
   private static final Unit lambda_1549237918$lambda$6(RowScope $this$Button, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
      ComposerKt.sourceInformation($composer, "C266@10729L210,271@10960L39,272@11020L79:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1549237918, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$1549237918.<anonymous> (MainActivity.kt:266)");
         }

         ImageVector var10000 = AccountCircleKt.getAccountCircle(Icons.INSTANCE.getDefault());
         Modifier var10002 = (Modifier)Modifier.Companion;
         int var3 = 20;
         int var4 = 0;
         IconKt.Icon-ww6aTOc(var10000, "Google Logo", SizeKt.size-3ABfNKs(var10002, Dp.constructor-impl((float)var3)), 0L, $composer, 432, 8);
         Modifier var7 = (Modifier)Modifier.Companion;
         var3 = 8;
         var4 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var7, Dp.constructor-impl((float)var3)), $composer, 6);
         TextKt.Text--4IGK_g("Sign in with Google", (Modifier)null, 0L, TextUnitKt.getSp(16), (FontStyle)null, FontWeight.Companion.getSemiBold(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 131030);
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
   private static final Unit lambda_177959605$lambda$7(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C358@14318L98:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(177959605, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$177959605.<anonymous> (MainActivity.kt:358)");
         }

         ImageVector var10000 = AddKt.getAdd(Icons.INSTANCE.getDefault());
         Modifier var10002 = (Modifier)Modifier.Companion;
         int var2 = 32;
         int var3 = 0;
         IconKt.Icon-ww6aTOc(var10000, "Add", SizeKt.size-3ABfNKs(var10002, Dp.constructor-impl((float)var2)), 0L, $composer, 432, 8);
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
   private static final Unit lambda__1829659831$lambda$9(RowScope $this$SwipeToDismissBox, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$SwipeToDismissBox, "$this$SwipeToDismissBox");
      ComposerKt.sourceInformation($composer, "C1054@48039L691:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1829659831, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-1829659831.<anonymous> (MainActivity.kt:1054)");
         }

         Modifier var10000 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         long var10001 = Color.copy-wmQWz5c$default(Color.Companion.getRed-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         int var3 = 24;
         int var4 = 0;
         var10000 = BackgroundKt.background-bw27NRU(var10000, var10001, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var3)));
         var3 = 24;
         var4 = 0;
         Modifier var32 = PaddingKt.padding-VpY3zN4$default(var10000, Dp.constructor-impl((float)var3), 0.0F, 2, (Object)null);
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
         ComposerKt.sourceInformationMarkerStart($composer, 1763677033, "C1061@48593L87:MainActivity.kt#to5c3");
         IconKt.Icon-ww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), (String)null, (Modifier)null, Color.Companion.getWhite-0d7_KjU(), $composer, 3120, 4);
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

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda__797412777$lambda$10(RowScope $this$Button, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
      ComposerKt.sourceInformation($composer, "C1594@74643L12:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-797412777, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-797412777.<anonymous> (MainActivity.kt:1594)");
         }

         TextKt.Text--4IGK_g("Save", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
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
   private static final Unit lambda__1605815414$lambda$11(RowScope $this$TextButton, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
      ComposerKt.sourceInformation($composer, "C1600@74847L14:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1605815414, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-1605815414.<anonymous> (MainActivity.kt:1600)");
         }

         TextKt.Text--4IGK_g("Cancel", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
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
   private static final Unit lambda_923266341$lambda$12(RowScope $this$TextButton, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
      ComposerKt.sourceInformation($composer, "C1604@75013L33:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(923266341, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$923266341.<anonymous> (MainActivity.kt:1604)");
         }

         TextKt.Text--4IGK_g("Delete", (Modifier)null, Color.Companion.getRed-0d7_KjU(), 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 390, 0, 131066);
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
   private static final Unit lambda__1416378372$lambda$13(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1328@60410L13:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1416378372, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-1416378372.<anonymous> (MainActivity.kt:1328)");
         }

         TextKt.Text--4IGK_g("Title", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
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
   private static final Unit lambda__1559172109$lambda$14(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1337@60759L19:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1559172109, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-1559172109.<anonymous> (MainActivity.kt:1337)");
         }

         TextKt.Text--4IGK_g("Description", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
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
   private static final Unit lambda__955061994$lambda$15(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1529@71673L116:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-955061994, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-955061994.<anonymous> (MainActivity.kt:1529)");
         }

         IconKt.Icon-ww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Delete Subtask", (Modifier)null, Color.copy-wmQWz5c$default(Color.Companion.getRed-0d7_KjU(), 0.7F, 0.0F, 0.0F, 0.0F, 14, (Object)null), $composer, 3120, 4);
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
   private static final Unit lambda__320843275$lambda$16(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1541@72259L29:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-320843275, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-320843275.<anonymous> (MainActivity.kt:1541)");
         }

         TextKt.Text--4IGK_g("New checklist item...", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
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
   private static final Unit lambda_1191297817$lambda$17(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1566@73654L73:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1191297817, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$1191297817.<anonymous> (MainActivity.kt:1566)");
         }

         IconKt.Icon-ww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Add subtask", (Modifier)null, 0L, $composer, 48, 12);
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
   private static final Unit lambda_562488902$lambda$18(RowScope $this$Button, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
      ComposerKt.sourceInformation($composer, "C1706@78981L13:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(562488902, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$562488902.<anonymous> (MainActivity.kt:1706)");
         }

         TextKt.Text--4IGK_g("Close", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
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
   private static final Unit lambda_1684216341$lambda$19(RowScope $this$TextButton, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
      ComposerKt.sourceInformation($composer, "C1715@79183L33:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1684216341, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$1684216341.<anonymous> (MainActivity.kt:1715)");
         }

         TextKt.Text--4IGK_g("Delete", (Modifier)null, Color.Companion.getRed-0d7_KjU(), 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 390, 0, 131066);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }
}
