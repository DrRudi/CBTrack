package com.app.cbtrack

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.app.cbtrack.database.WordViewModel
import kotlinx.android.synthetic.main.activity_all_notes_list_item.*

class NoteActivity : AppCompatActivity() {

    private var id: Long = 0
    private lateinit var wordViewModel: WordViewModel
    private lateinit var situationText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        situationText = findViewById(R.id.note_text)
        id = intent.getLongExtra("id", 0)

        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        wordViewModel.getWordById(id).observe(this, Observer { word ->
            word?.let { situationText.text = it.word }
        })
    }
}