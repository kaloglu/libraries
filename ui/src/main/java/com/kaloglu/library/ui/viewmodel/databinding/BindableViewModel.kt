package com.kaloglu.library.ui.viewmodel.databinding

import androidx.databinding.PropertyChangeRegistry
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.databinding.interfaces.BindableField
import com.kaloglu.library.ui.viewmodel.states.State

abstract class BindableViewModel<M, S>(application: BaseApplication) :
    BaseViewModel<M, S>(application), BindableField
        where M : Any, S : State {

    @Transient
    override var mCallbacks: PropertyChangeRegistry? = null

}
