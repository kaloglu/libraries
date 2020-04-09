package com.kaloglu.library.ui

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.kaloglu.library.ui.interfaces.ViewLifecycle

abstract class BaseActivity @ContentView constructor(
    @LayoutRes internal val resourceLayoutId: Int = 0
) : AppCompatActivity(resourceLayoutId), ViewLifecycle {
    override val activity by lazy { this }
    override var containerView: View? = null

    override val application by lazy { getApplication() as BaseApplication }

    final override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        initUserInterface(savedInstanceState)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        containerView = super.onCreateView(name, context, attrs)
        return containerView
    }

}

