package com.cba.core_ui.utils

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("source")
fun source(imageView: ImageView,resource : String?){
    if(resource == null )
        return
    val context = imageView.context
    val drawable = context.getDrawable(resource)
    if(drawable == 0){
        Glide.with(context).load(resource).into(imageView)
    }else{
        Glide.with(context).load(drawable).into(imageView)
    }
}
fun Context.getDrawable(resource: String) : Int {
    return  this.resources.getIdentifier(resource,"drawable",this.packageName)
}