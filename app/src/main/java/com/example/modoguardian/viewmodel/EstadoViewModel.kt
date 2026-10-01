package com.example.modoguardian.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.modoguardian.viewmodel.EstadoDataStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EstadoViewModel(application: Application) : AndroidViewModel(application) {

    // Datastore con contexto de app
    private val estadoDataStore = EstadoDataStore(application)

    // Estado que representa si esta activo o no (observable)
    private val _activo = MutableStateFlow<Boolean?>(null)
    val activo: StateFlow<Boolean?> = _activo

    // Estado para mostrar mensaje
    private val _mostrarMensaje = MutableStateFlow(false)
    val mostrarMensaje: StateFlow<Boolean> = _mostrarMensaje

    init {
        // al iniciar ViewModel cargamos el estado desde DataStore
        cargarEstado()
    }

    fun cargarEstado() {
        viewModelScope.launch {
            // simular la demora para mostrar el cargando
            delay(1500)
            _activo.value = estadoDataStore.obtenerEstado().first() ?: false
        }
    }

    fun alternarEstado() {
        viewModelScope.launch {
            // alternamos el valor actual
            val nuevoValor = !(_activo.value ?: false)

            //guardamos en datastore
            estadoDataStore.guardarEstado(nuevoValor)

            //actualizamos el flujo
            _activo.value = nuevoValor

            // Mostrar el mensaje visual animado
            _mostrarMensaje.value = true

            delay(2000) // ocultamos en 2 segundos
            _mostrarMensaje.value = false
        }
    }
}