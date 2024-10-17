package dev.trindadedev.movies.ui.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.input.nestedscroll.*

import dev.trindadedev.movies.Strings
import dev.trindadedev.movies.mv.getMovies
import dev.trindadedev.movies.mv.Type
import dev.trindadedev.movies.mv.models.Movie
import dev.trindadedev.movies.ui.screens.home.components.Section
import dev.trindadedev.movies.ui.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onMovieClicked: (Movie) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val scrollState = rememberScrollState()
    
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(
                title = {
                    Text(stringResource(id = Strings.app_name))
                },
                scrollBehavior = scrollBehavior
            ) 
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            Sections { onMovieClicked(it) }
        }
    }
}

@Composable
private fun Sections(
    onMovieClicked: (Movie) -> Unit
) {
    Section(
        label = Type.LATEST.toName,
        movies = getMovies(Type.LATEST),
        onMovieClicked = { onMovieClicked(it) }
    )
    
    Section(
        label = Type.OLD.toName, 
        movies = getMovies(Type.OLD),
        onMovieClicked = { onMovieClicked(it) }
    )
    
    Section(
        label = Type.CARTOON.toName,
        movies = getMovies(Type.CARTOON),
        onMovieClicked = { onMovieClicked(it) }
    )
}