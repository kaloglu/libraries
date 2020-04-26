package com.kaloglu.library.ui.viewmodel.databinding.model

import androidx.databinding.Bindable
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.databinding.BindableViewModel
import com.kaloglu.library.ui.viewmodel.mvi.Event
import com.kaloglu.library.ui.viewmodel.mvi.Resource

abstract class RecyclerBindableViewModel<E, R>(application: BaseApplication) :
    BindableViewModel<E, R>(application), RecyclerItem
        where E : Event, R: Resource<*> {

    @get:Bindable
    abstract override var layoutId: Int

}
