package com.app.cbtrack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView

import java.util.ArrayList

class AActivity : AppCompatActivity() {

    private var mAutoCompleteTextView: AutoCompleteTextView? = null
    private val mCats = arrayOf("Apple", "Book", "Tree", "Sock", "Train", "Blue")

    private var mList: MutableList<String>? = null
    private var mAutoCompleteAdapter: ArrayAdapter<String>? = null
    private var mAutoListTextView: TextView? = null
    private lateinit var addB : Button
    private var tag : String? =  ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_all_view)

        mAutoCompleteTextView = findViewById(R.id.autoCompleteTextView) as AutoCompleteTextView
        prepareList()

        mAutoCompleteAdapter = ArrayAdapter(this@AActivity,
                android.R.layout.simple_dropdown_item_1line, mList!!)


        mAutoCompleteTextView!!.setAdapter<ArrayAdapter<String>>(mAutoCompleteAdapter)

        mAutoListTextView = findViewById(R.id.textViewAutoList) as TextView

        addB = findViewById(R.id.button_add_test)

        addB.setOnClickListener {
            tag += "#"
            tag += mAutoCompleteTextView!!.text.toString()
            mAutoCompleteTextView!!.setText("")
        }

    }

    private fun prepareList() {
        mList = ArrayList()
        for (mCat in mCats) {
            mList!!.add(mCat)
        }
    }

    fun onClick(view: View) {
        val newAdd = mAutoCompleteTextView!!.text.toString()

        if (!mList!!.contains(newAdd)) {
            mList!!.add(newAdd)

            // update the autocomplete words
            mAutoCompleteAdapter = ArrayAdapter(
                    this@AActivity,
                    android.R.layout.simple_dropdown_item_1line, mList!!)

            mAutoCompleteTextView!!.setAdapter<ArrayAdapter<String>>(mAutoCompleteAdapter)
        }

        // display the words in mList for your reference

        mAutoListTextView!!.text = tag
    }
}