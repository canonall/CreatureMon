package com.canonal.creaturemon.ui.util

import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.canonal.creaturemon.R

class AnimationUtil {
    companion object {
        fun getNextFragmentSlideNavOptions(): NavOptions = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right

            }
        }
    }
}