package com.itis.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itis.homework.R
import com.itis.homework.base.BaseFragment
import com.itis.homework.databinding.FragmentStartBinding

class StartFragment : BaseFragment(R.layout.fragment_start) {
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