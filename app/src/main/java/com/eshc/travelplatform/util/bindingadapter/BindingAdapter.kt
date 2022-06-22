package com.eshc.travelplatform.util.bindingadapter

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.eshc.travelplatform.R

object BindingAdapter {
    fun getGradientDrawable(
        drawable: Drawable?,
        cornerRadius: Float,
        opacity: Int? = null
    ): GradientDrawable {
        val gradientDrawable: GradientDrawable
        if (drawable is GradientDrawable) {
            gradientDrawable = drawable
        } else {
            gradientDrawable = GradientDrawable()
            if (drawable is ColorDrawable) {
                gradientDrawable.alpha = opacity ?: drawable.alpha
                gradientDrawable.setColor(drawable.color)
            }
        }
        gradientDrawable.cornerRadius = cornerRadius
        return gradientDrawable
    }
    @BindingAdapter("coverSrc")
    @JvmStatic fun setCoverSrc(view: AppCompatImageView, resource: Any?) {
        when (resource) {
            null ->  Glide.with(view.context).load(R.drawable.background_corner_round).into(view)
            "" -> Glide.with(view.context).load(R.drawable.background_corner_round).into(view)
            else -> Glide.with(view.context).load(resource).centerCrop().placeholder(R.drawable.background_corner_round)
                .into(view)
        }

        view.requestLayout()
    }

}