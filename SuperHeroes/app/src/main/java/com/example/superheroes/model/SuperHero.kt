package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SuperHero(
    @StringRes val nameResource: Int,
    @DrawableRes val imageResource: Int,
    @StringRes val descriptionResource: Int
)
