[![](https://jitpack.io/v/kaloglu/libraries.svg)](https://jitpack.io/#kaloglu/libraries) [![](https://jitci.com/gh/kaloglu/libraries/svg)](https://jitci.com/gh/kaloglu/libraries)

**Wiki for databinding4vm**
* [Home](https://github.com/kaloglu/libraries/wiki/Home)
* [BindingFragment](https://github.com/kaloglu/libraries/wiki/BindingFragment)
* [BindableViewModel](https://github.com/kaloglu/libraries/wiki/BindableViewModel)
* [DataBoundRecyclerAdapter](https://github.com/kaloglu/libraries/wiki/DataBoundRecyclerAdapter)
* [Interractors](https://github.com/kaloglu/libraries/wiki/Interractors)
* [States & Events for MVI](https://github.com/kaloglu/libraries/wiki/States-&-Events-for-MVI)

---
This is an experimental project which aims to help developers to build android apps with less boilerplate code.

**You are welcome to open issues or PRs**

**ktx:1.1.0** = Useful extensions, needed in every Android project. 
* _Currently_ : date, string, simple animations for view, etc.
* _In Progress_ :  fragment, dialog, adapter and more...
```gradle
    implementation 'com.github.kaloglu.libraries:ktx:latestVersion'
```
**ui:1.1.0** = Provides ready-to-use base classes with default implementations, you can extend recycler items and define their actions easily or just give a layout and let the library handle your dialogs.
```gradle
    implementation 'com.github.kaloglu.libraries:ktx:latestVersion' //required
    implementation 'com.github.kaloglu.libraries:ui:latestVersion'
```

**viewmodel:1.1.0** = (**Experimental**) Provides DataBinding abilities for other libraries. With combination of these libraries, you can create RecyclerViews with just one line of code or any changes in ViewModel automatically triggers data binding methods. You can reduce the amount of code you need to write 
```gradle
    implementation 'com.github.kaloglu.libraries:ktx:latestVersion' //required
    implementation 'com.github.kaloglu.libraries:ui:latestVersion' //required
    implementation 'com.github.kaloglu.libraries:viewmodel:latestVersion'
```
**databinding4vm:1.1.0** = (**Experimental**) Provides DataBinding abilities for other libraries. With combination of these libraries, you can create RecyclerViews with just one line of code, any changes in ViewModel automatically triggers data binding methods
```gradle
    implementation 'com.github.kaloglu.libraries:ktx:latestVersion' //required
    implementation 'com.github.kaloglu.libraries:ui:latestVersion' //required
    implementation 'com.github.kaloglu.libraries:viewmodel:latestVersion' //required
    implementation 'com.github.kaloglu.libraries:databinding4vm:latestVersion'
```

Full sample for databinding4vm : https://github.com/kaloglu/androtweet
