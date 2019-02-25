package com.kotlex.system.android

import android.content.Context
import android.hardware.SensorManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.net.wifi.WifiManager
import android.os.UserManager
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.WindowManager


//val Context.accessibilityManager get() = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
//
//val Context.accountManager get() = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
//val Context.activityManager get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
//val Context.alarmManager get() = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//val Context.appWidgetManager
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    get() = getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager
//val Context.appOpsManager get() = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
//val Context.audioManager get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager
//val Context.batteryManager
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    get() = getSystemService(Context.BATTERY_SERVICE) as BatteryManager
//val Context.bluetoothManager get() = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
//val Context.captioningManager get() = getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager
//val Context.carrierConfigManager
//    @RequiresApi(Build.VERSION_CODES.M)
//    get() = getSystemService(Context.CARRIER_CONFIG_SERVICE) as CarrierConfigManager
//val Context.clipboardManager get() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//val Context.companionDeviceManager
//    @RequiresApi(Build.VERSION_CODES.O)
//    get() = getSystemService(Context.COMPANION_DEVICE_SERVICE) as CompanionDeviceManager
//val Context.connectivityManager get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//val Context.consumerIrManager get() = getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager
//val Context.downloadManager get() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
//val Context.dropBoxManager get() = getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager
//val Context.euiccManager
//    @RequiresApi(Build.VERSION_CODES.P)
//    get() = getSystemService(Context.EUICC_SERVICE) as EuiccManager
//val Context.fingerprintManager
//    @RequiresApi(Build.VERSION_CODES.M)
//    get() = getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager
//val Context.hardwarePropertiesManager
//    @RequiresApi(Build.VERSION_CODES.N)
//    get() = getSystemService(Context.HARDWARE_PROPERTIES_SERVICE) as HardwarePropertiesManager
//val Context.inputMethodManager get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//val Context.inputManager get() = getSystemService(Context.INPUT_SERVICE) as InputManager
//val Context.ipSecManager
//    @RequiresApi(Build.VERSION_CODES.P)
//    get() = getSystemService(Context.IPSEC_SERVICE) as IpSecManager
//val Context.jobScheduler
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    get() = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
//val Context.keyguardManager get() = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
//val Context.launcherApps
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    get() = getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps
//val Context.layoutInflater get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//val Context.locationManager get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//val Context.mediaProjectionManager
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    get() = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
//val Context.mediaRouter get() = getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter
//val Context.mediaSessionManager
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    get() = getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager
//val Context.midiManager
//    @RequiresApi(Build.VERSION_CODES.M)
//    get() = getSystemService(Context.MIDI_SERVICE) as MidiManager
//val Context.networkStatsManager
//    @RequiresApi(Build.VERSION_CODES.M)
//    get() = getSystemService(Context.NETWORK_STATS_SERVICE) as NetworkStatsManager
//
//val Context.nfcManager get() = getSystemService(Context.NFC_SERVICE) as NfcManager
//val Context.notificationManager get() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//val Context.nsdManager get() = getSystemService(Context.NSD_SERVICE) as NsdManager
//val Context.powerManager get() = getSystemService(Context.POWER_SERVICE) as PowerManager
//val Context.printManager get() = getSystemService(Context.PRINT_SERVICE) as PrintManager
//val Context.restrictionsManager
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    get() = getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager
//val Context.searchManager get() = getSystemService(Context.SEARCH_SERVICE) as SearchManager
//val Context.sensorManager get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager
//val Context.shortcutManager
//    @RequiresApi(Build.VERSION_CODES.N_MR1)
//    get() = getSystemService(Context.SHORTCUT_SERVICE) as ShortcutManager
//val Context.storageStatsManager
//    @RequiresApi(Build.VERSION_CODES.O)
//    get() = getSystemService(Context.STORAGE_STATS_SERVICE) as StorageStatsManager
//val Context.telecomManager
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    get() = getSystemService(Context.TELECOM_SERVICE) as TelecomManager
//val Context.telephonyManager get() = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//val Context.subscriptionManager
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
//    get() = getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager
//val Context.textClassificationManager
//    @RequiresApi(Build.VERSION_CODES.O)
//    get() = getSystemService(Context.TEXT_CLASSIFICATION_SERVICE) as TextClassificationManager
//val Context.textServicesManager get() = getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager
//val Context.tvInputManager
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    get() = getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager
//val Context.uiModeManager get() = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
//val Context.usageStatsManager
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
//    get() = getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
//val Context.usbManager get() = getSystemService(Context.USB_SERVICE) as UsbManager
//val Context.userManager get() = getSystemService(Context.USER_SERVICE) as UserManager
//val Context.vibrator get() = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//val Context.wallpaperService get() = getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager
//val Context.wifiAwareManager
//    @RequiresApi(Build.VERSION_CODES.O)
//    get() = getSystemService(Context.WIFI_AWARE_SERVICE) as WifiAwareManager
//val Context.wifiP2pManager get() = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager
//val Context.wifiRttManager
//    @RequiresApi(Build.VERSION_CODES.P)
//    get() = getSystemService(Context.WIFI_RTT_RANGING_SERVICE) as WifiRttManager
//val Context.windowManager get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager
//val Context.wifiManager get() = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager


val Context.sensors get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager
val Context.layoutInflater get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
val Context.locations get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager
val Context.usb get() = getSystemService(Context.USB_SERVICE) as UsbManager
val Context.users get() = getSystemService(Context.USER_SERVICE) as UserManager
val Context.vibrator get() = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
val Context.window get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager
val Context.wifi get() = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager