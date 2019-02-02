package com.enghack2018.Activities

import android.app.Application
import com.enghack2018.dagger.components.DaggerMainApplicationComponent
import com.enghack2018.dagger.components.MainApplicationComponent
import com.enghack2018.dagger.modules.MainApplicationModule

class MainApplication : Application() {

    companion object {
        lateinit var mainApplicationComponent : MainApplicationComponent
        lateinit var instance : MainApplication
    }

    override fun onCreate() {
        super.onCreate()
        mainApplicationComponent =
                DaggerMainApplicationComponent
                        .builder()
                        .mainApplicationModule(MainApplicationModule(this))
                        .build()
        mainApplicationComponent.inject(this)
        instance = this
    }
}