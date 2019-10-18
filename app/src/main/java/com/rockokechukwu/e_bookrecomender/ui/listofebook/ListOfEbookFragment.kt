package com.rockokechukwu.e_bookrecomender.ui.listofebook

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rockokechukwu.e_bookrecomender.R

class ListOfEbookFragment : Fragment() {

    companion object {
        fun newInstance() =
            ListOfEbookFragment()
    }

    private lateinit var viewModel: ListOfEbookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListOfEbookViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
