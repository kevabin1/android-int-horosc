package com.example.horoscapp.ui.home.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscapp.data.providers.HoroscopeProvider
import com.example.horoscapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider): ViewModel() {
    // aqui se crea el flow para comunicar las vistas
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init { // metodo especial de los viewModels
        _horoscope.value = horoscopeProvider.getHoroscopes() // llamamos al provider que se inyecto
    }
}