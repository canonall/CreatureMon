package com.canonal.creaturemon.ui.util.recyclerViewUtil

import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewUtils {
    companion object {
        fun <T : RecyclerView.ViewHolder?> initializeRecyclerView(
            recyclerView: RecyclerView,
            adapter: RecyclerView.Adapter<T>,
            layoutManager: RecyclerView.LayoutManager,
            hasFixedSize: Boolean,
            layoutAnimationController: LayoutAnimationController,
            edgeEffectFactory: RecyclerView.EdgeEffectFactory
        ) {
            recyclerView.apply {
                this.adapter = adapter
                this.layoutManager = layoutManager
                this.setHasFixedSize(hasFixedSize)
                this.layoutAnimation = layoutAnimationController
                this.edgeEffectFactory = edgeEffectFactory
            }
        }
    }
}