package com.d.oiltransterminal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        mapButton.setListenerToStartActivity<MapActivity>()
        lorryButton.setListenerToStartActivity<LorryActivity>()
        manButton.setListenerToStartActivity<ManActivity>()
        infoButton.setListenerToStartActivity<InfoActivity>()
        exitButton.setOnClickListener {
            moveTaskToBack(true)
        }

        startActivity(Intent(this, LoginActivity::class.java))
    }

    inline fun <reified T> Button.setListenerToStartActivity() {
        setOnClickListener {
            startActivity(Intent(this@MenuActivity, T::class.java))
        }
    }
}