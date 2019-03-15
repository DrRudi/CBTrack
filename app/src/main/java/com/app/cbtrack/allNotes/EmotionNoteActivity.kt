package com.app.cbtrack.allNotes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.app.cbtrack.R
import com.app.cbtrack.database.NoteViewModel
import com.app.cbtrack.dateToString

class EmotionNoteActivity : AppCompatActivity() {

    private var id: Long = 0
    private lateinit var noteViewModel: NoteViewModel

    private lateinit var situationText: TextView
    private lateinit var dateText: TextView
    private lateinit var emotionText: TextView
    private lateinit var tagsText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotion_note)

        situationText = findViewById(R.id.situation_text)
        dateText = findViewById(R.id.date_text)
        emotionText = findViewById(R.id.emotion_text)
        tagsText = findViewById(R.id.tags_text)

        id = intent.getLongExtra("id", 0)

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

        noteViewModel.getNoteById(id).observe(this, Observer { note ->
            note?.let {
                situationText.text = it.situation
                dateText.text = dateToString(it.date)
                emotionText.text = it.emotion
                tagsText.text = it.tags
            }
        })
    }
}