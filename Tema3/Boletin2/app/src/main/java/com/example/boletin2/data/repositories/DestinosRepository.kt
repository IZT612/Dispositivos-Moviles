package com.example.boletin2.data.repositories

import com.example.boletin2.domain.entities.Destino

object DestinosRepository {

    private val _lista = mutableListOf(
        Destino(1, "Mi casa", "España"),
        Destino(2 ,"Torre Eiffel", "Francia"),
        Destino(3, "Bandera de USA", "La luna")
    )

    fun obtenerLista(): MutableList<Destino> {
        return _lista
    }

    fun obtenerPorId(id: Int): Destino {

        var devolver: Destino = Destino(0, "ERROR", "ERROR")

        _lista.forEach { destino ->
            if(id == destino.id) {

                devolver = destino

            }
        }

        return devolver

    }
}
