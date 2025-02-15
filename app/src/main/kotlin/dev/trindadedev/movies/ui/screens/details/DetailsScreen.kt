package dev.trindadedev.movies.ui.screens.details

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.input.nestedscroll.*

import dev.trindadedev.movies.Strings
import dev.trindadedev.movies.mv.models.Movie
import dev.trindadedev.movies.ui.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    movie: Movie
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val scrollState = rememberScrollState()
    
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(
                title = {
                    Text(stringResource(id = Strings.label_details))
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
            
        }
    }
}