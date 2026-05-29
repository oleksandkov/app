package com.example;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import com.example.data.local.entity.NoteEntity;
import com.example.notes.NotesViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
@SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$4\n+ 2 OtherScreens.kt\ncom/example/OtherScreensKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,433:1\n244#2,4:434\n248#2:444\n250#2:451\n1225#3,6:438\n1225#3,6:445\n*S KotlinDebug\n*F\n+ 1 OtherScreens.kt\ncom/example/OtherScreensKt\n*L\n247#1:438,6\n248#1:445,6\n*E\n"})
public final class OtherScreensKt$NotesScreen$lambda$48$lambda$47$lambda$46$lambda$45$$inlined$items$default$4 extends Lambda implements Function4 {
   // $FF: synthetic field
   final List $items;
   // $FF: synthetic field
   final NotesViewModel $viewModel$inlined;
   // $FF: synthetic field
   final MutableState $noteToDelete$delegate$inlined;
   // $FF: synthetic field
   final MutableState $editingNote$delegate$inlined;

   public OtherScreensKt$NotesScreen$lambda$48$lambda$47$lambda$46$lambda$45$$inlined$items$default$4(List $items, NotesViewModel var2, MutableState var3, MutableState var4) {
      super(4);
      this.$items = $items;
      this.$viewModel$inlined = var2;
      this.$noteToDelete$delegate$inlined = var3;
      this.$editingNote$delegate$inlined = var4;
   }

   @Composable
   public final void invoke(@NotNull LazyItemScope $this$items, int it, @Nullable Composer $composer, int $changed) {
      // $FF: Couldn't be decompiled
   }
}
