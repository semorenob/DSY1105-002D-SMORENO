package com.example.modoguardian.navigation

sealed class Screen(val route: String) {
    data object Login: Screen("login")
    data object HomeAdmin: Screen("home_admin")
    data object HomeSupervisor: Screen("home_supervisor")
    data object HomeOperador: Screen("home_operador")
}

sealed class NavigationEvent {
    // Evento para navegar a destino especifico
    data class NavigateTo(
        val route: Screen,
        val popUptoRoute: Screen? = null,
        val inclusive: Boolean = false,
        val singleTop: Boolean = false
    ) : NavigationEvent()

    // Evento para volver a pantalla anterior
    object PopBackStack : NavigationEvent()

    // Evento para navegar "arriba"
    object NavigateUp : NavigationEvent()
}