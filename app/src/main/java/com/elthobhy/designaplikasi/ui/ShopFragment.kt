package com.elthobhy.designaplikasi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.elthobhy.designaplikasi.R
import com.elthobhy.designaplikasi.adapter.TopRekomendasiAdapter
import com.elthobhy.designaplikasi.adapter.ViewPagerAdapter
import com.elthobhy.designaplikasi.data.Paket
import com.elthobhy.designaplikasi.databinding.FragmentInternetBinding
import com.elthobhy.designaplikasi.databinding.FragmentShopBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class ShopFragment : Fragment() {


    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding as FragmentShopBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabTitle = arrayOf(
            R.string.internet,
            R.string.roaming,
        )

        viewPagerAdapter = ViewPagerAdapter(requireActivity(), lifecycle)
        binding.viewPager.adapter = viewPagerAdapter

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, binding.viewPager) { tab, position ->
            tab.text = context?.resources?.getString(tabTitle[position])
        }.attach()
        tabLayout.getTabAt(0)?.setIcon(R.drawable.network)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.roaming)

    }

}