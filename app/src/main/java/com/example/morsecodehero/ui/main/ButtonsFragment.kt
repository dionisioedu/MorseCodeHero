package com.example.morsecodehero.ui.main

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.morsecodehero.R

class ButtonsFragment : Fragment() {

    companion object {
        fun newInstance() = ButtonsFragment()
    }

    private val  viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.buttons_fragment, container, false)

        val buttonDot = view.findViewById<ImageButton>(R.id.button_dot)
        buttonDot?.setOnClickListener {
            viewModel.appendText(".")
        }

        val buttonLine = view.findViewById<ImageButton>(R.id.button_line)
        buttonLine?.setOnClickListener {
            viewModel.appendText("-")
        }

        val buttonSpace = view.findViewById<ImageButton>(R.id.button_space)
        buttonSpace?.setOnClickListener {
            viewModel.appendText(" ")
        }

        return view
    }

}