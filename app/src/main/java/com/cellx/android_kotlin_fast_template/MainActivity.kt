package com.cellx.android_kotlin_fast_template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.cellx.android_kotlin_fast_template.api.ServiceCreator
import com.cellx.android_kotlin_fast_template.api.TestService
import com.cellx.android_kotlin_fast_template.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val scope = MainScope()

    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        var plusBtn:Button = binding.btnPlus

        plusBtn.setOnClickListener {
            var currentNum = binding.currentNum?:1
            binding.currentNum = ++currentNum
        }


        binding.btnRequest.setOnClickListener {
            Log.e("555 => ", "request start...")
            fetchData()

        }


    }

    private fun fetchData(){
        scope.launch {
            try {
                val result = ServiceCreator.create<TestService>().get1()

                Log.e("result fuck => ", result.toString())

            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}