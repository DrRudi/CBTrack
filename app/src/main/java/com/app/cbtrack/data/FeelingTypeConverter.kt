package com.app.cbtrack.data

import android.arch.persistence.room.TypeConverter
import java.util.*

class FeelingTypeConverter {
    @TypeConverter
    fun fromStringFeeling(value: String?): Feeling? {
        return Feeling.valueOf(value!!)
    }

    @TypeConverter
    fun feelingToDtring(feeling: Feeling?): String? {
        return feeling?.name
    }
}