package com.app.cbtrack

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class FeelingsMain : AppCompatActivity() {

    private lateinit var editWordView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feelings_layout)

        editWordView = findViewById(R.id.editText_emotion)
        val buttonSave = findViewById<Button>(R.id.button_save_feelings)
        val buttonBack = findViewById<Button>(R.id.button_back_feelings_layout)
        val buttonLock = findViewById<Button>(R.id.toggleButton_lock)

        buttonBack.setOnClickListener {
            val intent = Intent(this@FeelingsMain, MainActivity::class.java)
            startActivity(intent)
        }

        buttonSave.setOnClickListener {

        }

        buttonLock.setOnClickListener {

        }

    }
}