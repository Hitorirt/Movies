package dev.trindadedev.movies.navigation

import android.util.Log

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

import dev.trindadedev.movies.mv.models.Movie
import dev.trindadedev.movies.platform.LocalMainNavController
import dev.trindadedev.movies.navigation.routes.*
import dev.trindadedev.movies.extensions.navigation.navigateSingleTop
import dev.trindadedev.movies.ui.screens.home.HomeScreen
import dev.trindadedev.movies.ui.screens.details.DetailsScreen
import dev.trindadedev.movies.ui.animations.navigation.NavigationAnimationTransitions

import kotlin.reflect.typeOf

@Composable
fun MainNavHost() {
    val navController = LocalMainNavController.current

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        enterTransition = {
            NavigationAnimationTransitions.enterTransition 
        },
        exitTransition = {
            NavigationAnimationTransitions.exitTransition
        },
        popEnterTransition = {
            NavigationAnimationTransitions.popEnterTransition
        },
        popExitTransition = {
            NavigationAnimationTransitions.popExitTransition
        }
    ) {
        composable<HomeRoute> {
            HomeScreen(
                onMovieClicked = { movie ->
                    navController.navigateSingleTop(DetailsRoute(movie))
                }
            )
        }
        
        composable<DetailsRoute>(
            typeMap = mapOf(
                typeOf<Movie>() to CustomNavType.MovieType
            )
        ) {
            val args = it.toRoute<DetailsRoute>()
            DetailsScreen(
                movie = args.movie
            )
        }
    }
}
