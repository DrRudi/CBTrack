package com.app.cbtrack.data

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import java.util.*


@Dao
interface FeelingsDAO {
    @Query("SELECT * FROM feelings")
    fun getAll(): List<Feelings>

    @Query("SELECT * FROM feelings WHERE id = :id")
    fun getById(id: Long): Feelings

    @Query("SELECT * FROM feelings WHERE date = :date")
    fun getByDate(date: Date): Feelings

    @Query("SELECT * FROM feelings WHERE feeling = :feeling")
    fun getByFeeling(feeling: Feeling): Feelings

    @Query("SELECT * FROM feelings WHERE tag = :tag")
    fun getByTag(tag: Feeling): Feelings

    @Insert(onConflict = IGNORE)
    fun insert(feeling: Feelings)

    @Update(onConflict = IGNORE)
    fun update(feeling: Feelings)

    @Delete
    fun delete(feeling: Feelings)
}