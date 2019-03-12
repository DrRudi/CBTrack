package com.app.cbtrack.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.app.cbtrack.data.Feelings

@Dao
interface WordDao {
    @Query("SELECT * from word_table")
    fun getAllWords(): LiveData<List<Word>>

    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * FROM word_table WHERE id = :id")
    fun getById(id: Long): LiveData<Word>
}
