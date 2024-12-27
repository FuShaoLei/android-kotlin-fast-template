package com.cellx.android_kotlin_fast_template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.cellx.android_kotlin_fast_template.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        var plusBtn:Button = binding.btnPlus

        plusBtn.setOnClickListener {
            var currentNum = binding.currentNum?:1
            binding.currentNum = ++currentNum
        }


    }
}