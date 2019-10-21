package com.rockokechukwu.e_bookrecomender.ui.listofebook


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.rockokechukwu.e_bookrecomender.R
import com.rockokechukwu.e_bookrecomender.binding.FragmentDataBindingComponent
import com.rockokechukwu.e_bookrecomender.databinding.FragmentListOfEbookBinding
import com.rockokechukwu.e_bookrecomender.dependencyinjection.Injectable
import com.rockokechukwu.e_bookrecomender.repository.AppExecutors
import com.rockokechukwu.e_bookrecomender.utilities.autoCleared
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ListOfEbookFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var appExecutors: AppExecutors

    val listOfEbookViewModel: ListOfEbookViewModel by viewModels {
        viewModelFactory
    }

    var binding by autoCleared<FragmentListOfEbookBinding>()

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val dataBinding = DataBindingUtil.inflate<FragmentListOfEbookBinding>(
            inflater,
            R.layout.fragment_list_of_ebook,
            container,
            false
        )

        binding = dataBinding

        return dataBinding.root
    }


}
