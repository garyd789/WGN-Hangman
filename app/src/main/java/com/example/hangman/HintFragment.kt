//package com.example.hangman
//
//import android.content.res.ColorStateList
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.lifecycle.Observer
//import android.widget.Toast
//import androidx.core.content.ContextCompat
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import com.example.hangman.databinding.FragmentHintBinding // Assuming you have a layout file named fragment_hint.xml
//import com.example.hangman.databinding.LettersBinding
//
////Wibert’s task
//
////•	Manage persisting states for button colors/disabling when rotation
////•	Right now we have it that when you click the right letter it turns the button green and disables it, and when you click the wrong letter it turns the button dark gray and disables it
////•	But when you rotate the screen it resets all the buttons (all the buttons are light gray again and it is enabled, meaning that you can reselect that letter)
////•	We dont want that
////•	We want it to stay the same color and disabled for the buttons that were clicked
//class HintFragment : Fragment() {
//
//    private var _binding: FragmentHintBinding? = null
//    private val binding get() = _binding!!
//    private lateinit var viewModel: SharedViewModel
//    private var hintClickCount = 0
//
//    //•	The second time it is clicked it disables half of the remaining letters (that are not part of the word)
//    // BUT it costs the user a turn.
//    //•	The third time it is clicked, it shows all the vowels, BUT it costs the user a turn.
//    // Be sure to disable all of the vowel buttons so they user doesn’t click them again.
//    //•	If clicking the hint button would cause the user to be completely hung, ie, lose the game,
//    // then show a toast, “Hint not available”.
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        _binding = FragmentHintBinding.inflate(inflater, container, false)
//        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
//
//        viewModel._currentWordIndex.observe(viewLifecycleOwner, Observer { index: Int ->
//            Log.d("HintFragment", "Current word index: $index")
//            val hint = viewModel.getCurrentHint()
//            Log.d("HintFragment", "Current hint: $hint")
//            // Directly set the hint text for debugging
//            binding.HintText.text = hint ?: "No hint available"
//        })
//
//        savedInstanceState?.let {
//            hintClickCount = it.getInt("hintClickCount", 0)
//        }
//
//        binding.hintButton.setOnClickListener {
//            hintClickCount++
//            System.out.print("print count click hint" + hintClickCount)
//            when (hintClickCount) {
//                //•	The first time it is clicked it displays a hint message.
//                1 -> showHintMessage()
//                //•	The second time it is clicked it disables half of the remaining letters
//                // (that are not part of the word)
//                // BUT it costs the user a turn.
//                2 -> {
//                    disableHalfOfLetters()
//                    consumeTurn()
//                }
//                //•	The third time it is clicked, it shows all the vowels,
//                // BUT it costs the user a turn.
//                // Be sure to disable all of the vowel
//                // buttons so they user doesn’t click them again.
//                3 -> {
//                    showVowels()
//                    disableVowelButtons()
//                    consumeTurn()
//                }
//            }
//        }
//
//        return binding.root
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("hintClickCount", hintClickCount)
//    }
//
//    private fun showHintMessage() {
//        // Use getString(R.string.your_hint_message) to retrieve messages from strings.xml
////        Toast.makeText(context, getString(R.string.hint_message), Toast.LENGTH_SHORT).show()
//        // Assuming you have a hint message to display. Retrieve it from your ViewModel or define it here.
//        val hintMessage = viewModel.getCurrentHint() ?: "No hint available"
//
//        // Update the TextView with the ID HintText with the hint message
//        binding.HintText.text = hintMessage
//    }
//
//    private fun disableHalfOfLetters() {
//        lateinit var binding: LettersBinding
//
//        //disable half of the letters
//        val enabledButtons = listOf(binding.AButton, binding.BButton, /* and so on for all letter buttons */)
//            .filter { it.isEnabled }
//
//        // Randomly disable half of the enabled buttons
//        enabledButtons.shuffled().take(enabledButtons.size / 2).forEach { button ->
//            activity?.runOnUiThread {
//                button.isEnabled = false
//                // Optionally set the button to a disabled color
////                button.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.disabled_button))
//            }
//        }
//    }
//
//    private fun consumeTurn() {
////        viewModel.consumeTurn()
////        _incorrect.value = (_incorrect.value ?: 0) + 1
//    }
//
//    private fun showVowels() {
//        // Your logic to show vowels
//    }
//
//    private fun disableVowelButtons() {
//        // Your logic to disable vowel buttons
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}