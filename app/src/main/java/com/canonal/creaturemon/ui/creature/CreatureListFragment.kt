package com.canonal.creaturemon.ui.creature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ui.AppBarConfiguration
import com.canonal.creaturemon.R
import com.canonal.creaturemon.databinding.FragmentCreatureListBinding

class CreatureListFragment : Fragment() {

    private lateinit var creatureListBinding: FragmentCreatureListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        creatureListBinding = FragmentCreatureListBinding.inflate(inflater, container, false)
        return creatureListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}