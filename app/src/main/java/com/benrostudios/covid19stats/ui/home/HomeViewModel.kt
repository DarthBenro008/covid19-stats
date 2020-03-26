package com.benrostudios.covid19stats.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.benrostudios.covid19stats.data.repository.StatsRepo
import com.benrostudios.covid19stats.network.response.ApiResponse

class HomeViewModel(
    private val statsRepo: StatsRepo
) : ViewModel() {

    private val _response = MutableLiveData<ApiResponse>()


    suspend fun getSummary() {
        statsRepo.getSummary()
    }

    fun getResponse(): LiveData<ApiResponse>{
        statsRepo.getResponseForgetSummary().observeForever {
            _response.postValue(it)
        }
        return _response
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}