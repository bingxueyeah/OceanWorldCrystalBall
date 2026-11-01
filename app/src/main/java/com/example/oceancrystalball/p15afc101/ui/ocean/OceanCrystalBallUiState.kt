package com.example.oceancrystalball.p15afc101.ui.ocean

import androidx.compose.runtime.Immutable
import com.example.oceancrystalball.p15afc101.domain.model.EditorAssetStatus

@Immutable
data class OceanCrystalBallUiState(
    val rotationDegrees: Float = 0f,
    val editorAssetStatus: EditorAssetStatus = EditorAssetStatus.Blocked,
)

sealed interface OceanCrystalBallEvent {
    data class RotationChanged(val rotationDegrees: Float) : OceanCrystalBallEvent
    data object ResetView : OceanCrystalBallEvent
}
