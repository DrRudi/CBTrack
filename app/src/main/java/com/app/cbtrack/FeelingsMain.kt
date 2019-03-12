package com.app.cbtrack

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class FeelingsMain : AppCompatActivity() {

    private val CHOOSE_EMOTION_REQUEST = 1
    private lateinit var editSituation: EditText
    private lateinit var editTag: EditText
    private lateinit var date: Date
    private var emotion: String? = null
    private lateinit var dateButton: Button
    private lateinit var dateText: TextView
    private lateinit var chooseEmotionButton: Button

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_feeling)

        editSituation = findViewById(R.id.edit_situation)
        editTag = findViewById(R.id.edit_tag)
        dateButton = findViewById(R.id.choose_date_b)
        dateText = findViewById(R.id.date_text)
        chooseEmotionButton = findViewById(R.id.choose_emotion_b)

        val cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            date = cal.time

            val myFormat = "dd.MM.yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            dateText.text = sdf.format(date)

        }

        dateButton.setOnClickListener {
            DatePickerDialog(this@FeelingsMain, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        chooseEmotionButton.setOnClickListener {
            val intent = Intent(this@FeelingsMain, FeelingsSelection::class.java)
            startActivityForResult( intent, CHOOSE_EMOTION_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CHOOSE_EMOTION_REQUEST && resultCode == Activity.RESULT_OK) {
            emotion = data?.getStringExtra("emotion")
        }
    }
}