package com.example.morsecodehero.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    private val _line : MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val line : LiveData<String>
        get() = _line

    fun clearLine() {
        _line.value = ""
        Log.d(TAG, "$this -> cleanLine()")
    }

    fun appendText(text: String) {
        _line.value = _line.value + text

        Log.d(TAG, "$this -> appendText()")
    }
}