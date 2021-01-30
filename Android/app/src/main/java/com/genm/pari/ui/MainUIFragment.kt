package com.genm.pari.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.transition.MaterialSharedAxis


class MainUIFragment : Fragment() {

    companion object{
        lateinit var navController: NavController
        lateinit var navView: BottomNavigationView
        lateinit var main_con: FrameLayout
        lateinit var nav_top_corner: ImageView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //animation https://material.io/develop/android/theming/motion#shared-axis
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_u_i, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navView = view.findViewById(R.id.nav_view)
        main_con = view.findViewById(R.id.main_container)
        nav_top_corner = view.findViewById(R.id.nav_top_corner)
        navController = requireActivity().findNavController(R.id.nav_host_nelayan)
        if(MainActivity.user_type == "Nelayan"){
            navController.setGraph(R.navigation.nelayan_ui_navigation)
        }
        else{
            navController.setGraph(R.navigation.regular_ui_navigation)
        }
        navView.setupWithNavController(navController)
    }

}