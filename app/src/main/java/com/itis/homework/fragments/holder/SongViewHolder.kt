package com.itis.homework.fragments.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.itis.homework.R
import com.itis.homework.databinding.ItemSongBinding
import com.itis.homework.model.SongModel

class SongViewHolder(
    val viewBinding: ItemSongBinding,
    private val onSongClicked: ((View, SongModel) -> Unit),
    private val onLikeClicked: ((Int,  SongModel) -> Unit),
    ) : RecyclerView.ViewHolder(viewBinding.root) {

        private var item:  SongModel? = null

        init {
            viewBinding.root.setOnClickListener {
                this.item?.let{ onSongClicked(viewBinding.ivItemSong, it) }
            }
            viewBinding.imBtnFavourite.setOnClickListener {
                this.item?.let {
                    val data = it.copy(isFavourites = !it.isFavourites)
                    onLikeClicked(adapterPosition, data)
                }
            }
        }

        fun bindItem(item:  SongModel) {
            this.item = item
            with(viewBinding) {
                tvItemTitle.text = item.name
                item.icon.let { res ->
                    if (res != null) {
                        ivItemSong.setImageResource(res)
                    }
                }
                changeLikeBtnStatus(isChecked = item.isFavourites)
            }
        }

        fun changeLikeBtnStatus(isChecked: Boolean) {
            val likeDrawable = if (isChecked) R.drawable.baseline_star_24 else R.drawable.baseline_star_border_24
            viewBinding.imBtnFavourite.setImageResource(likeDrawable)
        }

}