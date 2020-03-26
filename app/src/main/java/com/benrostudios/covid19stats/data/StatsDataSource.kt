package com.benrostudios.covid19stats.data

import androidx.lifecycle.LiveData
import com.benrostudios.covid19stats.network.response.ApiResponse

interface StatsDataSource {

    suspend fun getSummary()
    fun responseForGetSummary(): LiveData<ApiResponse>

}