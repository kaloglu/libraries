package com.kaloglu.library.databinding4vm.model

import androidx.databinding.Bindable
import androidx.databinding.PropertyChangeRegistry
import com.kaloglu.library.databinding4vm.interfaces.BindableField
import com.kaloglu.library.ui.RecyclerItem

abstract class RecyclerBindableItem() : RecyclerItem, BindableField {

    @Transient
    override var mCallbacks: PropertyChangeRegistry? = null

    @get:Bindable
    abstract override var layoutId: Int

}

