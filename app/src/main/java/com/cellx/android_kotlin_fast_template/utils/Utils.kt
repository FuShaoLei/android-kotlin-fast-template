package com.cellx.android_kotlin_fast_template.utils

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.RecyclerView
import com.cellx.android_kotlin_fast_template.app.App

typealias ClickHandler<T> = (T) -> Unit

typealias SimpleClickHandler = () -> Unit

fun Int.dp2px(): Int {
    val density = App.appContext.resources.displayMetrics.density

    Log.e("Utils", " density = $density")

    return this * density.toInt()
}

/**
 * 隐藏虚拟键盘
 */
fun customHideKeyboard(activity: Activity) {
    val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    // 获取当前焦点
    val view = activity.currentFocus
    view?.let {
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}


fun RecyclerView.removeAllItemDecoration(): Unit {
    val decorationCount = this.itemDecorationCount
    for (i in decorationCount - 1 downTo 0) {
        this.removeItemDecorationAt(i)
    }
}

fun createItemDecoration(
    left: Int = 6,
    top: Int = left,
    right: Int = left,
    bottom: Int = top
): RecyclerView.ItemDecoration {
    return object : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.apply {
                this.left = left.dp2px()
                this.top = top.dp2px()
                this.right = right.dp2px()
                this.bottom = bottom.dp2px()
            }
        }
    }
}

