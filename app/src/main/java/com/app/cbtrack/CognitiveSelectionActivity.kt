package com.app.cbtrack

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner

class CognitiveSelectionActivity : AppCompatActivity() {

    private lateinit var saveCognitive: Button
    private lateinit var infoCognitive: Button
    private lateinit var cognitiveSpinner: Spinner

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cognitive_selection)

        saveCognitive = findViewById(R.id.save_cognitive_button)
        infoCognitive = findViewById(R.id.cognitive_info_button)
        cognitiveSpinner = findViewById(R.id.cognitive_spinner)

        saveCognitive.setOnClickListener {
            val replyIntent = Intent()
            replyIntent.putExtra("cognitive", cognitiveSpinner.selectedItem.toString())
            setResult(Activity.RESULT_OK, replyIntent)
            finish()
        }

        infoCognitive.setOnClickListener {
            val intent = Intent(this@CognitiveSelectionActivity, CognitiveInfoActivity::class.java)
            startActivity(intent)
        }
    }
}