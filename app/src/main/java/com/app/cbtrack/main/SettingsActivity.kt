package com.app.cbtrack.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Switch
import com.app.cbtrack.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val description = (R.id.description)
        val recordsAccess = findViewById<Switch>(R.id.records_access)
        val apartPgAcs = (R.id.apart_page_access)
        val descriptionAptPg = (R.id.description_apart_page)
        val shareAcs = (R.id.share_access)
        val mailWndw = (R.id.mail_window)

        val buttonShr = findViewById<Button>(R.id.button_share)
        buttonShr.setOnClickListener {
//            TODO
        }

    }
}