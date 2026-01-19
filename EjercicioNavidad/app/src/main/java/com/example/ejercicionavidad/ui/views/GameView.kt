package com.example.ejercicionavidad.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicionavidad.data.models.Move
import com.example.ejercicionavidad.ui.viewmodels.GameViewModel

@Composable
fun GameView(
    viewModel: GameViewModel,
    onGoToMenu: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "IA",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.secondaryContainer,
                        RoundedCornerShape(16.dp)
                    )
                    .padding(20.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("IA", fontWeight = FontWeight.Bold)
                            Text(
                                moveToIcon(viewModel.iaMove),
                                fontSize = 40.sp
                            )
                        }

                        Text("VS", fontWeight = FontWeight.Bold)

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Jugador", fontWeight = FontWeight.Bold)
                            Text(
                                moveToIcon(viewModel.playerMove),
                                fontSize = 40.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        viewModel.resultText,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (viewModel.playerName.isNotEmpty())
                    viewModel.playerName else "Jugador",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                GameButton("🪨") { viewModel.playRound(Move.ROCK) }
                GameButton("📄") { viewModel.playRound(Move.PAPER) }
                GameButton("✂️") { viewModel.playRound(Move.SCISSORS) }
                GameButton("❓") { viewModel.playRound(Move.RANDOM) }
            }
        }
    }

    if (viewModel.showEndDialog) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text("Partida terminada") },
            text = { Text("Ganador: ${viewModel.getWinner()}") },
            confirmButton = {
                Button(onClick = { viewModel.resetGame() }) {
                    Text("Volver a jugar")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = {
                    viewModel.resetGame()
                    onGoToMenu()
                }) {
                    Text("Menú")
                }
            }
        )
    }
}

@Composable
fun GameButton(
    icon: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(70.dp),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Text(
            text = icon,
            fontSize = 28.sp
        )
    }
}


fun moveToIcon(move: Move?): String =
    when (move) {
        Move.ROCK -> "🪨"
        Move.PAPER -> "📄"
        Move.SCISSORS -> "✂️"
        Move.RANDOM -> "❓"
        null -> "❔"
    }
