package com.example.hangman
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hangman.databinding.LettersBinding


class LettersFragment : Fragment() {

    private lateinit var binding: LettersBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            LettersBinding.inflate(layoutInflater, container, false)
        return binding.root

        binding.AButton
    }

}