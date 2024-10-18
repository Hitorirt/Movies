package dev.trindadedev.movies.mv.models

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val image: String = "",
    val categoryName: String = "",
    val url: String = ""
)