package com.example.shaditest.data.ui.models
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Keep
@Entity
data class Results (
	@PrimaryKey(autoGenerate = true) val uid: Long?,
	@Embedded
	@SerializedName("name") val name : Name?,
	@Embedded
	@SerializedName("location") val location : Location?,
	@Embedded
	@SerializedName("login") val login : Login?,
	@Embedded
	@SerializedName("dob") val dob : Dob?,
	@Embedded
	@SerializedName("picture") val picture : Picture?,
	@ColumnInfo(name = "action")
	var action : String?="na"
)