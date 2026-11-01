package com.example.oceancrystalball.p15afc101.platform

import android.app.Application
import com.pico.spatial.ui.foundation.dsl.launch
import com.example.oceancrystalball.p15afc101.mainApp

class SpatialApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        launch(::mainApp)
    }
}
