package com.app.cbtrack.addNotes

import android.app.Activity
import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.*
import com.app.cbtrack.R
import com.app.cbtrack.database.Note
import com.app.cbtrack.database.NoteViewModel
import java.io.*
import java.text.SimpleDateFormat
import java.util.*

class AddThoughtActivity : AppCompatActivity() {

    private val CHOOSE_EMOTION_REQUEST = 1
    private val CHOOSE_COGNITIVE_REQUEST = 1
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
    private lateinit var noteViewModel: NoteViewModel

    private var mAutoCompleteTextView: AutoCompleteTextView? = null
    private var mList: MutableList<String>? = null
    private var mAutoCompleteAdapter: ArrayAdapter<String>? = null
    private var editTags: String? = ""
    private lateinit var addTag: Button
    private lateinit var addedTags: TextView
    private lateinit var reader: BufferedReader
    private var mTest = listOf<String>()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_thought)

        editSituation = findViewById(R.id.editText_situation)
        editThought = findViewById(R.id.editText_auto_thought)
        editInterpretation = findViewById(R.id.editText_alternative_interpretation)
        dateButton = findViewById(R.id.choose_date_button_thought)
        dateText = findViewById(R.id.editText_date_thought)
        chooseEmotionButton = findViewById(R.id.emotion_choose_button_thought_activity)
        chooseCognitive = findViewById(R.id.cognitive_choose_button)
        saveThought = findViewById(R.id.save_thought_button)

        addTag = findViewById(R.id.add_tag_thought_button)
        addedTags = findViewById(R.id.tag_textView_thought)

        mAutoCompleteTextView = findViewById(R.id.autoCompleteTextView_thought) as AutoCompleteTextView


        try {
            reader = BufferedReader(InputStreamReader(openFileInput("saved_tags")))
        } catch (e: Exception) {
            try {
                val writer = BufferedWriter(OutputStreamWriter(
                        openFileOutput("saved_tags", Context.MODE_PRIVATE)))
                writer.write("#Apple")
                writer.close()
                reader = BufferedReader(InputStreamReader(openFileInput("saved_tags")))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        mTest = reader.readLine().split('#')
        mList = ArrayList()
        for (mTest in mTest) {
            mList!!.add(mTest)
        }

        mAutoCompleteAdapter = ArrayAdapter(this@AddThoughtActivity,
                android.R.layout.simple_dropdown_item_1line, mList!!)


        mAutoCompleteTextView!!.setAdapter<ArrayAdapter<String>>(mAutoCompleteAdapter)


        addTag.setOnClickListener {
            val newAdd = mAutoCompleteTextView!!.text.toString()

            if (!mList!!.contains(newAdd)) {
                mList!!.add(newAdd)

                // update the autocomplete words
                mAutoCompleteAdapter = ArrayAdapter(
                        this@AddThoughtActivity,
                        android.R.layout.simple_dropdown_item_1line, mList!!)

                mAutoCompleteTextView!!.setAdapter<ArrayAdapter<String>>(mAutoCompleteAdapter)
            }
            editTags += "#"
            editTags += mAutoCompleteTextView!!.text.toString()
            mAutoCompleteTextView!!.setText("")
            addedTags.text = editTags
        }

        val cal = Calendar.getInstance()

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

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
            startActivityForResult(intent, CHOOSE_COGNITIVE_REQUEST)
        }

        saveThought.setOnClickListener {
            var s = ""
            for (i in 0 until mList!!.size) {
                s += "#" + mList!!.get(i)
            }
            saveData("saved_tags", s)
            Log.d("LOG", "FileCreated")
            val note = Note(null, 2, editThought.text.toString(), cognitive, editSituation.text.toString(), cal.time, emotion, editInterpretation.text.toString(), editTags)
            noteViewModel.insert(note)
            finish()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CHOOSE_EMOTION_REQUEST && resultCode == Activity.RESULT_OK) {
            emotion = data?.getStringExtra("emotion")
        }

        if (requestCode == CHOOSE_COGNITIVE_REQUEST && resultCode == Activity.RESULT_OK) {
            cognitive = data?.getStringExtra("cognitive")
        }
    }

    private fun saveData(fileName: String, data: String) {
        try {
            val writer = BufferedWriter(OutputStreamWriter(
                    openFileOutput(fileName, Context.MODE_PRIVATE)))
            writer.write(data)
            writer.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
