package com.rockokechukwu.e_bookrecomender.utilities.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdaptor: RecyclerView.Adapter<AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType,
             parent, false )

        return AppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {

        val obj = getObjForPosition(position)
        holder.bind(obj)

    }

    override fun getItemViewType(position: Int) = getLayoutIdForPosition(position)


    abstract fun getObjForPosition(position: Int)

    /*generate layout ID for position, so it support different layout types depending on position*/
    abstract fun getLayoutIdForPosition(position: Int): Int


}