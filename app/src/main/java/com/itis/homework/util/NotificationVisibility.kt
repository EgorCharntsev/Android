package com.itis.homework.util

import android.app.Notification

enum class NotificationVisibility(val value: String, val id: Int){
    SECRET("Secret", Notification.VISIBILITY_SECRET),
    PRIVATE("Private", Notification.VISIBILITY_PRIVATE),
    PUBLIC("Public", Notification.VISIBILITY_PUBLIC);
}