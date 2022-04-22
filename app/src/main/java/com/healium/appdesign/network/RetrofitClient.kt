package com.healium.appdesign.network

import com.healium.appdesign.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://demo3231717.mockable.io"

    private val retrofitInit : Retrofit.Builder by lazy {
        val levelType = if(BuildConfig.BUILD_TYPE.contentEquals("Debug"))
            HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(logging)

        Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient.build()).addConverterFactory(GsonConverterFactory.create())
    }

    val apiClient: ApiInterface by lazy {
        retrofitInit.build().create(ApiInterface ::class.java)
    }
}