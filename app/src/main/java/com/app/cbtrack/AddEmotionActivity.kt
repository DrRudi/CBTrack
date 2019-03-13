package com.app.cbtrack

import android.app.Activity
import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import com.app.cbtrack.database.Note
import com.app.cbtrack.database.NoteViewModel
import java.text.SimpleDateFormat
import java.util.*

class AddEmotionActivity : AppCompatActivity() {

    private val CHOOSE_EMOTION_REQUEST = 1

    private lateinit var editSituation: EditText

    private var emotion: String? = null
    private lateinit var date: String
    private lateinit var dateButton: Button
    private lateinit var dateText: TextView
    private lateinit var chooseEmotionButton: Button
    private lateinit var saveButton: Button

    private lateinit var noteViewModel: NoteViewModel

    private var mAutoCompleteTextView: AutoCompleteTextView? = null
    private val mCats = arrayOf("Apple", "Book", "Tree", "Sock", "Train", "Blue")
    private var mList: MutableList<String>? = null
    private var mAutoCompleteAdapter: ArrayAdapter<String>? = null
    private var editTags: String? = ""
    private lateinit var addTag: Button
    private lateinit var addedTags: TextView



    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_emotion)

        editSituation = findViewById(R.id.edit_situation)

        dateButton = findViewById(R.id.choose_date_b)
        dateText = findViewById(R.id.date_text)
        chooseEmotionButton = findViewById(R.id.choose_emotion_b)
        saveButton = findViewById(R.id.save_b)

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

        addTag = findViewById(R.id.add_tag_emotion_button)
        addedTags = findViewById(R.id.tag_textView_emotion)

        mAutoCompleteTextView = findViewById(R.id.autoCompleteTextView_emotion) as AutoCompleteTextView
        prepareList()

        mAutoCompleteAdapter = ArrayAdapter(this@AddEmotionActivity,
                android.R.layout.simple_dropdown_item_1line, mList!!)


        mAutoCompleteTextView!!.setAdapter<ArrayAdapter<String>>(mAutoCompleteAdapter)


        addTag.setOnClickListener {
            editTags += "#"
            editTags += mAutoCompleteTextView!!.text.toString()
            mAutoCompleteTextView!!.setText("")
            addedTags.text = editTags
        }

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
            val note = Note(null, 1, null, null, editSituation.text.toString(), cal.time, emotion, null, editTags)
            noteViewModel.insert(note)
            finish()
        }
    }

    private fun prepareList() {
        mList = ArrayList()
        for (mCat in mCats) {
            mList!!.add(mCat)
        }
    }

    fun onClick(view: View) {
        val newAdd = mAutoCompleteTextView!!.text.toString()

        if (!mList!!.contains(newAdd)) {
            mList!!.add(newAdd)

            // update the autocomplete words
            mAutoCompleteAdapter = ArrayAdapter(
                    this@AddEmotionActivity,
                    android.R.layout.simple_dropdown_item_1line, mList!!)

            mAutoCompleteTextView!!.setAdapter<ArrayAdapter<String>>(mAutoCompleteAdapter)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CHOOSE_EMOTION_REQUEST && resultCode == Activity.RESULT_OK) {
            emotion = data?.getStringExtra("emotion")
        }
    }





}