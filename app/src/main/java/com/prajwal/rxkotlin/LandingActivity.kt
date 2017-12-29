package com.prajwal.rxkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response
import io.reactivex.disposables.Disposable


/**
 * Created by prajwal on 12/29/17.
 */

class LandingActivity : AppCompatActivity(), View.OnClickListener {
//    private val isTokenValid = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener(this)

        val weatherCall: Single<Response<Weather>> = RetrofitHelper().getApiService().getWeather()

        //for Single
        weatherCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    when (response.code()) {
                        200 -> {
                            Log.d("Message", response.body()?.name)
                        }
                    }
                }, { error ->
                    Log.d("Error", error.localizedMessage)
                })


        //for Observable
//        weatherCall.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ response ->
//                    when (response.code()) {
//                        200 -> {
//                            Log.d("Message", response.body()?.name)
//                        }
//                    }
//                }, { error ->
//                    Log.d("Error", error.localizedMessage)
//                }, {
//                    Log.d("OnFinished", "Success")
//                })


//        getToken().flatMap{it -> printToken(it)}
//                .observeOn(Schedulers.newThread())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe({ it ->
//                    Log.d("Prajwal" , it)
//                }, {it ->
//                    Log.d("PrajwalError" , it.localizedMessage)
//                }, {
//                    Log.d("PrajwalComplete", "true")
//                })
    }

//    private fun getToken(): Observable<String> =
//            Observable.create<String> { e ->
//                if (!isTokenValid) {
//                    e.onNext("Token")
//                } else {
//                    e.onError(Throwable("Error"))
//                    e.onComplete()
//                }
//            }
//
//    private fun printToken(accessToken: String): Observable<String> =
//            Observable.create<String> { e ->
//                if (accessToken.isNotEmpty()) {
//                    Log.d("AccessToken ->", accessToken)
//                    Log.d("Prajwal" , "sakyo")
//                    e.onComplete()
//                } else {
//                    e.onError(Throwable("PrintTokenError"))
//                    e.onComplete()
//                }
//            }

    override fun onClick(view: View) {
        when (view) {
            btn -> {
                Observable.create<String> { e ->
                    if (true) {
                        e.onNext("Value")
                    } else {
                        e.onError(Throwable("Error"))
                    }
                    e.onComplete()
                }.subscribe({ result ->
                    Log.d("Result", result)
                }, { error ->
                    Log.d("Error", error.localizedMessage)
                }, {
                    Log.d("complete", "yahoo")
                })
            }
        }
    }

}