package com.example.shop

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.example.shop.Activity.DetailActivity

class PopularListAdapter(var items: ArrayList<Popular>) :
    RecyclerView.Adapter<PopularListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pop_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.titleText.text = item.title
        holder.feeText.text = "$"+item.price.toString()
        holder.scoreText.text = ""+item.score.toString()

        val drawableResourceId: Int = holder.itemView.context.resources
            .getIdentifier(items.get(position).picUrl.toString(), "drawable", holder.itemView.context.packageName)

        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .transform(GranularRoundedCorners(30f, 30f, 30f, 30f))
            .into(holder.pic)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.TITLE, item.title)
            intent.putExtra(DetailActivity.PRICE, item.price)
            intent.putExtra(DetailActivity.SCORE, item.score)
            intent.putExtra(DetailActivity.PIC_URL, item.picUrl)
            holder.itemView.context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText = itemView.findViewById<TextView>(R.id.titleText)
        val feeText = itemView.findViewById<TextView>(R.id.feeText)
        val scoreText = itemView.findViewById<TextView>(R.id.scoreText)
        val pic = itemView.findViewById<ImageView>(R.id.pic)
    }
}