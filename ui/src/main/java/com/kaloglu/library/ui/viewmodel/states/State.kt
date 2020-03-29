package com.kaloglu.library.ui.viewmodel.states

import com.kaloglu.library.ui.models.ErrorModel
import java.util.*

interface State {
    val value: StateValues
    val valueInt: Int
        get() = value.value
            ?: throw MissingFormatArgumentException("should override #valueInt on state class for custom states")

    val error: ErrorModel?
        get() = null

    val loading: Boolean
        get() = false

    enum class StateValues(val value: Int? = 0) {
        EMPTY(300),
        DONE(200),
        LOADING(100),
        INIT(0),
        ERROR(-100),
        CUSTOM(null)
    }

    interface UiState : State {
        interface Init : UiState {
            override val loading: Boolean
                get() = true

            override val value
                get() = StateValues.INIT
        }

        interface Loading : UiState {
            override val loading: Boolean
                get() = true

            override val value
                get() = StateValues.LOADING
        }

        interface Empty : UiState {
            override val value
                get() = StateValues.EMPTY
        }

        interface Done : UiState {
            override val value
                get() = StateValues.DONE
        }

        interface Error : UiState {
            override val error: ErrorModel
            override val value
                get() = StateValues.ERROR
        }

        /**
         *  usage :
         *      class CustomState : State.CustomUi {
         *          override val valueInt: Int
         *              get() = 999
         *      }
         * */
        interface CustomUi : UiState {
            override val value
                get() = StateValues.CUSTOM
        }
    }

}
