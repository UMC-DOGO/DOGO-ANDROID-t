package com.example.dogo_profile


import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dogo_profile.databinding.FragmentProfileBinding
import java.io.File
import java.util.jar.Manifest
import android.widget.ArrayAdapter as ArrayAdapter


class ProfileFragment: Fragment() {




    private lateinit var viewBinding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        viewBinding = FragmentProfileBinding.inflate(layoutInflater)
        return viewBinding.root




    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.cstMycontent.setOnClickListener {
            (activity as MainActivity).changeFragment(1)

        }

        viewBinding.cstScrap.setOnClickListener {
            (activity as MainActivity).changeFragment(2)
        }

        viewBinding.btnLocation.setOnClickListener{
            (activity as MainActivity).changeFragment(4)
        }

        val items = arrayOf("여자","남자")



        viewBinding.spSex.adapter= ArrayAdapter.createFromResource(activity as MainActivity,R.array.ownerSex,android.R.layout.simple_spinner_dropdown_item)

        viewBinding.ivEdit.setOnClickListener{
            (activity as MainActivity).selectGallery()
        }



        }
    }
