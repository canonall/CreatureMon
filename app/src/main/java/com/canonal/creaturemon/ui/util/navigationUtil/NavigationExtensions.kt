package com.canonal.creaturemon.ui.util.navigationUtil

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.canonal.creaturemon.R


fun NavOptions.Builder.popUpToFragment(
    @IdRes destinationFragmentId: Int,
    inclusive: Boolean
): NavOptions {
    return this
        .setPopUpTo(destinationFragmentId, inclusive)
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right)
        .build()
}

fun Fragment.getNavigationResult(key: String) =
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>(key)

fun Fragment.setNavigationResult(result: String, key: String) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
}

