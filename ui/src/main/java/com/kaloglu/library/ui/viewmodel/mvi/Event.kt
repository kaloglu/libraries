package com.kaloglu.library.ui.viewmodel.mvi

import java.util.*

interface Event {

    enum class EventType(val value: Int? = 0) {
        INIT(0),
        DONE(1),
        CUSTOM(null)
    }

    val type: EventType
    val value: Int
        get() = type.value
            ?: throw MissingFormatArgumentException("should override #valueInt on state class for custom states")


    interface Init : Event {
        override val type
            get() = EventType.INIT
    }

    interface Done : Event {
        override val type
            get() = EventType.DONE
    }


    interface Custom : Event {
        override val type
            get() = EventType.CUSTOM
    }
}