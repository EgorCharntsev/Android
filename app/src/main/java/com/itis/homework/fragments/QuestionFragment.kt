package com.itis.homework.fragments

import QuestionAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.itis.homework.R
import com.itis.homework.base.BaseFragment
import com.itis.homework.databinding.FragmentQuestionBinding
import com.itis.homework.model.Question
import com.itis.homework.utils.ParamsKey

class QuestionFragment : BaseFragment(R.layout.fragment_question) {
    private var _viewBinding : FragmentQuestionBinding? = null
    private val viewBinding : FragmentQuestionBinding get() = _viewBinding!!
    private var questionAdapter : QuestionAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentQuestionBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val question : Question = arguments?.getSerializable(ParamsKey.QUESTION_KEY) as Question

        with(viewBinding) {
            tvQuestionFragmentHead.text = question.question
            questionAdapter = QuestionAdapter(
                answers = question.answers,
                onItemChecked = { position -> update(position)},
                onRootClicked = { position -> update(position)},
            )
            rvQuestionnaire.adapter = questionAdapter
        }
    }

    private fun update (position: Int) {
        questionAdapter?.let { questionAdapter ->
            val prevPosition = questionAdapter.answers.indexOfFirst { it.chosen }

            if (prevPosition != -1) {
                questionAdapter.answers[prevPosition].chosen = false
                questionAdapter.notifyItemChanged(prevPosition)
            }

            questionAdapter.answers[position].chosen = true
            questionAdapter.notifyItemChanged(position)

            val viewPagerFragment = requireActivity().supportFragmentManager.findFragmentByTag(ViewPagerFragment.VIEW_PAGER_FRAGMENT_TAG) as ViewPagerFragment
            val positionNumberQuestion = arguments?.getInt(ParamsKey.POSITION_NUMBER_QUESTION_KEY)
            if (positionNumberQuestion != null) viewPagerFragment.
        }
    }

    override fun onDestroyView() {
        _viewBinding = null
        super.onDestroyView()
    }

    companion object {
         const val QUESTION_FRAGMENT_TAG = "QUESTION_FRAGMENT_TAG"

        fun newInstance(question: Question, position : Int) = QuestionFragment().apply {
            arguments = bundleOf(
                ParamsKey.QUESTION_KEY to question,
                ParamsKey.POSITION_NUMBER_QUESTION_KEY to position,
            )
        }
    }
}
