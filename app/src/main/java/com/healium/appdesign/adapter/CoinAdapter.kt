package com.healium.appdesign.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.healium.appdesign.R
import com.healium.appdesign.databinding.ListItemBinding
import com.healium.appdesign.models.Coin

class CoinAdapter(private val listItem :ArrayList<Coin>) : RecyclerView.Adapter<CoinAdapter.CoinHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinAdapter.CoinHolder {
        return CoinHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item , parent  , false))
    }


    override fun onBindViewHolder(holder: CoinAdapter.CoinHolder, position: Int) {
        holder.bindData(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size

    inner class CoinHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemBinding.bind(itemView)
        fun bindData(coin: Coin) {
            try {
                binding.imgV.load(coin.pictures.front.url) {
                    crossfade(true)
                    crossfade(600)
                }
            } catch (e :Exception) {
                binding.imgV.load(R.drawable.noimage) {
                    crossfade(true)
                    crossfade(600)
                }
                Log.d("error**", "bindData: ${e.localizedMessage}")
            }
            binding.coinNameV.text = coin.coinName
        }
    }


}