package com.genm.pari.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.R

class MarketRegularFragment_Adapter(val Data: ArrayList<MarketItem>): RecyclerView.Adapter<MarketRegularFragment_Adapter.ItemData_Holder>() {

    data class MarketItem(
        var img: Int,
        var nama: String,
        var waktu: String,
        var berat: Int,
        var harga: Int
    )

    inner class ItemData_Holder(ItemLayout: View) : RecyclerView.ViewHolder(ItemLayout) {
        var Icon: ImageView = ItemLayout.findViewById(R.id.image_item_sell)
        var Name: TextView = ItemLayout.findViewById(R.id.judul_item_sell)
        var Berat: TextView = ItemLayout.findViewById(R.id.berat_item)
        var Waktu: TextView = ItemLayout.findViewById(R.id.waktu_tangkap)
        var Harga: TextView = ItemLayout.findViewById(R.id.harga_item_sell)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemData_Holder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_regular_market, parent, false)
        return ItemData_Holder(view)
    }

    override fun onBindViewHolder(holder: ItemData_Holder, position: Int) {
        val An_Item = Data[position]
        holder.Icon.setImageResource(An_Item.img)
        holder.Name.text = An_Item.nama
        holder.Berat.text = "${An_Item.berat} Kg"
        holder.Waktu.text = "Waktu tangkap: ${An_Item.waktu}"
        val txt = "Penawaran Terakhir:\nRp.${An_Item.harga}"
        holder.Harga.text = txt
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
        fun onItemClicked(data: MarketItem)
    }
}