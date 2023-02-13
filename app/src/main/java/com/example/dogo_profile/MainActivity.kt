package com.example.dogo_profile

import android.Manifest
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dogo_profile.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    companion object{
        const val REVIEW_MIN_LENGTH =10
        const val REQ_GALLERY = 1

    }

    // 갤러리 선택 이미지 결과값
    private val imageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
            result ->
        if(result.resultCode == RESULT_OK){

            val imageUri = result.data?.data
            imageUri.let{


                Glide.with(this)
                    .load(imageUri)
                    .fitCenter()
                    .apply(RequestOptions().override(500,500))
                    .into(findViewById(R.id.iv_profile))
            }
        }
    }


    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)






        // Bottom nav
        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.containerFragment.id, HomeFragment())
            .commitAllowingStateLoss()

        viewBinding.navBottom.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_home -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }

                    R.id.menu_profile -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, ProfileFragment())
                            .commit()
                    }

                }
                true
            }
            selectedItemId = R.id.menu_home
        }

    }


    //Fragment 이동
    fun changeFragment(index: Int){
        when(index){
            //내가 쓴글
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_fragment, MycontentFragment())
                    .commit()
            }
            //스크랩
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_fragment, ScrapFragment())
                    .commit()
            }
            //프로필
            3 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_fragment, ProfileFragment())
                    .commit()
            }
            //위치검색
            4 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_fragment, LocationFragment())
                    .commit()
            }
        }
    }



    //갤러리 접근 함수
    fun selectGallery(){
        val writePermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val readPermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)

        if(writePermission == PackageManager.PERMISSION_DENIED ||
            readPermission == PackageManager.PERMISSION_DENIED) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ), REQ_GALLERY
            )
        }else{
            val intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*"
            )
            imageResult.launch(intent)
        }
    }


}