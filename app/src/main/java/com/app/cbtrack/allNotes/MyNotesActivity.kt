package com.app.cbtrack.allNotes

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.TextView
import com.app.cbtrack.R


class MyNotesActivity : AppCompatActivity() {

    private lateinit var emotionNotesButton: Button
    private lateinit var thoughtNotesButton: Button
    private lateinit var tagsNotesButton: Button
    private lateinit var allNotesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_notes)

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        val mTitle = toolbar.findViewById<TextView>(R.id.toolbar_title)

        setSupportActionBar(toolbar)
        mTitle.text = resources.getString(R.string.my_notes);

        supportActionBar!!.setDisplayShowTitleEnabled(false)

        emotionNotesButton = findViewById(R.id.emotion_notes_button)
        thoughtNotesButton = findViewById(R.id.thoughts_notes_button)
        tagsNotesButton = findViewById(R.id.tags_notes_button)
        allNotesButton = findViewById(R.id.all_notes_button)

        thoughtNotesButton.setOnClickListener {
            //TODO: go to my_thoughts
        }

        emotionNotesButton.setOnClickListener {
            //TODO: go to emotions
        }

        allNotesButton.setOnClickListener {
            val intent = Intent(this@MyNotesActivity, AllNotesActivity::class.java)
            startActivity(intent)
        }

        tagsNotesButton.setOnClickListener {
            val intent = Intent(this@MyNotesActivity, AActivity::class.java)
            startActivity(intent)
        }
    }
}