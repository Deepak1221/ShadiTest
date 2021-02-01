package com.example.shaditest.data.ui.models
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
@Keep
data class Name (
	@ColumnInfo(name = "first")
	@SerializedName("first") val first : String?

)