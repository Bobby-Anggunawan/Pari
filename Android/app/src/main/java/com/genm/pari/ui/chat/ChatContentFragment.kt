package com.genm.pari.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.R
import com.genm.pari.adapter.ChatContent_Adapter
import com.genm.pari.adapter.ChatFragmentAdapter


class ChatContentFragment : Fragment() {

    lateinit var myRecyclerView: RecyclerView
    companion object{
        val message_list = arrayListOf<ChatContent_Adapter.ListItem>(
                ChatContent_Adapter.ListItem("Bobby", "auiuahusa iaus iuahsu aiu", "20:00", "16-01-2021", true),
                ChatContent_Adapter.ListItem("Stanley", "aiuhiea jjcnhsi siuhru", "20:01", "16-01-2021", false),
                ChatContent_Adapter.ListItem("Bobby", "huiah eahe hfb", "10:40", "17-01-2021", true),
                ChatContent_Adapter.ListItem("Stanley", "ahwuhi aueud fuisrh rui xiuxux urhai", "01:00", "18-01-2021", true)
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_chat_content, container, false)
        myRecyclerView = root.findViewById(R.id.message_list)
        myRecyclerView.setHasFixedSize(true)
        SetAdapter()
        return root
    }

    fun SetAdapter(){
        myRecyclerView.layoutManager = LinearLayoutManager(getActivity())
        val ListAdapter = ChatContent_Adapter(message_list)
        myRecyclerView.adapter = ListAdapter

        ListAdapter.setOnItemClickCallback(object : ChatContent_Adapter.OnItemClickCallback {
            override fun onItemClicked(data: ChatContent_Adapter.ListItem) {
                //todo, gak bisa di klik waktu di tes pake toast. Tapi kayaknya lebih baik gak pae ini tapi ganti imageview jadi imagebutton
            }
        })
    }



}