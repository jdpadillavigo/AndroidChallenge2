package com.example.androidchallenge2.song.domain

import android.media.Image

data class Song(
    val title: String,
    val author: String,
    val lyrics: List<String>,
    val imageSong: Int
)
