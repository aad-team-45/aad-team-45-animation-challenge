package com.rockokechukwu.e_bookrecomender.dependencyinjection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rockokechukwu.e_bookrecomender.ui.ebookdetail.EbookDetailViewModel
import com.rockokechukwu.e_bookrecomender.ui.listofebook.ListOfEbookViewModel
import com.rockokechukwu.e_bookrecomender.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(EbookDetailViewModel::class)
    abstract fun bindEbookDetailViewModel(ebookDetailViewModel: EbookDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListOfEbookViewModel::class)
    abstract fun bindListOfEbookViewModel(listOfEbookViewModel: ListOfEbookViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}