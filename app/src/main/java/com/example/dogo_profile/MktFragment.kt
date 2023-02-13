package com.example.dogo_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogo_profile.databinding.FragmentMktBinding

class MktFragment:Fragment() {
    private lateinit var viewBinding: FragmentMktBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentMktBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}