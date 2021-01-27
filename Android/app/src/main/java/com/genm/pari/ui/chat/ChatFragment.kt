package com.genm.pari.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.adapter.ChatFragmentAdapter
import com.genm.pari.adapter.MarketNelayanFragment_Adapter
import com.genm.pari.ui.home.HomeAndChatFragment
import com.genm.pari.ui.market.MarketNelayanFragment

class ChatFragment : Fragment() {


    lateinit var myRecyclerView: RecyclerView
    companion object{
        val chatList = arrayListOf<ChatFragmentAdapter.ListItem>(
                ChatFragmentAdapter.ListItem(R.drawable.fish_demo, "andi", "giue iwuw  wui gigw dd"),
                ChatFragmentAdapter.ListItem(R.drawable.fish_demo, "romaIrama", "uiehiure iufdudv sihoi euhuihisues oios soi ugiugi"),
                ChatFragmentAdapter.ListItem(R.drawable.fish_demo, "gon", "hiuhwi  iqe oifsobh aiuao adh iuy yuuyitt")
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_chat, container, false)
        myRecyclerView = root.findViewById(R.id.chat_list)
        myRecyclerView.setHasFixedSize(true)
        SetAdapter()

        val topAppBar: Toolbar = root.findViewById(R.id.topAppBar)
        topAppBar.setNavigationOnClickListener {
            HomeAndChatFragment.viewPager.setCurrentItem(0)
        }
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
        myRecyclerView.layoutManager = LinearLayoutManager(getActivity())
        val ListAdapter = ChatFragmentAdapter(chatList)
        myRecyclerView.adapter = ListAdapter

        ListAdapter.onItemClick = {
            MainActivity.navController.navigate(R.id.fragment_messages)
        }
    }
}