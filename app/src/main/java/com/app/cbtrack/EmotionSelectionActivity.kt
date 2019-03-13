package com.app.cbtrack

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner

class EmotionSelectionActivity : AppCompatActivity() {

    private lateinit var emotionSpinner: Spinner
    private lateinit var spinnerButton : Button

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotion_selection)

        emotionSpinner = findViewById(R.id.emotion_spinner)
        spinnerButton = findViewById(R.id.emotion_spinner_b)

        spinnerButton.setOnClickListener {
            val replyIntent = Intent()
            replyIntent.putExtra("emotion", emotionSpinner.selectedItem.toString())
            setResult(Activity.RESULT_OK, replyIntent)
            finish()
        }
    }
}