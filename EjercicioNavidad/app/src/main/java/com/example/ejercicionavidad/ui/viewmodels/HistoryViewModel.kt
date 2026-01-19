package com.example.ejercicionavidad.ui.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejercicionavidad.data.room.database.AppDatabase
import com.example.ejercicionavidad.data.room.entities.GameEntity
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    private val gameDao = AppDatabase.getDatabase(application).gameDao()

    var games by mutableStateOf<List<GameEntity>>(emptyList())
        private set

    fun loadGames() {
        viewModelScope.launch {
            games = gameDao.getAllGames()
        }
    }

    fun clearHistory() {
        viewModelScope.launch {
            gameDao.clearGames()
            games = emptyList()
        }
    }
}
