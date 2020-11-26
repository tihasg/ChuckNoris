package com.tiago.chucknoris.categories

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.recyclerview.widget.LinearLayoutManager
import com.tiago.chucknoris.R
import com.tiago.chucknoris.base.BaseActivity
import com.tiago.chucknoris.categories.adapter.CategoriesAdapter
import com.tiago.chucknoris.util.extensions.hide
import com.tiago.chucknoris.util.extensions.show
import com.tiago.chucknoris.piada.PiadaActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_categories.*
import javax.inject.Inject

class CategoriesActivity : BaseActivity<CategoriesContracts.Presenter>(), CategoriesContracts.View {

    @Inject
    override lateinit var presenter: CategoriesContracts.Presenter

    private lateinit var adapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_categories)
        presenter.view = this

        initUI()

        compositeDisposable.add(
                presenter.listCategories().subscribe(this::showCategories, this::showErrorMessage))
    }

    private fun initUI() {
        adapter = CategoriesAdapter(presenter)
        recycler_categories_list.layoutManager = LinearLayoutManager(this)
        recycler_categories_list.adapter = adapter
    }

    private fun showCategories(categories: List<String>) {
        adapter.clear()
        adapter.add(categories)
    }

    override fun showRandomJoke(category: String) {
        startActivity(PiadaActivity.getIntent(this, category))
    }

    private fun showErrorMessage(throwable: Throwable) {
        Toast.makeText(this, R.string.error_categories, LENGTH_LONG).show()
    }

    override fun startLoading() {
        progress_categories.show()
        recycler_categories_list.hide()
    }

    override fun stopLoading() {
        progress_categories.hide()
        recycler_categories_list.show()
    }
}
