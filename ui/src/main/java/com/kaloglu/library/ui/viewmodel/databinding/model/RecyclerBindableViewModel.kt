package com.kaloglu.library.ui.viewmodel.databinding.model

import androidx.databinding.Bindable
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.databinding.BindableViewModel
import com.kaloglu.library.ui.viewmodel.states.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
abstract class RecyclerBindableViewModel<M : Any, S : State>(application: BaseApplication) :
    BindableViewModel<M, S>(application), RecyclerItem {

    @get:Bindable
    abstract override var layoutId: Int

}
