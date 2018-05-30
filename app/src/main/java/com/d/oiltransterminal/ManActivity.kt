package com.d.oiltransterminal

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_man.*

class ManActivity: TrackActivity() {
    override val subfolder = "man"
    lateinit var points: List<String>

    override fun onItemSelected(spinner: AdapterView<*>?, p1: View?, index: Int, p3: Long) {
        val neighborSpinner = if (spinner == pointASpinner) pointBSpinner else pointASpinner
        val neighborIndex = neighborSpinner.selectedItemPosition

        if (neighborIndex == index) {
            neighborSpinner.setSelection(0)
            manImageView.setImageResource(R.drawable.placeholder)
        } else if (index == 0 || neighborIndex == 0) {
            manImageView.setImageResource(R.drawable.placeholder)
        } else {
            val pointA = points[index]
            val pointB = points[neighborIndex]
            val alternativeImageName1 = pointA + "_" + pointB
            val alternativeImageName2 = pointB + "_" + pointA
            val imageName = if (trackNames.contains(alternativeImageName1)) alternativeImageName1 else alternativeImageName2
            manImageView.setImageFromAssets(assets, subfolder, "$imageName.jpg")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man)

        points = listOf("") + trackNames.flatMap { it.split("_") }.distinct()
        configureSpinner(pointASpinner, points, 1)
        configureSpinner(pointBSpinner, points, 2)
    }
}
