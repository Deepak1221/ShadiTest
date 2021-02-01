package com.example.shaditest.ui

 import com.example.deevideos.data.local.preferences.PrefManager
import com.example.deevideos.data.local.room_db.DbHelper
 import com.example.deevideos.utils.AppResource
 import com.example.shaditest.data.base.BaseRepo
 import com.example.shaditest.data.remote.ApiClient
 import com.example.shaditest.data.remote.IUserService
 import com.example.shaditest.ui.models.Results
 import com.example.shaditest.data.local_db.entity.dbModels.User


class ShadiRepo(val apiClient: ApiClient, val dbHelper: DbHelper, val pref: PrefManager) : BaseRepo() {

    suspend fun getUserList(num: String): AppResource<List<Results>> {
        val apiService = apiClient.createService(IUserService::class.java)
        val response = apiService.getPerson(num)
        if (response.isSuccessful && !response.body()?.results.isNullOrEmpty()) {
            return AppResource.success(response.body()?.results)
        } else return AppResource.error("something went wrong", null)
    }

    suspend fun saveToDb(data: List<User>?) {
        dbHelper.insertAllUsers(data!!)
    }

    suspend fun getUserFromDb(): List<User> = dbHelper.getAllUsers()

    suspend fun updateUser(results: User) {
        dbHelper.updateUser(results)
    }
}