package com.rockokechukwu.e_bookrecomender.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.rockokechukwu.e_bookrecomender.api.ApiSuccessResponse
import com.rockokechukwu.e_bookrecomender.api.BookService
import com.rockokechukwu.e_bookrecomender.api.response.Ebook
import com.rockokechukwu.e_bookrecomender.api.response.Volume
import com.rockokechukwu.e_bookrecomender.db.EbookDao
import com.rockokechukwu.e_bookrecomender.db.EbookDb
import com.rockokechukwu.e_bookrecomender.utilities.AbsentLiveData
import com.rockokechukwu.e_bookrecomender.vo.Resource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * The class for managing multiple data sources.
 */
@Singleton
class BookRepository @Inject constructor(
    private val context: Context,
    private val appExecutors: AppExecutors,
    private val ebookDao: EbookDao,
    private val ebookDb: EbookDb,
    private val bookService: BookService
) {

    fun search(query: String): LiveData<Resource<List<Ebook>>> {
        return object : NetworkBoundResource<List<Ebook>, Volume>(appExecutors) {

            override fun saveCallResult(item: Volume) {

                ebookDb.runInTransaction {
                    ebookDao.insertEbooks(item.items)
                }
            }

            // Returns boolean indicating if to fetch data from web or not, true means fetch the data from web.
            override fun shouldFetch(data: List<Ebook>?) = data == null

            // contains logic to get data from room database
            override fun loadFromDb(): LiveData<List<Ebook>> {
                return Transformations.switchMap(ebookDao.loadEbooks()){data ->
                    if (data.isEmpty()) {
                        AbsentLiveData.create()
                    } else {
                        ebookDao.loadEbooks()
                    }
                }
            }

            override fun createCall() = bookService.getBooks(query)

            override fun processResponse(response: ApiSuccessResponse<Volume>)
                    : Volume {
                val body = response.body
                return body
            }
        }.asLiveData()
    }
}