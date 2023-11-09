package com.itis.homework.fragments.holder

import androidx.recyclerview.widget.RecyclerView
import com.itis.homework.databinding.QuestionItemBinding
import com.itis.homework.model.Answer

class QuestionHolder(
    private val viewBinding: QuestionItemBinding,
    private val onItemChecked: ((Int) -> Unit)? = null,
    private val onRootClicked: ((Int) -> Unit)? = null,
) : RecyclerView.ViewHolder(viewBinding.root) {

    init {
        viewBinding.answerOption.setOnClickListener {
            onItemChecked?.invoke(adapterPosition)
        }

        viewBinding.root.setOnClickListener {
            onRootClicked?.invoke(adapterPosition)
        }
    }

    fun bindItem(answer: Answer) {
        with(viewBinding) {
            answerOption.text = answer.answer
            answerOption.isChecked = answer.chosen
            answerOption.isEnabled = !answer.chosen
        }
    }
}