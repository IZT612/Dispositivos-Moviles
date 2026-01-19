package com.example.ejercicionavidad.ui.viewmodels

import android.app.Application
import androidx.compose.runtime.*
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejercicionavidad.data.models.Move
import com.example.ejercicionavidad.data.models.RoundResult
import com.example.ejercicionavidad.data.room.database.AppDatabase
import com.example.ejercicionavidad.data.room.entities.GameEntity
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private val gameDao = AppDatabase.getDatabase(application).gameDao()

    var showEndDialog by mutableStateOf(false)
        private set

    var playerName by mutableStateOf("")
        private set

    var resultText by mutableStateOf("Elige una opción")
        private set

    var gameFinished by mutableStateOf(false)
        private set

    // 👉 NUEVO: jugadas actuales
    var playerMove by mutableStateOf<Move?>(null)
        private set

    var iaMove by mutableStateOf<Move?>(null)
        private set

    private val totalRounds = 3
    private var roundsPlayed = 0
    private var playerWins = 0
    private var iaWins = 0

    fun updatePlayerName(name: String) {
        playerName = name
        resetGame()
    }

    fun playRound(move: Move) {
        val finalPlayerMove =
            if (move == Move.RANDOM) randomMove() else move

        val finalIaMove = randomMove()
        val result = calculateResult(finalPlayerMove, finalIaMove)

        playerMove = finalPlayerMove
        iaMove = finalIaMove

        roundsPlayed++

        when (result) {
            RoundResult.WIN -> playerWins++
            RoundResult.LOSE -> iaWins++
            else -> {}
        }

        resultText = when (result) {
            RoundResult.WIN -> "¡Has ganado la ronda!"
            RoundResult.LOSE -> "Has perdido la ronda"
            RoundResult.DRAW -> "Empate"
        }

        if (roundsPlayed == totalRounds) {
            gameFinished = true
            showEndDialog = true
            saveGame()
        }
    }

    private fun saveGame() {
        val winner = getWinner()

        viewModelScope.launch {
            gameDao.insertGame(
                GameEntity(
                    playerName = playerName,
                    playerWins = playerWins,
                    iaWins = iaWins,
                    winner = winner
                )
            )
        }
    }

    fun getWinner(): String =
        when {
            playerWins > iaWins -> playerName
            iaWins > playerWins -> "IA"
            else -> "Empate"
        }

    fun resetGame() {
        roundsPlayed = 0
        playerWins = 0
        iaWins = 0
        gameFinished = false
        showEndDialog = false
        playerMove = null
        iaMove = null
        resultText = "Elige una opción"
    }

    private fun randomMove(): Move =
        listOf(Move.ROCK, Move.PAPER, Move.SCISSORS).random()

    private fun calculateResult(player: Move, ia: Move): RoundResult =
        when {
            player == ia -> RoundResult.DRAW
            player == Move.ROCK && ia == Move.SCISSORS -> RoundResult.WIN
            player == Move.PAPER && ia == Move.ROCK -> RoundResult.WIN
            player == Move.SCISSORS && ia == Move.PAPER -> RoundResult.WIN
            else -> RoundResult.LOSE
        }
}
