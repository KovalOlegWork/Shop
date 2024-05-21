package com.example.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.example.shop.Activity.ChangeNumberItemListener
import com.example.shop.Activity.ManagementCart

class CartListAdapter(var listItemSelected: ArrayList<Popular>, var context: Context, var changeNumberItemListener: ChangeNumberItemListener) :
    RecyclerView.Adapter<CartListAdapter.ViewHolder>() {

    private lateinit var managementCart: ManagementCart
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartListAdapter.ViewHolder, position: Int) {
        holder.title.setText(listItemSelected.get(position).title)
        holder.feeEachItem.setText("$"+listItemSelected.get(position).price)
        holder.feeEachItem.setText("$"+Math.round(listItemSelected.get(position).numberInCart * listItemSelected.get(position).price))
        holder.num.setText((listItemSelected.get(position).numberInCart).toString())

        val drawableResourceId: Int = holder.itemView.context.resources
            .getIdentifier(listItemSelected.get(position).picUrl.toString(), "drawable", holder.itemView.context.packageName)

        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .transform(GranularRoundedCorners(30f, 30f, 30f, 30f))
            .into(holder.pic)

        holder.plusItem.setOnClickListener{
            managementCart.plusNumberItem(listItemSelected, position,
                object : ChangeNumberItemListener {
                    override fun change() {
                        notifyDataSetChanged()
                        changeNumberItemListener.change()
                    }
                })
        }
        holder.minusItem.setOnClickListener{
            managementCart.minusNumberItem(listItemSelected, position,
                object : ChangeNumberItemListener {
                    override fun change() {
                        notifyDataSetChanged()
                        changeNumberItemListener.change()
                    }
                })
        }
    }

    override fun getItemCount(): Int {
        return listItemSelected.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.titleText)
        val feeEachItem = itemView.findViewById<TextView>(R.id.feeEachItem)
        val totalEachItem = itemView.findViewById<TextView>(R.id.totalEachItem)
        val pic = itemView.findViewById<ImageView>(R.id.pic)
        val plusItem = itemView.findViewById<TextView>(R.id.plusCartBtn)
        val minusItem = itemView.findViewById<TextView>(R.id.minusCartBtn)
        val num = itemView.findViewById<TextView>(R.id.numberItemText)
    }
}