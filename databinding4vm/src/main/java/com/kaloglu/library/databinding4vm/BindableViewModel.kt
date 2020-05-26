package com.kaloglu.library.databinding4vm

import androidx.databinding.PropertyChangeRegistry
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.BaseModel
import com.kaloglu.library.databinding4vm.interfaces.BindableField
import com.kaloglu.library.viewmodel.model.RecyclerViewModel
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State

@Suppress("CovariantEquals")
abstract class BindableViewModel<E, S>(application: BaseApplication) :
    RecyclerViewModel<E, S>(application),
    BindableField
        where E : Event, S : State {

    @Transient
    override var mCallbacks: PropertyChangeRegistry? = null

    @Suppress("UNCHECKED_CAST")
    @Deprecated("Not Use", level = DeprecationLevel.HIDDEN)
    override fun <T : Any> getID(): T = -1 as T

    @Deprecated("Not Use", level = DeprecationLevel.HIDDEN)
    override fun <T : BaseModel> equals(obj2: T): Boolean = false

    @Deprecated("Not Use", level = DeprecationLevel.HIDDEN)
    override var layoutId: Int = -1
}
