package com.example.task1.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.Model.VehicleType
import com.example.task1.R


class VehicleTypeAdapter(var list:List<VehicleType>): RecyclerView.Adapter<VehicleTypeAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var t1: TextView =view.findViewById(R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view2,parent,false)
        return ViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listData =list[position]
        holder.t1.text=listData.Name

    }
}
