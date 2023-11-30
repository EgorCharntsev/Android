package com.itis.homework

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Build.VERSION_CODES.TIRAMISU
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.itis.homework.databinding.ActivityMainBinding
import com.itis.homework.repository.CoroutinesRepository
import com.itis.homework.ui.CoroutineFragment
import com.itis.homework.ui.NotificationFragment
import com.itis.homework.ui.StartFragment
import com.itis.homework.util.NotificationHandler
import com.itis.homework.util.PermissionRequestHandler
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private var _viewBinding: ActivityMainBinding? = null
    private val viewBinding: ActivityMainBinding get() = _viewBinding!!

    private var permissionRequestHandler: PermissionRequestHandler? = null
    private var job: Job? = null
    private var isStopOnBackground = false
    private var unfinishedCoroutines = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val newBinding = viewBinding.root
        setContentView(newBinding)

        initBottomNavigationView()
        permissionHandler()

        if (Build.VERSION.SDK_INT >= TIRAMISU) {
            requestPermission(POST_NOTIFICATIONS)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationHandler.createNotificationChannel(this)
        }
    }

    fun requestPermission(permission: String) {
        permissionRequestHandler?.requestPermission(permission)
    }

    private fun initBottomNavigationView() {
        val controller =
            (supportFragmentManager.findFragmentById(R.id.activity_main_container) as NavHostFragment).navController

        NavigationUI.setupWithNavController(viewBinding.bnvMain, controller, false)

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val action = intent?.getIntExtra("action", NO_ACTION) ?: NO_ACTION
        onIntentAction(action)
    }

    private fun onIntentAction(action: Int) {
        when (action) {
            ACTION_SEND_MESSAGE -> {
                Snackbar.make(
                        viewBinding.root, getString(R.string.str_message), Snackbar.LENGTH_SHORT
                    ).show()
            }

            ACTION_OPEN_SETTINGS -> {
                (supportFragmentManager.findFragmentById(R.id.activity_main_container) as NavHostFragment).navController.apply {
                        if (currentDestination?.id != R.id.notificationFragment) {
                            popBackStack(R.id.startFragment, false)
                            navigate(R.id.action_startFragment_to_notificationFragment)
                        }
                    }
            }
        }
    }

    fun startCoroutines() {
        unfinishedCoroutines = CoroutinesRepository.progress
        isStopOnBackground = CoroutinesRepository.isStopOnBackground

        job = lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                repeat(CoroutinesRepository.progress) {
                    if (CoroutinesRepository.isAsync) {
                        launch {
                            startCoroutine(it + 1)
                        }
                    } else {
                        startCoroutine(it + 1)
                    }
                }
            }
        }.also { coroutines ->
            coroutines.invokeOnCompletion { cause ->
                if (cause == null) {
                    NotificationHandler.createCoroutinesNotification(this)
                } else if (cause is CancellationException) {
                    Log.e(
                        javaClass.name,
                        "$unfinishedCoroutines coroutines didn't complete their work!"
                    )
                }
            }
        }
    }

    private suspend fun startCoroutine(index: Int) {
        delay(2345)
        Log.e(javaClass.name, "Coroutine $index has completed its work!")
        unfinishedCoroutines--
    }

    private fun permissionHandler() {
        permissionRequestHandler = PermissionRequestHandler(this, {
            Snackbar.make(
                    viewBinding.root,
                    getString(R.string.str_successful_given_permission),
                    Snackbar.LENGTH_SHORT
                ).show()
        }, {
            val dialog =
                AlertDialog.Builder(this).setTitle(getString(R.string.str_denied_notifications))
                    .setMessage(getString(R.string.str_denied_message))
                    .setPositiveButton(getString(R.string.str_accept), null).show()
            val b = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
            b.setOnClickListener {
                if (Build.VERSION.SDK_INT >= TIRAMISU) {
                    requestPermission(POST_NOTIFICATIONS)
                }
                dialog.dismiss()
            }
        }, {
            AlertDialog.Builder(this).setTitle(getString(R.string.str_denied_notifications))
                .setMessage(getString(R.string.str_denied_notifications_two))
                .setPositiveButton(getString(R.string.str_settings)) { _, _ ->
                    val appSettingsIntent = Intent(
                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + this.packageName)
                    )
                    startActivity(appSettingsIntent)
                }.show()
        })
    }

    override fun onStop() {
        if (isStopOnBackground) {
            job?.cancel(getString(R.string.str_cancel_coroutines))
        }
        super.onStop()
    }

    companion object {
        const val NO_ACTION = 0
        const val ACTION_SEND_MESSAGE = 1
        const val ACTION_OPEN_SETTINGS = 2
    }
}