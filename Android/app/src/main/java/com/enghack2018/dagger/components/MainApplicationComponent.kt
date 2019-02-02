package com.enghack2018.dagger.components

import android.content.Context
import com.enghack2018.Activities.MainApplication
import com.enghack2018.Activities.MainDataActivity
import com.enghack2018.Activities.SplashScreenActivity
import com.enghack2018.Controllers.SplashScreenController
import com.enghack2018.REST.Request.Plate.PlatesRequestAsync
import com.enghack2018.dagger.modules.MainApplicationModule
import com.enghack2018.dagger.modules.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainApplicationModule::class, ViewModelModule::class])
interface MainApplicationComponent {

    fun context() : Context

    fun platesRequestAsync() : PlatesRequestAsync

    fun inject(application : MainApplication)

    fun inject(mainDataActivity: MainDataActivity)

    fun inject(splashScreenController: SplashScreenController)

    fun inject(splashScreenActivity: SplashScreenActivity)
}