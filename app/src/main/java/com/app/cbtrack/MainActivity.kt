package com.app.cbtrack

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.all_content_b)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, AllNotesActivity::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.add_thougths_b)
        button2.setOnClickListener {
            val intent = Intent(this@MainActivity, FeelingsMain::class.java)
            startActivity(intent)
        }

        val button1 = findViewById<Button>(R.id.add_feelings_b)
        button1.setOnClickListener {
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivity(intent)
        }
    }
}
