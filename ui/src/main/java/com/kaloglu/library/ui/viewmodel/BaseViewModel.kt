package com.kaloglu.library.ui.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.utils.Resource
import com.kaloglu.library.ui.viewmodel.states.State
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlin.coroutines.CoroutineContext

@Suppress("UNCHECKED_CAST")
@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
abstract class BaseViewModel<M : Any, S : State>(application: BaseApplication) :
    AndroidViewModel(application), CoroutineScope {

    override val coroutineContext: CoroutineContext by lazy { Job() + Dispatchers.Main }

    private val _state = MutableLiveData<S>()

    val state: LiveData<S> = _state

    protected abstract val resultChannel: ConflatedBroadcastChannel<Resource<M>>
    protected abstract val eventChannel: ConflatedBroadcastChannel<S>

    @CallSuper
    override fun onCleared() {
        resultChannel.cancel()
        super.onCleared()
    }

    @CallSuper
    open fun onAttachViewModel() {
        launch {
            resultChannel.consumeEach(this@BaseViewModel::handleResult)
            eventChannel.consumeEach(this@BaseViewModel::onEvent)
        }

        _state.observeForever(this::onState)
    }

    open fun handleResult(resource: Resource<M>) {
        resource.handleResult(
            successBlock = { onDataSuccess() },
            failureBlock = { onDataFailure() },
            loadingBlock = { onDataLoading() }
        )
    }

    open fun onEvent(event: S) = Unit

    @CallSuper
    open fun onState(state: S) {
        when (state) {
            is State.UiState.Init -> onInitState()
        }
    }

    @Suppress("MemberVisible")
    @CallSuper
    open fun postState(state: S) {
        _state.postValue(state)
    }

    abstract fun onDataLoading()

    abstract fun onDataSuccess()

    abstract fun onDataFailure()

    abstract fun onInitState()

}
