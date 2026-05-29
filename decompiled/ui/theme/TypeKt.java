package com.example.ui.theme;

import androidx.compose.material3.Typography;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
   d2 = {"Typography", "Landroidx/compose/material3/Typography;", "getTypography", "()Landroidx/compose/material3/Typography;", "app"}
)
public final class TypeKt {
   @NotNull
   private static final Typography Typography;

   @NotNull
   public static final Typography getTypography() {
      return Typography;
   }

   static {
      SystemFontFamily var0 = FontFamily.Companion.getDefault();
      FontWeight var1 = FontWeight.Companion.getNormal();
      long var2 = TextUnitKt.getSp(16);
      long var4 = TextUnitKt.getSp(24);
      long var6 = TextUnitKt.getSp((double)0.5F);
      Typography = new Typography((TextStyle)null, (TextStyle)null, (TextStyle)null, (TextStyle)null, (TextStyle)null, (TextStyle)null, (TextStyle)null, (TextStyle)null, (TextStyle)null, new TextStyle(0L, var2, var1, (FontStyle)null, (FontSynthesis)null, (FontFamily)var0, (String)null, var6, (BaselineShift)null, (TextGeometricTransform)null, (LocaleList)null, 0L, (TextDecoration)null, (Shadow)null, (DrawStyle)null, 0, 0, var4, (TextIndent)null, (PlatformTextStyle)null, (LineHeightStyle)null, 0, 0, (TextMotion)null, 16645977, (DefaultConstructorMarker)null), (TextStyle)null, (TextStyle)null, (TextStyle)null, (TextStyle)null, (TextStyle)null, 32255, (DefaultConstructorMarker)null);
   }
}
