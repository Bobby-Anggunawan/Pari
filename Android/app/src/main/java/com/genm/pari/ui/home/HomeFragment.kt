package com.genm.pari.ui.home

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.genm.pari.JavaFunction
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.adapter.ToolFragment_Adapter
import com.genm.pari.ui.MainUIFragment
import com.genm.pari.ui.tool.ToolFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

  lateinit var myRecyclerView: RecyclerView
  companion object{
    var items = arrayListOf<ToolFragment_Adapter.ToolItem>(
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "SOS"),
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Radar Ikan"),
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Input Item"),
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Alarm"),
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Compass"),
            ToolFragment_Adapter.ToolItem(R.drawable.plus_black, "")
    )
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val root = inflater.inflate(R.layout.fragment_home, container, false)

    //sumber gambar:
    //https://www.booked.net/widgets/weather
    val weatherWidget = root.findViewById<ImageView>(R.id.weather_widget)
    myRecyclerView = root.findViewById(R.id.shorcut_list)
    myRecyclerView.setHasFixedSize(true)
    Glide.with(this).load("https://w.bookcdn.com/weather/picture/3_42375_1_1_137AE9_160_ffffff_333333_08488D_1_ffffff_333333_0_6.png?scode=124&domid=w209&anc_id=88042")
      .fitCenter().into(weatherWidget)

    val topAppBar: Toolbar = root.findViewById(R.id.topAppBar)
    topAppBar.setOnMenuItemClickListener { menuItem ->
      when (menuItem.itemId) {
        R.id.notification -> {
          MainActivity.navController.navigate(R.id.notification_page)
          true
        }
        R.id.chat -> {
          HomeAndChatFragment.viewPager.setCurrentItem(1)
          true
        }
        else -> false
      }
    }

    ///set nav view spesial home
    val navView: BottomNavigationView = root.findViewById(R.id.nav_view)
    navView.setupWithNavController(MainUIFragment.navController)
    MainUIFragment.navView.visibility = View.GONE
    MainUIFragment.nav_top_corner.visibility = View.GONE
    JavaFunction.setMargins(MainUIFragment.main_con, false)

    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    SetAdapter()
    myRecyclerView.isLayoutFrozen = true //disable scrool
  }

  fun SetAdapter(){
    myRecyclerView.layoutManager = GridLayoutManager(getActivity(), 4)
    val ListAdapter = ToolFragment_Adapter(items)
    myRecyclerView.adapter = ListAdapter

    ListAdapter.setOnItemClickCallback(object : ToolFragment_Adapter.OnItemClickCallback {
      override fun onItemClicked(data: ToolFragment_Adapter.ToolItem) {
        //todo, gak bisa di klik waktu di tes pake toast. Tapi kayaknya lebih baik gak pae ini tapi ganti imageview jadi imagebutton
      }
    })
  }
}