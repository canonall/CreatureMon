package com.canonal.creaturemon.ui.adapter.spinnerAdapter

import android.content.Context
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import com.canonal.creaturemon.model.attributeType.StrengthType
import com.canonal.creaturemon.ui.adapter.spinnerAdapter.BaseSpinnerAdapter

class StrengthAdapter(
    context: Context,
    @LayoutRes private val layoutResource: Int,
    @IdRes private val textViewResourceId: Int = 0,
    values: List<StrengthType>
) : BaseSpinnerAdapter<StrengthType>(context, layoutResource, textViewResourceId, values)