package com.kaloglu.library.ui.interfaces

import android.view.View
import com.kaloglu.library.ui.adapter.BaseViewHolder
import com.kaloglu.library.ui.RecyclerItem

interface ClickableRecyclerItem<RI : RecyclerItem> {

    var onViewClick: ((RI, View, Int) -> Unit)?
    fun setOnViewClick(onViewClick: ((RI, View, Int) -> Unit)? = null): BaseViewHolder<RI>
}
