package com.genm.pari.ui.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.database.User
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {

    lateinit var username: TextInputLayout
    lateinit var mpassword: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_login, container, false)

        username = root.findViewById(R.id.username)
        mpassword = root.findViewById(R.id.password)
        root.findViewById<Button>(R.id.singin).setOnClickListener {
            login()

        }

        root.findViewById<Button>(R.id.register).setOnClickListener {
            MainActivity.navController.navigate(R.id.fragment_register)
        }

        return root
    }

    fun login(){
        val db = User.NoteHelper.getInstance(requireContext())
        db.open()
        val cursor = db.queryAll()
        val data = User.MappingHelper.mapCursorToArrayList(cursor)
        db.close()

        //todo harusnya cari by id dari database
        for(x in 0..data.count()-1){
            if(data[x].username == username.editText?.text.toString()){
                if(data[x].password == mpassword.editText?.text.toString()){
                    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
                    with (sharedPref.edit()) {
                        putString("username", data[x].username)
                        MainActivity.username = data[x].username
                        putString("nama", data[x].nama_asli)
                        MainActivity.nama = data[x].nama_asli
                        putInt("nelayan", data[x].is_nelayan!!.toInt())
                        if(data[x].is_nelayan!!.toInt() == 1){
                            MainActivity.user_type = "Nelayan"
                        }
                        else{
                            MainActivity.user_type = "Regular"
                        }
                        apply()
                    }
                    MainActivity.navController.navigate(R.id.nelayan_ui)
                }
                else{
                    Toast.makeText(activity, "password salah", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}