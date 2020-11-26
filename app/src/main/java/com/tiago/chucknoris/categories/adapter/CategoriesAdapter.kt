package com.tiago.chucknoris.categories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tiago.chucknoris.base.adapter.BaseAdapter
import com.tiago.chucknoris.base.adapter.BaseHolder
import com.tiago.chucknoris.categories.CategoriesContracts.Presenter
import com.tiago.chucknoris.R


class CategoriesAdapter(val presenter: Presenter) : BaseAdapter<String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<String> {
        val inflater = LayoutInflater.from(parent.context)
        return CategoriesHolder(inflater.inflate(R.layout.item_category, parent, false), presenter)
    }
}