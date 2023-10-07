package com.elthobhy.designaplikasi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.elthobhy.designaplikasi.R
import com.elthobhy.designaplikasi.adapter.TopRekomendasiAdapter
import com.elthobhy.designaplikasi.data.Paket
import com.elthobhy.designaplikasi.databinding.FragmentInternetBinding
import com.elthobhy.designaplikasi.databinding.FragmentShopBinding

class InternetFragment : Fragment(),TopRekomendasiAdapter.OnItemClickListener{


    private var _binding: FragmentInternetBinding? = null
    private val binding get() = _binding as FragmentInternetBinding
    private lateinit var adapterShop: TopRekomendasiAdapter
    private var list : MutableList<Paket> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInternetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterShop= TopRekomendasiAdapter(requireActivity(),this)
        binding.rvItem.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapterShop
        }
        val rekomendasi1 = Paket("Paket PROMO Combo Special", 30000, 1, 30, 15)
        val rekomendasi2 = Paket("Paket Promo Internet dan Telpon", 15000, 2, 7, 5)
        val rekomendasi3 = Paket("Combo Sakti Spesial", 25000, 3, 30, 5)
        val rekomendasi4 = Paket("Combo Sakti Spesial", 20000, 4, 30, 10)
        val rekomendasi5 = Paket("Combo SAKTI Mingguan UNLIMITED", 36000, 5, 7, 10)
        val rekomendasi6 = Paket("Combo SAKTI Mingguan UNLIMITED", 36000, 5, 7, 10)
        val rekomendasi7 = Paket("Combo SAKTI Mingguan UNLIMITED", 36000, 5, 7, 10)
        list.add(rekomendasi1)
        list.add(rekomendasi2)
        list.add(rekomendasi3)
        list.add(rekomendasi4)
        list.add(rekomendasi5)
        list.add(rekomendasi6)
        list.add(rekomendasi7)

        adapterShop.setData(list)
    }

    override fun onItemClicked(v: View, position: Int) {

    }
}