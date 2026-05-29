package com.example;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.Icons.Outlined;
import androidx.compose.material.icons.filled.DateRangeKt;
import androidx.compose.material.icons.filled.MeetingRoomKt;
import androidx.compose.material.icons.filled.NotificationsKt;
import androidx.compose.material.icons.filled.SyncKt;
import androidx.compose.material.icons.filled.WarningKt;
import androidx.compose.material.icons.outlined.CalendarMonthKt;
import androidx.compose.material.icons.outlined.ColorLensKt;
import androidx.compose.material.icons.outlined.MusicNoteKt;
import androidx.compose.material.icons.outlined.NotificationsOffKt;
import androidx.compose.material.icons.outlined.VolumeDownKt;
import androidx.compose.material.icons.outlined.VolumeMuteKt;
import androidx.compose.material.icons.outlined.VolumeOffKt;
import androidx.compose.material.icons.outlined.VolumeUpKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AssistChipDefaults;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.CheckboxDefaults;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipElevation;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.FloatingActionButtonElevation;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuItemColors;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SliderColors;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.Brush.Companion;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.PopupProperties;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.example.auth.AuthManager;
import com.example.calendar.CalendarSyncViewModel;
import com.example.data.local.entity.NoteEntity;
import com.example.data.local.entity.TaskEntity;
import com.example.data.network.CalendarEvent;
import com.example.notes.NotesViewModel;
import com.example.notification.NotificationHelper;
import com.example.settings.SettingsViewModel;
import com.example.ui.theme.ColorKt;
import com.example.ui.theme.ThemeKt;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u0007\u001as\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u001a-\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a1\u0010!\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00132\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010$\u001a9\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010)\u001ab\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00132\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\f2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0004\b1\u00102\u001aY\u00103\u001a\u00020\u00012\f\u00104\u001a\b\u0012\u0004\u0012\u000206052\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00010\t2.\u00108\u001a*\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u000106\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020\u000109H\u0007¢\u0006\u0002\u0010;\u001aa\u0010<\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\f\u00104\u001a\b\u0012\u0004\u0012\u000206052\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00010\t2.\u0010=\u001a*\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u000106\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020\u000109H\u0007¢\u0006\u0002\u0010>\u001a=\u0010?\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010@\u001a\u00020\u00152\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010B\u001a-\u0010C\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010E\u001a3\u0010F\u001a\u00020\u00012\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010H\u001a\u00020I2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010J¨\u0006K²\u0006\u0010\u0010L\u001a\b\u0012\u0004\u0012\u00020'05X\u008a\u0084\u0002²\u0006\u0010\u0010M\u001a\b\u0012\u0004\u0012\u00020N05X\u008a\u0084\u0002²\u0006\u0010\u0010O\u001a\b\u0012\u0004\u0012\u00020P05X\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020RX\u008a\u008e\u0002²\u0006\n\u0010S\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\f\u0010T\u001a\u0004\u0018\u00010'X\u008a\u008e\u0002²\u0006\f\u0010U\u001a\u0004\u0018\u00010'X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010V\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010W\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010X\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\f\u0010Y\u001a\u0004\u0018\u000106X\u008a\u008e\u0002²\u0006\f\u0010Z\u001a\u0004\u0018\u00010:X\u008a\u008e\u0002²\u0006\n\u0010[\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010V\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010W\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010X\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\f\u0010Y\u001a\u0004\u0018\u000106X\u008a\u008e\u0002²\u0006\f\u0010Z\u001a\u0004\u0018\u00010:X\u008a\u008e\u0002²\u0006\n\u0010[\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\u0010\u0010\\\u001a\b\u0012\u0004\u0012\u00020N05X\u008a\u0084\u0002²\u0006\u0010\u0010]\u001a\b\u0012\u0004\u0012\u00020'05X\u008a\u0084\u0002²\u0006\u0010\u0010^\u001a\b\u0012\u0004\u0012\u00020P05X\u008a\u0084\u0002²\u0006\n\u0010_\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\f\u0010`\u001a\u0004\u0018\u00010:X\u008a\u0084\u0002²\u0006\f\u0010a\u001a\u0004\u0018\u00010\u0015X\u008a\u0084\u0002²\u0006\n\u0010b\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010c\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\f\u0010`\u001a\u0004\u0018\u00010:X\u008a\u0084\u0002²\u0006\n\u0010d\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010e\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010f\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010g\u001a\u00020RX\u008a\u0084\u0002²\u0006\n\u0010h\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010i\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010j\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010k\u001a\u00020lX\u008a\u008e\u0002"},
   d2 = {"GlassCard", "", "modifier", "Landroidx/compose/ui/Modifier;", "border", "Landroidx/compose/foundation/BorderStroke;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "onClick", "Lkotlin/Function0;", "onDoubleClick", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "GlassCard-dgCr-O4", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/ui/graphics/Color;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "isMeetingEvent", "", "title", "", "description", "NotesScreen", "viewModel", "Lcom/example/notes/NotesViewModel;", "plannerViewModel", "Lcom/example/PlannerViewModel;", "syncViewModel", "Lcom/example/calendar/CalendarSyncViewModel;", "authManager", "Lcom/example/auth/AuthManager;", "(Lcom/example/notes/NotesViewModel;Lcom/example/PlannerViewModel;Lcom/example/calendar/CalendarSyncViewModel;Lcom/example/auth/AuthManager;Landroidx/compose/runtime/Composer;I)V", "NoteContentWithChecklist", "expanded", "onContentChange", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "NoteCard", "note", "Lcom/example/data/local/entity/NoteEntity;", "onDelete", "(Lcom/example/data/local/entity/NoteEntity;Lcom/example/notes/NotesViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NoteOptionRow", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "iconTint", "subtitle", "checked", "onCheckedChange", "NoteOptionRow-oC9nPe0", "(Landroidx/compose/ui/graphics/vector/ImageVector;JLjava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DetailedAddNoteDialog", "meetings", "", "Lcom/example/MeetingItem;", "onDismiss", "onAdd", "Lkotlin/Function5;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;I)V", "DetailedEditNoteDialog", "onSave", "(Lcom/example/data/local/entity/NoteEntity;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;I)V", "DeleteConfirmationDialog", "message", "onConfirm", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SyncScreen", "notesViewModel", "(Lcom/example/PlannerViewModel;Lcom/example/notes/NotesViewModel;Lcom/example/calendar/CalendarSyncViewModel;Lcom/example/auth/AuthManager;Landroidx/compose/runtime/Composer;I)V", "SettingsScreen", "onSignOut", "settingsViewModel", "Lcom/example/settings/SettingsViewModel;", "(Lkotlin/jvm/functions/Function0;Lcom/example/settings/SettingsViewModel;Lcom/example/calendar/CalendarSyncViewModel;Lcom/example/auth/AuthManager;Landroidx/compose/runtime/Composer;I)V", "app", "notes", "localTasks", "Lcom/example/data/local/entity/TaskEntity;", "googleEvents", "Lcom/example/data/network/CalendarEvent;", "selectedTab", "", "showAddNoteDialog", "noteToDelete", "editingNote", "linkToday", "attachMeeting", "hasReminder", "selectedMeeting", "reminderTime", "expandedDropdown", "tasks", "allNotes", "events", "isSyncing", "lastSyncTime", "error", "themeMode", "notificationsMuted", "googleCalendarRemindersEnabled", "notificationSoundEnabled", "notificationMelody", "notificationVolume", "calendarSyncEnabled", "planNotificationEnabled", "expandedMelody", "volumeState", ""}
)
@SourceDebugExtension({"SMAP\nOtherScreens.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OtherScreens.kt\ncom/example/OtherScreensKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Composer.kt\nandroidx/compose/runtime/Updater\n+ 8 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 9 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 10 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 11 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 12 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 13 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 14 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n+ 15 SnapshotFloatState.kt\nandroidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt\n*L\n1#1,1753:1\n149#2:1754\n149#2:1755\n149#2:1762\n149#2:1763\n149#2:1800\n149#2:1944\n149#2:2032\n149#2:2085\n149#2:2090\n149#2:2127\n149#2:2132\n149#2:2169\n149#2:2174\n149#2:2176\n149#2:2193\n149#2:2194\n149#2:2299\n149#2:2335\n149#2:2340\n149#2:2390\n149#2:2515\n149#2:2552\n149#2:2553\n149#2:2554\n149#2:2555\n149#2:2619\n149#2:2620\n149#2:2621\n149#2:2643\n149#2:2644\n149#2:2663\n149#2:2700\n149#2:2701\n149#2:2702\n149#2:2703\n149#2:2704\n149#2:2743\n149#2:2794\n149#2:2834\n149#2:2835\n149#2:2917\n149#2:2918\n149#2:2919\n149#2:2955\n149#2:2956\n149#2:3030\n149#2:3031\n149#2:3040\n149#2:3041\n149#2:3115\n149#2:3116\n149#2:3125\n149#2:3126\n149#2:3200\n149#2:3201\n149#2:3218\n149#2:3223\n149#2:3310\n149#2:3321\n149#2:3328\n149#2:3329\n149#2:3330\n149#2:3366\n149#2:3373\n149#2:3412\n149#2:3419\n149#2:3426\n149#2:3431\n149#2:3456\n149#2:3457\n149#2:3493\n149#2:3494\n149#2:3495\n149#2:3496\n149#2:3511\n149#2:3512\n149#2:3513\n149#2:3594\n149#2:3605\n149#2:3612\n149#2:3613\n149#2:3614\n149#2:3650\n149#2:3657\n149#2:3696\n149#2:3703\n149#2:3710\n149#2:3715\n149#2:3740\n149#2:3741\n149#2:3777\n149#2:3778\n149#2:3779\n149#2:3780\n149#2:3795\n149#2:3796\n149#2:3797\n149#2:3835\n149#2:3836\n149#2:3847\n149#2:3884\n149#2:3926\n149#2:3931\n149#2:3977\n149#2:3978\n149#2:4022\n149#2:4062\n149#2:4176\n149#2:4177\n149#2:4223\n149#2:4250\n149#2:4251\n149#2:4321\n149#2:4336\n149#2:4337\n149#2:4407\n149#2:4422\n149#2:4423\n149#2:4493\n149#2:4508\n149#2:4509\n149#2:4579\n149#2:4594\n149#2:4601\n149#2:4671\n149#2:4719\n149#2:4720\n149#2:4735\n149#2:4742\n149#2:4816\n149#2:4821\n149#2:4838\n149#2:4912\n149#2:4917\n149#2:4918\n149#2:4919\n149#2:4920\n149#2:4921\n149#2:4959\n149#2:5014\n149#2:5052\n149#2:5053\n149#2:5054\n149#2:5067\n149#2:5068\n1225#3,6:1756\n1225#3,6:1851\n1225#3,6:1857\n1225#3,6:1863\n1225#3,6:1869\n1225#3,3:1875\n1228#3,3:1893\n1225#3,3:1896\n1228#3,3:1905\n1225#3,6:1908\n1225#3,6:1914\n1225#3,6:1920\n1225#3,6:1926\n1225#3,6:1932\n1225#3,6:1938\n1225#3,6:1984\n1225#3,6:2026\n1225#3,6:2037\n1225#3,6:2079\n1225#3,6:2181\n1225#3,6:2187\n1225#3,6:2395\n1225#3,6:2401\n1225#3,6:2407\n1225#3,6:2413\n1225#3,6:2419\n1225#3,6:2425\n1225#3,6:2431\n1225#3,6:2438\n1225#3,6:2444\n1225#3,6:2450\n1225#3,6:2456\n1225#3,6:2462\n1225#3,6:2468\n1225#3,6:2474\n1225#3,6:2480\n1225#3,3:2487\n1228#3,3:2494\n1225#3,6:2497\n1225#3,6:2503\n1225#3,6:2509\n1225#3,6:2613\n1225#3,6:2622\n1225#3,6:2645\n1225#3,6:2744\n1225#3,6:2836\n1225#3,6:3224\n1225#3,6:3255\n1225#3,6:3262\n1225#3,6:3304\n1225#3,6:3311\n1225#3,6:3322\n1225#3,6:3367\n1225#3,6:3406\n1225#3,6:3413\n1225#3,6:3420\n1225#3,6:3432\n1225#3,6:3438\n1225#3,6:3444\n1225#3,6:3450\n1225#3,6:3497\n1225#3,6:3539\n1225#3,6:3546\n1225#3,6:3588\n1225#3,6:3595\n1225#3,6:3606\n1225#3,6:3651\n1225#3,6:3690\n1225#3,6:3697\n1225#3,6:3704\n1225#3,6:3716\n1225#3,6:3722\n1225#3,6:3728\n1225#3,6:3734\n1225#3,6:3781\n1225#3,6:3920\n1225#3,6:4224\n1225#3,6:4240\n1225#3,6:4326\n1225#3,6:4412\n1225#3,6:4498\n1225#3,6:4584\n1225#3,6:4595\n1225#3,6:4713\n1225#3,6:4721\n1225#3,6:4736\n1225#3,6:4822\n1225#3,6:4828\n1225#3,6:4960\n1225#3,6:5055\n1225#3,6:5061\n71#4:1764\n68#4,6:1765\n74#4:1799\n78#4:1844\n71#4:2300\n69#4,5:2301\n74#4:2334\n78#4:2339\n71#4:2750\n69#4,5:2751\n74#4:2784\n78#4:2788\n71#4:2795\n69#4,5:2796\n74#4:2829\n78#4:2833\n71#4:2957\n68#4,6:2958\n74#4:2992\n78#4:3039\n71#4:3042\n68#4,6:3043\n74#4:3077\n78#4:3124\n71#4:3127\n68#4,6:3128\n74#4:3162\n78#4:3209\n71#4:3268\n68#4,6:3269\n74#4:3303\n78#4:3320\n71#4:3552\n68#4,6:3553\n74#4:3587\n78#4:3604\n71#4:3885\n69#4,5:3886\n74#4:3919\n78#4:3930\n71#4:4023\n69#4,5:4024\n74#4:4057\n78#4:4061\n71#4:4676\n67#4,7:4677\n74#4:4712\n78#4:4730\n71#4:4966\n69#4,5:4967\n74#4:5000\n78#4:5004\n79#5,6:1771\n86#5,4:1786\n90#5,2:1796\n79#5,6:1808\n86#5,4:1823\n90#5,2:1833\n94#5:1839\n94#5:1843\n79#5,6:1953\n86#5,4:1968\n90#5,2:1978\n79#5,6:1997\n86#5,4:2012\n90#5,2:2022\n94#5:2035\n79#5,6:2050\n86#5,4:2065\n90#5,2:2075\n94#5:2088\n79#5,6:2098\n86#5,4:2113\n90#5,2:2123\n94#5:2130\n79#5,6:2140\n86#5,4:2155\n90#5,2:2165\n94#5:2172\n94#5:2179\n79#5,6:2202\n86#5,4:2217\n90#5,2:2227\n79#5,6:2234\n86#5,4:2249\n90#5,2:2259\n79#5,6:2270\n86#5,4:2285\n90#5,2:2295\n79#5,6:2306\n86#5,4:2321\n90#5,2:2331\n94#5:2338\n79#5,6:2349\n86#5,4:2364\n90#5,2:2374\n94#5:2380\n94#5:2384\n94#5:2388\n94#5:2393\n79#5,6:2523\n86#5,4:2538\n90#5,2:2548\n79#5,6:2562\n86#5,4:2577\n90#5,2:2587\n94#5:2593\n94#5:2597\n79#5,6:2671\n86#5,4:2686\n90#5,2:2696\n79#5,6:2712\n86#5,4:2727\n90#5,2:2737\n79#5,6:2756\n86#5,4:2771\n90#5,2:2781\n94#5:2787\n94#5:2792\n79#5,6:2801\n86#5,4:2816\n90#5,2:2826\n94#5:2832\n94#5:2844\n79#5,6:2852\n86#5,4:2867\n90#5,2:2877\n79#5,6:2888\n86#5,4:2903\n90#5,2:2913\n79#5,6:2926\n86#5,4:2941\n90#5,2:2951\n79#5,6:2964\n86#5,4:2979\n90#5,2:2989\n79#5,6:3001\n86#5,4:3016\n90#5,2:3026\n94#5:3034\n94#5:3038\n79#5,6:3049\n86#5,4:3064\n90#5,2:3074\n79#5,6:3086\n86#5,4:3101\n90#5,2:3111\n94#5:3119\n94#5:3123\n79#5,6:3134\n86#5,4:3149\n90#5,2:3159\n79#5,6:3171\n86#5,4:3186\n90#5,2:3196\n94#5:3204\n94#5:3208\n94#5:3212\n94#5:3216\n94#5:3221\n79#5,6:3275\n86#5,4:3290\n90#5,2:3300\n94#5:3319\n79#5,6:3337\n86#5,4:3352\n90#5,2:3362\n79#5,6:3377\n86#5,4:3392\n90#5,2:3402\n94#5:3429\n79#5,6:3464\n86#5,4:3479\n90#5,2:3489\n94#5:3505\n94#5:3509\n79#5,6:3559\n86#5,4:3574\n90#5,2:3584\n94#5:3603\n79#5,6:3621\n86#5,4:3636\n90#5,2:3646\n79#5,6:3661\n86#5,4:3676\n90#5,2:3686\n94#5:3713\n79#5,6:3748\n86#5,4:3763\n90#5,2:3773\n94#5:3789\n94#5:3793\n79#5,6:3806\n86#5,4:3821\n90#5,2:3831\n94#5:3839\n79#5,6:3855\n86#5,4:3870\n90#5,2:3880\n79#5,6:3891\n86#5,4:3906\n90#5,2:3916\n94#5:3929\n79#5,6:3940\n86#5,4:3955\n90#5,2:3965\n94#5:3971\n94#5:3975\n79#5,6:3993\n86#5,4:4008\n90#5,2:4018\n79#5,6:4029\n86#5,4:4044\n90#5,2:4054\n94#5:4060\n79#5,6:4070\n86#5,4:4085\n90#5,2:4095\n94#5:4101\n94#5:4105\n79#5,6:4110\n86#5,4:4125\n90#5,2:4135\n79#5,6:4147\n86#5,4:4162\n90#5,2:4172\n79#5,6:4186\n86#5,4:4201\n90#5,2:4211\n94#5:4217\n94#5:4221\n94#5:4232\n79#5,6:4255\n86#5,4:4270\n90#5,2:4280\n79#5,6:4292\n86#5,4:4307\n90#5,2:4317\n94#5:4324\n94#5:4334\n79#5,6:4341\n86#5,4:4356\n90#5,2:4366\n79#5,6:4378\n86#5,4:4393\n90#5,2:4403\n94#5:4410\n94#5:4420\n79#5,6:4427\n86#5,4:4442\n90#5,2:4452\n79#5,6:4464\n86#5,4:4479\n90#5,2:4489\n94#5:4496\n94#5:4506\n79#5,6:4513\n86#5,4:4528\n90#5,2:4538\n79#5,6:4550\n86#5,4:4565\n90#5,2:4575\n94#5:4582\n94#5:4592\n79#5,6:4605\n86#5,4:4620\n90#5,2:4630\n79#5,6:4642\n86#5,4:4657\n90#5,2:4667\n94#5:4674\n79#5,6:4684\n86#5,4:4699\n90#5,2:4709\n94#5:4729\n94#5:4733\n79#5,6:4750\n86#5,4:4765\n90#5,2:4775\n79#5,6:4787\n86#5,4:4802\n90#5,2:4812\n94#5:4819\n94#5:4836\n79#5,6:4846\n86#5,4:4861\n90#5,2:4871\n79#5,6:4883\n86#5,4:4898\n90#5,2:4908\n94#5:4915\n79#5,6:4929\n86#5,4:4944\n90#5,2:4954\n79#5,6:4972\n86#5,4:4987\n90#5,2:4997\n94#5:5003\n94#5:5008\n94#5:5012\n79#5,6:5023\n86#5,4:5038\n90#5,2:5048\n94#5:5071\n368#6,9:1777\n377#6:1798\n368#6,9:1814\n377#6:1835\n378#6,2:1837\n378#6,2:1841\n368#6,9:1959\n377#6:1980\n368#6,9:2003\n377#6:2024\n378#6,2:2033\n368#6,9:2056\n377#6:2077\n378#6,2:2086\n368#6,9:2104\n377#6:2125\n378#6,2:2128\n368#6,9:2146\n377#6:2167\n378#6,2:2170\n378#6,2:2177\n368#6,9:2208\n377#6:2229\n368#6,9:2240\n377#6:2261\n368#6,9:2276\n377#6:2297\n368#6,9:2312\n377#6:2333\n378#6,2:2336\n368#6,9:2355\n377#6:2376\n378#6,2:2378\n378#6,2:2382\n378#6,2:2386\n378#6,2:2391\n368#6,9:2529\n377#6:2550\n368#6,9:2568\n377#6:2589\n378#6,2:2591\n378#6,2:2595\n368#6,9:2677\n377#6:2698\n368#6,9:2718\n377#6:2739\n368#6,9:2762\n377#6:2783\n378#6,2:2785\n378#6,2:2790\n368#6,9:2807\n377#6:2828\n378#6,2:2830\n378#6,2:2842\n368#6,9:2858\n377#6:2879\n368#6,9:2894\n377#6:2915\n368#6,9:2932\n377#6:2953\n368#6,9:2970\n377#6:2991\n368#6,9:3007\n377#6:3028\n378#6,2:3032\n378#6,2:3036\n368#6,9:3055\n377#6:3076\n368#6,9:3092\n377#6:3113\n378#6,2:3117\n378#6,2:3121\n368#6,9:3140\n377#6:3161\n368#6,9:3177\n377#6:3198\n378#6,2:3202\n378#6,2:3206\n378#6,2:3210\n378#6,2:3214\n378#6,2:3219\n368#6,9:3281\n377#6:3302\n378#6,2:3317\n368#6,9:3343\n377#6:3364\n368#6,9:3383\n377#6:3404\n378#6,2:3427\n368#6,9:3470\n377#6:3491\n378#6,2:3503\n378#6,2:3507\n368#6,9:3565\n377#6:3586\n378#6,2:3601\n368#6,9:3627\n377#6:3648\n368#6,9:3667\n377#6:3688\n378#6,2:3711\n368#6,9:3754\n377#6:3775\n378#6,2:3787\n378#6,2:3791\n368#6,9:3812\n377#6:3833\n378#6,2:3837\n368#6,9:3861\n377#6:3882\n368#6,9:3897\n377#6:3918\n378#6,2:3927\n368#6,9:3946\n377#6:3967\n378#6,2:3969\n378#6,2:3973\n368#6,9:3999\n377#6:4020\n368#6,9:4035\n377#6:4056\n378#6,2:4058\n368#6,9:4076\n377#6:4097\n378#6,2:4099\n378#6,2:4103\n368#6,9:4116\n377#6:4137\n368#6,9:4153\n377#6:4174\n368#6,9:4192\n377#6:4213\n378#6,2:4215\n378#6,2:4219\n378#6,2:4230\n368#6,9:4261\n377#6:4282\n368#6,9:4298\n377#6:4319\n378#6,2:4322\n378#6,2:4332\n368#6,9:4347\n377#6:4368\n368#6,9:4384\n377#6:4405\n378#6,2:4408\n378#6,2:4418\n368#6,9:4433\n377#6:4454\n368#6,9:4470\n377#6:4491\n378#6,2:4494\n378#6,2:4504\n368#6,9:4519\n377#6:4540\n368#6,9:4556\n377#6:4577\n378#6,2:4580\n378#6,2:4590\n368#6,9:4611\n377#6:4632\n368#6,9:4648\n377#6:4669\n378#6,2:4672\n368#6,9:4690\n377#6:4711\n378#6,2:4727\n378#6,2:4731\n368#6,9:4756\n377#6:4777\n368#6,9:4793\n377#6:4814\n378#6,2:4817\n378#6,2:4834\n368#6,9:4852\n377#6:4873\n368#6,9:4889\n377#6:4910\n378#6,2:4913\n368#6,9:4935\n377#6:4956\n368#6,9:4978\n377#6:4999\n378#6,2:5001\n378#6,2:5006\n378#6,2:5010\n368#6,9:5029\n377#6:5050\n378#6,2:5069\n4034#7,6:1790\n4034#7,6:1827\n4034#7,6:1972\n4034#7,6:2016\n4034#7,6:2069\n4034#7,6:2117\n4034#7,6:2159\n4034#7,6:2221\n4034#7,6:2253\n4034#7,6:2289\n4034#7,6:2325\n4034#7,6:2368\n4034#7,6:2542\n4034#7,6:2581\n4034#7,6:2690\n4034#7,6:2731\n4034#7,6:2775\n4034#7,6:2820\n4034#7,6:2871\n4034#7,6:2907\n4034#7,6:2945\n4034#7,6:2983\n4034#7,6:3020\n4034#7,6:3068\n4034#7,6:3105\n4034#7,6:3153\n4034#7,6:3190\n4034#7,6:3294\n4034#7,6:3356\n4034#7,6:3396\n4034#7,6:3483\n4034#7,6:3578\n4034#7,6:3640\n4034#7,6:3680\n4034#7,6:3767\n4034#7,6:3825\n4034#7,6:3874\n4034#7,6:3910\n4034#7,6:3959\n4034#7,6:4012\n4034#7,6:4048\n4034#7,6:4089\n4034#7,6:4129\n4034#7,6:4166\n4034#7,6:4205\n4034#7,6:4274\n4034#7,6:4311\n4034#7,6:4360\n4034#7,6:4397\n4034#7,6:4446\n4034#7,6:4483\n4034#7,6:4532\n4034#7,6:4569\n4034#7,6:4624\n4034#7,6:4661\n4034#7,6:4703\n4034#7,6:4769\n4034#7,6:4806\n4034#7,6:4865\n4034#7,6:4902\n4034#7,6:4948\n4034#7,6:4991\n4034#7,6:5042\n86#8:1801\n83#8,6:1802\n89#8:1836\n93#8:1840\n86#8:1945\n82#8,7:1946\n89#8:1981\n93#8:2180\n86#8:2195\n83#8,6:2196\n89#8:2230\n86#8:2341\n82#8,7:2342\n89#8:2377\n93#8:2381\n93#8:2394\n86#8:2516\n83#8,6:2517\n89#8:2551\n93#8:2598\n86#8:2664\n83#8,6:2665\n89#8:2699\n93#8:2845\n86#8:2881\n83#8,6:2882\n89#8:2916\n93#8:3217\n86#8:3331\n84#8,5:3332\n89#8:3365\n93#8:3510\n86#8:3615\n84#8,5:3616\n89#8:3649\n93#8:3794\n86#8:3932\n82#8,7:3933\n89#8:3968\n93#8:3972\n86#8:4063\n83#8,6:4064\n89#8:4098\n93#8:4102\n86#8:4178\n82#8,7:4179\n89#8:4214\n93#8:4218\n86#8:4743\n83#8,6:4744\n89#8:4778\n93#8:4837\n86#8:4839\n83#8,6:4840\n89#8:4874\n93#8:5013\n86#8:5015\n82#8,7:5016\n89#8:5051\n93#8:5072\n1761#9,3:1845\n1761#9,3:1848\n774#9:1878\n865#9,2:1879\n1563#9:1881\n1634#9,3:1882\n774#9:1885\n865#9,2:1886\n1563#9:1888\n1634#9,2:1889\n1636#9:1892\n774#9:1899\n865#9,2:1900\n774#9:1902\n865#9,2:1903\n1878#9,2:1982\n1880#9:2175\n1788#9,4:2490\n1617#9,9:2600\n1869#9:2609\n1870#9:2611\n1626#9:2612\n1878#9,2:2741\n1880#9:2789\n1869#9:3254\n1870#9:3261\n1869#9:3538\n1870#9:3545\n1869#9:4239\n1870#9:4246\n1869#9:4958\n1870#9:5005\n1#10:1891\n1#10:2610\n99#11:1990\n96#11,6:1991\n102#11:2025\n106#11:2036\n99#11:2043\n96#11,6:2044\n102#11:2078\n106#11:2089\n99#11:2091\n96#11,6:2092\n102#11:2126\n106#11:2131\n99#11:2133\n96#11,6:2134\n102#11:2168\n106#11:2173\n99#11,3:2231\n102#11:2262\n99#11:2263\n96#11,6:2264\n102#11:2298\n106#11:2385\n106#11:2389\n99#11:2556\n97#11,5:2557\n102#11:2590\n106#11:2594\n99#11:2705\n96#11,6:2706\n102#11:2740\n106#11:2793\n99#11,3:2849\n102#11:2880\n99#11:2920\n97#11,5:2921\n102#11:2954\n99#11:2993\n95#11,7:2994\n102#11:3029\n106#11:3035\n99#11:3078\n95#11,7:3079\n102#11:3114\n106#11:3120\n99#11:3163\n95#11,7:3164\n102#11:3199\n106#11:3205\n106#11:3213\n106#11:3222\n99#11,3:3374\n102#11:3405\n106#11:3430\n99#11:3458\n97#11,5:3459\n102#11:3492\n106#11:3506\n99#11,3:3658\n102#11:3689\n106#11:3714\n99#11:3742\n97#11,5:3743\n102#11:3776\n106#11:3790\n99#11:3798\n95#11,7:3799\n102#11:3834\n106#11:3840\n99#11:3848\n96#11,6:3849\n102#11:3883\n106#11:3976\n99#11:3986\n96#11,6:3987\n102#11:4021\n106#11:4106\n99#11,3:4107\n102#11:4138\n99#11:4139\n95#11,7:4140\n102#11:4175\n106#11:4222\n106#11:4233\n99#11,3:4252\n102#11:4283\n99#11:4284\n95#11,7:4285\n102#11:4320\n106#11:4325\n106#11:4335\n99#11,3:4338\n102#11:4369\n99#11:4370\n95#11,7:4371\n102#11:4406\n106#11:4411\n106#11:4421\n99#11,3:4424\n102#11:4455\n99#11:4456\n95#11,7:4457\n102#11:4492\n106#11:4497\n106#11:4507\n99#11,3:4510\n102#11:4541\n99#11:4542\n95#11,7:4543\n102#11:4578\n106#11:4583\n106#11:4593\n99#11,3:4602\n102#11:4633\n99#11:4634\n95#11,7:4635\n102#11:4670\n106#11:4675\n106#11:4734\n99#11:4779\n95#11,7:4780\n102#11:4815\n106#11:4820\n99#11:4875\n95#11,7:4876\n102#11:4911\n106#11:4916\n99#11:4922\n96#11,6:4923\n102#11:4957\n106#11:5009\n77#12:2437\n77#12:2486\n77#12:2599\n81#13:2628\n81#13:2629\n81#13:2630\n81#13:2631\n107#13,2:2632\n81#13:2634\n107#13,2:2635\n81#13:2637\n107#13,2:2638\n81#13:2640\n107#13,2:2641\n81#13:2846\n107#13,2:2847\n81#13:3230\n107#13,2:3231\n81#13:3233\n107#13,2:3234\n81#13:3236\n107#13,2:3237\n81#13:3239\n107#13,2:3240\n81#13:3242\n107#13,2:3243\n81#13:3245\n107#13,2:3246\n81#13:3248\n107#13,2:3249\n81#13:3251\n107#13,2:3252\n81#13:3514\n107#13,2:3515\n81#13:3517\n107#13,2:3518\n81#13:3520\n107#13,2:3521\n81#13:3523\n107#13,2:3524\n81#13:3526\n107#13,2:3527\n81#13:3529\n107#13,2:3530\n81#13:3532\n107#13,2:3533\n81#13:3535\n107#13,2:3536\n81#13:3841\n81#13:3842\n81#13:3843\n81#13:3844\n81#13:3845\n81#13:3846\n81#13:3979\n81#13:3980\n81#13:3981\n81#13:3982\n81#13:3983\n81#13:3984\n81#13:3985\n81#13:4234\n81#13:4235\n81#13:4236\n107#13,2:4237\n143#14,12:2651\n79#15:4247\n112#15,2:4248\n*S KotlinDebug\n*F\n+ 1 OtherScreens.kt\ncom/example/OtherScreensKt\n*L\n63#1:1754\n67#1:1755\n75#1:1762\n80#1:1763\n83#1:1800\n309#1:1944\n330#1:2032\n356#1:2085\n370#1:2090\n373#1:2127\n387#1:2132\n390#1:2169\n405#1:2174\n417#1:2176\n531#1:2193\n533#1:2194\n546#1:2299\n551#1:2335\n553#1:2340\n578#1:2390\n1191#1:2515\n1200#1:2552\n1207#1:2553\n1259#1:2554\n1264#1:2555\n1328#1:2619\n1329#1:2620\n1330#1:2621\n176#1:2643\n177#1:2644\n187#1:2663\n196#1:2700\n202#1:2701\n203#1:2702\n205#1:2703\n206#1:2704\n213#1:2743\n228#1:2794\n239#1:2834\n240#1:2835\n445#1:2917\n448#1:2918\n449#1:2919\n454#1:2955\n455#1:2956\n458#1:3030\n459#1:3031\n467#1:3040\n468#1:3041\n471#1:3115\n472#1:3116\n482#1:3125\n483#1:3126\n486#1:3200\n487#1:3201\n497#1:3218\n504#1:3223\n740#1:3310\n764#1:3321\n805#1:3328\n615#1:3329\n617#1:3330\n636#1:3366\n642#1:3373\n662#1:3412\n675#1:3419\n698#1:3426\n713#1:3431\n812#1:3456\n816#1:3457\n822#1:3493\n823#1:3494\n834#1:3495\n835#1:3496\n606#1:3511\n607#1:3512\n611#1:3513\n1015#1:3594\n1039#1:3605\n1080#1:3612\n890#1:3613\n892#1:3614\n911#1:3650\n917#1:3657\n937#1:3696\n950#1:3703\n973#1:3710\n988#1:3715\n1087#1:3740\n1091#1:3741\n1097#1:3777\n1098#1:3778\n1109#1:3779\n1110#1:3780\n881#1:3795\n882#1:3796\n886#1:3797\n1138#1:3835\n1140#1:3836\n1217#1:3847\n1224#1:3884\n1230#1:3926\n1240#1:3931\n1274#1:3977\n1290#1:3978\n1351#1:4022\n1363#1:4062\n1394#1:4176\n1396#1:4177\n1418#1:4223\n1434#1:4250\n1443#1:4251\n1453#1:4321\n1468#1:4336\n1475#1:4337\n1485#1:4407\n1500#1:4422\n1508#1:4423\n1518#1:4493\n1533#1:4508\n1540#1:4509\n1550#1:4579\n1565#1:4594\n1574#1:4601\n1584#1:4671\n1594#1:4719\n1595#1:4720\n1619#1:4735\n1627#1:4742\n1640#1:4816\n1647#1:4821\n1665#1:4838\n1677#1:4912\n1684#1:4917\n1690#1:4918\n1691#1:4919\n1693#1:4920\n1694#1:4921\n1702#1:4959\n1722#1:5014\n1727#1:5052\n1728#1:5053\n1729#1:5054\n1741#1:5067\n1742#1:5068\n69#1:1756,6\n120#1:1851,6\n121#1:1857,6\n122#1:1863,6\n123#1:1869,6\n139#1:1875,3\n139#1:1893,3\n161#1:1896,3\n161#1:1905,3\n260#1:1908,6\n261#1:1914,6\n271#1:1920,6\n272#1:1926,6\n284#1:1932,6\n285#1:1938,6\n315#1:1984,6\n323#1:2026,6\n341#1:2037,6\n349#1:2079,6\n425#1:2181,6\n429#1:2187,6\n590#1:2395,6\n591#1:2401,6\n592#1:2407,6\n593#1:2413,6\n594#1:2419,6\n596#1:2425,6\n597#1:2431,6\n855#1:2438,6\n856#1:2444,6\n857#1:2450,6\n858#1:2456,6\n859#1:2462,6\n861#1:2468,6\n866#1:2474,6\n868#1:2480,6\n1180#1:2487,3\n1180#1:2494,3\n1181#1:2497,6\n1182#1:2503,6\n1186#1:2509,6\n1323#1:2613,6\n1331#1:2622,6\n173#1:2645,6\n215#1:2744,6\n242#1:2836,6\n508#1:3224,6\n751#1:3255,6\n735#1:3262,6\n738#1:3304,6\n746#1:3311,6\n781#1:3322,6\n628#1:3367,6\n652#1:3406,6\n665#1:3413,6\n678#1:3420,6\n704#1:3432,6\n723#1:3438,6\n732#1:3444,6\n776#1:3450,6\n828#1:3497,6\n1026#1:3539,6\n1010#1:3546,6\n1013#1:3588,6\n1021#1:3595,6\n1056#1:3606,6\n903#1:3651,6\n927#1:3690,6\n940#1:3697,6\n953#1:3704,6\n979#1:3716,6\n998#1:3722,6\n1007#1:3728,6\n1051#1:3734,6\n1103#1:3781,6\n1227#1:3920,6\n1416#1:4224,6\n1606#1:4240,6\n1462#1:4326,6\n1494#1:4412,6\n1527#1:4498,6\n1559#1:4584,6\n1570#1:4595,6\n1593#1:4713,6\n1601#1:4721,6\n1623#1:4736,6\n1650#1:4822,6\n1651#1:4828,6\n1704#1:4960,6\n1724#1:5055,6\n1738#1:5061,6\n79#1:1764\n79#1:1765,6\n79#1:1799\n79#1:1844\n544#1:2300\n544#1:2301,5\n544#1:2334\n544#1:2339\n209#1:2750\n209#1:2751,5\n209#1:2784\n209#1:2788\n231#1:2795\n231#1:2796,5\n231#1:2829\n231#1:2833\n452#1:2957\n452#1:2958,6\n452#1:2992\n452#1:3039\n465#1:3042\n465#1:3043,6\n465#1:3077\n465#1:3124\n480#1:3127\n480#1:3128,6\n480#1:3162\n480#1:3209\n736#1:3268\n736#1:3269,6\n736#1:3303\n736#1:3320\n1011#1:3552\n1011#1:3553,6\n1011#1:3587\n1011#1:3604\n1222#1:3885\n1222#1:3886,5\n1222#1:3919\n1222#1:3930\n1349#1:4023\n1349#1:4024,5\n1349#1:4057\n1349#1:4061\n1591#1:4676\n1591#1:4677,7\n1591#1:4712\n1591#1:4730\n1698#1:4966\n1698#1:4967,5\n1698#1:5000\n1698#1:5004\n79#1:1771,6\n79#1:1786,4\n79#1:1796,2\n82#1:1808,6\n82#1:1823,4\n82#1:1833,2\n82#1:1839\n79#1:1843\n309#1:1953,6\n309#1:1968,4\n309#1:1978,2\n313#1:1997,6\n313#1:2012,4\n313#1:2022,2\n313#1:2035\n339#1:2050,6\n339#1:2065,4\n339#1:2075,2\n339#1:2088\n368#1:2098,6\n368#1:2113,4\n368#1:2123,2\n368#1:2130\n385#1:2140,6\n385#1:2155,4\n385#1:2165,2\n385#1:2172\n309#1:2179\n526#1:2202,6\n526#1:2217,4\n526#1:2227,2\n535#1:2234,6\n535#1:2249,4\n535#1:2259,2\n540#1:2270,6\n540#1:2285,4\n540#1:2295,2\n544#1:2306,6\n544#1:2321,4\n544#1:2331,2\n544#1:2338\n554#1:2349,6\n554#1:2364,4\n554#1:2374,2\n554#1:2380\n540#1:2384\n535#1:2388\n526#1:2393\n1188#1:2523,6\n1188#1:2538,4\n1188#1:2548,2\n1262#1:2562,6\n1262#1:2577,4\n1262#1:2587,2\n1262#1:2593\n1188#1:2597\n183#1:2671,6\n183#1:2686,4\n183#1:2696,2\n199#1:2712,6\n199#1:2727,4\n199#1:2737,2\n209#1:2756,6\n209#1:2771,4\n209#1:2781,2\n209#1:2787\n199#1:2792\n231#1:2801,6\n231#1:2816,4\n231#1:2826,2\n231#1:2832\n183#1:2844\n433#1:2852,6\n433#1:2867,4\n433#1:2877,2\n438#1:2888,6\n438#1:2903,4\n438#1:2913,2\n447#1:2926,6\n447#1:2941,4\n447#1:2951,2\n452#1:2964,6\n452#1:2979,4\n452#1:2989,2\n457#1:3001,6\n457#1:3016,4\n457#1:3026,2\n457#1:3034\n452#1:3038\n465#1:3049,6\n465#1:3064,4\n465#1:3074,2\n470#1:3086,6\n470#1:3101,4\n470#1:3111,2\n470#1:3119\n465#1:3123\n480#1:3134,6\n480#1:3149,4\n480#1:3159,2\n485#1:3171,6\n485#1:3186,4\n485#1:3196,2\n485#1:3204\n480#1:3208\n447#1:3212\n438#1:3216\n433#1:3221\n736#1:3275,6\n736#1:3290,4\n736#1:3300,2\n736#1:3319\n613#1:3337,6\n613#1:3352,4\n613#1:3362,2\n640#1:3377,6\n640#1:3392,4\n640#1:3402,2\n640#1:3429\n814#1:3464,6\n814#1:3479,4\n814#1:3489,2\n814#1:3505\n613#1:3509\n1011#1:3559,6\n1011#1:3574,4\n1011#1:3584,2\n1011#1:3603\n888#1:3621,6\n888#1:3636,4\n888#1:3646,2\n915#1:3661,6\n915#1:3676,4\n915#1:3686,2\n915#1:3713\n1089#1:3748,6\n1089#1:3763,4\n1089#1:3773,2\n1089#1:3789\n888#1:3793\n1133#1:3806,6\n1133#1:3821,4\n1133#1:3831,2\n1133#1:3839\n1218#1:3855,6\n1218#1:3870,4\n1218#1:3880,2\n1222#1:3891,6\n1222#1:3906,4\n1222#1:3916,2\n1222#1:3929\n1241#1:3940,6\n1241#1:3955,4\n1241#1:3965,2\n1241#1:3971\n1218#1:3975\n1345#1:3993,6\n1345#1:4008,4\n1345#1:4018,2\n1349#1:4029,6\n1349#1:4044,4\n1349#1:4054,2\n1349#1:4060\n1364#1:4070,6\n1364#1:4085,4\n1364#1:4095,2\n1364#1:4101\n1345#1:4105\n1384#1:4110,6\n1384#1:4125,4\n1384#1:4135,2\n1389#1:4147,6\n1389#1:4162,4\n1389#1:4172,2\n1397#1:4186,6\n1397#1:4201,4\n1397#1:4211,2\n1397#1:4217\n1389#1:4221\n1384#1:4232\n1440#1:4255,6\n1440#1:4270,4\n1440#1:4280,2\n1447#1:4292,6\n1447#1:4307,4\n1447#1:4317,2\n1447#1:4324\n1440#1:4334\n1472#1:4341,6\n1472#1:4356,4\n1472#1:4366,2\n1479#1:4378,6\n1479#1:4393,4\n1479#1:4403,2\n1479#1:4410\n1472#1:4420\n1505#1:4427,6\n1505#1:4442,4\n1505#1:4452,2\n1512#1:4464,6\n1512#1:4479,4\n1512#1:4489,2\n1512#1:4496\n1505#1:4506\n1537#1:4513,6\n1537#1:4528,4\n1537#1:4538,2\n1544#1:4550,6\n1544#1:4565,4\n1544#1:4575,2\n1544#1:4582\n1537#1:4592\n1571#1:4605,6\n1571#1:4620,4\n1571#1:4630,2\n1578#1:4642,6\n1578#1:4657,4\n1578#1:4667,2\n1578#1:4674\n1591#1:4684,6\n1591#1:4699,4\n1591#1:4709,2\n1591#1:4729\n1571#1:4733\n1624#1:4750,6\n1624#1:4765,4\n1624#1:4775,2\n1629#1:4787,6\n1629#1:4802,4\n1629#1:4812,2\n1629#1:4819\n1624#1:4836\n1670#1:4846,6\n1670#1:4861,4\n1670#1:4871,2\n1671#1:4883,6\n1671#1:4898,4\n1671#1:4908,2\n1671#1:4915\n1687#1:4929,6\n1687#1:4944,4\n1687#1:4954,2\n1698#1:4972,6\n1698#1:4987,4\n1698#1:4997,2\n1698#1:5003\n1687#1:5008\n1670#1:5012\n1722#1:5023,6\n1722#1:5038,4\n1722#1:5048,2\n1722#1:5071\n79#1:1777,9\n79#1:1798\n82#1:1814,9\n82#1:1835\n82#1:1837,2\n79#1:1841,2\n309#1:1959,9\n309#1:1980\n313#1:2003,9\n313#1:2024\n313#1:2033,2\n339#1:2056,9\n339#1:2077\n339#1:2086,2\n368#1:2104,9\n368#1:2125\n368#1:2128,2\n385#1:2146,9\n385#1:2167\n385#1:2170,2\n309#1:2177,2\n526#1:2208,9\n526#1:2229\n535#1:2240,9\n535#1:2261\n540#1:2276,9\n540#1:2297\n544#1:2312,9\n544#1:2333\n544#1:2336,2\n554#1:2355,9\n554#1:2376\n554#1:2378,2\n540#1:2382,2\n535#1:2386,2\n526#1:2391,2\n1188#1:2529,9\n1188#1:2550\n1262#1:2568,9\n1262#1:2589\n1262#1:2591,2\n1188#1:2595,2\n183#1:2677,9\n183#1:2698\n199#1:2718,9\n199#1:2739\n209#1:2762,9\n209#1:2783\n209#1:2785,2\n199#1:2790,2\n231#1:2807,9\n231#1:2828\n231#1:2830,2\n183#1:2842,2\n433#1:2858,9\n433#1:2879\n438#1:2894,9\n438#1:2915\n447#1:2932,9\n447#1:2953\n452#1:2970,9\n452#1:2991\n457#1:3007,9\n457#1:3028\n457#1:3032,2\n452#1:3036,2\n465#1:3055,9\n465#1:3076\n470#1:3092,9\n470#1:3113\n470#1:3117,2\n465#1:3121,2\n480#1:3140,9\n480#1:3161\n485#1:3177,9\n485#1:3198\n485#1:3202,2\n480#1:3206,2\n447#1:3210,2\n438#1:3214,2\n433#1:3219,2\n736#1:3281,9\n736#1:3302\n736#1:3317,2\n613#1:3343,9\n613#1:3364\n640#1:3383,9\n640#1:3404\n640#1:3427,2\n814#1:3470,9\n814#1:3491\n814#1:3503,2\n613#1:3507,2\n1011#1:3565,9\n1011#1:3586\n1011#1:3601,2\n888#1:3627,9\n888#1:3648\n915#1:3667,9\n915#1:3688\n915#1:3711,2\n1089#1:3754,9\n1089#1:3775\n1089#1:3787,2\n888#1:3791,2\n1133#1:3812,9\n1133#1:3833\n1133#1:3837,2\n1218#1:3861,9\n1218#1:3882\n1222#1:3897,9\n1222#1:3918\n1222#1:3927,2\n1241#1:3946,9\n1241#1:3967\n1241#1:3969,2\n1218#1:3973,2\n1345#1:3999,9\n1345#1:4020\n1349#1:4035,9\n1349#1:4056\n1349#1:4058,2\n1364#1:4076,9\n1364#1:4097\n1364#1:4099,2\n1345#1:4103,2\n1384#1:4116,9\n1384#1:4137\n1389#1:4153,9\n1389#1:4174\n1397#1:4192,9\n1397#1:4213\n1397#1:4215,2\n1389#1:4219,2\n1384#1:4230,2\n1440#1:4261,9\n1440#1:4282\n1447#1:4298,9\n1447#1:4319\n1447#1:4322,2\n1440#1:4332,2\n1472#1:4347,9\n1472#1:4368\n1479#1:4384,9\n1479#1:4405\n1479#1:4408,2\n1472#1:4418,2\n1505#1:4433,9\n1505#1:4454\n1512#1:4470,9\n1512#1:4491\n1512#1:4494,2\n1505#1:4504,2\n1537#1:4519,9\n1537#1:4540\n1544#1:4556,9\n1544#1:4577\n1544#1:4580,2\n1537#1:4590,2\n1571#1:4611,9\n1571#1:4632\n1578#1:4648,9\n1578#1:4669\n1578#1:4672,2\n1591#1:4690,9\n1591#1:4711\n1591#1:4727,2\n1571#1:4731,2\n1624#1:4756,9\n1624#1:4777\n1629#1:4793,9\n1629#1:4814\n1629#1:4817,2\n1624#1:4834,2\n1670#1:4852,9\n1670#1:4873\n1671#1:4889,9\n1671#1:4910\n1671#1:4913,2\n1687#1:4935,9\n1687#1:4956\n1698#1:4978,9\n1698#1:4999\n1698#1:5001,2\n1687#1:5006,2\n1670#1:5010,2\n1722#1:5029,9\n1722#1:5050\n1722#1:5069,2\n79#1:1790,6\n82#1:1827,6\n309#1:1972,6\n313#1:2016,6\n339#1:2069,6\n368#1:2117,6\n385#1:2159,6\n526#1:2221,6\n535#1:2253,6\n540#1:2289,6\n544#1:2325,6\n554#1:2368,6\n1188#1:2542,6\n1262#1:2581,6\n183#1:2690,6\n199#1:2731,6\n209#1:2775,6\n231#1:2820,6\n433#1:2871,6\n438#1:2907,6\n447#1:2945,6\n452#1:2983,6\n457#1:3020,6\n465#1:3068,6\n470#1:3105,6\n480#1:3153,6\n485#1:3190,6\n736#1:3294,6\n613#1:3356,6\n640#1:3396,6\n814#1:3483,6\n1011#1:3578,6\n888#1:3640,6\n915#1:3680,6\n1089#1:3767,6\n1133#1:3825,6\n1218#1:3874,6\n1222#1:3910,6\n1241#1:3959,6\n1345#1:4012,6\n1349#1:4048,6\n1364#1:4089,6\n1384#1:4129,6\n1389#1:4166,6\n1397#1:4205,6\n1440#1:4274,6\n1447#1:4311,6\n1472#1:4360,6\n1479#1:4397,6\n1505#1:4446,6\n1512#1:4483,6\n1537#1:4532,6\n1544#1:4569,6\n1571#1:4624,6\n1578#1:4661,6\n1591#1:4703,6\n1624#1:4769,6\n1629#1:4806,6\n1670#1:4865,6\n1671#1:4902,6\n1687#1:4948,6\n1698#1:4991,6\n1722#1:5042,6\n82#1:1801\n82#1:1802,6\n82#1:1836\n82#1:1840\n309#1:1945\n309#1:1946,7\n309#1:1981\n309#1:2180\n526#1:2195\n526#1:2196,6\n526#1:2230\n554#1:2341\n554#1:2342,7\n554#1:2377\n554#1:2381\n526#1:2394\n1188#1:2516\n1188#1:2517,6\n1188#1:2551\n1188#1:2598\n183#1:2664\n183#1:2665,6\n183#1:2699\n183#1:2845\n438#1:2881\n438#1:2882,6\n438#1:2916\n438#1:3217\n613#1:3331\n613#1:3332,5\n613#1:3365\n613#1:3510\n888#1:3615\n888#1:3616,5\n888#1:3649\n888#1:3794\n1241#1:3932\n1241#1:3933,7\n1241#1:3968\n1241#1:3972\n1364#1:4063\n1364#1:4064,6\n1364#1:4098\n1364#1:4102\n1397#1:4178\n1397#1:4179,7\n1397#1:4214\n1397#1:4218\n1624#1:4743\n1624#1:4744,6\n1624#1:4778\n1624#1:4837\n1670#1:4839\n1670#1:4840,6\n1670#1:4874\n1670#1:5013\n1722#1:5015\n1722#1:5016,7\n1722#1:5051\n1722#1:5072\n100#1:1845,3\n103#1:1848,3\n140#1:1878\n140#1:1879,2\n140#1:1881\n140#1:1882,3\n149#1:1885\n149#1:1886,2\n149#1:1888\n149#1:1889,2\n149#1:1892\n163#1:1899\n163#1:1900,2\n164#1:1902\n164#1:1903,2\n310#1:1982,2\n310#1:2175\n1180#1:2490,4\n1321#1:2600,9\n1321#1:2609\n1321#1:2611\n1321#1:2612\n208#1:2741,2\n208#1:2789\n748#1:3254\n748#1:3261\n1023#1:3538\n1023#1:3545\n1603#1:4239\n1603#1:4246\n1696#1:4958\n1696#1:5005\n1321#1:2610\n313#1:1990\n313#1:1991,6\n313#1:2025\n313#1:2036\n339#1:2043\n339#1:2044,6\n339#1:2078\n339#1:2089\n368#1:2091\n368#1:2092,6\n368#1:2126\n368#1:2131\n385#1:2133\n385#1:2134,6\n385#1:2168\n385#1:2173\n535#1:2231,3\n535#1:2262\n540#1:2263\n540#1:2264,6\n540#1:2298\n540#1:2385\n535#1:2389\n1262#1:2556\n1262#1:2557,5\n1262#1:2590\n1262#1:2594\n199#1:2705\n199#1:2706,6\n199#1:2740\n199#1:2793\n433#1:2849,3\n433#1:2880\n447#1:2920\n447#1:2921,5\n447#1:2954\n457#1:2993\n457#1:2994,7\n457#1:3029\n457#1:3035\n470#1:3078\n470#1:3079,7\n470#1:3114\n470#1:3120\n485#1:3163\n485#1:3164,7\n485#1:3199\n485#1:3205\n447#1:3213\n433#1:3222\n640#1:3374,3\n640#1:3405\n640#1:3430\n814#1:3458\n814#1:3459,5\n814#1:3492\n814#1:3506\n915#1:3658,3\n915#1:3689\n915#1:3714\n1089#1:3742\n1089#1:3743,5\n1089#1:3776\n1089#1:3790\n1133#1:3798\n1133#1:3799,7\n1133#1:3834\n1133#1:3840\n1218#1:3848\n1218#1:3849,6\n1218#1:3883\n1218#1:3976\n1345#1:3986\n1345#1:3987,6\n1345#1:4021\n1345#1:4106\n1384#1:4107,3\n1384#1:4138\n1389#1:4139\n1389#1:4140,7\n1389#1:4175\n1389#1:4222\n1384#1:4233\n1440#1:4252,3\n1440#1:4283\n1447#1:4284\n1447#1:4285,7\n1447#1:4320\n1447#1:4325\n1440#1:4335\n1472#1:4338,3\n1472#1:4369\n1479#1:4370\n1479#1:4371,7\n1479#1:4406\n1479#1:4411\n1472#1:4421\n1505#1:4424,3\n1505#1:4455\n1512#1:4456\n1512#1:4457,7\n1512#1:4492\n1512#1:4497\n1505#1:4507\n1537#1:4510,3\n1537#1:4541\n1544#1:4542\n1544#1:4543,7\n1544#1:4578\n1544#1:4583\n1537#1:4593\n1571#1:4602,3\n1571#1:4633\n1578#1:4634\n1578#1:4635,7\n1578#1:4670\n1578#1:4675\n1571#1:4734\n1629#1:4779\n1629#1:4780,7\n1629#1:4815\n1629#1:4820\n1671#1:4875\n1671#1:4876,7\n1671#1:4911\n1671#1:4916\n1687#1:4922\n1687#1:4923,6\n1687#1:4957\n1687#1:5009\n599#1:2437\n874#1:2486\n1316#1:2599\n116#1:2628\n117#1:2629\n118#1:2630\n120#1:2631\n120#1:2632,2\n121#1:2634\n121#1:2635,2\n122#1:2637\n122#1:2638,2\n123#1:2640\n123#1:2641,2\n425#1:2846\n425#1:2847,2\n590#1:3230\n590#1:3231,2\n591#1:3233\n591#1:3234,2\n592#1:3236\n592#1:3237,2\n593#1:3239\n593#1:3240,2\n594#1:3242\n594#1:3243,2\n596#1:3245\n596#1:3246,2\n597#1:3248\n597#1:3249,2\n735#1:3251\n735#1:3252,2\n855#1:3514\n855#1:3515,2\n856#1:3517\n856#1:3518,2\n857#1:3520\n857#1:3521,2\n858#1:3523\n858#1:3524,2\n859#1:3526\n859#1:3527,2\n861#1:3529\n861#1:3530,2\n866#1:3532\n866#1:3533,2\n1010#1:3535\n1010#1:3536,2\n1173#1:3841\n1174#1:3842\n1175#1:3843\n1176#1:3844\n1177#1:3845\n1178#1:3846\n1309#1:3979\n1310#1:3980\n1311#1:3981\n1312#1:3982\n1313#1:3983\n1314#1:3984\n1315#1:3985\n1437#1:4234\n1504#1:4235\n1570#1:4236\n1570#1:4237,2\n243#1:2651,12\n1623#1:4247\n1623#1:4248,2\n*E\n"})
public final class OtherScreensKt {
   @Composable
   @ComposableInferredTarget(
      scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]"
   )
   public static final void GlassCard_dgCr_O4/* $FF was: GlassCard-dgCr-O4*/(@Nullable Modifier modifier, @Nullable BorderStroke border, @Nullable Color containerColor, @Nullable Function0 onClick, @Nullable Function0 onDoubleClick, @NotNull Function3 content, @Nullable Composer $composer, int $changed, int var8) {
      Intrinsics.checkNotNullParameter(content, "content");
      $composer = $composer.startRestartGroup(1664503138);
      ComposerKt.sourceInformation($composer, "C(GlassCard)P(3!1,1:c#ui.graphics.Color,4,5)60@2412L18,78@3018L216:OtherScreens.kt#to5c3");
      int $dirty = $changed;
      if ((var8 & 1) != 0) {
         $dirty = $changed | 6;
      } else if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(modifier) ? 4 : 2);
      }

      if ((var8 & 2) != 0) {
         $dirty |= 48;
      } else if (($changed & 48) == 0) {
         $dirty |= $composer.changed(border) ? 32 : 16;
      }

      if ((var8 & 4) != 0) {
         $dirty |= 384;
      } else if (($changed & 384) == 0) {
         $dirty |= $composer.changed(containerColor) ? 256 : 128;
      }

      if ((var8 & 8) != 0) {
         $dirty |= 3072;
      } else if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(onClick) ? 2048 : 1024;
      }

      if ((var8 & 16) != 0) {
         $dirty |= 24576;
      } else if (($changed & 24576) == 0) {
         $dirty |= $composer.changedInstance(onDoubleClick) ? 16384 : 8192;
      }

      if (($changed & 196608) == 0) {
         $dirty |= $composer.changedInstance(content) ? 131072 : 65536;
      }

      if (($dirty & 74899) == 74898 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if ((var8 & 1) != 0) {
            modifier = (Modifier)Modifier.Companion;
         }

         if ((var8 & 2) != 0) {
            border = null;
         }

         if ((var8 & 4) != 0) {
            containerColor = null;
         }

         if ((var8 & 8) != 0) {
            onClick = null;
         }

         if ((var8 & 16) != 0) {
            onDoubleClick = null;
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1664503138, $dirty, -1, "com.example.GlassCard (OtherScreens.kt:59)");
         }

         boolean isDark = ThemeKt.isAppInDarkTheme($composer, 0);
         long bgColor = containerColor != null ? containerColor.unbox-impl() : (isDark ? ColorKt.getDarkCard() : ColorKt.getWhite90());
         int var14 = 1;
         int var15 = 0;
         BorderStroke defaultBorder = BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var14), isDark ? ColorKt.getDarkGlassBorder() : ColorKt.getWhite40());
         Modifier var92;
         if (onClick == null && onDoubleClick == null) {
            $composer.startReplaceGroup(1816363482);
            $composer.endReplaceGroup();
            var15 = 24;
            int var82 = 0;
            var92 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(modifier, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var15))), bgColor, (Shape)null, 2, (Object)null);
         } else {
            $composer.startReplaceGroup(1816120845);
            ComposerKt.sourceInformation($composer, "68@2783L21");
            int var16 = 24;
            int var17 = 0;
            var92 = ClipKt.clip(modifier, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var16)));
            boolean var10001 = false;
            Object var10002 = null;
            Object var10003 = null;
            Object var10004 = null;
            Object var10005 = null;
            Function0 var10006 = onDoubleClick;
            ComposerKt.sourceInformationMarkerStart($composer, 1859703543, "CC(remember):OtherScreens.kt#9igjgp");
            boolean var18 = ($dirty & 7168) == 2048;
            int var19 = 0;
            Object var20 = $composer.rememberedValue();
            int var21 = 0;
            Object var10007;
            if (!var18 && var20 != Composer.Companion.getEmpty()) {
               var10007 = var20;
            } else {
               Object var72 = null;
               Object var71 = null;
               Object var70 = null;
               Object var69 = null;
               boolean var68 = false;
               Modifier var67 = var92;
               int var22 = 0;
               Function0 var23_1 = OtherScreensKt::GlassCard_dgCr_O4$lambda$1$lambda$0;
               var92 = var67;
               var10001 = var68;
               var10002 = var69;
               var10003 = var70;
               var10004 = var71;
               var10005 = var72;
               var10006 = onDoubleClick;
               $composer.updateRememberedValue(var23_1);
               var10007 = var23_1;
            }

            Function0 var81 = (Function0)var10007;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier var77 = BackgroundKt.background-bw27NRU$default(ClickableKt.combinedClickable-cJG_KMw$default(var92, var10001, (String)var10002, (Role)var10003, (String)var10004, (Function0)var10005, var10006, var81, 31, (Object)null), bgColor, (Shape)null, 2, (Object)null);
            $composer.endReplaceGroup();
            var92 = var77;
         }

         Modifier contentModifier = var92;
         BorderStroke var96 = border;
         if (border == null) {
            var96 = defaultBorder;
         }

         var15 = 24;
         int var83 = 0;
         Modifier var80 = BorderKt.border(contentModifier, var96, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var15)));
         byte var86 = 0;
         int var87 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         Alignment var84 = Alignment.Companion.getTopStart();
         boolean var85 = false;
         MeasurePolicy var88 = BoxKt.maybeCachedBoxMeasurePolicy(var84, var85);
         int var89 = 112 & var86 << 3;
         int var23 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var24 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var25 = $composer.getCurrentCompositionLocalMap();
         Modifier var26 = ComposedModifierKt.materializeModifier($composer, var80);
         Function0 var27 = ComposeUiNode.Companion.getConstructor();
         int var28 = 6 | 896 & var89 << 6;
         int var29 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var27);
         } else {
            $composer.useNode();
         }

         Composer var30 = Updater.constructor-impl($composer);
         int var31 = 0;
         Updater.set-impl(var30, var88, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var30, var25, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var32 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var33 = 0;
         int var35 = 0;
         if (var30.getInserting() || !Intrinsics.areEqual(var30.rememberedValue(), var24)) {
            var30.updateRememberedValue(var24);
            var30.apply(var24, var32);
         }

         Updater.set-impl(var30, var26, ComposeUiNode.Companion.getSetModifier());
         int var36 = 14 & var28 >> 6;
         int var38 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         int var39 = 6 | 112 & var86 >> 6;
         BoxScope var93 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var42 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -83713956, "C81@3133L95:OtherScreens.kt#to5c3");
         Modifier var94 = (Modifier)Modifier.Companion;
         int var43 = 16;
         int var44 = 0;
         Modifier var90 = PaddingKt.padding-3ABfNKs(var94, Dp.constructor-impl((float)var43));
         int var46 = 6 | 7168 & $dirty >> 6;
         int var47 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var91 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var48 = Alignment.Companion.getStart();
         MeasurePolicy var49 = ColumnKt.columnMeasurePolicy(var91, var48, $composer, 14 & var46 >> 3 | 112 & var46 >> 3);
         int var50 = 112 & var46 << 3;
         int var51 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var52 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var53 = $composer.getCurrentCompositionLocalMap();
         Modifier var54 = ComposedModifierKt.materializeModifier($composer, var90);
         Function0 var55 = ComposeUiNode.Companion.getConstructor();
         int var56 = 6 | 896 & var50 << 6;
         int var57 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var55);
         } else {
            $composer.useNode();
         }

         Composer var58 = Updater.constructor-impl($composer);
         int var59 = 0;
         Updater.set-impl(var58, var49, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var58, var53, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var60 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var61 = 0;
         int var63 = 0;
         if (var58.getInserting() || !Intrinsics.areEqual(var58.rememberedValue(), var52)) {
            var58.updateRememberedValue(var52);
            var58.apply(var52, var60);
         }

         Updater.set-impl(var58, var54, ComposeUiNode.Companion.getSetModifier());
         int var64 = 14 & var56 >> 6;
         int var66 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         content.invoke(ColumnScopeInstance.INSTANCE, $composer, 6 | 112 & var46 >> 6);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
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

      ScopeUpdateScope var95 = $composer.endRestartGroup();
      if (var95 != null) {
         var95.updateScope(OtherScreensKt::GlassCard_dgCr_O4$lambda$3);
      }

   }

   public static final boolean isMeetingEvent(@NotNull String title, @Nullable String description) {
      String lowerTitle;
      String var20;
      label78: {
         Intrinsics.checkNotNullParameter(title, "title");
         var20 = title.toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var20, "toLowerCase(...)");
         lowerTitle = var20;
         if (description != null) {
            var20 = description.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(var20, "toLowerCase(...)");
            if (var20 != null) {
               break label78;
            }
         }

         var20 = "";
      }

      String lowerDesc = var20;
      String[] var5 = new String[]{"meeting", "meet", "synch", "sync", "discussion", "call", "1:1", "1on1", "standup", "zoom", "teams", "hangout"};
      Iterable hasVideoLink = (Iterable)CollectionsKt.listOf(var5);
      int var6 = 0;
      boolean var21;
      if (hasVideoLink instanceof Collection && ((Collection)hasVideoLink).isEmpty()) {
         var21 = false;
      } else {
         Iterator var7 = hasVideoLink.iterator();

         while(true) {
            if (!var7.hasNext()) {
               var21 = false;
               break;
            }

            Object var8 = var7.next();
            String var9 = (String)var8;
            int var10 = 0;
            if (StringsKt.contains$default((CharSequence)lowerTitle, (CharSequence)var9, false, 2, (Object)null) || StringsKt.contains$default((CharSequence)lowerDesc, (CharSequence)var9, false, 2, (Object)null)) {
               var21 = true;
               break;
            }
         }
      }

      boolean hasMeetingKeyword = var21;
      String[] var14 = new String[]{"meet.google.com", "teams.microsoft.com", "zoom.us", "webex.com"};
      Iterable var15 = (Iterable)CollectionsKt.listOf(var14);
      int var16 = 0;
      if (var15 instanceof Collection && ((Collection)var15).isEmpty()) {
         var21 = false;
      } else {
         Iterator var17 = var15.iterator();

         while(true) {
            if (!var17.hasNext()) {
               var21 = false;
               break;
            }

            Object var18 = var17.next();
            String var19 = (String)var18;
            int var11 = 0;
            if (StringsKt.contains$default((CharSequence)lowerTitle, (CharSequence)var19, false, 2, (Object)null) || StringsKt.contains$default((CharSequence)lowerDesc, (CharSequence)var19, false, 2, (Object)null)) {
               var21 = true;
               break;
            }
         }
      }

      boolean hasVideoLink = var21;
      return hasMeetingKeyword || hasVideoLink;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void NotesScreen(@NotNull NotesViewModel viewModel, @NotNull PlannerViewModel plannerViewModel, @NotNull CalendarSyncViewModel syncViewModel, @NotNull AuthManager authManager, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(viewModel, "viewModel");
      Intrinsics.checkNotNullParameter(plannerViewModel, "plannerViewModel");
      Intrinsics.checkNotNullParameter(syncViewModel, "syncViewModel");
      Intrinsics.checkNotNullParameter(authManager, "authManager");
      $composer = $composer.startRestartGroup(-491194866);
      ComposerKt.sourceInformation($composer, "C(NotesScreen)P(3,1,2)115@4181L29,116@4262L29,117@4337L29,119@4391L30,120@4484L34,121@4543L46,122@4613L46,138@5106L878,160@6010L243,170@6344L438,181@6789L3000,168@6259L3530:OtherScreens.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changedInstance(viewModel) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(plannerViewModel) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(syncViewModel) ? 256 : 128;
      }

      if (($dirty & 147) == 146 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-491194866, $dirty, -1, "com.example.NotesScreen (OtherScreens.kt:114)");
         }

         State notes$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getAllNotes(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State localTasks$delegate = FlowExtKt.collectAsStateWithLifecycle(plannerViewModel.getTodaysTasks(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State googleEvents$delegate = FlowExtKt.collectAsStateWithLifecycle(syncViewModel.getEvents(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         ComposerKt.sourceInformationMarkerStart($composer, 408149836, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var13 = false;
         int var14 = 0;
         Object var15 = $composer.rememberedValue();
         int var17_10 = 0;
         Object var10000;
         if (var15 == Composer.Companion.getEmpty()) {
            int var17 = 0;
            Object var75 = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var75);
            var10000 = (MeetingItem)var75;
         } else {
            var10000 = (MeetingItem)var15;
         }

         MutableState showAddNoteDialog$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableState selectedTab$delegate = showAddNoteDialog$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 408152816, "CC(remember):OtherScreens.kt#9igjgp");
         var14 = 0;
         int var68 = 0;
         Object var17_10 = $composer.rememberedValue();
         int var76 = 0;
         if (var17_10 == Composer.Companion.getEmpty()) {
            int var19_6 = 0;
            Object var19_6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var19_6);
            var10000 = var19_6;
         } else {
            var10000 = var17_10;
         }

         MutableState noteToDelete$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         showAddNoteDialog$delegate = noteToDelete$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 408154716, "CC(remember):OtherScreens.kt#9igjgp");
         var68 = 0;
         int var71 = 0;
         Object var77 = $composer.rememberedValue();
         int var80 = 0;
         if (var77 == Composer.Companion.getEmpty()) {
            int var19 = 0;
            Object var85 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var85);
            var10000 = var85;
         } else {
            var10000 = var77;
         }

         MutableState editingNote$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         noteToDelete$delegate = editingNote$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 408156956, "CC(remember):OtherScreens.kt#9igjgp");
         var71 = 0;
         int var78 = 0;
         Object var19_6 = $composer.rememberedValue();
         int var86 = 0;
         if (var19_6 == Composer.Companion.getEmpty()) {
            int var22_6 = 0;
            Object var22_6 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var22_6);
            var10000 = var22_6;
         } else {
            var10000 = var19_6;
         }

         MutableState var66 = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         editingNote$delegate = var66;
         Calendar todayEnd = Calendar.getInstance();
         int var82 = 0;
         todayEnd.set(11, 0);
         todayEnd.set(12, 0);
         todayEnd.set(13, 0);
         todayEnd.set(14, 0);
         long todayStart = todayEnd.getTimeInMillis();
         Calendar allMeetings = Calendar.getInstance();
         int var89 = 0;
         allMeetings.set(11, 23);
         allMeetings.set(12, 59);
         allMeetings.set(13, 59);
         allMeetings.set(14, 999);
         long todayEnd = allMeetings.getTimeInMillis();
         List var87 = NotesScreen$lambda$7(localTasks$delegate);
         List var22_6 = NotesScreen$lambda$8(googleEvents$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 408173564, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var23 = $composer.changed(var87) | $composer.changed(var22_6);
         int var24 = 0;
         Object var25 = $composer.rememberedValue();
         int var26 = 0;
         if (!var23 && var25 != Composer.Companion.getEmpty()) {
            var10000 = var25;
         } else {
            int var27 = 0;
            Iterable var28 = (Iterable)NotesScreen$lambda$7(localTasks$delegate);
            int var29 = 0;
            Collection var31 = (Collection)(new ArrayList());
            int var33_11 = 0;

            for(Object var34 : var28) {
               TaskEntity var33_14 = (TaskEntity)var34;
               int var36 = 0;
               if (var33_14.isMeeting()) {
                  var31.add(var34);
               }
            }

            var28 = (Iterable)((List)var31);
            var29 = 0;
            var31 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var28, 10)));
            var33_11 = 0;

            for(Object var165 : var28) {
               TaskEntity var33_14 = (TaskEntity)var165;
               int var181 = 0;
               var10000 = new MeetingItem;
               String var10002 = "local_" + var33_14.getId();
               String var10003 = var33_14.getTitle();
               Long var10004 = var33_14.getStartTime();
               long var225 = var10004 != null ? var10004 : var33_14.getDate();
               Long var10005 = var33_14.getEndTime();
               long var226;
               if (var10005 != null) {
                  var226 = var10005;
               } else {
                  Long var227 = var33_14.getStartTime();
                  var226 = (var227 != null ? var227 : var33_14.getDate()) + 3600000L;
               }

               var10000.<init>(var10002, var10003, var225, var226, false);
               var31.add(var10000);
            }

            List var38 = (List)var31;
            Iterable var135 = (Iterable)NotesScreen$lambda$8(googleEvents$delegate);
            int var30 = 0;
            Collection var33_11 = (Collection)(new ArrayList());
            int var161 = 0;

            for(Object var33_14 : var135) {
               CalendarEvent var182 = (CalendarEvent)var33_14;
               int var39 = 0;
               String var196 = var182.getSummary();
               if (var196 == null) {
                  var196 = "";
               }

               if (isMeetingEvent(var196, var182.getDescription())) {
                  var33_11.add(var33_14);
               }
            }

            var135 = (Iterable)((List)var33_11);
            var30 = 0;
            var33_11 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var135, 10)));
            var161 = 0;

            for(Object var33_14 : var135) {
               CalendarEvent var183 = (CalendarEvent)var33_14;
               int var189 = 0;
               String var197 = "google_" + var183.getId();
               String var10001 = var183.getSummary();
               if (var10001 == null) {
                  var10001 = "Google Meeting";
               }

               long var216 = var183.getStartTimeInMillis();
               Long var40 = var183.getEndTimeInMillis();
               long var41 = ((Number)var40).longValue();
               long var43 = var216;
               String var45 = var10001;
               String var46 = var197;
               int var47 = 0;
               boolean var48 = var41 > 0L;
               long var222 = (var48 ? var40 : null) != null ? var48 ? var40 : null : var183.getStartTimeInMillis() + 3600000L;
               boolean var53 = true;
               long var54 = var222;
               var33_11.add(new MeetingItem(var46, var45, var43, var54, var53));
            }

            List var128 = (List)var33_11;
            Object var49 = CollectionsKt.plus((Collection)var38, (Iterable)var128);
            $composer.updateRememberedValue(var49);
            var10000 = var49;
         }

         List var21 = (List)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         List allMeetings = var21;
         var22_6 = NotesScreen$lambda$6(notes$delegate);
         int var97 = NotesScreen$lambda$10(selectedTab$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 408201857, "CC(remember):OtherScreens.kt#9igjgp");
         var24 = $composer.changed(var22_6) | $composer.changed(var97);
         int var107 = 0;
         Object var114 = $composer.rememberedValue();
         int var121 = 0;
         if (!var24 && var114 != Composer.Companion.getEmpty()) {
            var10000 = (MeetingItem)var114;
         } else {
            int var129 = 0;
            List var199;
            switch (NotesScreen$lambda$10(selectedTab$delegate)) {
               case 1:
                  Iterable var138 = (Iterable)NotesScreen$lambda$6(notes$delegate);
                  int var144 = 0;
                  Collection var33_11 = (Collection)(new ArrayList());
                  int var164 = 0;

                  for(Object var33_14 : var138) {
                     NoteEntity var185 = (NoteEntity)var33_14;
                     int var186 = 0;
                     LongRange var188 = new LongRange(todayStart, todayEnd);
                     Long var190 = var185.getLinkedDate();
                     if (var190 != null && var188.contains(var190)) {
                        var33_11.add(var33_14);
                     }
                  }

                  var199 = (List)var33_11;
                  break;
               case 2:
                  Iterable var137 = (Iterable)NotesScreen$lambda$6(notes$delegate);
                  int var143 = 0;
                  Collection var33_11 = (Collection)(new ArrayList());
                  int var163 = 0;

                  for(Object var33_14 : var137) {
                     NoteEntity var184 = (NoteEntity)var33_14;
                     int var37 = 0;
                     CharSequence var187 = (CharSequence)var184.getLinkedMeetingId();
                     if (var187 != null && var187.length() != 0) {
                        var33_11.add(var33_14);
                     }
                  }

                  var199 = (List)var33_11;
                  break;
               default:
                  var199 = NotesScreen$lambda$6(notes$delegate);
            }

            Object var191 = var199;
            $composer.updateRememberedValue(var191);
            var10000 = (MeetingItem)var191;
         }

         List filteredNotes = (List)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         long var22_6 = Color.Companion.getTransparent-0d7_KjU();
         ScaffoldKt.Scaffold-TvnljyQ((Modifier)null, (Function2)null, (Function2)null, (Function2)null, (Function2)ComposableLambdaKt.rememberComposableLambda(847910421, true, OtherScreensKt::NotesScreen$lambda$34, $composer, 54), 0, var22_6, 0L, (WindowInsets)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-721174307, true, OtherScreensKt::NotesScreen$lambda$48, $composer, 54), $composer, 806903808, 431);
         NoteEntity var22_6 = NotesScreen$lambda$16(noteToDelete$delegate);
         if (var22_6 == null) {
            $composer.startReplaceGroup(-226871713);
            $composer.endReplaceGroup();
            var10000 = null;
         } else {
            $composer.startReplaceGroup(-226871712);
            ComposerKt.sourceInformation($composer, "*259@10022L23,260@10071L94,256@9831L344");
            var23 = (boolean)0;
            String var201 = "Delete Note";
            String var211 = "Are you sure you want to delete \"" + var22_6.getTitle() + "\"? This action cannot be undone.";
            ComposerKt.sourceInformationMarkerStart($composer, -466355797, "CC(remember):OtherScreens.kt#9igjgp");
            var107 = 0;
            int var115 = 0;
            Object var122 = $composer.rememberedValue();
            int var130 = 0;
            Object var217;
            if (var122 == Composer.Companion.getEmpty()) {
               String var139 = var211;
               String var145 = "Delete Note";
               int var149 = 0;
               Function0 var33_11 = OtherScreensKt::NotesScreen$lambda$53$lambda$50$lambda$49;
               var201 = var145;
               var211 = var139;
               $composer.updateRememberedValue(var33_11);
               var217 = var33_11;
            } else {
               var217 = var122;
            }

            Function0 var170 = (Function0)var217;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var218 = var170;
            ComposerKt.sourceInformationMarkerStart($composer, -466354158, "CC(remember):OtherScreens.kt#9igjgp");
            var107 = $composer.changedInstance(viewModel) | $composer.changed(var22_6);
            var115 = 0;
            var122 = $composer.rememberedValue();
            var130 = 0;
            Object var223;
            if (!var107 && var122 != Composer.Companion.getEmpty()) {
               var223 = var122;
            } else {
               String var140 = var211;
               String var146 = var201;
               int var150 = 0;
               Function0 var33_14 = OtherScreensKt::NotesScreen$lambda$53$lambda$52$lambda$51;
               var201 = var146;
               var211 = var140;
               var218 = var170;
               $composer.updateRememberedValue(var33_14);
               var223 = var33_14;
            }

            var170 = (Function0)var223;
            ComposerKt.sourceInformationMarkerEnd($composer);
            DeleteConfirmationDialog(var201, var211, var218, var170, $composer, 390, 0);
            Unit var202 = Unit.INSTANCE;
            $composer.endReplaceGroup();
            var202 = Unit.INSTANCE;
         }

         if (NotesScreen$lambda$13(showAddNoteDialog$delegate)) {
            $composer.startReplaceGroup(-226471719);
            ComposerKt.sourceInformation($composer, "270@10303L29,271@10354L283,268@10220L427");
            List var205 = allMeetings;
            ComposerKt.sourceInformationMarkerStart($composer, 408339019, "CC(remember):OtherScreens.kt#9igjgp");
            boolean var98 = false;
            var23 = (boolean)0;
            Object var105 = $composer.rememberedValue();
            var107 = 0;
            Object var213;
            if (var105 == Composer.Companion.getEmpty()) {
               int var117 = 0;
               Function0 var212 = OtherScreensKt::NotesScreen$lambda$55$lambda$54;
               var205 = allMeetings;
               Object var124 = var212;
               $composer.updateRememberedValue(var124);
               var213 = var124;
            } else {
               var213 = var105;
            }

            Function0 var22_6 = (Function0)var213;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var214 = var22_6;
            ComposerKt.sourceInformationMarkerStart($composer, 408340905, "CC(remember):OtherScreens.kt#9igjgp");
            var98 = $composer.changed(todayStart) | $composer.changedInstance(viewModel);
            var23 = (boolean)0;
            var105 = $composer.rememberedValue();
            var107 = 0;
            Object var219;
            if (!var98 && var105 != Composer.Companion.getEmpty()) {
               var219 = var105;
            } else {
               List var50 = var205;
               int var118 = 0;
               Function5 var27_12 = OtherScreensKt::NotesScreen$lambda$57$lambda$56;
               var205 = var50;
               var214 = var22_6;
               $composer.updateRememberedValue(var27_12);
               var219 = var27_12;
            }

            Function5 var22_6 = (Function5)var219;
            ComposerKt.sourceInformationMarkerEnd($composer);
            DetailedAddNoteDialog(var205, var214, var22_6, $composer, 48);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-236614764);
            $composer.endReplaceGroup();
         }

         var22_6 = NotesScreen$lambda$19(editingNote$delegate);
         if (var22_6 == null) {
            $composer.startReplaceGroup(-226004705);
            $composer.endReplaceGroup();
            var10000 = null;
         } else {
            $composer.startReplaceGroup(-226004704);
            ComposerKt.sourceInformation($composer, "*283@10803L22,284@10848L532,280@10694L696");
            var23 = (boolean)0;
            NoteEntity var206 = var22_6;
            List var215 = allMeetings;
            ComposerKt.sourceInformationMarkerStart($composer, 1492061985, "CC(remember):OtherScreens.kt#9igjgp");
            var107 = 0;
            int var119 = 0;
            Object var125 = $composer.rememberedValue();
            int var132 = 0;
            Object var220;
            if (var125 == Composer.Companion.getEmpty()) {
               int var151 = 0;
               Function0 var33_11 = OtherScreensKt::NotesScreen$lambda$62$lambda$59$lambda$58;
               var206 = var22_6;
               var215 = allMeetings;
               $composer.updateRememberedValue(var33_11);
               var220 = var33_11;
            } else {
               var220 = var125;
            }

            Function0 var172 = (Function0)var220;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var221 = var172;
            ComposerKt.sourceInformationMarkerStart($composer, 1492063935, "CC(remember):OtherScreens.kt#9igjgp");
            var107 = $composer.changed(todayStart) | $composer.changedInstance(viewModel) | $composer.changed(var22_6);
            var119 = 0;
            var125 = $composer.rememberedValue();
            var132 = 0;
            Object var224;
            if (!var107 && var125 != Composer.Companion.getEmpty()) {
               var224 = var125;
            } else {
               List var141 = var215;
               NoteEntity var147 = var206;
               int var152 = 0;
               Function5 var33_14 = OtherScreensKt::NotesScreen$lambda$62$lambda$61$lambda$60;
               var206 = var147;
               var215 = var141;
               var221 = var172;
               $composer.updateRememberedValue(var33_14);
               var224 = var33_14;
            }

            Function5 var173 = (Function5)var224;
            ComposerKt.sourceInformationMarkerEnd($composer);
            DetailedEditNoteDialog(var206, var215, var221, var173, $composer, 384);
            Unit var207 = Unit.INSTANCE;
            $composer.endReplaceGroup();
            var207 = Unit.INSTANCE;
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var210 = $composer.endRestartGroup();
      if (var210 != null) {
         var210.updateScope(OtherScreensKt::NotesScreen$lambda$63);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void NoteContentWithChecklist(@NotNull String content, boolean expanded, @NotNull Function1 onContentChange, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(content, "content");
      Intrinsics.checkNotNullParameter(onContentChange, "onContentChange");
      $composer = $composer.startRestartGroup(-999876865);
      ComposerKt.sourceInformation($composer, "C(NoteContentWithChecklist)308@11630L5505:OtherScreens.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(content) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changed(expanded) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(onContentChange) ? 256 : 128;
      }

      if (($dirty & 147) == 146 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-999876865, $dirty, -1, "com.example.NoteContentWithChecklist (OtherScreens.kt:305)");
         }

         CharSequence var10000 = (CharSequence)content;
         String[] var7 = new String[]{"\n"};
         List lines = StringsKt.split$default(var10000, var7, false, 0, 6, (Object)null);
         List displayLines = expanded ? lines : CollectionsKt.take((Iterable)lines, 2);
         int var9 = 4;
         int var10 = 0;
         Arrangement.Vertical var115 = (Arrangement.Vertical)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var9));
         int var12 = 48;
         int var13 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Modifier var8 = (Modifier)Modifier.Companion;
         Alignment.Horizontal var116 = Alignment.Companion.getStart();
         MeasurePolicy var14 = ColumnKt.columnMeasurePolicy(var115, var116, $composer, 14 & var12 >> 3 | 112 & var12 >> 3);
         int var15 = 112 & var12 << 3;
         int var16 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var17 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var18 = $composer.getCurrentCompositionLocalMap();
         Modifier var19 = ComposedModifierKt.materializeModifier($composer, var8);
         Function0 var20 = ComposeUiNode.Companion.getConstructor();
         int var21 = 6 | 896 & var15 << 6;
         int var22 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var20);
         } else {
            $composer.useNode();
         }

         Composer var23 = Updater.constructor-impl($composer);
         int var24 = 0;
         Updater.set-impl(var23, var14, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var23, var18, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var25 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var26 = 0;
         int var28 = 0;
         if (var23.getInserting() || !Intrinsics.areEqual(var23.rememberedValue(), var17)) {
            var23.updateRememberedValue(var17);
            var23.apply(var17, var25);
         }

         Updater.set-impl(var23, var19, ComposeUiNode.Companion.getSetModifier());
         int var29 = 14 & var21 >> 6;
         int var31 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var32 = 6 | 112 & var12 >> 6;
         Composer var73_1 = $composer;
         ColumnScope var246 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var35 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1278834570, "C:OtherScreens.kt#to5c3");
         $composer.startReplaceGroup(1205673352);
         ComposerKt.sourceInformation($composer, "");
         Iterable var36 = (Iterable)displayLines;
         int var37 = 0;
         int var38 = 0;

         for(Object var40 : var36) {
            int var41 = var38++;
            if (var41 < 0) {
               CollectionsKt.throwIndexOverflow();
            }

            String var42 = (String)var40;
            int var44 = 0;
            if (StringsKt.startsWith$default(var42, "[ ] ", false, 2, (Object)null)) {
               var73_1.startReplaceGroup(611308281);
               ComposerKt.sourceInformation(var73_1, "314@11972L237,312@11826L1286");
               Alignment.Vertical var45 = Alignment.Companion.getCenterVertically();
               Modifier var248 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
               boolean var10001 = false;
               Object var10002 = null;
               Object var10003 = null;
               ComposerKt.sourceInformationMarkerStart(var73_1, -950107416, "CC(remember):OtherScreens.kt#9igjgp");
               boolean var47 = $composer.changedInstance(lines) | $composer.changed(var41) | $composer.changed(var42) | ($dirty & 896) == 256;
               int var48 = 0;
               Object var49 = var73_1.rememberedValue();
               int var50 = 0;
               Object var10004;
               if (!var47 && var49 != Composer.Companion.getEmpty()) {
                  var10004 = var49;
               } else {
                  Object var51 = null;
                  Object var52 = null;
                  boolean var53 = false;
                  Modifier var54 = var248;
                  int var55 = 0;
                  Function0 var57_1 = OtherScreensKt::NoteContentWithChecklist$lambda$77$lambda$76$lambda$65$lambda$64;
                  var248 = var54;
                  var10001 = var53;
                  var10002 = var52;
                  var10003 = var51;
                  var73_1.updateRememberedValue(var57_1);
                  var10004 = var57_1;
               }

               Function0 var58 = (Function0)var10004;
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               Modifier var164 = ClickableKt.clickable-XHw0xAI$default(var248, var10001, (String)var10002, (Role)var10003, var58, 7, (Object)null);
               short var136 = 384;
               var50 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
               Arrangement.Horizontal var46 = Arrangement.INSTANCE.getStart();
               MeasurePolicy var154 = RowKt.rowMeasurePolicy(var46, var45, var73_1, 14 & var136 >> 3 | 112 & var136 >> 3);
               int var57 = 112 & var136 << 3;
               int var59 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
               int var60 = ComposablesKt.getCurrentCompositeKeyHash(var73_1, 0);
               CompositionLocalMap var61 = var73_1.getCurrentCompositionLocalMap();
               Modifier var62 = ComposedModifierKt.materializeModifier(var73_1, var164);
               Function0 var63 = ComposeUiNode.Companion.getConstructor();
               int var64 = 6 | 896 & var57 << 6;
               int var65 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
               if (!(var73_1.getApplier() instanceof Applier)) {
                  ComposablesKt.invalidApplier();
               }

               var73_1.startReusableNode();
               if (var73_1.getInserting()) {
                  var73_1.createNode(var63);
               } else {
                  var73_1.useNode();
               }

               Composer var66 = Updater.constructor-impl(var73_1);
               int var67 = 0;
               Updater.set-impl(var66, var154, ComposeUiNode.Companion.getSetMeasurePolicy());
               Updater.set-impl(var66, var61, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
               Function2 var68 = ComposeUiNode.Companion.getSetCompositeKeyHash();
               int var69 = 0;
               int var71 = 0;
               if (var66.getInserting() || !Intrinsics.areEqual(var66.rememberedValue(), var60)) {
                  var66.updateRememberedValue(var60);
                  var66.apply(var60, var68);
               }

               Updater.set-impl(var66, var62, ComposeUiNode.Companion.getSetModifier());
               int var72 = 14 & var64 >> 6;
               int var74 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, -407840262, "C101@5126L9:Row.kt#2w3rfo");
               int var75 = 6 | 112 & var136 >> 6;
               RowScope var249 = (RowScope)RowScopeInstance.INSTANCE;
               int var78 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, 1608322156, "C322@12359L253,327@12706L11,327@12668L82,320@12258L518,329@12801L39,333@13021L11,330@12865L225:OtherScreens.kt#to5c3");
               boolean var250 = false;
               ComposerKt.sourceInformationMarkerStart(var73_1, -779399980, "CC(remember):OtherScreens.kt#9igjgp");
               boolean var80 = $composer.changedInstance(lines) | $composer.changed(var41) | $composer.changed(var42) | ($dirty & 896) == 256;
               int var81 = 0;
               Object var82 = var73_1.rememberedValue();
               int var83 = 0;
               Object var269;
               if (!var80 && var82 != Composer.Companion.getEmpty()) {
                  var269 = var82;
               } else {
                  boolean var84 = false;
                  int var85 = 0;
                  Function1 var87_1 = OtherScreensKt::NoteContentWithChecklist$lambda$77$lambda$76$lambda$68$lambda$67$lambda$66;
                  var250 = var84;
                  var73_1.updateRememberedValue(var87_1);
                  var269 = var87_1;
               }

               Function1 var88 = (Function1)var269;
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               CheckboxKt.Checkbox(var250, var88, (Modifier)null, false, CheckboxDefaults.INSTANCE.colors-5tl4gsc(0L, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(var73_1, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.6F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, 0L, 0L, 0L, var73_1, CheckboxDefaults.$stable << 18, 61), (MutableInteractionSource)null, var73_1, 6, 44);
               Modifier var251 = (Modifier)Modifier.Companion;
               int var234 = 4;
               int var79 = 0;
               SpacerKt.Spacer(SizeKt.width-3ABfNKs(var251, Dp.constructor-impl((float)var234)), var73_1, 6);
               String var252 = var42.substring(4);
               Intrinsics.checkNotNullExpressionValue(var252, "substring(...)");
               String var235 = var252;
               long var89 = TextUnitKt.getSp(14);
               long var91 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(var73_1, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
               TextKt.Text--4IGK_g(var235, (Modifier)null, var91, var89, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, var73_1, 3072, 0, 131058);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               var73_1.endNode();
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               var73_1.endReplaceGroup();
            } else if (StringsKt.startsWith$default(var42, "[x] ", false, 2, (Object)null)) {
               var73_1.startReplaceGroup(612672436);
               ComposerKt.sourceInformation(var73_1, "340@13342L237,338@13196L1451");
               Alignment.Vertical var122 = Alignment.Companion.getCenterVertically();
               Modifier var253 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
               boolean var270 = false;
               Object var276 = null;
               Object var277 = null;
               ComposerKt.sourceInformationMarkerStart(var73_1, -950063576, "CC(remember):OtherScreens.kt#9igjgp");
               boolean var131 = $composer.changedInstance(lines) | $composer.changed(var41) | $composer.changed(var42) | ($dirty & 896) == 256;
               int var132 = 0;
               Object var137 = var73_1.rememberedValue();
               int var145 = 0;
               Object var278;
               if (!var131 && var137 != Composer.Companion.getEmpty()) {
                  var278 = var137;
               } else {
                  Object var150 = null;
                  Object var151 = null;
                  boolean var152 = false;
                  Modifier var153 = var253;
                  int var155 = 0;
                  Function0 var57_1 = OtherScreensKt::NoteContentWithChecklist$lambda$77$lambda$76$lambda$70$lambda$69;
                  var253 = var153;
                  var270 = var152;
                  var276 = var151;
                  var277 = var150;
                  var73_1.updateRememberedValue(var57_1);
                  var278 = var57_1;
               }

               Function0 var165 = (Function0)var278;
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               Modifier var166 = ClickableKt.clickable-XHw0xAI$default(var253, var270, (String)var276, (Role)var277, var165, 7, (Object)null);
               short var138 = 384;
               var145 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
               Arrangement.Horizontal var126 = Arrangement.INSTANCE.getStart();
               MeasurePolicy var156 = RowKt.rowMeasurePolicy(var126, var122, var73_1, 14 & var138 >> 3 | 112 & var138 >> 3);
               int var161 = 112 & var138 << 3;
               int var171 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
               int var174 = ComposablesKt.getCurrentCompositeKeyHash(var73_1, 0);
               CompositionLocalMap var177 = var73_1.getCurrentCompositionLocalMap();
               Modifier var180 = ComposedModifierKt.materializeModifier(var73_1, var166);
               Function0 var183 = ComposeUiNode.Companion.getConstructor();
               int var186 = 6 | 896 & var161 << 6;
               int var189 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
               if (!(var73_1.getApplier() instanceof Applier)) {
                  ComposablesKt.invalidApplier();
               }

               var73_1.startReusableNode();
               if (var73_1.getInserting()) {
                  var73_1.createNode(var183);
               } else {
                  var73_1.useNode();
               }

               Composer var192 = Updater.constructor-impl(var73_1);
               int var195 = 0;
               Updater.set-impl(var192, var156, ComposeUiNode.Companion.getSetMeasurePolicy());
               Updater.set-impl(var192, var177, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
               Function2 var198 = ComposeUiNode.Companion.getSetCompositeKeyHash();
               int var201 = 0;
               int var204 = 0;
               if (var192.getInserting() || !Intrinsics.areEqual(var192.rememberedValue(), var174)) {
                  var192.updateRememberedValue(var174);
                  var192.apply(var174, var198);
               }

               Updater.set-impl(var192, var180, ComposeUiNode.Companion.getSetModifier());
               int var207 = 14 & var186 >> 6;
               int var210 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, -407840262, "C101@5126L9:Row.kt#2w3rfo");
               int var213 = 6 | 112 & var138 >> 6;
               RowScope var254 = (RowScope)RowScopeInstance.INSTANCE;
               int var216 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, 1671550174, "C348@13728L253,353@14037L32,346@13628L467,355@14120L39,359@14340L11,360@14435L10,356@14184L441:OtherScreens.kt#to5c3");
               boolean var255 = true;
               ComposerKt.sourceInformationMarkerStart(var73_1, -223171235, "CC(remember):OtherScreens.kt#9igjgp");
               boolean var220 = $composer.changedInstance(lines) | $composer.changed(var41) | $composer.changed(var42) | ($dirty & 896) == 256;
               int var221 = 0;
               Object var224 = var73_1.rememberedValue();
               int var225 = 0;
               Object var271;
               if (!var220 && var224 != Composer.Companion.getEmpty()) {
                  var271 = var224;
               } else {
                  boolean var227 = true;
                  int var231 = 0;
                  Function1 var87_1 = OtherScreensKt::NoteContentWithChecklist$lambda$77$lambda$76$lambda$73$lambda$72$lambda$71;
                  var255 = var227;
                  var73_1.updateRememberedValue(var87_1);
                  var271 = var87_1;
               }

               Function1 var236 = (Function1)var271;
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               CheckboxKt.Checkbox(var255, var236, (Modifier)null, false, CheckboxDefaults.INSTANCE.colors-5tl4gsc(ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, var73_1, 6 | CheckboxDefaults.$stable << 18, 62), (MutableInteractionSource)null, var73_1, 6, 44);
               Modifier var256 = (Modifier)Modifier.Companion;
               int var237 = 4;
               int var219 = 0;
               SpacerKt.Spacer(SizeKt.width-3ABfNKs(var256, Dp.constructor-impl((float)var237)), var73_1, 6);
               String var257 = var42.substring(4);
               Intrinsics.checkNotNullExpressionValue(var257, "substring(...)");
               String var238 = var257;
               long var240 = TextUnitKt.getSp(14);
               long var242 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(var73_1, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
               TextStyle var226 = TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography(var73_1, MaterialTheme.$stable).getBodyMedium(), 0L, 0L, (FontWeight)null, (FontStyle)null, (FontSynthesis)null, (FontFamily)null, (String)null, 0L, (BaselineShift)null, (TextGeometricTransform)null, (LocaleList)null, 0L, TextDecoration.Companion.getLineThrough(), (Shadow)null, (DrawStyle)null, 0, 0, 0L, (TextIndent)null, (PlatformTextStyle)null, (LineHeightStyle)null, 0, 0, (TextMotion)null, 16773119, (Object)null);
               TextKt.Text--4IGK_g(var238, (Modifier)null, var242, var240, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, var226, var73_1, 3072, 0, 65522);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               var73_1.endNode();
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               var73_1.endReplaceGroup();
            } else if (!StringsKt.startsWith$default(var42, "- ", false, 2, (Object)null) && !StringsKt.startsWith$default(var42, "* ", false, 2, (Object)null)) {
               CharSequence var124 = (CharSequence)var42;
               if ((new Regex("^\\d+\\.\\s.*")).matches(var124)) {
                  var73_1.startReplaceGroup(614916247);
                  ComposerKt.sourceInformation(var73_1, "384@15666L620");
                  int var125 = StringsKt.indexOf$default((CharSequence)var42, ".", 0, false, 6, (Object)null);
                  String var262 = var42.substring(0, var125 + 1);
                  Intrinsics.checkNotNullExpressionValue(var262, "substring(...)");
                  String var99 = var262;
                  var262 = var42.substring(var125 + 1);
                  Intrinsics.checkNotNullExpressionValue(var262, "substring(...)");
                  String var170 = StringsKt.trim((CharSequence)var262).toString();
                  Alignment.Vertical var130 = Alignment.Companion.getTop();
                  Modifier var264 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
                  int var133 = 8;
                  int var140 = 0;
                  float var273 = Dp.constructor-impl((float)var133);
                  var133 = 2;
                  var140 = 0;
                  Modifier var135 = PaddingKt.padding-VpY3zN4(var264, var273, Dp.constructor-impl((float)var133));
                  short var163 = 390;
                  int var173 = 0;
                  ComposerKt.sourceInformationMarkerStart(var73_1, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                  Arrangement.Horizontal var142 = Arrangement.INSTANCE.getStart();
                  MeasurePolicy var176 = RowKt.rowMeasurePolicy(var142, var130, var73_1, 14 & var163 >> 3 | 112 & var163 >> 3);
                  int var179 = 112 & var163 << 3;
                  int var182 = 0;
                  ComposerKt.sourceInformationMarkerStart(var73_1, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                  int var185 = ComposablesKt.getCurrentCompositeKeyHash(var73_1, 0);
                  CompositionLocalMap var188 = var73_1.getCurrentCompositionLocalMap();
                  Modifier var191 = ComposedModifierKt.materializeModifier(var73_1, var135);
                  Function0 var194 = ComposeUiNode.Companion.getConstructor();
                  int var197 = 6 | 896 & var179 << 6;
                  int var200 = 0;
                  ComposerKt.sourceInformationMarkerStart(var73_1, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                  if (!(var73_1.getApplier() instanceof Applier)) {
                     ComposablesKt.invalidApplier();
                  }

                  var73_1.startReusableNode();
                  if (var73_1.getInserting()) {
                     var73_1.createNode(var194);
                  } else {
                     var73_1.useNode();
                  }

                  Composer var203 = Updater.constructor-impl(var73_1);
                  int var70 = 0;
                  Updater.set-impl(var203, var176, ComposeUiNode.Companion.getSetMeasurePolicy());
                  Updater.set-impl(var203, var188, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                  Function2 var206 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                  int var209 = 0;
                  int var212 = 0;
                  if (var203.getInserting() || !Intrinsics.areEqual(var203.rememberedValue(), var185)) {
                     var203.updateRememberedValue(var185);
                     var203.apply(var185, var206);
                  }

                  Updater.set-impl(var203, var191, ComposeUiNode.Companion.getSetModifier());
                  int var215 = 14 & var197 >> 6;
                  int var77 = 0;
                  ComposerKt.sourceInformationMarkerStart(var73_1, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                  int var218 = 6 | 112 & var163 >> 6;
                  RowScope var265 = (RowScope)RowScopeInstance.INSTANCE;
                  int var223 = 0;
                  ComposerKt.sourceInformationMarkerStart(var73_1, 1669696774, "C388@15881L82,389@15988L39,393@16195L11,390@16052L212:OtherScreens.kt#to5c3");
                  long var244 = TextUnitKt.getSp(14);
                  FontWeight var230 = FontWeight.Companion.getBold();
                  long var100 = ColorKt.getIndigo600();
                  TextKt.Text--4IGK_g(var99, (Modifier)null, var100, var244, (FontStyle)null, var230, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, var73_1, 200064, 0, 131026);
                  Modifier var266 = (Modifier)Modifier.Companion;
                  int var87 = 8;
                  int var239 = 0;
                  SpacerKt.Spacer(SizeKt.width-3ABfNKs(var266, Dp.constructor-impl((float)var87)), var73_1, 6);
                  var244 = TextUnitKt.getSp(14);
                  long var241 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(var73_1, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
                  TextKt.Text--4IGK_g(var170, (Modifier)null, var241, var244, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, var73_1, 3072, 0, 131058);
                  ComposerKt.sourceInformationMarkerEnd(var73_1);
                  ComposerKt.sourceInformationMarkerEnd(var73_1);
                  var73_1.endNode();
                  ComposerKt.sourceInformationMarkerEnd(var73_1);
                  ComposerKt.sourceInformationMarkerEnd(var73_1);
                  ComposerKt.sourceInformationMarkerEnd(var73_1);
                  var73_1.endReplaceGroup();
               } else {
                  var73_1.startReplaceGroup(615770359);
                  ComposerKt.sourceInformation(var73_1, "");
                  if (!StringsKt.isBlank((CharSequence)var42)) {
                     var73_1.startReplaceGroup(615813046);
                     ComposerKt.sourceInformation(var73_1, "402@16543L11,399@16400L353");
                     long var102 = TextUnitKt.getSp(14);
                     long var104 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(var73_1, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
                     long var106 = TextUnitKt.getSp(20);
                     Modifier var267 = (Modifier)Modifier.Companion;
                     int var148 = 4;
                     int var158 = 0;
                     float var274 = Dp.constructor-impl((float)var148);
                     var148 = 2;
                     var158 = 0;
                     Modifier var143 = PaddingKt.padding-VpY3zN4(var267, var274, Dp.constructor-impl((float)var148));
                     TextKt.Text--4IGK_g(var42, var143, var104, var102, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, var106, 0, false, 0, 0, (Function1)null, (TextStyle)null, var73_1, 3120, 6, 130032);
                     var73_1.endReplaceGroup();
                  } else {
                     var73_1.startReplaceGroup(599556615);
                     var73_1.endReplaceGroup();
                  }

                  var73_1.endReplaceGroup();
               }
            } else {
               var73_1.startReplaceGroup(614192428);
               ComposerKt.sourceInformation(var73_1, "367@14754L627");
               Alignment.Vertical var123 = Alignment.Companion.getTop();
               Modifier var258 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
               int var167 = 8;
               int var127 = 0;
               float var272 = Dp.constructor-impl((float)var167);
               var167 = 2;
               var127 = 0;
               Modifier var169 = PaddingKt.padding-VpY3zN4(var258, var272, Dp.constructor-impl((float)var167));
               short var139 = 390;
               int var147 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
               Arrangement.Horizontal var129 = Arrangement.INSTANCE.getStart();
               MeasurePolicy var157 = RowKt.rowMeasurePolicy(var129, var123, var73_1, 14 & var139 >> 3 | 112 & var139 >> 3);
               int var162 = 112 & var139 << 3;
               int var172 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
               int var175 = ComposablesKt.getCurrentCompositeKeyHash(var73_1, 0);
               CompositionLocalMap var178 = var73_1.getCurrentCompositionLocalMap();
               Modifier var181 = ComposedModifierKt.materializeModifier(var73_1, var169);
               Function0 var184 = ComposeUiNode.Companion.getConstructor();
               int var187 = 6 | 896 & var162 << 6;
               int var190 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
               if (!(var73_1.getApplier() instanceof Applier)) {
                  ComposablesKt.invalidApplier();
               }

               var73_1.startReusableNode();
               if (var73_1.getInserting()) {
                  var73_1.createNode(var184);
               } else {
                  var73_1.useNode();
               }

               Composer var193 = Updater.constructor-impl(var73_1);
               int var196 = 0;
               Updater.set-impl(var193, var157, ComposeUiNode.Companion.getSetMeasurePolicy());
               Updater.set-impl(var193, var178, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
               Function2 var199 = ComposeUiNode.Companion.getSetCompositeKeyHash();
               int var202 = 0;
               int var205 = 0;
               if (var193.getInserting() || !Intrinsics.areEqual(var193.rememberedValue(), var175)) {
                  var193.updateRememberedValue(var175);
                  var193.apply(var175, var199);
               }

               Updater.set-impl(var193, var181, ComposeUiNode.Companion.getSetModifier());
               int var208 = 14 & var187 >> 6;
               int var211 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, -407840262, "C101@5126L9:Row.kt#2w3rfo");
               int var214 = 6 | 112 & var139 >> 6;
               RowScope var259 = (RowScope)RowScopeInstance.INSTANCE;
               int var217 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, -476869474, "C371@14969L76,372@15070L39,376@15290L11,373@15134L225:OtherScreens.kt#to5c3");
               long var93 = TextUnitKt.getSp(14);
               FontWeight var222 = FontWeight.Companion.getBold();
               long var95 = ColorKt.getIndigo600();
               TextKt.Text--4IGK_g("•", (Modifier)null, var95, var93, (FontStyle)null, var222, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, var73_1, 200070, 0, 131026);
               Modifier var260 = (Modifier)Modifier.Companion;
               int var228 = 8;
               int var232 = 0;
               SpacerKt.Spacer(SizeKt.width-3ABfNKs(var260, Dp.constructor-impl((float)var228)), var73_1, 6);
               String var261 = var42.substring(2);
               Intrinsics.checkNotNullExpressionValue(var261, "substring(...)");
               String var229 = var261;
               long var97 = TextUnitKt.getSp(14);
               var95 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(var73_1, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
               TextKt.Text--4IGK_g(var229, (Modifier)null, var95, var97, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, var73_1, 3072, 0, 131058);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               var73_1.endNode();
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               var73_1.endReplaceGroup();
            }
         }

         var73_1.endReplaceGroup();
         if (!expanded && lines.size() > 2) {
            var73_1.startReplaceGroup(-1273873889);
            ComposerKt.sourceInformation(var73_1, "411@16873L246");
            long var108 = TextUnitKt.getSp(12);
            FontWeight var117 = FontWeight.Companion.getBold();
            long var110 = ColorKt.getIndigo600();
            Modifier var268 = (Modifier)Modifier.Companion;
            int var119 = 4;
            int var43 = 0;
            float var275 = Dp.constructor-impl((float)var119);
            var119 = 2;
            var43 = 0;
            Modifier var118 = PaddingKt.padding-VpY3zN4(var268, var275, Dp.constructor-impl((float)var119));
            TextKt.Text--4IGK_g("Show more...", var118, var110, var108, (FontStyle)null, var117, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, var73_1, 200118, 0, 131024);
            var73_1.endReplaceGroup();
         } else {
            var73_1.startReplaceGroup(-1290607379);
            var73_1.endReplaceGroup();
         }

         ComposerKt.sourceInformationMarkerEnd(var73_1);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var113 = $composer.endRestartGroup();
      if (var113 != null) {
         var113.updateScope(OtherScreensKt::NoteContentWithChecklist$lambda$78);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void NoteCard(@NotNull NoteEntity note, @NotNull NotesViewModel viewModel, @NotNull Function0 onDelete, @NotNull Function0 onDoubleClick, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(note, "note");
      Intrinsics.checkNotNullParameter(viewModel, "viewModel");
      Intrinsics.checkNotNullParameter(onDelete, "onDelete");
      Intrinsics.checkNotNullParameter(onDoubleClick, "onDoubleClick");
      $composer = $composer.startRestartGroup(1897799230);
      ComposerKt.sourceInformation($composer, "C(NoteCard)P(!1,3)424@17280L34,425@17332L18,428@17385L24,431@17499L4105,427@17356L4248:OtherScreens.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(note) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(viewModel) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(onDelete) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(onDoubleClick) ? 2048 : 1024;
      }

      if (($dirty & 1171) == 1170 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1897799230, $dirty, -1, "com.example.NoteCard (OtherScreens.kt:423)");
         }

         ComposerKt.sourceInformationMarkerStart($composer, -1576036224, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var10 = false;
         int var11 = 0;
         Object var12 = $composer.rememberedValue();
         int var13 = 0;
         Object var10000;
         if (var12 == Composer.Companion.getEmpty()) {
            int var14 = 0;
            Object var27 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var27);
            var10000 = var27;
         } else {
            var10000 = var12;
         }

         MutableState var8 = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableState expanded$delegate = var8;
         boolean isDark = ThemeKt.isAppInDarkTheme($composer, 0);
         Modifier var29 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Object var10001 = null;
         Object var10002 = null;
         ComposerKt.sourceInformationMarkerStart($composer, -1576032874, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var25 = false;
         var13 = 0;
         Object var28 = $composer.rememberedValue();
         int var15 = 0;
         Object var10003;
         if (var28 == Composer.Companion.getEmpty()) {
            Object var20 = null;
            Object var19 = null;
            Modifier var18 = var29;
            int var16 = 0;
            Function0 var17_1 = OtherScreensKt::NoteCard$lambda$83$lambda$82;
            var29 = var18;
            var10001 = var19;
            var10002 = var20;
            $composer.updateRememberedValue(var17_1);
            var10003 = var17_1;
         } else {
            var10003 = var28;
         }

         Function0 var24 = (Function0)var10003;
         ComposerKt.sourceInformationMarkerEnd($composer);
         GlassCard-dgCr-O4(var29, (BorderStroke)var10001, (Color)var10002, var24, onDoubleClick, (Function3)ComposableLambdaKt.rememberComposableLambda(459541874, true, OtherScreensKt::NoteCard$lambda$95, $composer, 54), $composer, 199686 | '\ue000' & $dirty << 3, 6);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var30 = $composer.endRestartGroup();
      if (var30 != null) {
         var30.updateScope(OtherScreensKt::NoteCard$lambda$96);
      }

   }

   @Composable
   @ComposableInferredTarget(
      scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]"
   )
   public static final void NoteOptionRow_oC9nPe0/* $FF was: NoteOptionRow-oC9nPe0*/(@NotNull ImageVector icon, long iconTint, @NotNull String title, @NotNull String subtitle, boolean checked, @NotNull Function1 onCheckedChange, @Nullable Function2 content, @Nullable Composer $composer, int $changed, int var10) {
      Intrinsics.checkNotNullParameter(icon, "icon");
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(subtitle, "subtitle");
      Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
      $composer = $composer.startRestartGroup(-365834274);
      ComposerKt.sourceInformation($composer, "C(NoteOptionRow)P(2,3:c#ui.graphics.Color,6,5!1,4)524@21853L18,525@21876L2045:OtherScreens.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(icon) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changed(iconTint) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changed(title) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changed(subtitle) ? 2048 : 1024;
      }

      if (($changed & 24576) == 0) {
         $dirty |= $composer.changed(checked) ? 16384 : 8192;
      }

      if (($changed & 196608) == 0) {
         $dirty |= $composer.changedInstance(onCheckedChange) ? 131072 : 65536;
      }

      if ((var10 & 64) != 0) {
         $dirty |= 1572864;
      } else if (($changed & 1572864) == 0) {
         $dirty |= $composer.changedInstance(content) ? 1048576 : 524288;
      }

      if (($dirty & 599187) == 599186 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if ((var10 & 64) != 0) {
            content = null;
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-365834274, $dirty, -1, "com.example.NoteOptionRow (OtherScreens.kt:523)");
         }

         boolean isDark = ThemeKt.isAppInDarkTheme($composer, 0);
         Modifier var10000 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         long var10001 = isDark ? Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.05F, 0.0F, 0.0F, 0.0F, 14, (Object)null) : Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.02F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         int var13 = 16;
         int var14 = 0;
         var10000 = BackgroundKt.background-bw27NRU(var10000, var10001, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var13)));
         var13 = 12;
         var14 = 0;
         Modifier var141 = PaddingKt.padding-3ABfNKs(var10000, Dp.constructor-impl((float)var13));
         byte var17 = 0;
         int var18 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var143 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var15 = Alignment.Companion.getStart();
         MeasurePolicy var19 = ColumnKt.columnMeasurePolicy(var143, var15, $composer, 14 & var17 >> 3 | 112 & var17 >> 3);
         int var20 = 112 & var17 << 3;
         int var21 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var22 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var23 = $composer.getCurrentCompositionLocalMap();
         Modifier var24 = ComposedModifierKt.materializeModifier($composer, var141);
         Function0 var25 = ComposeUiNode.Companion.getConstructor();
         int var26 = 6 | 896 & var20 << 6;
         int var27 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var25);
         } else {
            $composer.useNode();
         }

         Composer var28 = Updater.constructor-impl($composer);
         int var29 = 0;
         Updater.set-impl(var28, var19, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var28, var23, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var30 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var31 = 0;
         int var33 = 0;
         if (var28.getInserting() || !Intrinsics.areEqual(var28.rememberedValue(), var22)) {
            var28.updateRememberedValue(var22);
            var28.apply(var22, var30);
         }

         Updater.set-impl(var28, var24, ComposeUiNode.Companion.getSetModifier());
         int var34 = 14 & var26 >> 6;
         int var36 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var37 = 6 | 112 & var17 >> 6;
         ColumnScope var175 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var40 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1593646871, "C534@22163L1625:OtherScreens.kt#to5c3");
         Modifier var41 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Alignment.Vertical var42 = Alignment.Companion.getCenterVertically();
         Arrangement.HorizontalOrVertical var43 = Arrangement.INSTANCE.getSpaceBetween();
         Arrangement.Horizontal var45 = (Arrangement.Horizontal)var43;
         short var48 = 438;
         int var49 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         MeasurePolicy var50 = RowKt.rowMeasurePolicy(var45, var42, $composer, 14 & var48 >> 3 | 112 & var48 >> 3);
         int var51 = 112 & var48 << 3;
         int var52 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var53 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var54 = $composer.getCurrentCompositionLocalMap();
         Modifier var55 = ComposedModifierKt.materializeModifier($composer, var41);
         Function0 var56 = ComposeUiNode.Companion.getConstructor();
         int var57 = 6 | 896 & var51 << 6;
         int var58 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var56);
         } else {
            $composer.useNode();
         }

         Composer var59 = Updater.constructor-impl($composer);
         int var60 = 0;
         Updater.set-impl(var59, var50, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var59, var54, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var61 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var62 = 0;
         int var64 = 0;
         if (var59.getInserting() || !Intrinsics.areEqual(var59.rememberedValue(), var53)) {
            var59.updateRememberedValue(var53);
            var59.apply(var53, var61);
         }

         Updater.set-impl(var59, var55, ComposeUiNode.Companion.getSetModifier());
         int var65 = 14 & var57 >> 6;
         int var67 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var68 = 6 | 112 & var48 >> 6;
         RowScope var70 = (RowScope)RowScopeInstance.INSTANCE;
         int var71 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 89395490, "C539@22361L1128,570@23636L128,567@23502L276:OtherScreens.kt#to5c3");
         Modifier var72 = RowScope.weight$default(var70, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         Alignment.Vertical var73 = Alignment.Companion.getCenterVertically();
         short var75 = 384;
         int var76 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var77 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var78 = RowKt.rowMeasurePolicy(var77, var73, $composer, 14 & var75 >> 3 | 112 & var75 >> 3);
         int var79 = 112 & var75 << 3;
         int var80 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var81 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var82 = $composer.getCurrentCompositionLocalMap();
         Modifier var83 = ComposedModifierKt.materializeModifier($composer, var72);
         Function0 var84 = ComposeUiNode.Companion.getConstructor();
         int var85 = 6 | 896 & var79 << 6;
         int var86 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var84);
         } else {
            $composer.useNode();
         }

         Composer var87 = Updater.constructor-impl($composer);
         int var88 = 0;
         Updater.set-impl(var87, var78, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var87, var82, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var89 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var90 = 0;
         int var92 = 0;
         if (var87.getInserting() || !Intrinsics.areEqual(var87.rememberedValue(), var81)) {
            var87.updateRememberedValue(var81);
            var87.apply(var81, var89);
         }

         Updater.set-impl(var87, var83, ComposeUiNode.Companion.getSetModifier());
         int var93 = 14 & var85 >> 6;
         int var95 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var96 = 6 | 112 & var75 >> 6;
         RowScope var176 = (RowScope)RowScopeInstance.INSTANCE;
         int var99 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1147921441, "C543@22509L392,552@22918L40,553@22975L500:OtherScreens.kt#to5c3");
         Modifier var177 = (Modifier)Modifier.Companion;
         int var100 = 40;
         int var101 = 0;
         Modifier var146 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(var177, Dp.constructor-impl((float)var100)), (Shape)RoundedCornerShapeKt.getCircleShape()), Color.copy-wmQWz5c$default(iconTint, 0.1F, 0.0F, 0.0F, 0.0F, 14, (Object)null), (Shape)null, 2, (Object)null);
         Alignment var149 = Alignment.Companion.getCenter();
         byte var103 = 48;
         int var104 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         boolean var105 = false;
         MeasurePolicy var106 = BoxKt.maybeCachedBoxMeasurePolicy(var149, var105);
         int var107 = 112 & var103 << 3;
         int var108 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var109 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var110 = $composer.getCurrentCompositionLocalMap();
         Modifier var111 = ComposedModifierKt.materializeModifier($composer, var146);
         Function0 var112 = ComposeUiNode.Companion.getConstructor();
         int var113 = 6 | 896 & var107 << 6;
         int var114 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var112);
         } else {
            $composer.useNode();
         }

         Composer var115 = Updater.constructor-impl($composer);
         int var116 = 0;
         Updater.set-impl(var115, var106, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var115, var110, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var117 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var118 = 0;
         int var120 = 0;
         if (var115.getInserting() || !Intrinsics.areEqual(var115.rememberedValue(), var109)) {
            var115.updateRememberedValue(var109);
            var115.apply(var109, var117);
         }

         Updater.set-impl(var115, var111, ComposeUiNode.Companion.getSetModifier());
         int var121 = 14 & var113 >> 6;
         int var123 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         int var124 = 6 | 112 & var103 >> 6;
         BoxScope var178 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var127 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 763629674, "C550@22796L87:OtherScreens.kt#to5c3");
         Modifier var179 = (Modifier)Modifier.Companion;
         int var128 = 20;
         int var129 = 0;
         Modifier var130 = SizeKt.size-3ABfNKs(var179, Dp.constructor-impl((float)var128));
         IconKt.Icon-ww6aTOc(icon, (String)null, var130, iconTint, $composer, 432 | 14 & $dirty | 7168 & $dirty << 6, 0);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         var179 = (Modifier)Modifier.Companion;
         int var147 = 12;
         int var150 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var179, Dp.constructor-impl((float)var147)), $composer, 6);
         var103 = 0;
         var104 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Modifier var148 = (Modifier)Modifier.Companion;
         Arrangement.Vertical var151 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var154 = Alignment.Companion.getStart();
         var106 = ColumnKt.columnMeasurePolicy(var151, var154, $composer, 14 & var103 >> 3 | 112 & var103 >> 3);
         var107 = 112 & var103 << 3;
         var108 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var109 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var110 = $composer.getCurrentCompositionLocalMap();
         var111 = ComposedModifierKt.materializeModifier($composer, var148);
         var112 = ComposeUiNode.Companion.getConstructor();
         var113 = 6 | 896 & var107 << 6;
         var114 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var112);
         } else {
            $composer.useNode();
         }

         var115 = Updater.constructor-impl($composer);
         var116 = 0;
         Updater.set-impl(var115, var106, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var115, var110, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var117 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var118 = 0;
         var120 = 0;
         if (var115.getInserting() || !Intrinsics.areEqual(var115.rememberedValue(), var109)) {
            var115.updateRememberedValue(var109);
            var115.apply(var109, var117);
         }

         Updater.set-impl(var115, var111, ComposeUiNode.Companion.getSetModifier());
         var121 = 14 & var113 >> 6;
         var123 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         var124 = 6 | 112 & var103 >> 6;
         ColumnScope var181 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         var127 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -362960308, "C558@23190L11,554@23004L232,563@23392L11,560@23257L200:OtherScreens.kt#to5c3");
         FontWeight var173 = FontWeight.Companion.getBold();
         long var131 = TextUnitKt.getSp(14);
         long var133 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g(title, (Modifier)null, var133, var131, (FontStyle)null, var173, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680 | 14 & $dirty >> 6, 0, 131026);
         long var135 = TextUnitKt.getSp(11);
         long var137 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         TextKt.Text--4IGK_g(subtitle, (Modifier)null, var137, var135, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3072 | 14 & $dirty >> 9, 0, 131058);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         SwitchKt.Switch(checked, onCheckedChange, (Modifier)null, (Function2)null, false, SwitchDefaults.INSTANCE.colors-V1nXRL4(Color.Companion.getWhite-0d7_KjU(), ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 54, SwitchDefaults.$stable << 18, 65532), (MutableInteractionSource)null, $composer, 14 & $dirty >> 12 | 112 & $dirty >> 12, 92);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         if (checked && content != null) {
            $composer.startReplaceGroup(1595247896);
            ComposerKt.sourceInformation($composer, "577@23843L40,578@23896L9");
            Modifier var182 = (Modifier)Modifier.Companion;
            int var144 = 8;
            int var145 = 0;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(var182, Dp.constructor-impl((float)var144)), $composer, 6);
            content.invoke($composer, 14 & $dirty >> 18);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(1571605870);
            $composer.endReplaceGroup();
         }

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

      ScopeUpdateScope var183 = $composer.endRestartGroup();
      if (var183 != null) {
         var183.updateScope(OtherScreensKt::NoteOptionRow_oC9nPe0$lambda$102);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void DetailedAddNoteDialog(@NotNull List meetings, @NotNull Function0 onDismiss, @NotNull Function5 onAdd, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(meetings, "meetings");
      Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
      Intrinsics.checkNotNullParameter(onAdd, "onAdd");
      $composer = $composer.startRestartGroup(-1949295446);
      ComposerKt.sourceInformation($composer, "C(DetailedAddNoteDialog)P(!1,2)589@24111L31,590@24162L31,591@24215L34,592@24275L34,593@24333L34,595@24396L47,596@24468L40,598@24541L7,600@24591L11708,600@24554L11745:OtherScreens.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changedInstance(meetings) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(onDismiss) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(onAdd) ? 256 : 128;
      }

      if (($dirty & 147) == 146 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1949295446, $dirty, -1, "com.example.DetailedAddNoteDialog (OtherScreens.kt:588)");
         }

         ComposerKt.sourceInformationMarkerStart($composer, -667176567, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var9 = false;
         int var10 = 0;
         Object var11 = $composer.rememberedValue();
         int var12 = 0;
         Object var10000;
         if (var11 == Composer.Companion.getEmpty()) {
            int var13 = 0;
            Object var37 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var37);
            var10000 = var37;
         } else {
            var10000 = var11;
         }

         MutableState content$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableState title$delegate = content$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, -667174935, "CC(remember):OtherScreens.kt#9igjgp");
         var10 = 0;
         int var28 = 0;
         Object var32 = $composer.rememberedValue();
         int var38 = 0;
         if (var32 == Composer.Companion.getEmpty()) {
            int var14 = 0;
            Object var44 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var44);
            var10000 = var44;
         } else {
            var10000 = var32;
         }

         MutableState linkToday$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         content$delegate = linkToday$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, -667173236, "CC(remember):OtherScreens.kt#9igjgp");
         var28 = 0;
         int var33 = 0;
         Object var39 = $composer.rememberedValue();
         int var45 = 0;
         if (var39 == Composer.Companion.getEmpty()) {
            int var15 = 0;
            Object var50 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var50);
            var10000 = var50;
         } else {
            var10000 = var39;
         }

         MutableState attachMeeting$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         linkToday$delegate = attachMeeting$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, -667171316, "CC(remember):OtherScreens.kt#9igjgp");
         var33 = 0;
         int var40 = 0;
         Object var46 = $composer.rememberedValue();
         int var51 = 0;
         if (var46 == Composer.Companion.getEmpty()) {
            int var16 = 0;
            Object var55 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var55);
            var10000 = var55;
         } else {
            var10000 = var46;
         }

         MutableState hasReminder$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         attachMeeting$delegate = hasReminder$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, -667169460, "CC(remember):OtherScreens.kt#9igjgp");
         var40 = 0;
         int var47 = 0;
         Object var52 = $composer.rememberedValue();
         int var56 = 0;
         if (var52 == Composer.Companion.getEmpty()) {
            int var17 = 0;
            Object var60 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var60);
            var10000 = var60;
         } else {
            var10000 = var52;
         }

         MutableState selectedMeeting$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         hasReminder$delegate = selectedMeeting$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, -667167431, "CC(remember):OtherScreens.kt#9igjgp");
         var47 = 0;
         int var53 = 0;
         Object var57 = $composer.rememberedValue();
         int var61 = 0;
         if (var57 == Composer.Companion.getEmpty()) {
            int var18 = 0;
            Object var64 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var64);
            var10000 = var64;
         } else {
            var10000 = var57;
         }

         MutableState reminderTime$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         selectedMeeting$delegate = reminderTime$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, -667165134, "CC(remember):OtherScreens.kt#9igjgp");
         var53 = 0;
         int var58 = 0;
         Object var62 = $composer.rememberedValue();
         int var65 = 0;
         if (var62 == Composer.Companion.getEmpty()) {
            int var19 = 0;
            Object var67 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var67);
            var10000 = var67;
         } else {
            var10000 = var62;
         }

         MutableState var42 = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         reminderTime$delegate = var42;
         CompositionLocal var49 = (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext();
         var58 = 0;
         int var63 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
         Object var66 = $composer.consume(var49);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Context context = (Context)var66;
         AndroidDialog_androidKt.Dialog(onDismiss, (DialogProperties)null, (Function2)ComposableLambdaKt.rememberComposableLambda(-631751885, true, OtherScreensKt::DetailedAddNoteDialog$lambda$169, $composer, 54), $composer, 384 | 14 & $dirty >> 3, 2);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var74 = $composer.endRestartGroup();
      if (var74 != null) {
         var74.updateScope(OtherScreensKt::DetailedAddNoteDialog$lambda$170);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void DetailedEditNoteDialog(@NotNull final NoteEntity note, @NotNull final List meetings, @NotNull Function0 onDismiss, @NotNull Function5 onSave, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(note, "note");
      Intrinsics.checkNotNullParameter(meetings, "meetings");
      Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
      Intrinsics.checkNotNullParameter(onSave, "onSave");
      $composer = $composer.startRestartGroup(131716240);
      ComposerKt.sourceInformation($composer, "C(DetailedEditNoteDialog)P(1)854@36513L39,855@36572L41,856@36635L52,857@36713L66,858@36803L54,860@36886L124,865@37035L53,867@37119L175,867@37094L200,873@37327L7,875@37377L11707,875@37340L11744:OtherScreens.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(note) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(meetings) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(onDismiss) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(onSave) ? 2048 : 1024;
      }

      if (($dirty & 1171) == 1170 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(131716240, $dirty, -1, "com.example.DetailedEditNoteDialog (OtherScreens.kt:853)");
         }

         ComposerKt.sourceInformationMarkerStart($composer, 2025261815, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var10 = false;
         int var11 = 0;
         Object var12 = $composer.rememberedValue();
         int var13 = 0;
         Object var10000;
         if (var12 == Composer.Companion.getEmpty()) {
            int var14 = 0;
            Object var15 = SnapshotStateKt.mutableStateOf$default(note.getTitle(), (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var15);
            var10000 = var15;
         } else {
            var10000 = var12;
         }

         MutableState content$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableState title$delegate = content$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2025263705, "CC(remember):OtherScreens.kt#9igjgp");
         var11 = 0;
         int var35 = 0;
         Object var39 = $composer.rememberedValue();
         int var44 = 0;
         if (var39 == Composer.Companion.getEmpty()) {
            int var51 = 0;
            Object var16 = SnapshotStateKt.mutableStateOf$default(note.getContent(), (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var16);
            var10000 = var16;
         } else {
            var10000 = var39;
         }

         MutableState linkToday$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         content$delegate = linkToday$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2025265732, "CC(remember):OtherScreens.kt#9igjgp");
         var35 = 0;
         int var40 = 0;
         Object var45 = $composer.rememberedValue();
         int var52 = 0;
         if (var45 == Composer.Companion.getEmpty()) {
            int var57 = 0;
            Object var17 = SnapshotStateKt.mutableStateOf$default(note.getLinkedDate() != null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var17);
            var10000 = var17;
         } else {
            var10000 = var45;
         }

         MutableState attachMeeting$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         linkToday$delegate = attachMeeting$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2025268242, "CC(remember):OtherScreens.kt#9igjgp");
         var40 = 0;
         int var46 = 0;
         Object var53 = $composer.rememberedValue();
         int var58 = 0;
         if (var53 != Composer.Companion.getEmpty()) {
            var10000 = var53;
         } else {
            int var63 = 0;
            CharSequence var18 = (CharSequence)note.getLinkedMeetingId();
            Object var19 = SnapshotStateKt.mutableStateOf$default(var18 != null && var18.length() != 0, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var19);
            var10000 = var19;
         }

         MutableState hasReminder$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         attachMeeting$delegate = hasReminder$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2025271110, "CC(remember):OtherScreens.kt#9igjgp");
         var46 = 0;
         int var54 = 0;
         Object var59 = $composer.rememberedValue();
         int var64 = 0;
         if (var59 == Composer.Companion.getEmpty()) {
            int var69 = 0;
            Object var74 = SnapshotStateKt.mutableStateOf$default(note.getReminderTime() != null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var74);
            var10000 = var74;
         } else {
            var10000 = var59;
         }

         final MutableState selectedMeeting$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         hasReminder$delegate = selectedMeeting$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2025273836, "CC(remember):OtherScreens.kt#9igjgp");
         var54 = 0;
         int var60 = 0;
         Object var65 = $composer.rememberedValue();
         int var70 = 0;
         if (var65 != Composer.Companion.getEmpty()) {
            var10000 = var65;
         } else {
            int var75 = 0;
            Iterable var20 = (Iterable)meetings;
            Iterator var21 = var20.iterator();

            while(true) {
               if (var21.hasNext()) {
                  Object var22 = var21.next();
                  MeetingItem var23 = (MeetingItem)var22;
                  int var24 = 0;
                  if (!Intrinsics.areEqual(var23.getId(), note.getLinkedMeetingId())) {
                     continue;
                  }

                  var10000 = var22;
                  break;
               }

               var10000 = null;
               break;
            }

            Object var25 = SnapshotStateKt.mutableStateOf$default(var10000, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var25);
            var10000 = var25;
         }

         MutableState reminderTime$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         selectedMeeting$delegate = reminderTime$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2025278533, "CC(remember):OtherScreens.kt#9igjgp");
         var60 = 0;
         int var66 = 0;
         Object var71 = $composer.rememberedValue();
         int var76 = 0;
         if (var71 == Composer.Companion.getEmpty()) {
            int var79 = 0;
            Object var81 = SnapshotStateKt.mutableStateOf$default(note.getReminderTime(), (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var81);
            var10000 = var81;
         } else {
            var10000 = var71;
         }

         MutableState var48 = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         reminderTime$delegate = var48;
         List var90 = meetings;
         ComposerKt.sourceInformationMarkerStart($composer, 2025281343, "CC(remember):OtherScreens.kt#9igjgp");
         var60 = ($dirty & 14) == 4 | $composer.changedInstance(meetings);
         var66 = 0;
         var71 = $composer.rememberedValue();
         var76 = 0;
         Object var92;
         if (!var60 && var71 != Composer.Companion.getEmpty()) {
            var92 = var71;
         } else {
            int var80 = 0;
            Function2 var10001 = new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        if (OtherScreensKt.DetailedEditNoteDialog$lambda$188(selectedMeeting$delegate) == null) {
                           CharSequence var2 = (CharSequence)note.getLinkedMeetingId();
                           if (var2 != null && var2.length() != 0) {
                              Iterable var10 = (Iterable)meetings;
                              NoteEntity var3 = note;
                              MutableState var9 = selectedMeeting$delegate;
                              Iterator var5 = var10.iterator();

                              Object var10000;
                              while(true) {
                                 if (!var5.hasNext()) {
                                    var10000 = null;
                                    break;
                                 }

                                 Object var6 = var5.next();
                                 MeetingItem var7 = (MeetingItem)var6;
                                 int var8 = 0;
                                 if (Intrinsics.areEqual(var7.getId(), var3.getLinkedMeetingId())) {
                                    var10000 = var6;
                                    break;
                                 }
                              }

                              OtherScreensKt.DetailedEditNoteDialog$lambda$189(var9, (MeetingItem)var10000);
                           }
                        }

                        return Unit.INSTANCE;
                     default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }

               public final Continuation create(Object value, Continuation $completion) {
                  return (Continuation)(new <anonymous constructor>($completion));
               }

               public final Object invoke(CoroutineScope p1, Continuation p2) {
                  return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
               }
            };
            var90 = meetings;
            Object var82 = var10001;
            $composer.updateRememberedValue(var82);
            var92 = var82;
         }

         Function2 context = (Function2)var92;
         ComposerKt.sourceInformationMarkerEnd($composer);
         EffectsKt.LaunchedEffect(var90, context, $composer, 14 & $dirty >> 3);
         CompositionLocal var56 = (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext();
         var66 = 0;
         int var73 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
         Object var78 = $composer.consume(var56);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Context context = (Context)var78;
         AndroidDialog_androidKt.Dialog(onDismiss, (DialogProperties)null, (Function2)ComposableLambdaKt.rememberComposableLambda(-918327911, true, OtherScreensKt::DetailedEditNoteDialog$lambda$239, $composer, 54), $composer, 384 | 14 & $dirty >> 6, 2);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var91 = $composer.endRestartGroup();
      if (var91 != null) {
         var91.updateScope(OtherScreensKt::DetailedEditNoteDialog$lambda$240);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void DeleteConfirmationDialog(@Nullable String title, @Nullable String message, @NotNull Function0 onDismiss, @NotNull Function0 onConfirm, @Nullable Composer $composer, int $changed, int var6) {
      Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
      Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
      $composer = $composer.startRestartGroup(-1884618058);
      ComposerKt.sourceInformation($composer, "C(DeleteConfirmationDialog)P(3!1,2)1146@50042L246,1154@50314L264,1131@49394L494,1143@49905L111,1129@49327L1257:OtherScreens.kt#to5c3");
      int $dirty = $changed;
      if ((var6 & 1) != 0) {
         $dirty = $changed | 6;
      } else if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(title) ? 4 : 2);
      }

      if ((var6 & 2) != 0) {
         $dirty |= 48;
      } else if (($changed & 48) == 0) {
         $dirty |= $composer.changed(message) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(onDismiss) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(onConfirm) ? 2048 : 1024;
      }

      if (($dirty & 1171) == 1170 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if ((var6 & 1) != 0) {
            title = "Confirm Delete";
         }

         if ((var6 & 2) != 0) {
            message = "Are you sure you want to delete this item? This action cannot be undone.";
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1884618058, $dirty, -1, "com.example.DeleteConfirmationDialog (OtherScreens.kt:1128)");
         }

         AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(onDismiss, (Function2)ComposableLambdaKt.rememberComposableLambda(-820115714, true, OtherScreensKt::DeleteConfirmationDialog$lambda$241, $composer, 54), (Modifier)null, (Function2)ComposableLambdaKt.rememberComposableLambda(41717888, true, OtherScreensKt::DeleteConfirmationDialog$lambda$242, $composer, 54), (Function2)null, (Function2)ComposableLambdaKt.rememberComposableLambda(903551490, true, OtherScreensKt::DeleteConfirmationDialog$lambda$244, $composer, 54), (Function2)ComposableLambdaKt.rememberComposableLambda(1334468291, true, OtherScreensKt::DeleteConfirmationDialog$lambda$245, $composer, 54), (Shape)null, 0L, 0L, 0L, 0L, 0.0F, (DialogProperties)null, $composer, 1772592 | 14 & $dirty >> 6, 0, 16276);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var10000 = $composer.endRestartGroup();
      if (var10000 != null) {
         var10000.updateScope(OtherScreensKt::DeleteConfirmationDialog$lambda$246);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void SyncScreen(@NotNull PlannerViewModel plannerViewModel, @NotNull NotesViewModel notesViewModel, @NotNull CalendarSyncViewModel syncViewModel, @NotNull AuthManager authManager, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(plannerViewModel, "plannerViewModel");
      Intrinsics.checkNotNullParameter(notesViewModel, "notesViewModel");
      Intrinsics.checkNotNullParameter(syncViewModel, "syncViewModel");
      Intrinsics.checkNotNullParameter(authManager, "authManager");
      $composer = $composer.startRestartGroup(1016329542);
      ComposerKt.sourceInformation($composer, "C(SyncScreen)P(2,1,3)1172@50813L29,1173@50889L29,1174@50958L29,1175@51033L29,1176@51114L29,1177@51181L29,1179@51237L50,1180@51309L30,1181@51371L115,1185@51508L71,1187@51585L4404:OtherScreens.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changedInstance(plannerViewModel) ? 4 : 2);
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(syncViewModel) ? 256 : 128;
      }

      if (($dirty & 131) == 130 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1016329542, $dirty, -1, "com.example.SyncScreen (OtherScreens.kt:1171)");
         }

         State tasks$delegate = FlowExtKt.collectAsStateWithLifecycle(plannerViewModel.getTodaysTasks(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State allNotes$delegate = FlowExtKt.collectAsStateWithLifecycle(plannerViewModel.getAllNotes(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State events$delegate = FlowExtKt.collectAsStateWithLifecycle(syncViewModel.getEvents(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State isSyncing$delegate = FlowExtKt.collectAsStateWithLifecycle(syncViewModel.isSyncing(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State lastSyncTime$delegate = FlowExtKt.collectAsStateWithLifecycle(syncViewModel.getLastSyncTime(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State error$delegate = FlowExtKt.collectAsStateWithLifecycle(syncViewModel.getError(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         List var14 = SyncScreen$lambda$247(tasks$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 1735134488, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var17 = $composer.changed(var14);
         int var18 = 0;
         Object var19 = $composer.rememberedValue();
         int var20 = 0;
         Object var125;
         if (!var17 && var19 != Composer.Companion.getEmpty()) {
            var125 = var19;
         } else {
            int var21 = 0;
            Iterable var22 = (Iterable)SyncScreen$lambda$247(tasks$delegate);
            int var23 = 0;
            int var10000;
            if (var22 instanceof Collection && ((Collection)var22).isEmpty()) {
               var10000 = 0;
            } else {
               int var24 = 0;

               for(Object var26 : var22) {
                  TaskEntity var27 = (TaskEntity)var26;
                  int var28 = 0;
                  if (var27.isCompleted()) {
                     ++var24;
                     if (var24 < 0) {
                        CollectionsKt.throwCountOverflow();
                     }
                  }
               }

               var10000 = var24;
            }

            Object var29 = var10000;
            $composer.updateRememberedValue(var29);
            var125 = var29;
         }

         int var15 = ((Number)var125).intValue();
         ComposerKt.sourceInformationMarkerEnd($composer);
         List var81 = SyncScreen$lambda$247(tasks$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 1735136772, "CC(remember):OtherScreens.kt#9igjgp");
         var18 = $composer.changed(var81);
         int var90 = 0;
         Object var94 = $composer.rememberedValue();
         int var97 = 0;
         if (!var18 && var94 != Composer.Companion.getEmpty()) {
            var125 = var94;
         } else {
            int var101 = 0;
            Object var105 = SyncScreen$lambda$247(tasks$delegate).size();
            $composer.updateRememberedValue(var105);
            var125 = var105;
         }

         int completionPercentage = ((Number)var125).intValue();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerStart($composer, 1735138841, "CC(remember):OtherScreens.kt#9igjgp");
         var18 = $composer.changed(var15) | $composer.changed(completionPercentage);
         var90 = 0;
         var94 = $composer.rememberedValue();
         var97 = 0;
         if (!var18 && var94 != Composer.Companion.getEmpty()) {
            var125 = var94;
         } else {
            int var102 = 0;
            Object var106 = completionPercentage > 0 ? var15 * 100 / completionPercentage : 0;
            $composer.updateRememberedValue(var106);
            var125 = var106;
         }

         completionPercentage = ((Number)var125).intValue();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerStart($composer, 1735143181, "CC(remember):OtherScreens.kt#9igjgp");
         var90 = 0;
         int var96 = 0;
         Object var99 = $composer.rememberedValue();
         int var103 = 0;
         if (var99 == Composer.Companion.getEmpty()) {
            int var107 = 0;
            Object var108 = new SimpleDateFormat("MMM d, yyyy HH:mm", Locale.getDefault());
            $composer.updateRememberedValue(var108);
            var125 = var108;
         } else {
            var125 = var99;
         }

         SimpleDateFormat var83 = (SimpleDateFormat)var125;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Modifier var129 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var84 = 24;
         var18 = 0;
         Modifier var85 = PaddingKt.padding-3ABfNKs(var129, Dp.constructor-impl((float)var84));
         byte var100 = 6;
         var103 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var89 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var93 = Alignment.Companion.getStart();
         MeasurePolicy var109 = ColumnKt.columnMeasurePolicy(var89, var93, $composer, 14 & var100 >> 3 | 112 & var100 >> 3);
         int var110 = 112 & var100 << 3;
         int var111 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var112 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var113 = $composer.getCurrentCompositionLocalMap();
         Modifier var114 = ComposedModifierKt.materializeModifier($composer, var85);
         Function0 var115 = ComposeUiNode.Companion.getConstructor();
         int var30 = 6 | 896 & var110 << 6;
         int var31 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var115);
         } else {
            $composer.useNode();
         }

         Composer var32 = Updater.constructor-impl($composer);
         int var33 = 0;
         Updater.set-impl(var32, var109, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var32, var113, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var34 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var35 = 0;
         int var37 = 0;
         if (var32.getInserting() || !Intrinsics.areEqual(var32.rememberedValue(), var112)) {
            var32.updateRememberedValue(var112);
            var32.apply(var112, var34);
         }

         Updater.set-impl(var32, var114, ComposeUiNode.Companion.getSetModifier());
         int var38 = 14 & var30 >> 6;
         int var40 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var41 = 6 | 112 & var100 >> 6;
         ColumnScope var130 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var44 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 2047242704, "C1196@51839L11,1192@51692L220,1199@51921L40,1202@52079L11,1200@51970L192,1206@52172L41,1209@52300L2156,1209@52254L2202,1258@54466L41,1261@54551L1432:OtherScreens.kt#to5c3");
         long var45 = TextUnitKt.getSp(28);
         FontWeight var47 = FontWeight.Companion.getBold();
         long var48 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         long var50 = TextUnitKt.getSp((double)-0.5F);
         TextKt.Text--4IGK_g("Insights & Progress", (Modifier)null, var48, var45, (FontStyle)null, var47, (FontFamily)null, var50, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 130898);
         Modifier var131 = (Modifier)Modifier.Companion;
         int var52 = 8;
         int var53 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var131, Dp.constructor-impl((float)var52)), $composer, 6);
         TextKt.Text--4IGK_g("Track daily task metrics, note counts, and sync logs.", (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.6F, 0.0F, 0.0F, 0.0F, 14, (Object)null), TextUnitKt.getSp(14), (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3078, 0, 131058);
         var131 = (Modifier)Modifier.Companion;
         var52 = 24;
         var53 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var131, Dp.constructor-impl((float)var52)), $composer, 6);
         GlassCard-dgCr-O4(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), (BorderStroke)null, (Color)null, (Function0)null, (Function0)null, (Function3)ComposableLambdaKt.rememberComposableLambda(1026543812, true, OtherScreensKt::SyncScreen$lambda$267$lambda$263, $composer, 54), $composer, 196614, 30);
         var131 = (Modifier)Modifier.Companion;
         var52 = 16;
         var53 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var131, Dp.constructor-impl((float)var52)), $composer, 6);
         Modifier var120 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var53 = 16;
         int var116 = 0;
         Arrangement.Horizontal var124 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var53));
         byte var55 = 54;
         int var56 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Alignment.Vertical var117 = Alignment.Companion.getTop();
         MeasurePolicy var57 = RowKt.rowMeasurePolicy(var124, var117, $composer, 14 & var55 >> 3 | 112 & var55 >> 3);
         int var58 = 112 & var55 << 3;
         int var59 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var60 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var61 = $composer.getCurrentCompositionLocalMap();
         Modifier var62 = ComposedModifierKt.materializeModifier($composer, var120);
         Function0 var63 = ComposeUiNode.Companion.getConstructor();
         int var64 = 6 | 896 & var58 << 6;
         int var65 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var63);
         } else {
            $composer.useNode();
         }

         Composer var66 = Updater.constructor-impl($composer);
         int var67 = 0;
         Updater.set-impl(var66, var57, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var66, var61, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var68 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var69 = 0;
         int var71 = 0;
         if (var66.getInserting() || !Intrinsics.areEqual(var66.rememberedValue(), var60)) {
            var66.updateRememberedValue(var60);
            var66.apply(var60, var68);
         }

         Updater.set-impl(var66, var62, ComposeUiNode.Companion.getSetModifier());
         int var72 = 14 & var64 >> 6;
         int var74 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var75 = 6 | 112 & var55 >> 6;
         RowScope var77 = (RowScope)RowScopeInstance.INSTANCE;
         int var78 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2137999774, "C1266@54778L557,1266@54736L599,1282@55432L541,1282@55390L583:OtherScreens.kt#to5c3");
         GlassCard-dgCr-O4(RowScope.weight$default(var77, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null), (BorderStroke)null, (Color)null, (Function0)null, (Function0)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-1629219872, true, OtherScreensKt::SyncScreen$lambda$267$lambda$266$lambda$264, $composer, 54), $composer, 196608, 30);
         GlassCard-dgCr-O4(RowScope.weight$default(var77, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null), (BorderStroke)null, (Color)null, (Function0)null, (Function0)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-775608631, true, OtherScreensKt::SyncScreen$lambda$267$lambda$266$lambda$265, $composer, 54), $composer, 196608, 30);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
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

      ScopeUpdateScope var134 = $composer.endRestartGroup();
      if (var134 != null) {
         var134.updateScope(OtherScreensKt::SyncScreen$lambda$268);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void SettingsScreen(@NotNull Function0 onSignOut, @NotNull SettingsViewModel settingsViewModel, @NotNull CalendarSyncViewModel syncViewModel, @NotNull AuthManager authManager, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(onSignOut, "onSignOut");
      Intrinsics.checkNotNullParameter(settingsViewModel, "settingsViewModel");
      Intrinsics.checkNotNullParameter(syncViewModel, "syncViewModel");
      Intrinsics.checkNotNullParameter(authManager, "authManager");
      $composer = $composer.startRestartGroup(1353216126);
      ComposerKt.sourceInformation($composer, "C(SettingsScreen)P(1,2,3)1308@56218L29,1309@56315L29,1310@56396L29,1311@56517L29,1312@56626L29,1313@56723L29,1314@56820L29,1315@56881L7,1322@57248L66,1330@57536L19816,1324@57320L20032:OtherScreens.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changedInstance(onSignOut) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(settingsViewModel) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(syncViewModel) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(authManager) ? 2048 : 1024;
      }

      if (($dirty & 1171) == 1170 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1353216126, $dirty, -1, "com.example.SettingsScreen (OtherScreens.kt:1307)");
         }

         State themeMode$delegate = FlowExtKt.collectAsStateWithLifecycle(settingsViewModel.getThemeMode(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State notificationsMuted$delegate = FlowExtKt.collectAsStateWithLifecycle(settingsViewModel.getNotificationsMuted(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State lastSyncTime$delegate = FlowExtKt.collectAsStateWithLifecycle(syncViewModel.getLastSyncTime(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State googleCalendarRemindersEnabled$delegate = FlowExtKt.collectAsStateWithLifecycle(settingsViewModel.getGoogleCalendarRemindersEnabled(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State notificationSoundEnabled$delegate = FlowExtKt.collectAsStateWithLifecycle(settingsViewModel.getNotificationSoundEnabled(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State notificationMelody$delegate = FlowExtKt.collectAsStateWithLifecycle(settingsViewModel.getNotificationMelody(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State notificationVolume$delegate = FlowExtKt.collectAsStateWithLifecycle(settingsViewModel.getNotificationVolume(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         CompositionLocal var15 = (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext();
         int var17 = 0;
         int var18 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
         Object var24_1 = $composer.consume(var15);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Context context = (Context)var24_1;

         FirebaseUser var16;
         try {
            var16 = FirebaseAuth.getInstance().getCurrentUser();
         } catch (Exception var43) {
            var16 = null;
         }

         String var10000;
         label113: {
            firebaseUser = var16;
            if (var16 != null) {
               var10000 = var16.getDisplayName();
               if (var10000 != null) {
                  break label113;
               }
            }

            var10000 = "Pro User";
         }

         label108: {
            name = var10000;
            if (firebaseUser != null) {
               var10000 = firebaseUser.getEmail();
               if (var10000 != null) {
                  break label108;
               }
            }

            var10000 = "user@plannerpro.com";
         }

         String email = var10000;
         CharSequence var72 = (CharSequence)name;
         String[] var24_1 = new String[]{" "};
         Iterable var24_1 = (Iterable)StringsKt.split$default(var72, var24_1, false, 0, 6, (Object)null);
         int var20 = 0;
         Collection var22 = (Collection)(new ArrayList());
         int var23 = 0;
         int var25 = 0;

         for(Object var28_1 : var24_1) {
            label97: {
               int var29 = 0;
               String var30 = (String)var28_1;
               int var31 = 0;
               Character var73 = StringsKt.firstOrNull((CharSequence)var30);
               if (var73 != null) {
                  String var74 = var73.toString();
                  if (var74 != null) {
                     var75 = var74.toUpperCase(Locale.ROOT);
                     Intrinsics.checkNotNullExpressionValue(var75, "toUpperCase(...)");
                     break label97;
                  }
               }

               var75 = null;
            }

            if (var75 != null) {
               Object var32 = var75;
               int var33 = 0;
               var22.add(var32);
            }
         }

         String initials = CollectionsKt.joinToString$default((Iterable)CollectionsKt.take((Iterable)((List)var22), 2), (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null);
         ComposerKt.sourceInformationMarkerStart($composer, -934353376, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var55 = (boolean)0;
         var23 = 0;
         Object var24 = $composer.rememberedValue();
         var25 = 0;
         Object var76;
         if (var24 == Composer.Companion.getEmpty()) {
            int var66 = 0;
            Object var67 = new SimpleDateFormat("MMM d, HH:mm", Locale.getDefault());
            $composer.updateRememberedValue(var67);
            var76 = var67;
         } else {
            var76 = var24;
         }

         SimpleDateFormat var52 = (SimpleDateFormat)var76;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SimpleDateFormat syncFormatter = var52;
         Modifier var77 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var21 = 24;
         var55 = (boolean)0;
         Modifier var53 = PaddingKt.padding-3ABfNKs(var77, Dp.constructor-impl((float)var21));
         var55 = (boolean)24;
         var23 = 0;
         Arrangement.HorizontalOrVertical var54 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var55));
         var23 = 80;
         int var63 = 0;
         PaddingValues var58 = PaddingKt.PaddingValues-a9UjIt4$default(0.0F, 0.0F, 0.0F, Dp.constructor-impl((float)var23), 7, (Object)null);
         var77 = var53;
         Object var10001 = null;
         PaddingValues var10002 = var58;
         boolean var10003 = false;
         Arrangement.Vertical var10004 = (Arrangement.Vertical)var54;
         Object var10005 = null;
         Object var10006 = null;
         boolean var10007 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -934324410, "CC(remember):OtherScreens.kt#9igjgp");
         var25 = $composer.changed(initials) | $composer.changed(name) | $composer.changed(email) | $composer.changed(lastSyncTime$delegate) | $composer.changedInstance(syncFormatter) | $composer.changedInstance(syncViewModel) | $composer.changedInstance(authManager) | $composer.changedInstance(settingsViewModel) | $composer.changed(notificationsMuted$delegate) | $composer.changed(googleCalendarRemindersEnabled$delegate) | $composer.changed(notificationSoundEnabled$delegate) | $composer.changed(notificationMelody$delegate) | $composer.changedInstance(context) | $composer.changed(notificationVolume$delegate) | $composer.changed(themeMode$delegate) | ($dirty & 14) == 4;
         int var68 = 0;
         Object var28_1 = $composer.rememberedValue();
         int var28 = 0;
         Object var10008;
         if (!var25 && var28_1 != Composer.Companion.getEmpty()) {
            var10008 = var28_1;
         } else {
            boolean var41 = false;
            Object var40 = null;
            Object var39 = null;
            Arrangement.Vertical var38 = var10004;
            boolean var37 = false;
            Object var35 = null;
            int var70 = 0;
            Function1 var30_3 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349;
            var77 = var53;
            var10001 = var35;
            var10002 = var58;
            var10003 = var37;
            var10004 = var38;
            var10005 = var39;
            var10006 = var40;
            var10007 = var41;
            $composer.updateRememberedValue(var30_3);
            var10008 = var30_3;
         }

         Function1 var62 = (Function1)var10008;
         ComposerKt.sourceInformationMarkerEnd($composer);
         LazyDslKt.LazyColumn(var77, (LazyListState)var10001, var10002, var10003, var10004, (Alignment.Horizontal)var10005, (FlingBehavior)var10006, var10007, var62, $composer, 24966, 234);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var79 = $composer.endRestartGroup();
      if (var79 != null) {
         var79.updateScope(OtherScreensKt::SettingsScreen$lambda$351);
      }

   }

   private static final Unit GlassCard_dgCr_O4$lambda$1$lambda$0(Function0 $onClick) {
      if ($onClick != null) {
         $onClick.invoke();
      }

      return Unit.INSTANCE;
   }

   private static final Unit GlassCard_dgCr_O4$lambda$3(Modifier $modifier, BorderStroke $border, Color $containerColor, Function0 $onClick, Function0 $onDoubleClick, Function3 $content, int $$changed, int $$default, Composer $composer, int $force) {
      GlassCard-dgCr-O4($modifier, $border, $containerColor, $onClick, $onDoubleClick, $content, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1), $$default);
      return Unit.INSTANCE;
   }

   private static final List NotesScreen$lambda$6(State $notes$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$notes$delegate.getValue();
   }

   private static final List NotesScreen$lambda$7(State $localTasks$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$localTasks$delegate.getValue();
   }

   private static final List NotesScreen$lambda$8(State $googleEvents$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$googleEvents$delegate.getValue();
   }

   private static final int NotesScreen$lambda$10(MutableState $selectedTab$delegate) {
      State var1 = (State)$selectedTab$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return ((Number)var1.getValue()).intValue();
   }

   private static final void NotesScreen$lambda$11(MutableState $selectedTab$delegate, int var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $selectedTab$delegate.setValue(var5);
   }

   private static final boolean NotesScreen$lambda$13(MutableState $showAddNoteDialog$delegate) {
      State var1 = (State)$showAddNoteDialog$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void NotesScreen$lambda$14(MutableState $showAddNoteDialog$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $showAddNoteDialog$delegate.setValue(var5);
   }

   private static final NoteEntity NotesScreen$lambda$16(MutableState $noteToDelete$delegate) {
      State var1 = (State)$noteToDelete$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (NoteEntity)var1.getValue();
   }

   private static final void NotesScreen$lambda$17(MutableState $noteToDelete$delegate, NoteEntity var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $noteToDelete$delegate.setValue(var1);
   }

   private static final NoteEntity NotesScreen$lambda$19(MutableState $editingNote$delegate) {
      State var1 = (State)$editingNote$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (NoteEntity)var1.getValue();
   }

   private static final void NotesScreen$lambda$20(MutableState $editingNote$delegate, NoteEntity var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $editingNote$delegate.setValue(var1);
   }

   private static final Unit NotesScreen$lambda$34$lambda$33$lambda$32(MutableState $showAddNoteDialog$delegate) {
      NotesScreen$lambda$14($showAddNoteDialog$delegate, true);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit NotesScreen$lambda$34(MutableState $showAddNoteDialog$delegate, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C172@6406L28,171@6358L414:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(847910421, $changed, -1, "com.example.NotesScreen.<anonymous> (OtherScreens.kt:171)");
         }

         long var3 = ColorKt.getIndigo600();
         long var5 = Color.Companion.getWhite-0d7_KjU();
         int var8 = 16;
         int var9 = 0;
         RoundedCornerShape var7 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var8));
         Modifier var10000 = (Modifier)Modifier.Companion;
         var9 = 56;
         int var10 = 0;
         Modifier var17 = SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var9));
         ComposerKt.sourceInformationMarkerStart($composer, -1201869647, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var11 = false;
         int var12 = 0;
         Object var13 = $composer.rememberedValue();
         int var14 = 0;
         Object var20;
         if (var13 == Composer.Companion.getEmpty()) {
            int var15 = 0;
            Object var16 = OtherScreensKt::NotesScreen$lambda$34$lambda$33$lambda$32;
            $composer.updateRememberedValue(var16);
            var20 = var16;
         } else {
            var20 = var13;
         }

         Function0 var19 = (Function0)var20;
         ComposerKt.sourceInformationMarkerEnd($composer);
         FloatingActionButtonKt.FloatingActionButton-X-z6DiA(var19, var17, (Shape)var7, var3, var5, (FloatingActionButtonElevation)null, (MutableInteractionSource)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$-1244815465$app(), $composer, 12610614, 96);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit NotesScreen$lambda$48$lambda$47$lambda$39$lambda$38$lambda$36$lambda$35(int $index, MutableState $selectedTab$delegate) {
      NotesScreen$lambda$11($selectedTab$delegate, $index);
      return Unit.INSTANCE;
   }

   private static final Object NotesScreen$lambda$48$lambda$47$lambda$46$lambda$45$lambda$41(NoteEntity it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return it.getId();
   }

   private static final Unit NotesScreen$lambda$48$lambda$47$lambda$46$lambda$45(List $filteredNotes, NotesViewModel $viewModel, MutableState $noteToDelete$delegate, MutableState $editingNote$delegate, LazyListScope $this$LazyColumn) {
      Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
      Function1 var7 = OtherScreensKt::NotesScreen$lambda$48$lambda$47$lambda$46$lambda$45$lambda$41;
      Function1 var8 = OtherScreensKt$NotesScreen$lambda$48$lambda$47$lambda$46$lambda$45$$inlined$items$default$1.INSTANCE;
      int var9 = 0;
      $this$LazyColumn.items($filteredNotes.size(), var7 != null ? (Function1)(new OtherScreensKt$NotesScreen$lambda$48$lambda$47$lambda$46$lambda$45$$inlined$items$default$2(var7, $filteredNotes)) : null, new OtherScreensKt$NotesScreen$lambda$48$lambda$47$lambda$46$lambda$45$$inlined$items$default$3(var8, $filteredNotes), (Function4)ComposableLambdaKt.composableLambdaInstance(-632812321, true, new OtherScreensKt$NotesScreen$lambda$48$lambda$47$lambda$46$lambda$45$$inlined$items$default$4($filteredNotes, $viewModel, $noteToDelete$delegate, $editingNote$delegate)));
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit NotesScreen$lambda$48(List $filteredNotes, NotesViewModel $viewModel, MutableState $selectedTab$delegate, MutableState $noteToDelete$delegate, MutableState $editingNote$delegate, PaddingValues paddingValues, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
      ComposerKt.sourceInformation($composer, "C182@6816L2967:OtherScreens.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(paddingValues) ? 4 : 2);
      }

      if (($dirty & 19) == 18 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721174307, $dirty, -1, "com.example.NotesScreen.<anonymous> (OtherScreens.kt:182)");
         }

         Modifier var10000 = PaddingKt.padding(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), paddingValues);
         int var9 = 24;
         int var10 = 0;
         Modifier var129 = PaddingKt.padding-3ABfNKs(var10000, Dp.constructor-impl((float)var9));
         byte var13 = 0;
         int var14 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var130 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var11 = Alignment.Companion.getStart();
         MeasurePolicy var15 = ColumnKt.columnMeasurePolicy(var130, var11, $composer, 14 & var13 >> 3 | 112 & var13 >> 3);
         int var16 = 112 & var13 << 3;
         int var17 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var18 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var19 = $composer.getCurrentCompositionLocalMap();
         Modifier var20 = ComposedModifierKt.materializeModifier($composer, var129);
         Function0 var21 = ComposeUiNode.Companion.getConstructor();
         int var22 = 6 | 896 & var16 << 6;
         int var23 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var21);
         } else {
            $composer.useNode();
         }

         Composer var24 = Updater.constructor-impl($composer);
         int var25 = 0;
         Updater.set-impl(var24, var15, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var24, var19, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var26 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var27 = 0;
         int var29 = 0;
         if (var24.getInserting() || !Intrinsics.areEqual(var24.rememberedValue(), var18)) {
            var24.updateRememberedValue(var18);
            var24.apply(var18, var26);
         }

         Updater.set-impl(var24, var20, ComposeUiNode.Companion.getSetModifier());
         int var30 = 14 & var22 >> 6;
         int var32 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var33 = 6 | 112 & var13 >> 6;
         ColumnScope var35 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var36 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 984935062, "C192@7137L11,188@6983L235,195@7231L41,203@7535L18,204@7617L18,198@7334L1354,227@8702L41:OtherScreens.kt#to5c3");
         long var37 = TextUnitKt.getSp(28);
         FontWeight var39 = FontWeight.Companion.getBold();
         long var40 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         long var42 = TextUnitKt.getSp((double)-0.5F);
         TextKt.Text--4IGK_g("Your Notes", (Modifier)null, var40, var37, (FontStyle)null, var39, (FontFamily)null, var42, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 130898);
         var10000 = (Modifier)Modifier.Companion;
         int var44 = 16;
         int var45 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var10000, Dp.constructor-impl((float)var44)), $composer, 6);
         var10000 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var44 = 48;
         var45 = 0;
         var10000 = SizeKt.height-3ABfNKs(var10000, Dp.constructor-impl((float)var44));
         var44 = 16;
         var45 = 0;
         var10000 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(var10000, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var44))), ThemeKt.isAppInDarkTheme($composer, 0) ? ColorKt.getDarkGlass() : ColorKt.getWhite40(), (Shape)null, 2, (Object)null);
         var44 = 1;
         var45 = 0;
         float var10001 = Dp.constructor-impl((float)var44);
         long var10002 = ThemeKt.isAppInDarkTheme($composer, 0) ? ColorKt.getDarkGlassBorder() : ColorKt.getWhite20();
         var44 = 16;
         var45 = 0;
         var10000 = BorderKt.border-xT4_qwU(var10000, var10001, var10002, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var44)));
         var44 = 4;
         var45 = 0;
         Modifier var140 = PaddingKt.padding-3ABfNKs(var10000, Dp.constructor-impl((float)var44));
         int var47 = 0;
         int var48 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var149 = Arrangement.INSTANCE.getStart();
         Alignment.Vertical var131 = Alignment.Companion.getTop();
         MeasurePolicy var49 = RowKt.rowMeasurePolicy(var149, var131, $composer, 14 & var47 >> 3 | 112 & var47 >> 3);
         int var50 = 112 & var47 << 3;
         int var51 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var52 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var53 = $composer.getCurrentCompositionLocalMap();
         Modifier var54 = ComposedModifierKt.materializeModifier($composer, var140);
         Function0 var55 = ComposeUiNode.Companion.getConstructor();
         int var56 = 6 | 896 & var50 << 6;
         int var57 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var55);
         } else {
            $composer.useNode();
         }

         Composer var58 = Updater.constructor-impl($composer);
         int var59 = 0;
         Updater.set-impl(var58, var49, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var58, var53, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var60 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var61 = 0;
         int var63 = 0;
         if (var58.getInserting() || !Intrinsics.areEqual(var58.rememberedValue(), var52)) {
            var58.updateRememberedValue(var52);
            var58.apply(var52, var60);
         }

         Updater.set-impl(var58, var54, ComposeUiNode.Companion.getSetModifier());
         int var64 = 14 & var56 >> 6;
         int var66 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var67 = 6 | 112 & var47 >> 6;
         Composer var107_1 = $composer;
         RowScope var69 = (RowScope)RowScopeInstance.INSTANCE;
         int var70 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2115070161, "C:OtherScreens.kt#to5c3");
         $composer.startReplaceGroup(1871435665);
         ComposerKt.sourceInformation($composer, "*214@8183L23,208@7849L807");
         String[] var71 = new String[]{"All", "Today", "Meetings"};
         Iterable var180 = (Iterable)CollectionsKt.listOf(var71);
         int var72 = 0;
         int var73 = 0;

         for(Object var75 : var180) {
            int var76 = var73++;
            if (var76 < 0) {
               CollectionsKt.throwIndexOverflow();
            }

            String var77 = (String)var75;
            int var79 = 0;
            var10000 = SizeKt.fillMaxHeight$default(RowScope.weight$default(var69, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null), 0.0F, 1, (Object)null);
            int var80 = 12;
            int var81 = 0;
            var10000 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(var10000, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var80))), NotesScreen$lambda$10($selectedTab$delegate) == var76 ? ColorKt.getIndigo600() : Color.Companion.getTransparent-0d7_KjU(), (Shape)null, 2, (Object)null);
            boolean var201 = false;
            Object var203 = null;
            Object var10003 = null;
            ComposerKt.sourceInformationMarkerStart(var107_1, 508988532, "CC(remember):OtherScreens.kt#9igjgp");
            boolean var82 = var107_1.changed(var76);
            int var83 = 0;
            Object var84 = var107_1.rememberedValue();
            int var85 = 0;
            Object var10004;
            if (!var82 && var84 != Composer.Companion.getEmpty()) {
               var10004 = var84;
            } else {
               Object var86 = null;
               Object var87 = null;
               boolean var88 = false;
               Modifier var89 = var10000;
               int var90 = 0;
               Function0 var92_1 = OtherScreensKt::NotesScreen$lambda$48$lambda$47$lambda$39$lambda$38$lambda$36$lambda$35;
               var10000 = var89;
               var201 = var88;
               var203 = var87;
               var10003 = var86;
               var107_1.updateRememberedValue(var92_1);
               var10004 = var92_1;
            }

            Function0 var181 = (Function0)var10004;
            ComposerKt.sourceInformationMarkerEnd(var107_1);
            Modifier var182 = ClickableKt.clickable-XHw0xAI$default(var10000, var201, (String)var203, (Role)var10003, var181, 7, (Object)null);
            Alignment var183 = Alignment.Companion.getCenter();
            byte var185 = 48;
            var85 = 0;
            ComposerKt.sourceInformationMarkerStart(var107_1, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            var82 = false;
            MeasurePolicy var187 = BoxKt.maybeCachedBoxMeasurePolicy(var183, var82);
            int var92 = 112 & var185 << 3;
            int var93 = 0;
            ComposerKt.sourceInformationMarkerStart(var107_1, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var94 = ComposablesKt.getCurrentCompositeKeyHash(var107_1, 0);
            CompositionLocalMap var95 = var107_1.getCurrentCompositionLocalMap();
            Modifier var96 = ComposedModifierKt.materializeModifier(var107_1, var182);
            Function0 var97 = ComposeUiNode.Companion.getConstructor();
            int var98 = 6 | 896 & var92 << 6;
            int var99 = 0;
            ComposerKt.sourceInformationMarkerStart(var107_1, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(var107_1.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            var107_1.startReusableNode();
            if (var107_1.getInserting()) {
               var107_1.createNode(var97);
            } else {
               var107_1.useNode();
            }

            Composer var100 = Updater.constructor-impl(var107_1);
            int var101 = 0;
            Updater.set-impl(var100, var187, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var100, var95, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var102 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var103 = 0;
            int var105 = 0;
            if (var100.getInserting() || !Intrinsics.areEqual(var100.rememberedValue(), var94)) {
               var100.updateRememberedValue(var94);
               var100.apply(var94, var102);
            }

            Updater.set-impl(var100, var96, ComposeUiNode.Companion.getSetModifier());
            int var106 = 14 & var98 >> 6;
            int var108 = 0;
            ComposerKt.sourceInformationMarkerStart(var107_1, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            int var109 = 6 | 112 & var185 >> 6;
            BoxScope var196 = (BoxScope)BoxScopeInstance.INSTANCE;
            int var112 = 0;
            ComposerKt.sourceInformationMarkerStart(var107_1, 1566575630, "C217@8316L318:OtherScreens.kt#to5c3");
            long var197;
            if (NotesScreen$lambda$10($selectedTab$delegate) == var76) {
               var107_1.startReplaceGroup(-642198564);
               var107_1.endReplaceGroup();
               var197 = Color.Companion.getWhite-0d7_KjU();
            } else {
               var107_1.startReplaceGroup(-642196951);
               ComposerKt.sourceInformation(var107_1, "219@8457L11");
               long var113 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(var107_1, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.7F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
               var107_1.endReplaceGroup();
               var197 = var113;
            }

            long var115 = var197;
            FontWeight var117 = FontWeight.Companion.getSemiBold();
            long var118 = TextUnitKt.getSp(14);
            TextKt.Text--4IGK_g(var77, (Modifier)null, var115, var118, (FontStyle)null, var117, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, var107_1, 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(var107_1);
            ComposerKt.sourceInformationMarkerEnd(var107_1);
            var107_1.endNode();
            ComposerKt.sourceInformationMarkerEnd(var107_1);
            ComposerKt.sourceInformationMarkerEnd(var107_1);
            ComposerKt.sourceInformationMarkerEnd(var107_1);
         }

         var107_1.endReplaceGroup();
         ComposerKt.sourceInformationMarkerEnd(var107_1);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         var10000 = (Modifier)Modifier.Companion;
         int var141 = 24;
         int var150 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var10000, Dp.constructor-impl((float)var141)), $composer, 6);
         if ($filteredNotes.isEmpty()) {
            $composer.startReplaceGroup(986647594);
            ComposerKt.sourceInformation($composer, "230@8804L305");
            Modifier var143 = SizeKt.fillMaxWidth$default(ColumnScope.weight$default(var35, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null), 0.0F, 1, (Object)null);
            Alignment var153 = Alignment.Companion.getCenter();
            var47 = 48;
            var48 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            boolean var134 = false;
            var49 = BoxKt.maybeCachedBoxMeasurePolicy(var153, var134);
            var50 = 112 & var47 << 3;
            var51 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            var52 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            var53 = $composer.getCurrentCompositionLocalMap();
            var54 = ComposedModifierKt.materializeModifier($composer, var143);
            var55 = ComposeUiNode.Companion.getConstructor();
            var56 = 6 | 896 & var50 << 6;
            var57 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var55);
            } else {
               $composer.useNode();
            }

            var58 = Updater.constructor-impl($composer);
            var59 = 0;
            Updater.set-impl(var58, var49, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var58, var53, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            var60 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            var61 = 0;
            var63 = 0;
            if (var58.getInserting() || !Intrinsics.areEqual(var58.rememberedValue(), var52)) {
               var58.updateRememberedValue(var52);
               var58.apply(var52, var60);
            }

            Updater.set-impl(var58, var54, ComposeUiNode.Companion.getSetModifier());
            var64 = 14 & var56 >> 6;
            var66 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            var67 = 6 | 112 & var47 >> 6;
            BoxScope var200 = (BoxScope)BoxScopeInstance.INSTANCE;
            var70 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 1549627276, "C233@9026L11,231@8914L177:OtherScreens.kt#to5c3");
            TextKt.Text--4IGK_g("No notes found in this category.", (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(986997367);
            ComposerKt.sourceInformation($composer, "241@9367L392,237@9147L612");
            var150 = 16;
            int var132 = 0;
            Arrangement.HorizontalOrVertical var142 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var150));
            var132 = 80;
            int var46 = 0;
            PaddingValues var152 = PaddingKt.PaddingValues-a9UjIt4$default(0.0F, 0.0F, 0.0F, Dp.constructor-impl((float)var132), 7, (Object)null);
            var10000 = ColumnScope.weight$default(var35, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
            Object var202 = null;
            PaddingValues var204 = var152;
            boolean var205 = false;
            Arrangement.Vertical var206 = (Arrangement.Vertical)var142;
            Object var10005 = null;
            Object var10006 = null;
            boolean var10007 = false;
            ComposerKt.sourceInformationMarkerStart($composer, -1769269329, "CC(remember):OtherScreens.kt#9igjgp");
            var48 = $composer.changedInstance($filteredNotes) | $composer.changedInstance($viewModel);
            int var158 = 0;
            Object var160 = $composer.rememberedValue();
            var51 = 0;
            Object var10008;
            if (!var48 && var160 != Composer.Companion.getEmpty()) {
               var10008 = var160;
            } else {
               boolean var120 = false;
               Object var121 = null;
               Object var122 = null;
               Arrangement.Vertical var123 = var206;
               boolean var124 = false;
               Object var126 = null;
               Modifier var127 = var10000;
               var52 = 0;
               Function1 var53_3 = OtherScreensKt::NotesScreen$lambda$48$lambda$47$lambda$46$lambda$45;
               var10000 = var127;
               var202 = var126;
               var204 = var152;
               var205 = var124;
               var206 = var123;
               var10005 = var122;
               var10006 = var121;
               var10007 = var120;
               $composer.updateRememberedValue(var53_3);
               var10008 = var53_3;
            }

            Function1 var154 = (Function1)var10008;
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(var10000, (LazyListState)var202, var204, var205, var206, (Alignment.Horizontal)var10005, (FlingBehavior)var10006, var10007, var154, $composer, 24960, 234);
            $composer.endReplaceGroup();
         }

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

   private static final Unit NotesScreen$lambda$53$lambda$50$lambda$49(MutableState $noteToDelete$delegate) {
      NotesScreen$lambda$17($noteToDelete$delegate, (NoteEntity)null);
      return Unit.INSTANCE;
   }

   private static final Unit NotesScreen$lambda$53$lambda$52$lambda$51(NotesViewModel $viewModel, NoteEntity $note, MutableState $noteToDelete$delegate) {
      $viewModel.deleteNote($note);
      NotesScreen$lambda$17($noteToDelete$delegate, (NoteEntity)null);
      return Unit.INSTANCE;
   }

   private static final Unit NotesScreen$lambda$55$lambda$54(MutableState $showAddNoteDialog$delegate) {
      NotesScreen$lambda$14($showAddNoteDialog$delegate, false);
      return Unit.INSTANCE;
   }

   private static final Unit NotesScreen$lambda$57$lambda$56(long $todayStart, NotesViewModel $viewModel, MutableState $showAddNoteDialog$delegate, String title, String content, boolean linkToday, MeetingItem selectedMeeting, Long reminderTime) {
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(content, "content");
      Long linkedDate = linkToday ? $todayStart : null;
      $viewModel.addNote(title, content, linkedDate, selectedMeeting != null ? selectedMeeting.getId() : null, reminderTime);
      NotesScreen$lambda$14($showAddNoteDialog$delegate, false);
      return Unit.INSTANCE;
   }

   private static final Unit NotesScreen$lambda$62$lambda$59$lambda$58(MutableState $editingNote$delegate) {
      NotesScreen$lambda$20($editingNote$delegate, (NoteEntity)null);
      return Unit.INSTANCE;
   }

   private static final Unit NotesScreen$lambda$62$lambda$61$lambda$60(long $todayStart, NotesViewModel $viewModel, NoteEntity $note, MutableState $editingNote$delegate, String title, String content, boolean linkToday, MeetingItem selectedMeeting, Long reminderTime) {
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(content, "content");
      Long linkedDate = linkToday ? $todayStart : null;
      String var11 = selectedMeeting != null ? selectedMeeting.getId() : null;
      long var12 = System.currentTimeMillis();
      $viewModel.updateNote(NoteEntity.copy$default($note, 0, (String)null, title, content, (Integer)null, reminderTime, linkedDate, var11, var12, (Long)null, 531, (Object)null));
      NotesScreen$lambda$20($editingNote$delegate, (NoteEntity)null);
      return Unit.INSTANCE;
   }

   private static final Unit NotesScreen$lambda$63(NotesViewModel $viewModel, PlannerViewModel $plannerViewModel, CalendarSyncViewModel $syncViewModel, AuthManager $authManager, int $$changed, Composer $composer, int $force) {
      NotesScreen($viewModel, $plannerViewModel, $syncViewModel, $authManager, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final Unit NoteContentWithChecklist$lambda$77$lambda$76$lambda$65$lambda$64(List $lines, int $index, String $line, Function1 $onContentChange) {
      List newLines = CollectionsKt.toMutableList((Collection)$lines);
      String var10002 = $line.substring(3);
      Intrinsics.checkNotNullExpressionValue(var10002, "substring(...)");
      newLines.set($index, "[x]" + var10002);
      $onContentChange.invoke(CollectionsKt.joinToString$default((Iterable)newLines, (CharSequence)"\n", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null));
      return Unit.INSTANCE;
   }

   private static final Unit NoteContentWithChecklist$lambda$77$lambda$76$lambda$68$lambda$67$lambda$66(List $lines, int $index, String $line, Function1 $onContentChange, boolean it) {
      List newLines = CollectionsKt.toMutableList((Collection)$lines);
      String var10002 = $line.substring(3);
      Intrinsics.checkNotNullExpressionValue(var10002, "substring(...)");
      newLines.set($index, "[x]" + var10002);
      $onContentChange.invoke(CollectionsKt.joinToString$default((Iterable)newLines, (CharSequence)"\n", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null));
      return Unit.INSTANCE;
   }

   private static final Unit NoteContentWithChecklist$lambda$77$lambda$76$lambda$70$lambda$69(List $lines, int $index, String $line, Function1 $onContentChange) {
      List newLines = CollectionsKt.toMutableList((Collection)$lines);
      String var10002 = $line.substring(3);
      Intrinsics.checkNotNullExpressionValue(var10002, "substring(...)");
      newLines.set($index, "[ ]" + var10002);
      $onContentChange.invoke(CollectionsKt.joinToString$default((Iterable)newLines, (CharSequence)"\n", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null));
      return Unit.INSTANCE;
   }

   private static final Unit NoteContentWithChecklist$lambda$77$lambda$76$lambda$73$lambda$72$lambda$71(List $lines, int $index, String $line, Function1 $onContentChange, boolean it) {
      List newLines = CollectionsKt.toMutableList((Collection)$lines);
      String var10002 = $line.substring(3);
      Intrinsics.checkNotNullExpressionValue(var10002, "substring(...)");
      newLines.set($index, "[ ]" + var10002);
      $onContentChange.invoke(CollectionsKt.joinToString$default((Iterable)newLines, (CharSequence)"\n", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null));
      return Unit.INSTANCE;
   }

   private static final Unit NoteContentWithChecklist$lambda$78(String $content, boolean $expanded, Function1 $onContentChange, int $$changed, Composer $composer, int $force) {
      NoteContentWithChecklist($content, $expanded, $onContentChange, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final boolean NoteCard$lambda$80(MutableState $expanded$delegate) {
      State var1 = (State)$expanded$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void NoteCard$lambda$81(MutableState $expanded$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $expanded$delegate.setValue(var5);
   }

   private static final Unit NoteCard$lambda$83$lambda$82(MutableState $expanded$delegate) {
      NoteCard$lambda$81($expanded$delegate, !NoteCard$lambda$80($expanded$delegate));
      return Unit.INSTANCE;
   }

   private static final Unit NoteCard$lambda$95$lambda$94$lambda$93(NotesViewModel $viewModel, NoteEntity $note, String newContent) {
      Intrinsics.checkNotNullParameter(newContent, "newContent");
      $viewModel.updateNote(NoteEntity.copy$default($note, 0, (String)null, (String)null, newContent, (Integer)null, (Long)null, (Long)null, (String)null, 0L, (Long)null, 1015, (Object)null));
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit NoteCard$lambda$95(NoteEntity $note, NotesViewModel $viewModel, Function0 $onDelete, boolean $isDark, MutableState $expanded$delegate, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C432@17509L3797,503@21315L40,507@21489L99,504@21364L234:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(459541874, $changed, -1, "com.example.NoteCard.<anonymous> (OtherScreens.kt:432)");
         }

         Modifier var8 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Arrangement.Horizontal var9 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
         Alignment.Vertical var10 = Alignment.Companion.getTop();
         short var12 = 438;
         int var13 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         MeasurePolicy var14 = RowKt.rowMeasurePolicy(var9, var10, $composer, 14 & var12 >> 3 | 112 & var12 >> 3);
         int var15 = 112 & var12 << 3;
         int var16 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var17 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var18 = $composer.getCurrentCompositionLocalMap();
         Modifier var19 = ComposedModifierKt.materializeModifier($composer, var8);
         Function0 var20 = ComposeUiNode.Companion.getConstructor();
         int var21 = 6 | 896 & var15 << 6;
         int var22 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var20);
         } else {
            $composer.useNode();
         }

         Composer var23 = Updater.constructor-impl($composer);
         int var24 = 0;
         Updater.set-impl(var23, var14, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var23, var18, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var25 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var26 = 0;
         int var28 = 0;
         if (var23.getInserting() || !Intrinsics.areEqual(var23.rememberedValue(), var17)) {
            var23.updateRememberedValue(var17);
            var23.apply(var17, var25);
         }

         Updater.set-impl(var23, var19, ComposeUiNode.Companion.getSetModifier());
         int var29 = 14 & var21 >> 6;
         int var31 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var32 = 6 | 112 & var12 >> 6;
         RowScope var34 = (RowScope)RowScopeInstance.INSTANCE;
         int var35 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1815394853, "C437@17694L3198,493@20905L391:OtherScreens.kt#to5c3");
         Modifier var36 = RowScope.weight$default(var34, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         int var38 = 0;
         int var39 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var40 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var41 = Alignment.Companion.getStart();
         MeasurePolicy var42 = ColumnKt.columnMeasurePolicy(var40, var41, $composer, 14 & var38 >> 3 | 112 & var38 >> 3);
         int var43 = 112 & var38 << 3;
         int var44 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var45 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var46 = $composer.getCurrentCompositionLocalMap();
         Modifier var47 = ComposedModifierKt.materializeModifier($composer, var36);
         Function0 var48 = ComposeUiNode.Companion.getConstructor();
         int var49 = 6 | 896 & var43 << 6;
         int var50 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var48);
         } else {
            $composer.useNode();
         }

         Composer var51 = Updater.constructor-impl($composer);
         int var52 = 0;
         Updater.set-impl(var51, var42, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var51, var46, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var53 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var54 = 0;
         int var56 = 0;
         if (var51.getInserting() || !Intrinsics.areEqual(var51.rememberedValue(), var45)) {
            var51.updateRememberedValue(var45);
            var51.apply(var45, var53);
         }

         Updater.set-impl(var51, var47, ComposeUiNode.Companion.getSetModifier());
         int var57 = 14 & var49 >> 6;
         int var59 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var60 = 6 | 112 & var38 >> 6;
         ColumnScope var10000 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var63 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1504261472, "C442@17926L11,438@17751L217,444@17985L40,446@18075L2803:OtherScreens.kt#to5c3");
         String var64 = $note.getTitle();
         FontWeight var65 = FontWeight.Companion.getBold();
         long var66 = TextUnitKt.getSp(18);
         long var68 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g(var64, (Modifier)null, var68, var66, (FontStyle)null, var65, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
         Modifier var302 = (Modifier)Modifier.Companion;
         int var180 = 4;
         int var182 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var302, Dp.constructor-impl((float)var180)), $composer, 6);
         var182 = 8;
         int var70 = 0;
         Arrangement.HorizontalOrVertical var181 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var182));
         var302 = (Modifier)Modifier.Companion;
         var70 = 4;
         int var71 = 0;
         Modifier var185 = PaddingKt.padding-VpY3zN4$default(var302, 0.0F, Dp.constructor-impl((float)var70), 1, (Object)null);
         Arrangement.Horizontal var186 = (Arrangement.Horizontal)var181;
         byte var73 = 54;
         int var74 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Alignment.Vertical var75 = Alignment.Companion.getTop();
         MeasurePolicy var76 = RowKt.rowMeasurePolicy(var186, var75, $composer, 14 & var73 >> 3 | 112 & var73 >> 3);
         int var77 = 112 & var73 << 3;
         int var78 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var79 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var80 = $composer.getCurrentCompositionLocalMap();
         Modifier var81 = ComposedModifierKt.materializeModifier($composer, var185);
         Function0 var82 = ComposeUiNode.Companion.getConstructor();
         int var83 = 6 | 896 & var77 << 6;
         int var84 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var82);
         } else {
            $composer.useNode();
         }

         Composer var85 = Updater.constructor-impl($composer);
         int var86 = 0;
         Updater.set-impl(var85, var76, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var85, var80, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var87 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var88 = 0;
         int var90 = 0;
         if (var85.getInserting() || !Intrinsics.areEqual(var85.rememberedValue(), var79)) {
            var85.updateRememberedValue(var79);
            var85.apply(var79, var87);
         }

         Updater.set-impl(var85, var81, ComposeUiNode.Companion.getSetModifier());
         int var91 = 14 & var83 >> 6;
         int var93 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var94 = 6 | 112 & var73 >> 6;
         RowScope var304 = (RowScope)RowScopeInstance.INSTANCE;
         int var97 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 367520200, "C:OtherScreens.kt#to5c3");
         if ($note.getLinkedDate() == null) {
            $composer.startReplaceGroup(349327570);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(367491803);
            ComposerKt.sourceInformation($composer, "451@18312L711");
            Modifier var305 = (Modifier)Modifier.Companion;
            long var10001 = ColorKt.getIndigo100();
            int var98 = 8;
            int var99 = 0;
            var305 = BackgroundKt.background-bw27NRU(var305, var10001, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var98)));
            var98 = 8;
            var99 = 0;
            float var325 = Dp.constructor-impl((float)var98);
            var98 = 2;
            var99 = 0;
            Modifier var189 = PaddingKt.padding-VpY3zN4(var305, var325, Dp.constructor-impl((float)var98));
            byte var101 = 0;
            int var102 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment var198 = Alignment.Companion.getTopStart();
            boolean var103 = false;
            MeasurePolicy var104 = BoxKt.maybeCachedBoxMeasurePolicy(var198, var103);
            int var105 = 112 & var101 << 3;
            int var106 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var107 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var108 = $composer.getCurrentCompositionLocalMap();
            Modifier var109 = ComposedModifierKt.materializeModifier($composer, var189);
            Function0 var110 = ComposeUiNode.Companion.getConstructor();
            int var111 = 6 | 896 & var105 << 6;
            int var112 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var110);
            } else {
               $composer.useNode();
            }

            Composer var113 = Updater.constructor-impl($composer);
            int var114 = 0;
            Updater.set-impl(var113, var104, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var113, var108, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var115 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var116 = 0;
            int var118 = 0;
            if (var113.getInserting() || !Intrinsics.areEqual(var113.rememberedValue(), var107)) {
               var113.updateRememberedValue(var107);
               var113.apply(var107, var115);
            }

            Updater.set-impl(var113, var109, ComposeUiNode.Companion.getSetModifier());
            int var119 = 14 & var111 >> 6;
            int var121 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            int var122 = 6 | 112 & var101 >> 6;
            BoxScope var307 = (BoxScope)BoxScopeInstance.INSTANCE;
            int var125 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -402179472, "C456@18579L418:OtherScreens.kt#to5c3");
            Alignment.Vertical var126 = Alignment.Companion.getCenterVertically();
            int var128 = 384;
            int var129 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier var130 = (Modifier)Modifier.Companion;
            Arrangement.Horizontal var131 = Arrangement.INSTANCE.getStart();
            MeasurePolicy var132 = RowKt.rowMeasurePolicy(var131, var126, $composer, 14 & var128 >> 3 | 112 & var128 >> 3);
            int var133 = 112 & var128 << 3;
            int var134 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var135 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var136 = $composer.getCurrentCompositionLocalMap();
            Modifier var137 = ComposedModifierKt.materializeModifier($composer, var130);
            Function0 var138 = ComposeUiNode.Companion.getConstructor();
            int var139 = 6 | 896 & var133 << 6;
            int var140 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var138);
            } else {
               $composer.useNode();
            }

            Composer var141 = Updater.constructor-impl($composer);
            int var142 = 0;
            Updater.set-impl(var141, var132, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var141, var136, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var143 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var144 = 0;
            int var146 = 0;
            if (var141.getInserting() || !Intrinsics.areEqual(var141.rememberedValue(), var135)) {
               var141.updateRememberedValue(var135);
               var141.apply(var135, var143);
            }

            Updater.set-impl(var141, var137, ComposeUiNode.Companion.getSetModifier());
            int var147 = 14 & var139 >> 6;
            int var149 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            int var150 = 6 | 112 & var128 >> 6;
            RowScope var308 = (RowScope)RowScopeInstance.INSTANCE;
            int var153 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 375485952, "C457@18665L107,458@18805L39,459@18877L90:OtherScreens.kt#to5c3");
            ImageVector var309 = DateRangeKt.getDateRange(Icons.INSTANCE.getDefault());
            Modifier var10002 = (Modifier)Modifier.Companion;
            int var154 = 12;
            int var155 = 0;
            IconKt.Icon-ww6aTOc(var309, (String)null, SizeKt.size-3ABfNKs(var10002, Dp.constructor-impl((float)var154)), ColorKt.getIndigo700(), $composer, 3504, 0);
            Modifier var310 = (Modifier)Modifier.Companion;
            var154 = 4;
            var155 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var310, Dp.constructor-impl((float)var154)), $composer, 6);
            long var156 = TextUnitKt.getSp(10);
            FontWeight var158 = FontWeight.Companion.getBold();
            long var159 = ColorKt.getIndigo700();
            TextKt.Text--4IGK_g("Linked to Today", (Modifier)null, var159, var156, (FontStyle)null, var158, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 200070, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
         }

         CharSequence var190 = (CharSequence)$note.getLinkedMeetingId();
         if (var190 == null || var190.length() == 0) {
            $composer.startReplaceGroup(349327570);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(368308126);
            ComposerKt.sourceInformation($composer, "464@19135L708");
            Modifier var311 = (Modifier)Modifier.Companion;
            long var326 = ColorKt.getTeal100();
            int var191 = 8;
            int var199 = 0;
            var311 = BackgroundKt.background-bw27NRU(var311, var326, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var191)));
            var191 = 8;
            var199 = 0;
            float var327 = Dp.constructor-impl((float)var191);
            var191 = 2;
            var199 = 0;
            Modifier var194 = PaddingKt.padding-VpY3zN4(var311, var327, Dp.constructor-impl((float)var191));
            byte var207 = 0;
            int var209 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment var202 = Alignment.Companion.getTopStart();
            boolean var210 = false;
            MeasurePolicy var215 = BoxKt.maybeCachedBoxMeasurePolicy(var202, var210);
            int var217 = 112 & var207 << 3;
            int var219 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var221 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var223 = $composer.getCurrentCompositionLocalMap();
            Modifier var225 = ComposedModifierKt.materializeModifier($composer, var194);
            Function0 var227 = ComposeUiNode.Companion.getConstructor();
            int var229 = 6 | 896 & var217 << 6;
            int var231 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var227);
            } else {
               $composer.useNode();
            }

            Composer var233 = Updater.constructor-impl($composer);
            int var235 = 0;
            Updater.set-impl(var233, var215, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var233, var223, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var237 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var239 = 0;
            int var241 = 0;
            if (var233.getInserting() || !Intrinsics.areEqual(var233.rememberedValue(), var221)) {
               var233.updateRememberedValue(var221);
               var233.apply(var221, var237);
            }

            Updater.set-impl(var233, var225, ComposeUiNode.Companion.getSetModifier());
            int var243 = 14 & var229 >> 6;
            int var244 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            int var246 = 6 | 112 & var207 >> 6;
            BoxScope var313 = (BoxScope)BoxScopeInstance.INSTANCE;
            int var247 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 1178215994, "C469@19400L417:OtherScreens.kt#to5c3");
            Alignment.Vertical var248 = Alignment.Companion.getCenterVertically();
            int var249 = 384;
            int var251 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier var252 = (Modifier)Modifier.Companion;
            Arrangement.Horizontal var254 = Arrangement.INSTANCE.getStart();
            MeasurePolicy var256 = RowKt.rowMeasurePolicy(var254, var248, $composer, 14 & var249 >> 3 | 112 & var249 >> 3);
            int var258 = 112 & var249 << 3;
            int var260 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var262 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var264 = $composer.getCurrentCompositionLocalMap();
            Modifier var266 = ComposedModifierKt.materializeModifier($composer, var252);
            Function0 var268 = ComposeUiNode.Companion.getConstructor();
            int var270 = 6 | 896 & var258 << 6;
            int var272 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var268);
            } else {
               $composer.useNode();
            }

            Composer var274 = Updater.constructor-impl($composer);
            int var276 = 0;
            Updater.set-impl(var274, var256, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var274, var264, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var278 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var280 = 0;
            int var282 = 0;
            if (var274.getInserting() || !Intrinsics.areEqual(var274.rememberedValue(), var262)) {
               var274.updateRememberedValue(var262);
               var274.apply(var262, var278);
            }

            Updater.set-impl(var274, var266, ComposeUiNode.Companion.getSetModifier());
            int var284 = 14 & var270 >> 6;
            int var285 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            int var287 = 6 | 112 & var249 >> 6;
            RowScope var314 = (RowScope)RowScopeInstance.INSTANCE;
            int var288 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 1190021834, "C470@19486L107,471@19626L39,472@19698L89:OtherScreens.kt#to5c3");
            ImageVector var315 = MeetingRoomKt.getMeetingRoom(Icons.INSTANCE.getDefault());
            Modifier var332 = (Modifier)Modifier.Companion;
            int var290 = 12;
            int var293 = 0;
            IconKt.Icon-ww6aTOc(var315, (String)null, SizeKt.size-3ABfNKs(var332, Dp.constructor-impl((float)var290)), ColorKt.getTeal700(), $composer, 3504, 0);
            Modifier var316 = (Modifier)Modifier.Companion;
            var290 = 4;
            var293 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var316, Dp.constructor-impl((float)var290)), $composer, 6);
            long var296 = TextUnitKt.getSp(10);
            FontWeight var297 = FontWeight.Companion.getBold();
            long var298 = ColorKt.getTeal700();
            TextKt.Text--4IGK_g("Meeting Attached", (Modifier)null, var298, var296, (FontStyle)null, var297, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 200070, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
         }

         if ($note.getReminderTime() != null) {
            $composer.startReplaceGroup(369115459);
            ComposerKt.sourceInformation($composer, "479@20097L741");
            SimpleDateFormat var195 = new SimpleDateFormat("HH:mm", Locale.getDefault());
            String var203 = var195.format(new Date($note.getReminderTime()));
            Modifier var317 = (Modifier)Modifier.Companion;
            long var328 = $isDark ? ColorKt.getDarkGlass() : ColorKt.getSlate200();
            int var211 = 8;
            int var100 = 0;
            var317 = BackgroundKt.background-bw27NRU(var317, var328, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var211)));
            var211 = 8;
            var100 = 0;
            float var329 = Dp.constructor-impl((float)var211);
            var211 = 2;
            var100 = 0;
            Modifier var214 = PaddingKt.padding-VpY3zN4(var317, var329, Dp.constructor-impl((float)var211));
            byte var216 = 0;
            int var218 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment var206 = Alignment.Companion.getTopStart();
            boolean var208 = false;
            MeasurePolicy var220 = BoxKt.maybeCachedBoxMeasurePolicy(var206, var208);
            int var222 = 112 & var216 << 3;
            int var224 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var226 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var228 = $composer.getCurrentCompositionLocalMap();
            Modifier var230 = ComposedModifierKt.materializeModifier($composer, var214);
            Function0 var232 = ComposeUiNode.Companion.getConstructor();
            int var234 = 6 | 896 & var222 << 6;
            int var236 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var232);
            } else {
               $composer.useNode();
            }

            Composer var238 = Updater.constructor-impl($composer);
            int var240 = 0;
            Updater.set-impl(var238, var220, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var238, var228, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var117 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var242 = 0;
            int var120 = 0;
            if (var238.getInserting() || !Intrinsics.areEqual(var238.rememberedValue(), var226)) {
               var238.updateRememberedValue(var226);
               var238.apply(var226, var117);
            }

            Updater.set-impl(var238, var230, ComposeUiNode.Companion.getSetModifier());
            int var245 = 14 & var234 >> 6;
            int var123 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            int var124 = 6 | 112 & var216 >> 6;
            BoxScope var319 = (BoxScope)BoxScopeInstance.INSTANCE;
            int var127 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -276109132, "C484@20390L422:OtherScreens.kt#to5c3");
            Alignment.Vertical var250 = Alignment.Companion.getCenterVertically();
            int var253 = 384;
            int var255 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier var257 = (Modifier)Modifier.Companion;
            Arrangement.Horizontal var259 = Arrangement.INSTANCE.getStart();
            MeasurePolicy var261 = RowKt.rowMeasurePolicy(var259, var250, $composer, 14 & var253 >> 3 | 112 & var253 >> 3);
            int var263 = 112 & var253 << 3;
            int var265 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var267 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var269 = $composer.getCurrentCompositionLocalMap();
            Modifier var271 = ComposedModifierKt.materializeModifier($composer, var257);
            Function0 var273 = ComposeUiNode.Companion.getConstructor();
            int var275 = 6 | 896 & var263 << 6;
            int var277 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var273);
            } else {
               $composer.useNode();
            }

            Composer var279 = Updater.constructor-impl($composer);
            int var281 = 0;
            Updater.set-impl(var279, var261, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var279, var269, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var145 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var283 = 0;
            int var148 = 0;
            if (var279.getInserting() || !Intrinsics.areEqual(var279.rememberedValue(), var267)) {
               var279.updateRememberedValue(var267);
               var279.apply(var267, var145);
            }

            Updater.set-impl(var279, var271, ComposeUiNode.Companion.getSetModifier());
            int var286 = 14 & var275 >> 6;
            int var151 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            int var152 = 6 | 112 & var253 >> 6;
            RowScope var320 = (RowScope)RowScopeInstance.INSTANCE;
            int var295 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -264303292, "C485@20476L110,486@20619L39,487@20691L91:OtherScreens.kt#to5c3");
            ImageVector var321 = NotificationsKt.getNotifications(Icons.INSTANCE.getDefault());
            Modifier var333 = (Modifier)Modifier.Companion;
            int var161 = 12;
            int var162 = 0;
            IconKt.Icon-ww6aTOc(var321, (String)null, SizeKt.size-3ABfNKs(var333, Dp.constructor-impl((float)var161)), ColorKt.getSlate500(), $composer, 3504, 0);
            Modifier var322 = (Modifier)Modifier.Companion;
            var161 = 4;
            var162 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var322, Dp.constructor-impl((float)var161)), $composer, 6);
            String var300 = "Reminder: " + var203;
            long var163 = TextUnitKt.getSp(10);
            FontWeight var165 = FontWeight.Companion.getBold();
            long var166 = ColorKt.getSlate500();
            TextKt.Text--4IGK_g(var300, (Modifier)null, var166, var163, (FontStyle)null, var165, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 200064, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(349327570);
            $composer.endReplaceGroup();
         }

         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Modifier var330 = (Modifier)Modifier.Companion;
         int var178 = 36;
         int var179 = 0;
         IconButtonKt.IconButton($onDelete, BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(var330, Dp.constructor-impl((float)var178)), (Shape)RoundedCornerShapeKt.getCircleShape()), Color.copy-wmQWz5c$default(Color.Companion.getRed-0d7_KjU(), 0.1F, 0.0F, 0.0F, 0.0F, 14, (Object)null), (Shape)null, 2, (Object)null), false, (IconButtonColors)null, (MutableInteractionSource)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$1071890483$app(), $composer, 196608, 28);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Modifier var323 = (Modifier)Modifier.Companion;
         int var171 = 8;
         int var173 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var323, Dp.constructor-impl((float)var171)), $composer, 6);
         String var324 = $note.getContent();
         boolean var331 = NoteCard$lambda$80($expanded$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, -761762795, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var174 = $composer.changedInstance($viewModel) | $composer.changed($note);
         int var11 = 0;
         Object var175 = $composer.rememberedValue();
         var13 = 0;
         Object var334;
         if (!var174 && var175 != Composer.Companion.getEmpty()) {
            var334 = var175;
         } else {
            boolean var169 = var331;
            String var168 = var324;
            int var177 = 0;
            Function1 var15_3 = OtherScreensKt::NoteCard$lambda$95$lambda$94$lambda$93;
            var324 = var168;
            var331 = var169;
            $composer.updateRememberedValue(var15_3);
            var334 = var15_3;
         }

         Function1 var172 = (Function1)var334;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NoteContentWithChecklist(var324, var331, var172, $composer, 0);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit NoteCard$lambda$96(NoteEntity $note, NotesViewModel $viewModel, Function0 $onDelete, Function0 $onDoubleClick, int $$changed, Composer $composer, int $force) {
      NoteCard($note, $viewModel, $onDelete, $onDoubleClick, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final Unit NoteOptionRow_oC9nPe0$lambda$102(ImageVector $icon, long $iconTint, String $title, String $subtitle, boolean $checked, Function1 $onCheckedChange, Function2 $content, int $$changed, int $$default, Composer $composer, int $force) {
      NoteOptionRow-oC9nPe0($icon, $iconTint, $title, $subtitle, $checked, $onCheckedChange, $content, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1), $$default);
      return Unit.INSTANCE;
   }

   private static final String DetailedAddNoteDialog$lambda$104(MutableState $title$delegate) {
      State var1 = (State)$title$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)var1.getValue();
   }

   private static final void DetailedAddNoteDialog$lambda$105(MutableState $title$delegate, String var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $title$delegate.setValue(var1);
   }

   private static final String DetailedAddNoteDialog$lambda$107(MutableState $content$delegate) {
      State var1 = (State)$content$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)var1.getValue();
   }

   private static final void DetailedAddNoteDialog$lambda$108(MutableState $content$delegate, String var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $content$delegate.setValue(var1);
   }

   private static final boolean DetailedAddNoteDialog$lambda$110(MutableState $linkToday$delegate) {
      State var1 = (State)$linkToday$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void DetailedAddNoteDialog$lambda$111(MutableState $linkToday$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $linkToday$delegate.setValue(var5);
   }

   private static final boolean DetailedAddNoteDialog$lambda$113(MutableState $attachMeeting$delegate) {
      State var1 = (State)$attachMeeting$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void DetailedAddNoteDialog$lambda$114(MutableState $attachMeeting$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $attachMeeting$delegate.setValue(var5);
   }

   private static final boolean DetailedAddNoteDialog$lambda$116(MutableState $hasReminder$delegate) {
      State var1 = (State)$hasReminder$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void DetailedAddNoteDialog$lambda$117(MutableState $hasReminder$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $hasReminder$delegate.setValue(var5);
   }

   private static final MeetingItem DetailedAddNoteDialog$lambda$119(MutableState $selectedMeeting$delegate) {
      State var1 = (State)$selectedMeeting$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (MeetingItem)var1.getValue();
   }

   private static final void DetailedAddNoteDialog$lambda$120(MutableState $selectedMeeting$delegate, MeetingItem var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $selectedMeeting$delegate.setValue(var1);
   }

   private static final Long DetailedAddNoteDialog$lambda$122(MutableState $reminderTime$delegate) {
      State var1 = (State)$reminderTime$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Long)var1.getValue();
   }

   private static final void DetailedAddNoteDialog$lambda$123(MutableState $reminderTime$delegate, Long var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $reminderTime$delegate.setValue(var1);
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$125$lambda$124(MutableState $title$delegate, String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      DetailedAddNoteDialog$lambda$105($title$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$132$lambda$127$lambda$126(MutableState $content$delegate) {
      String newText = ((CharSequence)DetailedAddNoteDialog$lambda$107($content$delegate)).length() != 0 && !StringsKt.endsWith$default(DetailedAddNoteDialog$lambda$107($content$delegate), "\n", false, 2, (Object)null) ? DetailedAddNoteDialog$lambda$107($content$delegate) + "\n[ ] " : DetailedAddNoteDialog$lambda$107($content$delegate) + "[ ] ";
      DetailedAddNoteDialog$lambda$108($content$delegate, newText);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$132$lambda$129$lambda$128(MutableState $content$delegate) {
      String newText = ((CharSequence)DetailedAddNoteDialog$lambda$107($content$delegate)).length() != 0 && !StringsKt.endsWith$default(DetailedAddNoteDialog$lambda$107($content$delegate), "\n", false, 2, (Object)null) ? DetailedAddNoteDialog$lambda$107($content$delegate) + "\n- " : DetailedAddNoteDialog$lambda$107($content$delegate) + "- ";
      DetailedAddNoteDialog$lambda$108($content$delegate, newText);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$132$lambda$131$lambda$130(MutableState $content$delegate) {
      CharSequence var10000 = (CharSequence)DetailedAddNoteDialog$lambda$107($content$delegate);
      String[] var2 = new String[]{"\n"};
      List lines = StringsKt.split$default(var10000, var2, false, 0, 6, (Object)null);
      int nextNum = 1;
      int var3 = ((Collection)lines).size() + -1;
      if (0 <= var3) {
         do {
            int i = var3--;
            String line = StringsKt.trim((CharSequence)((String)lines.get(i))).toString();
            MatchResult match = Regex.find$default(new Regex("^(\\d+)\\.\\s.*"), (CharSequence)line, 0, 2, (Object)null);
            if (match != null) {
               Integer var9 = StringsKt.toIntOrNull((String)match.getGroupValues().get(1));
               nextNum = (var9 != null ? var9 : 0) + 1;
               break;
            }
         } while(0 <= var3);
      }

      String newText = ((CharSequence)DetailedAddNoteDialog$lambda$107($content$delegate)).length() != 0 && !StringsKt.endsWith$default(DetailedAddNoteDialog$lambda$107($content$delegate), "\n", false, 2, (Object)null) ? DetailedAddNoteDialog$lambda$107($content$delegate) + "\n" + nextNum + ". " : DetailedAddNoteDialog$lambda$107($content$delegate) + nextNum + ". ";
      DetailedAddNoteDialog$lambda$108($content$delegate, newText);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$134$lambda$133(MutableState $content$delegate, String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      DetailedAddNoteDialog$lambda$108($content$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$136$lambda$135(MutableState $linkToday$delegate, boolean it) {
      DetailedAddNoteDialog$lambda$111($linkToday$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$138$lambda$137(MutableState $attachMeeting$delegate, boolean it) {
      DetailedAddNoteDialog$lambda$114($attachMeeting$delegate, it);
      return Unit.INSTANCE;
   }

   private static final boolean DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$140(MutableState $expandedDropdown$delegate) {
      State var1 = (State)$expandedDropdown$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$141(MutableState $expandedDropdown$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $expandedDropdown$delegate.setValue(var5);
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$143$lambda$142(MutableState $expandedDropdown$delegate) {
      DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$141($expandedDropdown$delegate, true);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$144(MutableState $selectedMeeting$delegate, RowScope $this$OutlinedButton, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$OutlinedButton, "$this$OutlinedButton");
      ComposerKt.sourceInformation($composer, "C741@31234L54:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-327266843, $changed, -1, "com.example.DetailedAddNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:741)");
         }

         String var4;
         label20: {
            MeetingItem var10000 = DetailedAddNoteDialog$lambda$119($selectedMeeting$delegate);
            if (var10000 != null) {
               var4 = var10000.getTitle();
               if (var4 != null) {
                  break label20;
               }
            }

            var4 = "Select Meeting Event";
         }

         TextKt.Text--4IGK_g(var4, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$146$lambda$145(MutableState $expandedDropdown$delegate) {
      DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$141($expandedDropdown$delegate, false);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$151$lambda$150$lambda$147(MeetingItem $event, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C749@31729L17:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1656230417, $changed, -1, "com.example.DetailedAddNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:749)");
         }

         TextKt.Text--4IGK_g($event.getTitle(), (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$151$lambda$150$lambda$149$lambda$148(MeetingItem $event, MutableState $selectedMeeting$delegate, MutableState $expandedDropdown$delegate) {
      DetailedAddNoteDialog$lambda$120($selectedMeeting$delegate, $event);
      DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$141($expandedDropdown$delegate, false);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$151(List $meetings, MutableState $selectedMeeting$delegate, MutableState $expandedDropdown$delegate, ColumnScope $this$DropdownMenu, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$DropdownMenu, "$this$DropdownMenu");
      ComposerKt.sourceInformation($composer, "C*749@31727L21,750@31804L192,748@31658L380:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1423615960, $changed, -1, "com.example.DetailedAddNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:747)");
         }

         Iterable var6 = (Iterable)$meetings;
         int var7 = 0;

         for(Object var9 : var6) {
            MeetingItem var10 = (MeetingItem)var9;
            int var11 = 0;
            Function2 var10000 = (Function2)ComposableLambdaKt.rememberComposableLambda(1656230417, true, OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$151$lambda$150$lambda$147, $composer, 54);
            ComposerKt.sourceInformationMarkerStart($composer, -1268749055, "CC(remember):OtherScreens.kt#9igjgp");
            boolean var13 = $composer.changed(var10);
            int var14 = 0;
            Object var15 = $composer.rememberedValue();
            int var16 = 0;
            Object var21;
            if (!var13 && var15 != Composer.Companion.getEmpty()) {
               var21 = var15;
            } else {
               Function2 var17 = var10000;
               int var18 = 0;
               Function0 var10001 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$151$lambda$150$lambda$149$lambda$148;
               var10000 = var17;
               Object var19 = var10001;
               $composer.updateRememberedValue(var19);
               var21 = var19;
            }

            Function0 var20 = (Function0)var21;
            ComposerKt.sourceInformationMarkerEnd($composer);
            AndroidMenu_androidKt.DropdownMenuItem(var10000, var20, (Modifier)null, (Function2)null, (Function2)null, false, (MenuItemColors)null, (PaddingValues)null, (MutableInteractionSource)null, $composer, 6, 508);
         }

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
   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153(List $meetings, MutableState $selectedMeeting$delegate, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1321898194, $changed, -1, "com.example.DetailedAddNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:733)");
         }

         if (!((Collection)$meetings).isEmpty()) {
            $composer.startReplaceGroup(114057276);
            ComposerKt.sourceInformation($composer, "734@30792L34,735@30855L1285");
            ComposerKt.sourceInformationMarkerStart($composer, -966151724, "CC(remember):OtherScreens.kt#9igjgp");
            boolean var7 = false;
            int var47 = 0;
            Object var48 = $composer.rememberedValue();
            int var50 = 0;
            Object var61;
            if (var48 == Composer.Companion.getEmpty()) {
               int var11 = 0;
               Object var52 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy)null, 2, (Object)null);
               $composer.updateRememberedValue(var52);
               var61 = var52;
            } else {
               var61 = var48;
            }

            MutableState var5 = (MutableState)var61;
            ComposerKt.sourceInformationMarkerEnd($composer);
            MutableState expandedDropdown$delegate = var5;
            Modifier var44 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            int var49 = 6;
            var50 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment var45 = Alignment.Companion.getTopStart();
            var7 = false;
            MeasurePolicy var53 = BoxKt.maybeCachedBoxMeasurePolicy(var45, var7);
            int var12 = 112 & var49 << 3;
            int var13 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var14 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var15 = $composer.getCurrentCompositionLocalMap();
            Modifier var16 = ComposedModifierKt.materializeModifier($composer, var44);
            Function0 var17 = ComposeUiNode.Companion.getConstructor();
            int var18 = 6 | 896 & var12 << 6;
            int var19 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var17);
            } else {
               $composer.useNode();
            }

            Composer var20 = Updater.constructor-impl($composer);
            int var21 = 0;
            Updater.set-impl(var20, var53, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var20, var15, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var23 = 0;
            int var25 = 0;
            if (var20.getInserting() || !Intrinsics.areEqual(var20.rememberedValue(), var14)) {
               var20.updateRememberedValue(var14);
               var20.apply(var14, var22);
            }

            Updater.set-impl(var20, var16, ComposeUiNode.Companion.getSetModifier());
            int var26 = 14 & var18 >> 6;
            int var28 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            int var29 = 6 | 112 & var49 >> 6;
            BoxScope var62 = (BoxScope)BoxScopeInstance.INSTANCE;
            int var32 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 1733202163, "C737@30991L27,740@31196L126,736@30929L393,745@31489L28,746@31552L558,743@31355L755:OtherScreens.kt#to5c3");
            ComposerKt.sourceInformationMarkerStart($composer, 1025741902, "CC(remember):OtherScreens.kt#9igjgp");
            boolean var34 = false;
            int var35 = 0;
            Object var36 = $composer.rememberedValue();
            int var37 = 0;
            Object var63;
            if (var36 == Composer.Companion.getEmpty()) {
               int var38 = 0;
               Object var39 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$143$lambda$142;
               $composer.updateRememberedValue(var39);
               var63 = var39;
            } else {
               var63 = var36;
            }

            Function0 var40 = (Function0)var63;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var64 = var40;
            Modifier var10001 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            int var59 = 12;
            int var33 = 0;
            ButtonKt.OutlinedButton(var64, var10001, false, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var59)), (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-327266843, true, OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$144, $composer, 54), $composer, 805306422, 500);
            boolean var65 = DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$140(expandedDropdown$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 1025757839, "CC(remember):OtherScreens.kt#9igjgp");
            var34 = false;
            var35 = 0;
            var36 = $composer.rememberedValue();
            var37 = 0;
            Object var66;
            if (var36 == Composer.Companion.getEmpty()) {
               boolean var41 = var65;
               int var58 = 0;
               Function0 var39_4 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$146$lambda$145;
               var65 = var41;
               $composer.updateRememberedValue(var39_4);
               var66 = var39_4;
            } else {
               var66 = var36;
            }

            Function0 var60 = (Function0)var66;
            ComposerKt.sourceInformationMarkerEnd($composer);
            AndroidMenu_androidKt.DropdownMenu-IlH_yew(var65, var60, (Modifier)null, 0L, (ScrollState)null, (PopupProperties)null, (Shape)null, 0L, 0.0F, 0.0F, (BorderStroke)null, (Function3)ComposableLambdaKt.rememberComposableLambda(1423615960, true, OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153$lambda$152$lambda$151, $composer, 54), $composer, 48, 48, 2044);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(115446913);
            ComposerKt.sourceInformation($composer, "762@32365L11,759@32202L311");
            long expandedDropdown$delegate = TextUnitKt.getSp(12);
            long var6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            Modifier var10000 = (Modifier)Modifier.Companion;
            int var9 = 8;
            int var10 = 0;
            Modifier var8 = PaddingKt.padding-qDBjuR0$default(var10000, Dp.constructor-impl((float)var9), 0.0F, 0.0F, 0.0F, 14, (Object)null);
            TextKt.Text--4IGK_g("No meetings found", var8, var6, expandedDropdown$delegate, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3126, 0, 131056);
            $composer.endReplaceGroup();
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$155$lambda$154(MutableState $hasReminder$delegate, boolean it) {
      DetailedAddNoteDialog$lambda$117($hasReminder$delegate, it);
      return Unit.INSTANCE;
   }

   private static final void DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$163$lambda$161$lambda$160$lambda$159$lambda$158(int $year, int $month, int $day, MutableState $reminderTime$delegate, TimePicker var4, int hour, int minute) {
      Calendar var10_1 = Calendar.getInstance();
      int var11 = 0;
      var10_1.set($year, $month, $day, hour, minute, 0);
      long newTime = var10_1.getTimeInMillis();
      DetailedAddNoteDialog$lambda$123($reminderTime$delegate, newTime);
   }

   private static final void DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$163$lambda$161$lambda$160$lambda$159(Context $context, Calendar $c, MutableState $reminderTime$delegate, DatePicker var3, int year, int month, int day) {
      (new TimePickerDialog($context, OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$163$lambda$161$lambda$160$lambda$159$lambda$158, $c.get(11), $c.get(12), true)).show();
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$163$lambda$161$lambda$160(Context $context, long $currentReminder, MutableState $reminderTime$delegate) {
      Calendar var6_1 = Calendar.getInstance();
      int var7 = 0;
      var6_1.setTimeInMillis($currentReminder);
      (new DatePickerDialog($context, OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$163$lambda$161$lambda$160$lambda$159, var6_1.get(1), var6_1.get(2), var6_1.get(5))).show();
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$163$lambda$162(SimpleDateFormat $sdf, long $currentReminder, RowScope $this$OutlinedButton, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$OutlinedButton, "$this$OutlinedButton");
      ComposerKt.sourceInformation($composer, "C806@34753L39:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-181050077, $changed, -1, "com.example.DetailedAddNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:806)");
         }

         String var10000 = $sdf.format(new Date($currentReminder));
         Intrinsics.checkNotNullExpressionValue(var10000, "format(...)");
         TextKt.Text--4IGK_g(var10000, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
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
   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$163(Context $context, MutableState $reminderTime$delegate, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C780@33236L1333,805@34723L95,779@33182L1636:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1204261425, $changed, -1, "com.example.DetailedAddNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:777)");
         }

         Long var10000 = DetailedAddNoteDialog$lambda$122($reminderTime$delegate);
         long currentReminder = var10000 != null ? var10000 : System.currentTimeMillis();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
         ComposerKt.sourceInformationMarkerStart($composer, 1949036486, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var9 = $composer.changed(currentReminder) | $composer.changedInstance($context);
         int var10 = 0;
         Object var11 = $composer.rememberedValue();
         int var12 = 0;
         Object var16;
         if (!var9 && var11 != Composer.Companion.getEmpty()) {
            var16 = var11;
         } else {
            int var13 = 0;
            Object var14 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$163$lambda$161$lambda$160;
            $composer.updateRememberedValue(var14);
            var16 = var14;
         }

         Function0 var7 = (Function0)var16;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var17 = var7;
         Modifier var10001 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var15 = 12;
         int var8 = 0;
         ButtonKt.OutlinedButton(var17, var10001, false, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var15)), (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-181050077, true, OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$163$lambda$162, $composer, 54), $composer, 805306416, 500);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$166$lambda$165$lambda$164(Function5 $onAdd, MutableState $title$delegate, MutableState $content$delegate, MutableState $linkToday$delegate, MutableState $attachMeeting$delegate, MutableState $selectedMeeting$delegate, MutableState $hasReminder$delegate, MutableState $reminderTime$delegate) {
      $onAdd.invoke(DetailedAddNoteDialog$lambda$104($title$delegate), DetailedAddNoteDialog$lambda$107($content$delegate), DetailedAddNoteDialog$lambda$110($linkToday$delegate), DetailedAddNoteDialog$lambda$113($attachMeeting$delegate) ? DetailedAddNoteDialog$lambda$119($selectedMeeting$delegate) : null, DetailedAddNoteDialog$lambda$116($hasReminder$delegate) ? DetailedAddNoteDialog$lambda$122($reminderTime$delegate) : null);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit DetailedAddNoteDialog$lambda$169$lambda$168(MutableState $title$delegate, MutableState $content$delegate, MutableState $linkToday$delegate, MutableState $attachMeeting$delegate, List $meetings, MutableState $selectedMeeting$delegate, MutableState $hasReminder$delegate, Context $context, MutableState $reminderTime$delegate, Function0 $onDismiss, Function5 $onAdd, ColumnScope $this$Card, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
      ComposerKt.sourceInformation($composer, "C615@25146L21,612@25030L11253:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-799738751, $changed, -1, "com.example.DetailedAddNoteDialog.<anonymous>.<anonymous> (OtherScreens.kt:612)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var14 = 24;
         int var15 = 0;
         Modifier var97 = ScrollKt.verticalScroll$default(PaddingKt.padding-3ABfNKs(var10000, Dp.constructor-impl((float)var14)), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior)null, false, 14, (Object)null);
         var15 = 16;
         int var16 = 0;
         Arrangement.Vertical var99 = (Arrangement.Vertical)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var15));
         byte var18 = 48;
         int var19 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Alignment.Horizontal var100 = Alignment.Companion.getStart();
         MeasurePolicy var20 = ColumnKt.columnMeasurePolicy(var99, var100, $composer, 14 & var18 >> 3 | 112 & var18 >> 3);
         int var21 = 112 & var18 << 3;
         int var22 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var23 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var24 = $composer.getCurrentCompositionLocalMap();
         Modifier var25 = ComposedModifierKt.materializeModifier($composer, var97);
         Function0 var26 = ComposeUiNode.Companion.getConstructor();
         int var27 = 6 | 896 & var21 << 6;
         int var28 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var26);
         } else {
            $composer.useNode();
         }

         Composer var29 = Updater.constructor-impl($composer);
         int var30 = 0;
         Updater.set-impl(var29, var20, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var29, var24, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var31 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var32 = 0;
         int var34 = 0;
         if (var29.getInserting() || !Intrinsics.areEqual(var29.rememberedValue(), var23)) {
            var29.updateRememberedValue(var23);
            var29.apply(var23, var31);
         }

         Updater.set-impl(var29, var25, ComposeUiNode.Companion.getSetModifier());
         int var35 = 14 & var27 >> 6;
         int var37 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var38 = 6 | 112 & var18 >> 6;
         ColumnScope var221 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var41 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1116351295, "C622@25454L11,618@25268L228,632@25891L11,630@25766L246,627@25604L14,625@25514L627,639@26159L3086,709@29678L11,707@29553L246,703@29355L16,701@29263L665,722@30261L18,716@29946L351,731@30631L22,732@30685L1876,725@30315L2264,775@32923L20,776@32975L1865,769@32597L2261,811@34876L40,813@34934L1335:OtherScreens.kt#to5c3");
         long var42 = TextUnitKt.getSp(20);
         FontWeight var44 = FontWeight.Companion.getBold();
         long var45 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g("Create Context Note", (Modifier)null, var45, var42, (FontStyle)null, var44, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 131026);
         String var47 = DetailedAddNoteDialog$lambda$104($title$delegate);
         TextFieldColors var48 = OutlinedTextFieldDefaults.INSTANCE.colors-0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, (TextSelectionColors)null, ColorKt.getIndigo600(), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.15F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 0, 48, 3072, 0, 3072, 2139088895, 4095);
         int var49 = 16;
         int var50 = 0;
         RoundedCornerShape var101 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var49));
         Modifier var123 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         String var222 = var47;
         ComposerKt.sourceInformationMarkerStart($composer, 36011097, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var52 = false;
         int var53 = 0;
         Object var54 = $composer.rememberedValue();
         int var55 = 0;
         Object var237;
         if (var54 == Composer.Companion.getEmpty()) {
            int var57 = 0;
            Function1 var10001 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$125$lambda$124;
            var222 = var47;
            Object var58 = var10001;
            $composer.updateRememberedValue(var58);
            var237 = var58;
         } else {
            var237 = var54;
         }

         Function1 var129 = (Function1)var237;
         ComposerKt.sourceInformationMarkerEnd($composer);
         OutlinedTextFieldKt.OutlinedTextField(var222, var129, var123, false, false, (TextStyle)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$-1471712271$app(), (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, false, (VisualTransformation)null, (KeyboardOptions)null, (KeyboardActions)null, true, 0, 0, (MutableInteractionSource)null, (Shape)var101, var48, $composer, 1573296, 12582912, 0, 1966008);
         Modifier var110 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var117 = 8;
         int var102 = 0;
         Arrangement.Horizontal var118 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var117));
         Alignment.Vertical var103 = Alignment.Companion.getCenterVertically();
         int var130 = 438;
         int var51 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         MeasurePolicy var141 = RowKt.rowMeasurePolicy(var118, var103, $composer, 14 & var130 >> 3 | 112 & var130 >> 3);
         var53 = 112 & var130 << 3;
         int var150 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var55 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var158 = $composer.getCurrentCompositionLocalMap();
         Modifier var161 = ComposedModifierKt.materializeModifier($composer, var110);
         Function0 var59 = ComposeUiNode.Companion.getConstructor();
         int var60 = 6 | 896 & var53 << 6;
         int var61 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var59);
         } else {
            $composer.useNode();
         }

         Composer var62 = Updater.constructor-impl($composer);
         int var63 = 0;
         Updater.set-impl(var62, var141, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var62, var158, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var64 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var65 = 0;
         int var67 = 0;
         if (var62.getInserting() || !Intrinsics.areEqual(var62.rememberedValue(), var55)) {
            var62.updateRememberedValue(var55);
            var62.apply(var55, var64);
         }

         Updater.set-impl(var62, var161, ComposeUiNode.Companion.getSetModifier());
         int var68 = 14 & var60 >> 6;
         int var70 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var71 = 6 | 112 & var130 >> 6;
         RowScope var223 = (RowScope)RowScopeInstance.INSTANCE;
         int var74 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1845627760, "C648@26582L11,644@26399L248,651@26714L333,660@27171L40,650@26668L648,664@27383L329,673@27838L40,663@27337L646,677@28050L905,696@29082L40,676@28004L1223:OtherScreens.kt#to5c3");
         long var75 = TextUnitKt.getSp(12);
         FontWeight var77 = FontWeight.Companion.getBold();
         long var78 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         TextKt.Text--4IGK_g("Insert:", (Modifier)null, var78, var75, (FontStyle)null, var77, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 131026);
         ComposerKt.sourceInformationMarkerStart($composer, -217550700, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var176 = (boolean)0;
         int var81 = 0;
         Object var82 = $composer.rememberedValue();
         int var83 = 0;
         Object var224;
         if (var82 == Composer.Companion.getEmpty()) {
            int var84 = 0;
            Object var85 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$132$lambda$127$lambda$126;
            $composer.updateRememberedValue(var85);
            var224 = var85;
         } else {
            var224 = var82;
         }

         Function0 var86 = (Function0)var224;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var225 = var86;
         Function2 var238 = ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$314074980$app();
         ChipColors var10007 = AssistChipDefaults.INSTANCE.assistChipColors-oq7We08(0L, ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, $composer, 48 | AssistChipDefaults.$stable << 24, 253);
         int var198 = 1;
         int var80 = 0;
         ChipKt.AssistChip(var225, var238, (Modifier)null, false, (Function2)null, (Function2)null, (Shape)null, var10007, (ChipElevation)null, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var198), Color.copy-wmQWz5c$default(ColorKt.getIndigo600(), 0.3F, 0.0F, 0.0F, 0.0F, 14, (Object)null)), (MutableInteractionSource)null, $composer, 805306422, 0, 1404);
         ComposerKt.sourceInformationMarkerStart($composer, -217529296, "CC(remember):OtherScreens.kt#9igjgp");
         var176 = (boolean)0;
         var81 = 0;
         var82 = $composer.rememberedValue();
         var83 = 0;
         Object var226;
         if (var82 == Composer.Companion.getEmpty()) {
            int var192 = 0;
            Object var195 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$132$lambda$129$lambda$128;
            $composer.updateRememberedValue(var195);
            var226 = var195;
         } else {
            var226 = var82;
         }

         Function0 var199 = (Function0)var226;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var227 = var199;
         var238 = ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$924639373$app();
         var10007 = AssistChipDefaults.INSTANCE.assistChipColors-oq7We08(0L, ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, $composer, 48 | AssistChipDefaults.$stable << 24, 253);
         int var200 = 1;
         var80 = 0;
         ChipKt.AssistChip(var227, var238, (Modifier)null, false, (Function2)null, (Function2)null, (Shape)null, var10007, (ChipElevation)null, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var200), Color.copy-wmQWz5c$default(ColorKt.getIndigo600(), 0.3F, 0.0F, 0.0F, 0.0F, 14, (Object)null)), (MutableInteractionSource)null, $composer, 805306422, 0, 1404);
         ComposerKt.sourceInformationMarkerStart($composer, -217507376, "CC(remember):OtherScreens.kt#9igjgp");
         var176 = (boolean)0;
         var81 = 0;
         var82 = $composer.rememberedValue();
         var83 = 0;
         Object var228;
         if (var82 == Composer.Companion.getEmpty()) {
            int var193 = 0;
            Object var196 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$132$lambda$131$lambda$130;
            $composer.updateRememberedValue(var196);
            var228 = var196;
         } else {
            var228 = var82;
         }

         Function0 var201 = (Function0)var228;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var229 = var201;
         var238 = ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$265573292$app();
         var10007 = AssistChipDefaults.INSTANCE.assistChipColors-oq7We08(0L, ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, $composer, 48 | AssistChipDefaults.$stable << 24, 253);
         int var202 = 1;
         var80 = 0;
         ChipKt.AssistChip(var229, var238, (Modifier)null, false, (Function2)null, (Function2)null, (Shape)null, var10007, (ChipElevation)null, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var202), Color.copy-wmQWz5c$default(ColorKt.getIndigo600(), 0.3F, 0.0F, 0.0F, 0.0F, 14, (Object)null)), (MutableInteractionSource)null, $composer, 805306422, 0, 1404);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         String var111 = DetailedAddNoteDialog$lambda$107($content$delegate);
         TextFieldColors var119 = OutlinedTextFieldDefaults.INSTANCE.colors-0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, (TextSelectionColors)null, ColorKt.getIndigo600(), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.15F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 0, 48, 3072, 0, 3072, 2139088895, 4095);
         int var124 = 16;
         var130 = 0;
         RoundedCornerShape var104 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var124));
         Modifier var125 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         String var230 = var111;
         ComposerKt.sourceInformationMarkerStart($composer, 36131131, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var142 = (boolean)0;
         var53 = 0;
         Object var151 = $composer.rememberedValue();
         var55 = 0;
         Object var242;
         if (var151 == Composer.Companion.getEmpty()) {
            int var159 = 0;
            Function1 var241 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$134$lambda$133;
            var230 = var111;
            Object var162 = var241;
            $composer.updateRememberedValue(var162);
            var242 = var162;
         } else {
            var242 = var151;
         }

         Function1 var132 = (Function1)var242;
         ComposerKt.sourceInformationMarkerEnd($composer);
         OutlinedTextFieldKt.OutlinedTextField(var230, var132, var125, false, false, (TextStyle)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$-1692449126$app(), (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, false, (VisualTransformation)null, (KeyboardOptions)null, (KeyboardActions)null, false, 6, 3, (MutableInteractionSource)null, (Shape)var104, var119, $composer, 1573296, 905969664, 0, 1310648);
         ImageVector var231 = DateRangeKt.getDateRange(Icons.INSTANCE.getDefault());
         long var243 = ColorKt.getIndigo600();
         String var10002 = "Link to Current Day";
         String var10003 = "Associate this note with today's schedule";
         boolean var10004 = DetailedAddNoteDialog$lambda$110($linkToday$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 36160125, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var105 = (boolean)0;
         int var126 = 0;
         Object var133 = $composer.rememberedValue();
         var51 = 0;
         Object var10005;
         if (var133 == Composer.Companion.getEmpty()) {
            boolean var87 = var10004;
            String var88 = "Associate this note with today's schedule";
            String var89 = "Link to Current Day";
            long var90 = var243;
            ImageVector var56 = var231;
            var142 = (boolean)0;
            Function1 var53_5 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$136$lambda$135;
            var231 = var56;
            var243 = var90;
            var10002 = var89;
            var10003 = var88;
            var10004 = var87;
            $composer.updateRememberedValue(var53_5);
            var10005 = var53_5;
         } else {
            var10005 = var133;
         }

         Function1 var112 = (Function1)var10005;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NoteOptionRow-oC9nPe0(var231, var243, var10002, var10003, var10004, var112, (Function2)null, $composer, 200112, 64);
         var231 = MeetingRoomKt.getMeetingRoom(Icons.INSTANCE.getDefault());
         var243 = ColorKt.getTeal600();
         var10002 = "Attach to Meeting";
         var10003 = "Link note to an event from your calendar";
         var10004 = DetailedAddNoteDialog$lambda$113($attachMeeting$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 36171969, "CC(remember):OtherScreens.kt#9igjgp");
         var105 = (boolean)0;
         var126 = 0;
         var133 = $composer.rememberedValue();
         var51 = 0;
         if (var133 == Composer.Companion.getEmpty()) {
            boolean var204 = var10004;
            String var206 = "Link note to an event from your calendar";
            String var208 = "Attach to Meeting";
            long var210 = var243;
            ImageVector var156 = var231;
            var142 = (boolean)0;
            Function1 var53_5 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$138$lambda$137;
            var231 = var156;
            var243 = var210;
            var10002 = var208;
            var10003 = var206;
            var10004 = var204;
            $composer.updateRememberedValue(var53_5);
            var10005 = var53_5;
         } else {
            var10005 = var133;
         }

         var112 = (Function1)var10005;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NoteOptionRow-oC9nPe0(var231, var243, var10002, var10003, var10004, var112, (Function2)ComposableLambdaKt.rememberComposableLambda(1321898194, true, OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$153, $composer, 54), $composer, 1772976, 0);
         var231 = NotificationsKt.getNotifications(Icons.INSTANCE.getDefault());
         var243 = ColorKt.getIndigo600();
         var10002 = "Set Review Reminder";
         var10003 = "Schedule a reminder notification for this note";
         var10004 = DetailedAddNoteDialog$lambda$116($hasReminder$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 36245311, "CC(remember):OtherScreens.kt#9igjgp");
         var105 = (boolean)0;
         var126 = 0;
         var133 = $composer.rememberedValue();
         var51 = 0;
         if (var133 == Composer.Companion.getEmpty()) {
            boolean var205 = var10004;
            String var207 = "Schedule a reminder notification for this note";
            String var209 = "Set Review Reminder";
            long var211 = var243;
            ImageVector var157 = var231;
            var142 = (boolean)0;
            Function1 var53_5 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$155$lambda$154;
            var231 = var157;
            var243 = var211;
            var10002 = var209;
            var10003 = var207;
            var10004 = var205;
            $composer.updateRememberedValue(var53_5);
            var10005 = var53_5;
         } else {
            var10005 = var133;
         }

         var112 = (Function1)var10005;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NoteOptionRow-oC9nPe0(var231, var243, var10002, var10003, var10004, var112, (Function2)ComposableLambdaKt.rememberComposableLambda(1204261425, true, OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$163, $composer, 54), $composer, 1772976, 0);
         Modifier var234 = (Modifier)Modifier.Companion;
         int var115 = 8;
         int var120 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var234, Dp.constructor-impl((float)var115)), $composer, 6);
         Modifier var116 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var120 = 12;
         var105 = (boolean)0;
         Arrangement.Horizontal var122 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var120));
         byte var136 = 54;
         var51 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Alignment.Vertical var109 = Alignment.Companion.getTop();
         MeasurePolicy var146 = RowKt.rowMeasurePolicy(var122, var109, $composer, 14 & var136 >> 3 | 112 & var136 >> 3);
         var53 = 112 & var136 << 3;
         int var152 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var55 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var158 = $composer.getCurrentCompositionLocalMap();
         var161 = ComposedModifierKt.materializeModifier($composer, var116);
         var59 = ComposeUiNode.Companion.getConstructor();
         var60 = 6 | 896 & var53 << 6;
         var61 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var59);
         } else {
            $composer.useNode();
         }

         var62 = Updater.constructor-impl($composer);
         var63 = 0;
         Updater.set-impl(var62, var146, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var62, var158, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var64 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var65 = 0;
         var67 = 0;
         if (var62.getInserting() || !Intrinsics.areEqual(var62.rememberedValue(), var55)) {
            var62.updateRememberedValue(var55);
            var62.apply(var55, var64);
         }

         Updater.set-impl(var62, var161, ComposeUiNode.Companion.getSetModifier());
         var68 = 14 & var60 >> 6;
         var70 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         var71 = 6 | 112 & var136 >> 6;
         RowScope var73 = (RowScope)RowScopeInstance.INSTANCE;
         var74 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1733875131, "C817@35107L363,835@36023L94,827@35533L175,826@35491L760:OtherScreens.kt#to5c3");
         Modifier var246 = RowScope.weight$default(var73, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         int var93 = 48;
         int var94 = 0;
         var246 = SizeKt.height-3ABfNKs(var246, Dp.constructor-impl((float)var93));
         var93 = 14;
         var94 = 0;
         ButtonKt.OutlinedButton($onDismiss, var246, false, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var93)), (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$1256216286$app(), $composer, 805306368, 500);
         var93 = !StringsKt.isBlank((CharSequence)DetailedAddNoteDialog$lambda$104($title$delegate)) && !StringsKt.isBlank((CharSequence)DetailedAddNoteDialog$lambda$107($content$delegate));
         var234 = RowScope.weight$default(var73, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         var176 = (boolean)48;
         int var95 = 0;
         Modifier var217 = SizeKt.height-3ABfNKs(var234, Dp.constructor-impl((float)var176));
         var95 = 14;
         int var96 = 0;
         RoundedCornerShape var180 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var95));
         ButtonColors var219 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(ColorKt.getIndigo600(), 0L, 0L, 0L, $composer, 6 | ButtonDefaults.$stable << 12, 14);
         ComposerKt.sourceInformationMarkerStart($composer, 333038783, "CC(remember):OtherScreens.kt#9igjgp");
         var81 = $composer.changed($onAdd);
         int var188 = 0;
         Object var191 = $composer.rememberedValue();
         int var194 = 0;
         Object var236;
         if (!var81 && var191 != Composer.Companion.getEmpty()) {
            var236 = var191;
         } else {
            int var197 = 0;
            Object var203 = OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168$lambda$167$lambda$166$lambda$165$lambda$164;
            $composer.updateRememberedValue(var203);
            var236 = var203;
         }

         Function0 var220 = (Function0)var236;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.Button(var220, var217, (boolean)var93, (Shape)var180, var219, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$-167229920$app(), $composer, 805306368, 480);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
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
   private static final Unit DetailedAddNoteDialog$lambda$169(MutableState $title$delegate, MutableState $content$delegate, MutableState $linkToday$delegate, MutableState $attachMeeting$delegate, List $meetings, MutableState $selectedMeeting$delegate, MutableState $hasReminder$delegate, Context $context, MutableState $reminderTime$delegate, Function0 $onDismiss, Function5 $onAdd, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C608@24892L11,607@24833L95,610@24967L38,611@25016L11277,601@24601L11692:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-631751885, $changed, -1, "com.example.DetailedAddNoteDialog.<anonymous> (OtherScreens.kt:601)");
         }

         Modifier var10000 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), (Alignment.Vertical)null, false, 3, (Object)null);
         int var13 = 24;
         int var14 = 0;
         var10000 = PaddingKt.padding-VpY3zN4$default(var10000, 0.0F, Dp.constructor-impl((float)var13), 1, (Object)null);
         var13 = 28;
         var14 = 0;
         Shape var10001 = (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var13));
         CardColors var10002 = CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getBackground-0d7_KjU(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
         var13 = 8;
         var14 = 0;
         CardKt.Card(var10000, var10001, var10002, CardDefaults.INSTANCE.cardElevation-aqJV_2Y(Dp.constructor-impl((float)var13), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, $composer, 6 | CardDefaults.$stable << 18, 62), (BorderStroke)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-799738751, true, OtherScreensKt::DetailedAddNoteDialog$lambda$169$lambda$168, $composer, 54), $composer, 196614, 16);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DetailedAddNoteDialog$lambda$170(List $meetings, Function0 $onDismiss, Function5 $onAdd, int $$changed, Composer $composer, int $force) {
      DetailedAddNoteDialog($meetings, $onDismiss, $onAdd, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final String DetailedEditNoteDialog$lambda$172(MutableState $title$delegate) {
      State var1 = (State)$title$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)var1.getValue();
   }

   private static final void DetailedEditNoteDialog$lambda$173(MutableState $title$delegate, String var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $title$delegate.setValue(var1);
   }

   private static final String DetailedEditNoteDialog$lambda$175(MutableState $content$delegate) {
      State var1 = (State)$content$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)var1.getValue();
   }

   private static final void DetailedEditNoteDialog$lambda$176(MutableState $content$delegate, String var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $content$delegate.setValue(var1);
   }

   private static final boolean DetailedEditNoteDialog$lambda$178(MutableState $linkToday$delegate) {
      State var1 = (State)$linkToday$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void DetailedEditNoteDialog$lambda$179(MutableState $linkToday$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $linkToday$delegate.setValue(var5);
   }

   private static final boolean DetailedEditNoteDialog$lambda$181(MutableState $attachMeeting$delegate) {
      State var1 = (State)$attachMeeting$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void DetailedEditNoteDialog$lambda$182(MutableState $attachMeeting$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $attachMeeting$delegate.setValue(var5);
   }

   private static final boolean DetailedEditNoteDialog$lambda$184(MutableState $hasReminder$delegate) {
      State var1 = (State)$hasReminder$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void DetailedEditNoteDialog$lambda$185(MutableState $hasReminder$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $hasReminder$delegate.setValue(var5);
   }

   private static final MeetingItem DetailedEditNoteDialog$lambda$188(MutableState $selectedMeeting$delegate) {
      State var1 = (State)$selectedMeeting$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (MeetingItem)var1.getValue();
   }

   private static final void DetailedEditNoteDialog$lambda$189(MutableState $selectedMeeting$delegate, MeetingItem var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $selectedMeeting$delegate.setValue(var1);
   }

   private static final Long DetailedEditNoteDialog$lambda$191(MutableState $reminderTime$delegate) {
      State var1 = (State)$reminderTime$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Long)var1.getValue();
   }

   private static final void DetailedEditNoteDialog$lambda$192(MutableState $reminderTime$delegate, Long var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $reminderTime$delegate.setValue(var1);
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$195$lambda$194(MutableState $title$delegate, String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      DetailedEditNoteDialog$lambda$173($title$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$202$lambda$197$lambda$196(MutableState $content$delegate) {
      String newText = ((CharSequence)DetailedEditNoteDialog$lambda$175($content$delegate)).length() != 0 && !StringsKt.endsWith$default(DetailedEditNoteDialog$lambda$175($content$delegate), "\n", false, 2, (Object)null) ? DetailedEditNoteDialog$lambda$175($content$delegate) + "\n[ ] " : DetailedEditNoteDialog$lambda$175($content$delegate) + "[ ] ";
      DetailedEditNoteDialog$lambda$176($content$delegate, newText);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$202$lambda$199$lambda$198(MutableState $content$delegate) {
      String newText = ((CharSequence)DetailedEditNoteDialog$lambda$175($content$delegate)).length() != 0 && !StringsKt.endsWith$default(DetailedEditNoteDialog$lambda$175($content$delegate), "\n", false, 2, (Object)null) ? DetailedEditNoteDialog$lambda$175($content$delegate) + "\n- " : DetailedEditNoteDialog$lambda$175($content$delegate) + "- ";
      DetailedEditNoteDialog$lambda$176($content$delegate, newText);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$202$lambda$201$lambda$200(MutableState $content$delegate) {
      CharSequence var10000 = (CharSequence)DetailedEditNoteDialog$lambda$175($content$delegate);
      String[] var2 = new String[]{"\n"};
      List lines = StringsKt.split$default(var10000, var2, false, 0, 6, (Object)null);
      int nextNum = 1;
      int var3 = ((Collection)lines).size() + -1;
      if (0 <= var3) {
         do {
            int i = var3--;
            String line = StringsKt.trim((CharSequence)((String)lines.get(i))).toString();
            MatchResult match = Regex.find$default(new Regex("^(\\d+)\\.\\s.*"), (CharSequence)line, 0, 2, (Object)null);
            if (match != null) {
               Integer var9 = StringsKt.toIntOrNull((String)match.getGroupValues().get(1));
               nextNum = (var9 != null ? var9 : 0) + 1;
               break;
            }
         } while(0 <= var3);
      }

      String newText = ((CharSequence)DetailedEditNoteDialog$lambda$175($content$delegate)).length() != 0 && !StringsKt.endsWith$default(DetailedEditNoteDialog$lambda$175($content$delegate), "\n", false, 2, (Object)null) ? DetailedEditNoteDialog$lambda$175($content$delegate) + "\n" + nextNum + ". " : DetailedEditNoteDialog$lambda$175($content$delegate) + nextNum + ". ";
      DetailedEditNoteDialog$lambda$176($content$delegate, newText);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$204$lambda$203(MutableState $content$delegate, String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      DetailedEditNoteDialog$lambda$176($content$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$206$lambda$205(MutableState $linkToday$delegate, boolean it) {
      DetailedEditNoteDialog$lambda$179($linkToday$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$208$lambda$207(MutableState $attachMeeting$delegate, boolean it) {
      DetailedEditNoteDialog$lambda$182($attachMeeting$delegate, it);
      return Unit.INSTANCE;
   }

   private static final boolean DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$210(MutableState $expandedDropdown$delegate) {
      State var1 = (State)$expandedDropdown$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$211(MutableState $expandedDropdown$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $expandedDropdown$delegate.setValue(var5);
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$213$lambda$212(MutableState $expandedDropdown$delegate) {
      DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$211($expandedDropdown$delegate, true);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$214(MutableState $selectedMeeting$delegate, RowScope $this$OutlinedButton, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$OutlinedButton, "$this$OutlinedButton");
      ComposerKt.sourceInformation($composer, "C1016@44018L54:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-537328309, $changed, -1, "com.example.DetailedEditNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1016)");
         }

         String var4;
         label20: {
            MeetingItem var10000 = DetailedEditNoteDialog$lambda$188($selectedMeeting$delegate);
            if (var10000 != null) {
               var4 = var10000.getTitle();
               if (var4 != null) {
                  break label20;
               }
            }

            var4 = "Select Meeting Event";
         }

         TextKt.Text--4IGK_g(var4, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$216$lambda$215(MutableState $expandedDropdown$delegate) {
      DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$211($expandedDropdown$delegate, false);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$221$lambda$220$lambda$217(MeetingItem $event, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1024@44513L17:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(405923703, $changed, -1, "com.example.DetailedEditNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1024)");
         }

         TextKt.Text--4IGK_g($event.getTitle(), (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$221$lambda$220$lambda$219$lambda$218(MeetingItem $event, MutableState $selectedMeeting$delegate, MutableState $expandedDropdown$delegate) {
      DetailedEditNoteDialog$lambda$189($selectedMeeting$delegate, $event);
      DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$211($expandedDropdown$delegate, false);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$221(List $meetings, MutableState $selectedMeeting$delegate, MutableState $expandedDropdown$delegate, ColumnScope $this$DropdownMenu, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$DropdownMenu, "$this$DropdownMenu");
      ComposerKt.sourceInformation($composer, "C*1024@44511L21,1025@44588L192,1023@44442L380:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1846080834, $changed, -1, "com.example.DetailedEditNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1022)");
         }

         Iterable var6 = (Iterable)$meetings;
         int var7 = 0;

         for(Object var9 : var6) {
            MeetingItem var10 = (MeetingItem)var9;
            int var11 = 0;
            Function2 var10000 = (Function2)ComposableLambdaKt.rememberComposableLambda(405923703, true, OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$221$lambda$220$lambda$217, $composer, 54);
            ComposerKt.sourceInformationMarkerStart($composer, -847886105, "CC(remember):OtherScreens.kt#9igjgp");
            boolean var13 = $composer.changed(var10);
            int var14 = 0;
            Object var15 = $composer.rememberedValue();
            int var16 = 0;
            Object var21;
            if (!var13 && var15 != Composer.Companion.getEmpty()) {
               var21 = var15;
            } else {
               Function2 var17 = var10000;
               int var18 = 0;
               Function0 var10001 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$221$lambda$220$lambda$219$lambda$218;
               var10000 = var17;
               Object var19 = var10001;
               $composer.updateRememberedValue(var19);
               var21 = var19;
            }

            Function0 var20 = (Function0)var21;
            ComposerKt.sourceInformationMarkerEnd($composer);
            AndroidMenu_androidKt.DropdownMenuItem(var10000, var20, (Modifier)null, (Function2)null, (Function2)null, false, (MenuItemColors)null, (PaddingValues)null, (MutableInteractionSource)null, $composer, 6, 508);
         }

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
   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223(List $meetings, MutableState $selectedMeeting$delegate, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-952152904, $changed, -1, "com.example.DetailedEditNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1008)");
         }

         if (!((Collection)$meetings).isEmpty()) {
            $composer.startReplaceGroup(-1623043434);
            ComposerKt.sourceInformation($composer, "1009@43576L34,1010@43639L1285");
            ComposerKt.sourceInformationMarkerStart($composer, -190903238, "CC(remember):OtherScreens.kt#9igjgp");
            boolean var7 = false;
            int var47 = 0;
            Object var48 = $composer.rememberedValue();
            int var50 = 0;
            Object var61;
            if (var48 == Composer.Companion.getEmpty()) {
               int var11 = 0;
               Object var52 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy)null, 2, (Object)null);
               $composer.updateRememberedValue(var52);
               var61 = var52;
            } else {
               var61 = var48;
            }

            MutableState var5 = (MutableState)var61;
            ComposerKt.sourceInformationMarkerEnd($composer);
            MutableState expandedDropdown$delegate = var5;
            Modifier var44 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            int var49 = 6;
            var50 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment var45 = Alignment.Companion.getTopStart();
            var7 = false;
            MeasurePolicy var53 = BoxKt.maybeCachedBoxMeasurePolicy(var45, var7);
            int var12 = 112 & var49 << 3;
            int var13 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var14 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var15 = $composer.getCurrentCompositionLocalMap();
            Modifier var16 = ComposedModifierKt.materializeModifier($composer, var44);
            Function0 var17 = ComposeUiNode.Companion.getConstructor();
            int var18 = 6 | 896 & var12 << 6;
            int var19 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var17);
            } else {
               $composer.useNode();
            }

            Composer var20 = Updater.constructor-impl($composer);
            int var21 = 0;
            Updater.set-impl(var20, var53, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var20, var15, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var23 = 0;
            int var25 = 0;
            if (var20.getInserting() || !Intrinsics.areEqual(var20.rememberedValue(), var14)) {
               var20.updateRememberedValue(var14);
               var20.apply(var14, var22);
            }

            Updater.set-impl(var20, var16, ComposeUiNode.Companion.getSetModifier());
            int var26 = 14 & var18 >> 6;
            int var28 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            int var29 = 6 | 112 & var49 >> 6;
            BoxScope var62 = (BoxScope)BoxScopeInstance.INSTANCE;
            int var32 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -891347763, "C1012@43775L27,1015@43980L126,1011@43713L393,1020@44273L28,1021@44336L558,1018@44139L755:OtherScreens.kt#to5c3");
            ComposerKt.sourceInformationMarkerStart($composer, -305846988, "CC(remember):OtherScreens.kt#9igjgp");
            boolean var34 = false;
            int var35 = 0;
            Object var36 = $composer.rememberedValue();
            int var37 = 0;
            Object var63;
            if (var36 == Composer.Companion.getEmpty()) {
               int var38 = 0;
               Object var39 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$213$lambda$212;
               $composer.updateRememberedValue(var39);
               var63 = var39;
            } else {
               var63 = var36;
            }

            Function0 var40 = (Function0)var63;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var64 = var40;
            Modifier var10001 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            int var59 = 12;
            int var33 = 0;
            ButtonKt.OutlinedButton(var64, var10001, false, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var59)), (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-537328309, true, OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$214, $composer, 54), $composer, 805306422, 500);
            boolean var65 = DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$210(expandedDropdown$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -305831051, "CC(remember):OtherScreens.kt#9igjgp");
            var34 = false;
            var35 = 0;
            var36 = $composer.rememberedValue();
            var37 = 0;
            Object var66;
            if (var36 == Composer.Companion.getEmpty()) {
               boolean var41 = var65;
               int var58 = 0;
               Function0 var39_4 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$216$lambda$215;
               var65 = var41;
               $composer.updateRememberedValue(var39_4);
               var66 = var39_4;
            } else {
               var66 = var36;
            }

            Function0 var60 = (Function0)var66;
            ComposerKt.sourceInformationMarkerEnd($composer);
            AndroidMenu_androidKt.DropdownMenu-IlH_yew(var65, var60, (Modifier)null, 0L, (ScrollState)null, (PopupProperties)null, (Shape)null, 0L, 0.0F, 0.0F, (BorderStroke)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-1846080834, true, OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223$lambda$222$lambda$221, $composer, 54), $composer, 48, 48, 2044);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-1621653797);
            ComposerKt.sourceInformation($composer, "1037@45149L11,1034@44986L311");
            long expandedDropdown$delegate = TextUnitKt.getSp(12);
            long var6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            Modifier var10000 = (Modifier)Modifier.Companion;
            int var9 = 8;
            int var10 = 0;
            Modifier var8 = PaddingKt.padding-qDBjuR0$default(var10000, Dp.constructor-impl((float)var9), 0.0F, 0.0F, 0.0F, 14, (Object)null);
            TextKt.Text--4IGK_g("No meetings found", var8, var6, expandedDropdown$delegate, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3126, 0, 131056);
            $composer.endReplaceGroup();
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$225$lambda$224(MutableState $hasReminder$delegate, boolean it) {
      DetailedEditNoteDialog$lambda$185($hasReminder$delegate, it);
      return Unit.INSTANCE;
   }

   private static final void DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$233$lambda$231$lambda$230$lambda$229$lambda$228(int $year, int $month, int $day, MutableState $reminderTime$delegate, TimePicker var4, int hour, int minute) {
      Calendar var10_1 = Calendar.getInstance();
      int var11 = 0;
      var10_1.set($year, $month, $day, hour, minute, 0);
      long newTime = var10_1.getTimeInMillis();
      DetailedEditNoteDialog$lambda$192($reminderTime$delegate, newTime);
   }

   private static final void DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$233$lambda$231$lambda$230$lambda$229(Context $context, Calendar $c, MutableState $reminderTime$delegate, DatePicker var3, int year, int month, int day) {
      (new TimePickerDialog($context, OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$233$lambda$231$lambda$230$lambda$229$lambda$228, $c.get(11), $c.get(12), true)).show();
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$233$lambda$231$lambda$230(Context $context, long $currentReminder, MutableState $reminderTime$delegate) {
      Calendar var6_1 = Calendar.getInstance();
      int var7 = 0;
      var6_1.setTimeInMillis($currentReminder);
      (new DatePickerDialog($context, OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$233$lambda$231$lambda$230$lambda$229, var6_1.get(1), var6_1.get(2), var6_1.get(5))).show();
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$233$lambda$232(SimpleDateFormat $sdf, long $currentReminder, RowScope $this$OutlinedButton, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$OutlinedButton, "$this$OutlinedButton");
      ComposerKt.sourceInformation($composer, "C1081@47537L39:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(394342281, $changed, -1, "com.example.DetailedEditNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1081)");
         }

         String var10000 = $sdf.format(new Date($currentReminder));
         Intrinsics.checkNotNullExpressionValue(var10000, "format(...)");
         TextKt.Text--4IGK_g(var10000, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
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
   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$233(Context $context, MutableState $reminderTime$delegate, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1055@46020L1333,1080@47507L95,1054@45966L1636:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(845297559, $changed, -1, "com.example.DetailedEditNoteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1052)");
         }

         Long var10000 = DetailedEditNoteDialog$lambda$191($reminderTime$delegate);
         long currentReminder = var10000 != null ? var10000 : System.currentTimeMillis();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
         ComposerKt.sourceInformationMarkerStart($composer, 582144940, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var9 = $composer.changed(currentReminder) | $composer.changedInstance($context);
         int var10 = 0;
         Object var11 = $composer.rememberedValue();
         int var12 = 0;
         Object var16;
         if (!var9 && var11 != Composer.Companion.getEmpty()) {
            var16 = var11;
         } else {
            int var13 = 0;
            Object var14 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$233$lambda$231$lambda$230;
            $composer.updateRememberedValue(var14);
            var16 = var14;
         }

         Function0 var7 = (Function0)var16;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var17 = var7;
         Modifier var10001 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var15 = 12;
         int var8 = 0;
         ButtonKt.OutlinedButton(var17, var10001, false, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var15)), (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, (Function3)ComposableLambdaKt.rememberComposableLambda(394342281, true, OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$233$lambda$232, $composer, 54), $composer, 805306416, 500);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$236$lambda$235$lambda$234(Function5 $onSave, MutableState $title$delegate, MutableState $content$delegate, MutableState $linkToday$delegate, MutableState $attachMeeting$delegate, MutableState $selectedMeeting$delegate, MutableState $hasReminder$delegate, MutableState $reminderTime$delegate) {
      $onSave.invoke(DetailedEditNoteDialog$lambda$172($title$delegate), DetailedEditNoteDialog$lambda$175($content$delegate), DetailedEditNoteDialog$lambda$178($linkToday$delegate), DetailedEditNoteDialog$lambda$181($attachMeeting$delegate) ? DetailedEditNoteDialog$lambda$188($selectedMeeting$delegate) : null, DetailedEditNoteDialog$lambda$184($hasReminder$delegate) ? DetailedEditNoteDialog$lambda$191($reminderTime$delegate) : null);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit DetailedEditNoteDialog$lambda$239$lambda$238(MutableState $title$delegate, MutableState $content$delegate, MutableState $linkToday$delegate, MutableState $attachMeeting$delegate, List $meetings, MutableState $selectedMeeting$delegate, MutableState $hasReminder$delegate, Context $context, MutableState $reminderTime$delegate, Function0 $onDismiss, Function5 $onSave, ColumnScope $this$Card, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
      ComposerKt.sourceInformation($composer, "C890@37932L21,887@37816L11252:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(14590439, $changed, -1, "com.example.DetailedEditNoteDialog.<anonymous>.<anonymous> (OtherScreens.kt:887)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var14 = 24;
         int var15 = 0;
         Modifier var97 = ScrollKt.verticalScroll$default(PaddingKt.padding-3ABfNKs(var10000, Dp.constructor-impl((float)var14)), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior)null, false, 14, (Object)null);
         var15 = 16;
         int var16 = 0;
         Arrangement.Vertical var99 = (Arrangement.Vertical)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var15));
         byte var18 = 48;
         int var19 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Alignment.Horizontal var100 = Alignment.Companion.getStart();
         MeasurePolicy var20 = ColumnKt.columnMeasurePolicy(var99, var100, $composer, 14 & var18 >> 3 | 112 & var18 >> 3);
         int var21 = 112 & var18 << 3;
         int var22 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var23 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var24 = $composer.getCurrentCompositionLocalMap();
         Modifier var25 = ComposedModifierKt.materializeModifier($composer, var97);
         Function0 var26 = ComposeUiNode.Companion.getConstructor();
         int var27 = 6 | 896 & var21 << 6;
         int var28 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var26);
         } else {
            $composer.useNode();
         }

         Composer var29 = Updater.constructor-impl($composer);
         int var30 = 0;
         Updater.set-impl(var29, var20, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var29, var24, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var31 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var32 = 0;
         int var34 = 0;
         if (var29.getInserting() || !Intrinsics.areEqual(var29.rememberedValue(), var23)) {
            var29.updateRememberedValue(var23);
            var29.apply(var23, var31);
         }

         Updater.set-impl(var29, var25, ComposeUiNode.Companion.getSetModifier());
         int var35 = 14 & var27 >> 6;
         int var37 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var38 = 6 | 112 & var18 >> 6;
         ColumnScope var221 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var41 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -362857734, "C897@38238L11,893@38054L226,907@38675L11,905@38550L246,902@38388L14,900@38298L627,914@38943L3086,984@42462L11,982@42337L246,978@42139L16,976@42047L665,997@43045L18,991@42730L351,1006@43415L22,1007@43469L1876,1000@43099L2264,1050@45707L20,1051@45759L1865,1044@45381L2261,1086@47660L40,1088@47718L1336:OtherScreens.kt#to5c3");
         long var42 = TextUnitKt.getSp(20);
         FontWeight var44 = FontWeight.Companion.getBold();
         long var45 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g("Edit Context Note", (Modifier)null, var45, var42, (FontStyle)null, var44, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 131026);
         String var47 = DetailedEditNoteDialog$lambda$172($title$delegate);
         TextFieldColors var48 = OutlinedTextFieldDefaults.INSTANCE.colors-0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, (TextSelectionColors)null, ColorKt.getIndigo600(), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.15F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 0, 48, 3072, 0, 3072, 2139088895, 4095);
         int var49 = 16;
         int var50 = 0;
         RoundedCornerShape var101 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var49));
         Modifier var123 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         String var222 = var47;
         ComposerKt.sourceInformationMarkerStart($composer, 1373767935, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var52 = false;
         int var53 = 0;
         Object var54 = $composer.rememberedValue();
         int var55 = 0;
         Object var237;
         if (var54 == Composer.Companion.getEmpty()) {
            int var57 = 0;
            Function1 var10001 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$195$lambda$194;
            var222 = var47;
            Object var58 = var10001;
            $composer.updateRememberedValue(var58);
            var237 = var58;
         } else {
            var237 = var54;
         }

         Function1 var129 = (Function1)var237;
         ComposerKt.sourceInformationMarkerEnd($composer);
         OutlinedTextFieldKt.OutlinedTextField(var222, var129, var123, false, false, (TextStyle)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$-681739945$app(), (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, false, (VisualTransformation)null, (KeyboardOptions)null, (KeyboardActions)null, true, 0, 0, (MutableInteractionSource)null, (Shape)var101, var48, $composer, 1573296, 12582912, 0, 1966008);
         Modifier var110 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var117 = 8;
         int var102 = 0;
         Arrangement.Horizontal var118 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var117));
         Alignment.Vertical var103 = Alignment.Companion.getCenterVertically();
         int var130 = 438;
         int var51 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         MeasurePolicy var141 = RowKt.rowMeasurePolicy(var118, var103, $composer, 14 & var130 >> 3 | 112 & var130 >> 3);
         var53 = 112 & var130 << 3;
         int var150 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var55 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var158 = $composer.getCurrentCompositionLocalMap();
         Modifier var161 = ComposedModifierKt.materializeModifier($composer, var110);
         Function0 var59 = ComposeUiNode.Companion.getConstructor();
         int var60 = 6 | 896 & var53 << 6;
         int var61 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var59);
         } else {
            $composer.useNode();
         }

         Composer var62 = Updater.constructor-impl($composer);
         int var63 = 0;
         Updater.set-impl(var62, var141, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var62, var158, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var64 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var65 = 0;
         int var67 = 0;
         if (var62.getInserting() || !Intrinsics.areEqual(var62.rememberedValue(), var55)) {
            var62.updateRememberedValue(var55);
            var62.apply(var55, var64);
         }

         Updater.set-impl(var62, var161, ComposeUiNode.Companion.getSetModifier());
         int var68 = 14 & var60 >> 6;
         int var70 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var71 = 6 | 112 & var130 >> 6;
         RowScope var223 = (RowScope)RowScopeInstance.INSTANCE;
         int var74 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -286218934, "C923@39366L11,919@39183L248,926@39498L333,935@39955L40,925@39452L648,939@40167L329,948@40622L40,938@40121L646,952@40834L905,971@41866L40,951@40788L1223:OtherScreens.kt#to5c3");
         long var75 = TextUnitKt.getSp(12);
         FontWeight var77 = FontWeight.Companion.getBold();
         long var78 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         TextKt.Text--4IGK_g("Insert:", (Modifier)null, var78, var75, (FontStyle)null, var77, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 131026);
         ComposerKt.sourceInformationMarkerStart($composer, 2068984698, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var176 = (boolean)0;
         int var81 = 0;
         Object var82 = $composer.rememberedValue();
         int var83 = 0;
         Object var224;
         if (var82 == Composer.Companion.getEmpty()) {
            int var84 = 0;
            Object var85 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$202$lambda$197$lambda$196;
            $composer.updateRememberedValue(var85);
            var224 = var85;
         } else {
            var224 = var82;
         }

         Function0 var86 = (Function0)var224;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var225 = var86;
         Function2 var238 = ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$-1646929846$app();
         ChipColors var10007 = AssistChipDefaults.INSTANCE.assistChipColors-oq7We08(0L, ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, $composer, 48 | AssistChipDefaults.$stable << 24, 253);
         int var198 = 1;
         int var80 = 0;
         ChipKt.AssistChip(var225, var238, (Modifier)null, false, (Function2)null, (Function2)null, (Shape)null, var10007, (ChipElevation)null, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var198), Color.copy-wmQWz5c$default(ColorKt.getIndigo600(), 0.3F, 0.0F, 0.0F, 0.0F, 14, (Object)null)), (MutableInteractionSource)null, $composer, 805306422, 0, 1404);
         ComposerKt.sourceInformationMarkerStart($composer, 2069006102, "CC(remember):OtherScreens.kt#9igjgp");
         var176 = (boolean)0;
         var81 = 0;
         var82 = $composer.rememberedValue();
         var83 = 0;
         Object var226;
         if (var82 == Composer.Companion.getEmpty()) {
            int var192 = 0;
            Object var195 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$202$lambda$199$lambda$198;
            $composer.updateRememberedValue(var195);
            var226 = var195;
         } else {
            var226 = var82;
         }

         Function0 var199 = (Function0)var226;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var227 = var199;
         var238 = ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$1833491443$app();
         var10007 = AssistChipDefaults.INSTANCE.assistChipColors-oq7We08(0L, ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, $composer, 48 | AssistChipDefaults.$stable << 24, 253);
         int var200 = 1;
         var80 = 0;
         ChipKt.AssistChip(var227, var238, (Modifier)null, false, (Function2)null, (Function2)null, (Shape)null, var10007, (ChipElevation)null, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var200), Color.copy-wmQWz5c$default(ColorKt.getIndigo600(), 0.3F, 0.0F, 0.0F, 0.0F, 14, (Object)null)), (MutableInteractionSource)null, $composer, 805306422, 0, 1404);
         ComposerKt.sourceInformationMarkerStart($composer, 2069028022, "CC(remember):OtherScreens.kt#9igjgp");
         var176 = (boolean)0;
         var81 = 0;
         var82 = $composer.rememberedValue();
         var83 = 0;
         Object var228;
         if (var82 == Composer.Companion.getEmpty()) {
            int var193 = 0;
            Object var196 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$202$lambda$201$lambda$200;
            $composer.updateRememberedValue(var196);
            var228 = var196;
         } else {
            var228 = var82;
         }

         Function0 var201 = (Function0)var228;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var229 = var201;
         var238 = ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$-1454794606$app();
         var10007 = AssistChipDefaults.INSTANCE.assistChipColors-oq7We08(0L, ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, $composer, 48 | AssistChipDefaults.$stable << 24, 253);
         int var202 = 1;
         var80 = 0;
         ChipKt.AssistChip(var229, var238, (Modifier)null, false, (Function2)null, (Function2)null, (Shape)null, var10007, (ChipElevation)null, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var202), Color.copy-wmQWz5c$default(ColorKt.getIndigo600(), 0.3F, 0.0F, 0.0F, 0.0F, 14, (Object)null)), (MutableInteractionSource)null, $composer, 805306422, 0, 1404);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         String var111 = DetailedEditNoteDialog$lambda$175($content$delegate);
         TextFieldColors var119 = OutlinedTextFieldDefaults.INSTANCE.colors-0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, (TextSelectionColors)null, ColorKt.getIndigo600(), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.15F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 0, 48, 3072, 0, 3072, 2139088895, 4095);
         int var124 = 16;
         var130 = 0;
         RoundedCornerShape var104 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var124));
         Modifier var125 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         String var230 = var111;
         ComposerKt.sourceInformationMarkerStart($composer, 1373887969, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var142 = (boolean)0;
         var53 = 0;
         Object var151 = $composer.rememberedValue();
         var55 = 0;
         Object var242;
         if (var151 == Composer.Companion.getEmpty()) {
            int var159 = 0;
            Function1 var241 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$204$lambda$203;
            var230 = var111;
            Object var162 = var241;
            $composer.updateRememberedValue(var162);
            var242 = var162;
         } else {
            var242 = var151;
         }

         Function1 var132 = (Function1)var242;
         ComposerKt.sourceInformationMarkerEnd($composer);
         OutlinedTextFieldKt.OutlinedTextField(var230, var132, var125, false, false, (TextStyle)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$797546112$app(), (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, false, (VisualTransformation)null, (KeyboardOptions)null, (KeyboardActions)null, false, 6, 3, (MutableInteractionSource)null, (Shape)var104, var119, $composer, 1573296, 905969664, 0, 1310648);
         ImageVector var231 = DateRangeKt.getDateRange(Icons.INSTANCE.getDefault());
         long var243 = ColorKt.getIndigo600();
         String var10002 = "Link to Current Day";
         String var10003 = "Associate this note with today's schedule";
         boolean var10004 = DetailedEditNoteDialog$lambda$178($linkToday$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 1373916963, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var105 = (boolean)0;
         int var126 = 0;
         Object var133 = $composer.rememberedValue();
         var51 = 0;
         Object var10005;
         if (var133 == Composer.Companion.getEmpty()) {
            boolean var87 = var10004;
            String var88 = "Associate this note with today's schedule";
            String var89 = "Link to Current Day";
            long var90 = var243;
            ImageVector var56 = var231;
            var142 = (boolean)0;
            Function1 var53_5 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$206$lambda$205;
            var231 = var56;
            var243 = var90;
            var10002 = var89;
            var10003 = var88;
            var10004 = var87;
            $composer.updateRememberedValue(var53_5);
            var10005 = var53_5;
         } else {
            var10005 = var133;
         }

         Function1 var112 = (Function1)var10005;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NoteOptionRow-oC9nPe0(var231, var243, var10002, var10003, var10004, var112, (Function2)null, $composer, 200112, 64);
         var231 = MeetingRoomKt.getMeetingRoom(Icons.INSTANCE.getDefault());
         var243 = ColorKt.getTeal600();
         var10002 = "Attach to Meeting";
         var10003 = "Link note to an event from your calendar";
         var10004 = DetailedEditNoteDialog$lambda$181($attachMeeting$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 1373928807, "CC(remember):OtherScreens.kt#9igjgp");
         var105 = (boolean)0;
         var126 = 0;
         var133 = $composer.rememberedValue();
         var51 = 0;
         if (var133 == Composer.Companion.getEmpty()) {
            boolean var204 = var10004;
            String var206 = "Link note to an event from your calendar";
            String var208 = "Attach to Meeting";
            long var210 = var243;
            ImageVector var156 = var231;
            var142 = (boolean)0;
            Function1 var53_5 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$208$lambda$207;
            var231 = var156;
            var243 = var210;
            var10002 = var208;
            var10003 = var206;
            var10004 = var204;
            $composer.updateRememberedValue(var53_5);
            var10005 = var53_5;
         } else {
            var10005 = var133;
         }

         var112 = (Function1)var10005;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NoteOptionRow-oC9nPe0(var231, var243, var10002, var10003, var10004, var112, (Function2)ComposableLambdaKt.rememberComposableLambda(-952152904, true, OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$223, $composer, 54), $composer, 1772976, 0);
         var231 = NotificationsKt.getNotifications(Icons.INSTANCE.getDefault());
         var243 = ColorKt.getIndigo600();
         var10002 = "Set Review Reminder";
         var10003 = "Schedule a reminder notification for this note";
         var10004 = DetailedEditNoteDialog$lambda$184($hasReminder$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 1374002149, "CC(remember):OtherScreens.kt#9igjgp");
         var105 = (boolean)0;
         var126 = 0;
         var133 = $composer.rememberedValue();
         var51 = 0;
         if (var133 == Composer.Companion.getEmpty()) {
            boolean var205 = var10004;
            String var207 = "Schedule a reminder notification for this note";
            String var209 = "Set Review Reminder";
            long var211 = var243;
            ImageVector var157 = var231;
            var142 = (boolean)0;
            Function1 var53_5 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$225$lambda$224;
            var231 = var157;
            var243 = var211;
            var10002 = var209;
            var10003 = var207;
            var10004 = var205;
            $composer.updateRememberedValue(var53_5);
            var10005 = var53_5;
         } else {
            var10005 = var133;
         }

         var112 = (Function1)var10005;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NoteOptionRow-oC9nPe0(var231, var243, var10002, var10003, var10004, var112, (Function2)ComposableLambdaKt.rememberComposableLambda(845297559, true, OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$233, $composer, 54), $composer, 1772976, 0);
         Modifier var234 = (Modifier)Modifier.Companion;
         int var115 = 8;
         int var120 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var234, Dp.constructor-impl((float)var115)), $composer, 6);
         Modifier var116 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var120 = 12;
         var105 = (boolean)0;
         Arrangement.Horizontal var122 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var120));
         byte var136 = 54;
         var51 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Alignment.Vertical var109 = Alignment.Companion.getTop();
         MeasurePolicy var146 = RowKt.rowMeasurePolicy(var122, var109, $composer, 14 & var136 >> 3 | 112 & var136 >> 3);
         var53 = 112 & var136 << 3;
         int var152 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var55 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var158 = $composer.getCurrentCompositionLocalMap();
         var161 = ComposedModifierKt.materializeModifier($composer, var116);
         var59 = ComposeUiNode.Companion.getConstructor();
         var60 = 6 | 896 & var53 << 6;
         var61 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var59);
         } else {
            $composer.useNode();
         }

         var62 = Updater.constructor-impl($composer);
         var63 = 0;
         Updater.set-impl(var62, var146, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var62, var158, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var64 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var65 = 0;
         var67 = 0;
         if (var62.getInserting() || !Intrinsics.areEqual(var62.rememberedValue(), var55)) {
            var62.updateRememberedValue(var55);
            var62.apply(var55, var64);
         }

         Updater.set-impl(var62, var161, ComposeUiNode.Companion.getSetModifier());
         var68 = 14 & var60 >> 6;
         var70 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         var71 = 6 | 112 & var136 >> 6;
         RowScope var73 = (RowScope)RowScopeInstance.INSTANCE;
         var74 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1581460172, "C1092@47891L363,1110@48808L94,1102@48317L176,1101@48275L761:OtherScreens.kt#to5c3");
         Modifier var246 = RowScope.weight$default(var73, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         int var93 = 48;
         int var94 = 0;
         var246 = SizeKt.height-3ABfNKs(var246, Dp.constructor-impl((float)var93));
         var93 = 14;
         var94 = 0;
         ButtonKt.OutlinedButton($onDismiss, var246, false, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var93)), (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$-788504380$app(), $composer, 805306368, 500);
         var93 = !StringsKt.isBlank((CharSequence)DetailedEditNoteDialog$lambda$172($title$delegate)) && !StringsKt.isBlank((CharSequence)DetailedEditNoteDialog$lambda$175($content$delegate));
         var234 = RowScope.weight$default(var73, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         var176 = (boolean)48;
         int var95 = 0;
         Modifier var217 = SizeKt.height-3ABfNKs(var234, Dp.constructor-impl((float)var176));
         var95 = 14;
         int var96 = 0;
         RoundedCornerShape var180 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var95));
         ButtonColors var219 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(ColorKt.getIndigo600(), 0L, 0L, 0L, $composer, 6 | ButtonDefaults.$stable << 12, 14);
         ComposerKt.sourceInformationMarkerStart($composer, -743738842, "CC(remember):OtherScreens.kt#9igjgp");
         var81 = $composer.changed($onSave);
         int var188 = 0;
         Object var191 = $composer.rememberedValue();
         int var194 = 0;
         Object var236;
         if (!var81 && var191 != Composer.Companion.getEmpty()) {
            var236 = var191;
         } else {
            int var197 = 0;
            Object var203 = OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238$lambda$237$lambda$236$lambda$235$lambda$234;
            $composer.updateRememberedValue(var203);
            var236 = var203;
         }

         Function0 var220 = (Function0)var236;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.Button(var220, var217, (boolean)var93, (Shape)var180, var219, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$-897483514$app(), $composer, 805306368, 480);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
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
   private static final Unit DetailedEditNoteDialog$lambda$239(MutableState $title$delegate, MutableState $content$delegate, MutableState $linkToday$delegate, MutableState $attachMeeting$delegate, List $meetings, MutableState $selectedMeeting$delegate, MutableState $hasReminder$delegate, Context $context, MutableState $reminderTime$delegate, Function0 $onDismiss, Function5 $onSave, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C883@37678L11,882@37619L95,885@37753L38,886@37802L11276,876@37387L11691:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-918327911, $changed, -1, "com.example.DetailedEditNoteDialog.<anonymous> (OtherScreens.kt:876)");
         }

         Modifier var10000 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), (Alignment.Vertical)null, false, 3, (Object)null);
         int var13 = 24;
         int var14 = 0;
         var10000 = PaddingKt.padding-VpY3zN4$default(var10000, 0.0F, Dp.constructor-impl((float)var13), 1, (Object)null);
         var13 = 28;
         var14 = 0;
         Shape var10001 = (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var13));
         CardColors var10002 = CardDefaults.INSTANCE.cardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getBackground-0d7_KjU(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
         var13 = 8;
         var14 = 0;
         CardKt.Card(var10000, var10001, var10002, CardDefaults.INSTANCE.cardElevation-aqJV_2Y(Dp.constructor-impl((float)var13), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, $composer, 6 | CardDefaults.$stable << 18, 62), (BorderStroke)null, (Function3)ComposableLambdaKt.rememberComposableLambda(14590439, true, OtherScreensKt::DetailedEditNoteDialog$lambda$239$lambda$238, $composer, 54), $composer, 196614, 16);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DetailedEditNoteDialog$lambda$240(NoteEntity $note, List $meetings, Function0 $onDismiss, Function5 $onSave, int $$changed, Composer $composer, int $force) {
      DetailedEditNoteDialog($note, $meetings, $onDismiss, $onSave, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit DeleteConfirmationDialog$lambda$241(Function0 $onConfirm, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1149@50145L42,1147@50056L222:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-820115714, $changed, -1, "com.example.DeleteConfirmationDialog.<anonymous> (OtherScreens.kt:1147)");
         }

         ButtonKt.TextButton($onConfirm, (Modifier)null, false, (Shape)null, ButtonDefaults.INSTANCE.textButtonColors-ro_MJ88(0L, Color.Companion.getRed-0d7_KjU(), 0L, 0L, $composer, 48 | ButtonDefaults.$stable << 12, 13), (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$-288003013$app(), $composer, 805306368, 494);
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
   private static final Unit DeleteConfirmationDialog$lambda$242(Function0 $onDismiss, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1157@50463L11,1157@50417L90,1155@50328L240:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(41717888, $changed, -1, "com.example.DeleteConfirmationDialog.<anonymous> (OtherScreens.kt:1155)");
         }

         ButtonKt.TextButton($onDismiss, (Modifier)null, false, (Shape)null, ButtonDefaults.INSTANCE.textButtonColors-ro_MJ88(0L, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.6F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, 0L, $composer, ButtonDefaults.$stable << 12, 13), (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$573830589$app(), $composer, 805306368, 494);
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
   private static final Unit DeleteConfirmationDialog$lambda$244(String $title, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1132@49408L470:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(903551490, $changed, -1, "com.example.DeleteConfirmationDialog.<anonymous> (OtherScreens.kt:1132)");
         }

         Alignment.Vertical var5 = Alignment.Companion.getCenterVertically();
         int var7 = 384;
         int var8 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Modifier var3 = (Modifier)Modifier.Companion;
         Arrangement.Horizontal var4 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var9 = RowKt.rowMeasurePolicy(var4, var5, $composer, 14 & var7 >> 3 | 112 & var7 >> 3);
         int var10 = 112 & var7 << 3;
         int var11 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var12 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var13 = $composer.getCurrentCompositionLocalMap();
         Modifier var14 = ComposedModifierKt.materializeModifier($composer, var3);
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
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var27 = 6 | 112 & var7 >> 6;
         RowScope var10000 = (RowScope)RowScopeInstance.INSTANCE;
         int var30 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1484620197, "C1133@49478L217,1139@49712L39,1140@49839L11,1140@49768L96:OtherScreens.kt#to5c3");
         ImageVector var31 = WarningKt.getWarning(Icons.INSTANCE.getDefault());
         long var32 = Color.Companion.getRed-0d7_KjU();
         Modifier var41 = (Modifier)Modifier.Companion;
         int var34 = 24;
         int var35 = 0;
         Modifier var36 = SizeKt.size-3ABfNKs(var41, Dp.constructor-impl((float)var34));
         IconKt.Icon-ww6aTOc(var31, (String)null, var36, var32, $composer, 3504, 0);
         var41 = (Modifier)Modifier.Companion;
         int var38 = 8;
         int var37 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var41, Dp.constructor-impl((float)var38)), $composer, 6);
         FontWeight var39 = FontWeight.Companion.getBold();
         var32 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g($title, (Modifier)null, var32, 0L, (FontStyle)null, var39, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 196608, 0, 131034);
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
   private static final Unit DeleteConfirmationDialog$lambda$245(String $message, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1144@49962L11,1144@49919L87:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1334468291, $changed, -1, "com.example.DeleteConfirmationDialog.<anonymous> (OtherScreens.kt:1144)");
         }

         TextKt.Text--4IGK_g($message, (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131066);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DeleteConfirmationDialog$lambda$246(String $title, String $message, Function0 $onDismiss, Function0 $onConfirm, int $$changed, int $$default, Composer $composer, int $force) {
      DeleteConfirmationDialog($title, $message, $onDismiss, $onConfirm, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1), $$default);
      return Unit.INSTANCE;
   }

   private static final List SyncScreen$lambda$247(State $tasks$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$tasks$delegate.getValue();
   }

   private static final List SyncScreen$lambda$248(State $allNotes$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$allNotes$delegate.getValue();
   }

   private static final List SyncScreen$lambda$249(State $events$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$events$delegate.getValue();
   }

   private static final boolean SyncScreen$lambda$250(State $isSyncing$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)$isSyncing$delegate.getValue();
   }

   private static final Long SyncScreen$lambda$251(State $lastSyncTime$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Long)$lastSyncTime$delegate.getValue();
   }

   private static final String SyncScreen$lambda$252(State $error$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)$error$delegate.getValue();
   }

   private static final float SyncScreen$lambda$267$lambda$263$lambda$262$lambda$260$lambda$259$lambda$258(int $totalTasks, int $completedTasks) {
      return $totalTasks > 0 ? (float)$completedTasks / (float)$totalTasks : 0.0F;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit SyncScreen$lambda$267$lambda$263(int $totalTasks, int $completedTasks, int $completionPercentage, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C1214@52483L11,1210@52314L207,1216@52534L40,1217@52587L1859:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1026543812, $changed, -1, "com.example.SyncScreen.<anonymous>.<anonymous> (OtherScreens.kt:1210)");
         }

         FontWeight var6 = FontWeight.Companion.getBold();
         long var7 = TextUnitKt.getSp(16);
         long var9 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g("Daily Completion Progress", (Modifier)null, var9, var7, (FontStyle)null, var6, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 131026);
         Modifier var10000 = (Modifier)Modifier.Companion;
         int var86 = 8;
         int var88 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var10000, Dp.constructor-impl((float)var86)), $composer, 6);
         Alignment.Vertical var87 = Alignment.Companion.getCenterVertically();
         Modifier var8 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         short var12 = 390;
         int var13 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var89 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var14 = RowKt.rowMeasurePolicy(var89, var87, $composer, 14 & var12 >> 3 | 112 & var12 >> 3);
         int var15 = 112 & var12 << 3;
         int var16 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var17 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var18 = $composer.getCurrentCompositionLocalMap();
         Modifier var19 = ComposedModifierKt.materializeModifier($composer, var8);
         Function0 var20 = ComposeUiNode.Companion.getConstructor();
         int var21 = 6 | 896 & var15 << 6;
         int var22 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var20);
         } else {
            $composer.useNode();
         }

         Composer var23 = Updater.constructor-impl($composer);
         int var24 = 0;
         Updater.set-impl(var23, var14, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var23, var18, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var25 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var26 = 0;
         int var28 = 0;
         if (var23.getInserting() || !Intrinsics.areEqual(var23.rememberedValue(), var17)) {
            var23.updateRememberedValue(var17);
            var23.apply(var17, var25);
         }

         Updater.set-impl(var23, var19, ComposeUiNode.Companion.getSetModifier());
         int var29 = 14 & var21 >> 6;
         int var31 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var32 = 6 | 112 & var12 >> 6;
         RowScope var116 = (RowScope)RowScopeInstance.INSTANCE;
         int var35 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 945438366, "C1221@52739L849,1239@53605L40,1240@53662L770:OtherScreens.kt#to5c3");
         Alignment var36 = Alignment.Companion.getCenter();
         Modifier var117 = (Modifier)Modifier.Companion;
         int var37 = 64;
         int var38 = 0;
         Modifier var92 = SizeKt.size-3ABfNKs(var117, Dp.constructor-impl((float)var37));
         byte var40 = 54;
         int var41 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         boolean var42 = (boolean)0;
         MeasurePolicy var43 = BoxKt.maybeCachedBoxMeasurePolicy(var36, var42);
         int var44 = 112 & var40 << 3;
         int var45 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var46 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var47 = $composer.getCurrentCompositionLocalMap();
         Modifier var48 = ComposedModifierKt.materializeModifier($composer, var92);
         Function0 var49 = ComposeUiNode.Companion.getConstructor();
         int var50 = 6 | 896 & var44 << 6;
         int var51 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var49);
         } else {
            $composer.useNode();
         }

         Composer var52 = Updater.constructor-impl($composer);
         int var53 = 0;
         Updater.set-impl(var52, var43, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var52, var47, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var54 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var55 = 0;
         int var57 = 0;
         if (var52.getInserting() || !Intrinsics.areEqual(var52.rememberedValue(), var46)) {
            var52.updateRememberedValue(var46);
            var52.apply(var46, var54);
         }

         Updater.set-impl(var52, var48, ComposeUiNode.Companion.getSetModifier());
         int var58 = 14 & var50 >> 6;
         int var60 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         int var61 = 6 | 112 & var40 >> 6;
         BoxScope var118 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var64 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1030583248, "C1226@52955L79,1230@53233L11,1225@52893L405,1236@53524L11,1232@53319L251:OtherScreens.kt#to5c3");
         ComposerKt.sourceInformationMarkerStart($composer, -1906416643, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var66 = $composer.changed($totalTasks) | $composer.changed($completedTasks);
         int var67 = 0;
         Object var68 = $composer.rememberedValue();
         int var69 = 0;
         Object var119;
         if (!var66 && var68 != Composer.Companion.getEmpty()) {
            var119 = var68;
         } else {
            int var70 = 0;
            Object var71 = OtherScreensKt::SyncScreen$lambda$267$lambda$263$lambda$262$lambda$260$lambda$259$lambda$258;
            $composer.updateRememberedValue(var71);
            var119 = var71;
         }

         Function0 var72 = (Function0)var119;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var120 = var72;
         Modifier var10001 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         long var10002 = ColorKt.getIndigo600();
         int var113 = 6;
         int var65 = 0;
         ProgressIndicatorKt.CircularProgressIndicator-IyT6zlY(var120, var10001, var10002, Dp.constructor-impl((float)var113), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.1F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0, 0.0F, $composer, 3504, 96);
         String var114 = $completionPercentage + "%";
         long var73 = TextUnitKt.getSp(14);
         FontWeight var112 = FontWeight.Companion.getBold();
         long var75 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g(var114, (Modifier)null, var75, var73, (FontStyle)null, var112, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Modifier var121 = (Modifier)Modifier.Companion;
         int var90 = 20;
         int var77 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var121, Dp.constructor-impl((float)var90)), $composer, 6);
         var42 = (boolean)0;
         int var39 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Modifier var91 = (Modifier)Modifier.Companion;
         Arrangement.Vertical var115 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var93 = Alignment.Companion.getStart();
         MeasurePolicy var94 = ColumnKt.columnMeasurePolicy(var115, var93, $composer, 14 & var42 >> 3 | 112 & var42 >> 3);
         var41 = 112 & var42 << 3;
         int var97 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var44 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var99 = $composer.getCurrentCompositionLocalMap();
         Modifier var100 = ComposedModifierKt.materializeModifier($composer, var91);
         Function0 var101 = ComposeUiNode.Companion.getConstructor();
         int var102 = 6 | 896 & var41 << 6;
         int var103 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var101);
         } else {
            $composer.useNode();
         }

         Composer var104 = Updater.constructor-impl($composer);
         var51 = 0;
         Updater.set-impl(var104, var94, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var104, var99, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var106 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var53 = 0;
         var55 = 0;
         if (var104.getInserting() || !Intrinsics.areEqual(var104.rememberedValue(), var44)) {
            var104.updateRememberedValue(var44);
            var104.apply(var44, var106);
         }

         Updater.set-impl(var104, var100, ComposeUiNode.Companion.getSetModifier());
         int var56 = 14 & var102 >> 6;
         var58 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var59 = 6 | 112 & var42 >> 6;
         ColumnScope var122 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var62 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 698467058, "C1245@53924L11,1241@53691L279,1252@54349L11,1247@53991L423:OtherScreens.kt#to5c3");
         String var63 = $completedTasks + " of " + $totalTasks + " tasks completed";
         FontWeight var111 = FontWeight.Companion.getSemiBold();
         long var78 = TextUnitKt.getSp(15);
         long var80 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g(var63, (Modifier)null, var80, var78, (FontStyle)null, var111, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
         var63 = $totalTasks == 0 ? "No tasks scheduled for today." : ($completedTasks == $totalTasks ? "All tasks completed! Great job!" : "Keep going to finish your schedule!");
         long var82 = TextUnitKt.getSp(12);
         long var84 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.6F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         TextKt.Text--4IGK_g(var63, (Modifier)null, var84, var82, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3072, 0, 131058);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
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
   private static final Unit SyncScreen$lambda$267$lambda$266$lambda$264(int $totalTasks, int $completedTasks, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C1271@54976L11,1267@54796L241,1273@55054L40,1274@55111L210:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1629219872, $changed, -1, "com.example.SyncScreen.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1267)");
         }

         long var5 = TextUnitKt.getSp(12);
         FontWeight var7 = FontWeight.Companion.getBold();
         long var8 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         TextKt.Text--4IGK_g("Pending Tasks", (Modifier)null, var8, var5, (FontStyle)null, var7, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 131026);
         Modifier var10000 = (Modifier)Modifier.Companion;
         int var11 = 4;
         int var6 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var10000, Dp.constructor-impl((float)var11)), $composer, 6);
         String var12 = String.valueOf($totalTasks - $completedTasks);
         long var13 = TextUnitKt.getSp(24);
         FontWeight var14 = FontWeight.Companion.getBold();
         long var9 = ColorKt.getIndigo600();
         TextKt.Text--4IGK_g(var12, (Modifier)null, var9, var13, (FontStyle)null, var14, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 200064, 0, 131026);
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
   private static final Unit SyncScreen$lambda$267$lambda$266$lambda$265(State $allNotes$delegate, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C1287@55628L11,1283@55450L239,1289@55706L40,1290@55763L196:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-775608631, $changed, -1, "com.example.SyncScreen.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1283)");
         }

         long var4 = TextUnitKt.getSp(12);
         FontWeight var6 = FontWeight.Companion.getBold();
         long var7 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         TextKt.Text--4IGK_g("Total Notes", (Modifier)null, var7, var4, (FontStyle)null, var6, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 131026);
         Modifier var10000 = (Modifier)Modifier.Companion;
         int var10 = 4;
         int var5 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var10000, Dp.constructor-impl((float)var10)), $composer, 6);
         String var11 = String.valueOf(SyncScreen$lambda$248($allNotes$delegate).size());
         long var12 = TextUnitKt.getSp(24);
         FontWeight var13 = FontWeight.Companion.getBold();
         long var8 = ColorKt.getPurple500();
         TextKt.Text--4IGK_g(var11, (Modifier)null, var8, var12, (FontStyle)null, var13, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 200064, 0, 131026);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit SyncScreen$lambda$268(PlannerViewModel $plannerViewModel, NotesViewModel $notesViewModel, CalendarSyncViewModel $syncViewModel, AuthManager $authManager, int $$changed, Composer $composer, int $force) {
      SyncScreen($plannerViewModel, $notesViewModel, $syncViewModel, $authManager, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final String SettingsScreen$lambda$269(State $themeMode$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)$themeMode$delegate.getValue();
   }

   private static final boolean SettingsScreen$lambda$270(State $notificationsMuted$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)$notificationsMuted$delegate.getValue();
   }

   private static final Long SettingsScreen$lambda$271(State $lastSyncTime$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Long)$lastSyncTime$delegate.getValue();
   }

   private static final boolean SettingsScreen$lambda$272(State $googleCalendarRemindersEnabled$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)$googleCalendarRemindersEnabled$delegate.getValue();
   }

   private static final boolean SettingsScreen$lambda$273(State $notificationSoundEnabled$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)$notificationSoundEnabled$delegate.getValue();
   }

   private static final String SettingsScreen$lambda$274(State $notificationMelody$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)$notificationMelody$delegate.getValue();
   }

   private static final int SettingsScreen$lambda$275(State $notificationVolume$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return ((Number)$notificationVolume$delegate.getValue()).intValue();
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$283$lambda$282(String $initials, String $name, String $email, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C1344@57943L1434:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1699720135, $changed, -1, "com.example.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1344)");
         }

         Modifier var6 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Alignment.Vertical var8 = Alignment.Companion.getCenterVertically();
         short var10 = 390;
         int var11 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var7 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var12 = RowKt.rowMeasurePolicy(var7, var8, $composer, 14 & var10 >> 3 | 112 & var10 >> 3);
         int var13 = 112 & var10 << 3;
         int var14 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var15 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var16 = $composer.getCurrentCompositionLocalMap();
         Modifier var17 = ComposedModifierKt.materializeModifier($composer, var6);
         Function0 var18 = ComposeUiNode.Companion.getConstructor();
         int var19 = 6 | 896 & var13 << 6;
         int var20 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var18);
         } else {
            $composer.useNode();
         }

         Composer var21 = Updater.constructor-impl($composer);
         int var22 = 0;
         Updater.set-impl(var21, var12, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var21, var16, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var23 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var24 = 0;
         int var26 = 0;
         if (var21.getInserting() || !Intrinsics.areEqual(var21.rememberedValue(), var15)) {
            var21.updateRememberedValue(var15);
            var21.apply(var15, var23);
         }

         Updater.set-impl(var21, var17, ComposeUiNode.Companion.getSetModifier());
         int var27 = 14 & var19 >> 6;
         int var29 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var30 = 6 | 112 & var10 >> 6;
         RowScope var32 = (RowScope)RowScopeInstance.INSTANCE;
         int var33 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1578682456, "C1348@58111L604,1362@58736L40,1363@58797L562:OtherScreens.kt#to5c3");
         Modifier var10000 = (Modifier)Modifier.Companion;
         int var34 = 64;
         int var35 = 0;
         var10000 = ClipKt.clip(SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var34)), (Shape)RoundedCornerShapeKt.getCircleShape());
         Brush.Companion var10001 = Brush.Companion;
         Color[] var68 = new Color[]{Color.box-impl(ColorKt.getIndigo400()), Color.box-impl(ColorKt.getPurple500())};
         Modifier var69 = BackgroundKt.background$default(var10000, Companion.linearGradient-mHitzGk$default(var10001, CollectionsKt.listOf(var68), 0L, 0L, 0, 14, (Object)null), (Shape)null, 0.0F, 6, (Object)null);
         Alignment var72 = Alignment.Companion.getCenter();
         int var37 = 48;
         int var38 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         boolean var39 = false;
         MeasurePolicy var40 = BoxKt.maybeCachedBoxMeasurePolicy(var72, var39);
         int var41 = 112 & var37 << 3;
         int var42 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var43 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var44 = $composer.getCurrentCompositionLocalMap();
         Modifier var45 = ComposedModifierKt.materializeModifier($composer, var69);
         Function0 var46 = ComposeUiNode.Companion.getConstructor();
         int var47 = 6 | 896 & var41 << 6;
         int var48 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var46);
         } else {
            $composer.useNode();
         }

         Composer var49 = Updater.constructor-impl($composer);
         int var50 = 0;
         Updater.set-impl(var49, var40, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var49, var44, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var51 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var52 = 0;
         int var54 = 0;
         if (var49.getInserting() || !Intrinsics.areEqual(var49.rememberedValue(), var43)) {
            var49.updateRememberedValue(var43);
            var49.apply(var43, var51);
         }

         Updater.set-impl(var49, var45, ComposeUiNode.Companion.getSetModifier());
         int var55 = 14 & var47 >> 6;
         int var57 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         int var58 = 6 | 112 & var37 >> 6;
         BoxScope var98 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var61 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -898458626, "C1355@58449L244:OtherScreens.kt#to5c3");
         CharSequence var62 = (CharSequence)$initials;
         Object var99;
         if (var62.length() == 0) {
            int var63 = 0;
            var99 = "U";
         } else {
            var99 = var62;
         }

         TextKt.Text--4IGK_g((String)var99, (Modifier)null, Color.Companion.getWhite-0d7_KjU(), TextUnitKt.getSp(22), (FontStyle)null, FontWeight.Companion.getBold(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 200064, 0, 131026);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Modifier var100 = (Modifier)Modifier.Companion;
         int var70 = 16;
         int var73 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var100, Dp.constructor-impl((float)var70)), $composer, 6);
         Modifier var71 = RowScope.weight$default(var32, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         var37 = 0;
         var38 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var74 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var77 = Alignment.Companion.getStart();
         var40 = ColumnKt.columnMeasurePolicy(var74, var77, $composer, 14 & var37 >> 3 | 112 & var37 >> 3);
         var41 = 112 & var37 << 3;
         var42 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var43 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var44 = $composer.getCurrentCompositionLocalMap();
         var45 = ComposedModifierKt.materializeModifier($composer, var71);
         var46 = ComposeUiNode.Companion.getConstructor();
         var47 = 6 | 896 & var41 << 6;
         var48 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var46);
         } else {
            $composer.useNode();
         }

         var49 = Updater.constructor-impl($composer);
         var50 = 0;
         Updater.set-impl(var49, var40, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var49, var44, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var51 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var52 = 0;
         var54 = 0;
         if (var49.getInserting() || !Intrinsics.areEqual(var49.rememberedValue(), var43)) {
            var49.updateRememberedValue(var43);
            var49.apply(var43, var51);
         }

         Updater.set-impl(var49, var45, ComposeUiNode.Companion.getSetModifier());
         var55 = 14 & var47 >> 6;
         var57 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         var58 = 6 | 112 & var37 >> 6;
         ColumnScope var101 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         var61 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1114257017, "C1368@59056L11,1364@58862L244,1372@59222L11,1370@59131L206:OtherScreens.kt#to5c3");
         FontWeight var96 = FontWeight.Companion.getBold();
         long var64 = TextUnitKt.getSp(18);
         long var66 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g($name, (Modifier)null, var66, var64, (FontStyle)null, var96, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
         TextKt.Text--4IGK_g($email, (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.6F, 0.0F, 0.0F, 0.0F, 14, (Object)null), TextUnitKt.getSp(14), (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3072, 0, 131058);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
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
   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$283(String $initials, String $name, String $email, LazyItemScope $this$item, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$item, "$this$item");
      ComposerKt.sourceInformation($composer, "C1343@57925L1466,1343@57879L1512:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1284754541, $changed, -1, "com.example.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1343)");
         }

         GlassCard-dgCr-O4(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), (BorderStroke)null, (Color)null, (Function0)null, (Function0)null, (Function3)ComposableLambdaKt.rememberComposableLambda(1699720135, true, OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$283$lambda$282, $composer, 54), $composer, 196614, 30);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$290$lambda$289$lambda$288$lambda$287$lambda$286(CalendarSyncViewModel $syncViewModel, AuthManager $authManager) {
      $syncViewModel.syncCalendar($authManager);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$290$lambda$289(CalendarSyncViewModel $syncViewModel, AuthManager $authManager, SimpleDateFormat $syncFormatter, State $lastSyncTime$delegate, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C1383@59526L1908:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1025653350, $changed, -1, "com.example.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1383)");
         }

         Modifier var7 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Arrangement.Horizontal var8 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
         Alignment.Vertical var9 = Alignment.Companion.getCenterVertically();
         short var11 = 438;
         int var12 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         MeasurePolicy var13 = RowKt.rowMeasurePolicy(var8, var9, $composer, 14 & var11 >> 3 | 112 & var11 >> 3);
         int var14 = 112 & var11 << 3;
         int var15 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var16 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var17 = $composer.getCurrentCompositionLocalMap();
         Modifier var18 = ComposedModifierKt.materializeModifier($composer, var7);
         Function0 var19 = ComposeUiNode.Companion.getConstructor();
         int var20 = 6 | 896 & var14 << 6;
         int var21 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var19);
         } else {
            $composer.useNode();
         }

         Composer var22 = Updater.constructor-impl($composer);
         int var23 = 0;
         Updater.set-impl(var22, var13, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var22, var17, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var24 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var25 = 0;
         int var27 = 0;
         if (var22.getInserting() || !Intrinsics.areEqual(var22.rememberedValue(), var16)) {
            var22.updateRememberedValue(var16);
            var22.apply(var16, var24);
         }

         Updater.set-impl(var22, var18, ComposeUiNode.Companion.getSetModifier());
         int var28 = 14 & var20 >> 6;
         int var30 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var31 = 6 | 112 & var11 >> 6;
         RowScope var10000 = (RowScope)RowScopeInstance.INSTANCE;
         int var34 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -572788155, "C1388@59764L1290,1416@61210L40,1415@61117L43,1414@61075L341:OtherScreens.kt#to5c3");
         Alignment.Vertical var35 = Alignment.Companion.getCenterVertically();
         int var37 = 384;
         int var38 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Modifier var39 = (Modifier)Modifier.Companion;
         Arrangement.Horizontal var40 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var41 = RowKt.rowMeasurePolicy(var40, var35, $composer, 14 & var37 >> 3 | 112 & var37 >> 3);
         int var42 = 112 & var37 << 3;
         int var43 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var44 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var45 = $composer.getCurrentCompositionLocalMap();
         Modifier var46 = ComposedModifierKt.materializeModifier($composer, var39);
         Function0 var47 = ComposeUiNode.Companion.getConstructor();
         int var48 = 6 | 896 & var42 << 6;
         int var49 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var47);
         } else {
            $composer.useNode();
         }

         Composer var50 = Updater.constructor-impl($composer);
         int var51 = 0;
         Updater.set-impl(var50, var41, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var50, var45, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var52 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var53 = 0;
         int var55 = 0;
         if (var50.getInserting() || !Intrinsics.areEqual(var50.rememberedValue(), var44)) {
            var50.updateRememberedValue(var44);
            var50.apply(var44, var52);
         }

         Updater.set-impl(var50, var46, ComposeUiNode.Companion.getSetModifier());
         int var56 = 14 & var48 >> 6;
         int var58 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var59 = 6 | 112 & var37 >> 6;
         var10000 = (RowScope)RowScopeInstance.INSTANCE;
         int var62 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1827351023, "C1389@59842L240,1395@60107L40,1396@60172L860:OtherScreens.kt#to5c3");
         ImageVector var63 = SyncKt.getSync(Icons.INSTANCE.getDefault());
         long var64 = ColorKt.getIndigo600();
         Modifier var118 = (Modifier)Modifier.Companion;
         int var66 = 24;
         int var67 = 0;
         Modifier var68 = SizeKt.size-3ABfNKs(var118, Dp.constructor-impl((float)var66));
         IconKt.Icon-ww6aTOc(var63, (String)null, var68, var64, $composer, 3504, 0);
         var118 = (Modifier)Modifier.Companion;
         int var108 = 12;
         int var69 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var118, Dp.constructor-impl((float)var108)), $composer, 6);
         var66 = 0;
         var67 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Modifier var109 = (Modifier)Modifier.Companion;
         Arrangement.Vertical var112 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var70 = Alignment.Companion.getStart();
         MeasurePolicy var71 = ColumnKt.columnMeasurePolicy(var112, var70, $composer, 14 & var66 >> 3 | 112 & var66 >> 3);
         int var72 = 112 & var66 << 3;
         int var73 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var74 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var75 = $composer.getCurrentCompositionLocalMap();
         Modifier var76 = ComposedModifierKt.materializeModifier($composer, var109);
         Function0 var77 = ComposeUiNode.Companion.getConstructor();
         int var78 = 6 | 896 & var72 << 6;
         int var79 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var77);
         } else {
            $composer.useNode();
         }

         Composer var80 = Updater.constructor-impl($composer);
         int var81 = 0;
         Updater.set-impl(var80, var71, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var80, var75, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var82 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var83 = 0;
         int var85 = 0;
         if (var80.getInserting() || !Intrinsics.areEqual(var80.rememberedValue(), var74)) {
            var80.updateRememberedValue(var74);
            var80.apply(var74, var82);
         }

         label63: {
            label62: {
               Updater.set-impl(var80, var76, ComposeUiNode.Companion.getSetModifier());
               int var86 = 14 & var78 >> 6;
               int var88 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
               int var89 = 6 | 112 & var66 >> 6;
               ColumnScope var120 = (ColumnScope)ColumnScopeInstance.INSTANCE;
               int var92 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, -523950174, "C1401@60432L11,1397@60209L277,1410@60933L11,1403@60515L491:OtherScreens.kt#to5c3");
               FontWeight var93 = FontWeight.Companion.getBold();
               long var94 = TextUnitKt.getSp(16);
               long var96 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
               TextKt.Text--4IGK_g("Google Calendar", (Modifier)null, var96, var94, (FontStyle)null, var93, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 131026);
               if (SettingsScreen$lambda$271($lastSyncTime$delegate) != null) {
                  Long var121 = SettingsScreen$lambda$271($lastSyncTime$delegate);
                  var94 = 0L;
                  if (var121 == null) {
                     break label62;
                  }

                  if (var121 != var94) {
                     break label62;
                  }
               }

               var122 = "Never Synced";
               break label63;
            }

            Long var10003 = SettingsScreen$lambda$271($lastSyncTime$delegate);
            Intrinsics.checkNotNull(var10003);
            var122 = "Synced: " + $syncFormatter.format(new Date(var10003));
         }

         String var113 = var122;
         long var115 = TextUnitKt.getSp(12);
         long var116 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         TextKt.Text--4IGK_g(var113, (Modifier)null, var116, var115, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3072, 0, 131058);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonColors var102 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(ColorKt.getIndigo600(), 0L, 0L, 0L, $composer, 6 | ButtonDefaults.$stable << 12, 14);
         int var98 = 12;
         int var36 = 0;
         RoundedCornerShape var103 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var98));
         ComposerKt.sourceInformationMarkerStart($composer, -711172011, "CC(remember):OtherScreens.kt#9igjgp");
         var37 = $composer.changedInstance($syncViewModel) | $composer.changedInstance($authManager);
         var38 = 0;
         Object var104 = $composer.rememberedValue();
         var42 = 0;
         Object var123;
         if (!var37 && var104 != Composer.Companion.getEmpty()) {
            var123 = var104;
         } else {
            var43 = 0;
            Object var107 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$290$lambda$289$lambda$288$lambda$287$lambda$286;
            $composer.updateRememberedValue(var107);
            var123 = var107;
         }

         Function0 var99 = (Function0)var123;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.Button(var99, (Modifier)null, false, (Shape)var103, var102, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$-1908739398$app(), $composer, 805306368, 486);
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
   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$290(CalendarSyncViewModel $syncViewModel, AuthManager $authManager, SimpleDateFormat $syncFormatter, State $lastSyncTime$delegate, LazyItemScope $this$item, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$item, "$this$item");
      ComposerKt.sourceInformation($composer, "C1382@59508L1940,1382@59462L1986:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1958821326, $changed, -1, "com.example.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1382)");
         }

         GlassCard-dgCr-O4(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), (BorderStroke)null, (Color)null, (Function0)null, (Function0)null, (Function3)ComposableLambdaKt.rememberComposableLambda(1025653350, true, OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$290$lambda$289, $composer, 54), $composer, 196614, 30);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final boolean SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$291(State $calendarSyncEnabled$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)$calendarSyncEnabled$delegate.getValue();
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$295$lambda$294$lambda$293(SettingsViewModel $settingsViewModel, boolean it) {
      $settingsViewModel.toggleNotifications(!it);
      return Unit.INSTANCE;
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$299$lambda$298$lambda$297(SettingsViewModel $settingsViewModel, boolean it) {
      $settingsViewModel.setGoogleCalendarRemindersEnabled(it);
      return Unit.INSTANCE;
   }

   private static final boolean SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$300(State $planNotificationEnabled$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)$planNotificationEnabled$delegate.getValue();
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$304$lambda$303$lambda$302(SettingsViewModel $settingsViewModel, boolean it) {
      $settingsViewModel.setPlanNotificationEnabled(it);
      return Unit.INSTANCE;
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$308$lambda$307$lambda$306(SettingsViewModel $settingsViewModel, boolean it) {
      $settingsViewModel.setNotificationSoundEnabled(it);
      return Unit.INSTANCE;
   }

   private static final boolean SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$310(MutableState $expandedMelody$delegate) {
      State var1 = (State)$expandedMelody$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$311(MutableState $expandedMelody$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $expandedMelody$delegate.setValue(var5);
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$314$lambda$313(MutableState $expandedMelody$delegate) {
      SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$311($expandedMelody$delegate, true);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$315(State $notificationMelody$delegate, RowScope $this$OutlinedButton, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$OutlinedButton, "$this$OutlinedButton");
      ComposerKt.sourceInformation($composer, "C1596@69562L24:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-920088260, $changed, -1, "com.example.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1596)");
         }

         TextKt.Text--4IGK_g(SettingsScreen$lambda$274($notificationMelody$delegate), (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$317$lambda$316(MutableState $expandedMelody$delegate) {
      SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$311($expandedMelody$delegate, false);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$322$lambda$321$lambda$318(String $melody, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1604@70050L12:OtherScreens.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1987391185, $changed, -1, "com.example.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1604)");
         }

         TextKt.Text--4IGK_g($melody, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$322$lambda$321$lambda$320$lambda$319(SettingsViewModel $settingsViewModel, String $melody, Context $context, MutableState $expandedMelody$delegate, State $notificationVolume$delegate) {
      $settingsViewModel.setNotificationMelody($melody);
      SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$311($expandedMelody$delegate, false);
      NotificationHelper.INSTANCE.playMelody($context, $melody, SettingsScreen$lambda$275($notificationVolume$delegate));
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$322(SettingsViewModel $settingsViewModel, Context $context, State $notificationVolume$delegate, MutableState $expandedMelody$delegate, ColumnScope $this$DropdownMenu, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$DropdownMenu, "$this$DropdownMenu");
      ComposerKt.sourceInformation($composer, "C*1604@70048L16,1605@70116L313,1603@69983L484:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1911613359, $changed, -1, "com.example.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1602)");
         }

         String[] var7 = new String[]{"Default", "Classic Chime", "Double Alert", "Digital Ping"};
         Iterable var22 = (Iterable)CollectionsKt.listOf(var7);
         int var8 = 0;

         for(Object var10 : var22) {
            String var11 = (String)var10;
            int var12 = 0;
            Function2 var10000 = (Function2)ComposableLambdaKt.rememberComposableLambda(-1987391185, true, OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$322$lambda$321$lambda$318, $composer, 54);
            ComposerKt.sourceInformationMarkerStart($composer, -1637073544, "CC(remember):OtherScreens.kt#9igjgp");
            boolean var14 = $composer.changedInstance($settingsViewModel) | $composer.changed(var11) | $composer.changedInstance($context) | $composer.changed($notificationVolume$delegate);
            int var15 = 0;
            Object var16 = $composer.rememberedValue();
            int var17 = 0;
            Object var23;
            if (!var14 && var16 != Composer.Companion.getEmpty()) {
               var23 = var16;
            } else {
               Function2 var18 = var10000;
               int var19 = 0;
               Function0 var10001 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$322$lambda$321$lambda$320$lambda$319;
               var10000 = var18;
               Object var20 = var10001;
               $composer.updateRememberedValue(var20);
               var23 = var20;
            }

            Function0 var21 = (Function0)var23;
            ComposerKt.sourceInformationMarkerEnd($composer);
            AndroidMenu_androidKt.DropdownMenuItem(var10000, var21, (Modifier)null, (Function2)null, (Function2)null, false, (MenuItemColors)null, (PaddingValues)null, (MutableInteractionSource)null, $composer, 6, 508);
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final float SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$326(MutableFloatState $volumeState$delegate) {
      FloatState var1 = (FloatState)$volumeState$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return var1.getFloatValue();
   }

   private static final void SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$327(MutableFloatState $volumeState$delegate, float var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $volumeState$delegate.setFloatValue(var1);
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$333$lambda$330$lambda$329(MutableFloatState $volumeState$delegate, float it) {
      SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$327($volumeState$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$333$lambda$332$lambda$331(SettingsViewModel $settingsViewModel, Context $context, MutableFloatState $volumeState$delegate, State $notificationMelody$delegate) {
      $settingsViewModel.setNotificationVolume((int)SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$326($volumeState$delegate));
      NotificationHelper.INSTANCE.playMelody($context, SettingsScreen$lambda$274($notificationMelody$delegate), (int)SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$326($volumeState$delegate));
      return Unit.INSTANCE;
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$340$lambda$339$lambda$338$lambda$336$lambda$335(SettingsViewModel $settingsViewModel, String $mode) {
      $settingsViewModel.setThemeMode($mode);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341(SettingsViewModel $settingsViewModel, State $notificationsMuted$delegate, State $googleCalendarRemindersEnabled$delegate, State $notificationSoundEnabled$delegate, State $notificationMelody$delegate, Context $context, State $notificationVolume$delegate, State $themeMode$delegate, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C1432@61756L11,1428@61585L297,1436@61965L29,1439@62052L1218,1466@63349L11,1465@63288L190,1471@63541L1185,1498@64805L11,1497@64744L190,1503@65069L29,1504@65115L1170,1531@66364L11,1530@66303L190,1536@66550L1228,1563@67857L11,1562@67796L190,1669@73270L2444:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(351586565, $changed, -1, "com.example.SettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1428)");
         }

         FontWeight var11 = FontWeight.Companion.getBold();
         long var12 = TextUnitKt.getSp(14);
         long var14 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.4F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         Modifier var10000 = (Modifier)Modifier.Companion;
         int var17 = 12;
         int var18 = 0;
         Modifier var16 = PaddingKt.padding-qDBjuR0$default(var10000, 0.0F, 0.0F, 0.0F, Dp.constructor-impl((float)var17), 7, (Object)null);
         TextKt.Text--4IGK_g("Preferences", var16, var14, var12, (FontStyle)null, var11, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199734, 0, 131024);
         State calendarSyncEnabled$delegate = FlowExtKt.collectAsStateWithLifecycle($settingsViewModel.getCalendarSyncEnabled(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         var10000 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var121 = 8;
         int var13 = 0;
         Modifier var122 = PaddingKt.padding-VpY3zN4$default(var10000, 0.0F, Dp.constructor-impl((float)var121), 1, (Object)null);
         Arrangement.Horizontal var128 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
         Alignment.Vertical var139 = Alignment.Companion.getCenterVertically();
         int var165 = 438;
         var17 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         MeasurePolicy var188 = RowKt.rowMeasurePolicy(var128, var139, $composer, 14 & var165 >> 3 | 112 & var165 >> 3);
         int var19 = 112 & var165 << 3;
         int var20 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var21 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var22 = $composer.getCurrentCompositionLocalMap();
         Modifier var23 = ComposedModifierKt.materializeModifier($composer, var122);
         Function0 var24 = ComposeUiNode.Companion.getConstructor();
         int var25 = 6 | 896 & var19 << 6;
         int var26 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var24);
         } else {
            $composer.useNode();
         }

         Composer var27 = Updater.constructor-impl($composer);
         int var28 = 0;
         Updater.set-impl(var27, var188, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var27, var22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var29 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var30 = 0;
         int var32 = 0;
         if (var27.getInserting() || !Intrinsics.areEqual(var27.rememberedValue(), var21)) {
            var27.updateRememberedValue(var21);
            var27.apply(var21, var29);
         }

         Updater.set-impl(var27, var23, ComposeUiNode.Companion.getSetModifier());
         int var33 = 14 & var25 >> 6;
         int var35 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var36 = 6 | 112 & var165 >> 6;
         RowScope var616 = (RowScope)RowScopeInstance.INSTANCE;
         int var39 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1570672291, "C1446@62365L693,1461@63184L46,1459@63079L173:OtherScreens.kt#to5c3");
         Alignment.Vertical var40 = Alignment.Companion.getCenterVertically();
         int var42 = 384;
         int var43 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Modifier var44 = (Modifier)Modifier.Companion;
         Arrangement.Horizontal var45 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var46 = RowKt.rowMeasurePolicy(var45, var40, $composer, 14 & var42 >> 3 | 112 & var42 >> 3);
         int var47 = 112 & var42 << 3;
         int var48 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var49 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var50 = $composer.getCurrentCompositionLocalMap();
         Modifier var51 = ComposedModifierKt.materializeModifier($composer, var44);
         Function0 var52 = ComposeUiNode.Companion.getConstructor();
         int var53 = 6 | 896 & var47 << 6;
         int var54 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var52);
         } else {
            $composer.useNode();
         }

         Composer var55 = Updater.constructor-impl($composer);
         int var56 = 0;
         Updater.set-impl(var55, var46, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var55, var50, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var57 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var58 = 0;
         int var60 = 0;
         if (var55.getInserting() || !Intrinsics.areEqual(var55.rememberedValue(), var49)) {
            var55.updateRememberedValue(var49);
            var55.apply(var49, var57);
         }

         Updater.set-impl(var55, var51, ComposeUiNode.Companion.getSetModifier());
         int var61 = 14 & var53 >> 6;
         int var63 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var64 = 6 | 112 & var42 >> 6;
         var616 = (RowScope)RowScopeInstance.INSTANCE;
         int var67 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -324150619, "C1450@62673L11,1447@62443L299,1452@62767L40,1456@62986L11,1453@62832L204:OtherScreens.kt#to5c3");
         IconKt.Icon-ww6aTOc(!SettingsScreen$lambda$270($notificationsMuted$delegate) ? androidx.compose.material.icons.outlined.NotificationsKt.getNotifications(Outlined.INSTANCE) : NotificationsOffKt.getNotificationsOff(Outlined.INSTANCE), (String)null, (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null), $composer, 48, 4);
         Modifier var618 = (Modifier)Modifier.Companion;
         int var68 = 12;
         int var69 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var618, Dp.constructor-impl((float)var68)), $composer, 6);
         long var70 = TextUnitKt.getSp(16);
         long var72 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g("Enable App Reminders", (Modifier)null, var72, var70, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3078, 0, 131058);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         boolean var619 = !SettingsScreen$lambda$270($notificationsMuted$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 50692215, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var308 = $composer.changedInstance($settingsViewModel);
         int var41 = 0;
         Object var322 = $composer.rememberedValue();
         var43 = 0;
         Object var10001;
         if (!var308 && var322 != Composer.Companion.getEmpty()) {
            var10001 = var322;
         } else {
            boolean var74 = var619;
            int var370 = 0;
            Function1 var47_3 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$295$lambda$294$lambda$293;
            var619 = var74;
            $composer.updateRememberedValue(var47_3);
            var10001 = var47_3;
         }

         Function1 var341 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SwitchKt.Switch(var619, var341, (Modifier)null, (Function2)null, false, (SwitchColors)null, (MutableInteractionSource)null, $composer, 0, 124);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         long var123 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.08F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         Modifier var620 = (Modifier)Modifier.Companion;
         int var15 = 12;
         var165 = 0;
         Modifier var140 = PaddingKt.padding-VpY3zN4$default(var620, 0.0F, Dp.constructor-impl((float)var15), 1, (Object)null);
         DividerKt.HorizontalDivider-9IZ8Weo(var140, 0.0F, var123, $composer, 6, 2);
         var620 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int planNotificationEnabled$delegate = 8;
         int var129 = 0;
         Modifier var125 = PaddingKt.padding-VpY3zN4$default(var620, 0.0F, Dp.constructor-impl((float)planNotificationEnabled$delegate), 1, (Object)null);
         Arrangement.Horizontal var130 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
         Alignment.Vertical var141 = Alignment.Companion.getCenterVertically();
         var165 = 438;
         var17 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         var188 = RowKt.rowMeasurePolicy(var130, var141, $composer, 14 & var165 >> 3 | 112 & var165 >> 3);
         var19 = 112 & var165 << 3;
         var20 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var21 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var22 = $composer.getCurrentCompositionLocalMap();
         var23 = ComposedModifierKt.materializeModifier($composer, var125);
         var24 = ComposeUiNode.Companion.getConstructor();
         var25 = 6 | 896 & var19 << 6;
         var26 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var24);
         } else {
            $composer.useNode();
         }

         var27 = Updater.constructor-impl($composer);
         var28 = 0;
         Updater.set-impl(var27, var188, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var27, var22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var29 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var30 = 0;
         var32 = 0;
         if (var27.getInserting() || !Intrinsics.areEqual(var27.rememberedValue(), var21)) {
            var27.updateRememberedValue(var21);
            var27.apply(var21, var29);
         }

         Updater.set-impl(var27, var23, ComposeUiNode.Companion.getSetModifier());
         var33 = 14 & var25 >> 6;
         var35 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         var36 = 6 | 112 & var165 >> 6;
         RowScope var622 = (RowScope)RowScopeInstance.INSTANCE;
         var39 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2052980083, "C1478@63854L636,1493@64627L59,1491@64511L197:OtherScreens.kt#to5c3");
         Alignment.Vertical var309 = Alignment.Companion.getCenterVertically();
         int var323 = 384;
         var43 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Modifier var342 = (Modifier)Modifier.Companion;
         var45 = Arrangement.INSTANCE.getStart();
         var46 = RowKt.rowMeasurePolicy(var45, var309, $composer, 14 & var323 >> 3 | 112 & var323 >> 3);
         var47 = 112 & var323 << 3;
         var48 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var49 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var50 = $composer.getCurrentCompositionLocalMap();
         var51 = ComposedModifierKt.materializeModifier($composer, var342);
         var52 = ComposeUiNode.Companion.getConstructor();
         var53 = 6 | 896 & var47 << 6;
         var54 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var52);
         } else {
            $composer.useNode();
         }

         var55 = Updater.constructor-impl($composer);
         var56 = 0;
         Updater.set-impl(var55, var46, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var55, var50, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var57 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var58 = 0;
         var60 = 0;
         if (var55.getInserting() || !Intrinsics.areEqual(var55.rememberedValue(), var49)) {
            var55.updateRememberedValue(var49);
            var55.apply(var49, var57);
         }

         Updater.set-impl(var55, var51, ComposeUiNode.Companion.getSetModifier());
         var61 = 14 & var53 >> 6;
         var63 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         var64 = 6 | 112 & var323 >> 6;
         var622 = (RowScope)RowScopeInstance.INSTANCE;
         var67 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1906723673, "C1482@64100L11,1479@63932L237,1484@64194L40,1488@64418L11,1485@64259L209:OtherScreens.kt#to5c3");
         IconKt.Icon-ww6aTOc(CalendarMonthKt.getCalendarMonth(Outlined.INSTANCE), (String)null, (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null), $composer, 48, 4);
         Modifier var624 = (Modifier)Modifier.Companion;
         var68 = 12;
         var69 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var624, Dp.constructor-impl((float)var68)), $composer, 6);
         var70 = TextUnitKt.getSp(16);
         var72 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g("Enable Calendar Reminders", (Modifier)null, var72, var70, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3078, 0, 131058);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         boolean var625 = SettingsScreen$lambda$272($googleCalendarRemindersEnabled$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, -2144411205, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var310 = $composer.changedInstance($settingsViewModel);
         var41 = 0;
         Object var324 = $composer.rememberedValue();
         var43 = 0;
         if (!var310 && var324 != Composer.Companion.getEmpty()) {
            var10001 = var324;
         } else {
            boolean var576 = var625;
            int var372 = 0;
            Function1 var47_3 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$299$lambda$298$lambda$297;
            var625 = var576;
            $composer.updateRememberedValue(var47_3);
            var10001 = var47_3;
         }

         Function1 var343 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SwitchKt.Switch(var625, var343, (Modifier)null, (Function2)null, false, (SwitchColors)null, (MutableInteractionSource)null, $composer, 0, 124);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         long var126 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.08F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         Modifier var626 = (Modifier)Modifier.Companion;
         var15 = 12;
         var165 = 0;
         Modifier var142 = PaddingKt.padding-VpY3zN4$default(var626, 0.0F, Dp.constructor-impl((float)var15), 1, (Object)null);
         DividerKt.HorizontalDivider-9IZ8Weo(var142, 0.0F, var126, $composer, 6, 2);
         State planNotificationEnabled$delegate = FlowExtKt.collectAsStateWithLifecycle($settingsViewModel.getPlanNotificationEnabled(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         var626 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var131 = 8;
         int var143 = 0;
         Modifier var132 = PaddingKt.padding-VpY3zN4$default(var626, 0.0F, Dp.constructor-impl((float)var131), 1, (Object)null);
         Arrangement.Horizontal var144 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
         Alignment.Vertical var154 = Alignment.Companion.getCenterVertically();
         var17 = 438;
         int var190 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         MeasurePolicy var199 = RowKt.rowMeasurePolicy(var144, var154, $composer, 14 & var17 >> 3 | 112 & var17 >> 3);
         var20 = 112 & var17 << 3;
         var21 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var224 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var231 = $composer.getCurrentCompositionLocalMap();
         Modifier var238 = ComposedModifierKt.materializeModifier($composer, var132);
         Function0 var244 = ComposeUiNode.Companion.getConstructor();
         var26 = 6 | 896 & var20 << 6;
         int var256 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var244);
         } else {
            $composer.useNode();
         }

         Composer var262 = Updater.constructor-impl($composer);
         int var268 = 0;
         Updater.set-impl(var262, var199, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var262, var231, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var274 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var31 = 0;
         var33 = 0;
         if (var262.getInserting() || !Intrinsics.areEqual(var262.rememberedValue(), var224)) {
            var262.updateRememberedValue(var224);
            var262.apply(var224, var274);
         }

         Updater.set-impl(var262, var238, ComposeUiNode.Companion.getSetModifier());
         int var34 = 14 & var26 >> 6;
         var36 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var37 = 6 | 112 & var17 >> 6;
         RowScope var628 = (RowScope)RowScopeInstance.INSTANCE;
         var310 = (boolean)0;
         ComposerKt.sourceInformationMarkerStart($composer, -1046299301, "C1511@65428L635,1526@66193L52,1524@66084L183:OtherScreens.kt#to5c3");
         Alignment.Vertical var315 = Alignment.Companion.getCenterVertically();
         var43 = 384;
         int var344 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Modifier var355 = (Modifier)Modifier.Companion;
         Arrangement.Horizontal var373 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var389 = RowKt.rowMeasurePolicy(var373, var315, $composer, 14 & var43 >> 3 | 112 & var43 >> 3);
         var48 = 112 & var43 << 3;
         var49 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var421 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var431 = $composer.getCurrentCompositionLocalMap();
         Modifier var441 = ComposedModifierKt.materializeModifier($composer, var355);
         Function0 var451 = ComposeUiNode.Companion.getConstructor();
         var54 = 6 | 896 & var48 << 6;
         int var467 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var451);
         } else {
            $composer.useNode();
         }

         Composer var475 = Updater.constructor-impl($composer);
         int var483 = 0;
         Updater.set-impl(var475, var389, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var475, var431, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var491 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var59 = 0;
         var61 = 0;
         if (var475.getInserting() || !Intrinsics.areEqual(var475.rememberedValue(), var421)) {
            var475.updateRememberedValue(var421);
            var475.apply(var421, var491);
         }

         Updater.set-impl(var475, var441, ComposeUiNode.Companion.getSetModifier());
         int var62 = 14 & var54 >> 6;
         var64 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var65 = 6 | 112 & var43 >> 6;
         var628 = (RowScope)RowScopeInstance.INSTANCE;
         var68 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -900042457, "C1515@65674L11,1512@65506L237,1517@65768L40,1521@65991L11,1518@65833L208:OtherScreens.kt#to5c3");
         IconKt.Icon-ww6aTOc(androidx.compose.material.icons.outlined.NotificationsKt.getNotifications(Outlined.INSTANCE), (String)null, (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null), $composer, 48, 4);
         Modifier var630 = (Modifier)Modifier.Companion;
         var69 = 12;
         int var554 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var630, Dp.constructor-impl((float)var69)), $composer, 6);
         long var71 = TextUnitKt.getSp(16);
         long var73 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g("Enable Plan Notification", (Modifier)null, var73, var71, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3078, 0, 131058);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         boolean var631 = SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$300(planNotificationEnabled$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, -1696295883, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var316 = $composer.changedInstance($settingsViewModel);
         int var325 = 0;
         Object var334 = $composer.rememberedValue();
         var344 = 0;
         if (!var316 && var334 != Composer.Companion.getEmpty()) {
            var10001 = var334;
         } else {
            boolean var47_3 = var631;
            int var390 = 0;
            Function1 var48_5 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$304$lambda$303$lambda$302;
            var631 = var47_3;
            $composer.updateRememberedValue(var48_5);
            var10001 = var48_5;
         }

         Function1 var356 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SwitchKt.Switch(var631, var356, (Modifier)null, (Function2)null, false, (SwitchColors)null, (MutableInteractionSource)null, $composer, 0, 124);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         long var133 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.08F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         Modifier var632 = (Modifier)Modifier.Companion;
         var165 = 12;
         var17 = 0;
         Modifier var155 = PaddingKt.padding-VpY3zN4$default(var632, 0.0F, Dp.constructor-impl((float)var165), 1, (Object)null);
         DividerKt.HorizontalDivider-9IZ8Weo(var155, 0.0F, var133, $composer, 6, 2);
         var632 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var134 = 8;
         int var145 = 0;
         Modifier expandedMelody$delegate = PaddingKt.padding-VpY3zN4$default(var632, 0.0F, Dp.constructor-impl((float)var134), 1, (Object)null);
         Arrangement.Horizontal volumeState$delegate = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
         Alignment.Vertical var156 = Alignment.Companion.getCenterVertically();
         var17 = 438;
         var190 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         var199 = RowKt.rowMeasurePolicy(volumeState$delegate, var156, $composer, 14 & var17 >> 3 | 112 & var17 >> 3);
         var20 = 112 & var17 << 3;
         var21 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var224 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var231 = $composer.getCurrentCompositionLocalMap();
         var238 = ComposedModifierKt.materializeModifier($composer, expandedMelody$delegate);
         var244 = ComposeUiNode.Companion.getConstructor();
         var26 = 6 | 896 & var20 << 6;
         var256 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var244);
         } else {
            $composer.useNode();
         }

         var262 = Updater.constructor-impl($composer);
         var268 = 0;
         Updater.set-impl(var262, var199, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var262, var231, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var274 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var31 = 0;
         var33 = 0;
         if (var262.getInserting() || !Intrinsics.areEqual(var262.rememberedValue(), var224)) {
            var262.updateRememberedValue(var224);
            var262.apply(var224, var274);
         }

         Updater.set-impl(var262, var238, ComposeUiNode.Companion.getSetModifier());
         var34 = 14 & var26 >> 6;
         var36 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         var37 = 6 | 112 & var17 >> 6;
         RowScope var634 = (RowScope)RowScopeInstance.INSTANCE;
         var310 = (boolean)0;
         ComposerKt.sourceInformationMarkerStart($composer, -39616256, "C1543@66863L691,1558@67685L53,1556@67575L185:OtherScreens.kt#to5c3");
         Alignment.Vertical var317 = Alignment.Companion.getCenterVertically();
         int var335 = 384;
         var344 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Modifier var357 = (Modifier)Modifier.Companion;
         var373 = Arrangement.INSTANCE.getStart();
         var389 = RowKt.rowMeasurePolicy(var373, var317, $composer, 14 & var335 >> 3 | 112 & var335 >> 3);
         var48 = 112 & var335 << 3;
         var49 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var421 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var431 = $composer.getCurrentCompositionLocalMap();
         var441 = ComposedModifierKt.materializeModifier($composer, var357);
         var451 = ComposeUiNode.Companion.getConstructor();
         var54 = 6 | 896 & var48 << 6;
         var467 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var451);
         } else {
            $composer.useNode();
         }

         var475 = Updater.constructor-impl($composer);
         var483 = 0;
         Updater.set-impl(var475, var389, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var475, var431, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var491 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var59 = 0;
         var61 = 0;
         if (var475.getInserting() || !Intrinsics.areEqual(var475.rememberedValue(), var421)) {
            var475.updateRememberedValue(var421);
            var475.apply(var421, var491);
         }

         Updater.set-impl(var475, var441, ComposeUiNode.Companion.getSetModifier());
         var62 = 14 & var54 >> 6;
         var64 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         var65 = 6 | 112 & var335 >> 6;
         var634 = (RowScope)RowScopeInstance.INSTANCE;
         var68 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 106640526, "C1547@67164L11,1544@66941L292,1549@67258L40,1553@67482L11,1550@67323L209:OtherScreens.kt#to5c3");
         IconKt.Icon-ww6aTOc(SettingsScreen$lambda$273($notificationSoundEnabled$delegate) ? VolumeUpKt.getVolumeUp(Outlined.INSTANCE) : VolumeOffKt.getVolumeOff(Outlined.INSTANCE), (String)null, (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null), $composer, 48, 4);
         Modifier var636 = (Modifier)Modifier.Companion;
         var69 = 12;
         var554 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var636, Dp.constructor-impl((float)var69)), $composer, 6);
         var71 = TextUnitKt.getSp(16);
         var73 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g("Enable Notification Sound", (Modifier)null, var73, var71, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3078, 0, 131058);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         boolean var637 = SettingsScreen$lambda$273($notificationSoundEnabled$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, -1248178473, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var318 = $composer.changedInstance($settingsViewModel);
         var325 = 0;
         Object var336 = $composer.rememberedValue();
         var344 = 0;
         if (!var318 && var336 != Composer.Companion.getEmpty()) {
            var10001 = var336;
         } else {
            boolean var47_3 = var637;
            int var392 = 0;
            Function1 var48_5 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$308$lambda$307$lambda$306;
            var637 = var47_3;
            $composer.updateRememberedValue(var48_5);
            var10001 = var48_5;
         }

         Function1 var358 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SwitchKt.Switch(var637, var358, (Modifier)null, (Function2)null, false, (SwitchColors)null, (MutableInteractionSource)null, $composer, 0, 124);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         long var136 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.08F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         Modifier var638 = (Modifier)Modifier.Companion;
         var165 = 12;
         var17 = 0;
         Modifier var157 = PaddingKt.padding-VpY3zN4$default(var638, 0.0F, Dp.constructor-impl((float)var165), 1, (Object)null);
         DividerKt.HorizontalDivider-9IZ8Weo(var157, 0.0F, var136, $composer, 6, 2);
         if (SettingsScreen$lambda$273($notificationSoundEnabled$delegate)) {
            $composer.startReplaceGroup(-1303301369);
            ComposerKt.sourceInformation($composer, "1569@68117L34,1570@68172L2407,1617@70666L11,1616@70601L202,1622@70881L82,1623@70984L1982,1663@73053L11,1662@72988L202");
            ComposerKt.sourceInformationMarkerStart($composer, -1427517785, "CC(remember):OtherScreens.kt#9igjgp");
            var165 = 0;
            var17 = 0;
            Object var192 = $composer.rememberedValue();
            int var201 = 0;
            Object var639;
            if (var192 == Composer.Companion.getEmpty()) {
               var20 = 0;
               Object var211 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy)null, 2, (Object)null);
               $composer.updateRememberedValue(var211);
               var639 = var211;
            } else {
               var639 = var192;
            }

            MutableState var147 = (MutableState)var639;
            ComposerKt.sourceInformationMarkerEnd($composer);
            MutableState expandedMelody$delegate = var147;
            Modifier var640 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            int var148 = 8;
            int var158 = 0;
            Modifier var149 = PaddingKt.padding-VpY3zN4$default(var640, 0.0F, Dp.constructor-impl((float)var148), 1, (Object)null);
            Arrangement.Horizontal var159 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical var172 = Alignment.Companion.getCenterVertically();
            int var193 = 438;
            var201 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy var212 = RowKt.rowMeasurePolicy(var159, var172, $composer, 14 & var193 >> 3 | 112 & var193 >> 3);
            var21 = 112 & var193 << 3;
            var224 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var233 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var240 = $composer.getCurrentCompositionLocalMap();
            Modifier var246 = ComposedModifierKt.materializeModifier($composer, var149);
            Function0 var252 = ComposeUiNode.Companion.getConstructor();
            var256 = 6 | 896 & var21 << 6;
            int var264 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var252);
            } else {
               $composer.useNode();
            }

            Composer var270 = Updater.constructor-impl($composer);
            int var276 = 0;
            Updater.set-impl(var270, var212, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var270, var240, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var280 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            var32 = 0;
            var34 = 0;
            if (var270.getInserting() || !Intrinsics.areEqual(var270.rememberedValue(), var233)) {
               var270.updateRememberedValue(var233);
               var270.apply(var233, var280);
            }

            Updater.set-impl(var270, var246, ComposeUiNode.Companion.getSetModifier());
            var35 = 14 & var256 >> 6;
            var37 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            int var38 = 6 | 112 & var193 >> 6;
            RowScope var641 = (RowScope)RowScopeInstance.INSTANCE;
            var318 = (boolean)0;
            ComposerKt.sourceInformationMarkerStart($composer, 1316426115, "C1577@68513L674,1590@69212L1345:OtherScreens.kt#to5c3");
            Alignment.Vertical var327 = Alignment.Companion.getCenterVertically();
            var344 = 384;
            int var359 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier var375 = (Modifier)Modifier.Companion;
            Arrangement.Horizontal var393 = Arrangement.INSTANCE.getStart();
            MeasurePolicy var403 = RowKt.rowMeasurePolicy(var393, var327, $composer, 14 & var344 >> 3 | 112 & var344 >> 3);
            var49 = 112 & var344 << 3;
            var421 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var433 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var443 = $composer.getCurrentCompositionLocalMap();
            Modifier var453 = ComposedModifierKt.materializeModifier($composer, var375);
            Function0 var461 = ComposeUiNode.Companion.getConstructor();
            var467 = 6 | 896 & var49 << 6;
            int var477 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var461);
            } else {
               $composer.useNode();
            }

            Composer var485 = Updater.constructor-impl($composer);
            int var493 = 0;
            Updater.set-impl(var485, var403, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var485, var443, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var499 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            var60 = 0;
            var62 = 0;
            if (var485.getInserting() || !Intrinsics.areEqual(var485.rememberedValue(), var433)) {
               var485.updateRememberedValue(var433);
               var485.apply(var433, var499);
            }

            Updater.set-impl(var485, var453, ComposeUiNode.Companion.getSetModifier());
            var63 = 14 & var467 >> 6;
            var65 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            int var107_1 = 6 | 112 & var344 >> 6;
            var641 = (RowScope)RowScopeInstance.INSTANCE;
            var69 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1563337947, "C1581@68771L11,1578@68595L249,1583@68873L40,1587@69107L11,1584@68942L219:OtherScreens.kt#to5c3");
            IconKt.Icon-ww6aTOc(MusicNoteKt.getMusicNote(Outlined.INSTANCE), (String)null, (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null), $composer, 48, 4);
            Modifier var643 = (Modifier)Modifier.Companion;
            var554 = 12;
            int var564 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var643, Dp.constructor-impl((float)var554)), $composer, 6);
            var72 = TextUnitKt.getSp(16);
            long var577 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
            TextKt.Text--4IGK_g("Notification Melody", (Modifier)null, var577, var72, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3078, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            var344 = 0;
            var359 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            var375 = (Modifier)Modifier.Companion;
            Alignment var394 = Alignment.Companion.getTopStart();
            boolean var328 = (boolean)0;
            var403 = BoxKt.maybeCachedBoxMeasurePolicy(var394, var328);
            var49 = 112 & var344 << 3;
            var421 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            var433 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            var443 = $composer.getCurrentCompositionLocalMap();
            var453 = ComposedModifierKt.materializeModifier($composer, var375);
            var461 = ComposeUiNode.Companion.getConstructor();
            var467 = 6 | 896 & var49 << 6;
            var477 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var461);
            } else {
               $composer.useNode();
            }

            var485 = Updater.constructor-impl($composer);
            var493 = 0;
            Updater.set-impl(var485, var403, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var485, var443, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            var499 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            var60 = 0;
            var62 = 0;
            if (var485.getInserting() || !Intrinsics.areEqual(var485.rememberedValue(), var433)) {
               var485.updateRememberedValue(var433);
               var485.apply(var433, var499);
            }

            Updater.set-impl(var485, var453, ComposeUiNode.Companion.getSetModifier());
            var63 = 14 & var467 >> 6;
            var65 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            var107_1 = 6 | 112 & var344 >> 6;
            BoxScope var644 = (BoxScope)BoxScopeInstance.INSTANCE;
            var69 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 1058185812, "C1592@69304L25,1595@69528L88,1591@69246L370,1600@69769L26,1601@69826L705,1598@69645L886:OtherScreens.kt#to5c3");
            ComposerKt.sourceInformationMarkerStart($composer, 1003966947, "CC(remember):OtherScreens.kt#9igjgp");
            var564 = 0;
            int var584 = 0;
            Object var77 = $composer.rememberedValue();
            int var78 = 0;
            Object var645;
            if (var77 == Composer.Companion.getEmpty()) {
               int var53_15 = 0;
               Object var80 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$314$lambda$313;
               $composer.updateRememberedValue(var80);
               var645 = var80;
            } else {
               var645 = var77;
            }

            Function0 var81 = (Function0)var645;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var646 = var81;
            int var600 = 12;
            var554 = 0;
            Shape var10003 = (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var600));
            var600 = 12;
            var554 = 0;
            float var10007 = Dp.constructor-impl((float)var600);
            var600 = 6;
            var554 = 0;
            ButtonKt.OutlinedButton(var646, (Modifier)null, false, var10003, (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, PaddingKt.PaddingValues-YgX7TsA(var10007, Dp.constructor-impl((float)var600)), (MutableInteractionSource)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-920088260, true, OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$315, $composer, 54), $composer, 817889286, 374);
            boolean var647 = SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$310(expandedMelody$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 1003981828, "CC(remember):OtherScreens.kt#9igjgp");
            var564 = 0;
            var584 = 0;
            var77 = $composer.rememberedValue();
            var78 = 0;
            if (var77 == Composer.Companion.getEmpty()) {
               boolean var82 = var647;
               int var593 = 0;
               Function0 var80_4 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$317$lambda$316;
               var647 = var82;
               $composer.updateRememberedValue(var80_4);
               var10001 = var80_4;
            } else {
               var10001 = var77;
            }

            Function0 var603 = (Function0)var10001;
            ComposerKt.sourceInformationMarkerEnd($composer);
            AndroidMenu_androidKt.DropdownMenu-IlH_yew(var647, var603, (Modifier)null, 0L, (ScrollState)null, (PopupProperties)null, (Shape)null, 0L, 0.0F, 0.0F, (BorderStroke)null, (Function3)ComposableLambdaKt.rememberComposableLambda(1911613359, true, OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$324$lambda$323$lambda$322, $composer, 54), $composer, 48, 48, 2044);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long var150 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.08F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            Modifier var648 = (Modifier)Modifier.Companion;
            var17 = 12;
            var193 = 0;
            Modifier var173 = PaddingKt.padding-VpY3zN4$default(var648, 0.0F, Dp.constructor-impl((float)var17), 1, (Object)null);
            DividerKt.HorizontalDivider-9IZ8Weo(var173, 0.0F, var150, $composer, 6, 2);
            int var160 = SettingsScreen$lambda$275($notificationVolume$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -1427429289, "CC(remember):OtherScreens.kt#9igjgp");
            var193 = $composer.changed(var160);
            var201 = 0;
            Object var213 = $composer.rememberedValue();
            var21 = 0;
            Object var649;
            if (!var193 && var213 != Composer.Companion.getEmpty()) {
               var649 = var213;
            } else {
               var224 = 0;
               Object var234 = PrimitiveSnapshotStateKt.mutableFloatStateOf((float)SettingsScreen$lambda$275($notificationVolume$delegate));
               $composer.updateRememberedValue(var234);
               var649 = var234;
            }

            MutableFloatState var174 = (MutableFloatState)var649;
            ComposerKt.sourceInformationMarkerEnd($composer);
            MutableFloatState volumeState$delegate = var174;
            Modifier var650 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            var160 = 8;
            int var175 = 0;
            Modifier var162 = PaddingKt.padding-VpY3zN4$default(var650, 0.0F, Dp.constructor-impl((float)var160), 1, (Object)null);
            var201 = 6;
            int var214 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Arrangement.Vertical var176 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal var185 = Alignment.Companion.getStart();
            MeasurePolicy var221 = ColumnKt.columnMeasurePolicy(var176, var185, $composer, 14 & var201 >> 3 | 112 & var201 >> 3);
            var224 = 112 & var201 << 3;
            var233 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var241 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var247 = $composer.getCurrentCompositionLocalMap();
            Modifier var253 = ComposedModifierKt.materializeModifier($composer, var162);
            Function0 var259 = ComposeUiNode.Companion.getConstructor();
            var264 = 6 | 896 & var224 << 6;
            int var271 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var259);
            } else {
               $composer.useNode();
            }

            Composer var277 = Updater.constructor-impl($composer);
            int var281 = 0;
            Updater.set-impl(var277, var221, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var277, var247, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var285 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            var33 = 0;
            var35 = 0;
            if (var277.getInserting() || !Intrinsics.areEqual(var277.rememberedValue(), var241)) {
               var277.updateRememberedValue(var241);
               var277.apply(var241, var285);
            }

            Updater.set-impl(var277, var253, ComposeUiNode.Companion.getSetModifier());
            var36 = 14 & var264 >> 6;
            var38 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            var39 = 6 | 112 & var201 >> 6;
            ColumnScope var651 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            var328 = (boolean)0;
            ComposerKt.sourceInformationMarkerStart($composer, -1843667573, "C1628@71182L976,1646@72183L40,1655@72764L154,1649@72349L20,1650@72423L236,1647@72248L696:OtherScreens.kt#to5c3");
            Alignment.Vertical var337 = Alignment.Companion.getCenterVertically();
            var359 = 384;
            int var377 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier var395 = (Modifier)Modifier.Companion;
            Arrangement.Horizontal var405 = Arrangement.INSTANCE.getStart();
            MeasurePolicy var415 = RowKt.rowMeasurePolicy(var405, var337, $composer, 14 & var359 >> 3 | 112 & var359 >> 3);
            var421 = 112 & var359 << 3;
            var433 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var445 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var455 = $composer.getCurrentCompositionLocalMap();
            Modifier var463 = ComposedModifierKt.materializeModifier($composer, var395);
            Function0 var471 = ComposeUiNode.Companion.getConstructor();
            var477 = 6 | 896 & var421 << 6;
            int var487 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var471);
            } else {
               $composer.useNode();
            }

            Composer var495 = Updater.constructor-impl($composer);
            int var501 = 0;
            Updater.set-impl(var495, var415, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var495, var455, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var507 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            var61 = 0;
            var63 = 0;
            if (var495.getInserting() || !Intrinsics.areEqual(var495.rememberedValue(), var445)) {
               var495.updateRememberedValue(var445);
               var495.apply(var445, var507);
            }

            Updater.set-impl(var495, var463, ComposeUiNode.Companion.getSetModifier());
            var64 = 14 & var477 >> 6;
            var107_1 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            var67 = 6 | 112 & var359 >> 6;
            RowScope var652 = (RowScope)RowScopeInstance.INSTANCE;
            var554 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1459672859, "C1637@71730L11,1634@71568L235,1639@71832L40,1643@72078L11,1640@71901L231:OtherScreens.kt#to5c3");
            ImageVector var567 = SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$326(volumeState$delegate) == 0.0F ? VolumeMuteKt.getVolumeMute(Outlined.INSTANCE) : (SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$326(volumeState$delegate) < 40.0F ? VolumeDownKt.getVolumeDown(Outlined.INSTANCE) : VolumeUpKt.getVolumeUp(Outlined.INSTANCE));
            IconKt.Icon-ww6aTOc(var567, (String)null, (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null), $composer, 48, 4);
            Modifier var653 = (Modifier)Modifier.Companion;
            int var571 = 12;
            int var574 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var653, Dp.constructor-impl((float)var571)), $composer, 6);
            String var572 = "Volume: " + (int)SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$326(volumeState$delegate) + "%";
            var577 = TextUnitKt.getSp(16);
            long var48_5 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
            TextKt.Text--4IGK_g(var572, (Modifier)null, var48_5, var577, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3072, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            var653 = (Modifier)Modifier.Companion;
            int var396 = 8;
            int var406 = 0;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(var653, Dp.constructor-impl((float)var396)), $composer, 6);
            float var397 = SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$326(volumeState$delegate);
            ClosedFloatingPointRange var407 = RangesKt.rangeTo(0.0F, 100.0F);
            SliderColors var338 = SliderDefaults.INSTANCE.colors-q0g_0yA(ColorKt.getIndigo600(), ColorKt.getIndigo600(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 54, 6, 1020);
            float var655 = var397;
            ComposerKt.sourceInformationMarkerStart($composer, -475079542, "CC(remember):OtherScreens.kt#9igjgp");
            var377 = $composer.changed(volumeState$delegate);
            int var416 = 0;
            Object var426 = $composer.rememberedValue();
            var433 = 0;
            if (!var377 && var426 != Composer.Companion.getEmpty()) {
               var10001 = var426;
            } else {
               var445 = 0;
               Function1 var53_15 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$333$lambda$330$lambda$329;
               var655 = var397;
               $composer.updateRememberedValue(var53_15);
               var10001 = var53_15;
            }

            Function1 var350 = (Function1)var10001;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function1 var674 = var350;
            Object var10002 = null;
            boolean var679 = false;
            ClosedFloatingPointRange var10004 = var407;
            byte var10005 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -475076958, "CC(remember):OtherScreens.kt#9igjgp");
            var377 = $composer.changedInstance($settingsViewModel) | $composer.changed(volumeState$delegate) | $composer.changedInstance($context) | $composer.changed($notificationMelody$delegate);
            var416 = 0;
            var426 = $composer.rememberedValue();
            var433 = 0;
            Object var10006;
            if (!var377 && var426 != Composer.Companion.getEmpty()) {
               var10006 = var426;
            } else {
               byte var596 = 0;
               boolean var606 = false;
               Object var80_4 = null;
               float var591 = var655;
               var445 = 0;
               Function0 var53_18 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$333$lambda$332$lambda$331;
               var655 = var591;
               var674 = var350;
               var10002 = var80_4;
               var679 = var606;
               var10004 = var407;
               var10005 = var596;
               $composer.updateRememberedValue(var53_18);
               var10006 = var53_18;
            }

            Function0 var351 = (Function0)var10006;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SliderKt.Slider(var655, var674, (Modifier)var10002, var679, var10004, var10005, var351, var338, (MutableInteractionSource)null, $composer, 0, 300);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long var163 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.08F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            Modifier var656 = (Modifier)Modifier.Companion;
            var193 = 12;
            var201 = 0;
            Modifier var186 = PaddingKt.padding-VpY3zN4$default(var656, 0.0F, Dp.constructor-impl((float)var193), 1, (Object)null);
            DividerKt.HorizontalDivider-9IZ8Weo(var186, 0.0F, var163, $composer, 6, 2);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-1370952483);
            $composer.endReplaceGroup();
         }

         Modifier var138 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var17 = 6;
         var190 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var152 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var164 = Alignment.Companion.getStart();
         var199 = ColumnKt.columnMeasurePolicy(var152, var164, $composer, 14 & var17 >> 3 | 112 & var17 >> 3);
         var20 = 112 & var17 << 3;
         var21 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var224 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var231 = $composer.getCurrentCompositionLocalMap();
         var238 = ComposedModifierKt.materializeModifier($composer, var138);
         var244 = ComposeUiNode.Companion.getConstructor();
         var26 = 6 | 896 & var20 << 6;
         var256 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var244);
         } else {
            $composer.useNode();
         }

         var262 = Updater.constructor-impl($composer);
         var268 = 0;
         Updater.set-impl(var262, var199, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var262, var231, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var274 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var31 = 0;
         var33 = 0;
         if (var262.getInserting() || !Intrinsics.areEqual(var262.rememberedValue(), var224)) {
            var262.updateRememberedValue(var224);
            var262.apply(var224, var274);
         }

         Updater.set-impl(var262, var238, ComposeUiNode.Companion.getSetModifier());
         var34 = 14 & var26 >> 6;
         var36 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         var37 = 6 | 112 & var17 >> 6;
         ColumnScope var657 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         var310 = (boolean)0;
         ComposerKt.sourceInformationMarkerStart($composer, -478056241, "C1670@73335L617,1683@73973L41,1691@74326L18,1692@74417L18,1686@74085L1611:OtherScreens.kt#to5c3");
         Alignment.Vertical var320 = Alignment.Companion.getCenterVertically();
         int var339 = 384;
         var344 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Modifier var362 = (Modifier)Modifier.Companion;
         var373 = Arrangement.INSTANCE.getStart();
         var389 = RowKt.rowMeasurePolicy(var373, var320, $composer, 14 & var339 >> 3 | 112 & var339 >> 3);
         var48 = 112 & var339 << 3;
         var49 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var421 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var431 = $composer.getCurrentCompositionLocalMap();
         var441 = ComposedModifierKt.materializeModifier($composer, var362);
         var451 = ComposeUiNode.Companion.getConstructor();
         var54 = 6 | 896 & var48 << 6;
         var467 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var451);
         } else {
            $composer.useNode();
         }

         var475 = Updater.constructor-impl($composer);
         var483 = 0;
         Updater.set-impl(var475, var389, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var475, var431, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var491 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var59 = 0;
         var61 = 0;
         if (var475.getInserting() || !Intrinsics.areEqual(var475.rememberedValue(), var421)) {
            var475.updateRememberedValue(var421);
            var475.apply(var421, var491);
         }

         Updater.set-impl(var475, var441, ComposeUiNode.Companion.getSetModifier());
         var62 = 14 & var54 >> 6;
         var64 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         var65 = 6 | 112 & var339 >> 6;
         RowScope var658 = (RowScope)RowScopeInstance.INSTANCE;
         var68 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -894010337, "C1674@73577L11,1671@73413L233,1676@73671L40,1680@73880L11,1677@73736L194:OtherScreens.kt#to5c3");
         IconKt.Icon-ww6aTOc(ColorLensKt.getColorLens(Outlined.INSTANCE), (String)null, (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null), $composer, 48, 4);
         Modifier var659 = (Modifier)Modifier.Companion;
         var69 = 12;
         var554 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var659, Dp.constructor-impl((float)var69)), $composer, 6);
         var71 = TextUnitKt.getSp(16);
         var73 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g("Theme Mode", (Modifier)null, var73, var71, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3078, 0, 131058);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         var659 = (Modifier)Modifier.Companion;
         int var363 = 12;
         int var381 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var659, Dp.constructor-impl((float)var363)), $composer, 6);
         var659 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var363 = 40;
         var381 = 0;
         var659 = SizeKt.height-3ABfNKs(var659, Dp.constructor-impl((float)var363));
         var363 = 12;
         var381 = 0;
         var659 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(var659, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var363))), ThemeKt.isAppInDarkTheme($composer, 0) ? ColorKt.getDarkGlass() : ColorKt.getSlate100(), (Shape)null, 2, (Object)null);
         var363 = 1;
         var381 = 0;
         float var675 = Dp.constructor-impl((float)var363);
         long var677 = ThemeKt.isAppInDarkTheme($composer, 0) ? ColorKt.getDarkGlassBorder() : ColorKt.getSlate200();
         var363 = 12;
         var381 = 0;
         var659 = BorderKt.border-xT4_qwU(var659, var675, var677, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var363)));
         var363 = 2;
         var381 = 0;
         Modifier var369 = PaddingKt.padding-3ABfNKs(var659, Dp.constructor-impl((float)var363));
         var339 = 0;
         var344 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var387 = Arrangement.INSTANCE.getStart();
         var320 = Alignment.Companion.getTop();
         var389 = RowKt.rowMeasurePolicy(var387, var320, $composer, 14 & var339 >> 3 | 112 & var339 >> 3);
         var48 = 112 & var339 << 3;
         var49 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var421 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var431 = $composer.getCurrentCompositionLocalMap();
         var441 = ComposedModifierKt.materializeModifier($composer, var369);
         var451 = ComposeUiNode.Companion.getConstructor();
         var54 = 6 | 896 & var48 << 6;
         var467 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var451);
         } else {
            $composer.useNode();
         }

         var475 = Updater.constructor-impl($composer);
         var483 = 0;
         Updater.set-impl(var475, var389, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var475, var431, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var491 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var59 = 0;
         var61 = 0;
         if (var475.getInserting() || !Intrinsics.areEqual(var475.rememberedValue(), var421)) {
            var475.updateRememberedValue(var421);
            var475.apply(var421, var491);
         }

         Updater.set-impl(var475, var441, ComposeUiNode.Companion.getSetModifier());
         var62 = 14 & var54 >> 6;
         var64 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         var65 = 6 | 112 & var339 >> 6;
         Composer var107_1 = $composer;
         RowScope var539 = (RowScope)RowScopeInstance.INSTANCE;
         var68 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -634894675, "C:OtherScreens.kt#to5c3");
         $composer.startReplaceGroup(-574668748);
         ComposerKt.sourceInformation($composer, "*1703@75101L40,1697@74729L919");
         String[] var551 = new String[]{"LIGHT", "DARK", "SYSTEM"};
         Iterable var552 = (Iterable)CollectionsKt.listOf(var551);
         var554 = 0;

         for(Object var48_5 : var552) {
            String var589 = (String)var48_5;
            int var592 = 0;
            boolean var53_15 = Intrinsics.areEqual(SettingsScreen$lambda$269($themeMode$delegate), var589);
            var659 = SizeKt.fillMaxHeight$default(RowScope.weight$default(var539, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null), 0.0F, 1, (Object)null);
            int var597 = 10;
            int var604 = 0;
            var659 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(var659, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var597))), var53_15 ? ColorKt.getIndigo600() : Color.Companion.getTransparent-0d7_KjU(), (Shape)null, 2, (Object)null);
            boolean var676 = false;
            Object var678 = null;
            Object var680 = null;
            ComposerKt.sourceInformationMarkerStart(var107_1, -1064278994, "CC(remember):OtherScreens.kt#9igjgp");
            boolean var607 = var107_1.changedInstance($settingsViewModel) | var107_1.changed(var589);
            int var610 = 0;
            Object var53_18 = var107_1.rememberedValue();
            int var85 = 0;
            Object var681;
            if (!var607 && var53_18 != Composer.Companion.getEmpty()) {
               var681 = var53_18;
            } else {
               Object var86 = null;
               Object var87 = null;
               boolean var88 = false;
               Modifier var89 = var659;
               int var90 = 0;
               Function0 var92_1 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341$lambda$340$lambda$339$lambda$338$lambda$336$lambda$335;
               var659 = var89;
               var676 = var88;
               var678 = var87;
               var680 = var86;
               var107_1.updateRememberedValue(var92_1);
               var681 = var92_1;
            }

            Function0 var598 = (Function0)var681;
            ComposerKt.sourceInformationMarkerEnd(var107_1);
            Modifier var599 = ClickableKt.clickable-XHw0xAI$default(var659, var676, (String)var678, (Role)var680, var598, 7, (Object)null);
            Alignment var605 = Alignment.Companion.getCenter();
            byte var53_18 = 48;
            var85 = 0;
            ComposerKt.sourceInformationMarkerStart(var107_1, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            var607 = false;
            MeasurePolicy var614 = BoxKt.maybeCachedBoxMeasurePolicy(var605, var607);
            int var92 = 112 & var53_18 << 3;
            int var93 = 0;
            ComposerKt.sourceInformationMarkerStart(var107_1, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var94 = ComposablesKt.getCurrentCompositeKeyHash(var107_1, 0);
            CompositionLocalMap var95 = var107_1.getCurrentCompositionLocalMap();
            Modifier var96 = ComposedModifierKt.materializeModifier(var107_1, var599);
            Function0 var97 = ComposeUiNode.Companion.getConstructor();
            int var98 = 6 | 896 & var92 << 6;
            int var99 = 0;
            ComposerKt.sourceInformationMarkerStart(var107_1, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(var107_1.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            var107_1.startReusableNode();
            if (var107_1.getInserting()) {
               var107_1.createNode(var97);
            } else {
               var107_1.useNode();
            }

            Composer var100 = Updater.constructor-impl(var107_1);
            int var101 = 0;
            Updater.set-impl(var100, var614, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var100, var95, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var102 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var103 = 0;
            int var105 = 0;
            if (var100.getInserting() || !Intrinsics.areEqual(var100.rememberedValue(), var94)) {
               var100.updateRememberedValue(var94);
               var100.apply(var94, var102);
            }

            Updater.set-impl(var100, var96, ComposeUiNode.Companion.getSetModifier());
            int var106 = 14 & var98 >> 6;
            int var108 = 0;
            ComposerKt.sourceInformationMarkerStart(var107_1, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            int var109 = 6 | 112 & var53_18 >> 6;
            BoxScope var667 = (BoxScope)BoxScopeInstance.INSTANCE;
            int var112 = 0;
            ComposerKt.sourceInformationMarkerStart(var107_1, 1216094124, "C1706@75275L343:OtherScreens.kt#to5c3");
            long var113 = TextUnitKt.getSp(12);
            FontWeight var115 = FontWeight.Companion.getBold();
            long var668;
            if (var53_15) {
               var107_1.startReplaceGroup(454878213);
               var107_1.endReplaceGroup();
               var668 = Color.Companion.getWhite-0d7_KjU();
            } else {
               var107_1.startReplaceGroup(454879826);
               ComposerKt.sourceInformation(var107_1, "1710@75541L11");
               long var116 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(var107_1, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.6F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
               var107_1.endReplaceGroup();
               var668 = var116;
            }

            long var118 = var668;
            TextKt.Text--4IGK_g(var589, (Modifier)null, var118, var113, (FontStyle)null, var115, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, var107_1, 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(var107_1);
            ComposerKt.sourceInformationMarkerEnd(var107_1);
            var107_1.endNode();
            ComposerKt.sourceInformationMarkerEnd(var107_1);
            ComposerKt.sourceInformationMarkerEnd(var107_1);
            ComposerKt.sourceInformationMarkerEnd(var107_1);
         }

         var107_1.endReplaceGroup();
         ComposerKt.sourceInformationMarkerEnd(var107_1);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
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
   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$342(SettingsViewModel $settingsViewModel, State $notificationsMuted$delegate, State $googleCalendarRemindersEnabled$delegate, State $notificationSoundEnabled$delegate, State $notificationMelody$delegate, Context $context, State $notificationVolume$delegate, State $themeMode$delegate, LazyItemScope $this$item, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$item, "$this$item");
      ComposerKt.sourceInformation($composer, "C1427@61567L14161,1427@61521L14207:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1662079185, $changed, -1, "com.example.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1427)");
         }

         GlassCard-dgCr-O4(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), (BorderStroke)null, (Color)null, (Function0)null, (Function0)null, (Function3)ComposableLambdaKt.rememberComposableLambda(351586565, true, OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342$lambda$341, $composer, 54), $composer, 196614, 30);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$348$lambda$347$lambda$344$lambda$343(SettingsViewModel $settingsViewModel, Function0 $onSignOut) {
      $settingsViewModel.signOut($onSignOut);
      return Unit.INSTANCE;
   }

   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$348$lambda$347$lambda$346$lambda$345(SettingsViewModel $settingsViewModel, Function0 $onSignOut) {
      $settingsViewModel.signOut($onSignOut);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit SettingsScreen$lambda$350$lambda$349$lambda$348(SettingsViewModel $settingsViewModel, Function0 $onSignOut, LazyItemScope $this$item, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$item, "$this$item");
      ComposerKt.sourceInformation($composer, "C1721@75806L1530:OtherScreens.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(988012400, $changed, -1, "com.example.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (OtherScreens.kt:1721)");
         }

         int var6 = 12;
         int var7 = 0;
         Arrangement.Vertical var45 = (Arrangement.Vertical)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var6));
         int var9 = 48;
         int var10 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Modifier var5 = (Modifier)Modifier.Companion;
         Alignment.Horizontal var46 = Alignment.Companion.getStart();
         MeasurePolicy var11 = ColumnKt.columnMeasurePolicy(var45, var46, $composer, 14 & var9 >> 3 | 112 & var9 >> 3);
         int var12 = 112 & var9 << 3;
         int var13 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var14 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var15 = $composer.getCurrentCompositionLocalMap();
         Modifier var16 = ComposedModifierKt.materializeModifier($composer, var5);
         Function0 var17 = ComposeUiNode.Companion.getConstructor();
         int var18 = 6 | 896 & var12 << 6;
         int var19 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var17);
         } else {
            $composer.useNode();
         }

         Composer var20 = Updater.constructor-impl($composer);
         int var21 = 0;
         Updater.set-impl(var20, var11, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var20, var15, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var23 = 0;
         int var25 = 0;
         if (var20.getInserting() || !Intrinsics.areEqual(var20.rememberedValue(), var14)) {
            var20.updateRememberedValue(var14);
            var20.apply(var14, var22);
         }

         Updater.set-impl(var20, var16, ComposeUiNode.Companion.getSetModifier());
         int var26 = 14 & var18 >> 6;
         int var28 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var29 = 6 | 112 & var9 >> 6;
         ColumnScope var10000 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var32 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1727893207, "C1729@76268L46,1723@75928L40,1722@75882L710,1737@76648L40,1742@76953L11,1742@77027L11,1742@76909L143,1736@76610L712:OtherScreens.kt#to5c3");
         Modifier var63 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var33 = 56;
         int var34 = 0;
         Modifier var35 = SizeKt.height-3ABfNKs(var63, Dp.constructor-impl((float)var33));
         var34 = 16;
         int var36 = 0;
         RoundedCornerShape var47 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var34));
         var36 = 1;
         int var37 = 0;
         BorderStroke var51 = BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var36), Color.copy-wmQWz5c$default(Color.Companion.getRed-0d7_KjU(), 0.4F, 0.0F, 0.0F, 0.0F, 14, (Object)null));
         ButtonColors var57 = ButtonDefaults.INSTANCE.outlinedButtonColors-ro_MJ88(0L, Color.Companion.getRed-0d7_KjU(), 0L, 0L, $composer, 48 | ButtonDefaults.$stable << 12, 13);
         ComposerKt.sourceInformationMarkerStart($composer, 636998242, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var39 = $composer.changedInstance($settingsViewModel) | $composer.changed($onSignOut);
         int var40 = 0;
         Object var41 = $composer.rememberedValue();
         int var42 = 0;
         Object var64;
         if (!var39 && var41 != Composer.Companion.getEmpty()) {
            var64 = var41;
         } else {
            int var43 = 0;
            Object var44 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$348$lambda$347$lambda$344$lambda$343;
            $composer.updateRememberedValue(var44);
            var64 = var44;
         }

         Function0 var59 = (Function0)var64;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.OutlinedButton(var59, var35, false, (Shape)var47, var57, (ButtonElevation)null, var51, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$1599078536$app(), $composer, 806879280, 420);
         ComposerKt.sourceInformationMarkerStart($composer, 637021282, "CC(remember):OtherScreens.kt#9igjgp");
         boolean var52 = $composer.changedInstance($settingsViewModel) | $composer.changed($onSignOut);
         int var58 = 0;
         Object var60 = $composer.rememberedValue();
         int var38 = 0;
         if (!var52 && var60 != Composer.Companion.getEmpty()) {
            var64 = var60;
         } else {
            var39 = (boolean)0;
            Object var62 = OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$348$lambda$347$lambda$346$lambda$345;
            $composer.updateRememberedValue(var62);
            var64 = var62;
         }

         Function0 var53 = (Function0)var64;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var66 = var53;
         Modifier var10001 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var54 = 56;
         int var48 = 0;
         var10001 = SizeKt.height-3ABfNKs(var10001, Dp.constructor-impl((float)var54));
         var54 = 16;
         var48 = 0;
         ButtonKt.Button(var66, var10001, false, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var54)), ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.1F, 0.0F, 0.0F, 0.0F, 14, (Object)null), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, 0L, $composer, ButtonDefaults.$stable << 12, 12), (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$1250590410$app(), $composer, 805306416, 484);
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

   private static final Unit SettingsScreen$lambda$350$lambda$349(String $initials, String $name, String $email, CalendarSyncViewModel $syncViewModel, AuthManager $authManager, SimpleDateFormat $syncFormatter, State $lastSyncTime$delegate, SettingsViewModel $settingsViewModel, State $notificationsMuted$delegate, State $googleCalendarRemindersEnabled$delegate, State $notificationSoundEnabled$delegate, State $notificationMelody$delegate, Context $context, State $notificationVolume$delegate, State $themeMode$delegate, Function0 $onSignOut, LazyListScope $this$LazyColumn) {
      Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
      LazyListScope.item$default($this$LazyColumn, (Object)null, (Object)null, ComposableSingletons$OtherScreensKt.INSTANCE.getLambda$1903512170$app(), 3, (Object)null);
      LazyListScope.item$default($this$LazyColumn, (Object)null, (Object)null, (Function3)ComposableLambdaKt.composableLambdaInstance(-1284754541, true, OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$283), 3, (Object)null);
      LazyListScope.item$default($this$LazyColumn, (Object)null, (Object)null, (Function3)ComposableLambdaKt.composableLambdaInstance(-1958821326, true, OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$290), 3, (Object)null);
      LazyListScope.item$default($this$LazyColumn, (Object)null, (Object)null, (Function3)ComposableLambdaKt.composableLambdaInstance(1662079185, true, OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$342), 3, (Object)null);
      LazyListScope.item$default($this$LazyColumn, (Object)null, (Object)null, (Function3)ComposableLambdaKt.composableLambdaInstance(988012400, true, OtherScreensKt::SettingsScreen$lambda$350$lambda$349$lambda$348), 3, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit SettingsScreen$lambda$351(Function0 $onSignOut, SettingsViewModel $settingsViewModel, CalendarSyncViewModel $syncViewModel, AuthManager $authManager, int $$changed, Composer $composer, int $force) {
      SettingsScreen($onSignOut, $settingsViewModel, $syncViewModel, $authManager, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }
}
