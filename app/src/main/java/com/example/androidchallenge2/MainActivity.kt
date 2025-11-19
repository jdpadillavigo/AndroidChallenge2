package com.example.androidchallenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidchallenge2.song.domain.Song
import com.example.androidchallenge2.song.presentation.SongScreen
import com.example.androidchallenge2.ui.theme.AndroidChallenge2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val songTest = Song(
            title = "So am I",
            author = "Ava Max",
            lyrics = mutableListOf("I can see ya, I know what you're feelin'",
                "So let me tell you 'bout my little secret",
                "I'm a little crazy underneath this"),
            imageSong = R.drawable.soami
        )

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidChallenge2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SongScreen(
                        modifier = Modifier.padding(innerPadding),
                        song = songTest
                    )
                }
            }
        }
    }
}
