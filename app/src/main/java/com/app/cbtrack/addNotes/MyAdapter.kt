package com.app.cbtrack.addNotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import com.app.cbtrack.R


class MyAdapter(private val mContext: Context, resource: Int, var listSpinerState: List<SpinerState>) : ArrayAdapter<SpinerState>(mContext, resource, listSpinerState) {
    private var isFromView = false

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View = getCustomView(position, convertView, parent)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View = getCustomView(position, convertView, parent)

    fun getCustomView(position: Int, convertView1: View?, parent: ViewGroup): View {
        var convertView = convertView1
        val holder: ViewHolder
        if (convertView == null) {
            val layoutInflator = LayoutInflater.from(mContext)
            convertView = layoutInflator.inflate(R.layout.spinner_item, null)
            holder = ViewHolder()
            holder.mTextView = convertView
                    .findViewById(R.id.text)
            holder.mCheckBox = convertView
                    .findViewById(R.id.checkbox)
            convertView.setTag(holder)
        } else {
            holder = convertView.getTag() as ViewHolder
        }

        holder.mTextView!!.setText(listSpinerState[position].title)

        isFromView = true
        holder.mCheckBox!!.setChecked(listSpinerState[position].isSelected)
        isFromView = false

        if (position === 0) {
            holder.mCheckBox!!.setVisibility(View.INVISIBLE)
        } else {
            holder.mCheckBox!!.setVisibility(View.VISIBLE)
        }
        holder.mCheckBox!!.setTag(position)
        holder.mCheckBox!!.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.tag as Int

            if (!isFromView) {
                listSpinerState[position].isSelected = isChecked
            }
        }
        return convertView!!
    }

    private inner class ViewHolder {
        var mTextView: TextView? = null
        var mCheckBox: CheckBox? = null
    }
}