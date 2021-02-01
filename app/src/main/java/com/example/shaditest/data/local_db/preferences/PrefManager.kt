package com.example.deevideos.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import com.example.shaditest.MyApplication


object PrefManager {
    private var mPrefs: SharedPreferences? = null
    private val prefFileName = "ShadiPrefrences"

    init {
        mPrefs = MyApplication.applicationContext()
            .getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
    }

    fun putBoolean(key: String?, value: Boolean) {
        mPrefs?.edit()?.putBoolean(key, value)?.apply()
    }

    fun getBoolean(key: String?): Boolean {
        return mPrefs?.getBoolean(key, false)!!
    }


    fun getInt(key: String?): Int {
        return mPrefs?.getInt(key, 0)!!
    }

    fun putInt(key: String?, value: Int) {
        mPrefs?.edit()?.putLong(key, value.toLong())?.apply()
    }

    fun putString(key: String?, value: String?) {
        mPrefs?.edit()?.putString(key, value)?.apply() // Commit the edits!
    }

    fun getString(key: String?): String? {
        return mPrefs?.getString(key, null)
    }
    fun clearAllPrefs() {
        mPrefs?.edit()?.clear()?.apply()

    }

}