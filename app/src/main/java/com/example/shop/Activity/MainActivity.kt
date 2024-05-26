package com.example.shop.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.shop.Popular
import com.example.shop.PopularListAdapter
import com.example.shop.R

class MainActivity : AppCompatActivity() {

    private lateinit var adapterPopular: PopularListAdapter
    private lateinit var recyclerViewPopular: RecyclerView
    private lateinit var buttonCategory: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        bottom_navigation()
    }

    private fun bottom_navigation(){
        val homeBtn: LinearLayout = findViewById(R.id.homeBtn)
        val cartBtn: LinearLayout = findViewById(R.id.cartBtn)
        homeBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        cartBtn.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
    private fun init(){
        val items = ArrayList<Popular>()
        val imageResource = R.drawable.pic1
        val drawable = ContextCompat.getDrawable(this, imageResource)
        items.add(Popular("MacBook Pro 13 M2 chip", "", R.drawable.pic1, 15, 4.0, 500.0, 1))
        items.add(Popular("Ps-5 Digital", "", R.drawable.pic2, 10, 4.5, 450.0, 2))
        items.add(Popular("Iphone 14", "", R.drawable.pic3, 13, 4.2, 800.0, 3))

        adapterPopular = PopularListAdapter(items)

        recyclerViewPopular = findViewById(R.id.rv1)
        recyclerViewPopular.adapter = adapterPopular
    }

}
