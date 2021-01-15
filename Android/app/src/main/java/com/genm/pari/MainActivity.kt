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
        lateinit var actionBarBack: ImageButton
        lateinit var notificationButton: ImageButton
        lateinit var mainContext: Context
        lateinit var navController: NavController
        var myActionBar: ActionBar? = null

        fun removeHomeButton(){
            //menghilangkan tombol back default
            myActionBar!!.setHomeButtonEnabled(false); // disable the button
            myActionBar!!.setDisplayHomeAsUpEnabled(false); // remove the left caret
            myActionBar!!.setDisplayShowHomeEnabled(false); // remove the icon
            //============
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainContext = this
        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nelayan_ui, R.id.notification_page))
        setupActionBarWithNavController(navController, appBarConfiguration)


        //set custom action bar
        //todo: ada code yang pakai set title untuk action bar tiap pindah fragment
        myActionBar = supportActionBar
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        supportActionBar?.setDisplayShowCustomEnabled(true);
        supportActionBar?.setCustomView(R.layout.action_bar)
        actionBarBack = supportActionBar!!.customView!!.findViewById<ImageButton>(R.id.backActionBar)
        actionBarBack.setOnClickListener{
            onBackPressed()
        }
        notificationButton = supportActionBar!!.customView!!.findViewById(R.id.notification_button)
        notificationButton.setOnClickListener{
            navController.navigate(R.id.notification_page)
        }
    }

}