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
import com.canonal.creaturemon.R
import com.canonal.creaturemon.databinding.FragmentCreatureListBinding
import com.canonal.creaturemon.di.AppModule
import com.canonal.creaturemon.ui.adapter.CreatureAdapter
import com.canonal.creaturemon.ui.util.animationUtil.AnimationUtil
import com.canonal.creaturemon.ui.util.recyclerViewUtil.BounceEdgeEffectFactory
import com.canonal.creaturemon.ui.util.recyclerViewUtil.RecyclerViewUtils
import com.canonal.creaturemon.ui.util.recyclerViewUtil.SwipeToDeleteCallback
import com.canonal.creaturemon.ui.viewModel.CreatureViewModel
import com.canonal.creaturemon.ui.viewModelFactory.CreatureViewModelFactory

class CreatureListFragment : Fragment(R.layout.fragment_creature_list) {

    private lateinit var binding: FragmentCreatureListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCreatureListBinding.bind(view)
        val rvCreature = binding.rvCreatureList
        val creatureViewModel: CreatureViewModel by viewModels {
            CreatureViewModelFactory(AppModule.getCreatureRepository(view.context))
        }
        val creatureAdapter = CreatureAdapter()
        RecyclerViewUtils.initializeRecyclerView(
            rvCreature,
            creatureAdapter,
            LinearLayoutManager(view.context),
            true,
            AnimationUtil.getLayoutAnimationController(
                view.context,
                R.anim.creature_list_layout_animation
            ),
            BounceEdgeEffectFactory()
        )
        creatureViewModel.creatureList.observe(viewLifecycleOwner, {
            creatureAdapter.submitList(it)
        })
        val swipeHandler = object : SwipeToDeleteCallback(view.context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val deletedCreature = creatureAdapter.currentList[viewHolder.adapterPosition]
                creatureViewModel.deleteCreature(deletedCreature)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(rvCreature)
    }
}

