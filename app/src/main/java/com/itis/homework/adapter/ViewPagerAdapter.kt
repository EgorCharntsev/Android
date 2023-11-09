package com.itis.homework.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.itis.homework.fragments.QuestionFragment
import com.itis.homework.model.Question

class ViewPagerAdapter(
    manager: FragmentManager,
    lifecycle: Lifecycle,
    private val questions: List<Question>,
) : FragmentStateAdapter(manager, lifecycle) {

    override fun getItemCount(): Int = questions.size

    override fun createFragment(position: Int): Fragment {
        return QuestionFragment.newInstance(questions[position], position)
    }
}
}