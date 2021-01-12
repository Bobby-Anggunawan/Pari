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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.adapter.ToolFragment_Adapter
import com.genm.pari.ui.tool.ToolFragment

class HomeFragment : Fragment() {

  lateinit var myRecyclerView: RecyclerView
  companion object{
    var items = arrayListOf<ToolFragment_Adapter.ToolItem>(
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "SOS"),
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Radar Ikan"),
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Input Item"),
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
    MainActivity.actionBarBack.visibility = View.INVISIBLE
    Glide.with(this).load("https://w.bookcdn.com/weather/picture/3_42375_1_1_137AE9_160_ffffff_333333_08488D_1_ffffff_333333_0_6.png?scode=124&domid=w209&anc_id=88042")
      .fitCenter().into(weatherWidget)

    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    SetAdapter()
    myRecyclerView.isLayoutFrozen = true //disable scrool
  }

  fun SetAdapter(){
    myRecyclerView.layoutManager = GridLayoutManager(getActivity(), 3)
    val ListAdapter = ToolFragment_Adapter(items)
    myRecyclerView.adapter = ListAdapter

    ListAdapter.setOnItemClickCallback(object : ToolFragment_Adapter.OnItemClickCallback {
      override fun onItemClicked(data: ToolFragment_Adapter.ToolItem) {
        //todo, gak bisa di klik waktu di tes pake toast. Tapi kayaknya lebih baik gak pae ini tapi ganti imageview jadi imagebutton
      }
    })
  }
}