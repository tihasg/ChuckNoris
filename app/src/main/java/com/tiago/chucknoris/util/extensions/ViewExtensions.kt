package com.tiago.chucknoris.util.extensions

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

fun View.show() {
    this.visibility = VISIBLE
}

fun View.hide() {
    this.visibility = GONE
}