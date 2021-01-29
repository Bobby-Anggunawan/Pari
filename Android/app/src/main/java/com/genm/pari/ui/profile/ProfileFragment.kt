package com.genm.pari.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.genm.pari.JavaFunction
import com.genm.pari.R
import com.genm.pari.ui.MainUIFragment


class ProfileFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        JavaFunction.setMargins(MainUIFragment.main_con, true)
        MainUIFragment.navView.visibility = View.VISIBLE
        MainUIFragment.nav_top_corner.visibility = View.VISIBLE
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

}