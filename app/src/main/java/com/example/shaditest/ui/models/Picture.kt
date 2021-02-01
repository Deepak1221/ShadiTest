package com.example.shaditest.ui.models
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
@Keep
data class Picture (
	@SerializedName("large") val large : String?

)