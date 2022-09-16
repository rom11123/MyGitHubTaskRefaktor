package com.example.mygithubtaskrefacktor.core.restservice

import com.example.mygithubtaskrefacktor.feature_authentication.data.datasource.localdatasource.LoginLocalDataSource
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor(private val loginLocalDataSource: LoginLocalDataSource):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader(AUTHORIZATION, "token ${loginLocalDataSource.getPassword()}")
            .build()
        return chain.proceed(request)
    }
}