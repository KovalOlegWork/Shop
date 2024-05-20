package com.example.shop

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Popular(@PrimaryKey(autoGenerate = true) val title: String, val description: String, val picUrl: Int,
                   val review: Int, val score: Double, val price: Double, val numberInCart: Int) {
}