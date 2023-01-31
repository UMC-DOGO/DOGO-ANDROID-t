package com.umc.dogo.sign

import android.R
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.umc.dogo.databinding.ActivitySetupBinding


class SetupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySetupBinding

    var list_of_gender = arrayOf("여자", "남자")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //도로명 주소 페이지로
//        binding.setupAddressEt.setOnClickListener(View.OnClickListener {
//            //인터넷 연결 확인
//            val status: Int = NetworkStatus.getConnectivityStatus(getContext())
//            if (status == NetworkStatus.TYPE_MOBILE || status == NetworkStatus.TYPE_WIFI) {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id., AddressWebFragment).commitAllowingStateLoss()
//            } else {
//                Snackbar.make(binding.root, "인터넷 연결을 확인해주세요.", Snackbar.LENGTH_SHORT).show()
//            }
//        })

        //입력 박스
        setSpinner()

        //개인정보동의 페이지로 이동
        binding.setupNextBtn.setOnClickListener{
            val intent = Intent(this, ConsentActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    object NetworkStatus {
        const val TYPE_WIFI = 1
        const val TYPE_MOBILE = 2
        const val TYPE_NOT_CONNECTED = 3
        fun getConnectivityStatus(context: Context): Int {
            val manager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = manager.activeNetworkInfo
            if (networkInfo != null) {
                val type = networkInfo.type
                if (type == ConnectivityManager.TYPE_MOBILE) { //모바일 (LTE, 5G)
                    return TYPE_MOBILE
                } else if (type == ConnectivityManager.TYPE_WIFI) { //WIFI
                    return TYPE_WIFI
                }
            }
            return TYPE_NOT_CONNECTED //연결 X
        }
    }

    private fun setSpinner(){
        binding.setupGenderEt.adapter = ArrayAdapter(this,  com.umc.dogo.R.layout.shape_select, resources.getStringArray(com.umc.dogo.R.array.gender))
//        binding.setupGenderEt.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                if(p2 == 0){
//                    Log.d("선택", "no")
//                } else{
//                    Log.d("선택", binding.setupGenderEt.toString())
//                }
//            }
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//            }
//
//        }
        binding.setupDogEt.adapter = ArrayAdapter(this, com.umc.dogo.R.layout.shape_select, resources.getStringArray(com.umc.dogo.R.array.spinner_dog))
//        binding.setupDogEt.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                if(p2 == 0){
//                    Log.d("선택", "no")
//                } else{
//                    Log.d("선택", binding.setupDogEt.getItemAtPosition(p2).toString())
//                }
//            }
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//            }
//
//        }
    }
}