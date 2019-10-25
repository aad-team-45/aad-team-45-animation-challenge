package com.rockokechukwu.e_bookrecomender.ui.listofebook

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rockokechukwu.e_bookrecomender.api.response.Ebook
import com.rockokechukwu.e_bookrecomender.repository.BookRepository
import com.rockokechukwu.e_bookrecomender.utilities.AbsentLiveData
import com.rockokechukwu.e_bookrecomender.vo.Resource
import javax.inject.Inject

class ListOfEbookViewModel @Inject constructor(repository: BookRepository) : ViewModel() {
    private var _query = MutableLiveData<String>().apply {
        value = "search items"
    }

    val results: LiveData<Resource<List<Ebook>>> = Transformations
        .switchMap(_query) { search ->
            if (search.isNullOrBlank()) {
                AbsentLiveData.create()
            } else {
                Log.d("TAGU","search : $search")
                repository.getEbookList(search)
            }
        }
}
