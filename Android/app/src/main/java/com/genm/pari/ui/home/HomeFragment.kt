package com.genm.pari.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.genm.pari.MainActivity
import com.genm.pari.R

class HomeFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val root = inflater.inflate(R.layout.fragment_home, container, false)

    //sumber gambar:
    //https://www.booked.net/widgets/weather
    val weatherWidget = root.findViewById<ImageView>(R.id.weather_widget)
    MainActivity.actionBarBack.visibility = View.INVISIBLE
    Glide.with(this).load("https://w.bookcdn.com/weather/picture/3_42375_1_1_137AE9_160_ffffff_333333_08488D_1_ffffff_333333_0_6.png?scode=124&domid=w209&anc_id=88042")
      .fitCenter().into(weatherWidget)

    return root
  }
}