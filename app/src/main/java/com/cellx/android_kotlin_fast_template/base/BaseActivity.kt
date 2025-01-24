package com.cellx.android_kotlin_fast_template.base

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cellx.android_kotlin_fast_template.R
import com.cellx.android_kotlin_fast_template.databinding.ActivityMainBinding

abstract class BaseActivity<V : ViewDataBinding>(private val layoutId: Int) : AppCompatActivity() {

    protected open val TAG: String =  "${this::class.simpleName} =>" ?: "BaseActivity"

    protected lateinit var context: Context

    protected lateinit var rootbinding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this

        rootbinding = DataBindingUtil.setContentView(this, layoutId)


    }



}