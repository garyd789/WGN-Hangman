package com.example.hangman

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hangman.databinding.FragmentHintBinding // Assuming you have a layout file named fragment_hint.xml

class HintFragment : Fragment() {

    private var _binding: FragmentHintBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SharedViewModel
    private var hintClickCount = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHintBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.hintButton.setOnClickListener {
            hintClickCount++
            when (hintClickCount) {
                1 -> showHintMessage()
                2 -> {
                    disableHalfOfLetters() // disable half of the letters.
                    consumeTurn()
                }
                3 -> {
                    showVowels() // show all vowels.
                    disableVowelButtons() // disable vowel buttons.
                    consumeTurn()
                }
            }
        }

        return binding.root
    }

    private fun showHintMessage() {
    }

    private fun disableHalfOfLetters() {
    }

    private fun consumeTurn() {
    }

    private fun showVowels() {
    }

    private fun disableVowelButtons() {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
