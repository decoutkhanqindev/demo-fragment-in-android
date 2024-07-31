package com.example.demofragmentinandroid

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    private val logTag by lazy(LazyThreadSafetyMode.NONE) {
        this::class.java.simpleName // lay ra name cua context trien khai hien tai
    }

    @CallSuper
    override fun onAttach(context: Context) {
        super.onAttach(context)
        logMessage("onAttach: context=$context")
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logMessage("onCreate: savedInstanceState=$savedInstanceState")
        logMessage("onCreate: arguments=${arguments}")
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logMessage("onViewCreated: view=$view")
        logMessage("onViewCreated: savedInstanceState=$savedInstanceState")
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        logMessage("onStart")
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        logMessage("onResume")
    }

    @CallSuper
    override fun onPause() {
        logMessage("onPause")
        super.onPause()
    }

    @CallSuper
    override fun onStop() {
        logMessage("onStop")
        super.onStop()
    }

    @CallSuper
    override fun onDestroyView() {
        logMessage("onDestroyView")
        super.onDestroyView()
    }

    @CallSuper
    override fun onDestroy() {
        logMessage("onDestroy")
        super.onDestroy()
    }

    @CallSuper
    override fun onDetach() {
        logMessage("onDetach")
        super.onDetach()
    }

    protected fun logMessage(message: String) = Log.d(logTag, "$this: $message")
}