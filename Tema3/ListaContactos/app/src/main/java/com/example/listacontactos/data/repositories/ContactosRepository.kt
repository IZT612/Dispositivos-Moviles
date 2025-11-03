package com.example.listacontactos.data.repositories

import com.example.listacontactos.domain.entities.Contacto
import com.example.listacontactos.domain.entities.Genero

object ContactosRepository {

    val lista = mutableListOf(
        Contacto(1, "Juan García", "611123456", Genero.Masculino),
        Contacto(2, "María López", "678456123", Genero.Femenino),
        Contacto(3, "Raúl Cimas", "644789456", Genero.Masculino),
        Contacto(4, "Ana Morantes", "693882147", Genero.Femenino),
        Contacto(5, "Luis Fernández", "622345678", Genero.Masculino),
        Contacto(6, "Elena Martín", "634567812", Genero.Femenino),
        Contacto(7, "Carlos Pérez", "655789234", Genero.Masculino),
        Contacto(8, "Laura Gómez", "677890345", Genero.Femenino),
        Contacto(9, "Sergio Ruiz", "699123987", Genero.Masculino),
        Contacto(10, "Patricia Torres", "688234561", Genero.Femenino),
        Contacto(11, "David Morales", "666987123", Genero.Masculino),
        Contacto(12, "Beatriz Cano", "644345678", Genero.Femenino),
        Contacto(13, "Javier Ortiz", "612456789", Genero.Masculino),
        Contacto(14, "Silvia Rivas", "671234890", Genero.Femenino),
        Contacto(15, "Andrés Soto", "693456712", Genero.Masculino),
        Contacto(16, "Natalia Campos", "655678901", Genero.Femenino),
        Contacto(17, "Miguel Castro", "611789234", Genero.Masculino),
        Contacto(18, "Lucía Vega", "623890567", Genero.Femenino),
        Contacto(19, "Pablo Serrano", "687901234", Genero.Masculino),
        Contacto(20, "Marta Díaz", "698012345", Genero.Femenino),
        )
    fun getAllContacts(): List<Contacto> {
        return lista
    }

    fun guardarContacto(nuevoContacto: Contacto) {

        lista.add(nuevoContacto)

    }


}