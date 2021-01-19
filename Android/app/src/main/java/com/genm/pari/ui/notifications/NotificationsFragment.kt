package com.genm.pari.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.adapter.NotificationsFragment_Adapter
import com.genm.pari.adapter.ToolFragment_Adapter
import com.genm.pari.ui.tool.ToolFragment
import com.google.android.material.transition.MaterialSharedAxis

class NotificationsFragment : Fragment() {


  companion object{
    val notificationList = arrayListOf<NotificationsFragment_Adapter.NotificationItem>(
            NotificationsFragment_Adapter.NotificationItem("Judul1", "Isi notifikasi 1", "8 Jan"),
            NotificationsFragment_Adapter.NotificationItem("Judul2", "Isi notifikasi 2", "9 Jan"),
            NotificationsFragment_Adapter.NotificationItem("Judul1", "Isi notifikasi 3", "9 Jan"),
    )
  }
  lateinit var myRecyclerView: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    //animation https://material.io/develop/android/theming/motion#shared-axis
    enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
    returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val root = inflater.inflate(R.layout.fragment_notifications, container, false)


    myRecyclerView = root.findViewById(R.id.notification_list)
    myRecyclerView.setHasFixedSize(true)
    SetAdapter()

    val topAppBar: Toolbar = root.findViewById(R.id.topAppBar)
    topAppBar.setNavigationOnClickListener {
      activity?.onBackPressed()
    }

    return root
  }


  fun SetAdapter(){
    myRecyclerView.layoutManager = LinearLayoutManager(getActivity())
    val ListAdapter = NotificationsFragment_Adapter(notificationList)
    myRecyclerView.adapter = ListAdapter
  }


}