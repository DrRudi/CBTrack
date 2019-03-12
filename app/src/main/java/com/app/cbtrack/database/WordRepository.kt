package com.app.cbtrack.database

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    fun getWordById(wordId: Long): LiveData<Word> {
        return wordDao.getById(wordId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}
