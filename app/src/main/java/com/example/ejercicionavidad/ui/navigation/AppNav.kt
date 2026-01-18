package com.example.ejercicionavidad.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.ejercicionavidad.ui.viewmodels.GameViewModel
import com.example.ejercicionavidad.ui.views.*

@Composable
fun AppNav(viewModel: GameViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "welcome") {

        composable("welcome") {
            WelcomeView { name ->
                viewModel.updatePlayerName(name)
                navController.navigate("game")
            }
        }

        composable("game") {
            GameView(viewModel) {
                navController.navigate("result")
            }
        }

        composable("result") {
            ResultView(
                winner = viewModel.getWinner(),
                onReplay = {
                    viewModel.resetGame()
                    navController.navigate("game")
                },
                onExit = {
                    navController.navigate("welcome") {
                        popUpTo("welcome") { inclusive = true }
                    }
                }
            )
        }
    }
}