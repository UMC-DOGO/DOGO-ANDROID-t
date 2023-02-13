package com.example.dogo_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogo_profile.databinding.FragmentMycontextBinding
import com.google.android.material.tabs.TabLayoutMediator

class MycontentFragment :Fragment() {
    private lateinit var viewBinding: FragmentMycontextBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentMycontextBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mcVAdapter = McVAdapter(this)
        viewBinding.vpMyContent.adapter=mcVAdapter

        val tabTitleArray = arrayOf(
            "커뮤니티",
            "중고마켓",

        )
        //TabLayout 연동
        TabLayoutMediator(viewBinding.tabMyContext, viewBinding.vpMyContent){tab,position->
            tab.text = tabTitleArray[position]
        }.attach() //연결

        viewBinding.backMycontent.setOnClickListener{
            (activity as MainActivity).changeFragment(3)
        }
    }

}