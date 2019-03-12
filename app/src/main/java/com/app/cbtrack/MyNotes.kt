package com.app.cbtrack

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button


@SuppressLint("Registered")
class MyNotes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_notes_view)

        val buttonThoughts = findViewById<Button>(R.id.thoughts_notes_button)
        buttonThoughts.setOnClickListener {
            //TODO: go to my_thoughts
        }

        val buttonEmotion = findViewById<Button>(R.id.emotion_notes_button)
        buttonEmotion.setOnClickListener {
            //TODO: go to emotions
        }

        val buttonAllnotes = findViewById<Button>(R.id.all_notes_button)
        buttonAllnotes.setOnClickListener {
            val intent = Intent(this@MyNotes, AllNotesActivity::class.java)
            startActivity(intent)
        }
        val buttonTags = findViewById<Button>(R.id.tags_button)
        buttonTags.setOnClickListener {
            //TODO: go to tags
        }
    }
}