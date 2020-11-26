package com.tiago.chucknoris.categories

import com.tiago.chucknoris.categories.CategoriesContracts.Presenter
import com.tiago.chucknoris.categories.CategoriesContracts.Repository
import dagger.Binds
import dagger.Module


@Module
abstract class CategoriesModule {
    @Binds
    abstract fun providesPresenter(presenter: CategoriesPresenter): Presenter

    @Binds
    abstract fun providesRepository(presenter: CategoriesRepository): Repository
}