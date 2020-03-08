package com.kaloglu.library.ui.viewmodel

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.kaloglu.library.ui.BaseFragment
import com.kaloglu.library.ui.viewmodel.interfaces.Mwwm

abstract class ViewModelFragment<VM : BaseViewModel<*>>(
    @LayoutRes override val resourceLayoutId: Int = 0
) : BaseFragment(resourceLayoutId), Mwwm<VM> {
    override lateinit var viewModel: VM

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateViewModel()
    }

    override fun onCreateViewModel() {
        viewModel = activity.getViewModel(application, viewModel::class.java)
        viewModel.observeViewModel()
    }

}
