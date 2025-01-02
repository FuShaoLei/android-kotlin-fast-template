package com.cellx.android_kotlin_fast_template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.cellx.android_kotlin_fast_template.api.ServiceCreator
import com.cellx.android_kotlin_fast_template.api.TestService
import com.cellx.android_kotlin_fast_template.databinding.ActivityMainBinding
import com.cellx.android_kotlin_fast_template.model.GitHubViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: GitHubViewModel by viewModels()

    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        var plusBtn: Button = binding.btnPlus

        plusBtn.setOnClickListener {
            var currentNum = binding.currentNum ?: 1
            binding.currentNum = ++currentNum
        }


        binding.btnRequest.setOnClickListener {
            Log.e("555 => ", "request start...")


            viewModel.fetchRepositories()
        }

        viewModel.repositories.observe(this) { repositories->
            Log.e("fuck => ", "observe this work !")
            if (repositories != null) {
                Toast.makeText(this, "Success !", Toast.LENGTH_SHORT).show()
                Log.e("fuck => ", "repositories.toString() = ${repositories.toString()}")

            } else {
                Toast.makeText(this, "No repositories found", Toast.LENGTH_SHORT).show()
            }
        }
    }

}