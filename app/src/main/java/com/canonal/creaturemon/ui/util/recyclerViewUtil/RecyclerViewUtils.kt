package com.canonal.creaturemon.ui.util.recyclerViewUtil

import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.RecyclerView
import com.canonal.creaturemon.ui.adapter.BaseViewHolder

class RecyclerViewUtils {
    companion object {
        fun initializeRecyclerView(
            recyclerView: RecyclerView,
            adapter: RecyclerView.Adapter<BaseViewHolder>,
            layoutManager: RecyclerView.LayoutManager,
            hasFixedSize: Boolean,
            layoutAnimationController: LayoutAnimationController
        ) {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(hasFixedSize)
            recyclerView.layoutAnimation = layoutAnimationController
        }
    }
}