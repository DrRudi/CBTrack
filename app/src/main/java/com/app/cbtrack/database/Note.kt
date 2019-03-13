package com.app.cbtrack.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
        @PrimaryKey(autoGenerate = true)
        val id: Long? = null,
        @ColumnInfo(name = "situation")
        val situation: String,
        val date: String,
        val emotion: String?,
        val tags: String)
