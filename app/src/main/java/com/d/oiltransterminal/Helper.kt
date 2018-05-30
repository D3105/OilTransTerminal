package com.d.oiltransterminal

import android.content.Context
import android.content.res.AssetManager
import android.graphics.drawable.Drawable
import android.widget.Button
import android.widget.ImageView

fun AssetManager.getDrawable(subfolder: String, name: String): Drawable {
    val stream = open("$subfolder/$name")
    return Drawable.createFromStream(stream, null)
}

fun ImageView.setImageFromAssets(assets: AssetManager, subfolder: String, name: String) {
    val image = assets.getDrawable(subfolder, name)
    setImageDrawable(image)
}