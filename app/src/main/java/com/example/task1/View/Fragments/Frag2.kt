package com.example.task1.View.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.Adapter.VehicleAdapter
import com.example.task1.Adapter.VehicleTypeAdapter
import com.example.task1.Model.Result1
import com.example.task1.Model.Vehicle
import com.example.task1.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Frag2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Frag2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var recycler_view:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     var inflated= inflater.inflate (R.layout.fragment_frag2, container, false)
        with(inflated){
//            text1=findViewById(R.id.text1)
            recycler_view = findViewById(R.id.recyclerview2)
        }
        return inflated
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val commonnametext:TextView=view.findViewById(R.id.commonnametext)
        val countrytextView:TextView=view.findViewById(R.id.countrytextView)
        val mfridtext:TextView=view.findViewById(R.id.mfridtext)
       val mfrnametext:TextView=view.findViewById(R.id.mfrnametext)
        val getdata=arguments?.getParcelable<Result1>("country")
        val mfrcname="Mfr_CommonName:${getdata?.Mfr_CommonName}"
        commonnametext.text=mfrcname
        val countryname="Country:${getdata?.Country}"
        countrytextView.text=countryname
        val mfrid = "Mfr_ID: ${getdata?.Mfr_ID.toString()}"
        mfridtext.text =mfrid

        val mfrname = "Mfr_Name: ${getdata?.Mfr_Name}"
        mfrnametext.text = mfrname
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        var adapter = getdata?.VehicleTypes?.let { VehicleTypeAdapter(it) }
        recycler_view.adapter = adapter



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Frag2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Frag2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}