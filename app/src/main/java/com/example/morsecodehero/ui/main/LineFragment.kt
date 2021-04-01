package com.example.morsecodehero.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.morsecodehero.R

class LineFragment : Fragment() {

    companion object {
        fun newInstance() = LineFragment()
    }

    private val viewModel : MainViewModel by activityViewModels()

    private lateinit var textViewLine : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.line_fragment, container, false)

        textViewLine = view.findViewById<TextView>(R.id.textView_line)
        viewModel.line.observe(viewLifecycleOwner, Observer {
            textViewLine.text = it ?: ""
        })

        return view
    }

}