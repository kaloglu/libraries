package com.kaloglu.library.ui.viewmodel.model

import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.states.State

abstract class RecyclerViewModel<S : State>(application: BaseApplication) :
    BaseViewModel<S>(application), RecyclerItem {

//    override val parent: RecyclerViewModel? = null

}
