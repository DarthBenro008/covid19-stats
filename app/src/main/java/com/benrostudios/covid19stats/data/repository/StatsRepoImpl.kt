package com.benrostudios.covid19stats.data.repository

import androidx.lifecycle.LiveData
import com.benrostudios.covid19stats.data.StatsDataSource
import com.benrostudios.covid19stats.network.response.ApiResponse

class StatsRepoImpl(
    val statsDataSource: StatsDataSource
) : StatsRepo {
    override suspend fun getSummary() {
        statsDataSource.getSummary()
    }

    override fun getResponseForgetSummary(): LiveData<ApiResponse> {
        return statsDataSource.responseForGetSummary()
    }
}