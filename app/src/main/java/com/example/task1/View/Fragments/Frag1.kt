package com.example.task1.View.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.Adapter.VehicleAdapter
import com.example.task1.R
import com.example.task1.ViewModel.QuoteViewModel
import com.example.task1.ViewModel.VehicleViewModel
import com.example.task1.Model.Result1


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Frag1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Frag1 : Fragment() ,VehicleAdapter.ItemClickListener{
    private lateinit var viewModel: QuoteViewModel
    private lateinit var viewModel1: VehicleViewModel



    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun OnItemClickListener(clickItem: Result1){
        val frag2=Frag2.newInstance("","")
        val args=Bundle()
        args.apply {
            putParcelable("country",clickItem)
        }
        frag2.arguments=args
        parentFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragment_container,frag2,"Fragment2").commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
return inflater.inflate(R.layout.fragment_frag1, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)
        val quoteTextView: TextView = view.findViewById(R.id.quoteTextview)
        val quoteButton: Button = view.findViewById(R.id.quoteButton)
        quoteButton.setOnClickListener { viewModel.getRandomQuotes() }
        viewModel.response.observe(viewLifecycleOwner) { response ->
            quoteTextView.text = response[0]

        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel1 = ViewModelProvider(this).get(VehicleViewModel::class.java)
        viewModel1.getVehicleDatas()
        viewModel1.response1.observe(viewLifecycleOwner) { result ->
            var adapter = VehicleAdapter(result,this)

            recyclerView.adapter = adapter


        }

    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Frag1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Frag1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
