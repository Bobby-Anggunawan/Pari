package com.genm.pari.ui.profile

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.genm.pari.JavaFunction
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.ui.MainUIFragment
import com.google.android.material.appbar.MaterialToolbar


class ProfileFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        JavaFunction.setMargins(MainUIFragment.main_con, true)
        MainUIFragment.navView.visibility = View.VISIBLE
        MainUIFragment.nav_top_corner.visibility = View.VISIBLE

        root.findViewById<TextView>(R.id.textView7).text = MainActivity.nama
        root.findViewById<MaterialToolbar>(R.id.topAppBar).title = MainActivity.username

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topAppBar: Toolbar = view.findViewById(R.id.topAppBar)
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.notification -> {
                    MainActivity.navController.navigate(R.id.notification_page)
                    true
                }
                R.id.logout -> {
                    with (sharedPref.edit()) {
                        putString("username", null)
                        apply()
                    }
                    MainActivity.navController.navigate(R.id.fragment_login)
                    true
                }
                else -> false
            }
        }
    }

}