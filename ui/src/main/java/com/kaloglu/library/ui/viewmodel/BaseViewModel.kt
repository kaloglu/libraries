package com.kaloglu.library.ui.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.utils.Resource
import com.kaloglu.library.ui.viewmodel.states.State
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlin.coroutines.CoroutineContext

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
abstract class BaseViewModel<S : State>(application: BaseApplication) :
    AndroidViewModel(application), CoroutineScope {

    protected abstract val receiveChannel: ReceiveChannel<Resource<*>>
    protected abstract val stateChannel: Channel<S>

    private val job = Job()

    init {
        processStream()
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    @CallSuper
    override fun onCleared() {
        receiveChannel.cancel()
        coroutineContext.cancel()
        super.onCleared()
    }

    open fun onResourceState(resourceState: Resource.State) = Unit

    suspend fun postState(state: S) {
        stateChannel.send(state)
    }

    private fun processStream() {
        launch {
            receiveChannel.consumeEach(this@BaseViewModel::resolve)
            stateChannel.consumeEach(this@BaseViewModel::onState)
        }
    }

    private fun resolve(value: Resource<*>) =
        value.handleResult(::onSuccess, ::onFailure, ::onResourceState)

    abstract fun onState(state: S)
    abstract fun onSuccess(data: Any?)
    abstract fun onFailure(error: Error)

}
