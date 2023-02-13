package com.example.dogo_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogo_profile.databinding.FragmentCmntBinding

class CmntFragment:Fragment() {
    private lateinit var viewBinding: FragmentCmntBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentCmntBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}