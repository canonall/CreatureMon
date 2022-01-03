package com.canonal.creaturemon.ui.util.spinnerUtil

import android.widget.AdapterView
import android.widget.Spinner
import com.canonal.creaturemon.ui.adapter.spinnerAdapter.BaseSpinnerAdapter

class SpinnerUtil {
    companion object {
        fun <T> setSpinnerAdapter(
            spinner: Spinner,
            adapter: BaseSpinnerAdapter<T>,
            itemSelectListener: AdapterView.OnItemSelectedListener
        ) {
            spinner.adapter = adapter
            spinner.onItemSelectedListener = itemSelectListener
        }
    }
}