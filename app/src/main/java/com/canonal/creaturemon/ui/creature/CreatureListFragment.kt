package com.canonal.creaturemon.ui.creature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.canonal.creaturemon.databinding.FragmentCreatureListBinding
import com.canonal.creaturemon.di.AppModule
import com.canonal.creaturemon.ui.adapter.CreatureAdapter
import com.canonal.creaturemon.ui.viewModel.CreatureViewModel
import com.canonal.creaturemon.ui.viewModelFactory.CreatureViewModelFactory

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
        val creatureViewModel: CreatureViewModel by viewModels {
            CreatureViewModelFactory(AppModule.getCreatureRepository(view.context))
        }
        creatureViewModel.creatureList.observe(viewLifecycleOwner, {
            val creatureAdapter = CreatureAdapter(it)
            creatureListBinding.rvCreatureList.adapter = creatureAdapter
            creatureListBinding.rvCreatureList.layoutManager = LinearLayoutManager(view.context)
            creatureListBinding.rvCreatureList.setHasFixedSize(true)
        })
    }
}

