package com.enghack2018.dagger.modules

import android.arch.lifecycle.ViewModelProvider
import com.enghack2018.ViewModel.MainViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(mainMainViewModelFactory: MainViewModelFactory): ViewModelProvider.Factory
}