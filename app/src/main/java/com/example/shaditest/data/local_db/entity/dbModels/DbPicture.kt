package com.example.shaditest.data.local_db.entity.dbModels
import androidx.annotation.Keep
import androidx.room.ColumnInfo

@Keep
data class DbPicture (
		@ColumnInfo(name = "large")
		val large: String?

)