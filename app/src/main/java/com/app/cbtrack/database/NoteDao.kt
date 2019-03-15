package com.app.cbtrack.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * from note_table")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * from note_table ORDER BY date DESC")
    fun getAllNotesByDate(): LiveData<List<Note>>

    @Query("SELECT * from note_table WHERE noteType = 1")
    fun getAllEmotions(): LiveData<List<Note>>

    @Query("SELECT * from note_table WHERE noteType = 0")
    fun getAllThoughts(): LiveData<List<Note>>

    @Query("SELECT DISTINCT tags FROM note_table")
    fun getAllUniqueTags(): LiveData<List<String?>>

    @Query("SELECT * from note_table WHERE tags LIKE :tag")
    fun getAllNotesByTag(tag: String): LiveData<List<Note>>

    @Insert
    fun insert(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAll()

    @Query("SELECT * FROM note_table WHERE id = :id")
    fun getById(id: Long): LiveData<Note>
}
