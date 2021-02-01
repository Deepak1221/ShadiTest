package com.example.deevideos.data.local.room_db.dao

import androidx.room.*
import com.example.shaditest.data.local_db.entity.dbModels.User


@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    suspend fun getAllUsers(): List<User>
    @Insert
    suspend fun insertAll(users: List<User>)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(users:  User)
   }