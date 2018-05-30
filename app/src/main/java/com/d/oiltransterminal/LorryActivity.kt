package com.d.oiltransterminal

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_lorry.*

class LorryActivity: TrackActivity() {
    override val subfolder = "lorry"

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, index: Int, p3: Long) {
        lorryImageView.setImageFromAssets(assets, subfolder, allTracks[index])
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lorry)

        configureSpinner(lorrySpinner, trackNames)
        lorryImageView.setImageFromAssets(assets, subfolder, allTracks[0])
    }
}
