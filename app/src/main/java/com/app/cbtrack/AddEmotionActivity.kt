package com.app.cbtrack

import android.app.Activity
import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.app.cbtrack.database.Note
import com.app.cbtrack.database.NoteViewModel
import kotlinx.android.synthetic.main.activity_emotion_note.*
import java.text.SimpleDateFormat
import java.util.*

class AddEmotionActivity : AppCompatActivity() {

    private val CHOOSE_EMOTION_REQUEST = 1

    private lateinit var editSituation: EditText
    private lateinit var editTags: EditText
    private var emotion: String? = null
    private lateinit var date: String

    private lateinit var dateButton: Button
    private lateinit var dateText: TextView
    private lateinit var chooseEmotionButton: Button
    private lateinit var saveButton: Button

    private lateinit var noteViewModel: NoteViewModel


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_emotion)

        editSituation = findViewById(R.id.edit_situation)
        editTags = findViewById(R.id.edit_tag)

        dateButton = findViewById(R.id.choose_date_b)
        dateText = findViewById(R.id.date_text)
        chooseEmotionButton = findViewById(R.id.choose_emotion_b)
        saveButton = findViewById(R.id.save_b)

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)


        val cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            date = sdf.format(cal.time)

            dateText.text = date

        }

        dateButton.setOnClickListener {
            DatePickerDialog(this@AddEmotionActivity, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        chooseEmotionButton.setOnClickListener {
            val intent = Intent(this@AddEmotionActivity, EmotionSelectionActivity::class.java)
            startActivityForResult(intent, CHOOSE_EMOTION_REQUEST)
        }

        saveButton.setOnClickListener {
            val note = Note(null, 1, null, null, editSituation.text.toString(), cal.time, emotion, editTags.text.toString())
            noteViewModel.insert(note)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CHOOSE_EMOTION_REQUEST && resultCode == Activity.RESULT_OK) {
            emotion = data?.getStringExtra("emotion")
        }
    }
}