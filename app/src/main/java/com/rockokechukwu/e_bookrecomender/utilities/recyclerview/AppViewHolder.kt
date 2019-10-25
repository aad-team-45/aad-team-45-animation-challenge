package com.rockokechukwu.e_bookrecomender.utilities.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.rockokechukwu.e_bookrecomender.BR

class AppViewHolder( private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: Any){
        binding.apply {
            setVariable(BR.obj, obj)
            executePendingBindings()
        }
    }
}