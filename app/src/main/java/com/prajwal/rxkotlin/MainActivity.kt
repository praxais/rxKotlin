package com.prajwal.rxkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.reactivestreams.Subscriber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Observable.merge<Any>(getButtonListener(), getTask())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeBy(onError = { e ->
//                    Log.d("onError", e.message)
//                }, onComplete = {
//                    Log.d("OnComplete", "xais")
//                }, onNext = { any ->
//                    Toast.makeText(this, any as String, Toast.LENGTH_SHORT).show()
//                })


//        getButtonListener().observeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeBy(
//                        onNext = { any ->
//                            if (any is String)
//                                Log.d("OnNext", any)
//                            else if (any is Int)
//                                Log.d("Value", "" + any)
//                        })


        Observable.merge<Any>(getButtonListener(), getTask())
                .observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onComplete = {
                            Log.d("OnSuccess", "Success")
                        },
                        onError = {

                        },
                        onNext = { any ->
                            Log.d("OnNext", any as String)
                        }

                )

//        getAccessToken().flatMap { it -> getProfile(it) }
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ it ->
//                    if (isViewAttached){
//                        Log.d("Profile", it.firstName)
//                    }
//                }, { it ->
//                    if (isViewAttached) {
//                        view.showToast(it.localizedMessage)
//                    }
//                }, {
//                    if (isViewAttached) {
//                        view.hideLoading()
//                    }
//                })
    }

    private fun getButtonListener(): Observable<Any> =
            Observable.create<Any> { e ->
                btn.setOnClickListener({
                    e.onNext("Click success")
                    e.onComplete()
                })
            }

    private fun getTask(): Observable<String> =
            Observable.create<String> { e ->
                btn.setOnClickListener({
                    e.onNext("Condition success")
                    e.onComplete()
                })
            }





//    private fun getAccessToken(): Observable<String> =
//            Observable.create<String> { e ->
//                employerInteractor.getAccessToken(userType, object : OnDbFinishListener {
//                    override fun accessToken(result: String?) {
//                        if (result != null) {
//                            e.onNext(result)
//                        } else {
//                            e.onError(Throwable("Token null"))
//                            e.onComplete()
//                        }
//                    }
//                })
//            }
//
//    private fun getProfile(accessToken: String): Observable<Profiles> =
//            Observable.create<Profiles> { e ->
//                employeeLoginInteractor.getEmployeeProfile(accessToken, object : OnFinishListener<Profiles> {
//                    override fun onSuccess(result: Profiles) {
//                        e.onNext(result)
//                        e.onComplete()
//                    }
//
//                    override fun onFailed(msg: String) {
//                        e.onError(Throwable(msg))
//                        e.onComplete()
//                    }
//                })
//            }
}
