package com.canonal.creaturemon.ui.creature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.canonal.creaturemon.databinding.FragmentCreatureListBinding
import com.canonal.creaturemon.di.AppModule
import com.canonal.creaturemon.ui.adapter.CreatureAdapter
import com.canonal.creaturemon.ui.util.recyclerViewUtil.SwipeToDeleteCallback
import com.canonal.creaturemon.ui.viewModel.CreatureViewModel
import com.canonal.creaturemon.ui.viewModelFactory.CreatureViewModelFactory

class CreatureListFragment : Fragment() {

    private lateinit var binding: FragmentCreatureListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreatureListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rvCreatureList = binding.rvCreatureList
        val creatureViewModel: CreatureViewModel by viewModels {
            CreatureViewModelFactory(AppModule.getCreatureRepository(view.context))
        }
        creatureViewModel.creatureList.observe(viewLifecycleOwner, {
            val creatureAdapter = CreatureAdapter(it)
            rvCreatureList.adapter = creatureAdapter
            rvCreatureList.layoutManager = LinearLayoutManager(view.context)
            rvCreatureList.setHasFixedSize(true)
        })

        val swipeHandler = object : SwipeToDeleteCallback(view.context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = rvCreatureList.adapter as CreatureAdapter
                creatureViewModel.deleteCreature(adapter.getCreatureAt(viewHolder.adapterPosition))
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(rvCreatureList)
    }
}

