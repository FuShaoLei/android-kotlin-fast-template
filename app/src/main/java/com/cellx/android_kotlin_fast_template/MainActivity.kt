package com.cellx.android_kotlin_fast_template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.cellx.android_kotlin_fast_template.adapter.NormalButtonAdapter
import com.cellx.android_kotlin_fast_template.databinding.ActivityMainBinding
import com.cellx.android_kotlin_fast_template.entity.NormalButton
import com.cellx.android_kotlin_fast_template.model.GitHubViewModel
import com.cellx.android_kotlin_fast_template.utils.createItemDecoration

class MainActivity : AppCompatActivity() {
    private val viewModel: GitHubViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding


    private val adapter = NormalButtonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.addItemDecoration(createItemDecoration())


        val list = listOf(
            NormalButton("请求数据"),
            NormalButton("列表"),
            NormalButton("MMKV测试")
        )

        binding.recyclerview.adapter = adapter

        adapter.addData(list)


    }

    private fun unused() {
        //        var plusBtn: Button = binding.btnPlus

//        plusBtn.setOnClickListener {
//            var currentNum = binding.currentNum ?: 1
//            binding.currentNum = ++currentNum
//        }
//
//
//        binding.btnRequest.setOnClickListener {
//            Log.e("555 => ", "request start...")
//
//
//            viewModel.fetchRepositories()
//        }

//        viewModel.repositories.observe(this) { repositories->
//            Log.e("fuck => ", "observe this work !")
//            if (repositories != null) {
//                Toast.makeText(this, "Success !", Toast.LENGTH_SHORT).show()
//                Log.e("fuck => ", "repositories.toString() = ${repositories.toString()}")
//
//            } else {
//                Toast.makeText(this, "No repositories found", Toast.LENGTH_SHORT).show()
//            }
//        }
    }

}