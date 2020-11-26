package com.tiago.chucknoris.di


import com.tiago.chucknoris.ChuckApp
import com.tiago.chucknoris.api.ApiModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    BindingModule::class,
    ApiModule::class])
interface AppComponent : AndroidInjector<ChuckApp>