package com.itis.homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.itis.homework.R
import com.itis.homework.base.BaseFragment
import com.itis.homework.databinding.FragmentThirdScreenBinding
import com.itis.homework.utils.ParamsKey

class ThirdFragment : BaseFragment(R.layout.fragment_third_screen) {

    private var _viewBinding: FragmentThirdScreenBinding? = null
    private val viewBinding: FragmentThirdScreenBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentThirdScreenBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            arguments?.getString(ParamsKey.MESSAGE_TEXT_KEY)?.let { message ->
                if (message != "") {
                    tvThirdScreen.text = message
                } else {
                    tvThirdScreen.text = getString(R.string.third_screen)
                }
            }
        }
    }

    override fun onDestroyView() {
        _viewBinding = null
        super.onDestroyView()
    }

    companion object {

        const val THIRD_FRAGMENT_TAG = "THIRD_FRAGMENT_TAG"

        fun newInstance(message: String) = ThirdFragment().apply {
            arguments = bundleOf(ParamsKey.MESSAGE_TEXT_KEY to message)
        }
    }
}