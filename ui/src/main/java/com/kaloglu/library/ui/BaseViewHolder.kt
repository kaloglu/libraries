package com.kaloglu.library.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<M>(override val containerView: View) :
    RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    internal var onViewClick: ((M, View) -> Unit) = { _, _ -> }

    abstract fun bindItem(item: M)

    internal fun bindItem(item: M, onItemClick: (M) -> Unit) {

        with(itemView) {
            setOnClickListener { onItemClick(item) }
            bindItem(item)
        }
    }

    internal fun setOnViewClick(onViewClick: ((M, View) -> Unit)): BaseViewHolder<M> {
        this.onViewClick = onViewClick
        return this
    }
}