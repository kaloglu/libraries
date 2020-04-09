package com.kaloglu.library.ui.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.ui.interfaces.DialogFragmentLifecycle

abstract class BaseDialogFragment @ContentView constructor(
        @LayoutRes internal open val resourceLayoutId: Int = 0
) : DialogFragment(), DialogFragmentLifecycle {

    override lateinit var containerView: View

    override val activity by lazy { getActivity() as BaseActivity }
    override val application by lazy { activity.application }
    override val fragmentTag = this.javaClass.simpleName
    override val dialogTitle: String? = null

    final override fun initUserInterface(savedInstanceState: Bundle?) {
        dialog?.let {
            it.setOnShowListener {
                dialogTitle?.let { dialog?.setTitle(it) }
                dialog?.window?.setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
            initUserInterface(it)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(resourceLayoutId, parent)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        containerView = view
        super.onViewCreated(view, savedInstanceState)
        initUserInterface(savedInstanceState)
    }

}


