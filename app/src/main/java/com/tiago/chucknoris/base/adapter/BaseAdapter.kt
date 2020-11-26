package com.tiago.chucknoris.base.adapter

import androidx.recyclerview.widget.RecyclerView
import java.lang.Math.min

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseHolder<T>>() {
    protected val items: MutableList<T>  by lazy { mutableListOf<T>() }

    override fun onBindViewHolder(holder: BaseHolder<T>, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun add(collection: Collection<T>) {
        for (obj in collection) {
            add(obj)
        }
    }

    fun add(obj: T) {
        add(obj, items.size)
    }

    fun add(obj: T, position: Int) {
        items.add(min(position, items.size), obj)
        notifyItemInserted(position)
    }

    fun clear() {
        val count = items.size
        items.clear()
        notifyItemRangeRemoved(0, count)
    }
}