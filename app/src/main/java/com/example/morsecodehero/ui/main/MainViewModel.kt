package com.example.morsecodehero.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val _line: MutableLiveData<String> = MutableLiveData<String>("")
    val line: LiveData<String> get() = _line

    private val _word: MutableLiveData<String> = MutableLiveData<String>("A")
    val word: LiveData<String> get() = _word

    private val _points: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val points: LiveData<Int> get() = _points

    fun clearLine() {
        _line.value = ""
    }

    fun appendText(text: String) {
        if (text == " ") {
            matchWord()
            clearLine()
            nextWord()
        } else {
            _line.value = _line.value + text
        }
    }

    fun setWord(newWord: String) {
        _word.value = newWord
    }

    fun matchWord() {
        if (letterToMorse[_word.value] == _line.value) {
            sumPoints()
        } else {
            resetPoints()
        }
    }

    fun nextWord() {
        val next = Random.nextInt(letterToMorse.size)
        setWord(mapKeys[next])
    }

    fun resetPoints() {
        _points.value = 0
    }

    fun sumPoints() {
        _points.value = _points.value?.plus(1)
    }

    companion object {
        private const val TAG = "MainViewModel"
        private val letterToMorse = mapOf(
                "A" to ".-",
                "B" to "-...",
                "C" to "-.-.",
                "D" to "-..",
                "E" to ".",
                "F" to "..-.",
                "G" to "--.",
                "H" to "....",
                "I" to "..",
                "J" to ".---",
                "K" to "-.-",
                "L" to ".-..",
                "M" to "--",
                "N" to "-.",
                "O" to "---",
                "P" to ".--.",
                "Q" to "--.-",
                "R" to ".-.",
                "S" to "...",
                "T" to "-",
                "U" to "..-",
                "V" to "...-",
                "W" to ".--",
                "X" to "-..-",
                "Y" to "-.--",
                "Z" to "--..",
                "1" to ".----",
                "2" to "..---",
                "3" to "...--",
                "4" to "....-",
                "5" to ".....",
                "6" to "-....",
                "7" to "--...",
                "8" to "---..",
                "9" to "----.",
                "0" to "-----",
                "." to ".-.-.-",
                "," to "--..--",
                "?" to "..--..",
        )

        private val mapKeys = arrayListOf(
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G",
                "H",
                "I",
                "J",
                "K",
                "L",
                "M",
                "N",
                "O",
                "P",
                "Q",
                "R",
                "S",
                "T",
                "U",
                "V",
                "W",
                "X",
                "Y",
                "Z",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "0",
                ".",
                ",",
                "?" )
    }
}