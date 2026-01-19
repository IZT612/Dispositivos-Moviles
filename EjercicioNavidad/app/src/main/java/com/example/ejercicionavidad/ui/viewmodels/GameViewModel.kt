package com.example.ejercicionavidad.ui.viewmodels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.ejercicionavidad.data.models.Move
import com.example.ejercicionavidad.data.models.RoundResult

class GameViewModel : ViewModel() {

    var playerName by mutableStateOf("")
        private set

    var resultText by mutableStateOf("Elige una opción")
        private set

    var gameFinished by mutableStateOf(false)
        private set

    private val totalRounds = 3
    private var roundsPlayed = 0
    private var playerWins = 0
    private var iaWins = 0

    fun updatePlayerName(name: String) {
        playerName = name
        resetGame()
    }

    fun playRound(playerMove: Move) {
        val finalPlayerMove =
            if (playerMove == Move.RANDOM) randomMove() else playerMove

        val iaMove = randomMove()
        val result = calculateResult(finalPlayerMove, iaMove)

        roundsPlayed++

        when (result) {
            RoundResult.WIN -> playerWins++
            RoundResult.LOSE -> iaWins++
            else -> {}
        }

        resultText = """
            Tú: $finalPlayerMove
            IA: $iaMove
            Resultado: $result
        """.trimIndent()

        if (roundsPlayed == totalRounds) {
            gameFinished = true
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