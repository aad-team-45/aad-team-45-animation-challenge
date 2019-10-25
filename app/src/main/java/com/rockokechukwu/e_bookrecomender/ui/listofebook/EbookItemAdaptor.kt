package com.rockokechukwu.e_bookrecomender.ui.listofebook

import com.rockokechukwu.e_bookrecomender.api.response.Ebook
import com.rockokechukwu.e_bookrecomender.utilities.recyclerview.BaseAdaptor

/*
* recyclerView Adaptor for [ListOfEbookFragment]*/

class EbookItemAdaptor(private val layoutId : Int):
    BaseAdaptor() {

    private var data: List<Ebook>? = null

    override fun getLayoutIdForPosition(position: Int) = layoutId

    override fun getObjForPosition(position: Int) = data?.get(position) as Ebook

    override fun getItemCount() = data?.size ?: 0

    /* updates the data for the recyclerView*/
    fun setData(currentData: List<Ebook>){

        data = currentData
        notifyDataSetChanged()
    }
}