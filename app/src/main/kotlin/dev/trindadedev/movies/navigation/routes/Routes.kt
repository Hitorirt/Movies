package dev.trindadedev.movies.navigation.routes

import dev.trindadedev.movies.mv.models.Movie

import kotlinx.serialization.Serializable

@Serializable object HomeRoute

@Serializable data class DetailsRoute(val movie: Movie)