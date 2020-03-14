package com.kaloglu.library.ui

import java.io.Serializable

interface BaseModel : Serializable {
    fun <T : Any> getID(): T

    @Suppress("CovariantEquals")
    fun <T : BaseModel> equals(obj2: T): Boolean
}

