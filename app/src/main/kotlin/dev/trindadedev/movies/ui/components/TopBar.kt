package dev.trindadedev.movies.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.RowScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: @Composable () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = title,
        navigationIcon = {
            navigationIcon?.let {
                it()
            }
        },
        actions = actions,
        scrollBehavior = scrollBehavior,
    )
}