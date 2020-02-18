package com.kaloglu.library.ui.interfaces

import android.view.View
import com.kaloglu.library.ui.BaseViewHolder

interface ClickableRecyclerItem<M> {

    var onViewClick: ((M, View, Int) -> Unit)?
    fun setOnViewClick(onViewClick: ((M, View, Int) -> Unit)? = null): BaseViewHolder<M>
}
