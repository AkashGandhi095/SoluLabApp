package com.healium.appdesign.network

import com.healium.appdesign.models.DataResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/coinlist")
    suspend fun getCoinData() :Response<DataResponse>
}