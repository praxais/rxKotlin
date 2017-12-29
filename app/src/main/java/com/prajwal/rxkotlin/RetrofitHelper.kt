package com.prajwal.rxkotlin

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by prajwal on 9/18/17.
 */

class RetrofitHelper {
    private lateinit var apiService: ApiService

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()

    fun getApiService(): ApiService {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://10.10.10.25:3000")
                .client(okHttpClient)
                .build()
        apiService = retrofit.create(ApiService::class.java)
        return apiService
    }

    fun getServerApiService(): ApiService {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://api.openweathermap.org")
                .client(okHttpClient)
                .build()
        apiService = retrofit.create(ApiService::class.java)
        return apiService
    }
}