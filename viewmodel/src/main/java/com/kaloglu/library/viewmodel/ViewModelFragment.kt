package com.kaloglu.library.viewmodel

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.kaloglu.library.ui.BaseFragment
import com.kaloglu.library.viewmodel.interfaces.MvvmLifeCycle

abstract class ViewModelFragment<VM>(@LayoutRes override val resourceLayoutId: Int = 0) :
    BaseFragment(resourceLayoutId),
    MvvmLifeCycle<VM>
        where  VM : BaseViewModel<*, *> {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel(viewLifecycleOwner)
    }

}
