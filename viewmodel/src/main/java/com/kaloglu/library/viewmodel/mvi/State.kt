package com.kaloglu.library.viewmodel.mvi

import com.kaloglu.library.ui.models.ErrorModel

interface State {

    val type: StateType
    val loading: Boolean
        get() = false

    enum class StateType {
        EMPTY,
        LOADING,
        INIT,
        IDLE,
        ERROR,
        DONE,
        CUSTOM
    }

    interface Init : State {
        override val type: StateType
            get() = StateType.INIT

        override val loading: Boolean
            get() = true
    }
    interface Idle : State {
        override val type: StateType
            get() = StateType.IDLE

        override val loading: Boolean
            get() = true
    }

    interface Empty : State {
        override val type: StateType
            get() = StateType.EMPTY
    }

    interface Failure : State {
        override val type: StateType
            get() = StateType.ERROR

        val error: ErrorModel
    }

    interface Done : State {
        override val type: StateType
            get() = StateType.DONE
    }

    interface Loading : State {
        override val type: StateType
            get() = StateType.LOADING

        override val loading: Boolean
            get() = true
    }

    interface Custom : State {
        override val type
            get() = StateType.CUSTOM
    }

}
