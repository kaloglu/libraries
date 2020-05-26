package com.kaloglu.library.databinding4vm.model

import androidx.databinding.Bindable
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.databinding4vm.BindableViewModel
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State

abstract class RecyclerBindableViewModel<E, S>(application: BaseApplication) :
    BindableViewModel<E, S>(application), RecyclerItem
        where E : Event, S : State {

    @get:Bindable
    abstract override var layoutId: Int

}
