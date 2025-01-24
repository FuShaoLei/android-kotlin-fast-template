package com.cellx.android_kotlin_fast_template.base

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, V : ViewDataBinding>(private val layoutId: Int, private val initialItems: List<T> = emptyList()) :
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder<V>>() {


    private val items = mutableListOf<T>()
    init {
        if (!initialItems.isNullOrEmpty()) {
            items.addAll(initialItems)
        }
    }



    @SuppressLint("NotifyDataSetChanged")
    fun addData(newItems: List<T>) {
        if (newItems.isEmpty()) return

        val startPosition = itemCount
        items.addAll(newItems)
        notifyItemRangeInserted(startPosition, newItems.size)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearData() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<V> {

        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: V = DataBindingUtil.inflate(inflater, layoutId, parent, false)

        return BaseViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<V>, position: Int) {

        if(itemCount > 0) {
            val currentData = items[position]
            onBind(holder, currentData)
        }

    }


    abstract fun onBind(holder: BaseViewHolder<V>, currentData: T)

    class BaseViewHolder<V : ViewDataBinding>(val binding: V) :
        RecyclerView.ViewHolder(binding.root) {
    }
}