package com.example.mygithubtaskrefacktor.core.di

import com.example.mygithubtaskrefacktor.core.restservice.BASE_URL
import com.example.mygithubtaskrefacktor.core.restservice.GithubApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
//
//    single { getHttpLoggingInterceptor() }
//
//    single { getOkHttpClient(httpLoggingInterceptor = get(),  basicAuthInterceptor = get()) }

//    single { getRetrofit(okHttpClient = get(), baseUrl = BASE_URL) }

//    single { getRetrofit(okHttpClient = get())}
//
//    single { getGithubRestService(retrofit = get()) }
//
//    single { BasicAuthInterceptor(loginLocalDataSource = get()) }
//
//    single{
//        getRetrofitTest()
//    }

//    single {
//        Retrofit.Builder()
//            .baseUrl("https://api.github.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(GithubApiService::class.java)
//    }

    single{
        getRetrofitTest()
    }

    single{
        getGithubRestService(retrofit = get())
    }


}

private fun getRetrofitTest():Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


//private fun getRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit
//    .Builder()
////    .baseUrl(baseUrl)
//    .baseUrl("https://api.github.com")
//    .client(okHttpClient)
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()

private fun getGithubRestService(retrofit: Retrofit): GithubApiService =
    retrofit.create(GithubApiService::class.java)
//
//private fun getOkHttpClient(
//    httpLoggingInterceptor: HttpLoggingInterceptor,
//    basicAuthInterceptor: BasicAuthInterceptor
//): OkHttpClient = OkHttpClient.Builder()
//    .addInterceptor(httpLoggingInterceptor)
//    .addInterceptor(basicAuthInterceptor)
//    .build()
//
//private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
//    val loggingInterceptor = HttpLoggingInterceptor()
//    loggingInterceptor.level = if (BuildConfig.DEBUG)
//        HttpLoggingInterceptor.Level.BODY
//    else
//        HttpLoggingInterceptor.Level.NONE
//    return loggingInterceptor
//}