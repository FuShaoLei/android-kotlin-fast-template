package com.cellx.android_kotlin_fast_template.api

import com.cellx.android_kotlin_fast_template.entity.TestData
import retrofit2.http.GET

interface TestService {

    @GET("/todos/1")
    suspend fun get1(): TestData
}