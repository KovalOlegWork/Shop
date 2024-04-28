package com.example.shop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(private val items: MutableList<Item>): RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ProductsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val item = items[position]
        holder.textViewName.text = item.name
        //holder.chosenStatus = item.isChosen.toString()
    }

    class ProductsViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val chosenStatus = view.findViewById<View>(R.id.chosenStatus)
    }
}