package com.kaloglu.library.ui.viewmodel.databinding.model

import androidx.databinding.Bindable
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.databinding.BindableViewModel
import com.kaloglu.library.ui.viewmodel.states.State

abstract class RecyclerBindableViewModel<S : State> : BindableViewModel<S>(), RecyclerItem {

    @get:Bindable
    abstract override var layoutId: Int

//    @get:Bindable
//    override val parent: RecyclerBindableViewModel? = null

}
