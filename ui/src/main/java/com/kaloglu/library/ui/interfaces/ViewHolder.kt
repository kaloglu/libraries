package com.kaloglu.library.ui.interfaces

import androidx.lifecycle.LifecycleOwner

interface ViewHolder<M> : LifecycleOwner, ViewHolderLifeCycle {
    fun bind(item: M)

    fun bind(
        item: M?,
        onItemClick: ((M, Int) -> Unit)? = null,
        onItemLongClick: ((M, Int) -> Boolean) = { _, _ -> false }
    )

}
