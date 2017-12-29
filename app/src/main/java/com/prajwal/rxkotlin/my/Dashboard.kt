package com.prajwal.rxkotlin.my

import com.google.gson.annotations.SerializedName

/**
 * Created by prajwal on 12/29/17.
 */

data class Dashboard(
        @SerializedName("section_id")
        var sectionId: Int,
        @SerializedName("section_title")
        var sectionTitle: String,
        var items: List<Items>
)

data class Items(
        var id: Int,
        var image: String,
        var title: String,
        var description: String,
        var sponser: Sponser
)

data class Sponser(
        var id: Int,
        var name: String,
        var logo: String
)