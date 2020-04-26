package com.kaloglu.library.ui.viewmodel.mvi

enum class State {
    SUCCESS,
    ERROR,
    LOADING,
    EMPTY,
    INIT,
    CUSTOM
}
/*interface State {
    val type: StateType
    val value: Int
        get() = type.value
            ?: throw MissingFormatArgumentException("should override #valueInt on state class for custom states")

    val error: ErrorModel?
        get() = null

    val loading: Boolean
        get() = false

    enum class StateType(val value: Int? = 0) {
        EMPTY(300),
        DONE(200),
        LOADING(100),
        INIT(0),
        ERROR(-100),
        CUSTOM(null)
    }

    interface Init : State {
        override val loading: Boolean
            get() = true

        override val type
            get() = StateType.INIT
    }

    interface Loading : State {
        override val loading: Boolean
            get() = true

        override val type
            get() = StateType.LOADING
    }

    interface Empty : State {
        override val type
            get() = StateType.EMPTY
    }

    interface Done : State {
        override val type
            get() = StateType.DONE
    }

    interface Error : State {
        override val error: ErrorModel
        override val type
            get() = StateType.ERROR
    }

    */
/**
 *  usage :
 *      class Custom : State {
 *          override val valueInt: Int
 *              get() = 999
 *      }
 * *//*
    interface Custom : State {
        override val type
            get() = StateType.CUSTOM
    }

    fun done(): Done
    fun empty(): Empty
    fun loading(): Loading
    fun error(error: ErrorModel): Error
}*/
