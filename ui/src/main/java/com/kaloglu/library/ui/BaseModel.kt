package com.kaloglu.library.ui

import java.io.Serializable

interface BaseModel : Serializable {
    fun <T : Any> getId(): T
}

