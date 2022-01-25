package com.canonal.creaturemon.ui.creature

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
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
import com.canonal.creaturemon.ui.adapter.BaseSpinnerAdapter
import com.canonal.creaturemon.ui.util.animationUtil.AnimationUtil
import com.canonal.creaturemon.ui.util.navigationUtil.getNavigationResult
import com.canonal.creaturemon.ui.util.navigationUtil.popUpToFragment
import com.canonal.creaturemon.ui.util.navigationUtil.removeMenuItem
import com.canonal.creaturemon.ui.util.spinnerUtil.SpinnerUtil
import com.canonal.creaturemon.ui.viewModel.CreatureViewModel
import com.canonal.creaturemon.ui.viewModelFactory.CreatureViewModelFactory
import com.squareup.picasso.Picasso

class AddCreatureFragment : Fragment(R.layout.fragment_add_creature),
    AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentAddCreatureBinding
    private lateinit var selectedIntelligenceItem: IntelligenceType
    private lateinit var selectedStrengthItem: StrengthType
    private lateinit var selectedEnduranceItem: EnduranceType
    private val creatureViewModel: CreatureViewModel by viewModels {
        CreatureViewModelFactory(AppModule.getCreatureRepository(requireActivity()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddCreatureBinding.bind(view)
        val ivAvatar = binding.ivAvatar
        var selectedAvatarUrl = ""
        val etCreatureName = binding.etName
        val spinnerIntelligence = binding.spinnerIntelligence
        val spinnerStrength = binding.spinnerStrength
        val spinnerEndurance = binding.spinnerEndurance
        val btnGenerate = binding.btnGenerate
        val tvTapAvatarLabel = binding.tvTapAvatarLabel

        initializeSpinners(view.context, spinnerIntelligence, spinnerStrength, spinnerEndurance)

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
                    binding.tvCreatureNameError.visibility = View.GONE
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

    override fun onPrepareOptionsMenu(menu: Menu) {
        removeMenuItem(menu, R.id.addCreatureFragment)
        removeMenuItem(menu, R.id.creatureListFragment)
    }

    private fun initializeSpinners(
        context: Context,
        spinnerIntelligence: Spinner,
        spinnerStrength: Spinner,
        spinnerEndurance: Spinner
    ) {
        val intelligenceSpinAdapter = BaseSpinnerAdapter(
            context,
            values = creatureViewModel.getIntelligenceTypeList()
        )
        SpinnerUtil.setSpinnerAdapter(
            spinnerIntelligence,
            intelligenceSpinAdapter,
            this
        )
        val strengthSpinAdapter = BaseSpinnerAdapter(
            context,
            values = creatureViewModel.getStrengthTypeList()
        )
        SpinnerUtil.setSpinnerAdapter(
            spinnerStrength,
            strengthSpinAdapter,
            this
        )
        val enduranceSpinAdapter = BaseSpinnerAdapter(
            context,
            values = creatureViewModel.getEnduranceTypeList()
        )
        SpinnerUtil.setSpinnerAdapter(
            spinnerEndurance,
            enduranceSpinAdapter,
            this
        )
    }
}