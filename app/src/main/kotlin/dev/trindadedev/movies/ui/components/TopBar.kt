package dev.trindadedev.movies.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: @Composable.() -> Unit
    scrollBehavior: TopAppBarScrollBehavior,
) {
    TopAppBar(
        title = title,
        scrollBehavior = scrollBehavior,
    )
}
