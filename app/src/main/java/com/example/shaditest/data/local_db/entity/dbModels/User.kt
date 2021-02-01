package com.example.shaditest.data.local_db.entity.dbModels
import androidx.annotation.Keep
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
@Keep
@Entity
data class User (
		@NonNull
		@PrimaryKey val uid: String,
		@Embedded
		val name: DbName?,
		@Embedded
		val location: DbLocation?,
		@Embedded
		val login: DbLogin?,
		@Embedded
		val dob: DbDob?,
		@Embedded
		val picture: DbPicture?,
		@ColumnInfo(name = "action")
		var action: String? = "na"
)