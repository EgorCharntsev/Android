package com.itis.homework.util

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class PermissionRequestHandler(
    activity: AppCompatActivity,
    private val callback: (() -> Unit)? = null,
    private val rationaleCallback: (() -> Unit)? = null,
    private val deniedCallback: (() -> Unit)? = null,
) {

    private var currentPermission = ""

    private val singlePermissionLauncher =
        activity.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                callback?.invoke()
            } else {
                if (currentPermission.isNotEmpty() && activity.shouldShowRequestPermissionRationale(currentPermission)) {
                    rationaleCallback?.invoke()
                } else {
                    deniedCallback?.invoke()
                }
            }
        }

    private val multiplePermissionsLauncher = activity.registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissionsMap ->
        var check = true
        permissionsMap.forEach {
            if (!it.value) {
                check = false
                return@forEach
            }
        }
        if (check) {
            callback?.invoke()
        } else {
            permissionsMap.forEach {
                if (activity.shouldShowRequestPermissionRationale(it.key)) {
                    rationaleCallback?.invoke()
                } else {
                    deniedCallback?.invoke()
                }
            }
        }
    }

    fun requestPermission(permission: String) {
        this.currentPermission = permission
        singlePermissionLauncher.launch(permission)
    }
}