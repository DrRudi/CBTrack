package com.app.cbtrack

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner
import kotlin.collections.ArrayList

class EmotionSelectionActivity : AppCompatActivity() {

    private lateinit var okButton: Button
    private val emotionSpinners = ArrayList<Spinner>()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotion_selection)

        emotionSpinners.add(findViewById(R.id.spinner_sad))
        emotionSpinners.add(findViewById(R.id.spinner_happy))
        emotionSpinners.add(findViewById(R.id.spinner_evil))
        emotionSpinners.add(findViewById(R.id.spinner_sсare))
        emotionSpinners.add(findViewById(R.id.spinner_сalm))
        okButton = findViewById(R.id.buttonOk)

        okButton.setOnClickListener {
            val replyIntent = Intent()
//            for (sp in emotionSpinners)
            replyIntent.putExtra("emotion", emotionSpinners[0].selectedItem.toString())
            setResult(Activity.RESULT_OK, replyIntent)
            finish()
        }
    }
}