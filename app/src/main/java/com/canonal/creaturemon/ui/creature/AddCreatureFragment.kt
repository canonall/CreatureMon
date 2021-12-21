package com.canonal.creaturemon.ui.creature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.canonal.creaturemon.R
import com.canonal.creaturemon.databinding.FragmentAddCreatureBinding
import com.canonal.creaturemon.model.attributeType.EnduranceType
import com.canonal.creaturemon.model.attributeType.IntelligenceType
import com.canonal.creaturemon.model.attributeType.StrengthType
import com.canonal.creaturemon.ui.adapter.SpinAdapter


class AddCreatureFragment : Fragment() {

    private lateinit var addCreatureBinding: FragmentAddCreatureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        addCreatureBinding = FragmentAddCreatureBinding.inflate(inflater, container, false)
        return addCreatureBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val intelligenceSpinAdapter = SpinAdapter(
            view.context,
            R.layout.spinner_layout,
            values = getIntelligenceTypeList()
        )

        val strengthSpinAdapter = SpinAdapter(
            view.context,
            R.layout.spinner_layout,
            values = getStrengthTypeList()
        )
        val enduranceSpinAdapter = SpinAdapter(
            view.context,
            R.layout.spinner_layout,
            values = getEnduranceTypeList()
        )
        addCreatureBinding.spinnerIntelligence.adapter = intelligenceSpinAdapter
        addCreatureBinding.spinnerStrength.adapter = strengthSpinAdapter
        addCreatureBinding.spinnerEndurance.adapter = enduranceSpinAdapter

    }

    private fun getIntelligenceTypeList() = listOf(
        IntelligenceType.SMART.toString(),
        IntelligenceType.REGULAR.toString(),
        IntelligenceType.DUMB.toString()
    )

    private fun getStrengthTypeList() = listOf(
        StrengthType.STRONG.toString(),
        StrengthType.REGULAR.toString(),
        StrengthType.WEAK.toString()
    )

    private fun getEnduranceTypeList() = listOf(
        EnduranceType.TOUGH.toString(),
        EnduranceType.REGULAR.toString(),
        EnduranceType.WEAK.toString()
    )


}