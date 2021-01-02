package com.genm.pari.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.R

class ToolFragment_Adapter(val Data: ArrayList<ToolItem>): RecyclerView.Adapter<ToolFragment_Adapter.ItemData_Holder>(){

    //data type
    data class ToolItem(
        var logo: Int,
        var name: String
    )

    inner class ItemData_Holder(ItemLayout: View):RecyclerView.ViewHolder(ItemLayout){
        var Icon: ImageView = ItemLayout.findViewById(R.id.tool_item_icon)
        var Name: TextView = ItemLayout.findViewById(R.id.tool_item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemData_Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_tool, parent, false)
        return ItemData_Holder(view)
    }

    override fun onBindViewHolder(holder: ItemData_Holder, position: Int) {

        val An_Item = Data[position]
        holder.Icon.setImageResource(An_Item.logo)
        holder.Name.text = An_Item.name
    }

    override fun getItemCount(): Int {
        return Data.size
    }

    //=======================================================================================
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ToolItem)
    }
}