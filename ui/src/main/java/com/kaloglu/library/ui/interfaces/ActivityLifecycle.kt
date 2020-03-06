package com.kaloglu.library.ui.interfaces

import com.kaloglu.library.ui.BaseApplication

interface ActivityLifecycle {
    fun beforeOnCreate() = Unit

    fun initUserInterface()

    val application: BaseApplication
}