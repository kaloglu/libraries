package com.kaloglu.library.ui

import android.os.Bundle
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.kaloglu.library.ui.interfaces.ActivityLifecycle

abstract class BaseActivity @ContentView constructor(
    @LayoutRes internal val resourceLayoutId: Int = 0
) : AppCompatActivity(resourceLayoutId), ActivityLifecycle {
    override val application by lazy { getApplication() as BaseApplication }
    
    final override fun onCreate(savedInstanceState: Bundle?) {
        beforeOnCreate()

        super.onCreate(savedInstanceState)

        initUserInterface()
    }

}

