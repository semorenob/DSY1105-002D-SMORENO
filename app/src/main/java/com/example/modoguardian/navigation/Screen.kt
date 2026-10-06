package com.example.modoguardian.navigation

sealed class Screen(val route: String) {
    data object Login: Screen("login")
    data object HomeAdmin: Screen("home_admin")
    data object HomeSupervisor: Screen("home_supervisor")
    data object HomeOperador: Screen("home_operador")
}

// sealed class NavigationEvent { ... }