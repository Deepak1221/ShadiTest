package com.example.shaditest.data.local_db.entity.dbModels
import androidx.annotation.Keep
import androidx.room.ColumnInfo

@Keep
data class DbLogin (
		@ColumnInfo(name = "uuid")
		val uuid: String?,
		@ColumnInfo(name = "username")
		val username: String?

)