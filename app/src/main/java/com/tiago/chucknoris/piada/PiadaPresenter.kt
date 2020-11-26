package com.tiago.chucknoris.piada

import com.tiago.chucknoris.piada.PiadaContracts.Presenter
import com.tiago.chucknoris.piada.PiadaContracts.View
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PiadaPresenter @Inject constructor(val repository: PiadaContracts.Repository) : Presenter {

    override fun getRandomJoke(category: String): Single<Piada> {
        return repository
                .getRandomJoke(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view?.startLoading() }
                .doFinally { view?.stopLoading() }
                .map { response ->
                    Piada().apply {
                        this.content = response.value ?: ""
                        this.imgUrl = response.iconUrl ?: ""
                        this.link = response.url ?: ""
                    }
                }
    }

    override var view: View? = null


}