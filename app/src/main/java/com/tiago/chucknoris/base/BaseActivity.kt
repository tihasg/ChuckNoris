package com.tiago.chucknoris.base
import androidx.appcompat.app.AppCompatActivity
import com.tiago.chucknoris.base.mvp.BaseView
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<T> : AppCompatActivity(), BaseView<T> {
    var compositeDisposable = CompositeDisposable()


    override fun onResume() {
        super.onResume()
        compositeDisposable = CompositeDisposable()
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear()
    }
}