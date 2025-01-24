package com.cellx.android_kotlin_fast_template.adapter

import com.cellx.android_kotlin_fast_template.R
import com.cellx.android_kotlin_fast_template.base.BaseAdapter
import com.cellx.android_kotlin_fast_template.databinding.AdapterButtonBinding
import com.cellx.android_kotlin_fast_template.entity.NormalButton

class NormalButtonAdapter(private val initialItems:List<NormalButton>):BaseAdapter<NormalButton, AdapterButtonBinding>(R.layout.adapter_button, initialItems) {
    override fun onBind(holder: BaseViewHolder<AdapterButtonBinding>, currentData: NormalButton) {
        holder.binding.data = currentData
    }
}