package com.kaloglu.library.viewmodel.dialogFragments

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.kaloglu.library.ui.dialogFragments.BaseDialogFragment
import com.kaloglu.library.viewmodel.BaseViewModel
import com.kaloglu.library.viewmodel.interfaces.MvvmDialogLifeCycle

abstract class ViewModelDialogFragment<VM>(@LayoutRes override val resourceLayoutId: Int = 0) :
    BaseDialogFragment(resourceLayoutId),
    MvvmDialogLifeCycle<VM>
        where  VM : BaseViewModel<*, *> {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel(viewLifecycleOwner)
    }

}

