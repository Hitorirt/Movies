package dev.trindadedev.movies.ui.activities

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier

import dev.trindadedev.movies.navigation.MainNavHost
import dev.trindadedev.movies.ui.theme.MoviesAppTheme
import dev.trindadedev.movies.platform.LocalMainNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                Surface(
                     modifier = Modifier.fillMaxSize(),
                     color = MaterialTheme.colorScheme.background
                ) {
                    ProvideMainCompositionLocals { 
                        MainNavHost() 
                    }
                }
            }
        }
    }
    
    @Composable
    private fun ProvideMainCompositionLocals(content: @Composable () -> Unit) {
        val navController = rememberNavController()

        CompositionLocalProvider(
            LocalMainNavController provides navController, 
            content = content
        )
    }
}