package com.kaloglu.library.ui.viewmodel.databinding.model

import androidx.databinding.Bindable
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.databinding.BindableViewModel
import com.kaloglu.library.ui.viewmodel.states.State

abstract class RecyclerBindableViewModel<M, S>(application: BaseApplication) :
    BindableViewModel<M, S>(application), RecyclerItem
        where M : Any, S : State {

    @get:Bindable
    abstract override var layoutId: Int

}
