package com.example.ejercicionavidad.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp

@Composable
fun ResultView(
    winner: String,
    onReplay: () -> Unit,
    onExit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Ganador: $winner", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        Button(onClick = onReplay) {
            Text("Volver a jugar")
        }

        Spacer(Modifier.height(8.dp))

        Button(onClick = onExit) {
            Text("Cambiar jugador")
        }
    }
}