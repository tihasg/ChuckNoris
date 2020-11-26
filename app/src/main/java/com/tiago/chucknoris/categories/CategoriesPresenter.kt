package com.tiago.chucknoris.categories

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoriesPresenter @Inject constructor(private val repository: CategoriesRepository) : CategoriesContracts.Presenter {

    override var view: CategoriesContracts.View? = null

    override fun onCategorySelected(category: String) {
        view?.showRandomJoke(category)
    }

    override fun listCategories(): Single<List<String>> {
        return repository
                .listCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view?.startLoading() }
                .doFinally { view?.stopLoading() }
    }
}