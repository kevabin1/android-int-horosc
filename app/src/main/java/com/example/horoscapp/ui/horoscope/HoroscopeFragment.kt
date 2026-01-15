package com.example.horoscapp.ui.home.horoscope

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.*
import androidx.lifecycle.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.horoscapp.databinding.FragmentHoroscopeBinding
import com.example.horoscapp.ui.home.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private var _horoscopeAdapter: HoroscopeAdapter? = null
    private val horoscopeAdapter get() = _horoscopeAdapter!!
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initList()
    }

    private fun initList() {
        _horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            Toast.makeText(context, getString(it.name), Toast.LENGTH_SHORT).show()
        })
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    // aqui van los cambios que ocurren en horoscope
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _horoscopeAdapter = null
    }
}