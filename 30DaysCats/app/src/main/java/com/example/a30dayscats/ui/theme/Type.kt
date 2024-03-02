package com.example.a30dayscats.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a30dayscats.R


val alegreyaFontFamily = FontFamily(
    Font(R.font.alegreya_sans_regular, FontWeight.Normal),
    Font(R.font.alegreya_sans_bold, FontWeight.Bold)
)



// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = alegreyaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    displayMedium = TextStyle(
        fontFamily = alegreyaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp
    ),
    labelSmall = TextStyle(
        fontFamily = alegreyaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 8.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = alegreyaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )



)