package com.example.demofragmentinandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.demofragmentinandroid.databinding.FragmentFirstBinding
import com.example.demofragmentinandroid.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment() {
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
            parentFragmentManager.commit {
                replace<ThirdFragment>(
                    containerViewId = R.id.fragmentContainerView,
                    args = bundleOf("source" to "first fragment ")
                )
                addToBackStack("2 to 3")
            }
        }
    }

    // k nen tham chieu toi view nua
    override fun onDestroyView() {
        _binding = null // huy binding -> tranh memory leaks
        super.onDestroyView()
    }
}