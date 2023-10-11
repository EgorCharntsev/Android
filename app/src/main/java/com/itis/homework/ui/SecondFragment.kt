package com.itis.homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.itis.homework.R
import com.itis.homework.base.BaseActivity
import com.itis.homework.base.BaseFragment
import com.itis.homework.databinding.FragmentSecondScreenBinding
import com.itis.homework.utils.ActionType
import com.itis.homework.utils.ParamsKey

class SecondFragment : BaseFragment(R.layout.fragment_second_screen) {

    private var _viewBinding: FragmentSecondScreenBinding? = null
    private val viewBinding: FragmentSecondScreenBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentSecondScreenBinding.inflate(inflater)
        return viewBinding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            arguments?.getString(ParamsKey.MESSAGE_TEXT_KEY)?.let {message ->
                if (message != "") {
                    tvSecondScreen.text = message
                } else {
                    tvSecondScreen.text = getString(R.string.second_screen)
                }

                btnSecondToThird.setOnClickListener {
                    parentFragmentManager.popBackStack()

                    (requireActivity() as? BaseActivity)?.goToScreen(
                        actionType = ActionType.REPLACE,
                        destination = ThirdFragment.newInstance(message = message),
                        tag = ThirdFragment.THIRD_FRAGMENT_TAG,
                        isAddToBackStack = true,
                    )
                }
            }

            btnSecondToFirst.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        _viewBinding = null
        super.onDestroyView()
    }

    companion object {

        const val SECOND_FRAGMENT_TAG = "SECOND_FRAGMENT_TAG"

        fun newInstance(message: String) = SecondFragment().apply {
            arguments = bundleOf(ParamsKey.MESSAGE_TEXT_KEY to message)
        }
    }
}