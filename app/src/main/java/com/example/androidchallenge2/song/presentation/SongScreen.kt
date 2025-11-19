package com.example.androidchallenge2.song.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidchallenge2.R
import com.example.androidchallenge2.song.domain.Song
import com.example.androidchallenge2.ui.theme.SongColor

@Composable
fun SongScreen(
    modifier: Modifier = Modifier,
    song: Song
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(SongColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Card(
                modifier = Modifier
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
                    Column(
                        modifier = Modifier
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
//                                .border(
//                                    width = 40.dp,
//                                    brush = Brush.radialGradient(
//                                        colors = listOf(
//                                            Color.White,
//                                            Color.Transparent
//                                        ),
////                                        radius = 190f,
////                                        center = Offset(0.5f, 0.5f)
//                                    ),
//                                    shape = CircleShape
//                                )
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
                    Column(
                        modifier = Modifier.fillMaxWidth(0.85f),
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
                    Column(
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
                        IconButton(onClick = {}) {
                            Image(
                                painter = painterResource(R.drawable.random),
                                contentDescription = ""
                            )
                        }
                        IconButton(onClick = {}) {
                            Image(
                                painter = painterResource(R.drawable.previous),
                                contentDescription = ""
                            )
                        }
                        IconButton(onClick = {}) {
                            Image(
                                painter = painterResource(R.drawable.pause),
                                contentDescription = ""
                            )
                        }
                        IconButton(onClick = {}) {
                            Image(
                                painter = painterResource(R.drawable.next),
                                contentDescription = ""
                            )
                        }
                        IconButton(onClick = {}) {
                            Image(
                                painter = painterResource(R.drawable.repeat),
                                contentDescription = ""
                            )
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