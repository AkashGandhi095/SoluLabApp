package com.healium.appdesign.models

import com.google.gson.annotations.SerializedName

data class Coin(
    val coinImage :String ,
    @SerializedName("name")
    val coinName :String ,
    val pictures: Pictures

)

data class Pictures(
    val front :FrontPicture
)

data class FrontPicture(
    val url :String
)

data class DataResponse(
    val data : CoinData
)

data class CoinData(
    val list :ArrayList<Coin>
)