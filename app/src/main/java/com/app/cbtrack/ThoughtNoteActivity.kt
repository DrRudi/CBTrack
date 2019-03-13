package com.app.cbtrack

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.app.cbtrack.database.NoteViewModel

class ThoughtNoteActivity : AppCompatActivity() {

    private var id: Long = 0
    private lateinit var noteViewModel: NoteViewModel

    private lateinit var situationText: TextView
    private lateinit var dateText: TextView
    private lateinit var emotionText: TextView
    private lateinit var cognitiveText: TextView
    private lateinit var autoText: TextView
    private lateinit var interpretationText: TextView
    private lateinit var tagsText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thought_note)

        situationText = findViewById(R.id.textView_situation_thought)
        dateText = findViewById(R.id.textView_date_thought)
        emotionText = findViewById(R.id.textView_emotion_thought)
        tagsText = findViewById(R.id.textView_tags_thought)
        cognitiveText = findViewById(R.id.textView_cognitive_thought)
        autoText = findViewById(R.id.textView_auto_thought)
        interpretationText = findViewById(R.id.textView_interpretation_thought)

        id = intent.getLongExtra("id", 0)

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

        noteViewModel.getNoteById(id).observe(this, Observer { note ->
            note?.let {
                situationText.text = it.situation
                dateText.text = dateToString(it.date)
                emotionText.text = it.emotion
                tagsText.text = it.tags
                cognitiveText.text = it.cognitiveBias
                autoText.text = it.autoThougths
                interpretationText.text = it.alternative
            }
        })
    }
}