package com.example.oceancrystalball.p15afc101.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class OceanCrystalBallState(
    val rotationDegrees: Float = 0f,
    val editorAssetStatus: EditorAssetStatus = EditorAssetStatus.Blocked,
)

enum class EditorAssetStatus {
    Delivered,
    Blocked,
}
