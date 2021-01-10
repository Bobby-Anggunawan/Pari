package com.genm.pari.ui.market

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.genm.pari.MainActivity
import com.genm.pari.R
import com.genm.pari.adapter.NelayanInsertFragment_Adapter

class NelayanInsertItemFragment : Fragment() {

    companion object{
        val daftarGambar = arrayListOf<Uri>()
    }
    val REQUEST_CODE = 200
    lateinit var myRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_nelayan_insert_item, container, false)
        MainActivity.actionBarBack.visibility = View.VISIBLE

        myRecyclerView = root.findViewById(R.id.recyclerView)
        myRecyclerView.setHasFixedSize(true)
        root.findViewById<Button>(R.id.select_image_button).setOnClickListener {
            openGalleryForImages()
        }

        SetAdapter()

        return root
    }


    fun SetAdapter(){
        myRecyclerView.layoutManager = GridLayoutManager(getActivity(), 3)
        val ListAdapter = NelayanInsertFragment_Adapter(daftarGambar)
        myRecyclerView.adapter = ListAdapter
    }

    private fun openGalleryForImages() {
        if (Build.VERSION.SDK_INT < 19) {
            var intent = Intent()
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                    Intent.createChooser(intent, "Choose Pictures")
                    , REQUEST_CODE
            )
        }
        else { // For latest versions API LEVEL 19+
            var intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE);
        }

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){

            // if multiple images are selected
            if (data?.getClipData() != null) {
                var count = data.clipData?.itemCount

                for (i in 0..count!!.toInt() - 1) {
                    var imageUri: Uri = data.clipData?.getItemAt(i)!!.uri
                    //iv_image.setImageURI(imageUri) Here you can assign your Image URI to the ImageViews
                    daftarGambar.add(imageUri)
                }

            } else if (data?.getData() != null) {
                // if single image is selected
                var imageUri: Uri? = data.data
                //iv_image.setImageURI(imageUri) Here you can assign the picked image uri to your imageview
                daftarGambar.add(imageUri!!)

            }
        }

        myRecyclerView.adapter?.notifyDataSetChanged()
    }

}