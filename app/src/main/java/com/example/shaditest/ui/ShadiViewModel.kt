package com.example.shaditest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deevideos.utils.AppResource
 import com.example.shaditest.data.base.BaseRepo
import com.example.shaditest.ui.models.Results
import com.example.shaditest.data.local_db.entity.dbModels.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShadiViewModel(repo: BaseRepo) :ViewModel() {
    private  val shadiRepo :ShadiRepo
    init {
        shadiRepo = repo as ShadiRepo
    }

    private var listLiveData = MutableLiveData<AppResource<List<User>>>()
    fun fetchUserList(num: String) {
         viewModelScope.launch {
            listLiveData.postValue(AppResource.loading(null))
            try {
                val userFromDb = shadiRepo.getUserFromDb()
                if (userFromDb.isNullOrEmpty()) {
                    val mListHolder = shadiRepo.getUserList(num)
                    saveToDb(mListHolder.data)
                   // listLiveData.postValue(mListHolder)
                } else {
                    listLiveData.postValue(AppResource.success(userFromDb))
                }

            } catch (e: Exception) {
                listLiveData.postValue(AppResource.error(e.toString(), null))
            }
        }
    }

 inline  suspend  private fun saveToDb(data: List<Results>?) {
       withContext(Dispatchers.IO){
           if (data != null) {
               val usersListForDB = mutableListOf<User>()
               for(apiRespone in data){
                   val name = DbName(apiRespone.name?.first)
                   val location = DbLocation(apiRespone.location?.city, apiRespone.location?.state)
                   val uid = apiRespone.login?.uuid
                   val login = DbLogin(apiRespone.login?.uuid, apiRespone.login?.username)
                   val dob = DbDob(apiRespone.dob?.age)
                   val picture = DbPicture(apiRespone.picture?.large)
                   val user = User(
                           uid=uid!!,
                           name = name,
                           location = location,
                           login = login,
                           dob = dob,
                           picture = picture
                   )
                   usersListForDB.add(user)
               }
                   shadiRepo.saveToDb(usersListForDB)
               listLiveData.postValue(AppResource.success(usersListForDB))
           }
       }
    }

    fun getUserList( ): LiveData<AppResource<List<User>>> {
        return listLiveData
    }

    fun updateUser(results: User) {
        try {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    shadiRepo.updateUser(results)
                }
            }
        } catch (e: Exception) {
            e.stackTrace
        }

    }

}