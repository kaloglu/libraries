package com.kaloglu.library.ui.interfaces

import android.view.View
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.adapter.BaseViewHolder

interface ClickableRecyclerItem<RI : RecyclerItem> {

    var onViewClick: ((RI, View, Int) -> Unit)?
    var onViewLongClick: (RI, View, Int) -> Boolean

    fun setClicks(
        onViewClick: ((RI, View, Int) -> Unit)? = null,
        onViewLongClick: (RI, View, Int) -> Boolean = { _, _, _ -> false }
    ): BaseViewHolder<RI>
}
