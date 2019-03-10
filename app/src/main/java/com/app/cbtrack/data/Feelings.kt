package com.app.cbtrack.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import java.util.*

@Entity(tableName = "feelings")
data class Feelings(
        @PrimaryKey(autoGenerate = true)
        val id: Int? = null,
        val date: Date,
        val feeling: Feeling,
        val situation: String,
        val tag: String
)