package com.kaloglu.library.ui.viewmodel.databinding.model

import androidx.databinding.Bindable
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.databinding.BindableViewModel
import com.kaloglu.library.ui.viewmodel.mvi.Event
import com.kaloglu.library.ui.viewmodel.mvi.State

abstract class RecyclerBindableViewModel<E, S>(application: BaseApplication) :
    BindableViewModel<E, S>(application), RecyclerItem
        where E : Event, S : State {

    @get:Bindable
    abstract override var layoutId: Int

}
