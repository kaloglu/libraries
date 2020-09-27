package com.kaloglu.library.databinding4vm.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.kaloglu.library.databinding4vm.BindableViewModel
import com.kaloglu.library.databinding4vm.inflateViewBinding
import com.kaloglu.library.databinding4vm.interfaces.DataBindingDialog
import com.kaloglu.library.viewmodel.dialogFragments.ViewModelDialogFragment
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class BindingDialogFragment<VDB, VM, E, S> @ContentView
constructor(@LayoutRes override val resourceLayoutId: Int = 0) :
    ViewModelDialogFragment<VM, E, S>(),
    DataBindingDialog<VDB, VM, E, S>
        where VDB : ViewDataBinding, VM : BindableViewModel<E, S>, E : Event, S : State {

    override lateinit var viewDataBinding: VDB

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflateViewBinding<VDB>(parent, resourceLayoutId) {
        setVariable(getBindingVariable(), viewModel)
        viewDataBinding = this
    }.root

}

