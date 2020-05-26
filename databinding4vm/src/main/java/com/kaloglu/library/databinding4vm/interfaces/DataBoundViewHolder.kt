package com.kaloglu.library.databinding4vm.interfaces

import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.interfaces.ViewHolder

interface DataBoundViewHolder<RI> : ViewHolder<RI>
        where RI : RecyclerItem
