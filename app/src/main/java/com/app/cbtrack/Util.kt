package com.app.cbtrack

import java.text.SimpleDateFormat
import java.util.*

fun dateToString(date: Date) = SimpleDateFormat("dd.MM.yyyy", Locale.US).format(date)