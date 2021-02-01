package com.example.shaditest.ui.models
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
data class Location (
    @SerializedName("city") val city : String?,
	@SerializedName("state") val state : String?

)