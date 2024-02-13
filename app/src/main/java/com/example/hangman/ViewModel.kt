package com.example.hangman

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    // private mutable data
    private val _word = MutableLiveData<String>()

    // public immutable LiveData
    val word: LiveData<String> = _word


    //boolean for when a letter is guessed
    private val _guess = MutableLiveData<Boolean>()
    val guess: LiveData<Boolean> = _guess


    //variable used to pass along letters
    private val _letter = MutableLiveData<Char>()
    val letter: LiveData<Char> = _letter

    // Function used to set a new word
    fun setWord(newWord: String) {
        _word.value = newWord
        Log.d("ViewModel", newWord)
    }
    fun guessRight(letter: Char) {
            _guess.value = true
            _letter.value = letter
            Log.d("ViewModel", "Letter guessed correctly")

    }

}
