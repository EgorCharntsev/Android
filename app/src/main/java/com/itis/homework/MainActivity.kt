package com.itis.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.itis.homework.databinding.ActivityMainBinding
import com.itis.homework.ui.CoroutineFragment
import com.itis.homework.ui.NotificationFragment
import com.itis.homework.ui.StartFragment

class MainActivity : AppCompatActivity() {

    private val fragmentContainerId: Int = R.id.activity_main_container
    private var _viewBinding : ActivityMainBinding? = null
    private val viewBinding : ActivityMainBinding get() = _viewBinding!!

    private fun goToScreen(
        fragment : Fragment,
        fragmentKey : String,
    ) {
        supportFragmentManager.beginTransaction()
            .replace(
                fragmentContainerId,
                fragment,
                fragmentKey,
        ).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val newBinding = viewBinding.root
        setContentView(newBinding)

        initBottomNavigationView()

    }

    private fun initBottomNavigationView() {
        var controller = (supportFragmentManager.findFragmentById(R.id.activity_main_container) as NavHostFragment)
            .navController

        findViewById<BottomNavigationView>(R.id.bnv_main).apply {
            setupWithNavController(controller)
        }

        _viewBinding?.bnvMain?.setOnItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(item, controller)
            return@setOnItemSelectedListener true
        }
    }


}