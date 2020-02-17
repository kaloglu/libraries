package com.kaloglu.library.ui.interfaces

interface ActivityLifecycle {
    fun beforeOnCreate() = Unit

    fun initUserInterface()

}