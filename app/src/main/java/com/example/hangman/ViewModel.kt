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

    //variable for incorrect guesses
    private val _incorrect = MutableLiveData<Int>()
    val incorrect: LiveData<Int> = _incorrect

    //boolean for game over
    private val _gameover = MutableLiveData<Boolean>()
    val gameover: LiveData<Boolean> = _gameover

    //boolean for game win
    private val _gamewin = MutableLiveData<Boolean>()
    val gamewin: LiveData<Boolean> = _gamewin



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
    fun guessWrong(letter: Char) {
        val currentCount = _incorrect.value ?: 0
        if (currentCount < 6) {
            _incorrect.value = currentCount + 1
            Log.d("ViewModel", "Letter guessed incorrectly: $letter")
        } else {
            // Reset the count when it reaches 6
            _incorrect.value = 1
            Log.d("ViewModel", "Incorrect count reset after reaching limit with letter: $letter")
        }
    }

    fun gameOver(state: Boolean){
        _gameover.value = state
    }

    fun gameWin(state: Boolean){
        _gamewin.value = state
    }

    fun resetIncorrect(){
        _incorrect.value = 0
    }

}
