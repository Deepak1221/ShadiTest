package com.example.deevideos.data.local.room_db
import com.example.shaditest.data.ui.models.Results


class DbHelperImpl(private val appDb : AppDB):DbHelper  {
    override suspend fun getAllUsers()= appDb.userDao().getAllUsers()
    override suspend fun insertAllUsers(videos: List<Results>) = appDb.userDao().insertAll(videos)
    override suspend fun updateUser(user: Results) {
        appDb.userDao().updateUser(user)
    }


}