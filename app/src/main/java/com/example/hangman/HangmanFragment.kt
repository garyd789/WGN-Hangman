package com.example.hangman
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hangman.databinding.HangmanBinding
import com.example.hangman.HangmanView

class HangmanFragment : Fragment() {

    private var _binding: HangmanBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = HangmanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Assume that your HangmanView id in the layout file is hangmanView
        val hangmanView = binding.hangmanView

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        viewModel.incorrect.observe(viewLifecycleOwner, Observer { incorrect ->
            binding.hangmanView.incorrectGuesses = incorrect
        })

        // Let's assume you have a function to check the current state of the game and update incorrectGuesses
        // For example, you call this function whenever a new letter is guessed
        updateGame(hangmanView)
    }

    // call this function if word guess is not right then increment the incorrect guess
    private fun updateGame(hangmanView: HangmanView) {
        // Your logic to update the game state goes here
        hangmanView.incorrectGuesses++
        if (hangmanView.incorrectGuesses == 6){
            hangmanView.restartGame()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // This is to avoid memory leaks
    }
}