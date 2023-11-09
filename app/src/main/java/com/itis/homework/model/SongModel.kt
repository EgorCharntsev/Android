package com.itis.homework.model

import androidx.annotation.DrawableRes

data class SongModel(
    val songId: Int,
    val songName: String,
    val album: String,
    val author: String,
    val text: String = "This song doesn't have text =(",
    @DrawableRes val songIcon: Int? = null,
    val isFavourites: Boolean = false
)