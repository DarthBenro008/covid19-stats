package com.benrostudios.covid19stats.network.response


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("Countries")
    val countries: List<Country>,
    @SerializedName("Date")
    val date: String
)