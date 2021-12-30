package com.canonal.creaturemon.ui.creature

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.canonal.creaturemon.R
import com.canonal.creaturemon.databinding.FragmentAddCreatureBinding
import com.canonal.creaturemon.di.AppModule
import com.canonal.creaturemon.model.attributeType.EnduranceType
import com.canonal.creaturemon.model.attributeType.IntelligenceType
import com.canonal.creaturemon.model.attributeType.StrengthType
import com.canonal.creaturemon.ui.adapter.EnduranceAdapter
import com.canonal.creaturemon.ui.adapter.IntelligenceAdapter
import com.canonal.creaturemon.ui.adapter.StrengthAdapter
import com.canonal.creaturemon.ui.util.animationUtil.AnimationUtil
import com.canonal.creaturemon.ui.util.navigationUtil.getNavigationResult
import com.canonal.creaturemon.ui.util.navigationUtil.popUpToFragment
import com.canonal.creaturemon.ui.viewModel.CreatureViewModel
import com.canonal.creaturemon.ui.viewModelFactory.CreatureViewModelFactory
import com.squareup.picasso.Picasso

class AddCreatureFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentAddCreatureBinding
    private lateinit var selectedIntelligenceItem: IntelligenceType
    private lateinit var selectedStrengthItem: StrengthType
    private lateinit var selectedEnduranceItem: EnduranceType

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCreatureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val ivAvatar = binding.ivAvatar
        var selectedAvatarUrl= ""
        val etCreatureName = binding.etName
        val spinnerIntelligence = binding.spinnerIntelligence
        val spinnerStrength = binding.spinnerStrength
        val spinnerEndurance = binding.spinnerEndurance
        val btnGenerate = binding.btnGenerate
        val tvTapAvatarLabel = binding.tvTapAvatarLabel
        val creatureViewModel: CreatureViewModel by viewModels {
            CreatureViewModelFactory(AppModule.getCreatureRepository(view.context))
        }
        val intelligenceSpinAdapter = IntelligenceAdapter(
            view.context,
            R.layout.spinner_layout,
            values = creatureViewModel.getIntelligenceTypeList()
        )
        val strengthSpinAdapter = StrengthAdapter(
            view.context,
            R.layout.spinner_layout,
            values = creatureViewModel.getStrengthTypeList()
        )
        val enduranceSpinAdapter = EnduranceAdapter(
            view.context,
            R.layout.spinner_layout,
            values = creatureViewModel.getEnduranceTypeList()
        )

        spinnerIntelligence.adapter = intelligenceSpinAdapter
        spinnerIntelligence.onItemSelectedListener = this

        spinnerStrength.adapter = strengthSpinAdapter
        spinnerStrength.onItemSelectedListener = this

        spinnerEndurance.adapter = enduranceSpinAdapter
        spinnerEndurance.onItemSelectedListener = this

        ivAvatar.setOnClickListener {
            findNavController().navigate(
                R.id.action_addCreatureFragment_to_avatarListFragment,
                null,
                AnimationUtil.getNextFragmentSlideNavOptions()
            )
        }

        getNavigationResult("avatarUrl")?.observe(viewLifecycleOwner, { avatarUrl ->
            if (avatarUrl != null) {
                selectedAvatarUrl = avatarUrl
                Picasso.get().load(selectedAvatarUrl).into(ivAvatar)
                tvTapAvatarLabel.visibility = View.INVISIBLE
            }
        })

        btnGenerate.setOnClickListener {
            when {
                etCreatureName.text.toString().isEmpty() -> {
                    binding.tvCreatureNameError.visibility = View.VISIBLE
                }
                selectedAvatarUrl.isEmpty() -> {
                    binding.tvCreatureNameError.visibility= View.GONE
                    binding.tvCreatureAvatarError.visibility = View.VISIBLE
                }
                else -> {
                    val newCreature = creatureViewModel.getNewCreature(
                        etCreatureName.text.toString(),
                        selectedIntelligenceItem,
                        selectedStrengthItem,
                        selectedEnduranceItem,
                        selectedAvatarUrl
                    )
                    val action =
                        AddCreatureFragmentDirections.actionAddCreatureFragmentToNewCreatureDetailFragment(
                            newCreature
                        )
                    creatureViewModel.insertCreature(newCreature)
                    findNavController().navigate(
                        action,
                        NavOptions.Builder().popUpToFragment(R.id.creatureListFragment, false)
                    )
                }
            }

        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        when (parent.getItemAtPosition(position)) {
            is IntelligenceType -> {
                selectedIntelligenceItem = parent.getItemAtPosition(position) as IntelligenceType
            }
            is StrengthType -> {
                selectedStrengthItem = parent.getItemAtPosition(position) as StrengthType
            }
            is EnduranceType -> {
                selectedEnduranceItem = parent.getItemAtPosition(position) as EnduranceType
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Log.e("NothingSelected", "onNothingSelected: AddCreatureFragment ")
    }

}