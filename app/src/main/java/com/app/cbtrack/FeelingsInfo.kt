package com.app.cbtrack

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class FeelingsInfo : AppCompatActivity() {


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_info)

        val buttonBack = findViewById<Button>(R.id.button_back_emotion_info)

        buttonBack.setOnClickListener {
            finish()
        }


    }
}