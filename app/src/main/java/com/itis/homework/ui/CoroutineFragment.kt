package com.itis.homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.itis.homework.MainActivity
import com.itis.homework.R
import com.itis.homework.databinding.FragmentCoroutineBinding
import com.itis.homework.repository.CoroutinesRepository

class CoroutineFragment : Fragment(R.layout.fragment_coroutine) {

    private var _viewBinding : FragmentCoroutineBinding? = null
    private val viewBinding : FragmentCoroutineBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentCoroutineBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        with(viewBinding) {
            cbAsync.isChecked = CoroutinesRepository.isAsync
            cbAsync.setOnCheckedChangeListener { _, isChecked ->
                CoroutinesRepository.isAsync = isChecked
            }

            cbStopOnBackground.isChecked = CoroutinesRepository.isStopOnBackground
            cbStopOnBackground.setOnCheckedChangeListener { _, isChecked ->
                CoroutinesRepository.isStopOnBackground = isChecked
            }

            sbCoroutines.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        CoroutinesRepository.progress = sbCoroutines.progress
                    }
                }
            )

            btnStartCoroutines.setOnClickListener {
                (activity as MainActivity).startCoroutines()
            }
        }
    }

    override fun onDestroyView() {
        _viewBinding = null
        super.onDestroyView()
    }
}