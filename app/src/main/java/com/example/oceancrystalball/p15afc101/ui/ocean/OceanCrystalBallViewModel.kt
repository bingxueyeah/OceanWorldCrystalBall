package com.example.oceancrystalball.p15afc101.ui.ocean

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OceanCrystalBallViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OceanCrystalBallUiState())
    val uiState: StateFlow<OceanCrystalBallUiState> = _uiState.asStateFlow()

    fun onEvent(event: OceanCrystalBallEvent) {
        when (event) {
            is OceanCrystalBallEvent.RotationChanged -> {
                _uiState.update { current ->
                    current.copy(rotationDegrees = event.rotationDegrees)
                }
            }

            OceanCrystalBallEvent.ResetView -> {
                _uiState.update { current ->
                    current.copy(rotationDegrees = 0f)
                }
            }
        }
    }
}
