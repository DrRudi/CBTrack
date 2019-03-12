package com.app.cbtrack

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.app.cbtrack.database.Word
import com.app.cbtrack.database.WordViewModel

class NewWordActivity : AppCompatActivity() {

    private lateinit var editWordView: EditText
    private lateinit var wordViewModel: WordViewModel

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        editWordView = findViewById(R.id.edit_word)
        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val word = Word(null, editWordView.text.toString())
            wordViewModel.insert(word)
            finish()
        }
    }
}

