package com.genm.pari.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.MainActivity
import com.genm.pari.R

class ChatContent_Adapter(val Data: ArrayList<ListItem>): RecyclerView.Adapter<ChatContent_Adapter.ItemData_Holder>() {

    data class ListItem(
            var user: String,
            var content: String,
            var time: String,
            var date: String,
            var IsFistAtThatDate: Boolean
    )

    inner class ItemData_Holder(ItemLayout: View): RecyclerView.ViewHolder(ItemLayout){
        var time: TextView = ItemLayout.findViewById(R.id.time)
        var incoming_con : LinearLayout = ItemLayout.findViewById(R.id.incoming)
        var incoming_text: TextView = ItemLayout.findViewById(R.id.incoming_text)
        var incoming_time: TextView = ItemLayout.findViewById(R.id.incoming_time)

        var outgoing_con : LinearLayout = ItemLayout.findViewById(R.id.outgoing)
        var outgoing_text: TextView = ItemLayout.findViewById(R.id.outgoing_text)
        var outgoing_time: TextView = ItemLayout.findViewById(R.id.outgoing_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemData_Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_content, parent, false)
        return ItemData_Holder(view)
    }

    override fun onBindViewHolder(holder: ItemData_Holder, position: Int) {
        val An_Item = Data[position]
        if(An_Item.IsFistAtThatDate){
            holder.time.text = An_Item.date
        }
        else{
            holder.time.visibility = View.GONE
        }
        //todo sama dengan di baris pertama block companion object main activity
        if(An_Item.user == MainActivity.username){
            holder.incoming_con.visibility = View.GONE
            holder.outgoing_text.text = An_Item.content
            holder.outgoing_time.text = An_Item.time
        }
        else{
            holder.outgoing_con.visibility = View.GONE
            holder.incoming_text.text = An_Item.content
            holder.incoming_time.text = An_Item.time
        }
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