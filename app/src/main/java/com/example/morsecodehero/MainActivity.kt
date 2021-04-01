package com.example.morsecodehero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.morsecodehero.ui.main.*

class MainActivity : AppCompatActivity()  {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val viewModel: MainViewModel by viewModels()

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