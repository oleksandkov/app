package com.example.ui.theme;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.Shapes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.view.WindowCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a*\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"},
   d2 = {"LightColorScheme", "Landroidx/compose/material3/ColorScheme;", "DarkColorScheme", "MyApplicationTheme", "", "themeMode", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "isAppInDarkTheme", "", "(Landroidx/compose/runtime/Composer;I)Z", "app"}
)
@SourceDebugExtension({"SMAP\nTheme.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Theme.kt\ncom/example/ui/theme/ThemeKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,77:1\n77#2:78\n1225#3,6:79\n*S KotlinDebug\n*F\n+ 1 Theme.kt\ncom/example/ui/theme/ThemeKt\n*L\n57#1:78\n59#1:79,6\n*E\n"})
public final class ThemeKt {
   @NotNull
   private static final ColorScheme LightColorScheme;
   @NotNull
   private static final ColorScheme DarkColorScheme;

   @Composable
   @ComposableInferredTarget(
      scheme = "[0[0]]"
   )
   public static final void MyApplicationTheme(@Nullable String themeMode, @NotNull Function2 content, @Nullable Composer $composer, int $changed, int var4) {
      Intrinsics.checkNotNullParameter(content, "content");
      $composer = $composer.startRestartGroup(1403526328);
      ComposerKt.sourceInformation($composer, "C(MyApplicationTheme)P(1)48@1481L21,56@1732L7,65@2042L114:Theme.kt#75kw8w");
      int $dirty = $changed;
      if ((var4 & 1) != 0) {
         $dirty = $changed | 6;
      } else if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(themeMode) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(content) ? 32 : 16;
      }

      if (($dirty & 19) == 18 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if ((var4 & 1) != 0) {
            themeMode = "SYSTEM";
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1403526328, $dirty, -1, "com.example.ui.theme.MyApplicationTheme (Theme.kt:47)");
         }

         boolean isSystemDark = DarkThemeKt.isSystemInDarkTheme($composer, 0);
         boolean useDarkTheme = Intrinsics.areEqual(themeMode, "LIGHT") ? false : (Intrinsics.areEqual(themeMode, "DARK") ? true : isSystemDark);
         ColorScheme colorScheme = useDarkTheme ? DarkColorScheme : LightColorScheme;
         CompositionLocal var10 = (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalView();
         int var12 = 0;
         int var13 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
         Object var14 = $composer.consume(var10);
         ComposerKt.sourceInformationMarkerEnd($composer);
         View view = (View)var14;
         if (view.isInEditMode()) {
            $composer.startReplaceGroup(944872682);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(946635838);
            ComposerKt.sourceInformation($composer, "58@1789L241,58@1778L252");
            ComposerKt.sourceInformationMarkerStart($composer, 169084617, "CC(remember):Theme.kt#9igjgp");
            var12 = $composer.changedInstance(view) | $composer.changed(colorScheme) | $composer.changed(useDarkTheme);
            var13 = 0;
            var14 = $composer.rememberedValue();
            int var15 = 0;
            Object var10000;
            if (!var12 && var14 != Composer.Companion.getEmpty()) {
               var10000 = var14;
            } else {
               int var16 = 0;
               Object var17 = ThemeKt::MyApplicationTheme$lambda$1$lambda$0;
               $composer.updateRememberedValue(var17);
               var10000 = var17;
            }

            Function0 var19 = (Function0)var10000;
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.SideEffect(var19, $composer, 0);
            $composer.endReplaceGroup();
         }

         MaterialThemeKt.MaterialTheme(colorScheme, (Shapes)null, TypeKt.getTypography(), content, $composer, 384 | 7168 & $dirty << 6, 2);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var23 = $composer.endRestartGroup();
      if (var23 != null) {
         var23.updateScope(ThemeKt::MyApplicationTheme$lambda$2);
      }

   }

   @Composable
   public static final boolean isAppInDarkTheme(@Nullable Composer $composer, int $changed) {
      ComposerKt.sourceInformationMarkerStart($composer, 252256894, "C(isAppInDarkTheme)74@2231L11:Theme.kt#75kw8w");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(252256894, $changed, -1, "com.example.ui.theme.isAppInDarkTheme (Theme.kt:73)");
      }

      boolean var2 = Color.equals-impl0(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getBackground-0d7_KjU(), ColorKt.getDarkBackground());
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      ComposerKt.sourceInformationMarkerEnd($composer);
      return var2;
   }

   private static final Unit MyApplicationTheme$lambda$1$lambda$0(View $view, ColorScheme $colorScheme, boolean $useDarkTheme) {
      Context var10000 = $view.getContext();
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type android.app.Activity");
      Window window = ((Activity)var10000).getWindow();
      window.setStatusBarColor(androidx.compose.ui.graphics.ColorKt.toArgb-8_81llA($colorScheme.getBackground-0d7_KjU()));
      WindowCompat.getInsetsController(window, $view).setAppearanceLightStatusBars(!$useDarkTheme);
      return Unit.INSTANCE;
   }

   private static final Unit MyApplicationTheme$lambda$2(String $themeMode, Function2 $content, int $$changed, int $$default, Composer $composer, int $force) {
      MyApplicationTheme($themeMode, $content, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1), $$default);
      return Unit.INSTANCE;
   }

   static {
      long var0 = ColorKt.getIndigo600();
      long var2 = ColorKt.getPurple500();
      long var4 = ColorKt.getIndigo400();
      long var6 = ColorKt.getAppBackground();
      long var8 = ColorKt.getAppBackground();
      long var10 = ColorKt.getWhite90();
      long var12 = ColorKt.getWhite90();
      long var14 = ColorKt.getWhite90();
      long var16 = ColorKt.getSlate900();
      long var18 = ColorKt.getSlate900();
      LightColorScheme = ColorSchemeKt.lightColorScheme-C-Xl9yA$default(var0, var10, 0L, 0L, 0L, var2, var12, 0L, 0L, var4, var14, 0L, 0L, var6, var16, var8, var18, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -124516, 15, (Object)null);
      var0 = ColorKt.getIndigo400();
      var2 = ColorKt.getPurple500();
      var4 = ColorKt.getIndigo100();
      var6 = ColorKt.getDarkBackground();
      var8 = ColorKt.getDarkSurface();
      var10 = ColorKt.getDarkTextPrimary();
      var12 = ColorKt.getDarkTextPrimary();
      var14 = ColorKt.getDarkTextPrimary();
      var16 = ColorKt.getDarkTextPrimary();
      var18 = ColorKt.getDarkTextPrimary();
      DarkColorScheme = ColorSchemeKt.darkColorScheme-C-Xl9yA$default(var0, var10, 0L, 0L, 0L, var2, var12, 0L, 0L, var4, var14, 0L, 0L, var6, var16, var8, var18, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -124516, 15, (Object)null);
   }
}
