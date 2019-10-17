package com.rockokechukwu.e_bookrecomender.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import com.rockokechukwu.e_bookrecomender.api.ApiResponse
import com.rockokechukwu.e_bookrecomender.api.BookService
import com.rockokechukwu.e_bookrecomender.api.response.Items
import javax.inject.Inject
import javax.inject.Singleton

/**
 * The class for managing multiple data sources.
 */
@Singleton
class BookRepository @Inject constructor(
    private val context: Context,
    private val appExecutors: AppExecutors,
    private val bookService: BookService,
    private val sharedPreferences: SharedPreferences
) {
    fun getUser(userId: String): LiveData<List<Items>> {
        return object : NetworkBoundResource<Items, Items>() {

        }.asLiveData()
    }
}