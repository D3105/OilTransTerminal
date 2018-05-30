package com.d.oiltransterminal

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_lorry.*

abstract class TrackActivity: AppCompatActivity(), OnItemSelectedListener {
    override fun onNothingSelected(p0: AdapterView<*>?) { }
    abstract val subfolder: String
    lateinit var allTracks: Array<String>
    lateinit var trackNames: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        allTracks = assets.list(subfolder)
        trackNames = allTracks.map { it.split(".")[0] }
    }

    fun configureSpinner(spinner: Spinner, items: List<String>, firstIndex: Int = 0) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.setSelection(firstIndex)
        spinner.onItemSelectedListener = this
    }
}