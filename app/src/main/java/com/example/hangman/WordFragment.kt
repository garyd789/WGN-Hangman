package com.example.hangman
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hangman.databinding.WordBinding
import kotlin.random.Random

class WordFragment : Fragment() {

    private lateinit var binding: WordBinding
    private lateinit var viewModel: SharedViewModel
    val words = listOf("PARENT", "CLEAN", "ARCHER", "ANTIHERO", "FIFTEEN", "FEARLESS", "MIDNIGHT", "EVERMORE", "DEBUT", "RED", "SPEAK NOW", "FOLKLORE")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WordBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // Select a random word from the list
        val selectedWord = words[Random.nextInt(words.size)]

        viewModel.setWord(selectedWord)
        var wordGuess = generateLinesWithSpacesForWord(selectedWord)
        binding.wordContainer.setText(wordGuess)

        viewModel.guess.observe(viewLifecycleOwner, Observer { state ->
            if (state == true) {
                viewModel.letter.observe(viewLifecycleOwner, Observer{ char ->
                    viewModel.word.observe(viewLifecycleOwner, Observer { answer ->
                        wordGuess = updatePlaceholderStringWithGuess(answer, wordGuess, char)
                        binding.wordContainer.setText(wordGuess)
                        if (!wordGuess.contains("_")){
                            Toast.makeText(
                                getActivity(), // Use getActivity() to get the context of the containing activity
                                R.string.done,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                })

            }
        })

        return binding.root
    }



    // Function to replace each character of the word with an underscore followed by a space
    fun generateLinesWithSpacesForWord(word: String): String {
        return "_ ".repeat(word.length).trimEnd()
    }

    // Function to update the placeholder string with the guessed letter
    fun updatePlaceholderStringWithGuess(word: String, placeholder: String, guess: Char): String {
        val result = StringBuilder(placeholder)
        for (index in word.indices) {
            if (word[index] == guess) {
                val placeholderIndex = index * 2
                result[placeholderIndex] = guess
            }
        }
        return result.toString()
    }



}