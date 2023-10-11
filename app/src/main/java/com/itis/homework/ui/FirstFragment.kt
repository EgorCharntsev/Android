package com.itis.homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.itis.homework.R
import com.itis.homework.base.BaseActivity
import com.itis.homework.base.BaseFragment
import com.itis.homework.databinding.FragmentFirstScreenBinding
import com.itis.homework.utils.ActionType
import com.itis.homework.utils.ParamsKey

class FirstFragment : BaseFragment(R.layout.fragment_first_screen) {

    private var _viewBinding: FragmentFirstScreenBinding? = null
    private val viewBinding: FragmentFirstScreenBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentFirstScreenBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            arguments?.getString(ParamsKey.MESSAGE_TEXT_KEY)?.let {
                tvFirstScreen.text = it
            }

            btnFirstScreen.setOnClickListener {
                (requireActivity() as? BaseActivity)?.goToScreen(
                    actionType = ActionType.REPLACE,
                    destination = SecondFragment.newInstance(message = etFirstScreen.text.toString()),
                    tag = SecondFragment.SECOND_FRAGMENT_TAG,
                    isAddToBackStack = true,
                )

                (requireActivity() as? BaseActivity)?.goToScreen(
                    actionType = ActionType.REPLACE,
                    destination = ThirdFragment.newInstance(message = etFirstScreen.text.toString()),
                    tag = ThirdFragment.THIRD_FRAGMENT_TAG,
                    isAddToBackStack = true,
                )
            }
        }
    }

    override fun onDestroyView() {
        _viewBinding = null
        super.onDestroyView()
    }

    companion object {

        const val FIRST_FRAGMENT_TAG = "FIRST_FRAGMENT_TAG"

        fun newInstance(message: String) = FirstFragment().apply {
            arguments = bundleOf(ParamsKey.MESSAGE_TEXT_KEY to message)
        }
    }
}