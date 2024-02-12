package com.example.hangman
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hangman.databinding.HangmanBinding
import com.example.hangman.HangmanView

class HangmanFragment : Fragment() {

    private var _binding: HangmanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = HangmanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Assume that your HangmanView id in the layout file is hangmanView
        val hangmanView = binding.hangmanView

        // Let's assume you have a function to check the current state of the game and update incorrectGuesses
        // For example, you call this function whenever a new letter is guessed
        updateGame(hangmanView)
    }
    private fun updateGame(hangmanView: HangmanView) {
        // Your logic to update the game state goes here
        // For demonstration, let's increment incorrectGuesses every time this function is called
        hangmanView.incorrectGuesses++
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        // You can now access your HangmanView through binding if it is defined in your HangmanBinding
//        // Example: val hangmanView = binding.hangmanViewContainer
//        // And you can set properties on your hangmanView as needed
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // This is to avoid memory leaks
    }
}