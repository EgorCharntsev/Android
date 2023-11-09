package com.itis.homework.fragments.holder

import androidx.recyclerview.widget.RecyclerView
import com.itis.homework.databinding.ItemDividerBinding

class DividerViewHolder(
    private val viewBinding: ItemDividerBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindItem(date: String) {
        viewBinding.tvDate.text = date
    }
}