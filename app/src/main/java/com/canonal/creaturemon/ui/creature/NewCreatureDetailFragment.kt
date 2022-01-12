package com.canonal.creaturemon.ui.creature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.canonal.creaturemon.R
import com.canonal.creaturemon.databinding.FragmentNewCreatureDetailBinding
import com.canonal.creaturemon.ui.util.navigationUtil.popUpToFragment
import com.canonal.creaturemon.ui.util.navigationUtil.removeMenuItem

class NewCreatureDetailFragment : Fragment(R.layout.fragment_new_creature_detail) {

    private lateinit var binding: FragmentNewCreatureDetailBinding
    private val args: NewCreatureDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentNewCreatureDetailBinding.bind(view)
        binding.creature = args.creature
        binding.btnHome.setOnClickListener {
            findNavController().navigate(
                NewCreatureDetailFragmentDirections.actionNewCreatureDetailFragmentToCreatureListFragment(),
                NavOptions.Builder().popUpToFragment(R.id.creatureListFragment, true)
            )
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        removeMenuItem(menu, R.id.addCreatureFragment)
        removeMenuItem(menu, R.id.creatureListFragment)
    }
}