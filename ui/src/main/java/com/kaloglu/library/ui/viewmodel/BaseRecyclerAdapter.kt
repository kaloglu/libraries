package com.kaloglu.library.ui.viewmodel

import android.view.View
import android.view.ViewGroup
import com.kaloglu.library.ui.BaseRecyclerAdapter
import com.kaloglu.library.ui.BaseViewHolder
import com.kaloglu.library.ui.viewmodel.model.RecyclerViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
abstract class BaseRecyclerAdapter<RVM : RecyclerViewModel<*>, VH : BaseViewHolder<RVM>> :
    BaseRecyclerAdapter<RVM, VH>() {

    override var onItemClick: ((RVM, Int) -> Unit)? = null
    override var onViewClick: ((RVM, View, Int) -> Unit)? = null

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder
            .setOnViewClick(onViewClick)
            .bindItem(getItem(position), onItemClick)

}
