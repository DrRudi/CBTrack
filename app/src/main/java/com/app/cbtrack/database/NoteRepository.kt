package com.app.cbtrack.database

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes: LiveData<List<Note>>
        get() = noteDao.getAllNotes()
    val allNotesByDate: LiveData<List<Note>>
        get() = noteDao.getAllNotesByDate()
    val allEmotions: LiveData<List<Note>>
        get() = noteDao.getAllEmotions()
    val allThoughts: LiveData<List<Note>>
        get() = noteDao.getAllThoughts()
    val allUniqueTags: LiveData<List<String?>>
        get() = noteDao.getAllUniqueTags()

    fun getAllNotesByTag(tag: String): LiveData<List<Note>> {
        return noteDao.getAllNotesByTag("%$tag%")
    }

    fun getNoteById(noteId: Long): LiveData<Note> {
        return noteDao.getById(noteId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
}
