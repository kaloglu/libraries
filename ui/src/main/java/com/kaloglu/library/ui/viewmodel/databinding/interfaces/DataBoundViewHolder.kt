package com.kaloglu.library.ui.viewmodel.databinding.interfaces

import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.interfaces.ViewHolder
import com.kaloglu.library.ui.viewmodel.databinding.model.RecyclerBindableViewModel

interface DataBoundViewHolder<RI> : ViewHolder<RI>
        where RI : RecyclerItem {

    fun bindVariables(item: RI)

    fun getBoundVariable() = -1

}
