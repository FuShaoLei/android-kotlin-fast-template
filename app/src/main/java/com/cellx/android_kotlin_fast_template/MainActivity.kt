package com.cellx.android_kotlin_fast_template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.cellx.android_kotlin_fast_template.adapter.NormalButtonAdapter
import com.cellx.android_kotlin_fast_template.base.BaseActivity
import com.cellx.android_kotlin_fast_template.databinding.ActivityMainBinding
import com.cellx.android_kotlin_fast_template.demo.activity.MMKVActivity
import com.cellx.android_kotlin_fast_template.entity.NormalButton
import com.cellx.android_kotlin_fast_template.model.GitHubViewModel
import com.cellx.android_kotlin_fast_template.utils.createItemDecoration
import com.cellx.android_kotlin_fast_template.utils.jump

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: GitHubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rootbinding.recyclerview.layoutManager = LinearLayoutManager(this)
        rootbinding.recyclerview.addItemDecoration(createItemDecoration(bottom = 0))

        rootbinding.recyclerview.adapter = NormalButtonAdapter(
            listOf(
                NormalButton("请求数据") { Log.e(TAG, "请求数据 fuck !!!") },
                NormalButton("列表") { Toast.makeText(this, "wtf", Toast.LENGTH_SHORT).show() },
                NormalButton("MMKV测试") {
                    jump<MMKVActivity>()
                }
            )
        )

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