package com.example;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DurationBasedAnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
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
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CreateKt;
import androidx.compose.material.icons.filled.DateRangeKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.HomeKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.CheckboxColors;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FloatingActionButtonElevation;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.SelectableChipElevation;
import androidx.compose.material3.SwipeToDismissBoxKt;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.material3.SwitchColors;
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
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.Brush.Companion;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
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
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
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
import androidx.compose.ui.window.DialogProperties;
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
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.example.auth.AuthManager;
import com.example.auth.AuthState;
import com.example.auth.AuthViewModel;
import com.example.calendar.CalendarSyncViewModel;
import com.example.data.local.entity.SubTaskEntity;
import com.example.data.local.entity.TaskEntity;
import com.example.data.network.CalendarEvent;
import com.example.notes.NotesViewModel;
import com.example.settings.SettingsViewModel;
import com.example.ui.theme.ColorKt;
import com.example.ui.theme.ThemeKt;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a#\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u000e\u001a³\u0001\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0002\u0010!\u001a)\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0015H\u0007¢\u0006\u0002\u0010&\u001aQ\u0010'\u001a\u00020\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001d0)2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u0015H\u0007¢\u0006\u0002\u0010,\u001a¥\u0001\u0010-\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0)2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0002\u00101\u001a@\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020 2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b9H\u0007¢\u0006\u0002\u0010:\u001a)\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020 2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u0015H\u0007¢\u0006\u0002\u0010>\u001a5\u0010?\u001a\u00020\u00012\u0006\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u0002052\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010E\u001aë\u0002\u0010F\u001a\u00020\u00012\b\u0010G\u001a\u0004\u0018\u00010\u00162\u0006\u0010H\u001a\u0002052\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010)2\b\u0010K\u001a\u0004\u0018\u00010\u001b2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0091\u0002\u0010M\u001a\u008c\u0002\u0012\u0013\u0012\u00110 ¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(Q\u0012\u0013\u0012\u00110 ¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(R\u0012\u0013\u0012\u001105¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(S\u0012\u0013\u0012\u00110\u001b¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(T\u0012\u0013\u0012\u00110\u001b¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(U\u0012\u0013\u0012\u00110\u001b¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(V\u0012\u0013\u0012\u001105¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(W\u0012\u0013\u0012\u00110\u001b¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(X\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(Y\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020J0)¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(Z\u0012\u0013\u0012\u001105¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b([\u0012\u0013\u0012\u001105¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(\\\u0012\u0004\u0012\u00020\u00010NH\u0007¢\u0006\u0002\u0010]\u001aO\u0010^\u001a\u00020\u00012\u0006\u0010G\u001a\u00020\u00162\u0006\u0010_\u001a\u00020`2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010a\u001a\u00020\u00112\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015H\u0007¢\u0006\u0002\u0010b¨\u0006c²\u0006\n\u0010d\u001a\u00020eX\u008a\u0084\u0002²\u0006\n\u0010d\u001a\u00020eX\u008a\u0084\u0002²\u0006\n\u0010f\u001a\u000205X\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010h\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010i\u001a\u00020 X\u008a\u008e\u0002²\u0006\f\u0010j\u001a\u0004\u0018\u00010kX\u008a\u0084\u0002²\u0006\f\u0010\u001f\u001a\u0004\u0018\u00010 X\u008a\u008e\u0002²\u0006\n\u0010l\u001a\u000205X\u008a\u008e\u0002²\u0006\f\u0010m\u001a\u0004\u0018\u00010\u001bX\u008a\u008e\u0002²\u0006\f\u0010n\u001a\u0004\u0018\u00010\u0016X\u008a\u008e\u0002²\u0006\f\u0010o\u001a\u0004\u0018\u00010\u001dX\u008a\u008e\u0002²\u0006\f\u0010p\u001a\u0004\u0018\u00010\u0016X\u008a\u008e\u0002²\u0006\u0012\u0010I\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010)X\u008a\u008e\u0002²\u0006\u0012\u0010I\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010)X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002²\u0006\u0010\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00160)X\u008a\u0084\u0002²\u0006\u0010\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001d0)X\u008a\u0084\u0002²\u0006\u0010\u0010r\u001a\b\u0012\u0004\u0012\u00020s0)X\u008a\u0084\u0002²\u0006\n\u0010t\u001a\u00020uX\u008a\u0084\u0002²\u0006\n\u0010t\u001a\u00020uX\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010R\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010S\u001a\u000205X\u008a\u008e\u0002²\u0006\n\u0010\\\u001a\u000205X\u008a\u008e\u0002²\u0006\n\u0010T\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\n\u0010U\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\n\u0010V\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\n\u0010W\u001a\u000205X\u008a\u008e\u0002²\u0006\n\u0010X\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\f\u0010Y\u001a\u0004\u0018\u00010$X\u008a\u008e\u0002²\u0006\n\u0010v\u001a\u00020 X\u008a\u008e\u0002²\u0006\u0010\u0010Z\u001a\b\u0012\u0004\u0012\u00020J0)X\u008a\u0084\u0002"},
   d2 = {"MainAppNavigation", "", "settingsViewModel", "Lcom/example/settings/SettingsViewModel;", "(Lcom/example/settings/SettingsViewModel;Landroidx/compose/runtime/Composer;I)V", "LoginScreen", "navController", "Landroidx/navigation/NavHostController;", "authViewModel", "Lcom/example/auth/AuthViewModel;", "(Landroidx/navigation/NavHostController;Lcom/example/auth/AuthViewModel;Landroidx/compose/runtime/Composer;I)V", "MainDashboardScreen", "onSignOut", "Lkotlin/Function0;", "(Lcom/example/settings/SettingsViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PlannerScreen", "viewModel", "Lcom/example/PlannerViewModel;", "syncViewModel", "Lcom/example/calendar/CalendarSyncViewModel;", "onTaskClick", "Lkotlin/Function1;", "Lcom/example/data/local/entity/TaskEntity;", "onTaskEdit", "onTaskCombine", "onTaskDelete", "onEmptyHourClick", "", "onGoogleEventEdit", "Lcom/example/data/network/CalendarEvent;", "onGoogleEventDelete", "highlightedTaskId", "", "(Lcom/example/PlannerViewModel;Lcom/example/calendar/CalendarSyncViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "TopBar", "selectedDate", "", "onDateChange", "(JLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "UpcomingPlansSection", "tasks", "", "googleEvents", "onGoogleEventClick", "(Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "TimelineSection", "timelineItems", "Lcom/example/TimelineItem;", "onDelete", "(JLjava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ScheduleRow", "time", "isToday", "", "isCurrentHour", "isLast", "content", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;ZZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BottomNavBar", "currentRoute", "onNavigate", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "NavBarItem", "label", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "isActive", "onClick", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "AddTaskDialog", "task", "isCreatingPlan", "initialSubTasks", "Lcom/example/data/local/entity/SubTaskEntity;", "prefilledHour", "onDismiss", "onSave", "Lkotlin/Function12;", "Lkotlin/ParameterName;", "name", "title", "description", "isTimeBoxed", "hour", "minute", "duration", "hasReminder", "reminderMinutesBefore", "customReminderTime", "subTasks", "isAllTime", "isMeeting", "(Lcom/example/data/local/entity/TaskEntity;ZLjava/util/List;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function12;Landroidx/compose/runtime/Composer;I)V", "TaskDetailDialog", "authManager", "Lcom/example/auth/AuthManager;", "plannerViewModel", "(Lcom/example/data/local/entity/TaskEntity;Lcom/example/auth/AuthManager;Lcom/example/calendar/CalendarSyncViewModel;Lcom/example/PlannerViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app", "authState", "Lcom/example/auth/AuthState;", "isRegisterMode", "email", "password", "nickname", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "showAddTaskDialog", "prefilledHourForNewTask", "editingTask", "editingGoogleEvent", "selectedTask", "scheduleTasks", "todaysNotes", "Lcom/example/data/local/entity/NoteEntity;", "alpha", "", "newSubTaskTitle"}
)
@SourceDebugExtension({"SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\ncom/example/MainActivityKt\n+ 2 ViewModel.kt\nandroidx/lifecycle/viewmodel/compose/ViewModelKt__ViewModelKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 5 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/Updater\n+ 9 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 10 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 12 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 13 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 14 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 15 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 16 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 17 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n*L\n1#1,1753:1\n55#2,11:1754\n55#2,11:1862\n55#2,11:1873\n55#2,11:1884\n55#2,11:1895\n1225#3,6:1765\n1225#3,6:1771\n1225#3,6:1777\n1225#3,6:1783\n1225#3,6:1789\n1225#3,6:1795\n1225#3,6:1801\n1225#3,6:1807\n1225#3,6:1813\n1225#3,6:1906\n1225#3,6:1912\n1225#3,6:1918\n1225#3,6:1924\n1225#3,6:1930\n1225#3,6:1936\n1225#3,6:1942\n1225#3,6:1948\n1225#3,6:1954\n1225#3,3:1965\n1228#3,3:1971\n1225#3,6:1975\n1225#3,6:1981\n1225#3,6:1987\n1225#3,6:1993\n1225#3,6:1999\n1225#3,3:2010\n1228#3,3:2016\n1225#3,6:2020\n1225#3,6:2026\n1225#3,6:2032\n1225#3,6:2038\n1225#3,6:2044\n1225#3,6:2050\n1225#3,6:2056\n1225#3,6:2062\n1225#3,3:2068\n1228#3,3:2090\n1225#3,6:2129\n1225#3,6:2173\n1225#3,6:2223\n1225#3,6:2327\n1225#3,3:2333\n1228#3,3:2361\n1225#3,6:2402\n1225#3,3:2412\n1228#3,3:2416\n1225#3,6:2419\n1225#3,6:2425\n1225#3,6:2470\n1225#3,6:2560\n1225#3,6:2689\n1225#3,6:2695\n1225#3,6:2701\n1225#3,6:2707\n1225#3,6:2717\n1225#3,6:2809\n1225#3,6:2815\n1225#3,6:2821\n1225#3,6:2827\n1225#3,6:2833\n1225#3,6:2839\n1225#3,6:2845\n1225#3,6:2851\n1225#3,6:2857\n1225#3,6:2863\n1225#3,6:2869\n1225#3,6:2875\n1225#3,3:2882\n1228#3,3:2888\n1225#3,6:2892\n1225#3,6:2992\n1225#3,6:3000\n1225#3,6:3008\n1225#3,6:3017\n1225#3,6:3026\n1225#3,6:3033\n1225#3,6:3064\n1225#3,6:3072\n1225#3,6:3078\n1225#3,6:3084\n1225#3,6:3090\n1225#3,6:3096\n1225#3,6:3102\n1225#3,6:3108\n1225#3,6:3114\n1225#3,6:3120\n1225#3,6:3126\n1225#3,6:3132\n1225#3,6:3138\n1225#3,6:3144\n1225#3,6:3150\n1225#3,6:3156\n1225#3,6:3162\n1225#3,6:3320\n1225#3,6:3413\n1225#3,6:3420\n1225#3,6:3426\n1225#3,6:3511\n1225#3,6:3519\n1225#3,6:3525\n1225#3,6:3533\n1225#3,3:3544\n1228#3,3:3550\n1225#3,6:3587\n1225#3,6:3705\n1225#3,6:3786\n1225#3,6:3833\n1225#3,6:3875\n1225#3,6:3956\n1225#3,6:4012\n1225#3,6:4019\n1225#3,6:4057\n1225#3,6:4100\n1225#3,6:4143\n1225#3,6:4262\n1225#3,6:4272\n1225#3,6:4320\n1225#3,6:4327\n1225#3,6:4346\n1225#3,6:4388\n1225#3,6:4394\n1225#3,6:4438\n149#4:1819\n149#4:1855\n149#4:1856\n149#4:1857\n149#4:2135\n149#4:2172\n149#4:2189\n149#4:2190\n149#4:2269\n149#4:2270\n149#4:2400\n149#4:2401\n149#4:2467\n149#4:2468\n149#4:2469\n149#4:2516\n149#4:2517\n149#4:2558\n149#4:2559\n149#4:2601\n149#4:2602\n149#4:2603\n149#4:2608\n149#4:2609\n149#4:2654\n149#4:2655\n149#4:2656\n149#4:2723\n149#4:2760\n149#4:2761\n149#4:2798\n149#4:2803\n149#4:2804\n149#4:2950\n149#4:2987\n149#4:2988\n149#4:2989\n149#4:2990\n149#4:2991\n149#4:2998\n149#4:2999\n149#4:3006\n149#4:3007\n149#4:3014\n149#4:3015\n149#4:3016\n149#4:3023\n149#4:3024\n149#4:3025\n149#4:3032\n149#4:3039\n149#4:3040\n149#4:3070\n149#4:3071\n149#4:3190\n149#4:3191\n149#4:3193\n149#4:3194\n149#4:3270\n149#4:3271\n149#4:3272\n149#4:3273\n149#4:3310\n149#4:3315\n149#4:3363\n149#4:3364\n149#4:3365\n149#4:3366\n149#4:3403\n149#4:3408\n149#4:3419\n149#4:3467\n149#4:3472\n159#4:3517\n149#4:3518\n159#4:3531\n149#4:3532\n149#4:3553\n149#4:3593\n149#4:3635\n149#4:3636\n149#4:3704\n149#4:3747\n149#4:3917\n149#4:3975\n149#4:4011\n149#4:4018\n149#4:4067\n149#4:4142\n149#4:4153\n149#4:4154\n149#4:4319\n149#4:4326\n149#4:4352\n149#4:4400\n71#5:1820\n69#5,5:1821\n74#5:1854\n78#5:1861\n71#5:2271\n69#5,5:2272\n74#5:2305\n78#5:2322\n71#5:2566\n69#5,5:2567\n74#5:2600\n78#5:2607\n71#5:2610\n68#5,6:2611\n74#5:2645\n78#5:2649\n71#5:2762\n68#5,6:2763\n74#5:2797\n78#5:2802\n71#5:2898\n69#5,5:2899\n74#5:2932\n78#5:2936\n71#5:3195\n69#5,5:3196\n74#5:3229\n78#5:3233\n71#5:3432\n69#5,5:3433\n74#5:3466\n78#5:3471\n79#6,6:1826\n86#6,4:1841\n90#6,2:1851\n94#6:1860\n79#6,6:2100\n86#6,4:2115\n90#6,2:2125\n79#6,6:2143\n86#6,4:2158\n90#6,2:2168\n94#6:2181\n94#6:2185\n79#6,6:2194\n86#6,4:2209\n90#6,2:2219\n79#6,6:2236\n86#6,4:2251\n90#6,2:2261\n94#6:2267\n79#6,6:2277\n86#6,4:2292\n90#6,2:2302\n94#6:2321\n94#6:2325\n79#6,6:2371\n86#6,4:2386\n90#6,2:2396\n94#6:2410\n79#6,6:2438\n86#6,4:2453\n90#6,2:2463\n94#6:2478\n79#6,6:2487\n86#6,4:2502\n90#6,2:2512\n79#6,6:2525\n86#6,4:2540\n90#6,2:2550\n94#6:2556\n79#6,6:2572\n86#6,4:2587\n90#6,2:2597\n94#6:2606\n79#6,6:2617\n86#6,4:2632\n90#6,2:2642\n94#6:2648\n94#6:2652\n79#6,6:2660\n86#6,4:2675\n90#6,2:2685\n94#6:2715\n79#6,6:2731\n86#6,4:2746\n90#6,2:2756\n79#6,6:2769\n86#6,4:2784\n90#6,2:2794\n94#6:2801\n94#6:2807\n79#6,6:2904\n86#6,4:2919\n90#6,2:2929\n94#6:2935\n79#6,6:2958\n86#6,4:2973\n90#6,2:2983\n94#6:3043\n79#6,6:3201\n86#6,4:3216\n90#6,2:3226\n94#6:3232\n79#6,6:3241\n86#6,4:3256\n90#6,2:3266\n79#6,6:3281\n86#6,4:3296\n90#6,2:3306\n94#6:3313\n94#6:3318\n79#6,6:3334\n86#6,4:3349\n90#6,2:3359\n79#6,6:3374\n86#6,4:3389\n90#6,2:3399\n94#6:3406\n94#6:3411\n79#6,6:3438\n86#6,4:3453\n90#6,2:3463\n94#6:3470\n79#6,6:3481\n86#6,4:3496\n90#6,2:3506\n94#6:3542\n79#6,6:3602\n86#6,4:3617\n90#6,2:3627\n94#6:3633\n79#6,6:3643\n86#6,4:3658\n90#6,2:3668\n79#6,6:3675\n86#6,4:3690\n90#6,2:3700\n94#6:3713\n79#6,6:3718\n86#6,4:3733\n90#6,2:3743\n79#6,6:3756\n86#6,4:3771\n90#6,2:3781\n94#6:3795\n94#6:3799\n79#6,6:3804\n86#6,4:3819\n90#6,2:3829\n94#6:3841\n79#6,6:3846\n86#6,4:3861\n90#6,2:3871\n94#6:3883\n79#6,6:3888\n86#6,4:3903\n90#6,2:3913\n79#6,6:3926\n86#6,4:3941\n90#6,2:3951\n94#6:3965\n94#6:3969\n94#6:3973\n79#6,6:3982\n86#6,4:3997\n90#6,2:4007\n79#6,6:4028\n86#6,4:4043\n90#6,2:4053\n94#6:4065\n79#6,6:4071\n86#6,4:4086\n90#6,2:4096\n94#6:4108\n79#6,6:4113\n86#6,4:4128\n90#6,2:4138\n94#6:4151\n79#6,6:4163\n86#6,4:4178\n90#6,2:4188\n79#6,6:4197\n86#6,4:4212\n90#6,2:4222\n79#6,6:4233\n86#6,4:4248\n90#6,2:4258\n94#6:4270\n94#6:4280\n79#6,6:4290\n86#6,4:4305\n90#6,2:4315\n94#6:4335\n94#6:4339\n94#6:4343\n79#6,6:4359\n86#6,4:4374\n90#6,2:4384\n79#6,6:4409\n86#6,4:4424\n90#6,2:4434\n94#6:4446\n94#6:4451\n368#7,9:1832\n377#7:1853\n378#7,2:1858\n368#7,9:2106\n377#7:2127\n368#7,9:2149\n377#7:2170\n378#7,2:2179\n378#7,2:2183\n368#7,9:2200\n377#7:2221\n368#7,9:2242\n377#7:2263\n378#7,2:2265\n368#7,9:2283\n377#7:2304\n378#7,2:2319\n378#7,2:2323\n368#7,9:2377\n377#7:2398\n378#7,2:2408\n368#7,9:2444\n377#7:2465\n378#7,2:2476\n368#7,9:2493\n377#7:2514\n368#7,9:2531\n377#7:2552\n378#7,2:2554\n368#7,9:2578\n377#7:2599\n378#7,2:2604\n368#7,9:2623\n377#7:2644\n378#7,2:2646\n378#7,2:2650\n368#7,9:2666\n377#7:2687\n378#7,2:2713\n368#7,9:2737\n377#7:2758\n368#7,9:2775\n377#7:2796\n378#7,2:2799\n378#7,2:2805\n368#7,9:2910\n377#7:2931\n378#7,2:2933\n368#7,9:2964\n377#7:2985\n378#7,2:3041\n368#7,9:3207\n377#7:3228\n378#7,2:3230\n368#7,9:3247\n377#7:3268\n368#7,9:3287\n377#7:3308\n378#7,2:3311\n378#7,2:3316\n368#7,9:3340\n377#7:3361\n368#7,9:3380\n377#7:3401\n378#7,2:3404\n378#7,2:3409\n368#7,9:3444\n377#7:3465\n378#7,2:3468\n368#7,9:3487\n377#7:3508\n378#7,2:3540\n368#7,9:3608\n377#7:3629\n378#7,2:3631\n368#7,9:3649\n377#7:3670\n368#7,9:3681\n377#7:3702\n378#7,2:3711\n368#7,9:3724\n377#7:3745\n368#7,9:3762\n377#7:3783\n378#7,2:3793\n378#7,2:3797\n368#7,9:3810\n377#7:3831\n378#7,2:3839\n368#7,9:3852\n377#7:3873\n378#7,2:3881\n368#7,9:3894\n377#7:3915\n368#7,9:3932\n377#7:3953\n378#7,2:3963\n378#7,2:3967\n378#7,2:3971\n368#7,9:3988\n377#7:4009\n368#7,9:4034\n377#7:4055\n378#7,2:4063\n368#7,9:4077\n377#7:4098\n378#7,2:4106\n368#7,9:4119\n377#7:4140\n378#7,2:4149\n368#7,9:4169\n377#7:4190\n368#7,9:4203\n377#7:4224\n368#7,9:4239\n377#7:4260\n378#7,2:4268\n378#7,2:4278\n368#7,9:4296\n377#7:4317\n378#7,2:4333\n378#7,2:4337\n378#7,2:4341\n368#7,9:4365\n377#7:4386\n368#7,9:4415\n377#7:4436\n378#7,2:4444\n378#7,2:4449\n4034#8,6:1845\n4034#8,6:2119\n4034#8,6:2162\n4034#8,6:2213\n4034#8,6:2255\n4034#8,6:2296\n4034#8,6:2390\n4034#8,6:2457\n4034#8,6:2506\n4034#8,6:2544\n4034#8,6:2591\n4034#8,6:2636\n4034#8,6:2679\n4034#8,6:2750\n4034#8,6:2788\n4034#8,6:2923\n4034#8,6:2977\n4034#8,6:3220\n4034#8,6:3260\n4034#8,6:3300\n4034#8,6:3353\n4034#8,6:3393\n4034#8,6:3457\n4034#8,6:3500\n4034#8,6:3621\n4034#8,6:3662\n4034#8,6:3694\n4034#8,6:3737\n4034#8,6:3775\n4034#8,6:3823\n4034#8,6:3865\n4034#8,6:3907\n4034#8,6:3945\n4034#8,6:4001\n4034#8,6:4047\n4034#8,6:4090\n4034#8,6:4132\n4034#8,6:4182\n4034#8,6:4216\n4034#8,6:4252\n4034#8,6:4309\n4034#8,6:4378\n4034#8,6:4428\n481#9:1960\n480#9,4:1961\n484#9,2:1968\n488#9:1974\n481#9:2005\n480#9,4:2006\n484#9,2:2013\n488#9:2019\n480#10:1970\n480#10:2015\n1869#11,2:2071\n1617#11,9:2073\n1869#11:2082\n1870#11:2084\n1626#11:2085\n1869#11,2:2086\n1011#11,2:2088\n1617#11,9:2306\n1869#11:2315\n1870#11:2317\n1626#11:2318\n774#11:2336\n865#11,2:2337\n1869#11,2:2339\n1617#11,9:2341\n1869#11:2350\n1870#11:2352\n1626#11:2353\n774#11:2354\n865#11,2:2355\n1869#11,2:2357\n1011#11,2:2359\n774#11:2885\n865#11,2:2886\n1869#11:3510\n1870#11:3539\n774#11:3547\n865#11,2:3548\n1869#11:3785\n1870#11:3792\n1869#11:3955\n1870#11:3962\n1878#11,2:4192\n1880#11:4282\n1869#11:4401\n1870#11:4448\n1#12:2083\n1#12:2188\n1#12:2316\n1#12:2351\n1#12:2415\n86#13:2093\n83#13,6:2094\n89#13:2128\n86#13:2136\n83#13,6:2137\n89#13:2171\n93#13:2182\n93#13:2186\n86#13:2229\n83#13,6:2230\n89#13:2264\n93#13:2268\n86#13:2431\n83#13,6:2432\n89#13:2466\n93#13:2479\n86#13:2518\n83#13,6:2519\n89#13:2553\n93#13:2557\n86#13:2724\n83#13,6:2725\n89#13:2759\n93#13:2808\n86#13:2951\n83#13,6:2952\n89#13:2986\n93#13:3044\n86#13:3274\n83#13,6:3275\n89#13:3309\n93#13:3314\n86#13:3367\n83#13,6:3368\n89#13:3402\n93#13:3407\n86#13:3473\n82#13,7:3474\n89#13:3509\n93#13:3543\n86#13:3637\n84#13,5:3638\n89#13:3671\n93#13:3974\n86#13:3976\n84#13,5:3977\n89#13:4010\n86#13:4155\n82#13,7:4156\n89#13:4191\n93#13:4340\n93#13:4344\n86#13:4353\n84#13,5:4354\n89#13:4387\n93#13:4452\n77#14:2187\n77#14:2881\n99#15,3:2191\n102#15:2222\n106#15:2326\n99#15:2364\n96#15,6:2365\n102#15:2399\n106#15:2411\n99#15:2480\n96#15,6:2481\n102#15:2515\n106#15:2653\n99#15,3:2657\n102#15:2688\n106#15:2716\n99#15:3234\n96#15,6:3235\n102#15:3269\n106#15:3319\n99#15:3327\n96#15,6:3328\n102#15:3362\n106#15:3412\n99#15:3594\n95#15,7:3595\n102#15:3630\n106#15:3634\n99#15,3:3672\n102#15:3703\n106#15:3714\n99#15,3:3715\n102#15:3746\n99#15:3748\n95#15,7:3749\n102#15:3784\n106#15:3796\n106#15:3800\n99#15,3:3801\n102#15:3832\n106#15:3842\n99#15,3:3843\n102#15:3874\n106#15:3884\n99#15,3:3885\n102#15:3916\n99#15:3918\n95#15,7:3919\n102#15:3954\n106#15:3966\n106#15:3970\n99#15,3:4025\n102#15:4056\n106#15:4066\n99#15,3:4068\n102#15:4099\n106#15:4109\n99#15,3:4110\n102#15:4141\n106#15:4152\n99#15,3:4194\n102#15:4225\n99#15:4226\n96#15,6:4227\n102#15:4261\n106#15:4271\n106#15:4281\n99#15:4283\n96#15,6:4284\n102#15:4318\n106#15:4336\n99#15:4402\n96#15,6:4403\n102#15:4437\n106#15:4447\n81#16:2891\n81#16:2937\n81#16:2938\n107#16,2:2939\n81#16:2941\n107#16,2:2942\n81#16:2944\n107#16,2:2945\n81#16:2947\n107#16,2:2948\n81#16:3045\n81#16:3046\n107#16,2:3047\n81#16:3049\n107#16,2:3050\n81#16:3052\n107#16,2:3053\n81#16:3055\n107#16,2:3056\n81#16:3058\n107#16,2:3059\n81#16:3061\n107#16,2:3062\n81#16:3168\n107#16,2:3169\n81#16:3171\n107#16,2:3172\n81#16:3174\n81#16:3175\n81#16:3176\n81#16:3177\n81#16:3192\n81#16:3326\n81#16:3554\n107#16,2:3555\n81#16:3557\n107#16,2:3558\n81#16:3560\n107#16,2:3561\n81#16:3563\n107#16,2:3564\n81#16:3566\n107#16,2:3567\n81#16:3569\n107#16,2:3570\n81#16:3572\n107#16,2:3573\n81#16:3575\n107#16,2:3576\n81#16:3578\n107#16,2:3579\n81#16:3581\n107#16,2:3582\n81#16:3584\n107#16,2:3585\n81#16:4345\n143#17,12:3178\n*S KotlinDebug\n*F\n+ 1 MainActivity.kt\ncom/example/MainActivityKt\n*L\n83#1:1754,11\n315#1:1862,11\n316#1:1873,11\n317#1:1884,11\n318#1:1895,11\n86#1:1765,6\n90#1:1771,6\n111#1:1777,6\n132#1:1783,6\n133#1:1789,6\n134#1:1795,6\n135#1:1801,6\n139#1:1807,6\n143#1:1813,6\n321#1:1906,6\n323#1:1912,6\n330#1:1918,6\n331#1:1924,6\n332#1:1930,6\n333#1:1936,6\n334#1:1942,6\n443#1:1948,6\n445#1:1954,6\n468#1:1965,3\n468#1:1971,3\n469#1:1975,6\n470#1:1981,6\n479#1:1987,6\n480#1:1993,6\n484#1:1999,6\n511#1:2010,3\n511#1:2016,3\n512#1:2020,6\n513#1:2026,6\n516#1:2032,6\n534#1:2038,6\n535#1:2044,6\n539#1:2050,6\n559#1:2056,6\n560#1:2062,6\n586#1:2068,3\n586#1:2090,3\n602#1:2129,6\n622#1:2173,6\n653#1:2223,6\n706#1:2327,6\n708#1:2333,3\n708#1:2361,3\n743#1:2402,6\n801#1:2412,3\n801#1:2416,3\n808#1:2419,6\n815#1:2425,6\n848#1:2470,6\n1164#1:2560,6\n1220#1:2689,6\n1221#1:2695,6\n1222#1:2701,6\n1223#1:2707,6\n1233#1:2717,6\n1276#1:2809,6\n1277#1:2815,6\n1278#1:2821,6\n1279#1:2827,6\n1288#1:2833,6\n1289#1:2839,6\n1297#1:2845,6\n1299#1:2851,6\n1300#1:2857,6\n1301#1:2863,6\n1303#1:2869,6\n1306#1:2875,6\n1623#1:2882,3\n1623#1:2888,3\n117#1:2892,6\n203#1:2992,6\n214#1:3000,6\n224#1:3008,6\n234#1:3017,6\n256#1:3026,6\n278#1:3033,6\n339#1:3064,6\n350#1:3072,6\n373#1:3078,6\n374#1:3084,6\n375#1:3090,6\n378#1:3096,6\n381#1:3102,6\n385#1:3108,6\n386#1:3114,6\n404#1:3120,6\n405#1:3126,6\n406#1:3132,6\n409#1:3138,6\n412#1:3144,6\n415#1:3150,6\n416#1:3156,6\n368#1:3162,6\n976#1:3320,6\n1074#1:3413,6\n872#1:3420,6\n873#1:3426,6\n901#1:3511,6\n923#1:3519,6\n1022#1:3525,6\n1044#1:3533,6\n853#1:3544,3\n853#1:3550,3\n1575#1:3587,6\n1371#1:3705,6\n1400#1:3786,6\n1413#1:3833,6\n1422#1:3875,6\n1436#1:3956,6\n1328#1:4012,6\n1337#1:4019,6\n1351#1:4057,6\n1452#1:4100,6\n1463#1:4143,6\n1520#1:4262,6\n1529#1:4272,6\n1541#1:4320,6\n1549#1:4327,6\n1712#1:4346,6\n1644#1:4388,6\n1656#1:4394,6\n1689#1:4438,6\n163#1:1819\n167#1:1855\n168#1:1856\n172#1:1857\n607#1:2135\n615#1:2172\n647#1:2189\n648#1:2190\n686#1:2269\n688#1:2270\n731#1:2400\n741#1:2401\n841#1:2467\n845#1:2468\n846#1:2469\n1143#1:2516\n1144#1:2517\n1157#1:2558\n1162#1:2559\n1176#1:2601\n1181#1:2602\n1188#1:2603\n1196#1:2608\n1201#1:2609\n1213#1:2654\n1215#1:2655\n1216#1:2656\n1234#1:2723\n1239#1:2760\n1240#1:2761\n1242#1:2798\n1245#1:2803\n1247#1:2804\n175#1:2950\n182#1:2987\n184#1:2988\n191#1:2989\n198#1:2990\n207#1:2991\n209#1:2998\n218#1:2999\n220#1:3006\n229#1:3007\n231#1:3014\n242#1:3015\n243#1:3016\n252#1:3023\n264#1:3024\n265#1:3025\n276#1:3032\n287#1:3039\n292#1:3040\n356#1:3070\n357#1:3071\n874#1:3190\n883#1:3191\n956#1:3193\n957#1:3194\n984#1:3270\n986#1:3271\n989#1:3272\n990#1:3273\n1003#1:3310\n1012#1:3315\n1082#1:3363\n1084#1:3364\n1087#1:3365\n1088#1:3366\n1101#1:3403\n1109#1:3408\n870#1:3419\n892#1:3467\n896#1:3472\n917#1:3517\n919#1:3518\n1038#1:3531\n1040#1:3532\n1170#1:3553\n1599#1:3593\n1361#1:3635\n1362#1:3636\n1384#1:3704\n1396#1:3747\n1432#1:3917\n1324#1:3975\n1332#1:4011\n1342#1:4018\n1357#1:4067\n1493#1:4142\n1507#1:4153\n1510#1:4154\n1545#1:4319\n1547#1:4326\n1641#1:4352\n1673#1:4400\n159#1:1820\n159#1:1821,5\n159#1:1854\n159#1:1861\n684#1:2271\n684#1:2272,5\n684#1:2305\n684#1:2322\n1160#1:2566\n1160#1:2567,5\n1160#1:2600\n1160#1:2607\n1198#1:2610\n1198#1:2611,6\n1198#1:2645\n1198#1:2649\n1237#1:2762\n1237#1:2763,6\n1237#1:2797\n1237#1:2802\n120#1:2898\n120#1:2899,5\n120#1:2932\n120#1:2936\n953#1:3195\n953#1:3196,5\n953#1:3229\n953#1:3233\n867#1:3432\n867#1:3433,5\n867#1:3466\n867#1:3471\n159#1:1826,6\n159#1:1841,4\n159#1:1851,2\n159#1:1860\n601#1:2100,6\n601#1:2115,4\n601#1:2125,2\n604#1:2143,6\n604#1:2158,4\n604#1:2168,2\n604#1:2181\n601#1:2185\n644#1:2194,6\n644#1:2209,4\n644#1:2219,2\n652#1:2236,6\n652#1:2251,4\n652#1:2261,2\n652#1:2267\n684#1:2277,6\n684#1:2292,4\n684#1:2302,2\n684#1:2321\n644#1:2325\n721#1:2371,6\n721#1:2386,4\n721#1:2396,2\n721#1:2410\n833#1:2438,6\n833#1:2453,4\n833#1:2463,2\n833#1:2478\n1135#1:2487,6\n1135#1:2502,4\n1135#1:2512,2\n1141#1:2525,6\n1141#1:2540,4\n1141#1:2550,2\n1141#1:2556\n1160#1:2572,6\n1160#1:2587,4\n1160#1:2597,2\n1160#1:2606\n1198#1:2617,6\n1198#1:2632,4\n1198#1:2642,2\n1198#1:2648\n1135#1:2652\n1210#1:2660,6\n1210#1:2675,4\n1210#1:2685,2\n1210#1:2715\n1229#1:2731,6\n1229#1:2746,4\n1229#1:2756,2\n1237#1:2769,6\n1237#1:2784,4\n1237#1:2794,2\n1237#1:2801\n1229#1:2807\n120#1:2904,6\n120#1:2919,4\n120#1:2929,2\n120#1:2935\n174#1:2958,6\n174#1:2973,4\n174#1:2983,2\n174#1:3043\n953#1:3201,6\n953#1:3216,4\n953#1:3226,2\n953#1:3232\n978#1:3241,6\n978#1:3256,4\n978#1:3266,2\n990#1:3281,6\n990#1:3296,4\n990#1:3306,2\n990#1:3313\n978#1:3318\n1076#1:3334,6\n1076#1:3349,4\n1076#1:3359,2\n1088#1:3374,6\n1088#1:3389,4\n1088#1:3399,2\n1088#1:3406\n1076#1:3411\n867#1:3438,6\n867#1:3453,4\n867#1:3463,2\n867#1:3470\n896#1:3481,6\n896#1:3496,4\n896#1:3506,2\n896#1:3542\n1599#1:3602,6\n1599#1:3617,4\n1599#1:3627,2\n1599#1:3633\n1360#1:3643,6\n1360#1:3658,4\n1360#1:3668,2\n1364#1:3675,6\n1364#1:3690,4\n1364#1:3700,2\n1364#1:3713\n1390#1:3718,6\n1390#1:3733,4\n1390#1:3743,2\n1396#1:3756,6\n1396#1:3771,4\n1396#1:3781,2\n1396#1:3795\n1390#1:3799\n1407#1:3804,6\n1407#1:3819,4\n1407#1:3829,2\n1407#1:3841\n1416#1:3846,6\n1416#1:3861,4\n1416#1:3871,2\n1416#1:3883\n1426#1:3888,6\n1426#1:3903,4\n1426#1:3913,2\n1432#1:3926,6\n1432#1:3941,4\n1432#1:3951,2\n1432#1:3965\n1426#1:3969\n1360#1:3973\n1320#1:3982,6\n1320#1:3997,4\n1320#1:4007,2\n1345#1:4028,6\n1345#1:4043,4\n1345#1:4053,2\n1345#1:4065\n1446#1:4071,6\n1446#1:4086,4\n1446#1:4096,2\n1446#1:4108\n1456#1:4113,6\n1456#1:4128,4\n1456#1:4138,2\n1456#1:4151\n1510#1:4163,6\n1510#1:4178,4\n1510#1:4188,2\n1512#1:4197,6\n1512#1:4212,4\n1512#1:4222,2\n1517#1:4233,6\n1517#1:4248,4\n1517#1:4258,2\n1517#1:4270\n1512#1:4280\n1535#1:4290,6\n1535#1:4305,4\n1535#1:4315,2\n1535#1:4335\n1510#1:4339\n1320#1:4343\n1637#1:4359,6\n1637#1:4374,4\n1637#1:4384,2\n1683#1:4409,6\n1683#1:4424,4\n1683#1:4434,2\n1683#1:4446\n1637#1:4451\n159#1:1832,9\n159#1:1853\n159#1:1858,2\n601#1:2106,9\n601#1:2127\n604#1:2149,9\n604#1:2170\n604#1:2179,2\n601#1:2183,2\n644#1:2200,9\n644#1:2221\n652#1:2242,9\n652#1:2263\n652#1:2265,2\n684#1:2283,9\n684#1:2304\n684#1:2319,2\n644#1:2323,2\n721#1:2377,9\n721#1:2398\n721#1:2408,2\n833#1:2444,9\n833#1:2465\n833#1:2476,2\n1135#1:2493,9\n1135#1:2514\n1141#1:2531,9\n1141#1:2552\n1141#1:2554,2\n1160#1:2578,9\n1160#1:2599\n1160#1:2604,2\n1198#1:2623,9\n1198#1:2644\n1198#1:2646,2\n1135#1:2650,2\n1210#1:2666,9\n1210#1:2687\n1210#1:2713,2\n1229#1:2737,9\n1229#1:2758\n1237#1:2775,9\n1237#1:2796\n1237#1:2799,2\n1229#1:2805,2\n120#1:2910,9\n120#1:2931\n120#1:2933,2\n174#1:2964,9\n174#1:2985\n174#1:3041,2\n953#1:3207,9\n953#1:3228\n953#1:3230,2\n978#1:3247,9\n978#1:3268\n990#1:3287,9\n990#1:3308\n990#1:3311,2\n978#1:3316,2\n1076#1:3340,9\n1076#1:3361\n1088#1:3380,9\n1088#1:3401\n1088#1:3404,2\n1076#1:3409,2\n867#1:3444,9\n867#1:3465\n867#1:3468,2\n896#1:3487,9\n896#1:3508\n896#1:3540,2\n1599#1:3608,9\n1599#1:3629\n1599#1:3631,2\n1360#1:3649,9\n1360#1:3670\n1364#1:3681,9\n1364#1:3702\n1364#1:3711,2\n1390#1:3724,9\n1390#1:3745\n1396#1:3762,9\n1396#1:3783\n1396#1:3793,2\n1390#1:3797,2\n1407#1:3810,9\n1407#1:3831\n1407#1:3839,2\n1416#1:3852,9\n1416#1:3873\n1416#1:3881,2\n1426#1:3894,9\n1426#1:3915\n1432#1:3932,9\n1432#1:3953\n1432#1:3963,2\n1426#1:3967,2\n1360#1:3971,2\n1320#1:3988,9\n1320#1:4009\n1345#1:4034,9\n1345#1:4055\n1345#1:4063,2\n1446#1:4077,9\n1446#1:4098\n1446#1:4106,2\n1456#1:4119,9\n1456#1:4140\n1456#1:4149,2\n1510#1:4169,9\n1510#1:4190\n1512#1:4203,9\n1512#1:4224\n1517#1:4239,9\n1517#1:4260\n1517#1:4268,2\n1512#1:4278,2\n1535#1:4296,9\n1535#1:4317\n1535#1:4333,2\n1510#1:4337,2\n1320#1:4341,2\n1637#1:4365,9\n1637#1:4386\n1683#1:4415,9\n1683#1:4436\n1683#1:4444,2\n1637#1:4449,2\n159#1:1845,6\n601#1:2119,6\n604#1:2162,6\n644#1:2213,6\n652#1:2255,6\n684#1:2296,6\n721#1:2390,6\n833#1:2457,6\n1135#1:2506,6\n1141#1:2544,6\n1160#1:2591,6\n1198#1:2636,6\n1210#1:2679,6\n1229#1:2750,6\n1237#1:2788,6\n120#1:2923,6\n174#1:2977,6\n953#1:3220,6\n978#1:3260,6\n990#1:3300,6\n1076#1:3353,6\n1088#1:3393,6\n867#1:3457,6\n896#1:3500,6\n1599#1:3621,6\n1360#1:3662,6\n1364#1:3694,6\n1390#1:3737,6\n1396#1:3775,6\n1407#1:3823,6\n1416#1:3865,6\n1426#1:3907,6\n1432#1:3945,6\n1320#1:4001,6\n1345#1:4047,6\n1446#1:4090,6\n1456#1:4132,6\n1510#1:4182,6\n1512#1:4216,6\n1517#1:4252,6\n1535#1:4309,6\n1637#1:4378,6\n1683#1:4428,6\n468#1:1960\n468#1:1961,4\n468#1:1968,2\n468#1:1974\n511#1:2005\n511#1:2006,4\n511#1:2013,2\n511#1:2019\n468#1:1970\n511#1:2015\n588#1:2071,2\n590#1:2073,9\n590#1:2082\n590#1:2084\n590#1:2085\n591#1:2086,2\n597#1:2088,2\n693#1:2306,9\n693#1:2315\n693#1:2317\n693#1:2318\n710#1:2336\n710#1:2337,2\n711#1:2339,2\n713#1:2341,9\n713#1:2350\n713#1:2352\n713#1:2353\n714#1:2354\n714#1:2355,2\n715#1:2357,2\n717#1:2359,2\n1624#1:2885\n1624#1:2886,2\n897#1:3510\n897#1:3539\n854#1:3547\n854#1:3548,2\n1397#1:3785\n1397#1:3792\n1433#1:3955\n1433#1:3962\n1511#1:4192,2\n1511#1:4282\n1682#1:4401\n1682#1:4448\n590#1:2083\n693#1:2316\n713#1:2351\n601#1:2093\n601#1:2094,6\n601#1:2128\n604#1:2136\n604#1:2137,6\n604#1:2171\n604#1:2182\n601#1:2186\n652#1:2229\n652#1:2230,6\n652#1:2264\n652#1:2268\n833#1:2431\n833#1:2432,6\n833#1:2466\n833#1:2479\n1141#1:2518\n1141#1:2519,6\n1141#1:2553\n1141#1:2557\n1229#1:2724\n1229#1:2725,6\n1229#1:2759\n1229#1:2808\n174#1:2951\n174#1:2952,6\n174#1:2986\n174#1:3044\n990#1:3274\n990#1:3275,6\n990#1:3309\n990#1:3314\n1088#1:3367\n1088#1:3368,6\n1088#1:3402\n1088#1:3407\n896#1:3473\n896#1:3474,7\n896#1:3509\n896#1:3543\n1360#1:3637\n1360#1:3638,5\n1360#1:3671\n1360#1:3974\n1320#1:3976\n1320#1:3977,5\n1320#1:4010\n1510#1:4155\n1510#1:4156,7\n1510#1:4191\n1510#1:4340\n1320#1:4344\n1637#1:4353\n1637#1:4354,5\n1637#1:4387\n1637#1:4452\n639#1:2187\n1308#1:2881\n644#1:2191,3\n644#1:2222\n644#1:2326\n721#1:2364\n721#1:2365,6\n721#1:2399\n721#1:2411\n1135#1:2480\n1135#1:2481,6\n1135#1:2515\n1135#1:2653\n1210#1:2657,3\n1210#1:2688\n1210#1:2716\n978#1:3234\n978#1:3235,6\n978#1:3269\n978#1:3319\n1076#1:3327\n1076#1:3328,6\n1076#1:3362\n1076#1:3412\n1599#1:3594\n1599#1:3595,7\n1599#1:3630\n1599#1:3634\n1364#1:3672,3\n1364#1:3703\n1364#1:3714\n1390#1:3715,3\n1390#1:3746\n1396#1:3748\n1396#1:3749,7\n1396#1:3784\n1396#1:3796\n1390#1:3800\n1407#1:3801,3\n1407#1:3832\n1407#1:3842\n1416#1:3843,3\n1416#1:3874\n1416#1:3884\n1426#1:3885,3\n1426#1:3916\n1432#1:3918\n1432#1:3919,7\n1432#1:3954\n1432#1:3966\n1426#1:3970\n1345#1:4025,3\n1345#1:4056\n1345#1:4066\n1446#1:4068,3\n1446#1:4099\n1446#1:4109\n1456#1:4110,3\n1456#1:4141\n1456#1:4152\n1512#1:4194,3\n1512#1:4225\n1517#1:4226\n1517#1:4227,6\n1517#1:4261\n1517#1:4271\n1512#1:4281\n1535#1:4283\n1535#1:4284,6\n1535#1:4318\n1535#1:4336\n1683#1:4402\n1683#1:4403,6\n1683#1:4437\n1683#1:4447\n84#1:2891\n130#1:2937\n132#1:2938\n132#1:2939,2\n133#1:2941\n133#1:2942,2\n134#1:2944\n134#1:2945,2\n135#1:2947\n135#1:2948,2\n312#1:3045\n321#1:3046\n321#1:3047,2\n330#1:3049\n330#1:3050,2\n331#1:3052\n331#1:3053,2\n332#1:3055\n332#1:3056,2\n333#1:3058\n333#1:3059,2\n334#1:3061\n334#1:3062,2\n469#1:3168\n469#1:3169,2\n512#1:3171\n512#1:3172,2\n581#1:3174\n582#1:3175\n583#1:3176\n584#1:3177\n906#1:3192\n1027#1:3326\n1276#1:3554\n1276#1:3555,2\n1277#1:3557\n1277#1:3558,2\n1278#1:3560\n1278#1:3561,2\n1279#1:3563\n1279#1:3564,2\n1288#1:3566\n1288#1:3567,2\n1289#1:3569\n1289#1:3570,2\n1297#1:3572\n1297#1:3573,2\n1299#1:3575\n1299#1:3576,2\n1300#1:3578\n1300#1:3579,2\n1301#1:3581\n1301#1:3582,2\n1306#1:3584\n1306#1:3585,2\n1622#1:4345\n744#1:3178,12\n*E\n"})
public final class MainActivityKt {
   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void MainAppNavigation(@NotNull SettingsViewModel settingsViewModel, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(settingsViewModel, "settingsViewModel");
      $composer = $composer.startRestartGroup(2083918586);
      ComposerKt.sourceInformation($composer, "C(MainAppNavigation)81@3362L23,82@3425L11,83@3482L29,85@3534L96,89@3662L695,89@3636L721,110@4433L556,110@4363L626:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changedInstance(settingsViewModel) ? 4 : 2);
      }

      if (($dirty & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2083918586, $dirty, -1, "com.example.MainAppNavigation (MainActivity.kt:80)");
         }

         final NavHostController navController = NavHostControllerKt.rememberNavController(new Navigator[0], $composer, 0);
         int var11 = 0;
         int var12 = 0;
         $composer.startReplaceableGroup(1729797275);
         ComposerKt.sourceInformation($composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
         ViewModelStoreOwner var10000 = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer, 6);
         if (var10000 == null) {
            int var43 = 0;
            String var44 = "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner";
            throw new IllegalStateException(var44.toString());
         }

         ViewModelStoreOwner var6 = var10000;
         String var7 = null;
         ViewModelProvider.Factory var8 = null;
         CreationExtras var9 = var6 instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory)var6).getDefaultViewModelCreationExtras() : (CreationExtras)Empty.INSTANCE;
         ViewModel var14 = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(AuthViewModel.class), var6, var7, var8, var9, $composer, 112 & var11 << 3 | 896 & var11 << 3 | 7168 & var11 << 3 | '\ue000' & var11 << 3, 0);
         $composer.endReplaceableGroup();
         AuthViewModel authViewModel = (AuthViewModel)var14;
         final State authState$delegate = FlowExtKt.collectAsStateWithLifecycle(authViewModel.getAuthState(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         ComposerKt.sourceInformationMarkerStart($composer, 1191009946, "CC(remember):MainActivity.kt#9igjgp");
         boolean var10 = false;
         var11 = 0;
         Object var38 = $composer.rememberedValue();
         int var13 = 0;
         Object var49;
         if (var38 == Composer.Companion.getEmpty()) {
            int var45 = 0;
            Object var46 = FirebaseAuth.getInstance().getCurrentUser() != null ? "main" : "login";
            $composer.updateRememberedValue(var46);
            var49 = var46;
         } else {
            var49 = var38;
         }

         String var30 = (String)var49;
         ComposerKt.sourceInformationMarkerEnd($composer);
         var7 = var30;
         AuthState var50 = MainAppNavigation$lambda$0(authState$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 1191014641, "CC(remember):MainActivity.kt#9igjgp");
         var10 = $composer.changedInstance(navController) | $composer.changed(authState$delegate);
         var11 = 0;
         var38 = $composer.rememberedValue();
         var13 = 0;
         Object var53;
         if (!var10 && var38 != Composer.Companion.getEmpty()) {
            var53 = var38;
         } else {
            AuthState var16 = var50;
            int var47 = 0;
            Function2 var10001 = new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        NavDestination var10000 = navController.getCurrentDestination();
                        if (var10000 != null) {
                           String var4 = var10000.getRoute();
                           if (var4 != null) {
                              String currentRoute = var4;
                              AuthState var3 = MainActivityKt.MainAppNavigation$lambda$0(authState$delegate);
                              if (var3 instanceof AuthState.Idle) {
                                 if (!Intrinsics.areEqual(currentRoute, "login")) {
                                    navController.navigate("login", <undefinedtype>::invokeSuspend$lambda$1);
                                 }
                              } else if (var3 instanceof AuthState.Success && !Intrinsics.areEqual(currentRoute, "main")) {
                                 navController.navigate("main", <undefinedtype>::invokeSuspend$lambda$3);
                              }

                              return Unit.INSTANCE;
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

               private static final Unit invokeSuspend$lambda$1$lambda$0(PopUpToBuilder $this$popUpTo) {
                  $this$popUpTo.setInclusive(true);
                  return Unit.INSTANCE;
               }

               private static final Unit invokeSuspend$lambda$1(NavHostController $navController, NavOptionsBuilder $this$navigate) {
                  $this$navigate.popUpTo($navController.getGraph().getStartDestinationId(), <undefinedtype>::invokeSuspend$lambda$1$lambda$0);
                  return Unit.INSTANCE;
               }

               private static final Unit invokeSuspend$lambda$3$lambda$2(PopUpToBuilder $this$popUpTo) {
                  $this$popUpTo.setInclusive(true);
                  return Unit.INSTANCE;
               }

               private static final Unit invokeSuspend$lambda$3(NavOptionsBuilder $this$navigate) {
                  $this$navigate.popUpTo("login", <undefinedtype>::invokeSuspend$lambda$3$lambda$2);
                  return Unit.INSTANCE;
               }
            };
            var50 = var16;
            Object var15 = var10001;
            $composer.updateRememberedValue(var15);
            var53 = var15;
         }

         Function2 var31 = (Function2)var53;
         ComposerKt.sourceInformationMarkerEnd($composer);
         EffectsKt.LaunchedEffect(var50, var31, $composer, 0);
         NavHostController var51 = navController;
         String var54 = var7;
         Object var10002 = null;
         Object var10003 = null;
         Object var10004 = null;
         Object var10005 = null;
         Object var10006 = null;
         Object var10007 = null;
         Object var10008 = null;
         Object var10009 = null;
         ComposerKt.sourceInformationMarkerStart($composer, 1191039174, "CC(remember):MainActivity.kt#9igjgp");
         var10 = $composer.changedInstance(navController) | $composer.changedInstance(authViewModel) | $composer.changed(authState$delegate) | $composer.changedInstance(settingsViewModel);
         var11 = 0;
         var38 = $composer.rememberedValue();
         var13 = 0;
         Object var10010;
         if (!var10 && var38 != Composer.Companion.getEmpty()) {
            var10010 = var38;
         } else {
            Object var25 = null;
            Object var24 = null;
            Object var23 = null;
            Object var22 = null;
            Object var21 = null;
            Object var20 = null;
            Object var19 = null;
            Object var18 = null;
            int var48 = 0;
            Function1 var15_4 = MainActivityKt::MainAppNavigation$lambda$9$lambda$8;
            var51 = navController;
            var54 = var7;
            var10002 = var18;
            var10003 = var19;
            var10004 = var20;
            var10005 = var21;
            var10006 = var22;
            var10007 = var23;
            var10008 = var24;
            var10009 = var25;
            $composer.updateRememberedValue(var15_4);
            var10010 = var15_4;
         }

         Function1 var32 = (Function1)var10010;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NavHostKt.NavHost(var51, var54, (Modifier)var10002, (Alignment)var10003, (String)var10004, (Function1)var10005, (Function1)var10006, (Function1)var10007, (Function1)var10008, (Function1)var10009, var32, $composer, 48, 0, 1020);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var52 = $composer.endRestartGroup();
      if (var52 != null) {
         var52.updateScope(MainActivityKt::MainAppNavigation$lambda$10);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void LoginScreen(@NotNull final NavHostController navController, @NotNull AuthViewModel authViewModel, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(navController, "navController");
      Intrinsics.checkNotNullParameter(authViewModel, "authViewModel");
      $composer = $composer.startRestartGroup(-670183159);
      ComposerKt.sourceInformation($composer, "C(LoginScreen)P(1)129@5132L29,131@5189L34,132@5241L31,133@5293L31,134@5345L31,138@5506L77,136@5397L186,142@5615L176,142@5589L202,150@5810L18,158@6033L6132:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changedInstance(navController) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(authViewModel) ? 32 : 16;
      }

      if (($dirty & 19) == 18 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-670183159, $dirty, -1, "com.example.LoginScreen (MainActivity.kt:128)");
         }

         final State authState$delegate = FlowExtKt.collectAsStateWithLifecycle(authViewModel.getAuthState(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         ComposerKt.sourceInformationMarkerStart($composer, 199084907, "CC(remember):MainActivity.kt#9igjgp");
         boolean var9 = false;
         int var10 = 0;
         Object var11 = $composer.rememberedValue();
         int var12 = 0;
         Object var10000;
         if (var11 == Composer.Companion.getEmpty()) {
            int var13 = 0;
            Object var61 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var61);
            var10000 = var61;
         } else {
            var10000 = var11;
         }

         MutableState email$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableState isRegisterMode$delegate = email$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 199086568, "CC(remember):MainActivity.kt#9igjgp");
         var10 = 0;
         int var52 = 0;
         Object var57 = $composer.rememberedValue();
         int var62 = 0;
         if (var57 == Composer.Companion.getEmpty()) {
            int var14 = 0;
            Object var70 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var70);
            var10000 = var70;
         } else {
            var10000 = var57;
         }

         MutableState password$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         email$delegate = password$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 199088232, "CC(remember):MainActivity.kt#9igjgp");
         var52 = 0;
         int var58 = 0;
         Object var63 = $composer.rememberedValue();
         int var71 = 0;
         if (var63 == Composer.Companion.getEmpty()) {
            int var15 = 0;
            Object var77 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var77);
            var10000 = var77;
         } else {
            var10000 = var63;
         }

         MutableState nickname$delegate = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         password$delegate = nickname$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 199089896, "CC(remember):MainActivity.kt#9igjgp");
         var58 = 0;
         int var64 = 0;
         Object var72 = $composer.rememberedValue();
         int var78 = 0;
         if (var72 == Composer.Companion.getEmpty()) {
            int var16 = 0;
            Object var82 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var82);
            var10000 = var82;
         } else {
            var10000 = var72;
         }

         MutableState var50 = (MutableState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         nickname$delegate = var50;
         ActivityResultContract var97 = (ActivityResultContract)(new ActivityResultContracts.StartActivityForResult());
         ComposerKt.sourceInformationMarkerStart($composer, 199095094, "CC(remember):MainActivity.kt#9igjgp");
         var64 = $composer.changedInstance(authViewModel);
         int var73 = 0;
         Object var79 = $composer.rememberedValue();
         int var83 = 0;
         Object var105;
         if (!var64 && var79 != Composer.Companion.getEmpty()) {
            var105 = var79;
         } else {
            ActivityResultContract var43 = var97;
            int var17 = 0;
            Function1 var10001 = MainActivityKt::LoginScreen$lambda$25$lambda$24;
            var97 = var43;
            Object var18 = var10001;
            $composer.updateRememberedValue(var18);
            var105 = var18;
         }

         Function1 var54 = (Function1)var105;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(var97, var54, $composer, 0);
         AuthState var98 = LoginScreen$lambda$11(authState$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 199098681, "CC(remember):MainActivity.kt#9igjgp");
         var64 = $composer.changed(authState$delegate) | $composer.changedInstance(navController);
         var73 = 0;
         var79 = $composer.rememberedValue();
         var83 = 0;
         if (!var64 && var79 != Composer.Companion.getEmpty()) {
            var105 = var79;
         } else {
            AuthState var93 = var98;
            int var85 = 0;
            Function2 var106 = new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        if (MainActivityKt.LoginScreen$lambda$11(authState$delegate) instanceof AuthState.Success) {
                           navController.navigate("main", <undefinedtype>::invokeSuspend$lambda$1);
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

               private static final Unit invokeSuspend$lambda$1$lambda$0(PopUpToBuilder $this$popUpTo) {
                  $this$popUpTo.setInclusive(true);
                  return Unit.INSTANCE;
               }

               private static final Unit invokeSuspend$lambda$1(NavOptionsBuilder $this$navigate) {
                  $this$navigate.popUpTo("login", <undefinedtype>::invokeSuspend$lambda$1$lambda$0);
                  return Unit.INSTANCE;
               }
            };
            var98 = var93;
            Object var87 = var106;
            $composer.updateRememberedValue(var87);
            var105 = var87;
         }

         Function2 isDark = (Function2)var105;
         ComposerKt.sourceInformationMarkerEnd($composer);
         EffectsKt.LaunchedEffect(var98, isDark, $composer, 0);
         boolean isDark = ThemeKt.isAppInDarkTheme($composer, 0);
         Brush.Companion var99 = Brush.Companion;
         Color[] var67 = new Color[]{Color.box-impl(isDark ? ColorKt.getDarkBackground() : ColorKt.getAppBackground()), Color.box-impl(isDark ? ColorKt.getDarkSurface() : ColorKt.getIndigo100())};
         Brush backgroundBrush = Companion.linearGradient-mHitzGk$default(var99, CollectionsKt.listOf(var67), 0L, 0L, 0, 14, (Object)null);
         Modifier var100 = BackgroundKt.background$default(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), backgroundBrush, (Shape)null, 0.0F, 6, (Object)null);
         int var68 = 24;
         var73 = 0;
         Modifier var69 = PaddingKt.padding-3ABfNKs(var100, Dp.constructor-impl((float)var68));
         Alignment var76 = Alignment.Companion.getCenter();
         byte var86 = 48;
         int var88 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         boolean var81 = false;
         MeasurePolicy var19 = BoxKt.maybeCachedBoxMeasurePolicy(var76, var81);
         int var20 = 112 & var86 << 3;
         int var21 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var22 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var23 = $composer.getCurrentCompositionLocalMap();
         Modifier var24 = ComposedModifierKt.materializeModifier($composer, var69);
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
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         int var37 = 6 | 112 & var86 >> 6;
         BoxScope var101 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var40 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1368570148, "C168@6379L112,172@6585L5574,165@6223L5936:MainActivity.kt#to5c3");
         Modifier var102 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var41 = 32;
         int var42 = 0;
         var102 = PaddingKt.padding-qDBjuR0$default(var102, 0.0F, Dp.constructor-impl((float)var41), 0.0F, 0.0F, 13, (Object)null);
         var41 = 32;
         var42 = 0;
         Shape var108 = (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var41));
         CardColors var10002 = CardDefaults.INSTANCE.cardColors-ro_MJ88(isDark ? Color.copy-wmQWz5c$default(ColorKt.getDarkCard(), 0.85F, 0.0F, 0.0F, 0.0F, 14, (Object)null) : ColorKt.getWhite90(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
         var41 = 1;
         var42 = 0;
         CardKt.Card(var102, var108, var10002, (CardElevation)null, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var41), isDark ? ColorKt.getDarkGlassBorder() : ColorKt.getWhite40()), (Function3)ComposableLambdaKt.rememberComposableLambda(1999399425, true, MainActivityKt::LoginScreen$lambda$43$lambda$42, $composer, 54), $composer, 196614, 8);
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

      ScopeUpdateScope var104 = $composer.endRestartGroup();
      if (var104 != null) {
         var104.updateScope(MainActivityKt::LoginScreen$lambda$44);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void MainDashboardScreen(@NotNull SettingsViewModel settingsViewModel, @NotNull Function0 onSignOut, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(settingsViewModel, "settingsViewModel");
      Intrinsics.checkNotNullParameter(onSignOut, "onSignOut");
      $composer = $composer.startRestartGroup(-1011343791);
      ComposerKt.sourceInformation($composer, "C(MainDashboardScreen)P(1)310@12348L23,311@12421L30,314@12562L11,315@12615L11,316@12674L11,317@12725L11,320@12815L42,322@12897L119,322@12863L153,329@13047L34,330@13117L39,331@13180L46,332@13257L49,333@13331L46,336@13432L11,337@13476L325,346@13834L624,362@14465L3211,335@13383L4293:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changedInstance(settingsViewModel) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(onSignOut) ? 32 : 16;
      }

      if (($dirty & 19) == 18 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1011343791, $dirty, -1, "com.example.MainDashboardScreen (MainActivity.kt:309)");
         }

         NavHostController bottomNavController;
         String var10000;
         label270: {
            bottomNavController = NavHostControllerKt.rememberNavController(new Navigator[0], $composer, 0);
            State navBackStackEntry$delegate = NavHostControllerKt.currentBackStackEntryAsState((NavController)bottomNavController, $composer, 0);
            NavBackStackEntry var8 = MainDashboardScreen$lambda$45(navBackStackEntry$delegate);
            if (var8 != null) {
               NavDestination var9 = var8.getDestination();
               if (var9 != null) {
                  String var10 = var9.getRoute();
                  var10000 = var10;
                  if (var10 != null) {
                     break label270;
                  }
               }
            }

            var10000 = "home";
         }

         String currentRoute = var10000;
         byte var14 = 0;
         int var15 = 0;
         $composer.startReplaceableGroup(1729797275);
         ComposerKt.sourceInformation($composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
         ViewModelStoreOwner var292 = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer, 6);
         if (var292 == null) {
            int var86 = 0;
            String editingTask$delegate = "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner";
            throw new IllegalStateException(editingTask$delegate.toString());
         }

         ViewModelStoreOwner notesViewModel = var292;
         String var59 = null;
         ViewModelProvider.Factory var11 = null;
         CreationExtras var12 = notesViewModel instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory)notesViewModel).getDefaultViewModelCreationExtras() : (CreationExtras)Empty.INSTANCE;
         ViewModel var17 = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(PlannerViewModel.class), notesViewModel, var59, var11, var12, $composer, 112 & var14 << 3 | 896 & var14 << 3 | 7168 & var14 << 3 | '\ue000' & var14 << 3, 0);
         $composer.endReplaceableGroup();
         final PlannerViewModel viewModel = (PlannerViewModel)var17;
         var15 = 0;
         int var16 = 0;
         $composer.startReplaceableGroup(1729797275);
         ComposerKt.sourceInformation($composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
         var292 = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer, 6);
         if (var292 == null) {
            int var95 = 0;
            String var96 = "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner";
            throw new IllegalStateException(var96.toString());
         }

         ViewModelStoreOwner syncViewModel = var292;
         String var62 = null;
         ViewModelProvider.Factory var65 = null;
         CreationExtras var13 = syncViewModel instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory)syncViewModel).getDefaultViewModelCreationExtras() : (CreationExtras)Empty.INSTANCE;
         ViewModel var18 = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(NotesViewModel.class), syncViewModel, var62, var65, var13, $composer, 112 & var15 << 3 | 896 & var15 << 3 | 7168 & var15 << 3 | '\ue000' & var15 << 3, 0);
         $composer.endReplaceableGroup();
         NotesViewModel notesViewModel = (NotesViewModel)var18;
         var16 = 0;
         int var88 = 0;
         $composer.startReplaceableGroup(1729797275);
         ComposerKt.sourceInformation($composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
         var292 = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer, 6);
         if (var292 == null) {
            int var104 = 0;
            String var105 = "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner";
            throw new IllegalStateException(var105.toString());
         }

         ViewModelStoreOwner var63 = var292;
         String var66 = null;
         ViewModelProvider.Factory var69 = null;
         CreationExtras var72 = var63 instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory)var63).getDefaultViewModelCreationExtras() : (CreationExtras)Empty.INSTANCE;
         ViewModel var21_51 = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(CalendarSyncViewModel.class), var63, var66, var69, var72, $composer, 112 & var16 << 3 | 896 & var16 << 3 | 7168 & var16 << 3 | '\ue000' & var16 << 3, 0);
         $composer.endReplaceableGroup();
         CalendarSyncViewModel syncViewModel = (CalendarSyncViewModel)var21_51;
         var88 = 0;
         int var97 = 0;
         $composer.startReplaceableGroup(1729797275);
         ComposerKt.sourceInformation($composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
         var292 = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer, 6);
         if (var292 == null) {
            int var118 = 0;
            String var21_51 = "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner";
            throw new IllegalStateException(var21_51.toString());
         }

         ViewModelStoreOwner var67 = var292;
         String var70 = null;
         ViewModelProvider.Factory var73 = null;
         CreationExtras var78 = var67 instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory)var67).getDefaultViewModelCreationExtras() : (CreationExtras)Empty.INSTANCE;
         ViewModel var20 = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(AuthViewModel.class), var67, var70, var73, var78, $composer, 112 & var88 << 3 | 896 & var88 << 3 | 7168 & var88 << 3 | '\ue000' & var88 << 3, 0);
         $composer.endReplaceableGroup();
         AuthViewModel authViewModel = (AuthViewModel)var20;
         AuthManager authManager = authViewModel.getAuthManager();
         ComposerKt.sourceInformationMarkerStart($composer, -1238753541, "CC(remember):MainActivity.kt#9igjgp");
         var16 = 0;
         var88 = 0;
         Object var98 = $composer.rememberedValue();
         int var106 = 0;
         Object var296;
         if (var98 == Composer.Companion.getEmpty()) {
            int var120 = 0;
            Object var121 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var121);
            var296 = var121;
         } else {
            var296 = var98;
         }

         final MutableState var74 = (MutableState)var296;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableState highlightedTaskId$delegate = var74;
         String var297 = MainDashboardScreen$lambda$47(var74);
         ComposerKt.sourceInformationMarkerStart($composer, -1238750840, "CC(remember):MainActivity.kt#9igjgp");
         var16 = 0;
         var88 = 0;
         var98 = $composer.rememberedValue();
         var106 = 0;
         Object var10001;
         if (var98 == Composer.Companion.getEmpty()) {
            String var45 = var297;
            int var122 = 0;
            Function2 var21_1 = new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        if (MainActivityKt.MainDashboardScreen$lambda$47(var74) == null) {
                           return Unit.INSTANCE;
                        }

                        Continuation var10001 = (Continuation)this;
                        this.label = 1;
                        if (DelayKt.delay(4000L, var10001) == var2) {
                           return var2;
                        }
                        break;
                     case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                     default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  MainActivityKt.MainDashboardScreen$lambda$48(var74, (String)null);
                  return Unit.INSTANCE;
               }

               public final Continuation create(Object value, Continuation $completion) {
                  return (Continuation)(new <anonymous constructor>($completion));
               }

               public final Object invoke(CoroutineScope p1, Continuation p2) {
                  return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
               }
            };
            var297 = var45;
            $composer.updateRememberedValue(var21_1);
            var10001 = var21_1;
         } else {
            var10001 = var98;
         }

         Function2 showAddTaskDialog$delegate = (Function2)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         EffectsKt.LaunchedEffect(var297, showAddTaskDialog$delegate, $composer, 0);
         ComposerKt.sourceInformationMarkerStart($composer, -1238746125, "CC(remember):MainActivity.kt#9igjgp");
         var88 = 0;
         int var100 = 0;
         Object var21_51 = $composer.rememberedValue();
         int var123 = 0;
         Object var298;
         if (var21_51 == Composer.Companion.getEmpty()) {
            int var21 = 0;
            Object var127 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var127);
            var298 = var127;
         } else {
            var298 = var21_51;
         }

         MutableState prefilledHourForNewTask$delegate = (MutableState)var298;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableState showAddTaskDialog$delegate = prefilledHourForNewTask$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, -1238743880, "CC(remember):MainActivity.kt#9igjgp");
         var100 = 0;
         int var109 = 0;
         Object var124 = $composer.rememberedValue();
         int var128 = 0;
         if (var124 == Composer.Companion.getEmpty()) {
            int var22 = 0;
            Object var134 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var134);
            var298 = var134;
         } else {
            var298 = var124;
         }

         MutableState editingTask$delegate = (MutableState)var298;
         ComposerKt.sourceInformationMarkerEnd($composer);
         prefilledHourForNewTask$delegate = editingTask$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, -1238741857, "CC(remember):MainActivity.kt#9igjgp");
         var109 = 0;
         int var125 = 0;
         Object var129 = $composer.rememberedValue();
         int var135 = 0;
         if (var129 == Composer.Companion.getEmpty()) {
            int var23 = 0;
            Object var143 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var143);
            var298 = var143;
         } else {
            var298 = var129;
         }

         MutableState editingGoogleEvent$delegate = (MutableState)var298;
         ComposerKt.sourceInformationMarkerEnd($composer);
         editingTask$delegate = editingGoogleEvent$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, -1238739390, "CC(remember):MainActivity.kt#9igjgp");
         var125 = 0;
         int var130 = 0;
         Object var136 = $composer.rememberedValue();
         int var144 = 0;
         if (var136 == Composer.Companion.getEmpty()) {
            int var24 = 0;
            Object var156 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var156);
            var298 = var156;
         } else {
            var298 = var136;
         }

         MutableState selectedTask$delegate = (MutableState)var298;
         ComposerKt.sourceInformationMarkerEnd($composer);
         editingGoogleEvent$delegate = selectedTask$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, -1238737025, "CC(remember):MainActivity.kt#9igjgp");
         var130 = 0;
         int var137 = 0;
         Object var145 = $composer.rememberedValue();
         int var157 = 0;
         if (var145 == Composer.Companion.getEmpty()) {
            int var25 = 0;
            Object var168 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var168);
            var298 = var168;
         } else {
            var298 = var145;
         }

         MutableState var21_51 = (MutableState)var298;
         ComposerKt.sourceInformationMarkerEnd($composer);
         selectedTask$delegate = var21_51;
         long var21_51 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getBackground-0d7_KjU();
         ScaffoldKt.Scaffold-TvnljyQ((Modifier)null, (Function2)null, (Function2)ComposableLambdaKt.rememberComposableLambda(1621868438, true, MainActivityKt::MainDashboardScreen$lambda$69, $composer, 54), (Function2)null, (Function2)ComposableLambdaKt.rememberComposableLambda(583283864, true, MainActivityKt::MainDashboardScreen$lambda$72, $composer, 54), 0, var21_51, 0L, (WindowInsets)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-2016187040, true, MainActivityKt::MainDashboardScreen$lambda$109, $composer, 54), $composer, 805331328, 427);
         if (MainDashboardScreen$lambda$51(showAddTaskDialog$delegate)) {
            $composer.startReplaceGroup(258232828);
            ComposerKt.sourceInformation($composer, "442@17904L29,444@17985L909,437@17715L1189");
            var298 = null;
            boolean var324 = false;
            Object var10002 = null;
            Integer var10003 = MainDashboardScreen$lambda$54(prefilledHourForNewTask$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -1238590706, "CC(remember):MainActivity.kt#9igjgp");
            var130 = 0;
            var137 = 0;
            var145 = $composer.rememberedValue();
            var157 = 0;
            Object var10004;
            if (var145 == Composer.Companion.getEmpty()) {
               Integer var48 = var10003;
               Object var47 = null;
               boolean var21_1 = false;
               Object var286 = null;
               int var169 = 0;
               Function0 var26_1 = MainActivityKt::MainDashboardScreen$lambda$111$lambda$110;
               var298 = var286;
               var324 = var21_1;
               var10002 = var47;
               var10003 = var48;
               $composer.updateRememberedValue(var26_1);
               var10004 = var26_1;
            } else {
               var10004 = var145;
            }

            Function0 var21_51 = (Function0)var10004;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var338 = var21_51;
            Object var10005 = null;
            ComposerKt.sourceInformationMarkerStart($composer, -1238587234, "CC(remember):MainActivity.kt#9igjgp");
            var130 = $composer.changedInstance(viewModel);
            var137 = 0;
            var145 = $composer.rememberedValue();
            var157 = 0;
            Object var10006;
            if (!var130 && var145 != Composer.Companion.getEmpty()) {
               var10006 = var145;
            } else {
               Object var50 = null;
               Integer var291 = var10003;
               Object var290 = var10002;
               boolean var21_1 = var324;
               Object var287 = var298;
               int var170 = 0;
               Function12 var26_4 = MainActivityKt::MainDashboardScreen$lambda$114$lambda$113;
               var298 = var287;
               var324 = var21_1;
               var10002 = var290;
               var10003 = var291;
               var338 = var21_51;
               var10005 = var50;
               $composer.updateRememberedValue(var26_4);
               var10006 = var26_4;
            }

            Function12 var21_51 = (Function12)var10006;
            ComposerKt.sourceInformationMarkerEnd($composer);
            AddTaskDialog((TaskEntity)var298, var324, (List)var10002, var10003, var338, (Function0)var10005, var21_51, $composer, 221622);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(240631121);
            $composer.endReplaceGroup();
         }

         final TaskEntity var21_51 = MainDashboardScreen$lambda$57(editingTask$delegate);
         if (var21_51 == null) {
            $composer.startReplaceGroup(259468580);
            $composer.endReplaceGroup();
            var298 = null;
         } else {
            $composer.startReplaceGroup(259468581);
            ComposerKt.sourceInformation($composer, "*467@18963L24,468@19019L55,469@19107L92,469@19083L116,478@19390L22,479@19437L121,483@19581L1232,473@19209L1614");
            var137 = 0;
            var157 = 0;
            int var171 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, -954367824, "CC(remember):Effects.kt#9igjgp");
            boolean var28 = (boolean)0;
            int var29 = 0;
            Object var30 = $composer.rememberedValue();
            int var31 = 0;
            if (var30 == Composer.Companion.getEmpty()) {
               int var32 = 0;
               int var35 = 0;
               EmptyCoroutineContext var34_20 = EmptyCoroutineContext.INSTANCE;
               CoroutineScope var52 = EffectsKt.createCompositionCoroutineScope((CoroutineContext)var34_20, $composer);
               Object var259 = new CompositionScopedCoroutineScopeCanceller(var52);
               $composer.updateRememberedValue(var259);
               var298 = var259;
            } else {
               var298 = var30;
            }

            CompositionScopedCoroutineScopeCanceller var38_1 = (CompositionScopedCoroutineScopeCanceller)var298;
            ComposerKt.sourceInformationMarkerEnd($composer);
            CoroutineScope var38_1 = var38_1.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1954732161, "CC(remember):MainActivity.kt#9igjgp");
            var171 = 0;
            int var26 = 0;
            Object var27 = $composer.rememberedValue();
            var28 = (boolean)0;
            if (var27 == Composer.Companion.getEmpty()) {
               var29 = 0;
               Object var220 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
               $composer.updateRememberedValue(var220);
               var298 = var220;
            } else {
               var298 = var27;
            }

            final MutableState var148 = (MutableState)var298;
            ComposerKt.sourceInformationMarkerEnd($composer);
            MutableState var40 = var148;
            Integer var306 = var21_51.getId();
            ComposerKt.sourceInformationMarkerStart($composer, 1954735014, "CC(remember):MainActivity.kt#9igjgp");
            var171 = $composer.changedInstance(viewModel) | $composer.changed(var21_51);
            var26 = 0;
            var27 = $composer.rememberedValue();
            var28 = (boolean)0;
            if (!var171 && var27 != Composer.Companion.getEmpty()) {
               var10001 = var27;
            } else {
               Integer var34 = var306;
               var29 = 0;
               Function2 var325 = new Function2((Continuation)null) {
                  Object L$0;
                  int label;

                  public final Object invokeSuspend(Object $result) {
                     Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     MutableState var2;
                     Object var10000;
                     switch (this.label) {
                        case 0:
                           ResultKt.throwOnFailure($result);
                           var2 = var148;
                           PlannerViewModel var4 = viewModel;
                           String var10001 = "local_" + var21_51.getId();
                           Continuation var10002 = (Continuation)this;
                           this.L$0 = var2;
                           this.label = 1;
                           var10000 = var4.getSubTasksForParent(var10001, var10002);
                           if (var10000 == var3) {
                              return var3;
                           }
                           break;
                        case 1:
                           var2 = (MutableState)this.L$0;
                           ResultKt.throwOnFailure($result);
                           var10000 = $result;
                           break;
                        default:
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     MainActivityKt.MainDashboardScreen$lambda$125$lambda$117(var2, (List)var10000);
                     return Unit.INSTANCE;
                  }

                  public final Continuation create(Object value, Continuation $completion) {
                     return (Continuation)(new <anonymous constructor>($completion));
                  }

                  public final Object invoke(CoroutineScope p1, Continuation p2) {
                     return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                  }
               };
               var306 = var34;
               var30 = var325;
               $composer.updateRememberedValue(var30);
               var10001 = var30;
            }

            Function2 var149 = (Function2)var10001;
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(var306, var149, $composer, 0);
            TaskEntity var307 = var21_51;
            boolean var327 = false;
            List var332 = MainDashboardScreen$lambda$125$lambda$116(var40);
            Object var335 = null;
            ComposerKt.sourceInformationMarkerStart($composer, 1954744000, "CC(remember):MainActivity.kt#9igjgp");
            var171 = 0;
            var26 = 0;
            var27 = $composer.rememberedValue();
            var28 = (boolean)0;
            Object var339;
            if (var27 == Composer.Companion.getEmpty()) {
               Object var41 = null;
               List var34_20 = var332;
               boolean var34_17 = false;
               var29 = 0;
               Function0 var30_7 = MainActivityKt::MainDashboardScreen$lambda$125$lambda$120$lambda$119;
               var307 = var21_51;
               var327 = var34_17;
               var332 = var34_20;
               var335 = var41;
               $composer.updateRememberedValue(var30_7);
               var339 = var30_7;
            } else {
               var339 = var27;
            }

            Function0 var150 = (Function0)var339;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var340 = var150;
            ComposerKt.sourceInformationMarkerStart($composer, 1954745603, "CC(remember):MainActivity.kt#9igjgp");
            var171 = $composer.changedInstance(syncViewModel) | $composer.changed(var21_51) | $composer.changedInstance(authManager) | $composer.changedInstance(viewModel);
            var26 = 0;
            var27 = $composer.rememberedValue();
            var28 = (boolean)0;
            Object var346;
            if (!var171 && var27 != Composer.Companion.getEmpty()) {
               var346 = var27;
            } else {
               Object var276 = var335;
               List var34_20 = var332;
               boolean var34_17 = var327;
               TaskEntity var254 = var307;
               var29 = 0;
               Function0 var30_10 = MainActivityKt::MainDashboardScreen$lambda$125$lambda$122$lambda$121;
               var307 = var254;
               var327 = var34_17;
               var332 = var34_20;
               var335 = var276;
               var340 = var150;
               $composer.updateRememberedValue(var30_10);
               var346 = var30_10;
            }

            var150 = (Function0)var346;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var347 = var150;
            ComposerKt.sourceInformationMarkerStart($composer, 1954751322, "CC(remember):MainActivity.kt#9igjgp");
            var171 = $composer.changedInstance(var38_1) | $composer.changed(var21_51) | $composer.changedInstance(viewModel) | $composer.changedInstance(syncViewModel) | $composer.changedInstance(authManager);
            var26 = 0;
            var27 = $composer.rememberedValue();
            var28 = (boolean)0;
            Object var352;
            if (!var171 && var27 != Composer.Companion.getEmpty()) {
               var352 = var27;
            } else {
               Function0 var30_7 = var340;
               Object var277 = var335;
               List var34_20 = var332;
               boolean var34_17 = var327;
               TaskEntity var255 = var307;
               var29 = 0;
               Function12 var30_13 = MainActivityKt::MainDashboardScreen$lambda$125$lambda$124$lambda$123;
               var307 = var255;
               var327 = var34_17;
               var332 = var34_20;
               var335 = var277;
               var340 = var30_7;
               var347 = var150;
               $composer.updateRememberedValue(var30_13);
               var352 = var30_13;
            }

            Function12 var152 = (Function12)var352;
            ComposerKt.sourceInformationMarkerEnd($composer);
            AddTaskDialog(var307, var327, var332, (Integer)var335, var340, var347, var152, $composer, 27696);
            Unit var308 = Unit.INSTANCE;
            $composer.endReplaceGroup();
            var308 = Unit.INSTANCE;
         }

         final CalendarEvent var21_51 = MainDashboardScreen$lambda$60(editingGoogleEvent$delegate);
         if (var21_51 == null) {
            $composer.startReplaceGroup(261373995);
            $composer.endReplaceGroup();
            var298 = null;
         } else {
            $composer.startReplaceGroup(261373996);
            ComposerKt.sourceInformation($composer, "*510@20890L24,511@20946L55,512@21035L94,512@21010L119,515@21160L427,533@21789L29,534@21843L125,538@21991L581,528@21597L985");
            var137 = 0;
            var157 = 0;
            int var177 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, -954367824, "CC(remember):Effects.kt#9igjgp");
            boolean var211 = (boolean)0;
            int var225 = 0;
            Object var235 = $composer.rememberedValue();
            int var242 = 0;
            if (var235 == Composer.Companion.getEmpty()) {
               int var245 = 0;
               int var260 = 0;
               EmptyCoroutineContext var34_20 = EmptyCoroutineContext.INSTANCE;
               CoroutineScope var53 = EffectsKt.createCompositionCoroutineScope((CoroutineContext)var34_20, $composer);
               Object var261 = new CompositionScopedCoroutineScopeCanceller(var53);
               $composer.updateRememberedValue(var261);
               var298 = var261;
            } else {
               var298 = var235;
            }

            CompositionScopedCoroutineScopeCanceller var38_1 = (CompositionScopedCoroutineScopeCanceller)var298;
            ComposerKt.sourceInformationMarkerEnd($composer);
            CoroutineScope var38_1 = var38_1.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1061960138, "CC(remember):MainActivity.kt#9igjgp");
            var177 = 0;
            int var186 = 0;
            Object var198 = $composer.rememberedValue();
            var211 = (boolean)0;
            if (var198 == Composer.Companion.getEmpty()) {
               var225 = 0;
               Object var227 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
               $composer.updateRememberedValue(var227);
               var298 = var227;
            } else {
               var298 = var198;
            }

            final MutableState var153 = (MutableState)var298;
            ComposerKt.sourceInformationMarkerEnd($composer);
            MutableState var275 = var153;
            String var313 = var21_51.getId();
            ComposerKt.sourceInformationMarkerStart($composer, -1061957251, "CC(remember):MainActivity.kt#9igjgp");
            var177 = $composer.changedInstance(viewModel) | $composer.changed(var21_51);
            var186 = 0;
            var198 = $composer.rememberedValue();
            var211 = (boolean)0;
            if (!var177 && var198 != Composer.Companion.getEmpty()) {
               var10001 = var198;
            } else {
               String var256 = var313;
               var225 = 0;
               Function2 var328 = new Function2((Continuation)null) {
                  Object L$0;
                  int label;

                  public final Object invokeSuspend(Object $result) {
                     Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     MutableState var2;
                     Object var10000;
                     switch (this.label) {
                        case 0:
                           ResultKt.throwOnFailure($result);
                           var2 = var153;
                           PlannerViewModel var4 = viewModel;
                           String var10001 = "google_" + var21_51.getId();
                           Continuation var10002 = (Continuation)this;
                           this.L$0 = var2;
                           this.label = 1;
                           var10000 = var4.getSubTasksForParent(var10001, var10002);
                           if (var10000 == var3) {
                              return var3;
                           }
                           break;
                        case 1:
                           var2 = (MutableState)this.L$0;
                           ResultKt.throwOnFailure($result);
                           var10000 = $result;
                           break;
                        default:
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     MainActivityKt.MainDashboardScreen$lambda$137$lambda$128(var2, (List)var10000);
                     return Unit.INSTANCE;
                  }

                  public final Continuation create(Object value, Continuation $completion) {
                     return (Continuation)(new <anonymous constructor>($completion));
                  }

                  public final Object invoke(CoroutineScope p1, Continuation p2) {
                     return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                  }
               };
               var313 = var256;
               var235 = var328;
               $composer.updateRememberedValue(var235);
               var10001 = var235;
            }

            Function2 var154 = (Function2)var10001;
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(var313, var154, $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, -1061952918, "CC(remember):MainActivity.kt#9igjgp");
            var186 = $composer.changed(var21_51);
            int var200 = 0;
            Object var214 = $composer.rememberedValue();
            var225 = 0;
            Object var315;
            if (!var186 && var214 != Composer.Companion.getEmpty()) {
               var315 = (TaskEntity)var214;
            } else {
               int var237 = 0;
               var315 = new TaskEntity;
               String var341 = var21_51.getSummary();
               if (var341 == null) {
                  var341 = "";
               }

               String var348 = var21_51.getDescription();
               if (var348 == null) {
                  var348 = "";
               }

               var315.<init>(-1, (String)null, var341, var348, var21_51.getStartTimeInMillis(), var21_51.getStartTimeInMillis(), var21_51.getEndTimeInMillis(), true, false, false, (Long)null, (Integer)null, var21_51.getId(), false, 0L, (Long)null, 61186, (DefaultConstructorMarker)null);
               Object var243 = var315;
               $composer.updateRememberedValue(var243);
               var315 = (TaskEntity)var243;
            }

            TaskEntity var162 = var315;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TaskEntity var155 = var162;
            var315 = var162;
            boolean var330 = false;
            List var333 = MainDashboardScreen$lambda$137$lambda$127(var275);
            Object var336 = null;
            ComposerKt.sourceInformationMarkerStart($composer, -1061933188, "CC(remember):MainActivity.kt#9igjgp");
            var186 = 0;
            var200 = 0;
            var214 = $composer.rememberedValue();
            var225 = 0;
            Object var342;
            if (var214 == Composer.Companion.getEmpty()) {
               Object var278 = null;
               List var34_20 = var333;
               boolean var34_17 = false;
               int var238 = 0;
               Function0 var30_7 = MainActivityKt::MainDashboardScreen$lambda$137$lambda$132$lambda$131;
               var315 = var162;
               var330 = var34_17;
               var333 = var34_20;
               var336 = var278;
               $composer.updateRememberedValue(var30_7);
               var342 = var30_7;
            } else {
               var342 = var214;
            }

            Function0 var163 = (Function0)var342;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var343 = var163;
            ComposerKt.sourceInformationMarkerStart($composer, -1061931364, "CC(remember):MainActivity.kt#9igjgp");
            var186 = $composer.changedInstance(syncViewModel) | $composer.changed(var21_51) | $composer.changedInstance(authManager);
            var200 = 0;
            var214 = $composer.rememberedValue();
            var225 = 0;
            Object var349;
            if (!var186 && var214 != Composer.Companion.getEmpty()) {
               var349 = var214;
            } else {
               Object var279 = var336;
               List var34_20 = var333;
               boolean var34_17 = var330;
               TaskEntity var257 = var315;
               int var239 = 0;
               Function0 var30_10 = MainActivityKt::MainDashboardScreen$lambda$137$lambda$134$lambda$133;
               var315 = var257;
               var330 = var34_17;
               var333 = var34_20;
               var336 = var279;
               var343 = var163;
               $composer.updateRememberedValue(var30_10);
               var349 = var30_10;
            }

            var163 = (Function0)var349;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var350 = var163;
            ComposerKt.sourceInformationMarkerStart($composer, -1061926172, "CC(remember):MainActivity.kt#9igjgp");
            var186 = $composer.changedInstance(var38_1) | $composer.changed(var155) | $composer.changedInstance(syncViewModel) | $composer.changedInstance(authManager) | $composer.changedInstance(viewModel) | $composer.changed(var21_51);
            var200 = 0;
            var214 = $composer.rememberedValue();
            var225 = 0;
            Object var353;
            if (!var186 && var214 != Composer.Companion.getEmpty()) {
               var353 = var214;
            } else {
               Function0 var30_7 = var343;
               Object var280 = var336;
               List var34_20 = var333;
               boolean var34_17 = var330;
               TaskEntity var258 = var315;
               int var240 = 0;
               Function12 var30_13 = MainActivityKt::MainDashboardScreen$lambda$137$lambda$136$lambda$135;
               var315 = var258;
               var330 = var34_17;
               var333 = var34_20;
               var336 = var280;
               var343 = var30_7;
               var350 = var163;
               $composer.updateRememberedValue(var30_13);
               var353 = var30_13;
            }

            Function12 var165 = (Function12)var353;
            ComposerKt.sourceInformationMarkerEnd($composer);
            AddTaskDialog(var315, var330, var333, (Integer)var336, var343, var350, var165, $composer, 27696);
            Unit var317 = Unit.INSTANCE;
            $composer.endReplaceGroup();
            var317 = Unit.INSTANCE;
         }

         TaskEntity var21_51 = MainDashboardScreen$lambda$63(selectedTask$delegate);
         if (var21_51 == null) {
            $composer.startReplaceGroup(263071617);
            $composer.endReplaceGroup();
            var298 = null;
         } else {
            $composer.startReplaceGroup(263071618);
            ComposerKt.sourceInformation($composer, "*558@22821L23,559@22869L122,553@22630L371");
            var137 = 0;
            TaskEntity var320 = var21_51;
            AuthManager var331 = authManager;
            CalendarSyncViewModel var334 = syncViewModel;
            PlannerViewModel var337 = viewModel;
            ComposerKt.sourceInformationMarkerStart($composer, 1524960505, "CC(remember):MainActivity.kt#9igjgp");
            var157 = 0;
            int var180 = 0;
            Object var192 = $composer.rememberedValue();
            int var204 = 0;
            Object var344;
            if (var192 == Composer.Companion.getEmpty()) {
               int var246 = 0;
               Function0 var34_17 = MainActivityKt::MainDashboardScreen$lambda$142$lambda$139$lambda$138;
               var320 = var21_51;
               var331 = authManager;
               var334 = syncViewModel;
               var337 = viewModel;
               $composer.updateRememberedValue(var34_17);
               var344 = var34_17;
            } else {
               var344 = var192;
            }

            Function0 var262 = (Function0)var344;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Function0 var345 = var262;
            ComposerKt.sourceInformationMarkerStart($composer, 1524962140, "CC(remember):MainActivity.kt#9igjgp");
            var157 = $composer.changedInstance(syncViewModel) | $composer.changed(var21_51) | $composer.changedInstance(authManager) | $composer.changedInstance(viewModel);
            var180 = 0;
            var192 = $composer.rememberedValue();
            var204 = 0;
            Object var351;
            if (!var157 && var192 != Composer.Companion.getEmpty()) {
               var351 = var192;
            } else {
               PlannerViewModel var218 = var337;
               CalendarSyncViewModel var233 = var334;
               AuthManager var241 = var331;
               TaskEntity var244 = var320;
               int var247 = 0;
               Function1 var34_20 = MainActivityKt::MainDashboardScreen$lambda$142$lambda$141$lambda$140;
               var320 = var244;
               var331 = var241;
               var334 = var233;
               var337 = var218;
               var345 = var262;
               $composer.updateRememberedValue(var34_20);
               var351 = var34_20;
            }

            Function1 var263 = (Function1)var351;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TaskDetailDialog(var320, var331, var334, var337, var345, var263, $composer, 24576);
            Unit var321 = Unit.INSTANCE;
            $composer.endReplaceGroup();
            var321 = Unit.INSTANCE;
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var55 = $composer.endRestartGroup();
      if (var55 != null) {
         var55.updateScope(MainActivityKt::MainDashboardScreen$lambda$143);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void PlannerScreen(@NotNull PlannerViewModel viewModel, @NotNull CalendarSyncViewModel syncViewModel, @NotNull Function1 onTaskClick, @NotNull Function1 onTaskEdit, @NotNull Function1 onTaskCombine, @NotNull Function1 onTaskDelete, @NotNull Function1 onEmptyHourClick, @NotNull Function1 onGoogleEventEdit, @NotNull Function1 onGoogleEventDelete, @Nullable String highlightedTaskId, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(viewModel, "viewModel");
      Intrinsics.checkNotNullParameter(syncViewModel, "syncViewModel");
      Intrinsics.checkNotNullParameter(onTaskClick, "onTaskClick");
      Intrinsics.checkNotNullParameter(onTaskEdit, "onTaskEdit");
      Intrinsics.checkNotNullParameter(onTaskCombine, "onTaskCombine");
      Intrinsics.checkNotNullParameter(onTaskDelete, "onTaskDelete");
      Intrinsics.checkNotNullParameter(onEmptyHourClick, "onEmptyHourClick");
      Intrinsics.checkNotNullParameter(onGoogleEventEdit, "onGoogleEventEdit");
      Intrinsics.checkNotNullParameter(onGoogleEventDelete, "onGoogleEventDelete");
      $composer = $composer.startRestartGroup(1179253580);
      ComposerKt.sourceInformation($composer, "C(PlannerScreen)P(9,8,4,7,5,6,1,3,2)580@23492L29,581@23571L29,582@23646L29,583@23723L29,585@23778L513,600@24297L1314:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changedInstance(viewModel) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(syncViewModel) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(onTaskClick) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(onTaskEdit) ? 2048 : 1024;
      }

      if (($changed & 24576) == 0) {
         $dirty |= $composer.changedInstance(onTaskCombine) ? 16384 : 8192;
      }

      if (($changed & 196608) == 0) {
         $dirty |= $composer.changedInstance(onTaskDelete) ? 131072 : 65536;
      }

      if (($changed & 1572864) == 0) {
         $dirty |= $composer.changedInstance(onEmptyHourClick) ? 1048576 : 524288;
      }

      if (($changed & 12582912) == 0) {
         $dirty |= $composer.changedInstance(onGoogleEventEdit) ? 8388608 : 4194304;
      }

      if (($changed & 100663296) == 0) {
         $dirty |= $composer.changedInstance(onGoogleEventDelete) ? 67108864 : 33554432;
      }

      if (($changed & 805306368) == 0) {
         $dirty |= $composer.changed(highlightedTaskId) ? 536870912 : 268435456;
      }

      if (($dirty & 306783379) == 306783378 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1179253580, $dirty, -1, "com.example.PlannerScreen (MainActivity.kt:579)");
         }

         State selectedDate$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getSelectedDate(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State scheduleTasks$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getScheduleTasks(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State googleEvents$delegate = FlowExtKt.collectAsStateWithLifecycle(syncViewModel.getEvents(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State todaysNotes$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getNotesForToday(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         List var18 = PlannerScreen$lambda$145(scheduleTasks$delegate);
         List var19 = PlannerScreen$lambda$146(googleEvents$delegate);
         List var20 = PlannerScreen$lambda$147(todaysNotes$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, -608650707, "CC(remember):MainActivity.kt#9igjgp");
         boolean var23 = $composer.changed(var18) | $composer.changed(var19) | $composer.changed(var20);
         int var24 = 0;
         Object var25 = $composer.rememberedValue();
         int var26 = 0;
         Object var132;
         if (!var23 && var25 != Composer.Companion.getEmpty()) {
            var132 = var25;
         } else {
            int var27 = 0;
            List var30_6 = (List)(new ArrayList());
            Iterable var29 = (Iterable)PlannerScreen$lambda$145(scheduleTasks$delegate);
            int var35_1 = 0;

            for(Object var32 : var29) {
               TaskEntity var33 = (TaskEntity)var32;
               int var34 = 0;
               var30_6.add(new TimelineItem.AppTaskItem(var33));
            }

            Iterable var35_1 = (Iterable)PlannerScreen$lambda$145(scheduleTasks$delegate);
            int var107 = 0;
            Collection var113 = (Collection)(new ArrayList());
            int var116 = 0;
            int var36 = 0;

            for(Object var39_1 : var35_1) {
               int var40 = 0;
               TaskEntity var41 = (TaskEntity)var39_1;
               int var42 = 0;
               String var10000 = var41.getExternalCalendarEventId();
               if (var10000 != null) {
                  Object var43 = var10000;
                  int var44 = 0;
                  var113.add(var43);
               }
            }

            Set var102 = CollectionsKt.toSet((Iterable)((List)var113));
            var35_1 = (Iterable)PlannerScreen$lambda$146(googleEvents$delegate);
            var107 = 0;

            for(Object var114 : var35_1) {
               CalendarEvent var117 = (CalendarEvent)var114;
               int var35 = 0;
               if (!var102.contains(var117.getId())) {
                  var30_6.add(new TimelineItem.GoogleEventItem(var117));
               }
            }

            var107 = 0;
            if (var30_6.size() > 1) {
               CollectionsKt.sortWith(var30_6, new MainActivityKt$PlannerScreen$lambda$152$$inlined$sortBy$1());
            }

            $composer.updateRememberedValue(var30_6);
            var132 = var30_6;
         }

         List timelineItems = (List)var132;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Modifier var93 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var22 = 6;
         var23 = (boolean)0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var94 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var95 = Alignment.Companion.getStart();
         MeasurePolicy var97 = ColumnKt.columnMeasurePolicy(var94, var95, $composer, 14 & var22 >> 3 | 112 & var22 >> 3);
         int var98 = 112 & var22 << 3;
         var26 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var100 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var30_6 = $composer.getCurrentCompositionLocalMap();
         Modifier var103 = ComposedModifierKt.materializeModifier($composer, var93);
         Function0 var35_1 = ComposeUiNode.Companion.getConstructor();
         int var110 = 6 | 896 & var98 << 6;
         int var112 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var35_1);
         } else {
            $composer.useNode();
         }

         Composer var115 = Updater.constructor-impl($composer);
         int var118 = 0;
         Updater.set-impl(var115, var97, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var115, var30_6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var119 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var120 = 0;
         int var121 = 0;
         if (var115.getInserting() || !Intrinsics.areEqual(var115.rememberedValue(), var100)) {
            var115.updateRememberedValue(var100);
            var115.apply(var100, var119);
         }

         Updater.set-impl(var115, var103, ComposeUiNode.Companion.getSetModifier());
         int var39 = 14 & var110 >> 6;
         int var122 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var123 = 6 | 112 & var22 >> 6;
         ColumnScope var133 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var45 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1622210727, "C601@24400L28,601@24349L80,603@24439L1166:MainActivity.kt#to5c3");
         long var134 = PlannerScreen$lambda$144(selectedDate$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 363313022, "CC(remember):MainActivity.kt#9igjgp");
         boolean var47 = $composer.changedInstance(viewModel);
         int var48 = 0;
         Object var49 = $composer.rememberedValue();
         int var50 = 0;
         Object var10001;
         if (!var47 && var49 != Composer.Companion.getEmpty()) {
            var10001 = var49;
         } else {
            long var51 = var134;
            int var53 = 0;
            Function1 var55_1 = MainActivityKt::PlannerScreen$lambda$158$lambda$154$lambda$153;
            var134 = var51;
            $composer.updateRememberedValue(var55_1);
            var10001 = var55_1;
         }

         Function1 var56 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         TopBar(var134, var56, $composer, 0);
         Modifier var135 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var129 = 24;
         int var46 = 0;
         Modifier var130 = PaddingKt.padding-VpY3zN4$default(var135, Dp.constructor-impl((float)var129), 0.0F, 2, (Object)null);
         byte var126 = 6;
         var50 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var124 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var125 = Alignment.Companion.getStart();
         MeasurePolicy var128 = ColumnKt.columnMeasurePolicy(var124, var125, $composer, 14 & var126 >> 3 | 112 & var126 >> 3);
         int var55 = 112 & var126 << 3;
         int var57 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var58 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var59 = $composer.getCurrentCompositionLocalMap();
         Modifier var60 = ComposedModifierKt.materializeModifier($composer, var130);
         Function0 var61 = ComposeUiNode.Companion.getConstructor();
         int var62 = 6 | 896 & var55 << 6;
         int var63 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var61);
         } else {
            $composer.useNode();
         }

         Composer var64 = Updater.constructor-impl($composer);
         int var65 = 0;
         Updater.set-impl(var64, var128, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var64, var59, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var66 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var67 = 0;
         int var69 = 0;
         if (var64.getInserting() || !Intrinsics.areEqual(var64.rememberedValue(), var58)) {
            var64.updateRememberedValue(var58);
            var64.apply(var58, var66);
         }

         Updater.set-impl(var64, var60, ComposeUiNode.Companion.getSetModifier());
         int var70 = 14 & var62 >> 6;
         int var72 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var73 = 6 | 112 & var126 >> 6;
         ColumnScope var136 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var76 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1653317613, "C608@24579L217,614@24809L41,621@25130L288,615@24863L732:MainActivity.kt#to5c3");
         UpcomingPlansSection(PlannerScreen$lambda$145(scheduleTasks$delegate), PlannerScreen$lambda$146(googleEvents$delegate), onTaskClick, onGoogleEventEdit, $composer, 896 & $dirty | 7168 & $dirty >> 12);
         Modifier var137 = (Modifier)Modifier.Companion;
         int var77 = 24;
         int var78 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var137, Dp.constructor-impl((float)var77)), $composer, 6);
         long var138 = PlannerScreen$lambda$144(selectedDate$delegate);
         List var140 = timelineItems;
         Function1 var10002 = onTaskClick;
         Function1 var10003 = onTaskEdit;
         Function1 var10004 = onTaskCombine;
         ComposerKt.sourceInformationMarkerStart($composer, -1854431240, "CC(remember):MainActivity.kt#9igjgp");
         boolean var79 = ($dirty & 458752) == 131072 | ($dirty & 234881024) == 67108864;
         int var80 = 0;
         Object var81 = $composer.rememberedValue();
         int var82 = 0;
         Object var10005;
         if (!var79 && var81 != Composer.Companion.getEmpty()) {
            var10005 = var81;
         } else {
            long var87 = var138;
            int var89 = 0;
            Function1 var91_1 = MainActivityKt::PlannerScreen$lambda$158$lambda$157$lambda$156$lambda$155;
            var138 = var87;
            var140 = timelineItems;
            var10002 = onTaskClick;
            var10003 = onTaskEdit;
            var10004 = onTaskCombine;
            $composer.updateRememberedValue(var91_1);
            var10005 = var91_1;
         }

         Function1 var131 = (Function1)var10005;
         ComposerKt.sourceInformationMarkerEnd($composer);
         TimelineSection(var138, var140, var10002, var10003, var10004, var131, onEmptyHourClick, onGoogleEventEdit, highlightedTaskId, $composer, 896 & $dirty | 7168 & $dirty | '\ue000' & $dirty | 3670016 & $dirty | 29360128 & $dirty | 234881024 & $dirty >> 3);
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

      ScopeUpdateScope var139 = $composer.endRestartGroup();
      if (var139 != null) {
         var139.updateScope(MainActivityKt::PlannerScreen$lambda$159);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void TopBar(long selectedDate, @NotNull Function1 onDateChange, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(onDateChange, "onDateChange");
      $composer = $composer.startRestartGroup(2038514392);
      ComposerKt.sourceInformation($composer, "C(TopBar)P(1)638@25721L7,643@25954L2176:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(selectedDate) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(onDateChange) ? 32 : 16;
      }

      if (($dirty & 19) == 18 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2038514392, $dirty, -1, "com.example.TopBar (MainActivity.kt:637)");
         }

         CompositionLocal var7 = (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext();
         int var9 = 0;
         int var10 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
         Object var11 = $composer.consume(var7);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Context context = (Context)var11;
         Calendar var9_2 = Calendar.getInstance();
         var10 = 0;
         var9_2.setTimeInMillis(selectedDate);
         Calendar calendar = var9_2;
         SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
         SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
         Modifier var10000 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var10 = 24;
         int var104 = 0;
         float var10001 = Dp.constructor-impl((float)var10);
         var10 = 16;
         var104 = 0;
         var10000 = PaddingKt.padding-VpY3zN4(var10000, var10001, Dp.constructor-impl((float)var10));
         var10 = 16;
         var104 = 0;
         Modifier var103 = PaddingKt.padding-qDBjuR0$default(var10000, 0.0F, Dp.constructor-impl((float)var10), 0.0F, 0.0F, 13, (Object)null);
         Arrangement.Horizontal var107 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
         Alignment.Vertical var12 = Alignment.Companion.getCenterVertically();
         short var14 = 438;
         int var15 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         MeasurePolicy var16 = RowKt.rowMeasurePolicy(var107, var12, $composer, 14 & var14 >> 3 | 112 & var14 >> 3);
         int var17 = 112 & var14 << 3;
         int var18 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var19 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var20 = $composer.getCurrentCompositionLocalMap();
         Modifier var21 = ComposedModifierKt.materializeModifier($composer, var103);
         Function0 var22 = ComposeUiNode.Companion.getConstructor();
         int var23 = 6 | 896 & var17 << 6;
         int var24 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var22);
         } else {
            $composer.useNode();
         }

         Composer var25 = Updater.constructor-impl($composer);
         int var26 = 0;
         Updater.set-impl(var25, var16, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var25, var20, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var27 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var28 = 0;
         int var30 = 0;
         if (var25.getInserting() || !Intrinsics.areEqual(var25.rememberedValue(), var19)) {
            var25.updateRememberedValue(var19);
            var25.apply(var19, var27);
         }

         Updater.set-impl(var25, var21, ComposeUiNode.Companion.getSetModifier());
         int var31 = 14 & var23 >> 6;
         int var33 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var34 = 6 | 112 & var14 >> 6;
         RowScope var148 = (RowScope)RowScopeInstance.INSTANCE;
         int var37 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1084744553, "C652@26288L664,651@26238L1277,683@27524L600:MainActivity.kt#to5c3");
         Modifier var149 = (Modifier)Modifier.Companion;
         boolean var164 = false;
         Object var10002 = null;
         Object var10003 = null;
         ComposerKt.sourceInformationMarkerStart($composer, -1766123180, "CC(remember):MainActivity.kt#9igjgp");
         boolean var39 = $composer.changedInstance(context) | ($dirty & 112) == 32 | $composer.changedInstance(calendar);
         int var40 = 0;
         Object var41 = $composer.rememberedValue();
         int var42 = 0;
         Object var10004;
         if (!var39 && var41 != Composer.Companion.getEmpty()) {
            var10004 = var41;
         } else {
            Object var43 = null;
            Object var44 = null;
            boolean var45 = false;
            Modifier var46 = var149;
            int var47 = 0;
            Function0 var49_1 = MainActivityKt::TopBar$lambda$168$lambda$164$lambda$163;
            var149 = var46;
            var164 = var45;
            var10002 = var44;
            var10003 = var43;
            $composer.updateRememberedValue(var49_1);
            var10004 = var49_1;
         }

         Function0 var50 = (Function0)var10004;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Modifier var120 = ClickableKt.clickable-XHw0xAI$default(var149, var164, (String)var10002, (Role)var10003, var50, 7, (Object)null);
         byte var113 = 0;
         var42 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var38 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var111 = Alignment.Companion.getStart();
         MeasurePolicy var117 = ColumnKt.columnMeasurePolicy(var38, var111, $composer, 14 & var113 >> 3 | 112 & var113 >> 3);
         int var49 = 112 & var113 << 3;
         int var51 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var52 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var53 = $composer.getCurrentCompositionLocalMap();
         Modifier var54 = ComposedModifierKt.materializeModifier($composer, var120);
         Function0 var55 = ComposeUiNode.Companion.getConstructor();
         int var56 = 6 | 896 & var49 << 6;
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
         Updater.set-impl(var58, var117, ComposeUiNode.Companion.getSetMeasurePolicy());
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
         int var67 = 6 | 112 & var113 >> 6;
         ColumnScope var150 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var70 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -354055359, "C673@27166L11,669@26977L270,680@27448L11,676@27260L245:MainActivity.kt#to5c3");
         String var151 = dayFormat.format(new Date(selectedDate));
         Intrinsics.checkNotNullExpressionValue(var151, "format(...)");
         String var71 = var151;
         long var72 = TextUnitKt.getSp(24);
         FontWeight var74 = FontWeight.Companion.getSemiBold();
         long var75 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         long var77 = TextUnitKt.getSp((double)-0.5F);
         TextKt.Text--4IGK_g(var71, (Modifier)null, var75, var72, (FontStyle)null, var74, (FontFamily)null, var77, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 130898);
         var151 = dateFormat.format(new Date(selectedDate));
         Intrinsics.checkNotNullExpressionValue(var151, "format(...)");
         var71 = var151;
         var72 = TextUnitKt.getSp(14);
         var74 = FontWeight.Companion.getMedium();
         var75 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         TextKt.Text--4IGK_g(var71, (Modifier)null, var75, var72, (FontStyle)null, var74, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Modifier var153 = (Modifier)Modifier.Companion;
         int var121 = 40;
         int var108 = 0;
         var153 = ClipKt.clip(SizeKt.size-3ABfNKs(var153, Dp.constructor-impl((float)var121)), (Shape)RoundedCornerShapeKt.getCircleShape());
         var121 = 2;
         var108 = 0;
         var153 = BorderKt.border-xT4_qwU(var153, Dp.constructor-impl((float)var121), Color.Companion.getWhite-0d7_KjU(), (Shape)RoundedCornerShapeKt.getCircleShape());
         Brush.Companion var165 = Brush.Companion;
         Color[] var123 = new Color[]{Color.box-impl(ColorKt.getIndigo400()), Color.box-impl(ColorKt.getPurple500())};
         Modifier var124 = BackgroundKt.background$default(var153, Companion.linearGradient-mHitzGk$default(var165, CollectionsKt.listOf(var123), 0L, 0L, 0, 14, (Object)null), (Shape)null, 0.0F, 6, (Object)null);
         Alignment var110 = Alignment.Companion.getCenter();
         var113 = 48;
         var42 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         boolean var112 = false;
         var117 = BoxKt.maybeCachedBoxMeasurePolicy(var110, var112);
         var49 = 112 & var113 << 3;
         var51 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var52 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var53 = $composer.getCurrentCompositionLocalMap();
         var54 = ComposedModifierKt.materializeModifier($composer, var124);
         var55 = ComposeUiNode.Companion.getConstructor();
         var56 = 6 | 896 & var49 << 6;
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
         Updater.set-impl(var58, var117, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var58, var53, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var60 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var61 = 0;
         var63 = 0;
         if (var58.getInserting() || !Intrinsics.areEqual(var58.rememberedValue(), var52)) {
            var58.updateRememberedValue(var52);
            var58.apply(var52, var60);
         }

         label98: {
            Updater.set-impl(var58, var54, ComposeUiNode.Companion.getSetModifier());
            var64 = 14 & var56 >> 6;
            var66 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            var67 = 6 | 112 & var113 >> 6;
            BoxScope var156 = (BoxScope)BoxScopeInstance.INSTANCE;
            var70 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1727479895, "C693@28024L90:MainActivity.kt#to5c3");
            FirebaseUser var142 = FirebaseAuth.getInstance().getCurrentUser();
            if (var142 != null) {
               String var157 = var142.getDisplayName();
               if (var157 != null) {
                  CharSequence var158 = (CharSequence)var157;
                  String[] var79 = new String[]{" "};
                  List var159 = StringsKt.split$default(var158, var79, false, 0, 6, (Object)null);
                  if (var159 != null) {
                     Iterable var84_1 = (Iterable)var159;
                     int var145 = 0;
                     Collection var82 = (Collection)(new ArrayList());
                     int var83 = 0;
                     int var85 = 0;

                     for(Object var88_1 : var84_1) {
                        int var89 = 0;
                        String var90 = (String)var88_1;
                        int var91 = 0;
                        Character var160 = StringsKt.firstOrNull((CharSequence)var90);
                        String var161 = var160 != null ? var160.toString() : null;
                        if (var161 != null) {
                           Object var92 = var161;
                           int var93 = 0;
                           var82.add(var92);
                        }
                     }

                     var162 = CollectionsKt.joinToString$default((Iterable)((List)var82), (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null);
                     if (var162 != null) {
                        break label98;
                     }
                  }
               }
            }

            var162 = "JD";
         }

         String var94 = var162;
         TextKt.Text--4IGK_g(var94, (Modifier)null, Color.Companion.getWhite-0d7_KjU(), TextUnitKt.getSp(12), (FontStyle)null, FontWeight.Companion.getBold(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 200064, 0, 131026);
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

      ScopeUpdateScope var163 = $composer.endRestartGroup();
      if (var163 != null) {
         var163.updateScope(MainActivityKt::TopBar$lambda$169);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void UpcomingPlansSection(@NotNull List tasks, @NotNull List googleEvents, @NotNull Function1 onTaskClick, @NotNull Function1 onGoogleEventClick, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(tasks, "tasks");
      Intrinsics.checkNotNullParameter(googleEvents, "googleEvents");
      Intrinsics.checkNotNullParameter(onTaskClick, "onTaskClick");
      Intrinsics.checkNotNullParameter(onGoogleEventClick, "onGoogleEventClick");
      $composer = $composer.startRestartGroup(-678107882);
      ComposerKt.sourceInformation($composer, "C(UpcomingPlansSection)P(3!1,2)705@28353L39,707@28417L637,720@29060L2654:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changedInstance(tasks) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(googleEvents) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(onTaskClick) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(onGoogleEventClick) ? 2048 : 1024;
      }

      if (($dirty & 1171) == 1170 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-678107882, $dirty, -1, "com.example.UpcomingPlansSection (MainActivity.kt:704)");
         }

         ComposerKt.sourceInformationMarkerStart($composer, 1173361437, "CC(remember):MainActivity.kt#9igjgp");
         boolean var12 = false;
         int var13 = 0;
         Object var14 = $composer.rememberedValue();
         int var15 = 0;
         Object var10000;
         if (var14 == Composer.Companion.getEmpty()) {
            int var16 = 0;
            Object var73 = System.currentTimeMillis();
            $composer.updateRememberedValue(var73);
            var10000 = var73;
         } else {
            var10000 = var14;
         }

         long var9 = ((Number)var10000).longValue();
         ComposerKt.sourceInformationMarkerEnd($composer);
         long currentTime = var9;
         ComposerKt.sourceInformationMarkerStart($composer, 1173364083, "CC(remember):MainActivity.kt#9igjgp");
         var12 = $composer.changed(tasks) | $composer.changed(googleEvents);
         var13 = 0;
         var14 = $composer.rememberedValue();
         var15 = 0;
         if (!var12 && var14 != Composer.Companion.getEmpty()) {
            var10000 = var14;
         } else {
            int var74 = 0;
            List var19_9 = (List)(new ArrayList());
            Iterable var18 = (Iterable)tasks;
            int var24_4 = 0;
            Collection var21 = (Collection)(new ArrayList());
            int var22 = 0;

            for(Object var24 : var18) {
               label153: {
                  TaskEntity var25 = (TaskEntity)var24;
                  int var26 = 0;
                  if (var25.isTimeBoxed() && var25.getStartTime() != null && var25.getEndTime() != null) {
                     Long var122 = var25.getEndTime();
                     Intrinsics.checkNotNull(var122);
                     if (var122 > currentTime) {
                        var123 = true;
                        break label153;
                     }
                  }

                  var123 = false;
               }

               if (var123) {
                  var21.add(var24);
               }
            }

            var18 = (Iterable)((List)var21);
            var24_4 = 0;

            for(Object var90 : var18) {
               TaskEntity var93 = (TaskEntity)var90;
               int var98 = 0;
               var19_9.add(new PlanItem.LocalTask(var93));
            }

            Iterable var24_4 = (Iterable)tasks;
            int var85 = 0;
            Collection var94 = (Collection)(new ArrayList());
            int var99 = 0;
            int var106 = 0;

            for(Object var28_1 : var24_4) {
               int var29 = 0;
               TaskEntity var30 = (TaskEntity)var28_1;
               int var31 = 0;
               String var124 = var30.getExternalCalendarEventId();
               if (var124 != null) {
                  Object var32 = var124;
                  int var33 = 0;
                  var94.add(var32);
               }
            }

            Set var78 = CollectionsKt.toSet((Iterable)((List)var94));
            var24_4 = (Iterable)googleEvents;
            var85 = 0;
            var94 = (Collection)(new ArrayList());
            var99 = 0;

            for(Object var107 : var24_4) {
               CalendarEvent var110 = (CalendarEvent)var107;
               int var112 = 0;
               if (var110.getStartTimeInMillis() != 0L && var110.getEndTimeInMillis() != 0L && var110.getEndTimeInMillis() > currentTime && !var78.contains(var110.getId())) {
                  var94.add(var107);
               }
            }

            var24_4 = (Iterable)((List)var94);
            var85 = 0;

            for(Object var96 : var24_4) {
               CalendarEvent var101 = (CalendarEvent)var96;
               int var104 = 0;
               var19_9.add(new PlanItem.GoogleEvent(var101));
            }

            var85 = 0;
            if (var19_9.size() > 1) {
               CollectionsKt.sortWith(var19_9, new MainActivityKt$UpcomingPlansSection$lambda$177$$inlined$sortBy$1());
            }

            Object var34 = CollectionsKt.take((Iterable)var19_9, 3);
            $composer.updateRememberedValue(var34);
            var10000 = var34;
         }

         List var10 = (List)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         List closestPlans = var10;
         Modifier var65 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Alignment.Vertical var67 = Alignment.Companion.getCenterVertically();
         short var70 = 390;
         var15 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var11 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var75 = RowKt.rowMeasurePolicy(var11, var67, $composer, 14 & var70 >> 3 | 112 & var70 >> 3);
         int var19_9 = 112 & var70 << 3;
         int var79 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var24_4 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var89 = $composer.getCurrentCompositionLocalMap();
         Modifier var92 = ComposedModifierKt.materializeModifier($composer, var65);
         Function0 var97 = ComposeUiNode.Companion.getConstructor();
         int var102 = 6 | 896 & var19_9 << 6;
         int var105 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var97);
         } else {
            $composer.useNode();
         }

         Composer var108 = Updater.constructor-impl($composer);
         int var111 = 0;
         Updater.set-impl(var108, var75, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var108, var89, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var28_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var28 = 0;
         int var114 = 0;
         if (var108.getInserting() || !Intrinsics.areEqual(var108.rememberedValue(), var24_4)) {
            var108.updateRememberedValue(var24_4);
            var108.apply(var24_4, var28_1);
         }

         Updater.set-impl(var108, var92, ComposeUiNode.Companion.getSetModifier());
         int var115 = 14 & var102 >> 6;
         int var116 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var117 = 6 | 112 & var70 >> 6;
         RowScope var36 = (RowScope)RowScopeInstance.INSTANCE;
         int var37 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1574317937, "C728@29323L11,724@29180L285:MainActivity.kt#to5c3");
         long var38 = TextUnitKt.getSp(11);
         FontWeight var40 = FontWeight.Companion.getBold();
         long var41 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.4F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         long var43 = TextUnitKt.getSp((double)1.5F);
         Modifier var126 = (Modifier)Modifier.Companion;
         int var45 = 8;
         int var46 = 0;
         Modifier var47 = PaddingKt.padding-qDBjuR0$default(var126, 0.0F, 0.0F, Dp.constructor-impl((float)var45), 0.0F, 11, (Object)null);
         TextKt.Text--4IGK_g("UPCOMING", var47, var41, var38, (FontStyle)null, var40, (FontFamily)null, var43, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 12782646, 0, 130896);
         if (closestPlans.isEmpty()) {
            $composer.startReplaceGroup(1574564913);
            ComposerKt.sourceInformation($composer, "735@29591L11,733@29516L167");
            TextKt.Text--4IGK_g("None", (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.35F, 0.0F, 0.0F, 0.0F, 14, (Object)null), TextUnitKt.getSp(12), (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3078, 0, 131058);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(1574816695);
            ComposerKt.sourceInformation($composer, "742@29851L1847,739@29713L1985");
            int var48 = 8;
            int var118 = 0;
            Arrangement.HorizontalOrVertical var49 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var48));
            var126 = RowScope.weight$default(var36, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
            Object var10001 = null;
            Object var10002 = null;
            boolean var10003 = false;
            Arrangement.Horizontal var10004 = (Arrangement.Horizontal)var49;
            Object var10005 = null;
            Object var10006 = null;
            boolean var10007 = false;
            ComposerKt.sourceInformationMarkerStart($composer, 604994569, "CC(remember):MainActivity.kt#9igjgp");
            boolean var51 = $composer.changedInstance(closestPlans) | ($dirty & 896) == 256 | ($dirty & 7168) == 2048;
            int var52 = 0;
            Object var53 = $composer.rememberedValue();
            int var121 = 0;
            Object var10008;
            if (!var51 && var53 != Composer.Companion.getEmpty()) {
               var10008 = var53;
            } else {
               boolean var54 = false;
               Object var55 = null;
               Object var56 = null;
               Arrangement.Horizontal var57 = var10004;
               boolean var58 = false;
               Object var59 = null;
               Object var60 = null;
               Modifier var61 = var126;
               var45 = 0;
               Function1 var46_2 = MainActivityKt::UpcomingPlansSection$lambda$185$lambda$184$lambda$183;
               var126 = var61;
               var10001 = var60;
               var10002 = var59;
               var10003 = var58;
               var10004 = var57;
               var10005 = var56;
               var10006 = var55;
               var10007 = var54;
               $composer.updateRememberedValue(var46_2);
               var10008 = var46_2;
            }

            Function1 var119 = (Function1)var10008;
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyRow(var126, (LazyListState)var10001, (PaddingValues)var10002, var10003, var10004, (Alignment.Vertical)var10005, (FlingBehavior)var10006, var10007, var119, $composer, 24576, 238);
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

      ScopeUpdateScope var128 = $composer.endRestartGroup();
      if (var128 != null) {
         var128.updateScope(MainActivityKt::UpcomingPlansSection$lambda$186);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void TimelineSection(long selectedDate, @NotNull final List timelineItems, @NotNull Function1 onTaskClick, @NotNull Function1 onTaskEdit, @NotNull Function1 onTaskCombine, @NotNull Function1 onDelete, @NotNull Function1 onEmptyHourClick, @NotNull Function1 onGoogleEventEdit, @Nullable final String highlightedTaskId, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(timelineItems, "timelineItems");
      Intrinsics.checkNotNullParameter(onTaskClick, "onTaskClick");
      Intrinsics.checkNotNullParameter(onTaskEdit, "onTaskEdit");
      Intrinsics.checkNotNullParameter(onTaskCombine, "onTaskCombine");
      Intrinsics.checkNotNullParameter(onDelete, "onDelete");
      Intrinsics.checkNotNullParameter(onEmptyHourClick, "onEmptyHourClick");
      Intrinsics.checkNotNullParameter(onGoogleEventEdit, "onGoogleEventEdit");
      $composer = $composer.startRestartGroup(1557598118);
      ComposerKt.sourceInformation($composer, "C(TimelineSection)P(7,8,4,6,5,1,2,3)798@32154L23,800@32197L310,807@32537L171,807@32513L195,814@32748L694,814@32714L728,832@33448L19507:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(selectedDate) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(timelineItems) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(onTaskClick) ? 256 : 128;
      }

      if (($changed & 24576) == 0) {
         $dirty |= $composer.changedInstance(onTaskCombine) ? 16384 : 8192;
      }

      if (($changed & 196608) == 0) {
         $dirty |= $composer.changedInstance(onDelete) ? 131072 : 65536;
      }

      if (($changed & 1572864) == 0) {
         $dirty |= $composer.changedInstance(onEmptyHourClick) ? 1048576 : 524288;
      }

      if (($changed & 12582912) == 0) {
         $dirty |= $composer.changedInstance(onGoogleEventEdit) ? 8388608 : 4194304;
      }

      if (($changed & 100663296) == 0) {
         $dirty |= $composer.changed(highlightedTaskId) ? 67108864 : 33554432;
      }

      if (($dirty & 38346899) == 38346898 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1557598118, $dirty, -1, "com.example.TimelineSection (MainActivity.kt:797)");
         }

         final LazyListState lazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
         ComposerKt.sourceInformationMarkerStart($composer, -2091779268, "CC(remember):MainActivity.kt#9igjgp");
         boolean var17 = ($dirty & 14) == 4;
         int var18 = 0;
         Object var19 = $composer.rememberedValue();
         int var20 = 0;
         Object var10000;
         if (!var17 && var19 != Composer.Companion.getEmpty()) {
            var10000 = var19;
         } else {
            int var21 = 0;
            Calendar var22 = Calendar.getInstance();
            Calendar var24_1 = Calendar.getInstance();
            int var25 = 0;
            var24_1.setTimeInMillis(selectedDate);
            Object var27 = var22.get(1) == var24_1.get(1) && var22.get(6) == var24_1.get(6);
            $composer.updateRememberedValue(var27);
            var10000 = var27;
         }

         final boolean var15 = (Boolean)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         boolean isToday = var15;
         Boolean var100 = var15;
         ComposerKt.sourceInformationMarkerStart($composer, -2091768527, "CC(remember):MainActivity.kt#9igjgp");
         var17 = $composer.changed(var15) | $composer.changed(lazyListState);
         var18 = 0;
         var19 = $composer.rememberedValue();
         var20 = 0;
         Object var106;
         if (!var17 && var19 != Composer.Companion.getEmpty()) {
            var106 = var19;
         } else {
            Boolean var69 = var100;
            int var85 = 0;
            Function2 var10001 = new Function2((Continuation)null) {
               int I$0;
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        if (var15) {
                           int currentHour = Calendar.getInstance().get(11);
                           LazyListState var10000 = lazyListState;
                           Continuation var10003 = (Continuation)this;
                           this.I$0 = currentHour;
                           this.label = 1;
                           if (LazyListState.scrollToItem$default(var10000, currentHour, 0, var10003, 2, (Object)null) == var3) {
                              return var3;
                           }
                        }
                        break;
                     case 1:
                        int currentHour = this.I$0;
                        ResultKt.throwOnFailure($result);
                        break;
                     default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  return Unit.INSTANCE;
               }

               public final Continuation create(Object value, Continuation $completion) {
                  return (Continuation)(new <anonymous constructor>($completion));
               }

               public final Object invoke(CoroutineScope p1, Continuation p2) {
                  return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
               }
            };
            var100 = var69;
            Object var88 = var10001;
            $composer.updateRememberedValue(var88);
            var106 = var88;
         }

         Function2 var71 = (Function2)var106;
         ComposerKt.sourceInformationMarkerEnd($composer);
         EffectsKt.LaunchedEffect(var100, var71, $composer, 0);
         String var101 = highlightedTaskId;
         ComposerKt.sourceInformationMarkerStart($composer, -2091761252, "CC(remember):MainActivity.kt#9igjgp");
         var17 = ($dirty & 234881024) == 67108864 | $composer.changedInstance(timelineItems) | $composer.changed(lazyListState);
         var18 = 0;
         var19 = $composer.rememberedValue();
         var20 = 0;
         if (!var17 && var19 != Composer.Companion.getEmpty()) {
            var106 = var19;
         } else {
            int var86 = 0;
            Function2 var107 = new Function2((Continuation)null) {
               Object L$0;
               Object L$1;
               int I$0;
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch (this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        if (highlightedTaskId != null) {
                           Iterable cal = (Iterable)timelineItems;
                           String var5_2 = highlightedTaskId;
                           int var5 = 0;

                           Object var10000;
                           label39: {
                              for(Object var7 : cal) {
                                 TimelineItem var8 = (TimelineItem)var7;
                                 int var9 = 0;
                                 String var11 = var8 instanceof TimelineItem.AppTaskItem ? "local_" + ((TimelineItem.AppTaskItem)var8).getTask().getId() : (var8 instanceof TimelineItem.GoogleEventItem ? "google_" + ((TimelineItem.GoogleEventItem)var8).getEvent().getId() : null);
                                 if (Intrinsics.areEqual(var11, var5_2)) {
                                    var10000 = var7;
                                    break label39;
                                 }
                              }

                              var10000 = null;
                           }

                           TimelineItem targetItem = (TimelineItem)var10000;
                           if (targetItem != null) {
                              Calendar var5_2 = Calendar.getInstance();
                              int var19 = 0;
                              var5_2.setTimeInMillis(targetItem.getTimeInMillis());
                              Calendar cal = var5_2;
                              int hour = var5_2.get(11);
                              LazyListState var20 = lazyListState;
                              Continuation var10003 = (Continuation)this;
                              this.L$0 = SpillingKt.nullOutSpilledVariable(targetItem);
                              this.L$1 = SpillingKt.nullOutSpilledVariable(cal);
                              this.I$0 = hour;
                              this.label = 1;
                              if (LazyListState.animateScrollToItem$default(var20, hour, 0, var10003, 2, (Object)null) == var12) {
                                 return var12;
                              }
                           }
                        }
                        break;
                     case 1:
                        int hour = this.I$0;
                        Calendar cal = (Calendar)this.L$1;
                        TimelineItem targetItem = (TimelineItem)this.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                     default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  return Unit.INSTANCE;
               }

               public final Continuation create(Object value, Continuation $completion) {
                  return (Continuation)(new <anonymous constructor>($completion));
               }

               public final Object invoke(CoroutineScope p1, Continuation p2) {
                  return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
               }
            };
            var101 = highlightedTaskId;
            Object var89 = var107;
            $composer.updateRememberedValue(var89);
            var106 = var89;
         }

         var71 = (Function2)var106;
         ComposerKt.sourceInformationMarkerEnd($composer);
         EffectsKt.LaunchedEffect(var101, var71, $composer, 14 & $dirty >> 24);
         Modifier var73 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var81 = 6;
         var20 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var16 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var76 = Alignment.Companion.getStart();
         MeasurePolicy var87 = ColumnKt.columnMeasurePolicy(var16, var76, $composer, 14 & var81 >> 3 | 112 & var81 >> 3);
         int var90 = 112 & var81 << 3;
         int var91 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var24 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var92 = $composer.getCurrentCompositionLocalMap();
         Modifier var26 = ComposedModifierKt.materializeModifier($composer, var73);
         Function0 var93 = ComposeUiNode.Companion.getConstructor();
         int var28 = 6 | 896 & var90 << 6;
         int var29 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var93);
         } else {
            $composer.useNode();
         }

         Composer var30 = Updater.constructor-impl($composer);
         int var31 = 0;
         Updater.set-impl(var30, var87, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var30, var92, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
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
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var39 = 6 | 112 & var81 >> 6;
         ColumnScope var102 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var42 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 57162490, "C837@33649L11,833@33500L238,840@33747L41,847@34025L18924,842@33798L19151:MainActivity.kt#to5c3");
         long var43 = TextUnitKt.getSp(12);
         FontWeight var45 = FontWeight.Companion.getBold();
         long var46 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.4F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         long var48 = TextUnitKt.getSp((double)1.5F);
         TextKt.Text--4IGK_g("DAILY SCHEDULE", (Modifier)null, var46, var43, (FontStyle)null, var45, (FontFamily)null, var48, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 12782598, 0, 130898);
         Modifier var103 = (Modifier)Modifier.Companion;
         int var50 = 16;
         int var51 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var103, Dp.constructor-impl((float)var50)), $composer, 6);
         var51 = 16;
         int var94 = 0;
         Arrangement.HorizontalOrVertical var96 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var51));
         var94 = 100;
         int var52 = 0;
         PaddingValues var98 = PaddingKt.PaddingValues-a9UjIt4$default(0.0F, 0.0F, 0.0F, Dp.constructor-impl((float)var94), 7, (Object)null);
         var103 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         LazyListState var109 = lazyListState;
         PaddingValues var10002 = var98;
         boolean var10003 = false;
         Arrangement.Vertical var10004 = (Arrangement.Vertical)var96;
         Object var10005 = null;
         Object var10006 = null;
         boolean var10007 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 1941522876, "CC(remember):MainActivity.kt#9igjgp");
         boolean var54 = $composer.changed(isToday) | $composer.changedInstance(timelineItems) | ($dirty & 3670016) == 1048576 | ($dirty & 234881024) == 67108864 | ($dirty & '\ue000') == 16384 | ($dirty & 458752) == 131072 | ($dirty & 896) == 256 | ($dirty & 29360128) == 8388608;
         int var55 = 0;
         Object var56 = $composer.rememberedValue();
         int var57 = 0;
         Object var10008;
         if (!var54 && var56 != Composer.Companion.getEmpty()) {
            var10008 = var56;
         } else {
            boolean var58 = false;
            Object var59 = null;
            Object var60 = null;
            Arrangement.Vertical var61 = var10004;
            boolean var62 = false;
            Modifier var65 = var103;
            int var66 = 0;
            Function1 var68_1 = MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225;
            var103 = var65;
            var109 = lazyListState;
            var10002 = var98;
            var10003 = var62;
            var10004 = var61;
            var10005 = var60;
            var10006 = var59;
            var10007 = var58;
            $composer.updateRememberedValue(var68_1);
            var10008 = var68_1;
         }

         Function1 var99 = (Function1)var10008;
         ComposerKt.sourceInformationMarkerEnd($composer);
         LazyDslKt.LazyColumn(var103, var109, var10002, var10003, var10004, (Alignment.Horizontal)var10005, (FlingBehavior)var10006, var10007, var99, $composer, 24966, 232);
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

      ScopeUpdateScope var105 = $composer.endRestartGroup();
      if (var105 != null) {
         var105.updateScope(MainActivityKt::TimelineSection$lambda$228);
      }

   }

   @Composable
   @ComposableInferredTarget(
      scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]"
   )
   public static final void ScheduleRow(@NotNull String time, boolean isToday, boolean isCurrentHour, boolean isLast, @NotNull Function2 content, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(time, "time");
      Intrinsics.checkNotNullParameter(content, "content");
      $composer = $composer.startRestartGroup(1418089130);
      ComposerKt.sourceInformation($composer, "C(ScheduleRow)P(4,3,1,2)1134@53121L2481:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(time) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changed(isToday) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changed(isCurrentHour) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changed(isLast) ? 2048 : 1024;
      }

      if (($changed & 24576) == 0) {
         $dirty |= $composer.changedInstance(content) ? 16384 : 8192;
      }

      if (($dirty & 9363) == 9362 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1418089130, $dirty, -1, "com.example.ScheduleRow (MainActivity.kt:1133)");
         }

         Modifier var8 = IntrinsicKt.height(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), IntrinsicSize.Max);
         Alignment.Vertical var10 = Alignment.Companion.getTop();
         short var12 = 390;
         int var13 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var9 = Arrangement.INSTANCE.getStart();
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
         ComposerKt.sourceInformationMarkerStart($composer, -481109583, "C1140@53280L588,1156@53878L40,1158@53958L11,1163@54139L372,1159@54011L1376,1195@55397L40,1197@55447L149:MainActivity.kt#to5c3");
         Modifier var10000 = (Modifier)Modifier.Companion;
         int var36 = 48;
         int var37 = 0;
         var10000 = SizeKt.width-3ABfNKs(var10000, Dp.constructor-impl((float)var36));
         var36 = 18;
         var37 = 0;
         Modifier var84 = PaddingKt.padding-qDBjuR0$default(var10000, 0.0F, Dp.constructor-impl((float)var36), 0.0F, 0.0F, 13, (Object)null);
         Alignment.Horizontal var38 = Alignment.Companion.getEnd();
         boolean var40 = (boolean)390;
         int var41 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var87 = Arrangement.INSTANCE.getTop();
         MeasurePolicy var42 = ColumnKt.columnMeasurePolicy(var87, var38, $composer, 14 & var40 >> 3 | 112 & var40 >> 3);
         int var43 = 112 & var40 << 3;
         int var44 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var45 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var46 = $composer.getCurrentCompositionLocalMap();
         Modifier var47 = ComposedModifierKt.materializeModifier($composer, var84);
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
         int var60 = 6 | 112 & var40 >> 6;
         ColumnScope var149 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var63 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -450678970, "C1148@53701L157:MainActivity.kt#to5c3");
         long var150;
         if (isCurrentHour && isToday) {
            $composer.startReplaceGroup(401105057);
            $composer.endReplaceGroup();
            var150 = androidx.compose.ui.graphics.ColorKt.Color(4294913365L);
         } else {
            $composer.startReplaceGroup(401107042);
            ComposerKt.sourceInformation($composer, "1146@53544L11");
            long var64 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            $composer.endReplaceGroup();
            var150 = var64;
         }

         long var66 = var150;
         FontWeight var68 = isCurrentHour && isToday ? FontWeight.Companion.getExtraBold() : FontWeight.Companion.getBold();
         long var69 = TextUnitKt.getSp(13);
         TextKt.Text--4IGK_g(time, (Modifier)null, var66, var69, (FontStyle)null, var68, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3072 | 14 & $dirty, 0, 131026);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Modifier var151 = (Modifier)Modifier.Companion;
         int var85 = 12;
         int var88 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var151, Dp.constructor-impl((float)var85)), $composer, 6);
         long var71 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.08F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         var151 = (Modifier)Modifier.Companion;
         int var89 = 16;
         int var39 = 0;
         var151 = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(var151, Dp.constructor-impl((float)var89)), 0.0F, 1, (Object)null);
         ComposerKt.sourceInformationMarkerStart($composer, -2093704102, "CC(remember):MainActivity.kt#9igjgp");
         var40 = ($dirty & 7168) == 2048 | $composer.changed(var71);
         var41 = 0;
         Object var103 = $composer.rememberedValue();
         var43 = 0;
         Object var163;
         if (!var40 && var103 != Composer.Companion.getEmpty()) {
            var163 = var103;
         } else {
            Modifier var73 = var151;
            var44 = 0;
            Function1 var10001 = MainActivityKt::ScheduleRow$lambda$234$lambda$231$lambda$230;
            var151 = var73;
            Object var112 = var10001;
            $composer.updateRememberedValue(var112);
            var163 = var112;
         }

         Function1 var90 = (Function1)var163;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Modifier var91 = DrawModifierKt.drawBehind(var151, var90);
         Alignment var95 = Alignment.Companion.getTopCenter();
         byte var104 = 48;
         var43 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         var40 = (boolean)0;
         MeasurePolicy var110 = BoxKt.maybeCachedBoxMeasurePolicy(var95, var40);
         var45 = 112 & var104 << 3;
         int var115 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var117 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var119 = $composer.getCurrentCompositionLocalMap();
         Modifier var121 = ComposedModifierKt.materializeModifier($composer, var91);
         Function0 var123 = ComposeUiNode.Companion.getConstructor();
         int var125 = 6 | 896 & var45 << 6;
         var52 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var123);
         } else {
            $composer.useNode();
         }

         Composer var129 = Updater.constructor-impl($composer);
         var54 = 0;
         Updater.set-impl(var129, var110, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var129, var119, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var55 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var56 = 0;
         int var58 = 0;
         if (var129.getInserting() || !Intrinsics.areEqual(var129.rememberedValue(), var117)) {
            var129.updateRememberedValue(var117);
            var129.apply(var117, var55);
         }

         Updater.set-impl(var129, var121, ComposeUiNode.Companion.getSetModifier());
         var59 = 14 & var125 >> 6;
         int var61 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         int var62 = 6 | 112 & var104 >> 6;
         BoxScope var154 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var75 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -508851634, "C1178@54805L572:MainActivity.kt#to5c3");
         float var155;
         if (isCurrentHour && isToday) {
            int var144 = 10;
            int var145 = 0;
            var155 = Dp.constructor-impl((float)var144);
         } else {
            int var76 = 6;
            int var77 = 0;
            var155 = Dp.constructor-impl((float)var76);
         }

         float var141 = var155;
         long var156;
         if (isCurrentHour && isToday) {
            $composer.startReplaceGroup(2061798577);
            $composer.endReplaceGroup();
            var156 = androidx.compose.ui.graphics.ColorKt.Color(4294913365L);
         } else {
            $composer.startReplaceGroup(2061800562);
            ComposerKt.sourceInformation($composer, "1176@54748L11");
            var69 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.3F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            $composer.endReplaceGroup();
            var156 = var69;
         }

         long var78 = var156;
         Modifier var157 = (Modifier)Modifier.Companion;
         int var80 = 22;
         int var81 = 0;
         var157 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(var157, 0.0F, Dp.constructor-impl((float)var80), 0.0F, 0.0F, 13, (Object)null), var141), (Shape)RoundedCornerShapeKt.getCircleShape()), var78, (Shape)null, 2, (Object)null);
         Modifier var164;
         if (isCurrentHour && isToday) {
            var164 = (Modifier)Modifier.Companion;
            var80 = 2;
            var81 = 0;
            var164 = BorderKt.border(var164, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var80), Color.copy-wmQWz5c$default(androidx.compose.ui.graphics.ColorKt.Color(4294913365L), 0.3F, 0.0F, 0.0F, 0.0F, 14, (Object)null)), (Shape)RoundedCornerShapeKt.getCircleShape());
         } else {
            var164 = (Modifier)Modifier.Companion;
         }

         BoxKt.Box(var157.then(var164), $composer, 0);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         var157 = (Modifier)Modifier.Companion;
         int var92 = 12;
         int var96 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var157, Dp.constructor-impl((float)var92)), $composer, 6);
         var157 = RowScope.weight$default(var34, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         var92 = 16;
         var96 = 0;
         Modifier var94 = PaddingKt.padding-qDBjuR0$default(var157, 0.0F, 0.0F, 0.0F, Dp.constructor-impl((float)var92), 7, (Object)null);
         var104 = 0;
         var43 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         Alignment var98 = Alignment.Companion.getTopStart();
         var40 = (boolean)0;
         var110 = BoxKt.maybeCachedBoxMeasurePolicy(var98, var40);
         var45 = 112 & var104 << 3;
         var115 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var117 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var119 = $composer.getCurrentCompositionLocalMap();
         var121 = ComposedModifierKt.materializeModifier($composer, var94);
         var123 = ComposeUiNode.Companion.getConstructor();
         var125 = 6 | 896 & var45 << 6;
         var52 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var123);
         } else {
            $composer.useNode();
         }

         var129 = Updater.constructor-impl($composer);
         var54 = 0;
         Updater.set-impl(var129, var110, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var129, var119, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var55 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var56 = 0;
         var58 = 0;
         if (var129.getInserting() || !Intrinsics.areEqual(var129.rememberedValue(), var117)) {
            var129.updateRememberedValue(var117);
            var129.apply(var117, var55);
         }

         Updater.set-impl(var129, var121, ComposeUiNode.Companion.getSetModifier());
         var59 = 14 & var125 >> 6;
         var61 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         var62 = 6 | 112 & var104 >> 6;
         BoxScope var161 = (BoxScope)BoxScopeInstance.INSTANCE;
         var75 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 2059855761, "C1202@55577L9:MainActivity.kt#to5c3");
         content.invoke($composer, 14 & $dirty >> 12);
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

      ScopeUpdateScope var162 = $composer.endRestartGroup();
      if (var162 != null) {
         var162.updateScope(MainActivityKt::ScheduleRow$lambda$235);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void BottomNavBar(@NotNull String currentRoute, @NotNull Function1 onNavigate, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(currentRoute, "currentRoute");
      Intrinsics.checkNotNullParameter(onNavigate, "onNavigate");
      $composer = $composer.startRestartGroup(2029508048);
      ComposerKt.sourceInformation($composer, "C(BottomNavBar)1213@55809L18,1214@55885L18,1209@55693L858:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(currentRoute) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(onNavigate) ? 32 : 16;
      }

      if (($dirty & 19) == 18 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029508048, $dirty, -1, "com.example.BottomNavBar (MainActivity.kt:1208)");
         }

         Modifier var10000 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var5 = 80;
         int var6 = 0;
         var10000 = BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(var10000, Dp.constructor-impl((float)var5)), ThemeKt.isAppInDarkTheme($composer, 0) ? ColorKt.getDarkSurface() : ColorKt.getWhite90(), (Shape)null, 2, (Object)null);
         var5 = 1;
         var6 = 0;
         var10000 = BorderKt.border-xT4_qwU$default(var10000, Dp.constructor-impl((float)var5), ThemeKt.isAppInDarkTheme($composer, 0) ? ColorKt.getDarkGlassBorder() : ColorKt.getSlate100(), (Shape)null, 4, (Object)null);
         var5 = 8;
         var6 = 0;
         Modifier var48 = PaddingKt.padding-VpY3zN4$default(var10000, Dp.constructor-impl((float)var5), 0.0F, 2, (Object)null);
         Arrangement.Horizontal var51 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceAround();
         Alignment.Vertical var7 = Alignment.Companion.getCenterVertically();
         short var9 = 432;
         int var10 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         MeasurePolicy var11 = RowKt.rowMeasurePolicy(var51, var7, $composer, 14 & var9 >> 3 | 112 & var9 >> 3);
         int var12 = 112 & var9 << 3;
         int var13 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var14 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var15 = $composer.getCurrentCompositionLocalMap();
         Modifier var16 = ComposedModifierKt.materializeModifier($composer, var48);
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
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var29 = 6 | 112 & var9 >> 6;
         RowScope var84 = (RowScope)RowScopeInstance.INSTANCE;
         int var32 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 82985559, "C1219@56182L22,1219@56105L99,1220@56291L23,1220@56213L101,1221@56402L22,1221@56323L101,1222@56519L26,1222@56433L112:MainActivity.kt#to5c3");
         String var85 = "Planner";
         ImageVector var10001 = HomeKt.getHome(Icons.INSTANCE.getDefault());
         boolean var10002 = Intrinsics.areEqual(currentRoute, "home");
         ComposerKt.sourceInformationMarkerStart($composer, -1521341654, "CC(remember):MainActivity.kt#9igjgp");
         boolean var34 = ($dirty & 112) == 32;
         int var35 = 0;
         Object var36 = $composer.rememberedValue();
         int var37 = 0;
         Object var10003;
         if (!var34 && var36 != Composer.Companion.getEmpty()) {
            var10003 = var36;
         } else {
            boolean var38 = var10002;
            ImageVector var39 = var10001;
            String var40 = "Planner";
            int var41 = 0;
            Function0 var43_1 = MainActivityKt::BottomNavBar$lambda$244$lambda$237$lambda$236;
            var85 = var40;
            var10001 = var39;
            var10002 = var38;
            $composer.updateRememberedValue(var43_1);
            var10003 = var43_1;
         }

         Function0 var44 = (Function0)var10003;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NavBarItem(var85, var10001, var10002, var44, $composer, 6, 0);
         var85 = "Notes";
         var10001 = CreateKt.getCreate(Icons.INSTANCE.getDefault());
         var10002 = Intrinsics.areEqual(currentRoute, "notes");
         ComposerKt.sourceInformationMarkerStart($composer, -1521338165, "CC(remember):MainActivity.kt#9igjgp");
         var34 = ($dirty & 112) == 32;
         var35 = 0;
         var36 = $composer.rememberedValue();
         var37 = 0;
         if (!var34 && var36 != Composer.Companion.getEmpty()) {
            var10003 = var36;
         } else {
            boolean var64 = var10002;
            ImageVector var67 = var10001;
            String var70 = "Notes";
            int var73 = 0;
            Function0 var43_1 = MainActivityKt::BottomNavBar$lambda$244$lambda$239$lambda$238;
            var85 = var70;
            var10001 = var67;
            var10002 = var64;
            $composer.updateRememberedValue(var43_1);
            var10003 = var43_1;
         }

         var44 = (Function0)var10003;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NavBarItem(var85, var10001, var10002, var44, $composer, 6, 0);
         var85 = "Plan";
         var10001 = DateRangeKt.getDateRange(Icons.INSTANCE.getDefault());
         var10002 = Intrinsics.areEqual(currentRoute, "sync");
         ComposerKt.sourceInformationMarkerStart($composer, -1521334614, "CC(remember):MainActivity.kt#9igjgp");
         var34 = ($dirty & 112) == 32;
         var35 = 0;
         var36 = $composer.rememberedValue();
         var37 = 0;
         if (!var34 && var36 != Composer.Companion.getEmpty()) {
            var10003 = var36;
         } else {
            boolean var65 = var10002;
            ImageVector var68 = var10001;
            String var71 = "Plan";
            int var74 = 0;
            Function0 var43_1 = MainActivityKt::BottomNavBar$lambda$244$lambda$241$lambda$240;
            var85 = var71;
            var10001 = var68;
            var10002 = var65;
            $composer.updateRememberedValue(var43_1);
            var10003 = var43_1;
         }

         var44 = (Function0)var10003;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NavBarItem(var85, var10001, var10002, var44, $composer, 6, 0);
         var85 = "Settings";
         var10001 = SettingsKt.getSettings(Icons.INSTANCE.getDefault());
         var10002 = Intrinsics.areEqual(currentRoute, "settings");
         ComposerKt.sourceInformationMarkerStart($composer, -1521330866, "CC(remember):MainActivity.kt#9igjgp");
         var34 = ($dirty & 112) == 32;
         var35 = 0;
         var36 = $composer.rememberedValue();
         var37 = 0;
         if (!var34 && var36 != Composer.Companion.getEmpty()) {
            var10003 = var36;
         } else {
            boolean var66 = var10002;
            ImageVector var69 = var10001;
            String var72 = "Settings";
            int var75 = 0;
            Function0 var43_1 = MainActivityKt::BottomNavBar$lambda$244$lambda$243$lambda$242;
            var85 = var72;
            var10001 = var69;
            var10002 = var66;
            $composer.updateRememberedValue(var43_1);
            var10003 = var43_1;
         }

         var44 = (Function0)var10003;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NavBarItem(var85, var10001, var10002, var44, $composer, 6, 0);
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

      ScopeUpdateScope var89 = $composer.endRestartGroup();
      if (var89 != null) {
         var89.updateScope(MainActivityKt::BottomNavBar$lambda$245);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void NavBarItem(@NotNull String label, @NotNull ImageVector icon, boolean isActive, @NotNull Function0 onClick, @Nullable Composer $composer, int $changed, int var6) {
      Intrinsics.checkNotNullParameter(label, "label");
      Intrinsics.checkNotNullParameter(icon, "icon");
      Intrinsics.checkNotNullParameter(onClick, "onClick");
      $composer = $composer.startRestartGroup(1831747957);
      ComposerKt.sourceInformation($composer, "C(NavBarItem)P(2)1232@56836L13,1228@56670L980:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(label) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changed(icon) ? 32 : 16;
      }

      if ((var6 & 4) != 0) {
         $dirty |= 384;
      } else if (($changed & 384) == 0) {
         $dirty |= $composer.changed(isActive) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(onClick) ? 2048 : 1024;
      }

      if (($dirty & 1171) == 1170 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if ((var6 & 4) != 0) {
            isActive = false;
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1831747957, $dirty, -1, "com.example.NavBarItem (MainActivity.kt:1227)");
         }

         Alignment.Horizontal var8 = Alignment.Companion.getCenterHorizontally();
         Modifier var10000 = AlphaKt.alpha((Modifier)Modifier.Companion, isActive ? 1.0F : 0.5F);
         boolean var10001 = false;
         Object var10002 = null;
         Object var10003 = null;
         ComposerKt.sourceInformationMarkerStart($composer, -626795678, "CC(remember):MainActivity.kt#9igjgp");
         boolean var11 = ($dirty & 7168) == 2048;
         int var12 = 0;
         Object var13 = $composer.rememberedValue();
         int var14 = 0;
         Object var10004;
         if (!var11 && var13 != Composer.Companion.getEmpty()) {
            var10004 = var13;
         } else {
            Object var79 = null;
            Object var78 = null;
            boolean var77 = false;
            Modifier var76 = var10000;
            int var15 = 0;
            Function0 var16_1 = MainActivityKt::NavBarItem$lambda$247$lambda$246;
            var10000 = var76;
            var10001 = var77;
            var10002 = var78;
            var10003 = var79;
            $composer.updateRememberedValue(var16_1);
            var10004 = var16_1;
         }

         Function0 var9 = (Function0)var10004;
         ComposerKt.sourceInformationMarkerEnd($composer);
         var10000 = ClickableKt.clickable-XHw0xAI$default(var10000, var10001, (String)var10002, (Role)var10003, var9, 7, (Object)null);
         int var82 = 4;
         int var10 = 0;
         Modifier var83 = PaddingKt.padding-3ABfNKs(var10000, Dp.constructor-impl((float)var82));
         short var85 = 384;
         var14 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var84 = Arrangement.INSTANCE.getTop();
         MeasurePolicy var87 = ColumnKt.columnMeasurePolicy(var84, var8, $composer, 14 & var85 >> 3 | 112 & var85 >> 3);
         int var16 = 112 & var85 << 3;
         int var17 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var18 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var19 = $composer.getCurrentCompositionLocalMap();
         Modifier var20 = ComposedModifierKt.materializeModifier($composer, var83);
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
         Updater.set-impl(var24, var87, ComposeUiNode.Companion.getSetMeasurePolicy());
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
         int var33 = 6 | 112 & var85 >> 6;
         ColumnScope var101 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var36 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1628755433, "C1246@57439L40,1247@57488L156:MainActivity.kt#to5c3");
         if (!isActive) {
            $composer.startReplaceGroup(1629104368);
            ComposerKt.sourceInformation($composer, "1244@57341L18,1244@57277L143");
            long var70 = ThemeKt.isAppInDarkTheme($composer, 0) ? Color.Companion.getWhite-0d7_KjU() : ColorKt.getSlate900();
            Modifier var106 = (Modifier)Modifier.Companion;
            int var39 = 24;
            int var96 = 0;
            Modifier var97 = SizeKt.size-3ABfNKs(var106, Dp.constructor-impl((float)var39));
            IconKt.Icon-ww6aTOc(icon, label, var97, var70, $composer, 384 | 14 & $dirty >> 3 | 112 & $dirty << 3, 0);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(1628756889);
            ComposerKt.sourceInformation($composer, "1236@56921L326");
            Modifier var102 = (Modifier)Modifier.Companion;
            long var109 = ColorKt.getIndigo100();
            int var37 = 16;
            int var38 = 0;
            var102 = BackgroundKt.background-bw27NRU(var102, var109, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var37)));
            var37 = 20;
            var38 = 0;
            float var110 = Dp.constructor-impl((float)var37);
            var37 = 4;
            var38 = 0;
            Modifier var90 = PaddingKt.padding-VpY3zN4(var102, var110, Dp.constructor-impl((float)var37));
            byte var40 = 0;
            int var41 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment var94 = Alignment.Companion.getTopStart();
            boolean var42 = false;
            MeasurePolicy var43 = BoxKt.maybeCachedBoxMeasurePolicy(var94, var42);
            int var44 = 112 & var40 << 3;
            int var45 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var46 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var47 = $composer.getCurrentCompositionLocalMap();
            Modifier var48 = ComposedModifierKt.materializeModifier($composer, var90);
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
            BoxScope var104 = (BoxScope)BoxScopeInstance.INSTANCE;
            int var64 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -998465168, "C1241@57130L103:MainActivity.kt#to5c3");
            long var65 = ColorKt.getIndigo700();
            Modifier var105 = (Modifier)Modifier.Companion;
            int var67 = 24;
            int var68 = 0;
            Modifier var69 = SizeKt.size-3ABfNKs(var105, Dp.constructor-impl((float)var67));
            IconKt.Icon-ww6aTOc(icon, label, var69, var65, $composer, 3456 | 14 & $dirty >> 3 | 112 & $dirty << 3, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
         }

         Modifier var107 = (Modifier)Modifier.Companion;
         int var91 = 4;
         int var95 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var107, Dp.constructor-impl((float)var91)), $composer, 6);
         long var99 = TextUnitKt.getSp(10);
         FontWeight var98 = FontWeight.Companion.getBold();
         $composer.startReplaceGroup(329655931);
         ComposerKt.sourceInformation($composer, "1247@57597L18");
         long var72 = isActive ? ColorKt.getIndigo700() : (ThemeKt.isAppInDarkTheme($composer, 0) ? Color.Companion.getWhite-0d7_KjU() : ColorKt.getSlate900());
         $composer.endReplaceGroup();
         TextKt.Text--4IGK_g(label, (Modifier)null, var72, var99, (FontStyle)null, var98, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680 | 14 & $dirty, 0, 131026);
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

      ScopeUpdateScope var108 = $composer.endRestartGroup();
      if (var108 != null) {
         var108.updateScope(MainActivityKt::NavBarItem$lambda$250);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void AddTaskDialog(@Nullable TaskEntity task, boolean isCreatingPlan, @Nullable List initialSubTasks, @Nullable Integer prefilledHour, @NotNull Function0 onDismiss, @Nullable Function0 onDelete, @NotNull Function12 onSave, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
      Intrinsics.checkNotNullParameter(onSave, "onSave");
      $composer = $composer.startRestartGroup(-1798918113);
      ComposerKt.sourceInformation($composer, "C(AddTaskDialog)P(6,1!1,5,3)1275@58290L46,1276@58360L52,1277@58436L73,1278@58531L53,1287@58899L40,1288@58958L42,1296@59182L44,1298@59251L55,1299@59340L62,1300@59433L47,1302@59501L123,1305@59652L31,1307@59716L7,1572@73843L836,1597@74705L405,1311@59796L209,1318@60022L13795,1309@59729L15387:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(task) ? 4 : 2);
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(initialSubTasks) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changed(prefilledHour) ? 2048 : 1024;
      }

      if (($changed & 24576) == 0) {
         $dirty |= $composer.changedInstance(onDismiss) ? 16384 : 8192;
      }

      if (($changed & 196608) == 0) {
         $dirty |= $composer.changedInstance(onDelete) ? 131072 : 65536;
      }

      if (($changed & 1572864) == 0) {
         $dirty |= $composer.changedInstance(onSave) ? 1048576 : 524288;
      }

      if (($dirty & 599171) == 599170 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1798918113, $dirty, -1, "com.example.AddTaskDialog (MainActivity.kt:1274)");
         }

         ComposerKt.sourceInformationMarkerStart($composer, 2111534093, "CC(remember):MainActivity.kt#9igjgp");
         boolean var13 = false;
         int var14 = 0;
         Object var15 = $composer.rememberedValue();
         int var16 = 0;
         Object var130;
         if (var15 != Composer.Companion.getEmpty()) {
            var130 = var15;
         } else {
            label222: {
               int var17 = 0;
               if (task != null) {
                  var10000 = task.getTitle();
                  if (var10000 != null) {
                     break label222;
                  }
               }

               var10000 = "";
            }

            Object var19 = SnapshotStateKt.mutableStateOf$default(var10000, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var19);
            var130 = var19;
         }

         MutableState description$delegate = (MutableState)var130;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableState title$delegate = description$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2111536339, "CC(remember):MainActivity.kt#9igjgp");
         var14 = 0;
         int var43 = 0;
         Object var46 = $composer.rememberedValue();
         int var50 = 0;
         if (var46 != Composer.Companion.getEmpty()) {
            var130 = var46;
         } else {
            label213: {
               int var18 = 0;
               if (task != null) {
                  var131 = task.getDescription();
                  if (var131 != null) {
                     break label213;
                  }
               }

               var131 = "";
            }

            Object var20 = SnapshotStateKt.mutableStateOf$default(var131, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var20);
            var130 = var20;
         }

         MutableState isTimeBoxed$delegate = (MutableState)var130;
         ComposerKt.sourceInformationMarkerEnd($composer);
         description$delegate = isTimeBoxed$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2111538792, "CC(remember):MainActivity.kt#9igjgp");
         var43 = 0;
         int var47 = 0;
         Object var51 = $composer.rememberedValue();
         int var55 = 0;
         if (var51 == Composer.Companion.getEmpty()) {
            int var60 = 0;
            Object var65 = SnapshotStateKt.mutableStateOf$default(task != null ? task.isTimeBoxed() : prefilledHour != null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var65);
            var130 = var65;
         } else {
            var130 = var51;
         }

         MutableState isMeeting$delegate = (MutableState)var130;
         ComposerKt.sourceInformationMarkerEnd($composer);
         isTimeBoxed$delegate = isMeeting$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2111541812, "CC(remember):MainActivity.kt#9igjgp");
         var47 = 0;
         int var52 = 0;
         Object var56 = $composer.rememberedValue();
         int var61 = 0;
         if (var56 == Composer.Companion.getEmpty()) {
            int var66 = 0;
            Object var22_1 = SnapshotStateKt.mutableStateOf$default(task != null ? task.isMeeting() : false, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var22_1);
            var130 = var22_1;
         } else {
            var130 = var56;
         }

         MutableState var41 = (MutableState)var130;
         ComposerKt.sourceInformationMarkerEnd($composer);
         isMeeting$delegate = var41;
         int var137;
         if (prefilledHour != null) {
            var137 = prefilledHour;
         } else {
            label203: {
               if (task != null) {
                  Long var135 = task.getStartTime();
                  if (var135 != null) {
                     long var57 = ((Number)var135).longValue();
                     int var67 = 0;
                     Calendar var22_1 = Calendar.getInstance();
                     int var23 = 0;
                     var22_1.setTimeInMillis(var57);
                     var136 = var22_1.get(11);
                     break label203;
                  }
               }

               var136 = null;
            }

            var137 = var136 != null ? var136 : 9;
         }

         label196: {
            defaultHour = var137;
            if (task != null) {
               Long var138 = task.getStartTime();
               if (var138 != null) {
                  long var62 = ((Number)var138).longValue();
                  int var73 = 0;
                  Calendar var23_2 = Calendar.getInstance();
                  int var24 = 0;
                  var23_2.setTimeInMillis(var62);
                  var137 = var23_2.get(12);
                  break label196;
               }
            }

            var137 = 0;
         }

         var43 = var137;
         ComposerKt.sourceInformationMarkerStart($composer, 2111553575, "CC(remember):MainActivity.kt#9igjgp");
         var61 = 0;
         int var68 = 0;
         Object var22_1 = $composer.rememberedValue();
         int var78 = 0;
         Object var140;
         if (var22_1 == Composer.Companion.getEmpty()) {
            int var84 = 0;
            Object var90 = SnapshotStateKt.mutableStateOf$default(defaultHour, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var90);
            var140 = var90;
         } else {
            var140 = var22_1;
         }

         MutableState minute$delegate = (MutableState)var140;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableState hour$delegate = minute$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2111555465, "CC(remember):MainActivity.kt#9igjgp");
         var68 = 0;
         int var75 = 0;
         Object var23_2 = $composer.rememberedValue();
         int var85 = 0;
         if (var23_2 == Composer.Companion.getEmpty()) {
            int var91 = 0;
            Object var25 = SnapshotStateKt.mutableStateOf$default(var43, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var25);
            var140 = var25;
         } else {
            var140 = var23_2;
         }

         label190: {
            MutableState var58 = (MutableState)var140;
            ComposerKt.sourceInformationMarkerEnd($composer);
            minute$delegate = var58;
            if (task != null) {
               Long var142 = task.getStartTime();
               if (var142 != null) {
                  long var23_2 = ((Number)var142).longValue();
                  int var92 = 0;
                  var142 = task.getEndTime();
                  Integer var144;
                  if (var142 != null) {
                     long var98 = ((Number)var142).longValue();
                     int var27 = 0;
                     var144 = (int)((var98 - var23_2) / (long)'\uea60');
                  } else {
                     var144 = null;
                  }

                  if (var144 != null) {
                     var145 = var144;
                     break label190;
                  }
               }
            }

            var145 = 60;
         }

         int defaultDuration = var145;
         ComposerKt.sourceInformationMarkerStart($composer, 2111562635, "CC(remember):MainActivity.kt#9igjgp");
         boolean var81 = false;
         var85 = 0;
         Object var93 = $composer.rememberedValue();
         int var99 = 0;
         if (var93 == Composer.Companion.getEmpty()) {
            int var26 = 0;
            Object var110 = SnapshotStateKt.mutableStateOf$default(defaultDuration, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var110);
            var140 = var110;
         } else {
            var140 = var93;
         }

         MutableState hasReminder$delegate = (MutableState)var140;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableState duration$delegate = hasReminder$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2111564854, "CC(remember):MainActivity.kt#9igjgp");
         var85 = 0;
         int var94 = 0;
         Object var100 = $composer.rememberedValue();
         int var105 = 0;
         if (var100 == Composer.Companion.getEmpty()) {
            int var111 = 0;
            Object var28 = SnapshotStateKt.mutableStateOf$default(task != null ? task.getHasReminder() : false, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var28);
            var140 = var28;
         } else {
            var140 = var100;
         }

         MutableState reminderMinutesBefore$delegate = (MutableState)var140;
         ComposerKt.sourceInformationMarkerEnd($composer);
         hasReminder$delegate = reminderMinutesBefore$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2111567709, "CC(remember):MainActivity.kt#9igjgp");
         var94 = 0;
         int var101 = 0;
         Object var106 = $composer.rememberedValue();
         int var112 = 0;
         if (var106 != Composer.Companion.getEmpty()) {
            var140 = var106;
         } else {
            label180: {
               int var116 = 0;
               if (task != null) {
                  Integer var148 = task.getReminderMinutesBefore();
                  if (var148 != null) {
                     var149 = var148;
                     break label180;
                  }
               }

               var149 = 15;
            }

            Object var30 = SnapshotStateKt.mutableStateOf$default(var149, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var30);
            var140 = var30;
         }

         MutableState customReminderTime$delegate = (MutableState)var140;
         ComposerKt.sourceInformationMarkerEnd($composer);
         reminderMinutesBefore$delegate = customReminderTime$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 2111570670, "CC(remember):MainActivity.kt#9igjgp");
         var101 = 0;
         int var107 = 0;
         Object var113 = $composer.rememberedValue();
         int var117 = 0;
         if (var113 == Composer.Companion.getEmpty()) {
            int var29 = 0;
            Object var124 = SnapshotStateKt.mutableStateOf$default(task != null ? task.getReminderTime() : null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var124);
            var140 = var124;
         } else {
            var140 = var113;
         }

         MutableState var88 = (MutableState)var140;
         ComposerKt.sourceInformationMarkerEnd($composer);
         customReminderTime$delegate = var88;
         ComposerKt.sourceInformationMarkerStart($composer, 2111572922, "CC(remember):MainActivity.kt#9igjgp");
         var107 = 0;
         int var114 = 0;
         Object var118 = $composer.rememberedValue();
         int var121 = 0;
         if (var118 == Composer.Companion.getEmpty()) {
            int var125 = 0;
            SnapshotStateList var32_1 = SnapshotStateKt.mutableStateListOf();
            int var33 = 0;
            if (initialSubTasks != null) {
               var32_1.addAll((Collection)initialSubTasks);
            }

            $composer.updateRememberedValue(var32_1);
            var140 = var32_1;
         } else {
            var140 = var118;
         }

         SnapshotStateList var96 = (SnapshotStateList)var140;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SnapshotStateList subTasks = var96;
         ComposerKt.sourceInformationMarkerStart($composer, 2111577662, "CC(remember):MainActivity.kt#9igjgp");
         var114 = 0;
         int var119 = 0;
         Object var122 = $composer.rememberedValue();
         int var126 = 0;
         if (var122 == Composer.Companion.getEmpty()) {
            int var128 = 0;
            Object var32_1 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var32_1);
            var140 = var32_1;
         } else {
            var140 = var122;
         }

         MutableState var103 = (MutableState)var140;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableState newSubTaskTitle$delegate = var103;
         CompositionLocal var109 = (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext();
         var119 = 0;
         int var123 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
         Object var127 = $composer.consume(var109);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Context context = (Context)var127;
         AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(onDismiss, (Function2)ComposableLambdaKt.rememberComposableLambda(39360103, true, MainActivityKt::AddTaskDialog$lambda$294, $composer, 54), (Modifier)null, (Function2)ComposableLambdaKt.rememberComposableLambda(109007977, true, MainActivityKt::AddTaskDialog$lambda$296, $composer, 54), (Function2)null, (Function2)ComposableLambdaKt.rememberComposableLambda(178655851, true, MainActivityKt::AddTaskDialog$lambda$297, $composer, 54), (Function2)ComposableLambdaKt.rememberComposableLambda(213479788, true, MainActivityKt::AddTaskDialog$lambda$354, $composer, 54), (Shape)null, 0L, 0L, 0L, 0L, 0.0F, (DialogProperties)null, $composer, 1772592 | 14 & $dirty >> 12, 0, 16276);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var154 = $composer.endRestartGroup();
      if (var154 != null) {
         var154.updateScope(MainActivityKt::AddTaskDialog$lambda$355);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void TaskDetailDialog(@NotNull TaskEntity task, @NotNull AuthManager authManager, @NotNull CalendarSyncViewModel syncViewModel, @NotNull PlannerViewModel plannerViewModel, @NotNull Function0 onDismiss, @NotNull Function1 onDelete, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(task, "task");
      Intrinsics.checkNotNullParameter(authManager, "authManager");
      Intrinsics.checkNotNullParameter(syncViewModel, "syncViewModel");
      Intrinsics.checkNotNullParameter(plannerViewModel, "plannerViewModel");
      Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
      Intrinsics.checkNotNullParameter(onDelete, "onDelete");
      $composer = $composer.startRestartGroup(413661710);
      ComposerKt.sourceInformation($composer, "C(TaskDetailDialog)P(5!1,4,3,2)1621@75407L29,1622@75460L100,1701@78809L209,1709@79044L196,1628@75633L157,1635@75807L2976,1626@75566L3680:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(task) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(authManager) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(syncViewModel) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(plannerViewModel) ? 2048 : 1024;
      }

      if (($changed & 24576) == 0) {
         $dirty |= $composer.changedInstance(onDismiss) ? 16384 : 8192;
      }

      if (($changed & 196608) == 0) {
         $dirty |= $composer.changedInstance(onDelete) ? 131072 : 65536;
      }

      if (($dirty & 74899) == 74898 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(413661710, $dirty, -1, "com.example.TaskDetailDialog (MainActivity.kt:1620)");
         }

         State subTasks$delegate = FlowExtKt.collectAsStateWithLifecycle(plannerViewModel.getAllSubTasksFlow(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         List var11 = TaskDetailDialog$lambda$356(subTasks$delegate);
         int var12 = task.getId();
         ComposerKt.sourceInformationMarkerStart($composer, -1903044238, "CC(remember):MainActivity.kt#9igjgp");
         boolean var15 = $composer.changed(var11) | $composer.changed(var12);
         int var16 = 0;
         Object var17 = $composer.rememberedValue();
         int var18 = 0;
         Object var10000;
         if (!var15 && var17 != Composer.Companion.getEmpty()) {
            var10000 = var17;
         } else {
            int var19 = 0;
            Iterable var20 = (Iterable)TaskDetailDialog$lambda$356(subTasks$delegate);
            int var21 = 0;
            Collection var23 = (Collection)(new ArrayList());
            int var24 = 0;

            for(Object var26 : var20) {
               SubTaskEntity var27 = (SubTaskEntity)var26;
               int var28 = 0;
               if (Intrinsics.areEqual(var27.getParentIdStr(), "local_" + task.getId())) {
                  var23.add(var26);
               }
            }

            Object var29 = (List)var23;
            $composer.updateRememberedValue(var29);
            var10000 = var29;
         }

         List taskSubTasks = (List)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(onDismiss, (Function2)ComposableLambdaKt.rememberComposableLambda(-1227680170, true, MainActivityKt::TaskDetailDialog$lambda$359, $composer, 54), (Modifier)null, (Function2)ComposableLambdaKt.rememberComposableLambda(-729123368, true, MainActivityKt::TaskDetailDialog$lambda$362, $composer, 54), (Function2)null, (Function2)ComposableLambdaKt.rememberComposableLambda(-230566566, true, MainActivityKt::TaskDetailDialog$lambda$363, $composer, 54), (Function2)ComposableLambdaKt.rememberComposableLambda(18711835, true, MainActivityKt::TaskDetailDialog$lambda$373, $composer, 54), (Shape)null, 0L, 0L, 0L, 0L, 0.0F, (DialogProperties)null, $composer, 1772592 | 14 & $dirty >> 12, 0, 16276);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var31 = $composer.endRestartGroup();
      if (var31 != null) {
         var31.updateScope(MainActivityKt::TaskDetailDialog$lambda$374);
      }

   }

   private static final AuthState MainAppNavigation$lambda$0(State $authState$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (AuthState)$authState$delegate.getValue();
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit MainAppNavigation$lambda$9$lambda$8$lambda$3(NavHostController $navController, AuthViewModel $authViewModel, AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
      Intrinsics.checkNotNullParameter(it, "it");
      ComposerKt.sourceInformation($composer, "C111@4465L41:MainActivity.kt#to5c3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(-2089240163, $changed, -1, "com.example.MainAppNavigation.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:111)");
      }

      LoginScreen($navController, $authViewModel, $composer, 0);
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      return Unit.INSTANCE;
   }

   private static final Unit MainAppNavigation$lambda$9$lambda$8$lambda$7$lambda$5$lambda$4(AuthViewModel $authViewModel) {
      $authViewModel.signOut();
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit MainAppNavigation$lambda$9$lambda$8$lambda$7(SettingsViewModel $settingsViewModel, AuthViewModel $authViewModel, State $authState$delegate, AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
      Intrinsics.checkNotNullParameter(it, "it");
      ComposerKt.sourceInformation($composer, "C:MainActivity.kt#to5c3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(-17870700, $changed, -1, "com.example.MainAppNavigation.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:113)");
      }

      if (MainAppNavigation$lambda$0($authState$delegate) instanceof AuthState.Success) {
         $composer.startReplaceGroup(189976465);
         ComposerKt.sourceInformation($composer, "116@4716L27,114@4604L157");
         SettingsViewModel var10000 = $settingsViewModel;
         ComposerKt.sourceInformationMarkerStart($composer, 6132271, "CC(remember):MainActivity.kt#9igjgp");
         boolean var9 = $composer.changedInstance($authViewModel);
         int var10 = 0;
         Object var11 = $composer.rememberedValue();
         int var12 = 0;
         Object var43;
         if (!var9 && var11 != Composer.Companion.getEmpty()) {
            var43 = var11;
         } else {
            int var13 = 0;
            Function0 var10001 = MainActivityKt::MainAppNavigation$lambda$9$lambda$8$lambda$7$lambda$5$lambda$4;
            var10000 = $settingsViewModel;
            Object var14 = var10001;
            $composer.updateRememberedValue(var14);
            var43 = var14;
         }

         Function0 var7 = (Function0)var43;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MainDashboardScreen(var10000, var7, $composer, 0);
         $composer.endReplaceGroup();
      } else {
         $composer.startReplaceGroup(190169998);
         ComposerKt.sourceInformation($composer, "119@4799L160");
         Modifier var36 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Alignment var8 = Alignment.Companion.getCenter();
         int var38 = 54;
         int var39 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         boolean var37 = false;
         MeasurePolicy var40 = BoxKt.maybeCachedBoxMeasurePolicy(var8, var37);
         int var41 = 112 & var38 << 3;
         int var15 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var16 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var17 = $composer.getCurrentCompositionLocalMap();
         Modifier var18 = ComposedModifierKt.materializeModifier($composer, var36);
         Function0 var19 = ComposeUiNode.Companion.getConstructor();
         int var20 = 6 | 896 & var41 << 6;
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
         Updater.set-impl(var22, var40, ComposeUiNode.Companion.getSetMeasurePolicy());
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
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         int var31 = 6 | 112 & var38 >> 6;
         BoxScope var42 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var34 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1605531879, "C120@4897L44:MainActivity.kt#to5c3");
         ProgressIndicatorKt.CircularProgressIndicator-LxG7B9w((Modifier)null, ColorKt.getIndigo600(), 0.0F, 0L, 0, $composer, 48, 29);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endReplaceGroup();
      }

      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      return Unit.INSTANCE;
   }

   private static final Unit MainAppNavigation$lambda$9$lambda$8(NavHostController $navController, AuthViewModel $authViewModel, SettingsViewModel $settingsViewModel, State $authState$delegate, NavGraphBuilder $this$NavHost) {
      Intrinsics.checkNotNullParameter($this$NavHost, "$this$NavHost");
      NavGraphBuilderKt.composable$default($this$NavHost, "login", (List)null, (List)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function4)ComposableLambdaKt.composableLambdaInstance(-2089240163, true, MainActivityKt::MainAppNavigation$lambda$9$lambda$8$lambda$3), 254, (Object)null);
      NavGraphBuilderKt.composable$default($this$NavHost, "main", (List)null, (List)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function4)ComposableLambdaKt.composableLambdaInstance(-17870700, true, MainActivityKt::MainAppNavigation$lambda$9$lambda$8$lambda$7), 254, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit MainAppNavigation$lambda$10(SettingsViewModel $settingsViewModel, int $$changed, Composer $composer, int $force) {
      MainAppNavigation($settingsViewModel, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final AuthState LoginScreen$lambda$11(State $authState$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (AuthState)$authState$delegate.getValue();
   }

   private static final boolean LoginScreen$lambda$13(MutableState $isRegisterMode$delegate) {
      State var1 = (State)$isRegisterMode$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void LoginScreen$lambda$14(MutableState $isRegisterMode$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $isRegisterMode$delegate.setValue(var5);
   }

   private static final String LoginScreen$lambda$16(MutableState $email$delegate) {
      State var1 = (State)$email$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)var1.getValue();
   }

   private static final void LoginScreen$lambda$17(MutableState $email$delegate, String var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $email$delegate.setValue(var1);
   }

   private static final String LoginScreen$lambda$19(MutableState $password$delegate) {
      State var1 = (State)$password$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)var1.getValue();
   }

   private static final void LoginScreen$lambda$20(MutableState $password$delegate, String var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $password$delegate.setValue(var1);
   }

   private static final String LoginScreen$lambda$22(MutableState $nickname$delegate) {
      State var1 = (State)$nickname$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)var1.getValue();
   }

   private static final void LoginScreen$lambda$23(MutableState $nickname$delegate, String var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $nickname$delegate.setValue(var1);
   }

   private static final Unit LoginScreen$lambda$25$lambda$24(AuthViewModel $authViewModel, ActivityResult result) {
      Intrinsics.checkNotNullParameter(result, "result");
      $authViewModel.handleGoogleSignInResult(result.getData());
      return Unit.INSTANCE;
   }

   private static final Unit LoginScreen$lambda$43$lambda$42$lambda$41$lambda$28$lambda$27(MutableState $nickname$delegate, String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      LoginScreen$lambda$23($nickname$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit LoginScreen$lambda$43$lambda$42$lambda$41$lambda$30$lambda$29(MutableState $email$delegate, String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      LoginScreen$lambda$17($email$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit LoginScreen$lambda$43$lambda$42$lambda$41$lambda$32$lambda$31(MutableState $password$delegate, String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      LoginScreen$lambda$20($password$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit LoginScreen$lambda$43$lambda$42$lambda$41$lambda$34$lambda$33(AuthViewModel $authViewModel, MutableState $isRegisterMode$delegate, MutableState $email$delegate, MutableState $password$delegate, MutableState $nickname$delegate) {
      if (LoginScreen$lambda$13($isRegisterMode$delegate)) {
         $authViewModel.registerWithEmail(LoginScreen$lambda$16($email$delegate), LoginScreen$lambda$19($password$delegate), LoginScreen$lambda$22($nickname$delegate));
      } else {
         $authViewModel.loginWithEmail(LoginScreen$lambda$16($email$delegate), LoginScreen$lambda$19($password$delegate));
      }

      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit LoginScreen$lambda$43$lambda$42$lambda$41$lambda$35(MutableState $isRegisterMode$delegate, RowScope $this$Button, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
      ComposerKt.sourceInformation($composer, "C244@9755L203:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-660989081, $changed, -1, "com.example.LoginScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:244)");
         }

         TextKt.Text--4IGK_g(LoginScreen$lambda$13($isRegisterMode$delegate) ? "Sign Up" : "Sign In", (Modifier)null, 0L, TextUnitKt.getSp(16), (FontStyle)null, FontWeight.Companion.getSemiBold(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131030);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit LoginScreen$lambda$43$lambda$42$lambda$41$lambda$37$lambda$36(AuthViewModel $authViewModel, ManagedActivityResultLauncher $launcher) {
      Intent var10000 = $authViewModel.getAuthManager().getGoogleSignInClient().getSignInIntent();
      Intrinsics.checkNotNullExpressionValue(var10000, "getSignInIntent(...)");
      Intent signInIntent = var10000;
      $launcher.launch(signInIntent);
      return Unit.INSTANCE;
   }

   private static final Unit LoginScreen$lambda$43$lambda$42$lambda$41$lambda$39$lambda$38(MutableState $isRegisterMode$delegate) {
      LoginScreen$lambda$14($isRegisterMode$delegate, !LoginScreen$lambda$13($isRegisterMode$delegate));
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit LoginScreen$lambda$43$lambda$42$lambda$41$lambda$40(MutableState $isRegisterMode$delegate, RowScope $this$TextButton, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
      ComposerKt.sourceInformation($composer, "C278@11275L252:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1974092212, $changed, -1, "com.example.LoginScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:278)");
         }

         TextKt.Text--4IGK_g(LoginScreen$lambda$13($isRegisterMode$delegate) ? "Already have an account? Sign In" : "Don't have an account? Sign Up", (Modifier)null, ColorKt.getIndigo600(), 0L, (FontStyle)null, FontWeight.Companion.getSemiBold(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 196992, 0, 131034);
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
   private static final Unit LoginScreen$lambda$43$lambda$42(AuthViewModel $authViewModel, ManagedActivityResultLauncher $launcher, MutableState $isRegisterMode$delegate, MutableState $nickname$delegate, MutableState $email$delegate, MutableState $password$delegate, State $authState$delegate, ColumnScope $this$Card, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
      ComposerKt.sourceInformation($composer, "C173@6599L5550:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1999399425, $changed, -1, "com.example.LoginScreen.<anonymous>.<anonymous> (MainActivity.kt:173)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var10 = 24;
         int var11 = 0;
         Modifier var57 = PaddingKt.padding-3ABfNKs(var10000, Dp.constructor-impl((float)var10));
         Alignment.Horizontal var12 = Alignment.Companion.getCenterHorizontally();
         short var14 = 390;
         int var15 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var58 = Arrangement.INSTANCE.getTop();
         MeasurePolicy var16 = ColumnKt.columnMeasurePolicy(var58, var12, $composer, 14 & var14 >> 3 | 112 & var14 >> 3);
         int var17 = 112 & var14 << 3;
         int var18 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var19 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var20 = $composer.getCurrentCompositionLocalMap();
         Modifier var21 = ComposedModifierKt.materializeModifier($composer, var57);
         Function0 var22 = ComposeUiNode.Companion.getConstructor();
         int var23 = 6 | 896 & var17 << 6;
         int var24 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var22);
         } else {
            $composer.useNode();
         }

         Composer var25 = Updater.constructor-impl($composer);
         int var26 = 0;
         Updater.set-impl(var25, var16, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var25, var20, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var27 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var28 = 0;
         int var30 = 0;
         if (var25.getInserting() || !Intrinsics.areEqual(var25.rememberedValue(), var19)) {
            var25.updateRememberedValue(var19);
            var25.apply(var19, var27);
         }

         Updater.set-impl(var25, var21, ComposeUiNode.Companion.getSetModifier());
         int var31 = 14 & var23 >> 6;
         int var33 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var34 = 6 | 112 & var14 >> 6;
         ColumnScope var149 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var37 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -817029621, "C177@6758L221,183@6996L41,188@7285L11,184@7054L273,190@7344L40,194@7605L11,191@7401L315,197@7733L41,213@8374L14,211@8284L319,219@8620L41,223@8772L17,221@8679L421,230@9117L41,240@9549L40,233@9214L289,243@9733L243,232@9176L800,251@9994L41,260@10418L11,261@10517L11,259@10349L214,255@10125L178,254@10087L1030,275@11135L41,277@11215L36,277@11253L292,277@11194L351:MainActivity.kt#to5c3");
         ImageVector var38 = DateRangeKt.getDateRange(Icons.INSTANCE.getDefault());
         long var39 = ColorKt.getIndigo600();
         Modifier var150 = (Modifier)Modifier.Companion;
         int var41 = 64;
         int var42 = 0;
         Modifier var43 = SizeKt.size-3ABfNKs(var150, Dp.constructor-impl((float)var41));
         IconKt.Icon-ww6aTOc(var38, "Logo", var43, var39, $composer, 3504, 0);
         var150 = (Modifier)Modifier.Companion;
         int var59 = 16;
         int var44 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var150, Dp.constructor-impl((float)var59)), $composer, 6);
         String var60 = LoginScreen$lambda$13($isRegisterMode$delegate) ? "Create Account" : "Welcome to Planner Pro";
         var39 = TextUnitKt.getSp(24);
         FontWeight var93 = FontWeight.Companion.getBold();
         long var45 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g(var60, (Modifier)null, var45, var39, (FontStyle)null, var93, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
         var150 = (Modifier)Modifier.Companion;
         int var61 = 8;
         var44 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var150, Dp.constructor-impl((float)var61)), $composer, 6);
         String var62 = LoginScreen$lambda$13($isRegisterMode$delegate) ? "Sign up to start planning" : "Sign in to keep your tasks updated";
         var39 = TextUnitKt.getSp(14);
         long var47 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.6F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         var42 = TextAlign.Companion.getCenter-e0LSkKk();
         TextKt.Text--4IGK_g(var62, (Modifier)null, var47, var39, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, TextAlign.box-impl(var42), 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3072, 0, 130546);
         var150 = (Modifier)Modifier.Companion;
         int var63 = 24;
         var44 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var150, Dp.constructor-impl((float)var63)), $composer, 6);
         if (LoginScreen$lambda$13($isRegisterMode$delegate)) {
            $composer.startReplaceGroup(-816136667);
            ComposerKt.sourceInformation($composer, "202@7935L17,200@7834L352,208@8207L41");
            String var64 = LoginScreen$lambda$22($nickname$delegate);
            Modifier var108 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            int var94 = 12;
            var41 = 0;
            RoundedCornerShape var49 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var94));
            String var154 = var64;
            ComposerKt.sourceInformationMarkerStart($composer, -1827438808, "CC(remember):MainActivity.kt#9igjgp");
            var42 = 0;
            int var50 = 0;
            Object var51 = $composer.rememberedValue();
            int var52 = 0;
            Object var170;
            if (var51 == Composer.Companion.getEmpty()) {
               int var54 = 0;
               Function1 var10001 = MainActivityKt::LoginScreen$lambda$43$lambda$42$lambda$41$lambda$28$lambda$27;
               var154 = var64;
               Object var55 = var10001;
               $composer.updateRememberedValue(var55);
               var170 = var55;
            } else {
               var170 = var51;
            }

            Function1 var95 = (Function1)var170;
            ComposerKt.sourceInformationMarkerEnd($composer);
            OutlinedTextFieldKt.OutlinedTextField(var154, var95, var108, false, false, (TextStyle)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1744754540$app(), (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, false, (VisualTransformation)null, (KeyboardOptions)null, (KeyboardActions)null, true, 0, 0, (MutableInteractionSource)null, (Shape)var49, (TextFieldColors)null, $composer, 1573296, 12582912, 0, 6160312);
            Modifier var155 = (Modifier)Modifier.Companion;
            int var65 = 12;
            int var109 = 0;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(var155, Dp.constructor-impl((float)var65)), $composer, 6);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-823901237);
            $composer.endReplaceGroup();
         }

         String var66 = LoginScreen$lambda$16($email$delegate);
         Modifier var110 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var96 = 12;
         var41 = 0;
         RoundedCornerShape var120 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var96));
         String var156 = var66;
         ComposerKt.sourceInformationMarkerStart($composer, -1827424763, "CC(remember):MainActivity.kt#9igjgp");
         var42 = 0;
         int var127 = 0;
         Object var132 = $composer.rememberedValue();
         int var137 = 0;
         Object var172;
         if (var132 == Composer.Companion.getEmpty()) {
            int var141 = 0;
            Function1 var171 = MainActivityKt::LoginScreen$lambda$43$lambda$42$lambda$41$lambda$30$lambda$29;
            var156 = var66;
            Object var145 = var171;
            $composer.updateRememberedValue(var145);
            var172 = var145;
         } else {
            var172 = var132;
         }

         Function1 var97 = (Function1)var172;
         ComposerKt.sourceInformationMarkerEnd($composer);
         OutlinedTextFieldKt.OutlinedTextField(var156, var97, var110, false, false, (TextStyle)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$2078831761$app(), (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, false, (VisualTransformation)null, (KeyboardOptions)null, (KeyboardActions)null, true, 0, 0, (MutableInteractionSource)null, (Shape)var120, (TextFieldColors)null, $composer, 1573296, 12582912, 0, 6160312);
         Modifier var157 = (Modifier)Modifier.Companion;
         int var67 = 12;
         int var111 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var157, Dp.constructor-impl((float)var67)), $composer, 6);
         String var68 = LoginScreen$lambda$19($password$delegate);
         KeyboardOptions var112 = new KeyboardOptions(0, (Boolean)null, KeyboardType.Companion.getPassword-PjHm6EE(), 0, (PlatformImeOptions)null, (Boolean)null, (LocaleList)null, 123, (DefaultConstructorMarker)null);
         Modifier var121 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var41 = 12;
         var42 = 0;
         RoundedCornerShape var98 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var41));
         String var158 = var68;
         ComposerKt.sourceInformationMarkerStart($composer, -1827412024, "CC(remember):MainActivity.kt#9igjgp");
         var127 = 0;
         int var133 = 0;
         Object var138 = $composer.rememberedValue();
         int var142 = 0;
         if (var138 == Composer.Companion.getEmpty()) {
            int var146 = 0;
            Function1 var173 = MainActivityKt::LoginScreen$lambda$43$lambda$42$lambda$41$lambda$32$lambda$31;
            var158 = var68;
            Object var56 = var173;
            $composer.updateRememberedValue(var56);
            var172 = var56;
         } else {
            var172 = var138;
         }

         Function1 var82 = (Function1)var172;
         ComposerKt.sourceInformationMarkerEnd($composer);
         OutlinedTextFieldKt.OutlinedTextField(var158, var82, var121, false, false, (TextStyle)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1702114632$app(), (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, false, (VisualTransformation)null, var112, (KeyboardActions)null, true, 0, 0, (MutableInteractionSource)null, (Shape)var98, (TextFieldColors)null, $composer, 1573296, 12779520, 0, 6127544);
         Modifier var159 = (Modifier)Modifier.Companion;
         int var69 = 24;
         int var113 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var159, Dp.constructor-impl((float)var69)), $composer, 6);
         ButtonColors var70 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(ColorKt.getIndigo600(), 0L, 0L, 0L, $composer, 6 | ButtonDefaults.$stable << 12, 14);
         int var122 = 12;
         int var99 = 0;
         RoundedCornerShape var114 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var122));
         var159 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var99 = 50;
         int var83 = 0;
         Modifier var123 = SizeKt.height-3ABfNKs(var159, Dp.constructor-impl((float)var99));
         ComposerKt.sourceInformationMarkerStart($composer, -1827397608, "CC(remember):MainActivity.kt#9igjgp");
         var42 = $composer.changedInstance($authViewModel);
         var127 = 0;
         Object var134 = $composer.rememberedValue();
         int var139 = 0;
         Object var161;
         if (!var42 && var134 != Composer.Companion.getEmpty()) {
            var161 = var134;
         } else {
            var142 = 0;
            Object var147 = MainActivityKt::LoginScreen$lambda$43$lambda$42$lambda$41$lambda$34$lambda$33;
            $composer.updateRememberedValue(var147);
            var161 = var147;
         }

         Function0 var101 = (Function0)var161;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.Button(var101, var123, false, (Shape)var114, var70, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-660989081, true, MainActivityKt::LoginScreen$lambda$43$lambda$42$lambda$41$lambda$35, $composer, 54), $composer, 805306416, 484);
         Modifier var162 = (Modifier)Modifier.Companion;
         int var71 = 16;
         int var115 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var162, Dp.constructor-impl((float)var71)), $composer, 6);
         ButtonColors var72 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.05F, 0.0F, 0.0F, 0.0F, 14, (Object)null), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0L, 0L, $composer, ButtonDefaults.$stable << 12, 12);
         int var124 = 12;
         int var102 = 0;
         RoundedCornerShape var116 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var124));
         var162 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var102 = 50;
         var83 = 0;
         Modifier var125 = SizeKt.height-3ABfNKs(var162, Dp.constructor-impl((float)var102));
         ComposerKt.sourceInformationMarkerStart($composer, -1827368567, "CC(remember):MainActivity.kt#9igjgp");
         var42 = $composer.changedInstance($authViewModel) | $composer.changedInstance($launcher);
         var127 = 0;
         var134 = $composer.rememberedValue();
         var139 = 0;
         Object var164;
         if (!var42 && var134 != Composer.Companion.getEmpty()) {
            var164 = var134;
         } else {
            var142 = 0;
            Object var148 = MainActivityKt::LoginScreen$lambda$43$lambda$42$lambda$41$lambda$37$lambda$36;
            $composer.updateRememberedValue(var148);
            var164 = var148;
         }

         Function0 var104 = (Function0)var164;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.Button(var104, var125, false, (Shape)var116, var72, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1549237918$app(), $composer, 805306416, 484);
         Modifier var165 = (Modifier)Modifier.Companion;
         int var73 = 16;
         int var117 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var165, Dp.constructor-impl((float)var73)), $composer, 6);
         ComposerKt.sourceInformationMarkerStart($composer, -1827333829, "CC(remember):MainActivity.kt#9igjgp");
         boolean var126 = false;
         int var105 = 0;
         Object var85 = $composer.rememberedValue();
         var42 = 0;
         Object var166;
         if (var85 == Composer.Companion.getEmpty()) {
            var127 = 0;
            var134 = MainActivityKt::LoginScreen$lambda$43$lambda$42$lambda$41$lambda$39$lambda$38;
            $composer.updateRememberedValue(var134);
            var166 = var134;
         } else {
            var166 = var85;
         }

         Function0 var74 = (Function0)var166;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.TextButton(var74, (Modifier)null, false, (Shape)null, (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, (Function3)ComposableLambdaKt.rememberComposableLambda(1974092212, true, MainActivityKt::LoginScreen$lambda$43$lambda$42$lambda$41$lambda$40, $composer, 54), $composer, 805306374, 510);
         if (LoginScreen$lambda$11($authState$delegate) instanceof AuthState.Loading) {
            $composer.startReplaceGroup(-812389511);
            ComposerKt.sourceInformation($composer, "286@11621L41,287@11683L44");
            Modifier var167 = (Modifier)Modifier.Companion;
            int var75 = 16;
            var117 = 0;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(var167, Dp.constructor-impl((float)var75)), $composer, 6);
            ProgressIndicatorKt.CircularProgressIndicator-LxG7B9w((Modifier)null, ColorKt.getIndigo600(), 0.0F, 0L, 0, $composer, 48, 29);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-823901237);
            $composer.endReplaceGroup();
         }

         if (LoginScreen$lambda$11($authState$delegate) instanceof AuthState.Error) {
            $composer.startReplaceGroup(-812187143);
            ComposerKt.sourceInformation($composer, "291@11819L41,292@11881L236");
            Modifier var168 = (Modifier)Modifier.Companion;
            int var76 = 16;
            var117 = 0;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(var168, Dp.constructor-impl((float)var76)), $composer, 6);
            AuthState var169 = LoginScreen$lambda$11($authState$delegate);
            Intrinsics.checkNotNull(var169, "null cannot be cast to non-null type com.example.auth.AuthState.Error");
            TextKt.Text--4IGK_g(((AuthState.Error)var169).getMessage(), (Modifier)null, Color.Companion.getRed-0d7_KjU(), TextUnitKt.getSp(14), (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3456, 0, 130546);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-823901237);
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

   private static final Unit LoginScreen$lambda$44(NavHostController $navController, AuthViewModel $authViewModel, int $$changed, Composer $composer, int $force) {
      LoginScreen($navController, $authViewModel, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final NavBackStackEntry MainDashboardScreen$lambda$45(State $navBackStackEntry$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (NavBackStackEntry)$navBackStackEntry$delegate.getValue();
   }

   private static final String MainDashboardScreen$lambda$47(MutableState $highlightedTaskId$delegate) {
      State var1 = (State)$highlightedTaskId$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)var1.getValue();
   }

   private static final void MainDashboardScreen$lambda$48(MutableState $highlightedTaskId$delegate, String var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $highlightedTaskId$delegate.setValue(var1);
   }

   private static final boolean MainDashboardScreen$lambda$51(MutableState $showAddTaskDialog$delegate) {
      State var1 = (State)$showAddTaskDialog$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void MainDashboardScreen$lambda$52(MutableState $showAddTaskDialog$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $showAddTaskDialog$delegate.setValue(var5);
   }

   private static final Integer MainDashboardScreen$lambda$54(MutableState $prefilledHourForNewTask$delegate) {
      State var1 = (State)$prefilledHourForNewTask$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Integer)var1.getValue();
   }

   private static final void MainDashboardScreen$lambda$55(MutableState $prefilledHourForNewTask$delegate, Integer var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $prefilledHourForNewTask$delegate.setValue(var1);
   }

   private static final TaskEntity MainDashboardScreen$lambda$57(MutableState $editingTask$delegate) {
      State var1 = (State)$editingTask$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (TaskEntity)var1.getValue();
   }

   private static final void MainDashboardScreen$lambda$58(MutableState $editingTask$delegate, TaskEntity var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $editingTask$delegate.setValue(var1);
   }

   private static final CalendarEvent MainDashboardScreen$lambda$60(MutableState $editingGoogleEvent$delegate) {
      State var1 = (State)$editingGoogleEvent$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (CalendarEvent)var1.getValue();
   }

   private static final void MainDashboardScreen$lambda$61(MutableState $editingGoogleEvent$delegate, CalendarEvent var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $editingGoogleEvent$delegate.setValue(var1);
   }

   private static final TaskEntity MainDashboardScreen$lambda$63(MutableState $selectedTask$delegate) {
      State var1 = (State)$selectedTask$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (TaskEntity)var1.getValue();
   }

   private static final void MainDashboardScreen$lambda$64(MutableState $selectedTask$delegate, TaskEntity var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $selectedTask$delegate.setValue(var1);
   }

   private static final Unit MainDashboardScreen$lambda$69$lambda$68$lambda$67$lambda$66$lambda$65(PopUpToBuilder $this$popUpTo) {
      Intrinsics.checkNotNullParameter($this$popUpTo, "$this$popUpTo");
      $this$popUpTo.setSaveState(true);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$69$lambda$68$lambda$67$lambda$66(NavHostController $bottomNavController, NavOptionsBuilder $this$navigate) {
      Intrinsics.checkNotNullParameter($this$navigate, "$this$navigate");
      $this$navigate.popUpTo($bottomNavController.getGraph().getStartDestinationId(), MainActivityKt::MainDashboardScreen$lambda$69$lambda$68$lambda$67$lambda$66$lambda$65);
      $this$navigate.setLaunchSingleTop(true);
      $this$navigate.setRestoreState(true);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$69$lambda$68$lambda$67(NavHostController $bottomNavController, String route) {
      Intrinsics.checkNotNullParameter(route, "route");
      $bottomNavController.navigate(route, MainActivityKt::MainDashboardScreen$lambda$69$lambda$68$lambda$67$lambda$66);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit MainDashboardScreen$lambda$69(String $currentRoute, NavHostController $bottomNavController, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C338@13517L274,338@13490L301:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1621868438, $changed, -1, "com.example.MainDashboardScreen.<anonymous> (MainActivity.kt:338)");
         }

         String var10000 = $currentRoute;
         ComposerKt.sourceInformationMarkerStart($composer, -457557944, "CC(remember):MainActivity.kt#9igjgp");
         boolean var6 = $composer.changedInstance($bottomNavController);
         int var7 = 0;
         Object var8 = $composer.rememberedValue();
         int var9 = 0;
         Object var13;
         if (!var6 && var8 != Composer.Companion.getEmpty()) {
            var13 = var8;
         } else {
            int var10 = 0;
            Function1 var10001 = MainActivityKt::MainDashboardScreen$lambda$69$lambda$68$lambda$67;
            var10000 = $currentRoute;
            Object var11 = var10001;
            $composer.updateRememberedValue(var11);
            var13 = var11;
         }

         Function1 var4 = (Function1)var13;
         ComposerKt.sourceInformationMarkerEnd($composer);
         BottomNavBar(var10000, var4, $composer, 0);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$72$lambda$71$lambda$70(MutableState $prefilledHourForNewTask$delegate, MutableState $showAddTaskDialog$delegate) {
      MainDashboardScreen$lambda$55($prefilledHourForNewTask$delegate, (Integer)null);
      MainDashboardScreen$lambda$52($showAddTaskDialog$delegate, true);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit MainDashboardScreen$lambda$72(String $currentRoute, MutableState $prefilledHourForNewTask$delegate, MutableState $showAddTaskDialog$delegate, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(583283864, $changed, -1, "com.example.MainDashboardScreen.<anonymous> (MainActivity.kt:347)");
         }

         if (Intrinsics.areEqual($currentRoute, "home")) {
            $composer.startReplaceGroup(-828027794);
            ComposerKt.sourceInformation($composer, "349@13946L127,348@13894L540");
            long var5 = ColorKt.getIndigo600();
            long var7 = Color.Companion.getWhite-0d7_KjU();
            int var10 = 16;
            int var11 = 0;
            RoundedCornerShape var9 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var10));
            Modifier var10000 = (Modifier)Modifier.Companion;
            var11 = 56;
            int var12 = 0;
            Modifier var19 = SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var11));
            ComposerKt.sourceInformationMarkerStart($composer, -2104918761, "CC(remember):MainActivity.kt#9igjgp");
            boolean var13 = false;
            int var14 = 0;
            Object var15 = $composer.rememberedValue();
            int var16 = 0;
            Object var22;
            if (var15 == Composer.Companion.getEmpty()) {
               int var17 = 0;
               Object var18 = MainActivityKt::MainDashboardScreen$lambda$72$lambda$71$lambda$70;
               $composer.updateRememberedValue(var18);
               var22 = var18;
            } else {
               var22 = var15;
            }

            Function0 var21 = (Function0)var22;
            ComposerKt.sourceInformationMarkerEnd($composer);
            FloatingActionButtonKt.FloatingActionButton-X-z6DiA(var21, var19, (Shape)var9, var5, var7, (FloatingActionButtonElevation)null, (MutableInteractionSource)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$177959605$app(), $composer, 12610614, 96);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-841811510);
            $composer.endReplaceGroup();
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$74$lambda$73(MutableState $selectedTask$delegate, TaskEntity task) {
      Intrinsics.checkNotNullParameter(task, "task");
      MainDashboardScreen$lambda$64($selectedTask$delegate, task);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$76$lambda$75(MutableState $editingTask$delegate, TaskEntity task) {
      Intrinsics.checkNotNullParameter(task, "task");
      MainDashboardScreen$lambda$58($editingTask$delegate, task);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$78$lambda$77(CalendarSyncViewModel $syncViewModel, AuthManager $authManager, PlannerViewModel $viewModel, TaskEntity task) {
      Intrinsics.checkNotNullParameter(task, "task");
      $syncViewModel.pushTaskToCalendar(task, $authManager, $viewModel);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$80$lambda$79(CalendarSyncViewModel $syncViewModel, AuthManager $authManager, PlannerViewModel $viewModel, TaskEntity task) {
      Intrinsics.checkNotNullParameter(task, "task");
      $syncViewModel.deleteTask(task, $authManager, $viewModel);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$82$lambda$81(MutableState $prefilledHourForNewTask$delegate, MutableState $showAddTaskDialog$delegate, int hour) {
      MainDashboardScreen$lambda$55($prefilledHourForNewTask$delegate, hour);
      MainDashboardScreen$lambda$52($showAddTaskDialog$delegate, true);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$84$lambda$83(MutableState $editingGoogleEvent$delegate, CalendarEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      MainDashboardScreen$lambda$61($editingGoogleEvent$delegate, event);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$86$lambda$85(CalendarSyncViewModel $syncViewModel, AuthManager $authManager, CalendarEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      $syncViewModel.deleteGoogleEvent(event, $authManager);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87(PlannerViewModel $viewModel, CalendarSyncViewModel $syncViewModel, AuthManager $authManager, MutableState $selectedTask$delegate, MutableState $editingTask$delegate, MutableState $prefilledHourForNewTask$delegate, MutableState $showAddTaskDialog$delegate, MutableState $editingGoogleEvent$delegate, MutableState $highlightedTaskId$delegate, AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
      Intrinsics.checkNotNullParameter(it, "it");
      ComposerKt.sourceInformation($composer, "C372@14860L31,373@14926L30,374@14994L118,377@15149L110,380@15300L135,384@15477L39,385@15560L108,369@14717L1028:MainActivity.kt#to5c3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(486455261, $changed, -1, "com.example.MainDashboardScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:369)");
      }

      PlannerViewModel var10000 = $viewModel;
      CalendarSyncViewModel var10001 = $syncViewModel;
      ComposerKt.sourceInformationMarkerStart($composer, -667924260, "CC(remember):MainActivity.kt#9igjgp");
      boolean var15 = false;
      int var16 = 0;
      Object var17 = $composer.rememberedValue();
      int var18 = 0;
      Object var10002;
      if (var17 == Composer.Companion.getEmpty()) {
         int var19 = 0;
         Function1 var20_1 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$74$lambda$73;
         var10000 = $viewModel;
         var10001 = $syncViewModel;
         $composer.updateRememberedValue(var20_1);
         var10002 = var20_1;
      } else {
         var10002 = var17;
      }

      Function1 var13 = (Function1)var10002;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function1 var91 = var13;
      ComposerKt.sourceInformationMarkerStart($composer, -667922149, "CC(remember):MainActivity.kt#9igjgp");
      var15 = false;
      var16 = 0;
      var17 = $composer.rememberedValue();
      var18 = 0;
      Object var10003;
      if (var17 == Composer.Companion.getEmpty()) {
         CalendarSyncViewModel var22 = var10001;
         PlannerViewModel var21 = var10000;
         int var60 = 0;
         Function1 var20_4 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$76$lambda$75;
         var10000 = var21;
         var10001 = var22;
         var91 = var13;
         $composer.updateRememberedValue(var20_4);
         var10003 = var20_4;
      } else {
         var10003 = var17;
      }

      var13 = (Function1)var10003;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function1 var92 = var13;
      ComposerKt.sourceInformationMarkerStart($composer, -667919885, "CC(remember):MainActivity.kt#9igjgp");
      var15 = $composer.changedInstance($syncViewModel) | $composer.changedInstance($authManager) | $composer.changedInstance($viewModel);
      var16 = 0;
      var17 = $composer.rememberedValue();
      var18 = 0;
      Object var10004;
      if (!var15 && var17 != Composer.Companion.getEmpty()) {
         var10004 = var17;
      } else {
         Function1 var20_1 = var91;
         CalendarSyncViewModel var71 = var10001;
         PlannerViewModel var66 = var10000;
         int var61 = 0;
         Function1 var20_7 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$78$lambda$77;
         var10000 = var66;
         var10001 = var71;
         var91 = var20_1;
         var92 = var13;
         $composer.updateRememberedValue(var20_7);
         var10004 = var20_7;
      }

      var13 = (Function1)var10004;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function1 var93 = var13;
      ComposerKt.sourceInformationMarkerStart($composer, -667914933, "CC(remember):MainActivity.kt#9igjgp");
      var15 = $composer.changedInstance($syncViewModel) | $composer.changedInstance($authManager) | $composer.changedInstance($viewModel);
      var16 = 0;
      var17 = $composer.rememberedValue();
      var18 = 0;
      Object var10005;
      if (!var15 && var17 != Composer.Companion.getEmpty()) {
         var10005 = var17;
      } else {
         Function1 var20_4 = var92;
         Function1 var20_1 = var91;
         CalendarSyncViewModel var72 = var10001;
         PlannerViewModel var67 = var10000;
         int var62 = 0;
         Function1 var20_10 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$80$lambda$79;
         var10000 = var67;
         var10001 = var72;
         var91 = var20_1;
         var92 = var20_4;
         var93 = var13;
         $composer.updateRememberedValue(var20_10);
         var10005 = var20_10;
      }

      var13 = (Function1)var10005;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function1 var94 = var13;
      ComposerKt.sourceInformationMarkerStart($composer, -667910076, "CC(remember):MainActivity.kt#9igjgp");
      var15 = false;
      var16 = 0;
      var17 = $composer.rememberedValue();
      var18 = 0;
      Object var10006;
      if (var17 == Composer.Companion.getEmpty()) {
         Function1 var20_7 = var93;
         Function1 var20_4 = var92;
         Function1 var20_1 = var91;
         CalendarSyncViewModel var73 = var10001;
         PlannerViewModel var68 = var10000;
         int var63 = 0;
         Function1 var20_13 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$82$lambda$81;
         var10000 = var68;
         var10001 = var73;
         var91 = var20_1;
         var92 = var20_4;
         var93 = var20_7;
         var94 = var13;
         $composer.updateRememberedValue(var20_13);
         var10006 = var20_13;
      } else {
         var10006 = var17;
      }

      var13 = (Function1)var10006;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function1 var95 = var13;
      ComposerKt.sourceInformationMarkerStart($composer, -667904508, "CC(remember):MainActivity.kt#9igjgp");
      var15 = false;
      var16 = 0;
      var17 = $composer.rememberedValue();
      var18 = 0;
      Object var10007;
      if (var17 == Composer.Companion.getEmpty()) {
         Function1 var20_10 = var94;
         Function1 var20_7 = var93;
         Function1 var20_4 = var92;
         Function1 var20_1 = var91;
         CalendarSyncViewModel var74 = var10001;
         PlannerViewModel var69 = var10000;
         int var64 = 0;
         Function1 var20_16 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$84$lambda$83;
         var10000 = var69;
         var10001 = var74;
         var91 = var20_1;
         var92 = var20_4;
         var93 = var20_7;
         var94 = var20_10;
         var95 = var13;
         $composer.updateRememberedValue(var20_16);
         var10007 = var20_16;
      } else {
         var10007 = var17;
      }

      var13 = (Function1)var10007;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function1 var96 = var13;
      ComposerKt.sourceInformationMarkerStart($composer, -667901783, "CC(remember):MainActivity.kt#9igjgp");
      var15 = $composer.changedInstance($syncViewModel) | $composer.changedInstance($authManager);
      var16 = 0;
      var17 = $composer.rememberedValue();
      var18 = 0;
      Object var10008;
      if (!var15 && var17 != Composer.Companion.getEmpty()) {
         var10008 = var17;
      } else {
         Function1 var20_13 = var95;
         Function1 var20_10 = var94;
         Function1 var20_7 = var93;
         Function1 var20_4 = var92;
         Function1 var20_1 = var91;
         CalendarSyncViewModel var75 = var10001;
         PlannerViewModel var70 = var10000;
         int var65 = 0;
         Function1 var20_19 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87$lambda$86$lambda$85;
         var10000 = var70;
         var10001 = var75;
         var91 = var20_1;
         var92 = var20_4;
         var93 = var20_7;
         var94 = var20_10;
         var95 = var20_13;
         var96 = var13;
         $composer.updateRememberedValue(var20_19);
         var10008 = var20_19;
      }

      var13 = (Function1)var10008;
      ComposerKt.sourceInformationMarkerEnd($composer);
      PlannerScreen(var10000, var10001, var91, var92, var93, var94, var95, var96, var13, MainDashboardScreen$lambda$47($highlightedTaskId$delegate), $composer, 14159232);
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$88(NotesViewModel $notesViewModel, PlannerViewModel $viewModel, CalendarSyncViewModel $syncViewModel, AuthManager $authManager, AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
      Intrinsics.checkNotNullParameter(it, "it");
      ComposerKt.sourceInformation($composer, "C392@15810L225:MainActivity.kt#to5c3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(1975968134, $changed, -1, "com.example.MainDashboardScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:392)");
      }

      OtherScreensKt.NotesScreen($notesViewModel, $viewModel, $syncViewModel, $authManager, $composer, 0);
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$90$lambda$89(MutableState $selectedTask$delegate, TaskEntity task) {
      Intrinsics.checkNotNullParameter(task, "task");
      MainDashboardScreen$lambda$64($selectedTask$delegate, task);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$92$lambda$91(MutableState $editingTask$delegate, TaskEntity task) {
      Intrinsics.checkNotNullParameter(task, "task");
      MainDashboardScreen$lambda$58($editingTask$delegate, task);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$94$lambda$93(CalendarSyncViewModel $syncViewModel, AuthManager $authManager, PlannerViewModel $viewModel, TaskEntity task) {
      Intrinsics.checkNotNullParameter(task, "task");
      $syncViewModel.deleteTask(task, $authManager, $viewModel);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$96$lambda$95(CalendarSyncViewModel $syncViewModel, AuthManager $authManager, PlannerViewModel $viewModel, TaskEntity task) {
      Intrinsics.checkNotNullParameter(task, "task");
      $syncViewModel.pushTaskToCalendar(task, $authManager, $viewModel);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$98$lambda$97(PlannerViewModel $viewModel, AuthManager $authManager, CalendarSyncViewModel $syncViewModel, SubTaskEntity subTask, boolean isChecked) {
      Intrinsics.checkNotNullParameter(subTask, "subTask");
      $viewModel.toggleSubTaskCompletion(subTask, isChecked, $authManager, $syncViewModel);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$100$lambda$99(MutableState $editingGoogleEvent$delegate, CalendarEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      MainDashboardScreen$lambda$61($editingGoogleEvent$delegate, event);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$104$lambda$103$lambda$102$lambda$101(PopUpToBuilder $this$popUpTo) {
      Intrinsics.checkNotNullParameter($this$popUpTo, "$this$popUpTo");
      $this$popUpTo.setSaveState(true);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$104$lambda$103$lambda$102(NavHostController $bottomNavController, NavOptionsBuilder $this$navigate) {
      Intrinsics.checkNotNullParameter($this$navigate, "$this$navigate");
      $this$navigate.popUpTo($bottomNavController.getGraph().getStartDestinationId(), MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$104$lambda$103$lambda$102$lambda$101);
      $this$navigate.setLaunchSingleTop(true);
      $this$navigate.setRestoreState(true);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$104$lambda$103(NavHostController $bottomNavController, MutableState $highlightedTaskId$delegate, String id) {
      Intrinsics.checkNotNullParameter(id, "id");
      MainDashboardScreen$lambda$48($highlightedTaskId$delegate, id);
      $bottomNavController.navigate("home", MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$104$lambda$103$lambda$102);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105(PlannerViewModel $viewModel, CalendarSyncViewModel $syncViewModel, AuthManager $authManager, NavHostController $bottomNavController, MutableState $selectedTask$delegate, MutableState $editingTask$delegate, MutableState $editingGoogleEvent$delegate, MutableState $highlightedTaskId$delegate, AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
      Intrinsics.checkNotNullParameter(it, "it");
      ComposerKt.sourceInformation($composer, "C403@16239L31,404@16305L30,405@16372L110,408@16523L118,411@16689L151,414@16882L39,415@16961L367,400@16099L1247:MainActivity.kt#to5c3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(-608348315, $changed, -1, "com.example.MainDashboardScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:400)");
      }

      PlannerViewModel var10000 = $viewModel;
      CalendarSyncViewModel var10001 = $syncViewModel;
      ComposerKt.sourceInformationMarkerStart($composer, -507173372, "CC(remember):MainActivity.kt#9igjgp");
      boolean var14 = false;
      int var15 = 0;
      Object var16 = $composer.rememberedValue();
      int var17 = 0;
      Object var10002;
      if (var16 == Composer.Companion.getEmpty()) {
         int var18 = 0;
         Function1 var19_1 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$90$lambda$89;
         var10000 = $viewModel;
         var10001 = $syncViewModel;
         $composer.updateRememberedValue(var19_1);
         var10002 = var19_1;
      } else {
         var10002 = var16;
      }

      Function1 var12 = (Function1)var10002;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function1 var90 = var12;
      ComposerKt.sourceInformationMarkerStart($composer, -507171261, "CC(remember):MainActivity.kt#9igjgp");
      var14 = false;
      var15 = 0;
      var16 = $composer.rememberedValue();
      var17 = 0;
      Object var10003;
      if (var16 == Composer.Companion.getEmpty()) {
         CalendarSyncViewModel var21 = var10001;
         PlannerViewModel var20 = var10000;
         int var59 = 0;
         Function1 var19_4 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$92$lambda$91;
         var10000 = var20;
         var10001 = var21;
         var90 = var12;
         $composer.updateRememberedValue(var19_4);
         var10003 = var19_4;
      } else {
         var10003 = var16;
      }

      var12 = (Function1)var10003;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function1 var91 = var12;
      ComposerKt.sourceInformationMarkerStart($composer, -507169037, "CC(remember):MainActivity.kt#9igjgp");
      var14 = $composer.changedInstance($syncViewModel) | $composer.changedInstance($authManager) | $composer.changedInstance($viewModel);
      var15 = 0;
      var16 = $composer.rememberedValue();
      var17 = 0;
      Object var10004;
      if (!var14 && var16 != Composer.Companion.getEmpty()) {
         var10004 = var16;
      } else {
         Function1 var19_1 = var90;
         CalendarSyncViewModel var70 = var10001;
         PlannerViewModel var65 = var10000;
         int var60 = 0;
         Function1 var19_7 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$94$lambda$93;
         var10000 = var65;
         var10001 = var70;
         var90 = var19_1;
         var91 = var12;
         $composer.updateRememberedValue(var19_7);
         var10004 = var19_7;
      }

      var12 = (Function1)var10004;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function1 var92 = var12;
      ComposerKt.sourceInformationMarkerStart($composer, -507164197, "CC(remember):MainActivity.kt#9igjgp");
      var14 = $composer.changedInstance($syncViewModel) | $composer.changedInstance($authManager) | $composer.changedInstance($viewModel);
      var15 = 0;
      var16 = $composer.rememberedValue();
      var17 = 0;
      Object var10005;
      if (!var14 && var16 != Composer.Companion.getEmpty()) {
         var10005 = var16;
      } else {
         Function1 var19_4 = var91;
         Function1 var19_1 = var90;
         CalendarSyncViewModel var71 = var10001;
         PlannerViewModel var66 = var10000;
         int var61 = 0;
         Function1 var19_10 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$96$lambda$95;
         var10000 = var66;
         var10001 = var71;
         var90 = var19_1;
         var91 = var19_4;
         var92 = var12;
         $composer.updateRememberedValue(var19_10);
         var10005 = var19_10;
      }

      var12 = (Function1)var10005;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function1 var93 = var12;
      ComposerKt.sourceInformationMarkerStart($composer, -507158852, "CC(remember):MainActivity.kt#9igjgp");
      var14 = $composer.changedInstance($viewModel) | $composer.changedInstance($authManager) | $composer.changedInstance($syncViewModel);
      var15 = 0;
      var16 = $composer.rememberedValue();
      var17 = 0;
      Object var10006;
      if (!var14 && var16 != Composer.Companion.getEmpty()) {
         var10006 = var16;
      } else {
         Function1 var19_7 = var92;
         Function1 var19_4 = var91;
         Function1 var19_1 = var90;
         CalendarSyncViewModel var72 = var10001;
         PlannerViewModel var67 = var10000;
         int var62 = 0;
         Function2 var19_13 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$98$lambda$97;
         var10000 = var67;
         var10001 = var72;
         var90 = var19_1;
         var91 = var19_4;
         var92 = var19_7;
         var93 = var12;
         $composer.updateRememberedValue(var19_13);
         var10006 = var19_13;
      }

      Function2 var32 = (Function2)var10006;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function2 var94 = var32;
      ComposerKt.sourceInformationMarkerStart($composer, -507152788, "CC(remember):MainActivity.kt#9igjgp");
      var14 = false;
      var15 = 0;
      var16 = $composer.rememberedValue();
      var17 = 0;
      Object var10007;
      if (var16 == Composer.Companion.getEmpty()) {
         Function1 var19_10 = var93;
         Function1 var19_7 = var92;
         Function1 var19_4 = var91;
         Function1 var19_1 = var90;
         CalendarSyncViewModel var73 = var10001;
         PlannerViewModel var68 = var10000;
         int var63 = 0;
         Function1 var19_16 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$100$lambda$99;
         var10000 = var68;
         var10001 = var73;
         var90 = var19_1;
         var91 = var19_4;
         var92 = var19_7;
         var93 = var19_10;
         var94 = var32;
         $composer.updateRememberedValue(var19_16);
         var10007 = var19_16;
      } else {
         var10007 = var16;
      }

      Function1 var33 = (Function1)var10007;
      ComposerKt.sourceInformationMarkerEnd($composer);
      Function1 var95 = var33;
      ComposerKt.sourceInformationMarkerStart($composer, -507149932, "CC(remember):MainActivity.kt#9igjgp");
      var14 = $composer.changedInstance($bottomNavController);
      var15 = 0;
      var16 = $composer.rememberedValue();
      var17 = 0;
      Object var10008;
      if (!var14 && var16 != Composer.Companion.getEmpty()) {
         var10008 = var16;
      } else {
         Function2 var19_13 = var94;
         Function1 var19_10 = var93;
         Function1 var19_7 = var92;
         Function1 var19_4 = var91;
         Function1 var19_1 = var90;
         CalendarSyncViewModel var74 = var10001;
         PlannerViewModel var69 = var10000;
         int var64 = 0;
         Function1 var19_19 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105$lambda$104$lambda$103;
         var10000 = var69;
         var10001 = var74;
         var90 = var19_1;
         var91 = var19_4;
         var92 = var19_7;
         var93 = var19_10;
         var94 = var19_13;
         var95 = var33;
         $composer.updateRememberedValue(var19_19);
         var10008 = var19_19;
      }

      var33 = (Function1)var10008;
      ComposerKt.sourceInformationMarkerEnd($composer);
      PlanScreenKt.PlanScreen(var10000, var10001, var90, var91, var92, var93, var94, var95, var33, $composer, 12586368);
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$106(Function0 $onSignOut, SettingsViewModel $settingsViewModel, CalendarSyncViewModel $syncViewModel, AuthManager $authManager, AnimatedContentScope $this$composable, NavBackStackEntry it, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$composable, "$this$composable");
      Intrinsics.checkNotNullParameter(it, "it");
      ComposerKt.sourceInformation($composer, "C426@17414L232:MainActivity.kt#to5c3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(1102302532, $changed, -1, "com.example.MainDashboardScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:426)");
      }

      OtherScreensKt.SettingsScreen($onSignOut, $settingsViewModel, $syncViewModel, $authManager, $composer, 0);
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$109$lambda$108$lambda$107(PlannerViewModel $viewModel, CalendarSyncViewModel $syncViewModel, AuthManager $authManager, MutableState $selectedTask$delegate, MutableState $editingTask$delegate, MutableState $prefilledHourForNewTask$delegate, MutableState $showAddTaskDialog$delegate, MutableState $editingGoogleEvent$delegate, MutableState $highlightedTaskId$delegate, NotesViewModel $notesViewModel, NavHostController $bottomNavController, Function0 $onSignOut, SettingsViewModel $settingsViewModel, NavGraphBuilder $this$NavHost) {
      Intrinsics.checkNotNullParameter($this$NavHost, "$this$NavHost");
      NavGraphBuilderKt.composable$default($this$NavHost, "home", (List)null, (List)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function4)ComposableLambdaKt.composableLambdaInstance(486455261, true, MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$87), 254, (Object)null);
      NavGraphBuilderKt.composable$default($this$NavHost, "notes", (List)null, (List)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function4)ComposableLambdaKt.composableLambdaInstance(1975968134, true, MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$88), 254, (Object)null);
      NavGraphBuilderKt.composable$default($this$NavHost, "sync", (List)null, (List)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function4)ComposableLambdaKt.composableLambdaInstance(-608348315, true, MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$105), 254, (Object)null);
      NavGraphBuilderKt.composable$default($this$NavHost, "settings", (List)null, (List)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function1)null, (Function4)ComposableLambdaKt.composableLambdaInstance(1102302532, true, MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107$lambda$106), 254, (Object)null);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit MainDashboardScreen$lambda$109(NavHostController $bottomNavController, PlannerViewModel $viewModel, CalendarSyncViewModel $syncViewModel, AuthManager $authManager, NotesViewModel $notesViewModel, Function0 $onSignOut, SettingsViewModel $settingsViewModel, MutableState $selectedTask$delegate, MutableState $editingTask$delegate, MutableState $prefilledHourForNewTask$delegate, MutableState $showAddTaskDialog$delegate, MutableState $editingGoogleEvent$delegate, MutableState $highlightedTaskId$delegate, PaddingValues innerPadding, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
      ComposerKt.sourceInformation($composer, "C367@14666L3004,363@14491L3179:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(innerPadding) ? 4 : 2);
      }

      if (($dirty & 19) == 18 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2016187040, $dirty, -1, "com.example.MainDashboardScreen.<anonymous> (MainActivity.kt:363)");
         }

         NavHostController var10000 = $bottomNavController;
         String var10001 = "home";
         Modifier var10002 = SizeKt.fillMaxSize$default(PaddingKt.padding((Modifier)Modifier.Companion, innerPadding), 0.0F, 1, (Object)null);
         Object var10003 = null;
         Object var10004 = null;
         Object var10005 = null;
         Object var10006 = null;
         Object var10007 = null;
         Object var10008 = null;
         Object var10009 = null;
         ComposerKt.sourceInformationMarkerStart($composer, -525485508, "CC(remember):MainActivity.kt#9igjgp");
         boolean var19 = $composer.changedInstance($viewModel) | $composer.changedInstance($syncViewModel) | $composer.changedInstance($authManager) | $composer.changedInstance($notesViewModel) | $composer.changedInstance($bottomNavController) | $composer.changed($onSignOut) | $composer.changedInstance($settingsViewModel);
         int var20 = 0;
         Object var21 = $composer.rememberedValue();
         int var22 = 0;
         Object var10010;
         if (!var19 && var21 != Composer.Companion.getEmpty()) {
            var10010 = var21;
         } else {
            Object var34 = null;
            Object var33 = null;
            Object var32 = null;
            Object var31 = null;
            Object var30 = null;
            Object var29 = null;
            Object var28 = null;
            Modifier var27 = var10002;
            String var26 = "home";
            int var23 = 0;
            Function1 var24_1 = MainActivityKt::MainDashboardScreen$lambda$109$lambda$108$lambda$107;
            var10000 = $bottomNavController;
            var10001 = var26;
            var10002 = var27;
            var10003 = var28;
            var10004 = var29;
            var10005 = var30;
            var10006 = var31;
            var10007 = var32;
            var10008 = var33;
            var10009 = var34;
            $composer.updateRememberedValue(var24_1);
            var10010 = var24_1;
         }

         Function1 var17 = (Function1)var10010;
         ComposerKt.sourceInformationMarkerEnd($composer);
         NavHostKt.NavHost(var10000, var10001, var10002, (Alignment)var10003, (String)var10004, (Function1)var10005, (Function1)var10006, (Function1)var10007, (Function1)var10008, (Function1)var10009, var17, $composer, 48, 0, 1016);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$111$lambda$110(MutableState $showAddTaskDialog$delegate) {
      MainDashboardScreen$lambda$52($showAddTaskDialog$delegate, false);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$114$lambda$113$lambda$112(PlannerViewModel $viewModel, List $subTasks, TaskEntity insertedTask) {
      Intrinsics.checkNotNullParameter(insertedTask, "insertedTask");
      $viewModel.saveSubTasksForParentDirectly("local_" + insertedTask.getId(), $subTasks);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$114$lambda$113(PlannerViewModel $viewModel, MutableState $showAddTaskDialog$delegate, String title, String desc, boolean isTimeBoxed, int hour, int minute, int duration, boolean hasReminder, int reminderMins, Long customReminderTime, List subTasks, boolean isAllTime, boolean isMeeting) {
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(desc, "desc");
      Intrinsics.checkNotNullParameter(subTasks, "subTasks");
      $viewModel.addTask(title, desc, isTimeBoxed, hour, minute, duration, isAllTime, hasReminder, reminderMins, customReminderTime, isMeeting, MainActivityKt::MainDashboardScreen$lambda$114$lambda$113$lambda$112);
      MainDashboardScreen$lambda$52($showAddTaskDialog$delegate, false);
      return Unit.INSTANCE;
   }

   private static final List MainDashboardScreen$lambda$125$lambda$116(MutableState $initialSubTasks$delegate) {
      State var1 = (State)$initialSubTasks$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)var1.getValue();
   }

   private static final void MainDashboardScreen$lambda$125$lambda$117(MutableState $initialSubTasks$delegate, List var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $initialSubTasks$delegate.setValue(var1);
   }

   private static final Unit MainDashboardScreen$lambda$125$lambda$120$lambda$119(MutableState $editingTask$delegate) {
      MainDashboardScreen$lambda$58($editingTask$delegate, (TaskEntity)null);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$125$lambda$122$lambda$121(CalendarSyncViewModel $syncViewModel, TaskEntity $task, AuthManager $authManager, PlannerViewModel $viewModel, MutableState $editingTask$delegate) {
      $syncViewModel.deleteTask($task, $authManager, $viewModel);
      MainDashboardScreen$lambda$58($editingTask$delegate, (TaskEntity)null);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$125$lambda$124$lambda$123(CoroutineScope $scope, final TaskEntity $task, final PlannerViewModel $viewModel, final CalendarSyncViewModel $syncViewModel, final AuthManager $authManager, MutableState $editingTask$delegate, final String title, final String desc, final boolean isTimeBoxed, int hour, int minute, int duration, final boolean hasReminder, final int reminderMins, final Long customReminderTime, final List subTasks, boolean isAllTime, final boolean isMeeting) {
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(desc, "desc");
      Intrinsics.checkNotNullParameter(subTasks, "subTasks");
      BuildersKt.launch$default($scope, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         Object L$0;
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            TaskEntity updatedTask;
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  Long var3 = hasReminder ? (isTimeBoxed && $task.getStartTime() != null ? Boxing.boxLong($task.getStartTime() - (long)reminderMins * 60000L) : customReminderTime) : null;
                  Integer var4 = isTimeBoxed ? Boxing.boxInt(reminderMins) : null;
                  updatedTask = TaskEntity.copy$default($task, 0, (String)null, title, desc, 0L, (Long)null, (Long)null, isTimeBoxed, false, hasReminder, var3, var4, (String)null, isMeeting, 0L, (Long)null, 53619, (Object)null);
                  PlannerViewModel var10000 = $viewModel;
                  Continuation var10002 = (Continuation)this;
                  this.L$0 = updatedTask;
                  this.label = 1;
                  if (var10000.updateTaskSuspend(updatedTask, var10002) == var5) {
                     return var5;
                  }
                  break;
               case 1:
                  updatedTask = (TaskEntity)this.L$0;
                  ResultKt.throwOnFailure($result);
                  break;
               default:
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            if (updatedTask.isTimeBoxed()) {
               $syncViewModel.pushTaskToCalendar(updatedTask, $authManager, $viewModel);
            }

            $viewModel.saveSubTasksForParentDirectly("local_" + $task.getId(), subTasks);
            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }, 3, (Object)null);
      MainDashboardScreen$lambda$58($editingTask$delegate, (TaskEntity)null);
      return Unit.INSTANCE;
   }

   private static final List MainDashboardScreen$lambda$137$lambda$127(MutableState $initialSubTasks$delegate) {
      State var1 = (State)$initialSubTasks$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)var1.getValue();
   }

   private static final void MainDashboardScreen$lambda$137$lambda$128(MutableState $initialSubTasks$delegate, List var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $initialSubTasks$delegate.setValue(var1);
   }

   private static final Unit MainDashboardScreen$lambda$137$lambda$132$lambda$131(MutableState $editingGoogleEvent$delegate) {
      MainDashboardScreen$lambda$61($editingGoogleEvent$delegate, (CalendarEvent)null);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$137$lambda$134$lambda$133(CalendarSyncViewModel $syncViewModel, CalendarEvent $event, AuthManager $authManager, MutableState $editingGoogleEvent$delegate) {
      $syncViewModel.deleteGoogleEvent($event, $authManager);
      MainDashboardScreen$lambda$61($editingGoogleEvent$delegate, (CalendarEvent)null);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$137$lambda$136$lambda$135(CoroutineScope $scope, final TaskEntity $placeholderTask, final CalendarSyncViewModel $syncViewModel, final AuthManager $authManager, final PlannerViewModel $viewModel, final CalendarEvent $event, MutableState $editingGoogleEvent$delegate, final String title, final String desc, boolean isTimeBoxed, int hour, int minute, int duration, boolean hasReminder, int reminderMins, Long customReminderTime, final List subTasks, boolean isAllTime, boolean isMeeting) {
      Intrinsics.checkNotNullParameter(title, "title");
      Intrinsics.checkNotNullParameter(desc, "desc");
      Intrinsics.checkNotNullParameter(subTasks, "subTasks");
      BuildersKt.launch$default($scope, (CoroutineContext)null, (CoroutineStart)null, new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
               case 0:
                  ResultKt.throwOnFailure($result);
                  TaskEntity updatedEventTask = TaskEntity.copy$default($placeholderTask, 0, (String)null, title, desc, 0L, (Long)null, (Long)null, false, false, false, (Long)null, (Integer)null, (String)null, false, 0L, (Long)null, 65523, (Object)null);
                  $syncViewModel.updateGoogleEvent(updatedEventTask, $authManager);
                  $viewModel.saveSubTasksForParentDirectly("google_" + $event.getId(), subTasks);
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
      }, 3, (Object)null);
      MainDashboardScreen$lambda$61($editingGoogleEvent$delegate, (CalendarEvent)null);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$142$lambda$139$lambda$138(MutableState $selectedTask$delegate) {
      MainDashboardScreen$lambda$64($selectedTask$delegate, (TaskEntity)null);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$142$lambda$141$lambda$140(CalendarSyncViewModel $syncViewModel, TaskEntity $task, AuthManager $authManager, PlannerViewModel $viewModel, MutableState $selectedTask$delegate, TaskEntity it) {
      Intrinsics.checkNotNullParameter(it, "it");
      $syncViewModel.deleteTask($task, $authManager, $viewModel);
      MainDashboardScreen$lambda$64($selectedTask$delegate, (TaskEntity)null);
      return Unit.INSTANCE;
   }

   private static final Unit MainDashboardScreen$lambda$143(SettingsViewModel $settingsViewModel, Function0 $onSignOut, int $$changed, Composer $composer, int $force) {
      MainDashboardScreen($settingsViewModel, $onSignOut, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final long PlannerScreen$lambda$144(State $selectedDate$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return ((Number)$selectedDate$delegate.getValue()).longValue();
   }

   private static final List PlannerScreen$lambda$145(State $scheduleTasks$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$scheduleTasks$delegate.getValue();
   }

   private static final List PlannerScreen$lambda$146(State $googleEvents$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$googleEvents$delegate.getValue();
   }

   private static final List PlannerScreen$lambda$147(State $todaysNotes$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$todaysNotes$delegate.getValue();
   }

   private static final Unit PlannerScreen$lambda$158$lambda$154$lambda$153(PlannerViewModel $viewModel, long it) {
      $viewModel.selectDate(it);
      return Unit.INSTANCE;
   }

   private static final Unit PlannerScreen$lambda$158$lambda$157$lambda$156$lambda$155(Function1 $onTaskDelete, Function1 $onGoogleEventDelete, TimelineItem item) {
      Intrinsics.checkNotNullParameter(item, "item");
      if (item instanceof TimelineItem.AppTaskItem) {
         $onTaskDelete.invoke(((TimelineItem.AppTaskItem)item).getTask());
      } else if (item instanceof TimelineItem.GoogleEventItem) {
         $onGoogleEventDelete.invoke(((TimelineItem.GoogleEventItem)item).getEvent());
      }

      return Unit.INSTANCE;
   }

   private static final Unit PlannerScreen$lambda$159(PlannerViewModel $viewModel, CalendarSyncViewModel $syncViewModel, Function1 $onTaskClick, Function1 $onTaskEdit, Function1 $onTaskCombine, Function1 $onTaskDelete, Function1 $onEmptyHourClick, Function1 $onGoogleEventEdit, Function1 $onGoogleEventDelete, String $highlightedTaskId, int $$changed, Composer $composer, int $force) {
      PlannerScreen($viewModel, $syncViewModel, $onTaskClick, $onTaskEdit, $onTaskCombine, $onTaskDelete, $onEmptyHourClick, $onGoogleEventEdit, $onGoogleEventDelete, $highlightedTaskId, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final void TopBar$lambda$168$lambda$164$lambda$163$lambda$162(Function1 $onDateChange, DatePicker var1, int year, int month, int dayOfMonth) {
      Calendar var7_1 = Calendar.getInstance();
      int var8 = 0;
      var7_1.set(1, year);
      var7_1.set(2, month);
      var7_1.set(5, dayOfMonth);
      $onDateChange.invoke(var7_1.getTimeInMillis());
   }

   private static final Unit TopBar$lambda$168$lambda$164$lambda$163(Context $context, Calendar $calendar, Function1 $onDateChange) {
      (new DatePickerDialog($context, MainActivityKt::TopBar$lambda$168$lambda$164$lambda$163$lambda$162, $calendar.get(1), $calendar.get(2), $calendar.get(5))).show();
      return Unit.INSTANCE;
   }

   private static final Unit TopBar$lambda$169(long $selectedDate, Function1 $onDateChange, int $$changed, Composer $composer, int $force) {
      TopBar($selectedDate, $onDateChange, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final Unit UpcomingPlansSection$lambda$185$lambda$184$lambda$183(List $closestPlans, Function1 $onTaskClick, Function1 $onGoogleEventClick, LazyListScope $this$LazyRow) {
      Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
      Function1 var6 = null;
      Function1 var7 = MainActivityKt$UpcomingPlansSection$lambda$185$lambda$184$lambda$183$$inlined$items$default$1.INSTANCE;
      int var8 = 0;
      $this$LazyRow.items($closestPlans.size(), (Function1)null, new MainActivityKt$UpcomingPlansSection$lambda$185$lambda$184$lambda$183$$inlined$items$default$3(var7, $closestPlans), (Function4)ComposableLambdaKt.composableLambdaInstance(-632812321, true, new MainActivityKt$UpcomingPlansSection$lambda$185$lambda$184$lambda$183$$inlined$items$default$4($closestPlans, $onTaskClick, $onGoogleEventClick)));
      return Unit.INSTANCE;
   }

   private static final Unit UpcomingPlansSection$lambda$186(List $tasks, List $googleEvents, Function1 $onTaskClick, Function1 $onGoogleEventClick, int $$changed, Composer $composer, int $force) {
      UpcomingPlansSection($tasks, $googleEvents, $onTaskClick, $onGoogleEventClick, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$195$lambda$194(Function1 $onEmptyHourClick, int $hour) {
      $onEmptyHourClick.invoke($hour);
      return Unit.INSTANCE;
   }

   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$197$lambda$196(boolean $isCurrentHour, DrawScope $this$drawBehind) {
      Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
      int var3 = 1;
      int var4 = 0;
      float stroke = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl((float)var3));
      long color = $isCurrentHour ? Color.copy-wmQWz5c$default(androidx.compose.ui.graphics.ColorKt.Color(4294913365L), 0.15F, 0.0F, 0.0F, 0.0F, 14, (Object)null) : Color.copy-wmQWz5c$default(Color.Companion.getGray-0d7_KjU(), 0.1F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
      long var5 = $this$drawBehind.getSize-NH-jbRc();
      float[] var8 = new float[]{10.0F, 10.0F};
      Stroke var7 = new Stroke(stroke, 0.0F, 0, 0, PathEffect.Companion.dashPathEffect(var8, 0.0F), 14, (DefaultConstructorMarker)null);
      int var10 = 12;
      int var11 = 0;
      long var13 = CornerRadiusKt.CornerRadius$default($this$drawBehind.toPx-0680j_4(Dp.constructor-impl((float)var10)), 0.0F, 2, (Object)null);
      DrawScope.drawRoundRect-u-Aw5IA$default($this$drawBehind, color, 0L, var5, var13, (DrawStyle)var7, 0.0F, (ColorFilter)null, 0, 226, (Object)null);
      return Unit.INSTANCE;
   }

   private static final float TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$200(State $alpha$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return ((Number)$alpha$delegate.getValue()).floatValue();
   }

   private static final boolean TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$202$lambda$201(Function1 $onTaskCombine, TaskEntity $task, Function1 $onDelete, TimelineItem $item, SwipeToDismissBoxValue value) {
      Intrinsics.checkNotNullParameter(value, "value");
      boolean var10000;
      if (value == SwipeToDismissBoxValue.StartToEnd) {
         $onTaskCombine.invoke($task);
         var10000 = false;
      } else if (value == SwipeToDismissBoxValue.EndToStart) {
         $onDelete.invoke($item);
         var10000 = true;
      } else {
         var10000 = false;
      }

      return var10000;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$204(SwipeToDismissBoxState $dismissState, RowScope $this$SwipeToDismissBox, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$SwipeToDismissBox, "$this$SwipeToDismissBox");
      ComposerKt.sourceInformation($composer, "C952@40677L642:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1306710638, $changed, -1, "com.example.TimelineSection.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:936)");
         }

         SwipeToDismissBoxValue direction = $dismissState.getDismissDirection();
         long var10000;
         switch (MainActivityKt.WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1:
               var10000 = Color.copy-wmQWz5c$default(ColorKt.getTeal600(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
               break;
            case 2:
               var10000 = Color.copy-wmQWz5c$default(Color.Companion.getRed-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
               break;
            default:
               var10000 = Color.Companion.getTransparent-0d7_KjU();
         }

         long color = var10000;
         Alignment var40;
         switch (MainActivityKt.WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1:
               var40 = Alignment.Companion.getCenterStart();
               break;
            case 2:
               var40 = Alignment.Companion.getCenterEnd();
               break;
            default:
               var40 = Alignment.Companion.getCenter();
         }

         Alignment alignment = var40;
         ImageVector var41;
         switch (MainActivityKt.WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1:
               var41 = DateRangeKt.getDateRange(Icons.INSTANCE.getDefault());
               break;
            case 2:
               var41 = DeleteKt.getDelete(Icons.INSTANCE.getDefault());
               break;
            default:
               var41 = DeleteKt.getDelete(Icons.INSTANCE.getDefault());
         }

         ImageVector icon = var41;
         Modifier var42 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var9 = 24;
         int var10 = 0;
         var42 = BackgroundKt.background-bw27NRU(var42, color, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var9)));
         var9 = 24;
         var10 = 0;
         Modifier var38 = PaddingKt.padding-VpY3zN4$default(var42, Dp.constructor-impl((float)var9), 0.0F, 2, (Object)null);
         byte var13 = 0;
         int var14 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         boolean var11 = false;
         MeasurePolicy var15 = BoxKt.maybeCachedBoxMeasurePolicy(alignment, var11);
         int var16 = 112 & var13 << 3;
         int var17 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var18 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var19 = $composer.getCurrentCompositionLocalMap();
         Modifier var20 = ComposedModifierKt.materializeModifier($composer, var38);
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
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         int var33 = 6 | 112 & var13 >> 6;
         BoxScope var44 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var36 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1813309424, "C959@41198L71:MainActivity.kt#to5c3");
         IconKt.Icon-ww6aTOc(icon, (String)null, (Modifier)null, Color.Companion.getWhite-0d7_KjU(), $composer, 3120, 4);
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

   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$210$lambda$206$lambda$205(Function1 $onTaskClick, TaskEntity $task) {
      $onTaskClick.invoke($task);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$210$lambda$209(long $accentColor, TaskEntity $task, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C977@42458L3139:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1985960821, $changed, -1, "com.example.TimelineSection.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:977)");
         }

         Modifier var6 = IntrinsicKt.height(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), IntrinsicSize.Max);
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
         ComposerKt.sourceInformationMarkerStart($composer, 1785950233, "C981@42796L485,988@43338L40,989@43435L1427:MainActivity.kt#to5c3");
         Modifier var10000 = (Modifier)Modifier.Companion;
         int var34 = 4;
         int var35 = 0;
         var10000 = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(var10000, Dp.constructor-impl((float)var34)), 0.0F, 1, (Object)null);
         var34 = 2;
         var35 = 0;
         BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(var10000, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var34))), $accentColor, (Shape)null, 2, (Object)null), $composer, 0);
         var10000 = (Modifier)Modifier.Companion;
         var34 = 12;
         var35 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var10000, Dp.constructor-impl((float)var34)), $composer, 6);
         var10000 = RowScope.weight$default(var32, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         var34 = 12;
         var35 = 0;
         Modifier var78 = PaddingKt.padding-VpY3zN4$default(var10000, 0.0F, Dp.constructor-impl((float)var34), 1, (Object)null);
         int var37 = 0;
         int var38 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var83 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var39 = Alignment.Companion.getStart();
         MeasurePolicy var40 = ColumnKt.columnMeasurePolicy(var83, var39, $composer, 14 & var37 >> 3 | 112 & var37 >> 3);
         int var41 = 112 & var37 << 3;
         int var42 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var43 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var44 = $composer.getCurrentCompositionLocalMap();
         Modifier var45 = ComposedModifierKt.materializeModifier($composer, var78);
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
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var58 = 6 | 112 & var37 >> 6;
         ColumnScope var94 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var61 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1414566308, "C994@43913L11,990@43562L437:MainActivity.kt#to5c3");
         String var62 = $task.getTitle();
         long var63 = TextUnitKt.getSp(16);
         FontWeight var65 = FontWeight.Companion.getBold();
         long var66 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g(var62, (Modifier)null, var66, var63, (FontStyle)null, var65, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
         CharSequence var88 = (CharSequence)$task.getDescription();
         if (var88 != null && !StringsKt.isBlank(var88)) {
            $composer.startReplaceGroup(1415082364);
            ComposerKt.sourceInformation($composer, "1000@44442L11,997@44165L577");
            String var95 = $task.getDescription();
            Intrinsics.checkNotNull(var95);
            String var89 = var95;
            var63 = TextUnitKt.getSp(13);
            long var68 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.6F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            Modifier var96 = (Modifier)Modifier.Companion;
            int var70 = 2;
            int var71 = 0;
            Modifier var72 = PaddingKt.padding-qDBjuR0$default(var96, 0.0F, Dp.constructor-impl((float)var70), 0.0F, 0.0F, 13, (Object)null);
            TextKt.Text--4IGK_g(var89, var72, var68, var63, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 1, 0, (Function1)null, (TextStyle)null, $composer, 3120, 3072, 122864);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(1371313309);
            $composer.endReplaceGroup();
         }

         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         if ($task.getExternalCalendarEventId() != null) {
            $composer.startReplaceGroup(1788030797);
            ComposerKt.sourceInformation($composer, "1007@45023L462");
            ImageVector var79 = DateRangeKt.getDateRange(Icons.INSTANCE.getDefault());
            long var73 = ColorKt.getTeal600();
            Modifier var97 = (Modifier)Modifier.Companion;
            var37 = 16;
            var38 = 0;
            var97 = PaddingKt.padding-qDBjuR0$default(var97, 0.0F, 0.0F, Dp.constructor-impl((float)var37), 0.0F, 11, (Object)null);
            var37 = 20;
            var38 = 0;
            Modifier var36 = SizeKt.size-3ABfNKs(var97, Dp.constructor-impl((float)var37));
            IconKt.Icon-ww6aTOc(var79, "Synced", var36, var73, $composer, 3504, 0);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(1743410451);
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

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$210(TaskEntity $task, BorderStroke $borderStroke, Function1 $onTaskClick, RowScope $this$SwipeToDismissBox, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$SwipeToDismissBox, "$this$SwipeToDismissBox");
      ComposerKt.sourceInformation($composer, "C968@41856L18,975@42332L21,976@42404L3243,971@42019L3628:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1239930281, $changed, -1, "com.example.TimelineSection.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:963)");
         }

         long accentColor = $task.isMeeting() ? ColorKt.getCoral500() : ($task.getExternalCalendarEventId() != null ? ColorKt.getTeal600() : ColorKt.getIndigo600());
         boolean isDark = ThemeKt.isAppInDarkTheme($composer, 0);
         long cardBg = isDark ? ColorKt.getDarkCard() : ColorKt.getWhite90();
         Modifier var10000 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         BorderStroke var10001 = $borderStroke;
         Color var10002 = Color.box-impl(cardBg);
         ComposerKt.sourceInformationMarkerStart($composer, -1867029876, "CC(remember):MainActivity.kt#9igjgp");
         boolean var13 = $composer.changed($onTaskClick) | $composer.changed($task);
         int var14 = 0;
         Object var15 = $composer.rememberedValue();
         int var16 = 0;
         Object var10003;
         if (!var13 && var15 != Composer.Companion.getEmpty()) {
            var10003 = var15;
         } else {
            Color var21 = var10002;
            Modifier var19 = var10000;
            int var17 = 0;
            Function0 var18_1 = MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$210$lambda$206$lambda$205;
            var10000 = var19;
            var10001 = $borderStroke;
            var10002 = var21;
            $composer.updateRememberedValue(var18_1);
            var10003 = var18_1;
         }

         Function0 var11 = (Function0)var10003;
         ComposerKt.sourceInformationMarkerEnd($composer);
         OtherScreensKt.GlassCard-dgCr-O4(var10000, var10001, var10002, var11, (Function0)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-1985960821, true, MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$210$lambda$209, $composer, 54), $composer, 196614, 16);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final float TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$212(State $alpha$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return ((Number)$alpha$delegate.getValue()).floatValue();
   }

   private static final boolean TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$214$lambda$213(Function1 $onDelete, TimelineItem $item, SwipeToDismissBoxValue value) {
      Intrinsics.checkNotNullParameter(value, "value");
      boolean var10000;
      if (value == SwipeToDismissBoxValue.EndToStart) {
         $onDelete.invoke($item);
         var10000 = true;
      } else {
         var10000 = false;
      }

      return var10000;
   }

   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$220$lambda$216$lambda$215(Function1 $onGoogleEventEdit, CalendarEvent $event) {
      $onGoogleEventEdit.invoke($event);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$220$lambda$219(CalendarEvent $event, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C1075@49585L2987:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1754056702, $changed, -1, "com.example.TimelineSection.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:1075)");
         }

         Modifier var4 = IntrinsicKt.height(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), IntrinsicSize.Max);
         Alignment.Vertical var6 = Alignment.Companion.getCenterVertically();
         short var8 = 390;
         int var9 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var5 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var10 = RowKt.rowMeasurePolicy(var5, var6, $composer, 14 & var8 >> 3 | 112 & var8 >> 3);
         int var11 = 112 & var8 << 3;
         int var12 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var13 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var14 = $composer.getCurrentCompositionLocalMap();
         Modifier var15 = ComposedModifierKt.materializeModifier($composer, var4);
         Function0 var16 = ComposeUiNode.Companion.getConstructor();
         int var17 = 6 | 896 & var11 << 6;
         int var18 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var16);
         } else {
            $composer.useNode();
         }

         Composer var19 = Updater.constructor-impl($composer);
         int var20 = 0;
         Updater.set-impl(var19, var10, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var19, var14, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var21 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var22 = 0;
         int var24 = 0;
         if (var19.getInserting() || !Intrinsics.areEqual(var19.rememberedValue(), var13)) {
            var19.updateRememberedValue(var13);
            var19.apply(var13, var21);
         }

         Updater.set-impl(var19, var15, ComposeUiNode.Companion.getSetModifier());
         int var25 = 14 & var17 >> 6;
         int var27 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var28 = 6 | 112 & var8 >> 6;
         RowScope var30 = (RowScope)RowScopeInstance.INSTANCE;
         int var31 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1174885414, "C1079@49923L481,1086@50461L40,1087@50558L1446,1104@52061L457:MainActivity.kt#to5c3");
         Modifier var10000 = (Modifier)Modifier.Companion;
         int var32 = 4;
         int var33 = 0;
         var10000 = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(var10000, Dp.constructor-impl((float)var32)), 0.0F, 1, (Object)null);
         var32 = 2;
         var33 = 0;
         BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(var10000, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var32))), ColorKt.getTeal600(), (Shape)null, 2, (Object)null), $composer, 0);
         var10000 = (Modifier)Modifier.Companion;
         var32 = 12;
         var33 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var10000, Dp.constructor-impl((float)var32)), $composer, 6);
         var10000 = RowScope.weight$default(var30, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         var32 = 12;
         var33 = 0;
         Modifier var76 = PaddingKt.padding-VpY3zN4$default(var10000, 0.0F, Dp.constructor-impl((float)var32), 1, (Object)null);
         int var35 = 0;
         int var36 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var81 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var37 = Alignment.Companion.getStart();
         MeasurePolicy var38 = ColumnKt.columnMeasurePolicy(var81, var37, $composer, 14 & var35 >> 3 | 112 & var35 >> 3);
         int var39 = 112 & var35 << 3;
         int var40 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var41 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var42 = $composer.getCurrentCompositionLocalMap();
         Modifier var43 = ComposedModifierKt.materializeModifier($composer, var76);
         Function0 var44 = ComposeUiNode.Companion.getConstructor();
         int var45 = 6 | 896 & var39 << 6;
         int var46 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var44);
         } else {
            $composer.useNode();
         }

         Composer var47 = Updater.constructor-impl($composer);
         int var48 = 0;
         Updater.set-impl(var47, var38, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var47, var42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var49 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var50 = 0;
         int var52 = 0;
         if (var47.getInserting() || !Intrinsics.areEqual(var47.rememberedValue(), var41)) {
            var47.updateRememberedValue(var41);
            var47.apply(var41, var49);
         }

         Updater.set-impl(var47, var43, ComposeUiNode.Companion.getSetModifier());
         int var53 = 14 & var45 >> 6;
         int var55 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var56 = 6 | 112 & var35 >> 6;
         ColumnScope var92 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var59 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1551566950, "C1092@51053L11,1088@50685L454:MainActivity.kt#to5c3");
         String var93 = $event.getSummary();
         if (var93 == null) {
            var93 = "No Title";
         }

         String var60 = var93;
         long var61 = TextUnitKt.getSp(16);
         FontWeight var63 = FontWeight.Companion.getBold();
         long var64 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g(var60, (Modifier)null, var64, var61, (FontStyle)null, var63, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
         CharSequence var86 = (CharSequence)$event.getDescription();
         if (var86 != null && !StringsKt.isBlank(var86)) {
            $composer.startReplaceGroup(-1551033596);
            ComposerKt.sourceInformation($composer, "1098@51584L11,1095@51306L578");
            var93 = $event.getDescription();
            Intrinsics.checkNotNull(var93);
            String var87 = var93;
            var61 = TextUnitKt.getSp(13);
            long var66 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.6F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            Modifier var95 = (Modifier)Modifier.Companion;
            int var68 = 2;
            int var69 = 0;
            Modifier var70 = PaddingKt.padding-qDBjuR0$default(var95, 0.0F, Dp.constructor-impl((float)var68), 0.0F, 0.0F, 13, (Object)null);
            TextKt.Text--4IGK_g(var87, var70, var66, var61, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 1, 0, (Function1)null, (TextStyle)null, $composer, 3120, 3072, 122864);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-1601886554);
            $composer.endReplaceGroup();
         }

         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ImageVector var77 = DateRangeKt.getDateRange(Icons.INSTANCE.getDefault());
         long var71 = ColorKt.getTeal600();
         Modifier var96 = (Modifier)Modifier.Companion;
         var35 = 16;
         var36 = 0;
         var96 = PaddingKt.padding-qDBjuR0$default(var96, 0.0F, 0.0F, Dp.constructor-impl((float)var35), 0.0F, 11, (Object)null);
         var35 = 20;
         var36 = 0;
         Modifier var34 = SizeKt.size-3ABfNKs(var96, Dp.constructor-impl((float)var35));
         IconKt.Icon-ww6aTOc(var77, "Google Calendar Event", var34, var71, $composer, 3504, 0);
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
   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$220(BorderStroke $borderStroke, Function1 $onGoogleEventEdit, CalendarEvent $event, RowScope $this$SwipeToDismissBox, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$SwipeToDismissBox, "$this$SwipeToDismissBox");
      ComposerKt.sourceInformation($composer, "C1066@48976L18,1073@49452L28,1074@49531L3091,1069@49139L3483:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2078246194, $changed, -1, "com.example.TimelineSection.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:1066)");
         }

         boolean isDark = ThemeKt.isAppInDarkTheme($composer, 0);
         long cardBg = isDark ? ColorKt.getDarkCard() : ColorKt.getWhite90();
         Modifier var10000 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         BorderStroke var10001 = $borderStroke;
         Color var10002 = Color.box-impl(cardBg);
         ComposerKt.sourceInformationMarkerStart($composer, -34782518, "CC(remember):MainActivity.kt#9igjgp");
         boolean var11 = $composer.changed($onGoogleEventEdit) | $composer.changed($event);
         int var12 = 0;
         Object var13 = $composer.rememberedValue();
         int var14 = 0;
         Object var10003;
         if (!var11 && var13 != Composer.Companion.getEmpty()) {
            var10003 = var13;
         } else {
            Color var19 = var10002;
            Modifier var17 = var10000;
            int var15 = 0;
            Function0 var16_1 = MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$220$lambda$216$lambda$215;
            var10000 = var17;
            var10001 = $borderStroke;
            var10002 = var19;
            $composer.updateRememberedValue(var16_1);
            var10003 = var16_1;
         }

         Function0 var9 = (Function0)var10003;
         ComposerKt.sourceInformationMarkerEnd($composer);
         OtherScreensKt.GlassCard-dgCr-O4(var10000, var10001, var10002, var9, (Function0)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-1754056702, true, MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$220$lambda$219, $composer, 54), $composer, 196614, 16);
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
   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223(List $occurrencesForHour, Function1 $onEmptyHourClick, int $hour, boolean $isCurrentHour, String $highlightedTaskId, Function1 $onTaskCombine, Function1 $onDelete, Function1 $onTaskClick, Function1 $onGoogleEventEdit, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(619379743, $changed, -1, "com.example.TimelineSection.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:865)");
         }

         if ($occurrencesForHour.isEmpty()) {
            $composer.startReplaceGroup(762529436);
            ComposerKt.sourceInformation($composer, "871@35132L26,872@35203L882,866@34878L1687");
            Modifier var156 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            int var68 = 56;
            int var73 = 0;
            var156 = BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(var156, Dp.constructor-impl((float)var68)), Color.Companion.getTransparent-0d7_KjU(), (Shape)null, 2, (Object)null);
            boolean var164 = false;
            Object var10002 = null;
            Object var10003 = null;
            ComposerKt.sourceInformationMarkerStart($composer, -1776510343, "CC(remember):MainActivity.kt#9igjgp");
            boolean var76 = $composer.changed($onEmptyHourClick) | $composer.changed($hour);
            int var14 = 0;
            Object var80 = $composer.rememberedValue();
            int var83 = 0;
            Object var10004;
            if (!var76 && var80 != Composer.Companion.getEmpty()) {
               var10004 = var80;
            } else {
               Object var66 = null;
               Object var65 = null;
               boolean var64 = false;
               Modifier var63 = var156;
               int var86 = 0;
               Function0 var18_3 = MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$195$lambda$194;
               var156 = var63;
               var164 = var64;
               var10002 = var65;
               var10003 = var66;
               $composer.updateRememberedValue(var18_3);
               var10004 = var18_3;
            }

            Function0 var69 = (Function0)var10004;
            ComposerKt.sourceInformationMarkerEnd($composer);
            var156 = ClickableKt.clickable-XHw0xAI$default(var156, var164, (String)var10002, (Role)var10003, var69, 7, (Object)null);
            ComposerKt.sourceInformationMarkerStart($composer, -1776507215, "CC(remember):MainActivity.kt#9igjgp");
            var76 = $composer.changed($isCurrentHour);
            var14 = 0;
            var80 = $composer.rememberedValue();
            var83 = 0;
            Object var166;
            if (!var76 && var80 != Composer.Companion.getEmpty()) {
               var166 = var80;
            } else {
               Modifier var149 = var156;
               int var87 = 0;
               Function1 var165 = MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$197$lambda$196;
               var156 = var149;
               Object var89 = var165;
               $composer.updateRememberedValue(var89);
               var166 = var89;
            }

            Function1 var70 = (Function1)var166;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier var71 = DrawModifierKt.drawBehind(var156, var70);
            Alignment var74 = Alignment.Companion.getCenterStart();
            byte var82 = 48;
            var83 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            var76 = false;
            MeasurePolicy var88 = BoxKt.maybeCachedBoxMeasurePolicy(var74, var76);
            int var90 = 112 & var82 << 3;
            int var91 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var92 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var93 = $composer.getCurrentCompositionLocalMap();
            Modifier var94 = ComposedModifierKt.materializeModifier($composer, var71);
            Function0 var95 = ComposeUiNode.Companion.getConstructor();
            int var96 = 6 | 896 & var90 << 6;
            int var97 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var95);
            } else {
               $composer.useNode();
            }

            Composer var98 = Updater.constructor-impl($composer);
            int var99 = 0;
            Updater.set-impl(var98, var88, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var98, var93, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var100 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var101 = 0;
            int var102 = 0;
            if (var98.getInserting() || !Intrinsics.areEqual(var98.rememberedValue(), var92)) {
               var98.updateRememberedValue(var92);
               var98.apply(var92, var100);
            }

            Updater.set-impl(var98, var94, ComposeUiNode.Companion.getSetModifier());
            int var103 = 14 & var96 >> 6;
            int var104 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            int var105 = 6 | 112 & var82 >> 6;
            BoxScope var159 = (BoxScope)BoxScopeInstance.INSTANCE;
            int var106 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 1535919068, "C890@36389L11,887@36212L327:MainActivity.kt#to5c3");
            long var107 = TextUnitKt.getSp(12);
            long var108 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.25F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            Modifier var160 = (Modifier)Modifier.Companion;
            int var109 = 16;
            int var110 = 0;
            Modifier var45 = PaddingKt.padding-qDBjuR0$default(var160, Dp.constructor-impl((float)var109), 0.0F, 0.0F, 0.0F, 14, (Object)null);
            TextKt.Text--4IGK_g("Empty slot — Tap to plan", var45, var108, var107, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3126, 0, 131056);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(764708457);
            ComposerKt.sourceInformation($composer, "895@36619L16266");
            int var12 = 8;
            int var13 = 0;
            Arrangement.Vertical var72 = (Arrangement.Vertical)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var12));
            int var15 = 48;
            int var16 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier var11 = (Modifier)Modifier.Companion;
            Alignment.Horizontal var75 = Alignment.Companion.getStart();
            MeasurePolicy var17 = ColumnKt.columnMeasurePolicy(var72, var75, $composer, 14 & var15 >> 3 | 112 & var15 >> 3);
            int var18 = 112 & var15 << 3;
            int var19 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var20 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var21 = $composer.getCurrentCompositionLocalMap();
            Modifier var22 = ComposedModifierKt.materializeModifier($composer, var11);
            Function0 var23 = ComposeUiNode.Companion.getConstructor();
            int var24 = 6 | 896 & var18 << 6;
            int var25 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var23);
            } else {
               $composer.useNode();
            }

            Composer var26 = Updater.constructor-impl($composer);
            int var27 = 0;
            Updater.set-impl(var26, var17, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var26, var21, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var28 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var29 = 0;
            int var31 = 0;
            if (var26.getInserting() || !Intrinsics.areEqual(var26.rememberedValue(), var20)) {
               var26.updateRememberedValue(var20);
               var26.apply(var20, var28);
            }

            Updater.set-impl(var26, var22, ComposeUiNode.Companion.getSetModifier());
            int var32 = 14 & var24 >> 6;
            int var34 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            int var35 = 6 | 112 & var15 >> 6;
            Composer var36 = $composer;
            ColumnScope var10000 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            int var38 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -587170703, "C:MainActivity.kt#to5c3");
            $composer.startReplaceGroup(535248927);
            ComposerKt.sourceInformation($composer, "");
            Iterable var39 = (Iterable)$occurrencesForHour;
            int var40 = 0;

            for(Object var42 : var39) {
               TimelineItem var43 = (TimelineItem)var42;
               int var44 = 0;
               if (var43 instanceof TimelineItem.AppTaskItem) {
                  var36.startReplaceGroup(-376638591);
                  ComposerKt.sourceInformation(var36, "900@36979L164,904@37210L43,905@37326L546,922@38423L574,921@38326L713,935@39230L2135,962@41421L4272,933@39081L6654");
                  TaskEntity var46 = ((TimelineItem.AppTaskItem)var43).getTask();
                  int var47 = var46.getId();
                  ComposerKt.sourceInformationMarkerStart(var36, 1096224208, "CC(remember):MainActivity.kt#9igjgp");
                  boolean var49 = var36.changed($highlightedTaskId) | var36.changed(var47);
                  int var50 = 0;
                  Object var51 = var36.rememberedValue();
                  int var52 = 0;
                  Object var150;
                  if (!var49 && var51 != Composer.Companion.getEmpty()) {
                     var150 = var51;
                  } else {
                     int var53 = 0;
                     Object var54 = Intrinsics.areEqual("local_" + var46.getId(), $highlightedTaskId);
                     var36.updateRememberedValue(var54);
                     var150 = var54;
                  }

                  boolean var55 = (Boolean)var150;
                  ComposerKt.sourceInformationMarkerEnd(var36);
                  boolean var56 = var55;
                  InfiniteTransition var112 = InfiniteTransitionKt.rememberInfiniteTransition("pulse", var36, 6, 0);
                  State var140 = InfiniteTransitionKt.animateFloat(var112, 0.3F, 1.0F, AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)AnimationSpecKt.tween$default(800, 0, EasingKt.getLinearEasing(), 2, (Object)null), RepeatMode.Reverse, 0L, 4, (Object)null), "alpha", var36, 25008 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9, 0);
                  BorderStroke var151;
                  if (var56) {
                     var36.startReplaceGroup(-375823229);
                     var36.endReplaceGroup();
                     double var57 = (double)2.5F;
                     int var126 = 0;
                     var151 = BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var57), Color.copy-wmQWz5c$default(androidx.compose.ui.graphics.ColorKt.Color(4294913365L), TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$200(var140), 0.0F, 0.0F, 0.0F, 14, (Object)null));
                  } else {
                     var36.startReplaceGroup(-375671050);
                     ComposerKt.sourceInformation(var36, "918@38174L18");
                     var50 = 1;
                     int var127 = 0;
                     BorderStroke var116 = BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var50), ThemeKt.isAppInDarkTheme(var36, 0) ? ColorKt.getDarkGlassBorder() : ColorKt.getWhite40());
                     var36.endReplaceGroup();
                     var151 = var116;
                  }

                  BorderStroke var48 = var151;
                  Object var152 = null;
                  ComposerKt.sourceInformationMarkerStart(var36, 1096270826, "CC(remember):MainActivity.kt#9igjgp");
                  var52 = var36.changed($onTaskCombine) | var36.changed(var46) | var36.changed($onDelete) | var36.changed(var43);
                  int var134 = 0;
                  Object var137 = var36.rememberedValue();
                  int var59 = 0;
                  Object var161;
                  if (!var52 && var137 != Composer.Companion.getEmpty()) {
                     var161 = var137;
                  } else {
                     Object var60 = null;
                     int var61 = 0;
                     Function1 var10001 = MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$202$lambda$201;
                     var152 = var60;
                     Object var62 = var10001;
                     var36.updateRememberedValue(var62);
                     var161 = var62;
                  }

                  Function1 var122 = (Function1)var161;
                  ComposerKt.sourceInformationMarkerEnd(var36);
                  SwipeToDismissBoxState var117 = SwipeToDismissBoxKt.rememberSwipeToDismissBoxState((SwipeToDismissBoxValue)var152, var122, (Function1)null, var36, 0, 5);
                  SwipeToDismissBoxKt.SwipeToDismissBox(var117, (Function3)ComposableLambdaKt.rememberComposableLambda(-1306710638, true, MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$204, var36, 54), (Modifier)null, false, false, false, (Function3)ComposableLambdaKt.rememberComposableLambda(-1239930281, true, MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$210, var36, 54), var36, 1572912 | SwipeToDismissBoxState.$stable, 60);
                  var36.endReplaceGroup();
               } else if (var43 instanceof TimelineItem.GoogleEventItem) {
                  var36.startReplaceGroup(-367783937);
                  ComposerKt.sourceInformation(var36, "1021@45970L167,1025@46204L43,1026@46320L546,1043@47417L339,1042@47320L478,1065@48913L3755,1051@47840L4870");
                  CalendarEvent var111 = ((TimelineItem.GoogleEventItem)var43).getEvent();
                  String var113 = var111.getId();
                  ComposerKt.sourceInformationMarkerStart(var36, 1096511923, "CC(remember):MainActivity.kt#9igjgp");
                  boolean var118 = var36.changed($highlightedTaskId) | var36.changed(var113);
                  int var123 = 0;
                  Object var128 = var36.rememberedValue();
                  int var132 = 0;
                  Object var153;
                  if (!var118 && var128 != Composer.Companion.getEmpty()) {
                     var153 = var128;
                  } else {
                     int var135 = 0;
                     Object var138 = Intrinsics.areEqual("google_" + var111.getId(), $highlightedTaskId);
                     var36.updateRememberedValue(var138);
                     var153 = var138;
                  }

                  boolean var141 = (Boolean)var153;
                  ComposerKt.sourceInformationMarkerEnd(var36);
                  boolean var143 = var141;
                  InfiniteTransition var114 = InfiniteTransitionKt.rememberInfiniteTransition("pulse", var36, 6, 0);
                  State var142 = InfiniteTransitionKt.animateFloat(var114, 0.3F, 1.0F, AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)AnimationSpecKt.tween$default(800, 0, EasingKt.getLinearEasing(), 2, (Object)null), RepeatMode.Reverse, 0L, 4, (Object)null), "alpha", var36, 25008 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9, 0);
                  BorderStroke var154;
                  if (var143) {
                     var36.startReplaceGroup(-366901181);
                     var36.endReplaceGroup();
                     double var144 = (double)2.5F;
                     int var129 = 0;
                     var154 = BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var144), Color.copy-wmQWz5c$default(androidx.compose.ui.graphics.ColorKt.Color(4294913365L), TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$212(var142), 0.0F, 0.0F, 0.0F, 14, (Object)null));
                  } else {
                     var36.startReplaceGroup(-366749002);
                     ComposerKt.sourceInformation(var36, "1039@47168L18");
                     var123 = 1;
                     int var130 = 0;
                     BorderStroke var119 = BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var123), ThemeKt.isAppInDarkTheme(var36, 0) ? ColorKt.getDarkGlassBorder() : ColorKt.getWhite40());
                     var36.endReplaceGroup();
                     var154 = var119;
                  }

                  BorderStroke var115 = var154;
                  Object var155 = null;
                  ComposerKt.sourceInformationMarkerStart(var36, 1096558399, "CC(remember):MainActivity.kt#9igjgp");
                  var132 = var36.changed($onDelete) | var36.changed(var43);
                  int var136 = 0;
                  Object var139 = var36.rememberedValue();
                  int var145 = 0;
                  Object var163;
                  if (!var132 && var139 != Composer.Companion.getEmpty()) {
                     var163 = var139;
                  } else {
                     Object var146 = null;
                     int var147 = 0;
                     Function1 var162 = MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$214$lambda$213;
                     var155 = var146;
                     Object var148 = var162;
                     var36.updateRememberedValue(var148);
                     var163 = var148;
                  }

                  Function1 var125 = (Function1)var163;
                  ComposerKt.sourceInformationMarkerEnd(var36);
                  SwipeToDismissBoxState var120 = SwipeToDismissBoxKt.rememberSwipeToDismissBoxState((SwipeToDismissBoxValue)var155, var125, (Function1)null, var36, 0, 5);
                  SwipeToDismissBoxKt.SwipeToDismissBox(var120, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$-1829659831$app(), (Modifier)null, false, false, false, (Function3)ComposableLambdaKt.rememberComposableLambda(-2078246194, true, MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223$lambda$222$lambda$221$lambda$220, var36, 54), var36, 1575984 | SwipeToDismissBoxState.$stable, 52);
                  var36.endReplaceGroup();
               } else {
                  var36.startReplaceGroup(-361105452);
                  var36.endReplaceGroup();
               }
            }

            var36.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(var36);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
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
   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224(boolean $isToday, List $timelineItems, Function1 $onEmptyHourClick, String $highlightedTaskId, Function1 $onTaskCombine, Function1 $onDelete, Function1 $onTaskClick, Function1 $onGoogleEventEdit, LazyItemScope $this$items, int hour, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$items, "$this$items");
      ComposerKt.sourceInformation($composer, "C852@34292L284,864@34796L18129,859@34594L18331:MainActivity.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 48) == 0) {
         $dirty = $changed | ($composer.changed(hour) ? 32 : 16);
      }

      if (($dirty & 145) == 144 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-71464781, $dirty, -1, "com.example.TimelineSection.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:849)");
         }

         StringCompanionObject var10000 = StringCompanionObject.INSTANCE;
         Locale var15 = Locale.getDefault();
         String occurrencesForHour = "%02d:00";
         Object[] var17 = new Object[]{hour};
         String var38 = String.format(var15, occurrencesForHour, Arrays.copyOf(var17, var17.length));
         Intrinsics.checkNotNullExpressionValue(var38, "format(...)");
         String timeString = var38;
         boolean isCurrentHour = $isToday && Calendar.getInstance().get(11) == hour;
         ComposerKt.sourceInformationMarkerStart($composer, 41830255, "CC(remember):MainActivity.kt#9igjgp");
         boolean var18 = $composer.changed($timelineItems) | ($dirty & 112) == 32;
         int var19 = 0;
         Object var20 = $composer.rememberedValue();
         int var21 = 0;
         Object var39;
         if (!var18 && var20 != Composer.Companion.getEmpty()) {
            var39 = var20;
         } else {
            int var22 = 0;
            Iterable var23 = (Iterable)$timelineItems;
            int var24 = 0;
            Collection var26 = (Collection)(new ArrayList());
            int var27 = 0;

            for(Object var29 : var23) {
               TimelineItem var30 = (TimelineItem)var29;
               int var31 = 0;
               Calendar var33_1 = Calendar.getInstance();
               int var34 = 0;
               var33_1.setTimeInMillis(var30.getTimeInMillis());
               if (var33_1.get(11) == hour) {
                  var26.add(var29);
               }
            }

            Object var36 = (List)var26;
            $composer.updateRememberedValue(var36);
            var39 = var36;
         }

         List occurrencesForHour = (List)var39;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ScheduleRow(timeString, $isToday, isCurrentHour, hour == 23, (Function2)ComposableLambdaKt.rememberComposableLambda(619379743, true, MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224$lambda$223, $composer, 54), $composer, 24576);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit TimelineSection$lambda$227$lambda$226$lambda$225(boolean $isToday, List $timelineItems, Function1 $onEmptyHourClick, String $highlightedTaskId, Function1 $onTaskCombine, Function1 $onDelete, Function1 $onTaskClick, Function1 $onGoogleEventEdit, LazyListScope $this$LazyColumn) {
      Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
      LazyListScope.items$default($this$LazyColumn, 24, (Function1)null, (Function1)null, (Function4)ComposableLambdaKt.composableLambdaInstance(-71464781, true, MainActivityKt::TimelineSection$lambda$227$lambda$226$lambda$225$lambda$224), 6, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit TimelineSection$lambda$228(long $selectedDate, List $timelineItems, Function1 $onTaskClick, Function1 $onTaskEdit, Function1 $onTaskCombine, Function1 $onDelete, Function1 $onEmptyHourClick, Function1 $onGoogleEventEdit, String $highlightedTaskId, int $$changed, Composer $composer, int $force) {
      TimelineSection($selectedDate, $timelineItems, $onTaskClick, $onTaskEdit, $onTaskCombine, $onDelete, $onEmptyHourClick, $onGoogleEventEdit, $highlightedTaskId, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final Unit ScheduleRow$lambda$234$lambda$231$lambda$230(boolean $isLast, long $lineColor, DrawScope $this$drawBehind) {
      Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
      if (!$isLast) {
         long var10002 = OffsetKt.Offset(Size.getWidth-impl($this$drawBehind.getSize-NH-jbRc()) / (float)2, 0.0F);
         long var10003 = OffsetKt.Offset(Size.getWidth-impl($this$drawBehind.getSize-NH-jbRc()) / (float)2, Size.getHeight-impl($this$drawBehind.getSize-NH-jbRc()));
         int var4 = 2;
         int var5 = 0;
         DrawScope.drawLine-NGM6Ib0$default($this$drawBehind, $lineColor, var10002, var10003, $this$drawBehind.toPx-0680j_4(Dp.constructor-impl((float)var4)), 0, (PathEffect)null, 0.0F, (ColorFilter)null, 0, 496, (Object)null);
      }

      return Unit.INSTANCE;
   }

   private static final Unit ScheduleRow$lambda$235(String $time, boolean $isToday, boolean $isCurrentHour, boolean $isLast, Function2 $content, int $$changed, Composer $composer, int $force) {
      ScheduleRow($time, $isToday, $isCurrentHour, $isLast, $content, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final Unit BottomNavBar$lambda$244$lambda$237$lambda$236(Function1 $onNavigate) {
      $onNavigate.invoke("home");
      return Unit.INSTANCE;
   }

   private static final Unit BottomNavBar$lambda$244$lambda$239$lambda$238(Function1 $onNavigate) {
      $onNavigate.invoke("notes");
      return Unit.INSTANCE;
   }

   private static final Unit BottomNavBar$lambda$244$lambda$241$lambda$240(Function1 $onNavigate) {
      $onNavigate.invoke("sync");
      return Unit.INSTANCE;
   }

   private static final Unit BottomNavBar$lambda$244$lambda$243$lambda$242(Function1 $onNavigate) {
      $onNavigate.invoke("settings");
      return Unit.INSTANCE;
   }

   private static final Unit BottomNavBar$lambda$245(String $currentRoute, Function1 $onNavigate, int $$changed, Composer $composer, int $force) {
      BottomNavBar($currentRoute, $onNavigate, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final Unit NavBarItem$lambda$247$lambda$246(Function0 $onClick) {
      $onClick.invoke();
      return Unit.INSTANCE;
   }

   private static final Unit NavBarItem$lambda$250(String $label, ImageVector $icon, boolean $isActive, Function0 $onClick, int $$changed, int $$default, Composer $composer, int $force) {
      NavBarItem($label, $icon, $isActive, $onClick, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1), $$default);
      return Unit.INSTANCE;
   }

   private static final String AddTaskDialog$lambda$252(MutableState $title$delegate) {
      State var1 = (State)$title$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)var1.getValue();
   }

   private static final void AddTaskDialog$lambda$253(MutableState $title$delegate, String var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $title$delegate.setValue(var1);
   }

   private static final String AddTaskDialog$lambda$255(MutableState $description$delegate) {
      State var1 = (State)$description$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)var1.getValue();
   }

   private static final void AddTaskDialog$lambda$256(MutableState $description$delegate, String var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $description$delegate.setValue(var1);
   }

   private static final boolean AddTaskDialog$lambda$258(MutableState $isTimeBoxed$delegate) {
      State var1 = (State)$isTimeBoxed$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void AddTaskDialog$lambda$259(MutableState $isTimeBoxed$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $isTimeBoxed$delegate.setValue(var5);
   }

   private static final boolean AddTaskDialog$lambda$261(MutableState $isMeeting$delegate) {
      State var1 = (State)$isMeeting$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void AddTaskDialog$lambda$262(MutableState $isMeeting$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $isMeeting$delegate.setValue(var5);
   }

   private static final int AddTaskDialog$lambda$268(MutableState $hour$delegate) {
      State var1 = (State)$hour$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return ((Number)var1.getValue()).intValue();
   }

   private static final void AddTaskDialog$lambda$269(MutableState $hour$delegate, int var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $hour$delegate.setValue(var5);
   }

   private static final int AddTaskDialog$lambda$271(MutableState $minute$delegate) {
      State var1 = (State)$minute$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return ((Number)var1.getValue()).intValue();
   }

   private static final void AddTaskDialog$lambda$272(MutableState $minute$delegate, int var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $minute$delegate.setValue(var5);
   }

   private static final int AddTaskDialog$lambda$276(MutableState $duration$delegate) {
      State var1 = (State)$duration$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return ((Number)var1.getValue()).intValue();
   }

   private static final void AddTaskDialog$lambda$277(MutableState $duration$delegate, int var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $duration$delegate.setValue(var5);
   }

   private static final boolean AddTaskDialog$lambda$279(MutableState $hasReminder$delegate) {
      State var1 = (State)$hasReminder$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Boolean)var1.getValue();
   }

   private static final void AddTaskDialog$lambda$280(MutableState $hasReminder$delegate, boolean var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $hasReminder$delegate.setValue(var5);
   }

   private static final int AddTaskDialog$lambda$282(MutableState $reminderMinutesBefore$delegate) {
      State var1 = (State)$reminderMinutesBefore$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return ((Number)var1.getValue()).intValue();
   }

   private static final void AddTaskDialog$lambda$283(MutableState $reminderMinutesBefore$delegate, int var1) {
      Object var3 = null;
      Object var4 = null;
      Object var5 = var1;
      int var6 = 0;
      $reminderMinutesBefore$delegate.setValue(var5);
   }

   private static final Long AddTaskDialog$lambda$285(MutableState $customReminderTime$delegate) {
      State var1 = (State)$customReminderTime$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (Long)var1.getValue();
   }

   private static final void AddTaskDialog$lambda$286(MutableState $customReminderTime$delegate, Long var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $customReminderTime$delegate.setValue(var1);
   }

   private static final String AddTaskDialog$lambda$290(MutableState $newSubTaskTitle$delegate) {
      State var1 = (State)$newSubTaskTitle$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (String)var1.getValue();
   }

   private static final void AddTaskDialog$lambda$291(MutableState $newSubTaskTitle$delegate, String var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = 0;
      $newSubTaskTitle$delegate.setValue(var1);
   }

   private static final Unit AddTaskDialog$lambda$294$lambda$293$lambda$292(Function12 $onSave, SnapshotStateList $subTasks, MutableState $title$delegate, MutableState $description$delegate, MutableState $isTimeBoxed$delegate, MutableState $hour$delegate, MutableState $minute$delegate, MutableState $duration$delegate, MutableState $hasReminder$delegate, MutableState $reminderMinutesBefore$delegate, MutableState $customReminderTime$delegate, MutableState $isMeeting$delegate) {
      if (!StringsKt.isBlank((CharSequence)AddTaskDialog$lambda$252($title$delegate))) {
         $onSave.invoke(AddTaskDialog$lambda$252($title$delegate), AddTaskDialog$lambda$255($description$delegate), AddTaskDialog$lambda$258($isTimeBoxed$delegate), AddTaskDialog$lambda$268($hour$delegate), AddTaskDialog$lambda$271($minute$delegate), AddTaskDialog$lambda$276($duration$delegate), AddTaskDialog$lambda$279($hasReminder$delegate), AddTaskDialog$lambda$282($reminderMinutesBefore$delegate), AddTaskDialog$lambda$285($customReminderTime$delegate), $subTasks.toList(), !AddTaskDialog$lambda$258($isTimeBoxed$delegate), AddTaskDialog$lambda$261($isMeeting$delegate));
      }

      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit AddTaskDialog$lambda$294(Function12 $onSave, SnapshotStateList $subTasks, MutableState $title$delegate, MutableState $description$delegate, MutableState $isTimeBoxed$delegate, MutableState $hour$delegate, MutableState $minute$delegate, MutableState $duration$delegate, MutableState $hasReminder$delegate, MutableState $reminderMinutesBefore$delegate, MutableState $customReminderTime$delegate, MutableState $isMeeting$delegate, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1574@73891L637,1592@74570L40,1573@73857L812:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(39360103, $changed, -1, "com.example.AddTaskDialog.<anonymous> (MainActivity.kt:1573)");
         }

         ComposerKt.sourceInformationMarkerStart($composer, -829644508, "CC(remember):MainActivity.kt#9igjgp");
         boolean var16 = $composer.changed($onSave);
         int var17 = 0;
         Object var18 = $composer.rememberedValue();
         int var19 = 0;
         Object var10000;
         if (!var16 && var18 != Composer.Companion.getEmpty()) {
            var10000 = var18;
         } else {
            int var20 = 0;
            Object var21 = MainActivityKt::AddTaskDialog$lambda$294$lambda$293$lambda$292;
            $composer.updateRememberedValue(var21);
            var10000 = var21;
         }

         Function0 var14 = (Function0)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.Button(var14, (Modifier)null, false, (Shape)null, ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(ColorKt.getIndigo600(), 0L, 0L, 0L, $composer, 6 | ButtonDefaults.$stable << 12, 14), (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$-797412777$app(), $composer, 805306368, 494);
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
   private static final Unit AddTaskDialog$lambda$296(Function0 $onDismiss, TaskEntity $task, Function0 $onDelete, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1598@74719L381:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(109007977, $changed, -1, "com.example.AddTaskDialog.<anonymous> (MainActivity.kt:1598)");
         }

         int var6 = 8;
         int var7 = 0;
         Arrangement.Horizontal var33 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var6));
         int var9 = 48;
         int var10 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Modifier var5 = (Modifier)Modifier.Companion;
         Alignment.Vertical var34 = Alignment.Companion.getTop();
         MeasurePolicy var11 = RowKt.rowMeasurePolicy(var33, var34, $composer, 14 & var9 >> 3 | 112 & var9 >> 3);
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
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var29 = 6 | 112 & var9 >> 6;
         RowScope var10000 = (RowScope)RowScopeInstance.INSTANCE;
         int var32 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 2104961617, "C1599@74793L86:MainActivity.kt#to5c3");
         ButtonKt.TextButton($onDismiss, (Modifier)null, false, (Shape)null, (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$-1605815414$app(), $composer, 805306368, 510);
         if ($task != null && $onDelete != null) {
            $composer.startReplaceGroup(2105097117);
            ComposerKt.sourceInformation($composer, "1603@74956L112");
            ButtonKt.TextButton($onDelete, (Modifier)null, false, (Shape)null, (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$923266341$app(), $composer, 805306368, 510);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(2030756885);
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

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit AddTaskDialog$lambda$297(TaskEntity $task, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1312@59810L185:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(178655851, $changed, -1, "com.example.AddTaskDialog.<anonymous> (MainActivity.kt:1312)");
         }

         String var3 = $task != null ? "Edit Plan / Task" : "Create Plan / Task";
         FontWeight var4 = FontWeight.Companion.getBold();
         long var5 = TextUnitKt.getSp(20);
         TextKt.Text--4IGK_g(var3, (Modifier)null, 0L, var5, (FontStyle)null, var4, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131030);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$299$lambda$298(MutableState $title$delegate, String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      AddTaskDialog$lambda$253($title$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$301$lambda$300(MutableState $description$delegate, String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      AddTaskDialog$lambda$256($description$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$304$lambda$303$lambda$302(MutableState $isTimeBoxed$delegate, boolean it) {
      AddTaskDialog$lambda$259($isTimeBoxed$delegate, it);
      return Unit.INSTANCE;
   }

   private static final void AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$309$lambda$307$lambda$306$lambda$305(MutableState $hour$delegate, MutableState $minute$delegate, TimePicker var2, int selectedHour, int selectedMinute) {
      AddTaskDialog$lambda$269($hour$delegate, selectedHour);
      AddTaskDialog$lambda$272($minute$delegate, selectedMinute);
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$309$lambda$307$lambda$306(Context $context, MutableState $hour$delegate, MutableState $minute$delegate) {
      (new TimePickerDialog($context, MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$309$lambda$307$lambda$306$lambda$305, AddTaskDialog$lambda$268($hour$delegate), AddTaskDialog$lambda$271($minute$delegate), true)).show();
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$309$lambda$308(MutableState $hour$delegate, MutableState $minute$delegate, RowScope $this$Button, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
      ComposerKt.sourceInformation($composer, "C1385@63312L67:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-988895815, $changed, -1, "com.example.AddTaskDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:1385)");
         }

         StringCompanionObject var10000 = StringCompanionObject.INSTANCE;
         Locale var5 = Locale.getDefault();
         String var6 = "%02d:%02d";
         Object[] var7 = new Object[]{AddTaskDialog$lambda$268($hour$delegate), AddTaskDialog$lambda$271($minute$delegate)};
         String var8 = String.format(var5, var6, Arrays.copyOf(var7, var7.length));
         Intrinsics.checkNotNullExpressionValue(var8, "format(...)");
         TextKt.Text--4IGK_g(var8, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$315$lambda$314$lambda$313$lambda$311$lambda$310(int $mins, MutableState $duration$delegate) {
      AddTaskDialog$lambda$277($duration$delegate, $mins);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$315$lambda$314$lambda$313$lambda$312(int $mins, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1400@64246L50:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(804035439, $changed, -1, "com.example.AddTaskDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:1400)");
         }

         TextKt.Text--4IGK_g($mins < 60 ? $mins + "m" : $mins / 60 + "h", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$318$lambda$317$lambda$316(MutableState $isMeeting$delegate, boolean it) {
      AddTaskDialog$lambda$262($isMeeting$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$321$lambda$320$lambda$319(MutableState $hasReminder$delegate, boolean it) {
      AddTaskDialog$lambda$280($hasReminder$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$327$lambda$326$lambda$325$lambda$323$lambda$322(int $offset, MutableState $reminderMinutesBefore$delegate) {
      AddTaskDialog$lambda$283($reminderMinutesBefore$delegate, $offset);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$327$lambda$326$lambda$325$lambda$324(int $offset, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1436@66371L18:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(330592147, $changed, -1, "com.example.AddTaskDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:1436)");
         }

         TextKt.Text--4IGK_g($offset + "m", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
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
   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$329(Context $context, MutableState $hour$delegate, MutableState $minute$delegate, MutableState $duration$delegate, MutableState $isMeeting$delegate, MutableState $hasReminder$delegate, MutableState $reminderMinutesBefore$delegate, ColumnScope $this$Card, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
      ComposerKt.sourceInformation($composer, "C1359@61760L4847:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-419986833, $changed, -1, "com.example.AddTaskDialog.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:1359)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var10 = 16;
         int var11 = 0;
         Modifier var113 = PaddingKt.padding-3ABfNKs(var10000, Dp.constructor-impl((float)var10));
         var11 = 12;
         int var12 = 0;
         Arrangement.Vertical var115 = (Arrangement.Vertical)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var11));
         byte var14 = 54;
         int var15 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Alignment.Horizontal var116 = Alignment.Companion.getStart();
         MeasurePolicy var16 = ColumnKt.columnMeasurePolicy(var115, var116, $composer, 14 & var14 >> 3 | 112 & var14 >> 3);
         int var17 = 112 & var14 << 3;
         int var18 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var19 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var20 = $composer.getCurrentCompositionLocalMap();
         Modifier var21 = ComposedModifierKt.materializeModifier($composer, var113);
         Function0 var22 = ComposeUiNode.Companion.getConstructor();
         int var23 = 6 | 896 & var17 << 6;
         int var24 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var22);
         } else {
            $composer.useNode();
         }

         Composer var25 = Updater.constructor-impl($composer);
         int var26 = 0;
         Updater.set-impl(var25, var16, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var25, var20, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var27 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var28 = 0;
         int var30 = 0;
         if (var25.getInserting() || !Intrinsics.areEqual(var25.rememberedValue(), var19)) {
            var25.updateRememberedValue(var19);
            var25.apply(var19, var27);
         }

         Updater.set-impl(var25, var21, ComposeUiNode.Companion.getSetModifier());
         int var31 = 14 & var23 >> 6;
         int var33 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var34 = 6 | 112 & var14 >> 6;
         ColumnScope var283 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var37 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -834781033, "C1363@61966L1477,1389@63473L969,1406@64472L478,1415@64980L480:MainActivity.kt#to5c3");
         Modifier var38 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Alignment.Vertical var39 = Alignment.Companion.getCenterVertically();
         Arrangement.HorizontalOrVertical var40 = Arrangement.INSTANCE.getSpaceBetween();
         Arrangement.Horizontal var42 = (Arrangement.Horizontal)var40;
         short var45 = 438;
         int var46 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         MeasurePolicy var47 = RowKt.rowMeasurePolicy(var42, var39, $composer, 14 & var45 >> 3 | 112 & var45 >> 3);
         int var48 = 112 & var45 << 3;
         int var49 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var50 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var51 = $composer.getCurrentCompositionLocalMap();
         Modifier var52 = ComposedModifierKt.materializeModifier($composer, var38);
         Function0 var53 = ComposeUiNode.Companion.getConstructor();
         int var54 = 6 | 896 & var48 << 6;
         int var55 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var53);
         } else {
            $composer.useNode();
         }

         Composer var56 = Updater.constructor-impl($composer);
         int var57 = 0;
         Updater.set-impl(var56, var47, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var56, var51, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var58 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var59 = 0;
         int var61 = 0;
         if (var56.getInserting() || !Intrinsics.areEqual(var56.rememberedValue(), var50)) {
            var56.updateRememberedValue(var50);
            var56.apply(var50, var58);
         }

         Updater.set-impl(var56, var52, ComposeUiNode.Companion.getSetModifier());
         int var62 = 14 & var54 >> 6;
         int var64 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var65 = 6 | 112 & var45 >> 6;
         RowScope var284 = (RowScope)RowScopeInstance.INSTANCE;
         int var68 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 449570941, "C1368@62264L52,1382@63083L85,1370@62403L618,1384@63274L139,1369@62349L1064:MainActivity.kt#to5c3");
         TextKt.Text--4IGK_g("Start Time", (Modifier)null, 0L, 0L, (FontStyle)null, FontWeight.Companion.getSemiBold(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 196614, 0, 131038);
         ButtonColors var69 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(Color.copy-wmQWz5c$default(ColorKt.getIndigo600(), 0.1F, 0.0F, 0.0F, 0.0F, 14, (Object)null), ColorKt.getIndigo600(), 0L, 0L, $composer, 54 | ButtonDefaults.$stable << 12, 12);
         int var70 = 10;
         int var71 = 0;
         RoundedCornerShape var72 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var70));
         ComposerKt.sourceInformationMarkerStart($composer, 1815621523, "CC(remember):MainActivity.kt#9igjgp");
         boolean var73 = $composer.changedInstance($context);
         int var74 = 0;
         Object var75 = $composer.rememberedValue();
         int var77_3 = 0;
         Object var285;
         if (!var73 && var75 != Composer.Companion.getEmpty()) {
            var285 = var75;
         } else {
            int var77 = 0;
            Object var78 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$309$lambda$307$lambda$306;
            $composer.updateRememberedValue(var78);
            var285 = var78;
         }

         Function0 var217 = (Function0)var285;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.Button(var217, (Modifier)null, false, (Shape)var72, var69, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-988895815, true, MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$309$lambda$308, $composer, 54), $composer, 805306368, 486);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         var38 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var39 = Alignment.Companion.getCenterVertically();
         var40 = Arrangement.INSTANCE.getSpaceBetween();
         var42 = (Arrangement.Horizontal)var40;
         var45 = 438;
         var46 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         var47 = RowKt.rowMeasurePolicy(var42, var39, $composer, 14 & var45 >> 3 | 112 & var45 >> 3);
         var48 = 112 & var45 << 3;
         var49 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var50 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var51 = $composer.getCurrentCompositionLocalMap();
         var52 = ComposedModifierKt.materializeModifier($composer, var38);
         var53 = ComposeUiNode.Companion.getConstructor();
         var54 = 6 | 896 & var48 << 6;
         var55 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var53);
         } else {
            $composer.useNode();
         }

         var56 = Updater.constructor-impl($composer);
         var57 = 0;
         Updater.set-impl(var56, var47, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var56, var51, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var58 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var59 = 0;
         var61 = 0;
         if (var56.getInserting() || !Intrinsics.areEqual(var56.rememberedValue(), var50)) {
            var56.updateRememberedValue(var50);
            var56.apply(var50, var58);
         }

         Updater.set-impl(var56, var52, ComposeUiNode.Companion.getSetModifier());
         var62 = 14 & var54 >> 6;
         var64 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         var65 = 6 | 112 & var45 >> 6;
         RowScope var286 = (RowScope)RowScopeInstance.INSTANCE;
         var68 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1923159006, "C1394@63771L50,1395@63854L558:MainActivity.kt#to5c3");
         TextKt.Text--4IGK_g("Duration", (Modifier)null, 0L, 0L, (FontStyle)null, FontWeight.Companion.getSemiBold(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 196614, 0, 131038);
         int var213 = 6;
         int var218 = 0;
         Arrangement.Horizontal var214 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var213));
         int var226 = 48;
         var73 = (boolean)0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Modifier var234 = (Modifier)Modifier.Companion;
         Alignment.Vertical var219 = Alignment.Companion.getTop();
         MeasurePolicy var238 = RowKt.rowMeasurePolicy(var214, var219, $composer, 14 & var226 >> 3 | 112 & var226 >> 3);
         var77_3 = 112 & var226 << 3;
         int var246 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var248 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var79 = $composer.getCurrentCompositionLocalMap();
         Modifier var80 = ComposedModifierKt.materializeModifier($composer, var234);
         Function0 var81 = ComposeUiNode.Companion.getConstructor();
         int var82 = 6 | 896 & var77_3 << 6;
         int var83 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var81);
         } else {
            $composer.useNode();
         }

         Composer var84 = Updater.constructor-impl($composer);
         int var85 = 0;
         Updater.set-impl(var84, var238, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var84, var79, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var86 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var87 = 0;
         int var89 = 0;
         if (var84.getInserting() || !Intrinsics.areEqual(var84.rememberedValue(), var248)) {
            var84.updateRememberedValue(var248);
            var84.apply(var248, var86);
         }

         Updater.set-impl(var84, var80, ComposeUiNode.Companion.getSetModifier());
         int var90 = 14 & var82 >> 6;
         int var92 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var93 = 6 | 112 & var226 >> 6;
         Composer var94 = $composer;
         var286 = (RowScope)RowScopeInstance.INSTANCE;
         int var96 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 320009777, "C:MainActivity.kt#to5c3");
         $composer.startReplaceGroup(-2067886342);
         ComposerKt.sourceInformation($composer, "*1399@64171L19,1400@64244L54,1397@64030L310");
         Integer[] var97 = new Integer[]{15, 30, 60, 120};
         Iterable var267 = (Iterable)CollectionsKt.listOf(var97);
         int var98 = 0;

         for(Object var100 : var267) {
            int var101 = ((Number)var100).intValue();
            int var102 = 0;
            boolean var288 = AddTaskDialog$lambda$276($duration$delegate) == var101;
            ComposerKt.sourceInformationMarkerStart(var94, 1839061679, "CC(remember):MainActivity.kt#9igjgp");
            boolean var104 = var94.changed(var101);
            int var105 = 0;
            Object var106 = var94.rememberedValue();
            int var107 = 0;
            Object var10001;
            if (!var104 && var106 != Composer.Companion.getEmpty()) {
               var10001 = var106;
            } else {
               boolean var108 = var288;
               int var109 = 0;
               Function0 var111_1 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$315$lambda$314$lambda$313$lambda$311$lambda$310;
               var288 = var108;
               var94.updateRememberedValue(var111_1);
               var10001 = var111_1;
            }

            Function0 var112 = (Function0)var10001;
            ComposerKt.sourceInformationMarkerEnd(var94);
            ChipKt.FilterChip(var288, var112, (Function2)ComposableLambdaKt.rememberComposableLambda(804035439, true, MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$315$lambda$314$lambda$313$lambda$312, var94, 54), (Modifier)null, false, (Function2)null, (Function2)null, (Shape)null, (SelectableChipColors)null, (SelectableChipElevation)null, (BorderStroke)null, (MutableInteractionSource)null, var94, 384, 0, 4088);
         }

         var94.endReplaceGroup();
         ComposerKt.sourceInformationMarkerEnd(var94);
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
         var38 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var39 = Alignment.Companion.getCenterVertically();
         var40 = Arrangement.INSTANCE.getSpaceBetween();
         var42 = (Arrangement.Horizontal)var40;
         var45 = 438;
         var46 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         var47 = RowKt.rowMeasurePolicy(var42, var39, $composer, 14 & var45 >> 3 | 112 & var45 >> 3);
         var48 = 112 & var45 << 3;
         var49 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var50 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var51 = $composer.getCurrentCompositionLocalMap();
         var52 = ComposedModifierKt.materializeModifier($composer, var38);
         var53 = ComposeUiNode.Companion.getConstructor();
         var54 = 6 | 896 & var48 << 6;
         var55 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var53);
         } else {
            $composer.useNode();
         }

         var56 = Updater.constructor-impl($composer);
         var57 = 0;
         Updater.set-impl(var56, var47, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var56, var51, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var58 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var59 = 0;
         var61 = 0;
         if (var56.getInserting() || !Intrinsics.areEqual(var56.rememberedValue(), var50)) {
            var56.updateRememberedValue(var50);
            var56.apply(var50, var58);
         }

         Updater.set-impl(var56, var52, ComposeUiNode.Companion.getSetModifier());
         var62 = 14 & var54 >> 6;
         var64 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         var65 = 6 | 112 & var45 >> 6;
         var286 = (RowScope)RowScopeInstance.INSTANCE;
         var68 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1452015116, "C1411@64770L52,1412@64901L18,1412@64855L65:MainActivity.kt#to5c3");
         TextKt.Text--4IGK_g("Is Meeting", (Modifier)null, 0L, 0L, (FontStyle)null, FontWeight.Companion.getSemiBold(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 196614, 0, 131038);
         boolean var290 = AddTaskDialog$lambda$261($isMeeting$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 1986505907, "CC(remember):MainActivity.kt#9igjgp");
         boolean var220 = (boolean)0;
         var71 = 0;
         Object var227 = $composer.rememberedValue();
         var73 = (boolean)0;
         Object var296;
         if (var227 == Composer.Companion.getEmpty()) {
            boolean var235 = var290;
            int var239 = 0;
            Function1 var77_3 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$318$lambda$317$lambda$316;
            var290 = var235;
            $composer.updateRememberedValue(var77_3);
            var296 = var77_3;
         } else {
            var296 = var227;
         }

         Function1 var249 = (Function1)var296;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SwitchKt.Switch(var290, var249, (Modifier)null, (Function2)null, false, (SwitchColors)null, (MutableInteractionSource)null, $composer, 48, 124);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         var38 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         var39 = Alignment.Companion.getCenterVertically();
         var40 = Arrangement.INSTANCE.getSpaceBetween();
         var42 = (Arrangement.Horizontal)var40;
         var45 = 438;
         var46 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         var47 = RowKt.rowMeasurePolicy(var42, var39, $composer, 14 & var45 >> 3 | 112 & var45 >> 3);
         var48 = 112 & var45 << 3;
         var49 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var50 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         var51 = $composer.getCurrentCompositionLocalMap();
         var52 = ComposedModifierKt.materializeModifier($composer, var38);
         var53 = ComposeUiNode.Companion.getConstructor();
         var54 = 6 | 896 & var48 << 6;
         var55 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var53);
         } else {
            $composer.useNode();
         }

         var56 = Updater.constructor-impl($composer);
         var57 = 0;
         Updater.set-impl(var56, var47, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var56, var51, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         var58 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var59 = 0;
         var61 = 0;
         if (var56.getInserting() || !Intrinsics.areEqual(var56.rememberedValue(), var50)) {
            var56.updateRememberedValue(var50);
            var56.apply(var50, var58);
         }

         Updater.set-impl(var56, var52, ComposeUiNode.Companion.getSetModifier());
         var62 = 14 & var54 >> 6;
         var64 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         var65 = 6 | 112 & var45 >> 6;
         RowScope var291 = (RowScope)RowScopeInstance.INSTANCE;
         var68 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 532237225, "C1420@65278L50,1421@65409L20,1421@65361L69:MainActivity.kt#to5c3");
         TextKt.Text--4IGK_g("Reminder", (Modifier)null, 0L, 0L, (FontStyle)null, FontWeight.Companion.getSemiBold(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 196614, 0, 131038);
         boolean var292 = AddTaskDialog$lambda$279($hasReminder$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, -675563658, "CC(remember):MainActivity.kt#9igjgp");
         var220 = (boolean)0;
         var71 = 0;
         var227 = $composer.rememberedValue();
         var73 = (boolean)0;
         if (var227 == Composer.Companion.getEmpty()) {
            boolean var236 = var292;
            int var240 = 0;
            Function1 var77_3 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$321$lambda$320$lambda$319;
            var292 = var236;
            $composer.updateRememberedValue(var77_3);
            var296 = var77_3;
         } else {
            var296 = var227;
         }

         var249 = (Function1)var296;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SwitchKt.Switch(var292, var249, (Modifier)null, (Function2)null, false, (SwitchColors)null, (MutableInteractionSource)null, $composer, 48, 124);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         if (!AddTaskDialog$lambda$279($hasReminder$delegate)) {
            $composer.startReplaceGroup(-896395363);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-831378133);
            ComposerKt.sourceInformation($composer, "1425@65541L1010");
            var38 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            var39 = Alignment.Companion.getCenterVertically();
            var40 = Arrangement.INSTANCE.getSpaceBetween();
            var42 = (Arrangement.Horizontal)var40;
            var45 = 438;
            var46 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            var47 = RowKt.rowMeasurePolicy(var42, var39, $composer, 14 & var45 >> 3 | 112 & var45 >> 3);
            var48 = 112 & var45 << 3;
            var49 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            var50 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            var51 = $composer.getCurrentCompositionLocalMap();
            var52 = ComposedModifierKt.materializeModifier($composer, var38);
            var53 = ComposeUiNode.Companion.getConstructor();
            var54 = 6 | 896 & var48 << 6;
            var55 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var53);
            } else {
               $composer.useNode();
            }

            var56 = Updater.constructor-impl($composer);
            var57 = 0;
            Updater.set-impl(var56, var47, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var56, var51, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            var58 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            var59 = 0;
            var61 = 0;
            if (var56.getInserting() || !Intrinsics.areEqual(var56.rememberedValue(), var50)) {
               var56.updateRememberedValue(var50);
               var56.apply(var50, var58);
            }

            Updater.set-impl(var56, var52, ComposeUiNode.Companion.getSetModifier());
            var62 = 14 & var54 >> 6;
            var64 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            var65 = 6 | 112 & var45 >> 6;
            RowScope var293 = (RowScope)RowScopeInstance.INSTANCE;
            var68 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1094645747, "C1430@65859L37,1431@65933L584:MainActivity.kt#to5c3");
            TextKt.Text--4IGK_g("Time Before", (Modifier)null, 0L, TextUnitKt.getSp(14), (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3078, 0, 131062);
            int var215 = 6;
            var220 = (boolean)0;
            Arrangement.Horizontal var216 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var215));
            int var229 = 48;
            var73 = (boolean)0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            var234 = (Modifier)Modifier.Companion;
            Alignment.Vertical var223 = Alignment.Companion.getTop();
            var238 = RowKt.rowMeasurePolicy(var216, var223, $composer, 14 & var229 >> 3 | 112 & var229 >> 3);
            var77_3 = 112 & var229 << 3;
            var246 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var251 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            var79 = $composer.getCurrentCompositionLocalMap();
            var80 = ComposedModifierKt.materializeModifier($composer, var234);
            var81 = ComposeUiNode.Companion.getConstructor();
            var82 = 6 | 896 & var77_3 << 6;
            var83 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var81);
            } else {
               $composer.useNode();
            }

            var84 = Updater.constructor-impl($composer);
            var85 = 0;
            Updater.set-impl(var84, var238, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var84, var79, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            var86 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            var87 = 0;
            var89 = 0;
            if (var84.getInserting() || !Intrinsics.areEqual(var84.rememberedValue(), var251)) {
               var84.updateRememberedValue(var251);
               var84.apply(var251, var86);
            }

            Updater.set-impl(var84, var80, ComposeUiNode.Companion.getSetModifier());
            var90 = 14 & var82 >> 6;
            var92 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            var93 = 6 | 112 & var229 >> 6;
            var94 = $composer;
            var293 = (RowScope)RowScopeInstance.INSTANCE;
            var96 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -526567877, "C:MainActivity.kt#to5c3");
            $composer.startReplaceGroup(675751158);
            ComposerKt.sourceInformation($composer, "*1435@66277L34,1436@66369L22,1433@66113L324");
            Integer[] var268 = new Integer[]{5, 15, 30};
            Iterable var269 = (Iterable)CollectionsKt.listOf(var268);
            var98 = 0;

            for(Object var272 : var269) {
               int var273 = ((Number)var272).intValue();
               int var274 = 0;
               boolean var295 = AddTaskDialog$lambda$282($reminderMinutesBefore$delegate) == var273;
               ComposerKt.sourceInformationMarkerStart(var94, -150741886, "CC(remember):MainActivity.kt#9igjgp");
               boolean var275 = var94.changed(var273);
               int var276 = 0;
               Object var277 = var94.rememberedValue();
               int var278 = 0;
               if (!var275 && var277 != Composer.Companion.getEmpty()) {
                  var296 = var277;
               } else {
                  boolean var279 = var295;
                  int var280 = 0;
                  Function0 var111_1 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$327$lambda$326$lambda$325$lambda$323$lambda$322;
                  var295 = var279;
                  var94.updateRememberedValue(var111_1);
                  var296 = var111_1;
               }

               Function0 var282 = (Function0)var296;
               ComposerKt.sourceInformationMarkerEnd(var94);
               ChipKt.FilterChip(var295, var282, (Function2)ComposableLambdaKt.rememberComposableLambda(330592147, true, MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$329$lambda$328$lambda$327$lambda$326$lambda$325$lambda$324, var94, 54), (Modifier)null, false, (Function2)null, (Function2)null, (Shape)null, (SelectableChipColors)null, (SelectableChipElevation)null, (BorderStroke)null, (MutableInteractionSource)null, var94, 384, 0, 4088);
            }

            var94.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(var94);
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

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$332$lambda$331$lambda$330(MutableState $hasReminder$delegate, boolean it) {
      AddTaskDialog$lambda$280($hasReminder$delegate, it);
      return Unit.INSTANCE;
   }

   private static final void AddTaskDialog$lambda$354$lambda$353$lambda$339$lambda$337$lambda$336$lambda$335$lambda$334(int $y, int $m, int $d, MutableState $customReminderTime$delegate, TimePicker var4, int h, int min) {
      Calendar var9_1 = Calendar.getInstance();
      int var10 = 0;
      var9_1.set(1, $y);
      var9_1.set(2, $m);
      var9_1.set(5, $d);
      var9_1.set(11, h);
      var9_1.set(12, min);
      var9_1.set(13, 0);
      var9_1.set(14, 0);
      AddTaskDialog$lambda$286($customReminderTime$delegate, var9_1.getTimeInMillis());
   }

   private static final void AddTaskDialog$lambda$354$lambda$353$lambda$339$lambda$337$lambda$336$lambda$335(Context $context, Calendar $now, MutableState $customReminderTime$delegate, DatePicker var3, int y, int m, int d) {
      (new TimePickerDialog($context, MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$339$lambda$337$lambda$336$lambda$335$lambda$334, $now.get(11), $now.get(12), true)).show();
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$339$lambda$337$lambda$336(Context $context, MutableState $customReminderTime$delegate) {
      Calendar now = Calendar.getInstance();
      (new DatePickerDialog($context, MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$339$lambda$337$lambda$336$lambda$335, now.get(1), now.get(2), now.get(5))).show();
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$339$lambda$338(MutableState $customReminderTime$delegate, RowScope $this$Button, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
      ComposerKt.sourceInformation($composer, "C:MainActivity.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1850702347, $changed, -1, "com.example.AddTaskDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:1494)");
         }

         Long time = AddTaskDialog$lambda$285($customReminderTime$delegate);
         if (time != null) {
            $composer.startReplaceGroup(221678565);
            ComposerKt.sourceInformation($composer, "1497@69942L28");
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, HH:mm", Locale.getDefault());
            String var10000 = sdf.format(new Date(time));
            Intrinsics.checkNotNullExpressionValue(var10000, "format(...)");
            TextKt.Text--4IGK_g(var10000, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(221879631);
            ComposerKt.sourceInformation($composer, "1499@70048L22");
            TextKt.Text--4IGK_g("Pick Date/Time", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
            $composer.endReplaceGroup();
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$352$lambda$346$lambda$345$lambda$342$lambda$341$lambda$340(SnapshotStateList $subTasks, int $index, SubTaskEntity $sub, boolean isChecked) {
      $subTasks.set($index, SubTaskEntity.copy$default($sub, 0, (String)null, (String)null, (String)null, (Long)null, (Long)null, isChecked, 0L, (Long)null, 447, (Object)null));
      return Unit.INSTANCE;
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$352$lambda$346$lambda$345$lambda$344$lambda$343(SnapshotStateList $subTasks, int $index) {
      $subTasks.remove($index);
      return Unit.INSTANCE;
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$352$lambda$351$lambda$348$lambda$347(MutableState $newSubTaskTitle$delegate, String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      AddTaskDialog$lambda$291($newSubTaskTitle$delegate, it);
      return Unit.INSTANCE;
   }

   private static final Unit AddTaskDialog$lambda$354$lambda$353$lambda$352$lambda$351$lambda$350$lambda$349(SnapshotStateList $subTasks, TaskEntity $task, MutableState $newSubTaskTitle$delegate) {
      if (!StringsKt.isBlank((CharSequence)AddTaskDialog$lambda$290($newSubTaskTitle$delegate))) {
         String var3 = $task != null ? "local_" + $task.getId() : "";
         String var4 = AddTaskDialog$lambda$290($newSubTaskTitle$delegate);
         $subTasks.add(new SubTaskEntity(0, "", var3, var4, (Long)null, (Long)null, false, 0L, (Long)null, 384, (DefaultConstructorMarker)null));
         AddTaskDialog$lambda$291($newSubTaskTitle$delegate, "");
      }

      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit AddTaskDialog$lambda$354(MutableState $title$delegate, MutableState $description$delegate, MutableState $isTimeBoxed$delegate, Context $context, MutableState $hour$delegate, MutableState $minute$delegate, MutableState $duration$delegate, MutableState $isMeeting$delegate, MutableState $hasReminder$delegate, MutableState $reminderMinutesBefore$delegate, MutableState $customReminderTime$delegate, SnapshotStateList $subTasks, TaskEntity $task, MutableState $newSubTaskTitle$delegate, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1322@60152L21,1319@60036L13771:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(213479788, $changed, -1, "com.example.AddTaskDialog.<anonymous> (MainActivity.kt:1319)");
         }

         Modifier var16 = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior)null, false, 14, (Object)null);
         int var17 = 12;
         int var18 = 0;
         Arrangement.Vertical var156 = (Arrangement.Vertical)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var17));
         byte var20 = 48;
         int var21 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Alignment.Horizontal var157 = Alignment.Companion.getStart();
         MeasurePolicy var22 = ColumnKt.columnMeasurePolicy(var156, var157, $composer, 14 & var20 >> 3 | 112 & var20 >> 3);
         int var23 = 112 & var20 << 3;
         int var24 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var25 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var26 = $composer.getCurrentCompositionLocalMap();
         Modifier var27 = ComposedModifierKt.materializeModifier($composer, var16);
         Function0 var28 = ComposeUiNode.Companion.getConstructor();
         int var29 = 6 | 896 & var23 << 6;
         int var30 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var28);
         } else {
            $composer.useNode();
         }

         Composer var31 = Updater.constructor-impl($composer);
         int var32 = 0;
         Updater.set-impl(var31, var22, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var31, var26, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var33 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var34 = 0;
         int var36 = 0;
         if (var31.getInserting() || !Intrinsics.areEqual(var31.rememberedValue(), var25)) {
            var31.updateRememberedValue(var25);
            var31.apply(var25, var33);
         }

         Updater.set-impl(var31, var27, ComposeUiNode.Companion.getSetModifier());
         int var37 = 14 & var29 >> 6;
         int var39 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var40 = 6 | 112 & var20 >> 6;
         ColumnScope var10000 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var43 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 96036914, "C1327@60364L14,1325@60274L319,1336@60707L20,1334@60611L366,1344@60995L401,1506@70218L40,1507@70275L74,1509@70367L3426:MainActivity.kt#to5c3");
         String var44 = AddTaskDialog$lambda$252($title$delegate);
         Modifier var45 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var46 = 12;
         int var47 = 0;
         RoundedCornerShape var48 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var46));
         String var333 = var44;
         ComposerKt.sourceInformationMarkerStart($composer, 141634672, "CC(remember):MainActivity.kt#9igjgp");
         boolean var49 = (boolean)0;
         int var50 = 0;
         Object var51 = $composer.rememberedValue();
         int var52 = 0;
         Object var10001;
         if (var51 == Composer.Companion.getEmpty()) {
            int var54 = 0;
            Function1 var56_1 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$299$lambda$298;
            var333 = var44;
            $composer.updateRememberedValue(var56_1);
            var10001 = var56_1;
         } else {
            var10001 = var51;
         }

         Function1 var174 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         OutlinedTextFieldKt.OutlinedTextField(var333, var174, var45, false, false, (TextStyle)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$-1416378372$app(), (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, false, (VisualTransformation)null, (KeyboardOptions)null, (KeyboardActions)null, true, 0, 0, (MutableInteractionSource)null, (Shape)var48, (TextFieldColors)null, $composer, 1573296, 12582912, 0, 6160312);
         var44 = AddTaskDialog$lambda$255($description$delegate);
         var45 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var175 = 12;
         var47 = 0;
         var48 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var175));
         var333 = var44;
         ComposerKt.sourceInformationMarkerStart($composer, 141645654, "CC(remember):MainActivity.kt#9igjgp");
         var49 = (boolean)0;
         var50 = 0;
         var51 = $composer.rememberedValue();
         var52 = 0;
         if (var51 == Composer.Companion.getEmpty()) {
            int var205 = 0;
            Function1 var56_1 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$301$lambda$300;
            var333 = var44;
            $composer.updateRememberedValue(var56_1);
            var10001 = var56_1;
         } else {
            var10001 = var51;
         }

         Function1 var176 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         OutlinedTextFieldKt.OutlinedTextField(var333, var176, var45, false, false, (TextStyle)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$-1559172109$app(), (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, false, (VisualTransformation)null, (KeyboardOptions)null, (KeyboardActions)null, false, 4, 2, (MutableInteractionSource)null, (Shape)var48, (TextFieldColors)null, $composer, 1573296, 905969664, 0, 5504952);
         Modifier var159 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Alignment.Vertical var167 = Alignment.Companion.getCenterVertically();
         Arrangement.HorizontalOrVertical var184 = Arrangement.INSTANCE.getSpaceBetween();
         Arrangement.Horizontal var179 = (Arrangement.Horizontal)var184;
         int var196 = 438;
         var52 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         MeasurePolicy var206 = RowKt.rowMeasurePolicy(var179, var167, $composer, 14 & var196 >> 3 | 112 & var196 >> 3);
         int var56 = 112 & var196 << 3;
         int var57 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var58 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var59 = $composer.getCurrentCompositionLocalMap();
         Modifier var60 = ComposedModifierKt.materializeModifier($composer, var159);
         Function0 var61 = ComposeUiNode.Companion.getConstructor();
         int var62 = 6 | 896 & var56 << 6;
         int var63 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var61);
         } else {
            $composer.useNode();
         }

         Composer var64 = Updater.constructor-impl($composer);
         int var65 = 0;
         Updater.set-impl(var64, var206, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var64, var59, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var66 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var67 = 0;
         int var69 = 0;
         if (var64.getInserting() || !Intrinsics.areEqual(var64.rememberedValue(), var58)) {
            var64.updateRememberedValue(var58);
            var64.apply(var58, var66);
         }

         Updater.set-impl(var64, var60, ComposeUiNode.Companion.getSetModifier());
         int var70 = 14 & var62 >> 6;
         int var72 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var73 = 6 | 112 & var196 >> 6;
         RowScope var335 = (RowScope)RowScopeInstance.INSTANCE;
         int var76 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -432248756, "C1349@61233L55,1350@61357L20,1350@61309L69:MainActivity.kt#to5c3");
         TextKt.Text--4IGK_g("Time-Boxed Plan", (Modifier)null, 0L, 0L, (FontStyle)null, FontWeight.Companion.getMedium(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 196614, 0, 131038);
         boolean var336 = AddTaskDialog$lambda$258($isTimeBoxed$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, -706676326, "CC(remember):MainActivity.kt#9igjgp");
         boolean var78 = (boolean)0;
         int var79 = 0;
         Object var80 = $composer.rememberedValue();
         int var81 = 0;
         if (var80 == Composer.Companion.getEmpty()) {
            boolean var82 = var336;
            int var83 = 0;
            Function1 var85_1 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$304$lambda$303$lambda$302;
            var336 = var82;
            $composer.updateRememberedValue(var85_1);
            var10001 = var85_1;
         } else {
            var10001 = var80;
         }

         Function1 var86 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SwitchKt.Switch(var336, var86, (Modifier)null, (Function2)null, false, (SwitchColors)null, (MutableInteractionSource)null, $composer, 48, 124);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         if (AddTaskDialog$lambda$258($isTimeBoxed$delegate)) {
            $composer.startReplaceGroup(96927264);
            ComposerKt.sourceInformation($composer, "1355@61547L11,1355@61505L87,1358@61734L4895,1354@61453L5176");
            CardColors var162 = CardDefaults.INSTANCE.cardColors-ro_MJ88(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.03F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
            int var187 = 16;
            int var177 = 0;
            RoundedCornerShape var170 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var187));
            Modifier var188 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            CardKt.Card(var188, (Shape)var170, var162, (CardElevation)null, (BorderStroke)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-419986833, true, MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$329, $composer, 54), $composer, 196614, 24);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(102055749);
            ComposerKt.sourceInformation($composer, "1445@66675L426");
            var159 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            var167 = Alignment.Companion.getCenterVertically();
            var184 = Arrangement.INSTANCE.getSpaceBetween();
            var179 = (Arrangement.Horizontal)var184;
            var196 = (short)438;
            var52 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            var206 = RowKt.rowMeasurePolicy(var179, var167, $composer, 14 & var196 >> 3 | 112 & var196 >> 3);
            var56 = 112 & var196 << 3;
            var57 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            var58 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            var59 = $composer.getCurrentCompositionLocalMap();
            var60 = ComposedModifierKt.materializeModifier($composer, var159);
            var61 = ComposeUiNode.Companion.getConstructor();
            var62 = 6 | 896 & var56 << 6;
            var63 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var61);
            } else {
               $composer.useNode();
            }

            var64 = Updater.constructor-impl($composer);
            var65 = 0;
            Updater.set-impl(var64, var206, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var64, var59, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            var66 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            var67 = 0;
            var69 = 0;
            if (var64.getInserting() || !Intrinsics.areEqual(var64.rememberedValue(), var58)) {
               var64.updateRememberedValue(var58);
               var64.apply(var58, var66);
            }

            Updater.set-impl(var64, var60, ComposeUiNode.Companion.getSetModifier());
            var70 = 14 & var62 >> 6;
            var72 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            var73 = 6 | 112 & var196 >> 6;
            RowScope var337 = (RowScope)RowScopeInstance.INSTANCE;
            var76 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -453993017, "C1450@66933L52,1451@67058L20,1451@67010L69:MainActivity.kt#to5c3");
            TextKt.Text--4IGK_g("Add Reminder", (Modifier)null, 0L, 0L, (FontStyle)null, FontWeight.Companion.getMedium(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 196614, 0, 131038);
            boolean var338 = AddTaskDialog$lambda$279($hasReminder$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 123906270, "CC(remember):MainActivity.kt#9igjgp");
            var78 = (boolean)0;
            var79 = 0;
            var80 = $composer.rememberedValue();
            var81 = 0;
            if (var80 == Composer.Companion.getEmpty()) {
               boolean var280 = var338;
               int var284 = 0;
               Function1 var85_1 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$332$lambda$331$lambda$330;
               var338 = var280;
               $composer.updateRememberedValue(var85_1);
               var10001 = var85_1;
            } else {
               var10001 = var80;
            }

            var86 = (Function1)var10001;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SwitchKt.Switch(var338, var86, (Modifier)null, (Function2)null, false, (SwitchColors)null, (MutableInteractionSource)null, $composer, 48, 124);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (AddTaskDialog$lambda$279($hasReminder$delegate)) {
               $composer.startReplaceGroup(102523198);
               ComposerKt.sourceInformation($composer, "1455@67166L2994");
               var159 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
               var167 = Alignment.Companion.getCenterVertically();
               var184 = Arrangement.INSTANCE.getSpaceBetween();
               var179 = (Arrangement.Horizontal)var184;
               var196 = (short)438;
               var52 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
               var206 = RowKt.rowMeasurePolicy(var179, var167, $composer, 14 & var196 >> 3 | 112 & var196 >> 3);
               var56 = 112 & var196 << 3;
               var57 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
               var58 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
               var59 = $composer.getCurrentCompositionLocalMap();
               var60 = ComposedModifierKt.materializeModifier($composer, var159);
               var61 = ComposeUiNode.Companion.getConstructor();
               var62 = 6 | 896 & var56 << 6;
               var63 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
               if (!($composer.getApplier() instanceof Applier)) {
                  ComposablesKt.invalidApplier();
               }

               $composer.startReusableNode();
               if ($composer.getInserting()) {
                  $composer.createNode(var61);
               } else {
                  $composer.useNode();
               }

               var64 = Updater.constructor-impl($composer);
               var65 = 0;
               Updater.set-impl(var64, var206, ComposeUiNode.Companion.getSetMeasurePolicy());
               Updater.set-impl(var64, var59, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
               var66 = ComposeUiNode.Companion.getSetCompositeKeyHash();
               var67 = 0;
               var69 = 0;
               if (var64.getInserting() || !Intrinsics.areEqual(var64.rememberedValue(), var58)) {
                  var64.updateRememberedValue(var58);
                  var64.apply(var58, var66);
               }

               Updater.set-impl(var64, var60, ComposeUiNode.Companion.getSetModifier());
               var70 = 14 & var62 >> 6;
               var72 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
               var73 = 6 | 112 & var196 >> 6;
               RowScope var339 = (RowScope)RowScopeInstance.INSTANCE;
               var76 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, -249856548, "C1460@67444L55,1491@69507L85,1462@67578L1871,1493@69690L444,1461@67528L2606:MainActivity.kt#to5c3");
               TextKt.Text--4IGK_g("Reminder Time", (Modifier)null, 0L, 0L, (FontStyle)null, FontWeight.Companion.getSemiBold(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 196614, 0, 131038);
               ButtonColors var77 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(Color.copy-wmQWz5c$default(ColorKt.getIndigo600(), 0.1F, 0.0F, 0.0F, 0.0F, 14, (Object)null), ColorKt.getIndigo600(), 0L, 0L, $composer, 54 | ButtonDefaults.$stable << 12, 12);
               var78 = (boolean)10;
               var79 = 0;
               RoundedCornerShape var274 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var78));
               ComposerKt.sourceInformationMarkerStart($composer, -285151084, "CC(remember):MainActivity.kt#9igjgp");
               var81 = $composer.changedInstance($context);
               int var281 = 0;
               Object var285 = $composer.rememberedValue();
               int var289 = 0;
               Object var340;
               if (!var81 && var285 != Composer.Companion.getEmpty()) {
                  var340 = var285;
               } else {
                  int var85 = 0;
                  Object var295 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$339$lambda$337$lambda$336;
                  $composer.updateRememberedValue(var295);
                  var340 = var295;
               }

               Function0 var266 = (Function0)var340;
               ComposerKt.sourceInformationMarkerEnd($composer);
               ButtonKt.Button(var266, (Modifier)null, false, (Shape)var274, var77, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, (Function3)ComposableLambdaKt.rememberComposableLambda(-1850702347, true, MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$339$lambda$338, $composer, 54), $composer, 805306368, 486);
               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               $composer.endNode();
               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               $composer.endReplaceGroup();
            } else {
               $composer.startReplaceGroup(35825024);
               $composer.endReplaceGroup();
            }

            $composer.endReplaceGroup();
         }

         Modifier var341 = (Modifier)Modifier.Companion;
         int var163 = 8;
         int var171 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var341, Dp.constructor-impl((float)var163)), $composer, 6);
         FontWeight var164 = FontWeight.Companion.getBold();
         long var87 = TextUnitKt.getSp(16);
         TextKt.Text--4IGK_g("Subtasks Checklist", (Modifier)null, 0L, var87, (FontStyle)null, var164, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 131030);
         var171 = 6;
         int var189 = 0;
         Arrangement.Vertical var173 = (Arrangement.Vertical)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var171));
         int var182 = 48;
         var49 = (boolean)0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Modifier var165 = (Modifier)Modifier.Companion;
         Alignment.Horizontal var190 = Alignment.Companion.getStart();
         MeasurePolicy var194 = ColumnKt.columnMeasurePolicy(var173, var190, $composer, 14 & var182 >> 3 | 112 & var182 >> 3);
         var196 = 112 & var182 << 3;
         var52 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var209 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var213 = $composer.getCurrentCompositionLocalMap();
         Modifier var216 = ComposedModifierKt.materializeModifier($composer, var165);
         Function0 var219 = ComposeUiNode.Companion.getConstructor();
         int var222 = 6 | 896 & var196 << 6;
         int var225 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var219);
         } else {
            $composer.useNode();
         }

         Composer var228 = Updater.constructor-impl($composer);
         var62 = 0;
         Updater.set-impl(var228, var194, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var228, var213, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var234 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var237 = 0;
         int var242 = 0;
         if (var228.getInserting() || !Intrinsics.areEqual(var228.rememberedValue(), var209)) {
            var228.updateRememberedValue(var209);
            var228.apply(var209, var234);
         }

         Updater.set-impl(var228, var216, ComposeUiNode.Companion.getSetModifier());
         var67 = 14 & var222 >> 6;
         var69 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         var70 = 6 | 112 & var182 >> 6;
         Composer var110_1 = $composer;
         ColumnScope var342 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         var73 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1381608202, "C1534@71889L1886:MainActivity.kt#to5c3");
         $composer.startReplaceGroup(-1479454276);
         ComposerKt.sourceInformation($composer, "*1511@70510L1335");
         Iterable var74 = (Iterable)$subTasks;
         int var75 = 0;
         var76 = 0;

         for(Object var267 : var74) {
            var79 = var76++;
            if (var79 < 0) {
               CollectionsKt.throwIndexOverflow();
            }

            var80 = (SubTaskEntity)var267;
            int var282 = 0;
            Modifier var286 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
            Alignment.Vertical var85_1 = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical var292 = Arrangement.INSTANCE.getSpaceBetween();
            Arrangement.Horizontal var89 = (Arrangement.Horizontal)var292;
            short var92 = 438;
            int var93 = 0;
            ComposerKt.sourceInformationMarkerStart(var110_1, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy var94 = RowKt.rowMeasurePolicy(var89, var85_1, var110_1, 14 & var92 >> 3 | 112 & var92 >> 3);
            int var95 = 112 & var92 << 3;
            int var96 = 0;
            ComposerKt.sourceInformationMarkerStart(var110_1, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var97 = ComposablesKt.getCurrentCompositeKeyHash(var110_1, 0);
            CompositionLocalMap var98 = var110_1.getCurrentCompositionLocalMap();
            Modifier var99 = ComposedModifierKt.materializeModifier(var110_1, var286);
            Function0 var100 = ComposeUiNode.Companion.getConstructor();
            int var101 = 6 | 896 & var95 << 6;
            int var102 = 0;
            ComposerKt.sourceInformationMarkerStart(var110_1, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(var110_1.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            var110_1.startReusableNode();
            if (var110_1.getInserting()) {
               var110_1.createNode(var100);
            } else {
               var110_1.useNode();
            }

            Composer var103 = Updater.constructor-impl(var110_1);
            int var104 = 0;
            Updater.set-impl(var103, var94, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var103, var98, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var105 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var106 = 0;
            int var108 = 0;
            if (var103.getInserting() || !Intrinsics.areEqual(var103.rememberedValue(), var97)) {
               var103.updateRememberedValue(var97);
               var103.apply(var97, var105);
            }

            Updater.set-impl(var103, var99, ComposeUiNode.Companion.getSetModifier());
            int var109 = 14 & var101 >> 6;
            int var111 = 0;
            ComposerKt.sourceInformationMarkerStart(var110_1, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            int var112 = 6 | 112 & var92 >> 6;
            RowScope var114 = (RowScope)RowScopeInstance.INSTANCE;
            int var115 = 0;
            ComposerKt.sourceInformationMarkerStart(var110_1, 370927977, "C1516@70788L771,1528@71609L28,1528@71588L231:MainActivity.kt#to5c3");
            Alignment.Vertical var116 = Alignment.Companion.getCenterVertically();
            Modifier var117 = RowScope.weight$default(var114, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
            int var120 = 384;
            int var121 = 0;
            ComposerKt.sourceInformationMarkerStart(var110_1, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Arrangement.Horizontal var122 = Arrangement.INSTANCE.getStart();
            MeasurePolicy var123 = RowKt.rowMeasurePolicy(var122, var116, var110_1, 14 & var120 >> 3 | 112 & var120 >> 3);
            int var124 = 112 & var120 << 3;
            int var125 = 0;
            ComposerKt.sourceInformationMarkerStart(var110_1, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var126 = ComposablesKt.getCurrentCompositeKeyHash(var110_1, 0);
            CompositionLocalMap var127 = var110_1.getCurrentCompositionLocalMap();
            Modifier var128 = ComposedModifierKt.materializeModifier(var110_1, var117);
            Function0 var129 = ComposeUiNode.Companion.getConstructor();
            int var130 = 6 | 896 & var124 << 6;
            int var131 = 0;
            ComposerKt.sourceInformationMarkerStart(var110_1, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(var110_1.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            var110_1.startReusableNode();
            if (var110_1.getInserting()) {
               var110_1.createNode(var129);
            } else {
               var110_1.useNode();
            }

            Composer var132 = Updater.constructor-impl(var110_1);
            int var133 = 0;
            Updater.set-impl(var132, var123, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var132, var127, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var134 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var135 = 0;
            int var137 = 0;
            if (var132.getInserting() || !Intrinsics.areEqual(var132.rememberedValue(), var126)) {
               var132.updateRememberedValue(var126);
               var132.apply(var126, var134);
            }

            Updater.set-impl(var132, var128, ComposeUiNode.Companion.getSetModifier());
            int var138 = 14 & var130 >> 6;
            int var140 = 0;
            ComposerKt.sourceInformationMarkerStart(var110_1, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            int var141 = 6 | 112 & var120 >> 6;
            RowScope var344 = (RowScope)RowScopeInstance.INSTANCE;
            int var144 = 0;
            ComposerKt.sourceInformationMarkerStart(var110_1, 1292627429, "C1519@71033L144,1517@70906L305,1523@71244L285:MainActivity.kt#to5c3");
            boolean var345 = ((SubTaskEntity)var80).isCompleted();
            ComposerKt.sourceInformationMarkerStart(var110_1, -928130081, "CC(remember):MainActivity.kt#9igjgp");
            boolean var146 = var110_1.changed(var79) | var110_1.changed(var80);
            int var147 = 0;
            Object var148 = var110_1.rememberedValue();
            int var149 = 0;
            if (!var146 && var148 != Composer.Companion.getEmpty()) {
               var10001 = var148;
            } else {
               boolean var150 = var345;
               int var151 = 0;
               Function1 var153_1 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$352$lambda$346$lambda$345$lambda$342$lambda$341$lambda$340;
               var345 = var150;
               var110_1.updateRememberedValue(var153_1);
               var10001 = var153_1;
            }

            Function1 var154 = (Function1)var10001;
            ComposerKt.sourceInformationMarkerEnd(var110_1);
            CheckboxKt.Checkbox(var345, var154, (Modifier)null, false, (CheckboxColors)null, (MutableInteractionSource)null, var110_1, 0, 60);
            String var346 = ((SubTaskEntity)var80).getTitle();
            TextStyle var10016;
            if (((SubTaskEntity)var80).isCompleted()) {
               var110_1.startReplaceGroup(-928118272);
               ComposerKt.sourceInformation(var110_1, "1525@71383L10");
               TextStyle var331 = TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography(var110_1, MaterialTheme.$stable).getBodyMedium(), 0L, 0L, (FontWeight)null, (FontStyle)null, (FontSynthesis)null, (FontFamily)null, (String)null, 0L, (BaselineShift)null, (TextGeometricTransform)null, (LocaleList)null, 0L, TextDecoration.Companion.getLineThrough(), (Shadow)null, (DrawStyle)null, 0, 0, 0L, (TextIndent)null, (PlatformTextStyle)null, (LineHeightStyle)null, 0, 0, (TextMotion)null, 16773119, (Object)null);
               var110_1.endReplaceGroup();
               var10016 = var331;
            } else {
               var110_1.startReplaceGroup(-928115751);
               ComposerKt.sourceInformation(var110_1, "1525@71474L10");
               TextStyle var332 = MaterialTheme.INSTANCE.getTypography(var110_1, MaterialTheme.$stable).getBodyMedium();
               var110_1.endReplaceGroup();
               var10016 = var332;
            }

            TextKt.Text--4IGK_g(var346, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, var10016, var110_1, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(var110_1);
            ComposerKt.sourceInformationMarkerEnd(var110_1);
            var110_1.endNode();
            ComposerKt.sourceInformationMarkerEnd(var110_1);
            ComposerKt.sourceInformationMarkerEnd(var110_1);
            ComposerKt.sourceInformationMarkerEnd(var110_1);
            ComposerKt.sourceInformationMarkerStart(var110_1, -542198641, "CC(remember):MainActivity.kt#9igjgp");
            boolean var327 = var110_1.changed(var79);
            int var330 = 0;
            Object var118 = var110_1.rememberedValue();
            int var119 = 0;
            Object var347;
            if (!var327 && var118 != Composer.Companion.getEmpty()) {
               var347 = var118;
            } else {
               var120 = 0;
               Object var329 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$352$lambda$346$lambda$345$lambda$344$lambda$343;
               var110_1.updateRememberedValue(var329);
               var347 = var329;
            }

            Function0 var326 = (Function0)var347;
            ComposerKt.sourceInformationMarkerEnd(var110_1);
            IconButtonKt.IconButton(var326, (Modifier)null, false, (IconButtonColors)null, (MutableInteractionSource)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$-955061994$app(), var110_1, 196608, 30);
            ComposerKt.sourceInformationMarkerEnd(var110_1);
            ComposerKt.sourceInformationMarkerEnd(var110_1);
            var110_1.endNode();
            ComposerKt.sourceInformationMarkerEnd(var110_1);
            ComposerKt.sourceInformationMarkerEnd(var110_1);
            ComposerKt.sourceInformationMarkerEnd(var110_1);
         }

         var110_1.endReplaceGroup();
         Modifier var257 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Alignment.Vertical var262 = Alignment.Companion.getCenterVertically();
         var78 = (boolean)390;
         var79 = 0;
         ComposerKt.sourceInformationMarkerStart(var110_1, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var258 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var276 = RowKt.rowMeasurePolicy(var258, var262, var110_1, 14 & var78 >> 3 | 112 & var78 >> 3);
         var81 = 112 & var78 << 3;
         int var283 = 0;
         ComposerKt.sourceInformationMarkerStart(var110_1, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var287 = ComposablesKt.getCurrentCompositeKeyHash(var110_1, 0);
         CompositionLocalMap var85_1 = var110_1.getCurrentCompositionLocalMap();
         Modifier var293 = ComposedModifierKt.materializeModifier(var110_1, var257);
         Function0 var296 = ComposeUiNode.Companion.getConstructor();
         int var297 = 6 | 896 & var81 << 6;
         int var90 = 0;
         ComposerKt.sourceInformationMarkerStart(var110_1, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!(var110_1.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         var110_1.startReusableNode();
         if (var110_1.getInserting()) {
            var110_1.createNode(var296);
         } else {
            var110_1.useNode();
         }

         Composer var91 = Updater.constructor-impl(var110_1);
         int var298 = 0;
         Updater.set-impl(var91, var276, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var91, var85_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var299 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var300 = 0;
         int var301 = 0;
         if (var91.getInserting() || !Intrinsics.areEqual(var91.rememberedValue(), var287)) {
            var91.updateRememberedValue(var287);
            var91.apply(var287, var299);
         }

         Updater.set-impl(var91, var293, ComposeUiNode.Companion.getSetModifier());
         int var302 = 14 & var297 >> 6;
         int var303 = 0;
         ComposerKt.sourceInformationMarkerStart(var110_1, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var304 = 6 | 112 & var78 >> 6;
         RowScope var305 = (RowScope)RowScopeInstance.INSTANCE;
         int var306 = 0;
         ComposerKt.sourceInformationMarkerStart(var110_1, 972267767, "C1540@72189L24,1538@72073L412,1546@72510L39,1548@72624L843,1564@73525L72,1547@72574L1179:MainActivity.kt#to5c3");
         String var307 = AddTaskDialog$lambda$290($newSubTaskTitle$delegate);
         Modifier var310 = RowScope.weight$default(var305, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         int var312 = 8;
         int var107 = 0;
         RoundedCornerShape var316 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var312));
         String var348 = var307;
         ComposerKt.sourceInformationMarkerStart(var110_1, -245729132, "CC(remember):MainActivity.kt#9igjgp");
         boolean var318 = (boolean)0;
         int var110 = 0;
         Object var321 = var110_1.rememberedValue();
         int var323 = 0;
         if (var321 == Composer.Companion.getEmpty()) {
            int var324 = 0;
            Function1 var355 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$352$lambda$351$lambda$348$lambda$347;
            var348 = var307;
            Object var325 = var355;
            var110_1.updateRememberedValue(var325);
            var10001 = var325;
         } else {
            var10001 = var321;
         }

         Function1 var313 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd(var110_1);
         OutlinedTextFieldKt.OutlinedTextField(var348, var313, var310, false, false, (TextStyle)null, (Function2)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$-320843275$app(), (Function2)null, (Function2)null, (Function2)null, (Function2)null, (Function2)null, false, (VisualTransformation)null, (KeyboardOptions)null, (KeyboardActions)null, true, 0, 0, (MutableInteractionSource)null, (Shape)var316, (TextFieldColors)null, var110_1, 12582960, 12582912, 0, 6160248);
         Modifier var349 = (Modifier)Modifier.Companion;
         int var308 = 8;
         int var311 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var349, Dp.constructor-impl((float)var308)), var110_1, 6);
         ComposerKt.sourceInformationMarkerStart(var110_1, -245714393, "CC(remember):MainActivity.kt#9igjgp");
         boolean var317 = var110_1.changed($task);
         int var314 = 0;
         Object var315 = var110_1.rememberedValue();
         var318 = (boolean)0;
         Object var350;
         if (!var317 && var315 != Composer.Companion.getEmpty()) {
            var350 = var315;
         } else {
            var110 = 0;
            var321 = MainActivityKt::AddTaskDialog$lambda$354$lambda$353$lambda$352$lambda$351$lambda$350$lambda$349;
            var110_1.updateRememberedValue(var321);
            var350 = var321;
         }

         Function0 var309 = (Function0)var350;
         ComposerKt.sourceInformationMarkerEnd(var110_1);
         IconButtonKt.IconButton(var309, (Modifier)null, false, IconButtonDefaults.INSTANCE.iconButtonColors-ro_MJ88(ColorKt.getIndigo600(), Color.Companion.getWhite-0d7_KjU(), 0L, 0L, var110_1, 54 | IconButtonDefaults.$stable << 12, 12), (MutableInteractionSource)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1191297817$app(), var110_1, 196608, 22);
         ComposerKt.sourceInformationMarkerEnd(var110_1);
         ComposerKt.sourceInformationMarkerEnd(var110_1);
         var110_1.endNode();
         ComposerKt.sourceInformationMarkerEnd(var110_1);
         ComposerKt.sourceInformationMarkerEnd(var110_1);
         ComposerKt.sourceInformationMarkerEnd(var110_1);
         ComposerKt.sourceInformationMarkerEnd(var110_1);
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

   private static final Unit AddTaskDialog$lambda$355(TaskEntity $task, boolean $isCreatingPlan, List $initialSubTasks, Integer $prefilledHour, Function0 $onDismiss, Function0 $onDelete, Function12 $onSave, int $$changed, Composer $composer, int $force) {
      AddTaskDialog($task, $isCreatingPlan, $initialSubTasks, $prefilledHour, $onDismiss, $onDelete, $onSave, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final List TaskDetailDialog$lambda$356(State $subTasks$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$subTasks$delegate.getValue();
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit TaskDetailDialog$lambda$359(Function0 $onDismiss, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1704@78908L40,1702@78823L185:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1227680170, $changed, -1, "com.example.TaskDetailDialog.<anonymous> (MainActivity.kt:1702)");
         }

         ButtonKt.Button($onDismiss, (Modifier)null, false, (Shape)null, ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(ColorKt.getIndigo600(), 0L, 0L, 0L, $composer, 6 | ButtonDefaults.$stable << 12, 14), (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$562488902$app(), $composer, 805306368, 494);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit TaskDetailDialog$lambda$362$lambda$361$lambda$360(Function1 $onDelete, TaskEntity $task) {
      $onDelete.invoke($task);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit TaskDetailDialog$lambda$362(Function1 $onDelete, TaskEntity $task, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1711@79096L54,1710@79058L172:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-729123368, $changed, -1, "com.example.TaskDetailDialog.<anonymous> (MainActivity.kt:1710)");
         }

         ComposerKt.sourceInformationMarkerStart($composer, -607885682, "CC(remember):MainActivity.kt#9igjgp");
         boolean var6 = $composer.changed($onDelete) | $composer.changed($task);
         int var7 = 0;
         Object var8 = $composer.rememberedValue();
         int var9 = 0;
         Object var10000;
         if (!var6 && var8 != Composer.Companion.getEmpty()) {
            var10000 = var8;
         } else {
            int var10 = 0;
            Object var11 = MainActivityKt::TaskDetailDialog$lambda$362$lambda$361$lambda$360;
            $composer.updateRememberedValue(var11);
            var10000 = var11;
         }

         Function0 var4 = (Function0)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.TextButton(var4, (Modifier)null, false, (Shape)null, (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1684216341$app(), $composer, 805306368, 510);
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
   private static final Unit TaskDetailDialog$lambda$363(TaskEntity $task, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1629@75647L133:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-230566566, $changed, -1, "com.example.TaskDetailDialog.<anonymous> (MainActivity.kt:1629)");
         }

         String var3 = $task.getTitle();
         FontWeight var4 = FontWeight.Companion.getBold();
         long var5 = TextUnitKt.getSp(20);
         TextKt.Text--4IGK_g(var3, (Modifier)null, 0L, var5, (FontStyle)null, var4, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131030);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit TaskDetailDialog$lambda$373$lambda$372$lambda$371$lambda$370$lambda$369$lambda$368(PlannerViewModel $plannerViewModel, SubTaskEntity $sub, AuthManager $authManager, CalendarSyncViewModel $syncViewModel, boolean isChecked) {
      $plannerViewModel.toggleSubTaskCompletion($sub, isChecked, $authManager, $syncViewModel);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit TaskDetailDialog$lambda$373(TaskEntity $task, List $taskSubTasks, PlannerViewModel $plannerViewModel, AuthManager $authManager, CalendarSyncViewModel $syncViewModel, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C1639@75937L21,1636@75821L2952:MainActivity.kt#to5c3");
      if (($changed & 3) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(18711835, $changed, -1, "com.example.TaskDetailDialog.<anonymous> (MainActivity.kt:1636)");
         }

         Modifier var7 = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior)null, false, 14, (Object)null);
         int var8 = 8;
         int var9 = 0;
         Arrangement.Vertical var89 = (Arrangement.Vertical)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var8));
         byte var11 = 48;
         int var12 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Alignment.Horizontal var90 = Alignment.Companion.getStart();
         MeasurePolicy var13 = ColumnKt.columnMeasurePolicy(var89, var90, $composer, 14 & var11 >> 3 | 112 & var11 >> 3);
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
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var31 = 6 | 112 & var11 >> 6;
         Composer var73_1 = $composer;
         ColumnScope var10000 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var34 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 538590117, "C:MainActivity.kt#to5c3");
         if ($task.isTimeBoxed()) {
            $composer.startReplaceGroup(538544701);
            ComposerKt.sourceInformation($composer, "1643@76112L59,1646@76360L234");
            ComposerKt.sourceInformationMarkerStart($composer, -675363700, "CC(remember):MainActivity.kt#9igjgp");
            boolean var36 = false;
            int var37 = 0;
            Object var38 = $composer.rememberedValue();
            int var39 = 0;
            Object var121;
            if (var38 == Composer.Companion.getEmpty()) {
               int var40 = 0;
               Object var103 = new SimpleDateFormat("HH:mm", Locale.getDefault());
               $composer.updateRememberedValue(var103);
               var121 = var103;
            } else {
               var121 = var38;
            }

            SimpleDateFormat var42;
            label143: {
               SimpleDateFormat var41 = (SimpleDateFormat)var121;
               ComposerKt.sourceInformationMarkerEnd($composer);
               var42 = var41;
               Long var122 = $task.getStartTime();
               if (var122 != null) {
                  long var43 = ((Number)var122).longValue();
                  int var104 = 0;
                  var123 = var41.format(new Date(var43));
                  if (var123 != null) {
                     break label143;
                  }
               }

               var123 = "";
            }

            String var107;
            label138: {
               var107 = var123;
               Long var124 = $task.getEndTime();
               if (var124 != null) {
                  long var45 = ((Number)var124).longValue();
                  int var47 = 0;
                  var125 = var42.format(new Date(var45));
                  if (var125 != null) {
                     break label138;
                  }
               }

               var125 = "";
            }

            String var42_9 = var125;
            String var94 = "Time slot: " + var107 + " - " + var42_9;
            FontWeight var96 = FontWeight.Companion.getSemiBold();
            long var114 = ColorKt.getIndigo600();
            long var48 = TextUnitKt.getSp(14);
            TextKt.Text--4IGK_g(var94, (Modifier)null, var114, var48, (FontStyle)null, var96, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 200064, 0, 131026);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(463055857);
            $composer.endReplaceGroup();
         }

         CharSequence var111 = (CharSequence)$task.getDescription();
         if (var111 == null || StringsKt.isBlank(var111)) {
            $composer.startReplaceGroup(463055857);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(539133918);
            ComposerKt.sourceInformation($composer, "1655@76707L367");
            String var108 = $task.getDescription();
            ComposerKt.sourceInformationMarkerStart($composer, -675344352, "CC(remember):MainActivity.kt#9igjgp");
            boolean var97 = $composer.changed(var108);
            int var99 = 0;
            Object var101 = $composer.rememberedValue();
            int var105 = 0;
            Object var127;
            if (!var97 && var101 != Composer.Companion.getEmpty()) {
               var127 = var101;
            } else {
               int var116 = 0;
               String var126 = $task.getDescription();
               if (var126 == null) {
                  var126 = "";
               }

               String var50 = var126;
               Object var51 = StringsKt.contains$default((CharSequence)var50, (CharSequence)"\n\nTasks:\n", false, 2, (Object)null) ? StringsKt.substringBefore$default(var50, "\n\nTasks:\n", (String)null, 2, (Object)null) : (StringsKt.startsWith$default(var50, "Tasks:\n", false, 2, (Object)null) ? "" : var50);
               $composer.updateRememberedValue(var51);
               var127 = var51;
            }

            String var42_9 = (String)var127;
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (!StringsKt.isBlank((CharSequence)var42_9)) {
               $composer.startReplaceGroup(539569654);
               ComposerKt.sourceInformation($composer, "1666@77251L11,1664@77149L171");
               TextKt.Text--4IGK_g(var42_9, (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131066);
               $composer.endReplaceGroup();
            } else {
               $composer.startReplaceGroup(463055857);
               $composer.endReplaceGroup();
            }

            $composer.endReplaceGroup();
         }

         if (((Collection)$taskSubTasks).isEmpty()) {
            $composer.startReplaceGroup(463055857);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(539888427);
            ComposerKt.sourceInformation($composer, "1672@77431L40,1677@77684L11,1673@77492L305,*1682@77873L846");
            Modifier var128 = (Modifier)Modifier.Companion;
            int var112 = 8;
            int var109 = 0;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(var128, Dp.constructor-impl((float)var112)), $composer, 6);
            long var52 = TextUnitKt.getSp(11);
            FontWeight var42_9 = FontWeight.Companion.getBold();
            long var54 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.4F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            long var115 = TextUnitKt.getSp((double)1.5F);
            TextKt.Text--4IGK_g("CHECKLIST", (Modifier)null, var54, var52, (FontStyle)null, var42_9, (FontFamily)null, var115, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 12782598, 0, 130898);
            Iterable var113 = (Iterable)$taskSubTasks;
            var109 = 0;

            for(Object var95 : var113) {
               SubTaskEntity var98 = (SubTaskEntity)var95;
               int var100 = 0;
               Modifier var102 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
               Alignment.Vertical var106 = Alignment.Companion.getCenterVertically();
               short var117 = 390;
               int var118 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
               Arrangement.Horizontal var56 = Arrangement.INSTANCE.getStart();
               MeasurePolicy var57 = RowKt.rowMeasurePolicy(var56, var106, var73_1, 14 & var117 >> 3 | 112 & var117 >> 3);
               int var58 = 112 & var117 << 3;
               int var59 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
               int var60 = ComposablesKt.getCurrentCompositeKeyHash(var73_1, 0);
               CompositionLocalMap var61 = var73_1.getCurrentCompositionLocalMap();
               Modifier var62 = ComposedModifierKt.materializeModifier(var73_1, var102);
               Function0 var63 = ComposeUiNode.Companion.getConstructor();
               int var64 = 6 | 896 & var58 << 6;
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
               ComposerKt.sourceInformationMarkerStart(var73_1, -407840262, "C101@5126L9:Row.kt#2w3rfo");
               int var75 = 6 | 112 & var117 >> 6;
               RowScope var129 = (RowScope)RowScopeInstance.INSTANCE;
               int var78 = 0;
               ComposerKt.sourceInformationMarkerStart(var73_1, 553068766, "C1688@78192L169,1686@78073L318,1692@78420L273:MainActivity.kt#to5c3");
               boolean var130 = var98.isCompleted();
               ComposerKt.sourceInformationMarkerStart(var73_1, 1264770274, "CC(remember):MainActivity.kt#9igjgp");
               boolean var80 = var73_1.changedInstance($plannerViewModel) | var73_1.changed(var98) | var73_1.changedInstance($authManager) | var73_1.changedInstance($syncViewModel);
               int var81 = 0;
               Object var82 = var73_1.rememberedValue();
               int var83 = 0;
               Object var10001;
               if (!var80 && var82 != Composer.Companion.getEmpty()) {
                  var10001 = var82;
               } else {
                  boolean var84 = var130;
                  int var85 = 0;
                  Function1 var87_1 = MainActivityKt::TaskDetailDialog$lambda$373$lambda$372$lambda$371$lambda$370$lambda$369$lambda$368;
                  var130 = var84;
                  var73_1.updateRememberedValue(var87_1);
                  var10001 = var87_1;
               }

               Function1 var88 = (Function1)var10001;
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               CheckboxKt.Checkbox(var130, var88, (Modifier)null, false, (CheckboxColors)null, (MutableInteractionSource)null, var73_1, 0, 60);
               String var131 = var98.getTitle();
               TextStyle var10016;
               if (var98.isCompleted()) {
                  var73_1.startReplaceGroup(1264782346);
                  ComposerKt.sourceInformation(var73_1, "1694@78551L10");
                  TextStyle var119 = TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography(var73_1, MaterialTheme.$stable).getBodyMedium(), 0L, 0L, (FontWeight)null, (FontStyle)null, (FontSynthesis)null, (FontFamily)null, (String)null, 0L, (BaselineShift)null, (TextGeometricTransform)null, (LocaleList)null, 0L, TextDecoration.Companion.getLineThrough(), (Shadow)null, (DrawStyle)null, 0, 0, 0L, (TextIndent)null, (PlatformTextStyle)null, (LineHeightStyle)null, 0, 0, (TextMotion)null, 16773119, (Object)null);
                  var73_1.endReplaceGroup();
                  var10016 = var119;
               } else {
                  var73_1.startReplaceGroup(1264784867);
                  ComposerKt.sourceInformation(var73_1, "1694@78642L10");
                  TextStyle var120 = MaterialTheme.INSTANCE.getTypography(var73_1, MaterialTheme.$stable).getBodyMedium();
                  var73_1.endReplaceGroup();
                  var10016 = var120;
               }

               TextKt.Text--4IGK_g(var131, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, var10016, var73_1, 0, 0, 65534);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               var73_1.endNode();
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
               ComposerKt.sourceInformationMarkerEnd(var73_1);
            }

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

      return Unit.INSTANCE;
   }

   private static final Unit TaskDetailDialog$lambda$374(TaskEntity $task, AuthManager $authManager, CalendarSyncViewModel $syncViewModel, PlannerViewModel $plannerViewModel, Function0 $onDismiss, Function1 $onDelete, int $$changed, Composer $composer, int $force) {
      TaskDetailDialog($task, $authManager, $syncViewModel, $plannerViewModel, $onDismiss, $onDelete, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   // $FF: synthetic class
   @Metadata(
      mv = {2, 2, 0},
      k = 3,
      xi = 48
   )
   public static final class WhenMappings {
      // $FF: synthetic field
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[SwipeToDismissBoxValue.values().length];

         try {
            var0[SwipeToDismissBoxValue.StartToEnd.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SwipeToDismissBoxValue.EndToStart.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
