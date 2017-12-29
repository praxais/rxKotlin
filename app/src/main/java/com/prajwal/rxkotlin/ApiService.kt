package com.prajwal.rxkotlin

import com.prajwal.rxkotlin.my.Dashboard
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by prajwal on 12/29/17.
 */

interface ApiService {
    @GET("/data/2.5/weather?lat=27.186242&lon=85.957031&APPID=434d1145e31b7937aaa94e2faff65d0d")
    fun getWeather(): Single<Response<Weather>>

    @GET("/data/2.5/weather?lat=27.186242&lon=85.957031&APPID=434d1145e31b7937aaa94e2faff65d0d")
    fun getWeatherR() : Observable<Response<Weather>>

    @GET("/dashboard")
    fun getData(): Observable<Response<List<Dashboard>>>
}