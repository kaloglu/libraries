package com.kaloglu.library.viewmodel.dialogFragments

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.kaloglu.library.ui.dialogFragments.BaseDialogFragment
import com.kaloglu.library.viewmodel.BaseViewModel
import com.kaloglu.library.viewmodel.interfaces.MvvmDialogLifeCycle
import com.kaloglu.library.viewmodel.mvi.State

abstract class ViewModelDialogFragment<VM, S>(@LayoutRes override val resourceLayoutId: Int = 0) :
    BaseDialogFragment(resourceLayoutId),
    MvvmDialogLifeCycle<VM, S>
        where  VM : BaseViewModel<*, S>, S : State {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel(viewLifecycleOwner)
    }

}

