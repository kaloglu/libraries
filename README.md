**latestVersion** => [![](https://jitpack.io/v/kaloglu/libraries.svg)](https://jitpack.io/#kaloglu/libraries)


**usage:** 
```groovy
    implementation 'com.github.kaloglu.libraries:ktx:latestVersion'
    implementation 'com.github.kaloglu.libraries:ui:latestVersion'
```


**SAMPLE**

```kotlin
package com.kaloglu.sample

import androidx.databinding.Bindable
import com.kaloglu.library.ui.viewmodel.databinding.BindableViewModel
import com.kaloglu.library.ui.viewmodel.databinding.bindable

class SampleViewModel : BindableViewModel() {

    @get:Bindable
    var saySomeThing by bindable("initializeValue")

    init {
        doSample()
    }

    private fun doSample() {
        // do stuff
    }

}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout>

    <data>

        <variable
            name="dataModel"
            type="com.kaloglu.sample.SampleViewModel" />

    </data>

    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/rootLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SampleFragment">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@{dataModel.saySomething}"
        android:textSize="24sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

```kotlin
package com.kaloglu.sample

import android.os.Bundle
import android.os.Handler
import com.kaloglu.library.ui.viewmodel.databinding.BindingFragment
import com.kaloglu.sample.R
import com.kaloglu.sample.databinding.SampleFragmentBinding
import com.kaloglu.sample.SampleViewModel

class SampleFragment : BindingFragment<SampleFragmentBinding, SampleViewModel>(R.layout.Sample_fragment) {

    override val viewModelClass: Class<SampleViewModel>
        get() = SampleViewModel::class.java

    companion object {
        fun newInstance() = SampleFragment()
    }

    override fun initUserInterface(savedInstanceState: Bundle?) {
        Handler().postDelayed({
            viewModel.saySomething = "Passed 10 seconds!"
        }, 10000)
        // do stuff
    }

}
```
