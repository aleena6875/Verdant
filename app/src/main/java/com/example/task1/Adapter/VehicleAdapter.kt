package com.example.task1.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.Model.Result1
import com.example.task1.R
import androidx.navigation.fragment.findNavController
import com.example.task1.View.Fragments.Frag1
import com.google.android.material.animation.AnimatableView.Listener

class VehicleAdapter(var list:List<Result1>, val i1:ItemClickListener):RecyclerView.Adapter<VehicleAdapter.ViewHolder>(){
interface ItemClickListener{
    fun OnItemClickListener(clickItem:Result1)
}
inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
    var countryTextView:TextView=view.findViewById(R.id.countryTextview)
    var commonNameTextView:TextView=view.findViewById(R.id.commonNameTextView)
    val navLayout:ConstraintLayout=view.findViewById(R.id.navlayout)
    init {
        navLayout.setOnClickListener{
            val clickItem=list[adapterPosition]
            i1.OnItemClickListener(clickItem)
        }
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutView=LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false)
        return ViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listData=list[position]
        holder.countryTextView.text=listData.Country
        holder.commonNameTextView.text=listData.Mfr_CommonName


       }

        }

