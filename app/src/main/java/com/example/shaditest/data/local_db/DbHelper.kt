package com.example.deevideos.data.local.room_db

import com.example.shaditest.data.ui.models.Results

interface DbHelper {
    suspend fun getAllUsers():List<Results>
    suspend fun insertAllUsers(users: List<Results>)
    suspend fun updateUser(user : Results)

}