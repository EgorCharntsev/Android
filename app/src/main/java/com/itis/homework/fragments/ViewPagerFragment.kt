package com.itis.homework.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import com.itis.homework.R
import com.itis.homework.adapter.ViewPagerAdapter
import com.itis.homework.base.BaseFragment
import com.itis.homework.databinding.FragmentViewPagerBinding
import com.itis.homework.utils.Generator
import com.itis.homework.utils.ParamsKey

class ViewPagerFragment : BaseFragment(R.layout.fragment_view_pager) {
    private val binding: FragmentViewPagerBinding by viewBinding (FragmentViewPagerBinding::bind)
    private var viewPagerAdapter: ViewPagerAdapter? = null
    private var answers: MutableMap<Int, Boolean> = HashMap()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val count = arguments?.getInt(ParamsKey.QUESTION_KEY)

        if (count != null) {
            viewPagerAdapter = context?.let { Generator.generateQuestions(count, it) }?.let {
                ViewPagerAdapter(
                    manager = parentFragmentManager, lifecycle,
                    it
                )
            }

            binding.apply {
                vp2.adapter = viewPagerAdapter
                vp2.run {
                    registerOnPageChangeCallback(object : OnPageChangeCallback() {
                        override fun onPageScrolled(
                            position: Int,
                            positionOffset: Float,
                            positionOffsetPixels: Int
                        ) {
                            if (position == 0 && positionOffset == 0.0f) {
                                setCurrentItem(count, false)
                            } else if (position == count + 1 && positionOffset == 0.0f) {
                                setCurrentItem(1, false)
                            }
                        }

                        override fun onPageSelected(position: Int) {
                            val pos = when (position) {
                                0 -> count
                                count + 1 -> 1
                                else -> position
                            }
                            "$pos/$count".also { binding.tvStartFragmentMessage.text = it }
                        }

                        override fun onPageScrollStateChanged(state: Int) {
                            super.onPageScrollStateChanged(state)
                        }
                    })
                    setCurrentItem(1, false)
                }

                btnFinishSurvey.setOnClickListener {
                    Toast.makeText(context, "Нou have completed the survey!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun answerQuestion(questionNumber: Int) {
        answers[questionNumber] = true
        val count = arguments?.getInt(ParamsKey.QUESTION_KEY)
        if (answers.size == count) {
            binding.btnFinishSurvey.visibility = View.VISIBLE
        }
    }
    companion object {
        const val VIEW_PAGER_FRAGMENT_TAG = "VIEW_PAGER_FRAGMENT_TAG"

        fun newInstance(count: Int) = ViewPagerFragment().apply {
            arguments = bundleOf(ParamsKey.QUESTION_KEY to count)
        }
    }
}