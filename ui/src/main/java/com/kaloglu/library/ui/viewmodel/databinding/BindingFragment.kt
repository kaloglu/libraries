package com.kaloglu.library.ui.viewmodel.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.ViewModelFragment
import com.kaloglu.library.ui.viewmodel.databinding.interfaces.DataBinding

abstract class BindingFragment<VDB : ViewDataBinding, VM : BaseViewModel>
@ContentView constructor(
        @LayoutRes override val resourceLayoutId: Int = 0
) : ViewModelFragment<VM>(), DataBinding<VDB> {

    override lateinit var viewDataBinding: VDB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflateView(inflater, container, savedInstanceState)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeViewModel()
        super.onViewCreated(view, savedInstanceState)

    }

    override fun inflateView(layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        DataBindingUtil.inflate<VDB>(
                layoutInflater,
                resourceLayoutId,
                container,
                false
        ).apply {
            setVariable(getBindingVariable(), viewModel)
            viewDataBinding = this
        }

        return viewDataBinding.root
    }

//    override fun getBindingVariable() = BR.dataModel
    override fun observeViewModel() {
        //vieWModel state observe
    }
}
