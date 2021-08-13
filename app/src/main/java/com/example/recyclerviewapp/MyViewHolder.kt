package com.example.recyclerviewapp

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.View
class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val positionText: TextView
    val titleText: TextView
    init {
        positionText = itemView.findViewById(R.id.position)
        titleText = itemView.findViewById(R.id.title)
    }
}