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
import com.example.hangman.databinding.HangmanBinding
import com.example.hangman.HangmanView
import kotlinx.coroutines.delay

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
            if (incorrect == 6){
                showGameOverDialog()
                viewModel.gameOver(true)
            }
        })

        viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
            if (gamewin){
                val hangmanView = binding.hangmanView
                hangmanView.restartGame()
            }
        })

        // Let's assume you have a function to check the current state of the game and update incorrectGuesses
        // For example, you call this function whenever a new letter is guessed

    }

    fun showGameOverDialog() {
        // Create an AlertDialog builder
        val builder = AlertDialog.Builder(requireActivity())
        val hangmanView = binding.hangmanView

        // Set the title and message for the dialog
        builder.setTitle("Game Over")
        builder.setMessage("Would you like to restart the game?")

        // Add a button to the dialog for restarting the game
        builder.setPositiveButton("Restart Game") { dialog, which ->
            // Code to restart the game goes here
            hangmanView.restartGame()
        }

        // Optionally, add a cancel or dismiss button
        builder.setNegativeButton("Cancel", { dialog, which ->
            // Code to dismiss the dialog and perhaps exit the game or perform another action
            dialog.dismiss()
        })

        // Create and show the dialog
        builder.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // This is to avoid memory leaks
    }


}