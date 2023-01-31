package com.umc.dogo

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_main_resell.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainCommunity : Fragment() {
    private var param1: String? = null
    private var param2: String? = null



    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        var view: View = inflater.inflate(com.umc.dogo.R.layout.fragment_main_community, container, false)
    return view;
}

    fun newInstant() : MainCommunity
    {
        val args = Bundle()
        val frag = MainCommunity()
        frag.arguments = args
        return frag
    }

}