package com.example.androidchallenge2.song.domain

data class Song(
    val title: String,
    val author: String,
    val lyrics: List<String>,
    val imageSong: Int
)
