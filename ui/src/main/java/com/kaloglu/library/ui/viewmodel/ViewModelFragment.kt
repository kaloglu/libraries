package com.kaloglu.library.ui.viewmodel

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import com.kaloglu.library.ui.BaseFragment
import com.kaloglu.library.ui.viewmodel.interfaces.Mwwm

abstract class ViewModelFragment<VM : BaseViewModel<*, *>>(
    @LayoutRes override val resourceLayoutId: Int = 0
) : BaseFragment(resourceLayoutId), Mwwm<VM> {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.observeViewModel()
    }
}
