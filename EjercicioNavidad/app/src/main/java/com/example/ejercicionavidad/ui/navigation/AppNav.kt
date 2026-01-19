package com.example.ejercicionavidad.ui.navigation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.ejercicionavidad.ui.viewmodels.GameViewModel
import com.example.ejercicionavidad.ui.viewmodels.HistoryViewModel
import com.example.ejercicionavidad.ui.views.*

@Composable
fun AppNav(viewModel: GameViewModel) {

    val navController = rememberNavController()

    NavHost(navController, startDestination = "welcome") {

        composable("welcome") {
            WelcomeView(
                onStart = {
                    viewModel.updatePlayerName(it)
                    navController.navigate("game")
                },
                onHistoryClick = {
                    navController.navigate("history")
                }
            )
        }

        composable("game") {
            GameView(
                viewModel = viewModel,
                onGoToMenu = {
                    navController.popBackStack("welcome", inclusive = false)
                }
            )
        }


        composable("history") {

            val context = LocalContext.current
            val historyViewModel: HistoryViewModel =
                viewModel(
                    factory = ViewModelProvider.AndroidViewModelFactory(
                        context.applicationContext as Application
                    )
                )

            HistoryView(
                viewModel = historyViewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
