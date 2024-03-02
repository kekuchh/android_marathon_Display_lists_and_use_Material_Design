package com.example.superheroes.model

import com.example.superheroes.R


object SuperHeroesRepo {
    val heroes = listOf(
        SuperHero(
            nameResource = R.string.hero1,
            descriptionResource = R.string.description1,
            imageResource = R.drawable.android_superhero1
        ),
        SuperHero(
            nameResource = R.string.hero2,
            descriptionResource = R.string.description2,
            imageResource = R.drawable.android_superhero2
        ),
        SuperHero(
            nameResource = R.string.hero3,
            descriptionResource = R.string.description3,
            imageResource = R.drawable.android_superhero3
        ),
        SuperHero(
            nameResource = R.string.hero4,
            descriptionResource = R.string.description4,
            imageResource = R.drawable.android_superhero4
        ),
        SuperHero(
            nameResource = R.string.hero5,
            descriptionResource = R.string.description5,
            imageResource = R.drawable.android_superhero5
        ),
        SuperHero(
            nameResource = R.string.hero6,
            descriptionResource = R.string.description6,
            imageResource = R.drawable.android_superhero6
        )
    )
}