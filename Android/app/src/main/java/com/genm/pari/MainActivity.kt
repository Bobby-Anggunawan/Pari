package com.genm.pari

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    companion object{
        //todo implementaikan shared preference untuk menyimpan username setelah login
        var username: String? = "Bobby"
        var nama: String? = "nama asli"
        var user_type: String = "Nelayan" //Nelayan or Regular
        lateinit var mainContext: Context
        lateinit var navController: NavController

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainContext = this
        setUser()
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

    fun setUser(){
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return
        if(sharedPref.getInt("nelayan", 0) == 1){
            user_type = "Nelayan"
        }
        else{
            user_type = "Regular"
        }
        nama = sharedPref.getString("nama", "Bobby")
        username = sharedPref.getString("username", null)
    }

}