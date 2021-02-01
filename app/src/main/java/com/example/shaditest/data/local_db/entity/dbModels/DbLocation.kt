package com.example.shaditest.data.local_db.entity.dbModels
import androidx.room.ColumnInfo

data class DbLocation (
		@ColumnInfo(name = "city")
		val city: String?,
		@ColumnInfo(name = "state")
		val state: String?

)