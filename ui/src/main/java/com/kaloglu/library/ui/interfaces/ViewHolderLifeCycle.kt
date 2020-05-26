package com.kaloglu.library.ui.interfaces

interface ViewHolderLifeCycle {
    fun onCreated()
    fun onAttach()
    fun onDetach()
    fun onDestroyed()
}
