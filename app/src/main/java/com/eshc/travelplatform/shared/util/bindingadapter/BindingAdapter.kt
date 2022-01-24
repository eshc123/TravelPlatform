package com.eshc.travelplatform.shared.util.bindingadapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.eshc.travelplatform.R

object BindingAdapter {

    @BindingAdapter("coverSrc")
    @JvmStatic fun setCoverSrc(view: AppCompatImageView, resource: String?) {
        when (resource) {
            null ->  Glide.with(view.context).load(R.drawable.background_corner_round).into(view)
            "" -> Glide.with(view.context).load(R.drawable.background_corner_round).into(view)
            else -> Glide.with(view.context).load(resource).centerCrop().placeholder(R.drawable.background_corner_round)
                .into(view)
        }

        view.requestLayout()
    }
}