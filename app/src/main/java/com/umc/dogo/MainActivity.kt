package com.umc.dogo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.umc.dogo.chatting.ChattingFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

    private var backKeyPressTime : Long = 0

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
                        .replace(R.id.layout_nav_bottom, ChattingFragment()).commit()
                }
                R.id.nav_menu_bottom_myinfo -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_nav_bottom, MyInfoFragment()).commit()
                }
            }

            true
        }
    }

    override fun onBackPressed() {
        val toast = Toast.makeText(this, "뒤로 가기를 한 번 더 누르면 종료됩니다", Toast.LENGTH_SHORT)
        if (System.currentTimeMillis() > backKeyPressTime + 2500) {
            backKeyPressTime = System.currentTimeMillis()
            toast.show()
            return
        }
        if (System.currentTimeMillis() <= backKeyPressTime + 2500) {
            toast.cancel()
            finishAffinity()
        }
    }
}