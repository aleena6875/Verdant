package com.example.task1.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.adapterPackage.VehicleTypeAdapter
import com.example.task1.model.Result1
import com.example.task1.R
import com.example.task1.constants.Constants

class Frag2 : Fragment() {

    private lateinit var recycler_view:RecyclerView




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

     val inflated= inflater.inflate (R.layout.fragment_frag2, container, false)
        recycler_view = inflated.findViewById(R.id.recyclerview2)
        return inflated
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.apply {
            val commonnametext: TextView = view.findViewById(R.id.commonnametext)
            val countrytextView: TextView = view.findViewById(R.id.countrytextView)
            val mfridtext: TextView = view.findViewById(R.id.mfridtext)
            val mfrnametext: TextView = view.findViewById(R.id.mfrnametext)

            arguments?.getParcelable<Result1>(Constants.KEY_VALUE)?.let { getdata ->
                commonnametext.text = "Mfr_CommonName:${getdata.Mfr_CommonName}"
                countrytextView.text = "Country:${getdata.Country}"
                mfridtext.text = "Mfr_ID: ${getdata.Mfr_ID.toString()}"
                mfrnametext.text = "Mfr_Name: ${getdata.Mfr_Name}"

                recycler_view.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = getdata?.VehicleTypes?.let { VehicleTypeAdapter(it) }
                }

            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance()=Frag2()
    }
}