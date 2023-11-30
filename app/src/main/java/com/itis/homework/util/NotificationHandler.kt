package com.itis.homework.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.Builder
import com.itis.homework.MainActivity
import com.itis.homework.R
import com.itis.homework.repository.NotificationRepository

object NotificationHandler {

    fun createNotificationChannel(context: Context) {
        (context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager)?.let { manager ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                for (notificationImportance in NotificationImportance.values()) {
                    manager.createNotificationChannel(
                        NotificationChannel(
                            context.getString(R.string.str_default_channel_id) + "_" + notificationImportance.name,
                            notificationImportance.value,
                            notificationImportance.id
                        )
                    )
                }
            }
        }
    }

    fun createNotification(context: Context) {
        val channel = context.getString(R.string.str_default_channel_id) + "_" + NotificationRepository.importance

        val builder = NotificationCompat.Builder(context, channel)
            .setSmallIcon(R.drawable.baseline_circle_notifications_24)
            .setContentTitle(NotificationRepository.title)
            .setContentText(NotificationRepository.text)
            .setVisibility(NotificationRepository.visibility.id)
            .setPublicVersion(NotificationCompat.Builder(context, channel)
                    .setSmallIcon(R.drawable.baseline_circle_notifications_24)
                    .setContentTitle(NotificationRepository.title)
                    .build()
            )

        if (NotificationRepository.isBigText) {
            builder.setStyle(NotificationCompat.BigTextStyle().bigText(NotificationRepository.text))
        }

        if (NotificationRepository.isButtonsShow) {
            setButtonsOnNotification(context, builder)
        }

        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        builder.setContentIntent(PendingIntent.getActivity(
            context,
            2,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        ))

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, builder.build())
    }

    private fun setButtonsOnNotification(context: Context, builder: Builder) {
        val messageIntent = Intent(context, MainActivity::class.java)
        messageIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        messageIntent.putExtra(context.getString(R.string.str_action), MainActivity.ACTION_SEND_MESSAGE)
        builder.addAction(
            NotificationCompat.Action(
                null,
                context.getString(R.string.str_send_message),
                PendingIntent.getActivity(
                    context,
                    0,
                    messageIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
                )
            )
        )

        val settingsIntent = Intent(context, MainActivity::class.java)
        settingsIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        settingsIntent.putExtra(context.getString(R.string.str_action), MainActivity.ACTION_OPEN_SETTINGS)
        builder.addAction(
            NotificationCompat.Action(
                null,
                context.getString(R.string.str_open_settings),
                PendingIntent.getActivity(
                    context,
                    1,
                    settingsIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
                )
            )
        )
    }

    fun createCoroutinesNotification(context: Context) {
        val channel = context.getString(R.string.str_default_channel_id) + "_" + NotificationImportance.URGENT

        val builder = NotificationCompat.Builder(context, channel)
            .setSmallIcon(R.drawable.baseline_circle_notifications_24)
            .setContentTitle(context.getString(R.string.str_title_coroutines))
            .setContentText(context.getString(R.string.str_finish_coroutines))

        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        builder.setContentIntent(PendingIntent.getActivity(
            context,
            3,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        ))

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, builder.build())
    }

}