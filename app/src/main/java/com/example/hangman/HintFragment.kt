package com.example.hangman

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hangman.databinding.FragmentHintBinding // Assuming you have a layout file named fragment_hint.xml

//Wibert’s task

//•	Manage persisting states for button colors/disabling when rotation
//•	Right now we have it that when you click the right letter it turns the button green and disables it, and when you click the wrong letter it turns the button dark gray and disables it
//•	But when you rotate the screen it resets all the buttons (all the buttons are light gray again and it is enabled, meaning that you can reselect that letter)
//•	We dont want that
//•	We want it to stay the same color and disabled for the buttons that were clicked
class HintFragment : Fragment() {

    private var _binding: FragmentHintBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SharedViewModel
    private var hintClickCount = 0

    //•	The first time it is clicked it displays a hint message.
    //•	The second time it is clicked it disables half of the remaining letters (that are not part of the word)
    // BUT it costs the user a turn.
    //•	The third time it is clicked, it shows all the vowels, BUT it costs the user a turn.
    // Be sure to disable all of the vowel buttons so they user doesn’t click them again.
    //•	If clicking the hint button would cause the user to be completely hung, ie, lose the game,
    // then show a toast, “Hint not available”.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHintBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        savedInstanceState?.let {
            hintClickCount = it.getInt("hintClickCount", 0)
        }

        binding.hintButton.setOnClickListener {
            hintClickCount++
            System.out.print("print count click hint" + hintClickCount)
            when (hintClickCount) {
                1 -> showHintMessage()
                2 -> {
                    disableHalfOfLetters()
                    consumeTurn()
                }
                3 -> {
                    showVowels()
                    disableVowelButtons()
                    consumeTurn()
                }
            }
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("hintClickCount", hintClickCount)
    }

    private fun showHintMessage() {
        // Use getString(R.string.your_hint_message) to retrieve messages from strings.xml
        Toast.makeText(context, getString(R.string.hint_message), Toast.LENGTH_SHORT).show()
    }

    private fun disableHalfOfLetters() {
        // Your logic to disable half of the letters
    }

    private fun consumeTurn() {
        // Your logic to consume a turn
    }

    private fun showVowels() {
        // Your logic to show vowels
    }

    private fun disableVowelButtons() {
        // Your logic to disable vowel buttons
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}