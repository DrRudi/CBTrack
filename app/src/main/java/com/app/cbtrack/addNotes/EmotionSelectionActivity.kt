package com.app.cbtrack.addNotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner
import com.app.cbtrack.*


class EmotionSelectionActivity : AppCompatActivity() {

    private lateinit var okButton: Button
    private lateinit var sadSpinner: Spinner
    private lateinit var angerSpinner: Spinner
    private lateinit var scareSpinner: Spinner
    private lateinit var happySpinner: Spinner
    private lateinit var pacificationSpinner: Spinner

    private fun setAdapter(arr: Array<String>, spinner: Spinner) {
        val stateList = arrayListOf<SpinerState>()

        for (st in arr) {
            val state = SpinerState()
            state.title = st
            state.isSelected = false
            stateList.add(state)
        }

        spinner.adapter = MyAdapter(this@EmotionSelectionActivity, 0, stateList)
    }

    private fun getEmotions(spinner: Spinner) : String {
        val state = (spinner.adapter as MyAdapter).listSpinerState
        var str = ""
        for (st in state) {
            if(st.isSelected) {
                str = str + "/" + st.title
            }
        }
        return "$str:"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotion_selection)

        sadSpinner = findViewById(R.id.sad_spinner)
        angerSpinner = findViewById(R.id.anger_spinner)
        scareSpinner = findViewById(R.id.scare_spinner)
        happySpinner = findViewById(R.id.happy_spinner)
        pacificationSpinner = findViewById(R.id.pacification_spinner)
        okButton = findViewById(R.id.buttonOk)

        setAdapter(sad, sadSpinner)
        setAdapter(anger, angerSpinner)
        setAdapter(scare, scareSpinner)
        setAdapter(happy, happySpinner)
        setAdapter(pacification, pacificationSpinner)


        okButton.setOnClickListener {
            var str = ""
            str+=getEmotions(sadSpinner)
            str+=getEmotions(angerSpinner)
            str+=getEmotions(scareSpinner)
            str+=getEmotions(happySpinner)
            str+=getEmotions(pacificationSpinner)
            val replyIntent = Intent()
            replyIntent.putExtra("emotion", str)
            setResult(Activity.RESULT_OK, replyIntent)
            finish()
        }
    }
}