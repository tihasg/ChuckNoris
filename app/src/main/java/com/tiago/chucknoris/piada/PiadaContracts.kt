package com.tiago.chucknoris.piada

import com.tiago.chucknoris.base.mvp.BaseView
import io.reactivex.Single


object PiadaContracts {
    interface View : BaseView<Presenter>

    interface Presenter {
        fun getRandomJoke(category: String): Single<Piada>
        var view: View?
    }

    interface Repository {
        fun getRandomJoke(category: String): Single<RandomPiadaResponse>
    }
}