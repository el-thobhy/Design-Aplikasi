package com.elthobhy.designaplikasi.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.elthobhy.designaplikasi.ui.InternetFragment
import com.elthobhy.designaplikasi.ui.RoamingFragment

class ViewPagerAdapter(fa: FragmentActivity, lifecycle: Lifecycle) :
    FragmentStateAdapter(fa.supportFragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return setLayout(position)

    }

    fun setLayout(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = InternetFragment()
            1 -> fragment = RoamingFragment()
        }
        return fragment as Fragment
    }
}