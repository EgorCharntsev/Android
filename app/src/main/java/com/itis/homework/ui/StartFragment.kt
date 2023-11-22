package com.itis.homework.ui

import android.app.NotificationManager
import android.app.NotificationChannel
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import com.itis.homework.R
import com.itis.homework.databinding.FragmentStartBinding

class StartFragment : Fragment(R.layout.fragment_start) {

    private var _viewBinding : FragmentStartBinding? = null
    private val viewBinding : FragmentStartBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentStartBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val builder : NotificationCompat.Builder =
//            NotificationCompat.Builder(this)
//                .setContentTitle("Test notification")
//                .setContentText("Test text")
//
//        val notificationManager : NotificationManager =
//            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

    companion object {
        val START_FRAGMENT_KEY = "START_FRAGMENT_KEY"
        fun newInstance() = StartFragment()
    }
}