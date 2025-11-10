package com.example.ejemplomvvm.models

data class User(val id: Int, val name: String)

object UserRepository {
    val users = mutableListOf<User>(User(1, "Ana"), User(2, "Luis"))
    fun getUsers(): List<User> {
        return users.toList()
    }
    fun insert(user:User) { users.add(user) }
}


