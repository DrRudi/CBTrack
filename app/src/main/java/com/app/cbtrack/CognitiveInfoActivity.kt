package com.app.cbtrack

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class CognitiveInfoActivity : AppCompatActivity() {


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cognitive_info)

        val buttonBack = findViewById<Button>(R.id.back_cognitive_info_button)

        buttonBack.setOnClickListener {
            finish()
        }


    }
}