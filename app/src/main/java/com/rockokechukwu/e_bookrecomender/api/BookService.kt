package com.rockokechukwu.e_bookrecomender.api

import androidx.lifecycle.LiveData
import com.rockokechukwu.e_bookrecomender.api.response.Items
import com.rockokechukwu.e_bookrecomender.api.response.Volume
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    // The @GET annotation tells retrofit that this request is a get type request.
    // The string value tells retrofit that the path of this request is
    // baseUrl + volumes + query parameter.
    @GET("volumes")
    // Annotation @Query is used to define query parameter for request. It is possible to pass
    // multiple query parameters too. Finally the request url will look like that
    // https://sandbox-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?convert=EUR&limit=5000
    fun getBooks(@Query("q") searchTerm: String,
                 @Query("filter") filter: String,
                 @Query("field") field: String):
            LiveData<ApiResponse<List<Volume<Items>>>>
    // The return type for this function is Call with its type Items.
}