package com.example.shaditest.data.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deevideos.utils.AppResource
 import com.example.shaditest.data.base.BaseRepo
import com.example.shaditest.data.ui.models.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShadiViewModel(repo: BaseRepo) :ViewModel() {
    private  val shadiRepo :ShadiRepo
    init {
        shadiRepo = repo as ShadiRepo
    }

    private var listLiveData = MutableLiveData<AppResource<List<Results>>>()
    fun fetchUserList(num: String) {
         viewModelScope.launch {
            listLiveData.postValue(AppResource.loading(null))
            try {
                val userFromDb = shadiRepo.getUserFromDb()
                if (userFromDb.isNullOrEmpty()) {
                    val mListHolder = shadiRepo.getUserList(num)
                    saveToDb(mListHolder.data)
                    listLiveData.postValue(mListHolder)
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
       shadiRepo.saveToDb(data)
       }
    }

    fun getUserList( ): LiveData<AppResource<List<Results>>> {
        return listLiveData
    }

    fun updateUser(results: Results) {
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