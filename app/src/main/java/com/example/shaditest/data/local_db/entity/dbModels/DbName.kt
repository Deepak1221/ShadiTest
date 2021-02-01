package com.example.shaditest.data.local_db.entity.dbModels
import androidx.annotation.Keep
import androidx.room.ColumnInfo

@Keep
data class DbName (
	@ColumnInfo(name = "first")
	val first : String?

)