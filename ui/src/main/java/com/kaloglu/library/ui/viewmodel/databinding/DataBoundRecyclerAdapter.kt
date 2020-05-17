package com.kaloglu.library.ui.viewmodel.databinding

import android.view.ViewGroup
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.BaseRecyclerAdapter

abstract class DataBoundRecyclerAdapter<RI> : BaseRecyclerAdapter<RI, BoundViewHolder<RI>>()
        where RI : RecyclerItem {

    private val viewHolders: MutableList<BoundViewHolder<RI>> = mutableListOf()

    override fun getItemViewType(position: Int) = getItem(position).layoutId

    override fun onBindViewHolder(holder: BoundViewHolder<RI>, position: Int) =
        holder.bind(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BoundViewHolder<RI>(onCreateBinding(parent, viewType))
            .apply {
                viewHolders.add(this)
            }

    open fun onCreateBinding(parent: ViewGroup, viewType: Int) =
        parent.inflateViewHolderBinding(viewType)

    override fun onViewAttachedToWindow(holder: BoundViewHolder<RI>) {
        super.onViewAttachedToWindow(holder)
        holder.onAttach()
    }

    override fun onViewDetachedFromWindow(holder: BoundViewHolder<RI>) {
        super.onViewDetachedFromWindow(holder)
        holder.onDetach()
    }

    fun setLifecycleDestroyed() {
        viewHolders.forEach {
            it.onDestroyed()
        }
    }

}
