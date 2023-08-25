package com.example.task1.adapterPackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.model.Result1
import com.example.task1.R

class VehicleAdapter(val list:List<Result1>, val i1:ItemClickListener):RecyclerView.Adapter<VehicleAdapter.ViewHolder>(){
interface ItemClickListener{
    fun onItemClickListener(clickItem:Result1)
}
inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
    var countryTextView:TextView=view.findViewById(R.id.countryTextview)
    var commonNameTextView:TextView=view.findViewById(R.id.commonNameTextView)
    val navLayout:ConstraintLayout=view.findViewById(R.id.navlayout)

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutView=LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false)
        return ViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listData=list[position]
        holder.commonNameTextView.text=listData.Mfr_CommonName
        holder.countryTextView.text=listData.Country
        holder.navLayout.setOnClickListener {
            val clickItem = list[position]
            i1.onItemClickListener(clickItem)
        }

       }

        }

