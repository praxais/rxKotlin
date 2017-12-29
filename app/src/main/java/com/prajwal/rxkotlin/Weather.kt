package com.prajwal.rxkotlin

/**
 * Created by prajwal on 12/29/17.
 */

data class Weather(
        var base: String,
        var visibility: String,
        var dt: Int,
        var id: Int,
        var name: String,
        var cod: Int
)