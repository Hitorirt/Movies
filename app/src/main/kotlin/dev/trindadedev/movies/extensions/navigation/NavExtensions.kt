package dev.trindadedev.movies.extensions.navigation

import androidx.navigation.NavHostController

fun <T : Any> NavHostController.navigateSingleTop(route: T) {
    navigate(route) {
        restoreState = true
        launchSingleTop = true
    }
}
