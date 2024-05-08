package com.example.shop

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PopularListAdapter(var context: Context) :
    RecyclerView.Adapter<PopularListAdapter.ViewHolder>() {
    lateinit var items: ArrayList<Popular>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularListAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PopularListAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return items.size
    }
    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText = itemView.findViewById<TextView>(R.id.titleText)
        val feeText = itemView.findViewById<TextView>(R.id.feeText)
    }
}