package com.genm.pari.ui.tool

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.adapter.ToolFragment_Adapter
import com.google.android.material.snackbar.Snackbar


class ToolFragment : Fragment() {

    lateinit var myRecyclerView: RecyclerView
    companion object{
        var items = arrayListOf<ToolFragment_Adapter.ToolItem>(
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Pasang Surut"),
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Radar Ikan"),
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Tekanan Udara"),
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Arah Arus"),
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Perkiraan Cuaca"),
            ToolFragment_Adapter.ToolItem(R.drawable.ic_compas_black_24dp, "Arah Angin")
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tool, container, false)
        myRecyclerView = root.findViewById(R.id.tool_list)
        myRecyclerView.setHasFixedSize(true)

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SetAdapter()
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