package com.example.ejemplomvvm.models

object UserRepository {

    val users = mutableListOf<User>(
        User(1, "Ana"),
        User(2, "Luis"),
        User(3, "Iván"),
        User(4, "Jose Enrique"),
        User(5, "Samuel")
    )
    fun getUsers(): List<User> {
        return users.toList()
    }
    fun insert(user: User) {
        users.add(user)
    }

    fun insert(name: String) {

        val id = users.maxOf { it.id } + 1

        val user = User(id, name)

        users.add(user)

    }

}