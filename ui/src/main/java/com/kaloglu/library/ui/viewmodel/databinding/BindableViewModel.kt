package com.kaloglu.library.ui.viewmodel.databinding

import androidx.databinding.PropertyChangeRegistry
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.databinding.interfaces.BindableField
import com.kaloglu.library.ui.viewmodel.mvi.Event
import com.kaloglu.library.ui.viewmodel.mvi.Resource

abstract class BindableViewModel<E, R>(application: BaseApplication) :
    BaseViewModel<E, R>(application), BindableField
        where E : Event, R: Resource<*> {

    @Transient
    override var mCallbacks: PropertyChangeRegistry? = null

}
