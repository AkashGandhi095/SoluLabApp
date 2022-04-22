package com.healium.appdesign.Ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.healium.appdesign.R
import com.healium.appdesign.adapter.CoinAdapter
import com.healium.appdesign.databinding.FragmentHomeBinding
import com.healium.appdesign.models.Coin
import com.healium.appdesign.viewModels.CoinDataViewModel

class HomeFragment : Fragment() {

    private lateinit var binding :FragmentHomeBinding
    private lateinit var viewModel :CoinDataViewModel
    private lateinit var cAdapter :CoinAdapter
    private val coinList = arrayListOf<Coin>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[CoinDataViewModel ::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.fetchCoinData()
        initObservers()
    }

    private fun initView() {
        binding.listV.apply {
            layoutManager = GridLayoutManager(this.context , 3)
            cAdapter = CoinAdapter(coinList)
            adapter = cAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObservers() {
        viewModel.coinLiveData.observe(viewLifecycleOwner) { coins ->
            if(coinList.isNotEmpty()) coinList.clear()
            binding.progress.visibility = View.GONE
            coinList.addAll(coins)
            cAdapter.notifyDataSetChanged()
        }
    }

    companion object {}
}