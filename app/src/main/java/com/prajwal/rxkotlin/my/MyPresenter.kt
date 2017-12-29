package com.prajwal.rxkotlin.my

import android.util.Log
import com.prajwal.rxkotlin.RetrofitHelper
import com.prajwal.rxkotlin.Weather
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

/**
 * Created by prajwal on 12/29/17.
 */

class MyPresenter {
    private lateinit var disposable: Disposable

    fun getData() {
        val getDataCall = RetrofitHelper().getApiService().getData()

        disposable = getDataCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    when (response.code()) {
                        200 -> {
                            MyActivity().populateData(response.body())
                            if (!disposable.isDisposed) {
                                disposable.dispose()
                            }
                        }
                    }
                }, { error ->
                    Log.d("Error", error.localizedMessage)
                }, {
                    //hide Loading
                })

        Observable.merge(getData1(), getWeather(), getWeather(), getWeather())
                .subscribe({ response ->

                    (response as Response<Weather>).body()


                }, { it ->

                }, {

                })
    }


    private fun getData1(): Observable<Response<List<Dashboard>>> {
        val getDataCall = RetrofitHelper().getApiService().getData()

        return getDataCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getWeather(): Observable<Response<Weather>> {
        val getDataCall = RetrofitHelper().getServerApiService().getWeatherR()

        return getDataCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}