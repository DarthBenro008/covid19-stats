package com.benrostudios.covid19stats.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.benrostudios.covid19stats.network.response.ApiResponse
import com.benrostudios.covid19stats.network.service.ApiService

class StatsDataSourceImpl(
    var apiService: ApiService
) : StatsDataSource {

    val _response = MutableLiveData<ApiResponse>()

    override suspend fun getSummary() {
        val response = apiService.getSummary()
        _response.postValue(response.body())
    }

    override fun responseForGetSummary(): LiveData<ApiResponse> {
        return _response
    }
}