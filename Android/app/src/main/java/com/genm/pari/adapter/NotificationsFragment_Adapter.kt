package com.genm.pari.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.R

class NotificationsFragment_Adapter(val Data: ArrayList<NotificationItem>): RecyclerView.Adapter<NotificationsFragment_Adapter.ItemData_Holder>() {
    data class NotificationItem(
            var title: String,
            var content: String,
            var time: String
    )

    inner class ItemData_Holder(ItemLayout: View):RecyclerView.ViewHolder(ItemLayout){
        var title: TextView = ItemLayout.findViewById(R.id.notification_title)
        var content: TextView = ItemLayout.findViewById(R.id.notification_content)
        var time: TextView = ItemLayout.findViewById(R.id.notification_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsFragment_Adapter.ItemData_Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false)
        return ItemData_Holder(view)
    }

    override fun onBindViewHolder(holder: NotificationsFragment_Adapter.ItemData_Holder, position: Int) {
        val An_Item = Data[position]
        holder.title.text = An_Item.title
        holder.content.text = An_Item.content
        holder.time.text = An_Item.time
    }

    override fun getItemCount(): Int {
        return Data.size
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: NotificationItem)
    }


}