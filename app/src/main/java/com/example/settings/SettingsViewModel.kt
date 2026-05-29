package com.example.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = PreferencesRepository(application)

    val themeMode: StateFlow<String> = repository.themeModeFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "system")

    val masterNotifications: StateFlow<Boolean> = repository.masterNotificationsFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    val notifyPlans: StateFlow<Boolean> = repository.notifyPlansFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    val notifyTasks: StateFlow<Boolean> = repository.notifyTasksFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    val notifyStreaks: StateFlow<Boolean> = repository.notifyStreaksFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    val notifyGamification: StateFlow<Boolean> = repository.notifyGamificationFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    val notificationVolume: StateFlow<Float> = repository.notificationVolumeFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 1.0f)

    val notificationSoundProfile: StateFlow<String> = repository.notificationSoundProfileFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "default")

    val googleCalendarSync: StateFlow<Boolean> = repository.googleCalendarSyncFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    val googleCalendarAutoPush: StateFlow<Boolean> = repository.googleCalendarAutoPushFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    fun setThemeMode(mode: String) {
        viewModelScope.launch { repository.setThemeMode(mode) }
    }

    fun setMasterNotifications(enabled: Boolean) {
        viewModelScope.launch { repository.setMasterNotifications(enabled) }
    }

    fun setNotifyPlans(enabled: Boolean) {
        viewModelScope.launch { repository.setNotifyPlans(enabled) }
    }

    fun setNotifyTasks(enabled: Boolean) {
        viewModelScope.launch { repository.setNotifyTasks(enabled) }
    }

    fun setNotifyStreaks(enabled: Boolean) {
        viewModelScope.launch { repository.setNotifyStreaks(enabled) }
    }

    fun setNotifyGamification(enabled: Boolean) {
        viewModelScope.launch { repository.setNotifyGamification(enabled) }
    }

    fun setNotificationVolume(volume: Float) {
        viewModelScope.launch { repository.setNotificationVolume(volume) }
    }

    fun setNotificationSoundProfile(profile: String) {
        viewModelScope.launch { repository.setNotificationSoundProfile(profile) }
    }

    fun setGoogleCalendarSync(enabled: Boolean) {
        viewModelScope.launch { repository.setGoogleCalendarSync(enabled) }
    }

    fun setGoogleCalendarAutoPush(enabled: Boolean) {
        viewModelScope.launch { repository.setGoogleCalendarAutoPush(enabled) }
    }
}
