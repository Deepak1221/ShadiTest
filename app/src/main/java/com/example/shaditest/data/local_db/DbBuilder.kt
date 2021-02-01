package com.example.deevideos.data.local.room_db

import android.content.Context
import androidx.room.Room

object DbBuilder {

    private var INSTANCE: AppDB? = null

    fun getInstance(context: Context): AppDB {
        if (INSTANCE == null) {
            synchronized(AppDB::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDB::class.java,
            "Shadi.com.db"
        ).build()
}