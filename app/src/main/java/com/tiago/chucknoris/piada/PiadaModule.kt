package com.tiago.chucknoris.piada

import com.tiago.chucknoris.piada.PiadaContracts.Presenter
import com.tiago.chucknoris.piada.PiadaContracts.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class PiadaModule {
    @Binds
    abstract fun providesPresenter(presenter: PiadaPresenter): Presenter

    @Binds
    abstract fun providesRepository(presenter: PiadaRepository): Repository


}