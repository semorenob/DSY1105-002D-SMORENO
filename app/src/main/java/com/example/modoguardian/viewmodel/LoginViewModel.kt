package com.example.modoguardian.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {
    /*
    private val _estado = MutableStateFlow()

    fun onEmailChange(valor: String) {
        _estado.update { it.copy(correo = valor, errores = it.errores.copy(correo = null)) }
    }

    fun onPasswordChange(valor: String) {
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(direccion = null)) }
    }

    fun validarFormulario(): Boolean {
        val estadoActual = _estado.value
        val errores = UsuarioErrores(
            email = if (!estadoActual.correo.contains("@")) "Correo invalido" else null,
            password = if (estadoActual.clave.length < 6) "Debe tener al menos 6 caracteres" else null,
        )

        val hayErrores = listOfNotNull(
            errores.email,
            errores.password
        ).isNotEmpty()

        _estado.update { it.copy(errores = errores) }

        return !hayErrores
    }
     */
}