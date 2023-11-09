package com.itis.homework.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.itis.homework.R
import com.itis.homework.databinding.ItemDividerBinding
import com.itis.homework.databinding.ItemHeaderBottonBinding
import com.itis.homework.databinding.ItemSongBinding
import com.itis.homework.fragments.holder.DividerViewHolder
import com.itis.homework.fragments.holder.HeaderBottonViewHolder
import com.itis.homework.fragments.holder.SongViewHolder
import com.itis.homework.model.SongModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SongAdapter(
    private val fragmentManager: FragmentManager,
    private val onSongClicked: ((View, SongModel) -> Unit),
    private val onLikeClicked: ((Int, SongModel) -> Unit),
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        private var songsList = mutableListOf<SongModel>()
        private var context: Context? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            context = parent.context
            when (viewType) {
                SONG_TYPE -> return SongViewHolder(
                    viewBinding = ItemSongBinding.inflate(
                        LayoutInflater.from(context),
                        parent,
                        false
                    ),
                    onSongClicked = onSongClicked,
                    onLikeClicked = onLikeClicked,
                )

                BUTTON_TYPE -> return HeaderBottonViewHolder(
                    viewBinding = ItemHeaderBottonBinding.inflate(
                        LayoutInflater.from(context),
                        parent,
                        false
                    ),
                    fragmentManager = fragmentManager,
                    this
                )

                DATE_TYPE -> return DividerViewHolder(
                    viewBinding = ItemDividerBinding.inflate(
                        LayoutInflater.from(context),
                        parent,
                        false
                    )
                )

                else -> throw RuntimeException(parent.context.getString(R.string.there_is_no_such_type))
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is SongViewHolder -> holder.bindItem(songsList[position] as SongModel)
                is HeaderBottonViewHolder -> holder.bindItem()
                is DividerViewHolder -> holder.bindItem(
                    SimpleDateFormat(
                        "yyyy-MM-dd",
                        Locale.getDefault()
                    ).format(Date())
                )
            }
        }

        override fun onBindViewHolder(
            holder: RecyclerView.ViewHolder,
            position: Int,
            payloads: MutableList<Any>
        ) {
            if (payloads.isNotEmpty()) {
                (payloads.first() as? Boolean)?.let {
                    (holder as? SongViewHolder)?.changeLikeBtnStatus(it)
                }
            }
            super.onBindViewHolder(holder, position, payloads)
        }

        override fun getItemCount(): Int = songsList.size

//        override fun getItemViewType(position: Int): Int {
//            return when (songsList[position]) {
//                is SongModel -> PLANET_TYPE
//                is ButtonModel -> BUTTON_TYPE
//                is DateModel -> DATE_TYPE
//                else -> throw RuntimeException(context?.getString(R.string.there_is_no_such_type))
//            }
//        }

        fun setItems(list: List<SongModel>) {
            val diff = SongDiffUtil(oldSongList = songsList, newSongList = list)
            val diffResult = DiffUtil.calculateDiff(diff)
            songsList.clear()
            songsList.addAll(list)
            diffResult.dispatchUpdatesTo(this)
        }

        fun updateItem(position: Int, item: SongModel) {
            this.songsList[position] = item
            notifyItemChanged(position, item.isFavourites)
        }

        fun removeAt(position: Int) {
            songsList.removeAt(position)
            notifyItemRemoved(position)
        }

        companion object {
            private const val SONG_TYPE = 0
            private const val BUTTON_TYPE = 1
            private const val DATE_TYPE = 2
        }

}