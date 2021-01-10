package com.genm.pari.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.R

class NelayanInsertFragment_Adapter(val Data: ArrayList<Uri>): RecyclerView.Adapter<NelayanInsertFragment_Adapter.ItemData_Holder>() {

    inner class ItemData_Holder(ItemLayout: View):RecyclerView.ViewHolder(ItemLayout){
        var Icon: ImageView = ItemLayout.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemData_Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_nelayan_upload_img, parent, false)
        return ItemData_Holder(view)
    }

    override fun onBindViewHolder(holder: ItemData_Holder, position: Int) {

        val An_Item = Data[position]
        holder.Icon.setImageURI(An_Item)
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
        fun onItemClicked(data: Uri)
    }
}