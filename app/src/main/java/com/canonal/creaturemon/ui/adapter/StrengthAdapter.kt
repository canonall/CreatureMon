package com.canonal.creaturemon.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import com.canonal.creaturemon.model.Creature
import com.canonal.creaturemon.model.attributeType.IntelligenceType
import com.canonal.creaturemon.model.attributeType.StrengthType

class StrengthAdapter(
    context: Context,
    @LayoutRes private val layoutResource: Int,
    @IdRes private val textViewResourceId: Int = 0,
    private val values: List<StrengthType>
) : ArrayAdapter<StrengthType>(context, layoutResource, values) {

    override fun getItem(position: Int): StrengthType = values[position]

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = createViewFromResource(convertView, parent, layoutResource)

        return bindData(getItem(position), view)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = createViewFromResource(
            convertView,
            parent,
            android.R.layout.simple_spinner_dropdown_item
        )
        return bindData(getItem(position), view)
    }

    private fun createViewFromResource(
        convertView: View?,
        parent: ViewGroup,
        layoutResource: Int
    ): TextView {
        val view = convertView ?: LayoutInflater.from(parent.context)
            .inflate(layoutResource, parent, false)
        return try {
            if (textViewResourceId == 0) {
                view as TextView
            } else {
                view.findViewById(textViewResourceId) ?: throw RuntimeException(
                    "Failed to find view with ID " +
                            "${parent.context.resources.getResourceName(textViewResourceId)} in item layout"
                )
            }
        } catch (ex: ClassCastException) {
            Log.e("CustomArrayAdapter", "You must supply a resource ID for a TextView")
            throw IllegalStateException(
                "ArrayAdapter requires the resource ID to be a TextView", ex
            )
        }
    }

    private fun bindData(value: StrengthType, view: TextView): TextView {
        view.text = value.toString()
        return view
    }
}