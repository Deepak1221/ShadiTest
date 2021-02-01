package com.example.deevideos.data.local.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.deevideos.data.local.room_db.dao.UserDao
 import com.example.shaditest.data.ui.models.Results

@Database(entities = [Results::class],version = 1)
abstract class AppDB :RoomDatabase() {
    abstract fun  userDao():UserDao

}