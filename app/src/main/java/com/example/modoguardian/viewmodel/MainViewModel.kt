package com.example.modoguardian.viewmodel

import androidx.lifecycle.ViewModel
import com.example.modoguardian.navigation.NavigationEvent
import com.example.modoguardian.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
   private val _navigationEvents = MutableSharedFlow<NavigationEvent>()
    // Expone channel como Flow de solo lectura
   val navigationEvents: SharedFlow<NavigationEvent> = _navigationEvents.asSharedFlow()

   // Emite evento de navegacion hacia la ruta deseada
   fun navigateTo(screen: Screen) {
       CoroutineScope(Dispatchers.Main).launch {
           _navigationEvents.emit(NavigationEvent.NavigateTo(screen))
       }
   }

   // Volver atras
   fun navigateBack() {
       CoroutineScope(Dispatchers.Main).launch {
           _navigationEvents.emit(NavigationEvent.PopBackStack)
       }
   }

   // Navegar arriba (padre)
   fun navigateUp() {
       CoroutineScope(Dispatchers.Main).launch {
           _navigationEvents.emit(NavigationEvent.NavigateUp)
       }
   }
}