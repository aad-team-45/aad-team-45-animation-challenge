package com.rockokechukwu.e_bookrecomender.ui.listofebook


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rockokechukwu.e_bookrecomender.R
import com.rockokechukwu.e_bookrecomender.binding.FragmentDataBindingComponent
import com.rockokechukwu.e_bookrecomender.databinding.FragmentListOfEbookBinding
import com.rockokechukwu.e_bookrecomender.dependencyinjection.Injectable
import com.rockokechukwu.e_bookrecomender.repository.AppExecutors
import com.rockokechukwu.e_bookrecomender.utilities.autoCleared
import com.rockokechukwu.e_bookrecomender.utilities.hide
import com.rockokechukwu.e_bookrecomender.utilities.show
import com.rockokechukwu.e_bookrecomender.vo.Status
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_list_of_ebook.*
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)
    }

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

        val adaptor = EbookItemAdaptor(R.layout.ebook_item)

        binding = dataBinding


        retrieveUiData(binding, adaptor)

        return dataBinding.root
    }

    private fun retrieveUiData(binding: FragmentListOfEbookBinding, adaptor: EbookItemAdaptor){
        var fakeData = listOf<EbookItem>(EbookItem(listOf("cat beko", " ez lada"), "The lost book of Gundor"),
            EbookItem(listOf("esildor beko", " baku domica"), "The lost book of Gundor"),
            EbookItem(listOf("esildor beko", " baku domica"), "The lost book of Gundor")
            )

        binding.recyclerview.adapter = adaptor

        adaptor.setData(fakeData)

        listOfEbookViewModel.results.observe(viewLifecycleOwner, Observer {
            result ->

            when(result.status){
                Status.SUCCESS_DB  -> {
                    binding.progressbar.hide()
                }

                Status.SUCCESS_NETWORK -> {
                    binding.progressbar.hide()
                }

                Status.LOADING -> {
                    binding.progressbar.show()
                }

                Status.ERROR -> {
                    binding.progressbar.hide()
                }
            }
        })
    }



}
