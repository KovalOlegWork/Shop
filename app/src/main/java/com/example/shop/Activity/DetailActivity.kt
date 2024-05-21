package com.example.shop.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.shop.Popular
import com.example.shop.R

class DetailActivity : AppCompatActivity() {

    private lateinit var addToCartBtn: Button
    private lateinit var titleText: TextView
    private lateinit var feeText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var reviewText: TextView
    private lateinit var scoreText: TextView
    private lateinit var picItem: ImageView
    private lateinit var backBtn: ImageView
    private lateinit var objekt: Popular
    private lateinit var managementCart: ManagementCart
    private var numberOrder: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        managementCart = ManagementCart(this)
        setContentView(R.layout.activity_detail)
        initView()

    }

    private fun getBundle(){
        objekt = (Popular) getIntent().getSerializableExtra("object")
        val drawableResourceId: Int = this.resources.getIdentifier(objekt.picUrl.toString(), "drawable", this.packageName)
        Glide.with(this)
            .load(drawableResourceId)
            .into(picItem)
        titleText.setText(objekt.title)
        feeText.setText("$"+objekt.price)
        descriptionText.setText(objekt.description)
        reviewText.setText(""+objekt.review)
        scoreText.setText(""+objekt.score)
        addToCartBtn.setOnClickListener{
            objekt.numberInCart = numberOrder
            managementCart.insertFood(objekt)
        }
        backBtn.setOnClickListener{
            finish()
        }
    }

    private fun initView(){
        addToCartBtn = findViewById(R.id.addToCartBtn)
        feeText = findViewById(R.id.priceText)
        titleText = findViewById(R.id.titleText)
        descriptionText = findViewById(R.id.descriptionText)
        picItem = findViewById(R.id.itemPic)
        backBtn = findViewById(R.id.backBtn)
        reviewText = findViewById(R.id.reviewText)
        scoreText = findViewById(R.id.scoreText)
    }
}