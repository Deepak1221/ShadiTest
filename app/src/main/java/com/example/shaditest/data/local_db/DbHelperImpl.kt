package com.example.deevideos.data.local.room_db
import com.example.shaditest.data.local_db.entity.dbModels.User


class DbHelperImpl(private val appDb : AppDB):DbHelper  {
    override suspend fun getAllUsers()= appDb.userDao().getAllUsers()
    override suspend fun insertAllUsers(videos: List<User>) = appDb.userDao().insertAll(videos)
    override suspend fun updateUser(user: User) {
        appDb.userDao().updateUser(user)
    }


}