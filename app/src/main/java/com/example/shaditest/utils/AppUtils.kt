package com.example.deevideos.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun hideKeyboard(context: Activity) {
    try {
        // use application level context to avoid unnecessary leaks.
        val inputManager: InputMethodManager = context.applicationContext
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            context.currentFocus!!.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun showKeyboard(context: Activity) {
    try {
        val inputMethodManager: InputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(
            context.currentFocus,
            InputMethodManager.SHOW_IMPLICIT
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


@SuppressLint("HardwareIds")
fun getUniqueDeviceId(context: Context): String? {
    return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID)
}

/**
 * Gets the version name of the application. For e.g. 1.9.3
 */
fun getApplicationVersionNumber(context: Context?): String? {
    var versionName: String? = null
    if (context == null) {
        return versionName
    }
    try {
        versionName =
            context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }
    return versionName
}

/**
 * Gets the version code of the application. For e.g. Maverick Meerkat or 2013050301
 */
fun getApplicationVersionCode(ctx: Context): Int {
    var versionCode = 0
    try {
        versionCode = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0).versionCode
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }
    return versionCode
}

/**
 * Gets the version number of the Android OS For e.g. 2.3.4 or 4.1.2
 */
fun getOsVersion(): String? {
    return Build.VERSION.RELEASE
}
fun logger(t:String="Deepak",m:String){
   Log.w(t,m)
}
fun toasty(context: Context , msg:String){
    Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
}


