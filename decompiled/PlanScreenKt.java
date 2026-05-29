package com.example;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.CanvasKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.Icons.Outlined;
import androidx.compose.material.icons.filled.AccessTimeKt;
import androidx.compose.material.icons.filled.EventNoteKt;
import androidx.compose.material.icons.outlined.NotificationsKt;
import androidx.compose.material3.CheckboxDefaults;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.SwipeToDismissBoxKt;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
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
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.example.calendar.CalendarSyncViewModel;
import com.example.data.local.entity.SubTaskEntity;
import com.example.data.local.entity.TaskEntity;
import com.example.data.network.CalendarEvent;
import com.example.ui.theme.ColorKt;
import com.example.ui.theme.ThemeKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a¯\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u0014\u001ai\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0007¢\u0006\u0002\u0010\u001c\u001aM\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0007¢\u0006\u0002\u0010!¨\u0006\"²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002²\u0006\u0010\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0&X\u008a\u0084\u0002²\u0006\u0010\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110&X\u008a\u0084\u0002²\u0006\u0010\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0&X\u008a\u0084\u0002"},
   d2 = {"PlanScreen", "", "viewModel", "Lcom/example/PlannerViewModel;", "syncViewModel", "Lcom/example/calendar/CalendarSyncViewModel;", "onTaskClick", "Lkotlin/Function1;", "Lcom/example/data/local/entity/TaskEntity;", "onTaskEdit", "onTaskDelete", "onPushToCalendar", "onSubTaskCompleteToggle", "Lkotlin/Function2;", "Lcom/example/data/local/entity/SubTaskEntity;", "", "onGoogleEventEdit", "Lcom/example/data/network/CalendarEvent;", "onHighlightPlan", "", "(Lcom/example/PlannerViewModel;Lcom/example/calendar/CalendarSyncViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "PlanTaskCard", "task", "timeFormatter", "Ljava/text/SimpleDateFormat;", "onCompleteToggle", "Lkotlin/Function0;", "onDoubleClick", "(Lcom/example/data/local/entity/TaskEntity;Ljava/text/SimpleDateFormat;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SubTaskPlanCard", "item", "Lcom/example/SubTaskWithParent;", "onClick", "(Lcom/example/SubTaskWithParent;Ljava/text/SimpleDateFormat;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app", "selectedDate", "", "tasks", "", "googleEvents", "allSubTasks"}
)
@SourceDebugExtension({"SMAP\nPlanScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlanScreen.kt\ncom/example/PlanScreenKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 6 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 7 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 8 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 9 Composer.kt\nandroidx/compose/runtime/Updater\n+ 10 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 11 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 12 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 13 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n*L\n1#1,679:1\n1225#2,6:680\n1225#2,6:686\n1225#2,3:692\n1228#2,3:733\n1225#2,6:863\n1225#2,6:874\n1225#2,6:880\n1225#2,6:958\n1225#2,6:1050\n1225#2,6:1099\n1225#2,6:1344\n1225#2,6:1390\n1208#3,2:695\n1236#3,4:697\n1208#3,2:701\n1236#3,4:703\n1617#3,9:707\n1869#3:716\n1870#3:718\n1626#3:719\n1617#3,9:720\n1869#3:729\n1870#3:731\n1626#3:732\n1788#3,4:736\n1#4:717\n1#4:730\n1#4:873\n149#5:740\n149#5:777\n149#5:778\n149#5:851\n149#5:852\n149#5:861\n149#5:862\n149#5:922\n149#5:968\n149#5:969\n149#5:1014\n149#5:1056\n149#5:1061\n149#5:1105\n149#5:1106\n149#5:1175\n149#5:1176\n149#5:1177\n149#5:1178\n149#5:1179\n149#5:1180\n149#5:1216\n149#5:1221\n149#5:1258\n149#5:1295\n149#5:1296\n149#5:1297\n149#5:1298\n149#5:1299\n149#5:1350\n149#5:1351\n149#5:1388\n149#5:1389\n149#5:1449\n149#5:1450\n149#5:1451\n149#5:1488\n149#5:1525\n149#5:1562\n149#5:1563\n149#5:1564\n149#5:1565\n149#5:1566\n86#6:741\n83#6,6:742\n89#6:776\n86#6:814\n82#6,7:815\n89#6:850\n93#6:856\n93#6:872\n86#6:1062\n82#6,7:1063\n89#6:1098\n93#6:1110\n86#6:1222\n83#6,6:1223\n89#6:1257\n93#6:1403\n86#6:1489\n83#6,6:1490\n89#6:1524\n93#6:1614\n79#7,6:748\n86#7,4:763\n90#7,2:773\n79#7,6:785\n86#7,4:800\n90#7,2:810\n79#7,6:822\n86#7,4:837\n90#7,2:847\n94#7:855\n94#7:859\n94#7:871\n79#7,6:893\n86#7,4:908\n90#7,2:918\n79#7,6:929\n86#7,4:944\n90#7,2:954\n94#7:966\n94#7:972\n79#7,6:985\n86#7,4:1000\n90#7,2:1010\n79#7,6:1021\n86#7,4:1036\n90#7,2:1046\n94#7:1059\n79#7,6:1070\n86#7,4:1085\n90#7,2:1095\n94#7:1109\n94#7:1113\n79#7,6:1146\n86#7,4:1161\n90#7,2:1171\n79#7,6:1187\n86#7,4:1202\n90#7,2:1212\n94#7:1219\n79#7,6:1229\n86#7,4:1244\n90#7,2:1254\n79#7,6:1266\n86#7,4:1281\n90#7,2:1291\n79#7,6:1307\n86#7,4:1322\n90#7,2:1332\n94#7:1338\n94#7:1342\n79#7,6:1359\n86#7,4:1374\n90#7,2:1384\n94#7:1398\n94#7:1402\n79#7,6:1412\n86#7,4:1427\n90#7,2:1437\n94#7:1443\n94#7:1447\n79#7,6:1459\n86#7,4:1474\n90#7,2:1484\n79#7,6:1496\n86#7,4:1511\n90#7,2:1521\n79#7,6:1533\n86#7,4:1548\n90#7,2:1558\n79#7,6:1574\n86#7,4:1589\n90#7,2:1599\n94#7:1605\n94#7:1609\n94#7:1613\n94#7:1617\n368#8,9:754\n377#8:775\n368#8,9:791\n377#8:812\n368#8,9:828\n377#8:849\n378#8,2:853\n378#8,2:857\n378#8,2:869\n368#8,9:899\n377#8:920\n368#8,9:935\n377#8:956\n378#8,2:964\n378#8,2:970\n368#8,9:991\n377#8:1012\n368#8,9:1027\n377#8:1048\n378#8,2:1057\n368#8,9:1076\n377#8:1097\n378#8,2:1107\n378#8,2:1111\n368#8,9:1152\n377#8:1173\n368#8,9:1193\n377#8:1214\n378#8,2:1217\n368#8,9:1235\n377#8:1256\n368#8,9:1272\n377#8:1293\n368#8,9:1313\n377#8:1334\n378#8,2:1336\n378#8,2:1340\n368#8,9:1365\n377#8:1386\n378#8,2:1396\n378#8,2:1400\n368#8,9:1418\n377#8:1439\n378#8,2:1441\n378#8,2:1445\n368#8,9:1465\n377#8:1486\n368#8,9:1502\n377#8:1523\n368#8,9:1539\n377#8:1560\n368#8,9:1580\n377#8:1601\n378#8,2:1603\n378#8,2:1607\n378#8,2:1611\n378#8,2:1615\n4034#9,6:767\n4034#9,6:804\n4034#9,6:841\n4034#9,6:912\n4034#9,6:948\n4034#9,6:1004\n4034#9,6:1040\n4034#9,6:1089\n4034#9,6:1165\n4034#9,6:1206\n4034#9,6:1248\n4034#9,6:1285\n4034#9,6:1326\n4034#9,6:1378\n4034#9,6:1431\n4034#9,6:1478\n4034#9,6:1515\n4034#9,6:1552\n4034#9,6:1593\n71#10:779\n69#10,5:780\n74#10:813\n78#10:860\n71#10:923\n69#10,5:924\n74#10:957\n78#10:967\n71#10:1015\n69#10,5:1016\n74#10:1049\n78#10:1060\n71#10:1181\n69#10,5:1182\n74#10:1215\n78#10:1220\n71#10:1300\n68#10,6:1301\n74#10:1335\n78#10:1339\n71#10:1567\n68#10,6:1568\n74#10:1602\n78#10:1606\n99#11:886\n96#11,6:887\n102#11:921\n106#11:973\n99#11:978\n96#11,6:979\n102#11:1013\n106#11:1114\n99#11:1139\n96#11,6:1140\n102#11:1174\n99#11:1259\n96#11,6:1260\n102#11:1294\n106#11:1343\n99#11:1352\n96#11,6:1353\n102#11:1387\n106#11:1399\n99#11:1404\n95#11,7:1405\n102#11:1440\n106#11:1444\n106#11:1448\n99#11:1452\n96#11,6:1453\n102#11:1487\n99#11:1526\n96#11,6:1527\n102#11:1561\n106#11:1610\n106#11:1618\n81#12:974\n81#12:975\n81#12:976\n81#12:977\n143#13,12:1115\n143#13,12:1127\n*S KotlinDebug\n*F\n+ 1 PlanScreen.kt\ncom/example/PlanScreenKt\n*L\n60#1:680,6\n61#1:686,6\n69#1:692,3\n69#1:733,3\n195#1:863,6\n287#1:874,6\n513#1:880,6\n574#1:958,6\n129#1:1050,6\n151#1:1099,6\n430#1:1344,6\n463#1:1390,6\n70#1:695,2\n70#1:697,4\n71#1:701,2\n71#1:703,4\n72#1:707,9\n72#1:716\n72#1:718\n72#1:719\n74#1:720,9\n74#1:729\n74#1:731\n74#1:732\n90#1:736,4\n72#1:717\n74#1:730\n97#1:740\n114#1:777\n164#1:778\n178#1:851\n180#1:852\n193#1:861\n194#1:862\n569#1:922\n594#1:968\n603#1:969\n126#1:1014\n132#1:1056\n142#1:1061\n154#1:1105\n156#1:1106\n334#1:1175\n336#1:1176\n339#1:1177\n352#1:1178\n357#1:1179\n360#1:1180\n365#1:1216\n370#1:1221\n395#1:1258\n401#1:1295\n403#1:1296\n411#1:1297\n414#1:1298\n416#1:1299\n446#1:1350\n454#1:1351\n460#1:1388\n462#1:1389\n320#1:1449\n582#1:1450\n589#1:1451\n620#1:1488\n641#1:1525\n648#1:1562\n650#1:1563\n657#1:1564\n662#1:1565\n664#1:1566\n94#1:741\n94#1:742,6\n94#1:776\n173#1:814\n173#1:815,7\n173#1:850\n173#1:856\n94#1:872\n143#1:1062\n143#1:1063,7\n143#1:1098\n143#1:1110\n373#1:1222\n373#1:1223,6\n373#1:1257\n373#1:1403\n622#1:1489\n622#1:1490,6\n622#1:1524\n622#1:1614\n94#1:748,6\n94#1:763,4\n94#1:773,2\n167#1:785,6\n167#1:800,4\n167#1:810,2\n173#1:822,6\n173#1:837,4\n173#1:847,2\n173#1:855\n167#1:859\n94#1:871\n561#1:893,6\n561#1:908,4\n561#1:918,2\n567#1:929,6\n567#1:944,4\n567#1:954,2\n567#1:966\n561#1:972\n120#1:985,6\n120#1:1000,4\n120#1:1010,2\n124#1:1021,6\n124#1:1036,4\n124#1:1046,2\n124#1:1059\n143#1:1070,6\n143#1:1085,4\n143#1:1095,2\n143#1:1109\n120#1:1113\n324#1:1146,6\n324#1:1161,4\n324#1:1171,2\n355#1:1187,6\n355#1:1202,4\n355#1:1212,2\n355#1:1219\n373#1:1229,6\n373#1:1244,4\n373#1:1254,2\n393#1:1266,6\n393#1:1281,4\n393#1:1291,2\n412#1:1307,6\n412#1:1322,4\n412#1:1332,2\n412#1:1338\n393#1:1342\n452#1:1359,6\n452#1:1374,4\n452#1:1384,2\n452#1:1398\n373#1:1402\n486#1:1412,6\n486#1:1427,4\n486#1:1437,2\n486#1:1443\n324#1:1447\n607#1:1459,6\n607#1:1474,4\n607#1:1484,2\n622#1:1496,6\n622#1:1511,4\n622#1:1521,2\n639#1:1533,6\n639#1:1548,4\n639#1:1558,2\n660#1:1574,6\n660#1:1589,4\n660#1:1599,2\n660#1:1605\n639#1:1609\n622#1:1613\n607#1:1617\n94#1:754,9\n94#1:775\n167#1:791,9\n167#1:812\n173#1:828,9\n173#1:849\n173#1:853,2\n167#1:857,2\n94#1:869,2\n561#1:899,9\n561#1:920\n567#1:935,9\n567#1:956\n567#1:964,2\n561#1:970,2\n120#1:991,9\n120#1:1012\n124#1:1027,9\n124#1:1048\n124#1:1057,2\n143#1:1076,9\n143#1:1097\n143#1:1107,2\n120#1:1111,2\n324#1:1152,9\n324#1:1173\n355#1:1193,9\n355#1:1214\n355#1:1217,2\n373#1:1235,9\n373#1:1256\n393#1:1272,9\n393#1:1293\n412#1:1313,9\n412#1:1334\n412#1:1336,2\n393#1:1340,2\n452#1:1365,9\n452#1:1386\n452#1:1396,2\n373#1:1400,2\n486#1:1418,9\n486#1:1439\n486#1:1441,2\n324#1:1445,2\n607#1:1465,9\n607#1:1486\n622#1:1502,9\n622#1:1523\n639#1:1539,9\n639#1:1560\n660#1:1580,9\n660#1:1601\n660#1:1603,2\n639#1:1607,2\n622#1:1611,2\n607#1:1615,2\n94#1:767,6\n167#1:804,6\n173#1:841,6\n561#1:912,6\n567#1:948,6\n120#1:1004,6\n124#1:1040,6\n143#1:1089,6\n324#1:1165,6\n355#1:1206,6\n373#1:1248,6\n393#1:1285,6\n412#1:1326,6\n452#1:1378,6\n486#1:1431,6\n607#1:1478,6\n622#1:1515,6\n639#1:1552,6\n660#1:1593,6\n167#1:779\n167#1:780,5\n167#1:813\n167#1:860\n567#1:923\n567#1:924,5\n567#1:957\n567#1:967\n124#1:1015\n124#1:1016,5\n124#1:1049\n124#1:1060\n355#1:1181\n355#1:1182,5\n355#1:1215\n355#1:1220\n412#1:1300\n412#1:1301,6\n412#1:1335\n412#1:1339\n660#1:1567\n660#1:1568,6\n660#1:1602\n660#1:1606\n561#1:886\n561#1:887,6\n561#1:921\n561#1:973\n120#1:978\n120#1:979,6\n120#1:1013\n120#1:1114\n324#1:1139\n324#1:1140,6\n324#1:1174\n393#1:1259\n393#1:1260,6\n393#1:1294\n393#1:1343\n452#1:1352\n452#1:1353,6\n452#1:1387\n452#1:1399\n486#1:1404\n486#1:1405,7\n486#1:1440\n486#1:1444\n324#1:1448\n607#1:1452\n607#1:1453,6\n607#1:1487\n639#1:1526\n639#1:1527,6\n639#1:1561\n639#1:1610\n607#1:1618\n57#1:974\n58#1:975\n63#1:976\n64#1:977\n206#1:1115,12\n238#1:1127,12\n*E\n"})
public final class PlanScreenKt {
   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void PlanScreen(@NotNull PlannerViewModel viewModel, @NotNull CalendarSyncViewModel syncViewModel, @NotNull Function1 onTaskClick, @NotNull Function1 onTaskEdit, @NotNull Function1 onTaskDelete, @NotNull Function1 onPushToCalendar, @NotNull Function2 onSubTaskCompleteToggle, @NotNull Function1 onGoogleEventEdit, @NotNull Function1 onHighlightPlan, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(viewModel, "viewModel");
      Intrinsics.checkNotNullParameter(syncViewModel, "syncViewModel");
      Intrinsics.checkNotNullParameter(onTaskClick, "onTaskClick");
      Intrinsics.checkNotNullParameter(onTaskEdit, "onTaskEdit");
      Intrinsics.checkNotNullParameter(onTaskDelete, "onTaskDelete");
      Intrinsics.checkNotNullParameter(onPushToCalendar, "onPushToCalendar");
      Intrinsics.checkNotNullParameter(onSubTaskCompleteToggle, "onSubTaskCompleteToggle");
      Intrinsics.checkNotNullParameter(onGoogleEventEdit, "onGoogleEventEdit");
      Intrinsics.checkNotNullParameter(onHighlightPlan, "onHighlightPlan");
      $composer = $composer.startRestartGroup(-134475720);
      ComposerKt.sourceInformation($composer, "C(PlanScreen)P(8,7,4,6,5,2,3)56@2153L29,57@2222L29,59@2277L59,60@2361L72,62@2480L29,63@2559L29,68@2709L992,93@4095L7830:PlanScreen.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changedInstance(viewModel) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(syncViewModel) ? 32 : 16;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(onTaskEdit) ? 2048 : 1024;
      }

      if (($changed & 24576) == 0) {
         $dirty |= $composer.changedInstance(onTaskDelete) ? 16384 : 8192;
      }

      if (($changed & 1572864) == 0) {
         $dirty |= $composer.changedInstance(onSubTaskCompleteToggle) ? 1048576 : 524288;
      }

      if (($changed & 12582912) == 0) {
         $dirty |= $composer.changedInstance(onGoogleEventEdit) ? 8388608 : 4194304;
      }

      if (($changed & 100663296) == 0) {
         $dirty |= $composer.changedInstance(onHighlightPlan) ? 67108864 : 33554432;
      }

      if (($dirty & 38282259) == 38282258 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-134475720, $dirty, -1, "com.example.PlanScreen (PlanScreen.kt:55)");
         }

         State selectedDate$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getSelectedDate(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State tasks$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getTodaysTasks(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         ComposerKt.sourceInformationMarkerStart($composer, -382129165, "CC(remember):PlanScreen.kt#9igjgp");
         boolean var17 = false;
         int var18 = 0;
         Object var19 = $composer.rememberedValue();
         int var20 = 0;
         Object var10000;
         if (var19 == Composer.Companion.getEmpty()) {
            int var21 = 0;
            Object var143 = new SimpleDateFormat("HH:mm", Locale.getDefault());
            $composer.updateRememberedValue(var143);
            var10000 = (SubTaskWithParent)var143;
         } else {
            var10000 = (SubTaskWithParent)var19;
         }

         SimpleDateFormat timeFormatter = (SimpleDateFormat)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerStart($composer, -382126464, "CC(remember):PlanScreen.kt#9igjgp");
         var18 = 0;
         int var138 = 0;
         Object var140 = $composer.rememberedValue();
         int var144 = 0;
         if (var140 == Composer.Companion.getEmpty()) {
            int var22 = 0;
            Object var147 = new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.getDefault());
            $composer.updateRememberedValue(var147);
            var10000 = var147;
         } else {
            var10000 = var140;
         }

         SimpleDateFormat dateFormatter = (SimpleDateFormat)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         State googleEvents$delegate = FlowExtKt.collectAsStateWithLifecycle(syncViewModel.getEvents(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         State allSubTasks$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel.getAllSubTasksFlow(), (LifecycleOwner)null, (Lifecycle.State)null, (CoroutineContext)null, $composer, 0, 7);
         List allTasks = PlanScreen$lambda$1(tasks$delegate);
         List totalCount = PlanScreen$lambda$1(tasks$delegate);
         List completedCount = PlanScreen$lambda$5(allSubTasks$delegate);
         List var148 = PlanScreen$lambda$4(googleEvents$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, -382114408, "CC(remember):PlanScreen.kt#9igjgp");
         boolean var25 = $composer.changed(totalCount) | $composer.changed(completedCount) | $composer.changed(var148);
         int var26 = 0;
         Object var27 = $composer.rememberedValue();
         int var28 = 0;
         if (!var25 && var27 != Composer.Companion.getEmpty()) {
            var10000 = var27;
         } else {
            int var29 = 0;
            Iterable var30 = (Iterable)PlanScreen$lambda$1(tasks$delegate);
            int var31 = 0;
            int var37_7 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(var30, 10)), 16);
            Map var34 = (Map)(new LinkedHashMap(var37_7));
            int var35 = 0;

            for(Object var37 : var30) {
               TaskEntity var38 = (TaskEntity)var37;
               int var40 = 0;
               var34.put("local_" + var38.getId(), var37);
            }

            Map var41 = var34;
            Iterable var173 = (Iterable)PlanScreen$lambda$4(googleEvents$delegate);
            var37_7 = 0;
            int var33 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(var173, 10)), 16);
            Map var184 = (Map)(new LinkedHashMap(var33));
            int var188 = 0;

            for(Object var194 : var173) {
               CalendarEvent var198 = (CalendarEvent)var194;
               int var43_1 = 0;
               var184.put("google_" + var198.getId(), var194);
            }

            Map var171 = var184;
            Iterable var37_7 = (Iterable)PlanScreen$lambda$1(tasks$delegate);
            var33 = 0;
            Collection var185 = (Collection)(new ArrayList());
            var188 = 0;
            int var195 = 0;

            for(Object var43_1 : var37_7) {
               int var44 = 0;
               TaskEntity var45 = (TaskEntity)var43_1;
               int var46 = 0;
               String var237 = var45.getExternalCalendarEventId();
               if (var237 != null) {
                  Object var47 = var237;
                  int var48 = 0;
                  var185.add(var47);
               }
            }

            Set var174 = CollectionsKt.toSet((Iterable)((List)var185));
            var37_7 = (Iterable)PlanScreen$lambda$5(allSubTasks$delegate);
            var33 = 0;
            var185 = (Collection)(new ArrayList());
            var188 = 0;
            var195 = 0;

            for(Object var43_1 : var37_7) {
               int var206 = 0;
               SubTaskEntity var208 = (SubTaskEntity)var43_1;
               int var210 = 0;
               TaskEntity var211 = (TaskEntity)var41.get(var208.getParentIdStr());
               if (var211 != null) {
                  boolean var213 = var211.getExternalCalendarEventId() != null;
                  var10000 = new SubTaskWithParent(var208, var211.getTitle(), var211.getStartTime(), var211.getEndTime(), var213);
               } else {
                  CalendarEvent var214 = (CalendarEvent)var171.get(var208.getParentIdStr());
                  if (var214 != null && !var174.contains(var214.getId())) {
                     var10000 = new SubTaskWithParent;
                     String var10003 = var214.getSummary();
                     if (var10003 == null) {
                        var10003 = "Meeting";
                     }

                     var10000.<init>(var208, var10003, var214.getStartTimeInMillis(), var214.getEndTimeInMillis(), true);
                  } else {
                     var10000 = null;
                  }
               }

               if (var10000 != null) {
                  Object var49 = var10000;
                  int var50 = 0;
                  var185.add(var49);
               }
            }

            Object var51 = (List)var185;
            $composer.updateRememberedValue(var51);
            var10000 = var51;
         }

         List var23 = (List)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         int totalCount = allTasks.size() + var23.size();
         Iterable var149 = (Iterable)allTasks;
         int var152 = 0;
         int var240;
         if (var149 instanceof Collection && ((Collection)var149).isEmpty()) {
            var240 = 0;
         } else {
            int var24 = 0;

            for(Object var162 : var149) {
               TaskEntity var165 = (TaskEntity)var162;
               var28 = 0;
               if (var165.isCompleted()) {
                  ++var24;
                  if (var24 < 0) {
                     CollectionsKt.throwCountOverflow();
                  }
               }
            }

            var240 = var24;
         }

         var149 = (Iterable)var23;
         int var130 = var240;
         var152 = 0;
         if (var149 instanceof Collection && ((Collection)var149).isEmpty()) {
            var240 = 0;
         } else {
            int var155 = 0;

            for(Object var163 : var149) {
               SubTaskWithParent var166 = (SubTaskWithParent)var163;
               var28 = 0;
               if (var166.getSubTask().isCompleted()) {
                  ++var155;
                  if (var155 < 0) {
                     CollectionsKt.throwCountOverflow();
                  }
               }
            }

            var240 = var155;
         }

         int var131 = var240;
         int completedCount = var130 + var131;
         float progress = totalCount > 0 ? (float)completedCount / (float)totalCount : 0.0F;
         var152 = (int)(progress * (float)100);
         Modifier var242 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var156 = 24;
         var25 = (boolean)0;
         Modifier var157 = PaddingKt.padding-3ABfNKs(var242, Dp.constructor-impl((float)var156));
         var28 = 6;
         int var170 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var161 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var164 = Alignment.Companion.getStart();
         MeasurePolicy var172 = ColumnKt.columnMeasurePolicy(var161, var164, $composer, 14 & var28 >> 3 | 112 & var28 >> 3);
         int var175 = 112 & var28 << 3;
         int var179 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var182 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var183 = $composer.getCurrentCompositionLocalMap();
         Modifier var187 = ComposedModifierKt.materializeModifier($composer, var157);
         Function0 var191 = ComposeUiNode.Companion.getConstructor();
         int var193 = 6 | 896 & var175 << 6;
         int var197 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var191);
         } else {
            $composer.useNode();
         }

         Composer var39 = Updater.constructor-impl($composer);
         int var201 = 0;
         Updater.set-impl(var39, var172, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var39, var183, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var202 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var205 = 0;
         int var207 = 0;
         if (var39.getInserting() || !Intrinsics.areEqual(var39.rememberedValue(), var182)) {
            var39.updateRememberedValue(var182);
            var39.apply(var182, var202);
         }

         Updater.set-impl(var39, var187, ComposeUiNode.Companion.getSetModifier());
         int var209 = 14 & var193 >> 6;
         int var212 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var215 = 6 | 112 & var28 >> 6;
         ColumnScope var216 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var217 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2090587166, "C103@4371L11,99@4220L224,108@4554L11,106@4453L228,113@4699L41,118@4850L1833,116@4782L1901,163@6693L41:PlanScreen.kt#to5c3");
         long var52 = TextUnitKt.getSp(28);
         FontWeight var54 = FontWeight.Companion.getBold();
         long var55 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         long var57 = TextUnitKt.getSp((double)-0.5F);
         TextKt.Text--4IGK_g("Tasks & Subtasks", (Modifier)null, var55, var52, (FontStyle)null, var54, (FontFamily)null, var57, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199686, 0, 130898);
         String var243 = dateFormatter.format(new Date(PlanScreen$lambda$0(selectedDate$delegate)));
         Intrinsics.checkNotNullExpressionValue(var243, "format(...)");
         TextKt.Text--4IGK_g(var243, (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null), TextUnitKt.getSp(14), (FontStyle)null, FontWeight.Companion.getMedium(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
         Modifier var244 = (Modifier)Modifier.Companion;
         int var59 = 20;
         int var60 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var244, Dp.constructor-impl((float)var59)), $composer, 6);
         OtherScreensKt.GlassCard-dgCr-O4(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), (BorderStroke)null, (Color)null, (Function0)null, (Function0)null, (Function3)ComposableLambdaKt.rememberComposableLambda(1510128250, true, PlanScreenKt::PlanScreen$lambda$37$lambda$20, $composer, 54), $composer, 196614, 30);
         var244 = (Modifier)Modifier.Companion;
         var59 = 24;
         var60 = 0;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var244, Dp.constructor-impl((float)var59)), $composer, 6);
         if (allTasks.isEmpty() && var23.isEmpty()) {
            $composer.startReplaceGroup(-2088237460);
            ComposerKt.sourceInformation($composer, "166@6814L912");
            Modifier var223 = SizeKt.fillMaxWidth$default(ColumnScope.weight$default(var216, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null), 0.0F, 1, (Object)null);
            Alignment var226 = Alignment.Companion.getCenter();
            byte var229 = 48;
            int var230 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            boolean var220 = false;
            MeasurePolicy var231 = BoxKt.maybeCachedBoxMeasurePolicy(var226, var220);
            int var232 = 112 & var229 << 3;
            int var233 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var234 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var68 = $composer.getCurrentCompositionLocalMap();
            Modifier var69 = ComposedModifierKt.materializeModifier($composer, var223);
            Function0 var70 = ComposeUiNode.Companion.getConstructor();
            int var71 = 6 | 896 & var232 << 6;
            int var72 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var70);
            } else {
               $composer.useNode();
            }

            Composer var73 = Updater.constructor-impl($composer);
            int var74 = 0;
            Updater.set-impl(var73, var231, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var73, var68, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var75 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var76 = 0;
            int var78 = 0;
            if (var73.getInserting() || !Intrinsics.areEqual(var73.rememberedValue(), var234)) {
               var73.updateRememberedValue(var234);
               var73.apply(var234, var75);
            }

            Updater.set-impl(var73, var69, ComposeUiNode.Companion.getSetModifier());
            int var79 = 14 & var71 >> 6;
            int var81 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            int var82 = 6 | 112 & var229 >> 6;
            BoxScope var247 = (BoxScope)BoxScopeInstance.INSTANCE;
            int var85 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1155744300, "C172@7008L704:PlanScreen.kt#to5c3");
            Alignment.Horizontal var86 = Alignment.Companion.getCenterHorizontally();
            int var88 = 384;
            int var89 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier var90 = (Modifier)Modifier.Companion;
            Arrangement.Vertical var91 = Arrangement.INSTANCE.getTop();
            MeasurePolicy var92 = ColumnKt.columnMeasurePolicy(var91, var86, $composer, 14 & var88 >> 3 | 112 & var88 >> 3);
            int var93 = 112 & var88 << 3;
            int var94 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var95 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var96 = $composer.getCurrentCompositionLocalMap();
            Modifier var97 = ComposedModifierKt.materializeModifier($composer, var90);
            Function0 var98 = ComposeUiNode.Companion.getConstructor();
            int var99 = 6 | 896 & var93 << 6;
            int var100 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var98);
            } else {
               $composer.useNode();
            }

            Composer var101 = Updater.constructor-impl($composer);
            int var102 = 0;
            Updater.set-impl(var101, var92, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var101, var96, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var103 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var104 = 0;
            int var106 = 0;
            if (var101.getInserting() || !Intrinsics.areEqual(var101.rememberedValue(), var95)) {
               var101.updateRememberedValue(var95);
               var101.apply(var95, var103);
            }

            Updater.set-impl(var101, var97, ComposeUiNode.Companion.getSetModifier());
            int var107 = 14 & var99 >> 6;
            int var109 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            int var110 = 6 | 112 & var88 >> 6;
            ColumnScope var248 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            int var113 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1783013215, "C176@7254L11,173@7089L287,179@7397L41,182@7573L11,180@7459L235:PlanScreen.kt#to5c3");
            ImageVector var114 = EventNoteKt.getEventNote(Icons.INSTANCE.getDefault());
            long var115 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.2F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            Modifier var249 = (Modifier)Modifier.Companion;
            int var117 = 72;
            int var118 = 0;
            Modifier var119 = SizeKt.size-3ABfNKs(var249, Dp.constructor-impl((float)var117));
            IconKt.Icon-ww6aTOc(var114, (String)null, var119, var115, $composer, 432, 0);
            var249 = (Modifier)Modifier.Companion;
            int var235 = 16;
            int var120 = 0;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(var249, Dp.constructor-impl((float)var235)), $composer, 6);
            TextKt.Text--4IGK_g("No tasks planned for today.", (Modifier)null, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, (FontStyle)null, FontWeight.Companion.getMedium(), (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 196614, 0, 131034);
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
            $composer.startReplaceGroup(-2087202525);
            ComposerKt.sourceInformation($composer, "194@8017L3892,188@7756L4153");
            Modifier var222 = SizeKt.fillMaxWidth$default(ColumnScope.weight$default(var216, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null), 0.0F, 1, (Object)null);
            int var218 = 16;
            int var61 = 0;
            Arrangement.HorizontalOrVertical var225 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var218));
            var61 = 80;
            int var62 = 0;
            PaddingValues var219 = PaddingKt.PaddingValues-a9UjIt4$default(0.0F, 0.0F, 0.0F, Dp.constructor-impl((float)var61), 7, (Object)null);
            var244 = var222;
            Object var10001 = null;
            PaddingValues var10002 = var219;
            boolean var252 = false;
            Arrangement.Vertical var10004 = (Arrangement.Vertical)var225;
            Object var10005 = null;
            Object var10006 = null;
            boolean var10007 = false;
            ComposerKt.sourceInformationMarkerStart($composer, 763963394, "CC(remember):PlanScreen.kt#9igjgp");
            boolean var63 = $composer.changedInstance(allTasks) | $composer.changedInstance(timeFormatter) | $composer.changedInstance(viewModel) | ($dirty & 234881024) == 67108864 | ($dirty & 7168) == 2048 | ($dirty & '\ue000') == 16384 | $composer.changedInstance(var23) | ($dirty & 3670016) == 1048576 | $composer.changed(googleEvents$delegate) | ($dirty & 29360128) == 8388608;
            int var64 = 0;
            Object var65 = $composer.rememberedValue();
            int var66 = 0;
            Object var10008;
            if (!var63 && var65 != Composer.Companion.getEmpty()) {
               var10008 = var65;
            } else {
               boolean var121 = false;
               Object var122 = null;
               Object var123 = null;
               Arrangement.Vertical var124 = var10004;
               boolean var125 = false;
               Object var127 = null;
               int var67 = 0;
               Function1 var68_1 = PlanScreenKt::PlanScreen$lambda$37$lambda$36$lambda$35;
               var244 = var222;
               var10001 = var127;
               var10002 = var219;
               var252 = var125;
               var10004 = var124;
               var10005 = var123;
               var10006 = var122;
               var10007 = var121;
               $composer.updateRememberedValue(var68_1);
               var10008 = var68_1;
            }

            Function1 var228 = (Function1)var10008;
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(var244, (LazyListState)var10001, var10002, var252, var10004, (Alignment.Horizontal)var10005, (FlingBehavior)var10006, var10007, var228, $composer, 24960, 234);
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

      ScopeUpdateScope var251 = $composer.endRestartGroup();
      if (var251 != null) {
         var251.updateScope(PlanScreenKt::PlanScreen$lambda$38);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void PlanTaskCard(@NotNull TaskEntity task, @NotNull SimpleDateFormat timeFormatter, @NotNull Function1 onCompleteToggle, @NotNull Function0 onTaskClick, @NotNull Function0 onTaskEdit, @NotNull Function0 onTaskDelete, @NotNull Function0 onDoubleClick, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(task, "task");
      Intrinsics.checkNotNullParameter(timeFormatter, "timeFormatter");
      Intrinsics.checkNotNullParameter(onCompleteToggle, "onCompleteToggle");
      Intrinsics.checkNotNullParameter(onTaskClick, "onTaskClick");
      Intrinsics.checkNotNullParameter(onTaskEdit, "onTaskEdit");
      Intrinsics.checkNotNullParameter(onTaskDelete, "onTaskDelete");
      Intrinsics.checkNotNullParameter(onDoubleClick, "onDoubleClick");
      $composer = $composer.startRestartGroup(-1974205246);
      ComposerKt.sourceInformation($composer, "C(PlanTaskCard)P(5,6!1,2,4,3)283@12237L18,286@12424L474:PlanScreen.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(task) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(timeFormatter) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(onCompleteToggle) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(onTaskClick) ? 2048 : 1024;
      }

      if (($changed & 24576) == 0) {
         $dirty |= $composer.changedInstance(onTaskEdit) ? 16384 : 8192;
      }

      if (($changed & 196608) == 0) {
         $dirty |= $composer.changedInstance(onTaskDelete) ? 131072 : 65536;
      }

      if (($changed & 1572864) == 0) {
         $dirty |= $composer.changedInstance(onDoubleClick) ? 1048576 : 524288;
      }

      if (($dirty & 599187) == 599186 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1974205246, $dirty, -1, "com.example.PlanTaskCard (PlanScreen.kt:282)");
         }

         boolean isDark = ThemeKt.isAppInDarkTheme($composer, 0);
         Long var10000 = task.getStartTime();
         String var43;
         if (var10000 != null) {
            long var14 = ((Number)var10000).longValue();
            int var16 = 0;
            var43 = timeFormatter.format(new Date(var14));
         } else {
            var43 = null;
         }

         String startStr = var43;
         Long var44 = task.getEndTime();
         String var45;
         if (var44 != null) {
            long var15 = ((Number)var44).longValue();
            int var17 = 0;
            var45 = timeFormatter.format(new Date(var15));
         } else {
            var45 = null;
         }

         String endStr = var45;
         Long accentColor = task.getStartTime();
         Long var33 = task.getEndTime();
         ComposerKt.sourceInformationMarkerStart($composer, 1164319740, "CC(remember):PlanScreen.kt#9igjgp");
         boolean var18 = $composer.changed(accentColor) | $composer.changed(var33);
         int var19 = 0;
         Object var20 = $composer.rememberedValue();
         int var21 = 0;
         Object var47;
         if (!var18 && var20 != Composer.Companion.getEmpty()) {
            var47 = var20;
         } else {
            int var22 = 0;
            String var46;
            if (task.getStartTime() != null && task.getEndTime() != null && task.getEndTime() > task.getStartTime()) {
               int var23 = (int)((task.getEndTime() - task.getStartTime()) / (long)'\uea60');
               int var24 = var23 / 60;
               int var25 = var23 % 60;
               var46 = var24 > 0 && var25 > 0 ? var24 + "h " + var25 + "m" : (var24 > 0 ? var24 + "h" : var25 + "m");
            } else {
               var46 = null;
            }

            Object var26 = var46;
            $composer.updateRememberedValue(var26);
            var47 = var26;
         }

         String cardBg = (String)var47;
         ComposerKt.sourceInformationMarkerEnd($composer);
         String durationLabel = cardBg;
         long accentColor = !task.isTimeBoxed() ? Color.Companion.getTransparent-0d7_KjU() : (task.isMeeting() ? ColorKt.getCoral500() : (task.getExternalCalendarEventId() != null ? ColorKt.getTeal600() : ColorKt.getIndigo600()));
         long cardBg = isDark ? (task.isTimeBoxed() ? ColorKt.getDarkCard() : ColorKt.getDarkGlass()) : (task.isTimeBoxed() ? ColorKt.getWhite90() : ColorKt.getWhite70());
         long cardBorderColor = isDark ? ColorKt.getDarkGlassBorder() : ColorKt.getWhite40();
         if (task.isTimeBoxed()) {
            $composer.startReplaceGroup(1744201206);
            ComposerKt.sourceInformation($composer, "509@22600L13");
            PlanTaskCard$CardContent(cardBorderColor, cardBg, onTaskClick, onDoubleClick, task, accentColor, onCompleteToggle, startStr, endStr, durationLabel, onTaskEdit, onTaskDelete, $composer, 0);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(1744311504);
            ComposerKt.sourceInformation($composer, "512@22719L180,511@22654L255,538@23664L17,519@22918L773");
            var47 = null;
            ComposerKt.sourceInformationMarkerStart($composer, 1164648886, "CC(remember):PlanScreen.kt#9igjgp");
            boolean var39 = ($dirty & 458752) == 131072;
            int var40 = 0;
            Object var41 = $composer.rememberedValue();
            int var42 = 0;
            Object var50;
            if (!var39 && var41 != Composer.Companion.getEmpty()) {
               var50 = var41;
            } else {
               Object var29 = null;
               int var27 = 0;
               Function1 var10001 = PlanScreenKt::PlanTaskCard$lambda$54$lambda$53;
               var47 = var29;
               Object var28 = var10001;
               $composer.updateRememberedValue(var28);
               var50 = var28;
            }

            Function1 var38 = (Function1)var50;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SwipeToDismissBoxState dismissState = SwipeToDismissBoxKt.rememberSwipeToDismissBoxState((SwipeToDismissBoxValue)var47, var38, (Function1)null, $composer, 0, 5);
            SwipeToDismissBoxKt.SwipeToDismissBox(dismissState, ComposableSingletons$PlanScreenKt.INSTANCE.getLambda$-554183108$app(), (Modifier)null, false, false, false, (Function3)ComposableLambdaKt.rememberComposableLambda(221469313, true, PlanScreenKt::PlanTaskCard$lambda$55, $composer, 54), $composer, 1575984 | SwipeToDismissBoxState.$stable, 52);
            $composer.endReplaceGroup();
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var49 = $composer.endRestartGroup();
      if (var49 != null) {
         var49.updateScope(PlanScreenKt::PlanTaskCard$lambda$56);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void SubTaskPlanCard(@NotNull SubTaskWithParent item, @NotNull SimpleDateFormat timeFormatter, @NotNull Function1 onCompleteToggle, @NotNull Function0 onClick, @NotNull Function0 onDoubleClick, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(item, "item");
      Intrinsics.checkNotNullParameter(timeFormatter, "timeFormatter");
      Intrinsics.checkNotNullParameter(onCompleteToggle, "onCompleteToggle");
      Intrinsics.checkNotNullParameter(onClick, "onClick");
      Intrinsics.checkNotNullParameter(onDoubleClick, "onDoubleClick");
      $composer = $composer.startRestartGroup(-1093297423);
      ComposerKt.sourceInformation($composer, "C(SubTaskPlanCard)P(!1,4,2)560@24272L4809:PlanScreen.kt#to5c3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(item) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(timeFormatter) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changedInstance(onCompleteToggle) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= $composer.changedInstance(onClick) ? 2048 : 1024;
      }

      if (($changed & 24576) == 0) {
         $dirty |= $composer.changedInstance(onDoubleClick) ? 16384 : 8192;
      }

      if (($dirty & 9363) == 9362 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1093297423, $dirty, -1, "com.example.SubTaskPlanCard (PlanScreen.kt:550)");
         }

         SubTaskEntity subTask = item.getSubTask();
         String parentTitle = item.getParentTitle();
         Long var10000 = item.getParentStartTime();
         String var98;
         if (var10000 != null) {
            long var13 = ((Number)var10000).longValue();
            int var15 = 0;
            var98 = timeFormatter.format(new Date(var13));
         } else {
            var98 = null;
         }

         String startStr = var98;
         Long var99 = item.getParentEndTime();
         String var100;
         if (var99 != null) {
            long var14 = ((Number)var99).longValue();
            int var16 = 0;
            var100 = timeFormatter.format(new Date(var14));
         } else {
            var100 = null;
         }

         String endStr = var100;
         long accentColor = item.isSynced() ? ColorKt.getTeal500() : ColorKt.getPurple500();
         Modifier var86 = IntrinsicKt.height(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), IntrinsicSize.Max);
         byte var18 = 6;
         int var19 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var87 = Arrangement.INSTANCE.getStart();
         Alignment.Vertical var88 = Alignment.Companion.getTop();
         MeasurePolicy var20 = RowKt.rowMeasurePolicy(var87, var88, $composer, 14 & var18 >> 3 | 112 & var18 >> 3);
         int var21 = 112 & var18 << 3;
         int var22 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var23 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var24 = $composer.getCurrentCompositionLocalMap();
         Modifier var25 = ComposedModifierKt.materializeModifier($composer, var86);
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
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var38 = 6 | 112 & var18 >> 6;
         RowScope var40 = (RowScope)RowScopeInstance.INSTANCE;
         int var41 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1399939927, "C566@24436L938,593@25384L39,595@25446L18,605@25856L3219,599@25612L3463:PlanScreen.kt#to5c3");
         Modifier var101 = (Modifier)Modifier.Companion;
         int var42 = 24;
         int var43 = 0;
         Modifier var89 = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(var101, Dp.constructor-impl((float)var42)), 0.0F, 1, (Object)null);
         Alignment var92 = Alignment.Companion.getTopCenter();
         byte var45 = 54;
         int var46 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         boolean var47 = false;
         MeasurePolicy var48 = BoxKt.maybeCachedBoxMeasurePolicy(var92, var47);
         int var49 = 112 & var45 << 3;
         int var50 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var51 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var52 = $composer.getCurrentCompositionLocalMap();
         Modifier var53 = ComposedModifierKt.materializeModifier($composer, var89);
         Function0 var54 = ComposeUiNode.Companion.getConstructor();
         int var55 = 6 | 896 & var49 << 6;
         int var56 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var54);
         } else {
            $composer.useNode();
         }

         Composer var57 = Updater.constructor-impl($composer);
         int var58 = 0;
         Updater.set-impl(var57, var48, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var57, var52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var59 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var60 = 0;
         int var62 = 0;
         if (var57.getInserting() || !Intrinsics.areEqual(var57.rememberedValue(), var51)) {
            var57.updateRememberedValue(var51);
            var57.apply(var51, var59);
         }

         Updater.set-impl(var57, var53, ComposeUiNode.Companion.getSetModifier());
         int var63 = 14 & var55 >> 6;
         int var65 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         int var66 = 6 | 112 & var45 >> 6;
         BoxScope var102 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var69 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 466579500, "C572@24642L11,573@24741L623,573@24699L665:PlanScreen.kt#to5c3");
         long var70 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.15F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         Modifier var103 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         ComposerKt.sourceInformationMarkerStart($composer, -539134378, "CC(remember):PlanScreen.kt#9igjgp");
         boolean var73 = $composer.changed(var70);
         int var74 = 0;
         Object var75 = $composer.rememberedValue();
         int var76 = 0;
         Object var106;
         if (!var73 && var75 != Composer.Companion.getEmpty()) {
            var106 = var75;
         } else {
            Modifier var77 = var103;
            int var78 = 0;
            Function1 var10001 = PlanScreenKt::SubTaskPlanCard$lambda$67$lambda$61$lambda$60$lambda$59;
            var103 = var77;
            Object var79 = var10001;
            $composer.updateRememberedValue(var79);
            var106 = var79;
         }

         Function1 var80 = (Function1)var106;
         ComposerKt.sourceInformationMarkerEnd($composer);
         CanvasKt.Canvas(var103, var80, $composer, 6);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         var103 = (Modifier)Modifier.Companion;
         int var90 = 8;
         int var93 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var103, Dp.constructor-impl((float)var90)), $composer, 6);
         var90 = ThemeKt.isAppInDarkTheme($composer, 0);
         long var81 = var90 ? ColorKt.getDarkGlass() : ColorKt.getWhite70();
         long var83 = var90 ? ColorKt.getDarkGlassBorder() : ColorKt.getWhite40();
         Modifier var94 = RowScope.weight$default(var40, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         var49 = 1;
         var50 = 0;
         BorderStroke var95 = BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var49), var83);
         OtherScreensKt.GlassCard-dgCr-O4(var94, var95, Color.box-impl(var81), onClick, onDoubleClick, (Function3)ComposableLambdaKt.rememberComposableLambda(2138026049, true, PlanScreenKt::SubTaskPlanCard$lambda$67$lambda$66, $composer, 54), $composer, 196608 | 7168 & $dirty | '\ue000' & $dirty, 0);
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
         var105.updateScope(PlanScreenKt::SubTaskPlanCard$lambda$68);
      }

   }

   private static final long PlanScreen$lambda$0(State $selectedDate$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return ((Number)$selectedDate$delegate.getValue()).longValue();
   }

   private static final List PlanScreen$lambda$1(State $tasks$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$tasks$delegate.getValue();
   }

   private static final List PlanScreen$lambda$4(State $googleEvents$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$googleEvents$delegate.getValue();
   }

   private static final List PlanScreen$lambda$5(State $allSubTasks$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = 0;
      return (List)$allSubTasks$delegate.getValue();
   }

   private static final float PlanScreen$lambda$37$lambda$20$lambda$19$lambda$15$lambda$14$lambda$13(float $progress) {
      return $progress;
   }

   private static final float PlanScreen$lambda$37$lambda$20$lambda$19$lambda$18$lambda$17$lambda$16(float $progress) {
      return $progress;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit PlanScreen$lambda$37$lambda$20(float $progress, int $percentage, int $completedCount, int $totalCount, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C119@4864L1809:PlanScreen.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1510128250, $changed, -1, "com.example.PlanScreen.<anonymous>.<anonymous> (PlanScreen.kt:119)");
         }

         Alignment.Vertical var7 = Alignment.Companion.getCenterVertically();
         Modifier var8 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         short var12 = 390;
         int var13 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var9 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var14 = RowKt.rowMeasurePolicy(var9, var7, $composer, 14 & var12 >> 3 | 112 & var12 >> 3);
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
         RowScope var10000 = (RowScope)RowScopeInstance.INSTANCE;
         int var35 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1395731358, "C123@5016L772,141@5805L40,142@5862L797:PlanScreen.kt#to5c3");
         Alignment var36 = Alignment.Companion.getCenter();
         Modifier var118 = (Modifier)Modifier.Companion;
         int var37 = 60;
         int var38 = 0;
         Modifier var86 = SizeKt.size-3ABfNKs(var118, Dp.constructor-impl((float)var37));
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
         Modifier var48 = ComposedModifierKt.materializeModifier($composer, var86);
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
         BoxScope var119 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var64 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -640197093, "C128@5232L12,132@5443L11,127@5170L338,138@5724L11,134@5529L241:PlanScreen.kt#to5c3");
         ComposerKt.sourceInformationMarkerStart($composer, -851934116, "CC(remember):PlanScreen.kt#9igjgp");
         boolean var66 = $composer.changed($progress);
         int var67 = 0;
         Object var68 = $composer.rememberedValue();
         int var69 = 0;
         Object var120;
         if (!var66 && var68 != Composer.Companion.getEmpty()) {
            var120 = var68;
         } else {
            int var70 = 0;
            Object var71 = PlanScreenKt::PlanScreen$lambda$37$lambda$20$lambda$19$lambda$15$lambda$14$lambda$13;
            $composer.updateRememberedValue(var71);
            var120 = var71;
         }

         Function0 var72 = (Function0)var120;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var121 = var72;
         Modifier var10001 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         long var10002 = ColorKt.getIndigo600();
         int var114 = 6;
         int var65 = 0;
         ProgressIndicatorKt.CircularProgressIndicator-IyT6zlY(var121, var10001, var10002, Dp.constructor-impl((float)var114), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.1F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0, 0.0F, $composer, 3504, 96);
         String var115 = $percentage + "%";
         long var73 = TextUnitKt.getSp(13);
         FontWeight var110 = FontWeight.Companion.getBold();
         long var75 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g(var115, (Modifier)null, var75, var73, (FontStyle)null, var110, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         Modifier var122 = (Modifier)Modifier.Companion;
         int var84 = 16;
         int var77 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var122, Dp.constructor-impl((float)var84)), $composer, 6);
         var42 = (boolean)0;
         int var39 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Modifier var85 = (Modifier)Modifier.Companion;
         Arrangement.Vertical var117 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var87 = Alignment.Companion.getStart();
         MeasurePolicy var88 = ColumnKt.columnMeasurePolicy(var117, var87, $composer, 14 & var42 >> 3 | 112 & var42 >> 3);
         var41 = 112 & var42 << 3;
         int var91 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         var44 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var93 = $composer.getCurrentCompositionLocalMap();
         Modifier var94 = ComposedModifierKt.materializeModifier($composer, var85);
         Function0 var95 = ComposeUiNode.Companion.getConstructor();
         int var96 = 6 | 896 & var41 << 6;
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
         var51 = 0;
         Updater.set-impl(var98, var88, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var98, var93, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var100 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         var53 = 0;
         var55 = 0;
         if (var98.getInserting() || !Intrinsics.areEqual(var98.rememberedValue(), var44)) {
            var98.updateRememberedValue(var44);
            var98.apply(var44, var100);
         }

         Updater.set-impl(var98, var94, ComposeUiNode.Companion.getSetModifier());
         int var56 = 14 & var96 >> 6;
         var58 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var59 = 6 | 112 & var42 >> 6;
         ColumnScope var123 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var62 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1027025077, "C147@6114L11,143@5891L269,150@6241L12,157@6576L11,149@6181L460:PlanScreen.kt#to5c3");
         String var63 = $completedCount + " of " + $totalCount + " Completed";
         FontWeight var107 = FontWeight.Companion.getBold();
         long var78 = TextUnitKt.getSp(16);
         long var80 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
         TextKt.Text--4IGK_g(var63, (Modifier)null, var80, var78, (FontStyle)null, var107, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
         ComposerKt.sourceInformationMarkerStart($composer, 1002971628, "CC(remember):PlanScreen.kt#9igjgp");
         var69 = $composer.changed($progress);
         int var112 = 0;
         Object var113 = $composer.rememberedValue();
         int var116 = 0;
         Object var124;
         if (!var69 && var113 != Composer.Companion.getEmpty()) {
            var124 = var113;
         } else {
            int var82 = 0;
            Object var83 = PlanScreenKt::PlanScreen$lambda$37$lambda$20$lambda$19$lambda$18$lambda$17$lambda$16;
            $composer.updateRememberedValue(var83);
            var124 = var83;
         }

         Function0 var104 = (Function0)var124;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Function0 var125 = var104;
         var10001 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var105 = 6;
         int var108 = 0;
         var10001 = ClipKt.clip(SizeKt.height-3ABfNKs(var10001, Dp.constructor-impl((float)var105)), (Shape)RoundedCornerShapeKt.getCircleShape());
         var105 = 4;
         var108 = 0;
         ProgressIndicatorKt.LinearProgressIndicator-GJbTh5U(var125, PaddingKt.padding-qDBjuR0$default(var10001, 0.0F, Dp.constructor-impl((float)var105), 0.0F, 0.0F, 13, (Object)null), ColorKt.getIndigo600(), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.1F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0, 0.0F, (Function1)null, $composer, 384, 112);
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

   private static final Object PlanScreen$lambda$37$lambda$36$lambda$35$lambda$23(TaskEntity it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return "ft_" + it.getId();
   }

   private static final Object PlanScreen$lambda$37$lambda$36$lambda$35$lambda$30(SubTaskWithParent it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return "st_" + it.getSubTask().getId();
   }

   private static final Unit PlanScreen$lambda$37$lambda$36$lambda$35(List $allTasks, List $subTasksWithParent, SimpleDateFormat $timeFormatter, PlannerViewModel $viewModel, Function1 $onHighlightPlan, Function1 $onTaskEdit, Function1 $onTaskDelete, Function2 $onSubTaskCompleteToggle, State $googleEvents$delegate, Function1 $onGoogleEventEdit, LazyListScope $this$LazyColumn) {
      Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
      if (!((Collection)$allTasks).isEmpty()) {
         LazyListScope.item$default($this$LazyColumn, (Object)null, (Object)null, ComposableSingletons$PlanScreenKt.INSTANCE.getLambda$113925377$app(), 3, (Object)null);
         Function1 var13 = PlanScreenKt::PlanScreen$lambda$37$lambda$36$lambda$35$lambda$23;
         Function1 var14 = PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$1.INSTANCE;
         int var15 = 0;
         $this$LazyColumn.items($allTasks.size(), var13 != null ? (Function1)(new PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$2(var13, $allTasks)) : null, new PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$3(var14, $allTasks), (Function4)ComposableLambdaKt.composableLambdaInstance(-632812321, true, new PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$4($allTasks, $timeFormatter, $viewModel, $onHighlightPlan, $onTaskEdit, $onTaskDelete)));
      }

      if (!((Collection)$subTasksWithParent).isEmpty()) {
         LazyListScope.item$default($this$LazyColumn, (Object)null, (Object)null, ComposableSingletons$PlanScreenKt.INSTANCE.getLambda$404551352$app(), 3, (Object)null);
         Function1 var16 = PlanScreenKt::PlanScreen$lambda$37$lambda$36$lambda$35$lambda$30;
         Function1 var17 = PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$5.INSTANCE;
         int var18 = 0;
         $this$LazyColumn.items($subTasksWithParent.size(), var16 != null ? (Function1)(new PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$6(var16, $subTasksWithParent)) : null, new PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$7(var17, $subTasksWithParent), (Function4)ComposableLambdaKt.composableLambdaInstance(-632812321, true, new PlanScreenKt$PlanScreen$lambda$37$lambda$36$lambda$35$$inlined$items$default$8($subTasksWithParent, $timeFormatter, $onSubTaskCompleteToggle, $onHighlightPlan, $allTasks, $onTaskEdit, $googleEvents$delegate, $onGoogleEventEdit)));
      }

      return Unit.INSTANCE;
   }

   private static final Unit PlanScreen$lambda$38(PlannerViewModel $viewModel, CalendarSyncViewModel $syncViewModel, Function1 $onTaskClick, Function1 $onTaskEdit, Function1 $onTaskDelete, Function1 $onPushToCalendar, Function2 $onSubTaskCompleteToggle, Function1 $onGoogleEventEdit, Function1 $onHighlightPlan, int $$changed, Composer $composer, int $force) {
      PlanScreen($viewModel, $syncViewModel, $onTaskClick, $onTaskEdit, $onTaskDelete, $onPushToCalendar, $onSubTaskCompleteToggle, $onGoogleEventEdit, $onHighlightPlan, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit PlanTaskCard$CardContent$lambda$52(TaskEntity $task, long $accentColor, Function1 $onCompleteToggle, String $startStr, String $endStr, String $durationLabel, Function0 $onTaskEdit, Function0 $onTaskDelete, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C323@13698L8803:PlanScreen.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(954607397, $changed, -1, "com.example.PlanTaskCard.CardContent.<anonymous> (PlanScreen.kt:323)");
         }

         Alignment.Vertical var12 = Alignment.Companion.getCenterVertically();
         Modifier var13 = IntrinsicKt.height(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), IntrinsicSize.Max);
         short var18 = 390;
         int var19 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var15 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var20 = RowKt.rowMeasurePolicy(var15, var12, $composer, 14 & var18 >> 3 | 112 & var18 >> 3);
         int var21 = 112 & var18 << 3;
         int var22 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var23 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var24 = $composer.getCurrentCompositionLocalMap();
         Modifier var25 = ComposedModifierKt.materializeModifier($composer, var13);
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
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var38 = 6 | 112 & var18 >> 6;
         RowScope var40 = (RowScope)RowScopeInstance.INSTANCE;
         int var41 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -447606860, "C372@15820L5669:PlanScreen.kt#to5c3");
         if ($task.isTimeBoxed()) {
            $composer.startReplaceGroup(-447837625);
            ComposerKt.sourceInformation($composer, "331@14013L269,338@14303L40");
            Modifier var10000 = (Modifier)Modifier.Companion;
            int var42 = 4;
            int var43 = 0;
            var10000 = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(var10000, Dp.constructor-impl((float)var42)), 0.0F, 1, (Object)null);
            var42 = 2;
            var43 = 0;
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(var10000, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var42))), $accentColor, (Shape)null, 2, (Object)null), $composer, 0);
            var10000 = (Modifier)Modifier.Companion;
            var42 = 12;
            var43 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var10000, Dp.constructor-impl((float)var42)), $composer, 6);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-461729159);
            $composer.endReplaceGroup();
         }

         if (!$task.isTimeBoxed()) {
            $composer.startReplaceGroup(-447351948);
            ComposerKt.sourceInformation($composer, "348@14792L11,346@14671L190,343@14499L384,351@14904L40");
            CheckboxKt.Checkbox($task.isCompleted(), $onCompleteToggle, (Modifier)null, false, CheckboxDefaults.INSTANCE.colors-5tl4gsc(ColorKt.getIndigo600(), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.4F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, 0L, 0L, 0L, $composer, 6 | CheckboxDefaults.$stable << 18, 60), (MutableInteractionSource)null, $composer, 0, 44);
            Modifier var297 = (Modifier)Modifier.Companion;
            int var159 = 12;
            int var168 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var297, Dp.constructor-impl((float)var159)), $composer, 6);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-446854553);
            ComposerKt.sourceInformation($composer, "354@15068L639,369@15728L40");
            Modifier var292 = (Modifier)Modifier.Companion;
            int var155 = 18;
            int var164 = 0;
            var292 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(var292, Dp.constructor-impl((float)var155)), (Shape)RoundedCornerShapeKt.getCircleShape()), Color.copy-wmQWz5c$default($accentColor, 0.15F, 0.0F, 0.0F, 0.0F, 14, (Object)null), (Shape)null, 2, (Object)null);
            var155 = 2;
            var164 = 0;
            Modifier var157 = BorderKt.border-xT4_qwU(var292, Dp.constructor-impl((float)var155), $accentColor, (Shape)RoundedCornerShapeKt.getCircleShape());
            Alignment var166 = Alignment.Companion.getCenter();
            byte var45 = 48;
            int var46 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            boolean var47 = false;
            MeasurePolicy var48 = BoxKt.maybeCachedBoxMeasurePolicy(var166, var47);
            int var49 = 112 & var45 << 3;
            int var50 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var51 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var52 = $composer.getCurrentCompositionLocalMap();
            Modifier var53 = ComposedModifierKt.materializeModifier($composer, var157);
            Function0 var54 = ComposeUiNode.Companion.getConstructor();
            int var55 = 6 | 896 & var49 << 6;
            int var56 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var54);
            } else {
               $composer.useNode();
            }

            Composer var57 = Updater.constructor-impl($composer);
            int var58 = 0;
            Updater.set-impl(var57, var48, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var57, var52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var59 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var60 = 0;
            int var62 = 0;
            if (var57.getInserting() || !Intrinsics.areEqual(var57.rememberedValue(), var51)) {
               var57.updateRememberedValue(var51);
               var57.apply(var51, var59);
            }

            Updater.set-impl(var57, var53, ComposeUiNode.Companion.getSetModifier());
            int var63 = 14 & var55 >> 6;
            int var65 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            int var66 = 6 | 112 & var45 >> 6;
            BoxScope var294 = (BoxScope)BoxScopeInstance.INSTANCE;
            int var69 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1538174221, "C362@15455L230:PlanScreen.kt#to5c3");
            Modifier var295 = (Modifier)Modifier.Companion;
            int var70 = 6;
            int var71 = 0;
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(var295, Dp.constructor-impl((float)var70)), (Shape)RoundedCornerShapeKt.getCircleShape()), $accentColor, (Shape)null, 2, (Object)null), $composer, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            var295 = (Modifier)Modifier.Companion;
            int var158 = 16;
            int var167 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var295, Dp.constructor-impl((float)var158)), $composer, 6);
            $composer.endReplaceGroup();
         }

         Modifier var160 = RowScope.weight$default(var40, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         int var171 = 0;
         int var173 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var169 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var175 = Alignment.Companion.getStart();
         MeasurePolicy var177 = ColumnKt.columnMeasurePolicy(var169, var175, $composer, 14 & var171 >> 3 | 112 & var171 >> 3);
         int var179 = 112 & var171 << 3;
         int var181 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var183 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var185 = $composer.getCurrentCompositionLocalMap();
         Modifier var187 = ComposedModifierKt.materializeModifier($composer, var160);
         Function0 var189 = ComposeUiNode.Companion.getConstructor();
         int var191 = 6 | 896 & var179 << 6;
         int var193 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var189);
         } else {
            $composer.useNode();
         }

         Composer var195 = Updater.constructor-impl($composer);
         int var197 = 0;
         Updater.set-impl(var195, var177, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var195, var185, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var199 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var201 = 0;
         int var203 = 0;
         if (var195.getInserting() || !Intrinsics.areEqual(var195.rememberedValue(), var183)) {
            var195.updateRememberedValue(var183);
            var195.apply(var183, var199);
         }

         Updater.set-impl(var195, var187, ComposeUiNode.Companion.getSetModifier());
         int var205 = 14 & var191 >> 6;
         int var207 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var209 = 6 | 112 & var171 >> 6;
         ColumnScope var298 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var211 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 533249998, "C373@15881L726:PlanScreen.kt#to5c3");
         String var213 = $task.getTitle();
         long var72 = TextUnitKt.getSp(17);
         FontWeight var74 = FontWeight.Companion.getBold();
         long var299;
         if ($task.isCompleted()) {
            $composer.startReplaceGroup(533277618);
            ComposerKt.sourceInformation($composer, "378@16124L11");
            long var75 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            $composer.endReplaceGroup();
            var299 = var75;
         } else {
            $composer.startReplaceGroup(533395077);
            ComposerKt.sourceInformation($composer, "380@16243L11");
            long var222 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
            $composer.endReplaceGroup();
            var299 = var222;
         }

         long var77 = var299;
         TextStyle var300;
         if ($task.isCompleted()) {
            $composer.startReplaceGroup(533545303);
            ComposerKt.sourceInformation($composer, "383@16393L10");
            TextStyle var79 = TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyLarge(), 0L, 0L, (FontWeight)null, (FontStyle)null, (FontSynthesis)null, (FontFamily)null, (String)null, 0L, (BaselineShift)null, (TextGeometricTransform)null, (LocaleList)null, 0L, TextDecoration.Companion.getLineThrough(), (Shadow)null, (DrawStyle)null, 0, 0, 0L, (TextIndent)null, (PlatformTextStyle)null, (LineHeightStyle)null, 0, 0, (TextMotion)null, 16773119, (Object)null);
            $composer.endReplaceGroup();
            var300 = var79;
         } else {
            $composer.startReplaceGroup(533688585);
            ComposerKt.sourceInformation($composer, "385@16539L10");
            TextStyle var223 = MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyLarge();
            $composer.endReplaceGroup();
            var300 = var223;
         }

         TextStyle var80 = var300;
         TextKt.Text--4IGK_g(var213, (Modifier)null, var77, var72, (FontStyle)null, var74, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, var80, $composer, 199680, 0, 65490);
         if ($task.isTimeBoxed() && $startStr != null) {
            $composer.startReplaceGroup(533983705);
            ComposerKt.sourceInformation($composer, "392@16857L1755");
            var213 = $endStr != null ? $startStr + " - " + $endStr : $startStr;
            Alignment.Vertical var81 = Alignment.Companion.getCenterVertically();
            Modifier var301 = (Modifier)Modifier.Companion;
            int var218 = 2;
            int var82 = 0;
            Modifier var219 = PaddingKt.padding-qDBjuR0$default(var301, 0.0F, Dp.constructor-impl((float)var218), 0.0F, 0.0F, 13, (Object)null);
            short var224 = 390;
            int var84 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Arrangement.Horizontal var232 = Arrangement.INSTANCE.getStart();
            MeasurePolicy var85 = RowKt.rowMeasurePolicy(var232, var81, $composer, 14 & var224 >> 3 | 112 & var224 >> 3);
            int var86 = 112 & var224 << 3;
            int var87 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var88 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var89 = $composer.getCurrentCompositionLocalMap();
            Modifier var90 = ComposedModifierKt.materializeModifier($composer, var219);
            Function0 var91 = ComposeUiNode.Companion.getConstructor();
            int var92 = 6 | 896 & var86 << 6;
            int var93 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var91);
            } else {
               $composer.useNode();
            }

            Composer var94 = Updater.constructor-impl($composer);
            int var95 = 0;
            Updater.set-impl(var94, var85, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var94, var89, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var96 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var97 = 0;
            int var99 = 0;
            if (var94.getInserting() || !Intrinsics.areEqual(var94.rememberedValue(), var88)) {
               var94.updateRememberedValue(var88);
               var94.apply(var88, var96);
            }

            Updater.set-impl(var94, var90, ComposeUiNode.Companion.getSetModifier());
            int var100 = 14 & var92 >> 6;
            int var102 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            int var103 = 6 | 112 & var224 >> 6;
            RowScope var302 = (RowScope)RowScopeInstance.INSTANCE;
            int var106 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -43462575, "C396@17062L282,402@17373L39,403@17441L252:PlanScreen.kt#to5c3");
            ImageVector var107 = AccessTimeKt.getAccessTime(Icons.INSTANCE.getDefault());
            Modifier var303 = (Modifier)Modifier.Companion;
            int var108 = 13;
            int var109 = 0;
            Modifier var110 = SizeKt.size-3ABfNKs(var303, Dp.constructor-impl((float)var108));
            IconKt.Icon-ww6aTOc(var107, (String)null, var110, $accentColor, $composer, 432, 0);
            var303 = (Modifier)Modifier.Companion;
            int var255 = 4;
            int var264 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var303, Dp.constructor-impl((float)var255)), $composer, 6);
            long var111 = TextUnitKt.getSp(12);
            FontWeight var261 = FontWeight.Companion.getSemiBold();
            TextKt.Text--4IGK_g(var213, (Modifier)null, $accentColor, var111, (FontStyle)null, var261, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
            if ($durationLabel != null) {
               $composer.startReplaceGroup(-42802369);
               ComposerKt.sourceInformation($composer, "410@17783L39,411@17855L701");
               var303 = (Modifier)Modifier.Companion;
               var255 = 8;
               var264 = 0;
               SpacerKt.Spacer(SizeKt.width-3ABfNKs(var303, Dp.constructor-impl((float)var255)), $composer, 6);
               var303 = (Modifier)Modifier.Companion;
               var255 = 6;
               var264 = 0;
               var303 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(var303, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var255))), Color.copy-wmQWz5c$default($accentColor, 0.1F, 0.0F, 0.0F, 0.0F, 14, (Object)null), (Shape)null, 2, (Object)null);
               var255 = 6;
               var264 = 0;
               float var10001 = Dp.constructor-impl((float)var255);
               var255 = 2;
               var264 = 0;
               Modifier var260 = PaddingKt.padding-VpY3zN4(var303, var10001, Dp.constructor-impl((float)var255));
               byte var113 = 0;
               int var114 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
               Alignment var269 = Alignment.Companion.getTopStart();
               boolean var262 = false;
               MeasurePolicy var115 = BoxKt.maybeCachedBoxMeasurePolicy(var269, var262);
               int var116 = 112 & var113 << 3;
               int var117 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
               int var118 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
               CompositionLocalMap var119 = $composer.getCurrentCompositionLocalMap();
               Modifier var120 = ComposedModifierKt.materializeModifier($composer, var260);
               Function0 var121 = ComposeUiNode.Companion.getConstructor();
               int var122 = 6 | 896 & var116 << 6;
               int var123 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
               if (!($composer.getApplier() instanceof Applier)) {
                  ComposablesKt.invalidApplier();
               }

               $composer.startReusableNode();
               if ($composer.getInserting()) {
                  $composer.createNode(var121);
               } else {
                  $composer.useNode();
               }

               Composer var124 = Updater.constructor-impl($composer);
               int var125 = 0;
               Updater.set-impl(var124, var115, ComposeUiNode.Companion.getSetMeasurePolicy());
               Updater.set-impl(var124, var119, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
               Function2 var126 = ComposeUiNode.Companion.getSetCompositeKeyHash();
               int var127 = 0;
               int var129 = 0;
               if (var124.getInserting() || !Intrinsics.areEqual(var124.rememberedValue(), var118)) {
                  var124.updateRememberedValue(var118);
                  var124.apply(var118, var126);
               }

               Updater.set-impl(var124, var120, ComposeUiNode.Companion.getSetModifier());
               int var130 = 14 & var122 >> 6;
               int var132 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
               int var133 = 6 | 112 & var113 >> 6;
               BoxScope var308 = (BoxScope)BoxScopeInstance.INSTANCE;
               int var136 = 0;
               ComposerKt.sourceInformationMarkerStart($composer, -1305507649, "C417@18229L293:PlanScreen.kt#to5c3");
               long var137 = TextUnitKt.getSp(10);
               FontWeight var139 = FontWeight.Companion.getBold();
               TextKt.Text--4IGK_g($durationLabel, (Modifier)null, $accentColor, var137, (FontStyle)null, var139, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               $composer.endNode();
               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               $composer.endReplaceGroup();
            } else {
               $composer.startReplaceGroup(-60436316);
               $composer.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(517321763);
            $composer.endReplaceGroup();
         }

         CharSequence var215 = (CharSequence)$task.getDescription();
         if (var215 == null || StringsKt.isBlank(var215)) {
            $composer.startReplaceGroup(517321763);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(535919624);
            ComposerKt.sourceInformation($composer, "429@18759L488");
            String var231 = $task.getDescription();
            ComposerKt.sourceInformationMarkerStart($composer, 294383271, "CC(remember):PlanScreen.kt#9igjgp");
            boolean var233 = $composer.changed(var231);
            int var83 = 0;
            Object var228 = $composer.rememberedValue();
            int var225 = 0;
            Object var310;
            if (!var233 && var228 != Composer.Companion.getEmpty()) {
               var310 = var228;
            } else {
               int var235 = 0;
               String var309 = $task.getDescription();
               if (var309 == null) {
                  var309 = "";
               }

               String var237 = var309;
               Object var239 = StringsKt.startsWith$default(var237, "Tasks:\n", false, 2, (Object)null) ? StringsKt.substringAfter$default(var237, "Tasks:\n", (String)null, 2, (Object)null) : (StringsKt.contains$default((CharSequence)var237, (CharSequence)"\n\nTasks:\n", false, 2, (Object)null) ? StringsKt.substringBefore$default(var237, "\n\nTasks:\n", (String)null, 2, (Object)null) : var237);
               $composer.updateRememberedValue(var239);
               var310 = var239;
            }

            String var70_10 = (String)var310;
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (!StringsKt.isBlank((CharSequence)var70_10)) {
               $composer.startReplaceGroup(536483049);
               ComposerKt.sourceInformation($composer, "443@19494L11,440@19332L354");
               var72 = TextUnitKt.getSp(13);
               long var141 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.6F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
               Modifier var311 = (Modifier)Modifier.Companion;
               int var229 = 4;
               var225 = 0;
               Modifier var234 = PaddingKt.padding-qDBjuR0$default(var311, 0.0F, Dp.constructor-impl((float)var229), 0.0F, 0.0F, 13, (Object)null);
               TextKt.Text--4IGK_g(var70_10, var234, var141, var72, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 1, 0, (Function1)null, (TextStyle)null, $composer, 3120, 3072, 122864);
               $composer.endReplaceGroup();
            } else {
               $composer.startReplaceGroup(517321763);
               $composer.endReplaceGroup();
            }

            $composer.endReplaceGroup();
         }

         if (!$task.getHasReminder()) {
            $composer.startReplaceGroup(517321763);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(536995014);
            ComposerKt.sourceInformation($composer, "451@19804L1645");
            Alignment.Vertical var216 = Alignment.Companion.getCenterVertically();
            Modifier var312 = (Modifier)Modifier.Companion;
            int var70_10 = 4;
            int var220 = 0;
            Modifier var70_10 = PaddingKt.padding-qDBjuR0$default(var312, 0.0F, Dp.constructor-impl((float)var70_10), 0.0F, 0.0F, 13, (Object)null);
            short var230 = 390;
            int var227 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Arrangement.Horizontal var221 = Arrangement.INSTANCE.getStart();
            MeasurePolicy var236 = RowKt.rowMeasurePolicy(var221, var216, $composer, 14 & var230 >> 3 | 112 & var230 >> 3);
            int var238 = 112 & var230 << 3;
            int var240 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int var241 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap var242 = $composer.getCurrentCompositionLocalMap();
            Modifier var243 = ComposedModifierKt.materializeModifier($composer, var70_10);
            Function0 var244 = ComposeUiNode.Companion.getConstructor();
            int var245 = 6 | 896 & var238 << 6;
            int var246 = 0;
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

            Composer var247 = Updater.constructor-impl($composer);
            int var248 = 0;
            Updater.set-impl(var247, var236, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var247, var242, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 var249 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var250 = 0;
            int var98 = 0;
            if (var247.getInserting() || !Intrinsics.areEqual(var247.rememberedValue(), var241)) {
               var247.updateRememberedValue(var241);
               var247.apply(var241, var249);
            }

            Updater.set-impl(var247, var243, ComposeUiNode.Companion.getSetModifier());
            int var251 = 14 & var245 >> 6;
            int var101 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            int var252 = 6 | 112 & var230 >> 6;
            RowScope var313 = (RowScope)RowScopeInstance.INSTANCE;
            int var105 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692861369, "C458@20203L11,455@20009L332,461@20370L39,462@20458L686,477@21350L11,474@21173L250:PlanScreen.kt#to5c3");
            ImageVector var253 = NotificationsKt.getNotifications(Outlined.INSTANCE);
            long var143 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.4F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            Modifier var314 = (Modifier)Modifier.Companion;
            int var263 = 13;
            int var270 = 0;
            Modifier var106_6 = SizeKt.size-3ABfNKs(var314, Dp.constructor-impl((float)var263));
            IconKt.Icon-ww6aTOc(var253, (String)null, var106_6, var143, $composer, 432, 0);
            var314 = (Modifier)Modifier.Companion;
            int var254 = 4;
            int var146 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var314, Dp.constructor-impl((float)var254)), $composer, 6);
            Integer var288 = $task.getReminderMinutesBefore();
            Long var272 = $task.getReminderTime();
            ComposerKt.sourceInformationMarkerStart($composer, -1269262716, "CC(remember):PlanScreen.kt#9igjgp");
            var270 = $composer.changed(var288) | $composer.changed(var272);
            int var273 = 0;
            Object var274 = $composer.rememberedValue();
            int var275 = 0;
            Object var318;
            if (!var270 && var274 != Composer.Companion.getEmpty()) {
               var318 = var274;
            } else {
               label294: {
                  int var276 = 0;
                  Integer var277 = $task.getReminderMinutesBefore();
                  byte var278 = 15;
                  if (var277 != null) {
                     if (var277 == var278) {
                        var317 = "15m before";
                        break label294;
                     }
                  }

                  var278 = 30;
                  if (var277 != null) {
                     if (var277 == var278) {
                        var317 = "30m before";
                        break label294;
                     }
                  }

                  var278 = 45;
                  if (var277 != null) {
                     if (var277 == var278) {
                        var317 = "45m before";
                        break label294;
                     }
                  }

                  var278 = 60;
                  if (var277 != null) {
                     if (var277 == var278) {
                        var317 = "1h before";
                        break label294;
                     }
                  }

                  Long var316 = $task.getReminderTime();
                  if (var316 != null) {
                     long var147 = ((Number)var316).longValue();
                     int var282 = 0;
                     SimpleDateFormat var283 = new SimpleDateFormat("HH:mm", Locale.getDefault());
                     var317 = var283.format(new Date(var147));
                     if (var317 != null) {
                        break label294;
                     }
                  }

                  var317 = "Enabled";
               }

               Object var284 = var317;
               $composer.updateRememberedValue(var284);
               var318 = var284;
            }

            String var106_6 = (String)var318;
            ComposerKt.sourceInformationMarkerEnd($composer);
            String var289 = "Reminder: " + var106_6;
            long var149 = TextUnitKt.getSp(11);
            long var151 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.4F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            TextKt.Text--4IGK_g(var289, (Modifier)null, var151, var149, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 3072, 0, 131058);
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
         if ($task.isTimeBoxed()) {
            $composer.startReplaceGroup(-461729159);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(-440258094);
            ComposerKt.sourceInformation($composer, "485@21638L831");
            Alignment.Vertical var176 = Alignment.Companion.getCenterVertically();
            var171 = 384;
            var173 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            var160 = (Modifier)Modifier.Companion;
            Arrangement.Horizontal var170 = Arrangement.INSTANCE.getStart();
            var177 = RowKt.rowMeasurePolicy(var170, var176, $composer, 14 & var171 >> 3 | 112 & var171 >> 3);
            var179 = 112 & var171 << 3;
            var181 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            var183 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            var185 = $composer.getCurrentCompositionLocalMap();
            var187 = ComposedModifierKt.materializeModifier($composer, var160);
            var189 = ComposeUiNode.Companion.getConstructor();
            var191 = 6 | 896 & var179 << 6;
            var193 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
               ComposablesKt.invalidApplier();
            }

            $composer.startReusableNode();
            if ($composer.getInserting()) {
               $composer.createNode(var189);
            } else {
               $composer.useNode();
            }

            var195 = Updater.constructor-impl($composer);
            var197 = 0;
            Updater.set-impl(var195, var177, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(var195, var185, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            var199 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            var201 = 0;
            var203 = 0;
            if (var195.getInserting() || !Intrinsics.areEqual(var195.rememberedValue(), var183)) {
               var195.updateRememberedValue(var183);
               var195.apply(var183, var199);
            }

            Updater.set-impl(var195, var187, ComposeUiNode.Companion.getSetModifier());
            var205 = 14 & var191 >> 6;
            var207 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            var209 = 6 | 112 & var171 >> 6;
            RowScope var319 = (RowScope)RowScopeInstance.INSTANCE;
            var211 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, -2053182008, "C486@21716L353,494@22095L352:PlanScreen.kt#to5c3");
            IconButtonKt.IconButton($onTaskEdit, (Modifier)null, false, (IconButtonColors)null, (MutableInteractionSource)null, ComposableSingletons$PlanScreenKt.INSTANCE.getLambda$-1136223843$app(), $composer, 196608, 30);
            IconButtonKt.IconButton($onTaskDelete, (Modifier)null, false, (IconButtonColors)null, (MutableInteractionSource)null, ComposableSingletons$PlanScreenKt.INSTANCE.getLambda$-477593260$app(), $composer, 196608, 30);
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

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final void PlanTaskCard$CardContent(long cardBorderColor, long cardBg, Function0 $onTaskClick, Function0 $onDoubleClick, TaskEntity $task, long accentColor, Function1 $onCompleteToggle, String startStr, String endStr, String durationLabel, Function0 $onTaskEdit, Function0 $onTaskDelete, Composer $composer, int $changed) {
      ComposerKt.sourceInformationMarkerStart($composer, 1260872689, "C(CardContent)322@13684L8827,316@13443L9068:PlanScreen.kt#to5c3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(1260872689, $changed, -1, "com.example.PlanTaskCard.CardContent (PlanScreen.kt:315)");
      }

      Modifier var17 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
      int var19 = 1;
      int var20 = 0;
      BorderStroke var18 = BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float)var19), cardBorderColor);
      OtherScreensKt.GlassCard-dgCr-O4(var17, var18, Color.box-impl(cardBg), $onTaskClick, $onDoubleClick, (Function3)ComposableLambdaKt.rememberComposableLambda(954607397, true, PlanScreenKt::PlanTaskCard$CardContent$lambda$52, $composer, 54), $composer, 196614, 0);
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      ComposerKt.sourceInformationMarkerEnd($composer);
   }

   private static final boolean PlanTaskCard$lambda$54$lambda$53(Function0 $onTaskDelete, SwipeToDismissBoxValue value) {
      Intrinsics.checkNotNullParameter(value, "value");
      boolean var10000;
      if (value == SwipeToDismissBoxValue.EndToStart) {
         $onTaskDelete.invoke();
         var10000 = false;
      } else {
         var10000 = false;
      }

      return var10000;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit PlanTaskCard$lambda$55(long $cardBorderColor, long $cardBg, Function0 $onTaskClick, Function0 $onDoubleClick, TaskEntity $task, long $accentColor, Function1 $onCompleteToggle, String $startStr, String $endStr, String $durationLabel, Function0 $onTaskEdit, Function0 $onTaskDelete, RowScope $this$SwipeToDismissBox, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$SwipeToDismissBox, "$this$SwipeToDismissBox");
      ComposerKt.sourceInformation($composer, "C538@23666L13:PlanScreen.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(221469313, $changed, -1, "com.example.PlanTaskCard.<anonymous> (PlanScreen.kt:538)");
         }

         PlanTaskCard$CardContent($cardBorderColor, $cardBg, $onTaskClick, $onDoubleClick, $task, $accentColor, $onCompleteToggle, $startStr, $endStr, $durationLabel, $onTaskEdit, $onTaskDelete, $composer, 0);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit PlanTaskCard$lambda$56(TaskEntity $task, SimpleDateFormat $timeFormatter, Function1 $onCompleteToggle, Function0 $onTaskClick, Function0 $onTaskEdit, Function0 $onTaskDelete, Function0 $onDoubleClick, int $$changed, Composer $composer, int $force) {
      PlanTaskCard($task, $timeFormatter, $onCompleteToggle, $onTaskClick, $onTaskEdit, $onTaskDelete, $onDoubleClick, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final Unit SubTaskPlanCard$lambda$67$lambda$61$lambda$60$lambda$59(long $lineColor, DrawScope $this$Canvas) {
      Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
      float w = Size.getWidth-impl($this$Canvas.getSize-NH-jbRc());
      float h = Size.getHeight-impl($this$Canvas.getSize-NH-jbRc());
      long var10002 = OffsetKt.Offset(w / (float)2, 0.0F);
      long var10003 = OffsetKt.Offset(w / (float)2, h / (float)2);
      int var5 = 2;
      int var6 = 0;
      DrawScope.drawLine-NGM6Ib0$default($this$Canvas, $lineColor, var10002, var10003, $this$Canvas.toPx-0680j_4(Dp.constructor-impl((float)var5)), 0, (PathEffect)null, 0.0F, (ColorFilter)null, 0, 496, (Object)null);
      var10002 = OffsetKt.Offset(w / (float)2, h / (float)2);
      var10003 = OffsetKt.Offset(w, h / (float)2);
      var5 = 2;
      var6 = 0;
      DrawScope.drawLine-NGM6Ib0$default($this$Canvas, $lineColor, var10002, var10003, $this$Canvas.toPx-0680j_4(Dp.constructor-impl((float)var5)), 0, (PathEffect)null, 0.0F, (ColorFilter)null, 0, 496, (Object)null);
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit SubTaskPlanCard$lambda$67$lambda$66(SubTaskEntity $subTask, Function1 $onCompleteToggle, long $accentColor, String $startStr, String $endStr, String $parentTitle, ColumnScope $this$GlassCard, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$GlassCard, "$this$GlassCard");
      ComposerKt.sourceInformation($composer, "C606@25870L3195:PlanScreen.kt#to5c3");
      if (($changed & 17) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2138026049, $changed, -1, "com.example.SubTaskPlanCard.<anonymous>.<anonymous> (PlanScreen.kt:606)");
         }

         Alignment.Vertical var10 = Alignment.Companion.getCenterVertically();
         Modifier var11 = SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         short var15 = 390;
         int var16 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var12 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var17 = RowKt.rowMeasurePolicy(var12, var10, $composer, 14 & var15 >> 3 | 112 & var15 >> 3);
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
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var35 = 6 | 112 & var15 >> 6;
         RowScope var37 = (RowScope)RowScopeInstance.INSTANCE;
         int var38 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 2014929353, "C615@26300L11,613@26185L180,610@26022L361,619@26401L40,621@26459L2592:PlanScreen.kt#to5c3");
         CheckboxKt.Checkbox($subTask.isCompleted(), $onCompleteToggle, (Modifier)null, false, CheckboxDefaults.INSTANCE.colors-5tl4gsc($accentColor, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.4F, 0.0F, 0.0F, 0.0F, 14, (Object)null), 0L, 0L, 0L, 0L, $composer, CheckboxDefaults.$stable << 18, 60), (MutableInteractionSource)null, $composer, 0, 44);
         Modifier var10000 = (Modifier)Modifier.Companion;
         int var39 = 12;
         int var40 = 0;
         SpacerKt.Spacer(SizeKt.width-3ABfNKs(var10000, Dp.constructor-impl((float)var39)), $composer, 6);
         Modifier var138 = RowScope.weight$default(var37, (Modifier)Modifier.Companion, 1.0F, false, 2, (Object)null);
         int var42 = 0;
         int var43 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
         Arrangement.Vertical var139 = Arrangement.INSTANCE.getTop();
         Alignment.Horizontal var44 = Alignment.Companion.getStart();
         MeasurePolicy var45 = ColumnKt.columnMeasurePolicy(var139, var44, $composer, 14 & var42 >> 3 | 112 & var42 >> 3);
         int var46 = 112 & var42 << 3;
         int var47 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var48 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var49 = $composer.getCurrentCompositionLocalMap();
         Modifier var50 = ComposedModifierKt.materializeModifier($composer, var138);
         Function0 var51 = ComposeUiNode.Companion.getConstructor();
         int var52 = 6 | 896 & var46 << 6;
         int var53 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var51);
         } else {
            $composer.useNode();
         }

         Composer var54 = Updater.constructor-impl($composer);
         int var55 = 0;
         Updater.set-impl(var54, var45, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var54, var49, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var56 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var57 = 0;
         int var59 = 0;
         if (var54.getInserting() || !Intrinsics.areEqual(var54.rememberedValue(), var48)) {
            var54.updateRememberedValue(var48);
            var54.apply(var48, var56);
         }

         Updater.set-impl(var54, var50, ComposeUiNode.Companion.getSetModifier());
         int var60 = 14 & var52 >> 6;
         int var62 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
         int var63 = 6 | 112 & var42 >> 6;
         ColumnScope var163 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var66 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1387647511, "C622@26520L741,638@27283L1750:PlanScreen.kt#to5c3");
         String var67 = $subTask.getTitle();
         long var68 = TextUnitKt.getSp(15);
         FontWeight var70 = FontWeight.Companion.getSemiBold();
         long var164;
         if ($subTask.isCompleted()) {
            $composer.startReplaceGroup(1387780438);
            ComposerKt.sourceInformation($composer, "627@26773L11");
            long var71 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.5F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
            $composer.endReplaceGroup();
            var164 = var71;
         } else {
            $composer.startReplaceGroup(1387897897);
            ComposerKt.sourceInformation($composer, "629@26892L11");
            long var143 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU();
            $composer.endReplaceGroup();
            var164 = var143;
         }

         long var73 = var164;
         TextStyle var165;
         if ($subTask.isCompleted()) {
            $composer.startReplaceGroup(1388051130);
            ComposerKt.sourceInformation($composer, "632@27045L10");
            TextStyle var75 = TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), 0L, 0L, (FontWeight)null, (FontStyle)null, (FontSynthesis)null, (FontFamily)null, (String)null, 0L, (BaselineShift)null, (TextGeometricTransform)null, (LocaleList)null, 0L, TextDecoration.Companion.getLineThrough(), (Shadow)null, (DrawStyle)null, 0, 0, 0L, (TextIndent)null, (PlatformTextStyle)null, (LineHeightStyle)null, 0, 0, (TextMotion)null, 16773119, (Object)null);
            $composer.endReplaceGroup();
            var165 = var75;
         } else {
            $composer.startReplaceGroup(1388195404);
            ComposerKt.sourceInformation($composer, "634@27192L10");
            TextStyle var144 = MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium();
            $composer.endReplaceGroup();
            var165 = var144;
         }

         TextStyle var76 = var165;
         TextKt.Text--4IGK_g(var67, (Modifier)null, var73, var68, (FontStyle)null, var70, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, var76, $composer, 199680, 0, 65490);
         Alignment.Vertical var140 = Alignment.Companion.getCenterVertically();
         Modifier var166 = (Modifier)Modifier.Companion;
         int var77 = 2;
         int var141 = 0;
         Modifier var147 = PaddingKt.padding-qDBjuR0$default(var166, 0.0F, Dp.constructor-impl((float)var77), 0.0F, 0.0F, 13, (Object)null);
         short var146 = 390;
         int var145 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
         Arrangement.Horizontal var142 = Arrangement.INSTANCE.getStart();
         MeasurePolicy var80 = RowKt.rowMeasurePolicy(var142, var140, $composer, 14 & var146 >> 3 | 112 & var146 >> 3);
         int var81 = 112 & var146 << 3;
         int var82 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var83 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var84 = $composer.getCurrentCompositionLocalMap();
         Modifier var85 = ComposedModifierKt.materializeModifier($composer, var147);
         Function0 var86 = ComposeUiNode.Companion.getConstructor();
         int var87 = 6 | 896 & var81 << 6;
         int var88 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var86);
         } else {
            $composer.useNode();
         }

         Composer var89 = Updater.constructor-impl($composer);
         int var90 = 0;
         Updater.set-impl(var89, var80, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var89, var84, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var91 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var92 = 0;
         int var94 = 0;
         if (var89.getInserting() || !Intrinsics.areEqual(var89.rememberedValue(), var83)) {
            var89.updateRememberedValue(var83);
            var89.apply(var83, var91);
         }

         Updater.set-impl(var89, var85, ComposeUiNode.Companion.getSetModifier());
         int var95 = 14 & var87 >> 6;
         int var97 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
         int var98 = 6 | 112 & var146 >> 6;
         RowScope var167 = (RowScope)RowScopeInstance.INSTANCE;
         int var101 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 1587484097, "C662@28493L11,659@28318L693:PlanScreen.kt#to5c3");
         if ($startStr != null) {
            $composer.startReplaceGroup(1587482949);
            ComposerKt.sourceInformation($composer, "643@27524L282,649@27835L39,650@27903L295,656@28227L39");
            ImageVector var102 = AccessTimeKt.getAccessTime(Icons.INSTANCE.getDefault());
            Modifier var168 = (Modifier)Modifier.Companion;
            int var103 = 12;
            int var104 = 0;
            Modifier var105 = SizeKt.size-3ABfNKs(var168, Dp.constructor-impl((float)var103));
            IconKt.Icon-ww6aTOc(var102, (String)null, var105, $accentColor, $composer, 432, 0);
            var168 = (Modifier)Modifier.Companion;
            int var148 = 4;
            int var157 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var168, Dp.constructor-impl((float)var148)), $composer, 6);
            String var149 = $endStr != null ? $startStr + " - " + $endStr : $startStr;
            long var106 = TextUnitKt.getSp(11);
            FontWeight var156 = FontWeight.Companion.getBold();
            TextKt.Text--4IGK_g(var149, (Modifier)null, $accentColor, var106, (FontStyle)null, var156, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
            var168 = (Modifier)Modifier.Companion;
            int var150 = 8;
            var157 = 0;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(var168, Dp.constructor-impl((float)var150)), $composer, 6);
            $composer.endReplaceGroup();
         } else {
            $composer.startReplaceGroup(1560183171);
            $composer.endReplaceGroup();
         }

         Modifier var171 = (Modifier)Modifier.Companion;
         int var151 = 6;
         int var159 = 0;
         var171 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(var171, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var151))), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.05F, 0.0F, 0.0F, 0.0F, 14, (Object)null), (Shape)null, 2, (Object)null);
         var151 = 6;
         var159 = 0;
         float var10001 = Dp.constructor-impl((float)var151);
         var151 = 2;
         var159 = 0;
         Modifier var154 = PaddingKt.padding-VpY3zN4(var171, var10001, Dp.constructor-impl((float)var151));
         byte var108 = 0;
         int var109 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
         Alignment var162 = Alignment.Companion.getTopStart();
         boolean var155 = false;
         MeasurePolicy var110 = BoxKt.maybeCachedBoxMeasurePolicy(var162, var155);
         int var111 = 112 & var108 << 3;
         int var112 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
         int var113 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var114 = $composer.getCurrentCompositionLocalMap();
         Modifier var115 = ComposedModifierKt.materializeModifier($composer, var154);
         Function0 var116 = ComposeUiNode.Companion.getConstructor();
         int var117 = 6 | 896 & var111 << 6;
         int var118 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var116);
         } else {
            $composer.useNode();
         }

         Composer var119 = Updater.constructor-impl($composer);
         int var120 = 0;
         Updater.set-impl(var119, var110, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var119, var114, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var121 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var122 = 0;
         int var124 = 0;
         if (var119.getInserting() || !Intrinsics.areEqual(var119.rememberedValue(), var113)) {
            var119.updateRememberedValue(var113);
            var119.apply(var113, var121);
         }

         Updater.set-impl(var119, var115, ComposeUiNode.Companion.getSetModifier());
         int var125 = 14 & var117 >> 6;
         int var127 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
         int var128 = 6 | 112 & var108 >> 6;
         BoxScope var173 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var131 = 0;
         ComposerKt.sourceInformationMarkerStart($composer, -1817911291, "C669@28912L11,665@28672L313:PlanScreen.kt#to5c3");
         String var132 = "Attached to: " + $parentTitle;
         long var133 = TextUnitKt.getSp(10);
         FontWeight var135 = FontWeight.Companion.getBold();
         long var136 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnBackground-0d7_KjU(), 0.6F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         TextKt.Text--4IGK_g(var132, (Modifier)null, var136, var133, (FontStyle)null, var135, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 199680, 0, 131026);
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

   private static final Unit SubTaskPlanCard$lambda$68(SubTaskWithParent $item, SimpleDateFormat $timeFormatter, Function1 $onCompleteToggle, Function0 $onClick, Function0 $onDoubleClick, int $$changed, Composer $composer, int $force) {
      SubTaskPlanCard($item, $timeFormatter, $onCompleteToggle, $onClick, $onDoubleClick, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }
}
