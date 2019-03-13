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

class AddThoughtActivity : AppCompatActivity() {

    private val CHOOSE_EMOTION_REQUEST = 1
    private lateinit var editSituation: EditText
    private lateinit var editThought: EditText
    private lateinit var editInterpretation: EditText
    private lateinit var editTag: EditText
    private lateinit var date: Date
    private var emotion: String? = null
    private var cognitive: String? = null
    private lateinit var dateButton: Button
    private lateinit var dateText: TextView
    private lateinit var chooseEmotionButton: Button
    private lateinit var chooseCognitive: Button
    private lateinit var saveThought: Button


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_thought)

        editSituation = findViewById(R.id.editText_situation)
        editThought = findViewById(R.id.editText_auto_thought)
        editInterpretation = findViewById(R.id.editText_alternative_interpretation)
        editTag = findViewById(R.id.editText_tag_thought)
        dateButton = findViewById(R.id.choose_date_button_thought)
        dateText = findViewById(R.id.editText_date_thought)
        chooseEmotionButton = findViewById(R.id.emotion_choose_button_thought_activity)
        chooseCognitive = findViewById(R.id.cognitive_choose_button)
        saveThought = findViewById(R.id.save_thought_button)

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
            DatePickerDialog(this@AddThoughtActivity, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        chooseEmotionButton.setOnClickListener {
            val intent = Intent(this@AddThoughtActivity, EmotionSelectionActivity::class.java)
            startActivityForResult(intent, CHOOSE_EMOTION_REQUEST)
        }

        chooseCognitive.setOnClickListener {
            val intent = Intent(this@AddThoughtActivity, CognitiveSelectionActivity::class.java)
            startActivity(intent)
        }

        saveThought.setOnClickListener {

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CHOOSE_EMOTION_REQUEST && resultCode == Activity.RESULT_OK) {
            emotion = data?.getStringExtra("emotion")
        }
    }
}
