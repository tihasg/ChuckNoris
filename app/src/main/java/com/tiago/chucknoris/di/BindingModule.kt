package com.tiago.chucknoris.di

import com.tiago.chucknoris.categories.CategoriesActivity
import com.tiago.chucknoris.categories.CategoriesModule
import com.tiago.chucknoris.piada.PiadaActivity
import com.tiago.chucknoris.piada.PiadaModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface BindingModule {

    @ContributesAndroidInjector(modules = [CategoriesModule::class])
    fun injectCategoriesActivity(): CategoriesActivity

    @ContributesAndroidInjector(modules = [PiadaModule::class])
    fun injectJokeActivity(): PiadaActivity
}