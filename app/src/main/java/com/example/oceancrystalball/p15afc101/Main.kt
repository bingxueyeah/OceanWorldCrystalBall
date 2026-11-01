package com.example.oceancrystalball.p15afc101

import androidx.compose.ui.unit.dp
import com.example.oceancrystalball.p15afc101.ui.ocean.OceanCrystalBallScreen
import com.pico.spatial.ui.design.PicoTheme
import com.pico.spatial.ui.foundation.dsl.DefaultWindowContainer
import com.pico.spatial.ui.foundation.dsl.Form
import com.pico.spatial.ui.foundation.dsl.SpatialAppScope
import com.pico.spatial.ui.foundation.dsl.WindowContainer
import com.pico.spatial.ui.foundation.dsl.WindowContainerSize

fun mainApp(scope: SpatialAppScope) =
    with(scope) {
        DefaultWindowContainer {
            PicoTheme {
                OceanCrystalBallScreen()
            }
        }

        // design-style: volume-container ocean-volume
        WindowContainer(
            id = "ocean-volume",
            form = Form.Volumetric,
            defaultSize = WindowContainerSize(width = 960.dp, height = 640.dp, depth = 520.dp),
        ) {
            PicoTheme {
                OceanCrystalBallScreen()
            }
        }
    }
