package com.example.settings;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"%\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"},
   d2 = {"dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "dataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "app"}
)
public final class UserPreferencesRepositoryKt {
   // $FF: synthetic field
   static final KProperty[] $$delegatedProperties;
   @NotNull
   private static final ReadOnlyProperty dataStore$delegate;

   @NotNull
   public static final DataStore getDataStore(@NotNull Context $this$dataStore) {
      Intrinsics.checkNotNullParameter($this$dataStore, "<this>");
      return (DataStore)dataStore$delegate.getValue($this$dataStore, $$delegatedProperties[0]);
   }

   static {
      KProperty[] var0 = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(UserPreferencesRepositoryKt.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1)))};
      $$delegatedProperties = var0;
      dataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("user_preferences", (ReplaceFileCorruptionHandler)null, (Function1)null, (CoroutineScope)null, 14, (Object)null);
   }
}
