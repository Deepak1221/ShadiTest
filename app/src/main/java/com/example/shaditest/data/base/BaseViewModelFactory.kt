package com.example.shaditest.data.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shaditest.data.ui.ShadiViewModel


class BaseViewModelFactory(val repo :BaseRepo ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShadiViewModel::class.java)) {
            return ShadiViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}