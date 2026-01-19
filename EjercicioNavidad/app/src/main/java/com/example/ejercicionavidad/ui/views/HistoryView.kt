package com.example.ejercicionavidad.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Delete

import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import com.example.ejercicionavidad.data.models.Move
import com.example.ejercicionavidad.data.room.entities.GameEntity
import com.example.ejercicionavidad.ui.viewmodels.GameViewModel
import com.example.ejercicionavidad.ui.viewmodels.HistoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryView(
    viewModel: HistoryViewModel,
    onBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.loadGames()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Historial de partidas") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")

                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            if (viewModel.games.isEmpty()) {
                Text(
                    "No hay partidas guardadas",
                    modifier = Modifier.padding(16.dp)
                )
            } else {
                LazyColumn {
                    items(viewModel.games) { game ->
                        HistoryItem(game)
                    }
                }

            }

            FloatingActionButton(
                onClick = { viewModel.clearHistory() }
            ) {
                Icon(Icons.Default.Delete, contentDescription = "Borrar historial")
            }


        }
    }
}

@Composable
fun HistoryItem(game: GameEntity) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Jugador: ${game.playerName}")
            Text("Jugador: ${game.playerWins} - IA: ${game.iaWins}")
            Text("Ganador: ${game.winner}")
        }
    }
}

