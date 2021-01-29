package com.genm.pari.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.genm.pari.MainActivity
import com.genm.pari.R


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_login, container, false)

        root.findViewById<Button>(R.id.register).setOnClickListener {
            MainActivity.navController.navigate(R.id.fragment_register)
        }

        return root
    }
}