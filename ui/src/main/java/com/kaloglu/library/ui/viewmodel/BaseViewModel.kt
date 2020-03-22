package com.kaloglu.library.ui.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.utils.Resource
import com.kaloglu.library.ui.viewmodel.states.State

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseViewModel<M, S>(application: BaseApplication) :
    AndroidViewModel(application)
        where M : Any, S : State {

    val stateLiveData: LiveData<S>
        get() = _stateLiveData

    private val _stateLiveData = MutableLiveData<S>()

    val stateMediatorLiveData = MediatorLiveData<S>()

    @CallSuper
    open fun onAttachViewModel() {
        stateMediatorLiveData.addSource(_stateLiveData) {
            this.onState(it)
        }
    }

    open fun handleResult(resource: Resource<M>) {
        resource.handleResult(
            successBlock = { onDataSuccess(this) },
            failureBlock = { onDataFailure(this) },
            loadingBlock = { onDataLoading(this) }
        )
    }

    fun onState(state: S) {
        when (state) {
            is State.UiState -> onUiState(state)
            else -> throw IllegalArgumentException("Unhandled State types ${state.javaClass.simpleName}")
        }
    }

    @CallSuper
    open fun onUiState(state: S) {
        when (state) {
            is State.UiState.Init -> onInitState()
        }
    }

    @CallSuper
    open fun postState(state: S) {
        _stateLiveData.postValue(state)
    }

    abstract fun onInitState()

    open fun onDataLoading(loading: Resource.Loading<M>) = Unit

    open fun onDataSuccess(success: Resource.Success<M>) = Unit

    open fun onDataFailure(failure: Resource.Failure<M>) = Unit

}
