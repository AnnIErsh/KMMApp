package com.example.kmm.android

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract  class ViewHolder<T> (itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bindItem(item: T)
    open var tag: Int = 0
}