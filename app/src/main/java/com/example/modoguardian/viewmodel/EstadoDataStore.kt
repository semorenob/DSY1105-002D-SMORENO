package com.example.modoguardian.viewmodel

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("preferencia_usuario")
class EstadoDataStore(private val context: Context) {
    // Clave usada para guardar estado
    private val ESTADO_ACTIVADO = booleanPreferencesKey("modo_activado")

    // funcion pa guardar estado en DataStore
    suspend fun guardarEstado(valor: Boolean) {
        context.dataStore.edit { preferencias ->
            preferencias[ESTADO_ACTIVADO] = valor
        }
    }

    // funcion para obtener el estado como flow (reactivo)
    fun obtenerEstado(): Flow<Boolean?> {
        return context.dataStore.data.map { preferencias ->
            preferencias[ESTADO_ACTIVADO]
        }
    }
}