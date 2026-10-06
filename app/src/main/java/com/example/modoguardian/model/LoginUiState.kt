package com.example.modoguardian.model

class LoginUiState (
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errores: LoginErrores = LoginErrores()
) {

}