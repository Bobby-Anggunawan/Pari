package com.genm.pari.ui.market.regular

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import com.genm.pari.R


class MarketItemFragment : Fragment() {

    companion object{
        lateinit var rating: RatingBar
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_market_item, container, false)
        root.findViewById<RatingBar>(R.id.rating).rating = 4.2f
        root.findViewById<Button>(R.id.tawar_btn).setOnClickListener {
            CreateDialog()
        }
        val topAppBar: Toolbar = root.findViewById(R.id.topAppBar)
        topAppBar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
        return root
    }


    fun CreateDialog(){
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_market_item_regular)
        val harga = dialog.findViewById<EditText>(R.id.editTextNumber).text
        val yesBtn = dialog.findViewById(R.id.ok) as Button
        val noBtn = dialog.findViewById(R.id.cancel) as Button
        yesBtn.setOnClickListener {
            Toast.makeText(activity, "Masukkan anda: $harga", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

}