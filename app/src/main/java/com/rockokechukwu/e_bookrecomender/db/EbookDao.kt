package com.rockokechukwu.e_bookrecomender.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rockokechukwu.e_bookrecomender.api.response.Ebook

/**
 * Interface for database access on Ebook related operations.
 */

@Dao

abstract class EbookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertEbooks(ebook: List<Ebook>)

    @Query(
        """ SELECT * FROM Ebook WHERE id = :id"""
    )
    abstract fun loadEbook(id: String): LiveData<Ebook>

    @Query(
        """
        SELECT * FROM Ebook"""
    )
    abstract fun loadEbooks(): LiveData<List<Ebook>>

}