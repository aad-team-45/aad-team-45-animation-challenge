package com.rockokechukwu.e_bookrecomender.ui.ebookdetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rockokechukwu.e_bookrecomender.R

/**
 * A simple [Fragment] subclass.
 */
class EbookDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ebook_detail, container, false)
    }


}
