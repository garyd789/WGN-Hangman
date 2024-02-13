package com.example.hangman
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hangman.databinding.LettersBinding


class LettersFragment : Fragment() {

    private lateinit var binding: LettersBinding
    private lateinit var viewModel: SharedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            LettersBinding.inflate(layoutInflater, container, false)

        //set listeners on each letter
        binding.AButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("A")) {
                    viewModel.guessRight('A')
                    Log.d("LettersFragment", "Contains A")
                }
                else {
                    Log.d("LettersFragment", "Does not contain A")
                }
            }
        }

        binding.BButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("B")) {
                    viewModel.guessRight('B')
                    Log.d("LettersFragment", "Contains B")
                }
                else {
                    Log.d("LettersFragment", "Does not contain B")
                }
            }
        }
        binding.CButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("C")) {
                    viewModel.guessRight('C')
                    Log.d("LettersFragment", "Contains C")
                }
                else {
                    Log.d("LettersFragment", "Does not contain C")
                }
            }
        }
        binding.DButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("D")) {
                    viewModel.guessRight('D')
                    Log.d("LettersFragment", "Contains D")
                }
                else {
                    Log.d("LettersFragment", "Does not contain D")
                }
            }
        }
        binding.EButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("E")) {
                    viewModel.guessRight('E')
                    Log.d("LettersFragment", "Contains E")
                }
                else {
                    Log.d("LettersFragment", "Does not contain E")
                }
            }
        }
        binding.FButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("F")) {
                    viewModel.guessRight('F')
                    Log.d("LettersFragment", "Contains F")
                }
                else {
                    Log.d("LettersFragment", "Does not contain F")
                }
            }
        }
        binding.GButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("G")) {
                    viewModel.guessRight('G')
                    Log.d("LettersFragment", "Contains G")
                }
                else {
                    Log.d("LettersFragment", "Does not contain G")
                }
            }
        }
        binding.HButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("H")) {
                    viewModel.guessRight('H')
                    Log.d("LettersFragment", "Contains H")
                }
                else {
                    Log.d("LettersFragment", "Does not contain H")
                }
            }
        }
        binding.IButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("I")) {
                    viewModel.guessRight('I')
                    Log.d("LettersFragment", "Contains I")
                }
                else {
                    Log.d("LettersFragment", "Does not contain I")
                }
            }
        }
        binding.JButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("J")) {
                    viewModel.guessRight('J')
                    Log.d("LettersFragment", "Contains J")
                }
                else {
                    Log.d("LettersFragment", "Does not contain J")
                }
            }
        }
        binding.KButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("K")) {
                    viewModel.guessRight('K')
                    Log.d("LettersFragment", "Contains K")
                }
                else {
                    Log.d("LettersFragment", "Does not contain K")
                }
            }
        }
        binding.LButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("L")) {
                    viewModel.guessRight('L')
                    Log.d("LettersFragment", "Contains L")
                }
                else {
                    Log.d("LettersFragment", "Does not contain L")
                }
            }
        }
        binding.MButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("M")) {
                    viewModel.guessRight('M')
                    Log.d("LettersFragment", "Contains M")
                }
                else {
                    Log.d("LettersFragment", "Does not contain M")
                }
            }
        }
        binding.NButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("N")) {
                    viewModel.guessRight('N')
                    Log.d("LettersFragment", "Contains N")
                }
                else {
                    Log.d("LettersFragment", "Does not contain N")
                }
            }
        }
        binding.OButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("O")) {
                    viewModel.guessRight('O')
                    Log.d("LettersFragment", "Contains O")
                }
                else {
                    Log.d("LettersFragment", "Does not contain O")
                }
            }
        }
        binding.PButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("P")) {
                    viewModel.guessRight('P')
                    Log.d("LettersFragment", "Contains P")
                }
                else {
                    Log.d("LettersFragment", "Does not contain P")
                }
            }
        }
        binding.QButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("Q")) {
                    viewModel.guessRight('Q')
                    Log.d("LettersFragment", "Contains Q")
                }
                else {
                    Log.d("LettersFragment", "Does not contain Q")
                }
            }
        }
        binding.RButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("R")) {
                    viewModel.guessRight('R')
                    Log.d("LettersFragment", "Contains R")
                }
                else {
                    Log.d("LettersFragment", "Does not contain R")
                }
            }
        }
        binding.SButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("S")) {
                    viewModel.guessRight('S')
                    Log.d("LettersFragment", "Contains S")
                }
                else {
                    Log.d("LettersFragment", "Does not contain S")
                }
            }
        }
        binding.TButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("T")) {
                    viewModel.guessRight('T')
                    Log.d("LettersFragment", "Contains T")
                }
                else {
                    Log.d("LettersFragment", "Does not contain T")
                }
            }
        }
        binding.UButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("U")) {
                    viewModel.guessRight('U')
                    Log.d("LettersFragment", "Contains U")
                }
                else {
                    Log.d("LettersFragment", "Does not contain U")
                }
            }
        }
        binding.VButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("V")) {
                    viewModel.guessRight('V')
                    Log.d("LettersFragment", "Contains V")
                }
                else {
                    Log.d("LettersFragment", "Does not contain V")
                }
            }
        }
        binding.WButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("W")) {
                    viewModel.guessRight('W')
                    Log.d("LettersFragment", "Contains W")
                }
                else {
                    Log.d("LettersFragment", "Does not contain W")
                }
            }
        }
        binding.XButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("X")) {
                    viewModel.guessRight('X')
                    Log.d("LettersFragment", "Contains X")
                }
                else {
                    Log.d("LettersFragment", "Does not contain X")
                }
            }
        }
        binding.YButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("Y")) {
                    viewModel.guessRight('Y')
                    Log.d("LettersFragment", "Contains Y")
                }
                else {
                    Log.d("LettersFragment", "Does not contain Y")
                }
            }
        }
        binding.ZButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("Z")) {
                    viewModel.guessRight('Z')
                    Log.d("LettersFragment", "Contains Z")
                }
                else {
                    Log.d("LettersFragment", "Does not contain Z")
                }
            }
        }
        return binding.root

    }

}