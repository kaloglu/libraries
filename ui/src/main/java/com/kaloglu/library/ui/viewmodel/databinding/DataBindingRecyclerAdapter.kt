package com.kaloglu.library.ui.viewmodel.databinding

import android.view.ViewGroup
import com.kaloglu.library.ui.BR
import com.kaloglu.library.ui.BaseRecyclerAdapter
import com.kaloglu.library.ui.viewmodel.databinding.model.RecyclerBindableViewModel

abstract class DataBindingRecyclerAdapter<RVM : RecyclerBindableViewModel>
    : BaseRecyclerAdapter<RVM, DataBindingViewHolder<RVM>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<RVM> {
        return DataBindingViewHolder(parent.inflateBinding(viewType), viewType)
    }

    final override fun onBindViewHolder(holder: DataBindingViewHolder<RVM>, position: Int) {
        bind(holder, position)
        holder.binding.executePendingBindings()
    }

    private fun bind(
        holder: DataBindingViewHolder<RVM>,
        position: Int
    ) {
        holder.binding.setVariable(BR.dataModel, getItem(position))

        getItem(position).parent?.let {
            holder.binding.setVariable(BR.parent, it)
        }
        onBindCustomVariable(holder, getItem(position))
    }

    /**
     *
     *  Set custom variable after #onBindViewHolder
     *
     *  binding.setVariable(BR.variableName, it)
     *
     *  @param binding ViewDatabinding
     *  @param item Observable
     *
     * */
    internal open fun onBindCustomVariable(
        holder: DataBindingViewHolder<*>,
        item: RecyclerBindableViewModel
    ) = Unit

}
