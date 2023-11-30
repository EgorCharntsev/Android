package com.itis.homework.repository

import com.itis.homework.util.NotificationImportance
import com.itis.homework.util.NotificationVisibility

object NotificationRepository {
    var title = ""
    var text = ""
    var importance = NotificationImportance.HIGH
    var visibility = NotificationVisibility.PUBLIC
    var isBigText = false
    var isButtonsShow = false

}