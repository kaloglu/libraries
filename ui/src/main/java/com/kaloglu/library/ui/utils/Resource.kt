package com.kaloglu.library.ui.utils

sealed class Resource<out T> {
    class Success<out T>(val body: T) : Resource<T>()
    class Failure(val error: Error) : Resource<Nothing>()

    sealed class State : Resource<Nothing>() {
        object Loading : State()
        object Loaded : State()
        object NoInternet : State()
        object Cancelled : State()
        object TimeOut : State()
    }

    fun handleResult(
        successBlock: (T) -> Unit = {},
        failureBlock: (Error) -> Unit = {},
        stateBlock: (State) -> Unit = {}
    ) {
        when (this) {
            is Success -> successBlock(body)
            is Failure -> failureBlock(error)
            is State -> stateBlock(this)
        }
    }
}

//sealed class Resource2<out T> {
//    open val body: T? = null
//    open val error: ErrorModel? = null
//    open val isLoading: Boolean = false
//
//    data class Success<out T>(override val body: T) : Resource2<T>()
//    data class Failure(
//        override val error: ErrorModel = ErrorModel(
//            Constants.UNKNOWN_ERROR_CODE,
//            Constants.UNKNOWN_ERROR
//        )
//    ) : Resource2<Nothing>()
//
//    class Loading : Resource2<Nothing>()
//    class NoInternet : Resource2<Nothing>()
//    class Cancelled : Resource2<Nothing>()
//    class TimeOut : Resource2<Nothing>()
//}
