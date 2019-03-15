package com.app.cbtrack.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.TextView
import com.app.cbtrack.R
import com.app.cbtrack.addNotes.AddEmotionActivity
import com.app.cbtrack.addNotes.AddThoughtActivity
import com.app.cbtrack.allNotes.MyNotesActivity


class MainActivity : AppCompatActivity() {

    private lateinit var infoButton: Button
    private lateinit var settingsButton: Button
    private lateinit var addThoughtButton: Button
    private lateinit var addEmotionButton: Button
    private lateinit var allNotesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        val mTitle = toolbar.findViewById<TextView>(R.id.toolbar_title)

        setSupportActionBar(toolbar)
        mTitle.text = toolbar.title

        supportActionBar!!.setDisplayShowTitleEnabled(false)

        infoButton = toolbar.findViewById(R.id.info_b)
        settingsButton = toolbar.findViewById(R.id.settings_b)
        addThoughtButton = findViewById(R.id.add_thoughts_b)
        addEmotionButton = findViewById(R.id.add_emotion_b)
        allNotesButton = findViewById(R.id.all_notes_b)

        infoButton.setOnClickListener {
            //TODO
        }

        settingsButton.setOnClickListener {
            //TODO
        }


        addThoughtButton.setOnClickListener {
            val intent = Intent(this@MainActivity, AddThoughtActivity::class.java)
            startActivity(intent)
        }

        addEmotionButton.setOnClickListener {
            val intent = Intent(this@MainActivity, AddEmotionActivity::class.java)
            startActivity(intent)
        }

        allNotesButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MyNotesActivity::class.java)
            startActivity(intent)
        }
    }
}
