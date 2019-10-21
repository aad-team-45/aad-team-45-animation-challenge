package com.rockokechukwu.e_bookrecomender.dependencyinjection

import com.rockokechukwu.e_bookrecomender.ui.ebookdetail.EbookDetailFragment
import com.rockokechukwu.e_bookrecomender.ui.ittopics.ItTopicsFragment
import com.rockokechukwu.e_bookrecomender.ui.listofebook.ListOfEbookFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeItTopicsFragment(): ItTopicsFragment

    @ContributesAndroidInjector
    abstract fun contributeListOfEbookFragment(): ListOfEbookFragment

    @ContributesAndroidInjector
    abstract fun contributeEbookDetailFragment(): EbookDetailFragment
}