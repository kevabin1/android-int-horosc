package com.example.horoscapp.ui.home.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.horoscapp.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private var _binding: ActivityHoroscopeDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}