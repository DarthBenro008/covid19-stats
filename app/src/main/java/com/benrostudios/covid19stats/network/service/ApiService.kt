package com.benrostudios.covid19stats.network.service

import com.benrostudios.covid19stats.network.response.ApiResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("summary")
    suspend fun getSummary(): Response<ApiResponse>


    companion object {
        operator fun invoke(): ApiService {
            return Retrofit.Builder()
                .baseUrl("https://api.covid19api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)

        }
    }
}