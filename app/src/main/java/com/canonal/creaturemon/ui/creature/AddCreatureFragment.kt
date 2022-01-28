package com.canonal.creaturemon.ui.creature

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.animation.AnimationUtils
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
import com.canonal.creaturemon.ui.creature.addCreatureViewState.GenerateButtonViewState
import com.canonal.creaturemon.ui.util.animationUtil.AnimationUtil
import com.canonal.creaturemon.ui.util.navigationUtil.getNavigationResult
import com.canonal.creaturemon.ui.util.navigationUtil.popUpToFragment
import com.canonal.creaturemon.ui.util.navigationUtil.removeMenuItem
import com.canonal.creaturemon.ui.util.spinnerUtil.SpinnerUtil
import com.canonal.creaturemon.ui.viewModel.AddCreatureViewModel
import com.canonal.creaturemon.ui.viewModelFactory.CreatureViewModelFactory
import com.squareup.picasso.Picasso

class AddCreatureFragment : Fragment(R.layout.fragment_add_creature),
    AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentAddCreatureBinding
    private lateinit var selectedIntelligenceItem: IntelligenceType
    private lateinit var selectedStrengthItem: StrengthType
    private lateinit var selectedEnduranceItem: EnduranceType
    private val addCreatureViewModel: AddCreatureViewModel by viewModels {
        CreatureViewModelFactory(AppModule.getCreatureRepository(requireActivity()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddCreatureBinding.bind(view)
        binding.addCreatureViewModel = addCreatureViewModel
        val ivAvatar = binding.ivAvatar
        var selectedAvatarUrl = ""
        val etCreatureName = binding.etName
        val spinnerIntelligence = binding.spinnerIntelligence
        val spinnerStrength = binding.spinnerStrength
        val spinnerEndurance = binding.spinnerEndurance
        val btnGenerate = binding.btnGenerate
        val tvTapAvatarLabel = binding.tvTapAvatarLabel
        val tvCreatureAvatarError = binding.tvCreatureAvatarError

        initializeSpinners(view.context, spinnerIntelligence, spinnerStrength, spinnerEndurance)

        binding.generateButtonViewState = GenerateButtonViewState.getInitialVisibility()
        addCreatureViewModel.generateButtonVisibility.observe(viewLifecycleOwner, {
            binding.generateButtonViewState = it
            //https://developer.android.com/reference/android/databinding/ViewDataBinding#executependingbindings
            binding.executePendingBindings()
        })

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
                selectedAvatarUrl.isEmpty() -> {
                    tvCreatureAvatarError.visibility = View.VISIBLE
                    tvCreatureAvatarError.animation = AnimationUtils.loadAnimation(
                        requireContext(),
                        R.anim.slide_in_left
                    )
                }
                else -> {
                    tvCreatureAvatarError.visibility = View.GONE
                    val newCreature = addCreatureViewModel.getNewCreature(
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
                    addCreatureViewModel.insertCreature(newCreature)
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
            values = addCreatureViewModel.getIntelligenceTypeList()
        )
        SpinnerUtil.setSpinnerAdapter(
            spinnerIntelligence,
            intelligenceSpinAdapter,
            this
        )
        val strengthSpinAdapter = BaseSpinnerAdapter(
            context,
            values = addCreatureViewModel.getStrengthTypeList()
        )
        SpinnerUtil.setSpinnerAdapter(
            spinnerStrength,
            strengthSpinAdapter,
            this
        )
        val enduranceSpinAdapter = BaseSpinnerAdapter(
            context,
            values = addCreatureViewModel.getEnduranceTypeList()
        )
        SpinnerUtil.setSpinnerAdapter(
            spinnerEndurance,
            enduranceSpinAdapter,
            this
        )
    }
}