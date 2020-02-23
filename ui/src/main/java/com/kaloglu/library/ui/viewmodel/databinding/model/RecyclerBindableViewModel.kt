package com.kaloglu.library.ui.viewmodel.databinding.model

import androidx.databinding.Bindable
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.databinding.BindableViewModel

abstract class RecyclerBindableViewModel : BindableViewModel(), RecyclerItem {

    @get:Bindable
    abstract override var layoutId: Int

//    @get:Bindable
//    override val parent: RecyclerBindableViewModel? = null

}
