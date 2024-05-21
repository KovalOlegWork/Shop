package com.example.shop.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.CartListAdapter
import com.example.shop.R

class CartActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerView.Adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var managementCart: ManagementCart
    private lateinit var totalFeeText: TextView
    private lateinit var taxText: TextView
    private lateinit var deliveryText: TextView
    private lateinit var totalText: TextView
    private lateinit var emptyText: TextView
    private var tax: Double = 0.0
    private lateinit var scrollView: ScrollView
    private lateinit var backBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        managementCart = ManagementCart(this)
        initView()
        setVariable()
        initList()
        calculateCart()
    }

    private fun initList(){
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        adapter = CartListAdapter(managementCart.getListCard(), this,
            object : ChangeNumberItemListener {
                override fun change() {
                    calculateCart()
                }
            })
        recyclerView.adapter = adapter
        if (managementCart.getListCard().isEmpty()){
            emptyText.visibility = View.VISIBLE
            scrollView.visibility = View.GONE
        } else {
            emptyText.visibility = View.GONE
            scrollView.visibility = View.VISIBLE
        }
    }

    private fun setVariable(){
        backBtn.setOnClickListener{
            finish()
        }
    }
    private fun calculateCart(){
        var percentTax: Double = 0.02
        var delivery: Double = 10.0
        tax = Math.round((managementCart.getTotalFee()*percentTax*100.0)) / 100.0
        val total: Double = Math.round((managementCart.getTotalFee()+tax+delivery)*100.0) / 100.0
        val itemTotal: Double = Math.round((managementCart.getTotalFee())*100.0) / 100.0
        totalFeeText.setText("$"+itemTotal)
        taxText.setText("$"+tax)
        deliveryText.setText("$"+delivery)
        totalText.setText("$"+total)
    }

    private fun initView(){
        totalFeeText = findViewById(R.id.totalFeeText)
        taxText = findViewById(R.id.taxText)
        deliveryText = findViewById(R.id.deliveryText)
        totalText = findViewById(R.id.totalText)
        recyclerView = findViewById(R.id.rv3)
        scrollView = findViewById(R.id.scrollViewCart)
        backBtn = findViewById(R.id.backBtn)
        emptyText = findViewById(R.id.emptyText)
    }
}