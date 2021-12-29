package com.canonal.creaturemon.ui.util.bindingAdapterUtil

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setImageWithUrl")
fun setImageWithPicasso(imageView: ImageView, imageUrl: String){
    Picasso.get().isLoggingEnabled = true
    Picasso.get().setIndicatorsEnabled(true)
    Picasso.get().load(imageUrl).into(imageView)
}