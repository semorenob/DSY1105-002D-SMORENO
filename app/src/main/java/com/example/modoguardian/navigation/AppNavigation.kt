package com.example.modoguardian.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.modoguardian.ui.screens.HomeScreen
import com.example.modoguardian.ui.screens.LoginScreen
import com.example.modoguardian.ui.screens.RegistroScreen
import com.example.modoguardian.ui.screens.ResumenScreen
import com.example.modoguardian.viewmodel.EstadoViewModel
import com.example.modoguardian.viewmodel.UsuarioViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val estadoViewModel: EstadoViewModel = viewModel()
    val usuarioViewModel: UsuarioViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "inicio",
    ) {
        composable("inicio") {
            HomeScreen(estadoViewModel, navController)
        }
        composable("registro") {
            RegistroScreen(navController, usuarioViewModel)
        }
        composable("login") {
            LoginScreen(navController, usuarioViewModel)
        }
    }
}