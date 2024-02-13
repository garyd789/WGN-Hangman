package com.example.hangman
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hangman.databinding.LettersBinding
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat


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
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.AButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('A')
                    Log.d("LettersFragment", "Contains A")

                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.AButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('A')
                    Log.d("LettersFragment", "Does not contain A")
                }
                it.isEnabled = false
            }
        }

        binding.BButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("B")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.BButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('B')
                    Log.d("LettersFragment", "Contains B")

                }
                else {
                    viewModel.guessWrong('B')
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.BButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Does not contain B")
                }
                it.isEnabled = false
            }
        }
        binding.CButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("C")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.CButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('C')
                    Log.d("LettersFragment", "Contains C")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.CButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('C')
                    Log.d("LettersFragment", "Does not contain C")
                }
                it.isEnabled = false
            }
        }
        binding.DButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("D")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.DButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('D')
                    Log.d("LettersFragment", "Contains D")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.DButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('D')
                    Log.d("LettersFragment", "Does not contain D")
                }
                it.isEnabled = false
            }
        }
        binding.EButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("E")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.EButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('E')
                    Log.d("LettersFragment", "Contains E")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.EButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('E')
                    Log.d("LettersFragment", "Does not contain E")
                }
                it.isEnabled = false
            }
        }
        binding.FButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("F")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.FButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('F')
                    Log.d("LettersFragment", "Contains F")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.FButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('F')
                    Log.d("LettersFragment", "Does not contain F")
                }
                it.isEnabled = false
            }
        }
        binding.GButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("G")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.GButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('G')
                    Log.d("LettersFragment", "Contains G")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.GButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('G')
                    Log.d("LettersFragment", "Does not contain G")
                }
                it.isEnabled = false
            }
        }
        binding.HButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("H")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.HButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('H')
                    Log.d("LettersFragment", "Contains H")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.HButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('H')
                    Log.d("LettersFragment", "Does not contain H")
                }
                it.isEnabled = false
            }
        }
        binding.IButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("I")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.IButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('I')
                    Log.d("LettersFragment", "Contains I")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.IButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('I')
                    Log.d("LettersFragment", "Does not contain I")
                }
                it.isEnabled = false
            }
        }
        binding.JButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("J")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.JButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('J')
                    Log.d("LettersFragment", "Contains J")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.JButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('J')
                    Log.d("LettersFragment", "Does not contain J")
                }
                it.isEnabled = false
            }
        }
        binding.KButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("K")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.KButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('K')
                    Log.d("LettersFragment", "Contains K")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.KButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('K')
                    Log.d("LettersFragment", "Does not contain K")
                }
                it.isEnabled = false
            }
        }
        binding.LButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("L")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.LButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('L')
                    Log.d("LettersFragment", "Contains L")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.LButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('L')
                    Log.d("LettersFragment", "Does not contain L")
                }
                it.isEnabled = false
            }
        }
        binding.MButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("M")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.MButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('M')
                    Log.d("LettersFragment", "Contains M")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.MButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('M')
                    Log.d("LettersFragment", "Does not contain M")
                }
                it.isEnabled = false
            }
        }
        binding.NButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("N")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.NButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('N')
                    Log.d("LettersFragment", "Contains N")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.NButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('N')
                    Log.d("LettersFragment", "Does not contain N")
                }
                it.isEnabled = false
            }
        }
        binding.OButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("O")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.OButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('O')
                    Log.d("LettersFragment", "Contains O")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.OButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('O')
                    Log.d("LettersFragment", "Does not contain O")
                }
                it.isEnabled = false
            }
        }
        binding.PButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("P")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.PButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('P')
                    Log.d("LettersFragment", "Contains P")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.PButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('P')
                    Log.d("LettersFragment", "Does not contain P")
                }
                it.isEnabled = false
            }
        }
        binding.QButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("Q")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.QButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('Q')
                    Log.d("LettersFragment", "Contains Q")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.QButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('Q')
                    Log.d("LettersFragment", "Does not contain Q")
                }
                it.isEnabled = false
            }
        }
        binding.RButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("R")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.RButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('R')
                    Log.d("LettersFragment", "Contains R")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.RButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('R')
                    Log.d("LettersFragment", "Does not contain R")
                }
                it.isEnabled = false
            }
        }
        binding.SButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("S")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.SButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('S')
                    Log.d("LettersFragment", "Contains S")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.SButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('S')
                    Log.d("LettersFragment", "Does not contain S")
                }
                it.isEnabled = false
            }
        }
        binding.TButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("T")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.TButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('T')
                    Log.d("LettersFragment", "Contains T")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.TButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('T')
                    Log.d("LettersFragment", "Does not contain T")
                }
                it.isEnabled = false
            }
        }
        binding.UButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("U")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.UButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('U')
                    Log.d("LettersFragment", "Contains U")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.UButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('U')
                    Log.d("LettersFragment", "Does not contain U")
                }
                it.isEnabled = false
            }
        }
        binding.VButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("V")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.VButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('V')
                    Log.d("LettersFragment", "Contains V")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.VButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('V')
                    Log.d("LettersFragment", "Does not contain V")
                }
                it.isEnabled = false
            }
        }
        binding.WButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("W")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.WButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('W')
                    Log.d("LettersFragment", "Contains W")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.WButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('W')
                    Log.d("LettersFragment", "Does not contain W")
                }
                it.isEnabled = false
            }
        }
        binding.XButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("X")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.XButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('X')
                    Log.d("LettersFragment", "Contains X")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.XButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('X')
                    Log.d("LettersFragment", "Does not contain X")
                }
                it.isEnabled = false
            }
        }
        binding.YButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("Y")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.YButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('Y')
                    Log.d("LettersFragment", "Contains Y")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.YButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('Y')
                    Log.d("LettersFragment", "Does not contain Y")
                }
                it.isEnabled = false
            }
        }
        binding.ZButton.setOnClickListener {
            viewModel.word.value?.let { word ->
                if (word.contains("Z")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.ZButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('Z')
                    Log.d("LettersFragment", "Contains Z")
                }
                else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.ZButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('Z')
                    Log.d("LettersFragment", "Does not contain Z")
                }
                it.isEnabled = false
            }
        }
        return binding.root
    }

}