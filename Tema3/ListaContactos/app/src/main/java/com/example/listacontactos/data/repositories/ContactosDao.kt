package com.example.listacontactos.data.repositories

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.listacontactos.domain.entities.Contacto

@Dao
interface ContactosDao {

    @Query("SELECT * FROM contacto_entidad ORDER BY id ASC")
    suspend fun getAllContactos(): List<Contacto>

    @Insert
    suspend fun addContacto(contacto: Contacto): Long

    @Update
    suspend fun updateContacto(contacto: Contacto)

    @Delete
    suspend fun deleteContacto(contacto: Contacto)

    @Query("DELETE FROM contacto_entidad")
    suspend fun deleteAllContactos()
}