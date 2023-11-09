package com.itis.homework.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.itis.homework.R
import com.itis.homework.base.BaseActivity
import com.itis.homework.base.BaseFragment
import com.itis.homework.databinding.FragmentStartBinding
import com.itis.homework.utils.ActionType

class StartFragment : BaseFragment(R.layout.fragment_start) {
    private var _viewBinding : FragmentStartBinding? = null
    private     val viewBinding : FragmentStartBinding get() = _viewBinding!!

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

        phoneInput()

        if (viewBinding.etStartFragmentNumber.text!!.length == 18) {
            if (!viewBinding.etStartFragmentNumber.text.toString().matches(Regex("^\\+7\\s\\(9\\d{2}\\)-\\d{3}(-\\d{2}){2}$"))) {
                viewBinding.tilStartFragmentNumber.error = "Irregular input number!"
            } else {
                viewBinding.dtnStartFragmentEnter.setOnClickListener {
                    (requireActivity() as? BaseActivity)?.goToScreen(
                        ActionType.REPLACE,
                        ViewPagerFragment.newInstance(viewBinding.etStartFragmentQuestions.text.toString().toInt()),
                        START_FRAGMENT_TAG
                    )
                }
            }
        }
    }

    private fun phoneInput() {
        viewBinding.apply {

            etStartFragmentNumber.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus && etStartFragmentNumber.text!!.length == 0) {
                    etStartFragmentNumber.setText("+7 (9")
                    etStartFragmentNumber.setSelection(5)
                }
            }

            etStartFragmentNumber.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

//                    if (etStartFragmentNumber.text!!.length in 1..4) {
//                        etStartFragmentNumber.setText("+7 (9")
//                        etStartFragmentNumber.setSelection(5)
//                        etStartFragmentNumber.addTextChangedListener(this)
//                    }

                    if (etStartFragmentNumber.text!!.length == 5 && start == 5) {
                        etStartFragmentNumber.setText("")

                    }

                    s?.let {
                        val countOfChars = etStartFragmentNumber.text!!.length
                        if (before > 0) {
                            if (etStartFragmentNumber.text!!.last() == '-') {
                                if (s.last() == ')') {
                                    etStartFragmentNumber.setText(
                                        etStartFragmentNumber.text!!.substring(
                                            0,
                                            countOfChars - 2
                                        )
                                    )
                                } else {
                                    etStartFragmentNumber.setText(
                                        etStartFragmentNumber.text!!.substring(
                                            0,
                                            countOfChars - 1
                                        )
                                    )
                                }
                                etStartFragmentNumber.setSelection(etStartFragmentNumber.text!!.length)
                                etStartFragmentNumber.addTextChangedListener(this)
                            }
                        } else {
                            when (countOfChars) {
                                5 -> {
                                    if (s.length == 1) {
                                        etStartFragmentNumber.append(s)
                                    } else {
                                        etStartFragmentNumber.append(s.substring(5))
                                    }
                                    etStartFragmentNumber.setSelection(etStartFragmentNumber.text!!.length)
                                    etStartFragmentNumber.addTextChangedListener(this)
                                }

                                7 -> {
                                    etStartFragmentNumber.append(")-")
                                    etStartFragmentNumber.setSelection(etStartFragmentNumber.text!!.length)
                                    etStartFragmentNumber.addTextChangedListener(this)
                                }

                                12, 15 -> {
                                    etStartFragmentNumber.append("-")
                                    etStartFragmentNumber.setSelection(etStartFragmentNumber.text!!.length)
                                    etStartFragmentNumber.addTextChangedListener(this)
                                }
                            }
                        }
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                    if (etStartFragmentNumber.text!!.length > 18) {
                        tilStartFragmentNumber.error = "Max length!"
                    }

                    if (etStartFragmentNumber.text!!.length < 19) {
                        tilStartFragmentNumber.error = null
                    }
                    
                }

            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

    companion object {
        val START_FRAGMENT_TAG = "START_FRAGMENT_TAG"
        fun newInstance() = StartFragment()
    }
}