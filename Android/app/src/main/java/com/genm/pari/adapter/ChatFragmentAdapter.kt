package com.genm.pari.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.R


class ChatFragmentAdapter(val Data: ArrayList<ListItem>): RecyclerView.Adapter<ChatFragmentAdapter.ItemData_Holder>() {

    data class ListItem(
            var avatar: Int,
            var username: String,
            var lastchat: String
    )

    inner class ItemData_Holder(ItemLayout: View): RecyclerView.ViewHolder(ItemLayout){
        var avatar: ImageView = ItemLayout.findViewById(R.id.avatar)
        var username: TextView = ItemLayout.findViewById(R.id.username)
        var lastchat: TextView = ItemLayout.findViewById(R.id.last_chat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemData_Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ItemData_Holder(view)
    }

    override fun onBindViewHolder(holder: ItemData_Holder, position: Int) {
        val An_Item = Data[position]
        holder.avatar.setImageResource(An_Item.avatar)
        holder.username.text = An_Item.username
        holder.lastchat.text = An_Item.lastchat
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
        fun onItemClicked(data: ListItem)
    }

}