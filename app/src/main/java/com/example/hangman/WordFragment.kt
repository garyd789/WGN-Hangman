package com.example.hangman
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hangman.databinding.WordBinding
import kotlin.random.Random

class WordFragment : Fragment() {

    private lateinit var binding: WordBinding
    private lateinit var viewModel: SharedViewModel
    private lateinit var selectedWord: String
    private lateinit var wordGuess: String
    val words = listOf("PARENT", "CLEAN", "ARCHER", "ANTIHERO", "FIFTEEN", "FEARLESS", "MIDNIGHT", "EVERMORE", "DEBUT", "RED", "FOLKLORE")




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

       newGame()

        // Select a random word from the list after gameover
        viewModel.gameover.observe(viewLifecycleOwner, Observer {gameover ->
            if (gameover) {
                newGame()
                Log.d("WordFragment", "New word selected")
            }
        })
        viewModel.letter.observe(viewLifecycleOwner, Observer{ char ->
                        wordGuess = updatePlaceholderStringWithGuess(selectedWord, wordGuess, char)
                        binding.wordContainer.setText(wordGuess)

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
        val res = result.toString()
        if (!res.contains("_")){
            showCongratsDialog()
            viewModel.gameWin(true)
        }
        return result.toString()
    }

    fun showCongratsDialog() {
        // Create an AlertDialog builder
        val builder = AlertDialog.Builder(requireActivity())
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)


        // Set the title and message for the dialog
        builder.setTitle("Congratulations!")
        builder.setMessage("Would you like to restart the game?")

        // Add a button to the dialog for restarting the game
        builder.setPositiveButton("Restart Game") { dialog, which ->
            // Code to restart the game goes here
            newGame()
        }

        // Optionally, add a cancel or dismiss button
        builder.setNegativeButton("Cancel", { dialog, which ->
            // Code to dismiss the dialog and perhaps exit the game or perform another action
            dialog.dismiss()
        })

        // Create and show the dialog
        builder.create().show()
    }

    fun newGame(){
        selectedWord = words[Random.nextInt(words.size)]
        viewModel.setWord(selectedWord)
        wordGuess = generateLinesWithSpacesForWord(selectedWord)
        binding.wordContainer.setText(wordGuess)

    }




}