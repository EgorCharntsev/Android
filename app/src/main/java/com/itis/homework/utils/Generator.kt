package com.itis.homework.utils

import android.content.Context
import com.itis.homework.R
import com.itis.homework.model.Answer
import com.itis.homework.model.Question

object Generator {
    fun generateQuestions(count : Int, context : Context) : MutableList<Question> {
        val arrayOfQuestion = context.resources.getStringArray(R.array.questions)
        val arrayOfStringAnswers = context.resources.getStringArray(R.array.answers)
        val arrayOfAnswers = mutableListOf<Answer>()
        val arrayOfGeneratedQuestions = mutableListOf<Question>()

        for (i in arrayOfStringAnswers.indices) {
            arrayOfAnswers.add(i,Answer(arrayOfStringAnswers[i]))
        }

        for (i in 1..count ) {
            arrayOfGeneratedQuestions.add(Question(arrayOfQuestion[i - 1], arrayOfAnswers))
        }

        return arrayOfGeneratedQuestions
    }
}