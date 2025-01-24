package com.cellx.android_kotlin_fast_template.entity

import com.cellx.android_kotlin_fast_template.utils.SimpleClickHandler

data class NormalButton(
    val text: String,
    val onClick: SimpleClickHandler? = null
)