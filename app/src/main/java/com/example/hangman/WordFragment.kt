package com.example.hangman
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hangman.databinding.HangmanBinding
import com.example.hangman.databinding.WordBinding

class WordFragment : Fragment() {

    private lateinit var binding: WordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            WordBinding.inflate(layoutInflater, container, false)
        return binding.root




    }
}