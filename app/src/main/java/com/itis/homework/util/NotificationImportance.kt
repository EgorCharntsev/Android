package com.itis.homework.util

import android.app.NotificationManager

enum class NotificationImportance(val value: String, val id: Int) {
    URGENT("Urgent", NotificationManager.IMPORTANCE_HIGH),
    HIGH("High", NotificationManager.IMPORTANCE_DEFAULT),
    MEDIUM("Medium", NotificationManager.IMPORTANCE_LOW);
}