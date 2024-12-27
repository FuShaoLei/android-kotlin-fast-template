package com.cellx.android_kotlin_fast_template.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Retrofit构建器
object ServiceCreator {

    const val BASE_URL = "https://jsonplaceholder.typicode.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)

}
