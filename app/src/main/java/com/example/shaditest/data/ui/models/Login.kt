package com.example.shaditest.data.ui.models
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
@Keep
data class Login (
	@ColumnInfo(name = "uuid")
	@SerializedName("uuid") val uuid : String?,
	@ColumnInfo(name = "username")
	@SerializedName("username") val username : String?

)