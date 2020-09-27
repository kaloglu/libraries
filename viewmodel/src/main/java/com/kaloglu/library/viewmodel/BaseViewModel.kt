package com.kaloglu.library.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.viewModelScope
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
abstract class BaseViewModel<E, S>(application: BaseApplication) : AndroidViewModel(application),
    LifecycleObserver
        where E : Event, S : State {

    abstract val idleState: State.Idle
    abstract val idleEvent: Event.Idle

    val stateFlow: StateFlow<S?>
        get() = _stateFlow

    private val _stateFlow: MutableStateFlow<S?> = MutableStateFlow(null)
    private val _eventFlow: MutableStateFlow<E?> = MutableStateFlow(null)

    init {
        viewModelScope.launch {
            _eventFlow
                .filterNotNull()
                .collect {
                    when (it) {
                        is Event.Idle -> onEventIdle()
                        else -> {
                            onEvent(it)
                            eventIdle()
                        }
                    }
                }
        }
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun postEvent(event: E) {
        _eventFlow.value = event
    }

    open fun onEventIdle() = Unit

    open fun <VM : BaseViewModel<*, *>> attachViewModel(vararg viewModels: VM) = Unit

    @Suppress("UNCHECKED_CAST")
    open fun stateIdle() = postState(idleState as S)

    @Suppress("UNCHECKED_CAST")
    open fun eventIdle() = postEvent(idleEvent as E)

    protected open suspend fun onEvent(event: E) = Unit

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun postState(state: S) {
        _stateFlow.value = state
    }
}
