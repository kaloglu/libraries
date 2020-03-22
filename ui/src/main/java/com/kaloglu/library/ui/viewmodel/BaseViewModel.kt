package com.kaloglu.library.ui.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.utils.Resource
import com.kaloglu.library.ui.viewmodel.states.State
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlin.coroutines.CoroutineContext

@Suppress("MemberVisibilityCanBePrivate")
@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
abstract class BaseViewModel<M : Any, S : State>(application: BaseApplication) :
    AndroidViewModel(application), CoroutineScope {

    val job = Job()

    override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Main

    val stateLiveData = MutableLiveData<S>()

    val resultChannel=  ConflatedBroadcastChannel<Resource<M>>()
    val eventChannel = ConflatedBroadcastChannel<S>()
    val stateChannel = ConflatedBroadcastChannel<S>()

    @CallSuper
    override fun onCleared() {
        resultChannel.cancel()
        super.onCleared()
    }

    @CallSuper
    open fun onAttachViewModel() {
        launch {
            resultChannel.consumeEach {
                this@BaseViewModel.handleResult(it)
            }
            eventChannel.consumeEach {
                this@BaseViewModel.onEvent(it)
            }
            stateChannel.consumeEach {
                this@BaseViewModel.onStateChannel(it)
            }
        }

        stateLiveData.observeForever {
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

    open fun onEvent(event: S) = Unit

    @CallSuper
    open fun onState(state: S) {
        when (state) {
            is State.UiState.Init -> onInitState()
        }
    }

    @CallSuper
    open fun onStateChannel(state: S) {
        when (state) {
            is State.UiState.Init -> onInitState()
        }
    }

    @CallSuper
    open fun postState(state: S) {
        stateLiveData.postValue(state)
        stateChannel.offer(state)
    }

    abstract fun onInitState()

    abstract fun onDataLoading(loading: Resource.Loading<M>)

    abstract fun onDataSuccess(success: Resource.Success<M>)

    abstract fun onDataFailure(failure: Resource.Failure<M>)

}
