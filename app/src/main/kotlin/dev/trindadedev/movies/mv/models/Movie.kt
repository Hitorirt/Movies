package dev.trindadedev.movies.mv.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Movie(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val image: String = "",
    val categoryName: String = "",
    val url: String = ""
): Parcelable