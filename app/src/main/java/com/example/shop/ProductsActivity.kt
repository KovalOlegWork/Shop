package com.example.shop

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
    }
    companion object {
        fun productsIntent(context: Context): Intent {
            return Intent(context, ProductsActivity::class.java)
        }
    }
}