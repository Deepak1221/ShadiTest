package com.example.shaditest.data.ui.models
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
data class Location (
	@ColumnInfo(name = "city")
    @SerializedName("city") val city : String?,
	@ColumnInfo(name = "state")
	@SerializedName("state") val state : String?

)