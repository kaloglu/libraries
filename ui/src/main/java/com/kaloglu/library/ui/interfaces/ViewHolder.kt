package com.kaloglu.library.ui.interfaces

interface ViewHolder<M> {
    fun bindItem(item: M)

    fun bindItem(item: M, onItemClick: ((M, Int) -> Unit)? = null)

}
