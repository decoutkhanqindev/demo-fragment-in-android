package com.example.demofragmentinandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demofragmentinandroid.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment() {
    private var _binding: FragmentFirstBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logMessage("name is ${arguments?.getString("name")}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logMessage("onCreateView called")
        _binding = FragmentFirstBinding.inflate(
            /* inflater = */ inflater,
            /* parent = */ container,
            /* attachToParent = */ false
        )
        return _binding!!.root
    }

    // lam viec voi view
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding!!.btn.text = "Click me <3"
        _binding!!.btn.setOnClickListener {
            logMessage("Button clicked")
        }
    }

    // k nen tham chieu toi view nua
    override fun onDestroyView() {
        _binding = null // huy binding -> tranh memory leaks
        super.onDestroyView()
    }
}