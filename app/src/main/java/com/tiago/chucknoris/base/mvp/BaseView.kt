package com.tiago.chucknoris.base.mvp

interface BaseView<T> {
    fun startLoading()
    fun stopLoading()
    var presenter: T
}
