package com.example.shop

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CategoryActivity : AppCompatActivity() {

    private lateinit var buttonProducts: Button
    private lateinit var buttonClothes: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        init()
        buttonProducts.setOnClickListener {
            intent = ProductsActivity.productsIntent(this)
            startActivity(intent)
        }
    }

    private fun init(){
        buttonProducts = findViewById(R.id.buttonProducts)
        buttonClothes = findViewById(R.id.buttonClothes)
    }
    companion object {
        fun categoryIntent(context: Context): Intent {
            return Intent(context, CategoryActivity::class.java)
        }
    }

}