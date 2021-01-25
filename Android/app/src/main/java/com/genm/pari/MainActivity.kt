package com.genm.pari

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    companion object{
        //todo implementaikan shared preference untuk menyimpan username setelah login
        var username: String = "Bobby"
        var user_type: String = "Regular" //Nelayan or Regular
        lateinit var mainContext: Context
        lateinit var navController: NavController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainContext = this
        navController = findNavController(R.id.nav_host_fragment)
        //ubah nafgraph untuk nelayan atau regular
        if(user_type == "Nelayan"){
            navController.setGraph(R.navigation.mobile_navigation_nelayan)
        }
        else{
            navController.setGraph(R.navigation.mobile_navigation)
        }
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //todo, kode ini menyebabkan error saat actionbar dibuang
        /*
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nelayan_ui, R.id.notification_page))
        setupActionBarWithNavController(navController, appBarConfiguration)*/

    }

}