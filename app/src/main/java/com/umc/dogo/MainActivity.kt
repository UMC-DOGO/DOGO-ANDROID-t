package com.umc.dogo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.layout_nav_bottom, HomeFragment())
            .commit()


        nav_main_bottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_main_bottom_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_nav_bottom, HomeFragment()).commit()
                }

                R.id.nav_menu_bottom_community -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_nav_bottom, CommunityFragment()).commit()
                }
                R.id.nav_menu_bottom_map -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_nav_bottom, MapFragment()).commit()
                }
                R.id.nav_menu_bottom_chat -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_nav_bottom, ChatFragment()).commit()
                }
                R.id.nav_menu_bottom_myinfo -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_nav_bottom, MyInfoFragment()).commit()
                }
            }

            true
        }
    }
}