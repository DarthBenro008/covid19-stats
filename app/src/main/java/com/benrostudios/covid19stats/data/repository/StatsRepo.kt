package com.benrostudios.covid19stats.data.repository

import androidx.lifecycle.LiveData
import com.benrostudios.covid19stats.network.response.ApiResponse

interface StatsRepo {

    suspend fun getSummary()
    fun getResponseForgetSummary():LiveData<ApiResponse>
}