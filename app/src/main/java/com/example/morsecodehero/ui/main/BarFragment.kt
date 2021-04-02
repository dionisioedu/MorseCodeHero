package com.example.morsecodehero.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.morsecodehero.R

class BarFragment : Fragment() {

    companion object {
        fun newInstance() = BarFragment()
    }

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bar_fragment, container, false)

        val textViewPoints = view.findViewById<TextView>(R.id.textView_points)
        textViewPoints?.let { textView ->
            viewModel.points.observe(viewLifecycleOwner, Observer {
                textView.text = it.toString()
            })
        }

        return view
    }
}