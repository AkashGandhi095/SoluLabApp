package com.healium.appdesign.repository

import android.util.Log
import com.healium.appdesign.models.Coin
import com.healium.appdesign.network.ApiInterface
import com.healium.appdesign.network.RetrofitClient

object CoinRepo {

    private val apiInterface :ApiInterface = RetrofitClient.apiClient

    suspend fun fetchAllCoinList() :ArrayList<Coin> {
        return try {
            val res = apiInterface.getCoinData()
            if(res.isSuccessful) {
                val body = res.body()!!
                val coinList = body.data.list
                Log.d("coinList**", "fetchAllCoinList: $coinList")
                coinList
            } else {
                arrayListOf()
            }
        } catch (e :Exception) {
            Log.d("coinList**", "error : fetchAllCoinList: ${e.localizedMessage} ")
            arrayListOf()
        }
    }
}