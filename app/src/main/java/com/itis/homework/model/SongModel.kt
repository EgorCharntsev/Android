package com.itis.homework.model

import androidx.annotation.DrawableRes

data class SongModel(
    val id: Int,
    val name: String,
    val album: String,
    val author: String,
    val lyrics: LyricsModel,
    @DrawableRes val icon: Int? = null,
    val isFavourites: Boolean = false
)