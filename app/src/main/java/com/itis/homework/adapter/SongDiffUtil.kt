package com.itis.homework.adapter

import androidx.recyclerview.widget.DiffUtil
import com.itis.homework.model.SongModel

class SongDiffUtil(
    private val  oldSongList: List<SongModel>,
    private val  newSongList: List<SongModel>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int =  oldSongList.size

    override fun getNewListSize(): Int =  newSongList.size

    override fun areItemsTheSame( oldSongPosition: Int,  newSongPosition: Int): Boolean {
        val oldSong =  oldSongList[oldSongPosition]
        val newSong =  newSongList[newSongPosition]
        
        return  oldSong.id ==  newSong.id
    }

    override fun areContentsTheSame( oldSongPosition: Int,  newSongPosition: Int): Boolean {
        val oldSong =  oldSongList[oldSongPosition]
        val newSong =  newSongList[newSongPosition]
        
        return ( oldSong.name ==  newSong.name) &&
                    (oldSong.album ==  newSong.album) &&
                    (oldSong.author ==  newSong.author)
    }

    override fun getChangePayload( oldSongPosition: Int,  newSongPosition: Int): Any? {
        val oldSong =  oldSongList[oldSongPosition]
        val newSong =  newSongList[newSongPosition]
        
        if ( oldSong.isFavourites !=  newSong.isFavourites) {
                return  newSong.isFavourites
        }

        return super.getChangePayload(oldSongPosition, newSongPosition)
    }
}