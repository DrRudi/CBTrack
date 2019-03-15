package com.app.cbtrack

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import java.io.*


class AActivity : AppCompatActivity() {

    private var mAutoCompleteTextView: AutoCompleteTextView? = null
    private var mTest = listOf<String>()

    private var mList: MutableList<String>? = null
    private var mAutoCompleteAdapter: ArrayAdapter<String>? = null
    private var mAutoListTextView: TextView? = null
    private lateinit var addB: Button
    private var tag: String? = ""
    private lateinit var reader: BufferedReader


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_all_view)


        mAutoCompleteTextView = findViewById(R.id.autoCompleteTextView) as AutoCompleteTextView

        try {
            reader = BufferedReader(InputStreamReader(openFileInput("saved_tags")))
        } catch (e: Exception) {
            try {
                val writer = BufferedWriter(OutputStreamWriter(
                        openFileOutput("saved_tags", Context.MODE_PRIVATE)))
                writer.write("#Apple")
                writer.close()
                reader = BufferedReader(InputStreamReader(openFileInput("saved_tags")))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        mTest = reader.readLine().split('#')
        mList = ArrayList()
        for (mTest in mTest) {
            mList!!.add(mTest)
        }




        mAutoCompleteAdapter = ArrayAdapter(this@AActivity,
                android.R.layout.simple_dropdown_item_1line, mList!!)


        mAutoCompleteTextView!!.setAdapter<ArrayAdapter<String>>(mAutoCompleteAdapter)

        mAutoListTextView = findViewById(R.id.textViewAutoList) as TextView

        addB = findViewById(R.id.button_add_test)


        addB.setOnClickListener {
            val newAdd = mAutoCompleteTextView!!.text.toString()

            if (!mList!!.contains(newAdd)) {
                mList!!.add(newAdd)

                // update the autocomplete words
                mAutoCompleteAdapter = ArrayAdapter(
                        this@AActivity,
                        android.R.layout.simple_dropdown_item_1line, mList!!)

                mAutoCompleteTextView!!.setAdapter<ArrayAdapter<String>>(mAutoCompleteAdapter)
            }
            tag += "#"
            tag += mAutoCompleteTextView!!.text.toString()
            mAutoCompleteTextView!!.setText("")
        }

    }


    fun onClick(view: View) {

        var s = ""
        for (i in 0 until mList!!.size) {
            s += "#" + mList!!.get(i)
        }
        mAutoListTextView!!.text = s
        saveData("saved_tags", s)
        Log.d("LOG", "FileCreated")

    }

    private fun saveData(fileName: String, data: String) {
        try {
            val writer = BufferedWriter(OutputStreamWriter(
                    openFileOutput(fileName, Context.MODE_PRIVATE)))
            writer.write(data)
            writer.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


}