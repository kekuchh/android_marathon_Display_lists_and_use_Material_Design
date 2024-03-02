package com.example.a30dayscats.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CatDescription(
    @StringRes val nameRes: Int,
    @StringRes val instructionRes: Int,
    @DrawableRes val imageRes: Int,
)