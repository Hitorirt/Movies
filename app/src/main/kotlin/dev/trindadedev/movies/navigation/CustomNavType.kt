package dev.trindadedev.movies.navigation

import android.net.Uri
import android.os.Bundle

import androidx.navigation.NavType

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

import dev.trindadedev.movies.mv.models.Movie

object CustomNavType {

    val MovieType = object : NavType<Movie>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): Movie? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): Movie {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: Movie): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: Movie) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}