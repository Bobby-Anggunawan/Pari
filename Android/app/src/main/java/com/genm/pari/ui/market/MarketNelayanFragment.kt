package com.genm.pari.ui.market

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.adapter.MarketNelayanFragment_Adapter
import com.genm.pari.ui.MainUIFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MarketNelayanFragment : Fragment() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var sheetBehavior: BottomSheetBehavior<LinearLayout>
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

        myRecyclerView = root.findViewById(R.id.sell_item_list)
        myRecyclerView.setHasFixedSize(true)

        //set onclick untuk menambah item
        root.findViewById<ImageButton>(R.id.nelayanAddItem).setOnClickListener{
            MainUIFragment.navController.navigate(R.id.insert_item)
        }
        SetAdapter()
        root.findViewById<TextView>(R.id.item_count).text = "${sellItems.size} Items"

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

        //mengatur backdrop
        root.findViewById<AppBarLayout>(R.id.appBarLayout).setOutlineProvider(null) //menghilangkan garis bawah toolbar

        val contentLayout = root.findViewById<LinearLayout>(R.id.contentLayout)
        sheetBehavior = BottomSheetBehavior.from(contentLayout)
        sheetBehavior.setFitToContents(true)
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)

        //tombol hapus item
        root.findViewById<Button>(R.id.backdrop_hapus_item).setOnClickListener {
            val nama = view?.findViewById<TextView>(R.id.backdrop_judul)?.text
            for(x in 0..sellItems.count()){
                if(sellItems[x].nama == nama){
                    sellItems.removeAt(x)
                    myRecyclerView.adapter?.notifyDataSetChanged()
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
                    break
                }
            }
        }
        return root
    }

    fun SetAdapter(){
        myRecyclerView.layoutManager = GridLayoutManager(getActivity(), 2)
        val ListAdapter = MarketNelayanFragment_Adapter(sellItems)
        myRecyclerView.adapter = ListAdapter

        ListAdapter.onItemClick = {
            view?.findViewById<TextView>(R.id.backdrop_judul)?.text = it.nama
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        }
    }
}