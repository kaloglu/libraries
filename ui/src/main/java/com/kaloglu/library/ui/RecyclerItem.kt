package com.kaloglu.library.ui

import androidx.annotation.LayoutRes

interface RecyclerItem : BaseModel {

    @get:LayoutRes
    var layoutId: Int

    val parent: RecyclerItem?

    var position: Int
}
