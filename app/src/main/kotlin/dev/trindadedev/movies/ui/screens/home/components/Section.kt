package dev.trindadedev.movies.ui.screens.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.text.style.*

import coil3.compose.AsyncImage

import dev.trindadedev.movies.mv.models.Movie

@Composable
fun Section(
    label: String,
    movies: List<Movie>,
    onMovieClicked: (Movie) -> Unit
) {
    val scrollState = rememberScrollState()
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(8.dp)
        )
        Row(
            modifier = Modifier.horizontalScroll(scrollState)
        ) {
            MoviesList(
                movies = movies,
                onMovieClicked = { onMovieClicked(it) }
            )
        }
    }
}

@Composable
private fun MoviesList(
    movies: List<Movie>,
    onMovieClicked: (Movie) -> Unit
) {
    movies.forEach { movie ->
        Column(
            Modifier
                .width(140.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable { onMovieClicked(movie) }
        ) {
            AsyncImage(
                model = movie.image,
                contentDescription = "Movie Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = movie.name,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.padding(start = 2.dp, end = 2.dp)
            )
            Text(
                text = movie.description,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                modifier = Modifier.padding(start = 2.dp, end = 2.dp)
            )
        }
    }
}