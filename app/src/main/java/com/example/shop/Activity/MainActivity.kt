package com.example.shop.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewMain: RecyclerView
    private lateinit var buttonHome: Button
    private lateinit var buttonCategory: Button
    private lateinit var buttonBasket: Button
    private lateinit var buttonChosen: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*init()
        buttonCategory.setOnClickListener {
            intent = CategoryActivity.categoryIntent(this)
            startActivity(intent)
        }*/
    }
    /*private fun init(){
        recyclerViewMain = findViewById(R.id.recyclerViewMain)
        buttonHome = findViewById(R.id.buttonHome)
        buttonCategory = findViewById(R.id.buttonCategory)
        buttonBasket = findViewById(R.id.buttonBasket)
        buttonChosen = findViewById(R.id.buttonChosen)
    }*/
    companion object {
        fun homeIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

}