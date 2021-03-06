package com.example.githubexample.network

import okhttp3.Interceptor
import okhttp3.Response

class   HttpRequestIntercepter : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        return chain.proceed(request)
    }


}