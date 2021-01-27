package com.genm.pari.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.genm.pari.R
import com.genm.pari.adapter.HomeAndChat_PagerAdapter


class HomeAndChatFragment : Fragment() {

    companion object{
        lateinit var viewPager: ViewPager
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home_and_chat, container, false)
        val sectionsPagerAdapter =
            activity?.let { HomeAndChat_PagerAdapter(it, childFragmentManager) }
        viewPager = root.findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        return root
    }


}