package com.cellx.android_kotlin_fast_template.base

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

open class BaseActivity : AppCompatActivity() {

    protected open val TAG: String =  "${this::class.simpleName} =>" ?: "BaseActivity"

    protected lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context = this

    }



}