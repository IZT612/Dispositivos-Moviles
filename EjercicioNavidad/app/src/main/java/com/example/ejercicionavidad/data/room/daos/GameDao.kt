package com.example.ejercicionavidad.data.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ejercicionavidad.data.room.entities.GameEntity

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: GameEntity)

    @Query("SELECT * FROM games ORDER BY timestamp DESC")
    suspend fun getAllGames(): List<GameEntity>

    @Query("DELETE FROM games")
    suspend fun clearGames()
}
