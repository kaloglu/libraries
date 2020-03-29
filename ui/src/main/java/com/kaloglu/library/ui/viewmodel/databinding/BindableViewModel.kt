package com.kaloglu.library.ui.viewmodel.databinding

import androidx.databinding.PropertyChangeRegistry
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.databinding.interfaces.BindableField
import com.kaloglu.library.ui.viewmodel.mvi.Event
import com.kaloglu.library.ui.viewmodel.mvi.State

abstract class BindableViewModel<E, S>(application: BaseApplication) :
    BaseViewModel<E, S>(application), BindableField
        where E : Event, S : State {

    @Transient
    override var mCallbacks: PropertyChangeRegistry? = null

}
