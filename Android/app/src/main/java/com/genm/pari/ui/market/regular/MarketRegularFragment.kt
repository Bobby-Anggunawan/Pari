package com.genm.pari.ui.market.regular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.adapter.MarketNelayanFragment_Adapter
import com.genm.pari.adapter.MarketRegularFragment_Adapter


class MarketRegularFragment : Fragment() {
    lateinit var myRecyclerView: RecyclerView
    companion object{
        val sellItems = arrayListOf<MarketRegularFragment_Adapter.MarketItem>(
                MarketRegularFragment_Adapter.MarketItem(R.drawable.fish_demo, "Ikan mas", "11:20", 20, 50000),
                MarketRegularFragment_Adapter.MarketItem(R.drawable.fish_demo, "Ikan koi", "12:30", 30, 10000),
                MarketRegularFragment_Adapter.MarketItem(R.drawable.fish_demo, "Ikan nila", "10:00", 4, 120000)
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_market_regular, container, false)

        myRecyclerView = root.findViewById(R.id.sell_item_list)
        myRecyclerView.setHasFixedSize(true)

        SetAdapter()

        val topAppBar: Toolbar = root.findViewById(R.id.topAppBar)
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.notification -> {
                    MainActivity.navController.navigate(R.id.notification_page)
                    true
                }
                else -> false
            }
        }

        return root
    }

    fun SetAdapter(){
        myRecyclerView.layoutManager = GridLayoutManager(getActivity(), 2)
        val ListAdapter = MarketRegularFragment_Adapter(sellItems)
        myRecyclerView.adapter = ListAdapter
    }

}