package com.kotlex.system.android

import android.accounts.AccountManager
import android.app.*
import android.app.job.JobScheduler
import android.app.usage.NetworkStatsManager
import android.app.usage.StorageStatsManager
import android.app.usage.UsageStatsManager
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.companion.CompanionDeviceManager
import android.content.ClipboardManager
import android.content.Context
import android.content.RestrictionsManager
import android.content.pm.LauncherApps
import android.content.pm.ShortcutManager
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.fingerprint.FingerprintManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.media.midi.MidiManager
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import android.media.tv.TvInputManager
import android.net.ConnectivityManager
import android.net.IpSecManager
import android.net.nsd.NsdManager
import android.net.wifi.WifiManager
import android.net.wifi.aware.WifiAwareManager
import android.net.wifi.p2p.WifiP2pManager
import android.net.wifi.rtt.WifiRttManager
import android.nfc.NfcManager
import android.os.*
import android.print.PrintManager
import android.support.annotation.RequiresApi
import android.telecom.TelecomManager
import android.telephony.CarrierConfigManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.telephony.euicc.EuiccManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textclassifier.TextClassificationManager
import android.view.textservice.TextServicesManager


val Context.services
    get() = ServiceProvider(this)

class ServiceProvider(private val context: Context) {
    fun getAccessibilityManager() = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
    fun getAccountManager() = context.getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
    fun getActivityManager() = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    fun getAlarmManager() = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getAppWidgetManager() = context.getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager

    fun getAppOpsManager() = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
    fun getAudioManager() = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getBatteryManager() = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager

    fun getBluetoothManager() = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    fun getCaptioningManager() = context.getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager
    @RequiresApi(Build.VERSION_CODES.M)
    fun getCarrierConfigManager() = context.getSystemService(Context.CARRIER_CONFIG_SERVICE) as CarrierConfigManager

    fun getClipboardManager() = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCompanionDeviceManager() =
        context.getSystemService(Context.COMPANION_DEVICE_SERVICE) as CompanionDeviceManager

    fun getConnectivityManager() = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    fun getConsumerIrManager() = context.getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager
    fun getDownloadManager() = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    fun getDropBoxManager() = context.getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager
    @RequiresApi(Build.VERSION_CODES.P)
    fun getEuiccManager() = context.getSystemService(Context.EUICC_SERVICE) as EuiccManager

    @RequiresApi(Build.VERSION_CODES.M)
    fun getFingerprintManager() = context.getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager

    @RequiresApi(Build.VERSION_CODES.N)
    fun getHardwarePropertiesManager() =
        context.getSystemService(Context.HARDWARE_PROPERTIES_SERVICE) as HardwarePropertiesManager

    fun getInputMethodManager() = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    fun getInputManager() = context.getSystemService(Context.INPUT_SERVICE) as InputManager
    @RequiresApi(Build.VERSION_CODES.P)
    fun getIpSecManager() = context.getSystemService(Context.IPSEC_SERVICE) as IpSecManager

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getJobScheduler() = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

    fun getKeyguardManager() = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getLauncherApps() = context.getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps

    fun getLayoutInflater() = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    fun getLocationManager() = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getMediaProjectionManager() =
        context.getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

    fun getMediaRouter() = context.getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getMediaSessionManager() = context.getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager

    @RequiresApi(Build.VERSION_CODES.M)
    fun getMidiManager() = context.getSystemService(Context.MIDI_SERVICE) as MidiManager

    @RequiresApi(Build.VERSION_CODES.M)
    fun getNetworkStatsManager() = context.getSystemService(Context.NETWORK_STATS_SERVICE) as NetworkStatsManager

    fun getNfcManager() = context.getSystemService(Context.NFC_SERVICE) as NfcManager
    fun getNotificationManager() = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    fun getNsdManager() = context.getSystemService(Context.NSD_SERVICE) as NsdManager
    fun getPowerManager() = context.getSystemService(Context.POWER_SERVICE) as PowerManager
    fun getPrintManager() = context.getSystemService(Context.PRINT_SERVICE) as PrintManager
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getRestrictionsManager() = context.getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager

    fun getSearchManager() = context.getSystemService(Context.SEARCH_SERVICE) as SearchManager
    fun getSensorManager() = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    @RequiresApi(Build.VERSION_CODES.N_MR1)
    fun getShortcutManager() = context.getSystemService(Context.SHORTCUT_SERVICE) as ShortcutManager

    @RequiresApi(Build.VERSION_CODES.O)
    fun getStorageStatsManager() = context.getSystemService(Context.STORAGE_STATS_SERVICE) as StorageStatsManager

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getTelecomManager() = context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager

    fun getTelephonyManager() = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun getSubscriptionManager() =
        context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTextClassificationManager() =
        context.getSystemService(Context.TEXT_CLASSIFICATION_SERVICE) as TextClassificationManager

    fun getTextServicesManager() =
        context.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getTvInputManager() = context.getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager

    fun getUiModeManager() = context.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun getUsageStatsManager() = context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager

    fun getUsbManager() = context.getSystemService(Context.USB_SERVICE) as UsbManager
    fun getUserManager() = context.getSystemService(Context.USER_SERVICE) as UserManager
    fun getVibrator() = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    fun getWallpaperService() = context.getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager
    @RequiresApi(Build.VERSION_CODES.O)
    fun getWifiAwareManager() = context.getSystemService(Context.WIFI_AWARE_SERVICE) as WifiAwareManager

    fun getWifiP2pManager() = context.getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager
    @RequiresApi(Build.VERSION_CODES.P)
    fun getWifiRttManager() = context.getSystemService(Context.WIFI_RTT_RANGING_SERVICE) as WifiRttManager

    fun getWindowManager() = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    fun getWifiManager() = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
}