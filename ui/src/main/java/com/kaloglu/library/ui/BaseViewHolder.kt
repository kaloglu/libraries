package com.kaloglu.library.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kaloglu.library.ui.interfaces.ClickableRecyclerItem
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<M>(override val containerView: View) :
    RecyclerView.ViewHolder(containerView),
    LayoutContainer, ClickableRecyclerItem<M> {

    override var onViewClick: ((M, View, Int) -> Unit)? = null

    override fun setOnViewClick(onViewClick: ((M, View, Int) -> Unit)?): BaseViewHolder<M> {
        this.onViewClick = onViewClick
        return this
    }

    abstract fun bindItem(item: M)

    internal fun bindItem(item: M, onItemClick: ((M, Int) -> Unit)? = null) {

        with(itemView) {
            setOnClickListener { onItemClick?.invoke(item, adapterPosition) }
            bindItem(item)
        }
    }
}