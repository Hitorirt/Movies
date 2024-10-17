package dev.trindadedev.movies.ui.screens.home

import androidx.compose.material.icons.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.*

import dev.trindadedev.movies.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TopBar(scrollBehavior = scrollBehavior) 
        }
    ) { innerPadding ->
        
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = { Text(text = stringResource(id = Strings.app_name)) },
        scrollBehavior = scrollBehavior,
    )
}
