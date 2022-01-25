package com.canonal.creaturemon.ui.creature

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.canonal.creaturemon.R
import com.canonal.creaturemon.databinding.FragmentAvatarListBinding
import com.canonal.creaturemon.di.AppModule
import com.canonal.creaturemon.ui.adapter.AvatarAdapter
import com.canonal.creaturemon.ui.util.animationUtil.AnimationUtil
import com.canonal.creaturemon.ui.util.navigationUtil.removeMenuItem
import com.canonal.creaturemon.ui.util.navigationUtil.setNavigationResult
import com.canonal.creaturemon.ui.util.recyclerViewUtil.BounceEdgeEffectFactory
import com.canonal.creaturemon.ui.util.recyclerViewUtil.RecyclerViewUtils
import com.canonal.creaturemon.ui.viewModel.AvatarViewModel
import com.canonal.creaturemon.ui.viewModelFactory.AvatarViewModelFactory

class AvatarListFragment : Fragment(R.layout.fragment_avatar_list) {

    private lateinit var binding: FragmentAvatarListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAvatarListBinding.bind(view)
        val rvAvatar = binding.rvAvatarList
        val avatarViewModel: AvatarViewModel by viewModels {
            AvatarViewModelFactory(AppModule.getAvatarRepository())
        }
        val idList = avatarViewModel.getAvatarIdArray()
        avatarViewModel.getCharacterList(
            //default separator is ","
            idList.joinToString { it.toString() }
        )

        avatarViewModel.characterList.observe(viewLifecycleOwner, {
            val avatarAdapter = AvatarAdapter(it) { avatarUrl ->
                setNavigationResult(avatarUrl, "avatarUrl")
                findNavController().popBackStack(R.id.addCreatureFragment, false)
            }
            RecyclerViewUtils.initializeRecyclerView(
                rvAvatar,
                avatarAdapter,
                GridLayoutManager(view.context, 3),
                false,
                AnimationUtil.getLayoutAnimationController(
                    view.context,
                    R.anim.avatar_list_layout_animation
                ),
                BounceEdgeEffectFactory()
            )
        })

        avatarViewModel.errorMessage.observe(viewLifecycleOwner, {
            Log.e("RETROFIT FAIL", "onViewCreated: RETROFIT FAIL at AvatarListFragment")
        })
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        removeMenuItem(menu, R.id.addCreatureFragment)
        removeMenuItem(menu, R.id.creatureListFragment)
    }
}


