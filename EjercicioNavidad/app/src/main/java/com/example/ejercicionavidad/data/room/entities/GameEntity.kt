package com.example.ejercicionavidad.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val playerName: String,
    val playerWins: Int,
    val iaWins: Int,
    val winner: String,
    val timestamp: Long = System.currentTimeMillis()
)
