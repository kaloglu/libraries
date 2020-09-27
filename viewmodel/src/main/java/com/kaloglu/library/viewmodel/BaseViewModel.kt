package com.kaloglu.library.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
abstract class BaseViewModel<E, S>(application: BaseApplication) : AndroidViewModel(application),
    LifecycleObserver
        where E : Event, S : State {

    abstract val idleState: State.Idle
    abstract val idleEvent: Event.Idle

    val stateFlow: StateFlow<S?>
        get() = _stateFlow

    val eventFlow: StateFlow<E?>
        get() = _eventFlow

    private val _stateFlow: MutableStateFlow<S?> = MutableStateFlow(null)
    private val _eventFlow: MutableStateFlow<E?> = MutableStateFlow(null)

    @Suppress("UNCHECKED_CAST")
    open fun stateIdle() = postState(idleState as S)

    @Suppress("UNCHECKED_CAST")
    open fun eventIdle() = postEvent(idleEvent as E)

    open fun <VM : BaseViewModel<*, *>> attachViewModel(vararg viewModels: VM) = Unit

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun postEvent(event: E) {
        _eventFlow.value = event
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun postState(state: S) {
        _stateFlow.value = state
    }
}
