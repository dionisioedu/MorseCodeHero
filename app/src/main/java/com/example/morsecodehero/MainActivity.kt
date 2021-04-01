package com.example.morsecodehero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.morsecodehero.ui.main.BarFragment
import com.example.morsecodehero.ui.main.ButtonsFragment
import com.example.morsecodehero.ui.main.LineFragment
import com.example.morsecodehero.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_bar, BarFragment.newInstance())
                .replace(R.id.container, MainFragment.newInstance())
                .replace(R.id.container_line, LineFragment.newInstance())
                .replace(R.id.container_buttons, ButtonsFragment.newInstance())
                .commitNow()
        }
    }
}