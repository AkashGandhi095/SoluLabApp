package com.healium.appdesign.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.healium.appdesign.models.Coin
import com.healium.appdesign.repository.CoinRepo
import kotlinx.coroutines.launch

class CoinDataViewModel : ViewModel() {

    private val coinMutableLiveData = MutableLiveData<ArrayList<Coin>>()

    val coinLiveData : LiveData<ArrayList<Coin>>
        get() = coinMutableLiveData

    fun fetchCoinData() {
        viewModelScope.launch {
            val list = CoinRepo.fetchAllCoinList()
            coinMutableLiveData.value = list
        }
    }

}