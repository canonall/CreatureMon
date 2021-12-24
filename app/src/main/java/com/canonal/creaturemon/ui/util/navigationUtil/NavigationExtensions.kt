package com.canonal.creaturemon.ui.util.navigationUtil

import androidx.annotation.IdRes
import androidx.navigation.NavOptions
import com.canonal.creaturemon.R


fun NavOptions.Builder.popUpToCreatureListFragment(
    @IdRes destinationFragmentId: Int,
    inclusive: Boolean
): NavOptions {
    return this
        .setPopUpTo(destinationFragmentId, inclusive)
        .setExitAnim(R.anim.slide_out_left)
        .setPopExitAnim(R.anim.slide_out_right)
        .build()
}

