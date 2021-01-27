package br.com.henriquealtmayer.navigationcomponent.commons

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.content.ContextCompat

fun Context.initializeNotificationChannel(
    channelName: String = defaultNotificationChannel,
    channelDescription: String = defaultNotificationChannelDescription,
    channelId: String = defaultNotificationChannelId
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = channelDescription
        }

        // Register the channel with the system
        val notificationManager = ContextCompat.getSystemService(
            this,
            NotificationManager::class.java
        )

        notificationManager?.createNotificationChannel(channel)
    }
}