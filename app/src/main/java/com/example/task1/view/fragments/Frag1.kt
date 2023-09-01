package com.example.task1.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.adapterPackage.VehicleAdapter
import com.example.task1.R
import com.example.task1.constants.Constants
import com.example.task1.viewModel.QuoteViewModel
import com.example.task1.viewModel.VehicleViewModel
import com.example.task1.model.Result1

class Frag1 : Fragment() ,VehicleAdapter.ItemClickListener{
    private lateinit var viewModel: QuoteViewModel
    private lateinit var viewModel1: VehicleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onItemClickListener(clickItem: Result1){
        val frag2=Frag2.newInstance()
        val args=Bundle()
        args.apply {
            putParcelable(Constants.KEY_VALUE,clickItem)
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
        val profileButton:ImageButton=view.findViewById(R.id.profileButton)
        val logoutButton:ImageButton=view.findViewById(R.id.logoutButton)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        quoteButton.setOnClickListener { viewModel.getRandomQuotes() }
        viewModel.response.observe(viewLifecycleOwner) { response ->
            quoteTextView.text = response
        }
        viewModel.getRandomQuotes()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel1 = ViewModelProvider(this).get(VehicleViewModel::class.java)
        viewModel1.getVehicleDatas()
        viewModel1.response1.observe(viewLifecycleOwner) { result ->
            val adapter = VehicleAdapter(result,this)
            recyclerView.adapter = adapter
        }
        profileButton.setOnClickListener {
        val frag3=Frag3Profile()
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container,frag3).commit()
        }
        logoutButton.setOnClickListener {
            val loginFrag=LoginFragment()
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container,loginFrag).commit()
        }
    }

}
