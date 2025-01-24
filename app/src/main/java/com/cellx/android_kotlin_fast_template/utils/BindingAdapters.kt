package com.cellx.android_kotlin_fast_template.utils

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @BindingAdapter("statusType")
    @JvmStatic
    fun setStatusType(view: TextView, status: String) {
        view.setPadding(8, 5, 8, 5)
        when (status) {
            "primary" -> {
                view.setTextColor(Color.parseColor("#409eff"))
                view.setBackgroundColor(Color.parseColor("#EBF5FF"))
            }

            "success" -> {
                view.setTextColor(Color.parseColor("#67c23a"))
                view.setBackgroundColor(Color.parseColor("#EFF8EB"))
            }

            "warning" -> {
                view.setTextColor(Color.parseColor("#e6a23c"))
                view.setBackgroundColor(Color.parseColor("#FCF5EB"))
            }

            "danger" -> {
                view.setTextColor(Color.parseColor("#f56c6c"))
                view.setBackgroundColor(Color.parseColor("#FEF0F0"))
            } // info
            else -> {
                view.setTextColor(Color.parseColor("#909399"))
                view.setBackgroundColor(Color.parseColor("#F3F4F4"))
            }
        }
    }

    @BindingAdapter("viewClick")
    @JvmStatic
    fun setViewClick(view: View, onClick: SimpleClickHandler?) {
        onClick?.let { click ->
            view.setOnClickListener {
                click.invoke()
            }
        }
    }
}
