package com.itis.homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.itis.homework.R
import com.itis.homework.databinding.FragmentNotificationBinding
import com.itis.homework.repository.NotificationRepository
import com.itis.homework.util.NotificationImportance
import com.itis.homework.util.NotificationVisibility

class NotificationFragment : Fragment(R.layout.fragment_notification) {

    private var _viewBinding : FragmentNotificationBinding? = null
    private val viewBinding : FragmentNotificationBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentNotificationBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        val visibilityAdapter = ArrayAdapter(
            requireContext(),
            R.layout.notification_item,
            NotificationVisibility.values()
        )

        with(viewBinding) {
            val importanceAdapter = ArrayAdapter(
                requireContext(),
                R.layout.notification_item,
                NotificationImportance.values()
            )
            actvImportance.setAdapter(importanceAdapter)
            actvImportance.setText(NotificationRepository.importance.value,false)
            actvImportance.onItemClickListener = AdapterView.OnItemClickListener { parent, _, position, _ ->
                    NotificationRepository.importance = parent.getItemAtPosition(position) as NotificationImportance
                }

            actvVisibility.setAdapter(visibilityAdapter)
            actvVisibility.setText(NotificationRepository.visibility.value, false)
            actvVisibility.onItemClickListener = AdapterView.OnItemClickListener { parent, _, position, _ ->
                    NotificationRepository.visibility = parent.getItemAtPosition(position) as NotificationVisibility
                }

            cbBigText.setOnCheckedChangeListener { _, isChecked ->
                NotificationRepository.isBigText = isChecked
            }
            cbBigText.isChecked = NotificationRepository.isBigText


            cbButtonsShow.setOnCheckedChangeListener { _, isChecked ->
                NotificationRepository.isButtonsShow = isChecked
            }
            cbButtonsShow.isChecked = NotificationRepository.isButtonsShow

        }
    }

    override fun onDestroyView() {
        _viewBinding = null
        super.onDestroyView()

    }
}