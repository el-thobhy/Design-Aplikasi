package com.elthobhy.designaplikasi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elthobhy.designaplikasi.R
import com.elthobhy.designaplikasi.adapter.ViewPagerInternetAdapter
import com.elthobhy.designaplikasi.databinding.FragmentMainInternetBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainInternetFragment : Fragment() {

    private var _binding: FragmentMainInternetBinding? = null
    private val binding get() = _binding as FragmentMainInternetBinding
    private lateinit var viewPagerInternetAdapter: ViewPagerInternetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainInternetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager()
    }

    private fun setViewPager() {
        val tabTitle = arrayOf(
            R.string._1, R.string._2, R.string._3,
            R.string._4, R.string._5, R.string._6,
            R.string._7
        )
        viewPagerInternetAdapter = ViewPagerInternetAdapter(requireActivity(), lifecycle)
        binding.viewPager.adapter = viewPagerInternetAdapter
        val  tab = binding.tabLayout
        TabLayoutMediator(tab, binding.viewPager) { tabP, position ->
            tabP.text = context?.resources?.getString(tabTitle[position])
        }.attach()
        binding.viewPager.isUserInputEnabled = false
    }
}