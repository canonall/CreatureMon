package com.canonal.creaturemon.ui.util.animationUtil

import android.content.Context
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.annotation.IdRes
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.canonal.creaturemon.R

class AnimationUtil {

    companion object {
        fun getNextFragmentSlideNavOptions(): NavOptions = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.fade_out
                popEnter = R.anim.fade_in
                popExit = R.anim.slide_out_right

            }
        }

        fun getLayoutAnimationController(context: Context, layoutAnimationId: Int): LayoutAnimationController{
            return AnimationUtils.loadLayoutAnimation(context, layoutAnimationId)
        }
    }

}