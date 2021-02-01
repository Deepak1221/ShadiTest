package com.example.deevideos.data.local.room_db.dao

import androidx.room.*
import com.example.shaditest.data.ui.models.Results


@Dao
interface UserDao {
    @Query("SELECT * FROM Results")
    suspend fun getAllUsers(): List<Results>
    @Insert
    suspend fun insertAll(users: List<Results>)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(users:  Results)
   }