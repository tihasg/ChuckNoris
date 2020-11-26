package com.tiago.chucknoris.piada

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.tiago.chucknoris.base.BaseActivity
import com.tiago.chucknoris.piada.PiadaContracts.Presenter
import com.squareup.picasso.Picasso
import com.tiago.chucknoris.R
import com.tiago.chucknoris.util.extensions.hide
import com.tiago.chucknoris.util.extensions.show
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_random_joke.*
import javax.inject.Inject

class PiadaActivity : BaseActivity<Presenter>(), PiadaContracts.View {

    @Inject
    override lateinit var presenter: Presenter

    val category by lazy { intent.extras[CATEGORY] as String }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_random_joke)
        initUI()
        presenter.view = this
        compositeDisposable.add(
                presenter.getRandomJoke(category).subscribe(this::showJoke, this::showErrorMessage))
    }

    private fun initUI() {
        setSupportActionBar(toolbar_joke)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        this.title = category.toUpperCase()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun showJoke(piada: Piada) {
        Picasso.get().load(piada.imgUrl).into(image_joke_icon)
        text_joke_link.text = piada.link
        text_joke_content.text = piada.content
    }

    private fun showErrorMessage(throwable: Throwable) {
        Toast.makeText(this, R.string.error_joke, LENGTH_LONG).show()
    }

    override fun startLoading() {
        group_jokes_content.hide()
        progress_jokes.show()
    }

    override fun stopLoading() {
        group_jokes_content.show()
        progress_jokes.hide()
    }

    companion object {
        const val CATEGORY = "categoryId"
        fun getIntent(context: Context, category: String): Intent {
            return Intent(context, PiadaActivity::class.java).apply {
                putExtra(CATEGORY, category)
            }
        }
    }
}