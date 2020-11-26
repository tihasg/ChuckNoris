package com.tiago.chucknoris.categories.adapter

import android.view.View
import com.tiago.chucknoris.base.adapter.BaseHolder
import com.tiago.chucknoris.categories.CategoriesContracts
import kotlinx.android.synthetic.main.item_category.view.*

class CategoriesHolder(itemView: View, val presenter: CategoriesContracts.Presenter) : BaseHolder<String>(itemView) {

    override fun bind(item: String) {
        itemView.button_category.text = item
        itemView.button_category.setOnClickListener {
            presenter.onCategorySelected(item)
        }
    }
}