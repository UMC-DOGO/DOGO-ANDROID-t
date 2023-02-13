package com.example.dogo_profile

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class McVAdapter(fragment:Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int =2

    override fun createFragment(position: Int): Fragment {
       return when (position) {
           0 -> CmntFragment()
           1 -> MktFragment()
           else -> CmntFragment()
       }

    }

}