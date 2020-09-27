package com.kaloglu.library.viewmodel.dialogFragments

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.kaloglu.library.ui.dialogFragments.BaseDialogFragment
import com.kaloglu.library.viewmodel.BaseViewModel
import com.kaloglu.library.viewmodel.interfaces.MvvmDialogLifeCycle
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class ViewModelDialogFragment<VM, E, S>(@LayoutRes override val resourceLayoutId: Int = 0) :
    BaseDialogFragment(resourceLayoutId),
    MvvmDialogLifeCycle<VM, E, S>
        where  VM : BaseViewModel<E, S>, E : Event, S : State {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel(viewLifecycleOwner)
    }

}

