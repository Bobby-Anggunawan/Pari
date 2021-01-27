package com.genm.pari.ui.article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.genm.pari.JavaFunction
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.ui.MainUIFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class ArticleFragment : Fragment() {

    lateinit var myWebView: WebView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_article, container, false)
        myWebView = root.findViewById(R.id.articleWebView) as WebView

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
        JavaFunction.setMargins(MainUIFragment.main_con, true)
        MainUIFragment.navView.visibility = View.VISIBLE
        MainUIFragment.nav_top_corner.visibility = View.VISIBLE
        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myWebView.loadUrl("https://www.google.com/")
    }
}