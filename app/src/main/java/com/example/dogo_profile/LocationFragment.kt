package com.example.dogo_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogo_profile.databinding.FragmentLoacatoinBinding


class LocationFragment: Fragment() {
    private lateinit var viewBinding: FragmentLoacatoinBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentLoacatoinBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.backLocation.setOnClickListener{
            (activity as MainActivity).changeFragment(3)
        }

    }
}
