package com.example.recyclerviewapp
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
class MyRecyclerViewAdapter(val list: List<String>) : RecyclerView.Adapter<MyViewHolder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return MyViewHolder(itemView)
    }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.positionText.text = position.toString()
        holder.titleText.text = list[position]
    }

     override fun getItemCount(): Int = list.size
}