package com.kaloglu.library.ui.viewmodel

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kaloglu.library.ui.interfaces.ClickableRecyclerItem
import com.kaloglu.library.ui.interfaces.ViewHolder
import com.kaloglu.library.ui.viewmodel.model.RecyclerViewModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi
import com.kaloglu.library.ui.BaseViewHolder as BaseVH

@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
abstract class BaseViewHolder<RVM : RecyclerViewModel<*,*>>(override val containerView: View) :
    RecyclerView.ViewHolder(containerView),
    LayoutContainer, ClickableRecyclerItem<RVM>, ViewHolder<RVM> {

    override var onViewClick: ((RVM, View, Int) -> Unit)? = null

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun setOnViewClick(onViewClick: ((RVM, View, Int) -> Unit)?): BaseVH<RVM> {
        this.onViewClick = onViewClick
        return this as BaseVH<RVM>
    }

    override fun bindItem(item: RVM, onItemClick: ((RVM, Int) -> Unit)?) {

        with(itemView) {
            setOnClickListener { onItemClick?.invoke(item, adapterPosition) }
            bindItem(item)
        }
    }
}