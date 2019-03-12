package com.app.cbtrack

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner

class CognitiveSelection : AppCompatActivity() {

    private lateinit var checkBox4: CheckBox
    private lateinit var saveCognitive: Button
    private lateinit var infoCognitive: Button

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cognitive_selection)

        saveCognitive = findViewById(R.id.save_cognitive_button)
        infoCognitive = findViewById(R.id.cognitive_info_button)
        checkBox4 = findViewById(R.id.checkBox4)

        saveCognitive.setOnClickListener {

        }
        infoCognitive.setOnClickListener {
            val intent = Intent(this@CognitiveSelection, CognitiveInfo::class.java)
            startActivity(intent)
        }
    }
}