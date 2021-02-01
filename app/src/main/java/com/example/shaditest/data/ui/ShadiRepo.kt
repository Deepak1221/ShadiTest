package com.example.shaditest.data.ui

 import com.example.deevideos.data.local.preferences.PrefManager
import com.example.deevideos.data.local.room_db.DbHelper
 import com.example.deevideos.utils.AppResource
 import com.example.shaditest.data.base.BaseRepo
 import com.example.shaditest.data.remote.ApiClient
 import com.example.shaditest.data.remote.IUserService
 import com.example.shaditest.data.ui.models.Results


class ShadiRepo(val apiClient: ApiClient, val dbHelper: DbHelper, val pref: PrefManager) :
    BaseRepo() {

    suspend fun getUserList(num: String): AppResource<List<Results>> {
        val apiService = apiClient.createService(IUserService::class.java)
        val response = apiService.getPerson(num)
        if (response.isSuccessful && !response.body()?.results.isNullOrEmpty()) {
            return AppResource.success(response.body()?.results)
        } else return AppResource.error("something went wrong", null)
    }

    suspend fun saveToDb(data: List<Results>?) {
        dbHelper.insertAllUsers(data!!)
    }

    suspend fun getUserFromDb(): List<Results> = dbHelper.getAllUsers()

    suspend fun updateUser(results: Results) {
        dbHelper.updateUser(results)
    }
}