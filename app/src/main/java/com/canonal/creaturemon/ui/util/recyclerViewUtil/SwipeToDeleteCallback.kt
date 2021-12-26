package com.canonal.creaturemon.ui.util.recyclerViewUtil

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.canonal.creaturemon.R

abstract class SwipeToDeleteCallback(context: Context) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

    private val deleteIcon= ContextCompat.getDrawable(context, R.drawable.ic_delete)
    private val intrinsicWidth= deleteIcon?.intrinsicWidth
    private val intrinsicHeight= deleteIcon?.intrinsicHeight
    private val background = ColorDrawable()
    private val clearPaint = Paint().apply { xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR) }

//        To disable "swipe" for specific item return 0 here.
//    For example:
//    if (viewHolder?.itemViewType == YourAdapter.SOME_TYPE) return 0
//    if (viewHolder?.adapterPosition == 0) return 0
//    override fun getMovementFlags(
//        recyclerView: RecyclerView,
//        viewHolder: RecyclerView.ViewHolder
//    ): Int {
//        if (viewHolder.adapterPosition == 10) return 0
//        return super.getMovementFlags(recyclerView, viewHolder)
//    }

    // We don't want support moving items up/down
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onChildDraw(
        canvas: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val itemView = viewHolder.itemView
        val itemHeight = viewHolder.itemView.bottom - itemView.top
        val isCanceled = dX == 0f && isCurrentlyActive.not()

        if (isCanceled) {
            clearCanvas(
                canvas,
                itemView.right + dX,
                itemView.top.toFloat(),
                itemView.right.toFloat(),
                itemView.bottom.toFloat()
            )
            super.onChildDraw(canvas, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            return
        }

        //draw background
        background.color = Color.RED
        background.setBounds(itemView.right + dX.toInt(),itemView.top, itemView.right,itemView.bottom)
        background.draw(canvas)

        // Calculate position of delete icon
        if (intrinsicWidth != null && intrinsicHeight!= null) {
             val deleteIconTop = itemView.top + (itemHeight - intrinsicHeight) / 2
             val deleteIconMargin = (itemHeight - intrinsicHeight) / 2
             val deleteIconLeft = itemView.right - deleteIconMargin - intrinsicWidth
             val deleteIconRight = itemView.right - deleteIconMargin
             val deleteIconBottom = deleteIconTop + intrinsicHeight

            // Draw the delete icon
            deleteIcon?.setBounds(deleteIconLeft,deleteIconTop,deleteIconRight,deleteIconBottom)
            deleteIcon?.draw(canvas)
            }

        super.onChildDraw(canvas, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    private fun clearCanvas(
        canvas: Canvas,
        left: Float,
        top: Float,
        right: Float,
        bottom: Float
    ) {
        canvas.drawRect(left, right, top, bottom, clearPaint)
    }
}