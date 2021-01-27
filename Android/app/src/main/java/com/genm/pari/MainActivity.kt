package com.genm.pari

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    companion object{
        //todo implementaikan shared preference untuk menyimpan username setelah login
        var username: String = "Bobby"
        var user_type: String = "Nelayan" //Nelayan or Regular
        lateinit var mainContext: Context
        lateinit var navController: NavController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainContext = this
        navController = findNavController(R.id.nav_host_fragment)
        //ubah nafgraph untuk nelayan atau regular
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //todo, kode ini menyebabkan error saat actionbar dibuang
        /*
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nelayan_ui, R.id.notification_page))
        setupActionBarWithNavController(navController, appBarConfiguration)*/

    }

}