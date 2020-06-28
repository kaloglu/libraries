package com.kaloglu.library.ui.interfaces

import android.view.View
import com.kaloglu.library.ui.RecyclerItem

interface ClickableRecyclerItemAdapter<RI : RecyclerItem> {

    var onItemClick: ((RI, Int) -> Unit)?
    var onItemLongClick: (RI, Int) -> Boolean
    var onViewClick: ((RI, View, Int) -> Unit)?
    var onViewLongClick: (RI, View, Int) -> Boolean
}
