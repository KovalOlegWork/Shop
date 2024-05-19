package com.example.shop

import android.app.Application
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [Popular::class], version = 2, exportSchema = false)
abstract class PopularDB  : RoomDatabase() {
    abstract fun notesDao(): PopularDao?

    companion object {
        private var instance: PopularDB? = null
        private const val DB_NAME = "items_db"
        fun getInstance(application: Application?): PopularDB? {
            if (instance == null) {
                instance = databaseBuilder(
                    application!!,
                    PopularDB::class.java, DB_NAME
                ).build()
            }
            return instance
        }
    }
}
