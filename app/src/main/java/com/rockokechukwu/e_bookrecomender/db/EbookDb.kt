package com.rockokechukwu.e_bookrecomender.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rockokechukwu.e_bookrecomender.api.response.Ebook

/**
 * The Room database for this app.
 */
@Database(entities = [Ebook::class], version = 1, exportSchema = false)
abstract class EbookDb: RoomDatabase() {
    abstract fun ebookDao(): EbookDao
}