package com.rockokechukwu.e_bookrecomender.api

import com.rockokechukwu.e_bookrecomender.utilities.API_SERVICE_AUTHENTICATION_KEY
import com.rockokechukwu.e_bookrecomender.utilities.API_SERVICE_AUTHENTICATION_NAME
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor used to intercept the actual request and
 * to supply your API Key in REST API calls via a custom header.
 */
class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newRequest = chain.request().newBuilder()
            .addHeader(API_SERVICE_AUTHENTICATION_NAME, API_SERVICE_AUTHENTICATION_KEY)
            .build()

        return chain.proceed(newRequest)
    }
}