package com.example.ejercicionavidad.ui.views


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import com.example.ejercicionavidad.data.models.Move
import com.example.ejercicionavidad.ui.viewmodels.GameViewModel

@Composable
fun GameView(
    viewModel: GameViewModel,
    onGameFinished: () -> Unit
) {
    if (viewModel.gameFinished) {
        onGameFinished()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // IA
        Text(
            "IA",
            modifier = Modifier.fillMaxWidth(),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall
        )

        // Resultado
        Text(
            viewModel.resultText,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        // Jugador
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(viewModel.playerName)

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                GameButton("🪨") { viewModel.playRound(Move.ROCK) }
                GameButton("📄") { viewModel.playRound(Move.PAPER) }
                GameButton("✂️") { viewModel.playRound(Move.SCISSORS) }
                GameButton("❓") { viewModel.playRound(Move.RANDOM) }
            }
        }
    }
}

@Composable
fun GameButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text, fontSize = MaterialTheme.typography.headlineMedium.fontSize)
    }
}