package com.kaloglu.library.ui.viewmodel.model

import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.states.State

abstract class RecyclerViewModel<S : State> : BaseViewModel<S>(), RecyclerItem {

//    override val parent: RecyclerViewModel? = null

}
