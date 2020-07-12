package com.kaloglu.library.databinding4vm.adapter

import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import com.kaloglu.library.databinding4vm.inflateViewHolderBinding
import com.kaloglu.library.ui.DiffItemSimpleCallback
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.adapter.BasePagedListAdapter

abstract class DataBoundPagedListAdapter<RI>(
    diffUtilCallback: DiffItemSimpleCallback<RI> = DiffItemSimpleCallback()
) : BasePagedListAdapter<RI, BoundViewHolder<RI>>(diffUtilCallback)
        where RI : RecyclerItem {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BoundViewHolder<RI>(
            onCreateBinding(parent, viewType)
        )

    @CallSuper
    open fun onCreateBinding(parent: ViewGroup, viewType: Int) =
        parent.inflateViewHolderBinding(viewType)

    override fun onBindViewHolder(holder: BoundViewHolder<RI>, position: Int) {
        holder.setBindingVariable = this::setBindVariable
        super.onBindViewHolder(holder, position)
    }

    /**
     * Should set viewDataBinding.setVariable(BR.item, recylerItem)
     * */
    abstract fun setBindVariable(viewDataBinding: ViewDataBinding, recylerItem: RI)
}
