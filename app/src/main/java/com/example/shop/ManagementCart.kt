package com.example.shop.Activity

import android.content.Context
import android.widget.Toast
import com.example.shop.Popular
import com.example.shop.TinyDB

class ManagementCart(private var context: Context, private var tinyDB: TinyDB = TinyDB(context)) {
    fun insertFood(item: Popular) {
        val listPop: ArrayList<Popular> = getListCard()
        var existAlready: Boolean = false
        var n: Int = 0
        for (i in listPop.indices) {
            if (listPop.get(i).title.equals(item.title)) {
                existAlready = true
                n = 1
                break
            }
        }
        if (existAlready) {
            listPop.get(n).numberInCart = item.numberInCart
        } else {
            listPop.add(item)
        }
        tinyDB.putListObject("CartList", listPop)
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show()
    }

    fun getListCard(): ArrayList<Popular> {
        return tinyDB.getListObject("CartList")
    }

    fun minusNumberItem(listItem: ArrayList<Popular>, position: Int, changeNumberItemListener: ChangeNumberItemListener) {
        if (listItem.get(position).numberInCart == 1){
            listItem.removeAt(position)
        } else  {
            listItem.get(position).numberInCart = listItem.get(position).numberInCart - 1
        }
        tinyDB.putListObject("CartList", listItem)
        changeNumberItemListener.change()
    }
    fun plusNumberItem(listItem: ArrayList<Popular>, position: Int, changeNumberItemListener: ChangeNumberItemListener) {
        listItem.get(position).numberInCart = listItem.get(position).numberInCart + 1
        tinyDB.putListObject("CartList", listItem)
        changeNumberItemListener.change()
    }
    fun getTotalFee(): Double{
        val listItem: ArrayList<Popular> = getListCard()
        var fee: Double = 0.0
        for (i in listItem.indices) {
            fee = fee + (listItem.get(i).price * listItem.get(i).numberInCart)
        }
        return fee
    }
}