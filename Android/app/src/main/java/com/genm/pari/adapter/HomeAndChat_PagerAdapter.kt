package com.genm.pari.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.genm.pari.R
import com.genm.pari.ui.chat.ChatFragment
import com.genm.pari.ui.home.HomeFragment

class HomeAndChat_PagerAdapter(private val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val TAB_TITLES = arrayListOf<String>("Home", "Chat")
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HomeFragment()
            1 -> fragment = ChatFragment()
        }
        return fragment as Fragment
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }
    override fun getCount(): Int {
        return 2
    }
}