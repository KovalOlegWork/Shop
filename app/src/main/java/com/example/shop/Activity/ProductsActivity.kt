package com.example.shop.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.Item
import com.example.shop.ProductsAdapter
import com.example.shop.R

class ProductsActivity : AppCompatActivity() {

    private lateinit var recyclerViewProducts: RecyclerView
    private lateinit var newArrayList: ArrayList<Item>
    private lateinit var adapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        init()
        recyclerViewProducts.layoutManager = LinearLayoutManager(this)
        newArrayList = arrayListOf<Item>()
        list()
        recyclerViewProducts.adapter = adapter
        val items = list()
        adapter = ProductsAdapter(items)
    }

    private fun init(){
        recyclerViewProducts = findViewById(R.id.recyclerViewProducts)
    }
    companion object {
        fun productsIntent(context: Context): Intent {
            return Intent(context, ProductsActivity::class.java)
        }
    }
    private fun list(): MutableList<Item> {
        val items = mutableListOf<Item>()
        for (i in 1 .. 13){
            items.add(Item("Text $i", false))
        }
        return items
    }
}