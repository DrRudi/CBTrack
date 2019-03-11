package com.app.cbtrack

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.R.attr.data
import android.widget.ArrayAdapter
import android.widget.Spinner


class FeelingsSelection : AppCompatActivity() {


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_selection)

        val data_anger = arrayOf("nothing", "two", "three", "four", "five")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_anger)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinnerAnger = findViewById<Spinner>(R.id.spinner_anger)
        spinnerAnger.setAdapter(adapter)

        spinnerAnger.setSelection(0)

        val buttonSave = findViewById<Button>(R.id.button_save_emotions)
        val buttonBack = findViewById<Button>(R.id.button_back_emotion_selection)
        val buttonInfo = findViewById<Button>(R.id.button_emotion_info)

        buttonBack.setOnClickListener {
            finish()
        }

        buttonSave.setOnClickListener {

        }

        buttonInfo.setOnClickListener {
            val intent = Intent(this@FeelingsSelection, FeelingsInfo::class.java)
            startActivity(intent)
        }

    }
}