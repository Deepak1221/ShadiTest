package com.example.shaditest.data.ui.models
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
@Keep
data class Dob (
	@ColumnInfo(name = "age")
	@SerializedName("age") val age : String?
)