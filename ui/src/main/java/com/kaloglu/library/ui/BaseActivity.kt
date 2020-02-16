package com.kaloglu.library.ui

import android.os.Bundle
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity @ContentView constructor(
    @LayoutRes internal val resourceLayoutId: Int = 0
) : AppCompatActivity(resourceLayoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }

    protected abstract fun init()

}
