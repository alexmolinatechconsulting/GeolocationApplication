package com.geolocationapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geolocationapplication.repository.GeolocationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GeolocationUiState {
    val ipAddress = null
    val continent = null
    val region = null
    val city = null
    val district = null
    val zipCode = null
    val latitude = null
    val longitude = null
    val timezone = null
    val offset = null
}

class GeolocationSearchViewModel(private val geolocationRepository: GeolocationRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(GeolocationUiState())
    val uiState: StateFlow<GeolocationUiState> = _uiState.asStateFlow()

    fun getGeolocationByName(name : String?) 
    }
}