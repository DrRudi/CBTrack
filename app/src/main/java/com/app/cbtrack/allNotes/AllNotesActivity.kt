package com.app.cbtrack.allNotes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.app.cbtrack.R
import com.app.cbtrack.database.NoteViewModel

class AllNotesActivity : AppCompatActivity() {
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_notes)

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        val mTitle = toolbar.findViewById<TextView>(R.id.toolbar_title)

        setSupportActionBar(toolbar)
        mTitle.text = resources.getString(R.string.all_notes);

        supportActionBar!!.setDisplayShowTitleEnabled(false)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = NoteListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.onItemClick = {

            lateinit var intent: Intent

            if(it.noteType == 1) {
                intent = Intent(this@AllNotesActivity, EmotionNoteActivity::class.java)
            } else {
                intent = Intent(this@AllNotesActivity, ThoughtNoteActivity::class.java)
            }

            intent.putExtra("id", it.id)
            startActivity(intent)
        }

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

        noteViewModel.allNotesByDate.observe(this, Observer { notes ->
            notes?.let { adapter.setNotes(it) }
        })
    }
}