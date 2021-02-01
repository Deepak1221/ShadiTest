package com.example.shaditest.ui.models
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Keep

data class Results (
	    @SerializedName("name") val name: Name?,
		@SerializedName("location") val location: Location?,
		@SerializedName("login") val login: Login?,
		@SerializedName("dob") val dob: Dob?,
		@SerializedName("picture") val picture: Picture?

)