package com.app.cbtrack

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class FeelingsSelection : AppCompatActivity() {


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_selection)

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