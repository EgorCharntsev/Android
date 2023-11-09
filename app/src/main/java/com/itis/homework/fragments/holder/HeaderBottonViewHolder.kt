package com.itis.homework.fragments.holder

import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.itis.homework.adapter.SongAdapter
import com.itis.homework.databinding.ItemHeaderBottonBinding
import com.itis.homework.fragments.BottomSheetFragment

class HeaderBottonViewHolder (
    private val viewBinding: ItemHeaderBottonBinding,
    private val fragmentManager: FragmentManager,
    private val adapter: SongAdapter
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindItem() {
        viewBinding.btnItemHeader.setOnClickListener {
            val bottomSheet = BottomSheetFragment(adapter)
            bottomSheet.show(fragmentManager, BottomSheetFragment.BOTTOM_SHEET_FRAGMENT_TAG)
        }
    }
}