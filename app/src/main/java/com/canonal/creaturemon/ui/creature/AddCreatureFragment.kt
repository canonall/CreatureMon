package com.canonal.creaturemon.ui.creature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.canonal.creaturemon.R
import com.canonal.creaturemon.databinding.FragmentAddCreatureBinding


class AddCreatureFragment : Fragment() {

    private lateinit var addCreatureBinding: FragmentAddCreatureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        addCreatureBinding = FragmentAddCreatureBinding.inflate(inflater,container,false)
        return addCreatureBinding.root
    }

}