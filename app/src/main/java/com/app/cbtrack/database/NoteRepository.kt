package com.app.cbtrack.database

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    fun getNoteById(noteId: Long): LiveData<Note> {
        return noteDao.getById(noteId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
}
