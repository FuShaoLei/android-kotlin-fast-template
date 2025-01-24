package com.cellx.android_kotlin_fast_template.app

import android.app.Application
import android.content.Context
import com.tencent.mmkv.MMKV

class App:Application() {

    companion object {
        lateinit var appContext: Context
    }



    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext

        MMKV.initialize(this)

    }
}