package com.example.shop

data class Item(
    var name: String,
    var isChosen: Boolean,
    var id: Int = UNDEFINED_ID
)
{
    companion object {
        const val UNDEFINED_ID = -1
    }
}