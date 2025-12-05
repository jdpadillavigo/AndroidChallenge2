package com.example.androidchallenge2.song.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidchallenge2.R
import com.example.androidchallenge2.song.domain.Song
import com.example.androidchallenge2.ui.theme.SongColor
import com.example.androidchallenge2.ui.util.DeviceConfiguration

@Composable
fun SongScreen(
    modifier: Modifier = Modifier,
    song: Song
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.statusBars
    ) { innerPadding ->
        val rootModifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(SongColor)
            .consumeWindowInsets(WindowInsets.navigationBars)

        val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
        val deviceConfiguration = DeviceConfiguration.fromWindowSizeClass(windowSizeClass)
        when(deviceConfiguration) {
            DeviceConfiguration.MOBILE_PORTRAIT -> {
                LazyColumn(
                    modifier = rootModifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Card(
                            modifier = modifier
                                .padding(20.dp)
                                .clip(RoundedCornerShape(25.dp)),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Black.copy(alpha = 0.7f),
                                contentColor = Color.White
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(30.dp, 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                SongImage(
                                    song = song,
                                    imageMaxSize = 0.8f
                                )
                                SongLyrics(song = song)
                                SongOptions()
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowDown,
                                        contentDescription = ""
                                    )
                                }
                            }
                        }
                    }
                }
            }
            DeviceConfiguration.MOBILE_LANDSCAPE,
            DeviceConfiguration.TABLET_LANDSCAPE -> {
                LazyColumn(
                    modifier = rootModifier.windowInsetsPadding(WindowInsets.displayCutout),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    item {
                        Card(
                            modifier = modifier
                                .padding(horizontal = 20.dp, vertical = 30.dp)
                                .clip(RoundedCornerShape(25.dp)),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Black.copy(alpha = 0.7f),
                                contentColor = Color.White
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(30.dp, 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                                ) {
                                    SongImage(
                                        modifier = Modifier.fillMaxWidth(0.5f),
                                        song = song,
                                        imageMaxSize = 0.5f
                                    )
                                    Column(
                                        verticalArrangement = Arrangement.SpaceBetween,
                                    ) {
                                        SongLyrics(
                                            modifier = Modifier
                                                .padding(vertical = 40.dp)
                                                .fillMaxWidth(),
                                            song = song
                                        )
                                        SongOptions()
                                    }
                                }
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowDown,
                                        contentDescription = ""
                                    )
                                }
                            }
                        }
                    }
                }
            }
            DeviceConfiguration.TABLET_PORTRAIT,
            DeviceConfiguration.DESKTOP -> {
                LazyColumn(
                    modifier = rootModifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Card(
                            modifier = modifier
                                .padding(20.dp)
                                .clip(RoundedCornerShape(25.dp)),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Black.copy(alpha = 0.7f),
                                contentColor = Color.White
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(30.dp, 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                SongImage(
                                    song = song,
                                    imageMaxSize = 0.35f
                                )
                                SongLyrics(song = song)
                                SongOptions()
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowDown,
                                        contentDescription = ""
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SongImage(
    modifier: Modifier = Modifier,
    song: Song,
    imageMaxSize: Float,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Black.copy(alpha = 0.2f))
            .padding(20.dp, 0.dp, 20.dp, 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "",
                )
            }
            Text(
                text = "PLAYING FROM PLAYLIST",
                fontSize = 11.sp,
                color = Color.White.copy(alpha = 0.4f)
            )
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = ""
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.soami),
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxSize(imageMaxSize)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = song.title,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = song.author,
            fontSize = 14.sp,
            color = Color.White.copy(alpha = 0.65f)
        )
    }
}

@Composable
private fun SongLyrics(
    modifier: Modifier = Modifier,
    song: Song
) {
    Column(
        modifier = modifier.fillMaxWidth(0.85f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = song.lyrics[0],
            color = Color.White.copy(alpha = 0.8f),
            textAlign = TextAlign.Center
        )
        Text(
            text = song.lyrics[1],
            color = Color.White.copy(alpha = 0.3f),
            textAlign = TextAlign.Center
        )
        Text(
            text = song.lyrics[2],
            color = Color.White.copy(alpha = 0.15f),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun SongOptions(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "1:32",
                fontSize = 11.sp
            )
            Text(
                text = "3:03",
                fontSize = 11.sp
            )
        }
        Image(
            painter = painterResource(R.drawable.linesong),
            contentDescription = "",
        )
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        optionsImgs.forEach { drawable ->
            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(drawable),
                    contentDescription = ""
                )
            }
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = {}) {
            Image(
                painter = painterResource(R.drawable.download),
                contentDescription = ""
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = ""
            )
        }
    }
}

private val optionsImgs = listOf(
    R.drawable.random,
    R.drawable.previous,
    R.drawable.pause,
    R.drawable.next,
    R.drawable.repeat
)