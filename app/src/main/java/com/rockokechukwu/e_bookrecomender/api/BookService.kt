package com.rockokechukwu.e_bookrecomender.api

import androidx.lifecycle.LiveData
import com.rockokechukwu.e_bookrecomender.api.response.Volume
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    // The @GET annotation tells retrofit that this request is a get type request.
    // The string value tells retrofit that the path of this request is
    // baseUrl + volumes + query parameter.
    @GET("volumes")
    // Annotation @Query is used to define query parameter for request. It is possible to pass
    // multiple query parameters too.
    fun getBooks(@Query("q") searchTerm: String,
                 @Query("filter") filter: String):
            LiveData<ApiResponse<Volume>>

}