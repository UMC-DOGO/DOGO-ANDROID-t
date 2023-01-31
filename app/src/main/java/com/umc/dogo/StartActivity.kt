package com.umc.dogo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.umc.dogo.databinding.ActivitySetupBinding
import com.umc.dogo.databinding.ActivityStartBinding
import com.umc.dogo.sign.JoinActivity
import com.umc.dogo.sign.LoginActivity
import com.umc.dogo.sign.SetupActivity

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}