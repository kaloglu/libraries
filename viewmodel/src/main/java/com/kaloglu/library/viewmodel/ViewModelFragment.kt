package com.kaloglu.library.viewmodel

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.kaloglu.library.ui.BaseFragment
import com.kaloglu.library.viewmodel.interfaces.MvvmLifeCycle
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class ViewModelFragment<VM, E, S>(@LayoutRes override val resourceLayoutId: Int = 0) :
    BaseFragment(resourceLayoutId), MvvmLifeCycle<VM, E, S>
        where  VM : BaseViewModel<E, S>, E : Event, S : State {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel(viewLifecycleOwner)
    }

}
