package com.example.deevideos.data.local.room_db
import com.example.shaditest.data.local_db.entity.dbModels.User

interface DbHelper {
    suspend fun getAllUsers():List<User>
    suspend fun insertAllUsers(users: List<User>)
    suspend fun updateUser(user : User)

}