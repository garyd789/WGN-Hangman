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
import androidx.lifecycle.Observer

//class LettersFragment : Fragment() {
//
//    private lateinit var binding: LettersBinding
//    private lateinit var viewModel: SharedViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
//    ): View {
//        binding = LettersBinding.inflate(inflater, container, false)
//        setupButtonListeners()
//        observeGameState()
//        return binding.root
//    }
//
//    private fun setupButtonListeners() {
//        val buttons = listOf(
//            'A' to binding.AButton,
//            'B' to binding.BButton,
//            'C' to binding.CButton,
//            'D' to binding.DButton,
//            'E' to binding.EButton,
//            'F' to binding.FButton,
//            'G' to binding.GButton,
//            'H' to binding.HButton,
//            'I' to binding.IButton,
//            'J' to binding.JButton,
//            'K' to binding.KButton,
//            'L' to binding.LButton,
//            'M' to binding.MButton,
//            'N' to binding.NButton,
//            'O' to binding.OButton,
//            'P' to binding.PButton,
//            'Q' to binding.QButton,
//            'R' to binding.RButton,
//            'S' to binding.SButton,
//            'T' to binding.TButton,
//            'U' to binding.UButton,
//            'V' to binding.VButton,
//            'W' to binding.WButton,
//            'X' to binding.XButton,
//            'Y' to binding.YButton,
//            'Z' to binding.ZButton
//        )
//
//        buttons.forEach { (letter, button) ->
//            button.setOnClickListener {
//                handleButtonClick(letter, button)
//            }
//        }
//    }
//
//    private fun handleButtonClick(letter: Char, button: View) {
//        viewModel.word.value?.let { word ->
//            val colorRes = if (word.contains(letter.toString())) {
//                viewModel.guessRight(letter)
//                R.color.correct_guess
//            } else {
//                viewModel.guessWrong(letter)
//                R.color.incorrect_guess
//            }
//            val color = ContextCompat.getColor(requireContext(), colorRes)
//            ViewCompat.setBackgroundTintList(button, ColorStateList.valueOf(color))
//            button.isEnabled = false
//        }
//    }
//
//    private fun observeGameState() {
//        viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
//            if (gamewin) resetAllButtons()
//        })
//
//        viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
//            if (gameover) resetAllButtons()
//        })
//    }
//
//    private fun resetAllButtons() {
//        val defaultColor = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.button_color))
//        listOf(
//            binding.AButton,
//            binding.BButton,
//            binding.CButton,
//            binding.DButton,
//            binding.EButton,
//            binding.FButton,
//            binding.GButton,
//            binding.HButton,
//            binding.IButton,
//            binding.JButton,
//            binding.KButton,
//            binding.LButton,
//            binding.MButton,
//            binding.NButton,
//            binding.OButton,
//            binding.PButton,
//            binding.QButton,
//            binding.RButton,
//            binding.SButton,
//            binding.TButton,
//            binding.UButton,
//            binding.VButton,
//            binding.WButton,
//            binding.XButton,
//            binding.YButton,
//            binding.ZButton
//        ).forEach { button ->
//            button.isEnabled = true
//            ViewCompat.setBackgroundTintList(button, defaultColor)
//        }
//    }
//}
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
        binding = LettersBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        //set listeners on each letter
        binding.AButton.setOnClickListener  {
            viewModel.word.value?.let { word ->
                if (word.contains("A")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.AButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('A')
                    Log.d("LettersFragment", "Contains A")

                } else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.AButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('A')
                    Log.d("LettersFragment", "Does not contain A")
                }
                it.isEnabled = false
            }
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.AButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.AButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
        }

        binding.BButton.setOnClickListener  {
            viewModel.word.value?.let { word ->
                if (word.contains("B")) {
                    val color = ContextCompat.getColor(requireContext(), R.color.correct_guess)
                    ViewCompat.setBackgroundTintList(binding.BButton, ColorStateList.valueOf(color))
                    viewModel.guessRight('B')
                    Log.d("LettersFragment", "Contains B")

                } else {
                    val color = ContextCompat.getColor(requireContext(), R.color.incorrect_guess)
                    ViewCompat.setBackgroundTintList(binding.BButton, ColorStateList.valueOf(color))
                    viewModel.guessWrong('B')
                    Log.d("LettersFragment", "Does not contain B")
                }
                it.isEnabled = false
            }
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.BButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.BButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.CButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.CButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.DButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.DButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.EButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.EButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.FButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.FButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.GButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.GButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.HButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.HButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.IButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.IButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.JButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.JButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.KButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.KButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.LButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.LButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.MButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.MButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.NButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.NButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.OButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.OButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.PButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.PButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.QButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.QButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.RButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.RButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.SButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.SButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.TButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.TButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.UButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.UButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.VButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.VButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.WButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.WButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.XButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.XButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.YButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.YButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
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
            viewModel.gamewin.observe(viewLifecycleOwner, Observer { gamewin ->
                if (gamewin) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.ZButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gamewin")
                    viewModel.gameWin(false)
                }
            })

            viewModel.gameover.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    //reset buttons here
                    it.isEnabled = true
                    val color = ContextCompat.getColor(requireContext(), R.color.button_color)
                    ViewCompat.setBackgroundTintList(binding.ZButton, ColorStateList.valueOf(color))
                    Log.d("LettersFragment", "Reset Button, gameover")
                    viewModel.gameOver(false)
                }
            })
        }
        return binding.root
    }

}