package com.umc.dogo.sign

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.umc.dogo.R
import com.umc.dogo.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //프로필 설정 페이지로 이동
        binding.joinNextBtn.setOnClickListener{
            val intent = Intent(this, SetupActivity::class.java)
            startActivity(intent)
            finish()
        }
        
        //다음 버튼 활성화
        setNext()
    }

    private fun setNext() {
        if (binding.joinEmailEt.text.toString().isEmpty()) {
//            Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
            Log.d("입력여부", "미입력")
        }
        else if (binding.joinPwEt.text.toString().isEmpty()) {
            Log.d("입력여부", "미입력")
        }
        else if (binding.joinPwcheckEt.text.toString().isEmpty()) {
            Log.d("입력여부", "미입력")
        }
        else if (binding.joinNameEt.text.toString().isEmpty()) {
            Log.d("입력여부", "미입력")
        }
        else {
            binding.joinNextBtn.setBackgroundResource(R.drawable.img_next)
            binding.joinNextBtn.isEnabled = true
            Log.d("활성화여부", "활성화")
            return
        }
//        !(binding.joinEmailEt.text.toString().isEmpty() and binding.joinPwEt.text.toString().isEmpty() and binding.joinPwcheckEt.text.toString().isEmpty() and binding.joinNameEt.text.toString().isEmpty())
    }
}