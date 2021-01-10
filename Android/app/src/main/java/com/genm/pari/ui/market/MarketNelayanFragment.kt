package com.genm.pari.ui.market

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.adapter.MarketNelayanFragment_Adapter
import com.genm.pari.adapter.ToolFragment_Adapter
import com.genm.pari.ui.NelayanUIFragment
import com.genm.pari.ui.tool.ToolFragment


class MarketNelayanFragment : Fragment() {

    lateinit var myRecyclerView: RecyclerView
    companion object{
        val sellItems = arrayListOf<MarketNelayanFragment_Adapter.MarketItem>(
                MarketNelayanFragment_Adapter.MarketItem(R.drawable.fish_demo, "Ikan mas", 500000),
                MarketNelayanFragment_Adapter.MarketItem(R.drawable.fish_demo, "Ikan koi", 150000),
                MarketNelayanFragment_Adapter.MarketItem(R.drawable.fish_demo, "Ikan nila", 1000000)
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_market_nelayan, container, false)
        MainActivity.actionBarBack.visibility = View.INVISIBLE

        myRecyclerView = root.findViewById(R.id.sell_item_list)
        myRecyclerView.setHasFixedSize(true)

        //set onclick untuk menambah item
        root.findViewById<ImageButton>(R.id.nelayanAddItem).setOnClickListener{
            NelayanUIFragment.navController.navigate(R.id.insert_item)
            //it.findNavController().navigate(R.id.insert_item)
        }
        SetAdapter()
        return root
    }

    fun SetAdapter(){
        myRecyclerView.layoutManager = GridLayoutManager(getActivity(), 2)
        val ListAdapter = MarketNelayanFragment_Adapter(sellItems)
        myRecyclerView.adapter = ListAdapter

        ListAdapter.setOnItemClickCallback(object : MarketNelayanFragment_Adapter.OnItemClickCallback {
            override fun onItemClicked(data: MarketNelayanFragment_Adapter.MarketItem) {
                //todo, gak bisa di klik waktu di tes pake toast. Tapi kayaknya lebih baik gak pae ini tapi ganti imageview jadi imagebutton
            }
        })
    }
}