package com.rockokechukwu.e_bookrecomender.api

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rockokechukwu.e_bookrecomender.api.response.Volume
import retrofit2.Response

/**
 * Common class used by API responses. ApiResponse is a simple wrapper around the Retrofit2.Call
 * class that convert responses to instances of LiveData.
 * @param <CoinMarketCapType> the type of the response object
</T> */
@Suppress("unused") // T is used in extending classes
sealed class ApiResponse<T> {
    companion object {
        fun <T> create(error: Throwable): ApiErrorResponse<T> {
            return ApiErrorResponse(error.message ?: "Unknown error.")
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                if (body == null || response.code() == 204) {
                    ApiEmptyResponse()
                } else {
                    ApiSuccessResponse(body = body)
                }
            } else {

                val msg = response.errorBody()?.string()
                val errorMsg = if (msg.isNullOrEmpty()) {
                    response.message()
                } else {
                    msg
                }
                ApiErrorResponse(errorMsg ?: "Unknown error.")
            }
        }
    }
}

/**
 * Separate class for HTTP 204 resposes so that we can make ApiSuccessResponse's body non-null.
 */
class ApiEmptyResponse<CoinMarketCapType> : ApiResponse<CoinMarketCapType>()

data class ApiSuccessResponse<CoinMarketCapType>(val body: CoinMarketCapType) : ApiResponse<CoinMarketCapType>()

data class ApiErrorResponse<CoinMarketCapType>(val errorMessage: String) : ApiResponse<CoinMarketCapType>()