package com.example.oceancrystalball.p15afc101.ui.ocean

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.oceancrystalball.p15afc101.ui.ocean.components.OceanInfoPanel
import com.pico.spatial.core.ecs.Entity
import com.pico.spatial.core.ecs.TransformComponent
import com.pico.spatial.core.math.Vector3
import com.pico.spatial.ui.foundation.content.SpatialView

@Composable
fun OceanCrystalBallScreen(
    viewModel: OceanCrystalBallViewModel = viewModel(factory = null),
) {
    Box(
        modifier = Modifier
            .size(width = 960.dp, height = 640.dp),
        contentAlignment = Alignment.Center,
    ) {
        SpatialView(
            modifier = Modifier.size(width = 960.dp, height = 640.dp),
            attachments = {
                AttachmentPanel("info-panel") {
                    OceanInfoPanel(
                        onResetView = {
                            viewModel.onEvent(OceanCrystalBallEvent.ResetView)
                        },
                    )
                }
            },
            initial = { content, attachments ->
                val sceneRoot = Entity()
                content.addEntity(sceneRoot)

                val oceanCrystalBall = Entity.loadSuspend("asset://ocean_crystal_ball.usda")
                oceanCrystalBall.components[TransformComponent::class.java]
                    ?.setPosition(Vector3(-0.18f, -0.02f, -1.0f))
                sceneRoot.addChild(oceanCrystalBall)

                attachments.entity("info-panel")?.let { panel ->
                    panel.components[TransformComponent::class.java]
                        ?.setPosition(Vector3(0.36f, 0.02f, -0.78f))
                    sceneRoot.addChild(panel)
                }
            },
        )
    }
}
