package com.genm.pari.ui.login

import android.content.ContentValues
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.database.User
import com.google.android.material.textfield.TextInputLayout


class RegisterFragment : Fragment() {

    lateinit var email: TextInputLayout
    lateinit var username: TextInputLayout
    lateinit var nama: TextInputLayout
    lateinit var nelayan: TextInputLayout
    lateinit var upassword: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_register, container, false)
        email = root.findViewById(R.id.email)
        username = root.findViewById(R.id.username)
        nama = root.findViewById(R.id.nama)
        nelayan = root.findViewById(R.id.is_nelayan)
        upassword = root.findViewById(R.id.password)
        root.findViewById<Button>(R.id.daftar).setOnClickListener {
            insertData()
            MainActivity.navController.navigate(R.id.fragment_login)
        }
        //masukkan item ke dropdown jenis nelayan
        val items = listOf("Nelayan", "Regular")
        val adapter = ArrayAdapter(requireContext(), R.layout.item_jenis_nelayan, items)
        (root.findViewById<TextInputLayout>(R.id.is_nelayan).editText as? AutoCompleteTextView)?.setAdapter(adapter)
        return root
    }

    fun insertData(){
        val values = ContentValues()
        values.put(User.DatabaseContract.NoteColumns._ID, username.editText?.text.toString())
        values.put(User.DatabaseContract.NoteColumns.EMAIL, email.editText?.text.toString())
        values.put(User.DatabaseContract.NoteColumns.NAMA, nama.editText?.text.toString())
        val txt = nelayan.editText?.text.toString()
        if(txt == "Nelayan"){
            values.put(User.DatabaseContract.NoteColumns.nelayan, 1)
        }
        else{
            values.put(User.DatabaseContract.NoteColumns.nelayan, 0)
        }
        values.put(User.DatabaseContract.NoteColumns.password, upassword.editText?.text.toString())
        val db = User.NoteHelper.getInstance(requireContext())
        db.open()
        db.insert(values)
        db.close()
    }


}