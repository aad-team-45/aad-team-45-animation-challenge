package com.rockokechukwu.e_bookrecomender.ui.listofebook

import com.rockokechukwu.e_bookrecomender.utilities.recyclerview.BaseAdaptor

/*
* recyclerView Adaptor for [ListOfEbookFragment]*/

class EbookItemAdaptor(private val layoutId : Int):
    BaseAdaptor() {

    private var data: List<EbookItem> = emptyList()

    override fun getLayoutIdForPosition(position: Int) = layoutId

    override fun getObjForPosition(position: Int) = data[position]

    override fun getItemCount() = if (data.isEmpty()) 0  else data.size

    /* updates the data for the recyclerView*/
    fun setData(currentData: List<EbookItem>){

        data = currentData
        notifyDataSetChanged()
    }
}