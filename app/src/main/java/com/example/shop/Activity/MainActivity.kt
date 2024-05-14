package com.example.shop.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.Popular
import com.example.shop.PopularListAdapter
import com.example.shop.R

class MainActivity : AppCompatActivity() {

    private lateinit var adapterPopular: RecyclerView.Adapter
    private lateinit var recyclerViewPopular: RecyclerView
    private lateinit var buttonHome: Button
    private lateinit var buttonCategory: Button
    private lateinit var buttonBasket: Button
    private lateinit var buttonChosen: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        buttonCategory.setOnClickListener {
            intent = CategoryActivity.categoryIntent(this)
            startActivity(intent)
        }
    }
    private fun init(){
        val items = ArrayList<Popular>()
        items.add(Popular("MacBook Pro 13 M2 chip", "", "pic1", 15, 4.0, 500.0))
        items.add(Popular("Ps-5 Digital", "", "pic2", 10, 4.5, 450.0))
        items.add(Popular("Iphone 14", "", "pic3", 13, 4.2, 800.0))
        recyclerViewPopular = findViewById(R.id.view1)
        recyclerViewPopular.layoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterPopular = PopularListAdapter(items)
        recyclerViewPopular.adapter(adapterPopular)
    }
    companion object {
        fun homeIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

}