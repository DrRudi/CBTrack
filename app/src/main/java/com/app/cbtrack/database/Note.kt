package com.app.cbtrack.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "note_table")
data class Note(
        @PrimaryKey(autoGenerate = true)
        val id: Long? = null,
        val noteType: Int,
        val autoThougths: String?,
        val cognitiveBias: String?,
        val situation: String?,
        val date: Date,
        val emotion: String?,
        val tags: String?)
