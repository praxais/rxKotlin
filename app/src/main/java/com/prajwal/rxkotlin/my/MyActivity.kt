package com.prajwal.rxkotlin.my

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.prajwal.rxkotlin.R
import kotlinx.android.synthetic.main.activity_my.*

/**
 * Created by prajwal on 12/29/17.
 */

class MyActivity: AppCompatActivity() {
    private val myPresenter = MyPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        btnMain.setOnClickListener{
            myPresenter.getData()
        }
    }

    fun populateData(dashboardList: List<Dashboard>?) {
        println("Prajwal" + dashboardList?.get(0)?.sectionTitle)
    }
}