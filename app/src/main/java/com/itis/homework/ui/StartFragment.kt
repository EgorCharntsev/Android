package com.itis.homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.itis.homework.R
import com.itis.homework.databinding.FragmentStartBinding
import com.itis.homework.util.NotificationHandler
import com.itis.homework.repository.NotificationRepository
import com.itis.homework.util.ParamsKey

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
        initView()
    }

    private fun initView() {
        with(viewBinding) {
            var isTitleCorrect = true
            etTitle.setText(NotificationRepository.title)
            etTitle.addTextChangedListener { title ->
                NotificationRepository.title = title.toString()

                if (title.isNullOrEmpty()) {
                    tilTitle.error = getString(R.string.str_message_error_null)
                    isTitleCorrect = false
                } else if (title.length > ParamsKey.NOTIFICATION_TITLE_MAX_SIZE) {
                    tilTitle.error = getString(R.string.str_message_error)
                    isTitleCorrect = false
                } else {
                    tilTitle.error = null
                    isTitleCorrect = true
                }
            }

            var isTextCorrect = true
            etText.setText(NotificationRepository.text)
            etText.addTextChangedListener { text ->
                NotificationRepository.text = text.toString()

                if (text.isNullOrEmpty()) {
                    tilText.error = getString(R.string.str_message_error_null)
                    isTextCorrect = false
                } else if (text.length > ParamsKey.NOTIFICATION_TEXT_MAX_SIZE) {
                    tilText.error = getString(R.string.str_message_error)
                    isTextCorrect = false
                } else {
                    tilText.error = null
                    isTextCorrect = true
                }
            }

            btnStart.setOnClickListener {
                if (isTitleCorrect && isTextCorrect) {
                    NotificationHandler.createNotification(requireContext())
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}