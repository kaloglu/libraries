package com.kaloglu.library.viewmodel

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.kaloglu.library.ui.BaseFragment
import com.kaloglu.library.viewmodel.interfaces.MvvmLifeCycle
import com.kaloglu.library.viewmodel.mvi.State

abstract class ViewModelFragment<VM, S>(@LayoutRes override val resourceLayoutId: Int = 0) :
    BaseFragment(resourceLayoutId),
    MvvmLifeCycle<VM, S>
        where  VM : BaseViewModel<*, S>, S : State {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel(viewLifecycleOwner)
    }

}
