package com.example.ejemplomvvm.models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserVM : ViewModel() {
    private val _repo = UserRepository
    private val _users = mutableStateOf<List<User>>(emptyList())
    val users: State<List<User>> get() = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        _users.value = _repo.getUsers()
    }
    fun insertUser(user:User){
        _repo.insert(user)
        loadUsers()
    }
}





