package com.kaloglu.library.ui.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.viewmodel.states.State

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseViewModel<M, S>(application: BaseApplication) : AndroidViewModel(application)
        where M : Any, S : State {

    val stateMediatorLiveData = MediatorLiveData<S>()

    private val _stateLiveData = MutableLiveData<S>()

    @CallSuper
    open fun onAttachViewModel() {
        stateMediatorLiveData.addSource(_stateLiveData) {
            this.onState(it)
            stateMediatorLiveData::postValue
        }
    }

    @CallSuper
    open fun onUiState(state: S) = when (state) {
        is State.UiState.Init -> onInitState()
        else -> {
        }
    }

    @CallSuper
    open fun postState(state: S) {
        _stateLiveData.postValue(state)
    }

    fun onState(state: S) = when (state) {
        is State.UiState -> onUiState(state)
        else -> throw IllegalArgumentException("Unhandled State types ${state.javaClass.simpleName}")
    }

    abstract fun onInitState()

}
