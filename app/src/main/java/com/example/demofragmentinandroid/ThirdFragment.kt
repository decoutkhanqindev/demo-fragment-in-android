package com.example.demofragmentinandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.demofragmentinandroid.databinding.FragmentFirstBinding
import com.example.demofragmentinandroid.databinding.FragmentSecondBinding

class ThirdFragment : BaseFragment() {
    private var _binding: FragmentSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logMessage("onCreateView called")
        _binding = FragmentSecondBinding.inflate(
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
//            parentFragmentManager.popBackStack() // 3 to 2
            parentFragmentManager.popBackStack("1 to 2", FragmentManager.POP_BACK_STACK_INCLUSIVE) // 3 to 1
        }
    }

    // k nen tham chieu toi view nua
    override fun onDestroyView() {
        _binding = null // huy binding -> tranh memory leaks
        super.onDestroyView()
    }
}