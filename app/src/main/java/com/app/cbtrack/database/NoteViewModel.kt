package com.app.cbtrack.database

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    private val repository: NoteRepository

    val allNotes: LiveData<List<Note>>
        get() = repository.allNotes
    val allNotesByDate: LiveData<List<Note>>
        get() = repository.allNotesByDate
    val allEmotions: LiveData<List<Note>>
        get() = repository.allEmotions
    val allThoughts: LiveData<List<Note>>
        get() = repository.allThoughts
    val allUniqueTags: LiveData<List<String?>>
        get() = repository.allUniqueTags

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
    }

    fun getNoteById(noteId: Long): LiveData<Note> = repository.getNoteById(noteId)

    fun getAllNotesByTag(tag: String): LiveData<List<Note>> = repository.getAllNotesByTag(tag)

    fun insert(note: Note) = scope.launch(Dispatchers.IO) {
        repository.insert(note)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}
