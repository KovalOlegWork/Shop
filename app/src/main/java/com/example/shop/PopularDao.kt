package com.example.shop

import android.provider.ContactsContract
import androidx.contentpager.content.Query
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert

@Dao
interface PopularDao {


    @androidx.room.Query("SELECT * FROM items")
    fun getItems(): LiveData<List<ContactsContract.CommonDataKinds.Note?>?>?

    @Insert
    fun addItem(item: Popular)

    @androidx.room.Query("DELETE FROM items WHERE id = :id")
    fun remove(id: Int)
}