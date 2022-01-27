package com.canonal.creaturemon.ui.creature.addCreatureViewState

import android.view.View

data class GenerateButtonViewState(private val isGenerateButtonVisible: Boolean) {
    fun getGenerateButtonVisibility() =
        if (isGenerateButtonVisible) View.VISIBLE else View.INVISIBLE

    companion object {
        fun getInitialVisibility() = GenerateButtonViewState(false)
    }

}
