package com.example.art

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art.ui.theme.ArtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtTheme {
                ArtAppLayout()
            }
        }
    }
}

@Composable
fun ArtAppLayout() {
    var currentStep by remember { mutableIntStateOf(1) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        color = Color(0xFFC9AACE)
    ) {
        when (currentStep) {
            1 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtBack(
                        resourceDrawable = R.drawable.painting_1,
                        contentDescription = R.string.art_content_description
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ArtDescription(
                        title = R.string.painting_title_1,
                        artist = R.string.Kandinskii,
                        year = R.string.painting_year_1
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ButtonPanel(
                        previousBtn = { currentStep = 5 },
                        nextBtn = { currentStep = 2 }
                    )
                }
            }

            2 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtBack(
                        resourceDrawable = R.drawable.painting_2,
                        contentDescription = R.string.art_content_description
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ArtDescription(
                        title = R.string.painting_title_2,
                        artist = R.string.Kandinskii,
                        year = R.string.painting_year_2
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ButtonPanel(
                        previousBtn = { currentStep = 1 },
                        nextBtn = { currentStep = 3 })
                }
            }

            3 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtBack(
                        resourceDrawable = R.drawable.painting_3,
                        contentDescription = R.string.art_content_description
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ArtDescription(
                        title = R.string.painting_title_3,
                        artist = R.string.Kandinskii,
                        year = R.string.painting_year_3
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ButtonPanel(
                        previousBtn = { currentStep = 2 },
                        nextBtn = { currentStep = 4 })
                }
            }

            4 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtBack(
                        resourceDrawable = R.drawable.painting_4,
                        contentDescription = R.string.art_content_description
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ArtDescription(
                        title = R.string.painting_title_4,
                        artist = R.string.Malevich,
                        year = R.string.painting_year_4
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ButtonPanel(
                        previousBtn = { currentStep = 3 },
                        nextBtn = { currentStep = 5 })
                }
            }

            5 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtBack(
                        resourceDrawable = R.drawable.painting_5,
                        contentDescription = R.string.art_content_description
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ArtDescription(
                        title = R.string.painting_title_5,
                        artist = R.string.Malevich,
                        year = R.string.painting_year_5
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ButtonPanel(
                        previousBtn = { currentStep = 4 },
                        nextBtn = { currentStep = 1 })
                }
            }
        }
    }
}


@Composable
fun ArtBack(
    resourceDrawable: Int,
    contentDescription: Int
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .border(
                BorderStroke(5.dp, Color(0xFF5E4038))
            ),
        color = Color(0xFFCCCCCC),
        shadowElevation = 25.dp
    ) {
        Image(
            painter = painterResource(
                id = resourceDrawable
            ),
            contentDescription = stringResource(id = contentDescription),
            modifier = Modifier
                .padding(25.dp)
        )
    }
}

@Composable
fun ArtDescription(
    title: Int,
    artist: Int,
    year: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        Surface(
            shadowElevation = 25.dp,
            color = Color(0xFFCAAE7B),
            modifier = Modifier
                .border(
                    BorderStroke(3.dp, Color(0xFF000000))
                ),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(280.dp)
                    .padding(10.dp)
            ) {
                Text(
                    text = stringResource(title),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(artist),
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = stringResource(year),
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun ButtonPanel(
    previousBtn: () -> Unit,
    nextBtn: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(100.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = previousBtn,
            colors = ButtonDefaults.buttonColors(Color(0xFFF46C36)),
        ) {
            Text(
                text = stringResource(id = R.string.previous_button),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(100.dp),
                fontSize = 20.sp,
                color = Color(0xFFFFFFFF)
            )
        }
        Button(
            onClick = nextBtn,
            colors = ButtonDefaults.buttonColors(Color(0xFF009688))
        ) {
            Text(
                text = stringResource(id = R.string.next_button),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(100.dp),
                fontSize = 20.sp,
                color = Color(0xFFFFFFFF)
            )
        }
    }
}

@Preview()
@Composable
fun ArtAppPreview() {
    ArtTheme {
        ArtAppLayout()
    }
}
