package com.example.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_settings")

class PreferencesRepository(private val context: Context) {

    companion object {
        val THEME_MODE = stringPreferencesKey("theme_mode")
        val MASTER_NOTIFICATIONS = booleanPreferencesKey("master_notifications_enabled")
        val NOTIFY_PLANS = booleanPreferencesKey("notify_plans")
        val NOTIFY_TASKS = booleanPreferencesKey("notify_tasks")
        val NOTIFY_STREAKS = booleanPreferencesKey("notify_streaks")
        val NOTIFY_GAMIFICATION = booleanPreferencesKey("notify_gamification")
        val NOTIFICATION_VOLUME = floatPreferencesKey("notification_volume")
        val NOTIFICATION_SOUND_PROFILE = stringPreferencesKey("notification_sound_profile")
        val GOOGLE_CALENDAR_SYNC = booleanPreferencesKey("google_calendar_sync_enabled")
        val GOOGLE_CALENDAR_AUTO_PUSH = booleanPreferencesKey("google_calendar_auto_push")
    }

    // Getters as Flows
    val themeModeFlow: Flow<String> = context.dataStore.data.map { it[THEME_MODE] ?: "system" }
    val masterNotificationsFlow: Flow<Boolean> = context.dataStore.data.map { it[MASTER_NOTIFICATIONS] ?: true }
    val notifyPlansFlow: Flow<Boolean> = context.dataStore.data.map { it[NOTIFY_PLANS] ?: true }
    val notifyTasksFlow: Flow<Boolean> = context.dataStore.data.map { it[NOTIFY_TASKS] ?: true }
    val notifyStreaksFlow: Flow<Boolean> = context.dataStore.data.map { it[NOTIFY_STREAKS] ?: true }
    val notifyGamificationFlow: Flow<Boolean> = context.dataStore.data.map { it[NOTIFY_GAMIFICATION] ?: true }
    val notificationVolumeFlow: Flow<Float> = context.dataStore.data.map { it[NOTIFICATION_VOLUME] ?: 1.0f }
    val notificationSoundProfileFlow: Flow<String> = context.dataStore.data.map { it[NOTIFICATION_SOUND_PROFILE] ?: "default" }
    val googleCalendarSyncFlow: Flow<Boolean> = context.dataStore.data.map { it[GOOGLE_CALENDAR_SYNC] ?: true }
    val googleCalendarAutoPushFlow: Flow<Boolean> = context.dataStore.data.map { it[GOOGLE_CALENDAR_AUTO_PUSH] ?: false }

    // Setters
    suspend fun setThemeMode(mode: String) {
        context.dataStore.edit { it[THEME_MODE] = mode }
    }

    suspend fun setMasterNotifications(enabled: Boolean) {
        context.dataStore.edit { it[MASTER_NOTIFICATIONS] = enabled }
    }

    suspend fun setNotifyPlans(enabled: Boolean) {
        context.dataStore.edit { it[NOTIFY_PLANS] = enabled }
    }

    suspend fun setNotifyTasks(enabled: Boolean) {
        context.dataStore.edit { it[NOTIFY_TASKS] = enabled }
    }

    suspend fun setNotifyStreaks(enabled: Boolean) {
        context.dataStore.edit { it[NOTIFY_STREAKS] = enabled }
    }

    suspend fun setNotifyGamification(enabled: Boolean) {
        context.dataStore.edit { it[NOTIFY_GAMIFICATION] = enabled }
    }

    suspend fun setNotificationVolume(volume: Float) {
        context.dataStore.edit { it[NOTIFICATION_VOLUME] = volume }
    }

    suspend fun setNotificationSoundProfile(profile: String) {
        context.dataStore.edit { it[NOTIFICATION_SOUND_PROFILE] = profile }
    }

    suspend fun setGoogleCalendarSync(enabled: Boolean) {
        context.dataStore.edit { it[GOOGLE_CALENDAR_SYNC] = enabled }
    }

    suspend fun setGoogleCalendarAutoPush(enabled: Boolean) {
        context.dataStore.edit { it[GOOGLE_CALENDAR_AUTO_PUSH] = enabled }
    }
}
