package com.example.horoscapp.ui.home.horoscope.adapter

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscapp.databinding.ItemHoroscopeBinding
import com.example.horoscapp.domain.model.HoroscopeInfo
import com.example.horoscapp.ui.home.horoscope.viewholder.HoroscopeViewHolder

class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onItemSelected:(HoroscopeInfo) -> Unit): RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(list: List<HoroscopeInfo>) {
        horoscopeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val binding = ItemHoroscopeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HoroscopeViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.bind(horoscopeList[position], onItemSelected)
    }

    override fun getItemCount() = horoscopeList.size }