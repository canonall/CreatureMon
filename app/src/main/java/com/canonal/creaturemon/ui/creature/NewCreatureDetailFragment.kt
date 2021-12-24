package com.canonal.creaturemon.ui.creature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.canonal.creaturemon.R
import com.canonal.creaturemon.databinding.FragmentNewCreatureDetailBinding
import com.canonal.creaturemon.ui.util.navigationUtil.popUpToCreatureListFragment

class NewCreatureDetailFragment : Fragment() {

    private lateinit var binding: FragmentNewCreatureDetailBinding
    private val args: NewCreatureDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentNewCreatureDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.creature = args.creature
        binding.next.setOnClickListener {
            findNavController().navigate(
                NewCreatureDetailFragmentDirections.actionNewCreatureDetailFragmentToCreatureListFragment(),
                NavOptions.Builder().popUpToCreatureListFragment(R.id.creatureListFragment, true)
            )
        }
    }
}