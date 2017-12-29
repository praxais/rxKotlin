package com.prajwal.rxkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by prajwal on 12/29/17.
 */

class RxActivity : AppCompatActivity() {
    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            disposable = myObservable("MyText").subscribeOn(AndroidSchedulers.mainThread())
                    .observeOn(Schedulers.io())
                    .subscribe({ result ->
                        Log.d("MyResult", result)
                    }, { error ->
                        Log.d("Error", error.localizedMessage)
                    }, {
                        Log.d("Completed", "true")
                    })
        }
    }

    private fun myObservable(myValue: String): Observable<String> =
            Observable.create<String> { e ->
                e.onNext(myValue)
                e.onComplete()
            }

    override fun onDestroy() {
        super.onDestroy()
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}